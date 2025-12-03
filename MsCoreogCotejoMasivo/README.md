# Microservicio MsCoreogCotejoMasivo

## 📋 Información General

- **Nombre**: MsCoreogCotejoMasivo (Microservicio Coreógrafo de Cotejo Masivo)
- **Tipo**: Microservicio de Coreografía
- **Versión API**: v1
- **Paquete Base**: `pe.gob.reniec.coreografia.cotejomasivo`
- **Arquitectura**: Hexagonal (Ports & Adapters)
- **Patrón**: Domain-Driven Design (DDD)

---

## 🎯 Propósito

El Microservicio Coreógrafo de Cotejo Masivo coordina y gestiona el flujo de trabajo asíncrono para el proceso de cotejo masivo de ciudadanos en el Registro Nacional de Identificación y Estado Civil (RENIEC).

**Responsabilidades principales**:
- Recibir solicitudes de cotejo masivo vía API REST
- Validar solicitudes y datos de entrada
- Coordinar flujo asíncrono entre MsDominioCotejoMasivo y MsDatosCotejoMasivo
- Publicar eventos de inicio de cotejo a Apache Kafka
- Retornar respuesta síncrona con información de la solicitud registrada

---

## 🏗️ Arquitectura

### Tipo de Microservicio

Este es un **Microservicio de Coreografía** (similar a MsDominio), por lo tanto:
- ❌ **NO define** `RepositoryPort` (no accede directamente a base de datos)
- ✅ **SÍ define** puertos de salida (`CotejoMasivoDataPort`) hacia:
  - MsDominioCotejoMasivo (procesamiento intensivo)
  - MsDatosCotejoMasivo (persistencia)
- ✅ Implementa adaptador cliente (`CotejoMasivoDataAdapter`) sin tecnología específica
- ✅ Comunicación asíncrona vía eventos (Apache Kafka)

### Arquitectura Hexagonal

```
┌─────────────────────────────────────────────────────────────────┐
│                        INFRAESTRUCTURA                          │
│  ┌────────────────────┐              ┌──────────────────────┐   │
│  │   Adaptador IN     │              │   Adaptador OUT      │   │
│  │  (REST Controller) │              │  (DataAdapter)       │   │
│  └────────┬───────────┘              └──────────┬───────────┘   │
│           │                                     │               │
│           │  DTO                                │               │
│           │                                     │               │
├───────────┼─────────────────────────────────────┼───────────────┤
│           │           APLICACIÓN                │               │
│           ▼                                     │               │
│  ┌────────────────────┐                        │               │
│  │     Service        │                        │               │
│  │ IniciarCotejo...   │◄───────────────────────┘               │
│  └────────┬───────────┘                                        │
│           │                                                     │
├───────────┼─────────────────────────────────────────────────────┤
│           │             DOMINIO                                 │
│           ▼                                                     │
│  ┌────────────────────┐              ┌──────────────────────┐  │
│  │   Puerto IN        │              │    Puerto OUT        │  │
│  │   (UseCase)        │              │  CotejoMasivoData... │  │
│  └────────────────────┘              └──────────────────────┘  │
│                                                                 │
│  ┌──────────────────────────────────────────────────────────┐  │
│  │              Entidades del Dominio                       │  │
│  │  Solicitud, EntidadSolicitante, RegistroCotejo, etc.    │  │
│  └──────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
```

---

## 📡 Endpoints

### POST /api/v1/ciudadano/MsCoreogCotejoMasivo

Inicia el proceso de cotejo masivo de forma síncrona.

#### Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación |
| `Content-Type` | String | Sí | "application/json" |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad |
| `X-Office-Code` | String | Sí | Código de oficina desde donde se realiza la operación |
| `X-User-Role` | String | Sí | Rol del usuario (ejemplo: TECNICO_COTEJO) |
| `X-Request-Source` | String | Sí | Origen: WEB, API_EXTERNA, BATCH |
| `X-Idempotency-Key` | UUID | Sí | Clave para evitar procesamientos duplicados |

#### Request Body

```json
{
  "solicitud": {
    "numeroSolicitud": "SOL-2025-00001",
    "tipoTramite": "COTEJO_MASIVO",
    "fechaSolicitud": "2025-12-03T10:30:00Z",
    "prioridad": "ALTA"
  },
  "entidadSolicitante": {
    "codigo": "ENT-001",
    "nombre": "Banco de la Nación",
    "ruc": "12345678901",
    "representanteLegal": {
      "dni": "12345678",
      "nombres": "Juan Carlos",
      "apellidoPaterno": "Pérez",
      "apellidoMaterno": "García"
    },
    "contacto": {
      "email": "contacto@banco.gob.pe",
      "telefono": "01234567"
    }
  },
  "registrosCotejo": [
    {
      "secuencia": 1,
      "numeroDni": "87654321",
      "apellidoPaterno": "López",
      "apellidoMaterno": "Martínez",
      "nombres": "María Elena",
      "fechaNacimiento": "1990-05-15T00:00:00Z",
      "genero": "FEMENINO"
    }
  ],
  "configuracionProceso": {
    "notificarProgreso": true,
    "generarReporteDetallado": true,
    "formatoReporte": "PDF"
  },
  "documentoSolicitud": {
    "tipo": "OFICIO",
    "nombre": "oficio-solicitud.pdf",
    "urlDocumento": "https://storage.reniec.gob.pe/documentos/...",
    "hashDocumento": "abc123..."
  },
  "observaciones": "Cotejo masivo para validación de identidad"
}
```

#### Response Body (201 Created)

```json
{
  "success": true,
  "data": {
    "solicitudId": "uuid-generated",
    "numeroSolicitud": "SOL-2025-00001",
    "estado": "REGISTRADA",
    "tipoTramite": "COTEJO_MASIVO",
    "entidadSolicitante": {
      "codigo": "ENT-001",
      "nombre": "Banco de la Nación"
    },
    "fechaRegistro": "2025-12-03T10:30:05Z",
    "usuarioRegistro": "TECNICO_COTEJO",
    "oficinaRegistro": {
      "codigo": "OF-001",
      "nombre": "Oficina Lima Centro"
    },
    "resumenSolicitud": {
      "totalRegistros": 1,
      "prioridad": "ALTA",
      "tiempoEstimadoProcesamiento": "PT30M"
    },
    "siguientesPasos": [],
    "urlSeguimiento": "/api/v1/ciudadano/MsCoreogCotejoMasivo/uuid-generated",
    "eventosGenerados": [
      {
        "eventId": "event-uuid",
        "eventType": "COTEJO_MASIVO_INICIADO",
        "topic": "reniec.cotejo.masivo.iniciado"
      }
    ],
    "_links": {
      "self": "/api/v1/ciudadano/MsCoreogCotejoMasivo/uuid-generated",
      "consultarEstado": "/api/v1/ciudadano/MsCoreogCotejoMasivo/uuid-generated/estado",
      "cancelar": "/api/v1/ciudadano/MsCoreogCotejoMasivo/uuid-generated/cancelar"
    }
  },
  "metadata": {
    "timestamp": "2025-12-03T10:30:05Z",
    "correlationId": "correlation-uuid",
    "version": "v1",
    "tiempoRespuesta": "150ms"
  }
}
```

#### Status Codes HTTP

| Código | Descripción |
|--------|-------------|
| 201 | Created - Solicitud de cotejo masivo creada exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Usuario sin permisos para iniciar cotejo masivo |
| 404 | Not Found - Entidad solicitante no encontrada |
| 409 | Conflict - Solicitud duplicada (mismo número o idempotency key) |
| 413 | Payload Too Large - Más de 10,000 registros |
| 422 | Unprocessable Entity - Datos no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servidor |
| 502 | Bad Gateway - Error al comunicarse con Apache Kafka |
| 503 | Service Unavailable - Servicio temporalmente no disponible |

---

## 📦 Entidades del Dominio

### 1. Solicitud
- `numeroSolicitud`: String (10-20 caracteres)
- `tipoTramite`: String (5-30 caracteres)
- `fechaSolicitud`: LocalDateTime
- `prioridad`: String (4-10 caracteres) - Valores: ALTA, MEDIA, BAJA, URGENTE

### 2. EntidadSolicitante
- `codigo`: String (3-20 caracteres)
- `nombre`: String (5-200 caracteres)
- `ruc`: String (11 caracteres, opcional)
- `representanteLegal`: RepresentanteLegal
- `contacto`: Contacto

### 3. RepresentanteLegal
- `dni`: String (8 caracteres)
- `nombres`: String (2-100 caracteres)
- `apellidoPaterno`: String (2-60 caracteres)
- `apellidoMaterno`: String (2-60 caracteres)

### 4. Contacto
- `email`: String (5-254 caracteres, formato RFC 5322)
- `telefono`: String (7-15 caracteres, opcional)

### 5. RegistroCotejo
- `secuencia`: Integer
- `numeroDni`: String (8 caracteres)
- `apellidoPaterno`: String (2-60 caracteres)
- `apellidoMaterno`: String (2-60 caracteres)
- `nombres`: String (2-100 caracteres)
- `fechaNacimiento`: LocalDateTime (opcional)
- `genero`: String (1-20 caracteres, opcional)

### 6. ConfiguracionProceso
- `notificarProgreso`: Boolean
- `generarReporteDetallado`: Boolean
- `formatoReporte`: String (3-10 caracteres) - Valores: PDF, EXCEL, CSV, JSON

### 7. DocumentoSolicitud
- `tipo`: String (3-50 caracteres)
- `nombre`: String (5-200 caracteres)
- `urlDocumento`: String (10-500 caracteres)
- `hashDocumento`: String (64 caracteres SHA-256, opcional)

### 8. OficinaRegistro
- `codigo`: String
- `nombre`: String

### 9. ResumenSolicitud
- `totalRegistros`: Integer
- `prioridad`: String
- `tiempoEstimadoProcesamiento`: String (formato ISO 8601 Duration)

### 10. SiguientePaso
- `paso`: String
- `descripcion`: String

### 11. EventoGenerado
- `eventId`: String (UUID)
- `eventType`: String
- `topic`: String

### 12. Links (HATEOAS)
- `self`: String (URI)
- `consultarEstado`: String (URI)
- `cancelar`: String (URI, opcional)

### 13. Metadata
- `timestamp`: LocalDateTime
- `correlationId`: String (UUID)
- `version`: String
- `tiempoRespuesta`: String

### 14. Error
- `tipo`: String
- `titulo`: String
- `estado`: Integer
- `errores`: List<ErrorDetalle>

### 15. ErrorDetalle
- `campo`: String
- `detalleError`: String

---

## 🔧 Reglas de Negocio

### Validaciones de Entrada

1. **Límite de Registros**: Entre 1 y 10,000 registros por solicitud
2. **Formato DNI**: Exactamente 8 dígitos numéricos
3. **Formato RUC**: Exactamente 11 dígitos numéricos
4. **Formato Email**: Debe cumplir RFC 5322 (5-254 caracteres)
5. **Formato Teléfono**: 7-15 caracteres
6. **Fechas**: Formato ISO 8601 (YYYY-MM-DDThh:mm:ssZ)
7. **Hash Documento**: Exactamente 64 caracteres (SHA-256)
8. **Secuencia**: Correlativa y única dentro del array

### Validaciones de Negocio

1. **Entidad Solicitante**: Debe existir en el sistema
2. **Número de Solicitud**: No debe duplicarse
3. **Idempotency Key**: No debe duplicarse en solicitudes activas
4. **Estado Inicial**: Todas las solicitudes inician como "REGISTRADA"
5. **Tiempo Estimado**: Calculado según registros y prioridad

---

## 🔗 Dependencias con Otros Microservicios

### MsDominioCotejoMasivo
- **Tipo**: Microservicio de Dominio
- **Función**: Procesamiento intensivo de cotejos
- **Relación**: Recibe eventos para procesar
- **Comunicación**: Apache Kafka (asíncrona)

### MsDatosCotejoMasivo
- **Tipo**: Microservicio de Datos
- **Función**: Persistencia de solicitudes y resultados
- **Relación**: Almacena datos de solicitudes
- **Comunicación**: Apache Kafka (asíncrona)

### Apache Kafka
- **Tipo**: Event Streaming Platform
- **Función**: Comunicación asíncrona
- **Topics**: `reniec.cotejo.masivo.iniciado`

---

## 📁 Estructura del Proyecto

```
src/main/java/pe/gob/reniec/coreografia/cotejomasivo/
│
├── domain/
│   ├── model/
│   │   ├── Solicitud.java
│   │   ├── EntidadSolicitante.java
│   │   ├── RepresentanteLegal.java
│   │   ├── Contacto.java
│   │   ├── RegistroCotejo.java
│   │   ├── ConfiguracionProceso.java
│   │   ├── DocumentoSolicitud.java
│   │   ├── OficinaRegistro.java
│   │   ├── ResumenSolicitud.java
│   │   ├── SiguientePaso.java
│   │   ├── EventoGenerado.java
│   │   ├── Links.java
│   │   ├── Metadata.java
│   │   ├── Error.java
│   │   ├── ErrorDetalle.java
│   │   ├── SolicitudCotejoMasivo.java
│   │   └── RespuestaCotejo.java
│   │
│   └── ports/
│       ├── in/
│       │   └── IniciarCotejoMasivoUseCase.java
│       │
│       └── out/
│           └── CotejoMasivoDataPort.java
│
├── application/
│   └── service/
│       └── IniciarCotejoMasivoService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── CotejoMasivoController.java
        │       │
        │       ├── dto/
        │       │   ├── CotejoMasivoRequestDto.java
        │       │   ├── CotejoMasivoResponseDto.java
        │       │   ├── SolicitudDto.java
        │       │   ├── EntidadSolicitanteDto.java
        │       │   ├── RepresentanteLegalDto.java
        │       │   ├── ContactoDto.java
        │       │   ├── RegistroCotejoDto.java
        │       │   ├── ConfiguracionProcesoDto.java
        │       │   ├── DocumentoSolicitudDto.java
        │       │   ├── DataResponseDto.java
        │       │   ├── EntidadSolicitanteResponseDto.java
        │       │   ├── OficinaRegistroDto.java
        │       │   ├── ResumenSolicitudDto.java
        │       │   ├── SiguientePasoDto.java
        │       │   ├── EventoGeneradoDto.java
        │       │   ├── LinksDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorResponseDto.java
        │       │
        │       └── mapper/
        │           └── CotejoMasivoDtoMapper.java
        │
        └── out/
            └── msdata/
                └── client/
                    └── CotejoMasivoDataAdapter.java
```

---

## 🛡️ Seguridad

### Autenticación
- **Mecanismo**: Bearer Token JWT
- **Header**: `Authorization: Bearer <token>`
- **Validación**: Token válido y no expirado

### Autorización
- **Mecanismo**: Validación de roles
- **Header**: `X-User-Role`
- **Roles**: TECNICO_COTEJO (ejemplo)

### Trazabilidad
- **Correlation ID**: `X-Correlation-ID` para trazabilidad end-to-end
- **Office Code**: `X-Office-Code` identifica oficina de origen
- **Request Source**: `X-Request-Source` identifica origen (WEB, API_EXTERNA, BATCH)

### Integridad
- **Hash SHA-256**: Para validar integridad de documentos
- **Idempotency**: `X-Idempotency-Key` previene duplicados

---

## 🚀 Patrones Implementados

1. **Circuit Breaker**: Resiliencia ante fallos
2. **Retry Pattern**: Reintentos automáticos
3. **Event-Driven Architecture**: Comunicación asíncrona
4. **HATEOAS**: Nivel 3 Richardson Maturity Model
5. **Idempotency**: Prevención de duplicados
6. **Correlation ID**: Trazabilidad distribuida
7. **API Versioning**: Versionado vía path (`/api/v1/`)

---

## ⚠️ Limitaciones Técnicas

### Sin Frameworks
Este proyecto fue generado **sin dependencias de frameworks**:
- ❌ No usa Spring (Spring Boot, Spring Data, etc.)
- ❌ No usa JAX-RS
- ❌ No usa JPA/Hibernate
- ❌ No usa MapStruct
- ❌ No usa anotaciones de ningún framework

### Sin Tecnología de Comunicación
- ❌ No define protocolo HTTP real
- ❌ No implementa cliente Kafka real
- ❌ No define drivers de base de datos

### Código Compilable
- ✅ Interfaces y clases puras Java
- ✅ POJOs sin anotaciones
- ✅ Métodos stub con `UnsupportedOperationException` o implementaciones básicas
- ✅ Compilable como Java puro (sin dependencias externas)

---

## 📝 Notas de Implementación

### Adaptador de Salida
El `CotejoMasivoDataAdapter` contiene implementaciones **stub**. En producción debe implementar:

1. **Publicación de eventos**:
   - Integración con Apache Kafka
   - Serialización de eventos
   - Manejo de errores y reintentos

2. **Validaciones**:
   - Consultas a MsDatosCotejoMasivo
   - Validación de entidades solicitantes
   - Verificación de duplicados

3. **Registro**:
   - Persistencia vía MsDatosCotejoMasivo
   - Transaccionalidad
   - Logging y auditoría

### Controller
El `CotejoMasivoController` es un POJO sin anotaciones. Para usarlo con Spring:

```java
@RestController
@RequestMapping("/api/v1/ciudadano/MsCoreogCotejoMasivo")
public class CotejoMasivoControllerSpring {
    
    private final CotejoMasivoController controller;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CotejoMasivoResponseDto iniciarCotejo(
        @RequestBody CotejoMasivoRequestDto request,
        @RequestHeader("Authorization") String auth,
        @RequestHeader("X-Correlation-ID") String correlationId,
        @RequestHeader("X-Office-Code") String officeCode,
        @RequestHeader("X-User-Role") String userRole,
        @RequestHeader("X-Request-Source") String requestSource,
        @RequestHeader("X-Idempotency-Key") String idempotencyKey
    ) {
        return controller.iniciarCotejoMasivo(
            request, auth, correlationId, officeCode, 
            userRole, requestSource, idempotencyKey
        );
    }
}
```

---

## 🔍 Mapeo de Tipos

| Especificación | Tipo Java |
|----------------|-----------|
| string | String |
| integer/int | Integer |
| long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List<T> |
| object | Clase POJO |

---

## 📊 Convenciones de Mapeo

### DTOs Request/Response
- Formato JSON → POJOs Java
- Fechas en formato ISO 8601 → LocalDateTime
- Arrays → List<T>
- Objetos anidados → POJOs anidados

### Mapper
- Conversión manual sin librerías
- Métodos privados auxiliares
- Manejo de nulls
- Formato de fechas con DateTimeFormatter

---

## ✅ Criterios de Aceptación

- [x] Solo se usa información del PDF de especificación
- [x] Estructura del proyecto coincide con AGENT_PROMPT.md
- [x] Es un microservicio de Coreografía: existe puerto out `CotejoMasivoDataPort` y adaptador `CotejoMasivoDataAdapter`
- [x] NO existe `RepositoryPort` (microservicio de dominio/coreografía)
- [x] Código compila como Java puro sin dependencias externas
- [x] Solo se creó el caso de uso documentado (POST iniciar cotejo masivo)
- [x] Sin anotaciones de frameworks
- [x] Sin tecnología específica de comunicación

---

## 📚 Referencias

- **PDF de Especificación**: Microservicio MsCoreogCotejoMasivo V1.0.pdf
- **Análisis Completo**: PDF_ANALYSIS.md
- **Arquitectura Hexagonal**: Ports & Adapters Pattern
- **Domain-Driven Design**: Tactical patterns

---

## 👥 Contacto

- **Área**: Gestión de Seguridad Electrónica - RENIEC
- **Rol**: Arquitecto de Software
- **Versión del Documento**: 1.0
- **Fecha**: 03/12/2025

---

## 📄 Licencia

© 2025 RENIEC - Registro Nacional de Identificación y Estado Civil. Todos los derechos reservados.
