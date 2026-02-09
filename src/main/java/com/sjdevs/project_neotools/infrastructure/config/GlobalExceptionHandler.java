package com.sjdevs.project_neotools.infrastructure.config;

import com.sjdevs.project_neotools.domain.exceptions.BusinessException;
import com.sjdevs.project_neotools.domain.exceptions.ResourceNotFoundException;
import com.sjdevs.project_neotools.domain.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Manejo cuando no encuentra un recurso (404)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", 404);
		body.put("error", "Recurso no encontrado");
		body.put("message", ex.getMessage());
		body.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	// Manejo cuando no está autorizado (401)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<?> handleUnauthorized(UnauthorizedException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", 401);
		body.put("error", "No autorizado");
		body.put("message", ex.getMessage());
		body.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
	}

	// Manejo de errores de lógica de negocio (400)
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", 400);
		body.put("error", "Error de negocio");
		body.put("message", ex.getMessage());
		body.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	// Manejo genérico para cualquier otra excepción (500)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", 500);
		body.put("error", "Error interno del servidor");
		body.put("message", ex.getMessage());
		body.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
