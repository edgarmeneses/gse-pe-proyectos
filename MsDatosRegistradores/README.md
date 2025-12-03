# MsDatosRegistradores

## Resumen del Microservicio

**Nombre:** MsDatosRegistradores  
**Tipo:** MsData (Microservicio de Datos)  
**Versión API:** v1.0  
**Contexto de Negocio:** Gestión de Seguridad Electrónica - Personalización del DNIe de RENIEC  
**Paquete Base:** `pe.gob.reniec.gse.registradores`

### Descripción

El Microservicio Datos Registradores es un componente de persistencia y acceso a datos dedicado. Su propósito principal es interactuar de manera exclusiva con la Base de Datos de Registradores, actuando como el único intermediario para su administración. Se encarga de almacenar, recuperar y gestionar de forma segura toda la información operacional del registrador y sus elementos de autenticación.

---

## Arquitectura

Este microservicio implementa **Arquitectura Hexagonal estricta** siguiendo los principios de Domain-Driven Design (DDD).

### Tipo de Microservicio: MsData

Como microservicio de tipo **MsData**:

- ✅ **Define `RepositoryPort`**: Interface en `domain.ports.out` que especifica operaciones de persistencia
- ✅ **Define `RepositoryAdapter`**: Implementación del puerto en `infrastructure.adapters.out.persistence`
- ✅ **Define `Entities`**: POJOs de persistencia sin anotaciones JPA en `infrastructure.adapters.out.persistence.entity`
- ❌ **NO se integra con otro MsData**: Es un componente de datos independiente

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/gse/registradores/
├── domain/
│   ├── model/                          # Entidades de dominio y Value Objects
│   │   ├── Registrador.java           # Aggregate Root
│   │   ├── AsignacionActual.java      # Value Object
│   │   ├── Firma.java                 # Value Object
│   │   ├── Sello.java                 # Value Object
│   │   ├── Periodo.java               # Entity
│   │   ├── Auditoria.java             # Value Object
│   │   ├── Paginacion.java            # Value Object
│   │   ├── FiltroRegistrador.java     # Value Object
│   │   └── ResultadoPaginado.java     # Value Object
│   └── ports/
│       ├── in/                         # Puertos de entrada (Use Cases)
│       │   ├── CrearRegistradorUseCase.java
│       │   ├── ListarRegistradoresUseCase.java
│       │   └── ConsultarRegistradorUseCase.java
│       └── out/                        # Puertos de salida
│           └── RegistradorRepositoryPort.java
│
├── application/
│   └── service/                        # Servicios de aplicación
│       ├── CrearRegistradorService.java
│       ├── ListarRegistradoresService.java
│       └── ConsultarRegistradorService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── RegistradorController.java
        │       ├── dto/                # Records de Java (DTOs)
        │       │   ├── CrearRegistradorRequestDto.java
        │       │   ├── RegistradorResponseDto.java
        │       │   ├── ListaRegistradoresResponseDto.java
        │       │   ├── RegistradorListadoDto.java
        │       │   ├── RegistradorDetalleResponseDto.java
        │       │   ├── AsignacionActualDto.java
        │       │   ├── FirmaDto.java
        │       │   ├── SelloDto.java
        │       │   ├── PeriodoDto.java
        │       │   ├── AuditoriaDto.java
        │       │   ├── LinksDto.java
        │       │   ├── LinksDetalleDto.java
        │       │   ├── PaginacionDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── ApiResponseDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   ├── ErrorDto.java
        │       │   └── ErrorDetalleDto.java
        │       └── mapper/
        │           └── RegistradorDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/             # Entidades de persistencia (POJOs)
                │   ├── RegistradorEntity.java
                │   └── PeriodoEntity.java
                ├── mapper/
                │   └── RegistradorPersistenceMapper.java
                └── RegistradorRepositoryAdapter.java
```

---

## Endpoints

### 1. Crear Registrador

**POST** `/api/v1/registradores/MsDatosRegistradores`

Crea un nuevo registrador civil en el sistema.

#### Headers

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| Authorization | String | Sí | Bearer token JWT para autenticación |
| Content-Type | String | Sí | application/json |
| X-Correlation-ID | UUID | Sí | Identificador único de correlación para trazabilidad |
| X-Office-Code | String | Sí | Código de oficina desde donde se realiza la operación |
| X-User-Role | String | Sí | Rol del usuario (ADMINISTRADOR_REGISTRADORES) |
| X-Idempotency-Key | UUID | Sí | Clave para evitar creaciones duplicadas |

#### Request Body

```json
{
  "idRegistrador": "string",
  "numeroDni": "string",
  "primerApellido": "string",
  "segundoApellido": "string",
  "prenombres": "string",
  "codigoLocal": "string",
  "tipoRegistrador": "string",
  "observaciones": "string"
}
```

#### Response (201 Created)

```json
{
  "success": true,
  "data": {
    "idRegistrador": "string",
    "numeroDni": "string",
    "nombreCompleto": "string",
    "codigoLocal": "string",
    "descripcionLocal": "string",
    "codigoEstadoRegistrador": "string",
    "descripcionEstado": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "usuarioRegistro": "string",
    "_links": {
      "self": "string",
      "firmas": "string",
      "sellos": "string",
      "periodos": "string",
      "asignaciones": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 201 | Created - Registrador creado exitosamente |
| 400 | Bad Request - Datos inválidos o incompletos |
| 401 | Unauthorized - Token JWT inválido o expirado |
| 403 | Forbidden - Usuario sin permisos para crear registradores |
| 409 | Conflict - Ya existe un registrador con ese DNI/ID |
| 422 | Unprocessable Entity - Datos válidos pero lógica de negocio no permite procesarlos |
| 500 | Internal Server Error - Error interno del servidor |

---

### 2. Listar Registradores

**GET** `/api/v1/registradores/MsDatosRegistradores`

Lista registradores con filtros opcionales y paginación.

#### Headers

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| Authorization | String | Sí | Bearer token JWT |
| X-Correlation-ID | UUID | Sí | Identificador único de correlación |
| X-Office-Code | String | Sí | Código de oficina |
| X-User-Role | String | Sí | Rol del usuario |

#### Query Parameters

| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| codigoLocal | String | No | Código del local utilizado como filtro |
| estado | String | No | Estado aplicado como criterio de búsqueda |
| numeroDni | String | No | Número de documento utilizado como filtro |
| nombreRegistrador | String | No | Nombre del registrador asociado a la consulta |
| pagina | Integer | No | Número de página para la paginación |
| registrosPorPagina | Integer | No | Cantidad de registros por página (máximo 100) |

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "registradores": [
      {
        "idRegistrador": "string",
        "numeroDni": "string",
        "nombreCompleto": "string",
        "primerApellido": "string",
        "segundoApellido": "string",
        "prenombres": "string",
        "codigoLocal": "string",
        "descripcionLocal": "string",
        "codigoEstadoRegistrador": "string",
        "descripcionEstado": "string",
        "tieneFirmaRegistrada": "boolean",
        "tieneSellosRegistrado": "boolean",
        "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
        "_links": {
          "self": "string",
          "firmas": "string",
          "sellos": "string",
          "periodos": "string"
        }
      }
    ],
    "paginacion": {
      "totalRegistros": "integer",
      "totalPaginas": "integer",
      "paginaActual": "integer",
      "registrosPorPagina": "integer",
      "tieneAnterior": "boolean",
      "tieneSiguiente": "boolean"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 200 | OK - Lista de registradores consultada exitosamente |
| 400 | Bad Request - Parámetros de filtro inválidos |
| 401 | Unauthorized - Token JWT inválido o expirado |
| 403 | Forbidden - Usuario sin permisos para consultar |
| 500 | Internal Server Error - Error interno del servidor |

---

### 3. Consultar Registrador Específico

**GET** `/api/v1/registradores/MsDatosRegistradores/{idRegistrador}`

Obtiene la información detallada de un registrador específico.

#### Headers

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| Authorization | String | Sí | Bearer token JWT |
| X-Correlation-ID | UUID | Sí | Identificador único de correlación |
| X-Office-Code | String | Sí | Código de oficina |

#### Path Parameters

| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| idRegistrador | String | Sí | Identificador del registrador (1-8 caracteres) |

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "idRegistrador": "string",
    "numeroDni": "string",
    "primerApellido": "string",
    "segundoApellido": "string",
    "prenombres": "string",
    "nombreCompleto": "string",
    "numeroImagen": "string",
    "asignacionActual": {
      "codigoLocal": "string",
      "descripcionLocal": "string",
      "codigoEstadoRegistrador": "string",
      "descripcionEstado": "string",
      "fechaAsignacion": "YYYY-MM-DDThh:mm:ssZ"
    },
    "firma": {
      "tieneRegistrada": "boolean",
      "hashFirma": "string",
      "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ssZ"
    },
    "sello": {
      "tieneRegistrado": "boolean",
      "hashSello": "string",
      "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ssZ"
    },
    "periodos": [
      {
        "idPeriodo": "string",
        "codigoLocal": "string",
        "descripcionLocal": "string",
        "fechaInicio": "YYYY-MM-DDThh:mm:ssZ",
        "fechaFin": "YYYY-MM-DDThh:mm:ssZ",
        "estado": "string"
      }
    ],
    "auditoria": {
      "usuarioCreacion": "string",
      "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
      "usuarioModificacion": "string",
      "fechaModificacion": "YYYY-MM-DDThh:mm:ssZ"
    },
    "_links": {
      "self": "string",
      "firmas": "string",
      "sellos": "string",
      "periodos": "string",
      "asignaciones": "string",
      "historialFirmas": "string",
      "historialSellos": "string"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 200 | OK - Registrador consultado exitosamente |
| 400 | Bad Request - ID de registrador inválido |
| 401 | Unauthorized - Token JWT inválido o expirado |
| 403 | Forbidden - Usuario sin permisos para consultar |
| 404 | Not Found - Registrador no encontrado |
| 500 | Internal Server Error - Error interno del servidor |

---

## Modelo de Dominio

### Entidades

#### Registrador (Aggregate Root)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| idRegistrador | String | Identificador único del registrador (1-8 caracteres) |
| numeroDni | String | DNI del registrador (8 caracteres) |
| primerApellido | String | Primer apellido (1-128 caracteres) |
| segundoApellido | String | Segundo apellido (opcional, 1-128 caracteres) |
| prenombres | String | Nombres del registrador (1-160 caracteres) |
| nombreCompleto | String | Nombre completo concatenado |
| numeroImagen | String | Código o identificador de la imagen asociada |
| codigoLocal | String | Código de la oficina asignada (6 caracteres) |
| tipoRegistrador | String | Tipo de registrador (opcional, 2 caracteres) |
| observaciones | String | Observaciones adicionales (opcional, 0-500 caracteres) |
| codigoEstadoRegistrador | String | Código del estado actual |
| asignacionActual | AsignacionActual | Información de asignación vigente |
| firma | Firma | Información de la firma registrada |
| sello | Sello | Información del sello registrado |
| periodos | List\<Periodo\> | Lista de periodos de asignación |
| auditoria | Auditoria | Información de auditoría |

#### AsignacionActual (Value Object)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| codigoLocal | String | Código de la oficina |
| descripcionLocal | String | Nombre de la oficina |
| codigoEstadoRegistrador | String | Código del estado |
| descripcionEstado | String | Descripción del estado |
| fechaAsignacion | LocalDateTime | Fecha/hora de asignación |

#### Firma (Value Object)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| tieneRegistrada | Boolean | Indica si tiene firma registrada |
| hashFirma | String | Hash de la firma |
| fechaUltimaActualizacion | LocalDateTime | Última actualización |

#### Sello (Value Object)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| tieneRegistrado | Boolean | Indica si tiene sello registrado |
| hashSello | String | Hash del sello |
| fechaUltimaActualizacion | LocalDateTime | Última actualización |

#### Periodo (Entity)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| idPeriodo | String | Identificador del periodo |
| codigoLocal | String | Código de la oficina |
| descripcionLocal | String | Descripción de la oficina |
| fechaInicio | LocalDateTime | Fecha de inicio |
| fechaFin | LocalDateTime | Fecha de fin |
| estado | String | Estado del periodo |

#### Auditoria (Value Object)

| Campo | Tipo | Descripción |
|-------|------|-------------|
| usuarioCreacion | String | Usuario que creó el registro |
| fechaCreacion | LocalDateTime | Fecha de creación |
| usuarioModificacion | String | Usuario que modificó el registro |
| fechaModificacion | LocalDateTime | Fecha de modificación |

---

## Mapeo de Tipos

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer | Long |
| boolean | Boolean |
| datetime (YYYY-MM-DDThh:mm:ssZ) | LocalDateTime |
| array/list | List\<T\> |

---

## Casos de Uso

1. **CrearRegistradorUseCase**: Crear un nuevo registrador civil en el sistema
2. **ListarRegistradoresUseCase**: Listar registradores con filtros opcionales y paginación
3. **ConsultarRegistradorUseCase**: Obtener información detallada de un registrador específico

---

## Limitaciones y Consideraciones

### Neutralidad Tecnológica

- ✅ El código está implementado sin frameworks (Spring, JAX-RS, JPA, etc.)
- ✅ Clases e interfaces son POJOs puros de Java
- ✅ No hay anotaciones de tecnologías específicas
- ✅ Los adaptadores tienen métodos stub que lanzan `UnsupportedOperationException`

### No Implementado

- ❌ **Operaciones de Actualización**: No están documentadas en la especificación PDF
- ❌ **Operaciones de Eliminación**: No están documentadas en la especificación PDF
- ❌ **Implementación de Persistencia**: Los métodos del `RegistradorRepositoryAdapter` requieren tecnología específica (JDBC, JPA, etc.)
- ❌ **Protocolo de Conexión**: No se define cómo conectar con servicios externos

### Para Implementación Real

Para hacer funcional este microservicio se requiere:

1. **Framework Web**: Spring Boot, Quarkus, Micronaut, etc.
2. **Tecnología de Persistencia**: 
   - JDBC puro con DataSource
   - Spring Data JPA
   - MyBatis
   - jOOQ
3. **Base de Datos**: PostgreSQL, Oracle, SQL Server, etc.
4. **Seguridad**: Implementación de validación JWT
5. **Manejo de Errores**: Exception handlers y respuestas de error estandarizadas
6. **Logging**: SLF4J con Logback o Log4j2
7. **Validaciones**: Bean Validation (JSR-380)

---

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 500 | Internal Server Error - Error interno del servicio |

---

## Estructura de Respuesta de Error

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

---

## Documentos de Referencia

- **Especificación Original**: `Microservicio MsDatosRegistradores V1.0.pdf`
- **Información Extraída**: `ESPECIFICACION_EXTRAIDA.md`
- **Prompt de Generación**: `AGENT_PROMPT.md`

---

## Fecha de Generación

**Fecha:** 03 de diciembre de 2025  
**Versión del Documento:** 1.0
