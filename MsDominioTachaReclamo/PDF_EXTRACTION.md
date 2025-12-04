# Análisis del PDF: Microservicio MsDominioTachaReclamo V1.0

## Información General
- **Nombre**: MsDominioTachaReclamo
- **Versión API**: V1.0
- **Tipo**: MsDominio (Microservicio de Dominio)
- **Paquete Base**: pe.gob.onpe.dominio.tachareclamo
- **Contexto**: Gestión de reglas de negocio para Tachas y Reclamos Electorales

## Endpoints Identificados (del PDF)

### 1. Endpoint: Registrar Ciudadanos
- **Método**: POST
- **Ruta**: /ciudadanos
- **Request**: CiudadanoRequestDto
  - dni: String
  - nombres: String
  - apellidoPaterno: String
  - apellidoMaterno: String
  - fechaNacimiento: LocalDate
  - direccion: String
- **Response**: CiudadanoResponseDto
  - id: Long
  - dni: String
  - nombreCompleto: String
  - fechaRegistro: LocalDateTime
  - statusCode: String
  - message: String
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 2. Endpoint: Registrar Tachas Reclamos
- **Método**: POST
- **Ruta**: /tacha-reclamo
- **Request**: TachaReclamoRequestDto
  - tipo: String (TACHA, RECLAMO)
  - numeroExpediente: String
  - solicitante: String
  - descripcion: String
  - sustento: String
  - documentos: List<String>
- **Response**: TachaReclamoResponseDto
  - id: Long
  - numeroExpediente: String
  - tipo: String
  - estado: String
  - fechaRegistro: LocalDateTime
  - statusCode: String
  - message: String
- **Status Codes**: 201 (Created), 400 (Bad Request), 500 (Internal Server Error)

### 3. Endpoint: Validar Sustento
- **Método**: POST
- **Ruta**: /tacha-reclamo/validar-sustento
- **Request**: ValidarSustentoRequestDto
  - tachaReclamoId: Long
  - sustento: String
  - documentos: List<String>
- **Response**: ValidarSustentoResponseDto
  - tachaReclamoId: Long
  - esValido: Boolean
  - observaciones: String
  - fechaValidacion: LocalDateTime
  - statusCode: String
  - message: String
- **Status Codes**: 200 (OK), 400 (Bad Request), 404 (Not Found), 500 (Internal Server Error)

### 4. Endpoint: Derivar Tacha Reclamo
- **Método**: PUT
- **Ruta**: /tacha-reclamo/{id}/derivar
- **Path Params**: id (Long)
- **Request**: DerivarTachaReclamoRequestDto
  - areaDestino: String
  - responsable: String
  - observaciones: String
- **Response**: DerivarTachaReclamoResponseDto
  - id: Long
  - numeroExpediente: String
  - estadoAnterior: String
  - estadoActual: String
  - areaDestino: String
  - fechaDerivacion: LocalDateTime
  - statusCode: String
  - message: String
- **Status Codes**: 200 (OK), 400 (Bad Request), 404 (Not Found), 500 (Internal Server Error)

## Entidades del Dominio

### TachaReclamo
- id: Long
- tipo: String
- numeroExpediente: String
- fechaRegistro: LocalDateTime
- estado: String
- descripcion: String
- solicitante: String
- sustento: String
- documentos: List<String>
- areaActual: String
- responsableActual: String

### Ciudadano
- id: Long
- dni: String
- nombres: String
- apellidoPaterno: String
- apellidoMaterno: String
- fechaNacimiento: LocalDate
- direccion: String
- fechaRegistro: LocalDateTime

### ValidacionSustento
- id: Long
- tachaReclamoId: Long
- esValido: Boolean
- observaciones: String
- fechaValidacion: LocalDateTime
- validadoPor: String

### Derivacion
- id: Long
- tachaReclamoId: Long
- areaOrigen: String
- areaDestino: String
- responsable: String
- observaciones: String
- fechaDerivacion: LocalDateTime

## Reglas de Negocio Identificadas

1. **Registrar Ciudadanos**:
   - DNI debe ser válido (8 dígitos)
   - Nombres y apellidos son obligatorios
   - Fecha de nacimiento debe ser anterior a hoy
   - No permitir duplicados de DNI

2. **Registrar Tachas/Reclamos**:
   - Tipo debe ser "TACHA" o "RECLAMO"
   - Generar número de expediente automático
   - Estado inicial debe ser "REGISTRADO"
   - Sustento y descripción son obligatorios

3. **Validar Sustento**:
   - Solo se pueden validar tachas/reclamos en estado "REGISTRADO"
   - La validación debe tener al menos una observación
   - Al validar, cambiar estado a "VALIDADO" o "RECHAZADO"

4. **Derivar Tacha/Reclamo**:
   - Solo se pueden derivar tachas/reclamos validadas
   - Área destino debe ser válida
   - Registrar responsable de la derivación
   - Cambiar estado a "DERIVADO"

## Integraciones con MsDatosElectoral

Este microservicio de dominio requiere las siguientes operaciones de MsDatosElectoral:

1. **CrearTachaReclamo**: Para persistir las tachas/reclamos registradas
2. **ActualizarTachaReclamo**: Para actualizar estado, validaciones y derivaciones

## Mapeo de Tipos

- String → String
- Long → Long
- Boolean → Boolean
- LocalDate → LocalDate
- LocalDateTime → LocalDateTime
- List<String> → List<String>
