# MsDatosCiudadano

## Resumen del Microservicio

**Nombre:** MsDatosCiudadano  
**Tipo:** Microservicio de Datos (MsData)  
**Versión API:** v1  
**Paquete Base:** `pe.gob.reniec.msdatosciudadano`  
**Contexto de Negocio:** Gestión centralizada de la información de identificación (DNI) de los ciudadanos peruanos para el sistema de personalización del DNI Electrónico de RENIEC.

## Descripción

El Microservicio de Ciudadano es un componente esencial de la plataforma, encargado de la gestión centralizada de la información de identificación (DNI) de los ciudadanos. Su propósito principal es actuar como la única fuente de verdad para los datos de los ciudadanos, garantizando la consistencia y la integridad en toda la plataforma.

Este microservicio es del tipo **MsData**, lo que significa que:
- Define interfaces `RepositoryPort` y sus implementaciones `RepositoryAdapter`
- Define entidades del dominio y entidades de persistencia
- Gestiona el almacenamiento y recuperación de datos
- No depende de frameworks ni tecnologías específicas (implementación pura en Java)

## Arquitectura Hexagonal

El proyecto sigue estrictamente los principios de Arquitectura Hexagonal sin dependencias a frameworks:

```
src/main/java/pe/gob/reniec/msdatosciudadano/
├── domain/
│   ├── model/                          # Entidades del dominio (POJOs)
│   │   ├── Ciudadano.java
│   │   ├── InformacionParental.java
│   │   ├── DireccionResidencia.java
│   │   ├── Contacto.java
│   │   ├── InformacionElectoral.java
│   │   ├── DatosBiometricos.java
│   │   ├── HuellaDactilar.java
│   │   ├── Fotografia.java
│   │   ├── FirmaDigital.java
│   │   ├── Alerta.java
│   │   ├── InformePericial.java
│   │   ├── CotejoMasivo.java
│   │   ├── RegistroCotejo.java
│   │   ├── ConfiguracionCotejo.java
│   │   ├── EntidadSolicitante.java
│   │   └── CambioDomicilio.java
│   └── ports/
│       ├── in/                         # Casos de uso (interfaces)
│       │   ├── CrearCiudadanoUseCase.java
│       │   ├── ActualizarCiudadanoUseCase.java
│       │   ├── ConsultarCiudadanoUseCase.java
│       │   ├── ListarCiudadanosUseCase.java
│       │   ├── ConsultarInformePericialUseCase.java
│       │   ├── CrearAlertaUseCase.java
│       │   ├── ListarAlertaUseCase.java
│       │   ├── ConsultarAlertaUseCase.java
│       │   ├── ConsultarCambiosDomicilioUseCase.java
│       │   └── ConsultaMasivaUseCase.java
│       └── out/                        # Puertos de salida (interfaces)
│           ├── CiudadanoRepositoryPort.java
│           ├── AlertaRepositoryPort.java
│           ├── InformePericialRepositoryPort.java
│           ├── CotejoMasivoRepositoryPort.java
│           └── CambioDomicilioRepositoryPort.java
├── application/
│   └── service/                        # Servicios de aplicación
│       ├── CrearCiudadanoService.java
│       ├── ActualizarCiudadanoService.java
│       ├── ConsultarCiudadanoService.java
│       ├── ListarCiudadanosService.java
│       ├── ConsultarInformePericialService.java
│       ├── CrearAlertaService.java
│       ├── ListarAlertaService.java
│       ├── ConsultarAlertaService.java
│       ├── ConsultarCambiosDomicilioService.java
│       └── ConsultaMasivaService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/         # Controladores REST (POJOs)
        │       │   ├── CiudadanoController.java
        │       │   ├── AlertaController.java
        │       │   └── ConsultasController.java
        │       ├── dto/                # DTOs (Records de Java)
        │       │   ├── CrearCiudadanoRequestDto.java
        │       │   ├── CiudadanoResponseDto.java
        │       │   ├── InformacionParentalDto.java
        │       │   ├── DireccionResidenciaDto.java
        │       │   ├── ContactoDto.java
        │       │   ├── InformacionElectoralDto.java
        │       │   ├── DatosBiometricosDto.java
        │       │   ├── HuellaDactilarDto.java
        │       │   ├── FotografiaDto.java
        │       │   ├── FirmaDigitalDto.java
        │       │   ├── CrearAlertaRequestDto.java
        │       │   ├── AlertaResponseDto.java
        │       │   ├── ConsultaMasivaRequestDto.java
        │       │   ├── EntidadSolicitanteDto.java
        │       │   ├── ConfiguracionCotejoDto.java
        │       │   ├── RegistroCotejoDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── ErrorDetalleDto.java
        │       └── mapper/              # Mappers DTO-Domain
        │           ├── CiudadanoDtoMapper.java
        │           ├── AlertaDtoMapper.java
        │           └── CotejoMasivoDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/             # Entidades de persistencia (POJOs)
                │   ├── CiudadanoEntity.java
                │   └── AlertaEntity.java
                ├── mapper/             # Mappers Domain-Entity
                │   ├── CiudadanoPersistenceMapper.java
                │   └── AlertaPersistenceMapper.java
                ├── CiudadanoRepositoryAdapter.java
                ├── AlertaRepositoryAdapter.java
                ├── InformePericialRepositoryAdapter.java
                ├── CotejoMasivoRepositoryAdapter.java
                └── CambioDomicilioRepositoryAdapter.java
```

## Endpoints

### 1. Crear Ciudadano
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano`
- **Método:** POST
- **Headers:**
  - `Content-Type: multipart/form-data`
  - `Authorization: Bearer <token>`
  - `X-Correlation-ID: <UUID>`
  - `X-Office-Code: <código_oficina>`
- **Request Body:** JSON con datos completos del ciudadano (ver estructura en PDF)
- **Response (201):** `{ "id": "string", "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm" }`
- **Errores:** 400, 401, 403, 408, 413, 422, 429

### 2. Actualizar Ciudadano
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/{id}`
- **Método:** PUT
- **Headers:** Igual que Crear Ciudadano
- **Request Body:** JSON con datos del ciudadano a actualizar
- **Response (200):** `{ "id": "string", "fechaCreacion": "...", "fechaActualizacion": "...", "datosActualizados": [...] }`
- **Errores:** 400, 401, 403, 408, 413, 422, 429

### 3. Obtener Ciudadano
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/documento`
- **Método:** GET
- **Query Params:**
  - `tipoDocumento` (string, requerido)
  - `numeroDocumento` (string, requerido)
- **Response (200):** Datos completos del ciudadano
- **Errores:** 401, 403, 404, 408, 429

### 4. Listar Ciudadanos
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/ciudadano`
- **Método:** GET
- **Query Params:**
  - `page` (integer, requerido)
  - `size` (integer, requerido)
  - `queryParam1`, `queryParam2`, `queryParam3` (string, opcional)
  - `fields` (array string, opcional)
- **Response (200):** Paginación con lista de ciudadanos
- **Errores:** 401, 403, 404, 408, 429

### 5. Consultar Informe Pericial
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/informes-periciales`
- **Método:** GET
- **Query Params:**
  - `tipoDocumento` (string, requerido)
  - `numeroDocumento` (string, requerido)
- **Response (200):** Lista de informes periciales
- **Errores:** 204, 401, 403, 404

### 6. Crear Alerta
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`
- **Método:** POST
- **Request Body:** Datos de la alerta (situación, ciudadanoId, motivo, etc.)
- **Response (201):** `{ "id": "string", "fechaCreacion": "...", "estado": "string" }`
- **Errores:** 401, 403, 404, 409

### 7. Listar Alertas
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`
- **Método:** GET
- **Query Params:** Similar a Listar Ciudadanos
- **Response (200):** Paginación con lista de alertas
- **Errores:** 401, 403, 404, 408, 429

### 8. Consultar Alerta
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`
- **Método:** GET
- **Query Params:**
  - `alertaId` (string, requerido)
- **Response (200):** Detalle completo de la alerta
- **Errores:** 400, 401, 403, 404, 408, 429, 500, 502, 503

### 9. Consultar Cambios Domicilio
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/cambio-domicilio`
- **Método:** GET
- **Query Params:**
  - `fechaDesde` (string YYYY-MM-DD, requerido)
  - `fechaHasta` (string YYYY-MM-DD, requerido)
  - `circunscripcionId` (string, opcional)
  - `queryParam1`, `queryParam2`, `queryParam3` (string, opcional)
- **Response (200):** Lista de cambios de domicilio
- **Errores:** 204, 400, 401, 403, 404, 408, 429, 500

### 10. Consulta Masiva
- **Path:** `/api/v1/ciudadano/MsDatosCiudadano/consulta-masiva`
- **Método:** POST
- **Request Body:** Solicitud con entidad solicitante, configuración de cotejo y registros (máx 500)
- **Response (200/202):** Resultado del cotejo masivo con estadísticas
- **Errores:** 400, 401, 403, 408, 413, 422, 429, 500, 502, 503

## Entidades del Dominio

### Ciudadano (Aggregate Root)
Representa la información completa de un ciudadano peruano.

**Atributos principales:**
- `id: String`
- `tipoDocumento: String`
- `numeroDocumento: String`
- `primerNombre: String`
- `segundoNombre: String`
- `primerApellido: String`
- `segundoApellido: String`
- `fechaNacimiento: LocalDate`
- `sexo: String`
- `estadoCivil: String`
- `nacionalidad: String`
- `paisNacimiento: String`
- `departamentoNacimiento: String`
- `provinciaNacimiento: String`
- `distritoNacimiento: String`
- `grupoSanguineo: String`
- `estatura: String`
- `estado: String`
- `fechaCreacion: LocalDateTime`
- `fechaActualizacion: LocalDateTime`

**Objetos de valor asociados:**
- `informacionParental: InformacionParental`
- `direccionResidencia: DireccionResidencia`
- `contacto: Contacto`
- `informacionElectoral: InformacionElectoral`
- `datosBiometricos: DatosBiometricos`

### Alerta
Representa una alerta de domicilio asociada a un ciudadano.

**Atributos:**
- `id: String`
- `ciudadanoId: String`
- `situacion: String` (A, B, C)
- `motivo: String`
- `fechaDeteccion: LocalDateTime`
- `circunscripcionId: String`
- `medioVerificacion: String` (fisico, virtual)
- `documentoSoporteId: String`
- `equipoTrabajoId: String`
- `fechaCreacion: LocalDateTime`
- `fechaActualizacion: LocalDateTime`
- `estado: String`

### InformePericial
Representa un informe pericial biométrico de un ciudadano.

**Atributos:**
- `informeId: String`
- `ciudadanoId: String`
- `solicitudId: String`
- `fechaGeneracion: LocalDateTime`
- `huellaCoincide: Boolean`
- `rostroCoincide: Boolean`
- `urlPdf: String`

### CotejoMasivo
Representa una solicitud de verificación masiva de datos.

**Atributos:**
- `solicitudId: String`
- `codigoCotejo: String`
- `entidadSolicitante: EntidadSolicitante`
- `configuracionCotejo: ConfiguracionCotejo`
- `registros: List<RegistroCotejo>` (máx 500)
- `fechaProcesamiento: LocalDateTime`
- `estadoProceso: String`

### CambioDomicilio
Representa un cambio de domicilio de un ciudadano.

**Atributos:**
- `tipoDocumento: String`
- `numeroDocumento: String`
- `nombreCompleto: String`
- `departamento: String`
- `provincia: String`
- `distrito: String`
- `fechaCambio: LocalDate`

## Reglas de Mapeo de Tipos

El proyecto utiliza los siguientes tipos de datos Java para mapear los atributos del PDF:

| Tipo en PDF | Tipo en Java |
|------------|--------------|
| string | `String` |
| integer/int/long | `Long` |
| number/decimal/double | `Double` |
| boolean | `Boolean` |
| date (YYYY-MM-DD) | `LocalDate` |
| datetime/timestamp (ISO 8601) | `LocalDateTime` |
| array/list | `List<T>` |

**Ejemplos:**
- `fechaNacimiento` → `LocalDate`
- `fechaCreacion` → `LocalDateTime`
- `inscritoVotacion` → `Boolean`
- `huellasDactilares` → `List<HuellaDactilar>`

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 202 | Accepted - Cotejo masivo aceptado, procesamiento en curso |
| 204 | No Content - Sin contenido para los criterios especificados |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 413 | Payload Too Large - Tamaño del lote excede el límite |
| 422 | Unprocessable Entity - Datos válidos pero no procesables |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- **Sin frameworks:** El código está escrito en Java puro sin dependencias a Spring, JAX-RS, JPA, MapStruct, etc.
- **Sin anotaciones:** No se utilizan anotaciones de frameworks (@RestController, @Entity, @Component, etc.)
- **POJOs puros:** Todas las clases son Plain Old Java Objects con getters/setters estándar
- **Records para DTOs:** Se utilizan records de Java (disponibles desde Java 14) para inmutabilidad de DTOs

### Implementación de Adaptadores
- Los adaptadores de persistencia (`RepositoryAdapter`) tienen métodos stub que lanzan `UnsupportedOperationException`
- La implementación real dependerá de la tecnología de persistencia elegida (base de datos, ORM, etc.)
- Los mappers de persistencia están definidos pero requieren completar la lógica de conversión para objetos complejos

### Protocolo de Comunicación
- No se define el protocolo específico para comunicación HTTP (REST, SOAP, GraphQL)
- Los Controllers son clases Java simples sin anotaciones de routing
- La configuración del servidor HTTP y el binding de rutas debe hacerse externamente

### Gestión de Errores
- La estructura de errores está definida en `ErrorResponseDto` pero la lógica de manejo de excepciones debe implementarse
- Los códigos de estado HTTP están documentados pero no hay validación automática

### Validaciones
- No hay validaciones automáticas de entrada (tamaños, formatos, obligatoriedad)
- Las validaciones deben implementarse manualmente en los servicios o controllers

### Seguridad
- Los headers de autenticación están documentados pero no hay implementación de validación JWT
- La gestión de permisos y roles debe implementarse externamente

### Datos Biométricos
- Los datos biométricos se manejan como Base64 strings
- El procesamiento real de huellas, fotografías y firmas digitales está fuera del scope

## Próximos Pasos

Para hacer este microservicio funcional, se requiere:

1. **Seleccionar tecnologías concretas:**
   - Framework web (Spring Boot, Quarkus, Micronaut, etc.)
   - Base de datos (PostgreSQL, MongoDB, Oracle, etc.)
   - ORM/Persistencia (JPA/Hibernate, MyBatis, JDBC puro, etc.)

2. **Implementar la capa de persistencia:**
   - Configurar conexión a base de datos
   - Implementar los métodos de los `RepositoryAdapter`
   - Crear esquemas de base de datos

3. **Configurar el servidor HTTP:**
   - Definir el binding de rutas a los Controllers
   - Implementar serialización/deserialización JSON
   - Configurar manejo de errores global

4. **Agregar seguridad:**
   - Implementar validación de JWT
   - Agregar autorización basada en roles
   - Configurar CORS y otras políticas de seguridad

5. **Implementar validaciones:**
   - Validar datos de entrada
   - Implementar reglas de negocio específicas
   - Agregar sanitización de datos

6. **Testing:**
   - Tests unitarios de servicios y mappers
   - Tests de integración de adaptadores
   - Tests end-to-end de API

7. **Observabilidad:**
   - Logging estructurado
   - Métricas de aplicación
   - Distributed tracing

## Conclusión

Este proyecto proporciona una base sólida de Arquitectura Hexagonal pura sin dependencias tecnológicas, siguiendo estrictamente las especificaciones del PDF adjunto. La estructura está completa y lista para ser integrada con las tecnologías específicas que el equipo de desarrollo elija utilizar.
