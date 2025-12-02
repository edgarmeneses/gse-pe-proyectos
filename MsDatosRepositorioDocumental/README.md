# Microservicio MsDatosRepositorioDocumental

## Resumen

**Nombre:** MsDatosRepositorioDocumental  
**Contexto:** Gestión centralizada de documentos digitales dentro de la plataforma SIIRC, integrándose con Alfresco como sistema de gestión documental (ECM).  
**Versión API:** v1  
**Paquete Base:** `pe.gob.reniec.msdatos.repositoriodocumental`  
**Tipo de Microservicio:** **MsData** (Microservicio de Datos)

Como microservicio de tipo **MsData**, este proyecto:
- Define `RepositoryPort` para documentos y carpetas
- Contiene `Entities` (POJOs sin anotaciones JPA)
- Implementa `RepositoryAdapter` que conecta con el sistema de persistencia
- NO depende de componentes externos tipo MsDataXXXX

## Contexto de Negocio

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. Este microservicio forma parte de la solución de Personalización del DNIe de RENIEC y se encarga de la gestión centralizada de documentos digitales, garantizando la trazabilidad, seguridad e integridad de la información.

## Características de la Arquitectura

### Arquitectura Hexagonal (Puertos y Adaptadores)
Este proyecto implementa una arquitectura hexagonal estricta sin dependencias de frameworks:
- **Sin frameworks:** No se utilizan Spring, JAX-RS, JPA ni ninguna librería externa
- **POJOs puros:** Todas las clases son Java puro sin anotaciones
- **Puertos y Adaptadores:** Clara separación entre lógica de negocio e infraestructura
- **Sin protocolo definido:** Los adaptadores no implementan tecnologías específicas (HTTP/SOAP/etc)

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/msdatos/repositoriodocumental/
├── domain/
│   ├── model/
│   │   ├── Documento.java
│   │   └── Carpeta.java
│   └── ports/
│       ├── in/
│       │   ├── CrearDocumentoUseCase.java
│       │   ├── ConsultarDocumentoUseCase.java
│       │   ├── ActualizarDocumentoUseCase.java
│       │   ├── ListarDocumentosUseCase.java
│       │   ├── CrearCarpetaUseCase.java
│       │   ├── ActualizarCarpetaUseCase.java
│       │   ├── ConsultarCarpetaUseCase.java
│       │   └── ConsultarDocumentoPorDniUseCase.java
│       └── out/
│           ├── DocumentoRepositoryPort.java
│           └── CarpetaRepositoryPort.java
├── application/
│   └── service/
│       ├── CrearDocumentoService.java
│       ├── ConsultarDocumentoService.java
│       ├── ActualizarDocumentoService.java
│       ├── ListarDocumentosService.java
│       ├── CrearCarpetaService.java
│       ├── ActualizarCarpetaService.java
│       ├── ConsultarCarpetaService.java
│       └── ConsultarDocumentoPorDniService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   ├── DocumentoController.java
        │       │   └── CarpetaController.java
        │       ├── dto/
        │       │   ├── DocumentoRequestDto.java
        │       │   ├── DocumentoResponseDto.java
        │       │   ├── ActualizarDocumentoRequestDto.java
        │       │   ├── ActualizarDocumentoResponseDto.java
        │       │   ├── ConsultarDocumentoResponseDto.java
        │       │   ├── CarpetaRequestDto.java
        │       │   ├── CarpetaResponseDto.java
        │       │   ├── ActualizarCarpetaRequestDto.java
        │       │   ├── ActualizarCarpetaResponseDto.java
        │       │   ├── PageDto.java
        │       │   ├── ListarDocumentosResponseDto.java
        │       │   ├── DocumentoInfoDto.java
        │       │   ├── ErrorDto.java
        │       │   └── ErrorDetalleDto.java
        │       └── mapper/
        │           ├── DocumentoDtoMapper.java
        │           └── CarpetaDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   ├── DocumentoEntity.java
                │   └── CarpetaEntity.java
                ├── mapper/
                │   ├── DocumentoPersistenceMapper.java
                │   └── CarpetaPersistenceMapper.java
                ├── DocumentoRepositoryAdapter.java
                └── CarpetaRepositoryAdapter.java
```

## Endpoints del Microservicio

### 1. Crear Documento
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`
- **Método:** `POST`
- **Headers:**
  - `Content-Type: application/json`
  - `Authorization: Bearer {token}`
  - `X-Correlation-ID: {UUID}`
  - `X-Office-Code: {código de oficina}`
- **Request Body:**
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {
    "estructura": {
      "nombreArchivo": "string",
      "tipoDocumento": "string",
      "descripcion": "string"
    }
  }
}
```
- **Response (201):**
```json
{
  "id": "string",
  "metadata": "Documento",
  "createdAt": "2025-12-01T10:30:00+00:00",
  "estadoDocumento": "string"
}
```
- **Status Codes:**
  - `201 Created` - Documento creado exitosamente
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `408 Request Timeout` - Timeout
  - `413 Payload Too Large` - Tamaño excedido (50 MB)
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 2. Obtener Documento Específico
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar`
- **Método:** `GET`
- **Path Parameters:**
  - `id` (string, obligatorio, 2-36 caracteres)
- **Response (200):**
```json
{
  "archivo": "string",
  "carpetaId": "string",
  "metadata": {},
  "estadoDocumento": "string"
}
```
- **Status Codes:**
  - `200 OK` - Documento encontrado
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `404 Not Found` - Documento no encontrado
  - `408 Request Timeout` - Timeout
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 3. Actualizar Documento
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}`
- **Método:** `PUT`
- **Path Parameters:**
  - `id` (string, obligatorio)
- **Request Body:**
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {},
  "estadoDocumento": "string"
}
```
- **Response (200):**
```json
{
  "id": "string",
  "camposActualizados": [],
  "updatedAt": "2025-12-01T10:30:00+00:00",
  "estadoDocumento": "string"
}
```
- **Status Codes:**
  - `200 OK` - Documento actualizado
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `404 Not Found` - Documento no existe
  - `408 Request Timeout` - Timeout
  - `409 Conflict` - Conflicto de versión
  - `413 Payload Too Large` - Tamaño excedido (50 MB)
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 4. Consultar Varios Documentos
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`
- **Método:** `GET`
- **Query Parameters:**
  - `queryParam1` (string, opcional, 1-20 caracteres)
  - `queryParam2` (string, opcional, 1-20 caracteres)
  - `queryParam3` (string, opcional, 1-20 caracteres)
  - `page` (integer, obligatorio, mínimo 1)
  - `size` (integer, obligatorio, mínimo 1)
- **Response (200):**
```json
{
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 100,
    "totalPages": 10,
    "hasNext": true
  },
  "content": [
    {
      "documentoId": "string",
      "nombreDocumento": "string",
      "rutaDocumento": "string"
    }
  ]
}
```
- **Status Codes:**
  - `200 OK` - Consulta exitosa
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `408 Request Timeout` - Timeout
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 5. Crear Carpeta
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta`
- **Método:** `POST`
- **Request Body:**
```json
{
  "nombre": "string",
  "parentId": "string",
  "descripcion": "string"
}
```
- **Response (201):**
```json
{
  "id": "string",
  "createdAt": "2025-12-01T10:30:00+00:00",
  "estadoCarpeta": "string",
  "ruta": "string"
}
```
- **Status Codes:**
  - `201 Created` - Carpeta creada exitosamente
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `408 Request Timeout` - Timeout
  - `409 Conflict` - Carpeta con mismo nombre ya existe
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 6. Actualizar Carpeta
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`
- **Método:** `PUT`
- **Path Parameters:**
  - `id` (string, obligatorio)
- **Request Body:**
```json
{
  "nombre": "string",
  "estadoCarpeta": "string",
  "parentId": "string",
  "descripcion": "string"
}
```
- **Response (200):**
```json
{
  "id": "string",
  "updateAt": "2025-12-01T10:30:00+00:00",
  "camposActualizados": []
}
```
- **Status Codes:**
  - `200 OK` - Carpeta actualizada exitosamente
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `404 Not Found` - Carpeta no existe
  - `408 Request Timeout` - Timeout
  - `409 Conflict` - Carpeta con mismo nombre ya existe
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 7. Consultar Contenido de Carpeta
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`
- **Método:** `GET`
- **Path Parameters:**
  - `id` (string, obligatorio, 1-20 caracteres)
- **Query Parameters:**
  - `queryParam1` (string, opcional, 1-20 caracteres)
  - `queryParam2` (string, opcional, 1-20 caracteres)
  - `queryParam3` (string, opcional, 1-20 caracteres)
  - `page` (integer, obligatorio, mínimo 1)
  - `size` (integer, obligatorio, mínimo 1)
- **Response (200):**
```json
{
  "folder": {
    "id": "string",
    "metadata": {},
    "path": "string",
    "estadoCarpeta": "string",
    "createdAt": "2025-12-01T10:30:00+00:00",
    "updateAt": "2025-12-01T10:30:00+00:00"
  },
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 100,
    "totalPages": 10,
    "hasNext": true
  },
  "contents": {
    "folders": [
      {
        "id": "string",
        "metadata": {},
        "createdAt": "2025-12-01T10:30:00+00:00"
      }
    ],
    "documents": [
      {
        "id": "string",
        "metadata": {},
        "createdAt": "2025-12-01T10:30:00+00:00"
      }
    ]
  }
}
```
- **Status Codes:**
  - `200 OK` - Consulta exitosa
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `404 Not Found` - Carpeta no existe
  - `408 Request Timeout` - Timeout
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

### 8. Consultar Documentos por DNI del Ciudadano
- **Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar`
- **Método:** `GET`
- **Query Parameters:**
  - `dni` (string, obligatorio, 8 caracteres)
  - `tipoDocumento` (string, opcional, 1-30 caracteres)
  - `fechaDesde` (string ISO 8601, opcional)
  - `fechaHasta` (string ISO 8601, opcional)
  - `estadoDocumento` (string, opcional, 1-20 caracteres)
  - `page` (integer, obligatorio, mínimo 1)
  - `size` (integer, obligatorio, 1-100)
- **Response (200):**
```json
{
  "ciudadano": {
    "dni": "string",
    "nombreCompleto": "string"
  },
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 100,
    "totalPages": 10,
    "hasNext": true,
    "hasPrevious": false
  },
  "content": [
    {
      "documentoId": "string",
      "nombreDocumento": "string",
      "tipoDocumento": "string",
      "rutaDocumento": "string",
      "carpetaId": "string",
      "estadoDocumento": "string",
      "mimeType": "string",
      "tamanioBytes": 1024,
      "createdAt": "2025-12-01T10:30:00+00:00",
      "updatedAt": "2025-12-01T10:30:00+00:00"
    }
  ]
}
```
- **Status Codes:**
  - `200 OK` - Consulta exitosa
  - `400 Bad Request` - Parámetros inválidos
  - `401 Unauthorized` - Token inválido
  - `403 Forbidden` - Sin permisos
  - `404 Not Found` - No se encontraron documentos para el DNI
  - `408 Request Timeout` - Timeout
  - `422 Unprocessable Entity` - Datos no procesables
  - `429 Too Many Requests` - Rate limit excedido
  - `500 Internal Server Error` - Error interno
  - `502 Bad Gateway` - Alfresco no responde
  - `503 Service Unavailable` - Servicio no disponible
  - `504 Gateway Timeout` - Timeout de gateway

## Entidades del Dominio

### Documento
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| id | String | Identificador único del documento |
| archivoBase64 | String | Contenido del documento en Base64 |
| carpetaId | String | Identificador de la carpeta contenedora |
| metadata | Map<String, Object> | Metadatos del documento |
| estadoDocumento | String | Estado actual del documento |
| createdAt | LocalDateTime | Fecha de creación |
| updatedAt | LocalDateTime | Fecha de última actualización |

### Carpeta
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| id | String | Identificador único de la carpeta |
| nombre | String | Nombre de la carpeta (1-30 caracteres) |
| parentId | String | Identificador de la carpeta padre |
| descripcion | String | Descripción de la carpeta (opcional, 1-300 caracteres) |
| estadoCarpeta | String | Estado actual de la carpeta |
| ruta | String | Ruta completa en el sistema |
| metadata | Map<String, Object> | Metadatos de la carpeta |
| createdAt | LocalDateTime | Fecha de creación |
| updatedAt | LocalDateTime | Fecha de última actualización |

## Reglas de Mapeo de Tipos

Según la especificación del PDF, se aplicaron las siguientes conversiones de tipos:

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer/int | Integer |
| long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp/ISO 8601 | LocalDateTime |
| array/list | List<T> |
| object | Map<String, Object> o POJO |

## Tipo de Microservicio: MsData

Este es un microservicio de tipo **MsData** (Microservicio de Datos), lo cual implica:

### Características:
- **Define RepositoryPort:** Interfaces `DocumentoRepositoryPort` y `CarpetaRepositoryPort` en `domain/ports/out/`
- **Contiene Entities:** POJOs `DocumentoEntity` y `CarpetaEntity` en `infrastructure/adapters/out/persistence/entity/`
- **Implementa RepositoryAdapter:** `DocumentoRepositoryAdapter` y `CarpetaRepositoryAdapter` en `infrastructure/adapters/out/persistence/`
- **Responsabilidad:** Gestión directa de datos en el repositorio documental (Alfresco)

### Diferencias con MsDominio:
- **MsData:** Gestiona la persistencia directamente
- **MsDominio:** Se integraría con MsData a través de puertos de salida tipo `DataPort` y adaptadores cliente

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- **Sin frameworks:** No se incluyen Spring, JAX-RS, JPA, Hibernate, MapStruct ni similares
- **Sin anotaciones:** Código 100% Java puro sin anotaciones de frameworks
- **Sin protocolo definido:** Los adaptadores no implementan HTTP, SOAP ni otros protocolos específicos
- **Sin drivers:** No se incluyen drivers de base de datos ni conectores específicos

### Implementación de Adaptadores
Los adaptadores (`DocumentoRepositoryAdapter` y `CarpetaRepositoryAdapter`) contienen métodos stub que lanzan `UnsupportedOperationException`. Esto es intencional porque:
- El prompt requiere no asumir tecnologías específicas
- La conexión con Alfresco debe implementarse según las decisiones arquitectónicas del equipo
- Se mantiene la estructura correcta para futuras implementaciones

### Build y Dependencias
- **No se genera pom.xml:** Mantiene neutralidad respecto a la herramienta de build (Maven, Gradle, etc.)
- **No se definen dependencias:** Cada equipo decide qué librerías usar para implementar los adaptadores
- **Código compilable:** Todo el código es Java puro y compilable sin dependencias externas

### Manejo de Errores
- Los códigos de error HTTP están documentados en este README
- No se implementa lógica HTTP real en los controladores (POJOs sin anotaciones)
- Los detalles de error se representan mediante DTOs (`ErrorDto`, `ErrorDetalleDto`)

### Operaciones Definidas
Solo se crearon los casos de uso y endpoints que están **explícitamente documentados en el PDF**:
1. Crear Documento (POST)
2. Obtener Documento Específico (GET)
3. Actualizar Documento (PUT)
4. Consultar Varios Documentos (GET con filtros)
5. Crear Carpeta (POST)
6. Actualizar Carpeta (PUT)
7. Consultar Contenido de Carpeta (GET)
8. Consultar Documentos por DNI (GET)

**No se implementó DELETE** porque no aparece en la especificación del PDF.

## Próximos Pasos para Implementación

Para completar la implementación de este microservicio:

1. **Seleccionar Framework Web:** Spring Boot, Quarkus, Micronaut, etc.
2. **Agregar Anotaciones:** `@RestController`, `@Service`, `@Repository`, según el framework
3. **Implementar Conexión con Alfresco:** Cliente HTTP, SDK de Alfresco, etc.
4. **Configurar Persistencia:** Si se requiere BD adicional a Alfresco
5. **Implementar Seguridad:** Validación JWT, autorización
6. **Agregar Observabilidad:** Logging, métricas, tracing distribuido
7. **Configurar Build:** pom.xml o build.gradle con dependencias
8. **Pruebas:** Unitarias, de integración y end-to-end

## Compilación

El código generado es Java puro y puede compilarse con:
```bash
javac -d out -sourcepath src/main/java src/main/java/pe/gob/reniec/msdatos/repositoriodocumental/**/*.java
```

## Documentación de Referencia

- **Especificación Original:** `Microservicio MsDatosRepositorioDocumental V1.3.pdf`
- **Versión del Documento:** 1.3 (01/12/2025)
- **Organización:** RENIEC - Registro Nacional de Identificación y Estado Civil
- **Contexto:** Gestión de Seguridad Electrónica - Personalización del DNIe

---

**Nota:** Este proyecto sigue estrictamente la especificación del PDF sin inferencias adicionales, manteniendo neutralidad tecnológica y permitiendo flexibilidad en la implementación futura.
