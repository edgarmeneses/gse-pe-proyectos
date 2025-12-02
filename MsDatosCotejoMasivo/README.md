# Microservicio MsDatosCotejoMasivo

## Resumen del Microservicio

**Nombre:** MsDatosCotejoMasivo  
**Tipo:** MsData (Microservicio de Datos)  
**Contexto:** Gestión de Seguridad Electrónica - RENIEC  
**Versión API:** v1.0  
**Fecha de Generación:** 01/12/2025  

El microservicio **MsDatosCotejoMasivo** es el componente de persistencia exclusivo para la gestión de datos del proceso de Cotejo Masivo. Actúa como el único intermediario autorizado para acceder a la Base de Datos de Cotejo Masivo (esquema COTEJO_MASIVO_CTJ), garantizando la integridad, trazabilidad y seguridad de los registros.

## Arquitectura

Este proyecto implementa **Arquitectura Hexagonal** estricta con las siguientes características:

- **Sin dependencias externas**: No utiliza frameworks (Spring, JAX-RS, JPA, etc.)
- **POJOs puros**: Todas las clases son Java plano sin anotaciones
- **Separación estricta de responsabilidades**: Dominio, aplicación e infraestructura completamente desacoplados
- **Neutralidad tecnológica**: El código es compilable como Java puro

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/cotejo/masivo/
├── domain/
│   ├── model/
│   │   ├── Ejecucion.java
│   │   ├── ResumenResultados.java
│   │   ├── RegistroEntrada.java
│   │   └── ResultadoCotejo.java
│   └── ports/
│       ├── in/
│       │   ├── CrearEjecucionUseCase.java
│       │   ├── RegistrarRegistrosEntradaUseCase.java
│       │   ├── RegistrarResultadosCotejoUseCase.java
│       │   ├── ListarEjecucionesUseCase.java
│       │   └── ConsultarEjecucionUseCase.java
│       └── out/
│           ├── EjecucionRepositoryPort.java
│           ├── RegistroEntradaRepositoryPort.java
│           └── ResultadoCotejoRepositoryPort.java
├── application/
│   └── service/
│       ├── CrearEjecucionService.java
│       ├── RegistrarRegistrosEntradaService.java
│       ├── RegistrarResultadosCotejoService.java
│       ├── ListarEjecucionesService.java
│       └── ConsultarEjecucionService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── EjecucionController.java
        │       ├── dto/
        │       │   ├── CrearEjecucionRequestDto.java
        │       │   ├── EjecucionResponseDto.java
        │       │   ├── (21 DTOs más...)
        │       └── mapper/
        │           └── EjecucionDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── EjecucionEntity.java
                │   ├── RegistroEntradaEntity.java
                │   └── ResultadoCotejoEntity.java
                ├── mapper/
                │   ├── EjecucionPersistenceMapper.java
                │   ├── RegistroEntradaPersistenceMapper.java
                │   └── ResultadoCotejoPersistenceMapper.java
                ├── EjecucionRepositoryAdapter.java
                ├── RegistroEntradaRepositoryAdapter.java
                └── ResultadoCotejoRepositoryAdapter.java
```

## Endpoints Documentados

### 1. Crear Nueva Ejecución de Cotejo

**Endpoint:** `POST /api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP  

**Headers:**
- `Authorization`: String (Bearer token JWT)
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID (Trazabilidad end-to-end)
- `X-Office-Code`: String (Código de oficina)
- `X-User-Role`: String (Rol del usuario)
- `X-Idempotency-Key`: UUID (Evitar creaciones duplicadas)

**Request Body:**
```json
{
  "solicitudId": "UUID",
  "codigoOrganizacion": "string (4)",
  "nombreOrganizacion": "string (1-200)",
  "codigoEnvio": "string (4)",
  "numeroLote": "string (1-20)",
  "totalRegistrosEntrada": "integer",
  "documentoSustento": "string (1-50)",
  "observaciones": "string (0-500)",
  "indicadorDomicilio": "string (1)",
  "codigoPrograma": "string (1-6)"
}
```

**Response Body (201 Created):**
```json
{
  "success": true,
  "data": {
    "ejecucionId": "UUID",
    "solicitudId": "UUID",
    "codigoOrganizacion": "string",
    "nombreOrganizacion": "string",
    "codigoEnvio": "string",
    "numeroLote": "string",
    "codigoEstado": "string",
    "descripcionEstado": "string",
    "totalRegistrosEntrada": "integer",
    "fechaCreacion": "ISO 8601",
    "usuarioCreacion": "string",
    "_links": {
      "self": "string",
      "registros": "string",
      "resultados": "string",
      "actualizarEstado": "string"
    }
  },
  "metadata": {
    "timestamp": "ISO 8601",
    "correlationId": "UUID",
    "version": "string"
  }
}
```

**Status Codes:**
- `201 Created`: Ejecución creada exitosamente
- `400 Bad Request`: Datos inválidos o campos obligatorios faltantes
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos
- `404 Not Found`: Solicitud asociada no encontrada
- `409 Conflict`: Ya existe una ejecución activa para esta solicitud
- `422 Unprocessable Entity`: Lógica de negocio no permite procesarlos
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### 2. Registrar Registros de Entrada (Batch)

**Endpoint:** `POST /api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}/registros`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP  

**Path Parameters:**
- `ejecucionId`: UUID (obligatorio)

**Headers:**
- `Authorization`: String (Bearer token JWT)
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Batch-Size`: Integer (Número de registros en el lote)

**Request Body:**
```json
{
  "registros": [
    {
      "numeroSecuencia": "integer",
      "numeroDni": "string (8)",
      "apellidoPaterno": "string (1-128)",
      "apellidoMaterno": "string (1-128)",
      "nombres": "string (1-160)",
      "fechaNacimiento": "YYYY-MM-DD",
      "indicadorSexo": "string (1)",
      "identificadorInstitucion": "string (1-15)",
      "datosAdicionales": {}
    }
  ]
}
```

**Response Body (201 Created / 207 Multi-Status):**
```json
{
  "success": true,
  "data": {
    "ejecucionId": "UUID",
    "totalRegistrosRecibidos": "integer",
    "totalRegistrosInsertados": "integer",
    "totalRegistrosRechazados": "integer",
    "registrosInsertados": [
      {
        "registroEntradaId": "UUID",
        "numeroSecuencia": "integer",
        "numeroDni": "string"
      }
    ],
    "registrosRechazados": [
      {
        "numeroSecuencia": "integer",
        "numeroDni": "string",
        "motivoRechazo": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "ISO 8601",
    "correlationId": "UUID",
    "version": "string",
    "tiempoProcesamiento": "string"
  }
}
```

**Status Codes:**
- `201 Created`: Registros realizados exitosamente
- `207 Multi-Status`: Algunos registros insertados, otros rechazados
- `400 Bad Request`: Datos inválidos en el request
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Usuario sin permisos
- `404 Not Found`: Ejecución no encontrada
- `409 Conflict`: Números de secuencia duplicados
- `413 Payload Too Large`: Lote excede el tamaño máximo permitido
- `422 Unprocessable Entity`: Estado de la ejecución no permite insertar registros
- `500 Internal Server Error`: Error interno

---

### 3. Registrar Resultados de Cotejo (Batch)

**Endpoint:** `POST /api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}/resultados`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP  

**Path Parameters:**
- `ejecucionId`: UUID (obligatorio)

**Headers:**
- `Authorization`: String (Bearer token JWT)
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Batch-Size`: Integer

**Request Body:**
```json
{
  "resultados": [
    {
      "registroEntradaId": "UUID",
      "codigoResultado": "string (1-10)",
      "numeroDniEncontrado": "string (8)",
      "apellidoPaternoEncontrado": "string (1-128)",
      "apellidoMaternoEncontrado": "string (1-128)",
      "nombresEncontrado": "string (1-160)",
      "fechaNacimientoEncontrada": "YYYY-MM-DD",
      "indicadorSexoEncontrado": "string (1)",
      "codigoUbigeoDomicilio": "string (6)",
      "descripcionDomicilio": "string (1-200)",
      "estadoCivil": "string (1-20)",
      "condicionCiudadano": "string (1-20)",
      "fechaCaducidadDni": "YYYY-MM-DD",
      "indicadorRestriccion": "string (1-2)",
      "fechaRestriccion": "YYYY-MM-DD",
      "coincideDni": "string (1)",
      "coincideApellidoPaterno": "string (1)",
      "coincideApellidoMaterno": "string (1)",
      "coincideNombres": "string (1)",
      "coincideFechaNacimiento": "string (1)",
      "coincideSexo": "string (1)",
      "mensajeObservacion": "string (0-500)"
    }
  ]
}
```

**Response Body (201 Created / 207 Multi-Status):**
```json
{
  "success": true,
  "data": {
    "ejecucionId": "UUID",
    "totalResultadosRecibidos": "integer",
    "totalResultadosInsertados": "integer",
    "totalResultadosRechazados": "integer",
    "resumenResultados": {
      "totalCorrectos": "integer",
      "totalIncorrectos": "integer",
      "totalNoEncontrados": "integer",
      "totalFallecidos": "integer",
      "totalRestringidos": "integer",
      "totalErrores": "integer"
    },
    "resultadosRechazados": [
      {
        "registroEntradaId": "UUID",
        "motivoRechazo": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "ISO 8601",
    "correlationId": "UUID",
    "version": "string",
    "tiempoProcesamiento": "string"
  }
}
```

**Status Codes:**
- `201 Created`: Resultados insertados exitosamente
- `207 Multi-Status`: Algunos resultados insertados, otros rechazados
- `400 Bad Request`: Datos inválidos
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Usuario sin permisos
- `404 Not Found`: Ejecución o registro de entrada no encontrado
- `409 Conflict`: Ya existe resultado para el registro de entrada
- `422 Unprocessable Entity`: Estado no permite insertar resultados
- `500 Internal Server Error`: Error interno

---

### 4. Listar Ejecuciones de Cotejo

**Endpoint:** `GET /api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP  

**Headers:**
- `Authorization`: String (Bearer token JWT)
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

**Query Parameters:**
- `solicitudId`: UUID (opcional)
- `codigoOrganizacion`: String (1-4, opcional)
- `codigoEnvio`: String (1-4, opcional)
- `codigoEstado`: String (1-10, opcional)
- `fechaDesde`: ISO 8601 (opcional)
- `fechaHasta`: ISO 8601 (opcional)
- `page`: Integer (opcional, default: 0)
- `size`: Integer (opcional, 1-100)
- `sort`: String (1-50, opcional)
- `direction`: String (ASC/DESC, 3-4, opcional)

**Response Body (200 OK):**
```json
{
  "success": true,
  "data": [
    {
      "ejecucionId": "UUID",
      "solicitudId": "UUID",
      "codigoOrganizacion": "string",
      "nombreOrganizacion": "string",
      "codigoEnvio": "string",
      "numeroLote": "string",
      "codigoEstado": "string",
      "descripcionEstado": "string",
      "totalRegistrosEntrada": "integer",
      "totalRegistrosProcesados": "integer",
      "totalRegistrosCorrectos": "integer",
      "totalRegistrosIncorrectos": "integer",
      "fechaInicioProceso": "ISO 8601",
      "fechaFinProceso": "ISO 8601",
      "fechaCreacion": "ISO 8601",
      "usuarioCreacion": "string"
    }
  ],
  "pagination": {
    "page": "integer",
    "size": "integer",
    "totalElements": "integer",
    "totalPages": "integer",
    "first": "boolean",
    "last": "boolean"
  },
  "metadata": {
    "timestamp": "ISO 8601",
    "correlationId": "UUID",
    "version": "string"
  }
}
```

**Status Codes:**
- `200 OK`: Lista de ejecuciones consultada exitosamente
- `400 Bad Request`: Parámetros de consulta inválidos
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Usuario sin permisos
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno

---

### 5. Consultar Ejecución Específica

**Endpoint:** `GET /api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP  

**Path Parameters:**
- `ejecucionId`: UUID (obligatorio, 36)

**Headers:**
- `Authorization`: String (Bearer token JWT)
- `X-Correlation-ID`: UUID

**Response Body (200 OK):**
```json
{
  "success": true,
  "data": {
    "ejecucionId": "UUID",
    "solicitudId": "UUID",
    "codigoOrganizacion": "string",
    "nombreOrganizacion": "string",
    "codigoEnvio": "string",
    "numeroLote": "string",
    "codigoEstado": "string",
    "descripcionEstado": "string",
    "totalRegistrosEntrada": "integer",
    "totalRegistrosProcesados": "integer",
    "totalRegistrosCorrectos": "integer",
    "totalRegistrosIncorrectos": "integer",
    "fechaInicioProceso": "ISO 8601",
    "fechaFinProceso": "ISO 8601",
    "documentoSustento": "string",
    "observaciones": "string",
    "urlReporteGenerado": "URL",
    "indicadorDomicilio": "string",
    "codigoPrograma": "string",
    "resumenResultados": {
      "totalCorrectos": "integer",
      "totalIncorrectos": "integer",
      "totalNoEncontrados": "integer",
      "totalFallecidos": "integer",
      "totalRestringidos": "integer",
      "totalCaducados": "integer",
      "totalErrores": "integer"
    },
    "fechaCreacion": "ISO 8601",
    "usuarioCreacion": "string",
    "fechaModificacion": "ISO 8601",
    "usuarioModificacion": "string",
    "_links": {
      "self": "string",
      "registros": "string",
      "resultados": "string",
      "actualizarEstado": "string",
      "solicitud": "string"
    }
  },
  "metadata": {
    "timestamp": "ISO 8601",
    "correlationId": "UUID",
    "version": "string"
  }
}
```

**Status Codes:**
- `200 OK`: Ejecución consultada exitosamente
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Usuario sin permisos
- `404 Not Found`: Ejecución no encontrada
- `500 Internal Server Error`: Error interno

---

## Entidades del Dominio

### Ejecucion
Aggregate Root que representa una ejecución de cotejo masivo.

**Atributos:**
- `ejecucionId`: UUID
- `solicitudId`: UUID
- `codigoOrganizacion`: String
- `nombreOrganizacion`: String
- `codigoEnvio`: String
- `numeroLote`: String
- `codigoEstado`: String
- `descripcionEstado`: String
- `totalRegistrosEntrada`: Integer
- `totalRegistrosProcesados`: Integer
- `totalRegistrosCorrectos`: Integer
- `totalRegistrosIncorrectos`: Integer
- `fechaInicioProceso`: LocalDateTime
- `fechaFinProceso`: LocalDateTime
- `documentoSustento`: String
- `observaciones`: String
- `urlReporteGenerado`: String
- `indicadorDomicilio`: String
- `codigoPrograma`: String
- `resumenResultados`: ResumenResultados
- `fechaCreacion`: LocalDateTime
- `usuarioCreacion`: String
- `fechaModificacion`: LocalDateTime
- `usuarioModificacion`: String

### RegistroEntrada
Representa un registro de entrada para cotejo.

**Atributos:**
- `registroEntradaId`: UUID
- `ejecucionId`: UUID
- `numeroSecuencia`: Integer
- `numeroDni`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `nombres`: String
- `fechaNacimiento`: LocalDate
- `indicadorSexo`: String
- `identificadorInstitucion`: String
- `datosAdicionales`: String

### ResultadoCotejo
Representa el resultado de un cotejo individual.

**Atributos:**
- `resultadoCotejoId`: UUID
- `registroEntradaId`: UUID
- `codigoResultado`: String
- `numeroDniEncontrado`: String
- `apellidoPaternoEncontrado`: String
- `apellidoMaternoEncontrado`: String
- `nombresEncontrado`: String
- `fechaNacimientoEncontrada`: LocalDate
- `indicadorSexoEncontrado`: String
- `codigoUbigeoDomicilio`: String
- `descripcionDomicilio`: String
- `estadoCivil`: String
- `condicionCiudadano`: String
- `fechaCaducidadDni`: LocalDate
- `indicadorRestriccion`: String
- `fechaRestriccion`: LocalDate
- `coincideDni`: String
- `coincideApellidoPaterno`: String
- `coincideApellidoMaterno`: String
- `coincideNombres`: String
- `coincideFechaNacimiento`: String
- `coincideSexo`: String
- `mensajeObservacion`: String

### ResumenResultados
Value Object que representa el resumen consolidado.

**Atributos:**
- `totalCorrectos`: Integer
- `totalIncorrectos`: Integer
- `totalNoEncontrados`: Integer
- `totalFallecidos`: Integer
- `totalRestringidos`: Integer
- `totalCaducados`: Integer
- `totalErrores`: Integer

---

## Reglas de Mapeo de Tipos

El mapeo de tipos del PDF a Java se realizó de la siguiente manera:

| Tipo PDF | Tipo Java | Observaciones |
|----------|-----------|---------------|
| string | String | Tipo básico de cadena |
| integer | Integer | Números enteros |
| UUID | UUID | Identificadores únicos |
| YYYY-MM-DD | LocalDate | Solo fecha sin hora |
| YYYY-MM-DDThh:mm:ss±hh:mm | LocalDateTime | Fecha y hora con zona horaria |
| ISO 8601 | LocalDateTime | Formato de fecha/hora estándar |
| boolean | Boolean | Valores verdadero/falso |
| array | List<T> | Colecciones genéricas |
| object | Object/POJO | Objetos personalizados |

---

## Tipo de Microservicio: MsData

Este microservicio es de tipo **MsData** (Microservicio de Datos), lo que implica:

### Características Estructurales:

1. **Sí define RepositoryPort**: Interfaces para operaciones de persistencia
   - `EjecucionRepositoryPort`
   - `RegistroEntradaRepositoryPort`
   - `ResultadoCotejoRepositoryPort`

2. **Sí define Entities**: POJOs para representación de datos en persistencia
   - `EjecucionEntity`
   - `RegistroEntradaEntity`
   - `ResultadoCotejoEntity`

3. **Sí define RepositoryAdapter**: Implementaciones de los puertos de repositorio
   - `EjecucionRepositoryAdapter`
   - `RegistroEntradaRepositoryAdapter`
   - `ResultadoCotejoRepositoryAdapter`

4. **No depende de tecnologías específicas**: Sin JPA, sin JDBC, sin drivers
   - Los adapters tienen métodos stub que lanzan `UnsupportedOperationException`
   - Listos para implementar con la tecnología que se elija posteriormente

### Responsabilidades:

- Persistir ejecuciones de cotejo masivo
- Almacenar registros de entrada en lotes
- Guardar resultados de cotejo
- Consultar y listar ejecuciones con filtros y paginación
- Garantizar integridad y trazabilidad de los datos

---

## Limitaciones y Aclaraciones

### Sin Frameworks
Este proyecto **NO utiliza ningún framework**:
- No Spring Boot / Spring Framework
- No JAX-RS / Jersey
- No JPA / Hibernate
- No MapStruct
- Sin anotaciones de ningún tipo

### Sin Tecnología de Persistencia Definida
Los adaptadores de persistencia:
- **No implementan acceso real a base de datos**
- Lanzan `UnsupportedOperationException`
- Son interfaces listas para implementar con JDBC, JPA, MyBatis, o cualquier otra tecnología

### Sin Protocolo de Comunicación
Los controllers REST:
- **No tienen anotaciones HTTP** (@RestController, @GetMapping, etc.)
- Son POJOs con métodos que representan operaciones
- Listos para adaptarse a cualquier tecnología (Spring MVC, JAX-RS, Vert.x, etc.)

### Operaciones Stub
Algunas operaciones en `EjecucionController`:
- `registrarRegistrosEntrada`: Lanza `UnsupportedOperationException` para mapeo de respuesta
- `registrarResultadosCotejo`: Lanza `UnsupportedOperationException` para mapeo de respuesta
- Requieren lógica de mapeo completa según necesidades del negocio

---

## Códigos de Respuesta HTTP Estándar

Todos los endpoints implementan códigos de respuesta estandarizados:

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 207 | Multi-Status - Procesamiento parcial (algunos éxitos, algunos fallos) |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 413 | Payload Too Large - Tamaño de payload excede el límite |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

---

## Próximos Pasos

Para integrar este proyecto con tecnologías concretas:

1. **Agregar dependencias** en `pom.xml` o `build.gradle`
2. **Implementar RepositoryAdapters** con acceso real a base de datos
3. **Anotar Controllers** según framework web elegido (Spring, JAX-RS, etc.)
4. **Configurar serialización JSON** (Jackson, Gson, etc.)
5. **Implementar validaciones** de negocio en los servicios
6. **Agregar seguridad** (JWT, OAuth2)
7. **Configurar observabilidad** (logging, métricas, tracing)

---

## Versión del Documento

**Versión:** 1.0  
**Fecha:** 01/12/2025  
**Generado por:** Arquitecto de Software Senior  
**Basado en:** Especificación PDF "Microservicio MsDatosCotejoMasivo V1.0"
