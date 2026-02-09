# Proyecto Ferretería - Spring Boot Backend

Aplicación de gestión de alquiler de herramientas desarrollada con Spring Boot 4.0.2, Spring Data JPA y MySQL 8.0.

## 📋 Características

✅ **Autenticación por Sesiones**
- Login/Logout con sesiones HTTP
- Contraseñas encriptadas con BCrypt
- Endpoints protegidos con Spring Security

✅ **12 Entidades Principales**
1. **Usuario** - Gestión de usuarios del sistema
2. **Cliente** - Información de clientes que alquilan herramientas
3. **Herramienta** - Catálogo de herramientas disponibles
4. **Categoría** - Clasificación de herramientas
5. **Proveedor** - Proveedores de herramientas
6. **Reserva** - Reservas de herramientas
7. **Pago** - Pagos por reservas
8. **Factura** - Facturas de transacciones
9. **Rol** - Roles de usuario (ADMIN, USER, GUEST)
10. **EstadoHerramienta** - Estados de herramientas (DISPONIBLE, etc)
11. **EstadoReserva** - Estados de reservas (PENDIENTE, CONFIRMADA, etc)
12. **EstadoPago** - Estados de pagos (PENDIENTE, COMPLETADO, etc)

✅ **API REST**
- 8 Controllers (Auth, Tools, Users, Reservations, Payments, Invoices, Clients, Categories)
- CRUD completo para cada entidad
- Manejo centralizado de excepciones
- CORS configurado para React/Angular

✅ **BD Inicial**
- 50+ registros en total
- Datos de ejemplo para testing
- Script SQL en `src/main/resources/database/initial-data.sql`

## 🚀 Inicio Rápido

### Requisitos
- JDK 21 (OpenJDK o Temurin)
- MySQL 8.0 Docker o instalado localmente
- Maven (incluido en el proyecto con mvnw)

### 1. Iniciar MySQL (Docker)
```bash
docker run -d \
  --name mysql_ferreteria \
  -e MYSQL_ROOT_PASSWORD=1234 \
  -e MYSQL_DATABASE=proyecto_ferreteria \
  -p 3306:3306 \
  mysql:8.0
```

### 2. Configurar JAVA_HOME (Windows - PowerShell)
```powershell
$env:JAVA_HOME = "C:\Users\river\AppData\Local\Programs\Eclipse Adoptium\jdk-21.0.9.10-hotspot"
$env:PATH = "$env:JAVA_HOME\bin;" + $env:PATH
```

### 3. Ejecutar la Aplicación
```bash
cd c:\Users\river\Downloads\project_neotools
.\mvnw spring-boot:run
```

La app estará disponible en: **http://localhost:8080**

### 4. Cargar Datos Iniciales (Opcional)
Ejecuta el script SQL manualmente:
```sql
mysql -u root -p1234 proyecto_ferreteria < src/main/resources/database/initial-data.sql
```

## 📡 Endpoints Principales

### Autenticación
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/auth/login` | Login (username/password) |
| POST | `/api/auth/register` | Registrar nuevo usuario |
| POST | `/api/auth/validate` | Validar sesión actual |
| POST | `/api/auth/logout` | Cerrar sesión |

**Ejemplo Login:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"1234"}'
```

**Respuesta exitosa:**
```json
{
  "message": "Login exitoso",
  "username": "admin",
  "sessionId": "ABCD1234..."
}
```

### Herramientas
```bash
GET    /api/tools          - Listar todas las herramientas
GET    /api/tools/{id}     - Obtener detalles de herramienta
POST   /api/tools          - Crear nueva herramienta
PUT    /api/tools/{id}     - Actualizar herramienta
DELETE /api/tools/{id}     - Eliminar herramienta
```

### Usuarios
```bash
GET    /api/users          - Listar usuarios
GET    /api/users/{id}     - Obtener usuario
POST   /api/users          - Crear usuario
```

### Reservas
```bash
GET    /api/reservations   - Listar reservas
POST   /api/reservations   - Crear reserva
GET    /api/reservations/{id}
```

### Pagos
```bash
GET    /api/payments       - Listar pagos
POST   /api/payments       - Registrar pago
```

**Nota:** Todos los endpoints excepto `/api/auth/**` requieren sesión válida.

## 🔐 Credenciales por Defecto

Se incluyen 5 usuarios de ejemplo en el script SQL:

| Username | Password | Rol |
|----------|----------|-----|
| admin | 1234 | ADMIN |
| john_doe | 1234 | USER |
| jane_smith | 1234 | USER |
| carlos_lopez | 1234 | USER |
| maria_garcia | 1234 | GUEST |

## 📁 Estructura del Proyecto

```
src/main/java/com/sjdevs/project_neotools/
├── ProjectNeotoolsApplication.java          # Main
├── application/                              # Lógica de aplicación
│   ├── dto/                                 # DTOs para transferencia
│   ├── mapper/                              # Mapeo Entity ↔ DTO
│   └── usecase/                             # Casos de uso (vacíos - services los implementan)
├── domain/                                   # Modelo de dominio
│   ├── exceptions/                          # Excepciones custom
│   ├── model/                               # Entidades del dominio
│   └── ports/                               # Interfaces (vacías - funcionales en services)
└── infrastructure/                           # Implementación técnica
    ├── config/                              # Configuración (Security, CORS, etc)
    ├── controller/                          # REST Controllers
    ├── persistence/                         # BD
    │   ├── adapter/
    │   ├── entity/                          # JPA Entities
    │   └── repository/                      # JPA Repositories
    └── security/                            # Autenticación/Autorización

src/main/resources/
├── application.properties                   # Configuración Spring
└── database/
    └── initial-data.sql                     # Datos iniciales (50+ registros)
```

## ⚙️ Configuración

### application.properties
```properties
# Base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/proyecto_ferreteria
spring.datasource.username=root
spring.datasource.password=1234

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update  # Auto-crea tablas

# Sesiones
spring.session.store-type=jdbc  # Guarda sesiones en BD (opcional)
```

## 🔧 Desarrollo

### Compilar
```bash
.\mvnw clean compile
```

### Tests
```bash
.\mvnw test
```

### Empaquetar JAR
```bash
.\mvnw clean package -DskipTests
java -jar target/project_neotools-*.jar
```

## 🐛 Troubleshooting

### Error: "No compiler provided" 
**Causa:** Java 8 en lugar de JDK 21
```powershell
$env:JAVA_HOME = "ruta completa a JDK 21"
```

### Error: "Communications link failure"
**Causa:** MySQL no está corriendo
```bash
docker ps  # Verificar contenedor
docker logs mysql_ferreteria  # Ver logs
```

### Error: "Access denied" en login
**Causa:** Tabla de usuarios vacía o contraseña incorrecta
```bash
# Ejecutar script SQL con datos iniciales
```

## 📚 Tecnologías

- **Framework:** Spring Boot 4.0.2
- **Security:** Spring Security 6.x + Sesiones HTTP
- **BD:** MySQL 8.0 + Hibernate 7.2
- **ORM:** Spring Data JPA
- **Build:** Maven 3.x
- **Java:** JDK 21 (OpenJDK Temurin)

## 📝 Notas de Desarrollo

- ✅ Autenticación por sesiones (sin JWT)
- ✅ 12 entidades completas con CRUD
- ✅ Manejo centralizado de excepciones
- ✅ CORS para frontends React/Angular
- ⚠️ `usecase/` y `ports/` vacíos (servicios implementan la lógica)
- ⚠️ `register()` en AuthController necesita implementación para guardar usuarios

## 🤝 Próximos Pasos

1. Eliminar archivos vacíos (16 clases UseCase/Port)
2. Implementar validaciones @Email, @NotNull en DTOs
3. Agregar endpoints de registro que guarden en BD
4. Tests unitarios para servicios
5. Documentación Swagger/OpenAPI
6. Deploy en Azure/AWS

## ✅ Checklist Requisitos

- [x] Spring Boot backend completo
- [x] Autenticación (sesiones HTTP)
- [x] 12 entidades CRUD
- [x] MySQL 8.0
- [x] 50+ registros iniciales
- [x] Manejo de excepciones
- [x] CORS configurado
- [ ] GitHub privado (pendiente)
- [ ] Tests automatizados
- [ ] Documentación API

---

**Desarrollado:** 2026  
**Versión:** 0.0.1-SNAPSHOT  
**License:** MIT
