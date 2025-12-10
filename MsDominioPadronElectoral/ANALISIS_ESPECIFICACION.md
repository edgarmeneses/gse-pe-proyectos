# Análisis de Especificación - MsDominioPadronElectoral

## Información General

- **Nombre del Microservicio**: MsDominioPadronElectoral
- **Versión del Documento**: 1.1
- **Fecha**: 03/12/2025
- **Tipo**: Microservicio de Dominio (MsDominio)
- **Versión API**: v1
- **Paquete Base**: pe.gob.reniec.padronelectoral
- **Contexto**: Gestión integral del Padrón Electoral en Perú - generación, mantenimiento y servicio de listados de personas habilitadas para votar

## Endpoints Identificados

### 1. GenerarPadronElectoral (POST)
- **Path**: `/api/v1/electoral/MsDominioPadronElectoral`
- **Método**: POST
- **Headers**: Content-Type, Authorization (Bearer JWT), X-Correlation-ID (UUID), X-Office-Code (String)
- **Request Body**:
  - tipoPadron: String (obligatorio, 1-20 chars)
  - circunscripcion: Object (obligatorio)
    - estructura: Object
      - departamento: String (obligatorio, 1-20 chars)
      - provincia: String (obligatorio, 1-20 chars)
      - distrito: String (obligatorio, 1-20 chars)
- **Response** (201):
  - idPadron: String
  - listaCiudadanos: Array[Object]
    - nombre: String
    - documento: String
    - direccion: String
  - tipoPadron: String
  - fechaCreacion: String (ISO 8601: YYYY-MM-DDThh:mm:ssZ)
- **Status Codes**: 201, 400, 401, 403, 404, 409, 422, 429, 500, 502, 503

### 2. ActualizarPadronElectoral (PUT)
- **Path**: `/api/v1/electoral/MsDominioPadronElectoral/{id}`
- **Método**: PUT
- **Headers**: Content-Type, Authorization (Bearer JWT), X-Correlation-ID (UUID), X-Office-Code (String)
- **Path Parameters**: id (String, obligatorio)
- **Request Body**:
  - usuarioResponsableId: String (obligatorio, 1-20 chars)
  - tipoPadron: String (obligatorio, 1-20 chars)
  - informeFinalVerificacionDomicilioId: String (obligatorio, 1-20 chars)
  - tipoVerificacion: String (campo presente pero sin especificación de obligatoriedad)
- **Response** (200):
  - idPadron: String
  - listaCiudadanos: Array[Object]
    - nombre: String
    - documento: String
    - direccion: String
  - fechaCreacion: String (ISO 8601)
  - fechaActualizacion: String (ISO 8601)
- **Status Codes**: 200, 400, 401, 403, 404, 422, 429, 500, 502, 503

### 3. ObtenerPadronesElectorales (GET - Listar)
- **Path**: `/api/v1/electoral/MsDominioPadronElectoral`
- **Método**: GET
- **Headers**: Content-Type, Authorization (Bearer JWT), X-Correlation-ID (UUID), X-Office-Code (String)
- **Query Parameters**:
  - texto: String (opcional, 1-20 chars)
  - fecha: String (opcional, 1-20 chars)
  - queryParam3: String (opcional, 1-20 chars) [filterParam3 en tabla]
  - page: Integer (obligatorio, mín 1)
  - size: Integer (obligatorio, mín 1)
- **Response** (200):
  - number: Integer (página actual)
  - size: Integer (tamaño página)
  - totalElements: Long (total elementos)
  - totalPages: Integer (total páginas)
  - hasNext: Boolean (indica si hay más páginas)
  - contenido: Array[Object]
    - idPadron: String
    - tipoPadron: String
    - circunscripcion: String
    - tipoProceso: String
    - fechaCreacion: String (ISO 8601)
    - cantidadCiudadanos: Integer
- **Status Codes**: 200, 400, 401, 403, 404, 429, 500, 502, 503

### 4. ObtenerPadronElectoral (GET - Consultar por ID)
- **Path**: `/api/v1/electoral/MsDominioPadronElectoral` (debería incluir /{id} según especificación)
- **Método**: GET
- **Headers**: Content-Type, Authorization (Bearer JWT), X-Correlation-ID (UUID), X-Office-Code (String)
- **Query/Path Parameters**:
  - id: String (obligatorio) [Padron.id]
  - page: Integer (obligatorio, mín 1)
  - size: Integer (obligatorio, mín 1)
- **Response** (200):
  - padron: Object
    - fechaCreacion: String (ISO 8601)
    - actualizacionPadron: Array[Object]
      - fechaActualizacion: String (ISO 8601)
      - usuarioResponsableId: String
      - informeFinalVerificacionDomicilioId: String
    - tipoPadron: String
    - tipoProceso: String
  - number: Integer
  - size: Integer
  - totalElements: Long
  - totalPages: Integer
  - hasNext: Boolean
  - listaCiudadanos: Array[Object]
    - nombre: String
    - documento: String
    - direccion: String
- **Status Codes**: 200, 400, 401, 403, 404, 429, 500, 502, 503

## Modelo de Error Estándar

Todos los endpoints comparten el mismo modelo de error:
```
error: Object
  - tipo: String (path de la ruta con error)
  - titulo: String (título del error)
  - estado: Integer (número del estado de error)
  - errores: Array[Object]
    - detalleError: String
```

## Entidades del Dominio

### PadronElectoral (Aggregate Root)
- idPadron: String
- tipoPadron: String
- tipoProceso: String
- fechaCreacion: LocalDateTime (ISO 8601)
- fechaActualizacion: LocalDateTime (ISO 8601, opcional)
- circunscripcion: Circunscripcion
- listaCiudadanos: List<Ciudadano>
- actualizacionesPadron: List<ActualizacionPadron>
- usuarioResponsableId: String (para actualización)
- informeFinalVerificacionDomicilioId: String (para actualización)
- tipoVerificacion: String (para actualización)
- cantidadCiudadanos: Integer (para listar)

### Circunscripcion (Value Object)
- departamento: String
- provincia: String
- distrito: String

### Ciudadano (Value Object)
- nombre: String
- documento: String
- direccion: String

### ActualizacionPadron (Value Object)
- fechaActualizacion: LocalDateTime
- usuarioResponsableId: String
- informeFinalVerificacionDomicilioId: String

### PaginatedResult<T> (Generic Value Object)
- number: Integer
- size: Integer
- totalElements: Long
- totalPages: Integer
- hasNext: Boolean
- contenido: List<T>

### ErrorResponse (Value Object)
- tipo: String
- titulo: String
- estado: Integer
- errores: List<ErrorDetail>

### ErrorDetail (Value Object)
- detalleError: String

## Mapeo de Tipos

- string → String
- integer → Integer
- long → Long
- array/list → List<T>
- date ISO 8601 (YYYY-MM-DDThh:mm:ssZ) → LocalDateTime
- boolean → Boolean
- Object → Clase POJO

## Operaciones del Puerto de Salida hacia MsDataPadronElectoral

Según el análisis de los endpoints, el puerto de salida unificado debe soportar:

1. **crearPadron**: Crea un nuevo padrón con circunscripción y retorna padrón generado con lista de ciudadanos
2. **actualizarPadron**: Actualiza un padrón existente por ID con información de verificación
3. **listarPadrones**: Lista padrones con filtros (texto, fecha, queryParam3) y paginación
4. **consultarPadronPorId**: Consulta un padrón específico con detalle de ciudadanos paginados y actualizaciones

## Notas y Aclaraciones

1. **Tipo de Microservicio**: Es un MsDominio, por tanto NO define RepositoryPort
2. **Integración con MsData**: Se integra con MsDataPadronElectoral mediante puerto de salida unificado
3. **Sin Tecnología**: No se define protocolo (HTTP/SOAP/colas) - solo interfaces y adaptadores
4. **Paginación**: Los endpoints de consulta y listado incluyen parámetros de paginación
5. **Ambigüedad detectada**: El endpoint ObtenerPadronElectoral no especifica /{id} en path pero sí requiere id como parámetro
6. **Campo tipoVerificacion**: Aparece en request de actualización pero sin especificación completa en tabla de parámetros
