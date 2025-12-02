# MsDominioProteccionDocumentos

## Resumen del Microservicio

**Nombre:** MsDominioProteccionDocumentos  
**Tipo:** Microservicio de Dominio (MsDominio)  
**Versión API:** v1  
**Organización:** RENIEC (Registro Nacional de Identificación y Estado Civil)  
**Plataforma:** SIIRC  
**Proyecto:** DNI Electrónico (DNIe)

### Contexto de Negocio

El Microservicio Protección Documentos es un componente de soporte y utilidad dentro de la plataforma SIIRC, esencial para la seguridad y el manejo eficiente de archivos. Su propósito principal es:

- Implementar la política de seguridad de distribución documental
- Comprimir documentos sensibles
- Generar y asignar una contraseña al archivo comprimido resultante
- Asegurar que cualquier documento creado pueda ser protegido con clave de acceso al momento de su distribución, conforme a la configuración del sistema

### Arquitectura

Este microservicio implementa **Arquitectura Hexagonal estricta** siguiendo los principios de **Domain-Driven Design (DDD)**.

Como **MsDominioXXXX**, este microservicio:
- **NO** define `RepositoryPort` ni maneja persistencia directamente
- Se integra con componentes externos (MsDataXXXX) a través de **puertos de salida** y **adaptadores cliente**
- No define el protocolo de conexión (HTTP/SOAP/colas) - solo interfaces y adaptadores abstractos
- Mantiene la lógica de negocio aislada de consideraciones tecnológicas

---

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/protecciondocumentos/
├── domain/
│   ├── model/
│   │   ├── ProteccionDocumento.java (Aggregate Root)
│   │   ├── SolicitudProteccion.java
│   │   ├── FuenteDocumento.java
│   │   ├── ReferenciaRepositorio.java
│   │   ├── MetadatosSolicitud.java
│   │   ├── ConfiguracionProteccion.java
│   │   ├── Destinatario.java
│   │   ├── ArchivoProtegido.java
│   │   ├── InformacionSeguridad.java
│   │   ├── EstadisticasCompresion.java
│   │   └── LinksHATEOAS.java
│   └── ports/
│       ├── in/
│       │   └── CrearProteccionDocumentoUseCase.java
│       └── out/
│           ├── ProteccionDocumentoDataPort.java
│           ├── ConfiguracionDataPort.java
│           └── GestorDocumentosDataPort.java
├── application/
│   └── service/
│       └── CrearProteccionDocumentoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── ProteccionDocumentoController.java
        │       ├── dto/
        │       │   ├── ProteccionDocumentoRequestDto.java
        │       │   ├── ProteccionDocumentoResponseDto.java
        │       │   ├── ProteccionDocumentoDataDto.java
        │       │   ├── FuenteDocumentoDto.java
        │       │   ├── MetadatosSolicitudDto.java
        │       │   ├── ConfiguracionProteccionDto.java
        │       │   ├── DestinatarioDto.java
        │       │   ├── ReferenciaRepositorioDto.java
        │       │   ├── ArchivoProtegidoDto.java
        │       │   ├── InformacionSeguridadDto.java
        │       │   ├── EstadisticasCompresionDto.java
        │       │   ├── LinksDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   ├── ErrorDto.java
        │       │   └── DetalleErrorDto.java
        │       └── mapper/
        │           └── ProteccionDocumentoDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    ├── ProteccionDocumentoDataAdapter.java
                    ├── ConfiguracionDataAdapter.java
                    └── GestorDocumentosDataAdapter.java
```

---

## Endpoints

### POST /api/v1/documentos/MsProteccionDocumentos/comprimir-proteger

Comprimir y proteger un documento con contraseña.

#### Headers

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación |
| `Content-Type` | String | Sí | `application/json` |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad |
| `X-Office-Code` | String | Opcional | Código de oficina/sede |
| `X-User-Role` | String | Opcional | Rol del usuario |
| `X-Request-Source` | String | Opcional | Origen: WEB, MOBILE, KIOSK, API_EXTERNA |
| `X-Idempotency-Key` | UUID | Opcional | Clave para evitar operaciones duplicadas |

#### Request Body

```json
{
  "solicitudId": "550e8400-e29b-41d4-a716-446655440000",
  "tipoDocumento": "DNI",
  "nombreArchivo": "documento_protegido.pdf",
  "fuenteDocumento": {
    "tipo": "REPOSITORIO",
    "contenidoBase64": null,
    "referenciaRepositorio": {
      "repositorioId": "REPO-001",
      "documentoId": "650e8400-e29b-41d4-a716-446655440000",
      "versionId": "v1"
    }
  },
  "metadatos": {
    "tipoTramite": "EMISION_DNI",
    "numeroSolicitud": "SOL-2025-001234",
    "dniSolicitante": "12345678",
    "fechaGeneracion": "2025-12-01T10:30:00-05:00"
  },
  "configuracionProteccion": {
    "usarConfiguracionPorDefecto": true,
    "algoritmoCompresion": null,
    "nivelCompresion": null
  },
  "destinatario": {
    "email": "ciudadano@example.com",
    "telefono": "+51987654321",
    "nombreCompleto": "Juan Pérez García"
  }
}
```

#### Response Body (Éxito - 201)

```json
{
  "success": true,
  "data": {
    "proteccionId": "750e8400-e29b-41d4-a716-446655440000",
    "solicitudId": "550e8400-e29b-41d4-a716-446655440000",
    "archivoProtegido": {
      "repositorioId": "REPO-001",
      "documentoId": "850e8400-e29b-41d4-a716-446655440000",
      "nombreArchivo": "documento_protegido.zip",
      "tamanioBytes": 1048576,
      "formatoSalida": "ZIP",
      "checksumSHA256": "abc123def456..."
    },
    "seguridad": {
      "passwordHashSHA512": "def789ghi012...",
      "algoritmoUtilizado": "AES-256",
      "longitudPassword": 16,
      "fechaGeneracion": "2025-12-01T10:30:15-05:00",
      "fechaExpiracion": "2026-01-01T10:30:15-05:00"
    },
    "compresion": {
      "algoritmo": "ZIP",
      "nivelCompresion": "MEDIUM",
      "tamanioOriginal": 2097152,
      "tamanioComprimido": 1048576,
      "ratioCompresion": 0.5
    },
    "estado": "COMPLETADO",
    "fechaProcesamiento": "2025-12-01T10:30:15-05:00",
    "_links": {
      "self": "/api/v1/documentos/protecciones/750e8400-e29b-41d4-a716-446655440000",
      "descargar": "/api/v1/documentos/protecciones/750e8400-e29b-41d4-a716-446655440000/descargar",
      "verificar": "/api/v1/documentos/protecciones/750e8400-e29b-41d4-a716-446655440000/verificar"
    }
  },
  "metadata": {
    "timestamp": "2025-12-01T10:30:15-05:00",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000",
    "version": "v1",
    "tiempoRespuesta": "150ms"
  }
}
```

#### Error Response

```json
{
  "error": {
    "tipo": "VALIDATION_ERROR",
    "titulo": "Datos de entrada inválidos",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El campo 'solicitudId' es obligatorio y debe ser un UUID válido"
      }
    ]
  }
}
```

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| **201** | Created | Documento comprimido y protegido exitosamente |
| **400** | Bad Request | Datos inválidos o formato de documento incorrecto |
| **401** | Unauthorized | Token JWT inválido o expirado |
| **403** | Forbidden | Usuario sin permisos para proteger documentos |
| **404** | Not Found | Documento de origen no encontrado en repositorio |
| **409** | Conflict | El documento ya fue protegido anteriormente |
| **413** | Payload Too Large | El documento excede el tamaño máximo permitido |
| **422** | Unprocessable Entity | Documento válido pero no procesable (ej: no es PDF, no está firmado) |
| **429** | Too Many Requests | Límite de rate limit excedido |
| **500** | Internal Server Error | Error interno del servidor |
| **502** | Bad Gateway | Error de comunicación con MsDatosConfiguracion o MsGestorDocumentos |
| **503** | Service Unavailable | Servicio temporalmente no disponible |

---

## Entidades del Dominio

### ProteccionDocumento (Aggregate Root)
- `proteccionId`: String (UUID)
- `solicitudId`: String (UUID)
- `archivoProtegido`: ArchivoProtegido
- `seguridad`: InformacionSeguridad
- `compresion`: EstadisticasCompresion
- `estado`: String (COMPLETADO, ERROR)
- `fechaProcesamiento`: LocalDateTime
- `links`: LinksHATEOAS

### SolicitudProteccion
- `solicitudId`: String (UUID, 36 caracteres)
- `tipoDocumento`: String (3-50 caracteres)
- `nombreArchivo`: String (5-200 caracteres)
- `fuenteDocumento`: FuenteDocumento
- `metadatos`: MetadatosSolicitud
- `configuracionProteccion`: ConfiguracionProteccion
- `destinatario`: Destinatario

### FuenteDocumento
- `tipo`: String (5-20 caracteres) - Valores: BASE64, REPOSITORIO
- `contenidoBase64`: String (Condicional)
- `referenciaRepositorio`: ReferenciaRepositorio (Condicional)

### ReferenciaRepositorio
- `repositorioId`: String (3-50 caracteres)
- `documentoId`: String (UUID, 36 caracteres)
- `versionId`: String (1-20 caracteres, Opcional)

### MetadatosSolicitud
- `tipoTramite`: String (3-50 caracteres)
- `numeroSolicitud`: String (5-30 caracteres)
- `dniSolicitante`: String (8 caracteres)
- `fechaGeneracion`: LocalDateTime

### ConfiguracionProteccion
- `usarConfiguracionPorDefecto`: Boolean
- `algoritmoCompresion`: String (3-20 caracteres, Opcional)
- `nivelCompresion`: String (4-10 caracteres, Opcional)

### Destinatario
- `email`: String (5-254 caracteres, Opcional)
- `telefono`: String (7-15 caracteres, Opcional)
- `nombreCompleto`: String (3-200 caracteres, Opcional)

### ArchivoProtegido
- `repositorioId`: String
- `documentoId`: String
- `nombreArchivo`: String
- `tamanioBytes`: Long
- `formatoSalida`: String (ZIP)
- `checksumSHA256`: String

### InformacionSeguridad
- `passwordHashSHA512`: String
- `algoritmoUtilizado`: String
- `longitudPassword`: Integer (16 caracteres)
- `fechaGeneracion`: LocalDateTime
- `fechaExpiracion`: LocalDateTime (Opcional)

### EstadisticasCompresion
- `algoritmo`: String
- `nivelCompresion`: String
- `tamanioOriginal`: Long (bytes)
- `tamanioComprimido`: Long (bytes)
- `ratioCompresion`: Double

### LinksHATEOAS
- `self`: String (URL)
- `descargar`: String (URL)
- `verificar`: String (URL)

---

## Mapeo de Tipos de Datos

| Tipo en Especificación | Tipo Java | Notas |
|------------------------|-----------|-------|
| string | String | Cadena de texto |
| integer/int | Long | Números enteros |
| number/decimal/double | Double | Números decimales |
| boolean | Boolean | Verdadero/Falso |
| date | LocalDate | Solo fecha (sin hora) |
| datetime/timestamp | LocalDateTime | Fecha y hora (formato ISO 8601) |
| array/list | List<T> | Colecciones |

---

## Reglas de Negocio

1. **Política de Seguridad**: El microservicio implementa la política de seguridad de distribución documental de RENIEC
2. **Protección con Contraseña**: Todo documento comprimido debe ser protegido con una contraseña generada automáticamente de 16 caracteres
3. **Hash de Seguridad**: Se utiliza SHA-512 para hashear la contraseña y SHA-256 para el checksum del archivo
4. **Formato de Salida**: El archivo resultante siempre es en formato ZIP
5. **Condicionalidad de Fuente**: El campo `contenidoBase64` o `referenciaRepositorio` son condicionales - se usa uno u otro según el tipo de fuente
6. **Validación de DNI**: El DNI del solicitante debe tener exactamente 8 caracteres
7. **UUID Estándar**: Los identificadores (`solicitudId`, `documentoId`, `proteccionId`) deben ser UUIDs de 36 caracteres
8. **Idempotencia**: Se utiliza `X-Idempotency-Key` para evitar operaciones duplicadas
9. **Trazabilidad**: Todas las operaciones deben incluir `X-Correlation-ID` para trazabilidad end-to-end
10. **HATEOAS**: Las respuestas incluyen enlaces para operaciones relacionadas (self, descargar, verificar)
11. **Configuración por Defecto**: El sistema puede usar configuración por defecto si no se especifica algoritmo o nivel de compresión

---

## Integraciones con Microservicios Externos

Este microservicio se integra con los siguientes componentes externos mediante **puertos de salida** y **adaptadores cliente**:

### 1. MsDatosConfiguracion
**Puerto:** `ConfiguracionDataPort`  
**Adaptador:** `ConfiguracionDataAdapter`  
**Operaciones:**
- `obtenerConfiguracionPorDefecto()`: Obtiene la configuración de compresión y protección por defecto
- `validarConfiguracion(ConfiguracionProteccion)`: Valida una configuración personalizada

### 2. MsGestorDocumentos
**Puerto:** `GestorDocumentosDataPort`  
**Adaptador:** `GestorDocumentosDataAdapter`  
**Operaciones:**
- `obtenerDocumento(String, String, String)`: Recupera un documento del repositorio
- `almacenarDocumentoProtegido(String, byte[], String)`: Almacena el documento protegido

### 3. MsDataProteccionDocumentos
**Puerto:** `ProteccionDocumentoDataPort`  
**Adaptador:** `ProteccionDocumentoDataAdapter`  
**Operaciones:**
- `guardarProteccionDocumento(ProteccionDocumento)`: Persiste el registro de protección
- `obtenerProteccionDocumentoPorId(String)`: Recupera una protección por ID
- `existeProteccionPorSolicitudId(String)`: Verifica si ya existe protección para una solicitud

---

## Arquitectura Hexagonal - Características

### Tipo: MsDominio

Este es un **microservicio de dominio** (`MsDominioXXXX`), por lo tanto:

#### ✅ Lo que SÍ tiene:
- **Puertos de entrada (in)**: Interfaces que definen los casos de uso del dominio
- **Puertos de salida (out)**: Interfaces hacia componentes externos (MsDataXXXX)
- **Adaptadores cliente**: Implementaciones de puertos out para integración con servicios externos
- **Servicios de aplicación**: Coordinan la lógica de negocio
- **Modelos de dominio**: POJOs puros sin dependencias tecnológicas
- **Adaptadores REST**: Controllers, DTOs (records) y Mappers para exposición HTTP

#### ❌ Lo que NO tiene:
- **RepositoryPort**: No maneja persistencia directamente
- **RepositoryAdapter**: No implementa acceso a bases de datos
- **Entities de persistencia**: No define entidades JPA/ORM
- **Anotaciones de framework**: Sin Spring, JPA, JAX-RS, etc.
- **Protocolo de comunicación definido**: Las integraciones no especifican HTTP/SOAP/mensajería

---

## Limitaciones

### Neutralidad Tecnológica

Este proyecto está diseñado para ser **neutral tecnológicamente**:

1. **Sin Frameworks**: No se utilizan Spring, JAX-RS, JPA, MapStruct ni ningún otro framework
2. **Java Puro**: Todo el código es Java estándar compilable sin dependencias externas
3. **Sin Anotaciones**: Las clases son POJOs simples sin anotaciones de frameworks
4. **Sin Protocolo Definido**: Los adaptadores de salida no implementan protocolos específicos (HTTP, SOAP, colas)
5. **Sin Build Configuration**: No se incluye `pom.xml`, `build.gradle` ni archivos de configuración de build

### Implementaciones Stub

Los siguientes componentes contienen implementaciones stub que lanzan `UnsupportedOperationException`:

- **CrearProteccionDocumentoService**: Lógica de compresión y protección no implementada
- **ConfiguracionDataAdapter**: Integración con MsDatosConfiguracion no implementada
- **GestorDocumentosDataAdapter**: Integración con MsGestorDocumentos no implementada
- **ProteccionDocumentoDataAdapter**: Integración con MsDataProteccionDocumentos no implementada

Estas implementaciones deben ser completadas en fases posteriores cuando se defina:
- El framework a utilizar (Spring Boot, Quarkus, Micronaut, etc.)
- Los protocolos de comunicación (REST HTTP, SOAP, mensajería, gRPC, etc.)
- Las tecnologías de persistencia (si aplican en este microservicio)
- Las librerías de compresión y seguridad específicas

### Sin Gestión de Errores Real

El manejo de errores y conversión a códigos HTTP está documentado pero no implementado. En una implementación real con framework:
- Se implementarían exception handlers globales
- Se mapearían excepciones de dominio a códigos HTTP apropiados
- Se aplicarían patrones Circuit Breaker, Retry y Timeout
- Se implementaría logging estructurado y distributed tracing

---

## Próximos Pasos para Implementación Completa

1. **Seleccionar Stack Tecnológico**: Decidir frameworks (Spring Boot, etc.)
2. **Definir Protocolos de Integración**: HTTP REST, SOAP, mensajería, etc.
3. **Implementar Lógica de Compresión**: Usar librerías como Apache Commons Compress
4. **Implementar Seguridad**: Generación de passwords y hashing (SHA-512, SHA-256)
5. **Completar Adaptadores**: Implementar clientes HTTP/SOAP para servicios externos
6. **Agregar Manejo de Errores**: Exception handlers y mapeo a status codes
7. **Configuración**: Properties/YAML para configuración de aplicación
8. **Testing**: Unit tests, integration tests, contract tests
9. **Observabilidad**: Logging, métricas, distributed tracing
10. **Documentación OpenAPI**: Generar Swagger/OpenAPI specification

---

## Notas Adicionales

- **Versión del Documento**: 1.0
- **Fecha de Generación**: 01/12/2025
- **Base Package**: `pe.gob.reniec.protecciondocumentos`
- **Código Fuente**: Estructura completa bajo `src/main/java/`
- **Patrón Arquitectónico**: Hexagonal (Ports & Adapters)
- **Principios de Diseño**: DDD, SOLID, Clean Architecture

Este proyecto representa únicamente la **estructura base y los artefactos de dominio** siguiendo Arquitectura Hexagonal estricta. La implementación tecnológica completa requiere decisiones adicionales sobre frameworks y protocolos de integración.
