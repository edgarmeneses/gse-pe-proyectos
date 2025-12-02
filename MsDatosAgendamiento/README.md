# MsDatosAgendamiento

## Descripción

Microservicio de tipo **MsData** para la gestión de datos de agendamiento de citas en RENIEC. Implementa Arquitectura Hexagonal estricta sin uso de frameworks ni anotaciones.

**Versión API:** v1  
**Tipo:** MsDataXXXX (Capa de persistencia de datos)  
**Base de paquete:** `pe.gob.reniec.agendamiento`

---

## Contexto

Este microservicio forma parte del sistema de agendamiento de RENIEC y es responsable de:
- Gestión del ciclo de vida completo de citas (crear, actualizar, consultar, listar, cancelar)
- Configuración y consulta de disponibilidad de horarios
- Registro de excepciones horarias (feriados, cierres especiales)
- Persistencia de datos sin integración con servicios externos

---

## Arquitectura

### Arquitectura Hexagonal

```
src/main/java/pe/gob/reniec/agendamiento/
├── domain/
│   ├── model/                    # Agregados, Entidades y Value Objects
│   │   ├── Cita.java
│   │   ├── SedeServicio.java
│   │   ├── Solicitud.java
│   │   ├── Solicitante.java
│   │   ├── Programacion.java
│   │   ├── TecnicoAsignado.java
│   │   ├── Disponibilidad.java
│   │   ├── HorarioServicio.java
│   │   ├── ExcepcionHoraria.java
│   │   ├── HorarioEspecial.java
│   │   └── CitasAfectadas.java
│   └── ports/
│       ├── in/                   # Puertos de entrada (Use Cases)
│       │   ├── CrearCitaUseCase.java
│       │   ├── ActualizarCitaUseCase.java
│       │   ├── ConsultarCitaUseCase.java
│       │   ├── ListarCitasUseCase.java
│       │   ├── CancelarCitaUseCase.java
│       │   ├── ConsultarDisponibilidadUseCase.java
│       │   ├── ConfigurarDisponibilidadUseCase.java
│       │   ├── ActualizarDisponibilidadUseCase.java
│       │   └── RegistrarExcepcionHorariaUseCase.java
│       └── out/                  # Puertos de salida (Repository Ports)
│           ├── CitaRepositoryPort.java
│           ├── DisponibilidadRepositoryPort.java
│           └── ExcepcionHorariaRepositoryPort.java
├── application/
│   └── service/                  # Servicios de Aplicación
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
        ├── in/                   # Adaptadores de entrada
        │   └── rest/
        │       ├── controller/
        │       │   ├── CitaController.java
        │       │   ├── DisponibilidadController.java
        │       │   └── ExcepcionHorariaController.java
        │       ├── dto/          # DTOs como Java records
        │       │   ├── CrearCitaRequestDto.java
        │       │   ├── ActualizarCitaRequestDto.java
        │       │   ├── CancelarCitaRequestDto.java
        │       │   ├── ConfigurarDisponibilidadRequestDto.java
        │       │   ├── ActualizarDisponibilidadRequestDto.java
        │       │   ├── RegistrarExcepcionHorariaRequestDto.java
        │       │   ├── CitaResponseDto.java
        │       │   ├── ListarCitasResponseDto.java
        │       │   ├── DisponibilidadResponseDto.java
        │       │   ├── ExcepcionHorariaResponseDto.java
        │       │   └── [otros DTOs auxiliares]
        │       └── mapper/
        │           ├── CitaDtoMapper.java
        │           ├── DisponibilidadDtoMapper.java
        │           └── ExcepcionHorariaDtoMapper.java
        └── out/                  # Adaptadores de salida
            └── persistence/
                ├── entity/
                │   ├── CitaEntity.java
                │   ├── DisponibilidadEntity.java
                │   └── ExcepcionHorariaEntity.java
                ├── mapper/
                │   ├── CitaPersistenceMapper.java
                │   ├── DisponibilidadPersistenceMapper.java
                │   └── ExcepcionHorariaPersistenceMapper.java
                └── adapter/
                    ├── CitaRepositoryAdapter.java
                    ├── DisponibilidadRepositoryAdapter.java
                    └── ExcepcionHorariaRepositoryAdapter.java
```

---

## API REST - Endpoints

### 1. Crear Cita
**POST** `/api/v1/citas`

Crea una nueva cita de atención.

**Request Body:**
```json
{
  "sedeServicio": {
    "codigoSede": "string",
    "nombreSede": "string",
    "direccion": "string",
    "telefono": "string",
    "capacidadDiariaMaxima": "Long",
    "tiempoAtencionMinutos": "Long"
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
    "nombreCompleto": "string",
    "email": "string",
    "telefono": "string"
  },
  "programacion": {
    "fechaCita": "yyyy-MM-dd",
    "horaCita": "HH:mm",
    "fechaHoraCompleta": "yyyy-MM-dd'T'HH:mm:ss",
    "idDisponibilidad": "string"
  },
  "tecnicoAsignado": {
    "idTecnico": "string",
    "nombreCompleto": "string"
  },
  "observaciones": "string"
}
```

**Response:** `CitaResponseDto` (200 OK)

---

### 2. Actualizar Cita
**PUT** `/api/v1/citas/{citaId}`

Actualiza una cita existente (reagendamiento).

**Path Parameters:**
- `citaId` (string): Identificador único de la cita

**Request Body:**
```json
{
  "tokenReagendamiento": "string",
  "nuevaProgramacion": {
    "fechaCita": "yyyy-MM-dd",
    "horaCita": "HH:mm",
    "fechaHoraCompleta": "yyyy-MM-dd'T'HH:mm:ss",
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

**Response:** `CitaResponseDto` (200 OK)

---

### 3. Consultar Cita
**GET** `/api/v1/citas/{citaId}`

Consulta los detalles de una cita por su ID.

**Path Parameters:**
- `citaId` (string): Identificador único de la cita

**Response:** `CitaResponseDto` (200 OK)

---

### 4. Listar Citas
**GET** `/api/v1/citas`

Lista citas con filtros opcionales.

**Query Parameters:**
- `codigoSede` (string, opcional)
- `fechaDesde` (string, opcional)
- `fechaHasta` (string, opcional)
- `estado` (string, opcional)
- `dni` (string, opcional)
- `pagina` (Long, opcional)
- `tamanoPagina` (Long, opcional)

**Response:** `ListarCitasResponseDto` (200 OK) con paginación

---

### 5. Cancelar Cita
**POST** `/api/v1/citas/{citaId}/cancelar`

Cancela una cita existente.

**Path Parameters:**
- `citaId` (string): Identificador único de la cita

**Request Body:**
```json
{
  "motivoCancelacion": "string",
  "tokenReagendamiento": "string",
  "observaciones": "string"
}
```

**Response:** `CitaResponseDto` (200 OK)

---

### 6. Consultar Disponibilidad
**GET** `/api/v1/disponibilidad`

Consulta disponibilidad de horarios.

**Query Parameters:**
- `codigoSede` (string, requerido)
- `fechaDesde` (string, requerido)
- `fechaHasta` (string, requerido)

**Response:** `DisponibilidadResponseDto` (200 OK)

---

### 7. Configurar Disponibilidad
**POST** `/api/v1/disponibilidad`

Configura la disponibilidad de horarios para una sede.

**Request Body:**
```json
{
  "sedeServicio": {
    "codigoSede": "string",
    "nombreSede": "string",
    "direccion": "string",
    "telefono": "string",
    "capacidadDiariaMaxima": "Long",
    "tiempoAtencionMinutos": "Long"
  },
  "horarioServicio": [
    {
      "diaSemana": "Long",
      "nombreDia": "string",
      "horaInicio": "HH:mm",
      "horaFin": "HH:mm",
      "capacidadPorFranja": "Long",
      "duracionFranjaMinutos": "Long",
      "activo": "Boolean"
    }
  ],
  "rangoAplicacion": {
    "fechaDesde": "yyyy-MM-dd",
    "fechaHasta": "yyyy-MM-dd"
  },
  "generarDisponibilidadAutomatica": "Boolean"
}
```

**Response:** `DisponibilidadResponseDto` (200 OK)

---

### 8. Actualizar Disponibilidad
**PUT** `/api/v1/disponibilidad/{disponibilidadId}`

Actualiza una disponibilidad existente.

**Path Parameters:**
- `disponibilidadId` (string): Identificador único de la disponibilidad

**Request Body:**
```json
{
  "capacidadTotal": "Long",
  "estado": "string",
  "motivoCambio": "string"
}
```

**Response:** `DisponibilidadResponseDto` (200 OK)

---

### 9. Registrar Excepción Horaria
**POST** `/api/v1/excepciones`

Registra una excepción horaria (feriado, cierre especial).

**Request Body:**
```json
{
  "codigoSede": "string",
  "fechaExcepcion": "yyyy-MM-dd",
  "tipoExcepcion": "string",
  "descripcion": "string",
  "horarioEspecial": {
    "horaInicio": "HH:mm",
    "horaFin": "HH:mm",
    "capacidadPorFranja": "Long"
  },
  "afectaCitasExistentes": "Boolean",
  "notificarAfectados": "Boolean"
}
```

**Response:** `ExcepcionHorariaResponseDto` (200 OK)

---

## Modelo de Dominio

### Agregados

#### Cita
Representa una cita de atención con un ciudadano.

**Atributos:**
- `citaId` (String): Identificador único
- `codigoCita` (String): Código de referencia
- `estado` (String): PENDIENTE, CONFIRMADA, ATENDIDA, CANCELADA
- `sedeServicio` (SedeServicio): Sede donde se atenderá
- `solicitud` (Solicitud): Datos de la solicitud asociada
- `solicitante` (Solicitante): Datos del ciudadano
- `programacion` (Programacion): Fecha y hora programada
- `tecnicoAsignado` (TecnicoAsignado): Técnico responsable (opcional)
- `tokenReagendamiento` (String): Token para reagendar
- `fechaLimiteReagendamiento` (LocalDateTime): Límite para reagendar
- `cantidadReagendamientos` (Long): Contador de reagendamientos
- `maximoReagendamientos` (Long): Límite de reagendamientos (por defecto 3)
- `observaciones` (String): Notas adicionales
- Campos de auditoría: `fechaRegistro`, `usuarioRegistro`, `fechaActualizacion`, `usuarioActualizacion`

#### Disponibilidad
Representa la disponibilidad de horarios para una sede.

**Atributos:**
- `idDisponibilidad` (String): Identificador único
- `sedeServicio` (SedeServicio): Sede asociada
- `fecha` (LocalDate): Fecha específica
- `diaSemana` (String): Nombre del día
- `esHabil` (Boolean): Indica si el día es hábil
- `motivoNoHabil` (String): Razón si no es hábil
- `horaInicio` (LocalTime): Hora de inicio de atención
- `horaFin` (LocalTime): Hora de fin de atención
- `capacidadTotal` (Long): Capacidad total de citas
- `capacidadOcupada` (Long): Citas ya agendadas
- `capacidadDisponible` (Long): Espacios disponibles
- `estado` (String): DISPONIBLE, AGOTADA, BLOQUEADA
- `horarioServicio` (List<HorarioServicio>): Franjas horarias
- Campos de auditoría

#### ExcepcionHoraria
Representa excepciones al horario normal (feriados, cierres).

**Atributos:**
- `idExcepcion` (String): Identificador único
- `codigoSede` (String): Código de la sede
- `nombreSede` (String): Nombre de la sede
- `fechaExcepcion` (LocalDate): Fecha de la excepción
- `tipoExcepcion` (String): FERIADO, CIERRE_ESPECIAL, HORARIO_ESPECIAL
- `descripcion` (String): Descripción de la excepción
- `horarioEspecial` (HorarioEspecial): Horario alternativo (opcional)
- `citasAfectadas` (CitasAfectadas): Citas impactadas
- Campos de auditoría

### Value Objects

- **SedeServicio**: Información de la sede de atención
- **Solicitud**: Datos de la solicitud/trámite
- **Solicitante**: Información del ciudadano
- **Programacion**: Fecha, hora y disponibilidad asignada
- **TecnicoAsignado**: Técnico responsable de la atención
- **HorarioServicio**: Configuración de horarios por día de semana
- **HorarioEspecial**: Horario alternativo para excepciones
- **CitasAfectadas**: Información sobre citas impactadas por excepciones

---

## Decisiones de Arquitectura

### 1. Sin Frameworks
- **Java Puro**: POJOs sin anotaciones (@Entity, @Service, @RestController, etc.)
- **Sin Spring**: No se usa Spring Boot, Spring Data, ni ningún otro framework
- **Sin JPA**: Entidades de persistencia sin anotaciones de mapeo

### 2. Technology Neutral
- Los Repository Adapters tienen métodos con `UnsupportedOperationException`
- No se define tecnología de base de datos (puede ser SQL, NoSQL, archivos, etc.)
- No se define protocolo de comunicación (puede ser REST, gRPC, GraphQL, etc.)
- La implementación concreta de persistencia se debe proveer externamente

### 3. Tipos de Datos
Se utilizan exclusivamente:
- `String`: Para textos e identificadores
- `Long`: Para números enteros y contadores
- `Boolean`: Para valores booleanos
- `LocalDate`: Para fechas
- `LocalTime`: Para horas
- `LocalDateTime`: Para marcas de tiempo completas
- `List<T>`: Para colecciones

### 4. DTOs como Records
- Todos los DTOs de request/response son Java records (inmutables)
- Sintaxis concisa y expresiva
- Validación a través de lógica de negocio en servicios

### 5. Separación Estricta de Capas
- **Domain**: Lógica de negocio pura, independiente de infraestructura
- **Application**: Orquestación de casos de uso
- **Infrastructure**: Adaptadores para entrada (REST) y salida (persistencia)

---

## Limitaciones y Consideraciones

### Implementación Pendiente
Los siguientes aspectos NO están implementados y deben ser provistos según tecnología elegida:

1. **Persistencia Real**: Los Repository Adapters lanzan excepciones, se necesita:
   - Conexión a base de datos (JDBC, MongoDB driver, etc.)
   - Implementación de métodos CRUD
   - Manejo de transacciones

2. **Protocolo de Comunicación**: Los Controllers no tienen protocolo definido, se necesita:
   - Framework REST (Spring MVC, Javalin, etc.)
   - Serialización/Deserialización JSON
   - Manejo de errores HTTP

3. **Validaciones**: No hay validaciones de negocio implementadas:
   - Validar que la fecha de cita sea futura
   - Validar capacidad disponible
   - Validar límite de reagendamientos
   - Validaciones de formato de datos

4. **Generación de IDs**: No hay estrategia para generar identificadores únicos:
   - UUID, secuencias de BD, snowflake ID, etc.

5. **Seguridad**: No hay autenticación ni autorización

6. **Logging**: No hay registro de eventos

7. **Manejo de Errores**: No hay excepciones personalizadas ni manejo centralizado

---

## Mapeo de Entidades

### Cita → CitaEntity
La entidad `Cita` se desnormaliza en `CitaEntity` aplanando los value objects:
- `SedeServicio` → campos `codigoSede`, `nombreSede`, etc.
- `Solicitud` → campos `idSolicitud`, `numeroTramite`
- `Solicitante` → campos `dniSolicitante`, `nombresSolicitante`, etc.
- `Programacion` → campos `fechaCita`, `horaCita`, etc.
- `TecnicoAsignado` → campos `idTecnico`, `nombreCompletoTecnico`

### Disponibilidad → DisponibilidadEntity
Similar desnormalización de `SedeServicio` y `HorarioServicio`.

### ExcepcionHoraria → ExcepcionHorariaEntity
Desnormalización de `HorarioEspecial` y `CitasAfectadas`.

---

## Cómo Extender

### 1. Implementar Persistencia
Ejemplo con tecnología ficticia:
```java
public class CitaRepositoryAdapterImpl extends CitaRepositoryAdapter {
    private final Database db;
    
    @Override
    public Cita guardar(Cita cita) {
        CitaEntity entity = mapper.domainToEntity(cita);
        // Guardar en base de datos
        entity = db.save(entity);
        return mapper.entityToDomain(entity);
    }
    // ... otros métodos
}
```

### 2. Implementar Protocolo REST
Ejemplo con framework ficticio:
```java
@RestController
public class CitaRestController {
    private final CitaController citaController;
    
    @PostMapping("/api/v1/citas")
    public ResponseEntity<CitaResponseDto> crearCita(@RequestBody CrearCitaRequestDto request) {
        CitaResponseDto response = citaController.crearCita(request);
        return ResponseEntity.ok(response);
    }
}
```

### 3. Agregar Validaciones
Ejemplo en el servicio:
```java
public class CrearCitaService implements CrearCitaUseCase {
    @Override
    public Cita crear(Cita cita) {
        // Validaciones
        if (cita.programacion().fechaCita().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha debe ser futura");
        }
        // ... más validaciones
        
        return citaRepositoryPort.guardar(cita);
    }
}
```

---

## Estructura Generada

El microservicio generado incluye:
- ✅ 11 clases de modelo de dominio
- ✅ 9 interfaces de puertos de entrada (use cases)
- ✅ 3 interfaces de puertos de salida (repository ports)
- ✅ 9 servicios de aplicación
- ✅ 3 controladores sin anotaciones
- ✅ 29 DTOs como Java records
- ✅ 3 mappers DTO → Domain
- ✅ 3 entidades de persistencia sin anotaciones
- ✅ 3 mappers Domain → Entity
- ✅ 3 adaptadores de repositorio con stubs

**Total:** 76 archivos Java generados

---

## Contacto y Mantenimiento

Este microservicio fue generado automáticamente a partir de la especificación PDF.  
Para cambios en funcionalidad, consultar el documento fuente: `Microservicio MsDatosAgendamiento V1.0.pdf`

**Convenciones de código:**
- Sin anotaciones de ningún tipo
- Java puro con types estrictos
- Inmutabilidad en domain model (records)
- Separación estricta de capas
- Technology neutral

---

## Licencia

Proyecto interno RENIEC - Todos los derechos reservados
