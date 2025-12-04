# Análisis del PDF: Microservicio MsDominioPaquetes V1.0

## Información General
- **Nombre**: MsDominioPaquetes
- **Versión**: 1.0
- **Tipo**: Microservicio de Dominio
- **Fecha de Generación**: 01/12/2025
- **Fecha de Actualización**: 24/11/2025
- **Contexto**: Gestión de Seguridad Electrónica - Gestión de Padrón Electoral
- **Responsable**: Arquitecto de Software

## Contexto de Negocio

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

### Propósito del Microservicio

El **MsDominioPaquetes** es un microservicio de dominio que gestiona el ciclo de vida de los paquetes electorales dentro del proceso de Gestión de Padrón Electoral. Este servicio orquesta las operaciones de consulta, aprobación y confirmación de revisión de paquetes, aplicando las reglas de negocio definidas para el proceso electoral.

## Arquitectura y Justificación

### Justificación de la Arquitectura de Microservicios

La adopción de microservicios para esta solución responde a necesidades técnicas y operativas concretas:

- **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.
- **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.
- **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.
- **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.
- **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

### Arquitectura de Referencia

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**: API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.
2. **Capa de Representación (Microservices Layer)**: Microservicios de negocio con lógica específica de dominio y responsabilidad única.
3. **Capa de Integración (Integration Layer)**: Event Streaming para comunicación asíncrona y conectores a sistemas legados.

## Códigos de Respuesta HTTP Estándar

Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP:

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio (información generalizada al exterior, detalle en logs) |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

## Endpoints Identificados

### 1. Endpoint: Consultar Paquetes

Permite consultar los paquetes electorales generados para un padrón específico, con capacidad de filtrado por tipo de padrón, departamento, provincia, distrito y estado del paquete.

#### Detalles Técnicos
- **Método**: GET
- **Ruta**: `/api/v1/electoral/paquetes/MsDominioPaquetes`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers Requeridos
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT para autenticación del usuario |
| Content-Type | String | "application/json" |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad end-to-end |
| X-Office-Code | String | Código de oficina desde donde se realiza la operación |
| X-User-Role | String | Rol del usuario |

#### Query Parameters (Parámetros de Entrada)

| Parámetro | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-----------|------|-------------|-----------|-----------|-------------|
| idPadron | String (UUID) | Sí | 36 | 36 | Identificador del padrón utilizado como filtro |
| tipoPadron | String | No | 2 | 3 | Tipo de padrón aplicado a la consulta |
| codigoDepartamento | String | No | 2 | 2 | Código del departamento para el filtrado geográfico |
| codigoProvincia | String | No | 4 | 4 | Código de la provincia asociado a la búsqueda |
| codigoDistrito | String | No | 6 | 6 | Código del distrito utilizado como filtro |
| estadoPaquete | String | No | 5 | 20 | Estado del paquete considerado en la consulta |
| pagina | Integer | No | - | - | Número de página para la paginación |
| registrosPorPagina | Integer | No | - | - | Cantidad de registros a mostrar por página |

#### Response Body (200 OK)

```json
{
  "success": true,
  "data": {
    "paquetes": [
      {
        "paqueteId": "string",
        "codigoPaquete": "string",
        "idPadron": "string",
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
        "fechaGeneracion": "YYYY-MM-DDThh:mm:ssZ",
        "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
        "usuarioUltimaActualizacion": "string",
        "totalCiudadanos": "integer",
        "totalImagenes": "integer",
        "tamanioArchivoPDF": "integer",
        "tamanioArchivoDatos": "integer",
        "hashIntegridad": "string",
        "rutaArchivoPDF": "string",
        "rutaArchivoDatos": "string",
        "rutaArchivoImagenes": "string",
        "informacionPublicacion": {
          "fechaPublicacion": "YYYY-MM-DDThh:mm:ssZ",
          "lugarPublicacion": "string",
          "observaciones": "string"
        },
        "aprobacion": {
          "aprobado": "boolean",
          "fechaAprobacion": "YYYY-MM-DDThh:mm:ssZ",
          "usuarioAprobacion": "string",
          "comentarioAprobacion": "string"
        },
        "_links": {
          "self": "string",
          "descargar": "string",
          "aprobar": "string",
          "regenerar": "string"
        }
      }
    ],
    "resumen": {
      "totalPaquetes": "integer",
      "paquetesAprobados": "integer",
      "paquetesPendientes": "integer",
      "paquetesEnRevision": "integer",
      "porcentajeAvance": "float"
    },
    "paginacion": {
      "totalRegistros": "integer",
      "totalPaginas": "integer",
      "paginaActual": "integer",
      "registrosPorPagina": "integer",
      "tieneAnterior": "boolean",
      "tieneSiguiente": "boolean"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string",
    "tiempoRespuesta": "string"
  }
}
```

#### Estructura de Respuesta Detallada

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo principal de la respuesta |
| data.paquetes[] | Array | Sí | Lista de paquetes encontrados |
| data.paquetes[].paqueteId | String (UUID) | Sí | Identificador único del paquete |
| data.paquetes[].codigoPaquete | String | Sí | Código legible del paquete |
| data.paquetes[].idPadron | String (UUID) | Sí | Identificador del padrón al que pertenece |
| data.paquetes[].tipoPadron | String | Sí | Tipo de padrón |
| data.paquetes[].codigoCronogramaElectoral | String | Sí | Código del cronograma electoral asociado |
| data.paquetes[].tipoProcesoElectoral | String | Sí | Tipo de proceso |
| data.paquetes[].ubicacion | Object | Sí | Información geográfica del paquete |
| data.paquetes[].ubicacion.codigoDepartamento | String | Sí | Código INEI del departamento |
| data.paquetes[].ubicacion.nombreDepartamento | String | Sí | Nombre del departamento |
| data.paquetes[].ubicacion.codigoProvincia | String | Sí | Código INEI de la provincia |
| data.paquetes[].ubicacion.nombreProvincia | String | Sí | Nombre de la provincia |
| data.paquetes[].ubicacion.codigoDistrito | String | Sí | Código INEI del distrito |
| data.paquetes[].ubicacion.nombreDistrito | String | Sí | Nombre del distrito |
| data.paquetes[].ubicacion.ubigeo | String | Sí | Código de ubigeo completo |
| data.paquetes[].estadoPaquete | String | Sí | Estado actual del paquete |
| data.paquetes[].fechaGeneracion | String (Date ISO 8601) | Sí | Fecha y hora de generación del paquete |
| data.paquetes[].fechaUltimaActualizacion | String (Date ISO 8601) | Sí | Fecha y hora de última actualización |
| data.paquetes[].usuarioUltimaActualizacion | String | Sí | Usuario que realizó la última actualización |
| data.paquetes[].totalCiudadanos | Integer | Sí | Cantidad de ciudadanos en el paquete |
| data.paquetes[].totalImagenes | Integer | Sí | Cantidad de imágenes incluidas |
| data.paquetes[].tamanioArchivoPDF | Long | Sí | Tamaño del archivo PDF en bytes |
| data.paquetes[].tamanioArchivoDatos | Long | Sí | Tamaño del archivo de datos en bytes |
| data.paquetes[].hashIntegridad | String | Sí | Hash SHA-256 para verificación de integridad |
| data.paquetes[].rutaArchivoPDF | String | Sí | Ruta del archivo PDF generado |
| data.paquetes[].rutaArchivoDatos | String | Sí | Ruta del archivo de datos |
| data.paquetes[].rutaArchivoImagenes | String | Sí | Ruta del directorio de imágenes |
| data.paquetes[].informacionPublicacion | Object | No | Información de publicación del paquete |
| data.paquetes[].informacionPublicacion.fechaPublicacion | String (Date ISO 8601) | No | Fecha de publicación |
| data.paquetes[].informacionPublicacion.lugarPublicacion | String | No | Lugar de publicación |
| data.paquetes[].informacionPublicacion.observaciones | String | No | Observaciones de publicación |
| data.paquetes[].aprobacion | Object | Sí | Información de aprobación del paquete |
| data.paquetes[].aprobacion.aprobado | Boolean | Sí | Indica si el paquete está aprobado |
| data.paquetes[].aprobacion.fechaAprobacion | String (Date ISO 8601) | No | Fecha de aprobación |
| data.paquetes[].aprobacion.usuarioAprobacion | String | No | Usuario que aprobó el paquete |
| data.paquetes[].aprobacion.comentarioAprobacion | String | No | Comentario de aprobación |
| data.paquetes[]._links | Object | Sí | Hipervínculos de navegación HATEOAS |
| data.paquetes[]._links.self | String | Sí | URL del recurso actual |
| data.paquetes[]._links.descargar | String | Sí | URL para descargar el paquete |
| data.paquetes[]._links.aprobar | String | No | URL para aprobar el paquete |
| data.paquetes[]._links.regenerar | String | No | URL para regenerar el paquete |
| data.resumen | Object | Sí | Resumen estadístico de paquetes |
| data.resumen.totalPaquetes | Integer | Sí | Total de paquetes encontrados |
| data.resumen.paquetesAprobados | Integer | Sí | Cantidad de paquetes aprobados |
| data.resumen.paquetesPendientes | Integer | Sí | Cantidad de paquetes pendientes |
| data.resumen.paquetesEnRevision | Integer | Sí | Cantidad de paquetes en revisión |
| data.resumen.porcentajeAvance | Float | Sí | Porcentaje de avance de revisión |
| data.paginacion | Object | Sí | Información de paginación |
| data.paginacion.totalRegistros | Integer | Sí | Total de registros disponibles |
| data.paginacion.totalPaginas | Integer | Sí | Total de páginas |
| data.paginacion.paginaActual | Integer | Sí | Página actual |
| data.paginacion.registrosPorPagina | Integer | Sí | Registros por página |
| data.paginacion.tieneAnterior | Boolean | Sí | Indica si existe página anterior |
| data.paginacion.tieneSiguiente | Boolean | Sí | Indica si existe página siguiente |
| metadata | Object | Sí | Metadatos de la operación |
| metadata.timestamp | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| metadata.correlationId | String (UUID) | Sí | Identificador de correlación para trazabilidad |
| metadata.version | String | Sí | Versión del servicio |
| metadata.tiempoRespuesta | String | Sí | Tiempo total de respuesta |

#### Error Response

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": "integer",
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| error | Object | No | Objeto de error (presente solo en caso de fallo) |
| error.tipo | String | No | Tipo de error |
| error.titulo | String | No | Título descriptivo del error |
| error.estado | Integer | No | Código HTTP del error |
| error.errores[] | Array | No | Lista de errores detallados |
| error.errores[].detalleError | String | No | Detalle específico del error |

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Paquetes consultados exitosamente |
| 400 | Bad Request | Parámetros de consulta inválidos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Usuario sin permisos para consultar paquetes electorales |
| 404 | Not Found | Padrón electoral no encontrado |
| 422 | Unprocessable Entity | Parámetros válidos pero inconsistentes |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Service Unavailable | Servicio temporalmente no disponible |

---

### 2. Endpoint: Aprobar Paquete

Permite al Analista Electoral aprobar un paquete específico después de verificar su contenido. La aprobación registra la acción en la trazabilidad y actualiza el estado del paquete.

#### Detalles Técnicos
- **Método**: PUT
- **Ruta**: `/api/v1/electoral/paquetes/MsDominioPaquetes/{paqueteId}/aprobar`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers Requeridos
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT para autenticación del usuario |
| Content-Type | String | "application/json" |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad end-to-end |
| X-Office-Code | String | Código de oficina desde donde se realiza la operación |
| X-User-Role | String | Rol del usuario: ANALISTA_ELECTORAL |
| X-Idempotency-Key | UUID | Clave para evitar aprobaciones duplicadas |

#### Path Parameters
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| paqueteId | String (UUID) | Identificador único del paquete a aprobar |

#### Request Body

```json
{
  "informacionPublicacion": {
    "fechaPublicacion": "YYYY-MM-DDThh:mm:ssZ",
    "lugarPublicacion": "string",
    "observaciones": "string"
  },
  "comentarioAprobacion": "string",
  "confirmarIntegridad": true
}
```

#### Parámetros de Request Body

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| informacionPublicacion | Object | No | - | - | Información de Publicación |
| informacionPublicacion.fechaPublicacion | String (Date ISO 8601) | No | - | - | Fecha de Publicación |
| informacionPublicacion.lugarPublicacion | String | No | 3 | 200 | Lugar de Publicación |
| informacionPublicacion.observaciones | String | No | 0 | 500 | Observaciones |
| comentarioAprobacion | String | No | 0 | 500 | Comentario de Aprobación |
| confirmarIntegridad | Boolean | Sí | - | - | Confirmar Integridad |

#### Response Body (200 OK)

```json
{
  "success": true,
  "data": {
    "paqueteId": "string",
    "codigoPaquete": "string",
    "estadoAnterior": "string",
    "estadoActual": "string",
    "aprobacion": {
      "aprobado": "boolean",
      "fechaAprobacion": "YYYY-MM-DDThh:mm:ssZ",
      "usuarioAprobacion": "string",
      "comentarioAprobacion": "string"
    },
    "informacionPublicacion": {
      "fechaPublicacion": "YYYY-MM-DDThh:mm:ssZ",
      "lugarPublicacion": "string",
      "observaciones": "string"
    },
    "trazabilidad": {
      "accion": "string",
      "fechaAccion": "YYYY-MM-DDThh:mm:ssZ",
      "usuarioAccion": "string",
      "ipOrigen": "string",
      "detalleAccion": "string"
    },
    "_links": {
      "self": "string",
      "paquete": "string",
      "listaPaquetes": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string",
    "tiempoRespuesta": "string"
  }
}
```

#### Estructura de Respuesta Detallada

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo principal de la respuesta |
| data.paqueteId | String (UUID) | Sí | Identificador único del paquete aprobado |
| data.codigoPaquete | String | Sí | Código legible del paquete |
| data.estadoAnterior | String | Sí | Estado del paquete antes de la aprobación |
| data.estadoActual | String | Sí | Estado actual del paquete (APROBADO) |
| data.aprobacion | Object | Sí | Información de la aprobación realizada |
| data.aprobacion.aprobado | Boolean | Sí | Indica que el paquete fue aprobado |
| data.aprobacion.fechaAprobacion | String (Date ISO 8601) | Sí | Fecha y hora de la aprobación |
| data.aprobacion.usuarioAprobacion | String | Sí | Usuario que realizó la aprobación |
| data.aprobacion.comentarioAprobacion | String | No | Comentario de la aprobación |
| data.informacionPublicacion | Object | No | Información de publicación registrada |
| data.informacionPublicacion.fechaPublicacion | String (Date ISO 8601) | No | Fecha de publicación registrada |
| data.informacionPublicacion.lugarPublicacion | String | No | Lugar de publicación |
| data.informacionPublicacion.observaciones | String | No | Observaciones de publicación |
| data.trazabilidad | Object | Sí | Información de trazabilidad de la acción |
| data.trazabilidad.accion | String | Sí | Tipo de acción registrada |
| data.trazabilidad.fechaAccion | String (Date ISO 8601) | Sí | Fecha y hora de la acción |
| data.trazabilidad.usuarioAccion | String | Sí | Usuario que ejecutó la acción |
| data.trazabilidad.ipOrigen | String | Sí | Dirección IP desde donde se ejecutó |
| data.trazabilidad.detalleAccion | String | Sí | Detalle de la acción realizada |
| data._links | Object | Sí | Hipervínculos de navegación HATEOAS |
| data._links.self | String | Sí | URL de la aprobación realizada |
| data._links.paquete | String | Sí | URL del paquete aprobado |
| data._links.listaPaquetes | String | Sí | URL para regresar a la lista de paquetes |
| metadata | Object | Sí | Metadatos de la operación |
| metadata.timestamp | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| metadata.correlationId | String (UUID) | Sí | Identificador de correlación para trazabilidad |
| metadata.version | String | Sí | Versión del servicio |
| metadata.tiempoRespuesta | String | Sí | Tiempo total de respuesta |

#### Error Response

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": "integer",
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| error | Object | No | Objeto de error (presente solo en caso de fallo) |
| error.tipo | String | No | Tipo de error |
| error.titulo | String | No | Título descriptivo del error |
| error.estado | Integer | No | Código HTTP del error |
| error.errores[] | Array | No | Lista de errores detallados |
| error.errores[].detalleError | String | No | Detalle específico del error |

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Paquete aprobado exitosamente |
| 400 | Bad Request | Datos de entrada inválidos o confirmarIntegridad es false |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Usuario sin rol ANALISTA_ELECTORAL o sin permisos para aprobar |
| 404 | Not Found | Paquete no encontrado en el sistema |
| 409 | Conflict | Paquete ya se encuentra aprobado o en estado no válido para aprobación |
| 422 | Unprocessable Entity | El paquete no cumple con las condiciones de negocio para ser aprobado |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Service Unavailable | Servicio temporalmente no disponible |

---

### 3. Endpoint: Confirmar Revisión Paquetes

Permite al Analista Electoral confirmar que la revisión de todos los paquetes de un padrón ha sido completada. Este endpoint valida que todos los paquetes estén aprobados antes de permitir la confirmación y actualiza el estado general del proceso de revisión.

#### Detalles Técnicos
- **Método**: PUT
- **Ruta**: `/api/v1/electoral/paquetes/MsDominioPaquetes/padron/{idPadron}/confirmar-revision`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers Requeridos
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT para autenticación del usuario |
| Content-Type | String | "application/json" |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad end-to-end |
| X-Office-Code | String | Código de oficina desde donde se realiza la operación |
| X-User-Role | String | Rol del usuario: ANALISTA_ELECTORAL |
| X-Idempotency-Key | UUID | Clave para evitar confirmaciones duplicadas |

#### Path Parameters
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| idPadron | String (UUID) | Identificador único del padrón electoral |

#### Request Body

```json
{
  "tipoPadron": "string",
  "comentarioConfirmacion": "string",
  "confirmarRevisionCompleta": true
}
```

#### Parámetros de Request Body

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| tipoPadron | String | Sí | 2 | 3 | Tipo de Padrón |
| comentarioConfirmacion | String | No | 0 | 500 | Comentario de Confirmación |
| confirmarRevisionCompleta | Boolean | Sí | - | - | Confirmar Revisión Completa |

#### Response Body (200 OK)

```json
{
  "success": true,
  "data": {
    "idPadron": "string",
    "tipoPadron": "string",
    "codigoCronogramaElectoral": "string",
    "estadoRevisionAnterior": "string",
    "estadoRevisionActual": "string",
    "confirmacion": {
      "confirmado": "boolean",
      "fechaConfirmacion": "YYYY-MM-DDThh:mm:ssZ",
      "usuarioConfirmacion": "string",
      "comentarioConfirmacion": "string"
    },
    "resumenPaquetes": {
      "totalPaquetes": "integer",
      "paquetesAprobados": "integer",
      "porcentajeAprobacion": "float"
    },
    "siguientePaso": {
      "accion": "string",
      "descripcion": "string",
      "plantillaSugerida": "string"
    },
    "trazabilidad": {
      "accion": "string",
      "fechaAccion": "YYYY-MM-DDThh:mm:ssZ",
      "usuarioAccion": "string",
      "ipOrigen": "string",
      "detalleAccion": "string"
    },
    "_links": {
      "self": "string",
      "padron": "string",
      "paquetes": "string",
      "generarDocumento": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string",
    "tiempoRespuesta": "string"
  }
}
```

#### Estructura de Respuesta Detallada

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo principal de la respuesta |
| data.idPadron | String (UUID) | Sí | Identificador único del padrón |
| data.tipoPadron | String | Sí | Tipo de padrón confirmado |
| data.codigoCronogramaElectoral | String | Sí | Código del cronograma electoral |
| data.estadoRevisionAnterior | String | Sí | Estado de revisión antes de la confirmación |
| data.estadoRevisionActual | String | Sí | Estado de revisión actual |
| data.confirmacion | Object | Sí | Información de la confirmación realizada |
| data.confirmacion.confirmado | Boolean | Sí | Indica que la revisión fue confirmada |
| data.confirmacion.fechaConfirmacion | String (Date ISO 8601) | Sí | Fecha y hora de la confirmación |
| data.confirmacion.usuarioConfirmacion | String | Sí | Usuario que realizó la confirmación |
| data.confirmacion.comentarioConfirmacion | String | No | Comentario de la confirmación |
| data.resumenPaquetes | Object | Sí | Resumen del estado de los paquetes |
| data.resumenPaquetes.totalPaquetes | Integer | Sí | Total de paquetes del padrón |
| data.resumenPaquetes.paquetesAprobados | Integer | Sí | Cantidad de paquetes aprobados |
| data.resumenPaquetes.porcentajeAprobacion | Float | Sí | Porcentaje de aprobación |
| data.siguientePaso | Object | Sí | Información del siguiente paso del proceso |
| data.siguientePaso.accion | String | Sí | Acción sugerida como siguiente paso |
| data.siguientePaso.descripcion | String | Sí | Descripción del siguiente paso |
| data.siguientePaso.plantillaSugerida | String | Sí | Plantilla sugerida para generar el oficio |
| data.trazabilidad | Object | Sí | Información de trazabilidad de la acción |
| data.trazabilidad.accion | String | Sí | Tipo de acción registrada |
| data.trazabilidad.fechaAccion | String (Date ISO 8601) | Sí | Fecha y hora de la acción |
| data.trazabilidad.usuarioAccion | String | Sí | Usuario que ejecutó la acción |
| data.trazabilidad.ipOrigen | String | Sí | Dirección IP desde donde se ejecutó |
| data.trazabilidad.detalleAccion | String | Sí | Detalle de la acción realizada |
| data._links | Object | Sí | Hipervínculos de navegación HATEOAS |
| data._links.self | String | Sí | URL de la confirmación realizada |
| data._links.padron | String | Sí | URL del padrón electoral |
| data._links.paquetes | String | Sí | URL para consultar los paquetes |
| data._links.generarDocumento | String | Sí | URL sugerida para generar el documento de oficio |
| metadata | Object | Sí | Metadatos de la operación |
| metadata.timestamp | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| metadata.correlationId | String (UUID) | Sí | Identificador de correlación para trazabilidad |
| metadata.version | String | Sí | Versión del servicio |
| metadata.tiempoRespuesta | String | Sí | Tiempo total de respuesta |

#### Error Response

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": "integer",
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| error | Object | No | Objeto de error (presente solo en caso de fallo) |
| error.tipo | String | No | Tipo de error |
| error.titulo | String | No | Título descriptivo del error |
| error.estado | Integer | No | Código HTTP del error |
| error.errores[] | Array | No | Lista de errores detallados |
| error.errores[].detalleError | String | No | Detalle específico del error |

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Revisión de paquetes confirmada exitosamente |
| 400 | Bad Request | Datos de entrada inválidos, tipoPadron no válido o confirmarRevisionCompleta es false |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Usuario sin rol ANALISTA_ELECTORAL o sin permisos para confirmar revisión |
| 404 | Not Found | Padrón electoral no encontrado en el sistema |
| 409 | Conflict | La revisión ya fue confirmada previamente para este padrón y tipo |
| 422 | Unprocessable Entity | Existen paquetes pendientes de aprobación. La respuesta incluye la lista de paquetes pendientes |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Error de comunicación con MsDatosPaquetesElectorales |
| 503 | Service Unavailable | Servicio temporalmente no disponible |

---

## Entidades del Dominio

### PaqueteElectoral

Entidad principal que representa un paquete electoral generado para un proceso electoral específico.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| paqueteId | String (UUID) | Identificador único del paquete |
| codigoPaquete | String | Código legible del paquete |
| idPadron | String (UUID) | Identificador del padrón al que pertenece |
| tipoPadron | String | Tipo de padrón (ej: "GE", "ERM") |
| codigoCronogramaElectoral | String | Código del cronograma electoral asociado |
| tipoProcesoElectoral | String | Tipo de proceso electoral |
| ubicacion | Ubicacion | Información geográfica del paquete |
| estadoPaquete | String | Estado actual del paquete |
| fechaGeneracion | String (Date ISO 8601) | Fecha y hora de generación del paquete |
| fechaUltimaActualizacion | String (Date ISO 8601) | Fecha y hora de última actualización |
| usuarioUltimaActualizacion | String | Usuario que realizó la última actualización |
| totalCiudadanos | Integer | Cantidad de ciudadanos en el paquete |
| totalImagenes | Integer | Cantidad de imágenes incluidas |
| tamanioArchivoPDF | Long | Tamaño del archivo PDF en bytes |
| tamanioArchivoDatos | Long | Tamaño del archivo de datos en bytes |
| hashIntegridad | String | Hash SHA-256 para verificación de integridad |
| rutaArchivoPDF | String | Ruta del archivo PDF generado |
| rutaArchivoDatos | String | Ruta del archivo de datos |
| rutaArchivoImagenes | String | Ruta del directorio de imágenes |
| informacionPublicacion | InformacionPublicacion | Información de publicación del paquete |
| aprobacion | Aprobacion | Información de aprobación del paquete |

### Ubicacion

Objeto valor que representa la información geográfica de un paquete electoral.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| codigoDepartamento | String | Código INEI del departamento |
| nombreDepartamento | String | Nombre del departamento |
| codigoProvincia | String | Código INEI de la provincia |
| nombreProvincia | String | Nombre de la provincia |
| codigoDistrito | String | Código INEI del distrito |
| nombreDistrito | String | Nombre del distrito |
| ubigeo | String | Código de ubigeo completo (6 dígitos) |

### InformacionPublicacion

Objeto valor que contiene los datos de publicación de un paquete electoral.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| fechaPublicacion | String (Date ISO 8601) | Fecha de publicación |
| lugarPublicacion | String | Lugar de publicación |
| observaciones | String | Observaciones de publicación |

### Aprobacion

Objeto valor que registra la información de aprobación de un paquete electoral.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| aprobado | Boolean | Indica si el paquete está aprobado |
| fechaAprobacion | String (Date ISO 8601) | Fecha y hora de la aprobación |
| usuarioAprobacion | String | Usuario que aprobó el paquete |
| comentarioAprobacion | String | Comentario de aprobación |

### Trazabilidad

Objeto valor que registra la trazabilidad de las acciones realizadas sobre el sistema.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| accion | String | Tipo de acción registrada |
| fechaAccion | String (Date ISO 8601) | Fecha y hora de la acción |
| usuarioAccion | String | Usuario que ejecutó la acción |
| ipOrigen | String | Dirección IP desde donde se ejecutó |
| detalleAccion | String | Detalle de la acción realizada |

### ResumenPaquetes

Objeto valor que contiene estadísticas sobre los paquetes electorales.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| totalPaquetes | Integer | Total de paquetes encontrados |
| paquetesAprobados | Integer | Cantidad de paquetes aprobados |
| paquetesPendientes | Integer | Cantidad de paquetes pendientes |
| paquetesEnRevision | Integer | Cantidad de paquetes en revisión |
| porcentajeAvance | Float | Porcentaje de avance de revisión |
| porcentajeAprobacion | Float | Porcentaje de aprobación |

### Paginacion

Objeto valor que contiene información de paginación de resultados.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| totalRegistros | Integer | Total de registros disponibles |
| totalPaginas | Integer | Total de páginas |
| paginaActual | Integer | Página actual |
| registrosPorPagina | Integer | Registros por página |
| tieneAnterior | Boolean | Indica si existe página anterior |
| tieneSiguiente | Boolean | Indica si existe página siguiente |

### Confirmacion

Objeto valor que registra la confirmación de revisión de paquetes de un padrón.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| confirmado | Boolean | Indica que la revisión fue confirmada |
| fechaConfirmacion | String (Date ISO 8601) | Fecha y hora de la confirmación |
| usuarioConfirmacion | String | Usuario que realizó la confirmación |
| comentarioConfirmacion | String | Comentario de la confirmación |

### SiguientePaso

Objeto valor que sugiere el siguiente paso en el proceso de gestión de paquetes.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| accion | String | Acción sugerida como siguiente paso |
| descripcion | String | Descripción del siguiente paso |
| plantillaSugerida | String | Plantilla sugerida para generar el oficio |

### Metadata

Objeto valor que contiene metadatos de las respuestas del servicio.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| timestamp | String (Date ISO 8601) | Marca de tiempo del procesamiento |
| correlationId | String (UUID) | Identificador de correlación para trazabilidad |
| version | String | Versión del servicio |
| tiempoRespuesta | String | Tiempo total de respuesta |

### ErrorResponse

Objeto valor que representa un error en la respuesta del servicio.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| tipo | String | Tipo de error |
| titulo | String | Título descriptivo del error |
| estado | Integer | Código HTTP del error |
| errores | List<DetalleError> | Lista de errores detallados |

### DetalleError

Objeto valor que contiene el detalle de un error específico.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| detalleError | String | Detalle específico del error |

---

## Reglas de Negocio y Validaciones

### Consultar Paquetes
1. El parámetro `idPadron` es obligatorio y debe ser un UUID válido de 36 caracteres.
2. El parámetro `tipoPadron` debe tener entre 2 y 3 caracteres si se proporciona.
3. Los códigos geográficos deben cumplir con las longitudes establecidas por INEI:
   - `codigoDepartamento`: 2 caracteres
   - `codigoProvincia`: 4 caracteres
   - `codigoDistrito`: 6 caracteres
4. El parámetro `estadoPaquete` debe tener entre 5 y 20 caracteres si se proporciona.
5. La paginación es opcional, pero si se usa debe ser consistente (página >= 1, registrosPorPagina > 0).
6. El usuario debe tener permisos para consultar paquetes electorales.
7. El token JWT debe ser válido y no estar expirado.

### Aprobar Paquete
1. El `paqueteId` debe existir en el sistema.
2. El parámetro `confirmarIntegridad` debe ser `true` obligatoriamente para proceder con la aprobación.
3. El usuario debe tener el rol `ANALISTA_ELECTORAL`.
4. El paquete no debe estar previamente aprobado (validación de idempotencia).
5. El paquete debe estar en un estado válido para ser aprobado (no puede estar rechazado o anulado).
6. Si se proporciona `informacionPublicacion.lugarPublicacion`, debe tener entre 3 y 200 caracteres.
7. Si se proporciona `informacionPublicacion.observaciones`, no debe exceder 500 caracteres.
8. Si se proporciona `comentarioAprobacion`, no debe exceder 500 caracteres.
9. La fecha de publicación debe estar en formato ISO 8601 si se proporciona.
10. El header `X-Idempotency-Key` debe ser único para evitar aprobaciones duplicadas.
11. Se debe registrar la trazabilidad completa de la acción (usuario, fecha, IP, detalle).
12. Al aprobar un paquete, el estado cambia a "APROBADO".

### Confirmar Revisión Paquetes
1. El `idPadron` debe existir en el sistema.
2. El parámetro `tipoPadron` es obligatorio y debe tener entre 2 y 3 caracteres.
3. El parámetro `confirmarRevisionCompleta` debe ser `true` obligatoriamente.
4. El usuario debe tener el rol `ANALISTA_ELECTORAL`.
5. Todos los paquetes del padrón especificado deben estar aprobados antes de confirmar la revisión.
6. Si existen paquetes pendientes de aprobación, la operación debe fallar con código 422 y listar los paquetes pendientes.
7. La revisión no debe haber sido confirmada previamente para el mismo padrón y tipo (validación de conflicto).
8. Si se proporciona `comentarioConfirmacion`, no debe exceder 500 caracteres.
9. El header `X-Idempotency-Key` debe ser único para evitar confirmaciones duplicadas.
10. Se debe registrar la trazabilidad completa de la acción.
11. El sistema debe calcular el porcentaje de aprobación correctamente.
12. Debe sugerirse el siguiente paso del proceso con plantilla y descripción.

### Validaciones Generales
1. Todos los endpoints requieren autenticación mediante token JWT Bearer.
2. Los headers `X-Correlation-ID` y `X-Office-Code` son obligatorios para trazabilidad.
3. El header `X-User-Role` debe contener el rol del usuario autenticado.
4. Los UUIDs deben tener exactamente 36 caracteres con formato estándar (8-4-4-4-12).
5. Las fechas deben estar en formato ISO 8601: `YYYY-MM-DDThh:mm:ssZ`.
6. Los hash de integridad deben ser SHA-256.
7. El sistema implementa rate limiting para prevenir abuso.
8. Los errores internos deben ser generalizados al exterior pero detallados en logs.
9. Se implementan patrones Circuit Breaker para comunicación con servicios externos.
10. Todas las respuestas deben incluir hipervínculos HATEOAS para navegación.
11. Los campos opcionales pueden ser `null` o no estar presentes en la respuesta.
12. Los campos de tipo String deben ser validados para evitar inyección de código.

---

## Mapeo de Tipos

| Tipo en Documentación | Tipo Java Recomendado |
|------------------------|------------------------|
| String | String |
| String (UUID) | String (validar con patrón UUID) |
| String (Date ISO 8601) | String (validar con patrón ISO 8601) |
| Integer | Integer |
| Long | Long |
| Float | Float o Double |
| Boolean | Boolean |
| Object | Clase POJO específica |
| Array | List<T> |

---

## Operaciones por Entidad

### PaqueteElectoral
- **Consultar**: GET - Lista paquetes con filtros y paginación
- **Aprobar**: PUT - Aprueba un paquete específico por ID

### Padron (conceptual)
- **Confirmar Revisión**: PUT - Confirma que todos los paquetes de un padrón están revisados

---

## Dependencias Externas Identificadas

El microservicio **MsDominioPaquetes** tiene dependencia con:
- **MsDatosPaquetesElectorales**: Servicio de datos que almacena la información de los paquetes electorales

Los códigos de error 502 (Bad Gateway) y 503 (Service Unavailable) indican manejo de fallos en la comunicación con servicios externos.

---

## Patrones de Diseño Identificados

1. **HATEOAS**: Todas las respuestas incluyen sección `_links` con hipervínculos para navegación.
2. **Circuit Breaker**: Código 503 indica implementación de Circuit Breaker cuando servicios externos no están disponibles.
3. **Idempotencia**: Headers `X-Idempotency-Key` para evitar operaciones duplicadas en endpoints PUT.
4. **Correlation ID**: Header `X-Correlation-ID` para trazabilidad end-to-end.
5. **Paginación**: Implementación de paginación en consultas con metadatos detallados.
6. **Metadata en Respuestas**: Todas las respuestas incluyen metadata con timestamp, correlationId, version y tiempoRespuesta.
7. **Trazabilidad Completa**: Registro de usuario, fecha, IP y detalle de cada acción crítica.
8. **Separación de Concerns**: Endpoints separados por responsabilidad (consultar, aprobar, confirmar).
9. **Validación por Capas**: Validaciones en múltiples niveles (formato, negocio, estado).
10. **Error Handling Estándar**: Estructura de error consistente en todos los endpoints.

---

## Consideraciones de Seguridad

1. **Autenticación**: Token JWT Bearer obligatorio en todos los endpoints.
2. **Autorización basada en Roles**: Rol `ANALISTA_ELECTORAL` requerido para operaciones críticas.
3. **Rate Limiting**: Código 429 indica implementación de límites de tasa.
4. **Idempotencia**: Prevención de operaciones duplicadas mediante claves únicas.
5. **Integridad de Datos**: Verificación de hash SHA-256 para archivos.
6. **Trazabilidad Completa**: Registro de IP origen y usuario en todas las operaciones.
7. **Validación de Entrada**: Validación estricta de longitudes y formatos.
8. **Separación de Errores**: Errores generalizados al exterior, detallados en logs internos.
9. **Timeout Management**: Códigos 408, 504 para manejo de timeouts.
10. **Office Code Tracking**: Header `X-Office-Code` para identificar origen de operaciones.

---

## Estructura a Generar (MsDominio)

Como es un **MsDominio** (Microservicio de Dominio), debe tener:

- ✅ **Entidades de Dominio** (POJOs sin anotaciones):
  - PaqueteElectoral
  - Ubicacion
  - InformacionPublicacion
  - Aprobacion
  - Trazabilidad
  - ResumenPaquetes
  - Paginacion
  - Confirmacion
  - SiguientePaso
  - Metadata
  - ErrorResponse
  - DetalleError

- ✅ **Puertos de Entrada (Use Cases)**:
  - ConsultarPaquetesUseCase
  - AprobarPaqueteUseCase
  - ConfirmarRevisionPaquetesUseCase

- ✅ **Puertos de Salida (Interfaces de Repositorio)**:
  - PaqueteElectoralRepositoryPort
  - PadronElectoralRepositoryPort
  - TrazabilidadRepositoryPort

- ✅ **Servicios de Aplicación**:
  - ConsultarPaquetesService
  - AprobarPaqueteService
  - ConfirmarRevisionPaquetesService

- ✅ **Adaptadores REST** (Controllers, DTOs, Mappers):
  - PaqueteElectoralController
  - Request DTOs: AprobarPaqueteRequestDto, ConfirmarRevisionRequestDto
  - Response DTOs: ConsultarPaquetesResponseDto, AprobarPaqueteResponseDto, ConfirmarRevisionResponseDto
  - Mappers: PaqueteElectoralMapper

- ✅ **Adaptadores de Integración**:
  - Cliente para MsDatosPaquetesElectorales
  - Adapter para servicios externos

---

## Notas Importantes de Implementación

1. **Sin frameworks**: No usar Spring, JAX-RS, JPA u otros frameworks.
2. **Solo POJOs**: Todas las clases deben ser POJOs sin anotaciones.
3. **Interfaces puras**: Los puertos deben ser interfaces Java puras.
4. **Código compilable**: Todo el código debe ser Java puro compilable sin dependencias externas.
5. **Sin anotaciones**: Controllers, servicios, entidades y repositorios sin anotaciones.
6. **Validaciones manuales**: Implementar validaciones de longitud, formato y reglas de negocio manualmente.
7. **Manejo de errores**: Implementar manejo de errores con try-catch y validaciones explícitas.
8. **Formato de fechas**: Usar String para fechas en formato ISO 8601, validar formato manualmente.
9. **UUIDs**: Usar String para UUIDs, validar formato con regex.
10. **HATEOAS manual**: Construir los links manualmente en las respuestas.

---

## Resumen Ejecutivo

El **Microservicio MsDominioPaquetes V1.0** es un componente crítico de la arquitectura de microservicios de RENIEC para la Gestión de Padrón Electoral. Su responsabilidad principal es gestionar el ciclo de vida de los paquetes electorales, desde su consulta hasta la confirmación de revisión completa.

**Características principales**:
- 3 endpoints REST con operaciones GET y PUT
- Autenticación y autorización basada en JWT y roles
- Trazabilidad completa de todas las operaciones
- Validaciones de negocio estrictas
- Implementación de patrones de resiliencia (Circuit Breaker, Retry)
- Paginación y filtrado avanzado
- HATEOAS para navegación de recursos
- Integración con MsDatosPaquetesElectorales

**Entidades principales**:
- PaqueteElectoral (entidad agregada principal)
- Ubicacion, InformacionPublicacion, Aprobacion (objetos valor)
- Trazabilidad (auditoria)
- ResumenPaquetes, Paginacion (DTOs de soporte)

**Roles identificados**:
- ANALISTA_ELECTORAL: Rol con permisos para aprobar paquetes y confirmar revisiones

**Integración**:
- Consume servicios de MsDatosPaquetesElectorales
- Expuesto a través de API Gateway Interno
- Implementa comunicación REST/HTTP
