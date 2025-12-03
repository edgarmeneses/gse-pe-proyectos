# Microservicio MsDatosCotejoMasivo

## Resumen

**Nombre del Microservicio:** MsDatosCotejoMasivo  
**Tipo:** MsData (Microservicio de Datos)  
**Contexto de Negocio:** Gestión de Seguridad Electrónica - RENIEC  
**Paquete Base:** `pe.gob.reniec.cotejo.masivo`  
**Versión del API:** v1  
**Fecha Generación:** 01/12/2025  
**Versión Documento:** 1.0

## Descripción

El microservicio **MsDatosCotejoMasivo** es el componente de persistencia exclusivo para la gestión de datos del proceso de Cotejo Masivo. Actúa como el único intermediario autorizado para acceder a la Base de Datos de Cotejo Masivo (esquema COTEJO_MASIVO_CTJ), garantizando la integridad, trazabilidad y seguridad de los registros.

Este microservicio es un **MsData**, por lo tanto:
- **SÍ define** `RepositoryPort` y `RepositoryAdapter`
- **SÍ define** Entities (POJOs sin anotaciones)
- Gestiona la persistencia de tres entidades principales: Ejecución, RegistroEntrada y ResultadoCotejo

## Arquitectura

Este proyecto sigue los principios de **Arquitectura Hexagonal** estricta:

### Estructura de Capas

```
src/main/java/pe/gob/reniec/cotejo/masivo/
├── domain/
│   ├── model/                      # Entidades del dominio (Aggregate Roots)
│   │   ├── Ejecucion.java
│   │   ├── RegistroEntrada.java
│   │   ├── ResultadoCotejo.java
│   │   └── ResumenResultados.java
│   └── ports/
│       ├── in/                     # Puertos de entrada (Use Cases)
│       │   ├── CrearEjecucionUseCase.java
│       │   ├── ConsultarEjecucionUseCase.java
│       │   ├── ListarEjecucionesUseCase.java
│       │   ├── RegistrarRegistrosEntradaUseCase.java
│       │   └── RegistrarResultadosCotejoUseCase.java
│       └── out/                    # Puertos de salida (Repository Ports)
│           ├── EjecucionRepositoryPort.java
│           ├── RegistroEntradaRepositoryPort.java
│           └── ResultadoCotejoRepositoryPort.java
├── application/
│   └── service/                    # Servicios de aplicación
│       ├── CrearEjecucionService.java
│       ├── ConsultarEjecucionService.java
│       ├── ListarEjecucionesService.java
│       ├── RegistrarRegistrosEntradaService.java
│       └── RegistrarResultadosCotejoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/               # Adaptadores REST
        │       ├── controller/
        │       │   └── EjecucionController.java
        │       ├── dto/            # DTOs de Request/Response
        │       │   ├── CrearEjecucionRequestDto.java
        │       │   ├── EjecucionResponseDto.java
        │       │   ├── RegistrarRegistrosRequestDto.java
        │       │   ├── RegistrarRegistrosResponseDto.java
        │       │   ├── RegistrarResultadosRequestDto.java
        │       │   ├── RegistrarResultadosResponseDto.java
        │       │   ├── ListarEjecucionesResponseDto.java
        │       │   ├── ConsultarEjecucionResponseDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorDto.java
        │       └── mapper/
        │           └── EjecucionDtoMapper.java
        └── out/
            └── persistence/        # Adaptadores de persistencia
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

## Endpoints

### 1. Crear Nueva Ejecución de Cotejo

**Path:** `/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones`  
**Método:** `POST`  
**Protocolo:** REST/HTTP  
**API Gateway:** Interno

#### Headers
- `Authorization`: Bearer token JWT para autenticación del usuario
- `Content-Type`: `application/json`
- `X-Correlation-ID`: UUID (Identificador único de correlación para trazabilidad end-to-end)
- `X-Office-Code`: String (Código de oficina desde donde se realiza la operación)
- `X-User-Role`: String (Rol del usuario que realiza la operación)
- `X-Idempotency-Key`: UUID (Clave para evitar creaciones duplicadas)

#### Request Body
```json
{
  "solicitudId": "string",
  "codigoOrganizacion": "string",
  "nombreOrganizacion": "string",
  "codigoEnvio": "string",
  "numeroLote": "string",
  "totalRegistrosEntrada": "integer",
  "documentoSustento": "string",
  "observaciones": "string",
  "indicadorDomicilio": "string",
  "codigoPrograma": "string"
}
```

#### Parámetros de Entrada
| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| solicitudId | String | Sí | 36 | 36 | ID de la solicitud |
| codigoOrganizacion | String | Sí | 4 | 4 | Código de organización |
| nombreOrganizacion | String | Sí | 1 | 200 | Nombre de organización |
| codigoEnvio | String | Sí | 4 | 4 | Código de envío |
| numeroLote | String | No | 1 | 20 | Número de lote |
| totalRegistrosEntrada | Long | Sí | - | - | Total de registros esperados |
| documentoSustento | String | No | 1 | 50 | Documento de sustento |
| observaciones | String | No | 0 | 500 | Observaciones |
| indicadorDomicilio | String | No | 1 | 1 | Indicador de domicilio |
| codigoPrograma | String | No | 1 | 6 | Código de programa |

#### Response Body
```json
{
  "success": "boolean",
  "data": {
    "ejecucionId": "string",
    "solicitudId": "string",
    "codigoOrganizacion": "string",
    "nombreOrganizacion": "string",
    "codigoEnvio": "string",
    "numeroLote": "string",
    "codigoEstado": "string",
    "descripcionEstado": "string",
    "totalRegistrosEntrada": "integer",
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioCreacion": "string",
    "_links": {
      "self": "string",
      "registros": "string",
      "resultados": "string",
      "actualizarEstado": "string"
    }
  },
  "metadata": {
    "timestamp": "string",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Ejecución creada exitosamente |
| 400 | Bad Request | Datos inválidos o campos obligatorios faltantes |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para crear ejecuciones |
| 404 | Not Found | Solicitud asociada no encontrada |
| 409 | Conflict | Ya existe una ejecución activa para esta solicitud |
| 422 | Unprocessable Entity | Datos válidos pero lógica de negocio no permite procesarlos |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 503 | Service Unavailable | Servicio temporalmente no disponible |

---

### 2. Registrar Registros de Entrada (Batch)

**Path:** `/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}/registros`  
**Método:** `POST`  
**Protocolo:** REST/HTTP  
**API Gateway:** Interno

#### Headers
- `Authorization`: Bearer token JWT
- `Content-Type`: `application/json`
- `X-Correlation-ID`: UUID
- `X-Batch-Size`: Integer (Número de registros en el lote)

#### Request Body
```json
{
  "registros": [
    {
      "numeroSecuencia": "integer",
      "numeroDni": "string",
      "apellidoPaterno": "string",
      "apellidoMaterno": "string",
      "nombres": "string",
      "fechaNacimiento": "YYYY-MM-DDTHH:MM:SSZ",
      "indicadorSexo": "string",
      "identificadorInstitucion": "string",
      "datosAdicionales": {}
    }
  ]
}
```

#### Parámetros de Entrada
| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| registros | Array | Sí | 1 | 10000 | Lista de registros a insertar |
| numeroSecuencia | Long | Sí | - | - | Número de secuencia del registro |
| numeroDni | String | Sí | 8 | 8 | Número de DNI |
| apellidoPaterno | String | No | 1 | 128 | Apellido paterno |
| apellidoMaterno | String | No | 1 | 128 | Apellido materno |
| nombres | String | No | 1 | 160 | Nombres |
| fechaNacimiento | LocalDateTime | No | - | - | Fecha de nacimiento |
| indicadorSexo | String | No | 1 | 1 | Indicador de sexo |
| identificadorInstitucion | String | No | 1 | 15 | ID de institución |
| datosAdicionales | Object | No | - | - | Datos adicionales en formato JSON |

#### Response Body
```json
{
  "success": "boolean",
  "data": {
    "ejecucionId": "string",
    "totalRegistrosRecibidos": "integer",
    "totalRegistrosInsertados": "integer",
    "totalRegistrosRechazados": "integer",
    "registrosInsertados": [
      {
        "registroEntradaId": "string",
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
    "timestamp": "string",
    "correlationId": "string",
    "version": "string",
    "tiempoProcesamiento": "string"
  }
}
```

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Registros realizados exitosamente |
| 207 | Multi-Status | Algunos registros fueron insertados, otros rechazados |
| 400 | Bad Request | Datos inválidos en el request |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos |
| 404 | Not Found | Ejecución no encontrada |
| 409 | Conflict | Números de secuencia duplicados |
| 413 | Payload Too Large | Lote excede el tamaño máximo permitido |
| 422 | Unprocessable Entity | Estado de la ejecución no permite insertar registros |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3. Registrar Resultados de Cotejo (Batch)

**Path:** `/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}/resultados`  
**Método:** `POST`  
**Protocolo:** REST/HTTP  
**API Gateway:** Interno

#### Headers
- `Authorization`: Bearer token JWT
- `Content-Type`: `application/json`
- `X-Correlation-ID`: UUID
- `X-Batch-Size`: Integer

#### Request Body
```json
{
  "resultados": [
    {
      "registroEntradaId": "string",
      "codigoResultado": "string",
      "numeroDniEncontrado": "string",
      "apellidoPaternoEncontrado": "string",
      "apellidoMaternoEncontrado": "string",
      "nombresEncontrado": "string",
      "fechaNacimientoEncontrada": "YYYY-MM-DDTHH:MM:SSZ",
      "indicadorSexoEncontrado": "string",
      "codigoUbigeoDomicilio": "string",
      "descripcionDomicilio": "string",
      "estadoCivil": "string",
      "condicionCiudadano": "string",
      "fechaCaducidadDni": "YYYY-MM-DDTHH:MM:SSZ",
      "indicadorRestriccion": "string",
      "fechaRestriccion": "YYYY-MM-DDTHH:MM:SSZ",
      "coincideDni": "string",
      "coincideApellidoPaterno": "string",
      "coincideApellidoMaterno": "string",
      "coincideNombres": "string",
      "coincideFechaNacimiento": "string",
      "coincideSexo": "string",
      "mensajeObservacion": "string"
    }
  ]
}
```

#### Parámetros de Entrada
| Campo | Tipo | Obligatorio | Long. Min | Long. Max |
|-------|------|-------------|-----------|-----------|
| resultados | Array | Sí | 1 | 10000 |
| registroEntradaId | String | Sí | 36 | 36 |
| codigoResultado | String | Sí | 1 | 10 |
| numeroDniEncontrado | String | No | 8 | 8 |
| apellidoPaternoEncontrado | String | No | 1 | 128 |
| apellidoMaternoEncontrado | String | No | 1 | 128 |
| nombresEncontrado | String | No | 1 | 160 |
| fechaNacimientoEncontrada | LocalDateTime | No | - | - |
| indicadorSexoEncontrado | String | No | 1 | 1 |
| codigoUbigeoDomicilio | String | No | 6 | 6 |
| descripcionDomicilio | String | No | 1 | 200 |
| estadoCivil | String | No | 1 | 20 |
| condicionCiudadano | String | No | 1 | 20 |
| fechaCaducidadDni | LocalDateTime | No | - | - |
| indicadorRestriccion | String | No | 1 | 2 |
| fechaRestriccion | LocalDateTime | No | - | - |
| coincideDni | String | No | 1 | 1 |
| coincideApellidoPaterno | String | No | 1 | 1 |
| coincideApellidoMaterno | String | No | 1 | 1 |
| coincideNombres | String | No | 1 | 1 |
| coincideFechaNacimiento | String | No | 1 | 1 |
| coincideSexo | String | No | 1 | 1 |
| mensajeObservacion | String | No | 0 | 500 |

#### Response Body
```json
{
  "success": "boolean",
  "data": {
    "ejecucionId": "string",
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
        "registroEntradaId": "string",
        "motivoRechazo": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "string",
    "correlationId": "string",
    "version": "string",
    "tiempoProcesamiento": "string"
  }
}
```

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Resultados insertados exitosamente |
| 207 | Multi-Status | Algunos resultados insertados, otros rechazados |
| 400 | Bad Request | Datos inválidos en el request |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos |
| 404 | Not Found | Ejecución o registro de entrada no encontrado |
| 409 | Conflict | Ya existe resultado para el registro de entrada |
| 422 | Unprocessable Entity | Estado de la ejecución no permite insertar resultados |
| 500 | Internal Server Error | Error interno del servidor |

---

### 4. Listar Ejecuciones de Cotejo

**Path:** `/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones`  
**Método:** `GET`  
**Protocolo:** REST/HTTP  
**API Gateway:** Interno

#### Headers
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

#### Query Parameters
| Parámetro | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-----------|------|-------------|-----------|-----------|-------------|
| solicitudId | String | No | 36 | 36 | Filtro por ID de solicitud |
| codigoOrganizacion | String | No | 1 | 4 | Filtro por código de organización |
| codigoEnvio | String | No | 1 | 4 | Filtro por código de envío |
| codigoEstado | String | No | 1 | 10 | Filtro por código de estado |
| fechaDesde | String (ISO 8601) | No | - | - | Fecha inicial del rango |
| fechaHasta | String (ISO 8601) | No | - | - | Fecha final del rango |
| page | Integer | No | 0 | - | Número de página |
| size | Integer | No | 1 | 100 | Registros por página |
| sort | String | No | 1 | 50 | Campo de ordenamiento |
| direction | String | No | 3 | 4 | Dirección (ASC/DESC) |

#### Response Body
```json
{
  "success": "boolean",
  "data": [
    {
      "ejecucionId": "string",
      "solicitudId": "string",
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
      "fechaInicioProceso": "YYYY-MM-DDThh:mm:ssZ",
      "fechaFinProceso": "YYYY-MM-DDThh:mm:ssZ",
      "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
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
    "timestamp": "string",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Lista de ejecuciones consultada exitosamente |
| 400 | Bad Request | Parámetros de consulta inválidos |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |

---

### 5. Consultar Ejecución Específica

**Path:** `/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/{ejecucionId}`  
**Método:** `GET`  
**Protocolo:** REST/HTTP  
**API Gateway:** Interno

#### Headers
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID

#### Path Parameters
| Parámetro | Tipo | Obligatorio | Long. Min | Long. Max |
|-----------|------|-------------|-----------|-----------|
| ejecucionId | String | Sí | 36 | 36 |

#### Response Body
```json
{
  "success": "boolean",
  "data": {
    "ejecucionId": "string",
    "solicitudId": "string",
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
    "fechaInicioProceso": "string (ISO 8601)",
    "fechaFinProceso": "string (ISO 8601)",
    "documentoSustento": "string",
    "observaciones": "string",
    "urlReporteGenerado": "string (URL)",
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
    "fechaCreacion": "string (ISO 8601)",
    "usuarioCreacion": "string",
    "fechaModificacion": "string (ISO 8601)",
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
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Ejecución consultada exitosamente |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 404 | Not Found | Ejecución no encontrada |
| 500 | Internal Server Error | Error interno del servidor |

---

## Entidades del Dominio

### Ejecucion (Aggregate Root)
Representa una ejecución de cotejo masivo.

**Atributos:**
- `ejecucionId`: String
- `solicitudId`: String
- `codigoOrganizacion`: String
- `nombreOrganizacion`: String
- `codigoEnvio`: String
- `numeroLote`: String
- `codigoEstado`: String
- `descripcionEstado`: String
- `totalRegistrosEntrada`: Long
- `totalRegistrosProcesados`: Long
- `totalRegistrosCorrectos`: Long
- `totalRegistrosIncorrectos`: Long
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
Representa un registro de entrada en el cotejo masivo.

**Atributos:**
- `registroEntradaId`: String
- `ejecucionId`: String
- `numeroSecuencia`: Long
- `numeroDni`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `nombres`: String
- `fechaNacimiento`: LocalDateTime
- `indicadorSexo`: String
- `identificadorInstitucion`: String
- `datosAdicionales`: String (JSON serializado)

### ResultadoCotejo
Representa el resultado del cotejo de un registro.

**Atributos:**
- `resultadoId`: String
- `registroEntradaId`: String
- `ejecucionId`: String
- `codigoResultado`: String
- `numeroDniEncontrado`: String
- `apellidoPaternoEncontrado`: String
- `apellidoMaternoEncontrado`: String
- `nombresEncontrado`: String
- `fechaNacimientoEncontrada`: LocalDateTime
- `indicadorSexoEncontrado`: String
- `codigoUbigeoDomicilio`: String
- `descripcionDomicilio`: String
- `estadoCivil`: String
- `condicionCiudadano`: String
- `fechaCaducidadDni`: LocalDateTime
- `indicadorRestriccion`: String
- `fechaRestriccion`: LocalDateTime
- `coincideDni`: String
- `coincideApellidoPaterno`: String
- `coincideApellidoMaterno`: String
- `coincideNombres`: String
- `coincideFechaNacimiento`: String
- `coincideSexo`: String
- `mensajeObservacion`: String

### ResumenResultados (Value Object)
Objeto de valor que encapsula los totales de resultados.

**Atributos:**
- `totalCorrectos`: Long
- `totalIncorrectos`: Long
- `totalNoEncontrados`: Long
- `totalFallecidos`: Long
- `totalRestringidos`: Long
- `totalCaducados`: Long
- `totalErrores`: Long

---

## Mapeo de Tipos de Datos

Según las especificaciones del PDF y siguiendo las convenciones del prompt:

| Tipo en Especificación | Tipo Java | Notas |
|------------------------|-----------|-------|
| string | String | Para textos generales |
| integer/int | Long | Para IDs y contadores |
| number/decimal | Double | Para valores decimales |
| boolean | Boolean | Para indicadores true/false |
| date | LocalDate | Para fechas sin hora |
| datetime/timestamp | LocalDateTime | Para fechas con hora |
| YYYY-MM-DDTHH:MM:SSZ | LocalDateTime | Formato ISO 8601 |
| array/list | List<T> | Para colecciones |
| object | Object/POJO | Para estructuras anidadas |

---

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 207 | Multi-Status - Operación parcial (batch con éxitos y fallos) |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 413 | Payload Too Large - Lote excede tamaño máximo |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

---

## Características del Proyecto

### Tipo de Microservicio: MsData

Como este es un microservicio **MsData**:

✅ **SÍ incluye:**
- `RepositoryPort` interfaces (EjecucionRepositoryPort, RegistroEntradaRepositoryPort, ResultadoCotejoRepositoryPort)
- `RepositoryAdapter` implementaciones (EjecucionRepositoryAdapter, RegistroEntradaRepositoryAdapter, ResultadoCotejoRepositoryAdapter)
- Entities de persistencia (EjecucionEntity, RegistroEntradaEntity, ResultadoCotejoEntity)
- Persistence Mappers para conversión Domain ↔ Entity

❌ **NO incluye:**
- Anotaciones de frameworks (JPA, Spring, JAX-RS, etc.)
- Drivers de base de datos específicos
- Configuraciones de tecnología concreta

### Neutralidad Tecnológica

Este proyecto está diseñado para ser **completamente independiente de tecnología**:

- **Sin frameworks**: No usa Spring, Hibernate, JAX-RS, ni ningún framework específico
- **Sin anotaciones**: Todos los componentes son POJOs puros
- **Sin dependencias externas**: Código Java puro compilable sin librerías adicionales
- **Implementaciones stub**: Los métodos lanzan `UnsupportedOperationException` indicando que requieren implementación con tecnología específica

### Principios Arquitectónicos

1. **Separation of Concerns**: Cada capa tiene responsabilidades claramente definidas
2. **Dependency Inversion**: El dominio no depende de la infraestructura
3. **Single Responsibility**: Cada clase tiene una única razón de cambio
4. **Open/Closed**: Abierto a extensión, cerrado a modificación
5. **Pure Domain**: El núcleo del negocio está libre de detalles técnicos

---

## Limitaciones y Consideraciones

### Limitaciones Actuales

1. **Sin implementación de persistencia real**: Los `RepositoryAdapter` tienen métodos stub que requieren implementación con tecnología específica (JDBC, JPA, MongoDB, etc.)
2. **Sin implementación de mappers completa**: Los mappers de DTOs y Entities tienen métodos stub
3. **Sin manejo de errores específico**: No hay excepciones de dominio implementadas
4. **Sin validaciones**: Las validaciones de negocio deben implementarse según reglas específicas
5. **Sin configuración de build**: No hay `pom.xml` ni `build.gradle` (neutralidad tecnológica)

### Próximos Pasos para Implementación

Para hacer este microservicio funcional, se debe:

1. **Elegir tecnología de persistencia**: 
   - Agregar dependencias (ej: Spring Data JPA, JDBC puro, MyBatis)
   - Implementar los métodos en `RepositoryAdapter`
   - Agregar anotaciones a las `Entity` si se usa JPA

2. **Implementar mappers**:
   - Completar `EjecucionDtoMapper` para conversión Domain ↔ DTO
   - Completar `PersistenceMapper` para conversión Domain ↔ Entity

3. **Agregar framework REST**:
   - Agregar anotaciones REST al `EjecucionController` (ej: Spring MVC, JAX-RS)
   - Configurar rutas y métodos HTTP

4. **Implementar validaciones**:
   - Agregar validaciones de negocio en los servicios
   - Implementar excepciones de dominio personalizadas

5. **Configurar infraestructura**:
   - Agregar `pom.xml` o `build.gradle`
   - Configurar conexión a base de datos
   - Configurar logging y observabilidad

---

## Casos de Uso Implementados

### Casos de Uso de Entrada (Puertos IN)

1. **CrearEjecucionUseCase**: Crear nueva ejecución de cotejo
2. **ConsultarEjecucionUseCase**: Consultar ejecución por ID
3. **ListarEjecucionesUseCase**: Listar ejecuciones con filtros y paginación
4. **RegistrarRegistrosEntradaUseCase**: Registrar batch de registros de entrada
5. **RegistrarResultadosCotejoUseCase**: Registrar batch de resultados de cotejo

### Puertos de Salida (Puertos OUT)

1. **EjecucionRepositoryPort**: Operaciones CRUD sobre Ejecución
2. **RegistroEntradaRepositoryPort**: Operaciones sobre RegistroEntrada
3. **ResultadoCotejoRepositoryPort**: Operaciones sobre ResultadoCotejo

---

## Trazabilidad con Especificación

Todos los endpoints, entidades y operaciones fueron extraídos directamente del documento PDF "Microservicio MsDatosCotejoMasivo V1.0.pdf":

- ✅ Endpoint 3.1.1: Crear Nueva Ejecución de Cotejo → `CrearEjecucionUseCase`
- ✅ Endpoint 3.1.2: Registrar Registros de Entrada (Batch) → `RegistrarRegistrosEntradaUseCase`
- ✅ Endpoint 3.1.3: Registrar Resultados de Cotejo (Batch) → `RegistrarResultadosCotejoUseCase`
- ✅ Endpoint 3.1.4: Listar Ejecuciones de Cotejo → `ListarEjecucionesUseCase`
- ✅ Endpoint 3.1.5: Consultar Ejecución Específica → `ConsultarEjecucionUseCase`

**No se han agregado operaciones adicionales no especificadas en el PDF.**

---

## Compilación

El código es Java puro y puede compilarse con:

```bash
javac -d bin -sourcepath src/main/java src/main/java/pe/gob/reniec/cotejo/masivo/**/*.java
```

**Nota**: Para un proyecto funcional, se recomienda usar Maven o Gradle con las dependencias apropiadas.

---

## Contacto y Soporte

**Organización:** RENIEC - Registro Nacional de Identificación y Estado Civil  
**Área:** Gestión de Seguridad Electrónica  
**Documento Base:** Microservicio MsDatosCotejoMasivo V1.0  
**Fecha Documento:** 01/12/2025

---

## Licencia

Este proyecto es propiedad de RENIEC y está sujeto a sus políticas de uso interno.
