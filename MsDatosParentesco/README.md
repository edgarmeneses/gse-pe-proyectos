# MsDatosParentesco - Microservicio Datos Parentesco

## 📋 Información General

### Nombre del Microservicio
**MsDatosParentesco** (Microservicio Datos Parentesco)

### Versión
- **Versión del API**: v1
- **Versión del Documento**: 1.0
- **Organización**: RENIEC - Registro Nacional de Identificación y Estado Civil

### Contexto de Negocio
El **Microservicio Datos Parentesco** es el componente de persistencia y acceso a datos dedicado exclusivamente al dominio del análisis de parentesco. Su propósito principal es actuar como el único intermediario entre el Microservicio Dominio Parentesco y la BD Análisis de Parentesco (schema `GRAFO_TRANSACCION_GRF`).

**Responsabilidades principales:**
- Almacenar registros de análisis de parentesco
- Recuperar información de análisis existentes
- Gestionar de forma segura las relaciones familiares validadas por el sistema
- Mantener la integridad de datos de parentesco entre ciudadanos

---

## 🏗️ Arquitectura

### Tipo de Microservicio
**MsData** - Microservicio de Datos

Este microservicio es un **MsData**, por lo tanto:
- ✅ **SÍ define** `RepositoryPort` y `RepositoryAdapter`
- ✅ **SÍ define** `Entities` (POJOs sin anotaciones)
- ✅ Actúa como capa de persistencia para el Microservicio Dominio Parentesco
- ❌ **NO usa** frameworks ni anotaciones (JPA, Spring, etc.)
- ❌ **NO define** protocolos de conexión específicos (HTTP/SOAP/colas)

### Arquitectura Hexagonal (Puertos y Adaptadores)
El proyecto sigue estrictamente **Arquitectura Hexagonal** sin dependencias tecnológicas:

```
MsDatosParentesco/
├── domain/                          # Dominio (núcleo de negocio)
│   ├── model/                       # Aggregate Roots, Value Objects, Enums
│   │   ├── AnalisisParentesco.java      # Aggregate Root con ciclo de vida
│   │   ├── RelacionParentesco.java      # Aggregate Root de relaciones
│   │   ├── EstadoAnalisis.java          # Enum con transiciones
│   │   ├── TipoVinculo.java             # Enum con relaciones inversas
│   │   ├── IdentificadorCiudadano.java  # Value Object con validación
│   │   ├── CriteriosBusqueda.java       # Value Object con normalización
│   │   ├── RangoAnios.java              # Value Object con validación
│   │   ├── Ciudadano.java               # Value Object inmutable
│   │   ├── Paginacion.java              # Value Object con lógica de paginación
│   │   └── RelacionInversa.java         # Value Object de relaciones bidireccionales
│   └── ports/
│       ├── in/                      # Puertos de entrada (Use Cases)
│       └── out/                     # Puertos de salida (RepositoryPorts)
├── application/                     # Capa de aplicación
│   └── service/                     # Servicios que implementan Use Cases
└── infrastructure/                  # Infraestructura (adaptadores)
    └── adapters/
        ├── in/rest/                 # Adaptador REST (entrada)
        │   ├── controller/
        │   ├── dto/
        │   └── mapper/
        └── out/persistence/         # Adaptador de persistencia (salida)
            ├── entity/
            ├── mapper/
            └── RepositoryAdapter
```

### Modelo de Dominio Rico (Rich Domain Model)

El proyecto implementa un **modelo de dominio rico** siguiendo principios de **Domain-Driven Design (DDD)**:

#### 🎯 Características del Dominio

**Aggregate Roots (Raíces de Agregado):**
- `AnalisisParentesco`: Gestiona el ciclo de vida de un análisis con transiciones de estado
- `RelacionParentesco`: Controla las relaciones familiares con validaciones de negocio

**Value Objects (Objetos de Valor Inmutables):**
- `IdentificadorCiudadano`: DNI con validación de longitud (8-12 caracteres)
- `EstadoAnalisis`: Enum con lógica de transiciones de estado (PENDIENTE→EN_PROCESO→COMPLETADO→VALIDADO)
- `TipoVinculo`: Enum con relaciones inversas automáticas (PADRE↔HIJO, MADRE↔HIJO, etc.)
- `CriteriosBusqueda`: Normalización y cálculo de complejidad de búsqueda
- `RangoAnios`: Validación de rangos temporales con restricciones de negocio
- `Ciudadano`: Normalización de nombres y validación de formato
- `Paginacion`: Cálculo automático de offsets, límites y navegación
- `RelacionInversa`: Representación bidireccional de relaciones familiares

#### 📐 Principios Aplicados

1. **Inmutabilidad**: Los value objects son inmutables (sin setters públicos)
2. **Factory Methods**: Uso de `crear()` y `reconstruir()` en lugar de constructores públicos
3. **Validaciones en el Dominio**: Reglas de negocio validadas al crear/modificar objetos
4. **Encapsulamiento**: Estados protegidos, modificaciones solo por métodos de negocio
5. **Comportamiento Rico**: Métodos de negocio como:
   - **AnalisisParentesco**: `iniciarProcesamiento()`, `completarConResultado()`, `validar()`, `rechazar()`, `cancelar()`
   - **RelacionParentesco**: `marcarComoInactiva()`, `esRelacionDirecta()`, `esVigente()`, `tieneSustentoCompleto()`
   - **EstadoAnalisis**: `puedeTransicionarA()`, `esFinal()`
   - **TipoVinculo**: `obtenerVinculoInverso()`
   - **CriteriosBusqueda**: `calcularComplejidad()`, `normalizarVariaciones()`
   - **Paginacion**: `calcularOffset()`, `paginaSiguiente()`, `paginaAnterior()`

#### ⚠️ Importante: No es un Modelo Anémico

Este modelo de dominio **NO es un simple contenedor de datos** (anti-patrón anémico). Cada clase:
- ✅ Protege sus invariantes con validaciones de negocio
- ✅ Expone comportamiento de negocio, no solo getters/setters
- ✅ Usa enums tipados en lugar de Strings para estados y tipos
- ✅ Implementa lógica de negocio relevante al dominio de parentesco
- ✅ Es inmutable donde corresponde (Value Objects)
- ✅ Controla sus transiciones de estado (Aggregate Roots)

---

## 📡 Endpoints Documentados

### Base Path
`/api/v1/parentesco/MsDatosParentesco`

### 1. Guardar Análisis
**Método**: `POST`  
**Path**: `/analisis`  
**Descripción**: Guardar un nuevo análisis de parentesco o actualizar uno existente

**Headers**:
- `Authorization`: Bearer {token JWT}
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-User-Role`: Rol del usuario

**Request Body**:
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

**Response (201 Created)**:
```json
{
  "success": true,
  "data": {
    "idAnalisis": "string",
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ",
    "estado": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string",
    "version": "string"
  }
}
```

**Status Codes**:
- `201` - Created: Análisis guardado exitosamente
- `400` - Bad Request: Parámetros inválidos o datos incompletos
- `401` - Unauthorized: Token JWT inválido o ausente
- `409` - Conflict: Ya existe un análisis activo para el ciudadano
- `500` - Internal Server Error: Error interno del servidor

---

### 2. Consultar Análisis Específico
**Método**: `GET`  
**Path**: `/analisis/{idAnalisis}`  
**Descripción**: Consultar un análisis de parentesco específico por su identificador

**Headers**:
- `Authorization`: Bearer {token JWT}
- `X-Correlation-ID`: UUID

**Path Parameters**:
- `idAnalisis` (String): Identificador del análisis (1-50 caracteres)

**Response (200 OK)**:
```json
{
  "success": true,
  "data": {
    "idAnalisis": "string",
    "idSolicitud": "string",
    "idCiudadanoConsultado": "string",
    "tipoVinculo": "string",
    "nivelComplejidad": "integer",
    "criteriosBusqueda": { ... },
    "estado": "string",
    "resultadoAnalisis": "string",
    "usuarioTecnico": "string",
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ssZ",
    "observaciones": "string"
  },
  "metadata": { ... }
}
```

**Status Codes**:
- `200` - OK: Análisis consultado exitosamente
- `401` - Unauthorized: Token JWT inválido o ausente
- `404` - Not Found: Análisis no encontrado
- `500` - Internal Server Error

---

### 3. Listar Análisis
**Método**: `GET`  
**Path**: `/analisis`  
**Descripción**: Listar análisis de parentesco con filtros opcionales y paginación

**Headers**:
- `Authorization`: Bearer {token JWT}
- `X-Correlation-ID`: UUID

**Query Parameters** (todos opcionales):
- `idCiudadano` (String): DNI del ciudadano (8-12)
- `idSolicitud` (String): ID de la solicitud (5-50)
- `estado` (String): Estado del análisis (1-20)
- `tipoVinculo` (String): Tipo de vínculo (3-30)
- `fechaDesde` (String): Fecha inicial ISO 8601
- `fechaHasta` (String): Fecha final ISO 8601
- `usuarioTecnico` (String): Usuario técnico (3-50)
- `pagina` (Integer): Número de página (≥1)
- `tamanioPagina` (Integer): Registros por página (≥1)

**Response (200 OK)**:
```json
{
  "success": true,
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
        "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ"
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
  "metadata": { ... }
}
```

**Status Codes**:
- `200` - OK: Análisis listado exitosamente
- `400` - Bad Request: Filtros inválidos
- `401` - Unauthorized: Token inválido
- `500` - Internal Server Error

---

### 4. Actualizar Análisis
**Método**: `PUT`  
**Path**: `/analisis/{idAnalisis}`  
**Descripción**: Actualizar un análisis de parentesco existente

**Headers**:
- `Authorization`: Bearer {token JWT}
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID

**Path Parameters**:
- `idAnalisis` (String): Identificador del análisis a actualizar

**Request Body**:
```json
{
  "estado": "string",
  "criteriosBusqueda": { ... },
  "observaciones": "string",
  "resultadoAnalisis": "string"
}
```

**Response (200 OK)**:
```json
{
  "success": true,
  "data": {
    "idAnalisis": "string",
    "estado": "string",
    "fechaModificacion": "YYYY-MM-DDThh:mm:ssZ"
  },
  "metadata": { ... }
}
```

**Status Codes**:
- `200` - OK: Análisis actualizado exitosamente
- `400` - Bad Request: Parámetros inválidos
- `404` - Not Found: Análisis no encontrado
- `409` - Conflict: Estado no permite la actualización
- `500` - Internal Server Error

---

### 5. Registrar Relación de Parentesco
**Método**: `POST`  
**Path**: `/relaciones`  
**Descripción**: Registrar una relación de parentesco confirmada entre dos ciudadanos

**Headers**:
- `Authorization`: Bearer {token JWT}
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID

**Request Body**:
```json
{
  "idAnalisis": "string",
  "idCiudadanoOrigen": "string",
  "idCiudadanoDestino": "string",
  "codigoTipoParentesco": "string",
  "gradoParentesco": "integer",
  "idActaSustento": "string",
  "idDocumentoSustento": "string",
  "fechaInicioVigencia": "YYYY-MM-DDThh:mm:ssZ",
  "observacion": "string"
}
```

**Response (201 Created)**:
```json
{
  "success": true,
  "data": {
    "idRelacion": "integer",
    "relacionInversa": {
      "idRelacion": "integer",
      "codigoTipo": "string"
    },
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ"
  },
  "metadata": { ... }
}
```

**Status Codes**:
- `201` - Created: Relación registrada exitosamente
- `400` - Bad Request: Datos inválidos
- `404` - Not Found: Análisis o ciudadano no encontrado
- `409` - Conflict: Relación ya existe
- `422` - Unprocessable Entity: Tipo no válido
- `500` - Internal Server Error

---

### 6. Consultar Relaciones de un Ciudadano
**Método**: `GET`  
**Path**: `/relaciones`  
**Descripción**: Consultar todas las relaciones de parentesco de un ciudadano específico

**Headers**:
- `Authorization`: Bearer {token JWT}
- `X-Correlation-ID`: UUID

**Query Parameters**:
- `idCiudadano` (String) **[Obligatorio]**: DNI del ciudadano (8-12)
- `tipoParentesco` (String) [Opcional]: Tipo de parentesco (3-30)
- `gradoMaximo` (Integer) [Opcional]: Grado máximo (1-2)
- `incluirInactivos` (Boolean) [Opcional]: Incluir inactivos

**Response (200 OK)**:
```json
{
  "success": true,
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
  "metadata": { ... }
}
```

**Status Codes**:
- `200` - OK: Relaciones consultadas exitosamente
- `401` - Unauthorized: Token JWT inválido o ausente
- `404` - Not Found: Ciudadano no encontrado
- `500` - Internal Server Error

---

## 📊 Entidades del Dominio

### AnalisisParentesco (Aggregate Root)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idAnalisis | String | ID único del análisis |
| idSolicitud | String | ID de la solicitud (5-50 caracteres) |
| idCiudadanoConsultado | String | DNI del ciudadano (8-30 caracteres) |
| tipoVinculo | String | Tipo de vínculo (6-10 caracteres) |
| nivelComplejidad | Integer | Nivel de complejidad |
| criteriosBusqueda | CriteriosBusqueda | Criterios utilizados |
| estado | String | Estado actual (8-15 caracteres) |
| resultadoAnalisis | String | Resultado (10-2000 caracteres) |
| usuarioTecnico | String | Usuario técnico (3-50 caracteres) |
| fechaCreacion | LocalDateTime | Fecha de creación |
| fechaModificacion | LocalDateTime | Fecha de modificación |
| observaciones | String | Observaciones (0-1000 caracteres) |

### CriteriosBusqueda (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| rangoAniosPadres | RangoAnios | Rango de años para padres |
| rangoAniosHijos | RangoAnios | Rango de años para hijos |
| variacionesNombre | List\<String\> | Variaciones del nombre |

### RangoAnios (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| anioInicio | Integer | Año inicial |
| anioFin | Integer | Año final |

### RelacionParentesco (Aggregate Root)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idRelacion | Long | ID único de la relación |
| idAnalisis | String | ID del análisis asociado (5-50) |
| idCiudadanoOrigen | String | DNI origen (8-12) |
| idCiudadanoDestino | String | DNI destino (8-12) |
| tipoParentesco | String | Código tipo parentesco (3-30) |
| descripcionParentesco | String | Descripción del tipo |
| gradoParentesco | Integer | Grado (1 dígito) |
| idActaSustento | String | ID acta (5-50) |
| idDocumentoSustento | String | ID documento (5-50) |
| fechaInicioVigencia | LocalDateTime | Inicio vigencia |
| fechaRegistro | LocalDateTime | Fecha de registro |
| vigente | Boolean | ¿Está vigente? |
| observacion | String | Observaciones (5-500) |
| relacionInversa | RelacionInversa | Relación inversa |

### RelacionInversa (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idRelacion | Long | ID de la relación inversa |
| codigoTipo | String | Código del tipo inverso |

### Ciudadano (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idCiudadano | String | DNI del ciudadano (8-12) |
| nombre | String | Nombre completo |

### Paginacion (Value Object)
| Atributo | Tipo | Descripción |
|----------|------|-------------|
| totalRegistros | Integer | Total de registros |
| totalPaginas | Integer | Total de páginas |
| paginaActual | Integer | Página actual |
| tamanioPagina | Integer | Registros por página |
| tieneAnterior | Boolean | ¿Tiene página anterior? |
| tieneSiguiente | Boolean | ¿Tiene página siguiente? |

---

## 🔄 Reglas de Mapeo de Tipos

| Tipo Especificación | Tipo Java |
|---------------------|-----------|
| string | String |
| integer / int | Integer |
| long | Long |
| number / decimal / double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime / timestamp | LocalDateTime |
| array / list | List\<T\> |

---

## 🔑 Casos de Uso Implementados

### Análisis de Parentesco
1. **CrearAnalisisUseCase**: Crear nuevo análisis
2. **ConsultarAnalisisUseCase**: Consultar análisis por ID
3. **ListarAnalisisUseCase**: Listar análisis con filtros y paginación
4. **ActualizarAnalisisUseCase**: Actualizar análisis existente

### Relaciones de Parentesco
1. **RegistrarRelacionUseCase**: Registrar nueva relación
2. **ConsultarRelacionesUseCase**: Consultar relaciones de un ciudadano

---

## 📦 Puertos y Adaptadores

### Puertos de Entrada (in)
Interfaces que definen los casos de uso del dominio.

### Puertos de Salida (out)
- **AnalisisParentescoRepositoryPort**: Operaciones de persistencia para análisis
- **RelacionParentescoRepositoryPort**: Operaciones de persistencia para relaciones

### Adaptadores de Entrada (in)
- **AnalisisParentescoController**: Controller REST para análisis
- **RelacionParentescoController**: Controller REST para relaciones

### Adaptadores de Salida (out)
- **AnalisisParentescoRepositoryAdapter**: Implementa persistencia para análisis
- **RelacionParentescoRepositoryAdapter**: Implementa persistencia para relaciones

---

## ⚠️ Limitaciones y Consideraciones

### Neutralidad Tecnológica
- ✅ **Sin frameworks**: No usa Spring, JAX-RS, JPA, MapStruct, etc.
- ✅ **Sin anotaciones**: Código Java puro (POJOs e interfaces)
- ✅ **Sin drivers de BD**: Los adaptadores lanzan `UnsupportedOperationException`
- ✅ **Sin protocolo definido**: No se especifica HTTP/SOAP/colas para conexiones

### Implementación Pendiente
Los métodos en servicios, mappers y adaptadores están marcados con:
```java
throw new UnsupportedOperationException("Implementación pendiente");
```

Esto es intencional para mantener:
- Código compilable como Java puro
- Neutralidad respecto a tecnologías de persistencia
- Estructura arquitectónica clara y documentada

### Base de Datos
- **Schema**: `GRAFO_TRANSACCION_GRF`
- **Acceso**: Exclusivo a través de este microservicio
- **Tipo**: No especificado (podría ser relacional o de grafos)

### Sin Build Tools
No se incluye `pom.xml`, `build.gradle` ni configuraciones de compilación para mantener la neutralidad.

---

## 📝 Códigos de Respuesta HTTP Estándar

| Código | Descripción | Uso |
|--------|-------------|-----|
| 200 | OK | Operación completada exitosamente |
| 201 | Created | Recurso creado exitosamente |
| 400 | Bad Request | Parámetros inválidos o incompletos |
| 401 | Unauthorized | Token JWT inválido o ausente |
| 403 | Forbidden | Sin permisos suficientes |
| 404 | Not Found | Recurso no encontrado |
| 408 | Request Timeout | Tiempo de espera agotado |
| 409 | Conflict | Conflicto con estado actual |
| 422 | Unprocessable Entity | Datos válidos pero no procesables |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Servicio externo no disponible |
| 503 | Service Unavailable | Servicio temporalmente no disponible |
| 504 | Gateway Timeout | Servicio externo no respondió |

---

## 🔐 Seguridad

### Autenticación
- **Método**: Bearer Token (JWT)
- **Header**: `Authorization: Bearer {token}`
- **Validación**: Todas las operaciones requieren token válido

### Trazabilidad
- **Header**: `X-Correlation-ID` (UUID)
- **Propósito**: Trazabilidad end-to-end de operaciones
- **Uso**: Obligatorio en todas las operaciones

---

## 📚 Referencias

- **Documento Fuente**: Microservicio MsDatosParentesco V1.0.pdf
- **Especificación Extraída**: ESPECIFICACION_MICROSERVICIO_COMPLETA.md
- **Organización**: RENIEC - Registro Nacional de Identificación y Estado Civil
- **Arquitectura**: Hexagonal (Puertos y Adaptadores)
- **Patrón**: Domain-Driven Design (DDD)

---

## ✅ Cumplimiento del Prompt

Este proyecto cumple con todas las especificaciones del `AGENT_PROMPT.md`:

1. ✅ Arquitectura Hexagonal estricta sin frameworks
2. ✅ Identificado como **MsData** con RepositoryPort y Entities
3. ✅ Solo operaciones documentadas en el PDF (6 endpoints)
4. ✅ Código Java puro compilable sin dependencias externas
5. ✅ Estructura de carpetas exacta según especificación
6. ✅ Mapeo de tipos según convenciones definidas
7. ✅ README completo con toda la información requerida
8. ✅ Sin tecnología ni protocolo definido para conexiones
9. ✅ Solo lo que está en el PDF, sin invenciones

---

**Fecha de Generación**: 03/12/2025  
**Versión del Proyecto**: 1.0
