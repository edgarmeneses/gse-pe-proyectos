# Microservicio MsDatosAgendamiento

## Resumen del Microservicio

**Nombre del Microservicio:** MsDatosAgendamiento  
**Tipo de Microservicio:** MsData (Microservicio de Datos)  
**Versión del API:** v1  
**Contexto de Negocio:** Gestión de Seguridad Electrónica - RENIEC  
**Paquete Base Java:** `pe.gob.reniec.gse.agendamiento.data`

## Descripción

El Microservicio Datos Agendamiento es un componente de persistencia y acceso a datos dedicado. Su propósito principal es interactuar de manera exclusiva con la Base de Datos de Agendamiento, actuando como el único intermediario para su administración. Se encarga de almacenar, recuperar y gestionar de forma segura toda la información de las agendas, la disponibilidad horaria y los datos de las citas programadas para las visitas de lectura de documentos archivados.

## Tipo de Microservicio: MsData

Como **MsData**, este microservicio:
- **SÍ define** `RepositoryPort` y `RepositoryAdapter` para cada entidad
- **SÍ define** `Entities` (POJOs sin anotaciones JPA)
- **NO depende** de frameworks ni tecnologías específicas
- **NO usa** anotaciones de JPA, Spring, JAX-RS, etc.
- **Gestiona** la persistencia de datos de agendamiento

## Endpoints

### 1. Crear Agenda (Cita)

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método:** `POST`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String
- `X-Idempotency-Key`: UUID

**Request Body:**
```json
{
  "sedeServicio": {
    "codigoSede": "string",
    "nombreSede": "string"
  },
  "solicitud": {
    "idSolicitud": "string",
    "numeroTramite": "string"
  },
  "solicitante": {
    "dni": "string",
    "nombres": "string",
    "apellidoPaterno": "string",
    "apellidoMaterno": "string",
    "email": "string",
    "telefono": "string"
  },
  "programacion": {
    "fechaCita": "YYYY-MM-DDThh:mm:ssZ",
    "horaCita": "HH:mm",
    "idDisponibilidad": "string"
  },
  "tecnicoAsignado": {
    "idTecnico": "string",
    "nombreCompleto": "string"
  },
  "observaciones": "string"
}
```

**Response (201 Created):**
```json
{
  "success": true,
  "data": {
    "citaId": "string",
    "codigoCita": "string",
    "estado": "string",
    "sedeServicio": {...},
    "solicitante": {...},
    "programacion": {...},
    "tecnicoAsignado": {...},
    "tokenReagendamiento": "string",
    "fechaLimiteReagendamiento": "YYYY-MM-DDThh:mm:ssZ",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string",
    "_links": {...}
  },
  "metadata": {
    "timestamp": "string",
    "correlationId": "string",
    "version": "string"
  }
}
```

**Status Codes:**
- `201 Created`: Cita creada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos para crear citas
- `409 Conflict`: Ya existe una cita activa o no hay disponibilidad
- `422 Unprocessable Entity`: Datos válidos pero lógica de negocio no permite procesarlos
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### 2. Actualizar Cita (Reagendamiento)

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/citas/{citaId}`  
**Método:** `PUT`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

**Path Parameters:**
- `citaId`: UUID de la cita a actualizar

**Request Body:**
```json
{
  "tokenReagendamiento": "string",
  "nuevaProgramacion": {
    "fechaCita": "YYYY-MM-DDThh:mm:ssZ",
    "horaCita": "HH:mm",
    "idDisponibilidad": "string"
  },
  "tecnicoAsignado": {
    "idTecnico": "string",
    "nombreCompleto": "string"
  },
  "motivoCambio": "string",
  "observaciones": "string"
}
```

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "citaId": "string",
    "codigoCita": "string",
    "estado": "string",
    "programacionAnterior": {...},
    "programacionNueva": {...},
    "sedeServicio": {...},
    "tecnicoAsignado": {...},
    "tokenReagendamiento": "string",
    "fechaLimiteReagendamiento": "YYYY-MM-DDThh:mm:ssZ",
    "cantidadReagendamientos": 0,
    "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioActualizacion": "string",
    "_links": {...}
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Cita actualizada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Token de reagendamiento inválido o expirado
- `404 Not Found`: Cita no encontrada
- `409 Conflict`: No hay disponibilidad en la nueva fecha/hora o cita en estado no modificable
- `422 Unprocessable Entity`: Excedido límite de reagendamientos
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor

---

### 3. Consultar Cita

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método:** `GET`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

**Query Parameters:**
- `citaId` (required): UUID de la cita
- `incluirHistorial` (optional): Boolean

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "citaId": "string",
    "codigoCita": "string",
    "estado": {
      "codigo": "string",
      "descripcion": "string",
      "permiteModificacion": true,
      "permiteCancelacion": true
    },
    "sedeServicio": {...},
    "solicitud": {...},
    "solicitante": {...},
    "programacion": {...},
    "tecnicoAsignado": {...},
    "tokenReagendamiento": "string",
    "fechaLimiteReagendamiento": "YYYY-MM-DDThh:mm:ssZ",
    "cantidadReagendamientos": 0,
    "maximoReagendamientos": 0,
    "observaciones": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string",
    "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioActualizacion": "string",
    "historial": [...],
    "_links": {...}
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Cita consultada exitosamente
- `400 Bad Request`: Parámetros de consulta inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos para consultar esta cita
- `404 Not Found`: Cita no encontrada
- `500 Internal Server Error`: Error interno del servidor

---

### 4. Listar Citas

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método:** `GET`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

**Query Parameters:**
- `codigoSede` (optional): String
- `estado` (optional): String
- `dniSolicitante` (optional): String
- `numeroTramite` (optional): String
- `idTecnico` (optional): String
- `fechaDesde` (optional): String (Date)
- `fechaHasta` (optional): String (Date)
- `page` (optional): Integer
- `size` (optional): Integer
- `sort` (optional): String
- `direction` (optional): String

**Response (200 OK):**
```json
{
  "success": true,
  "data": [
    {
      "citaId": "string",
      "codigoCita": "string",
      "estado": {...},
      "sedeServicio": {...},
      "solicitante": {...},
      "numeroTramite": "string",
      "programacion": {...},
      "tecnicoAsignado": {...}
    }
  ],
  "paginacion": {
    "totalRegistros": 0,
    "totalPaginas": 0,
    "paginaActual": 0,
    "registrosPorPagina": 0,
    "tieneAnterior": false,
    "tieneSiguiente": false
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Listado consultado exitosamente
- `400 Bad Request`: Parámetros de consulta inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos para listar citas
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor

---

### 5. Cancelar Cita

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/citas/{citaId}/cancelar`  
**Método:** `POST`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

**Path Parameters:**
- `citaId`: UUID de la cita a cancelar

**Request Body:**
```json
{
  "motivoCancelacion": "string",
  "tokenReagendamiento": "string",
  "observaciones": "string"
}
```

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "citaId": "string",
    "codigoCita": "string",
    "estadoAnterior": "string",
    "estadoNuevo": "string",
    "fechaCancelacion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioCancelacion": "string",
    "motivoCancelacion": "string",
    "disponibilidadLiberada": true
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Cita cancelada exitosamente
- `400 Bad Request`: Datos inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Token de reagendamiento inválido o sin permisos
- `404 Not Found`: Cita no encontrada
- `409 Conflict`: Cita en estado no cancelable
- `500 Internal Server Error`: Error interno del servidor

---

### 6. Consultar Disponibilidad

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad`  
**Método:** `GET`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String

**Query Parameters:**
- `codigoSede` (required): String
- `fechaDesde` (required): String (Date)
- `fechaHasta` (required): String (Date)
- `soloDisponibles` (optional): Boolean

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "sedeServicio": {...},
    "rangoConsultado": {...},
    "disponibilidad": [
      {
        "fecha": "YYYY-MM-DDThh:mm:ssZ",
        "diaSemana": "string",
        "esHabil": true,
        "motivoNoHabil": "string",
        "franjas": [
          {
            "idDisponibilidad": "string",
            "horaInicio": "HH:mm",
            "horaFin": "HH:mm",
            "capacidadTotal": 0,
            "capacidadOcupada": 0,
            "capacidadDisponible": 0,
            "estado": "string"
          }
        ]
      }
    ],
    "resumen": {
      "totalDias": 0,
      "diasHabiles": 0,
      "diasNoHabiles": 0,
      "totalFranjas": 0,
      "franjasDisponibles": 0,
      "franjasOcupadas": 0
    }
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Disponibilidad consultada exitosamente
- `400 Bad Request`: Parámetros inválidos o rango de fechas excede el máximo
- `401 Unauthorized`: Token JWT inválido o expirado
- `404 Not Found`: Sede no encontrada
- `500 Internal Server Error`: Error interno del servidor

---

### 7. Configurar Disponibilidad

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad`  
**Método:** `POST`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: ADMINISTRADOR

**Request Body:**
```json
{
  "sedeServicio": {
    "codigoSede": "string",
    "nombreSede": "string",
    "direccion": "string",
    "capacidadDiariaMaxima": 0,
    "tiempoAtencionMinutos": 0
  },
  "horarioServicio": [
    {
      "diaSemana": 0,
      "nombreDia": "string",
      "horaInicio": "HH:mm",
      "horaFin": "HH:mm",
      "capacidadPorFranja": 0,
      "duracionFranjaMinutos": 0,
      "activo": true
    }
  ],
  "rangoAplicacion": {
    "fechaDesde": "YYYY-MM-DDThh:mm:ssZ",
    "fechaHasta": "YYYY-MM-DDThh:mm:ssZ"
  },
  "generarDisponibilidadAutomatica": true
}
```

**Response (201 Created):**
```json
{
  "success": true,
  "data": {
    "sedeServicioId": "string",
    "codigoSede": "string",
    "nombreSede": "string",
    "configuracion": {
      "capacidadDiariaMaxima": 0,
      "tiempoAtencionMinutos": 0,
      "horariosConfigurados": 0
    },
    "disponibilidadGenerada": {
      "diasGenerados": 0,
      "franjasGeneradas": 0,
      "fechaDesde": "YYYY-MM-DDThh:mm:ssZ",
      "fechaHasta": "YYYY-MM-DDThh:mm:ssZ"
    },
    "fechaConfiguracion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioConfiguracion": "string"
  },
  "metadata": {...}
}
```

**Status Codes:**
- `201 Created`: Disponibilidad configurada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `409 Conflict`: Ya existe configuración para esta sede
- `422 Unprocessable Entity`: Configuración inválida (horarios superpuestos, etc.)
- `500 Internal Server Error`: Error interno del servidor

---

### 8. Actualizar Disponibilidad

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad/{disponibilidadId}`  
**Método:** `PUT`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: ADMINISTRADOR

**Path Parameters:**
- `disponibilidadId`: UUID de la disponibilidad a actualizar

**Request Body:**
```json
{
  "capacidadTotal": 0,
  "estado": "string",
  "motivoCambio": "string"
}
```

**Response (200 OK):**
```json
{
  "success": true,
  "data": {
    "idDisponibilidad": "string",
    "fecha": "YYYY-MM-DDThh:mm:ssZ",
    "horaInicio": "HH:mm",
    "horaFin": "HH:mm",
    "capacidadAnterior": 0,
    "capacidadNueva": 0,
    "capacidadOcupada": 0,
    "capacidadDisponible": 0,
    "estadoAnterior": "string",
    "estadoNuevo": "string",
    "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioActualizacion": "string"
  },
  "metadata": {...}
}
```

**Status Codes:**
- `200 OK`: Disponibilidad actualizada exitosamente
- `400 Bad Request`: Datos inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `404 Not Found`: Disponibilidad no encontrada
- `409 Conflict`: Capacidad nueva menor que citas ya programadas
- `500 Internal Server Error`: Error interno del servidor

---

### 9. Registrar Excepción Horaria

**Path:** `/api/v1/agendamiento/MsDatosAgendamiento/excepciones`  
**Método:** `POST`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: ADMINISTRADOR

**Request Body:**
```json
{
  "codigoSede": "string",
  "fechaExcepcion": "YYYY-MM-DDThh:mm:ssZ",
  "tipoExcepcion": "string",
  "descripcion": "string",
  "horarioEspecial": {
    "horaInicio": "HH:mm",
    "horaFin": "HH:mm",
    "capacidadPorFranja": 0
  },
  "afectaCitasExistentes": true,
  "notificarAfectados": true
}
```

**Response (201 Created):**
```json
{
  "success": true,
  "data": {
    "idExcepcion": "string",
    "codigoSede": "string",
    "nombreSede": "string",
    "fechaExcepcion": "YYYY-MM-DDThh:mm:ssZ",
    "tipoExcepcion": "string",
    "descripcion": "string",
    "horarioEspecial": {...},
    "citasAfectadas": {
      "cantidad": 0,
      "accion": "string",
      "citasIds": ["string"]
    },
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string"
  },
  "metadata": {...}
}
```

**Status Codes:**
- `201 Created`: Excepción registrada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `409 Conflict`: Ya existe excepción para esa fecha/sede
- `422 Unprocessable Entity`: Fecha de excepción en el pasado
- `500 Internal Server Error`: Error interno del servidor

---

## Entidades del Dominio

### 1. Cita (Aggregate Root)
- `citaId`: String (UUID)
- `codigoCita`: String
- `estado`: EstadoCita (Value Object)
- `sedeServicio`: SedeServicio (Value Object)
- `solicitud`: Solicitud (Value Object)
- `solicitante`: Solicitante (Value Object)
- `programacion`: Programacion (Value Object)
- `tecnicoAsignado`: TecnicoAsignado (Value Object) - Optional
- `tokenReagendamiento`: String
- `fechaLimiteReagendamiento`: LocalDateTime
- `cantidadReagendamientos`: Integer
- `maximoReagendamientos`: Integer
- `observaciones`: String
- `fechaRegistro`: LocalDateTime
- `usuarioRegistro`: String
- `fechaActualizacion`: LocalDateTime
- `usuarioActualizacion`: String

### 2. Disponibilidad (Aggregate Root)
- `idDisponibilidad`: String (UUID)
- `codigoSede`: String
- `fecha`: LocalDate
- `diaSemana`: String
- `esHabil`: Boolean
- `motivoNoHabil`: String
- `horaInicio`: LocalTime
- `horaFin`: LocalTime
- `capacidadTotal`: Integer
- `capacidadOcupada`: Integer
- `capacidadDisponible`: Integer
- `estado`: String
- `fechaRegistro`: LocalDateTime
- `usuarioRegistro`: String
- `fechaActualizacion`: LocalDateTime
- `usuarioActualizacion`: String

### 3. ExcepcionHoraria (Aggregate Root)
- `idExcepcion`: String (UUID)
- `codigoSede`: String
- `fechaExcepcion`: LocalDate
- `tipoExcepcion`: String
- `descripcion`: String
- `horarioEspecial`: HorarioEspecial (Value Object) - Optional
- `afectaCitasExistentes`: Boolean
- `notificarAfectados`: Boolean
- `fechaRegistro`: LocalDateTime
- `usuarioRegistro`: String

### 4. HistorialCita (Entity)
- `idHistorial`: String (UUID)
- `citaId`: String (UUID)
- `fechaCambio`: LocalDateTime
- `estadoAnterior`: String
- `estadoNuevo`: String
- `fechaAnterior`: LocalDateTime
- `horaAnterior`: LocalTime
- `fechaNueva`: LocalDateTime
- `horaNueva`: LocalTime
- `motivoCambio`: String
- `usuarioCambio`: String

### Value Objects

#### EstadoCita
- `codigo`: String
- `descripcion`: String
- `permiteModificacion`: Boolean
- `permiteCancelacion`: Boolean

#### SedeServicio
- `codigoSede`: String
- `nombreSede`: String
- `direccion`: String
- `telefono`: String
- `capacidadDiariaMaxima`: Integer
- `tiempoAtencionMinutos`: Integer

#### Solicitud
- `idSolicitud`: String (UUID)
- `numeroTramite`: String

#### Solicitante
- `dni`: String
- `nombres`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `email`: String
- `telefono`: String

#### Programacion
- `fechaCita`: LocalDate
- `horaCita`: LocalTime
- `idDisponibilidad`: String (UUID)

#### TecnicoAsignado
- `idTecnico`: String
- `nombreCompleto`: String

#### HorarioEspecial
- `horaInicio`: LocalTime
- `horaFin`: LocalTime
- `capacidadPorFranja`: Integer

#### HorarioServicio
- `diaSemana`: Integer
- `nombreDia`: String
- `horaInicio`: LocalTime
- `horaFin`: LocalTime
- `capacidadPorFranja`: Integer
- `duracionFranjaMinutos`: Integer
- `activo`: Boolean

#### Paginacion
- `totalRegistros`: Integer
- `totalPaginas`: Integer
- `paginaActual`: Integer
- `registrosPorPagina`: Integer
- `tieneAnterior`: Boolean
- `tieneSiguiente`: Boolean

#### ResumenDisponibilidad
- `totalDias`: Integer
- `diasHabiles`: Integer
- `diasNoHabiles`: Integer
- `totalFranjas`: Integer
- `franjasDisponibles`: Integer
- `franjasOcupadas`: Integer

#### CitasAfectadas
- `cantidad`: Integer
- `accion`: String
- `citasIds`: List\<String\>

## Mapeo de Tipos

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer | Integer |
| boolean | Boolean |
| date (YYYY-MM-DD) | LocalDate |
| datetime (YYYY-MM-DDThh:mm:ssZ) | LocalDateTime |
| time (HH:mm) | LocalTime |
| UUID | String |
| array | List\<T\> |

## Estructura del Proyecto

Como este es un microservicio de tipo **MsData**, la estructura incluye:

- **domain/model**: Entidades del dominio (Cita, Disponibilidad, ExcepcionHoraria, HistorialCita) y Value Objects
- **domain/ports/in**: Use Cases (interfaces) para cada operación de negocio
- **domain/ports/out**: Repository Ports (interfaces) para acceso a datos
- **application/service**: Servicios que implementan los Use Cases
- **infrastructure/adapters/in/rest**: Controllers, DTOs (records) y Mappers REST
- **infrastructure/adapters/out/persistence**: Entities, Mappers y Repository Adapters

## Limitaciones

- **Sin frameworks**: No se utilizan anotaciones ni dependencias de Spring, JPA, JAX-RS, MapStruct, etc.
- **POJOs puros**: Todas las clases son Java estándar compilables sin dependencias externas
- **Sin protocolo definido**: Los adaptadores no especifican la tecnología de conexión (HTTP, base de datos específica)
- **Código stub**: Los métodos lanzan `UnsupportedOperationException` o tienen cuerpos mínimos para mantener la arquitectura clara

## Notas de Implementación

1. **Arquitectura Hexagonal Estricta**: Separación clara entre dominio, aplicación e infraestructura
2. **Neutralidad Tecnológica**: El código es independiente de frameworks y tecnologías específicas
3. **Trazabilidad**: Cada endpoint del PDF se mapea a un Use Case específico
4. **Validation**: Las validaciones de negocio se documentan pero no se implementan para mantener el código simple
5. **Error Handling**: Los códigos de error HTTP están documentados pero no implementados en el código

## Versión

**Documento Versión:** 1.0  
**Fecha de Generación:** 01/12/2025  
**Arquitecto de Software:** RENIEC - Gestión de Seguridad Electrónica
