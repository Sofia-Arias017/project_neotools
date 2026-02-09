-- Script para cargar datos iniciales en la BD
-- Ejecutar después de que Hibernate cree las tablas (ddl-auto=update)

-- =====================================================
-- 1. ROLES (3 registros)
-- =====================================================
INSERT INTO rol (nombre) VALUES ('ADMIN');
INSERT INTO rol (nombre) VALUES ('USER');
INSERT INTO rol (nombre) VALUES ('GUEST');

-- =====================================================
-- 2. USUARIOS (5+ registros con password encriptado)
-- =====================================================
-- Password: "1234" encriptado con BCrypt
INSERT INTO usuario (username, email, password, estado) 
VALUES ('admin', 'admin@ferreteria.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');

INSERT INTO usuario (username, email, password, estado) 
VALUES ('john_doe', 'john@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');

INSERT INTO usuario (username, email, password, estado) 
VALUES ('jane_smith', 'jane@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');

INSERT INTO usuario (username, email, password, estado) 
VALUES ('carlos_lopez', 'carlos@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'ACTIVO');

INSERT INTO usuario (username, email, password, estado) 
VALUES ('maria_garcia', 'maria@example.com', '$2a$10$SlVZrJ3QR0/JNaL5ZvKxLexMfVkVi/YbFxWLqYqGFkEV5nKMF5dJ6', 'INACTIVO');

-- =====================================================
-- 3. CLIENTES (6+ registros)
-- =====================================================
INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('Juan', 'Pérez', 'juan.perez@email.com', '1234567890', 'Calle Principal 123');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('María', 'González', 'maria.gonzalez@email.com', '0987654321', 'Avenida Central 456');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('Carlos', 'Rodríguez', 'carlos.rodriguez@email.com', '5555555555', 'Pasaje Lateral 789');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('Ana', 'López', 'ana.lopez@email.com', '6666666666', 'Boulevard Este 321');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('Pedro', 'Martínez', 'pedro.martinez@email.com', '7777777777', 'Camino Oeste 654');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) 
VALUES ('Laura', 'Fernández', 'laura.fernandez@email.com', '8888888888', 'Plaza Sur 987');

-- =====================================================
-- 4. CATEGORÍAS (5 registros)
-- =====================================================
INSERT INTO categoria (nombre, descripcion) 
VALUES ('Herramientas Manuales', 'Herramientas de mano para trabajos generales');

INSERT INTO categoria (nombre, descripcion) 
VALUES ('Herramientas Eléctricas', 'Herramientas eléctricas y a batería');

INSERT INTO categoria (nombre, descripcion) 
VALUES ('Materiales de Construcción', 'Ladrillos, cemento, arena y materiales afines');

INSERT INTO categoria (nombre, descripcion) 
VALUES ('Equipos de Seguridad', 'Cascos, guantes, arneses y EPP');

INSERT INTO categoria (nombre, descripcion) 
VALUES ('Tuberías y Accesorios', 'Tuberías, codos, uniones y conexiones');

-- =====================================================
-- 5. PROVEEDORES (4+ registros)
-- =====================================================
INSERT INTO proveedor (nombre, contacto, email, telefono, direccion) 
VALUES ('Ferretería Wholesale Inc', 'Roberto Díaz', 'ventas@ferreteria-wholesale.com', '1111111111', 'Zona Industrial A, Lote 10');

INSERT INTO proveedor (nombre, contacto, email, telefono, direccion) 
VALUES ('Distribuidor Nacional SA', 'Ana María Flores', 'contacto@distribuidor-nacional.com', '2222222222', 'Km 5 Carretera Principal');

INSERT INTO proveedor (nombre, contacto, email, telefono, direccion) 
VALUES ('Comercial Herramientas Ltd', 'José Manuel Soto', 'info@comercial-herramientas.com', '3333333333', 'Centro Comercial Norte, Piso 3');

INSERT INTO proveedor (nombre, contacto, email, telefono, direccion) 
VALUES ('Importadora Global Tools', 'Lucia Mendoza', 'export@importadora-global.com', '4444444444', 'Puerto Marítimo, Terminal 2');

-- =====================================================
-- 6. ESTADO HERRAMIENTA (4 registros)
-- =====================================================
INSERT INTO estado_herramienta (nombre) VALUES ('DISPONIBLE');
INSERT INTO estado_herramienta (nombre) VALUES ('EN_MANTENIMIENTO');
INSERT INTO estado_herramienta (nombre) VALUES ('DAÑADA');
INSERT INTO estado_herramienta (nombre) VALUES ('RETIRADA');

-- =====================================================
-- 7. HERRAMIENTAS (12+ registros con diferentes estados)
-- =====================================================
INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Taladro de Impacto', 'Taladro DeWalt 20V con batería', 25.50, 1, 2, 1);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Juego de Llaves Inglesas', 'Set de 10 llaves diferentes tamaños', 8.00, 1, 1, 2);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Sierra Circular', 'Sierra eléctrica 7 1/4" marca Makita', 18.50, 1, 2, 3);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Martillo de Goma', 'Martillo de goma para trabajos de acabado', 3.50, 1, 1, 2);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Destornillador Manual Set', 'Set 8 destornilladores diferentes puntas', 6.00, 1, 1, 1);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Escalera Telescópica', 'Escalera aluminio telescópica 4.5m', 15.00, 1, 1, 4);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Casco de Seguridad', 'Casco amarillo ANSI Z89.1 certificado', 2.50, 1, 4, 2);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Guantes de Cuero', 'Guantes de trabajo cuero de primera', 4.00, 1, 4, 3);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Tubo PVC 3in', 'Tubo PVC para drenaje 3 pulgadas', 12.00, 1, 5, 1);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Codo PVC 90°', 'Codo PVC 3 pulgadas 90 grados', 0.75, 1, 5, 2);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Llave Inglesa Ajustable', 'Llave inglesa ajustable 12 pulgadas', 5.50, 2, 1, 3);

INSERT INTO herramienta (nombre, descripcion, precio_diario, estado_id, categoria_id, proveedor_id) 
VALUES ('Compresor de Aire', 'Compresor portátil 2.5 HP 60L', 35.00, 1, 2, 4);

-- =====================================================
-- 8. ESTADO RESERVA (4 registros)
-- =====================================================
INSERT INTO estado_reserva (nombre) VALUES ('PENDIENTE');
INSERT INTO estado_reserva (nombre) VALUES ('CONFIRMADA');
INSERT INTO estado_reserva (nombre) VALUES ('EN_PROGRESO');
INSERT INTO estado_reserva (nombre) VALUES ('COMPLETADA');

-- =====================================================
-- 9. RESERVAS (8+ registros)
-- =====================================================
INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (1, 1, '2026-02-10', '2026-02-12', 2, 2);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (2, 3, '2026-02-11', '2026-02-15', 2, 2);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (3, 5, '2026-02-09', '2026-02-10', 4, 3);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (4, 7, '2026-02-08', '2026-02-10', 3, 2);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (5, 2, '2026-02-12', '2026-02-14', 1, 3);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (6, 4, '2026-02-13', '2026-02-16', 2, 2);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (1, 6, '2026-02-14', '2026-02-17', 2, 3);

INSERT INTO reserva (cliente_id, herramienta_id, fecha_inicio, fecha_fin, estado_id, usuario_id) 
VALUES (2, 8, '2026-02-15', '2026-02-18', 1, 2);

-- =====================================================
-- 10. ESTADO PAGO (4 registros)
-- =====================================================
INSERT INTO estado_pago (nombre) VALUES ('PENDIENTE');
INSERT INTO estado_pago (nombre) VALUES ('PROCESADO');
INSERT INTO estado_pago (nombre) VALUES ('COMPLETADO');
INSERT INTO estado_pago (nombre) VALUES ('RECHAZADO');

-- =====================================================
-- 11. PAGOS (8+ registros)
-- =====================================================
INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (1, 51.00, 'TARJETA_CREDITO', 3, '2026-02-10');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (2, 74.00, 'TRANSFERENCIA', 3, '2026-02-11');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (3, 12.00, 'EFECTIVO', 3, '2026-02-09');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (4, 5.00, 'TARJETA_CREDITO', 2, '2026-02-08');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (5, 16.00, 'TARJETA_DEBITO', 1, NULL);

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (6, 10.50, 'EFECTIVO', 3, '2026-02-13');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (7, 45.00, 'TRANSFERENCIA', 3, '2026-02-14');

INSERT INTO pago (reserva_id, monto, metodo, estado_id, fecha_pago) 
VALUES (8, 8.00, 'TARJETA_CREDITO', 2, '2026-02-15');

-- =====================================================
-- 12. FACTURAS (6+ registros)
-- =====================================================
INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (1, 'FAC-2026-0001', '2026-02-10', 51.00, 1);

INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (2, 'FAC-2026-0002', '2026-02-11', 74.00, 2);

INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (3, 'FAC-2026-0003', '2026-02-09', 12.00, 3);

INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (4, 'FAC-2026-0004', '2026-02-08', 5.00, 4);

INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (6, 'FAC-2026-0005', '2026-02-13', 10.50, 6);

INSERT INTO factura (pago_id, numero_factura, fecha_emision, monto_total, cliente_id) 
VALUES (7, 'FAC-2026-0006', '2026-02-14', 45.00, 1);
