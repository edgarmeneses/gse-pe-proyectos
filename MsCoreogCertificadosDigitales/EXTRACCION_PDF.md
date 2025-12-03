# Extracción de Información - Microservicio MsCoreogCertificadosDigitales V1.0

## Nombre del Microservicio
MsCoreogCertificadosDigitales

## Tipo de Microservicio
Microservicio de **Coreografía** (MsDominio) - Coordina el flujo de emisión de Certificados Digitales DNIe

## Contexto de Negocio
Gestión y emisión de Certificados Digitales DNIe. Actúa como intermediario entre SIIRC y MsAdaptadorPKI.

## Versión API
V1.0

## Paquete Base Java
`pe.gob.sunat.gse.coreog.certificadosdigitales`

## Endpoints Identificados

### Endpoint: Obtener Certificado Digital

#### Información General
- **Nombre**: Obtener Certificado Digital
- **Método HTTP**: POST
- **Ruta**: `/api/v1/coreog/MsCoreogCertificadosDigitales/obtener-certificado-digital`
- **API Gateway**: Interno
- **Protocolo**: REST/HTTP

#### Headers Requeridos
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Request-ID`: UUID de la solicitud
- `X-Office-Code`: Código de oficina
- `X-Device-ID`: ID del dispositivo
- `X-Channel`: Canal de origen

#### Request Body
Estructura con 4 objetos principales:
1. **solicitud**: numeroDocumento, tipoDocumento, codigoSolicitudTramite, numeroTramite
2. **ciudadano**: nombres, apellidos, fechaNacimiento, sexo, correo, ubicación
3. **configuracionCertificados**: tipoCertificados[], vigenciaAnios, usoExtendido, nivelSeguridad
4. **metadatos**: oficinaOrigen, usuarioRegistrador, ipOrigen, timestampSolicitud

#### Response Body (201 Created)
Estructura completa:
```json
{
  "success": true,
  "data": {
    "transaccion": {...},
    "ciudadano": {...},
    "certificados": [{...}],
    "pasosProceso": {
      "paso1GeneracionClaves": {...},
      "paso2EmisionCertificado": {...}
    },
    "auditoria": {...}
  },
  "metadata": {
    "timestamp": "...",
    "correlationId": "...",
    "tiempoRespuesta": "..."
  }
}
```

#### Status Codes
- **201**: Created - Certificados emitidos exitosamente
- **400**: Bad Request - Parámetros inválidos
- **401**: Unauthorized - Token JWT inválido
- **403**: Forbidden - Sin permisos
- **404**: Not Found - Ciudadano no encontrado
- **409**: Conflict - Solicitud ya en proceso
- **422**: Unprocessable Entity - No cumple requisitos
- **429**: Too Many Requests - Rate limit excedido
- **500**: Internal Server Error - Error interno
- **502**: Bad Gateway - Error con MsAdaptadorPKI
- **503**: Service Unavailable - PKI no disponible
- **504**: Gateway Timeout - Timeout con PKI

## Entidades del Dominio

### CertificadoDigital
Campos según el response:
- tipoCertificado (String)
- certificadoId (String)
- numeroSerie (String)
- fechaEmision (String ISO 8601)
- fechaVencimiento (String ISO 8601)
- vigenciaAnios (Integer)
- estadoCertificado (String)
- algoritmoFirma (String)
- longitudClave (Integer)
- subjectDN (String)
- huellaCertificado (String)
- certificadoBase64 (String)

## Arquitectura
El microservicio ejecuta un flujo de **dos pasos obligatorios** consumiendo MsAdaptadorPKI:
1. **Paso 1**: Generar Números de Solicitud PKI
2. **Paso 2**: Emitir Certificado Digital DNIe

## Notas
- Información completamente extraída del PDF V1.0 (24/11/2025)
- El microservicio realiza transformaciones de datos documentadas en Anexo 1
- Actúa como coreógrafo entre SIIRC y MsAdaptadorPKI
