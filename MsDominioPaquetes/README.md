# MsDominioPaquetes - Microservicio de Dominio

## Descripción General

**Nombre del Microservicio:** MsDominioPaquetes  
**Tipo:** Microservicio de Dominio (MsDominio)  
**Contexto de Negocio:** Gestión de paquetes electorales para el DNI Electrónico (DNIe) de RENIEC  
**Paquete Base:** `pe.gob.reniec.padron.paquetes`  
**Versión API:** v1.0.0  
**Organización:** Registro Nacional de Identificación y Estado Civil (RENIEC) - Perú

## Contexto del Microservicio

El microservicio MsDominioPaquetes es un componente de dominio que orquesta el ciclo de vida de los paquetes electorales dentro del proceso de Gestión del Padrón Electoral. Este servicio gestiona las operaciones de consulta, aprobación y confirmación de revisión de paquetes, aplicando las reglas de negocio definidas para el proceso electoral.

**Importante:** Como microservicio de dominio, **NO define repositorios directos**. En su lugar, se integra con el componente externo **MsDatosPaquetesElectorales** a través de puertos de salida y adaptadores.

## Arquitectura

### Patrón Arquitectónico
- **Arquitectura Hexagonal (Ports & Adapters)**
- **Domain-Driven Design (DDD)**
- **Sin frameworks ni dependencias externas** (Java puro)

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/padron/paquetes/
├── domain/
│   ├── model/                           # Modelos del dominio (Aggregate Roots y Value Objects)
│   │   ├── Paquete.java
│   │   ├── Ubicacion.java
│   │   ├── InformacionPublicacion.java
│   │   ├── Aprobacion.java
│   │   ├── Trazabilidad.java
│   │   ├── Resumen.java
│   │   ├── Paginacion.java
│   │   ├── Confirmacion.java
│   │   ├── ResumenPaquetes.java
│   │   ├── SiguientePaso.java
│   │   ├── ConsultaPaquetesResult.java
│   │   ├── AprobacionResult.java
│   │   └── ConfirmacionRevisionResult.java
│   └── ports/
│       ├── in/                          # Puertos de entrada (Use Cases)
│       │   ├── ConsultarPaquetesUseCase.java
│       │   ├── AprobarPaqueteUseCase.java
│       │   └── ConfirmarRevisionPaquetesUseCase.java
│       └── out/                         # Puertos de salida (hacia MsDatosPaquetesElectorales)
│           └── PaqueteDataPort.java
├── application/
│   └── service/                         # Servicios de aplicación (implementan Use Cases)
│       ├── ConsultarPaquetesService.java
│       ├── AprobarPaqueteService.java
│       └── ConfirmarRevisionPaquetesService.java
└── infrastructure/
    └── adapters/
        ├── in/                          # Adaptadores de entrada (REST)
        │   └── rest/
        │       ├── controller/
        │       │   └── PaqueteController.java
        │       ├── dto/
        │       │   ├── AprobarPaqueteRequestDto.java
        │       │   ├── AprobarPaqueteResponseDto.java
        │       │   ├── ConfirmarRevisionRequestDto.java
        │       │   ├── ConfirmarRevisionResponseDto.java
        │       │   ├── ConsultaPaquetesResponseDto.java
        │       │   ├── PaqueteDto.java
        │       │   ├── UbicacionDto.java
        │       │   ├── InformacionPublicacionDto.java
        │       │   ├── AprobacionDto.java
        │       │   ├── ConfirmacionDto.java
        │       │   ├── ResumenDto.java
        │       │   ├── ResumenPaquetesDto.java
        │       │   ├── PaginacionDto.java
        │       │   ├── TrazabilidadDto.java
        │       │   ├── SiguientePasoDto.java
        │       │   └── MetadataDto.java
        │       └── mapper/
        │           └── PaqueteDtoMapper.java
        └── out/                         # Adaptadores de salida (hacia MsDatosPaquetesElectorales)
            └── msdata/
                └── client/
                    └── PaqueteDataAdapter.java
```

## Endpoints del Microservicio

### 1. Consultar Paquetes

**Método:** `GET`  
**Ruta:** `/api/v1/electoral/paquetes/MsDominioPaquetes`  
**Descripción:** Consulta los paquetes electorales generados para un padrón específico, con capacidad de filtrado.

**Query Parameters:**
| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| idPadron | String (UUID) | Sí | Identificador del padrón |
| tipoPadron | String | No | Tipo de padrón (longitud: 2-3) |
| codigoDepartamento | String | No | Código del departamento (longitud: 2) |
| codigoProvincia | String | No | Código de la provincia (longitud: 4) |
| codigoDistrito | String | No | Código del distrito (longitud: 6) |
| estadoPaquete | String | No | Estado del paquete (longitud: 5-20) |
| pagina | Long | No | Número de página para paginación |
| registrosPorPagina | Long | No | Cantidad de registros por página |

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "paquetes": [
      {
        "paqueteId": "string (UUID)",
        "codigoPaquete": "string",
        "idPadron": "string (UUID)",
        "tipoPadron": "string",
        "codigoCronogramaElectoral": "string",
        "tipoProcesoElectoral": "string",
        "ubicacion": {
          "codigoDepartamento": "string",
          "nombreDepartamento": "string",
          "codigoProvincia": "string",
          "nombreProvincia": "string",
          "codigoDistrito": "string",
          "nombreDistrito": "string",
          "ubigeo": "string"
        },
        "estadoPaquete": "string",
        "fechaGeneracion": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "usuarioUltimaActualizacion": "string",
        "totalCiudadanos": 0,
        "totalImagenes": 0,
        "tamanioArchivoPDF": 0,
        "tamanioArchivoDatos": 0,
        "hashIntegridad": "string",
        "rutaArchivoPDF": "string",
        "rutaArchivoDatos": "string",
        "rutaArchivoImagenes": "string",
        "informacionPublicacion": {
          "fechaPublicacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
          "lugarPublicacion": "string",
          "observaciones": "string"
        },
        "aprobacion": {
          "aprobado": false,
          "fechaAprobacion": null,
          "usuarioAprobacion": null,
          "comentarioAprobacion": null
        }
      }
    ],
    "resumen": {
      "totalPaquetes": 0,
      "paquetesAprobados": 0,
      "paquetesPendientes": 0,
      "paquetesEnRevision": 0,
      "porcentajeAvance": 0.0
    },
    "paginacion": {
      "totalRegistros": 0,
      "totalPaginas": 0,
      "paginaActual": 0,
      "registrosPorPagina": 0,
      "tieneAnterior": false,
      "tieneSiguiente": false
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string (UUID)",
    "version": "1.0.0",
    "tiempoRespuesta": "string"
  }
}
```

**Status Codes:**
| Código | Descripción |
|--------|-------------|
| 200 | Paquetes consultados exitosamente |
| 400 | Parámetros de consulta inválidos |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Usuario sin permisos para consultar paquetes |
| 404 | Padrón electoral no encontrado |
| 422 | Parámetros válidos pero inconsistentes |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servidor |
| 502 | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Servicio temporalmente no disponible |

---

### 2. Aprobar Paquete

**Método:** `PUT`  
**Ruta:** `/api/v1/electoral/paquetes/MsDominioPaquetes/{paqueteId}/aprobar`  
**Descripción:** Permite aprobar un paquete electoral específico después de verificar su contenido.

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| paqueteId | String (UUID) | Identificador único del paquete |

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina
- `X-User-Role`: ANALISTA_ELECTORAL
- `X-Idempotency-Key`: UUID para evitar duplicados

**Request Body:**
```json
{
  "informacionPublicacion": {
    "fechaPublicacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "lugarPublicacion": "string (3-200 caracteres)",
    "observaciones": "string (0-500 caracteres)"
  },
  "comentarioAprobacion": "string (0-500 caracteres)",
  "confirmarIntegridad": true
}
```

**Request Parameters:**
| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| informacionPublicacion | Object | No | Información de publicación |
| comentarioAprobacion | String | No | Comentario de la aprobación (max 500) |
| confirmarIntegridad | Boolean | Sí | Debe ser true para aprobar |

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "paqueteId": "string (UUID)",
    "codigoPaquete": "string",
    "estadoAnterior": "string",
    "estadoActual": "string",
    "aprobacion": {
      "aprobado": true,
      "fechaAprobacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "usuarioAprobacion": "string",
      "comentarioAprobacion": "string"
    },
    "informacionPublicacion": {
      "fechaPublicacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "lugarPublicacion": "string",
      "observaciones": "string"
    },
    "trazabilidad": {
      "accion": "APROBACION_PAQUETE",
      "fechaAccion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "usuarioAccion": "string",
      "ipOrigen": "string",
      "detalleAccion": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string (UUID)",
    "version": "1.0.0",
    "tiempoRespuesta": "string"
  }
}
```

**Status Codes:**
| Código | Descripción |
|--------|-------------|
| 200 | Paquete aprobado exitosamente |
| 400 | Datos inválidos o confirmarIntegridad es false |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Usuario sin rol ANALISTA_ELECTORAL |
| 404 | Paquete no encontrado |
| 409 | Paquete ya aprobado o en estado no válido |
| 422 | El paquete no cumple condiciones de negocio |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servidor |
| 502 | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Servicio temporalmente no disponible |

---

### 3. Confirmar Revisión de Paquetes

**Método:** `PUT`  
**Ruta:** `/api/v1/electoral/paquetes/MsDominioPaquetes/padron/{idPadron}/confirmar-revision`  
**Descripción:** Confirma que la revisión de todos los paquetes de un padrón ha sido completada.

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| idPadron | String (UUID) | Identificador único del padrón |

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina
- `X-User-Role`: ANALISTA_ELECTORAL
- `X-Idempotency-Key`: UUID para evitar duplicados

**Request Body:**
```json
{
  "tipoPadron": "string (2-3 caracteres)",
  "comentarioConfirmacion": "string (0-500 caracteres)",
  "confirmarRevisionCompleta": true
}
```

**Request Parameters:**
| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| tipoPadron | String | Sí | Tipo de padrón (2-3 caracteres) |
| comentarioConfirmacion | String | No | Comentario adicional (max 500) |
| confirmarRevisionCompleta | Boolean | Sí | Debe ser true para confirmar |

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "idPadron": "string (UUID)",
    "tipoPadron": "string",
    "codigoCronogramaElectoral": "string",
    "estadoRevisionAnterior": "string",
    "estadoRevisionActual": "string",
    "confirmacion": {
      "confirmado": true,
      "fechaConfirmacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "usuarioConfirmacion": "string",
      "comentarioConfirmacion": "string"
    },
    "resumenPaquetes": {
      "totalPaquetes": 0,
      "paquetesAprobados": 0,
      "porcentajeAprobacion": 100.0
    },
    "siguientePaso": {
      "accion": "GENERAR_DOCUMENTO",
      "descripcion": "string",
      "plantillaSugerida": "string"
    },
    "trazabilidad": {
      "accion": "CONFIRMACION_REVISION_PAQUETES",
      "fechaAccion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "usuarioAccion": "string",
      "ipOrigen": "string",
      "detalleAccion": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string (UUID)",
    "version": "1.0.0",
    "tiempoRespuesta": "string"
  }
}
```

**Status Codes:**
| Código | Descripción |
|--------|-------------|
| 200 | Revisión confirmada exitosamente |
| 400 | Datos inválidos o confirmarRevisionCompleta es false |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Usuario sin rol ANALISTA_ELECTORAL |
| 404 | Padrón electoral no encontrado |
| 409 | La revisión ya fue confirmada previamente |
| 422 | Existen paquetes pendientes de aprobación |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servidor |
| 502 | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Servicio temporalmente no disponible |

---

## Entidades del Dominio

### Paquete (Aggregate Root)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| paqueteId | String (UUID) | Identificador único del paquete |
| codigoPaquete | String | Código legible del paquete |
| idPadron | String (UUID) | Identificador del padrón |
| tipoPadron | String | Tipo de padrón |
| codigoCronogramaElectoral | String | Código del cronograma electoral |
| tipoProcesoElectoral | String | Tipo de proceso electoral |
| ubicacion | Ubicacion | Información geográfica |
| estadoPaquete | String | Estado actual del paquete |
| fechaGeneracion | LocalDateTime | Fecha de generación |
| fechaUltimaActualizacion | LocalDateTime | Última actualización |
| usuarioUltimaActualizacion | String | Usuario que actualizó |
| totalCiudadanos | Long | Total de ciudadanos |
| totalImagenes | Long | Total de imágenes |
| tamanioArchivoPDF | Long | Tamaño del PDF en bytes |
| tamanioArchivoDatos | Long | Tamaño de datos en bytes |
| hashIntegridad | String | Hash SHA-256 |
| rutaArchivoPDF | String | Ruta del archivo PDF |
| rutaArchivoDatos | String | Ruta del archivo de datos |
| rutaArchivoImagenes | String | Ruta de imágenes |
| informacionPublicacion | InformacionPublicacion | Info de publicación |
| aprobacion | Aprobacion | Info de aprobación |

### Ubicacion (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| codigoDepartamento | String | Código INEI departamento |
| nombreDepartamento | String | Nombre del departamento |
| codigoProvincia | String | Código INEI provincia |
| nombreProvincia | String | Nombre de la provincia |
| codigoDistrito | String | Código INEI distrito |
| nombreDistrito | String | Nombre del distrito |
| ubigeo | String | Código de ubigeo completo |

### InformacionPublicacion (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| fechaPublicacion | LocalDateTime | Fecha de publicación |
| lugarPublicacion | String | Lugar de publicación |
| observaciones | String | Observaciones adicionales |

### Aprobacion (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| aprobado | Boolean | Indica si está aprobado |
| fechaAprobacion | LocalDateTime | Fecha de aprobación |
| usuarioAprobacion | String | Usuario que aprobó |
| comentarioAprobacion | String | Comentario de aprobación |

### Trazabilidad (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| accion | String | Tipo de acción registrada |
| fechaAccion | LocalDateTime | Fecha de la acción |
| usuarioAccion | String | Usuario que ejecutó |
| ipOrigen | String | IP desde donde se ejecutó |
| detalleAccion | String | Detalle de la acción |

---

## Mapeo de Tipos

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer / int / long | Long |
| number / decimal / double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime / timestamp | LocalDateTime |
| array / list | List<T> |

---

## Características Arquitectónicas

### 1. Microservicio de Dominio
- **NO define RepositoryPort** (característica de MsData)
- Define **PaqueteDataPort** para integración con MsDatosPaquetesElectorales
- Implementa **PaqueteDataAdapter** sin tecnología específica
- El protocolo de comunicación (HTTP/SOAP/colas) debe configurarse externamente

### 2. Puertos y Adaptadores

**Puertos de Entrada (in):**
- `ConsultarPaquetesUseCase`
- `AprobarPaqueteUseCase`
- `ConfirmarRevisionPaquetesUseCase`

**Puertos de Salida (out):**
- `PaqueteDataPort` - Interface para integración con MsDatosPaquetesElectorales

**Adaptadores de Entrada:**
- `PaqueteController` - Controlador REST (POJO sin anotaciones)

**Adaptadores de Salida:**
- `PaqueteDataAdapter` - Cliente para MsDatosPaquetesElectorales (stub sin tecnología)

### 3. Servicios de Aplicación
- `ConsultarPaquetesService` - Implementa lógica de consulta
- `AprobarPaqueteService` - Implementa lógica de aprobación con validaciones
- `ConfirmarRevisionPaquetesService` - Implementa lógica de confirmación

---

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- **Sin frameworks**: No Spring, JAX-RS, JPA, etc.
- **Sin anotaciones**: Código Java puro
- **Sin protocolo definido**: La comunicación con MsDatosPaquetesElectorales debe configurarse externamente
- **Sin build configuration**: No se incluye pom.xml ni gradle

### Implementación de Comunicación
El `PaqueteDataAdapter` lanza `UnsupportedOperationException` ya que la implementación real de la comunicación con MsDatosPaquetesElectorales debe ser proporcionada mediante:
- Configuración externa
- Inyección de dependencias
- Implementación específica según el protocolo elegido (HTTP REST, SOAP, Message Queue, etc.)

### Mappers
Los métodos de mapeo en `PaqueteDtoMapper` son stubs que deben ser implementados según las necesidades específicas del proyecto.

---

## Compilación

El código está diseñado para compilar como Java puro (JDK 8+):

```bash
javac -d bin -sourcepath src/main/java src/main/java/pe/gob/reniec/padron/paquetes/**/*.java
```

---

## Integración con MsDatosPaquetesElectorales

Este microservicio de dominio **depende** del microservicio de datos **MsDatosPaquetesElectorales** para:
1. Consultar paquetes electorales
2. Aprobar paquetes
3. Confirmar revisión de paquetes

La integración se realiza a través del puerto `PaqueteDataPort` y su adaptador `PaqueteDataAdapter`, los cuales deben ser configurados con la implementación de comunicación apropiada en tiempo de despliegue.

---

## Contacto y Soporte

**Organización:** RENIEC - Registro Nacional de Identificación y Estado Civil  
**País:** Perú  
**Dominio:** Gestión de Padrón Electoral - DNI Electrónico  

---

**Documento generado:** 2025-12-01  
**Versión del documento:** 1.0  
**Versión de la especificación fuente:** 1.0
