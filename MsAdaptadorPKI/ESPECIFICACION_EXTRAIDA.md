# Especificación Extraída: MsAdaptadorPKI V1.0

## 1. INFORMACIÓN GENERAL

### Nombre del Microservicio
**MsAdaptadorPKI** (Microservicio Adaptador PKI)

### Contexto de Negocio
- Componente adaptador dentro de la plataforma SIIRC de RENIEC
- Actúa como fachada/puente entre microservicios internos y el servicio PKI externo de RENIEC
- Parte de la iniciativa de transformación digital DNI Electrónico (DNIe) de Perú
- Abstrae los detalles del servicio PKI de los microservicios de dominio

### Tipo de Microservicio
**MsDominio** - NO define Repository, se integra con servicios externos a través de puertos de salida.

### Paquete Base Java
`pe.gob.reniec.siirc.msadaptadorpki`

### Versión del API
**v1**

---

## 2. ENDPOINTS

### 2.1 Generar Certificado Digital DNIe

**Endpoint**: `POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarCertificadoDigitalDniE`

**Descripción**: Genera certificados digitales para autenticación, firma y cifrado del DNIe.

**Headers**:
- `Authorization`: Bearer {token} (JWT)
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Request-ID`: UUID único de la petición
- `X-Office-Code`: Código de la oficina (5 caracteres)
- `X-PKI-Transaction-ID`: ID de transacción PKI

**Request Body**:
```json
{
  "numeroCertificados": "string (10 caracteres)",
  "certificadoAutenticacion": {
    "numeroSolicitud": "string (10 caracteres)",
    "numeroDni": "string (8 dígitos)",
    "tipoDocumento": "string (ej: DNI)",
    "apellidoPaterno": "string",
    "apellidoMaterno": "string",
    "nombres": "string",
    "fechaNacimiento": "string (formato: dd/MM/yyyy)",
    "codigoOficina": "string (5 caracteres)",
    "numeroSerie": "string",
    "fechaEmision": "string (formato: dd/MM/yyyy HH:mm:ss)",
    "fechaExpiracion": "string (formato: dd/MM/yyyy HH:mm:ss)",
    "estadoCertificado": "string (VIGENTE, REVOCADO, EXPIRADO)",
    "motivoRevocacion": "string (opcional)",
    "publicKey": "string (Base64)",
    "certificadoPEM": "string (formato PEM)"
  },
  "certificadoFirma": {
    // misma estructura que certificadoAutenticacion
  },
  "certificadoCifrado": {
    // misma estructura que certificadoAutenticacion
  },
  "datosAdicionales": {
    "emailCiudadano": "string",
    "telefonoCiudadano": "string",
    "direccionCiudadano": "string",
    "usuarioRegistro": "string",
    "observaciones": "string"
  }
}
```

**Response Success (201)**:
```json
{
  "resultado": "EXITOSO",
  "mensaje": "Certificados generados exitosamente",
  "certificados": [
    {
      "tipo": "AUTENTICACION | FIRMA | CIFRADO",
      "numeroSolicitud": "string",
      "numeroCertificado": "string",
      "estadoCertificado": "VIGENTE",
      "fechaEmision": "string (dd/MM/yyyy HH:mm:ss)",
      "fechaExpiracion": "string (dd/MM/yyyy HH:mm:ss)",
      "certificadoPEM": "string"
    }
  ],
  "pkiExterno": {
    "codigoRespuesta": "string",
    "mensajeRespuesta": "string",
    "idTransaccionPKI": "string",
    "timestampPKI": "string (ISO-8601)"
  },
  "metadata": {
    "correlationId": "string",
    "requestId": "string",
    "timestamp": "string (ISO-8601)",
    "version": "v1"
  }
}
```

**Status Codes**:
- 201: Certificados generados exitosamente
- 400: Datos de entrada inválidos
- 401: No autorizado (token inválido)
- 403: Prohibido (permisos insuficientes)
- 404: Ciudadano no encontrado en APD
- 409: Conflicto (certificado ya existe)
- 422: Error de validación de negocio
- 429: Too Many Requests (rate limiting)
- 500: Error interno del servidor
- 502: Error en servicio PKI externo
- 503: Servicio no disponible
- 504: Timeout (> 30 segundos)

---

### 2.2 Generar Números de Solicitud

**Endpoint**: `POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarNumerosSolicitud2`

**Descripción**: Genera números de solicitud únicos para los tres tipos de certificados.

**Headers**:
- `Authorization`: Bearer {token}
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad
- `X-Office-Code`: Código de la oficina (5 caracteres)

**Request Body**:
```json
{
  "dni": "string (8 dígitos, requerido)",
  "nombres": "string (max 100, requerido)",
  "apellidoPaterno": "string (max 50, requerido)",
  "apellidoMaterno": "string (max 50, requerido)",
  "email": "string (formato email, requerido)",
  "telefono": "string (max 15)",
  "direccion": "string (max 200)",
  "codigoOficina": "string (5 caracteres, requerido)",
  "tipoDocumento": "string (default: DNI)",
  "fechaNacimiento": "string (formato: dd/MM/yyyy)",
  "lugarNacimiento": "string",
  "nacionalidad": "string (default: PERUANA)",
  "sexo": "string (M/F)",
  "estadoCivil": "string",
  "observaciones": "string"
}
```

**Response Success (201)**:
```json
{
  "resultado": "EXITOSO",
  "mensaje": "Números de solicitud generados exitosamente",
  "solicitudes": {
    "numeroSolicitudAutenticacion": "string (10 caracteres)",
    "numeroSolicitudFirma": "string (10 caracteres)",
    "numeroSolicitudCifrado": "string (10 caracteres)"
  },
  "metadata": {
    "correlationId": "string",
    "requestId": "string",
    "timestamp": "string (ISO-8601)",
    "version": "v1"
  }
}
```

**Status Codes**:
- 201: Números generados exitosamente
- 400: Datos de entrada inválidos
- 401: No autorizado
- 403: Prohibido
- 422: Error de validación de negocio
- 429: Too Many Requests
- 500: Error interno
- 502: Error en servicio PKI externo
- 503: Servicio no disponible
- 504: Timeout

---

## 3. ENTIDADES DEL DOMINIO

### 3.1 CertificadoDigital (Aggregate Root)
```
- tipo: String (AUTENTICACION, FIRMA, CIFRADO)
- numeroSolicitud: String (10 caracteres)
- numeroCertificado: String (10 caracteres)
- numeroDni: String (8 dígitos)
- tipoDocumento: String
- apellidoPaterno: String
- apellidoMaterno: String
- nombres: String
- fechaNacimiento: LocalDate
- codigoOficina: String (5 caracteres)
- numeroSerie: String
- fechaEmision: LocalDateTime
- fechaExpiracion: LocalDateTime
- estadoCertificado: String (VIGENTE, REVOCADO, EXPIRADO)
- motivoRevocacion: String (opcional)
- publicKey: String (Base64)
- certificadoPEM: String
```

### 3.2 SolicitudCertificado
```
- numeroCertificados: String (10 caracteres)
- certificadoAutenticacion: CertificadoDigital
- certificadoFirma: CertificadoDigital
- certificadoCifrado: CertificadoDigital
- datosAdicionales: DatosAdicionales
```

### 3.3 DatosAdicionales
```
- emailCiudadano: String
- telefonoCiudadano: String
- direccionCiudadano: String
- usuarioRegistro: String
- observaciones: String
```

### 3.4 SolicitudNumerosSecuencia
```
- dni: String (8 dígitos)
- nombres: String (max 100)
- apellidoPaterno: String (max 50)
- apellidoMaterno: String (max 50)
- email: String
- telefono: String (max 15)
- direccion: String (max 200)
- codigoOficina: String (5 caracteres)
- tipoDocumento: String
- fechaNacimiento: LocalDate
- lugarNacimiento: String
- nacionalidad: String
- sexo: String (M/F)
- estadoCivil: String
- observaciones: String
```

### 3.5 RespuestaPKI
```
- codigoRespuesta: String
- mensajeRespuesta: String
- idTransaccionPKI: String
- timestampPKI: LocalDateTime
```

### 3.6 NumerosSolicitud
```
- numeroSolicitudAutenticacion: String (10 caracteres)
- numeroSolicitudFirma: String (10 caracteres)
- numeroSolicitudCifrado: String (10 caracteres)
```

### 3.7 MetadataRespuesta
```
- correlationId: String
- requestId: String
- timestamp: LocalDateTime
- version: String
```

### 3.8 ErrorResponse
```
- tipo: String
- titulo: String
- estado: Integer
- detalle: String
- instancia: String
- errores: List<DetalleError>
- timestamp: LocalDateTime
- correlationId: String
```

### 3.9 DetalleError
```
- campo: String
- mensaje: String
- codigo: String
```

---

## 4. REGLAS DE NEGOCIO

### Validaciones
1. **Autenticación obligatoria**: Todos los endpoints requieren JWT válido
2. **Unicidad de certificados**: No se pueden generar certificados duplicados para un ciudadano/tipo
3. **Validación de existencia**: El ciudadano debe existir en APD antes de generar certificados
4. **Formato DNI**: Debe ser exactamente 8 dígitos numéricos
5. **Formato email**: Debe cumplir formato estándar RFC 5322
6. **Longitud campos**: Respetar longitudes máximas definidas
7. **Fechas**: Formato dd/MM/yyyy para fechas, dd/MM/yyyy HH:mm:ss para timestamps
8. **Códigos de oficina**: Exactamente 5 caracteres

### Políticas de Timeout
- Timeout máximo: 30 segundos
- Si excede, retornar 504 Gateway Timeout

### Rate Limiting
- Implementar límites de peticiones por minuto
- Retornar 429 cuando se exceda

### Circuit Breaker
- Aplicar patrón circuit breaker para llamadas al servicio PKI externo
- Evitar cascada de fallos

### Trazabilidad
- Todos los endpoints requieren `X-Correlation-ID` y `X-Request-ID`
- Propagar estos IDs a través de toda la cadena de llamadas

---

## 5. MAPEO DE TIPOS

| Tipo en PDF | Tipo Java |
|-------------|-----------|
| string | String |
| integer/int | Integer |
| long | Long |
| number/decimal | Double |
| boolean | Boolean |
| date (dd/MM/yyyy) | LocalDate |
| datetime/timestamp | LocalDateTime |
| array | List<T> |

---

## 6. ESTRUCTURA DE ERRORES

### Error Estándar
```json
{
  "tipo": "string (URI que identifica el tipo de error)",
  "titulo": "string (resumen corto)",
  "estado": "integer (código HTTP)",
  "detalle": "string (explicación detallada)",
  "instancia": "string (URI de la petición)",
  "errores": [
    {
      "campo": "string",
      "mensaje": "string",
      "codigo": "string"
    }
  ],
  "timestamp": "string (ISO-8601)",
  "correlationId": "string"
}
```

---

## 7. CONSIDERACIONES ARQUITECTÓNICAS

### Tipo de Microservicio
**MsDominio** - Por lo tanto:
- NO se define `RepositoryPort`
- Se define `PKIDataPort` para integración con servicio PKI externo
- Se implementa `PKIDataAdapter` que implementa `PKIDataPort`
- No se asume protocolo de conexión (HTTP/SOAP/colas)

### Puertos de Salida
- `PKIDataPort`: Interface para operaciones contra el servicio PKI externo
  - generarCertificados()
  - generarNumerosSolicitud()

### Casos de Uso Identificados
1. `GenerarCertificadoDigitalDnieUseCase`
2. `GenerarNumerosSolicitudUseCase`

---

## 8. LIMITACIONES Y ACLARACIONES

- Sin frameworks: No Spring, JAX-RS, JPA
- Sin anotaciones tecnológicas
- Código Java puro (POJOs e interfaces)
- Sin protocolo definido para conexiones externas
- Solo interfaces y clases con implementaciones stub
- Los adaptadores lanzan `UnsupportedOperationException` por defecto
