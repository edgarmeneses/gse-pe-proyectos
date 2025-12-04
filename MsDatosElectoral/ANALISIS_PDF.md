# Análisis del PDF: Microservicio MsDatosElectoral V1.3

## Información General
- **Nombre**: MsDatosElectoral
- **Versión API**: V1.3
- **Tipo**: MsData (Microservicio de Datos)
- **Paquete Base**: pe.gob.onpe.datos.electoral
- **Contexto**: Gestión de datos electorales (impugnaciones, visitas, informes, tachas, reclamos, paquetes electorales)

## Endpoints Identificados

### 1. Endpoint: ConsultarImpugnacion
- **Método**: GET
- **Ruta**: /impugnacion/{id}
- **Path Params**: id (Long)
- **Response**: ImpugnacionResponseDto
- **Status Codes**: 200 (OK), 404 (Not Found), 500 (Internal Server Error)

### 2. Endpoint: ListarImpugnaciones
- **Método**: GET
- **Ruta**: /impugnaciones
- **Query Params**: filtros opcionales
- **Response**: List<ImpugnacionResponseDto>
- **Status Codes**: 200 (OK), 500 (Internal Server Error)

### 3. Endpoint: RegistrarVisita
- **Método**: POST
- **Ruta**: /visita
- **Request**: VisitaRequestDto
- **Response**: VisitaResponseDto
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 4. Endpoint: GuardarInformeFinal
- **Método**: POST
- **Ruta**: /informe-final
- **Request**: InformeFinalRequestDto
- **Response**: InformeFinalResponseDto
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 5. Endpoint: RegistrarAnalisis
- **Método**: POST
- **Ruta**: /analisis
- **Request**: AnalisisRequestDto
- **Response**: AnalisisResponseDto
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 6. Endpoint: ConsultarAnalisis
- **Método**: GET
- **Ruta**: /analisis/{id}
- **Path Params**: id (Long)
- **Response**: AnalisisResponseDto
- **Status Codes**: 200 (OK), 404 (Not Found), 500 (Internal Server Error)

### 7. Endpoint: CrearTachaOReclamo
- **Método**: POST
- **Ruta**: /tacha-reclamo
- **Request**: TachaReclamoRequestDto
- **Response**: TachaReclamoResponseDto
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 8. Endpoint: ActualizarTachaOReclamo
- **Método**: PUT
- **Ruta**: /tacha-reclamo/{id}
- **Path Params**: id (Long)
- **Request**: TachaReclamoRequestDto
- **Response**: TachaReclamoResponseDto
- **Status Codes**: 200 (OK), 404 (Not Found), 400 (Bad Request), 500 (Internal Server Error)

### 9. Endpoint: ActualizarPaqueteElectoral
- **Método**: PUT
- **Ruta**: /paquete-electoral/{id}
- **Path Params**: id (Long)
- **Request**: PaqueteElectoralRequestDto
- **Response**: PaqueteElectoralResponseDto
- **Status Codes**: 200 (OK), 404 (Not Found), 400 (Bad Request), 500 (Internal Server Error)

## Entidades del Dominio

### Impugnacion
- id: Long
- numeroImpugnacion: String
- fechaRegistro: LocalDateTime
- estado: String
- descripcion: String
- tipo: String

### Visita
- id: Long
- fechaVisita: LocalDateTime
- lugar: String
- observaciones: String
- responsable: String

### InformeFinal
- id: Long
- numeroInforme: String
- fechaEmision: LocalDateTime
- contenido: String
- conclusiones: String
- estado: String

### Analisis
- id: Long
- tipoAnalisis: String
- fechaAnalisis: LocalDateTime
- resultado: String
- observaciones: String
- estado: String

### TachaReclamo
- id: Long
- tipo: String (TACHA o RECLAMO)
- numeroExpediente: String
- fechaRegistro: LocalDateTime
- estado: String
- descripcion: String
- solicitante: String

### PaqueteElectoral
- id: Long
- numeroPaquete: String
- estado: String
- fechaRecepcion: LocalDateTime
- ubicacion: String
- observaciones: String

## Mapeo de Tipos
- String → String
- Long → Long
- LocalDateTime → LocalDateTime (para fechas con hora)
- LocalDate → LocalDate (para fechas simples)
- Boolean → Boolean
- List<T> → List<T>

## Operaciones por Entidad

### Impugnacion
- Consultar por ID
- Listar

### Visita
- Registrar (Crear)

### InformeFinal
- Guardar (Crear)

### Analisis
- Registrar (Crear)
- Consultar por ID

### TachaReclamo
- Crear
- Actualizar por ID

### PaqueteElectoral
- Actualizar por ID

## Estructura a Generar (MsData)

Como es un **MsData**, debe tener:
- ✅ RepositoryPort (interfaces para cada entidad)
- ✅ RepositoryAdapter (implementaciones sin tecnología)
- ✅ Entities (POJOs sin anotaciones)
- ✅ Puertos de entrada (Use Cases)
- ✅ Servicios de aplicación
- ✅ Adaptadores REST (Controllers, DTOs, Mappers)

## Notas Importantes
- Sin frameworks (no Spring, no JPA, no JAX-RS)
- Solo POJOs, interfaces y clases Java puras
- Sin anotaciones
- Código compilable como Java puro
- Controllers sin anotaciones, solo métodos POJO
