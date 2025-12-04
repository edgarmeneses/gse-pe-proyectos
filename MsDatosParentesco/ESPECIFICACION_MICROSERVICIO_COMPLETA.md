# Especificación Completa - Microservicio MsDatosParentesco

## 📋 Información General

### 1. Nombre del Microservicio
**MsDatosParentesco** (Microservicio Datos Parentesco)

### 2. Versión del Documento
- **Versión**: 1.0
- **Fecha de Generación**: 01/12/2025
- **Fecha de Actualización**: 24/11/2025
- **Responsable**: Arquitecto de Software

### 3. Organización
**RENIEC** - Registro Nacional de Identificación y Estado Civil  
**Área**: Gestión de Seguridad Electrónica

---

## 🎯 Contexto de Negocio

### 1.1 Descripción del Contexto
El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

### 1.2 Propósito del Microservicio
El **Microservicio Datos Parentesco** es el componente de persistencia y acceso a datos dedicado exclusivamente al dominio del análisis de parentesco. Su propósito principal es actuar como el único intermediario entre el Microservicio Dominio Parentesco y la BD Análisis de Parentesco (schema GRAFO_TRANSACCION_GRF).

**Responsabilidades principales:**
- Almacenar registros de análisis de parentesco
- Recuperar información de análisis existentes
- Gestionar de forma segura las relaciones familiares validadas por el sistema
- Mantener la integridad de datos de parentesco entre ciudadanos

---

## 📐 Arquitectura de Referencia

### 2.1 Justificación de la Arquitectura de Microservicios

La adopción de microservicios para esta solución responde a necesidades técnicas y operativas concretas:

- **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.

- **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.

- **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.

- **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.

- **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

### 2.2 Capas de la Arquitectura

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**  
   API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer)**  
   Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer)**  
   Event Streaming para comunicación asíncrona y conectores a sistemas legados.

---

## 🔢 Versión del API

**Versión**: v1  
**Base Path**: `/api/v1/parentesco/MsDatosParentesco`

---

## 📡 Endpoints Documentados

### 3.1 Endpoint: Guardar Análisis

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/analisis`
- **Método HTTP**: `POST`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite guardar un nuevo análisis de parentesco o actualizar uno existente en el sistema.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT para autenticación del usuario |
| Content-Type | String | application/json |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad end-to-end |
| X-User-Role | String | Rol del usuario que realiza la operación |

#### Request Body
```json
{
  "idSolicitud": "string",
  "idCiudadanoConsultado": "string",
  "tipoVinculo": "string",
  "nivelComplejidad": "integer",
  "criteriosBusqueda": {
    "rangoAniosPadres": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "rangoAniosHijos": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "variacionesNombre": ["string"]
  },
  "estado": "string",
  "usuarioTecnico": "string",
  "observaciones": "string"
}
```

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Long. Mínima | Long. Máxima |
|------|----------|------|-------------|--------------|--------------|
| Identificador de Solicitud | idSolicitud | String | Sí | 5 | 50 |
| Identificador del Ciudadano | idCiudadanoConsultado | String | Sí | 5 | 30 |
| Tipo de Vínculo | tipoVinculo | String | Sí | 6 | 10 |
| Nivel de Complejidad | nivelComplejidad | Integer | Sí | NA | NA |
| Criterios de Búsqueda | criteriosBusqueda | Object | Sí | NA | NA |
| Rango de Años para Padres | criteriosBusqueda.rangoAniosPadres | Object | No | NA | NA |
| Año Inicial Padres | criteriosBusqueda.rangoAniosPadres.anioInicio | Integer | Condicional | NA | NA |
| Año Final Padres | criteriosBusqueda.rangoAniosPadres.anioFin | Integer | Condicional | NA | NA |
| Rango de Años para Hijos | criteriosBusqueda.rangoAniosHijos | Object | No | NA | NA |
| Año Inicial Hijos | criteriosBusqueda.rangoAniosHijos.anioInicio | Integer | Condicional | NA | NA |
| Año Final Hijos | criteriosBusqueda.rangoAniosHijos.anioFin | Integer | Condicional | NA | NA |
| Variaciones de Nombre | criteriosBusqueda.variacionesNombre | Array | No | NA | NA |
| Elemento de Variación | criteriosBusqueda.variacionesNombre[] | String | No | 2 | 100 |
| Estado del Análisis | estado | String | Sí | 8 | 12 |
| Usuario Técnico | usuarioTecnico | String | Sí | 3 | 50 |
| Observaciones | observaciones | String | No | 0 | 500 |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "estado": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo principal de la respuesta |
| data.idAnalisis | String | Sí | Identificador único del análisis |
| data.fechaRegistro | String (Date ISO 8601) | Sí | Fecha y hora de registro del análisis |
| data.estado | String | Sí | Estado del análisis |
| metadata | Object | Sí | Metadatos de la respuesta |
| metadata.timestamp | String (Date ISO 8601) | Sí | Fecha y hora de generación de la respuesta |
| metadata.correlationId | String | Sí | Identificador único de correlación para trazabilidad |
| metadata.version | String | Sí | Versión del servicio |
| error | Object | No | Objeto de error en caso de fallo |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Análisis guardado exitosamente |
| 400 | Bad Request | Parámetros inválidos o datos incompletos |
| 401 | Unauthorized | Token JWT inválido o ausente |
| 409 | Conflict | Ya existe un análisis activo para el ciudadano |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3.2 Endpoint: Consultar Análisis Específico

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/analisis/{idAnalisis}`
- **Método HTTP**: `GET`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite consultar un análisis de parentesco específico por su identificador.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT |
| X-Correlation-ID | UUID | Identificador único de correlación |

#### Path Parameters
| Parámetro | Tipo | Obligatorio | Long. Mínima | Long. Máxima | Descripción |
|-----------|------|-------------|--------------|--------------|-------------|
| idAnalisis | String | Sí | 1 | 50 | Identificador del análisis que se desea consultar |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "idSolicitud": "string",
    "idCiudadanoConsultado": "string",
    "tipoVinculo": "string",
    "nivelComplejidad": "integer",
    "criteriosBusqueda": {
      "rangoAniosPadres": {
        "anioInicio": "integer",
        "anioFin": "integer"
      },
      "variacionesNombre": ["string"]
    },
    "estado": "string",
    "resultadoAnalisis": "string",
    "usuarioTecnico": "string",
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ssZ",
    "observaciones": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo de datos del análisis |
| data.idAnalisis | String | Sí | ID único del análisis |
| data.idSolicitud | String | Sí | ID de la solicitud relacionada |
| data.idCiudadanoConsultado | String | Sí | DNI consultado |
| data.tipoVinculo | String | Sí | Tipo de vínculo analizado |
| data.nivelComplejidad | Integer | Sí | Nivel de complejidad |
| data.criteriosBusqueda | Object | Sí | Criterios usados |
| data.estado | String | Sí | Estado actual |
| data.resultadoAnalisis | String | No | Resultado si existe |
| data.usuarioTecnico | String | Sí | Técnico asignado |
| data.fechaCreacion | String | Sí | Fecha de creación (ISO 8601) |
| data.fechaModificacion | String | No | Fecha de modificación |
| data.observaciones | String | No | Observaciones |
| metadata.timestamp | String | Sí | Timestamp ISO 8601 |
| metadata.correlationId | String | Sí | ID de correlación |
| error | Object | No | Objeto de error en caso de fallo |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Análisis consultado exitosamente |
| 401 | Unauthorized | Token JWT inválido o ausente |
| 404 | Not Found | Análisis no encontrado |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3.3 Endpoint: Listar Análisis

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/analisis`
- **Método HTTP**: `GET`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite listar análisis de parentesco con filtros opcionales y paginación.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT |
| X-Correlation-ID | UUID | Identificador único de correlación |

#### Query Parameters

| Dato | Atributo | Tipo | Obligatorio | Long. Mínima | Long. Máxima | Descripción |
|------|----------|------|-------------|--------------|--------------|-------------|
| DNI Ciudadano | idCiudadano | String | No | 8 | 12 | Identificador del ciudadano utilizado como filtro |
| ID Solicitud | idSolicitud | String | No | 5 | 50 | Identificador de la solicitud asociada a la consulta |
| Estado | estado | String | No | 1 | 20 | Estado utilizado como criterio de filtrado |
| Tipo de vínculo | tipoVinculo | String | No | 3 | 30 | Tipo de vínculo aplicado al filtro |
| Fecha desde | fechaDesde | String (Date ISO 8601) | No | NA | NA | Fecha inicial del rango de consulta |
| Fecha hasta | fechaHasta | String (Date ISO 8601) | No | NA | NA | Fecha final del rango de consulta |
| Usuario Técnico | usuarioTecnico | String | No | 3 | 50 | Usuario técnico relacionado con la búsqueda |
| Página | pagina | Integer | No | 1 | NA | Número de página para la paginación |
| Tamaño Página | tamanioPagina | Integer | No | 1 | NA | Cantidad de registros por página |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "analisis": [
      {
        "idAnalisis": "string",
        "idSolicitud": "string",
        "idCiudadanoConsultado": "string",
        "tipoVinculo": "string",
        "nivelComplejidad": "integer",
        "estado": "string",
        "usuarioTecnico": "string",
        "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ"
      }
    ],
    "paginacion": {
      "totalRegistros": "integer",
      "totalPaginas": "integer",
      "paginaActual": "integer",
      "tamanioPagina": "integer",
      "tieneAnterior": "boolean",
      "tieneSiguiente": "boolean"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Contenedor principal de los datos de respuesta |
| metadata | Object | Sí | Metadatos técnicos de la respuesta |
| data.analisis | Array | Sí | Lista de análisis |
| data.paginacion | Object | Sí | Contiene datos de paginación |
| data.analisis[] | Object | Sí | Objeto de análisis individual |
| data.analisis[].idAnalisis | String | Sí | Identificador único del análisis |
| data.analisis[].idSolicitud | String | Sí | ID de la solicitud asociada |
| data.analisis[].idCiudadanoConsultado | String | Sí | ID del ciudadano consultado |
| data.analisis[].tipoVinculo | String | Sí | Tipo de vínculo analizado |
| data.analisis[].nivelComplejidad | Integer | Sí | Nivel de complejidad del análisis |
| data.analisis[].estado | String | Sí | Estado actual del análisis |
| data.analisis[].usuarioTecnico | String | Sí | Usuario que realizó/modificó el análisis |
| data.analisis[].fechaCreacion | String (Date ISO 8601) | Sí | Fecha de creación del análisis |
| data.paginacion.totalRegistros | Integer | Sí | Número total de registros encontrados |
| data.paginacion.totalPaginas | Integer | Sí | Número total de páginas disponibles |
| data.paginacion.paginaActual | Integer | Sí | Página actual mostrada |
| data.paginacion.tamanioPagina | Integer | Sí | Número de registros por página |
| data.paginacion.tieneAnterior | Boolean | Sí | Indica si existe página anterior |
| data.paginacion.tieneSiguiente | Boolean | Sí | Indica si existe página siguiente |
| metadata.timestamp | String | Sí | Fecha y hora de generación de la respuesta |
| metadata.correlationId | String | Sí | ID de correlación para trazabilidad |
| error | Object | No | Objeto de error en caso de fallo |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Análisis listado exitosamente |
| 400 | Bad Request | Filtros inválidos |
| 401 | Unauthorized | Token inválido |
| 500 | Internal Server Error | Error interno |

---

### 3.4 Endpoint: Actualizar Análisis

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/analisis/{idAnalisis}`
- **Método HTTP**: `PUT`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite actualizar un análisis de parentesco existente.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer {token JWT} |
| Content-Type | String | application/json |
| X-Correlation-ID | UUID | Identificador único de correlación |

#### Path Parameters
| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| idAnalisis | String | Sí | Identificador del análisis a actualizar |

#### Request Body
```json
{
  "estado": "string",
  "criteriosBusqueda": "object",
  "observaciones": "string",
  "resultadoAnalisis": "string"
}
```

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Long. Mínima | Long. Máxima |
|------|----------|------|-------------|--------------|--------------|
| Estado del Análisis | estado | String | Sí | 8 | 15 |
| Criterios de Búsqueda | criteriosBusqueda | Object | No | NA | NA |
| Observaciones Técnicas | observaciones | String | No | 0 | 1000 |
| Resultado del Análisis | resultadoAnalisis | String | Condicional | 10 | 2000 |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "estado": "string",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ssZ"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo de datos del análisis |
| data.idAnalisis | String | Sí | ID único del análisis |
| data.estado | String | Sí | Estado actual del análisis |
| data.fechaModificacion | String (Date ISO 8601) | Sí | Fecha y hora de modificación del análisis |
| metadata.timestamp | String (Date ISO 8601) | Sí | Timestamp de generación de la respuesta |
| metadata.correlationId | String | Sí | Identificador único de correlación |
| error | Object | No | Objeto de error en caso la operación falle |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código específico del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Análisis actualizado exitosamente |
| 400 | Bad Request | Parámetros inválidos |
| 404 | Not Found | Análisis no encontrado |
| 409 | Conflict | Estado no permite la actualización |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3.5 Endpoint: Registrar Relación de Parentesco

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/relaciones`
- **Método HTTP**: `POST`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite registrar una relación de parentesco confirmada entre dos ciudadanos.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer {token JWT} |
| Content-Type | String | application/json |
| X-Correlation-ID | UUID | Identificador único de correlación |

#### Request Body
```json
{
  "idAnalisis": "string",
  "idCiudadanoOrigen": "string",
  "idCiudadanoDestino": "string",
  "codigoTipoParentesco": "string",
  "gradoParentesco": "integer",
  "idActaSustento": "string",
  "idDocumentoSustento": "string",
  "fechaInicioVigencia": "YYYY-MM-DDThh:mm:ssZ",
  "observacion": "string"
}
```

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Long. Mínima | Long. Máxima |
|------|----------|------|-------------|--------------|--------------|
| ID del Análisis | idAnalisis | String | Sí | 5 | 50 |
| DNI Ciudadano Origen | idCiudadanoOrigen | String | Sí | 8 | 12 |
| DNI Ciudadano Destino | idCiudadanoDestino | String | Sí | 8 | 12 |
| Tipo de Parentesco | codigoTipoParentesco | String | Sí | 5 | 30 |
| Grado de Parentesco | gradoParentesco | Integer | Sí | 1 | 1 |
| ID Acta Sustento | idActaSustento | String | No | 5 | 50 |
| ID Documento Sustento | idDocumentoSustento | String | No | 5 | 50 |
| Fecha Inicio Vigencia | fechaInicioVigencia | String (Date ISO 8601) | No | NA | NA |
| Observación | observacion | String | No | 5 | 500 |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "idRelacion": "integer",
    "relacionInversa": {
      "idRelacion": "integer",
      "codigoTipo": "string"
    },
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo de datos de la relación registrada |
| data.idRelacion | Integer | Sí | ID único de la relación creada |
| data.relacionInversa | Object | No | Objeto con información de la relación inversa |
| data.relacionInversa.idRelacion | Integer | No | ID de la relación inversa (si aplica) |
| data.relacionInversa.codigoTipo | String | No | Código del tipo de parentesco inverso |
| data.fechaRegistro | String (Date ISO 8601) | Sí | Fecha y hora de registro de la relación |
| metadata.timestamp | String (Date ISO 8601) | Sí | Timestamp de generación de la respuesta |
| metadata.correlationId | String | Sí | Identificador único de correlación |
| error | Object | No | Objeto de error en caso la operación falle |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código específico del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Relación registrada exitosamente |
| 400 | Bad Request | Datos inválidos |
| 404 | Not Found | Análisis o ciudadano no encontrado |
| 409 | Conflict | Relación ya existe |
| 422 | Unprocessable Entity | Tipo no válido |
| 500 | Internal Server Error | Error interno |

---

### 3.6 Endpoint: Consultar Relaciones de un Ciudadano

#### Información General
- **Path**: `/api/v1/parentesco/MsDatosParentesco/relaciones`
- **Método HTTP**: `GET`
- **Protocolo**: REST/HTTP
- **API Gateway**: Interno
- **Descripción**: Endpoint que permite consultar todas las relaciones de parentesco de un ciudadano específico.

#### Headers
| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer {token JWT} |
| X-Correlation-ID | UUID | Identificador único de correlación |

#### Query Parameters

| Dato | Atributo | Tipo | Obligatorio | Long. Mínima | Long. Máxima | Descripción |
|------|----------|------|-------------|--------------|--------------|-------------|
| DNI del Ciudadano | idCiudadano | String | Sí | 8 | 12 | Identificador del ciudadano utilizado como filtro |
| Tipo de Parentesco | tipoParentesco | String | No | 3 | 30 | Tipo de parentesco aplicado al criterio de búsqueda |
| Grado Máximo | gradoMaximo | Integer | No | 1 | 2 | Grado máximo permitido para el filtro de parentesco |
| Incluir Inactivos | incluirInactivos | Boolean | No | NA | NA | Indica si deben incluirse registros inactivos en la respuesta |

#### Response Body (Success)
```json
{
  "success": "boolean",
  "data": {
    "ciudadano": {
      "idCiudadano": "string",
      "nombre": "string"
    },
    "relaciones": [
      {
        "idRelacion": "integer",
        "tipoParentesco": "string",
        "descripcionParentesco": "string",
        "gradoParentesco": "integer",
        "ciudadanoRelacionado": {
          "idCiudadano": "string",
          "nombre": "string"
        },
        "actaSustento": "string",
        "vigente": "boolean"
      }
    ],
    "totalRelaciones": "integer"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data | Object | Sí | Cuerpo con la información consultada |
| data.ciudadano | Object | Sí | Datos del ciudadano consultado |
| data.ciudadano.idCiudadano | String | Sí | DNI del ciudadano consultado |
| data.ciudadano.nombre | String | Sí | Nombre completo del ciudadano |
| data.relaciones | Array | Sí | Lista de relaciones de parentesco |
| data.relaciones[].idRelacion | Integer | Sí | ID único de la relación |
| data.relaciones[].tipoParentesco | String | Sí | Código del tipo de parentesco |
| data.relaciones[].descripcionParentesco | String | Sí | Descripción del tipo de parentesco |
| data.relaciones[].gradoParentesco | Integer | Sí | Grado de parentesco |
| data.relaciones[].ciudadanoRelacionado | Object | Sí | Datos del ciudadano relacionado |
| data.relaciones[].ciudadanoRelacionado.idCiudadano | String | Sí | DNI del ciudadano relacionado |
| data.relaciones[].ciudadanoRelacionado.nombre | String | Sí | Nombre del ciudadano relacionado |
| data.relaciones[].actaSustento | String | No | Referencia al acta de sustento |
| data.relaciones[].vigente | Boolean | Sí | Indica si la relación está vigente |
| data.totalRelaciones | Integer | Sí | Número total de relaciones encontradas |
| metadata.timestamp | String (Date ISO 8601) | Sí | Timestamp de generación de la respuesta |
| metadata.correlationId | String | Sí | Identificador único de correlación |
| error | Object | No | Objeto de error en caso la operación falle |
| error.tipo | String | No | Tipo o categoría del error |
| error.titulo | String | No | Título o descripción del error |
| error.estado | Integer | No | Código HTTP o código específico del error |
| error.errores | Array | No | Lista de errores específicos |
| error.errores[].detalleError | String | No | Detalle del error específico |

#### Response Body (Error)
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

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Relaciones consultadas exitosamente |
| 401 | Unauthorized | Token JWT inválido o ausente |
| 404 | Not Found | Ciudadano no encontrado |
| 500 | Internal Server Error | Error interno del servidor |

---

## 🗂️ Entidades / Modelos de Datos

### Modelo: Análisis de Parentesco

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| idAnalisis | String | Sí | Identificador único del análisis |
| idSolicitud | String | Sí | Identificador de la solicitud asociada |
| idCiudadanoConsultado | String | Sí | DNI del ciudadano consultado (8-30 caracteres) |
| tipoVinculo | String | Sí | Tipo de vínculo analizado (6-10 caracteres) |
| nivelComplejidad | Integer | Sí | Nivel de complejidad del análisis |
| criteriosBusqueda | CriteriosBusqueda | Sí | Criterios utilizados para el análisis |
| estado | String | Sí | Estado del análisis (8-15 caracteres) |
| resultadoAnalisis | String | No | Resultado del análisis (10-2000 caracteres) |
| usuarioTecnico | String | Sí | Usuario técnico asignado (3-50 caracteres) |
| fechaCreacion | DateTime (ISO 8601) | Sí | Fecha y hora de creación |
| fechaModificacion | DateTime (ISO 8601) | No | Fecha y hora de última modificación |
| observaciones | String | No | Observaciones técnicas (0-1000 caracteres) |

### Modelo: CriteriosBusqueda

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| rangoAniosPadres | RangoAnios | No | Rango de años para búsqueda de padres |
| rangoAniosHijos | RangoAnios | No | Rango de años para búsqueda de hijos |
| variacionesNombre | Array[String] | No | Lista de variaciones de nombre (2-100 caracteres por elemento) |

### Modelo: RangoAnios

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| anioInicio | Integer | Condicional | Año inicial del rango |
| anioFin | Integer | Condicional | Año final del rango |

### Modelo: Relación de Parentesco

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| idRelacion | Integer | Sí | Identificador único de la relación |
| idAnalisis | String | Sí | ID del análisis asociado (5-50 caracteres) |
| idCiudadanoOrigen | String | Sí | DNI del ciudadano origen (8-12 caracteres) |
| idCiudadanoDestino | String | Sí | DNI del ciudadano destino (8-12 caracteres) |
| tipoParentesco | String | Sí | Código del tipo de parentesco (3-30 caracteres) |
| descripcionParentesco | String | Sí | Descripción del tipo de parentesco |
| gradoParentesco | Integer | Sí | Grado de parentesco (1 dígito) |
| idActaSustento | String | No | ID del acta de sustento (5-50 caracteres) |
| idDocumentoSustento | String | No | ID del documento de sustento (5-50 caracteres) |
| fechaInicioVigencia | DateTime (ISO 8601) | No | Fecha de inicio de vigencia |
| fechaRegistro | DateTime (ISO 8601) | Sí | Fecha y hora de registro |
| vigente | Boolean | Sí | Indica si la relación está vigente |
| observacion | String | No | Observaciones (5-500 caracteres) |
| relacionInversa | RelacionInversa | No | Información de la relación inversa |

### Modelo: RelacionInversa

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| idRelacion | Integer | No | ID de la relación inversa |
| codigoTipo | String | No | Código del tipo de parentesco inverso |

### Modelo: Ciudadano

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| idCiudadano | String | Sí | DNI del ciudadano (8-12 caracteres) |
| nombre | String | Sí | Nombre completo del ciudadano |

### Modelo: Paginación

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| totalRegistros | Integer | Sí | Número total de registros encontrados |
| totalPaginas | Integer | Sí | Número total de páginas disponibles |
| paginaActual | Integer | Sí | Número de página actual |
| tamanioPagina | Integer | Sí | Cantidad de registros por página |
| tieneAnterior | Boolean | Sí | Indica si existe página anterior |
| tieneSiguiente | Boolean | Sí | Indica si existe página siguiente |

### Modelo: Metadata

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| timestamp | DateTime (ISO 8601) | Sí | Fecha y hora de generación de la respuesta |
| correlationId | String (UUID) | Sí | Identificador único de correlación para trazabilidad |
| version | String | No | Versión del servicio |

### Modelo: Error

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| tipo | String | No | Tipo o categoría del error |
| titulo | String | No | Título o descripción del error |
| estado | Integer | No | Código HTTP o código específico del error |
| errores | Array[DetalleError] | No | Lista de errores específicos |

### Modelo: DetalleError

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| detalleError | String | No | Detalle específico del error |

---

## 📏 Reglas de Negocio y Validaciones

### Validaciones de Entrada

1. **Validación de DNI**
   - Formato: String de 8-12 caracteres
   - Campos aplicables: `idCiudadano`, `idCiudadanoConsultado`, `idCiudadanoOrigen`, `idCiudadanoDestino`

2. **Validación de Identificadores**
   - `idSolicitud`: 5-50 caracteres
   - `idAnalisis`: 1-50 caracteres
   - `idActaSustento`: 5-50 caracteres
   - `idDocumentoSustento`: 5-50 caracteres

3. **Validación de Estado**
   - Longitud: 8-15 caracteres
   - Valores permitidos: No especificados en el documento (definidos por reglas de negocio)

4. **Validación de Tipo de Vínculo**
   - Longitud: 6-10 caracteres (para guardar)
   - Longitud: 3-30 caracteres (para filtros)

5. **Validación de Grado de Parentesco**
   - Tipo: Integer
   - Longitud: 1 dígito
   - Rango: 1-9

6. **Validación de Observaciones**
   - Guardar análisis: 0-500 caracteres
   - Actualizar análisis: 0-1000 caracteres
   - Registrar relación: 5-500 caracteres

7. **Validación de Resultado de Análisis**
   - Longitud: 10-2000 caracteres
   - Obligatorio: Condicional (según el estado del análisis)

8. **Validación de Usuario Técnico**
   - Longitud: 3-50 caracteres
   - Obligatorio: Sí

9. **Validación de Paginación**
   - `pagina`: Mínimo 1
   - `tamanioPagina`: Mínimo 1

10. **Validación de Fechas**
    - Formato: ISO 8601 (YYYY-MM-DDThh:mm:ssZ)
    - Campos: `fechaDesde`, `fechaHasta`, `fechaInicioVigencia`

### Reglas de Negocio

1. **Unicidad de Análisis**
   - Un ciudadano no puede tener múltiples análisis activos simultáneamente
   - Error 409 (Conflict) si se intenta crear un análisis duplicado

2. **Actualización de Estado**
   - No todos los estados permiten actualización
   - Validación de transiciones de estado según reglas de negocio
   - Error 409 (Conflict) si el estado no permite actualización

3. **Registro de Relaciones**
   - Requiere un análisis previo válido
   - Validación de existencia de ambos ciudadanos
   - No se permiten relaciones duplicadas (Error 409 - Conflict)
   - Validación de tipo de parentesco válido (Error 422 - Unprocessable Entity)

4. **Relación Inversa Automática**
   - Al registrar una relación de parentesco, se crea automáticamente la relación inversa
   - Ejemplo: Si A es PADRE de B, automáticamente B es HIJO de A

5. **Criterios de Búsqueda Condicionales**
   - Los rangos de años son condicionales: si se especifica un rango, tanto `anioInicio` como `anioFin` deben ser proporcionados

6. **Vigencia de Relaciones**
   - Las relaciones pueden estar activas o inactivas
   - Por defecto, solo se consultan relaciones activas
   - Parámetro `incluirInactivos` permite incluir relaciones inactivas en consultas

7. **Trazabilidad**
   - Todas las operaciones requieren `X-Correlation-ID` en el header
   - Permite trazabilidad end-to-end de las operaciones

8. **Autenticación y Autorización**
   - Todas las operaciones requieren token JWT válido
   - Error 401 (Unauthorized) si el token es inválido, ausente o expirado
   - Error 403 (Forbidden) si no se tienen permisos suficientes

---

## 🔗 Dependencias e Integraciones

### Dependencias con Otros Microservicios

1. **Microservicio Dominio Parentesco**
   - **Relación**: MsDatosParentesco actúa como capa de persistencia para el Microservicio Dominio Parentesco
   - **Tipo de Comunicación**: Síncrona (REST/HTTP)
   - **Dirección**: Dominio Parentesco → MsDatosParentesco

### Integraciones con Bases de Datos

1. **BD Análisis de Parentesco**
   - **Schema**: GRAFO_TRANSACCION_GRF
   - **Propósito**: Almacenamiento de análisis de parentesco y relaciones familiares
   - **Acceso**: Exclusivo a través de MsDatosParentesco

### Componentes de Infraestructura

1. **API Gateway (Interno)**
   - Gestión centralizada de seguridad
   - Control de throttling
   - Versionado de APIs
   - Punto único de entrada

2. **Sistema de Autenticación**
   - Validación de tokens JWT
   - Gestión de autenticación de usuarios

3. **Sistema de Logging y Monitoreo**
   - Logging centralizado
   - Distributed tracing mediante `X-Correlation-ID`
   - Métricas granulares

4. **Circuit Breaker**
   - Patrón de resiliencia
   - Prevención de cascada de fallos
   - Error 503 (Service Unavailable) cuando está abierto

---

## 📊 Códigos de Respuesta HTTP Estándar

Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP para garantizar consistencia:

| Código | Descripción | Uso |
|--------|-------------|-----|
| 200 | OK | Operación completada exitosamente |
| 201 | Created | Recurso creado exitosamente |
| 400 | Bad Request | Parámetros inválidos o datos incompletos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found | Recurso no encontrado en el sistema |
| 408 | Request Timeout | Tiempo de espera agotado al conectar |
| 409 | Conflict | Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity | Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servicio (información generalizada al exterior, detalle en logs) |
| 502 | Bad Gateway | Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable | Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout | Servicio externo no respondió en tiempo esperado |

---

## 🔒 Seguridad

### Autenticación
- **Método**: Bearer Token (JWT)
- **Header**: `Authorization: Bearer {token}`
- **Validación**: Todas las operaciones requieren token válido

### Autorización
- **Header**: `X-User-Role` (en endpoint POST /analisis)
- **Validación**: Según roles de usuario y permisos

### Trazabilidad
- **Header**: `X-Correlation-ID` (UUID)
- **Propósito**: Trazabilidad end-to-end de operaciones
- **Uso**: Obligatorio en todas las operaciones

### Rate Limiting
- **Código de Error**: 429 Too Many Requests
- **Gestión**: A nivel de API Gateway

---

## 📝 Notas Adicionales

### Formatos de Fecha
- **Estándar**: ISO 8601 (YYYY-MM-DDThh:mm:ssZ)
- **Timezone**: UTC (Z)

### Paginación
- Implementada en endpoint de listado de análisis
- Parámetros: `pagina`, `tamanioPagina`
- Metadatos completos de paginación en respuesta

### Filtros Opcionales
- Múltiples criterios de filtrado disponibles
- Filtros combinables
- Validación de parámetros de filtro (Error 400 si son inválidos)

### Base de Datos
- **Schema**: GRAFO_TRANSACCION_GRF
- **Tipo**: No especificado en el documento (inferido como base de datos relacional o de grafos)

---

## 📚 Referencias

- **Documento Fuente**: Microservicio MsDatosParentesco V1.0.pdf
- **Fecha de Generación del Documento**: 01/12/2025
- **Organismo**: RENIEC - Registro Nacional de Identificación y Estado Civil
- **Contexto**: DNI Electrónico (DNIe) - Personalización

---

**Fin de la Especificación**
