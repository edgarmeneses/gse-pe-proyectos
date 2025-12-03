# Especificación Completa del Microservicio MsDominioProteccionDocumentos

## INFORMACIÓN DEL DOCUMENTO
- **Documento**: Microservicio MsDominioProteccionDocumentos
- **Versión del Documento**: 1.0
- **Fecha de Generación**: 01/12/2025
- **Fecha de Actualización**: 24/11/2025
- **Responsable**: Arquitecto de Software

---

## 1. CONTEXTO DE NEGOCIO

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

---

## 2. INTRODUCCIÓN

Este documento describe el catálogo de microservicios identificados para la solución de Personalización del DNIe de RENIEC. El objetivo es establecer una arquitectura técnica moderna, escalable y mantenible que reemplace o complemente los sistemas monolíticos actuales mediante una transición ordenada hacia una arquitectura orientada a microservicios.

### 2.1 Justificación de la Arquitectura de Microservicios

La adopción de microservicios para esta solución responde a necesidades técnicas y operativas concretas:

- **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.

- **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.

- **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.

- **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.

- **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

### 2.2 Arquitectura de Referencia

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**: API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer)**: Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer)**: Event Streaming para comunicación asíncrona y conectores a sistemas legados.

### 2.3 Códigos de Respuesta HTTP Estándar

Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP para garantizar consistencia:

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

---

## 3. MICROSERVICIO: MsDominioProteccionDocumentos

### 3.1 Descripción General

El Microservicio Protección Documentos es un componente de soporte y utilidad dentro de la plataforma SIIRC, esencial para la seguridad y el manejo eficiente de archivos. Su propósito principal es implementar la política de seguridad de distribución documental, encargándose de comprimir los documentos sensibles y generar y asignar una contraseña al archivo comprimido resultante. Esto asegura que cualquier documento creado pueda ser protegido con clave de acceso al momento de su distribución, conforme a la configuración del sistema.

### 3.2 Versión del API
- **Versión**: v1
- **Path Base**: `/api/v1/documentos/MsProteccionDocumentos`

---

## 4. ENDPOINTS DEFINIDOS

### 4.1 Endpoint: Comprimir y Proteger Documento

Este endpoint permite comprimir un documento PDF firmado digitalmente y protegerlo con una contraseña generada criptográficamente.

#### Información General del Endpoint

| Atributo | Valor |
|----------|-------|
| **Path** | `/api/v1/documentos/MsProteccionDocumentos/comprimir-proteger` |
| **API Gateway** | Interno |
| **Método HTTP** | POST |
| **Protocolo** | REST/HTTP |

---

#### Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación del usuario |
| `Content-Type` | String | Sí | "application/json" |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad end-to-end |
| `X-Office-Code` | String | Sí | Código de oficina o sede desde donde se realiza la operación |
| `X-User-Role` | String | Sí | Rol del usuario que realiza la operación |
| `X-Request-Source` | String | Sí | Origen de la solicitud: WEB, MOBILE, KIOSK, API_EXTERNA |
| `X-Idempotency-Key` | UUID | Sí | Clave para evitar operaciones duplicadas |

---

#### Request Body (JSON Completo)

```json
{
  "solicitudId": "string",
  "tipoDocumento": "string",
  "nombreArchivo": "string",
  "fuenteDocumento": {
    "tipo": "string",
    "contenidoBase64": "string",
    "referenciaRepositorio": {
      "repositorioId": "string",
      "documentoId": "string",
      "versionId": "string"
    }
  },
  "metadatos": {
    "tipoTramite": "string",
    "numeroSolicitud": "string",
    "dniSolicitante": "string",
    "fechaGeneracion": "YYYY-MM-DDThh:mm:ssZ"
  },
  "configuracionProteccion": {
    "usarConfiguracionPorDefecto": "boolean",
    "algoritmoCompresion": "string",
    "nivelCompresion": "string"
  },
  "destinatario": {
    "email": "string",
    "telefono": "string",
    "nombreCompleto": "string"
  }
}
```

---

#### Response Body Exitoso (JSON Completo)

```json
{
  "success": "boolean",
  "data": {
    "proteccionId": "string",
    "solicitudId": "string",
    "archivoProtegido": {
      "repositorioId": "string",
      "documentoId": "string",
      "nombreArchivo": "string",
      "tamanioBytes": "integer",
      "formatoSalida": "string",
      "checksumSHA256": "string"
    },
    "seguridad": {
      "passwordHashSHA512": "string",
      "algoritmoUtilizado": "string",
      "longitudPassword": "integer",
      "fechaGeneracion": "YYYY-MM-DDThh:mm:ssZ",
      "fechaExpiracion": "YYYY-MM-DDThh:mm:ssZ"
    },
    "compresion": {
      "algoritmo": "string",
      "nivelCompresion": "string",
      "tamanioOriginal": "integer",
      "tamanioComprimido": "integer",
      "ratioCompresion": "number"
    },
    "estado": "string",
    "fechaProcesamiento": "YYYY-MM-DDThh:mm:ssZ",
    "_links": {
      "self": "string",
      "descargar": "string",
      "verificar": "string"
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

---

#### Error Response (JSON Completo)

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

#### Parámetros de Entrada (REQUEST) - Detalle Completo

| Dato | Atributo | Tipo | Obligatorio | Longitud Mínima | Longitud Máxima | Descripción |
|------|----------|------|-------------|-----------------|-----------------|-------------|
| ID de Solicitud | `solicitudId` | String | Sí | 36 | 36 | Identificador único de la solicitud |
| Tipo de Documento | `tipoDocumento` | String | Sí | 3 | 50 | Tipo de documento a proteger |
| Nombre del Archivo | `nombreArchivo` | String | Sí | 5 | 200 | Nombre del archivo original |
| Fuente del Documento | `fuenteDocumento` | Object | Sí | NA | NA | Objeto que define la fuente del documento |
| Tipo de Fuente | `fuenteDocumento.tipo` | String | Sí | 5 | 20 | Tipo de fuente (ej: BASE64, REPOSITORIO) |
| Contenido Base64 | `fuenteDocumento.contenidoBase64` | String | Condicional | 1 | NA | Contenido del documento codificado en Base64 (requerido si tipo=BASE64) |
| Referencia Repositorio | `fuenteDocumento.referenciaRepositorio` | Object | Condicional | NA | NA | Referencia al documento en repositorio (requerido si tipo=REPOSITORIO) |
| ID Repositorio | `fuenteDocumento.referenciaRepositorio.repositorioId` | String | Condicional | 3 | 50 | Identificador del repositorio |
| ID Documento | `fuenteDocumento.referenciaRepositorio.documentoId` | String | Condicional | 36 | 36 | Identificador del documento en el repositorio |
| ID Versión | `fuenteDocumento.referenciaRepositorio.versionId` | String | No | 1 | 20 | Identificador de la versión del documento |
| Metadatos | `metadatos` | Object | Sí | NA | NA | Metadatos del documento |
| Tipo de Trámite | `metadatos.tipoTramite` | String | Sí | 3 | 50 | Tipo de trámite asociado |
| Número de Solicitud | `metadatos.numeroSolicitud` | String | Sí | 5 | 30 | Número de solicitud del trámite |
| DNI Solicitante | `metadatos.dniSolicitante` | String | Sí | 8 | 8 | DNI del solicitante (8 dígitos) |
| Fecha Generación | `metadatos.fechaGeneracion` | String (Date ISO 8601) | Sí | NA | NA | Fecha de generación del documento |
| Configuración Protección | `configuracionProteccion` | Object | No | NA | NA | Configuración personalizada de protección |
| Usar Config. Por Defecto | `configuracionProteccion.usarConfiguracionPorDefecto` | Boolean | No | NA | NA | Indica si se usa configuración por defecto |
| Algoritmo Compresión | `configuracionProteccion.algoritmoCompresion` | String | No | 3 | 20 | Algoritmo de compresión a utilizar |
| Nivel Compresión | `configuracionProteccion.nivelCompresion` | String | No | 4 | 10 | Nivel de compresión (ej: ALTO, MEDIO, BAJO) |
| Destinatario | `destinatario` | Object | No | NA | NA | Información del destinatario |
| Email Destinatario | `destinatario.email` | String | No | 5 | 254 | Correo electrónico del destinatario |
| Teléfono Destinatario | `destinatario.telefono` | String | No | 7 | 15 | Teléfono del destinatario |
| Nombre Completo | `destinatario.nombreCompleto` | String | No | 3 | 200 | Nombre completo del destinatario |

---

#### Parámetros de Respuesta (RESPONSE) - Detalle Completo

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `success` | Boolean | Sí | Indica si la operación fue exitosa |
| `data` | Object | Sí | Cuerpo principal de la respuesta |
| `data.proteccionId` | String | Sí | UUID único de la operación de protección |
| `data.solicitudId` | String | Sí | ID de la solicitud procesada |
| `data.archivoProtegido` | Object | Sí | Información del archivo protegido generado |
| `data.archivoProtegido.repositorioId` | String | Sí | ID del repositorio donde se almacenó |
| `data.archivoProtegido.documentoId` | String | Sí | ID del documento en el repositorio |
| `data.archivoProtegido.nombreArchivo` | String | Sí | Nombre del archivo ZIP generado |
| `data.archivoProtegido.tamanioBytes` | Integer | Sí | Tamaño del archivo protegido en bytes |
| `data.archivoProtegido.formatoSalida` | String | Sí | Formato del archivo (ZIP) |
| `data.archivoProtegido.checksumSHA256` | String | Sí | Hash SHA-256 del archivo para verificación |
| `data.seguridad` | Object | Sí | Información de seguridad aplicada |
| `data.seguridad.passwordHashSHA512` | String | Sí | Hash SHA-512 de la contraseña generada |
| `data.seguridad.algoritmoUtilizado` | String | Sí | Algoritmo de cifrado aplicado |
| `data.seguridad.longitudPassword` | Integer | Sí | Longitud de la contraseña generada (16 caracteres) |
| `data.seguridad.fechaGeneracion` | String (Date ISO 8601) | Sí | Fecha de generación de la contraseña |
| `data.seguridad.fechaExpiracion` | String (Date ISO 8601) | No | Fecha de expiración de la contraseña |
| `data.compresion` | Object | Sí | Estadísticas de compresión |
| `data.compresion.algoritmo` | String | Sí | Algoritmo de compresión usado |
| `data.compresion.nivelCompresion` | String | Sí | Nivel de compresión aplicado |
| `data.compresion.tamanioOriginal` | Integer | Sí | Tamaño original del documento en bytes |
| `data.compresion.tamanioComprimido` | Integer | Sí | Tamaño después de comprimir en bytes |
| `data.compresion.ratioCompresion` | Number | Sí | Ratio de compresión logrado |
| `data.estado` | String | Sí | Estado del proceso (COMPLETADO, ERROR) |
| `data.fechaProcesamiento` | String (Date ISO 8601) | Sí | Fecha y hora del procesamiento |
| `data._links` | Object | Sí | Enlaces HATEOAS relacionados |
| `data._links.self` | String | Sí | URL del recurso actual |
| `data._links.descargar` | String | Sí | URL para descargar el archivo |
| `data._links.verificar` | String | Sí | URL para verificar integridad |
| `metadata` | Object | Sí | Metadatos de la respuesta |
| `metadata.timestamp` | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| `metadata.correlationId` | String | Sí | Identificador de correlación para trazabilidad |
| `metadata.version` | String | Sí | Versión del servicio |
| `metadata.tiempoRespuesta` | String | Sí | Tiempo total de respuesta |
| `error` | Object | No | Objeto que especifica algún error existente |
| `error.tipo` | String | No | Tipo de error |
| `error.titulo` | String | No | Título del error |
| `error.estado` | Integer | No | Código del estado de error |
| `error.errores` | Array | No | Listado de errores |
| `error.errores[].detalleError` | String | No | Detalle del error generado |

---

#### Status Codes Posibles

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Documento comprimido y protegido exitosamente |
| 400 | Bad Request | Datos inválidos o formato de documento incorrecto |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para proteger documentos |
| 404 | Not Found | Documento de origen no encontrado en repositorio |
| 409 | Conflict | El documento ya fue protegido anteriormente |
| 413 | Payload Too Large | El documento excede el tamaño máximo permitido |
| 422 | Unprocessable Entity | Documento válido pero no procesable (ej: no es PDF, no está firmado) |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Error de comunicación con MsDatosConfiguracion o MsGestorDocumentos |
| 503 | Service Unavailable | Servicio temporalmente no disponible |

---

## 5. ENTIDADES DEL DOMINIO

### 5.1 Entidad: SolicitudProteccion (Request)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `solicitudId` | String | Identificador único de la solicitud (UUID, 36 caracteres) |
| `tipoDocumento` | String | Tipo de documento a proteger (3-50 caracteres) |
| `nombreArchivo` | String | Nombre del archivo original (5-200 caracteres) |
| `fuenteDocumento` | FuenteDocumento | Objeto que define la fuente del documento |
| `metadatos` | MetadatosDocumento | Metadatos del documento |
| `configuracionProteccion` | ConfiguracionProteccion | Configuración personalizada de protección (opcional) |
| `destinatario` | Destinatario | Información del destinatario (opcional) |

### 5.2 Entidad: FuenteDocumento

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipo` | String | Tipo de fuente: "BASE64" o "REPOSITORIO" (5-20 caracteres) |
| `contenidoBase64` | String | Contenido del documento codificado en Base64 (condicional, requerido si tipo=BASE64) |
| `referenciaRepositorio` | ReferenciaRepositorio | Referencia al documento en repositorio (condicional, requerido si tipo=REPOSITORIO) |

### 5.3 Entidad: ReferenciaRepositorio

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `repositorioId` | String | Identificador del repositorio (3-50 caracteres) |
| `documentoId` | String | Identificador del documento en el repositorio (UUID, 36 caracteres) |
| `versionId` | String | Identificador de la versión del documento (1-20 caracteres, opcional) |

### 5.4 Entidad: MetadatosDocumento

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipoTramite` | String | Tipo de trámite asociado (3-50 caracteres) |
| `numeroSolicitud` | String | Número de solicitud del trámite (5-30 caracteres) |
| `dniSolicitante` | String | DNI del solicitante (8 caracteres exactos) |
| `fechaGeneracion` | DateTime (ISO 8601) | Fecha de generación del documento |

### 5.5 Entidad: ConfiguracionProteccion

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `usarConfiguracionPorDefecto` | Boolean | Indica si se usa configuración por defecto del sistema |
| `algoritmoCompresion` | String | Algoritmo de compresión a utilizar (3-20 caracteres, opcional) |
| `nivelCompresion` | String | Nivel de compresión: "ALTO", "MEDIO", "BAJO" (4-10 caracteres, opcional) |

### 5.6 Entidad: Destinatario

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `email` | String | Correo electrónico del destinatario (5-254 caracteres, opcional) |
| `telefono` | String | Teléfono del destinatario (7-15 caracteres, opcional) |
| `nombreCompleto` | String | Nombre completo del destinatario (3-200 caracteres, opcional) |

### 5.7 Entidad: RespuestaProteccion (Response Success)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `success` | Boolean | Indica si la operación fue exitosa |
| `data` | DataProteccion | Cuerpo principal de la respuesta |
| `metadata` | MetadataRespuesta | Metadatos de la respuesta |

### 5.8 Entidad: DataProteccion

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `proteccionId` | String | UUID único de la operación de protección |
| `solicitudId` | String | ID de la solicitud procesada |
| `archivoProtegido` | ArchivoProtegido | Información del archivo protegido generado |
| `seguridad` | InformacionSeguridad | Información de seguridad aplicada |
| `compresion` | EstadisticasCompresion | Estadísticas de compresión |
| `estado` | String | Estado del proceso: "COMPLETADO", "ERROR" |
| `fechaProcesamiento` | DateTime (ISO 8601) | Fecha y hora del procesamiento |
| `_links` | LinksHATEOAS | Enlaces HATEOAS relacionados |

### 5.9 Entidad: ArchivoProtegido

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `repositorioId` | String | ID del repositorio donde se almacenó |
| `documentoId` | String | ID del documento en el repositorio |
| `nombreArchivo` | String | Nombre del archivo ZIP generado |
| `tamanioBytes` | Integer | Tamaño del archivo protegido en bytes |
| `formatoSalida` | String | Formato del archivo (típicamente "ZIP") |
| `checksumSHA256` | String | Hash SHA-256 del archivo para verificación de integridad |

### 5.10 Entidad: InformacionSeguridad

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `passwordHashSHA512` | String | Hash SHA-512 de la contraseña generada |
| `algoritmoUtilizado` | String | Algoritmo de cifrado aplicado al archivo |
| `longitudPassword` | Integer | Longitud de la contraseña generada (típicamente 16 caracteres) |
| `fechaGeneracion` | DateTime (ISO 8601) | Fecha de generación de la contraseña |
| `fechaExpiracion` | DateTime (ISO 8601) | Fecha de expiración de la contraseña (opcional) |

### 5.11 Entidad: EstadisticasCompresion

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `algoritmo` | String | Algoritmo de compresión usado |
| `nivelCompresion` | String | Nivel de compresión aplicado |
| `tamanioOriginal` | Integer | Tamaño original del documento en bytes |
| `tamanioComprimido` | Integer | Tamaño después de comprimir en bytes |
| `ratioCompresion` | Number (decimal) | Ratio de compresión logrado |

### 5.12 Entidad: LinksHATEOAS

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `self` | String (URL) | URL del recurso actual |
| `descargar` | String (URL) | URL para descargar el archivo protegido |
| `verificar` | String (URL) | URL para verificar integridad del archivo |

### 5.13 Entidad: MetadataRespuesta

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `timestamp` | DateTime (ISO 8601) | Marca de tiempo del procesamiento |
| `correlationId` | String | Identificador de correlación para trazabilidad |
| `version` | String | Versión del servicio |
| `tiempoRespuesta` | String | Tiempo total de respuesta |

### 5.14 Entidad: ErrorResponse

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `error` | ErrorDetalle | Objeto que especifica el error |

### 5.15 Entidad: ErrorDetalle

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipo` | String | Tipo de error |
| `titulo` | String | Título del error |
| `estado` | Integer | Código del estado de error HTTP |
| `errores` | Array<ErrorItem> | Listado de errores específicos |

### 5.16 Entidad: ErrorItem

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `detalleError` | String | Detalle específico del error generado |

---

## 6. REGLAS DE NEGOCIO Y VALIDACIONES

### 6.1 Validaciones de Entrada

1. **Validación de solicitudId**:
   - Debe ser un UUID válido
   - Longitud exacta de 36 caracteres
   - Formato: xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx

2. **Validación de tipoDocumento**:
   - Longitud mínima: 3 caracteres
   - Longitud máxima: 50 caracteres
   - Campo obligatorio

3. **Validación de nombreArchivo**:
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 200 caracteres
   - Campo obligatorio

4. **Validación de fuenteDocumento.tipo**:
   - Valores permitidos: "BASE64", "REPOSITORIO"
   - Si tipo = "BASE64", entonces `contenidoBase64` es obligatorio
   - Si tipo = "REPOSITORIO", entonces `referenciaRepositorio` es obligatorio

5. **Validación de DNI Solicitante**:
   - Longitud exacta: 8 caracteres
   - Solo dígitos numéricos
   - Campo obligatorio

6. **Validación de Formato de Documento**:
   - El documento debe ser un PDF válido
   - El documento debe estar firmado digitalmente
   - Si no cumple, retornar error 422 (Unprocessable Entity)

7. **Validación de Tamaño de Documento**:
   - Si el documento excede el tamaño máximo permitido, retornar error 413 (Payload Too Large)

8. **Validación de Duplicidad**:
   - Si el documento ya fue protegido anteriormente, retornar error 409 (Conflict)
   - Usar `X-Idempotency-Key` para evitar operaciones duplicadas

9. **Validación de Email** (si se proporciona):
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 254 caracteres
   - Formato válido de email

10. **Validación de Teléfono** (si se proporciona):
    - Longitud mínima: 7 caracteres
    - Longitud máxima: 15 caracteres

### 6.2 Reglas de Negocio

1. **Generación de Contraseña**:
   - La contraseña debe ser generada criptográficamente
   - Longitud fija de 16 caracteres
   - Debe almacenarse el hash SHA-512 de la contraseña
   - La contraseña real debe enviarse al destinatario (no almacenar en texto plano)

2. **Compresión de Documentos**:
   - Si `usarConfiguracionPorDefecto` es `true`, usar la configuración del sistema
   - Si es `false`, usar los parámetros `algoritmoCompresion` y `nivelCompresion` proporcionados
   - El formato de salida siempre es ZIP

3. **Almacenamiento del Archivo Protegido**:
   - El archivo comprimido y protegido debe almacenarse en el repositorio especificado
   - Generar un `checksumSHA256` para verificación de integridad
   - Retornar las referencias: `repositorioId`, `documentoId`

4. **Política de Seguridad de Distribución Documental**:
   - Todos los documentos sensibles deben ser comprimidos
   - Todos los documentos sensibles deben estar protegidos con contraseña
   - La contraseña debe cumplir con la política de seguridad del sistema

5. **Trazabilidad**:
   - Usar `X-Correlation-ID` para trazabilidad end-to-end
   - Registrar `X-Office-Code` para auditoría de origen
   - Registrar `X-User-Role` para control de permisos
   - Registrar `X-Request-Source` para análisis de canales

6. **Autenticación y Autorización**:
   - Validar Bearer token JWT en header `Authorization`
   - Verificar que el usuario tiene permisos para proteger documentos
   - Si no está autenticado: retornar 401 (Unauthorized)
   - Si no tiene permisos: retornar 403 (Forbidden)

7. **Rate Limiting**:
   - Implementar límite de solicitudes por usuario/IP
   - Si se excede el límite: retornar 429 (Too Many Requests)

8. **Estado del Proceso**:
   - Estados posibles: "COMPLETADO", "ERROR"
   - El estado debe reflejarse en `data.estado`

9. **Enlaces HATEOAS**:
   - Proporcionar enlaces navegables en `_links`
   - `self`: URL del recurso actual
   - `descargar`: URL para descargar el archivo protegido
   - `verificar`: URL para verificar la integridad del archivo

10. **Cálculo de Ratio de Compresión**:
    - `ratioCompresion = tamanioOriginal / tamanioComprimido`
    - Incluir en la respuesta para transparencia

---

## 7. INTEGRACIÓN CON OTROS SERVICIOS

### 7.1 Integración con MsDatosConfiguracion

**Propósito**: Obtener la configuración por defecto de compresión y protección cuando `usarConfiguracionPorDefecto` es `true`.

**Datos a obtener**:
- Algoritmo de compresión por defecto
- Nivel de compresión por defecto
- Políticas de seguridad de contraseñas
- Tamaño máximo permitido de documentos

**Error Handling**:
- Si MsDatosConfiguracion no está disponible: retornar error 502 (Bad Gateway)
- Implementar Circuit Breaker para resiliencia
- Implementar Retry pattern con backoff exponencial

### 7.2 Integración con MsGestorDocumentos

**Propósito**: Almacenar y recuperar documentos del repositorio.

**Operaciones**:
1. **Recuperar documento**: Cuando `fuenteDocumento.tipo` = "REPOSITORIO"
   - Usar `repositorioId`, `documentoId`, `versionId` para obtener el documento
   
2. **Almacenar documento protegido**: Después de comprimir y proteger
   - Guardar el archivo ZIP protegido
   - Obtener `repositorioId` y `documentoId` del documento almacenado
   - Obtener URL de descarga

**Error Handling**:
- Si el documento no se encuentra en el repositorio: retornar error 404 (Not Found)
- Si MsGestorDocumentos no está disponible: retornar error 502 (Bad Gateway)
- Implementar Circuit Breaker para resiliencia
- Implementar Retry pattern con backoff exponencial

### 7.3 Patrones de Integración

**Circuit Breaker**:
- Prevenir cascadas de fallos cuando servicios externos no están disponibles
- Si se detecta indisponibilidad recurrente, abrir el circuito
- Retornar error 503 (Service Unavailable) cuando el circuito está abierto

**Retry Pattern**:
- Reintentar operaciones fallidas con servicios externos
- Implementar backoff exponencial entre reintentos
- Límite de reintentos: típicamente 3 intentos

**Timeout**:
- Establecer timeouts apropiados para llamadas a servicios externos
- Si el servicio externo no responde: retornar error 504 (Gateway Timeout)
- Timeout recomendado: configurar según SLA de servicios externos

---

## 8. CONSIDERACIONES TÉCNICAS

### 8.1 Seguridad

1. **Autenticación JWT**:
   - Validar Bearer token en todas las peticiones
   - Verificar firma del token
   - Validar expiración del token

2. **Cifrado de Contraseñas**:
   - Usar algoritmos criptográficamente seguros para generar contraseñas
   - Almacenar solo el hash SHA-512 de la contraseña
   - Nunca almacenar contraseñas en texto plano

3. **Integridad de Archivos**:
   - Generar checksum SHA-256 de todos los archivos protegidos
   - Permitir verificación de integridad mediante endpoint dedicado

4. **Protección de Datos Sensibles**:
   - Todos los documentos deben ser tratados como sensibles
   - Implementar cifrado en tránsito (HTTPS/TLS)
   - Implementar cifrado en reposo para almacenamiento

### 8.2 Rendimiento

1. **Compresión Eficiente**:
   - Optimizar algoritmos de compresión según tipo de documento
   - Balancear ratio de compresión vs. tiempo de procesamiento

2. **Procesamiento Asíncrono** (recomendación):
   - Para documentos grandes, considerar procesamiento asíncrono
   - Retornar inmediatamente con estado "EN_PROCESO"
   - Notificar cuando el proceso complete

3. **Caché** (recomendación):
   - Cachear configuraciones de MsDatosConfiguracion
   - Implementar TTL apropiado

### 8.3 Observabilidad

1. **Logging**:
   - Registrar todas las operaciones con `correlationId`
   - Logging estructurado para facilitar búsquedas
   - Nivel de log apropiado (INFO, WARNING, ERROR)

2. **Métricas**:
   - Tiempo de respuesta del endpoint
   - Tasa de éxito/error
   - Tamaño promedio de documentos procesados
   - Ratio de compresión promedio

3. **Distributed Tracing**:
   - Implementar tracing distribuido usando `X-Correlation-ID`
   - Rastrear llamadas a servicios externos (MsDatosConfiguracion, MsGestorDocumentos)

### 8.4 Escalabilidad

1. **Stateless Design**:
   - El microservicio debe ser stateless para facilitar escalado horizontal
   - No mantener estado en memoria del servicio

2. **Recursos**:
   - Considerar límites de CPU/memoria según carga esperada
   - Implementar auto-scaling basado en métricas

---

## 9. RESUMEN DE TECNOLOGÍAS Y ESTÁNDARES

- **Protocolo**: REST/HTTP
- **Formato de Datos**: JSON
- **Autenticación**: JWT (JSON Web Token)
- **Formato de Fechas**: ISO 8601 (YYYY-MM-DDThh:mm:ssZ)
- **Formato de Archivo Entrada**: PDF (firmado digitalmente)
- **Formato de Archivo Salida**: ZIP (protegido con contraseña)
- **Algoritmos de Hash**:
  - SHA-256 para checksums de archivos
  - SHA-512 para hash de contraseñas
- **Estilo de API**: RESTful con HATEOAS
- **Versionado de API**: Path-based (/api/v1/)
- **Patrones de Resiliencia**: Circuit Breaker, Retry, Timeout
- **Arquitectura**: Microservicios

---

## 10. NOTAS FINALES

Este documento contiene la especificación completa y detallada del microservicio **MsDominioProteccionDocumentos** versión 1.0. 

**Puntos clave**:
- El microservicio es un componente de soporte para la plataforma SIIRC
- Su función principal es comprimir y proteger documentos PDF con contraseña
- Implementa la política de seguridad de distribución documental de RENIEC
- Se integra con MsDatosConfiguracion y MsGestorDocumentos
- Sigue estándares REST/HTTP y principios de arquitectura de microservicios
- Implementa patrones de resiliencia para garantizar alta disponibilidad

**Para implementación**:
- Todos los campos, tipos y validaciones están completamente especificados
- Los códigos de estado HTTP están claramente definidos
- Las reglas de negocio están documentadas
- Las integraciones con otros servicios están identificadas
- Las consideraciones de seguridad, rendimiento y observabilidad están establecidas
