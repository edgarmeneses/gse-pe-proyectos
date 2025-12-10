# MsDominioPadronElectoral

Microservicio de Dominio para la Gestión Integral del Padrón Electoral - RENIEC

## Información General

- **Nombre**: MsDominioPadronElectoral
- **Versión del Documento**: 1.1
- **Versión de la API**: v1
- **Fecha de Especificación**: 03/12/2025
- **Tipo de Microservicio**: MsDominio (Microservicio de Dominio)
- **Paquete Base**: `pe.gob.reniec.padronelectoral`
- **Organización**: RENIEC (Registro Nacional de Identificación y Estado Civil)

## Contexto de Negocio

El Microservicio Padrón Electoral tiene como propósito principal la gestión integral del Padrón Electoral en Perú. Su función es generar, mantener y servir los listados finales y definitivos de personas habilitadas para votar, así como las circunscripciones asociadas, para ser consumidos por los diferentes servicios electorales del sistema.

Este microservicio forma parte de la modernización y transformación digital del Estado peruano en el marco del sistema de DNI Electrónico (DNIe).

## Arquitectura

Este proyecto implementa una **Arquitectura Hexagonal (Ports and Adapters)** estricta siguiendo los principios de **Domain-Driven Design (DDD)**.

### Tipo de Microservicio: MsDominio

Al ser un **MsDominio**, este microservicio:
- **NO define RepositoryPort** (no accede directamente a bases de datos)
- Se integra con el componente externo **MsDataPadronElectoral** a través de puertos de salida
- Implementa un adaptador cliente (`PadronElectoralDataAdapter`) que actúa como puente hacia MsDataPadronElectoral
- **No define el protocolo de comunicación** (HTTP/SOAP/Colas) - mantiene neutralidad tecnológica
- Contiene lógica de dominio y orquestación de casos de uso

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/padronelectoral/
├── domain/
│   ├── model/
│   │   ├── PadronElectoral.java          (Aggregate Root)
│   │   ├── Circunscripcion.java          (Value Object)
│   │   ├── Ciudadano.java                (Value Object)
│   │   ├── ActualizacionPadron.java      (Value Object)
│   │   ├── PaginatedResult.java          (Generic Value Object)
│   │   ├── ErrorResponse.java            (Value Object)
│   │   └── ErrorDetail.java              (Value Object)
│   └── ports/
│       ├── in/
│       │   ├── GenerarPadronElectoralUseCase.java
│       │   ├── ActualizarPadronElectoralUseCase.java
│       │   ├── ConsultarPadronElectoralUseCase.java
│       │   └── ListarPadronesElectoralesUseCase.java
│       └── out/
│           └── PadronElectoralDataPort.java      (Puerto unificado hacia MsData)
├── application/
│   └── service/
│       ├── GenerarPadronElectoralService.java
│       ├── ActualizarPadronElectoralService.java
│       ├── ConsultarPadronElectoralService.java
│       └── ListarPadronesElectoralesService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── PadronElectoralController.java
        │       ├── dto/
        │       │   ├── GenerarPadronElectoralRequestDto.java
        │       │   ├── ActualizarPadronElectoralRequestDto.java
        │       │   ├── PadronElectoralResponseDto.java
        │       │   ├── ListarPadronesResponseDto.java
        │       │   ├── ConsultarPadronResponseDto.java
        │       │   └── CircunscripcionDto.java
        │       └── mapper/
        │           └── PadronElectoralDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    └── PadronElectoralDataAdapter.java
```

## Endpoints del API

### Base Path
`/api/v1/electoral/MsDominioPadronElectoral`

### Headers Comunes
Todos los endpoints requieren los siguientes headers:
- `Content-Type`: application/json o multipart/form-data
- `Authorization`: Bearer token JWT para autenticación
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina de origen (formato: ORG-LIMA-CENTRO)

---

### 1. Generar Padrón Electoral

**Endpoint**: `POST /api/v1/electoral/MsDominioPadronElectoral`

**Descripción**: Crea un nuevo padrón electoral inicial, preliminar o final en el sistema.

**Request Body**:
```json
{
  "tipoPadron": "string",
  "circunscripcion": {
    "estructura": {
      "departamento": "string",
      "provincia": "string",
      "distrito": "string"
    }
  }
}
```

**Response** (201 Created):
```json
{
  "idPadron": "string",
  "listaCiudadanos": [
    {
      "nombre": "string",
      "documento": "string",
      "direccion": "string"
    }
  ],
  "tipoPadron": "string",
  "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ"
}
```

**Status Codes**:
- `201 Created`: Padrón creado exitosamente
- `400 Bad Request`: Parámetros inválidos
- `401 Unauthorized`: Token JWT inválido, expirado o ausente
- `403 Forbidden`: Sin permisos para crear un padrón
- `404 Not Found`: Provincias no existentes
- `409 Conflict`: Padrón duplicado
- `422 Unprocessable Entity`: Destinatario en lista negra o datos bloqueados
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `502 Bad Gateway`: Proveedores externos no disponibles
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### 2. Actualizar Padrón Electoral

**Endpoint**: `PUT /api/v1/electoral/MsDominioPadronElectoral/{id}`

**Descripción**: Actualiza un padrón electoral existente en el sistema.

**Path Parameters**:
- `id` (string, obligatorio): Identificador del padrón

**Request Body**:
```json
{
  "usuarioResponsableId": "string",
  "tipoPadron": "string",
  "informeFinalVerificacionDomicilioId": "string",
  "tipoVerificacion": "string"
}
```

**Response** (200 OK):
```json
{
  "idPadron": "string",
  "listaCiudadanos": [
    {
      "nombre": "string",
      "documento": "string",
      "direccion": "string"
    }
  ],
  "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
  "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ"
}
```

**Status Codes**:
- `200 OK`: Padrón actualizado exitosamente
- `400 Bad Request`: Parámetros inválidos
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Sin permisos para actualizar el padrón
- `404 Not Found`: Padrón no encontrado
- `422 Unprocessable Entity`: Datos no procesables por reglas de negocio
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `502 Bad Gateway`: Proveedores externos no disponibles
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### 3. Listar Padrones Electorales

**Endpoint**: `GET /api/v1/electoral/MsDominioPadronElectoral`

**Descripción**: Obtiene un listado de padrones según filtros con paginación.

**Query Parameters**:
- `texto` (string, opcional, 1-20 chars): Texto para filtrado
- `fecha` (string, opcional, 1-20 chars): Fecha para filtrado
- `queryParam3` (string, opcional, 1-20 chars): Parámetro adicional de filtrado
- `page` (integer, obligatorio, min 1): Número de página
- `size` (integer, obligatorio, min 1): Cantidad de registros por página

**Response** (200 OK):
```json
{
  "number": 1,
  "size": 10,
  "totalElements": 100,
  "totalPages": 10,
  "hasNext": true,
  "contenido": [
    {
      "idPadron": "string",
      "tipoPadron": "string",
      "circunscripcion": "string",
      "tipoProceso": "string",
      "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
      "cantidadCiudadanos": 1000
    }
  ]
}
```

**Status Codes**:
- `200 OK`: Padrones consultados exitosamente
- `400 Bad Request`: Parámetros inválidos
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Sin permisos para obtener el padrón
- `404 Not Found`: Padrón no encontrado
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `502 Bad Gateway`: Proveedores externos no disponibles
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### 4. Consultar Padrón Electoral por ID

**Endpoint**: `GET /api/v1/electoral/MsDominioPadronElectoral/{id}`

**Descripción**: Obtiene la información específica de un padrón con ciudadanos paginados.

**Path Parameters**:
- `id` (string, obligatorio): Identificador del padrón

**Query Parameters**:
- `page` (integer, obligatorio, min 1): Número de página para ciudadanos
- `size` (integer, obligatorio, min 1): Cantidad de registros por página

**Response** (200 OK):
```json
{
  "padron": {
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
    "actualizacionPadron": [
      {
        "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
        "usuarioResponsableId": "string",
        "informeFinalVerificacionDomicilioId": "string"
      }
    ],
    "tipoPadron": "string",
    "tipoProceso": "string"
  },
  "number": 1,
  "size": 10,
  "totalElements": 1000,
  "totalPages": 100,
  "hasNext": true,
  "listaCiudadanos": [
    {
      "nombre": "string",
      "documento": "string",
      "direccion": "string"
    }
  ]
}
```

**Status Codes**:
- `200 OK`: Padrón consultado exitosamente
- `400 Bad Request`: Parámetros inválidos
- `401 Unauthorized`: Token JWT inválido
- `403 Forbidden`: Sin permisos para obtener el padrón
- `404 Not Found`: Padrón no encontrado
- `429 Too Many Requests`: Límite de rate limit excedido
- `500 Internal Server Error`: Error interno del servidor
- `502 Bad Gateway`: Proveedores externos no disponibles
- `503 Service Unavailable`: Servicio temporalmente no disponible

---

### Modelo de Error Estándar

Todos los endpoints retornan el siguiente formato para errores:

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": 400,
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

## Modelo de Dominio

### Entidades y Value Objects

#### PadronElectoral (Aggregate Root)
- `idPadron`: String
- `tipoPadron`: String
- `tipoProceso`: String
- `fechaCreacion`: LocalDateTime
- `fechaActualizacion`: LocalDateTime (opcional)
- `circunscripcion`: Circunscripcion
- `listaCiudadanos`: List\<Ciudadano\>
- `actualizacionesPadron`: List\<ActualizacionPadron\>
- `cantidadCiudadanos`: Integer

#### Circunscripcion (Value Object)
- `departamento`: String
- `provincia`: String
- `distrito`: String

#### Ciudadano (Value Object)
- `nombre`: String
- `documento`: String
- `direccion`: String

#### ActualizacionPadron (Value Object)
- `fechaActualizacion`: LocalDateTime
- `usuarioResponsableId`: String
- `informeFinalVerificacionDomicilioId`: String

#### PaginatedResult\<T\> (Generic Value Object)
- `number`: Integer
- `size`: Integer
- `totalElements`: Long
- `totalPages`: Integer
- `hasNext`: Boolean
- `contenido`: List\<T\>

## Mapeo de Tipos

El proyecto sigue las siguientes convenciones de mapeo desde la especificación:

| Tipo en Especificación | Tipo en Java |
|------------------------|--------------|
| string | String |
| integer/int | Integer |
| long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp (ISO 8601) | LocalDateTime |
| array/list | List\<T\> |
| object | Clase POJO |

## Puerto de Salida Unificado

Este microservicio define un **único puerto de salida** (`PadronElectoralDataPort`) que recopila todas las operaciones necesarias para comunicarse con **MsDataPadronElectoral**:

### Operaciones del Puerto
1. **crearPadron**: Crea un nuevo padrón con circunscripción
2. **actualizarPadron**: Actualiza un padrón existente
3. **listarPadrones**: Lista padrones con filtros y paginación
4. **consultarPadronPorId**: Consulta un padrón específico
5. **obtenerCiudadanosPaginados**: Obtiene ciudadanos paginados de un padrón

### Adaptador de Salida

El adaptador `PadronElectoralDataAdapter` implementa `PadronElectoralDataPort` pero **NO define el protocolo de comunicación**. Los métodos lanzan `UnsupportedOperationException` como placeholder, indicando que la implementación real debe configurarse según la tecnología elegida (HTTP REST, SOAP, mensajería, etc.).

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- **Sin frameworks**: No se utilizan anotaciones de Spring, JAX-RS, JPA, ni otros frameworks
- **Sin dependencias externas**: Código compilable como Java puro
- **Sin protocolo definido**: La comunicación con MsDataPadronElectoral debe implementarse según necesidades

### Implementación Requerida
- Los servicios de aplicación delegan directamente al puerto de salida
- El adaptador `PadronElectoralDataAdapter` requiere implementación real para:
  - Establecer conexión con MsDataPadronElectoral
  - Serialización/deserialización de datos
  - Manejo de errores y timeouts
  - Implementación de resiliencia (Circuit Breaker, Retry)

### Sin Build Configuration
- No se proporciona `pom.xml` ni `build.gradle`
- Mantiene neutralidad respecto a herramientas de construcción
- El proyecto puede integrarse en cualquier sistema de build

## Casos de Uso Implementados

Solo se implementan los casos de uso documentados en la especificación:

1. **Generar Padrón Electoral** (`GenerarPadronElectoralUseCase`)
2. **Actualizar Padrón Electoral** (`ActualizarPadronElectoralUseCase`)
3. **Consultar Padrón Electoral** (`ConsultarPadronElectoralUseCase`)
4. **Listar Padrones Electorales** (`ListarPadronesElectoralesUseCase`)

No se crean operaciones adicionales de eliminación (DELETE) ya que no están especificadas en el documento fuente.

## Próximos Pasos para Integración

Para completar la implementación de este microservicio:

1. **Elegir protocolo de comunicación** con MsDataPadronElectoral (REST, SOAP, gRPC, etc.)
2. **Implementar PadronElectoralDataAdapter** con la tecnología seleccionada
3. **Agregar framework web** (Spring Boot, Quarkus, Micronaut) para exposición REST
4. **Configurar seguridad** (JWT, OAuth2)
5. **Implementar logging y observabilidad** (Correlation ID, tracing distribuido)
6. **Agregar validaciones** de entrada y manejo de errores
7. **Configurar resiliencia** (Circuit Breaker, Retry, Timeout)
8. **Definir estrategia de despliegue** (contenedores, Kubernetes)

## Documentos de Referencia

- `ANALISIS_ESPECIFICACION.md`: Análisis detallado extraído del PDF de especificación
- `Microservicio MsDominioPadronElectoral V1.1.pdf`: Documento fuente de especificación

## Versión
**1.1** - Diciembre 2025

---

*Este proyecto fue generado siguiendo estrictamente las especificaciones del documento "Microservicio MsDominioPadronElectoral V1.1" sin agregar funcionalidades no documentadas.*
