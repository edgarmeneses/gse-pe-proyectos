# MsDominioProteccionDocumentos

## Resumen del Microservicio

**Nombre**: MsDominioProteccionDocumentos  
**Tipo**: Microservicio de Dominio (MsDominio)  
**Versión del API**: v1  
**Contexto de Negocio**: Microservicio de dominio que implementa la lógica de negocio para protección de documentos mediante compresión y cifrado. Forma parte de la plataforma SIIRC (Sistema Integrado de Información del Registro Civil) de RENIEC.

## Arquitectura

Este microservicio sigue los principios de **Arquitectura Hexagonal** (Ports & Adapters) y **Domain-Driven Design (DDD)**, implementado en **Java puro** sin dependencias de frameworks externos.

### Tipo de Microservicio: MsDominio

Como microservicio de dominio:
- **NO define RepositoryPort** (no accede directamente a base de datos)
- Se integra con servicios externos (MsDatosConfiguracion y MsGestorDocumentos) a través de **puertos de salida** (`ConfiguracionDataPort`, `DocumentoDataPort`)
- Los **adaptadores** implementan la comunicación con estos servicios externos (sin asumir protocolo HTTP/SOAP/colas)

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/protecciondocumentos/
├── domain/
│   ├── model/                           # Modelos del dominio (POJOs puros)
│   │   ├── SolicitudProteccion.java     # Aggregate Root
│   │   ├── RespuestaProteccion.java     # Aggregate Root
│   │   ├── FuenteDocumento.java
│   │   ├── ReferenciaRepositorio.java
│   │   ├── MetadatosDocumento.java
│   │   ├── DatosMetadatos.java
│   │   ├── ConfiguracionProteccion.java
│   │   ├── Destinatario.java
│   │   ├── DataProteccion.java
│   │   ├── ArchivoProtegido.java
│   │   ├── InformacionSeguridad.java
│   │   ├── EstadisticasCompresion.java
│   │   ├── LinksHATEOAS.java
│   │   ├── MetadataRespuesta.java
│   │   ├── ErrorResponse.java
│   │   ├── ErrorDetalle.java
│   │   └── ErrorItem.java
│   └── ports/
│       ├── in/                          # Puertos de entrada (casos de uso)
│       │   └── ComprimirYProtegerDocumentosUseCase.java
│       └── out/                         # Puertos de salida (hacia MsData)
│           ├── ConfiguracionDataPort.java
│           └── DocumentoDataPort.java
├── application/
│   └── service/                         # Servicios de aplicación
│       └── ComprimirYProtegerDocumentosService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── ProteccionDocumentosController.java
        │       ├── dto/
        │       │   ├── SolicitudProteccionRequestDto.java
        │       │   ├── RespuestaProteccionResponseDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── ProteccionDocumentosDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    ├── ConfiguracionDataAdapter.java
                    └── DocumentoDataAdapter.java
```

## Endpoints

### POST /api/v1/documentos/MsProteccionDocumentos/comprimir-proteger

Comprime y protege documentos con configuración de seguridad específica.

**Headers Requeridos:**
- `X-Request-ID`: String (UUID único de la solicitud)
- `X-Correlation-ID`: String (ID de correlación para trazabilidad)
- `X-Client-ID`: String (Identificador del cliente/aplicación)
- `X-User-ID`: String (Identificador del usuario)
- `X-Tenant-ID`: String (Identificador del tenant/organización)
- `Content-Type`: application/json
- `Accept`: application/json

**Request Body:**
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

**Response Body (200 OK):**
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

**Error Response:**
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

**Status Codes:**
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente
- `202 Accepted` - Solicitud aceptada para procesamiento asíncrono
- `400 Bad Request` - Solicitud inválida
- `401 Unauthorized` - No autenticado
- `403 Forbidden` - Sin permisos
- `404 Not Found` - Recurso no encontrado
- `409 Conflict` - Conflicto de estado del recurso
- `422 Unprocessable Entity` - Entidad no procesable
- `429 Too Many Requests` - Límite de tasa excedido
- `500 Internal Server Error` - Error interno del servidor
- `502 Bad Gateway` - Error de gateway
- `503 Service Unavailable` - Servicio no disponible

## Entidades del Dominio

### Aggregate Roots

1. **SolicitudProteccion** - Solicitud de compresión y protección de documentos
2. **RespuestaProteccion** - Respuesta del procesamiento de protección

### Value Objects

- **FuenteDocumento** - Información de la fuente del documento
- **ReferenciaRepositorio** - Referencia a sistemas externos
- **MetadatosDocumento** - Metadatos de un documento
- **DatosMetadatos** - Datos descriptivos del documento
- **ConfiguracionProteccion** - Configuración de compresión y cifrado
- **Destinatario** - Información de destinatarios
- **DataProteccion** - Datos del resultado de protección
- **ArchivoProtegido** - Información de archivo protegido
- **InformacionSeguridad** - Información de seguridad aplicada
- **EstadisticasCompresion** - Estadísticas del procesamiento
- **LinksHATEOAS** - Enlaces de navegación REST
- **MetadataRespuesta** - Metadatos de respuesta
- **ErrorResponse** - Respuesta de error
- **ErrorDetalle** - Detalle de error
- **ErrorItem** - Item de error específico

## Mapeo de Tipos de Datos

| Tipo en JSON | Tipo en Java |
|--------------|--------------|
| string | String |
| integer (0) | Long |
| number (0.0) | Double |
| boolean | Boolean |
| datetime/timestamp | LocalDateTime |
| array | List<T> |

## Validaciones y Reglas de Negocio

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

## Integraciones con Otros Servicios

### MsDatosConfiguracion
**Propósito**: Obtener configuración por defecto de compresión y cifrado  
**Puerto**: `ConfiguracionDataPort`  
**Operaciones**:
- `obtenerConfiguracionPorDefecto()`: ConfiguracionProteccion
- `obtenerConfiguracionPorTipo(String tipo)`: ConfiguracionProteccion

### MsGestorDocumentos
**Propósito**: Almacenar y recuperar documentos protegidos  
**Puerto**: `DocumentoDataPort`  
**Operaciones**:
- `recuperarDocumento(String documentoId)`: MetadatosDocumento
- `almacenarDocumentoProtegido(ArchivoProtegido archivoProtegido)`: String
- `actualizarMetadatos(String documentoId, DatosMetadatos metadatos)`: void

### Patrones de Integración:
- **Circuit Breaker** (resilience4j pattern)
- **Retry** (hasta 3 intentos con backoff exponencial)
- **Timeout** (5 segundos para llamadas síncronas)

## Casos de Uso

### ComprimirYProtegerDocumentosUseCase
**Operación**: Comprimir y proteger documentos  
**Input**: SolicitudProteccion  
**Output**: RespuestaProteccion  
**Servicio**: ComprimirYProtegerDocumentosService

## Limitaciones

### Neutralidad Tecnológica
- **Sin frameworks**: El código no utiliza Spring, JAX-RS, JPA ni ningún framework
- **Sin anotaciones**: Todas las clases son POJOs puros de Java
- **Sin protocolo definido**: Los adaptadores de salida no especifican HTTP, SOAP o colas
- **Sin implementación de persistencia**: Los métodos lanzan `UnsupportedOperationException`

### Implementación Pendiente
Los siguientes componentes requieren implementación concreta:
- Lógica de compresión de documentos
- Lógica de cifrado de documentos
- Generación de hash SHA-256
- Comunicación real con MsDatosConfiguracion
- Comunicación real con MsGestorDocumentos
- Manejo de errores y excepciones
- Circuit Breaker y Retry
- Logging y auditoría

## Consideraciones de Seguridad

- Validación de todos los inputs
- Sanitización de datos
- Cifrado en reposo y en tránsito
- Tokens JWT para autenticación (no implementado en este código base)
- Políticas de distribución documental según nivel de acceso

## Observabilidad

Recomendaciones para implementación futura:
- **Logs estructurados** (JSON format)
- **Métricas** (Prometheus)
- **Trazabilidad distribuida** (OpenTelemetry)
- **Health checks** (endpoints /health, /ready)

## Compilación

Este proyecto es Java puro sin dependencias externas. Para compilar:

```bash
javac -d bin -sourcepath src/main/java src/main/java/pe/gob/reniec/protecciondocumentos/**/*.java
```

## Notas Importantes

1. **Este es código de estructura**, no de implementación funcional
2. **Los métodos lanzan UnsupportedOperationException** indicando que la lógica debe ser implementada
3. **No hay pom.xml** para mantener neutralidad tecnológica
4. **La arquitectura es deliberadamente agnóstica** respecto a frameworks y protocolos
5. **Toda la información fue extraída del PDF de especificación** sin asumir detalles adicionales

## Referencias

- **PDF de Especificación**: Microservicio MsDominioProteccionDocumentos V1.0.pdf
- **Arquitectura Hexagonal**: Ports & Adapters Pattern
- **Domain-Driven Design**: Aggregate Roots y Value Objects
- **Plataforma**: SIIRC (Sistema Integrado de Información del Registro Civil) - RENIEC
