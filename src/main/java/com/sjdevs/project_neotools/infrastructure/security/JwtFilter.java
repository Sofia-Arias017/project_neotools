package com.sjdevs.project_neotools.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * CON AUTENTICACIÓN POR SESIONES, ESTE FILTRO NO SE NECESITA.
 * 
 * Spring Security maneja todo automáticamente:
 * - Login: Crea una sesión en el servidor
 * - La sesión se guarda en una cookie JSESSIONID
 * - El navegador envía la cookie automáticamente
 * - Spring valida la sesión sin necesidad de filtros especiales
 * 
 * Este archivo se dejó vacío para no romper las referencias.
 */
public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// No hacer nada - Spring Security maneja sesiones automáticamente
		filterChain.doFilter(request, response);
	}
}
