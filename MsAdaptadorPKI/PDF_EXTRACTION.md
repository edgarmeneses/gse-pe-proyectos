# Extracción del PDF: Microservicio MsAdaptadorPKI v1.0

## Información General
- **Nombre del Microservicio**: MsAdaptadorPKI
- **Tipo**: Microservicio de Dominio (MsDominio)
- **Contexto**: Adaptador para integración con PKI (Public Key Infrastructure)
- **Versión API**: v1.0
- **Paquete Base**: pe.gob.sunat.sol.adaptadorpki

## Análisis del Tipo de Microservicio
Según el nombre "MsAdaptadorPKI", este NO es un "MsDominio" ni "MsData" tradicional.
Es un adaptador/integrador, por lo que:
- NO define RepositoryPort (no es MsData)
- Puede tener puertos de salida hacia sistemas PKI externos
- Enfoque en operaciones de firma, validación y certificados

## Endpoints Documentados

### 1. POST /api/v1/firma/firmar
**Descripción**: Firma un documento digital
**Request**:
```json
{
  "documento": "string (base64)",
  "certificado": "string",
  "password": "string",
  "tipoFirma": "string"
}
```
**Response**:
```json
{
  "documentoFirmado": "string (base64)",
  "fechaFirma": "datetime",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```
**Status Codes**:
- 200: OK
- 400: Bad Request
- 500: Internal Server Error

### 2. POST /api/v1/certificado/validar
**Descripción**: Valida un certificado digital
**Request**:
```json
{
  "certificado": "string",
  "fechaValidacion": "datetime"
}
```
**Response**:
```json
{
  "esValido": "boolean",
  "fechaExpiracion": "datetime",
  "emisor": "string",
  "titular": "string",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```
**Status Codes**:
- 200: OK
- 400: Bad Request
- 500: Internal Server Error

### 3. GET /api/v1/certificado/{numCertificado}
**Descripción**: Consulta información de un certificado
**Path Params**: numCertificado (string)
**Response**:
```json
{
  "numeroCertificado": "string",
  "titular": "string",
  "emisor": "string",
  "fechaEmision": "datetime",
  "fechaExpiracion": "datetime",
  "estado": "string",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```
**Status Codes**:
- 200: OK
- 404: Not Found
- 500: Internal Server Error

## Entidades del Dominio

### Firma
- documento: String (base64)
- certificado: String
- password: String
- tipoFirma: String
- documentoFirmado: String (base64)
- fechaFirma: LocalDateTime
- codigoRespuesta: String
- mensaje: String

### Certificado
- numeroCertificado: String
- certificado: String (contenido)
- titular: String
- emisor: String
- fechaEmision: LocalDateTime
- fechaExpiracion: LocalDateTime
- fechaValidacion: LocalDateTime
- estado: String
- esValido: Boolean
- codigoRespuesta: String
- mensaje: String

## Operaciones Identificadas

1. **FirmarDocumento** (POST /api/v1/firma/firmar)
2. **ValidarCertificado** (POST /api/v1/certificado/validar)
3. **ConsultarCertificado** (GET /api/v1/certificado/{numCertificado})

## Integraciones Externas
- Sistema PKI externo (puerto de salida sin protocolo definido)

## Notas
- No se define protocolo de conexión con PKI
- Solo interfaces y adaptadores sin implementación tecnológica
- Código Java puro sin frameworks
