# Guía de Uso - MsDatosGrafos

## Contenido del Proyecto

Este repositorio contiene la implementación completa del microservicio **MsDatosGrafos** siguiendo los principios de Arquitectura Hexagonal sin dependencias de frameworks específicos.

## Archivos de Documentación

### 📄 README.md
Documentación principal del proyecto que incluye:
- Resumen del microservicio
- Especificación completa del endpoint
- Entidades del dominio
- Mapeo de tipos
- Estructura de la arquitectura

### 📄 IMPLEMENTATION_SUMMARY.md
Resumen detallado de la implementación que incluye:
- Estado de completitud del proyecto
- Lista completa de archivos generados (36 archivos Java)
- Estructura del proyecto
- Próximos pasos para hacerlo funcional

### 📄 AGENT_PROMPT.md
Documento de especificación utilizado para generar el proyecto:
- Reglas de generación
- Convenciones de arquitectura
- Directrices para MsData vs MsDominio

### 📄 Microservicio MsDatosGrafos V1.0.pdf
Documento fuente con la especificación original del microservicio.

### 📄 pdf_extraction.txt
Extracción en texto plano del PDF para referencia rápida.

## Estructura del Código Fuente

```
src/main/java/pe/gob/reniec/siirc/msdatosgrafos/
├── domain/                         (Capa de Dominio - Lógica de Negocio)
│   ├── model/                     (8 clases)
│   │   ├── Ciudadano.java
│   │   ├── TipoParentesco.java
│   │   ├── Vigencia.java
│   │   ├── Sustento.java
│   │   ├── VinculoParentesco.java
│   │   ├── ResumenVinculos.java
│   │   ├── Paginacion.java
│   │   └── ResultadoConsultaVinculos.java
│   └── ports/                     (2 interfaces)
│       ├── in/
│       │   └── ConsultarVinculosParentescoUseCase.java
│       └── out/
│           └── VinculoParentescoRepositoryPort.java
│
├── application/                    (Capa de Aplicación - Casos de Uso)
│   └── service/                   (1 clase)
│       └── ConsultarVinculosParentescoService.java
│
└── infrastructure/                 (Capa de Infraestructura - Adaptadores)
    └── adapters/
        ├── in/                    (15 archivos)
        │   └── rest/
        │       ├── controller/
        │       │   └── VinculoParentescoController.java
        │       ├── dto/           (13 records)
        │       │   ├── CiudadanoDto.java
        │       │   ├── TipoParentescoDto.java
        │       │   ├── VigenciaDto.java
        │       │   ├── SustentoDto.java
        │       │   ├── VinculoDto.java
        │       │   ├── ResumenVinculosDto.java
        │       │   ├── PaginacionDto.java
        │       │   ├── VinculosParentescoDataDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── VinculosParentescoResponseDto.java
        │       │   ├── DetalleErrorDto.java
        │       │   ├── ErrorDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── VinculoParentescoDtoMapper.java
        └── out/                   (10 archivos)
            └── persistence/
                ├── entity/        (8 POJOs)
                │   ├── CiudadanoEntity.java
                │   ├── TipoParentescoEntity.java
                │   ├── VigenciaEntity.java
                │   ├── SustentoEntity.java
                │   ├── VinculoParentescoEntity.java
                │   ├── ResumenVinculosEntity.java
                │   ├── PaginacionEntity.java
                │   └── ResultadoConsultaVinculosEntity.java
                ├── mapper/
                │   └── VinculoParentescoPersistenceMapper.java
                └── VinculoParentescoRepositoryAdapter.java
```

## Características Principales

### ✅ Arquitectura Hexagonal Pura
- **Domain**: Contiene la lógica de negocio pura, sin dependencias externas
- **Application**: Orquesta los casos de uso
- **Infrastructure**: Adaptadores para entrada/salida

### ✅ Sin Frameworks
- Código Java puro sin Spring, JAX-RS, JPA
- Sin anotaciones de frameworks
- Completamente agnóstico de tecnología

### ✅ DTOs como Java Records
- Todos los DTOs implementados como records inmutables
- Sintaxis concisa y clara

### ✅ Tipos de Datos Apropiados
- `LocalDateTime` para fechas ISO 8601
- `Long` para IDs
- `Integer` para contadores
- `Boolean` para flags

## Cómo Usar Este Proyecto

### 1. Como Base para Implementación Real

Este código sirve como base sólida para:
1. Agregar Spring Boot o Quarkus
2. Implementar conexión a base de datos de grafos (Neo4j, JanusGraph)
3. Agregar validaciones y manejo de errores
4. Implementar seguridad y autenticación

### 2. Como Referencia Arquitectónica

Use este proyecto como referencia para:
- Estructura correcta de Arquitectura Hexagonal
- Separación de responsabilidades
- Patrón de puertos y adaptadores
- Domain-Driven Design

### 3. Como Template para Otros Microservicios

La estructura puede replicarse para otros microservicios:
- Mantenga la misma estructura de carpetas
- Siga las mismas convenciones de nombrado
- Respete la separación de capas

## Próximos Pasos para Implementación

### Paso 1: Agregar Build Tool
Crear `pom.xml` (Maven) o `build.gradle` (Gradle):
```xml
<!-- Ejemplo básico de pom.xml -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Agregar driver de base de datos de grafos -->
</dependencies>
```

### Paso 2: Anotar el Controller
```java
@RestController
@RequestMapping("/api/v1/APD/MsDatosGrafos")
public class VinculoParentescoController {
    
    @GetMapping("/vinculos-parentesco")
    public ResponseEntity<VinculosParentescoResponseDto> consultarVinculosParentesco(
        @RequestParam String idCiudadano,
        @RequestParam(required = false) Integer gradoMaximo,
        // ... más parámetros
    ) {
        // ... implementación existente
    }
}
```

### Paso 3: Implementar el RepositoryAdapter
```java
@Repository
public class VinculoParentescoRepositoryAdapter implements VinculoParentescoRepositoryPort {
    
    private final Neo4jClient neo4jClient; // O el cliente que uses
    
    @Override
    public ResultadoConsultaVinculos consultarVinculosParentesco(...) {
        // Implementar consulta Cypher o Gremlin
        String cypher = "MATCH (c:Ciudadano)-[r:TIENE_VINCULO]->(rel:Ciudadano) " +
                       "WHERE c.idCiudadano = $idCiudadano " +
                       "RETURN ...";
        
        // Ejecutar consulta y mapear resultados
    }
}
```

### Paso 4: Configurar Dependency Injection
```java
@Configuration
public class AppConfig {
    
    @Bean
    public VinculoParentescoPersistenceMapper persistenceMapper() {
        return new VinculoParentescoPersistenceMapper();
    }
    
    @Bean
    public VinculoParentescoRepositoryPort repositoryPort(
            VinculoParentescoPersistenceMapper mapper) {
        return new VinculoParentescoRepositoryAdapter(mapper);
    }
    
    @Bean
    public ConsultarVinculosParentescoUseCase consultarVinculosUseCase(
            VinculoParentescoRepositoryPort repositoryPort) {
        return new ConsultarVinculosParentescoService(repositoryPort);
    }
}
```

### Paso 5: Agregar Manejo de Errores
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CiudadanoNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCiudadanoNotFound(
            CiudadanoNotFoundException ex) {
        // Construir ErrorResponseDto
        return ResponseEntity.status(404).body(errorResponse);
    }
}
```

## Validación del Código

El código ha sido verificado y:
- ✅ Compila correctamente como Java puro
- ✅ Sigue convenciones de nomenclatura Java
- ✅ Respeta la Arquitectura Hexagonal
- ✅ Cumple con todas las especificaciones del PDF
- ✅ Solo implementa operaciones documentadas

## Contacto y Soporte

Para preguntas sobre la arquitectura o implementación, consulte:
- **README.md** - Documentación funcional
- **IMPLEMENTATION_SUMMARY.md** - Detalles de implementación
- **AGENT_PROMPT.md** - Reglas y convenciones utilizadas

## Licencia

Este proyecto es parte del sistema SIIRC del RENIEC.
