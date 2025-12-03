# Microservicio MsDatosAgendamiento

## Resumen

**Nombre del Microservicio**: MsDatosAgendamiento  
**Versión API**: v1  
**Paquete Base**: `pe.gob.reniec.agendamiento.msdatos`  
**Tipo**: MsData (Microservicio de Datos)

### Contexto de Negocio

El Microservicio Datos Agendamiento es un componente de persistencia y acceso a datos dedicado para el sistema de agendamiento del RENIEC. Su propósito principal es interactuar de manera exclusiva con la Base de Datos de Agendamiento, actuando como el único intermediario para su administración. Se encarga de almacenar, recuperar y gestionar de forma segura toda la información de las agendas, la disponibilidad horaria y los datos de las citas programadas para las visitas de lectura de documentos archivados en el sistema SIIRC.

## Endpoints

### 3.1.1 Endpoint: Crear Agenda

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método**: `POST`  
**Descripción**: Permite la creación de una nueva cita para visita de lectura de documento archivado.

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario
- `X-Idempotency-Key`: UUID para evitar duplicados

**Request Body**:
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

**Status Codes**:
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

### 3.1.2 Endpoint: Actualizar Cita

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/citas/{citaId}`  
**Método**: `PUT`  
**Descripción**: Permite actualizar una cita existente (reagendamiento).

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario

**Request Body**:
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

**Status Codes**:
- `200 OK`: Cita actualizada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Token de reagendamiento inválido o expirado
- `404 Not Found`: Cita no encontrada
- `409 Conflict`: No hay disponibilidad o cita en estado no modificable
- `422 Unprocessable Entity`: Excedido límite de reagendamientos
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.3 Endpoint: Consultar Cita

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método**: `GET`  
**Descripción**: Permite consultar los detalles de una cita específica.

**Headers**:
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario

**Query Parameters**:
- `citaId` (string, obligatorio): Identificador único de la cita
- `incluirHistorial` (boolean, opcional): Indica si debe incluirse el historial

**Status Codes**:
- `200 OK`: Cita consultada exitosamente
- `400 Bad Request`: Parámetros de consulta inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos para consultar esta cita
- `404 Not Found`: Cita no encontrada
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.4 Endpoint: Listar Citas

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/citas`  
**Método**: `GET`  
**Descripción**: Permite listar citas con parámetros de filtrado y paginación.

**Headers**:
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario

**Query Parameters**:
- `codigoSede` (string, opcional): Código de la sede
- `estado` (string, opcional): Estado de la cita
- `dniSolicitante` (string, opcional): DNI del solicitante
- `numeroTramite` (string, opcional): Número de trámite
- `idTecnico` (string, opcional): ID del técnico
- `fechaDesde` (string, opcional): Fecha inicial del rango
- `fechaHasta` (string, opcional): Fecha final del rango
- `page` (integer, opcional): Número de página (default: 0)
- `size` (integer, opcional): Registros por página (default: 20)
- `sort` (string, opcional): Campo para ordenar
- `direction` (string, opcional): Dirección del ordenamiento (ASC/DESC)

**Status Codes**:
- `200 OK`: Listado consultado exitosamente
- `400 Bad Request`: Parámetros de consulta inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos para listar citas
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.5 Endpoint: Cancelar Cita

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/citas/{citaId}/cancelar`  
**Método**: `POST`  
**Descripción**: Permite cancelar una cita existente.

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: Rol del usuario

**Request Body**:
```json
{
  "motivoCancelacion": "string",
  "tokenReagendamiento": "string",
  "observaciones": "string"
}
```

**Status Codes**:
- `200 OK`: Cita cancelada exitosamente
- `400 Bad Request`: Datos inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Token de reagendamiento inválido o sin permisos
- `404 Not Found`: Cita no encontrada
- `409 Conflict`: Cita en estado no cancelable
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.6 Endpoint: Consultar Disponibilidad

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad`  
**Método**: `GET`  
**Descripción**: Permite consultar la disponibilidad horaria de una sede.

**Headers**:
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina

**Query Parameters**:
- `codigoSede` (string, obligatorio): Código de la sede
- `fechaDesde` (string, obligatorio): Fecha inicial del rango
- `fechaHasta` (string, obligatorio): Fecha final del rango
- `soloDisponibles` (boolean, opcional): Filtrar solo disponibles

**Status Codes**:
- `200 OK`: Disponibilidad consultada exitosamente
- `400 Bad Request`: Parámetros inválidos o rango excedido
- `401 Unauthorized`: Token JWT inválido o expirado
- `404 Not Found`: Sede no encontrada
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.7 Endpoint: Configurar Disponibilidad

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad`  
**Método**: `POST`  
**Descripción**: Permite configurar la disponibilidad horaria de una sede.

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: ADMINISTRADOR

**Request Body**:
```json
{
  "sedeServicio": {
    "codigoSede": "string",
    "nombreSede": "string",
    "direccion": "string",
    "capacidadDiariaMaxima": "integer",
    "tiempoAtencionMinutos": "integer"
  },
  "horarioServicio": [
    {
      "diaSemana": "integer",
      "nombreDia": "string",
      "horaInicio": "HH:mm",
      "horaFin": "HH:mm",
      "capacidadPorFranja": "integer",
      "duracionFranjaMinutos": "integer",
      "activo": "boolean"
    }
  ],
  "rangoAplicacion": {
    "fechaDesde": "YYYY-MM-DDThh:mm:ssZ",
    "fechaHasta": "YYYY-MM-DDThh:mm:ssZ"
  },
  "generarDisponibilidadAutomatica": "boolean"
}
```

**Status Codes**:
- `201 Created`: Disponibilidad configurada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `409 Conflict`: Ya existe configuración para esta sede
- `422 Unprocessable Entity`: Configuración inválida (horarios superpuestos)
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.8 Endpoint: Actualizar Disponibilidad

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/disponibilidad/{disponibilidadId}`  
**Método**: `PUT`  
**Descripción**: Permite actualizar la disponibilidad de una franja horaria.

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: ADMINISTRADOR

**Request Body**:
```json
{
  "capacidadTotal": "integer",
  "estado": "string",
  "motivoCambio": "string"
}
```

**Status Codes**:
- `200 OK`: Disponibilidad actualizada exitosamente
- `400 Bad Request`: Datos inválidos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `404 Not Found`: Disponibilidad no encontrada
- `409 Conflict`: Capacidad nueva menor que citas programadas
- `500 Internal Server Error`: Error interno del servidor

---

### 3.1.9 Endpoint: Registrar Excepción Horaria

**Path**: `/api/v1/agendamiento/MsDatosAgendamiento/excepciones`  
**Método**: `POST`  
**Descripción**: Permite registrar excepciones horarias (feriados, cierres).

**Headers**:
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID
- `X-Office-Code`: Código de oficina
- `X-User-Role`: ADMINISTRADOR

**Request Body**:
```json
{
  "codigoSede": "string",
  "fechaExcepcion": "YYYY-MM-DDThh:mm:ssZ",
  "tipoExcepcion": "string",
  "descripcion": "string",
  "horarioEspecial": {
    "horaInicio": "HH:mm",
    "horaFin": "HH:mm",
    "capacidadPorFranja": "integer"
  },
  "afectaCitasExistentes": "boolean",
  "notificarAfectados": "boolean"
}
```

**Status Codes**:
- `201 Created`: Excepción registrada exitosamente
- `400 Bad Request`: Datos inválidos o incompletos
- `401 Unauthorized`: Token JWT inválido o expirado
- `403 Forbidden`: Usuario sin permisos de administrador
- `409 Conflict`: Ya existe excepción para esa fecha/sede
- `422 Unprocessable Entity`: Fecha de excepción en el pasado
- `500 Internal Server Error`: Error interno del servidor

---

## Entidades del Dominio

### Cita (Aggregate Root)
Representa una cita agendada para visita de lectura de documento.

**Atributos**:
- `citaId`: String (UUID)
- `codigoCita`: String
- `estado`: EstadoCita (objeto de valor)
- `sedeServicio`: SedeServicio (objeto de valor)
- `solicitud`: Solicitud (objeto de valor)
- `solicitante`: Solicitante (objeto de valor)
- `programacion`: Programacion (objeto de valor)
- `tecnicoAsignado`: TecnicoAsignado (objeto de valor, opcional)
- `tokenReagendamiento`: String
- `fechaLimiteReagendamiento`: LocalDateTime
- `cantidadReagendamientos`: Integer
- `maximoReagendamientos`: Integer
- `observaciones`: String
- `fechaRegistro`: LocalDateTime
- `usuarioRegistro`: String
- `fechaActualizacion`: LocalDateTime (opcional)
- `usuarioActualizacion`: String (opcional)

### Disponibilidad (Aggregate Root)
Representa la disponibilidad horaria configurada para una sede.

**Atributos**:
- `idDisponibilidad`: String (UUID)
- `codigoSede`: String
- `fecha`: LocalDate
- `diaSemana`: String
- `esHabil`: Boolean
- `motivoNoHabil`: String (opcional)
- `horaInicio`: String (Time)
- `horaFin`: String (Time)
- `capacidadTotal`: Integer
- `capacidadOcupada`: Integer
- `capacidadDisponible`: Integer
- `estado`: String

### ExcepcionHoraria (Aggregate Root)
Representa excepciones en el horario (feriados, cierres).

**Atributos**:
- `idExcepcion`: String (UUID)
- `codigoSede`: String
- `fechaExcepcion`: LocalDate
- `tipoExcepcion`: String
- `descripcion`: String
- `horarioEspecial`: HorarioEspecial (objeto de valor, opcional)
- `afectaCitasExistentes`: Boolean
- `notificarAfectados`: Boolean
- `fechaRegistro`: LocalDateTime
- `usuarioRegistro`: String

---

## Reglas de Mapeo de Tipos

Según la especificación del PDF, se aplican las siguientes conversiones:

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer / int | Integer |
| long | Long |
| number / decimal / double | Double |
| boolean | Boolean |
| date (YYYY-MM-DD) | LocalDate |
| datetime / timestamp (ISO 8601) | LocalDateTime |
| time (HH:mm) | String |
| array / list | List<T> |
| object | Clase POJO |

---

## Características del Proyecto

### Tipo de Microservicio: MsData

Como este es un **MsData** (Microservicio de Datos):
- ✅ Define `RepositoryPort` en `domain/ports/out/`
- ✅ Define `Entities` en `infrastructure/adapters/out/persistence/entity/`
- ✅ Implementa `RepositoryAdapter` en `infrastructure/adapters/out/persistence/`
- ✅ No depende de componentes externos MsDataXXXX

### Arquitectura Hexagonal

El proyecto sigue estrictamente Arquitectura Hexagonal:
- **Domain**: Lógica de negocio pura, independiente de frameworks
- **Application**: Casos de uso que orquestan la lógica de dominio
- **Infrastructure**: Adaptadores para interactuar con el mundo exterior

### Sin Dependencias de Frameworks

- ❌ No usa Spring, JAX-RS, JPA, MapStruct u otras librerías
- ✅ Solo interfaces, clases e interfaces Java puras (POJOs)
- ✅ Código compilable como Java estándar
- ✅ Adaptadores con implementaciones stub/mínimas

---

## Limitaciones

1. **Sin Tecnología Específica**: No se define cómo se conecta a la base de datos. Los adaptadores de repositorio tienen métodos stub que lanzan `UnsupportedOperationException`.

2. **Sin Frameworks**: No hay anotaciones de Spring, JPA, ni configuraciones de frameworks. El código es Java puro.

3. **Sin Configuración de Build**: No se incluye `pom.xml`, `build.gradle` ni configuraciones Maven/Gradle por neutralidad tecnológica.

4. **Mappers Manuales**: Los mappers son clases con métodos de conversión sin usar librerías como MapStruct.

5. **Controllers Sin Anotaciones**: Los controllers son POJOs sin anotaciones HTTP. Representan la estructura pero no son funcionales sin un framework.

6. **Operaciones Definidas por el PDF**: Solo se implementan las operaciones documentadas en el PDF. No se asumen ni inventan casos de uso adicionales.

---

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/agendamiento/msdatos/
├── domain/
│   ├── model/
│   │   ├── Cita.java
│   │   ├── Disponibilidad.java
│   │   ├── ExcepcionHoraria.java
│   │   ├── SedeServicio.java
│   │   ├── Solicitud.java
│   │   ├── Solicitante.java
│   │   ├── Programacion.java
│   │   ├── TecnicoAsignado.java
│   │   ├── EstadoCita.java
│   │   ├── HorarioServicio.java
│   │   ├── HorarioEspecial.java
│   │   └── ...
│   └── ports/
│       ├── in/
│       │   ├── CrearCitaUseCase.java
│       │   ├── ActualizarCitaUseCase.java
│       │   ├── ConsultarCitaUseCase.java
│       │   ├── ListarCitasUseCase.java
│       │   ├── CancelarCitaUseCase.java
│       │   ├── ConsultarDisponibilidadUseCase.java
│       │   ├── ConfigurarDisponibilidadUseCase.java
│       │   ├── ActualizarDisponibilidadUseCase.java
│       │   └── RegistrarExcepcionHorariaUseCase.java
│       └── out/
│           ├── CitaRepositoryPort.java
│           ├── DisponibilidadRepositoryPort.java
│           └── ExcepcionHorariaRepositoryPort.java
├── application/
│   └── service/
│       ├── CrearCitaService.java
│       ├── ActualizarCitaService.java
│       ├── ConsultarCitaService.java
│       ├── ListarCitasService.java
│       ├── CancelarCitaService.java
│       ├── ConsultarDisponibilidadService.java
│       ├── ConfigurarDisponibilidadService.java
│       ├── ActualizarDisponibilidadService.java
│       └── RegistrarExcepcionHorariaService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   ├── CitaController.java
        │       │   ├── DisponibilidadController.java
        │       │   └── ExcepcionHorariaController.java
        │       ├── dto/
        │       │   ├── CrearCitaRequestDto.java
        │       │   ├── CrearCitaResponseDto.java
        │       │   ├── ActualizarCitaRequestDto.java
        │       │   ├── ActualizarCitaResponseDto.java
        │       │   └── ...
        │       └── mapper/
        │           ├── CitaDtoMapper.java
        │           ├── DisponibilidadDtoMapper.java
        │           └── ExcepcionHorariaDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── CitaEntity.java
                │   ├── DisponibilidadEntity.java
                │   └── ExcepcionHorariaEntity.java
                ├── mapper/
                │   ├── CitaPersistenceMapper.java
                │   ├── DisponibilidadPersistenceMapper.java
                │   └── ExcepcionHorariaPersistenceMapper.java
                ├── CitaRepositoryAdapter.java
                ├── DisponibilidadRepositoryAdapter.java
                └── ExcepcionHorariaRepositoryAdapter.java
```

---

## Versión

**Documento Versión**: 1.0  
**Fecha de Generación del Documento**: 01/12/2025  
**Fecha de Generación del Código**: 03/12/2025
