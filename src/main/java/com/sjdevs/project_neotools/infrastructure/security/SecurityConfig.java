package com.sjdevs.project_neotools.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// Encriptar las contraseñas con BCrypt
	// Cada vez que un usuario se registra, su contraseña se encripta con esto
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// AuthenticationManager: Usado en AuthController para verificar username/password
	// Cuando el usuario hace login, esto compara la contraseña ingresada
	// con la contraseña encriptada guardada en la BD
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	// Configurar las reglas de seguridad
	// Con sesiones, Spring Security:
	// - Crea una sesión cuando haces login
	// - Guarda la sesión en una cookie JSESSIONID
	// - Valida la cookie automáticamente en cada request
	// - No necesitamos enviar manualmente tokens en headers
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			// Configurar autorización: qué endpoints necesitan autenticación
			.authorizeHttpRequests(authz -> authz
				// Permitir login y registro sin autenticación
				.requestMatchers("/api/auth/login").permitAll()
				.requestMatchers("/api/auth/register").permitAll()
				
				// Permitir validar token (para que el cliente sepa si está autenticado)
				.requestMatchers("/api/auth/validate").permitAll()
				
				// Permitir documentación de API (Swagger)
				.requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
				
				// TODOS los demás endpoints /api/** necesitan autenticación
				// Si no tienes sesión válida, Spring rechazará la solicitud
				.anyRequest().authenticated()
			)
			
			// Habilitar sesiones (por defecto en Spring)
			// El navegador obtiene una cookie JSESSIONID que identifica la sesión
			.sessionManagement(session -> {
				// IF_REQUIRED: Crear sesión solo si es necesaria (para obtener autenticación)
				// session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
				// Dejamos la configuración por defecto de Spring
			})
			
			// Desactivar CSRF para APIs REST
			// (CSRF es para proteger formularios HTML, no necesario para APIs JSON)
			.csrf(csrf -> csrf.disable())

			// Deshabilitar los mecanismos de login automáticos de Spring Security
			.formLogin(form -> form.disable())
			.httpBasic(httpBasic -> httpBasic.disable())

			// Manejar respuestas de autenticación con JSON en lugar de redirecciones HTML
			.exceptionHandling(ex -> ex.authenticationEntryPoint((request, response, authException) -> {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().write("{\"error\":\"Unauthorized\"}");
			}))

			// Configurar qué pasa cuando logout
			.logout(logout -> logout
				.logoutUrl("/api/auth/logout")
				.permitAll()
			);

		return http.build();
	}
}
