package com.sjdevs.project_neotools.infrastructure.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;

@Component
public class JwtUtil {

	// Con sesiones, no necesitamos generar tokens complicados.
	// Spring Security maneja la sesión automáticamente.
	// Este método no se usa, pero lo dejamos para compatibilidad.
	public String generateToken(UserDetails userDetails) {
		// No genera token real, solo retorna el username
		// La sesión es manejada automáticamente por Spring
		return userDetails.getUsername();
	}

	// Generar token con rol - no se usa con sesiones
	public String generateTokenWithRole(String username, String role) {
		return username;
	}

	// Obtener el usuario autenticado actual de la sesión
	public String extractUsername(HttpSession session) {
		// Obtener la autenticación del contexto de seguridad
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null && auth.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			return userDetails.getUsername();
		}
		
		return null;
	}

	// Validar si la sesión existe
	public Boolean validateToken(HttpSession session) {
		// Una sesión válida existe si:
		// 1. Hay una autenticación en el contexto
		// 2. La autenticación tiene un principal
		if (session == null) {
			return false;
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth != null && auth.isAuthenticated();
	}

	// Verificar si el usuario está autenticado
	public Boolean validateToken(String token, UserDetails userDetails) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth != null && auth.isAuthenticated() 
			&& auth.getName().equals(userDetails.getUsername());
	}
}
