package com.sjdevs.project_neotools.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	// Configura CORS (Cross-Origin Resource Sharing) para que aplicaciones front-end
	// desde otros dominios puedan acceder a los endpoints de esta API
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
			// Aplicar CORS a todos los endpoints (/api/**)
			.addMapping("/api/**")
			// Permitir solicitudes desde localhost:3000 (React por defecto)
			// y localhost:4200 (Angular por defecto)
			.allowedOrigins("http://localhost:3000", "http://localhost:4200")
			// Permitir métodos HTTP: GET, POST, PUT, DELETE, PATCH, OPTIONS
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			// Permitir headers Authorization (para enviar el JWT token)
			// y Content-Type (para indicar JSON)
			.allowedHeaders("Authorization", "Content-Type")
			// Permitir que el navegador acceda a los headers de respuesta Authorization
			.exposedHeaders("Authorization")
			// Permitir credenciales (cookies, autenticación HTTP, etc.)
			.allowCredentials(true)
			// Cachear la configuración CORS por 1 hora (3600 segundos)
			.maxAge(3600);
	}
}
