# Especificación Técnica Completa - MsDatosRepositorioDocumental

## Información del Documento Fuente

**Documento:** Microservicio MsDatosRepositorioDocumental  
**Versión:** 1.3  
**Fecha de Generación:** 01/12/2025  
**Organización:** RENIEC - Gestión de Seguridad Electrónica  

## Control de Versiones del Documento PDF

| Versión | Fecha | Cargo | Descripción |
|---------|-------|-------|-------------|
| 1.0 | 03/11/2025 | Arquitecto de Software | Versión inicial del documento |
| 1.1 | 29/11/2025 | Control de Arquitectura | Corrección del documento basado en observaciones |
| 1.2 | 30/11/2025 | Control de Arquitectura | Revisión estructura de objetos JSON |
| 1.3 | 01/12/2025 | Documentador Técnico | Ajustes de formato y respuestas de statusCode |

## Contexto del Negocio

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

## Descripción del Microservicio

**Nombre:** MsDatosRepositorioDocumental

**Función:** Repositorio documental se encarga de la gestión centralizada de documentos digitales dentro de la plataforma SIIRC, integrándose con Alfresco como sistema de gestión documental (ECM). Este microservicio permite la carga, consulta, actualización, recuperación y eliminación de documentos, adicional a esto se debe garantizar la trazabilidad, seguridad e integridad de la información.

**Gateway:** Interno  
**Protocolo:** REST/HTTP  
**Versión API:** v1

## Arquitectura de Referencia

### Capas Principales:

1. **Capa de Exposición (API Management Layer):** API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer):** Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer):** Event Streaming para comunicación asíncrona y conectores a sistemas legados.

## Códigos de Respuesta HTTP Estándar

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Operación completada exitosamente |
| 201 | Created | Recurso creado exitosamente |
| 400 | Bad Request | Parámetros inválidos o datos incompletos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found | Recurso no encontrado en el sistema |
| 408 | Request Timeout | Tiempo de espera agotado al conectar |
| 409 | Conflict | Conflicto con el estado actual del recurso |
| 413 | Payload Too Large | Tamaño excede límite (50 MB) |
| 422 | Unprocessable Entity | Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servicio (información generalizada al exterior, detalle en logs) |
| 502 | Bad Gateway | Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable | Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout | Servicio externo no respondió en tiempo esperado |

## Headers Estándar para Todos los Endpoints

```
Content-Type: application/json
Authorization: Bearer token JWT para autenticación
X-Correlation-ID: UUID (ID de correlación para trazabilidad)
X-Office-Code: String (Código de oficina de origen, formato: ORG-LIMA-CENTRO)
```

## Detalle de Endpoints

### 1. Crear Documento

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`  
**Método:** POST  
**API Gateway:** Interno  

**Request Body:**
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {
    "estructura": {
      "nombreArchivo": "string",
      "tipoDocumento": "string",
      "descripcion": "string"
    }
  }
}
```

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| archivoBase64 | Documento.archivo | String | Sí | N/A | N/A |
| carpetaId | Carpeta.idcarpeta | String | Sí | 1 | 20 |
| metadata | Documento.metadata | Object | Sí | - | - |
| Metadata.nombreArchivo | Documento.nombre | String | Sí | 1 | 30 |
| Metadata.tipoDocumento | Documento.mimeType | String | Sí | 1 | 30 |
| Metadata.descripcion | Documento.descripcion | String | No | 1 | 300 |

**Response (201 Created):**
```json
{
  "id": "string",
  "metadata": "Documento",
  "createdAt": {
    "format": "date-time",
    "description": "formato ISO 8601 UTC (YYYY-MM-DDThh:mm:ss±hh:mm)"
  },
  "estadoDocumento": "string"
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| id | String | Sí | Numero con el que se registra la solicitud |
| estadoDocumento | String | Sí | Estado actual del documento |
| createdAt | String | Sí | Fecha de creación de la solicitud |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | ArrayObject | No | Listado de errores |

**Status Codes Específicos:**
- 201: Created - Documento creado exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar la operación
- 408: Request Timeout - Tiempo de espera agotado
- 413: Payload Too Large - Tamaño del lote excede el límite (50 MB)
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error de tiempo de espera de puerta de enlace

---

### 2. Obtener Documento Específico

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar`  
**Método:** GET  
**API Gateway:** Interno  

**Parámetros:**
```json
{
  "id": "string"
}
```

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| ID | id | String | Sí | 2 | 36 |

**Response (200 OK):**
```json
{
  "archivo": "string",
  "carpetaId": "string",
  "metadata": {},
  "estadoDocumento": "string"
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| archivo | String | Sí | Archivo solicitado en base64 |
| carpetaId | String | Sí | Carpeta id donde está el archivo |
| metadata | Object | Sí | Información del documento |
| estadoDocumento | String | Sí | Estado del documento en el sistema |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | Arrayobject | No | Listado de errores |

**Status Codes Específicos:**
- 200: OK - Documento encontrado exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar la operación
- 404: Not Found - Documento no encontrado
- 408: Request Timeout - Tiempo de espera agotado
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error de tiempo de espera de puerta de enlace

---

### 3. Actualizar Documento

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}`  
**Método:** PUT  
**API Gateway:** Interno  

**Headers:**
```
Content-Type: multipart/form-data
(resto de headers estándar)
```

**Request Body:**
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {
    "estructura": {
      "nombreArchivo": "string",
      "tipoDocumento": "string",
      "descripcion": "string"
    }
  },
  "estadoDocumento": "string"
}
```

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| id | Documento.id | String | Sí | - | - |
| archivo | Documento.archivo | String | No | - | - |
| metadata | Documento.metadata | Object | No | - | - |
| carpetaId | Carpeta.id | String | No | - | - |
| estadoDocumento | documento.status | String | No | - | - |

**Response (200 OK):**
```json
{
  "id": "string",
  "camposActualizados": [],
  "updatedAt": {
    "format": "date-time",
    "description": "formato ISO 8601 UTC (YYYY-MM-DDThh:mm:ss±hh:mm)"
  },
  "estadoDocumento": "string"
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| id | String | Sí | Registro sobre el cual se realización la actualización |
| updateAt | String | Sí | Timestamp del momento exacto cuando se registró la actualización en el sistema |
| estadoDocumento | Integer | Sí | Estado del sistema ante la operación ejecutada |
| camposActualizados | Object | Sí | Resultado de campos actualizados |
| estadoDocumento | String | Sí | Estado del documento en el sistema |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | Arrayobject | No | Listado de errores |

**Status Codes Específicos:**
- 200: OK - Documento actualizado exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar el análisis de redacción
- 404: Not Found - El documento no existe
- 408: Request Timeout - Tiempo de espera agotado
- 409: Conflict - Conflictos de versión/estado
- 413: Payload Too Large - Tamaño del lote excede el límite (50 MB)
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido (100 req/hora)
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error de tiempo de espera de puerta de enlace

---

### 4. Consultar Varios Documentos

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`  
**Método:** GET  
**API Gateway:** Interno  

**Query Parameters:**
- queryParam1 (string): Parámetro utilizado para realizar filtrado según la lógica del servicio
- queryParam2 (string): Parámetro adicional aplicado al proceso de filtrado
- queryParam3 (string): Parámetro complementario para búsquedas o filtros específicos
- page (integer): Número de página solicitado para la paginación
- size (integer): Cantidad de registros que debe retornar el servicio por página

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| page | page | Integer | Sí | 1 | - |
| size | size | Integer | Sí | 1 | - |
| queryParam1 | filterParam | String | No | 1 | 20 |
| queryParam2 | filterParam2 | String | No | 1 | 20 |
| queryParam3 | filterParam3 | String | No | 1 | 20 |

**Response (200 OK):**
```json
{
  "page": {
    "number": "integer",
    "size": "integer",
    "totalElements": "integer",
    "totalPages": "integer",
    "hasNext": "boolean"
  },
  "content": [
    {
      "documentoId": "string",
      "nombreDocumento": "string",
      "rutaDocumento": "string"
    }
  ]
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| number | Integer | Sí | Número de la Página actual |
| size | Integer | Sí | Tamaño de página actual |
| totalElements | Long | Sí | Cantidad de elementos encontrados |
| totalPages | Integer | Sí | Número total de páginas disponibles |
| hasNext | Boolean | Sí | Indica si existen más paginas disponibles después de la actual |
| content | Arrayobject | Sí | Contiene los resultados según los parámetros filtrados |
| Content.documentoId | String | Sí | Identificador del documento |
| Content.documentoNombre | String | Sí | Nombre del documento |
| Content.parentId | String | Sí | Identificador del nodo en qué se encuentra |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | Arrayobject | No | Listado de errores |

**Status Codes Específicos:**
- 200: OK - Consulta realizada exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar el análisis de redacción
- 408: Request Timeout - Tiempo de espera agotado
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error tiempo de espera en la puerta de enlace

---

### 5. Crear Carpeta

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta`  
**Método:** POST  
**API Gateway:** Interno  

**Request Body:**
```json
{
  "nombre": "string",
  "parentId": "string",
  "descripcion": "string"
}
```

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| nombre | Carpeta.nombre | String | Sí | 1 | 30 |
| parentId | Carpeta.parent | String | Sí | - | - |
| descripcion | Carpeta.descripcion | String | No | 1 | 300 |

**Response (201 Created):**
```json
{
  "id": "string",
  "createdAt": {
    "format": "date-time",
    "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
  },
  "estadoCarpeta": "string",
  "ruta": "string"
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| id | String | Sí | Registro de la creación |
| createdAt | String | Sí | Timestamp del momento exacto cuando se registró la creación en el sistema |
| estadoCarpeta | String | Sí | Estado de la carpeta |
| ruta | String | Sí | Ruta de la carpeta en el sistema |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | Arrayobject | No | Listado de errores |

**Status Codes Específicos:**
- 201: Created - Carpeta creada exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para crear carpeta
- 408: Request Timeout - Tiempo de espera agotado
- 409: Conflict - Carpeta con el mismo nombre ya existe
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error Tiempo de espera en la puerta de enlace

---

### 6. Actualizar Carpeta

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`  
**Método:** PUT  
**API Gateway:** Interno  

**Request Body:**
```json
{
  "nombre": "string",
  "estadoCarpeta": "string",
  "parentId": "string",
  "descripcion": "string"
}
```

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| nombre | Carpeta.nombre | String | No | - | - |
| id | Carpeta.identificador | String | Sí | - | - |
| estadoCarpeta | Carpeta.estado | String | No | - | - |
| parentId | Carpeta.padreId | String | No | - | - |
| descripcion | Carpeta.descripcion | String | No | - | - |

**Response (200 OK):**
```json
{
  "id": "string",
  "updateAt": {
    "type": "string",
    "format": "date-time",
    "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
  },
  "camposActualizados": []
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| id | String | Sí | Registro sobre el cual se realización la actualización |
| updateAt | String | Sí | Timestamp del momento exacto cuando se registró la actualización en el sistema |
| estadoCarpeta | String | Sí | Estado de la carpeta |
| camposActualizados | Object | Sí | Resultado de campos actualizados |
| error | Object | No | Objeto qué especifica algún error existente en la operación |
| error.tipo | String | No | Path de la ruta con error |
| error.titulo | String | No | Título del error |
| error.status | Integer | No | Número del estado de error |
| error.errores | Arrayobject | No | Listado de errores |

**Status Codes Específicos:**
- 200: OK - Carpeta actualizada exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar la actualización
- 404: Not Found - Carpeta no existe
- 408: Request Timeout - Tiempo de espera agotado
- 409: Conflict - Carpeta con el mismo nombre ya existe
- 422: Unprocessable Entity - Datos válidos pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error tiempo de espera en la puerta de enlace

---

### 7. Consultar Contenido de una Carpeta

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`  
**Método:** GET  
**API Gateway:** Interno  

**Query Parameters:**
- queryParam1 (string): Parámetro utilizado para realizar filtrado según la lógica del servicio
- queryParam2 (string): Parámetro adicional aplicado al proceso de filtrado
- queryParam3 (string): Parámetro complementario para búsquedas o filtros específicos
- page (integer): Número de página solicitado para la paginación
- size (integer): Cantidad de registros que debe retornar el servicio por página

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| page | page | Integer | Sí | 1 | - |
| size | size | Integer | Sí | 1 | - |
| id | Carpeta.id | String | Sí | 1 | 20 |
| queryParam1 | filterParam | String | No | 1 | 20 |
| queryParam2 | filterParam2 | String | No | 1 | 20 |
| queryParam3 | filterParam3 | String | No | 1 | 20 |

**Response (200 OK):**
```json
{
  "folder": {
    "id": "String",
    "metadata": {},
    "path": "String",
    "estadoCarpeta": "String",
    "createdAt": {
      "format": "date-time",
      "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
    },
    "updateAt": {
      "format": "date-time",
      "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
    }
  },
  "page": {
    "number": "Integer",
    "size": "Integer",
    "totalElements": "Integer",
    "totalPages": "Integer",
    "hasNext": "Boolean"
  },
  "contents": {
    "folders": [
      {
        "id": "String",
        "metadata": {},
        "createdAt": {
          "type": "string",
          "format": "date-time",
          "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
        }
      }
    ],
    "documents": [
      {
        "id": "String",
        "metadata": {},
        "createdAt": {
          "type": "string",
          "format": "date-time",
          "description": "(YYYY-MM-DDThh:mm:ss±hh:mm)"
        }
      }
    ]
  }
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| folder | Object | Sí | Objeto con la información de la carpeta |
| Folder.createdAt | String | Sí | Fecha de creación de la carpeta |
| Folder.id | String | Sí | Identificador de la carpeta |
| Folder.updateAt | String | Sí | Fecha de actualización de la carpeta |
| Folder.path | String | Sí | Path de la carpeta en el sistema |
| metadata | Carpeta | No | Metadata de la carpeta creada |
| Folder.estadoCarpeta | String | Sí | Estado de la carpeta en el sistema |
| Page.number | Integer | Sí | Número de la Página actual |
| Page.size | Integer | Sí | Tamaño de página actual |
| Page.totalElements | Long | Sí | Cantidad de elementos encontrados |
| Page.totalPages | Integer | Sí | Número total de páginas disponibles |
| Page.hasNext | Boolean | Sí | Indica si existen más paginas disponibles después de la actual |
| Content.folders | Arraycarpeta | No | Listado de las carpetas hijas |
| Content.folders.id | String | No | Identificador de la subcarpeta |
| Content.folders.metadatada | Carpeta | No | Metadata de la carperta |
| Content.folders.createdAt | String | No | Fecha de creación de la carpeta en el sistema |
| Content.documents | Arraydocumento | No | Información de los documentos dentro de la carpeta |
| Content.documents.id | String | No | Identificador del documento |
| Content.documents.metadatada | documento | No | Metadata del documento |
| Content.documents.createdAt | String | No | Fecha de creación del documento |

**Status Codes Específicos:**
- 200: OK - Consulta realizada exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar esta consulta
- 404: Not Found - Carpeta no existe
- 408: Request Timeout - Tiempo de espera agotado
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error tiempo de espera en la puerta de enlace

---

### 8. Consultar por Documento del Ciudadano

**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar`  
**Método:** GET  
**API Gateway:** Interno  

**Query Parameters:**
- dni (string, path): Número de DNI del ciudadano (8 dígitos)
- tipoDocumento (string, query): Filtro por tipo de documento (opcional)
- fechaDesde (string, query): Fecha inicio (ISO 8601)
- fechaHasta (string, query): Fecha fin (ISO 8601)
- estadoDocumento (string, query): Filtro por estado del documento
- page (integer, query): Número de página solicitado para la paginación
- size (integer, query): Cantidad de registros por página

**Parámetros de Entrada:**

| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| dni | Ciudadano.dni | String | Sí | 8 | 8 |
| tipoDocumento | Documento.tipoDocumento | String | No | 1 | 30 |
| fechaDesde | filterFechaDesde | String (Date ISO 8601) | No | N/A | N/A |
| fechaHasta | filterFechaHasta | String (Date ISO 8601) | No | N/A | N/A |
| estadoDocumento | Documento.estado | String | No | 1 | 20 |
| page | page | Integer | Sí | 1 | - |
| size | size | Integer | Sí | 1 | 100 |

**Response (200 OK):**
```json
{
  "ciudadano": {
    "dni": "string",
    "nombreCompleto": "string"
  },
  "page": {
    "number": "integer",
    "size": "integer",
    "totalElements": "integer",
    "totalPages": "integer",
    "hasNext": "boolean",
    "hasPrevious": "boolean"
  },
  "content": [
    {
      "documentoId": "string",
      "nombreDocumento": "string",
      "tipoDocumento": "string",
      "rutaDocumento": "string",
      "carpetaId": "string",
      "estadoDocumento": "string",
      "mimeType": "string",
      "tamanioBytes": "integer",
      "createdAt": {
        "type": "string",
        "format": "date-time",
        "description": "formato ISO 8601 UTC (YYYY-MM-DDThh:mm:ss±hh:mm)"
      },
      "updatedAt": {
        "type": "string",
        "format": "date-time",
        "description": "formato ISO 8601 UTC (YYYY-MM-DDThh:mm:ss±hh:mm)"
      }
    }
  ]
}
```

**Parámetros de Respuesta:**

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| ciudadano | Object | Sí | Objeto con información básica del ciudadano consultado |
| ciudadano.dni | String | Sí | Número de DNI del ciudadano |
| ciudadano.nombreCompleto | String | No | Nombres y apellidos del ciudadano |
| page.number | Integer | Sí | Número de la página actual |
| page.size | Integer | Sí | Tamaño de la página actual |
| page.totalElements | Long | Sí | Cantidad total de documentos encontrados |
| page.totalPages | Integer | Sí | Número total de páginas disponibles |
| page.hasNext | Boolean | Sí | Indica si existen páginas posteriores |
| page.hasPrevious | Boolean | Sí | Indica si existen páginas anteriores |
| content | Array (Object) | Sí | Colección de documentos encontrados |
| content[].documentoId | String | Sí | Identificador único del documento en Alfresco |
| content[].nombreDocumento | String | Sí | Nombre del archivo del documento |
| content[].tipoDocumento | String | Sí | Tipo o categoría del documento |
| content[].rutaDocumento | String | Sí | Ruta completa del documento en el repositorio documental |
| content[].carpetaId | String | Sí | Identificador de la carpeta donde se almacena |
| content[].estadoDocumento | String | Sí | Estado del documento |
| content[].mimeType | String | Sí | Tipo MIME del documento |
| content[].tamanioBytes | Integer | No | Tamaño del documento en bytes |
| content[].createdAt | String | Sí | Fecha de creación del documento |
| content[].updatedAt | String | No | Fecha de última actualización del documento |
| error | Object | No | Objeto de error cuando ocurre una incidencia |
| error.tipo | String | No | Path o ubicación donde ocurrió el error |
| error.titulo | String | No | Descripción corta del error |
| error.status | Integer | No | Código numérico del estado del error |
| error.errores | Array (Object) | No | Listado de errores detallados |

**Status Codes Específicos:**
- 200: OK - Consulta realizada exitosamente
- 400: Bad Request - Parámetros inválidos o estructura incorrecta
- 401: Unauthorized - Token JWT inválido, expirado o ausente
- 403: Forbidden - Sin permisos para ejecutar el análisis de redacción
- 404: Not Found - No se encontraron documentos para el DNI especificado
- 408: Request Timeout - Tiempo de espera agotado
- 422: Unprocessable Entity - Datos válidos, pero no procesables
- 429: Too Many Requests - Límite de rate limit excedido
- 500: Internal Server Error - Error interno del servicio
- 502: Bad Gateway - Servicio de Alfresco no responde
- 503: Service Unavailable - Servicio temporalmente no disponible
- 504: Gateway Timeout - Error tiempo de espera en la puerta de enlace

---

## Resumen de Operaciones Implementadas

Según el PDF, solo se deben implementar las siguientes operaciones:

1. ✅ Crear Documento (POST)
2. ✅ Obtener Documento Específico (GET)
3. ✅ Actualizar Documento (PUT)
4. ✅ Consultar Varios Documentos (GET con paginación)
5. ✅ Crear Carpeta (POST)
6. ✅ Actualizar Carpeta (PUT)
7. ✅ Consultar Contenido de Carpeta (GET)
8. ✅ Consultar Documentos por DNI (GET)

**Nota:** No se definió operación DELETE en el PDF, por lo tanto no se implementó.

---

## Estructura de Error Estándar

Todos los endpoints pueden retornar errores en el siguiente formato:

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

---

## Observaciones Finales

1. **Integración con Alfresco:** Todos los endpoints se integran con Alfresco como sistema de gestión documental (ECM)

2. **Límites de Tamaño:** Los documentos tienen un límite de 50 MB según los códigos de error 413

3. **Rate Limiting:** Se menciona límite de rate limit, específicamente 100 req/hora en el endpoint de actualización de documento

4. **Formato de Fechas:** Todas las fechas deben estar en formato ISO 8601 UTC (YYYY-MM-DDThh:mm:ss±hh:mm)

5. **Trazabilidad:** Uso de X-Correlation-ID para trazabilidad de operaciones

6. **Seguridad:** Autenticación mediante Bearer token JWT en todas las operaciones

7. **Oficinas:** Código de oficina requerido en formato ORG-LIMA-CENTRO

---

**Documento Generado:** 02 de diciembre de 2025  
**Basado en:** Microservicio MsDatosRepositorioDocumental V1.3 (01/12/2025)  
**Organización:** RENIEC - Gestión de Seguridad Electrónica
