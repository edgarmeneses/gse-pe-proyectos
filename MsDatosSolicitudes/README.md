# Microservicio MsDatosSolicitudes

## 📚 Documentación Importante

- **[Modelo de Dominio Refactorizado](DOMINIO_REFACTORIZADO.md)** - Resumen de cambios y estructura del dominio limpio
- **[Estructura del Dominio](ESTRUCTURA_DOMINIO.md)** - Diagrama visual y flujo de datos

## Información General

- **Nombre del Microservicio**: MsDatosSolicitudes
- **Tipo**: MsData (Microservicio de Datos - gestiona persistencia)
- **Contexto de Negocio**: Gestión de solicitudes del sistema SIIRC (DNIe de RENIEC)
- **Paquete Base**: `pe.gob.pj.solicitudes.data`
- **Versión API**: v1
- **Versión del Documento**: 1.4
- **Fecha de Última Actualización**: 02/12/2025

## Descripción

El Microservicio de Solicitudes es responsable de la gestión de las solicitudes dentro de la plataforma SIIRC. Una solicitud representa un trámite iniciado por cualquiera de los grupos de interés (stakeholders), y este microservicio permite su creación, actualización, consulta y persistencia.

## Arquitectura

Este proyecto implementa **Arquitectura Hexagonal (Ports & Adapters)** con **Domain-Driven Design (DDD)**, sin frameworks ni tecnologías específicas, siguiendo los principios de neutralidad tecnológica.

> ⚠️ **Nota**: El modelo de dominio ha sido refactorizado para eliminar conceptos de infraestructura y presentación. Ver [DOMINIO_REFACTORIZADO.md](DOMINIO_REFACTORIZADO.md) para más detalles.

### Estructura del Proyecto

```
src/main/java/pe/gob/pj/solicitudes/data/
├── domain/
│   ├── model/                          # Entidades del dominio (REFACTORIZADO)
│   │   ├── Solicitud.java             # Aggregate Root - Solicitud
│   │   ├── Diligencia.java            # Aggregate Root - Diligencia
│   │   ├── Trazabilidad.java          # Aggregate Root - Trazabilidad
│   │   ├── Solicitante.java           # Value Object
│   │   ├── Direccion.java             # Value Object
│   │   ├── RequisitoCumplido.java     # Value Object
│   │   ├── DatosEspecificosTramite.java # Value Object
│   │   ├── DocumentoAdjunto.java      # Value Object
│   │   ├── Pago.java                  # Value Object
│   │   ├── OficinaRegistro.java       # Value Object
│   │   ├── DatosContactoEntidad.java  # Value Object
│   │   ├── DocumentoRequerido.java    # Value Object
│   │   ├── OficinaResponsable.java    # Value Object
│   │   ├── DocumentoGenerado.java     # Value Object
│   │   ├── Evento.java                # Entity
│   │   ├── Usuario.java               # Value Object
│   │   └── Oficina.java               # Value Object
│   └── ports/
│       ├── in/                        # Puertos de entrada (Use Cases)
│       │   ├── CrearSolicitudUseCase.java
│       │   ├── ListarSolicitudesUseCase.java
│       │   ├── ConsultarSolicitudUseCase.java
│       │   ├── ActualizarSolicitudUseCase.java
│       │   ├── ConsultarSolicitudesPendientesOfflineUseCase.java
│       │   ├── CrearDiligenciaUseCase.java
│       │   ├── VerificarDuplicadosUseCase.java
│       │   └── VerTrazabilidadUseCase.java
│       └── out/                       # Puertos de salida (Repository Ports)
│           ├── SolicitudRepositoryPort.java
│           ├── DiligenciaRepositoryPort.java
│           └── TrazabilidadRepositoryPort.java
├── application/
│   └── service/                       # Servicios de aplicación
│       ├── CrearSolicitudService.java
│       ├── ListarSolicitudesService.java
│       ├── ConsultarSolicitudService.java
│       ├── ActualizarSolicitudService.java
│       ├── ConsultarSolicitudesPendientesOfflineService.java
│       ├── CrearDiligenciaService.java
│       ├── VerificarDuplicadosService.java
│       └── VerTrazabilidadService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/                  # Adaptador REST (entrada)
        │       ├── controller/
        │       │   └── SolicitudController.java
        │       ├── dto/              # Data Transfer Objects (Java Records)
        │       │   ├── SolicitudRequestDto.java
        │       │   ├── SolicitudResponseDto.java
        │       │   ├── DiligenciaRequestDto.java
        │       │   ├── DiligenciaResponseDto.java
        │       │   ├── TrazabilidadResponseDto.java
        │       │   ├── VerificarDuplicadosRequestDto.java
        │       │   ├── VerificarDuplicadosResponseDto.java
        │       │   └── [otros DTOs...]
        │       └── mapper/           # Mappers DTO <-> Domain
        │           ├── SolicitudDtoMapper.java
        │           ├── DiligenciaDtoMapper.java
        │           └── TrazabilidadDtoMapper.java
        └── out/
            └── persistence/           # Adaptador de persistencia (salida)
                ├── entity/
                │   ├── SolicitudEntity.java
                │   └── DiligenciaEntity.java
                ├── mapper/
                │   └── SolicitudPersistenceMapper.java
                ├── SolicitudRepositoryAdapter.java
                ├── DiligenciaRepositoryAdapter.java
                └── TrazabilidadRepositoryAdapter.java
```

## Endpoints del API

### Base Path
`/api/v1/solicitudes/MsDatosSolicitudes`

### 1. Crear Nueva Solicitud
- **Método**: `POST`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes`
- **Descripción**: Permite la creación de una nueva solicitud en el sistema SIIRC
- **Headers**:
  - `Authorization`: Bearer token JWT
  - `Content-Type`: application/json
  - `X-Correlation-ID`: UUID de correlación
  - `X-Office-Code`: Código de oficina
  - `X-User-Role`: Rol del usuario
  - `X-Request-Source`: Origen de la solicitud
  - `X-Idempotency-Key`: UUID para evitar duplicados

**Request Body**:
```json
{
  "tipoTramite": "string",
  "subTipoTramite": "string",
  "solicitante": {
    "dni": "string",
    "nombres": "string",
    "apellidoPaterno": "string",
    "apellidoMaterno": "string",
    "email": "string",
    "telefono": "string",
    "direccion": {
      "departamento": "string",
      "provincia": "string",
      "distrito": "string",
      "direccionCompleta": "string"
    }
  },
  "tipoSolicitante": "string",
  "prioridad": "string",
  "requisitosCumplidos": [
    {
      "requisitoId": "string",
      "nombreRequisito": "string",
      "cumple": "boolean",
      "observacion": "string"
    }
  ],
  "datosEspecificosTramite": {
    "motivoRenovacion": "string",
    "dniAnterior": "string",
    "fechaVencimientoDniAnterior": "YYYY-MM-DDThh:mm:ssZ",
    "requiereEntregaDomicilio": "boolean",
    "oficinaEntregaPreferida": "string",
    "documentosAdjuntos": [
      {
        "tipo": "string",
        "nombre": "string",
        "tamanioBytes": "integer",
        "mimeType": "string",
        "checksum": "string"
      }
    ]
  },
  "pago": {
    "montoPagado": "number",
    "metodoPago": "string",
    "referenciaPago": "string",
    "fechaPago": "YYYY-MM-DDThh:mm:ssZ"
  },
  "observaciones": "string"
}
```

**Response (201 Created)**:
```json
{
  "success": "boolean",
  "data": {
    "solicitudId": "string",
    "numeroSolicitud": "string",
    "estado": "string",
    "tipoTramite": "string",
    "dniSolicitante": "string",
    "nombresSolicitante": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string",
    "oficinaRegistro": {
      "codigo": "string",
      "nombre": "string"
    },
    "siguientesPasos": [
      {
        "paso": "string"
      }
    ],
    "tiempoEstimadoResolucion": "integer",
    "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ",
    "urlSeguimiento": "string",
    "codigoQR": "string",
    "_links": {
      "self": "string",
      "actualizar": "string",
      "cambiarEstado": "string",
      "historial": "string"
    }
  },
  "metadata": {
    "timestamp": "string",
    "correlationId": "string",
    "version": "string"
  }
}
```

**Status Codes**:
- `201`: Created - Solicitud creada exitosamente
- `400`: Bad Request - Parámetros inválidos
- `401`: Unauthorized - Token JWT inválido o expirado
- `403`: Forbidden - Sin permisos para crear solicitudes
- `409`: Conflict - Solicitud duplicada (Idempotency-Key)
- `422`: Unprocessable Entity - Datos válidos pero no procesables
- `429`: Too Many Requests - Límite de rate limit excedido
- `500`: Internal Server Error - Error interno del servidor
- `503`: Service Unavailable - Servicio temporalmente no disponible

### 2. Listar Solicitudes
- **Método**: `GET`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes`
- **Descripción**: Lista solicitudes con parámetros de filtrado y paginación

**Query Parameters**:
- `estado` (string, opcional): Estado para filtrar
- `tipoTramite` (string, opcional): Tipo de trámite
- `codigoOficina` (string, opcional): Código de oficina
- `dniSolicitante` (string, opcional): DNI del solicitante
- `usuarioAsignado` (string, opcional): Usuario asignado
- `fechaDesde` (string, opcional): Fecha inicial (ISO 8601)
- `fechaHasta` (string, opcional): Fecha final (ISO 8601)
- `prioridad` (string, opcional): Nivel de prioridad
- `soloVencidas` (boolean, opcional): Solo solicitudes vencidas
- `page` (integer, opcional): Número de página
- `size` (integer, opcional): Registros por página
- `sort` (string, opcional): Campo de ordenamiento
- `direction` (string, opcional): Dirección del ordenamiento (ASC/DESC)

**Response (200 OK)**:
```json
{
  "success": "boolean",
  "data": [
    {
      "solicitudId": "string",
      "numeroSolicitud": "string",
      "estado": "string",
      "tipoTramite": "string",
      "dniSolicitante": "string",
      "nombresSolicitante": "string",
      "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
      "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ",
      "prioridad": "string",
      "usuarioAsignado": "string",
      "oficinaRegistro": "string",
      "diasTranscurridos": "integer",
      "diasRestantes": "integer"
    }
  ],
  "pagination": {
    "page": "integer",
    "size": "integer",
    "totalElements": "integer",
    "totalPages": "integer",
    "first": "boolean",
    "last": "boolean"
  }
}
```

**Status Codes**:
- `200`: OK - Consulta exitosa
- `400`: Bad Request - Parámetros de búsqueda inválidos
- `401`: Unauthorized - Token JWT inválido
- `403`: Forbidden - Sin permisos para consultar solicitudes
- `422`: Unprocessable Entity - Parámetros inválidos
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

### 3. Consultar Solicitud Específica
- **Método**: `GET`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/{id}`
- **Descripción**: Consulta una solicitud específica por ID

**Path Parameters**:
- `id` (string, requerido): Identificador de la solicitud

**Response (200 OK)**: Similar al response de Crear Solicitud con todos los detalles

**Status Codes**:
- `200`: OK - Solicitud encontrada
- `400`: Bad Request - UUID con formato inválido
- `401`: Unauthorized - Token JWT inválido
- `403`: Forbidden - Sin permisos
- `404`: Not Found - Solicitud no encontrada
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

### 4. Actualizar Solicitud Completa
- **Método**: `PUT`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/{id}`
- **Descripción**: Actualiza una solicitud completa por ID

**Path Parameters**:
- `id` (string, requerido): Identificador de la solicitud

**Request Body**: Similar al de Crear Solicitud (campos actualizables)

**Response (200 OK)**: Similar al response de Crear Solicitud

**Status Codes**:
- `200`: OK - Actualización exitosa
- `400`: Bad Request - Datos inválidos
- `401`: Unauthorized
- `403`: Forbidden
- `404`: Not Found - Solicitud no encontrada
- `409`: Conflict - Conflicto con el estado actual
- `422`: Unprocessable Entity
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

### 5. Consultar Solicitudes Pendientes Offline
- **Método**: `GET`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/offline/pendientes`
- **Descripción**: Consulta solicitudes registradas en modo offline que no han sido sincronizadas

**Query Parameters**:
- `oficinaCode` (string, requerido): Código de oficina
- `dispositivoId` (string, opcional): ID del dispositivo
- `fechaDesde` (string, opcional): Fecha inicial
- `fechaHasta` (string, opcional): Fecha final
- `estadoSincronizacion` (string, opcional): Estado de sincronización
- `page` (integer, opcional): Número de página
- `size` (integer, opcional): Registros por página
- `incluirDetalles` (boolean, opcional): Incluir detalles adicionales

**Status Codes**:
- `200`: OK
- `400`: Bad Request
- `401`: Unauthorized
- `403`: Forbidden
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

### 6. Crear Diligencia
- **Método**: `POST`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/{id}/diligencias`
- **Descripción**: Crea una diligencia asociada a una solicitud

**Path Parameters**:
- `id` (string, requerido): Identificador de la solicitud origen

**Request Body**:
```json
{
  "tipoDiligencia": "string",
  "entidadDestino": "string",
  "tipoEntidad": "string",
  "datosContactoEntidad": {
    "nombre": "string",
    "direccion": "string",
    "email": "string",
    "telefono": "string"
  },
  "motivoDiligencia": "string",
  "fundamentoLegal": "string",
  "informacionRequerida": "string",
  "documentosRequeridos": [
    {
      "tipoDocumento": "string",
      "descripcion": "string",
      "obligatorio": "boolean"
    }
  ],
  "plazoRespuesta": "integer",
  "unidadPlazo": "string",
  "prioridad": "string",
  "requiereRespuestaOficial": "boolean",
  "permitoRespuestaDigital": "boolean",
  "observaciones": "string",
  "oficinaResponsableSeguimiento": "string"
}
```

**Status Codes**:
- `201`: Created - Diligencia creada exitosamente
- `400`: Bad Request - Datos inválidos
- `401`: Unauthorized
- `403`: Forbidden
- `404`: Not Found - Solicitud origen no encontrada
- `409`: Conflict - Ya existe diligencia activa
- `422`: Unprocessable Entity
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

### 7. Verificar Duplicados
- **Método**: `POST`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/verificar-duplicado`
- **Descripción**: Verifica si existen solicitudes duplicadas

**Request Body**:
```json
{
  "solicitudId": "string",
  "fechaDesde": "string",
  "fechaHasta": "string",
  "tipoEvento": "string",
  "usuarioId": "string",
  "limit": "integer",
  "offset": "integer",
  "ordenamiento": "string",
  "incluirDatosDetallados": "boolean"
}
```

**Response (200 OK)**:
```json
{
  "tieneDuplicados": "boolean"
}
```

### 8. Ver Trazabilidad
- **Método**: `GET`
- **Path**: `/api/v1/solicitudes/MsDatosSolicitudes/{id}/trazabilidad`
- **Descripción**: Consulta el historial completo de trazabilidad de una solicitud

**Path Parameters**:
- `id` (string, requerido): Identificador de la solicitud

**Query Parameters**:
- `fechaDesde` (string, opcional): Fecha inicial
- `fechaHasta` (string, opcional): Fecha final
- `tipoEvento` (string, opcional): Filtrar por tipo de evento
- `usuarioId` (string, opcional): Filtrar por usuario
- `limit` (integer, opcional): Máximo de eventos por página (1-100)
- `offset` (integer, opcional): Registros a omitir
- `ordenamiento` (string, opcional): ASC o DESC
- `incluirDatosDetallados` (boolean, opcional): Incluir datos completos

**Tipos de Evento**:
- `CAMBIO_ESTADO`
- `MODIFICACION`
- `ASIGNACION`
- `DILIGENCIA`
- `VALIDACION_BIOMETRICA`
- `COMENTARIO`
- `NOTIFICACION`

**Status Codes**:
- `200`: OK - Historial recuperado exitosamente
- `400`: Bad Request - Parámetros inválidos
- `401`: Unauthorized
- `403`: Forbidden
- `404`: Not Found - Solicitud no encontrada
- `429`: Too Many Requests
- `500`: Internal Server Error
- `503`: Service Unavailable

## Entidades del Dominio

### Solicitud (Aggregate Root)
- **solicitudId**: String (UUID)
- **numeroSolicitud**: String
- **estado**: String
- **tipoTramite**: String
- **subTipoTramite**: String
- **solicitante**: Solicitante (Value Object)
- **tipoSolicitante**: String
- **prioridad**: String
- **requisitosCumplidos**: List<RequisitoCumplido>
- **datosEspecificosTramite**: DatosEspecificosTramite
- **pago**: Pago
- **observaciones**: String
- **fechaRegistro**: LocalDateTime
- **fechaVencimiento**: LocalDateTime
- **usuarioRegistro**: String
- **oficinaRegistro**: OficinaRegistro
- **siguientesPasos**: List<SiguientePaso>
- **tiempoEstimadoResolucion**: Long
- **urlSeguimiento**: String
- **codigoQR**: String
- **diasTranscurridos**: Long
- **diasRestantes**: Long
- **usuarioAsignado**: String
- **requiereDiligencia**: Boolean

### Diligencia (Aggregate Root)
- **diligenciaId**: String (UUID)
- **numeroDiligencia**: String
- **solicitudId**: String
- **numeroSolicitud**: String
- **estado**: String
- **tipoDiligencia**: String (FISICA | DIGITAL)
- **entidadDestino**: String
- **tipoEntidad**: String
- **datosContactoEntidad**: DatosContactoEntidad
- **motivoDiligencia**: String
- **fundamentoLegal**: String
- **informacionRequerida**: String
- **documentosRequeridos**: List<DocumentoRequerido>
- **plazoRespuesta**: Long
- **unidadPlazo**: String
- **prioridad**: String (ALTA | MEDIA | BAJA)
- **requiereRespuestaOficial**: Boolean
- **permitoRespuestaDigital**: Boolean
- **observaciones**: String
- **oficinaResponsableSeguimiento**: String
- **fechaCreacion**: LocalDateTime
- **fechaVencimiento**: LocalDateTime
- **diasTranscurridos**: Long
- **diasRestantes**: Long
- **oficinaResponsable**: OficinaResponsable
- **usuarioSolicitante**: String
- **estadoOficio**: String (GENERADO | ENVIADO | RECIBIDO)
- **documentosGenerados**: List<DocumentoGenerado>
- **seguimiento**: Seguimiento
- **eventosPublicados**: List<String>

### Trazabilidad (Aggregate Root)
- **solicitudId**: String
- **numeroSolicitud**: String
- **tipoTramite**: String
- **estadoActual**: String
- **fechaCreacion**: LocalDateTime
- **fechaUltimaModificacion**: LocalDateTime
- **totalEventos**: Long
- **eventos**: List<Evento>
- **resumenEventos**: ResumenEventos
- **estadisticas**: Estadisticas
- **paginacion**: Paginacion

## Mapeo de Tipos de Datos

Según el prompt del agente, los tipos de datos se mapean de la siguiente manera:

| Tipo en PDF | Tipo en Java |
|-------------|--------------|
| string | String |
| integer/int/long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List<T> |

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes |
| 404 | Not Found - Recurso no encontrado |
| 408 | Request Timeout - Tiempo de espera agotado |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos pero no procesables |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Servicio externo no respondió |

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
Este proyecto ha sido generado siguiendo los principios de **neutralidad tecnológica**:
- **Sin frameworks**: No se utiliza Spring, JAX-RS, ni ningún framework web
- **Sin JPA/ORM**: Las entidades de persistencia son POJOs sin anotaciones
- **Sin librerías de mapeo**: Los mappers son clases Java puras
- **Sin protocolo de conexión**: No se define HTTP, SOAP ni ningún protocolo específico

### Arquitectura Hexagonal Estricta
- **Puertos de Entrada (in)**: Interfaces que representan casos de uso
- **Puertos de Salida (out)**: Interfaces que representan operaciones de persistencia
- **Adaptadores de Entrada**: Controllers REST sin anotaciones
- **Adaptadores de Salida**: RepositoryAdapters con métodos stub (lanzannUnsupportedOperationException)

### Tipo de Microservicio: MsData
Al ser un **MsDataXXXX** (microservicio de datos):
- **Sí define** `RepositoryPort` (puertos de salida hacia la persistencia)
- **Sí define** `Entities` (entidades de persistencia como POJOs)
- **Sí define** `RepositoryAdapter` (implementación de los puertos de persistencia)
- **No define** tecnología de persistencia concreta (sin JDBC, sin Hibernate, sin Mongo)

### Código Compilable
- Todo el código es Java puro, compilable sin dependencias externas
- Los adaptadores de persistencia lanzan `UnsupportedOperationException` (requieren implementación con tecnología específica)
- Los DTOs son Java Records (requiere Java 14+)

### Operaciones Generadas
Solo se han generado las operaciones (use cases/endpoints) **documentadas en el PDF**:
1. Crear Nueva Solicitud
2. Listar Solicitudes
3. Consultar Solicitud Específica
4. Actualizar Solicitud Completa
5. Consultar Solicitudes Pendientes Offline
6. Crear Diligencia
7. Verificar Duplicados
8. Ver Trazabilidad

**No se inventaron operaciones adicionales**.

### Implementación Pendiente
Para completar la implementación, se requiere:
1. **Tecnología de persistencia**: JPA, JDBC, MongoDB, etc.
2. **Framework web**: Spring Boot, Micronaut, Quarkus, etc.
3. **Lógica de negocio**: Los servicios actualmente solo delegan a los puertos
4. **Validaciones**: Implementar validaciones de negocio en los servicios
5. **Manejo de errores**: Implementar excepciones personalizadas y manejo global
6. **Seguridad**: Implementar autenticación y autorización
7. **Configuración**: Propiedades, perfiles, variables de entorno
8. **Build tool**: Maven o Gradle para gestión de dependencias

## Próximos Pasos

1. Elegir tecnología de persistencia y framework web
2. Agregar `pom.xml` o `build.gradle`
3. Implementar lógica de negocio en los servicios
4. Completar los adaptadores de persistencia
5. Agregar anotaciones del framework elegido
6. Implementar validaciones y manejo de excepciones
7. Configurar logging y métricas
8. Agregar tests unitarios e integración
9. Documentar API con OpenAPI/Swagger
10. Configurar CI/CD

## Documentos de Referencia

- **Especificación Original**: `Microservicio MsDatosSolicitudes V1.3.pdf`
- **Extracción del PDF**: `EXTRACCION_PDF.md` (en la raíz del proyecto)
- **Prompt del Agente**: `AGENT_PROMPT.md`

---

**Generado automáticamente siguiendo Arquitectura Hexagonal y DDD sin frameworks**
