# Course Manager API

API REST para la gestión de cursos y estudiantes universitarios construida con Spring Boot.

## 📋 Descripción

Sistema de gestión universitaria que permite:
- Crear y gestionar estudiantes
- Crear y gestionar cursos
- Inscribir estudiantes en cursos
- Consultar los estudiantes inscritos en cada curso

## 🚀 Tecnologías

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **H2 Database** (base de datos en memoria)
- **Lombok** - Reducción de código boilerplate
- **MapStruct 1.6.3** - Mapeo entre DTOs y entidades
- **Bean Validation** - Validación de datos
- **Maven** - Gestión de dependencias

## 📦 Requisitos

- JDK 21 o superior
- Maven 3.6+

## 🔧 Instalación y Ejecución

### Clonar el repositorio
```bash
git clone <repository-url>
cd course-manager-api
```

### Compilar el proyecto
```bash
mvnw clean install
```

### Ejecutar la aplicación
```bash
mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 🗄️ Base de Datos

El proyecto usa **H2**, una base de datos en memoria que se reinicia con cada ejecución.

### Consola H2
Accede a la consola web de H2 en: `http://localhost:8080/h2-console`

**Credenciales:**
- JDBC URL: `jdbc:h2:mem:universitydb`
- Username: `sa`
- Password: *(vacío)*

## 📡 Endpoints API

### Estudiantes

#### Crear estudiante
```http
POST /students
Content-Type: application/json

{
  "firstName": "Juan",
  "lastName": "Pérez",
  "email": "juan.perez@university.com"
}
```

#### Obtener todos los estudiantes
```http
GET /students
```

### Cursos

#### Crear curso
```http
POST /courses
Content-Type: application/json

{
  "name": "Programación Avanzada",
  "code": "CS-301",
  "credits": 4
}
```

#### Inscribir estudiante en un curso
```http
PUT /courses/{courseId}/enroll/{studentId}
```

#### Obtener estudiantes de un curso
```http
GET /courses/{courseId}/students
```

## 📁 Estructura del Proyecto

```
src/main/java/com/university/course_manager_api/
├── controller/          # Controladores REST
│   ├── CourseController.java
│   └── StudentController.java
├── domain/             # Entidades JPA
│   ├── Course.java
│   └── Student.java
├── dto/                # Data Transfer Objects
│   ├── CourseRequestDTO.java
│   ├── CourseResponseDTO.java
│   ├── StudentRequestDTO.java
│   ├── StudentResponseDTO.java
│   └── ErrorResponse.java
├── exceptions/         # Manejo de excepciones
│   ├── BadRequestException.java
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
├── mapper/            # Mappers MapStruct
│   ├── CourseMapper.java
│   └── StudentMapper.java
├── repository/        # Repositorios Spring Data
│   ├── CourseRepository.java
│   └── StudentRepository.java
└── service/           # Lógica de negocio
    ├── CourseService.java
    └── StudentService.java
```

## 🧪 Testing

Ejecutar los tests:
```bash
mvnw test
```

## 📮 Colección Postman

El proyecto incluye un archivo `course-manager_collection.json` con ejemplos de todas las peticiones API. Importa este archivo en Postman para probar los endpoints.

## 🛠️ Características Técnicas

- **Validación de Datos**: Bean Validation en DTOs
- **Manejo Global de Excepciones**: `@RestControllerAdvice`
- **Relación Many-to-Many**: Entre `Student` y `Course`
- **DTOs**: Separación entre capa de presentación y dominio
- **MapStruct**: Mapeo automático y eficiente
- **Lombok**: Reducción de código boilerplate (`@Data`, `@Builder`, etc.)
- **Spring DevTools**: Hot reload en desarrollo

## 📝 Notas de Desarrollo

- Las tablas se crean automáticamente con `ddl-auto: update`
- SQL queries se muestran en consola (`show-sql: true`)
- Actuator habilitado para monitoreo en `/actuator`

## 🤝 Contribución

Co-Authored-By: Warp <agent@warp.dev>

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia que especifiques.
