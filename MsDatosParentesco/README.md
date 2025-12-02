# Microservicio MsDatosParentesco

## Resumen

**Nombre:** MsDatosParentesco  
**Tipo:** Microservicio de Datos (MsData)  
**Versión API:** v1  
**Contexto de Negocio:** Gestión de Seguridad Electrónica - RENIEC  

El Microservicio Datos Parentesco es el componente de persistencia y acceso a datos dedicado exclusivamente al dominio del análisis de parentesco. Su propósito principal es actuar como el único intermediario entre el Microservicio Dominio Parentesco (MsDominioParentesco) y la BD Análisis de Parentesco (schema GRAFO_TRANSACCION_GRF).

Se encarga de almacenar, recuperar y gestionar de forma segura los registros de los análisis y las relaciones familiares que han sido validadas por el sistema.

## Paquete Base

`pe.gob.reniec.gse.datosparentesco`

## Tipo de Microservicio: MsData

Como microservicio de datos (MsData), este componente:
- **SÍ** define `RepositoryPort` en `domain/ports/out/`
- **SÍ** define `RepositoryAdapter` en `infrastructure/adapters/out/persistence/`
- **SÍ** define `Entities` (POJOs sin anotaciones JPA)
- No utiliza tecnologías concretas (sin JPA, sin drivers, sin frameworks)
- Solo POJOs e interfaces Java puras

## Endpoints

### 1. Guardar Análisis
- **Método:** POST
- **Path:** `/api/v1/parentesco/MsDatosParentesco/analisis`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `Content-Type`: application/json
  - `X-Correlation-ID`: UUID
  - `X-User-Role`: String

**Request Body:**
```json
{
  "idSolicitud": "string",
  "idCiudadanoConsultado": "string",
  "tipoVinculo": "string",
  "nivelComplejidad": "integer",
  "criteriosBusqueda": {
    "rangoAniosPadres": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "rangoAniosHijos": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "variacionesNombre": ["string"]
  },
  "estado": "string",
  "usuarioTecnico": "string",
  "observaciones": "string"
}
```

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "estado": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string",
    "version": "string"
  }
}
```

**Status Codes:**
- 201 Created - Análisis guardado exitosamente
- 400 Bad Request - Parámetros inválidos o datos incompletos
- 401 Unauthorized - Token JWT inválido o ausente
- 409 Conflict - Ya existe un análisis activo para el ciudadano
- 500 Internal Server Error - Error interno del servidor

---

### 2. Consultar Análisis Específico
- **Método:** GET
- **Path:** `/api/v1/parentesco/MsDatosParentesco/analisis/{idAnalisis}`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `X-Correlation-ID`: UUID

**Path Parameters:**
- `idAnalisis`: String (obligatorio)

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "idSolicitud": "string",
    "idCiudadanoConsultado": "string",
    "tipoVinculo": "string",
    "nivelComplejidad": "integer",
    "criteriosBusqueda": {
      "rangoAniosPadres": {
        "anioInicio": "integer",
        "anioFin": "integer"
      },
      "variacionesNombre": ["string"]
    },
    "estado": "string",
    "resultadoAnalisis": "string",
    "usuarioTecnico": "string",
    "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "observaciones": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 200 OK - Análisis consultado exitosamente
- 401 Unauthorized - Token JWT inválido o ausente
- 404 Not Found - Análisis no encontrado
- 500 Internal Server Error - Error interno del servidor

---

### 3. Listar Análisis
- **Método:** GET
- **Path:** `/api/v1/parentesco/MsDatosParentesco/analisis`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `X-Correlation-ID`: UUID

**Query Parameters:**
- `idCiudadano`: String (opcional)
- `idSolicitud`: String (opcional)
- `estado`: String (opcional)
- `tipoVinculo`: String (opcional)
- `fechaDesde`: String (opcional, ISO 8601)
- `fechaHasta`: String (opcional, ISO 8601)
- `usuarioTecnico`: String (opcional)
- `pagina`: Integer (opcional)
- `tamanioPagina`: Integer (opcional)

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "analisis": [
      {
        "idAnalisis": "string",
        "idSolicitud": "string",
        "idCiudadanoConsultado": "string",
        "tipoVinculo": "string",
        "nivelComplejidad": "integer",
        "estado": "string",
        "usuarioTecnico": "string",
        "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
      }
    ],
    "paginacion": {
      "totalRegistros": "integer",
      "totalPaginas": "integer",
      "paginaActual": "integer",
      "tamanioPagina": "integer",
      "tieneAnterior": "boolean",
      "tieneSiguiente": "boolean"
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 200 OK - Análisis listado exitosamente
- 400 Bad Request - Filtros inválidos
- 401 Unauthorized - Token inválido
- 500 Internal Server Error - Error interno

---

### 4. Actualizar Análisis
- **Método:** PUT
- **Path:** `/api/v1/parentesco/MsDatosParentesco/analisis/{idAnalisis}`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `Content-Type`: application/json
  - `X-Correlation-ID`: UUID

**Path Parameters:**
- `idAnalisis`: String (obligatorio)

**Request Body:**
```json
{
  "estado": "string",
  "criteriosBusqueda": "object",
  "observaciones": "string",
  "resultadoAnalisis": "string"
}
```

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "idAnalisis": "string",
    "estado": "string",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 200 OK - Análisis actualizado exitosamente
- 400 Bad Request - Parámetros inválidos
- 404 Not Found - Análisis no encontrado
- 409 Conflict - Estado no permite la actualización
- 500 Internal Server Error - Error interno del servidor

---

### 5. Registrar Relación de Parentesco
- **Método:** POST
- **Path:** `/api/v1/parentesco/MsDatosParentesco/relaciones`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `Content-Type`: application/json
  - `X-Correlation-ID`: UUID

**Request Body:**
```json
{
  "idAnalisis": "string",
  "idCiudadanoOrigen": "string",
  "idCiudadanoDestino": "string",
  "codigoTipoParentesco": "string",
  "gradoParentesco": "integer",
  "idActaSustento": "string",
  "idDocumentoSustento": "string",
  "fechaInicioVigencia": "YYYY-MM-DD",
  "observacion": "string"
}
```

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "idRelacion": "integer",
    "relacionInversa": {
      "idRelacion": "integer",
      "codigoTipo": "string"
    },
    "fechaRegistro": "YYYY-MM-DDThh:mm:ss±hh:mm"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 201 Created - Relación registrada exitosamente
- 400 Bad Request - Datos inválidos
- 404 Not Found - Análisis o ciudadano no encontrado
- 409 Conflict - Relación ya existe
- 422 Unprocessable Entity - Tipo no válido
- 500 Internal Server Error - Error interno

---

### 6. Consultar Relaciones de un Ciudadano
- **Método:** GET
- **Path:** `/api/v1/parentesco/MsDatosParentesco/relaciones`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `X-Correlation-ID`: UUID

**Query Parameters:**
- `idCiudadano`: String (obligatorio)
- `tipoParentesco`: String (opcional)
- `gradoMaximo`: Integer (opcional)
- `incluirInactivos`: Boolean (opcional)

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "ciudadano": {
      "idCiudadano": "string",
      "nombre": "string"
    },
    "relaciones": [
      {
        "idRelacion": "integer",
        "tipoParentesco": "string",
        "descripcionParentesco": "string",
        "gradoParentesco": "integer",
        "ciudadanoRelacionado": {
          "idCiudadano": "string",
          "nombre": "string"
        },
        "actaSustento": "string",
        "vigente": "boolean"
      }
    ],
    "totalRelaciones": "integer"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 200 OK - Relaciones consultadas exitosamente
- 401 Unauthorized - Token JWT inválido o ausente
- 404 Not Found - Ciudadano no encontrado
- 500 Internal Server Error - Error interno del servidor

---

### 7. Listar Tipos de Parentesco
- **Método:** GET
- **Path:** `/api/v1/parentesco/MsDatosParentesco/tipos-parentesco`
- **API Gateway:** Interno
- **Headers:**
  - `Authorization`: Bearer token JWT
  - `X-Correlation-ID`: UUID

**Response Body:**
```json
{
  "success": "boolean",
  "data": {
    "tiposParentesco": [
      {
        "codigo": "string",
        "descripcion": "string",
        "tipoInverso": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string"
  }
}
```

**Status Codes:**
- 200 OK - Tipos listados exitosamente
- 401 Unauthorized - Token JWT inválido
- 500 Internal Server Error - Error interno

---

## Entidades del Dominio

### Analisis
- idAnalisis: String
- idSolicitud: String
- idCiudadanoConsultado: String
- tipoVinculo: String
- nivelComplejidad: Integer
- criteriosBusqueda: CriteriosBusqueda
- estado: String
- resultadoAnalisis: String
- usuarioTecnico: String
- fechaCreacion: LocalDateTime
- fechaModificacion: LocalDateTime
- observaciones: String

### RelacionParentesco
- idRelacion: Long
- idAnalisis: String
- idCiudadanoOrigen: String
- idCiudadanoDestino: String
- codigoTipoParentesco: String
- gradoParentesco: Integer
- idActaSustento: String
- idDocumentoSustento: String
- fechaInicioVigencia: LocalDate
- fechaRegistro: LocalDateTime
- observacion: String
- vigente: Boolean

### CriteriosBusqueda (Value Object)
- rangoAniosPadres: RangoAnios
- rangoAniosHijos: RangoAnios
- variacionesNombre: List<String>

### RangoAnios (Value Object)
- anioInicio: Integer
- anioFin: Integer

### TipoParentesco
- codigo: String
- descripcion: String
- tipoInverso: String

### Ciudadano (Value Object)
- idCiudadano: String
- nombre: String

## Mapeo de Tipos

Según las convenciones del prompt:
- string → String
- integer/int → Integer (para valores pequeños) o Long (para IDs grandes)
- boolean → Boolean
- date (YYYY-MM-DD) → LocalDate
- datetime/timestamp (YYYY-MM-DDThh:mm:ss±hh:mm) → LocalDateTime
- array/list → List<T>
- object → POJO anidado

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/gse/datosparentesco/
├── domain/
│   ├── model/
│   │   ├── Analisis.java
│   │   ├── RelacionParentesco.java
│   │   ├── CriteriosBusqueda.java
│   │   ├── RangoAnios.java
│   │   ├── TipoParentesco.java
│   │   └── Ciudadano.java
│   └── ports/
│       ├── in/
│       │   ├── CrearAnalisisUseCase.java
│       │   ├── ConsultarAnalisisUseCase.java
│       │   ├── ListarAnalisisUseCase.java
│       │   ├── ActualizarAnalisisUseCase.java
│       │   ├── RegistrarRelacionParentescoUseCase.java
│       │   ├── ConsultarRelacionesUseCase.java
│       │   └── ListarTiposParentescoUseCase.java
│       └── out/
│           ├── AnalisisRepositoryPort.java
│           ├── RelacionParentescoRepositoryPort.java
│           └── TipoParentescoRepositoryPort.java
├── application/
│   └── service/
│       ├── CrearAnalisisService.java
│       ├── ConsultarAnalisisService.java
│       ├── ListarAnalisisService.java
│       ├── ActualizarAnalisisService.java
│       ├── RegistrarRelacionParentescoService.java
│       ├── ConsultarRelacionesService.java
│       └── ListarTiposParentescoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   ├── AnalisisController.java
        │       │   ├── RelacionParentescoController.java
        │       │   └── TipoParentescoController.java
        │       ├── dto/
        │       │   ├── AnalisisRequestDto.java
        │       │   ├── AnalisisResponseDto.java
        │       │   ├── AnalisisDetalleResponseDto.java
        │       │   ├── AnalisisListaResponseDto.java
        │       │   ├── ActualizarAnalisisRequestDto.java
        │       │   ├── RelacionParentescoRequestDto.java
        │       │   ├── RelacionParentescoResponseDto.java
        │       │   ├── ConsultarRelacionesResponseDto.java
        │       │   ├── TipoParentescoResponseDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── MetadataDto.java
        │       └── mapper/
        │           ├── AnalisisDtoMapper.java
        │           ├── RelacionParentescoDtoMapper.java
        │           └── TipoParentescoDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── AnalisisEntity.java
                │   ├── RelacionParentescoEntity.java
                │   └── TipoParentescoEntity.java
                ├── mapper/
                │   ├── AnalisisPersistenceMapper.java
                │   ├── RelacionParentescoPersistenceMapper.java
                │   └── TipoParentescoPersistenceMapper.java
                ├── AnalisisRepositoryAdapter.java
                ├── RelacionParentescoRepositoryAdapter.java
                └── TipoParentescoRepositoryAdapter.java
```

## Limitaciones

- **Sin frameworks:** No se utilizan anotaciones de Spring, JAX-RS, JPA o similares
- **Sin tecnología de persistencia:** Los adaptadores de repositorio son stubs sin implementación real de base de datos
- **Java puro:** Solo interfaces, clases POJO y enums compilables como Java estándar
- **Sin protocolo de conexión:** No se define HTTP, SOAP ni colas de mensajería
- **Implementación mínima:** Los métodos lanzan `UnsupportedOperationException` o están vacíos para mantener neutralidad tecnológica

## Notas

Este microservicio fue generado siguiendo estrictamente las especificaciones del documento PDF "Microservicio MsDatosParentesco V1.0" y las reglas de Arquitectura Hexagonal definidas en el prompt del agente, sin asumir ni inferir funcionalidades no documentadas.
