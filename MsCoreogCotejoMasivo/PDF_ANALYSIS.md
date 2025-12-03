# Análisis Completo del Microservicio MsCoreogCotejoMasivo

## Documento de Origen
- **Nombre del PDF**: Microservicio MsCoreogCotejoMasivo V1.0.pdf
- **Versión del Documento**: 1.0
- **Fecha de Generación**: 01/12/2025
- **Última Actualización**: 24/11/2025
- **Área**: Gestión de Seguridad Electrónica
- **Rol Responsable**: Arquitecto de Software

---

## 1. INFORMACIÓN GENERAL DEL MICROSERVICIO

### 1.1 Nombre Exacto del Microservicio
**MsCoreogCotejoMasivo** (Microservicio Coreógrafo de Cotejo Masivo)

### 1.2 Contexto de Negocio
El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. 

En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

### 1.3 Descripción del Microservicio
El Microservicio Coreógrafo de Cotejo Masivo (**MsCoreogCotejoMasivo**) es un componente de coreografía dentro de la plataforma SIIRC. 

**Propósito principal**: Coordinar y gestionar el flujo de trabajo asíncrono entre:
- **Microservicio Cotejo Masivo** (MsDominioCotejoMasivo - capa de procesamiento intensivo)
- **Microservicio Datos Cotejo Masivo** (MsDatosCotejoMasivo - capa de persistencia)

Este microservicio asegura que las diferentes etapas del proceso de cotejo masivo se ejecuten en la secuencia correcta, manejen las fallas apropiadamente y registren los eventos de estado sin que los microservicios participantes se acoplen directamente.

### 1.4 Tipo de Microservicio
**Microservicio de Coreografía** (Orquestación de flujos asíncronos mediante eventos)

### 1.5 Versión del API
**v1** (version 1.0)

### 1.6 Paquete Base Java Sugerido
```
pe.gob.reniec.coreografia
```

Basado en la estructura existente del proyecto:
```
pe.gob.reniec.coreografia.cotejomasivo
```

---

## 2. ARQUITECTURA DE REFERENCIA

### 2.1 Justificación de Arquitectura de Microservicios

La adopción de microservicios responde a necesidades técnicas y operativas concretas:

1. **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.

2. **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.

3. **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.

4. **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.

5. **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

### 2.2 Capas de la Arquitectura

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**: API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer)**: Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer)**: Event Streaming para comunicación asíncrona y conectores a sistemas legados.

---

## 3. CÓDIGOS DE RESPUESTA HTTP ESTÁNDAR

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

---

## 4. CATÁLOGO DE ENDPOINTS

### 4.1 ENDPOINT: Iniciar Cotejo Masivo

#### 4.1.1 Información General del Endpoint

| Atributo | Valor |
|----------|-------|
| **Path** | `/api/v1/ciudadano/MsCoreogCotejoMasivo` |
| **API Gateway** | Interno |
| **Método HTTP** | `POST` |
| **Protocolo** | REST/HTTP |
| **Descripción** | Endpoint que permite iniciar el proceso de cotejo masivo de forma síncrona, validando la solicitud y emitiendo el evento de inicio del flujo de coreografía |

#### 4.1.2 Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación del usuario |
| `Content-Type` | String | Sí | "application/json" |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad end-to-end |
| `X-Office-Code` | String | Sí | Código de oficina o sede desde donde se realiza la operación |
| `X-User-Role` | String | Sí | Rol del usuario que realiza la operación (ejemplo: TECNICO_COTEJO) |
| `X-Request-Source` | String | Sí | Origen de la solicitud: WEB, API_EXTERNA, BATCH |
| `X-Idempotency-Key` | UUID | Sí | Clave para evitar procesamientos duplicados |

#### 4.1.3 Request Body (Entrada)

**Estructura JSON Completa:**

```json
{
  "solicitud": {
    "numeroSolicitud": "string",
    "tipoTramite": "string",
    "fechaSolicitud": "YYYY-MM-DDThh:mm:ssZ",
    "prioridad": "string"
  },
  "entidadSolicitante": {
    "codigo": "string",
    "nombre": "string",
    "ruc": "string",
    "representanteLegal": {
      "dni": "string",
      "nombres": "string",
      "apellidoPaterno": "string",
      "apellidoMaterno": "string"
    },
    "contacto": {
      "email": "string",
      "telefono": "string"
    }
  },
  "registrosCotejo": [
    {
      "secuencia": "integer",
      "numeroDni": "string",
      "apellidoPaterno": "string",
      "apellidoMaterno": "string",
      "nombres": "string",
      "fechaNacimiento": "YYYY-MM-DDThh:mm:ssZ",
      "genero": "string"
    }
  ],
  "configuracionProceso": {
    "notificarProgreso": "boolean",
    "generarReporteDetallado": "boolean",
    "formatoReporte": "string"
  },
  "documentoSolicitud": {
    "tipo": "string",
    "nombre": "string",
    "urlDocumento": "string",
    "hashDocumento": "string"
  },
  "observaciones": "string"
}
```

#### 4.1.4 Parámetros de Entrada Detallados

| Campo | Atributo JSON | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|---------------|------|-------------|-----------|-----------|-------------|
| **Solicitud** | `solicitud` | Object | Sí | N/A | N/A | Objeto principal de la solicitud |
| Número Solicitud | `solicitud.numeroSolicitud` | String | Sí | 10 | 20 | Número único de la solicitud |
| Tipo Trámite | `solicitud.tipoTramite` | String | Sí | 5 | 30 | Tipo de trámite solicitado |
| Fecha Solicitud | `solicitud.fechaSolicitud` | String (Date ISO 8601) | Sí | N/A | N/A | Fecha y hora de la solicitud |
| Prioridad | `solicitud.prioridad` | String | Sí | 4 | 10 | Prioridad de procesamiento |
| **Entidad Solicitante** | `entidadSolicitante` | Object | Sí | N/A | N/A | Datos de la entidad que solicita |
| Código Entidad | `entidadSolicitante.codigo` | String | Sí | 3 | 20 | Código único de la entidad |
| Nombre Entidad | `entidadSolicitante.nombre` | String | Sí | 5 | 200 | Nombre de la entidad |
| RUC | `entidadSolicitante.ruc` | String | No | 11 | 11 | RUC de la entidad |
| **Representante Legal** | `entidadSolicitante.representanteLegal` | Object | Sí | N/A | N/A | Datos del representante legal |
| DNI Representante | `entidadSolicitante.representanteLegal.dni` | String | Sí | 8 | 8 | DNI del representante legal |
| Nombres Representante | `entidadSolicitante.representanteLegal.nombres` | String | Sí | 2 | 100 | Nombres del representante |
| Apellido Paterno Rep. | `entidadSolicitante.representanteLegal.apellidoPaterno` | String | Sí | 2 | 60 | Apellido paterno del representante |
| Apellido Materno Rep. | `entidadSolicitante.representanteLegal.apellidoMaterno` | String | Sí | 2 | 60 | Apellido materno del representante |
| **Contacto** | `entidadSolicitante.contacto` | Object | Sí | N/A | N/A | Datos de contacto |
| Email | `entidadSolicitante.contacto.email` | String | Sí | 5 | 254 | Email de contacto |
| Teléfono | `entidadSolicitante.contacto.telefono` | String | No | 7 | 15 | Teléfono de contacto |
| **Registros Cotejo** | `registrosCotejo` | Array | Sí | 1 | 10000 | Lista de ciudadanos a cotejar |
| Secuencia | `registrosCotejo[].secuencia` | Integer | Sí | N/A | N/A | Número de secuencia del registro |
| Número DNI | `registrosCotejo[].numeroDni` | String | Sí | 8 | 8 | DNI del ciudadano |
| Apellido Paterno | `registrosCotejo[].apellidoPaterno` | String | Sí | 2 | 60 | Apellido paterno |
| Apellido Materno | `registrosCotejo[].apellidoMaterno` | String | Sí | 2 | 60 | Apellido materno |
| Nombres | `registrosCotejo[].nombres` | String | Sí | 2 | 100 | Nombres del ciudadano |
| Fecha Nacimiento | `registrosCotejo[].fechaNacimiento` | String (Date ISO 8601) | No | N/A | N/A | Fecha de nacimiento |
| Género | `registrosCotejo[].genero` | String | No | 1 | 20 | Género del ciudadano |
| **Configuración** | `configuracionProceso` | Object | No | N/A | N/A | Configuración del proceso |
| Notificar Progreso | `configuracionProceso.notificarProgreso` | Boolean | No | N/A | N/A | Indica si se notifica el progreso |
| Reporte Detallado | `configuracionProceso.generarReporteDetallado` | Boolean | No | N/A | N/A | Indica si se genera reporte detallado |
| Formato Reporte | `configuracionProceso.formatoReporte` | String | No | 3 | 10 | Formato del reporte (PDF, EXCEL, etc.) |
| **Documento Solicitud** | `documentoSolicitud` | Object | No | N/A | N/A | Documento adjunto a la solicitud |
| Tipo Documento | `documentoSolicitud.tipo` | String | Sí* | 3 | 50 | Tipo de documento |
| Nombre Documento | `documentoSolicitud.nombre` | String | Sí* | 5 | 200 | Nombre del archivo |
| URL Documento | `documentoSolicitud.urlDocumento` | String | Sí* | 10 | 500 | URL donde se encuentra el documento |
| Hash Documento | `documentoSolicitud.hashDocumento` | String | No | 64 | 64 | Hash SHA-256 del documento |
| **Observaciones** | `observaciones` | String | No | 0 | 500 | Observaciones adicionales |

*Sí, si se incluye el objeto `documentoSolicitud`

#### 4.1.5 Response Body (Respuesta Exitosa)

**Estructura JSON Completa:**

```json
{
  "success": "boolean",
  "data": {
    "solicitudId": "string",
    "numeroSolicitud": "string",
    "estado": "string",
    "tipoTramite": "string",
    "entidadSolicitante": {
      "codigo": "string",
      "nombre": "string"
    },
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string",
    "oficinaRegistro": {
      "codigo": "string",
      "nombre": "string"
    },
    "resumenSolicitud": {
      "totalRegistros": "integer",
      "prioridad": "string",
      "tiempoEstimadoProcesamiento": "string"
    },
    "siguientesPasos": [
      {
        "paso": "string",
        "descripcion": "string"
      }
    ],
    "urlSeguimiento": "string",
    "eventosGenerados": [
      {
        "eventId": "string",
        "eventType": "string",
        "topic": "string"
      }
    ],
    "_links": {
      "self": "string",
      "consultarEstado": "string",
      "cancelar": "string"
    }
  },
  "metadata": {
    "timestamp": "string",
    "correlationId": "string",
    "version": "string",
    "tiempoRespuesta": "string"
  }
}
```

#### 4.1.6 Parámetros de Respuesta Detallados

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| `success` | Boolean | Sí | Indica si la operación fue exitosa |
| `data` | Object | Sí | Cuerpo principal de la respuesta |
| `data.solicitudId` | String (UUID) | Sí | Identificador único de la solicitud creada |
| `data.numeroSolicitud` | String | Sí | Número legible de la solicitud |
| `data.estado` | String | Sí | Estado inicial de la solicitud |
| `data.tipoTramite` | String | Sí | Tipo de trámite |
| `data.entidadSolicitante` | Object | Sí | Datos de la entidad solicitante |
| `data.entidadSolicitante.codigo` | String | Sí | Código de la entidad |
| `data.entidadSolicitante.nombre` | String | Sí | Nombre de la entidad |
| `data.fechaRegistro` | String (Date ISO 8601) | Sí | Fecha y hora de registro |
| `data.usuarioRegistro` | String | Sí | Usuario que registró la solicitud |
| `data.oficinaRegistro` | Object | Sí | Oficina donde se registró |
| `data.oficinaRegistro.codigo` | String | Sí | Código de la oficina |
| `data.oficinaRegistro.nombre` | String | Sí | Nombre de la oficina |
| `data.resumenSolicitud` | Object | Sí | Resumen de la solicitud |
| `data.resumenSolicitud.totalRegistros` | Integer | Sí | Cantidad total de registros a cotejar |
| `data.resumenSolicitud.prioridad` | String | Sí | Prioridad asignada |
| `data.resumenSolicitud.tiempoEstimadoProcesamiento` | String | Sí | Tiempo estimado (ISO 8601 Duration) |
| `data.siguientesPasos[]` | Array | No | Lista de pasos siguientes |
| `data.siguientesPasos[].paso` | String | No | Nombre del paso |
| `data.siguientesPasos[].descripcion` | String | No | Descripción del paso |
| `data.urlSeguimiento` | String (URI) | No | URL para consultar estado |
| `data.eventosGenerados[]` | Array | Sí | Eventos emitidos al iniciar |
| `data.eventosGenerados[].eventId` | String (UUID) | Sí | ID del evento generado |
| `data.eventosGenerados[].eventType` | String | Sí | Tipo de evento |
| `data.eventosGenerados[].topic` | String | Sí | Topic Kafka destino |
| `data._links` | Object | Sí | Hipervínculos de navegación HATEOAS |
| `data._links.self` | String (URI) | Sí | URL del recurso actual |
| `data._links.consultarEstado` | String (URI) | Sí | URL para consultar estado |
| `data._links.cancelar` | String (URI) | No | URL para cancelar (si aplica) |
| `metadata` | Object | Sí | Metadatos de la operación |
| `metadata.timestamp` | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| `metadata.correlationId` | String (UUID) | Sí | ID de correlación para trazabilidad |
| `metadata.version` | String | Sí | Versión del API |
| `metadata.tiempoRespuesta` | String | Sí | Tiempo de respuesta del servicio |

#### 4.1.7 Response Body (Respuesta de Error)

**Estructura JSON de Error:**

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": "integer",
    "errores": [
      {
        "campo": "string",
        "detalleError": "string"
      }
    ]
  }
}
```

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| `error` | Object | No | Objeto de error (solo en caso de fallo) |
| `error.tipo` | String | No | Tipo de error |
| `error.titulo` | String | No | Título descriptivo del error |
| `error.estado` | Integer | No | Código de estado HTTP |
| `error.errores[]` | Array | No | Lista detallada de errores |
| `error.errores[].campo` | String | No | Campo con error |
| `error.errores[].detalleError` | String | No | Descripción del error |

#### 4.1.8 Status Codes HTTP Específicos del Endpoint

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Solicitud de cotejo masivo creada exitosamente |
| 400 | Bad Request | Parámetros inválidos o datos incompletos en la solicitud |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Usuario sin permisos para iniciar cotejo masivo |
| 404 | Not Found | Entidad solicitante no encontrada en el sistema |
| 409 | Conflict | Ya existe una solicitud activa con el mismo número o idempotency key |
| 413 | Payload Too Large | Lista de registros excede el límite permitido (10,000) |
| 422 | Unprocessable Entity | Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Error al comunicarse con Apache Kafka |
| 503 | Service Unavailable | Servicio temporalmente no disponible o Circuit Breaker abierto |

---

## 5. ENTIDADES DEL DOMINIO

### 5.1 Entidad: Solicitud

**Descripción**: Representa una solicitud de cotejo masivo.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `numeroSolicitud` | String | Sí | Número único de identificación de la solicitud | 10 | 20 |
| `tipoTramite` | String | Sí | Tipo de trámite solicitado | 5 | 30 |
| `fechaSolicitud` | String (Date ISO 8601) | Sí | Fecha y hora de la solicitud | N/A | N/A |
| `prioridad` | String | Sí | Nivel de prioridad del procesamiento | 4 | 10 |

**Valores posibles para `prioridad`**: ALTA, MEDIA, BAJA, URGENTE (inferido del contexto)

---

### 5.2 Entidad: EntidadSolicitante

**Descripción**: Representa la entidad que solicita el cotejo masivo.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `codigo` | String | Sí | Código único de la entidad | 3 | 20 |
| `nombre` | String | Sí | Nombre o razón social de la entidad | 5 | 200 |
| `ruc` | String | No | RUC de la entidad | 11 | 11 |
| `representanteLegal` | RepresentanteLegal | Sí | Datos del representante legal | N/A | N/A |
| `contacto` | Contacto | Sí | Información de contacto | N/A | N/A |

---

### 5.3 Entidad: RepresentanteLegal

**Descripción**: Representa el representante legal de la entidad solicitante.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `dni` | String | Sí | DNI del representante legal | 8 | 8 |
| `nombres` | String | Sí | Nombres del representante | 2 | 100 |
| `apellidoPaterno` | String | Sí | Apellido paterno del representante | 2 | 60 |
| `apellidoMaterno` | String | Sí | Apellido materno del representante | 2 | 60 |

---

### 5.4 Entidad: Contacto

**Descripción**: Información de contacto de la entidad solicitante.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `email` | String | Sí | Correo electrónico de contacto | 5 | 254 |
| `telefono` | String | No | Número telefónico de contacto | 7 | 15 |

---

### 5.5 Entidad: RegistroCotejo

**Descripción**: Representa un registro individual de ciudadano a cotejar.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `secuencia` | Integer | Sí | Número de secuencia del registro en el lote | N/A | N/A |
| `numeroDni` | String | Sí | Número de DNI del ciudadano | 8 | 8 |
| `apellidoPaterno` | String | Sí | Apellido paterno del ciudadano | 2 | 60 |
| `apellidoMaterno` | String | Sí | Apellido materno del ciudadano | 2 | 60 |
| `nombres` | String | Sí | Nombres del ciudadano | 2 | 100 |
| `fechaNacimiento` | String (Date ISO 8601) | No | Fecha de nacimiento del ciudadano | N/A | N/A |
| `genero` | String | No | Género del ciudadano | 1 | 20 |

**Valores posibles para `genero`**: MASCULINO, FEMENINO (inferido del contexto)

---

### 5.6 Entidad: ConfiguracionProceso

**Descripción**: Configuración del procesamiento del cotejo masivo.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `notificarProgreso` | Boolean | No | Indica si se envían notificaciones de progreso | N/A | N/A |
| `generarReporteDetallado` | Boolean | No | Indica si se genera un reporte detallado | N/A | N/A |
| `formatoReporte` | String | No | Formato del reporte a generar | 3 | 10 |

**Valores posibles para `formatoReporte`**: PDF, EXCEL, CSV, JSON (inferido del contexto)

---

### 5.7 Entidad: DocumentoSolicitud

**Descripción**: Documento adjunto a la solicitud de cotejo masivo.

| Atributo | Tipo | Obligatorio | Descripción | Long. Mín | Long. Máx |
|----------|------|-------------|-------------|-----------|-----------|
| `tipo` | String | Sí* | Tipo de documento | 3 | 50 |
| `nombre` | String | Sí* | Nombre del archivo del documento | 5 | 200 |
| `urlDocumento` | String | Sí* | URL donde se encuentra almacenado el documento | 10 | 500 |
| `hashDocumento` | String | No | Hash SHA-256 del documento para verificación de integridad | 64 | 64 |

*Sí, si se incluye el objeto `documentoSolicitud`

---

### 5.8 Entidad: OficinaRegistro

**Descripción**: Oficina donde se registró la solicitud.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `codigo` | String | Sí | Código único de la oficina |
| `nombre` | String | Sí | Nombre de la oficina |

---

### 5.9 Entidad: ResumenSolicitud

**Descripción**: Resumen de información de la solicitud.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `totalRegistros` | Integer | Sí | Cantidad total de registros a cotejar |
| `prioridad` | String | Sí | Prioridad asignada a la solicitud |
| `tiempoEstimadoProcesamiento` | String | Sí | Tiempo estimado de procesamiento (ISO 8601 Duration) |

---

### 5.10 Entidad: SiguientePaso

**Descripción**: Representa un paso siguiente en el flujo del proceso.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `paso` | String | No | Nombre identificador del paso |
| `descripcion` | String | No | Descripción detallada del paso |

---

### 5.11 Entidad: EventoGenerado

**Descripción**: Representa un evento generado por el proceso de coreografía.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `eventId` | String (UUID) | Sí | Identificador único del evento |
| `eventType` | String | Sí | Tipo de evento generado |
| `topic` | String | Sí | Topic de Apache Kafka donde se publicó el evento |

**Posibles valores para `eventType`** (inferidos):
- `COTEJO_MASIVO_INICIADO`
- `SOLICITUD_REGISTRADA`
- `VALIDACION_COMPLETADA`

---

### 5.12 Entidad: Links (HATEOAS)

**Descripción**: Hipervínculos para navegación según el estándar HATEOAS.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `self` | String (URI) | Sí | URL del recurso actual |
| `consultarEstado` | String (URI) | Sí | URL para consultar el estado de la solicitud |
| `cancelar` | String (URI) | No | URL para cancelar la solicitud (si aplica) |

---

### 5.13 Entidad: Metadata

**Descripción**: Metadatos técnicos de la operación.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `timestamp` | String (Date ISO 8601) | Sí | Marca de tiempo del procesamiento |
| `correlationId` | String (UUID) | Sí | ID de correlación para trazabilidad end-to-end |
| `version` | String | Sí | Versión del API |
| `tiempoRespuesta` | String | Sí | Tiempo de respuesta del servicio |

---

### 5.14 Entidad: Error

**Descripción**: Estructura de error estandarizada.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `tipo` | String | No | Tipo o categoría del error |
| `titulo` | String | No | Título descriptivo del error |
| `estado` | Integer | No | Código de estado HTTP del error |
| `errores` | Array[ErrorDetalle] | No | Lista detallada de errores |

---

### 5.15 Entidad: ErrorDetalle

**Descripción**: Detalle específico de un error.

| Atributo | Tipo | Obligatorio | Descripción |
|----------|------|-------------|-------------|
| `campo` | String | No | Campo que generó el error |
| `detalleError` | String | No | Descripción detallada del error |

---

## 6. RELACIONES ENTRE ENTIDADES

```
Solicitud
    ├── tipoTramite: String
    ├── numeroSolicitud: String
    ├── fechaSolicitud: Date
    └── prioridad: String

EntidadSolicitante
    ├── codigo: String
    ├── nombre: String
    ├── ruc: String
    ├── representanteLegal: RepresentanteLegal (1:1)
    └── contacto: Contacto (1:1)

RepresentanteLegal
    ├── dni: String
    ├── nombres: String
    ├── apellidoPaterno: String
    └── apellidoMaterno: String

Contacto
    ├── email: String
    └── telefono: String

RegistroCotejo (Array - 1 a 10,000)
    ├── secuencia: Integer
    ├── numeroDni: String
    ├── apellidoPaterno: String
    ├── apellidoMaterno: String
    ├── nombres: String
    ├── fechaNacimiento: Date
    └── genero: String

ConfiguracionProceso
    ├── notificarProgreso: Boolean
    ├── generarReporteDetallado: Boolean
    └── formatoReporte: String

DocumentoSolicitud
    ├── tipo: String
    ├── nombre: String
    ├── urlDocumento: String
    └── hashDocumento: String

Response
    ├── success: Boolean
    ├── data: DataResponse
    └── metadata: Metadata

DataResponse
    ├── solicitudId: UUID
    ├── numeroSolicitud: String
    ├── estado: String
    ├── tipoTramite: String
    ├── entidadSolicitante: EntidadSolicitanteResponse (1:1)
    ├── fechaRegistro: Date
    ├── usuarioRegistro: String
    ├── oficinaRegistro: OficinaRegistro (1:1)
    ├── resumenSolicitud: ResumenSolicitud (1:1)
    ├── siguientesPasos: Array[SiguientePaso] (0:N)
    ├── urlSeguimiento: String
    ├── eventosGenerados: Array[EventoGenerado] (1:N)
    └── _links: Links (1:1)
```

---

## 7. REGLAS DE NEGOCIO Y VALIDACIONES

### 7.1 Validaciones Generales

1. **Token JWT**: Debe ser válido y no estar expirado (Status 401)
2. **Permisos de Usuario**: El usuario debe tener el rol apropiado para iniciar cotejo masivo (Status 403)
3. **Entidad Solicitante**: Debe existir en el sistema (Status 404)
4. **Idempotency Key**: No debe existir una solicitud activa con el mismo `X-Idempotency-Key` (Status 409)
5. **Número de Solicitud**: No debe existir una solicitud activa con el mismo `numeroSolicitud` (Status 409)

### 7.2 Validaciones de Entrada

1. **Límite de Registros**: 
   - Mínimo: 1 registro
   - Máximo: 10,000 registros
   - Si se excede: Status 413 (Payload Too Large)

2. **Formato de DNI**:
   - Debe tener exactamente 8 dígitos numéricos
   - Longitud: 8 caracteres

3. **Formato de RUC**:
   - Debe tener exactamente 11 dígitos numéricos
   - Longitud: 11 caracteres

4. **Formato de Email**:
   - Debe cumplir con el formato estándar RFC 5322
   - Longitud: 5 a 254 caracteres

5. **Formato de Teléfono**:
   - Longitud: 7 a 15 caracteres

6. **Fechas**:
   - Deben estar en formato ISO 8601: `YYYY-MM-DDThh:mm:ssZ`
   - `fechaSolicitud` debe ser <= fecha actual

7. **Hash de Documento**:
   - Si se proporciona, debe tener exactamente 64 caracteres (SHA-256)

8. **Secuencia de Registros**:
   - Debe ser correlativa y única dentro del array

### 7.3 Reglas de Negocio Funcionales

1. **Prioridad**: Se asigna según criterios de negocio (puede ser ALTA, MEDIA, BAJA, URGENTE)

2. **Estado Inicial**: Toda solicitud inicia en estado "REGISTRADA" o "EN_COLA"

3. **Rate Limiting**: 
   - Existe un límite de solicitudes por tiempo
   - Si se excede: Status 429 (Too Many Requests)

4. **Circuit Breaker**: 
   - Si el servicio de Apache Kafka no está disponible: Status 502 (Bad Gateway)
   - Si el servicio está temporalmente no disponible: Status 503 (Service Unavailable)

5. **Tiempo de Procesamiento Estimado**:
   - Se calcula en base al número de registros y prioridad
   - Se retorna en formato ISO 8601 Duration (ejemplo: "PT2H30M" = 2 horas 30 minutos)

6. **Eventos Generados**:
   - Al iniciar una solicitud, se emiten eventos a Apache Kafka
   - Los eventos incluyen información del tipo de evento y topic destino

7. **HATEOAS**:
   - Todas las respuestas incluyen hipervínculos para navegación
   - Facilita el descubrimiento de operaciones disponibles

### 7.4 Validaciones de Integridad

1. **Documento Adjunto**:
   - Si se proporciona `hashDocumento`, se debe validar la integridad del documento
   - El documento debe ser accesible en la `urlDocumento` proporcionada

2. **Representante Legal**:
   - El DNI del representante legal debe ser válido y existir en el sistema

3. **Observaciones**:
   - Máximo 500 caracteres

---

## 8. DEPENDENCIAS CON OTROS MICROSERVICIOS

### 8.1 Microservicio Cotejo Masivo (MsDominioCotejoMasivo)

**Tipo**: Microservicio de Dominio (MsDominio)
**Función**: Capa de procesamiento intensivo
**Relación**: MsCoreogCotejoMasivo coordina el flujo asíncrono hacia este microservicio
**Comunicación**: Eventos (Apache Kafka)

### 8.2 Microservicio Datos Cotejo Masivo (MsDatosCotejoMasivo)

**Tipo**: Microservicio de Datos (MsData)
**Función**: Capa de persistencia
**Relación**: MsCoreogCotejoMasivo coordina el flujo asíncrono hacia este microservicio
**Comunicación**: Eventos (Apache Kafka)

### 8.3 Apache Kafka

**Tipo**: Event Streaming Platform
**Función**: Comunicación asíncrona entre microservicios
**Relación**: MsCoreogCotejoMasivo publica eventos a topics de Kafka
**Status Code en Error**: 502 (Bad Gateway) si Kafka no está disponible

### 8.4 API Gateway Interno

**Tipo**: Gateway de API
**Función**: Punto único de entrada, seguridad, throttling
**Relación**: Enruta las peticiones hacia MsCoreogCotejoMasivo
**Características**:
- Validación de JWT
- Rate Limiting
- Manejo de CORS
- Logging centralizado

---

## 9. PATRONES DE DISEÑO Y ARQUITECTURA

### 9.1 Patrones Implementados

1. **Circuit Breaker**: Garantiza resiliencia ante fallos de servicios externos
2. **Retry Pattern**: Reintentos automáticos en caso de fallos transitorios
3. **Event-Driven Architecture**: Comunicación asíncrona mediante eventos
4. **HATEOAS**: Hipermedia as the Engine of Application State
5. **Idempotency**: Prevención de procesamientos duplicados mediante `X-Idempotency-Key`
6. **Correlation ID**: Trazabilidad end-to-end mediante `X-Correlation-ID`
7. **API Versioning**: Versionado de API mediante path (`/api/v1/`)

### 9.2 Características de Arquitectura

1. **Escalabilidad Independiente**: Componentes escalan según demanda
2. **Logging Centralizado**: Trazabilidad de todas las operaciones
3. **Distributed Tracing**: Seguimiento de solicitudes a través de múltiples servicios
4. **Métricas Granulares**: Observabilidad detallada del sistema
5. **Responsabilidad Única**: Cada microservicio tiene una responsabilidad específica

---

## 10. SEGURIDAD

### 10.1 Autenticación

- **Mecanismo**: Bearer Token JWT
- **Header**: `Authorization: Bearer <token>`
- **Validación**: Token debe ser válido y no estar expirado
- **Error**: 401 Unauthorized si el token es inválido o está expirado

### 10.2 Autorización

- **Mecanismo**: Validación de roles de usuario
- **Header**: `X-User-Role`
- **Roles Esperados**: TECNICO_COTEJO (ejemplo)
- **Error**: 403 Forbidden si el usuario no tiene permisos suficientes

### 10.3 Trazabilidad

- **Correlation ID**: `X-Correlation-ID` (UUID) para trazabilidad end-to-end
- **Office Code**: `X-Office-Code` identifica la oficina de origen
- **Request Source**: `X-Request-Source` identifica el origen de la solicitud (WEB, API_EXTERNA, BATCH)

### 10.4 Integridad de Datos

- **Hash de Documentos**: SHA-256 para validar integridad de documentos adjuntos
- **Idempotency Key**: `X-Idempotency-Key` (UUID) para prevenir procesamientos duplicados

---

## 11. OBSERVABILIDAD Y MONITOREO

### 11.1 Metadatos de Respuesta

Todas las respuestas incluyen metadata con:
- `timestamp`: Marca de tiempo del procesamiento
- `correlationId`: ID de correlación
- `version`: Versión del API
- `tiempoRespuesta`: Tiempo de respuesta del servicio

### 11.2 Logging

- **Logging Centralizado**: Todos los logs se centralizan para análisis
- **Nivel de Detalle**: Información generalizada al exterior, detalle completo en logs internos
- **Trazabilidad**: Uso de `correlationId` en todos los logs

### 11.3 Métricas

- **Granularidad**: Métricas granulares por microservicio
- **Observabilidad**: Monitoreo de latencia, throughput, errores

---

## 12. TECNOLOGÍAS Y ESTÁNDARES

### 12.1 Estándares Implementados

1. **REST/HTTP**: Protocolo de comunicación
2. **JSON**: Formato de intercambio de datos
3. **ISO 8601**: Formato de fechas y duraciones
4. **RFC 5322**: Formato de emails
5. **JWT**: JSON Web Tokens para autenticación
6. **HATEOAS**: Nivel 3 de Richardson Maturity Model
7. **UUID**: Identificadores únicos universales
8. **SHA-256**: Hash para integridad de documentos

### 12.2 Tecnologías de Integración

1. **Apache Kafka**: Event streaming para comunicación asíncrona
2. **API Manager/Gateway**: Punto único de entrada
3. **Spring Boot** (inferido): Framework Java para microservicios

---

## 13. RESUMEN EJECUTIVO

### 13.1 Datos Clave

| Característica | Valor |
|----------------|-------|
| **Nombre del Microservicio** | MsCoreogCotejoMasivo |
| **Tipo** | Microservicio de Coreografía |
| **Versión del API** | v1 |
| **Paquete Base Java** | pe.gob.reniec.coreografia.cotejomasivo |
| **Total de Endpoints** | 1 (Iniciar Cotejo Masivo) |
| **Método HTTP** | POST |
| **Path** | /api/v1/ciudadano/MsCoreogCotejoMasivo |
| **API Gateway** | Interno |
| **Comunicación Asíncrona** | Apache Kafka |
| **Límite de Registros** | 1 a 10,000 por solicitud |
| **Autenticación** | JWT Bearer Token |
| **Patrón Arquitectónico** | Event-Driven Architecture |

### 13.2 Entidades Principales

1. Solicitud
2. EntidadSolicitante
3. RepresentanteLegal
4. Contacto
5. RegistroCotejo
6. ConfiguracionProceso
7. DocumentoSolicitud
8. OficinaRegistro
9. ResumenSolicitud
10. SiguientePaso
11. EventoGenerado
12. Links (HATEOAS)
13. Metadata
14. Error
15. ErrorDetalle

### 13.3 Dependencias Críticas

1. **MsDominioCotejoMasivo**: Procesamiento intensivo de cotejos
2. **MsDatosCotejoMasivo**: Persistencia de datos
3. **Apache Kafka**: Event streaming
4. **API Gateway**: Enrutamiento y seguridad

---

## 14. NOTAS ADICIONALES

### 14.1 Consideraciones de Implementación

1. El microservicio debe implementar Circuit Breaker para resiliencia
2. Debe registrar todos los eventos en logs centralizados
3. Los eventos deben publicarse en Apache Kafka de forma confiable
4. La validación debe ser exhaustiva antes de emitir eventos
5. El tiempo de respuesta debe optimizarse (respuesta síncrona rápida, procesamiento asíncrono)

### 14.2 Flujo de Coreografía

1. **Recepción**: MsCoreogCotejoMasivo recibe solicitud POST
2. **Validación**: Valida datos, autenticación, autorización
3. **Registro**: Registra solicitud en estado inicial
4. **Evento**: Publica evento de inicio a Kafka
5. **Respuesta**: Retorna respuesta 201 Created con datos de la solicitud
6. **Procesamiento Asíncrono**: MsDominioCotejoMasivo procesa el cotejo
7. **Persistencia Asíncrona**: MsDatosCotejoMasivo guarda resultados

### 14.3 Escalabilidad

- El microservicio puede escalar horizontalmente
- El límite de 10,000 registros por solicitud ayuda a mantener el rendimiento
- El procesamiento asíncrono permite alta concurrencia

---

## 15. CONCLUSIÓN

Este documento contiene **TODA** la información extraída del PDF "Microservicio MsCoreogCotejoMasivo V1.0.pdf". Incluye:

✅ Nombre exacto del microservicio
✅ Contexto de negocio completo
✅ Versión del API
✅ Paquete base Java sugerido
✅ Endpoint completo con todos los detalles
✅ Estructura JSON completa de request y response
✅ Todos los parámetros con tipos, validaciones y longitudes
✅ Status codes HTTP detallados
✅ 15 entidades del dominio con todos sus atributos
✅ Relaciones entre entidades
✅ Reglas de negocio y validaciones
✅ Tipo de microservicio (Coreografía)
✅ Dependencias con otros microservicios (MsDominioCotejoMasivo, MsDatosCotejoMasivo)
✅ Patrones de diseño y arquitectura
✅ Seguridad, observabilidad y tecnologías

**Este documento es la fuente única de verdad para implementar el microservicio MsCoreogCotejoMasivo.**

---

**Fecha de Análisis**: 03/12/2025  
**Documento Fuente**: Microservicio MsCoreogCotejoMasivo V1.0.pdf  
**Versión del Análisis**: 1.0
