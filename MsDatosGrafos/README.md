# Microservicio MsDatosGrafos

## Resumen del Microservicio

**Nombre:** MsDatosGrafos  
**Tipo:** MsData (Microservicio de Datos)  
**Contexto de Negocio:** Componente de persistencia especializada dentro de la plataforma SIIRC del RENIEC. Su propósito es interactuar con la Base de Datos de Grafos optimizada para análisis de conectividad y parentesco entre ciudadanos.  
**Paquete Base:** `pe.gob.reniec.siirc.msdatosgrafos`  
**Versión API:** v1  
**API Gateway:** Interno  

## Descripción

El Microservicio Datos Grafos actúa como la capa de abstracción de datos para todos los servicios del SIIRC que requieran análisis complejos de conectividad y parentesco. Almacena y consulta datos estructurados como nodos (entidades) y aristas (relaciones).

## Endpoints

### 1. Consultar Vínculos de Parentesco

**Método:** GET  
**Path:** `/api/v1/APD/MsDatosGrafos/vinculos-parentesco`  
**Protocolo:** REST/HTTP  

#### Headers
- `Authorization`: Bearer token JWT para autenticación del usuario
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID (Identificador único de correlación para trazabilidad end-to-end)
- `X-User-Role`: Rol del usuario que realiza la operación

#### Parámetros de Consulta (Query Parameters)

| Parámetro | Tipo | Obligatorio | Longitud Min | Longitud Max | Descripción |
|-----------|------|-------------|--------------|--------------|-------------|
| idCiudadano | String | Sí | 8 | 20 | Identificador del ciudadano utilizado como filtro |
| gradoMaximo | Integer | No | 1 | 10 | Grado máximo aplicado al criterio de búsqueda |
| categoriaParentesco | String | No | 3 | 20 | Categoría de parentesco utilizada como filtro |
| soloVigentes | Boolean | No | - | - | Indica si solo deben considerarse registros vigentes |
| pagina | Integer | No | 1 | 9999 | Número de página para la paginación |
| registrosPorPagina | Integer | No | 1 | 100 | Cantidad de registros por página |

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "ciudadanoConsultado": {
      "idCiudadano": "string",
      "nombre": "string",
      "fechaNacimiento": "YYYY-MM-DDThh:mm:ssZ"
    },
    "vinculos": [
      {
        "idRelacion": 0,
        "tipoParentesco": {
          "codigo": "string",
          "descripcion": "string",
          "esSimetrico": false
        },
        "gradoParentesco": 0,
        "categoriaParentesco": "string",
        "ciudadanoRelacionado": {
          "idCiudadano": "string",
          "nombre": "string",
          "fechaNacimiento": "YYYY-MM-DDThh:mm:ssZ"
        },
        "vigencia": {
          "fechaInicio": "YYYY-MM-DDThh:mm:ssZ",
          "fechaFin": "YYYY-MM-DDThh:mm:ssZ",
          "esVigente": false
        },
        "sustento": {
          "idActaSustento": "string",
          "idDocumentoSustento": "string"
        },
        "observacion": "string"
      }
    ],
    "resumen": {
      "totalVinculos": 0,
      "vinculosConsanguineos": 0,
      "vinculosPorAfinidad": 0,
      "vinculosVigentes": 0,
      "vinculosNoVigentes": 0
    },
    "paginacion": {
      "paginaActual": 0,
      "registrosPorPagina": 0,
      "totalRegistros": 0,
      "totalPaginas": 0,
      "tieneAnterior": false,
      "tieneSiguiente": false
    }
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string",
    "tiempoRespuesta": "string"
  }
}
```

#### Error Response

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": 0,
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 200 | OK - Vínculos de parentesco consultados exitosamente |
| 400 | Bad Request - Parámetros de consulta inválidos o formato incorrecto |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Usuario sin permisos para consultar vínculos de parentesco |
| 404 | Not Found - Ciudadano no encontrado en el sistema |
| 422 | Unprocessable Entity - ID de ciudadano válido pero sin registros de parentesco |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servidor |
| 503 | Service Unavailable - Servicio de base de datos temporalmente no disponible |

## Entidades del Dominio

### VinculoParentesco
Aggregate root que representa una relación de parentesco entre dos ciudadanos.

**Atributos:**
- `idRelacion`: Long
- `tipoParentesco`: TipoParentesco
- `gradoParentesco`: Integer
- `categoriaParentesco`: String
- `ciudadanoRelacionado`: Ciudadano
- `vigencia`: Vigencia
- `sustento`: Sustento
- `observacion`: String

### Ciudadano
Representa los datos básicos de un ciudadano en el sistema.

**Atributos:**
- `idCiudadano`: String
- `nombre`: String
- `fechaNacimiento`: LocalDateTime

### TipoParentesco
Categoriza el tipo de relación de parentesco.

**Atributos:**
- `codigo`: String
- `descripcion`: String
- `esSimetrico`: Boolean

### Vigencia
Controla el período de validez de una relación de parentesco.

**Atributos:**
- `fechaInicio`: LocalDateTime
- `fechaFin`: LocalDateTime
- `esVigente`: Boolean

### Sustento
Documentos que respaldan la relación de parentesco.

**Atributos:**
- `idActaSustento`: String
- `idDocumentoSustento`: String

### ResumenVinculos
Información estadística agregada de vínculos.

**Atributos:**
- `totalVinculos`: Integer
- `vinculosConsanguineos`: Integer
- `vinculosPorAfinidad`: Integer
- `vinculosVigentes`: Integer
- `vinculosNoVigentes`: Integer

### Paginacion
Información de paginación para respuestas con múltiples registros.

**Atributos:**
- `paginaActual`: Integer
- `registrosPorPagina`: Integer
- `totalRegistros`: Integer
- `totalPaginas`: Integer
- `tieneAnterior`: Boolean
- `tieneSiguiente`: Boolean

## Mapeo de Tipos

| Tipo del PDF | Tipo Java |
|--------------|-----------|
| string | String |
| integer | Integer (contadores) / Long (IDs) |
| boolean | Boolean |
| YYYY-MM-DDThh:mm:ssZ | LocalDateTime |
| array | List<T> |
| object | Clase POJO |

## Arquitectura

### Tipo de Microservicio: MsData

Como microservicio de tipo **MsData**, este componente:

- **Define RepositoryPort**: Interface que abstrae las operaciones de persistencia hacia la base de datos de grafos.
- **Define RepositoryAdapter**: Implementación del RepositoryPort sin anotaciones ni frameworks.
- **Define Entities**: POJOs que representan la estructura de persistencia.
- **NO asume tecnología específica**: No utiliza JPA, drivers específicos ni anotaciones de frameworks.

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/siirc/msdatosgrafos/
├── domain/
│   ├── model/
│   │   ├── VinculoParentesco.java
│   │   ├── Ciudadano.java
│   │   ├── TipoParentesco.java
│   │   ├── Vigencia.java
│   │   ├── Sustento.java
│   │   ├── ResumenVinculos.java
│   │   └── Paginacion.java
│   └── ports/
│       ├── in/
│       │   └── ConsultarVinculosParentescoUseCase.java
│       └── out/
│           └── VinculoParentescoRepositoryPort.java
├── application/
│   └── service/
│       └── ConsultarVinculosParentescoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── VinculoParentescoController.java
        │       ├── dto/
        │       │   ├── VinculoParentescoRequestDto.java
        │       │   ├── VinculoParentescoResponseDto.java
        │       │   ├── CiudadanoDto.java
        │       │   ├── TipoParentescoDto.java
        │       │   ├── VigenciaDto.java
        │       │   ├── SustentoDto.java
        │       │   ├── VinculoDto.java
        │       │   ├── ResumenVinculosDto.java
        │       │   ├── PaginacionDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorDto.java
        │       └── mapper/
        │           └── VinculoParentescoDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── VinculoParentescoEntity.java
                │   ├── CiudadanoEntity.java
                │   ├── TipoParentescoEntity.java
                │   ├── VigenciaEntity.java
                │   └── SustentoEntity.java
                ├── mapper/
                │   └── VinculoParentescoPersistenceMapper.java
                └── VinculoParentescoRepositoryAdapter.java
```

## Limitaciones

- **Sin Frameworks**: No se utilizan Spring, JAX-RS, JPA ni ningún framework. Solo Java puro.
- **Sin Anotaciones**: Código libre de anotaciones de tecnologías específicas.
- **Sin Protocolo Definido**: No se define cómo se implementan las conexiones a la base de datos (sin drivers específicos).
- **Código Compilable**: Todo el código es Java puro y compilable sin dependencias externas.
- **Puertos y Adaptadores**: Se definen interfaces (puertos) y clases de implementación (adaptadores) con cuerpos mínimos o que lanzan `UnsupportedOperationException`.

## Operaciones Generadas

Este proyecto genera **únicamente** la operación documentada en el PDF:

1. **Consultar Vínculos de Parentesco** - Mapeo de GET endpoint a use case de consulta

No se generan operaciones adicionales (crear, actualizar, eliminar) porque no están especificadas en el documento.

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

## Versión del Documento

**Versión:** 1.0  
**Fecha de Generación:** 01/12/2025  
**Arquitecto de Software:** Versión inicial del documento
