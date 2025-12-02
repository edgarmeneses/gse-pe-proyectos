# Microservicio MsDatosRegistradores

## Resumen

**Nombre:** MsDatosRegistradores  
**Tipo:** MsData (Microservicio de Datos)  
**Contexto:** Sistema Integrado de Identificación y Registro Civil (SIIRC) - RENIEC  
**Versión API:** 1.0.0  
**Paquete Base:** `pe.gob.reniec.msdatosregistradores`

## Descripción

El Microservicio Datos Registradores es un componente de persistencia y acceso a datos dedicado. Su propósito principal es interactuar de manera exclusiva con la Base de Datos de Registradores, actuando como el único intermediario para su administración. Se encarga de almacenar, recuperar y gestionar de forma segura toda la información operacional del registrador y sus elementos de autenticación.

### Funciones Principales

- **Operaciones CRUD sobre Registradores:** Realiza las operaciones básicas sobre la información de asignación y datos personales de los registradores.
- **Almacenamiento de Elementos de Autenticación:** Persiste de forma segura las imágenes y hashes de la firma manuscrita y el sello oficial del registrador.
- **Gestión de Periodos:** Administra los rangos de fechas en que un registrador estuvo activo en una oficina específica.
- **Consulta por Trazabilidad:** Proporciona funciones de consulta para determinar la ubicación y el periodo exacto en el que un registrador específico estuvo activo.

## Arquitectura

Este microservicio sigue una **Arquitectura Hexagonal (Ports & Adapters)** estricta sin dependencias de frameworks ni tecnologías concretas.

### Tipo de Microservicio: MsData

Como microservicio de datos:
- **Define RepositoryPort y RepositoryAdapter** para acceso a base de datos
- **Define Entities** (POJOs sin anotaciones JPA)
- **NO usa frameworks** (sin Spring, JAX-RS, JPA, etc.)
- **Código Java puro** compilable sin dependencias externas

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/msdatosregistradores/
├── domain/
│   ├── model/                      # Aggregate Root y Value Objects
│   │   ├── Registrador.java
│   │   ├── AsignacionActual.java
│   │   ├── Firma.java
│   │   ├── Sello.java
│   │   ├── Periodo.java
│   │   ├── Auditoria.java
│   │   └── Paginacion.java
│   └── ports/
│       ├── in/                     # Casos de uso (interfaces)
│       │   ├── CrearRegistradorUseCase.java
│       │   ├── ConsultarRegistradorUseCase.java
│       │   └── ListarRegistradoresUseCase.java
│       └── out/                    # Puerto de salida
│           └── RegistradorRepositoryPort.java
├── application/
│   └── service/                    # Implementación de casos de uso
│       ├── CrearRegistradorService.java
│       ├── ConsultarRegistradorService.java
│       └── ListarRegistradoresService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── RegistradorController.java
        │       ├── dto/            # Records Java (request/response)
        │       │   ├── RegistradorRequestDto.java
        │       │   ├── RegistradorResponseDto.java
        │       │   ├── ListarRegistradoresResponseDto.java
        │       │   ├── RegistradorDetalleResponseDto.java
        │       │   └── ... (DTOs auxiliares)
        │       └── mapper/
        │           └── RegistradorDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── RegistradorEntity.java
                │   └── PeriodoEntity.java
                ├── mapper/
                │   └── RegistradorPersistenceMapper.java
                └── RegistradorRepositoryAdapter.java
```

## Endpoints

### 1. Crear Registrador

**Operación:** Crear  
**Método HTTP:** POST  
**Path:** `/api/v1/registradores/MsDatosRegistradores`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

#### Headers
- `Authorization`: String (Bearer token JWT para autenticación)
- `Content-Type`: String ("application/json")
- `X-Correlation-ID`: UUID (Identificador único de correlación)
- `X-Office-Code`: String (Código de oficina)
- `X-User-Role`: String (Rol: ADMINISTRADOR_REGISTRADORES)
- `X-Idempotency-Key`: UUID (Clave para evitar creaciones duplicadas)

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

#### Response Body
```json
{
  "success": true,
  "data": {
    "idRegistrador": "string",
    "numeroDni": "string",
    "nombreCompleto": "string",
    "codigoLocal": "string",
    "descripcionLocal": "string",
    "codigoEstadoRegistrador": "01",
    "descripcionEstado": "REGISTRADOR ACTIVO",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ss±hh:mm",
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
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string",
    "version": "1.0.0"
  },
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

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 201 | Created | Registrador creado exitosamente |
| 400 | Bad Request | Datos inválidos o incompletos |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para crear registradores |
| 409 | Conflict | Ya existe un registrador con ese DNI/ID |
| 422 | Unprocessable Entity | Datos válidos pero lógica de negocio no permite procesarlos |
| 500 | Internal Server Error | Error interno del servidor |

---

### 2. Listar Registradores

**Operación:** Listar  
**Método HTTP:** GET  
**Path:** `/api/v1/registradores/MsDatosRegistradores`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

#### Headers
- `Authorization`: String (Bearer token JWT)
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

#### Query Parameters
| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| codigoLocal | String | No | Código de la oficina (6 caracteres) |
| estado | String | No | Estado del registrador (2 caracteres) |
| numeroDni | String | No | DNI del registrador (8 caracteres) |
| nombreRegistrador | String | No | Nombre del registrador (máx 100 caracteres) |
| pagina | Integer | No | Número de página (1-9999) |
| registrosPorPagina | Integer | No | Registros por página (1-100) |

#### Response Body
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
        "tieneFirmaRegistrada": true,
        "tieneSellosRegistrado": true,
        "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "_links": {
          "self": "string",
          "firmas": "string",
          "sellos": "string",
          "periodos": "string"
        }
      }
    ],
    "paginacion": {
      "totalRegistros": 150,
      "totalPaginas": 8,
      "paginaActual": 1,
      "registrosPorPagina": 20,
      "tieneAnterior": false,
      "tieneSiguiente": true
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string",
    "version": "1.0.0"
  },
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

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Lista de registradores recuperada exitosamente |
| 400 | Bad Request | Parámetros de filtro inválidos |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3. Consultar Registrador Específico

**Operación:** Consultar  
**Método HTTP:** GET  
**Path:** `/api/v1/registradores/MsDatosRegistradores/{idRegistrador}`  
**API Gateway:** Interno  
**Protocolo:** REST/HTTP

#### Headers
- `Authorization`: String (Bearer token JWT)
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String

#### Path Parameters
| Parámetro | Tipo | Obligatorio | Descripción |
|-----------|------|-------------|-------------|
| idRegistrador | String | Sí | ID del registrador (1-8 caracteres) |

#### Response Body
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
      "codigoEstadoRegistrador": "01",
      "descripcionEstado": "REGISTRADOR ACTIVO",
      "fechaAsignacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
    },
    "firma": {
      "tieneRegistrada": true,
      "hashFirma": "string",
      "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
    },
    "sello": {
      "tieneRegistrado": true,
      "hashSello": "string",
      "fechaUltimaActualizacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
    },
    "periodos": [
      {
        "idPeriodo": "string",
        "codigoLocal": "string",
        "descripcionLocal": "string",
        "fechaInicio": "YYYY-MM-DD",
        "fechaFin": "YYYY-MM-DD",
        "estado": "string"
      }
    ],
    "auditoria": {
      "usuarioCreacion": "string",
      "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "usuarioModificacion": "string",
      "fechaModificacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
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
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string",
    "version": "1.0.0"
  },
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

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Registrador encontrado exitosamente |
| 400 | Bad Request | ID de registrador inválido |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 404 | Not Found | Registrador no encontrado |
| 500 | Internal Server Error | Error interno del servidor |

## Entidades del Dominio

### Registrador (Aggregate Root)
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| idRegistrador | String | Identificador único del registrador |
| numeroDni | String | DNI del registrador |
| primerApellido | String | Primer apellido |
| segundoApellido | String | Segundo apellido (opcional) |
| prenombres | String | Nombres del registrador |
| nombreCompleto | String | Nombre completo concatenado |
| numeroImagen | String | Código de imagen asociada (opcional) |
| asignacionActual | AsignacionActual | Asignación vigente |
| firma | Firma | Información de firma |
| sello | Sello | Información de sello |
| periodos | List\<Periodo\> | Lista de periodos |
| auditoria | Auditoria | Información de auditoría |

### AsignacionActual
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| codigoLocal | String | Código de oficina |
| descripcionLocal | String | Nombre de la oficina |
| codigoEstadoRegistrador | String | Código de estado (01=Activo, 02=Baja) |
| descripcionEstado | String | Descripción del estado |
| fechaAsignacion | LocalDateTime | Fecha/hora de asignación |

### Firma
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| tieneRegistrada | Boolean | Indica si tiene firma registrada |
| hashFirma | String | Hash de la firma (opcional) |
| fechaUltimaActualizacion | LocalDateTime | Última actualización (opcional) |

### Sello
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| tieneRegistrado | Boolean | Indica si tiene sello registrado |
| hashSello | String | Hash del sello (opcional) |
| fechaUltimaActualizacion | LocalDateTime | Última actualización (opcional) |

### Periodo
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| idPeriodo | String | Identificador del periodo |
| codigoLocal | String | Código de oficina |
| descripcionLocal | String | Descripción de la oficina |
| fechaInicio | LocalDate | Fecha de inicio |
| fechaFin | LocalDate | Fecha de fin |
| estado | String | Estado del periodo |

### Auditoria
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| usuarioCreacion | String | Usuario que creó el registro |
| fechaCreacion | LocalDateTime | Fecha de creación |
| usuarioModificacion | String | Usuario que modificó (opcional) |
| fechaModificacion | LocalDateTime | Fecha de modificación (opcional) |

### Paginacion
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| totalRegistros | Long | Total de registros encontrados |
| totalPaginas | Long | Total de páginas disponibles |
| paginaActual | Long | Número de página actual |
| registrosPorPagina | Long | Registros por página |
| tieneAnterior | Boolean | Indica si existe página anterior |
| tieneSiguiente | Boolean | Indica si existe página siguiente |

## Reglas de Mapeo de Tipos

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer/int | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp (ISO 8601) | LocalDateTime |
| array/list | List\<T\> |

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

## Limitaciones y Restricciones

### Tecnológicas
- **Sin Frameworks:** No se utilizan frameworks como Spring, JAX-RS, Hibernate, JPA, etc.
- **Sin Anotaciones:** Las clases son POJOs puros sin anotaciones de frameworks
- **Sin Dependencias Externas:** El código es Java puro compilable sin librerías adicionales
- **Sin Protocolo Definido:** No se especifica cómo conectar con componentes externos
- **Métodos Stub:** Los métodos de servicio lanzan `UnsupportedOperationException` como placeholder

### Arquitectónicas
- **MsData:** Como microservicio de datos, define RepositoryPort y RepositoryAdapter
- **Sin Lógica de Negocio Compleja:** Actúa como capa de acceso a datos
- **CRUD Básico:** Operaciones de creación, consulta y listado según especificación

### Funcionales
- **Solo Endpoints Documentados:** Se implementan únicamente los 3 endpoints del PDF
- **Sin Operaciones Adicionales:** No se crean operaciones de actualización o eliminación (no están en el PDF)
- **Sin Validaciones Implementadas:** Las validaciones deben agregarse en implementación futura

## Notas de Implementación

1. **Este es un proyecto base** que requiere implementación de:
   - Lógica real en servicios y adapters
   - Conexión a base de datos
   - Validaciones de negocio
   - Manejo de errores y excepciones
   - Logging y trazabilidad
   - Mappers completos entre capas

2. **Tecnologías futuras sugeridas:**
   - Framework: Spring Boot
   - Persistencia: Spring Data JPA / MyBatis
   - API REST: Spring Web
   - Base de Datos: Oracle / PostgreSQL
   - Seguridad: Spring Security + JWT
   - Documentación: OpenAPI/Swagger

3. **Patrón Hexagonal:**
   - El dominio es independiente de la infraestructura
   - Los puertos definen contratos
   - Los adapters implementan la infraestructura
   - Fácil testing y cambio de tecnologías

## Compilación

El proyecto actual contiene solo clases e interfaces Java puras, compilables con:

```bash
javac -d target/classes -sourcepath src/main/java src/main/java/**/*.java
```

No requiere herramientas de build como Maven o Gradle en su estado actual.

## Autor

**Proyecto generado automáticamente** siguiendo especificación del PDF "Microservicio MsDatosRegistradores.pdf" v1.0  
**Organización:** RENIEC (Registro Nacional de Identificación y Estado Civil)  
**Sistema:** SIIRC (Sistema Integrado de Identificación y Registro Civil)
