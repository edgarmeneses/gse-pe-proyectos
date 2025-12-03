# Especificación Extraída: MsDominioProteccionDocumentos V1.0

## 1. Información General

**Nombre del Microservicio**: MsDominioProteccionDocumentos

**Contexto de Negocio**: 
Microservicio de dominio que implementa la lógica de negocio para protección de documentos mediante compresión y cifrado. Forma parte de la plataforma SIIRC (Sistema Integrado de Información del Registro Civil) de RENIEC. Se integra con MsDatosConfiguracion y MsGestorDocumentos.

**Versión del API**: v1

**Paquete Base Java**: pe.gob.reniec.protecciondocumentos

**Tipo de Microservicio**: MsDominio (NO define Repository, se integra con MsData a través de puertos)

---

## 2. Endpoint Único

### POST /api/v1/documentos/MsProteccionDocumentos/comprimir-proteger

**Descripción**: Comprime y protege documentos con configuración de seguridad específica

**Headers Requeridos**:
- `X-Request-ID`: String (UUID único de la solicitud)
- `X-Correlation-ID`: String (ID de correlación para trazabilidad)
- `X-Client-ID`: String (Identificador del cliente/aplicación)
- `X-User-ID`: String (Identificador del usuario que realiza la solicitud)
- `X-Tenant-ID`: String (Identificador del tenant/organización)
- `Content-Type`: application/json
- `Accept`: application/json

**Request Body**:
```json
{
  "solicitudId": "string",
  "tipoOperacion": "string",
  "fechaSolicitud": "2024-01-15T10:30:00Z",
  "fuente": {
    "tipo": "string",
    "origen": "string",
    "referencia": {
      "sistema": "string",
      "transaccionId": "string",
      "codigoSeguimiento": "string"
    }
  },
  "documentos": [
    {
      "documentoId": "string",
      "nombre": "string",
      "tipo": "string",
      "tamanioBytes": 0,
      "formatoOriginal": "string",
      "metadatos": {
        "titulo": "string",
        "descripcion": "string",
        "autor": "string",
        "fechaCreacion": "2024-01-15T10:30:00Z",
        "clasificacion": "string",
        "palabrasClave": ["string"]
      }
    }
  ],
  "configuracion": {
    "nivelCompresion": "string",
    "algoritmoCifrado": "string",
    "clavePublica": "string",
    "incluirMetadatos": true,
    "protegerConPassword": true,
    "passwordHash": "string"
  },
  "destinatarios": [
    {
      "destinatarioId": "string",
      "tipo": "string",
      "nivelAcceso": "string",
      "permisos": ["string"]
    }
  ]
}
```

**Response Body (200 OK)**:
```json
{
  "success": true,
  "timestamp": "2024-01-15T10:30:00Z",
  "data": {
    "procesoId": "string",
    "solicitudId": "string",
    "estado": "string",
    "fechaProcesamiento": "2024-01-15T10:30:00Z",
    "archivosProtegidos": [
      {
        "archivoId": "string",
        "documentoOriginalId": "string",
        "nombreArchivo": "string",
        "formatoProtegido": "string",
        "tamanioOriginalBytes": 0,
        "tamanioComprimidoBytes": 0,
        "ratioCompresion": 0.0,
        "hash": "string",
        "algoritmoHash": "string",
        "ubicacionAlmacenamiento": "string"
      }
    ],
    "seguridad": {
      "algoritmoCifrado": "string",
      "nivelSeguridad": "string",
      "fechaCifrado": "2024-01-15T10:30:00Z",
      "huellaCifrado": "string"
    },
    "estadisticas": {
      "totalDocumentos": 0,
      "documentosProcesados": 0,
      "documentosFallidos": 0,
      "tiempoProcesamientoMs": 0,
      "ahorroEspacioBytes": 0,
      "porcentajeReduccion": 0.0
    }
  },
  "links": [
    {
      "rel": "string",
      "href": "string",
      "method": "string"
    }
  ],
  "metadata": {
    "version": "string",
    "requestId": "string",
    "correlationId": "string"
  }
}
```

**Error Response**:
```json
{
  "success": false,
  "timestamp": "2024-01-15T10:30:00Z",
  "error": {
    "codigo": "string",
    "mensaje": "string",
    "detalles": [
      {
        "campo": "string",
        "descripcion": "string",
        "valorRecibido": "string"
      }
    ]
  },
  "metadata": {
    "version": "string",
    "requestId": "string",
    "correlationId": "string"
  }
}
```

**Status Codes**:
- 200 OK: Operación exitosa
- 201 Created: Recurso creado exitosamente
- 202 Accepted: Solicitud aceptada para procesamiento asíncrono
- 400 Bad Request: Solicitud inválida
- 401 Unauthorized: No autenticado
- 403 Forbidden: Sin permisos
- 404 Not Found: Recurso no encontrado
- 409 Conflict: Conflicto de estado del recurso
- 422 Unprocessable Entity: Entidad no procesable
- 429 Too Many Requests: Límite de tasa excedido
- 500 Internal Server Error: Error interno del servidor
- 502 Bad Gateway: Error de gateway
- 503 Service Unavailable: Servicio no disponible

---

## 3. Entidades del Dominio

### 3.1 SolicitudProteccion (Aggregate Root)
- `solicitudId`: String
- `tipoOperacion`: String
- `fechaSolicitud`: LocalDateTime
- `fuente`: FuenteDocumento
- `documentos`: List<MetadatosDocumento>
- `configuracion`: ConfiguracionProteccion
- `destinatarios`: List<Destinatario>

### 3.2 FuenteDocumento
- `tipo`: String
- `origen`: String
- `referencia`: ReferenciaRepositorio

### 3.3 ReferenciaRepositorio
- `sistema`: String
- `transaccionId`: String
- `codigoSeguimiento`: String

### 3.4 MetadatosDocumento
- `documentoId`: String
- `nombre`: String
- `tipo`: String
- `tamanioBytes`: Long
- `formatoOriginal`: String
- `metadatos`: DatosMetadatos

### 3.5 DatosMetadatos
- `titulo`: String
- `descripcion`: String
- `autor`: String
- `fechaCreacion`: LocalDateTime
- `clasificacion`: String
- `palabrasClave`: List<String>

### 3.6 ConfiguracionProteccion
- `nivelCompresion`: String
- `algoritmoCifrado`: String
- `clavePublica`: String
- `incluirMetadatos`: Boolean
- `protegerConPassword`: Boolean
- `passwordHash`: String

### 3.7 Destinatario
- `destinatarioId`: String
- `tipo`: String
- `nivelAcceso`: String
- `permisos`: List<String>

### 3.8 RespuestaProteccion (Aggregate Root)
- `success`: Boolean
- `timestamp`: LocalDateTime
- `data`: DataProteccion
- `links`: List<LinksHATEOAS>
- `metadata`: MetadataRespuesta

### 3.9 DataProteccion
- `procesoId`: String
- `solicitudId`: String
- `estado`: String
- `fechaProcesamiento`: LocalDateTime
- `archivosProtegidos`: List<ArchivoProtegido>
- `seguridad`: InformacionSeguridad
- `estadisticas`: EstadisticasCompresion

### 3.10 ArchivoProtegido
- `archivoId`: String
- `documentoOriginalId`: String
- `nombreArchivo`: String
- `formatoProtegido`: String
- `tamanioOriginalBytes`: Long
- `tamanioComprimidoBytes`: Long
- `ratioCompresion`: Double
- `hash`: String
- `algoritmoHash`: String
- `ubicacionAlmacenamiento`: String

### 3.11 InformacionSeguridad
- `algoritmoCifrado`: String
- `nivelSeguridad`: String
- `fechaCifrado`: LocalDateTime
- `huellaCifrado`: String

### 3.12 EstadisticasCompresion
- `totalDocumentos`: Long
- `documentosProcesados`: Long
- `documentosFallidos`: Long
- `tiempoProcesamientoMs`: Long
- `ahorroEspacioBytes`: Long
- `porcentajeReduccion`: Double

### 3.13 LinksHATEOAS
- `rel`: String
- `href`: String
- `method`: String

### 3.14 MetadataRespuesta
- `version`: String
- `requestId`: String
- `correlationId`: String

### 3.15 ErrorResponse
- `success`: Boolean
- `timestamp`: LocalDateTime
- `error`: ErrorDetalle
- `metadata`: MetadataRespuesta

### 3.16 ErrorDetalle
- `codigo`: String
- `mensaje`: String
- `detalles`: List<ErrorItem>

### 3.17 ErrorItem
- `campo`: String
- `descripcion`: String
- `valorRecibido`: String

---

## 4. Operaciones (Use Cases)

Basado en el endpoint único POST, se identifica:

### 4.1 ComprimirYProtegerDocumentosUseCase
- **Operación**: POST /api/v1/documentos/MsProteccionDocumentos/comprimir-proteger
- **Input**: SolicitudProteccion
- **Output**: RespuestaProteccion
- **Descripción**: Procesa la solicitud de compresión y protección de documentos

---

## 5. Validaciones y Reglas de Negocio

### Validaciones de Entrada:
1. `solicitudId` debe ser único y no nulo
2. `tipoOperacion` debe ser un valor válido del catálogo
3. `fechaSolicitud` no puede ser futura
4. Al menos un documento debe estar presente
5. `nivelCompresion` debe ser: NINGUNO, BAJO, MEDIO, ALTO, MAXIMO
6. `algoritmoCifrado` debe ser: AES256, RSA2048, RSA4096
7. Si `protegerConPassword` es true, `passwordHash` es obligatorio
8. `documentoId` debe existir en MsGestorDocumentos
9. `tamanioBytes` debe ser mayor que 0
10. Headers X-Request-ID, X-Correlation-ID, X-Client-ID son obligatorios

### Reglas de Negocio:
1. Si no se especifica configuración, usar valores de MsDatosConfiguracion
2. Comprimir antes de cifrar
3. Generar hash SHA-256 del archivo protegido
4. Registrar auditoría de todas las operaciones
5. Si un documento falla, continuar con los demás
6. Timeout máximo de procesamiento: 5 minutos
7. Tamaño máximo por documento: 100 MB
8. Máximo 10 documentos por solicitud
9. Retener logs de auditoría por 7 años
10. Circuit Breaker para integraciones externas

---

## 6. Integraciones con Otros Servicios

### 6.1 MsDatosConfiguracion
- **Propósito**: Obtener configuración por defecto de compresión y cifrado
- **Operaciones requeridas**:
  - Consultar configuración por tipo de operación
  - Consultar configuración por nivel de seguridad

### 6.2 MsGestorDocumentos
- **Propósito**: Almacenar y recuperar documentos protegidos
- **Operaciones requeridas**:
  - Recuperar documento original por ID
  - Almacenar documento protegido
  - Actualizar metadatos del documento

### Patrones de Integración:
- Circuit Breaker (resilience4j pattern)
- Retry (hasta 3 intentos con backoff exponencial)
- Timeout (5 segundos para llamadas síncronas)

---

## 7. Consideraciones Técnicas

### Arquitectura:
- **Capa de Dominio**: Lógica de negocio pura
- **Capa de Aplicación**: Casos de uso y orquestación
- **Capa de Infraestructura**: Adaptadores para integraciones

### Seguridad:
- Validación de todos los inputs
- Sanitización de datos
- Cifrado en reposo y en tránsito
- Tokens JWT para autenticación

### Observabilidad:
- Logs estructurados (JSON)
- Métricas (Prometheus)
- Trazabilidad distribuida (OpenTelemetry)
- Health checks

---

## 8. Mapeo de Tipos

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer/0 | Long |
| number/0.0 | Double |
| boolean/true/false | Boolean |
| datetime/timestamp | LocalDateTime |
| array | List<T> |

---

## 9. Puertos de Salida Requeridos (MsDominio)

Como es un **MsDominio**, NO se define RepositoryPort. Se definen puertos hacia servicios externos:

### 9.1 ConfiguracionDataPort
- `obtenerConfiguracionPorDefecto()`: ConfiguracionProteccion
- `obtenerConfiguracionPorTipo(String tipo)`: ConfiguracionProteccion

### 9.2 DocumentoDataPort
- `recuperarDocumento(String documentoId)`: MetadatosDocumento
- `almacenarDocumentoProtegido(ArchivoProtegido archivoProtegido)`: String
- `actualizarMetadatos(String documentoId, DatosMetadatos metadatos)`: void

---

## 10. Resumen de Artefactos a Generar

### Domain Layer:
- 17 clases de modelo (POJOs)
- 1 puerto de entrada (ComprimirYProtegerDocumentosUseCase)
- 2 puertos de salida (ConfiguracionDataPort, DocumentoDataPort)

### Application Layer:
- 1 servicio (ComprimirYProtegerDocumentosService)

### Infrastructure Layer:
- Controller: ProteccionDocumentosController
- DTOs: SolicitudProteccionRequestDto, RespuestaProteccionResponseDto, ErrorResponseDto
- Mappers: ProteccionDocumentosDtoMapper
- Adapters: ConfiguracionDataAdapter, DocumentoDataAdapter

### Documentation:
- README.md con toda la información estructurada
