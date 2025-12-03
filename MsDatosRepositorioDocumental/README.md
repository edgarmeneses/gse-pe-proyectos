# MsDatosRepositorioDocumental

## Resumen

**Nombre del Microservicio:** MsDatosRepositorioDocumental  
**Tipo:** MsData (Microservicio de Datos)  
**Contexto de Negocio:** Gestión centralizada de documentos digitales dentro de la plataforma SIIRC de RENIEC, integrándose con Alfresco como sistema de gestión documental (ECM).  
**Versión API:** v1  
**Paquete Base Java:** `pe.gob.reniec.msdatos.repositoriodocumental`  

## Descripción

Este microservicio se encarga de la gestión centralizada de documentos digitales, permitiendo:
- Carga, consulta, actualización y recuperación de documentos
- Gestión de carpetas en el repositorio documental
- Consulta de documentos por DNI de ciudadano
- Integración con Alfresco como sistema de gestión documental (ECM)
- Garantía de trazabilidad, seguridad e integridad de la información

Como microservicio de tipo **MsData**, implementa la capa de persistencia con RepositoryPort y RepositoryAdapter, integrándose directamente con el sistema de gestión documental Alfresco.

## Arquitectura

### Estructura del Proyecto

El proyecto sigue los principios de **Arquitectura Hexagonal (Puertos y Adaptadores)** con **Domain-Driven Design (DDD)**:

```
src/main/java/pe/gob/reniec/msdatos/repositoriodocumental/
├── domain/
│   ├── model/                      # Entidades del dominio (Aggregates y Value Objects)
│   │   ├── Documento.java
│   │   ├── Carpeta.java
│   │   ├── Ciudadano.java
│   │   └── Pagina.java
│   └── ports/
│       ├── in/                     # Puertos de entrada (Use Cases)
│       │   ├── CrearDocumentoUseCase.java
│       │   ├── ConsultarDocumentoUseCase.java
│       │   ├── ActualizarDocumentoUseCase.java
│       │   ├── ListarDocumentosUseCase.java
│       │   ├── ConsultarDocumentoPorDniUseCase.java
│       │   ├── CrearCarpetaUseCase.java
│       │   ├── ActualizarCarpetaUseCase.java
│       │   └── ConsultarCarpetaUseCase.java
│       └── out/                    # Puertos de salida (Repository Ports)
│           ├── DocumentoRepositoryPort.java
│           └── CarpetaRepositoryPort.java
├── application/
│   └── service/                    # Servicios de aplicación (implementan Use Cases)
│       ├── CrearDocumentoService.java
│       ├── ConsultarDocumentoService.java
│       ├── ActualizarDocumentoService.java
│       ├── ListarDocumentosService.java
│       ├── ConsultarDocumentoPorDniService.java
│       ├── CrearCarpetaService.java
│       ├── ActualizarCarpetaService.java
│       └── ConsultarCarpetaService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/               # Adaptador REST (Controllers, DTOs, Mappers)
        │       ├── controller/
        │       │   ├── DocumentoController.java
        │       │   └── CarpetaController.java
        │       ├── dto/            # DTOs como records de Java
        │       │   ├── CrearDocumentoRequestDto.java
        │       │   ├── CrearDocumentoResponseDto.java
        │       │   ├── ConsultarDocumentoResponseDto.java
        │       │   ├── ActualizarDocumentoRequestDto.java
        │       │   ├── ActualizarDocumentoResponseDto.java
        │       │   ├── ListarDocumentosResponseDto.java
        │       │   ├── CrearCarpetaRequestDto.java
        │       │   ├── CrearCarpetaResponseDto.java
        │       │   ├── ActualizarCarpetaRequestDto.java
        │       │   ├── ActualizarCarpetaResponseDto.java
        │       │   ├── ConsultarCarpetaResponseDto.java
        │       │   ├── ConsultarDocumentoPorDniResponseDto.java
        │       │   ├── PaginaDto.java
        │       │   ├── DocumentoItemDto.java
        │       │   ├── DocumentoInfoDto.java
        │       │   ├── DocumentoDetalleDto.java
        │       │   ├── CarpetaItemDto.java
        │       │   ├── FolderDto.java
        │       │   ├── ContentsDto.java
        │       │   ├── CiudadanoDto.java
        │       │   ├── ErrorDto.java
        │       │   └── ErrorDetalleDto.java
        │       └── mapper/
        │           ├── DocumentoDtoMapper.java
        │           └── CarpetaDtoMapper.java
        └── out/
            └── persistence/        # Adaptador de persistencia (Alfresco)
                ├── entity/
                │   ├── DocumentoEntity.java
                │   └── CarpetaEntity.java
                ├── mapper/
                │   ├── DocumentoPersistenceMapper.java
                │   └── CarpetaPersistenceMapper.java
                ├── DocumentoRepositoryAdapter.java
                └── CarpetaRepositoryAdapter.java
```

### Principios Arquitectónicos

- **Sin frameworks ni anotaciones:** El código es Java puro (POJOs e interfaces)
- **Sin tecnología específica:** No se usan anotaciones JPA, Spring, JAX-RS, etc.
- **Separación de responsabilidades:** Clara división entre dominio, aplicación e infraestructura
- **Inversión de dependencias:** El dominio no depende de la infraestructura
- **Neutralidad tecnológica:** El código puede integrarse con cualquier framework

## Endpoints

### 1. Crear Documento

**Método:** `POST`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`  
**Gateway:** Interno  

#### Headers
- `Content-Type`: application/json
- `Authorization`: Bearer token JWT para autenticación
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de oficina (formato: ORG-LIMA-CENTRO)

#### Request Body
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {
    "nombreArchivo": "string",
    "tipoDocumento": "string",
    "descripcion": "string"
  }
}
```

#### Response (201 Created)
```json
{
  "id": "string",
  "metadata": "Documento",
  "createdAt": "YYYY-MM-DDThh:mm:ssZ",
  "estadoDocumento": "string"
}
```

#### Parámetros de Entrada
| Campo | Tipo | Obligatorio | Longitud Min | Longitud Max |
|-------|------|-------------|--------------|--------------|
| archivoBase64 | String | Sí | N/A | N/A |
| carpetaId | String | Sí | 1 | 20 |
| metadata | Object | Sí | - | - |
| metadata.nombreArchivo | String | Sí | 1 | 30 |
| metadata.tipoDocumento | String | Sí | 1 | 30 |
| metadata.descripcion | String | No | 1 | 300 |

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 201 | Documento creado exitosamente |
| 400 | Parámetros inválidos o estructura incorrecta |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Sin permisos para ejecutar la operación |
| 408 | Tiempo de espera agotado |
| 413 | Tamaño del lote excede el límite (50 MB) |
| 422 | Datos válidos pero no procesables |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servicio |
| 502 | Servicio de Alfresco no responde |
| 503 | Servicio temporalmente no disponible |
| 504 | Error de tiempo de espera de puerta de enlace |

---

### 2. Obtener Documento Específico

**Método:** `GET`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}/descargar`  
**Gateway:** Interno  

#### Path Parameters
- `id` (String): Identificador del documento (longitud: 2-36)

#### Response (200 OK)
```json
{
  "archivo": "string",
  "carpetaId": "string",
  "metadata": {},
  "estadoDocumento": "string"
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 200 | Documento encontrado exitosamente |
| 400 | Parámetros inválidos o estructura incorrecta |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Sin permisos para ejecutar la operación |
| 404 | Documento no encontrado |
| 408 | Tiempo de espera agotado |
| 422 | Datos válidos pero no procesables |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servicio |
| 502 | Servicio de Alfresco no responde |
| 503 | Servicio temporalmente no disponible |
| 504 | Error de tiempo de espera de puerta de enlace |

---

### 3. Actualizar Documento

**Método:** `PUT`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{id}`  
**Gateway:** Interno  

#### Path Parameters
- `id` (String): Identificador del documento

#### Request Body
```json
{
  "archivoBase64": "string",
  "carpetaId": "string",
  "metadata": {
    "nombreArchivo": "string",
    "tipoDocumento": "string",
    "descripcion": "string"
  },
  "estadoDocumento": "string"
}
```

#### Response (200 OK)
```json
{
  "id": "string",
  "camposActualizados": ["array"],
  "updatedAt": "YYYY-MM-DDThh:mm:ssZ",
  "estadoDocumento": "string"
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 200 | Documento actualizado exitosamente |
| 400 | Parámetros inválidos o estructura incorrecta |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Sin permisos para ejecutar el análisis de redacción |
| 404 | El documento no existe |
| 408 | Tiempo de espera agotado |
| 409 | Conflictos de versión/estado |
| 413 | Tamaño del lote excede el límite (50 MB) |
| 422 | Datos válidos pero no procesables |
| 429 | Límite de rate limit excedido (100 req/hora) |
| 500 | Error interno del servicio |
| 502 | Servicio de Alfresco no responde |
| 503 | Servicio temporalmente no disponible |
| 504 | Error de tiempo de espera de puerta de enlace |

---

### 4. Consultar Varios Documentos

**Método:** `GET`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento`  
**Gateway:** Interno  

#### Query Parameters
- `queryParam1` (String, opcional): Parámetro de filtrado 1 (longitud: 1-20)
- `queryParam2` (String, opcional): Parámetro de filtrado 2 (longitud: 1-20)
- `queryParam3` (String, opcional): Parámetro de filtrado 3 (longitud: 1-20)
- `page` (Integer, obligatorio): Número de página (mínimo: 1)
- `size` (Integer, obligatorio): Tamaño de página (mínimo: 1)

#### Response (200 OK)
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

---

### 5. Crear Carpeta

**Método:** `POST`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta`  
**Gateway:** Interno  

#### Request Body
```json
{
  "nombre": "string",
  "parentId": "string",
  "descripcion": "string"
}
```

#### Parámetros de Entrada
| Campo | Tipo | Obligatorio | Longitud Min | Longitud Max |
|-------|------|-------------|--------------|--------------|
| nombre | String | Sí | 1 | 30 |
| parentId | String | Sí | - | - |
| descripcion | String | No | 1 | 300 |

#### Response (201 Created)
```json
{
  "id": "string",
  "createdAt": "YYYY-MM-DDThh:mm:ssZ",
  "estadoCarpeta": "string",
  "ruta": "string"
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 201 | Carpeta creada exitosamente |
| 400 | Parámetros inválidos o estructura incorrecta |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Sin permisos para crear carpeta |
| 408 | Tiempo de espera agotado |
| 409 | Carpeta con el mismo nombre ya existe |
| 422 | Datos válidos pero no procesables |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servicio |
| 502 | Servicio de Alfresco no responde |
| 503 | Servicio temporalmente no disponible |
| 504 | Error tiempo de espera en la puerta de enlace |

---

### 6. Actualizar Carpeta

**Método:** `PUT`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`  
**Gateway:** Interno  

#### Path Parameters
- `id` (String): Identificador de la carpeta

#### Request Body
```json
{
  "nombre": "string",
  "estadoCarpeta": "string",
  "parentId": "string",
  "descripcion": "string"
}
```

#### Response (200 OK)
```json
{
  "id": "string",
  "updatedAt": "YYYY-MM-DDThh:mm:ssZ",
  "camposActualizados": ["array"]
}
```

---

### 7. Consultar Contenido de Carpeta

**Método:** `GET`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}`  
**Gateway:** Interno  

#### Path Parameters
- `id` (String): Identificador de la carpeta (longitud: 1-20)

#### Query Parameters
- `queryParam1`, `queryParam2`, `queryParam3` (String, opcional): Filtros
- `page` (Integer, obligatorio): Número de página
- `size` (Integer, obligatorio): Tamaño de página

#### Response (200 OK)
```json
{
  "folder": {
    "id": "string",
    "metadata": {},
    "path": "string",
    "estadoCarpeta": "string",
    "createdAt": "YYYY-MM-DDThh:mm:ssZ",
    "updatedAt": "YYYY-MM-DDThh:mm:ssZ"
  },
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 50,
    "totalPages": 5,
    "hasNext": true
  },
  "contents": {
    "folders": [
      {
        "id": "string",
        "metadata": {},
        "createdAt": "YYYY-MM-DDThh:mm:ssZ"
      }
    ],
    "documents": [
      {
        "id": "string",
        "metadata": {},
        "createdAt": "YYYY-MM-DDThh:mm:ssZ"
      }
    ]
  }
}
```

---

### 8. Consultar Documentos por DNI de Ciudadano

**Método:** `GET`  
**Path:** `/api/v1/documentos/MsDatosRepositorioDocumental/documento/{dni}`  
**Gateway:** Interno  

#### Path Parameters
- `dni` (String): Número de DNI del ciudadano (8 dígitos)

#### Query Parameters
- `tipoDocumento` (String, opcional): Filtro por tipo de documento (longitud: 1-30)
- `fechaDesde` (String, opcional): Fecha inicio en formato ISO 8601
- `fechaHasta` (String, opcional): Fecha fin en formato ISO 8601
- `estadoDocumento` (String, opcional): Filtro por estado (longitud: 1-20)
- `page` (Integer, obligatorio): Número de página (mínimo: 1)
- `size` (Integer, obligatorio): Tamaño de página (1-100)

#### Response (200 OK)
```json
{
  "ciudadano": {
    "dni": "string",
    "nombreCompleto": "string"
  },
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 25,
    "totalPages": 3,
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
      "tamanioBytes": 12345,
      "createdAt": "YYYY-MM-DDThh:mm:ssZ",
      "updatedAt": "YYYY-MM-DDThh:mm:ssZ"
    }
  ]
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 200 | Consulta realizada exitosamente |
| 400 | Parámetros inválidos o estructura incorrecta |
| 401 | Token JWT inválido, expirado o ausente |
| 403 | Sin permisos para ejecutar el análisis de redacción |
| 404 | No se encontraron documentos para el DNI especificado |
| 408 | Tiempo de espera agotado |
| 422 | Datos válidos, pero no procesables |
| 429 | Límite de rate limit excedido |
| 500 | Error interno del servicio |
| 502 | Servicio de Alfresco no responde |
| 503 | Servicio temporalmente no disponible |
| 504 | Error tiempo de espera en la puerta de enlace |

---

## Entidades del Dominio

### Documento (Aggregate Root)
Representa un documento digital almacenado en el repositorio.

**Atributos:**
- `id` (String): Identificador único
- `archivoBase64` (String): Contenido del archivo en Base64
- `carpetaId` (String): Identificador de la carpeta contenedora
- `metadata` (Map<String, Object>): Metadata adicional del documento
- `estadoDocumento` (String): Estado actual
- `createdAt` (LocalDateTime): Fecha de creación
- `updatedAt` (LocalDateTime): Fecha de última actualización

### Carpeta (Aggregate Root)
Representa una carpeta en el sistema de gestión documental.

**Atributos:**
- `id` (String): Identificador único
- `nombre` (String): Nombre de la carpeta
- `parentId` (String): Identificador de la carpeta padre
- `descripcion` (String): Descripción opcional
- `estadoCarpeta` (String): Estado actual
- `ruta` (String): Ruta completa en el sistema
- `metadata` (Map<String, Object>): Metadata adicional
- `createdAt` (LocalDateTime): Fecha de creación
- `updatedAt` (LocalDateTime): Fecha de última actualización

### Ciudadano (Value Object)
Representa información básica de un ciudadano.

**Atributos:**
- `dni` (String): DNI del ciudadano (8 dígitos)
- `nombreCompleto` (String): Nombres y apellidos

### Pagina (Value Object)
Representa información de paginación.

**Atributos:**
- `number` (Integer): Número de página actual
- `size` (Integer): Tamaño de página
- `totalElements` (Long): Total de elementos encontrados
- `totalPages` (Integer): Total de páginas disponibles
- `hasNext` (Boolean): Indica si hay página siguiente
- `hasPrevious` (Boolean): Indica si hay página anterior

---

## Mapeo de Tipos de Datos

La especificación utiliza los siguientes tipos de datos según las convenciones de Java:

| Tipo en Especificación | Tipo en Java |
|------------------------|--------------|
| string | String |
| integer / int | Integer |
| long | Long |
| double / decimal / number | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime / timestamp | LocalDateTime |
| array / list | List<T> |
| object | Map<String, Object> o POJO |

---

## Estructura de Errores

Todos los endpoints siguen una estructura de error estándar:

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

---

## Tipo de Microservicio: MsData

Este es un **microservicio de datos (MsData)**, lo que implica:

### Características de MsData:
- ✅ **Define RepositoryPort**: Interfaces de persistencia en `domain/ports/out/`
- ✅ **Define Entities**: POJOs de persistencia en `infrastructure/adapters/out/persistence/entity/`
- ✅ **Implementa RepositoryAdapter**: Adaptadores que implementan los puertos de repositorio
- ✅ **Integración directa con Alfresco**: Como sistema de gestión documental (ECM)
- ❌ **No depende de otros microservicios de datos**: Gestiona directamente la persistencia

### Diferencia con MsDominio:
Los microservicios de tipo **MsDominio** NO definen RepositoryPort, sino que se integran con microservicios MsData a través de puertos de salida. En este caso, como es MsData, la integración con Alfresco se realiza directamente en los adaptadores de repositorio.

---

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- ✅ **Sin frameworks**: No se utilizan Spring, JAX-RS, ni otros frameworks
- ✅ **Sin anotaciones**: No hay anotaciones JPA, Jakarta, ni de frameworks
- ✅ **Java puro**: Solo POJOs, interfaces y clases
- ✅ **Sin dependencias externas**: El código es compilable como Java estándar

### Integración con Alfresco
- ⚠️ **Protocolo no definido**: Los adaptadores de repositorio tienen métodos stub que lanzan `UnsupportedOperationException`
- ⚠️ **API de Alfresco pendiente**: Se debe implementar la integración específica con la API REST o CMIS de Alfresco
- ⚠️ **Autenticación no implementada**: Se debe configurar la autenticación con Alfresco

### Gestión de Errores
- ⚠️ **Sin manejo HTTP real**: Los controladores no tienen lógica de manejo de códigos de estado HTTP
- ⚠️ **Sin validaciones implementadas**: Las validaciones de negocio están comentadas como "debería implementarse"

### Infraestructura
- ⚠️ **Sin configuración de build**: No se incluye `pom.xml` ni `build.gradle`
- ⚠️ **Sin configuración de despliegue**: No hay archivos de configuración de aplicación

---

## Próximos Pasos

Para completar la implementación, se debe:

1. **Implementar integración con Alfresco**:
   - Configurar cliente HTTP o CMIS para Alfresco
   - Implementar métodos en `DocumentoRepositoryAdapter` y `CarpetaRepositoryAdapter`
   - Gestionar autenticación y sesiones con Alfresco

2. **Agregar framework de aplicación**:
   - Configurar Spring Boot, Quarkus, Micronaut u otro framework
   - Agregar anotaciones REST (`@RestController`, `@GetMapping`, etc.)
   - Configurar inyección de dependencias

3. **Implementar validaciones**:
   - Validar formatos (DNI, Base64, tamaños de archivo)
   - Aplicar reglas de negocio en los servicios

4. **Gestión de errores**:
   - Implementar `@ExceptionHandler` o mecanismo similar
   - Mapear excepciones a códigos de estado HTTP

5. **Configuración**:
   - Crear `application.properties` o `application.yml`
   - Configurar URLs de Alfresco, credenciales, timeouts
   - Configurar logging y trazabilidad

6. **Testing**:
   - Tests unitarios para servicios y mappers
   - Tests de integración con Alfresco (mock o real)
   - Tests de contrato con consumidores

---

## Autor

Generado según especificación PDF: **Microservicio MsDatosRepositorioDocumental V1.3**  
Fecha de generación: 02/12/2025  
Arquitectura: **Hexagonal + DDD**  
Tipo: **MsData (Microservicio de Datos)**
