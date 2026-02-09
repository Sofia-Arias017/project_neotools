-- Insertar estados de herramienta
INSERT INTO estado_herramienta (id, nombre) VALUES (1, 'Disponible');
INSERT INTO estado_herramienta (id, nombre) VALUES (2, 'Mantenimiento');
INSERT INTO estado_herramienta (id, nombre) VALUES (3, 'Dañada');
INSERT INTO estado_herramienta (id, nombre) VALUES (4, 'Reservada');

-- Insertarestados de reserva
INSERT INTO estado_reserva (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estado_reserva (id, nombre) VALUES (2, 'Activa');
INSERT INTO estado_reserva (id, nombre) VALUES (3, 'Completada');
INSERT INTO estado_reserva (id, nombre) VALUES (4, 'Cancelada');

-- Insertar estados de pago
INSERT INTO estado_pago (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estado_pago (id, nombre) VALUES (2, 'Completado');
INSERT INTO estado_pago (id, nombre) VALUES (3, 'Rechazado');
INSERT INTO estado_pago (id, nombre) VALUES (4, 'Reembolsado');

-- Insertar roles
INSERT INTO rol (id, nombre) VALUES (1, 'Admin');
INSERT INTO rol (id, nombre) VALUES (2, 'Cliente');
INSERT INTO rol (id, nombre) VALUES (3, 'Proveedor');

-- Insertar usuarios
INSERT INTO usuario (id, username, email, password, estado, created_at, last_login) 
VALUES (1, 'admin', 'admin@ferreteria.com', 'hash_password_123', 'activo', NOW(), NULL);
INSERT INTO usuario (id, username, email, password, estado, created_at, last_login) 
VALUES (2, 'juan_perez', 'juan@example.com', 'hash_password_456', 'activo', NOW(), NULL);
INSERT INTO usuario (id, username, email, password, estado, created_at, last_login) 
VALUES (3, 'maria_garcia', 'maria@example.com', 'hash_password_789', 'activo', NOW(), NULL);
INSERT INTO usuario (id, username, email, password, estado, created_at, last_login) 
VALUES (4, 'proveedor_tools', 'proveedor@tools.com', 'hash_password_101', 'activo', NOW(), NULL);

-- Insertar clientes
INSERT INTO cliente (id, documento, telefono, usuario_id) VALUES (1, '12345678', '5551234567', 2);
INSERT INTO cliente (id, documento, telefono, usuario_id) VALUES (2, '87654321', '5559876543', 3);

-- Insertar categorías
INSERT INTO categoria (id, nombre, descripcion) 
VALUES (1, 'Herramientas Manuales', 'Herramientas utilizadas manualmente');
INSERT INTO categoria (id, nombre, descripcion) 
VALUES (2, 'Herramientas Eléctricas', 'Herramientas alimentadas por electricidad');
INSERT INTO categoria (id, nombre, descripcion) 
VALUES (3, 'Medición', 'Herramientas de medición y verificación');

-- Insertar proveedores
INSERT INTO proveedor (id, empresa, telefono, estado, usuario_id) 
VALUES (1, 'Herramientas Premium S.A.', '5551111111', 'activo', 4);
INSERT INTO proveedor (id, empresa, telefono, estado, usuario_id) 
VALUES (2, 'Distribuidor Industrial', '5552222222', 'activo', NULL);

-- Insertar herramientas
INSERT INTO herramienta (id, codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES (1, 'H001', 'Taladro Percutor', 'DeWalt', 'D25143K', 'Taladro de impacto profesional', NOW(), 2500.00, 'Buena', 1, 2, 1);
INSERT INTO herramienta (id, codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES (2, 'H002', 'Martillo Hidráulico', 'Bosch', 'GBH 5-40D', 'Martillo neumático robusto', NOW(), 3500.00, 'Excelente', 1, 2, 1);
INSERT INTO herramienta (id, codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES (3, 'H003', 'Cinta Métrica', 'Stanley', 'STHT30325', 'Cinta métrica de 8 metros', NOW(), 150.00, 'Buena', 2, 3, 1);
INSERT INTO herramienta (id, codigo_inventario, nombre, marca, modelo, descripcion, fecha_adquisicion, valor_reposicion, condicion_actual, proveedor_id, categoria_id, estado_herramienta_id) 
VALUES (4, 'H004', 'Destornillador Eléctrico', 'Makita', 'DF001D', 'Destornillador eléctrico inalámbrico', NOW(), 1800.00, 'Buena', 1, 2, 1);

-- Insertar reservas
INSERT INTO reserva (id, cliente_id, fecha_inicio, fecha_fin_estimada, fecha_creacion, estado_reserva_id, observaciones) 
VALUES (1, 1, NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), NOW(), 1, 'Reserva para proyecto de renovación');
INSERT INTO reserva (id, cliente_id, fecha_inicio, fecha_fin_estimada, fecha_creacion, estado_reserva_id, observaciones) 
VALUES (2, 2, DATE_ADD(NOW(), INTERVAL 1 DAY), DATE_ADD(NOW(), INTERVAL 8 DAY), NOW(), 1, 'Reparaciones en casa');

-- Insertar pagos
INSERT INTO pago (id, reserva_id, concepto, monto, fecha_pago, estado_pago_id) 
VALUES (1, 1, 'Alquiler de herramientas', 250.00, NOW(), 1);
INSERT INTO pago (id, reserva_id, concepto, monto, fecha_pago, estado_pago_id) 
VALUES (2, 2, 'Alquiler de herramientas', 180.00, NOW(), 1);

-- Insertar facturas
INSERT INTO factura (id, numero_factura, fecha_emision, total, pago_id) 
VALUES (1, 'FAC-2026-001', NOW(), 250.00, 1);
INSERT INTO factura (id, numero_factura, fecha_emision, total, pago_id) 
VALUES (2, 'FAC-2026-002', NOW(), 180.00, 2);
