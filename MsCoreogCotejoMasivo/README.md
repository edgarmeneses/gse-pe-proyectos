# Microservicio MsCoreogCotejoMasivo

## Resumen

**Nombre:** MsCoreogCotejoMasivo  
**Contexto de Negocio:** Microservicio Coreógrafo de Cotejo Masivo para la plataforma SIIRC de RENIEC. Su propósito principal es coordinar y gestionar el flujo de trabajo asíncrono entre el Microservicio Cotejo Masivo (MsCotejoMasivo - capa de procesamiento intensivo) y el Microservicio Datos Cotejo Masivo (MsDatosCotejoMasivo - capa de persistencia).  
**Versión del API:** v1.0  
**Paquete Base Java:** `pe.gob.reniec.coreografia.cotejo`  
**Tipo:** MsDominio (Microservicio de Coreografía)

## Arquitectura

Este proyecto implementa una **Arquitectura Hexagonal estricta** sin dependencias de frameworks ni tecnologías concretas. La estructura sigue el patrón de puertos y adaptadores (Ports & Adapters) y Domain-Driven Design (DDD).

Como **MsDominio (microservicio de coreografía)**, este proyecto:
- **NO** define `RepositoryPort`
- Define puertos de salida (`CotejoMasivoDataPort`) hacia MsDatosCotejoMasivo
- Implementa un adaptador cliente (`CotejoMasivoDataAdapter`) para comunicarse con el microservicio de datos
- **NO** especifica protocolo de comunicación (sin HTTP, SOAP, ni colas implementadas)

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/coreografia/cotejo/
│
├── domain/
│   ├── model/                          # Entidades y objetos de valor del dominio
│   │   ├── Solicitud.java
│   │   ├── EntidadSolicitante.java
│   │   ├── RepresentanteLegal.java
│   │   ├── Contacto.java
│   │   ├── RegistroCotejo.java
│   │   ├── ConfiguracionProceso.java
│   │   ├── DocumentoSolicitud.java
│   │   ├── SolicitudCotejoMasivo.java
│   │   ├── RespuestaIniciarCotejo.java
│   │   ├── OficinaRegistro.java
│   │   ├── ResumenSolicitud.java
│   │   ├── SiguientePaso.java
│   │   └── EventoGenerado.java
│   │
│   └── ports/
│       ├── in/                         # Puertos de entrada (casos de uso)
│       │   └── IniciarCotejoMasivoUseCase.java
│       │
│       └── out/                        # Puertos de salida hacia MsDatosCotejoMasivo
│           └── CotejoMasivoDataPort.java
│
├── application/
│   └── service/                        # Servicios de aplicación
│       └── IniciarCotejoMasivoService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── CotejoMasivoController.java
        │       ├── dto/                # DTOs REST (Java Records)
        │       │   ├── IniciarCotejoMasivoRequestDto.java
        │       │   ├── IniciarCotejoMasivoResponseDto.java
        │       │   ├── SolicitudDto.java
        │       │   ├── EntidadSolicitanteDto.java
        │       │   ├── RepresentanteLegalDto.java
        │       │   ├── ContactoDto.java
        │       │   ├── RegistroCotejoDto.java
        │       │   ├── ConfiguracionProcesoDto.java
        │       │   ├── DocumentoSolicitudDto.java
        │       │   ├── DatosCotejoDto.java
        │       │   ├── EntidadSolicitanteResponseDto.java
        │       │   ├── OficinaRegistroDto.java
        │       │   ├── ResumenSolicitudDto.java
        │       │   ├── SiguientePasoDto.java
        │       │   ├── EventoGeneradoDto.java
        │       │   ├── LinksDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── DetalleErrorDto.java
        │       └── mapper/
        │           └── CotejoMasivoRestMapper.java
        │
        └── out/
            └── msdata/
                └── client/
                    └── CotejoMasivoDataAdapter.java  # Adaptador cliente hacia MsDatosCotejoMasivo
```

## Endpoints

### 1. Iniciar Cotejo Masivo

**Descripción:** Permite iniciar el proceso de cotejo masivo de forma síncrona, validando la solicitud y emitiendo el evento de inicio del flujo de coreografía.

**Método:** `POST`  
**Path:** `/api/v1/ciudadano/MsCoreogCotejoMasivo`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

#### Headers

| Header | Tipo | Descripción |
|--------|------|-------------|
| `Authorization` | String | Bearer token JWT para autenticación del usuario |
| `Content-Type` | String | `application/json` |
| `X-Correlation-ID` | UUID | Identificador único de correlación para trazabilidad end-to-end |
| `X-Office-Code` | String | Código de oficina o sede desde donde se realiza la operación |
| `X-User-Role` | String | Rol del usuario (ejemplo: TECNICO_COTEJO) |
| `X-Request-Source` | String | Origen de la solicitud: WEB, API_EXTERNA, BATCH |
| `X-Idempotency-Key` | UUID | Clave para evitar procesamientos duplicados |

#### Request Body (JSON)

```json
{
  "solicitud": {
    "numeroSolicitud": "string",
    "tipoTramite": "COTEJO_MASIVO",
    "fechaSolicitud": "YYYY-MM-DDThh:mm:ss±hh:mm",
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
      "fechaNacimiento": "YYYY-MM-DD",
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

#### Response Body (JSON) - Éxito (201 Created)

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
    "fechaRegistro": "YYYY-MM-DDThh:mm:ss±hh:mm",
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

#### Response Body (JSON) - Error

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

## Códigos de Respuesta HTTP

| Código | Descripción |
|--------|-------------|
| `201` | Created - Solicitud de cotejo masivo creada exitosamente |
| `400` | Bad Request - Parámetros inválidos o datos incompletos en la solicitud |
| `401` | Unauthorized - Token JWT inválido, expirado o ausente |
| `403` | Forbidden - Usuario sin permisos para iniciar cotejo masivo |
| `404` | Not Found - Entidad solicitante no encontrada en el sistema |
| `409` | Conflict - Ya existe una solicitud activa con el mismo número o idempotency key |
| `413` | Payload Too Large - Lista de registros excede el límite permitido (10,000) |
| `422` | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| `429` | Too Many Requests - Límite de rate limit excedido |
| `500` | Internal Server Error - Error interno del servidor |
| `502` | Bad Gateway - Error al comunicarse con Apache Kafka |
| `503` | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |

## Entidades del Dominio

### SolicitudCotejoMasivo (Aggregate Root)

Entidad principal que agrupa toda la información necesaria para iniciar un cotejo masivo.

**Atributos:**
- `solicitud`: Solicitud - Información de la solicitud
- `entidadSolicitante`: EntidadSolicitante - Datos de la entidad que solicita el cotejo
- `registrosCotejo`: List<RegistroCotejo> - Lista de registros a cotejar (1-10000 elementos)
- `configuracionProceso`: ConfiguracionProceso - Configuración del proceso
- `documentoSolicitud`: DocumentoSolicitud - Documento adjunto (opcional)
- `observaciones`: String - Observaciones adicionales (opcional)

### Solicitud

**Atributos:**
- `numeroSolicitud`: String - Número único de la solicitud (10-20 caracteres)
- `tipoTramite`: String - Tipo de trámite (5-30 caracteres)
- `fechaSolicitud`: LocalDateTime - Fecha y hora de la solicitud (ISO 8601)
- `prioridad`: String - Nivel de prioridad (4-10 caracteres)

### EntidadSolicitante

**Atributos:**
- `codigo`: String - Código de la entidad (3-20 caracteres)
- `nombre`: String - Nombre de la entidad (5-200 caracteres)
- `ruc`: String - RUC (11 caracteres, opcional)
- `representanteLegal`: RepresentanteLegal - Representante legal
- `contacto`: Contacto - Información de contacto

### RepresentanteLegal

**Atributos:**
- `dni`: String - DNI (8 caracteres)
- `nombres`: String - Nombres (2-100 caracteres)
- `apellidoPaterno`: String - Apellido paterno (2-60 caracteres)
- `apellidoMaterno`: String - Apellido materno (2-60 caracteres)

### Contacto

**Atributos:**
- `email`: String - Correo electrónico (5-254 caracteres)
- `telefono`: String - Teléfono (7-15 caracteres, opcional)

### RegistroCotejo

**Atributos:**
- `secuencia`: Long - Número de secuencia
- `numeroDni`: String - DNI del ciudadano (8 caracteres)
- `apellidoPaterno`: String - Apellido paterno (2-60 caracteres)
- `apellidoMaterno`: String - Apellido materno (2-60 caracteres)
- `nombres`: String - Nombres (2-100 caracteres)
- `fechaNacimiento`: LocalDate - Fecha de nacimiento (opcional)
- `genero`: String - Género (1-20 caracteres, opcional)

### ConfiguracionProceso

**Atributos:**
- `notificarProgreso`: Boolean - Indica si notificar el progreso
- `generarReporteDetallado`: Boolean - Indica si generar reporte detallado
- `formatoReporte`: String - Formato del reporte (3-10 caracteres)

### DocumentoSolicitud

**Atributos:**
- `tipo`: String - Tipo de documento (3-50 caracteres)
- `nombre`: String - Nombre del archivo (5-200 caracteres)
- `urlDocumento`: String - URL del documento (10-500 caracteres)
- `hashDocumento`: String - Hash del documento (64 caracteres, opcional)

### RespuestaIniciarCotejo

Objeto que encapsula la respuesta del dominio al iniciar un cotejo masivo.

**Atributos:**
- `solicitudId`: String - ID único de la solicitud (UUID)
- `numeroSolicitud`: String - Número legible de la solicitud
- `estado`: String - Estado inicial de la solicitud
- `tipoTramite`: String - Tipo de trámite
- `entidadSolicitante`: EntidadSolicitante - Datos de la entidad solicitante
- `fechaRegistro`: LocalDateTime - Fecha y hora de registro (ISO 8601)
- `usuarioRegistro`: String - Usuario que registró la solicitud
- `oficinaRegistro`: OficinaRegistro - Oficina donde se registró
- `resumenSolicitud`: ResumenSolicitud - Resumen de la solicitud
- `siguientesPasos`: List<SiguientePaso> - Lista de pasos siguientes
- `urlSeguimiento`: String - URL para consultar estado
- `eventosGenerados`: List<EventoGenerado> - Eventos emitidos al iniciar

### Otras Entidades de Valor

- **OficinaRegistro**: codigo (String), nombre (String)
- **ResumenSolicitud**: totalRegistros (Long), prioridad (String), tiempoEstimadoProcesamiento (String)
- **SiguientePaso**: paso (String), descripcion (String)
- **EventoGenerado**: eventId (String), eventType (String), topic (String)

## Mapeo de Tipos de Datos

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer | Long |
| boolean | Boolean |
| date (YYYY-MM-DD) | LocalDate |
| datetime (ISO 8601) | LocalDateTime |
| array | List<T> |
| object | Clase POJO |
| UUID | String |

## Puertos y Adaptadores

### Puertos de Entrada (in)

- **IniciarCotejoMasivoUseCase**: Define el contrato para iniciar un cotejo masivo.

### Puertos de Salida (out)

- **CotejoMasivoDataPort**: Define el contrato para comunicarse con MsDatosCotejoMasivo. Operaciones:
  - `registrarSolicitudCotejoMasivo(SolicitudCotejoMasivo)`: Registra la solicitud en el microservicio de datos.

### Adaptadores

#### Adaptador de Entrada (REST)
- **CotejoMasivoController**: Controller REST sin anotaciones que expone el endpoint. Método:
  - `iniciarCotejoMasivo(...)`: Método que maneja la petición POST.

#### Adaptador de Salida (Cliente MsData)
- **CotejoMasivoDataAdapter**: Implementa `CotejoMasivoDataPort` para comunicarse con MsDatosCotejoMasivo.
  - **NOTA**: Implementación pendiente. No define protocolo de comunicación (ni HTTP, ni SOAP, ni colas).
  - Lanza `UnsupportedOperationException` como placeholder.

## Limitaciones y Consideraciones

1. **Sin Frameworks**: Este proyecto NO utiliza Spring, JAX-RS, JPA, MapStruct ni ningún otro framework. Es Java puro (POJOs e interfaces).

2. **Sin Tecnología de Persistencia**: NO hay anotaciones JPA, ni drivers de base de datos. Las entidades son POJOs simples.

3. **Sin Protocolo Definido**: El adaptador `CotejoMasivoDataAdapter` NO especifica cómo se conecta con MsDatosCotejoMasivo (ni HTTP, ni SOAP, ni colas). Solo define la interfaz del puerto de salida.

4. **Tipo de Microservicio**: Este es un **MsDominio** (coreógrafo), por lo tanto:
   - NO define `RepositoryPort`
   - Define puertos de salida hacia MsDatosCotejoMasivo
   - NO gestiona persistencia directa

5. **Código Compilable**: Todo el código es compilable como Java estándar sin dependencias externas (excepto JDK).

6. **DTOs como Records**: Los DTOs están implementados como Java Records para mayor concisión.

7. **Implementaciones Pendientes**: Los adaptadores de salida contienen implementaciones stub que lanzan `UnsupportedOperationException`.

8. **Manejo de Errores**: Los códigos de estado HTTP y estructuras de error están documentados pero no implementados en lógica real.

9. **Validaciones**: No se implementan validaciones de negocio (longitudes, formatos, obligatoriedad). Esto debe agregarse en una capa de framework o aplicación.

10. **Sin Build Tool**: No se proporciona `pom.xml` ni `build.gradle` para mantener neutralidad tecnológica.

## Operaciones Implementadas

Según el PDF, se implementa únicamente la operación documentada:

- **POST /api/v1/ciudadano/MsCoreogCotejoMasivo**: Iniciar Cotejo Masivo

No se han creado operaciones adicionales (GET, PUT, DELETE) ya que no están especificadas en el documento.

## Próximos Pasos

1. Implementar la lógica real del adaptador `CotejoMasivoDataAdapter` con el protocolo de comunicación definido (HTTP/REST, SOAP, Kafka, etc.).
2. Agregar framework (Spring Boot, Quarkus, Micronaut, etc.) para exponer el endpoint REST real.
3. Implementar validaciones de negocio en el servicio de aplicación.
4. Agregar manejo de errores y excepciones personalizadas.
5. Implementar logging y trazabilidad distribuida.
6. Agregar tests unitarios e integración.
7. Configurar gestión de eventos (Kafka/RabbitMQ) para la coreografía.
8. Implementar Circuit Breaker y patrones de resiliencia.

## Versión

- **Documento PDF:** 1.0 (01/12/2025)
- **Código Generado:** 01/12/2025
- **API Version:** v1.0

---

**Nota:** Este proyecto ha sido generado siguiendo estrictamente las especificaciones del documento PDF "Microservicio MsCoreogCotejoMasivo V1.0.pdf" sin inferencias ni adiciones no documentadas.
