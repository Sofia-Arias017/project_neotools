-- Script para cargar datos iniciales en la BD
-- Datos minimalistas compatibles con las entidades Hibernate generadas

-- ROLES
INSERT INTO rol (nombre) VALUES ('ADMIN');
INSERT INTO rol (nombre) VALUES ('USER');
INSERT INTO rol (nombre) VALUES ('GUEST');

-- USUARIOS
INSERT INTO usuario (username, email, password, estado) VALUES ('admin', 'admin@ferreteria.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');
INSERT INTO usuario (username, email, password, estado) VALUES ('john_doe', 'john@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');
INSERT INTO usuario (username, email, password, estado) VALUES ('jane_smith', 'jane@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');
INSERT INTO usuario (username, email, password, estado) VALUES ('carlos_lopez', 'carlos@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');
INSERT INTO usuario (username, email, password, estado) VALUES ('maria_garcia', 'maria@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'INACTIVO');

-- CLIENT
INSERT INTO cliente (documento, telefono, usuario_id) VALUES ('123456789', '1234567890', 1);
INSERT INTO cliente (documento, telefono, usuario_id) VALUES ('987654321', '0987654321', 2);
INSERT INTO cliente (documento, telefono, usuario_id) VALUES ('555555555', '5555555555', 3);

-- CATEGORIAS
INSERT INTO categoria (nombre, descripcion) VALUES ('Herramientas Manuales', 'Martillos, destornilladores, llaves, etc.');
INSERT INTO categoria (nombre, descripcion) VALUES ('Herramientas Eléctricas', 'Taladros, sierras, amoladores, etc.');
INSERT INTO categoria (nombre, descripcion) VALUES ('Equipos de Seguridad', 'Cascos, guantes, arneses, etc.');
INSERT INTO categoria (nombre, descripcion) VALUES ('Tuberías y Accesorios', 'PVC, cobre, hierro galvanizado, etc.');
INSERT INTO categoria (nombre, descripcion) VALUES ('Materiales de Construcción', 'Cemento, ladrillos, hierro, etc.');

INSERT INTO proveedor (empresa, telefono, estado, usuario_id) VALUES ('Ferretería Central SA', '5551111', 'ACTIVO', 1);
INSERT INTO proveedor (empresa, telefono, estado, usuario_id) VALUES ('Distribuidora Industrial', '5552222', 'ACTIVO', 2);
INSERT INTO proveedor (empresa, telefono, estado, usuario_id) VALUES ('Importadora de Herramientas', '5553333', 'ACTIVO', 3);
INSERT INTO proveedor (empresa, telefono, estado, usuario_id) VALUES ('Materiales Premium SRL', '5554444', 'ACTIVO', 4);

-- ESTADO HERRAMIENTA
INSERT INTO estado_herramienta (nombre) VALUES ('DISPONIBLE');
INSERT INTO estado_herramienta (nombre) VALUES ('RESERVADO');
INSERT INTO estado_herramienta (nombre) VALUES ('EN MANTENIMIENTO');
INSERT INTO estado_herramienta (nombre) VALUES ('DAÑADO');
INSERT INTO estado_herramienta (nombre) VALUES ('DESCARTADO');

-- HERRAMIENTAS
INSERT INTO herramienta (codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES ('H001', 'Martillo de Garra', 'Stanley', 'FuBar', 'Martillo 16oz', '2025-01-15', 25.50, 'BUENO', 1, 1, 1);

INSERT INTO herramienta (codigo_inventario,nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES ('H002', 'Taladro Percusor', 'DeWalt', 'DCD791D2', 'Taladro 12V', '2025-02-01', 89.99, 'BUENO', 2, 2, 1);

INSERT INTO herramienta (codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES ('H003', 'Escalera Aluminio', 'Surco', 'EMP-6', 'Escalera 6 peldaños', '2025-01-10', 150.00, 'EXCELENTE', 3, 1, 1);

INSERT INTO herramienta (codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES ('H004', 'Casco Seguridad', 'Truper', 'CSG-001', 'Casco amarillo', '2025-02-05', 12.75, 'BUENO', 4, 3, 1);

-- ESTADO RESERVA
INSERT INTO estado_reserva (nombre) VALUES ('PENDIENTE');
INSERT INTO estado_reserva (nombre) VALUES ('CONFIRMADA');
INSERT INTO estado_reserva (nombre) VALUES ('EN_PROGRESO');
INSERT INTO estado_reserva (nombre) VALUES ('COMPLETADA');
INSERT INTO estado_reserva (nombre) VALUES ('CANCELADA');

-- RESERVAS (minimal)
INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin_estimada, fecha_creacion, estado_reserva_id, observaciones) 
VALUES (1, 1, '2026-02-09', '2026-02-16', NOW(), 1, 'Primer herramienta');

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin_estimada, fecha_creacion, estado_reserva_id, observaciones) 
VALUES (2, 2, '2026-02-10', '2026-02-17', NOW(), 1, 'Segunda herramienta');

-- ESTADO PAGO
INSERT INTO estado_pago (nombre) VALUES ('PENDIENTE');
INSERT INTO estado_pago (nombre) VALUES ('REALIZADO');
INSERT INTO estado_pago (nombre) VALUES ('ANULADO');

-- PAGOS (minimal)
INSERT INTO pago (reserva_id, monto, fecha_pago, estado_pago_id) 
VALUES (1, 50.00, NOW(), 2);

INSERT INTO pago (reserva_id, monto, fecha_pago, estado_pago_id) 
VALUES (2, 89.99, NOW(), 2);

-- FACTURAS (minimal)
INSERT INTO factura (numero_factura, fecha_emision, total, pago_id) 
VALUES ('FAC-001', NOW(), 50.00, 1);

INSERT INTO factura (numero_factura, fecha_emision, total, pago_id) 
VALUES ('FAC-002', NOW(), 89.99, 2);
