# Extracción del PDF - Microservicio MsDatosSolicitudes V1.3

## Información General
- **Nombre**: MsDatosSolicitudes
- **Versión**: V1.3
- **Tipo**: MsData (microservicio de datos)
- **Paquete base**: pe.gob.pj.solicitudes.data
- **Contexto**: Microservicio de datos para la gestión de solicitudes

## Endpoints Identificados

### 3.1.1 Endpoint: Crear Solicitud
- **Método**: POST
- **Ruta**: /solicitudes
- **Parámetros de Entrada**:
  - Body: SolicitudRequest (JSON)
- **Parámetros de Respuesta**:
  - SolicitudResponse (JSON)
- **Status Codes**: 200 (OK), 400 (Bad Request), 500 (Internal Server Error)

### 3.1.2 Endpoint: Listar Solicitudes
- **Método**: GET
- **Ruta**: /solicitudes
- **Parámetros de Entrada**:
  - Query parameters (filtros)
- **Parámetros de Respuesta**:
  - Lista de SolicitudResponse
- **Status Codes**: 200 (OK), 500 (Internal Server Error)

### 3.1.3 Endpoint: Consultar Solicitud
- **Método**: GET
- **Ruta**: /solicitudes/{id}
- **Parámetros de Entrada**:
  - Path: id (identificador de solicitud)
- **Parámetros de Respuesta**:
  - SolicitudResponse
- **Status Codes**: 200 (OK), 404 (Not Found), 500 (Internal Server Error)

### 3.1.4 Endpoint: Actualizar Solicitud Completa
- **Método**: PUT
- **Ruta**: /solicitudes/{id}
- **Parámetros de Entrada**:
  - Path: id
  - Body: SolicitudRequest (JSON)
- **Parámetros de Respuesta**:
  - SolicitudResponse
- **Status Codes**: 200 (OK), 404 (Not Found), 400 (Bad Request), 500 (Internal Server Error)

### 3.1.5 Endpoint: Actualizar Parcialmente Solicitud
- **Método**: PATCH
- **Ruta**: /solicitudes/{id}
- **Parámetros de Entrada**:
  - Path: id
  - Body: Campos parciales de SolicitudRequest
- **Parámetros de Respuesta**:
  - SolicitudResponse
- **Status Codes**: 200 (OK), 404 (Not Found), 400 (Bad Request), 500 (Internal Server Error)

### 3.1.6 Endpoint: Crear Diligencia
- **Método**: POST
- **Ruta**: /solicitudes/{id}/diligencias
- **Parámetros de Entrada**:
  - Path: id (solicitud)
  - Body: DiligenciaRequest (JSON)
- **Parámetros de Respuesta**:
  - DiligenciaResponse
- **Status Codes**: 200 (OK), 404 (Not Found), 400 (Bad Request), 500 (Internal Server Error)

### 3.1.7 Endpoint: Verificar Duplicados
- **Método**: POST
- **Ruta**: /solicitudes/verificar-duplicados
- **Parámetros de Entrada**:
  - Body: CriteriosDuplicadosRequest
- **Parámetros de Respuesta**:
  - VerificacionDuplicadosResponse
- **Status Codes**: 200 (OK), 400 (Bad Request), 500 (Internal Server Error)

### 3.1.8 Endpoint: Ver Trazabilidad
- **Método**: GET
- **Ruta**: /solicitudes/{id}/trazabilidad
- **Parámetros de Entrada**:
  - Path: id (solicitud)
- **Parámetros de Respuesta**:
  - Lista de TrazabilidadResponse
- **Status Codes**: 200 (OK), 404 (Not Found), 500 (Internal Server Error)

## Entidades del Dominio (inferidas del PDF)

### Solicitud
- id: Long
- numeroSolicitud: String
- fechaSolicitud: LocalDateTime
- tipoSolicitud: String
- estado: String
- solicitante: String
- descripcion: String
- diligencias: List<Diligencia>

### Diligencia
- id: Long
- numeroDigencia: String
- fechaDiligencia: LocalDateTime
- tipoDiligencia: String
- estado: String
- descripcion: String
- solicitudId: Long

### Trazabilidad
- id: Long
- solicitudId: Long
- fecha: LocalDateTime
- accion: String
- usuario: String
- detalle: String

## Notas
- Este es un MsData, por lo tanto DEBE definir RepositoryPort y RepositoryAdapter
- Se deben crear Entities (POJOs sin anotaciones)
- NO se define protocolo de conexión
- Todos los DTOs serán records de Java
