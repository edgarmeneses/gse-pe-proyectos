# Especificación Extraída - MsDatosRegistradores

## Información General
- **Nombre del Microservicio**: MsDatosRegistradores
- **Tipo de Microservicio**: MsData (Microservicio de Datos)
- **Versión del API**: v1
- **Paquete Base**: pe.gob.reniec.gse.registradores
- **Contexto de Negocio**: Gestión de Seguridad Electrónica - Personalización del DNIe de RENIEC

## Descripción
El Microservicio Datos Registradores es un componente de persistencia y acceso a datos dedicado. Su propósito principal es interactuar de manera exclusiva con la Base de Datos de Registradores, actuando como el único intermediario para su administración. Se encarga de almacenar, recuperar y gestionar de forma segura toda la información operacional del registrador y sus elementos de autenticación.

## Tipo de Microservicio
**MsData**: Este es un microservicio de datos, por lo tanto:
- ✅ Define `RepositoryPort` y `RepositoryAdapter`
- ✅ Define `Entities` (POJOs sin anotaciones JPA)
- ✅ Implementa operaciones CRUD sobre la base de datos
- ❌ NO se integra con otro MsData

---

## Endpoints Identificados

### 1. Crear Registrador
- **Método**: POST
- **Path**: `/api/v1/registradores/MsDatosRegistradores`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers
- `Authorization`: Bearer token JWT para autenticación del usuario
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID (Identificador único de correlación para trazabilidad)
- `X-Office-Code`: String (Código de oficina desde donde se realiza la operación)
- `X-User-Role`: String (Rol del usuario: ADMINISTRADOR_REGISTRADORES)
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

#### Parámetros de Entrada
| Dato | Atributo | Tipo | Obligatorio | Long. Mín | Long. Máx |
|------|----------|------|-------------|-----------|-----------|
| ID Registrador | idRegistrador | String | Sí | 1 | 8 |
| Número DNI | numeroDni | String | Sí | 8 | 8 |
| Primer Apellido | primerApellido | String | Sí | 1 | 128 |
| Segundo Apellido | segundoApellido | String | No | 1 | 128 |
| Prenombres | prenombres | String | Sí | 1 | 160 |
| Código Local | codigoLocal | String | Sí | 6 | 6 |
| Tipo Registrador | tipoRegistrador | String | No | 2 | 2 |
| Observaciones | observaciones | String | No | 0 | 500 |

#### Response Body (201 Created)
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

#### Error Response
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
- **Método**: GET
- **Path**: `/api/v1/registradores/MsDatosRegistradores`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String
- `X-User-Role`: String

#### Query Parameters
| Parámetro | Tipo | Obligatorio | Long. Mín | Long. Máx |
|-----------|------|-------------|-----------|-----------|
| codigoLocal | String | No | 6 | 6 |
| estado | String | No | 2 | 2 |
| numeroDni | String | No | 8 | 8 |
| nombreRegistrador | String | No | 1 | 100 |
| pagina | Integer | No | 1 | 9999 |
| registrosPorPagina | Integer | No | 1 | 100 |

#### Response Body (200 OK)
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

#### Error Response
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

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Lista de registradores consultada exitosamente |
| 400 | Bad Request | Parámetros de filtro inválidos |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 500 | Internal Server Error | Error interno del servidor |

---

### 3. Consultar Registrador Específico
- **Método**: GET
- **Path**: `/api/v1/registradores/MsDatosRegistradores/{idRegistrador}`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers
- `Authorization`: Bearer token JWT
- `X-Correlation-ID`: UUID
- `X-Office-Code`: String

#### Path Parameters
| Parámetro | Tipo | Obligatorio | Long. Mín | Long. Máx |
|-----------|------|-------------|-----------|-----------|
| idRegistrador | String | Sí | 1 | 8 |

#### Response Body (200 OK)
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

#### Error Response
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

#### Status Codes
| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Registrador consultado exitosamente |
| 400 | Bad Request | ID de registrador inválido |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para consultar |
| 404 | Not Found | Registrador no encontrado |
| 500 | Internal Server Error | Error interno del servidor |

---

## Mapeo de Tipos de Datos

Según el prompt, los tipos se mapean de la siguiente manera:

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer | Long |
| boolean | Boolean |
| YYYY-MM-DDThh:mm:ssZ (datetime) | LocalDateTime |
| array/list | List<T> |

---

## Entidades del Dominio Identificadas

### 1. Registrador (Aggregate Root)
- idRegistrador: String
- numeroDni: String
- primerApellido: String
- segundoApellido: String
- prenombres: String
- nombreCompleto: String
- numeroImagen: String
- codigoLocal: String
- tipoRegistrador: String
- observaciones: String
- codigoEstadoRegistrador: String
- asignacionActual: AsignacionActual
- firma: Firma
- sello: Sello
- periodos: List<Periodo>
- auditoria: Auditoria

### 2. AsignacionActual (Value Object)
- codigoLocal: String
- descripcionLocal: String
- codigoEstadoRegistrador: String
- descripcionEstado: String
- fechaAsignacion: LocalDateTime

### 3. Firma (Value Object)
- tieneRegistrada: Boolean
- hashFirma: String
- fechaUltimaActualizacion: LocalDateTime

### 4. Sello (Value Object)
- tieneRegistrado: Boolean
- hashSello: String
- fechaUltimaActualizacion: LocalDateTime

### 5. Periodo (Entity)
- idPeriodo: String
- codigoLocal: String
- descripcionLocal: String
- fechaInicio: LocalDateTime
- fechaFin: LocalDateTime
- estado: String

### 6. Auditoria (Value Object)
- usuarioCreacion: String
- fechaCreacion: LocalDateTime
- usuarioModificacion: String
- fechaModificacion: LocalDateTime

### 7. Paginacion (Value Object)
- totalRegistros: Long
- totalPaginas: Long
- paginaActual: Long
- registrosPorPagina: Long
- tieneAnterior: Boolean
- tieneSiguiente: Boolean

### 8. Links (Value Object - HATEOAS)
- self: String
- firmas: String
- sellos: String
- periodos: String
- asignaciones: String
- historialFirmas: String
- historialSellos: String

---

## Casos de Uso Identificados

1. **CrearRegistradorUseCase**: Crear un nuevo registrador civil en el sistema
2. **ListarRegistradoresUseCase**: Listar registradores con filtros opcionales y paginación
3. **ConsultarRegistradorUseCase**: Obtener información detallada de un registrador específico

---

## Notas Adicionales

- El microservicio es de tipo **MsData**, por lo tanto implementará RepositoryPort y RepositoryAdapter
- No se implementarán operaciones de actualización ni eliminación ya que no están documentadas en el PDF
- Los endpoints están diseñados para ser consumidos internamente (API Gateway Interno)
- Se implementa paginación en el endpoint de listado
- Se utiliza HATEOAS con el atributo `_links` en las respuestas
- Se implementa auditoría con información de creación y modificación
- El sistema gestiona firmas y sellos de registradores con hashing
