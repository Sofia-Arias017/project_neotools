package com.sjdevs.project_neotools.infrastructure.controller;

import com.sjdevs.project_neotools.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	// LOGIN: Recibir usuario y contraseña, crear sesión
	// Con sesiones, el cliente obtiene una cookie JSESSIONID automáticamente
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO loginRequest, HttpSession session) {
		try {
			// 1. Intentar autenticar: compara el password con el de la BD
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					loginRequest.getUsername(),
					loginRequest.getPassword()
				)
			);

			// 2. Si llegamos aquí, la autenticación fue exitosa
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// 3. La sesión ya está creada por Spring automáticamente
			// El cliente recibe una cookie JSESSIONID que lo identifica

			// 4. Devolver respuesta al cliente
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Login exitoso");
			response.put("username", userDetails.getUsername());
			response.put("sessionId", session.getId()); // ID de la sesión del servidor

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// Si falla la autenticación (usuario o contraseña incorrecto)
			Map<String, String> error = new HashMap<>();
			error.put("error", "Usuario o contraseña incorrecto");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
	}

	// REGISTER: Registrar un nuevo usuario
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDTO registerRequest) {
		try {
			// TODO: Aquí deberías guardar el usuario en la BD
			// Por ahora solo devolvemos un mensaje

			Map<String, String> response = new HashMap<>();
			response.put("message", "Usuario registrado exitosamente");
			response.put("username", registerRequest.getUsername());

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Error al registrar usuario");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
	}

	// VALIDATE: Chequear si el cliente tiene una sesión válida
	// Con sesiones, es más simple: si llegaste aquí, la sesión es válida
	@PostMapping("/validate")
	public ResponseEntity<?> validateToken() {
		// Si Spring nos dejó entrar aquí, es porque está autenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null && auth.isAuthenticated()) {
			String username = auth.getName(); // Obtener el username de la autenticación
			Map<String, Object> response = new HashMap<>();
			response.put("valid", true);
			response.put("username", username);
			response.put("message", "Sesión válida");
			return ResponseEntity.ok(response);
		} else {
			// Sin sesión válida
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
				Map.of("valid", false, "message", "No hay sesión válida")
			);
		}
	}

	// LOGOUT: Cerrar sesión
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		try {
			// 1. Limpiar la autenticación del contexto
			SecurityContextHolder.clearContext();

			// 2. Invalidar la sesión
			session.invalidate();

			// 3. Retornar mensaje de éxito
			Map<String, String> response = new HashMap<>();
			response.put("message", "Logout exitoso");

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Error al hacer logout");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
		}
	}
}
