# Microservicio MsDatosGrafos

## Resumen del Microservicio

**Nombre:** MsDatosGrafos  
**Tipo:** MsData (Microservicio de Datos)  
**Versión API:** v1.0  
**Contexto de Negocio:** Gestión de Seguridad Electrónica - RENIEC  
**Paquete Base:** `pe.gob.reniec.siirc.msdatosgrafos`

### Descripción

El Microservicio MsDatosGrafos es un componente de persistencia especializada dentro de la plataforma SIIRC (Sistema Integral de Identificación y Registro Civil). Su propósito principal es interactuar exclusivamente con la **Base de Datos de Grafos**, la cual está optimizada para el almacenamiento y la consulta de datos estructurados como nodos (entidades) y aristas (relaciones).

Este microservicio actúa como la capa de abstracción de datos para todos los servicios del SIIRC que requieran análisis complejos de conectividad y parentesco.

---

## Arquitectura

### Tipo de Microservicio: MsData

Como microservicio de tipo **MsData**, este componente:

- **SÍ define** `RepositoryPort` y su correspondiente `RepositoryAdapter`
- **SÍ define** entidades de persistencia (`Entity`)
- Es responsable del acceso directo a la base de datos de grafos
- Proporciona una capa de abstracción para consultas de relaciones de parentesco

### Estructura del Proyecto

El proyecto sigue **Arquitectura Hexagonal estricta** con la siguiente estructura:

```
src/main/java/pe/gob/reniec/siirc/msdatosgrafos/
│
├── domain/                                    # Capa de Dominio
│   ├── model/                                 # Entidades y Value Objects del dominio
│   │   ├── VinculoParentesco.java            # Aggregate Root
│   │   ├── TipoParentesco.java               # Value Object
│   │   ├── Ciudadano.java                    # Entity
│   │   ├── Vigencia.java                     # Value Object
│   │   ├── Sustento.java                     # Value Object
│   │   ├── Resumen.java                      # Value Object
│   │   ├── Paginacion.java                   # Value Object
│   │   └── ConsultaVinculosResult.java       # Value Object (resultado completo)
│   │
│   └── ports/                                 # Puertos (interfaces)
│       ├── in/                                # Puertos de entrada (Use Cases)
│       │   └── ConsultarVinculosParentescoUseCase.java
│       │
│       └── out/                               # Puertos de salida
│           └── VinculoParentescoRepositoryPort.java
│
├── application/                               # Capa de Aplicación
│   └── service/                               # Servicios de aplicación
│       └── ConsultarVinculosParentescoService.java
│
└── infrastructure/                            # Capa de Infraestructura
    └── adapters/                              # Adaptadores
        ├── in/                                # Adaptadores de entrada
        │   └── rest/                          # Adaptador REST
        │       ├── controller/
        │       │   └── VinculoParentescoController.java
        │       ├── dto/                       # DTOs de request/response
        │       │   ├── ConsultaVinculosResponseDto.java
        │       │   ├── DataResponseDto.java
        │       │   ├── MetadataResponseDto.java
        │       │   ├── CiudadanoResponseDto.java
        │       │   ├── VinculoParentescoResponseDto.java
        │       │   ├── TipoParentescoResponseDto.java
        │       │   ├── VigenciaResponseDto.java
        │       │   ├── SustentoResponseDto.java
        │       │   ├── ResumenResponseDto.java
        │       │   ├── PaginacionResponseDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── DetalleErrorDto.java
        │       │
        │       └── mapper/
        │           └── VinculoParentescoDtoMapper.java
        │
        └── out/                               # Adaptadores de salida
            └── persistence/                   # Adaptador de persistencia
                ├── entity/                    # Entidades de persistencia
                │   ├── VinculoParentescoEntity.java
                │   ├── TipoParentescoEntity.java
                │   ├── CiudadanoEntity.java
                │   ├── VigenciaEntity.java
                │   └── SustentoEntity.java
                │
                ├── mapper/
                │   └── VinculoParentescoPersistenceMapper.java
                │
                └── VinculoParentescoRepositoryAdapter.java
```

---

## Endpoints

### 1. Consultar Vínculos de Parentesco

Endpoint que permite consultar los vínculos de parentesco directos de un ciudadano específico, con soporte para filtrado por tipo de parentesco, grado y vigencia.

#### Información del Endpoint

| Atributo | Valor |
|----------|-------|
| **Path** | `/api/v1/APD/MsDatosGrafos/vinculos-parentesco` |
| **API Gateway** | Interno |
| **Método HTTP** | `GET` |
| **Protocolo** | REST/HTTP |

#### Headers Requeridos

| Header | Tipo | Descripción |
|--------|------|-------------|
| `Authorization` | String | Bearer token JWT para autenticación del usuario |
| `Content-Type` | String | `application/json` |
| `X-Correlation-ID` | UUID | Identificador único de correlación para trazabilidad end-to-end |
| `X-User-Role` | String | Rol del usuario que realiza la operación |

#### Parámetros de Entrada (Query Parameters)

| Parámetro | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-----------|------|-------------|-----------|-----------|-------------|
| `idCiudadano` | String | Sí | 8 | 20 | Identificador del ciudadano utilizado como filtro |
| `gradoMaximo` | Integer | No | 1 | 10 | Grado máximo aplicado al criterio de búsqueda |
| `categoriaParentesco` | String | No | 3 | 20 | Categoría de parentesco: `CONSANGUINEO` o `AFINIDAD` |
| `soloVigentes` | Boolean | No | - | - | Indica si solo deben considerarse registros vigentes |
| `pagina` | Integer | No | 1 | 9999 | Número de página para la paginación |
| `registrosPorPagina` | Integer | No | 1 | 100 | Cantidad de registros por página |

#### Respuesta Exitosa (200 OK)

```json
{
  "success": true,
  "data": {
    "ciudadanoConsultado": {
      "idCiudadano": "12345678",
      "nombre": "Juan Pérez García",
      "fechaNacimiento": "1985-05-15"
    },
    "vinculos": [
      {
        "idRelacion": 1001,
        "tipoParentesco": {
          "codigo": "PADRE",
          "descripcion": "Padre",
          "esSimetrico": false
        },
        "gradoParentesco": 1,
        "categoriaParentesco": "CONSANGUINEO",
        "ciudadanoRelacionado": {
          "idCiudadano": "87654321",
          "nombre": "Pedro Pérez López",
          "fechaNacimiento": "1960-03-10"
        },
        "vigencia": {
          "fechaInicio": "1985-05-15",
          "fechaFin": "9999-12-31",
          "esVigente": true
        },
        "sustento": {
          "idActaSustento": "ACTA-2023-001",
          "idDocumentoSustento": "DOC-2023-001"
        },
        "observacion": "Vínculo registrado en acta de nacimiento"
      }
    ],
    "resumen": {
      "totalVinculos": 5,
      "vinculosConsanguineos": 4,
      "vinculosPorAfinidad": 1,
      "vinculosVigentes": 5,
      "vinculosNoVigentes": 0
    },
    "paginacion": {
      "paginaActual": 1,
      "registrosPorPagina": 10,
      "totalRegistros": 5,
      "totalPaginas": 1,
      "tieneAnterior": false,
      "tieneSiguiente": false
    }
  },
  "metadata": {
    "timestamp": "2025-12-01T10:30:00Z",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000",
    "version": "v1.0",
    "tiempoRespuesta": "150ms"
  }
}
```

#### Respuesta de Error

```json
{
  "error": {
    "tipo": "ValidationError",
    "titulo": "Parámetros de consulta inválidos",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El campo idCiudadano es obligatorio"
      }
    ]
  }
}
```

#### Códigos de Respuesta HTTP

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| `200` | OK | Vínculos de parentesco consultados exitosamente |
| `400` | Bad Request | Parámetros de consulta inválidos o formato incorrecto |
| `401` | Unauthorized | Token JWT inválido, expirado o ausente |
| `403` | Forbidden | Usuario sin permisos para consultar vínculos de parentesco |
| `404` | Not Found | Ciudadano no encontrado en el sistema |
| `422` | Unprocessable Entity | ID de ciudadano válido pero sin registros de parentesco |
| `429` | Too Many Requests | Límite de rate limit excedido |
| `500` | Internal Server Error | Error interno del servidor |
| `503` | Service Unavailable | Servicio de base de datos temporalmente no disponible |

---

## Entidades del Dominio

### 1. VinculoParentesco (Aggregate Root)

Representa un vínculo de parentesco entre dos ciudadanos.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `idRelacion` | Long | ID único de la relación en la tabla GRF_PARENTESCO |
| `tipoParentesco` | TipoParentesco | Información del tipo de parentesco |
| `gradoParentesco` | Long | Grado de parentesco calculado |
| `categoriaParentesco` | String | Categoría: CONSANGUINEO o AFINIDAD |
| `ciudadanoRelacionado` | Ciudadano | Datos del ciudadano relacionado |
| `vigencia` | Vigencia | Información de vigencia de la relación |
| `sustento` | Sustento | Documentos de sustento de la relación (opcional) |
| `observacion` | String | Observación de la relación (opcional) |

### 2. TipoParentesco (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `codigo` | String | Código del tipo de parentesco |
| `descripcion` | String | Descripción del tipo de parentesco |
| `esSimetrico` | Boolean | Indica si la relación es simétrica |

### 3. Ciudadano (Entity)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `idCiudadano` | String | DNI del ciudadano |
| `nombre` | String | Nombre completo del ciudadano |
| `fechaNacimiento` | LocalDate | Fecha de nacimiento (opcional) |

### 4. Vigencia (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `fechaInicio` | LocalDate | Fecha de inicio de vigencia |
| `fechaFin` | LocalDate | Fecha de fin de vigencia |
| `esVigente` | Boolean | Indica si la relación está vigente actualmente |

### 5. Sustento (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `idActaSustento` | String | ID del acta de sustento |
| `idDocumentoSustento` | String | ID del documento de sustento |

### 6. Resumen (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `totalVinculos` | Long | Total de vínculos encontrados |
| `vinculosConsanguineos` | Long | Cantidad de vínculos consanguíneos |
| `vinculosPorAfinidad` | Long | Cantidad de vínculos por afinidad |
| `vinculosVigentes` | Long | Cantidad de vínculos vigentes |
| `vinculosNoVigentes` | Long | Cantidad de vínculos no vigentes |

### 7. Paginacion (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `paginaActual` | Long | Página actual |
| `registrosPorPagina` | Long | Registros por página |
| `totalRegistros` | Long | Total de registros disponibles |
| `totalPaginas` | Long | Total de páginas |
| `tieneAnterior` | Boolean | Indica si existe página anterior |
| `tieneSiguiente` | Boolean | Indica si existe página siguiente |

---

## Reglas de Mapeo de Tipos

Según las convenciones del proyecto, los tipos de datos del PDF se mapean a tipos Java de la siguiente manera:

| Tipo en PDF | Tipo Java | Justificación |
|-------------|-----------|---------------|
| `string` | `String` | Tipo estándar para cadenas de texto |
| `integer` | `Long` | Valores enteros con rango amplio |
| `boolean` | `Boolean` | Valores verdadero/falso, permite null |
| `YYYY-MM-DD` (date) | `LocalDate` | Fechas sin componente de tiempo |
| `YYYY-MM-DDThh:mm:ssZ` (datetime) | `LocalDateTime` | Fechas con componente de tiempo |
| `array` | `List<T>` | Colecciones ordenadas |

---

## Características de Arquitectura

### Arquitectura Hexagonal

1. **Dominio (Core):**
   - Entidades del negocio sin dependencias externas
   - Puertos definidos como interfaces puras
   - Lógica de negocio encapsulada

2. **Aplicación:**
   - Casos de uso implementados como servicios
   - Orquestación de operaciones del dominio

3. **Infraestructura:**
   - Adaptadores de entrada (REST)
   - Adaptadores de salida (Persistencia)
   - Mappers para conversión de datos

### Neutralidad Tecnológica

Este proyecto sigue el principio de **neutralidad tecnológica**:

- **Sin frameworks:** No usa Spring, Jakarta EE, ni otros frameworks
- **Sin anotaciones:** Código Java puro sin anotaciones de frameworks
- **Sin dependencias externas:** Solo bibliotecas estándar de Java
- **POJOs puros:** Todas las clases son Plain Old Java Objects
- **Interfaces explícitas:** Puertos definidos como interfaces Java

### Inversión de Dependencias

- El dominio NO depende de la infraestructura
- Los adaptadores dependen de los puertos del dominio
- Las interfaces (puertos) están en el dominio
- Las implementaciones (adaptadores) están en infraestructura

---

## Limitaciones y Consideraciones

### 1. Sin Implementación de Base de Datos

El `VinculoParentescoRepositoryAdapter` contiene una implementación stub que lanza `UnsupportedOperationException`. En un entorno real, esta clase necesitaría:

- Driver de base de datos de grafos (Neo4j, ArangoDB, etc.)
- Implementación de consultas Cypher o lenguaje específico del grafo
- Manejo de conexiones y transacciones
- Gestión de errores de base de datos

### 2. Sin Protocolo de Comunicación Definido

El código no asume ningún protocolo específico:

- No hay implementación HTTP real
- No hay serialización/deserialización JSON
- No hay manejo de seguridad (JWT, OAuth)
- Los headers y parámetros están documentados pero no implementados

### 3. Sin Framework de Inyección de Dependencias

Las clases reciben dependencias por constructor, pero no hay:

- Contenedor IoC
- Configuración de beans
- Gestión de ciclo de vida
- Autodescubrimiento de componentes

### 4. Sin Manejo de Errores Centralizado

El código no incluye:

- Exception handlers globales
- Traducción de excepciones técnicas a de negocio
- Logging estructurado
- Métricas y observabilidad

### 5. Compilación

El código es **Java puro compilable** sin dependencias externas. Para compilar:

```bash
javac -d target src/main/java/pe/gob/reniec/siirc/msdatosgrafos/**/*.java
```

---

## Próximos Pasos para Producción

Para llevar este microservicio a un entorno productivo, se requiere:

1. **Añadir dependencias:**
   - Driver de base de datos de grafos
   - Framework web (opcional: Spring Boot, Quarkus, etc.)
   - Bibliotecas de serialización JSON

2. **Implementar adaptadores:**
   - Implementación real del RepositoryAdapter con consultas a base de datos
   - Configuración de conexión y pool de conexiones
   - Manejo de transacciones

3. **Añadir seguridad:**
   - Validación de JWT
   - Control de acceso basado en roles
   - Rate limiting

4. **Añadir observabilidad:**
   - Logging centralizado
   - Métricas (Prometheus, Micrometer)
   - Distributed tracing (Zipkin, Jaeger)
   - Health checks

5. **Añadir configuración:**
   - Archivos de propiedades por ambiente
   - Variables de entorno
   - Configuración de timeouts y reintentos

6. **Testing:**
   - Tests unitarios para dominio
   - Tests de integración para adaptadores
   - Tests de contrato para API

---

## Contexto RENIEC

Este microservicio es parte del ecosistema **SIIRC** (Sistema Integral de Identificación y Registro Civil) del **RENIEC** (Registro Nacional de Identificación y Estado Civil de Perú).

### Tabla de Base de Datos

Los vínculos de parentesco se almacenan en la tabla `GRF_PARENTESCO` de la base de datos de grafos, donde:

- Cada registro representa una arista (relación) entre dos nodos (ciudadanos)
- Las consultas utilizan algoritmos de grafos para determinar grados de parentesco
- La estructura de grafos permite análisis complejos de conectividad familiar

---

## Versión del Documento

| Versión | Fecha | Descripción |
|---------|-------|-------------|
| 1.0 | 01/12/2025 | Versión inicial generada desde PDF de especificación |

---

## Autor

Generado automáticamente siguiendo el **AGENT_PROMPT.md** para arquitectura hexagonal sin frameworks.
