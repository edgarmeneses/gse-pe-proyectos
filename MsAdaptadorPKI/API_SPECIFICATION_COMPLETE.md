# MICROSERVICIO MsAdaptadorPKI - ESPECIFICACIÓN COMPLETA API
**Versión del Documento**: 1.0  
**Fecha de Generación**: 01/12/2025  
**Organización**: RENIEC - Gestión de Seguridad Electrónica

---

## 1. CONTEXTO DEL NEGOCIO

### Organización
El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales.

### Propósito del Microservicio
En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

El **Microservicio Adaptador PKI** es un componente de tipo **Adaptador** dentro de la plataforma SIIRC. Su propósito principal es actuar como una **fachada o puente** entre los microservicios internos que requieren servicios de certificados digitales y el **Servicio Externo de PKI de RENIEC**.

Este diseño es fundamental para abstraer a los microservicios de dominio de cualquier cambio futuro, actualización de protocolos, o migración del servicio PKI subyacente.

---

## 2. INFORMACIÓN GENERAL DE LA API

### 2.1 Nombre del Microservicio
**MsAdaptadorPKI**

### 2.2 Versión de la API
**v1**

### 2.3 Base Path
`/api/v1/certificadosDigitales/MsAdaptadorPKI`

### 2.4 Gateway
**Interno**

### 2.5 Protocolo
**REST/HTTP**

---

## 3. ARQUITECTURA DE MICROSERVICIOS

### 3.1 Justificación de la Arquitectura de Microservicios

La adopción de microservicios para esta solución responde a necesidades técnicas y operativas concretas:

- **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.

- **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.

- **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.

- **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.

- **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

### 3.2 Arquitectura de Referencia

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**: API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer)**: Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer)**: Event Streaming para comunicación asíncrona y conectores a sistemas legados.

---

## 4. CÓDIGOS DE RESPUESTA HTTP ESTÁNDAR

Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP para garantizar consistencia:

| Código | Descripción |
|--------|-------------|
| **200** | OK - Operación completada exitosamente |
| **201** | Created - Recurso creado exitosamente |
| **400** | Bad Request - Parámetros inválidos o datos incompletos |
| **401** | Unauthorized - Token JWT inválido, expirado o ausente |
| **403** | Forbidden - Sin permisos suficientes para ejecutar la operación |
| **404** | Not Found - Recurso no encontrado en el sistema |
| **408** | Request Timeout - Tiempo de espera agotado al conectar |
| **409** | Conflict - Conflicto con el estado actual del recurso |
| **422** | Unprocessable Entity - Datos válidos, pero no procesables por reglas de negocio |
| **429** | Too Many Requests - Límite de rate limit excedido |
| **500** | Internal Server Error - Error interno del servicio (información generalizada al exterior, detalle en logs) |
| **502** | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| **503** | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |
| **504** | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

---

## 5. ENDPOINTS COMPLETOS

---

### 5.1 ENDPOINT 1: Generar Certificado Digital DNIe

#### 5.1.1 Información General

| Atributo | Valor |
|----------|-------|
| **Nombre del Endpoint** | generarCertificadoDigitalDniE |
| **Path Completo** | `/api/v1/certificadosDigitales/MsAdaptadorPKI/generarCertificadoDigitalDniE` |
| **Método HTTP** | `POST` |
| **API Gateway** | Interno |
| **Protocolo** | REST/HTTP |
| **Descripción** | Invoca al método generarCertificadoDigitalDniE del servicio PKI externo de RENIEC (certificadosdnie2 o certificadosdnie3) para solicitar la generación de 2 o 3 certificados digitales para un ciudadano |

---

#### 5.1.2 Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| **Authorization** | String | Sí | Bearer token JWT para autenticación del sistema |
| **Content-Type** | String | Sí | "application/json" |
| **X-Correlation-ID** | UUID | Sí | Identificador único de correlación para trazabilidad distribuida |
| **X-Request-ID** | UUID | Sí | Identificador único de la solicitud |
| **X-Office-Code** | String | Sí | Código de oficina donde se realiza la operación |
| **X-PKI-Transaction-ID** | String | Sí | Identificador de transacción PKI para seguimiento |

---

#### 5.1.3 Request Body - Estructura Completa

```json
{
  "numeroCertificados": 3,
  "certificadoAutenticacion": {
    "caName": "string",
    "certificateProfileName": "string",
    "clearPwd": true,
    "email": "string",
    "endEntityProfileName": "string",
    "keyRecoverable": true,
    "password": "string",
    "sendNotification": true,
    "status": 0,
    "subjectDN": "string",
    "tokenType": "string",
    "username": "string",
    "nuSolicitud": "string",
    "pkcs10Str": "string"
  },
  "certificadoFirma": {
    "caName": "string",
    "certificateProfileName": "string",
    "clearPwd": true,
    "email": "string",
    "endEntityProfileName": "string",
    "keyRecoverable": true,
    "password": "string",
    "sendNotification": true,
    "status": 0,
    "subjectDN": "string",
    "tokenType": "string",
    "username": "string",
    "nuSolicitud": "string",
    "pkcs10Str": "string"
  },
  "certificadoCifrado": {
    "caName": "string",
    "certificateProfileName": "string",
    "clearPwd": true,
    "email": "string",
    "endEntityProfileName": "string",
    "keyRecoverable": true,
    "password": "string",
    "sendNotification": true,
    "status": 0,
    "subjectDN": "string",
    "tokenType": "string",
    "username": "string",
    "nuSolicitud": "string",
    "pkcs10Str": "string"
  },
  "datosAdicionales": {
    "dni": "string",
    "sesionUsuario": "string"
  }
}
```

---

#### 5.1.4 Parámetros de Entrada Detallados

##### 5.1.4.1 Nivel Raíz

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| **numeroCertificados** | Integer | Sí | - | - | Número de certificados a generar (2 o 3) |

##### 5.1.4.2 Objeto: datosAdicionales

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| **dni** | String | Sí | 8 | 8 | Documento Nacional de Identidad del ciudadano |
| **sesionUsuario** | String | No | 0 | 50 | Identificador de sesión del usuario |

##### 5.1.4.3 Objeto: certificadoFirma

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| **caName** | String | No | 0 | 100 | Nombre de la Autoridad Certificadora |
| **certificateProfileName** | String | No | 0 | 100 | Nombre del perfil de certificado |
| **clearPwd** | Boolean | Sí | - | - | Indica si se debe limpiar el password |
| **email** | String | Sí | 5 | 100 | Correo electrónico del titular |
| **endEntityProfileName** | String | No | 0 | 100 | Nombre del perfil de entidad final |
| **keyRecoverable** | Boolean | Sí | - | - | Indica si la clave es recuperable |
| **password** | String | Sí | 0 | 20 | Contraseña para el certificado |
| **sendNotification** | Boolean | Sí | - | - | Indica si se debe enviar notificación |
| **status** | Integer | Sí | - | - | Estado del certificado |
| **subjectDN** | String | Sí | 50 | 500 | Distinguished Name del sujeto |
| **tokenType** | String | Sí | 10 | 20 | Tipo de token |
| **username** | String | Sí | 10 | 50 | Nombre de usuario |
| **nuSolicitud** | String | Sí | 5 | 20 | Número de solicitud |
| **pkcs10Str** | String | Sí | 100 | 10000 | Certificate Signing Request (CSR) en formato PKCS#10 |

##### 5.1.4.4 Objeto: certificadoCifrado

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| **caName** | String | No | 0 | 100 | Nombre de la Autoridad Certificadora |
| **certificateProfileName** | String | No | 0 | 100 | Nombre del perfil de certificado |
| **clearPwd** | Boolean | Sí | - | - | Indica si se debe limpiar el password |
| **email** | String | Sí | 5 | 100 | Correo electrónico del titular |
| **endEntityProfileName** | String | No | 0 | 100 | Nombre del perfil de entidad final |
| **keyRecoverable** | Boolean | Sí | - | - | Indica si la clave es recuperable |
| **password** | String | Sí | 0 | 20 | Contraseña para el certificado |
| **sendNotification** | Boolean | Sí | - | - | Indica si se debe enviar notificación |
| **status** | Integer | Sí | - | - | Estado del certificado |
| **subjectDN** | String | Sí | 50 | 500 | Distinguished Name del sujeto |
| **tokenType** | String | Sí | 10 | 20 | Tipo de token |
| **username** | String | Sí | 10 | 50 | Nombre de usuario |
| **nuSolicitud** | String | Sí | 5 | 20 | Número de solicitud |
| **pkcs10Str** | String | Sí | 100 | 10000 | Certificate Signing Request (CSR) en formato PKCS#10 |

##### 5.1.4.5 Objeto: certificadoAutenticacion

**NOTA**: Los campos de certificadoAutenticacion tienen la misma estructura que certificadoFirma y certificadoCifrado (ver sección 5.1.4.3)

---

#### 5.1.5 Response Body - Estructura Completa (Success)

```json
{
  "success": true,
  "statusCode": 201,
  "message": "Certificados digitales generados exitosamente",
  "data": {
    "certificados": [
      {
        "tipoCertificado": "AUTENTICACION",
        "certificadoBase64": "string",
        "numeroSerie": "string"
      },
      {
        "tipoCertificado": "FIRMA",
        "certificadoBase64": "string",
        "numeroSerie": "string"
      },
      {
        "tipoCertificado": "CIFRADO",
        "certificadoBase64": "string",
        "numeroSerie": "string"
      }
    ],
    "totalCertificados": 3,
    "pkiExterno": {
      "result": 0,
      "mensaje": "string"
    }
  },
  "metadata": {
    "timestamp": "2025-12-01T10:30:00Z",
    "correlationId": "string",
    "version": "1.0",
    "tiempoRespuesta": "1500ms"
  }
}
```

---

#### 5.1.6 Parámetros de Respuesta Detallados

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| **success** | Boolean | Sí | Indica si la operación fue exitosa |
| **statusCode** | Integer | Sí | Código de estado asociado a la respuesta del servicio |
| **message** | String | Sí | Mensaje informativo sobre el resultado de la operación |
| **data** | Object | Sí | Contenedor principal de los datos resultantes |
| **data.certificados** | Array | Sí | Lista de certificados generados o recuperados |
| **data.certificados[].tipoCertificado** | String | Sí | Tipo del certificado emitido (AUTENTICACION, FIRMA, CIFRADO) |
| **data.certificados[].certificadoBase64** | String | Sí | Certificado codificado en Base64 |
| **data.certificados[].numeroSerie** | String | Sí | Número de serie único del certificado |
| **data.totalCertificados** | Integer | Sí | Cantidad total de certificados incluidos en la respuesta |
| **data.pkiExterno** | Object | Sí | Información del proceso realizado con el PKI externo |
| **data.pkiExterno.result** | Integer | Sí | Resultado de la operación en el sistema PKI externo |
| **data.pkiExterno.mensaje** | String | Sí | Mensaje descriptivo del sistema PKI externo |
| **metadata** | Object | Sí | Información adicional para trazabilidad |
| **metadata.timestamp** | String (ISO 8601) | Sí | Fecha y hora exacta en que se generó la respuesta |
| **metadata.correlationId** | String | Sí | Identificador único para seguimiento de la transacción |
| **metadata.version** | String | Sí | Versión del servicio que generó la respuesta |
| **metadata.tiempoRespuesta** | String | Sí | Tiempo total de procesamiento del servicio |

---

#### 5.1.7 Error Response Structure

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

##### Parámetros de Error

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| **error** | Object | No | Objeto que especifica algún error existente |
| **error.tipo** | String | No | Tipo de error |
| **error.titulo** | String | No | Título del error |
| **error.estado** | Integer | No | Código del estado de error |
| **error.errores** | Array | No | Listado de errores |
| **error.errores[].detalleError** | String | No | Detalle del error generado |

---

#### 5.1.8 HTTP Status Codes - Endpoint generarCertificadoDigitalDniE

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| **201** | Created | Certificado digital generado exitosamente |
| **400** | Bad Request | Parámetros de entrada inválidos o incompletos |
| **401** | Unauthorized | Token JWT inválido, expirado o ausente |
| **403** | Forbidden | Sin permisos para generar certificados |
| **404** | Not Found | Ciudadano no encontrado en el APD |
| **409** | Conflict | Ya existe un certificado activo para este ciudadano y tipo |
| **422** | Unprocessable Entity | Ciudadano no cumple requisitos para certificado digital |
| **429** | Too Many Requests | Límite de rate limit excedido |
| **500** | Internal Server Error | Error interno del microservicio |
| **502** | Bad Gateway | Error de comunicación con servicio PKI externo de RENIEC |
| **503** | Service Unavailable | Servicio PKI externo temporalmente no disponible |
| **504** | Gateway Timeout | Timeout en comunicación con servicio PKI (> 30 segundos) |

---

---

### 5.2 ENDPOINT 2: Generar Números de Solicitud v2

#### 5.2.1 Información General

| Atributo | Valor |
|----------|-------|
| **Nombre del Endpoint** | generarNumerosSolicitud2 |
| **Path Completo** | `/api/v1/certificadosDigitales/MsAdaptadorPKI/generarNumerosSolicitud2` |
| **Método HTTP** | `POST` |
| **API Gateway** | Interno |
| **Protocolo** | REST/HTTP |
| **Descripción** | Invoca al método generarNumerosSolicitud2 del servicio PKI externo de RENIEC (certificadosdnie2 o certificadosdnie3) para generar 3 números de solicitud únicos correspondientes a los tres tipos de certificados digitales: AUT (Autenticación), FIR (Firma) y CIF (Cifrado) |

---

#### 5.2.2 Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| **Authorization** | String | Sí | Bearer token JWT para autenticación |
| **Content-Type** | String | Sí | "application/json" |
| **X-Correlation-ID** | UUID | Sí | Identificador único de correlación |
| **X-Office-Code** | String | Sí | Código de oficina origen |

---

#### 5.2.3 Request Body - Estructura Completa

```json
{
  "agenciaErep": "string",
  "apellidos": "string",
  "celular": "string",
  "comprobante": "string",
  "departamento": "string",
  "direccion": "string",
  "distrito": "string",
  "dni": "string",
  "email": "string",
  "ficha": "string",
  "nombres": "string",
  "nombreOperador": "string",
  "provincia": "string",
  "telefono": "string",
  "tipo": "string"
}
```

---

#### 5.2.4 Parámetros de Entrada Detallados

| Campo | Tipo | Obligatorio | Long. Mín | Long. Máx | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| **agenciaErep** | String | Sí | 1 | 100 | Código de agencia EREP |
| **apellidos** | String | Sí | 2 | 100 | Apellidos del ciudadano |
| **celular** | String | No | 9 | 15 | Número de teléfono celular |
| **comprobante** | String | Sí | 10 | 200 | Número de comprobante |
| **departamento** | String | Sí | 3 | 50 | Departamento de residencia |
| **direccion** | String | Sí | 5 | 200 | Dirección completa |
| **distrito** | String | Sí | 3 | 50 | Distrito de residencia |
| **dni** | String | Sí | 8 | 8 | Documento Nacional de Identidad |
| **email** | String | Sí | 5 | 100 | Correo electrónico |
| **ficha** | String | Sí | 5 | 20 | Número de ficha |
| **nombres** | String | Sí | 2 | 100 | Nombres del ciudadano |
| **nombreOperador** | String | Sí | 5 | 100 | Nombre del operador que realiza la solicitud |
| **provincia** | String | Sí | 3 | 50 | Provincia de residencia |
| **telefono** | String | No | 6 | 15 | Número de teléfono fijo |
| **tipo** | String | Sí | 1 | 1 | Tipo de solicitud |

---

#### 5.2.5 Response Body - Estructura Completa (Success)

```json
{
  "success": true,
  "statusCode": 201,
  "message": "Números de solicitud generados exitosamente",
  "data": {
    "idSolicitudAut": "string",
    "idSolicitudFir": "string",
    "idSolicitudCif": "string",
    "result": "string"
  },
  "metadata": {
    "timestamp": "2025-12-01T10:30:00Z",
    "correlationId": "string",
    "version": "1.0",
    "tiempoRespuesta": "500ms"
  }
}
```

---

#### 5.2.6 Parámetros de Respuesta Detallados

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| **success** | Boolean | Sí | Indica si la operación fue exitosa |
| **statusCode** | Integer | Sí | Código HTTP de respuesta |
| **message** | String | Sí | Mensaje descriptivo del resultado |
| **data.idSolicitudAut** | String | Sí | Número de solicitud para certificado de tipo autenticación |
| **data.idSolicitudFir** | String | Sí | Número de solicitud para certificado de tipo firma |
| **data.idSolicitudCif** | String | Sí | Número de solicitud para certificado de tipo cifrado |
| **data.result** | String | Sí | Código de salida |
| **metadata.timestamp** | String (Date ISO 8601) | Sí | Timestamp del procesamiento |
| **metadata.correlationId** | String | Sí | ID de correlación |
| **metadata.version** | String | Sí | Versión del API |
| **metadata.tiempoRespuesta** | String | Sí | Tiempo total de respuesta |

---

#### 5.2.7 Error Response Structure

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

##### Parámetros de Error

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| **error** | Object | No | Objeto que especifica algún error existente |
| **error.tipo** | String | No | Tipo de error |
| **error.titulo** | String | No | Título del error |
| **error.estado** | Integer | No | Código del estado de error |
| **error.errores** | Array | No | Listado de errores |
| **error.errores[].detalleError** | String | No | Detalle del error generado |

---

#### 5.2.8 HTTP Status Codes - Endpoint generarNumerosSolicitud2

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| **201** | Created | Números de solicitud generados exitosamente |
| **400** | Bad Request | Parámetros de entrada inválidos (DNI incorrecto, campos obligatorios faltantes) |
| **401** | Unauthorized | Token JWT inválido, expirado o ausente |
| **403** | Forbidden | Sin permisos para generar números de solicitud |
| **422** | Unprocessable Entity | Datos válidos pero no procesables por el servicio PKI |
| **429** | Too Many Requests | Límite de rate limit excedido |
| **500** | Internal Server Error | Error interno al generar secuencias |
| **502** | Bad Gateway | Error de comunicación con servicio PKI externo |
| **503** | Service Unavailable | Servicio PKI externo temporalmente no disponible |
| **504** | Gateway Timeout | Timeout en comunicación con servicio PKI (> 30 segundos) |

---

---

## 6. ENTIDADES DE DOMINIO

### 6.1 Entidad: CertificadoDigital

**Descripción**: Representa un certificado digital generado para un ciudadano.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| **tipoCertificado** | String | Tipo del certificado (AUTENTICACION, FIRMA, CIFRADO) |
| **certificadoBase64** | String | Contenido del certificado codificado en Base64 |
| **numeroSerie** | String | Número de serie único del certificado |

---

### 6.2 Entidad: SolicitudCertificado

**Descripción**: Representa los datos necesarios para solicitar un certificado digital.

| Atributo | Tipo | Obligatorio | Longitud | Descripción |
|----------|------|-------------|----------|-------------|
| **caName** | String | No | 0-100 | Nombre de la Autoridad Certificadora |
| **certificateProfileName** | String | No | 0-100 | Nombre del perfil de certificado |
| **clearPwd** | Boolean | Sí | - | Indica si se debe limpiar el password |
| **email** | String | Sí | 5-100 | Correo electrónico del titular |
| **endEntityProfileName** | String | No | 0-100 | Nombre del perfil de entidad final |
| **keyRecoverable** | Boolean | Sí | - | Indica si la clave es recuperable |
| **password** | String | Sí | 0-20 | Contraseña para el certificado |
| **sendNotification** | Boolean | Sí | - | Indica si se debe enviar notificación |
| **status** | Integer | Sí | - | Estado del certificado |
| **subjectDN** | String | Sí | 50-500 | Distinguished Name del sujeto |
| **tokenType** | String | Sí | 10-20 | Tipo de token |
| **username** | String | Sí | 10-50 | Nombre de usuario |
| **nuSolicitud** | String | Sí | 5-20 | Número de solicitud |
| **pkcs10Str** | String | Sí | 100-10000 | Certificate Signing Request en formato PKCS#10 |

---

### 6.3 Entidad: DatosAdicionales

**Descripción**: Datos adicionales necesarios para el procesamiento de certificados.

| Atributo | Tipo | Obligatorio | Longitud | Descripción |
|----------|------|-------------|----------|-------------|
| **dni** | String | Sí | 8 | Documento Nacional de Identidad del ciudadano |
| **sesionUsuario** | String | No | 0-50 | Identificador de sesión del usuario |

---

### 6.4 Entidad: SolicitudNumerosSecuencia

**Descripción**: Representa los datos de un ciudadano para generar números de solicitud.

| Atributo | Tipo | Obligatorio | Longitud | Descripción |
|----------|------|-------------|----------|-------------|
| **agenciaErep** | String | Sí | 1-100 | Código de agencia EREP |
| **apellidos** | String | Sí | 2-100 | Apellidos del ciudadano |
| **celular** | String | No | 9-15 | Número de teléfono celular |
| **comprobante** | String | Sí | 10-200 | Número de comprobante |
| **departamento** | String | Sí | 3-50 | Departamento de residencia |
| **direccion** | String | Sí | 5-200 | Dirección completa |
| **distrito** | String | Sí | 3-50 | Distrito de residencia |
| **dni** | String | Sí | 8 | Documento Nacional de Identidad |
| **email** | String | Sí | 5-100 | Correo electrónico |
| **ficha** | String | Sí | 5-20 | Número de ficha |
| **nombres** | String | Sí | 2-100 | Nombres del ciudadano |
| **nombreOperador** | String | Sí | 5-100 | Nombre del operador que realiza la solicitud |
| **provincia** | String | Sí | 3-50 | Provincia de residencia |
| **telefono** | String | No | 6-15 | Número de teléfono fijo |
| **tipo** | String | Sí | 1 | Tipo de solicitud |

---

### 6.5 Entidad: RespuestaPKI

**Descripción**: Respuesta del sistema PKI externo.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| **result** | Integer | Código de resultado de la operación |
| **mensaje** | String | Mensaje descriptivo del sistema PKI |

---

### 6.6 Entidad: NumerosSolicitud

**Descripción**: Números de solicitud generados para los tres tipos de certificados.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| **idSolicitudAut** | String | Número de solicitud para certificado de Autenticación |
| **idSolicitudFir** | String | Número de solicitud para certificado de Firma |
| **idSolicitudCif** | String | Número de solicitud para certificado de Cifrado |
| **result** | String | Código de salida de la operación |

---

### 6.7 Entidad: MetadataRespuesta

**Descripción**: Metadatos de trazabilidad de la respuesta.

| Atributo | Tipo | Formato | Descripción |
|----------|------|---------|-------------|
| **timestamp** | String | ISO 8601 (YYYY-MM-DDThh:mm:ssZ) | Fecha y hora de la respuesta |
| **correlationId** | String | UUID | Identificador de correlación |
| **version** | String | - | Versión del servicio |
| **tiempoRespuesta** | String | - | Tiempo de procesamiento |

---

### 6.8 Entidad: ErrorResponse

**Descripción**: Estructura estándar de errores.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| **tipo** | String | Tipo de error |
| **titulo** | String | Título descriptivo del error |
| **estado** | Integer | Código HTTP del error |
| **errores** | Array<DetalleError> | Lista de errores detallados |

---

### 6.9 Entidad: DetalleError

**Descripción**: Detalle específico de un error.

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| **detalleError** | String | Descripción detallada del error |

---

## 7. REGLAS DE NEGOCIO Y VALIDACIONES

### 7.1 Reglas Generales

1. **Autenticación Obligatoria**: Todos los endpoints requieren autenticación mediante Bearer Token JWT.

2. **Trazabilidad**: Todas las peticiones deben incluir X-Correlation-ID para seguimiento distribuido.

3. **Timeout**: El timeout máximo para comunicación con PKI externo es de 30 segundos.

4. **Rate Limiting**: Se aplica límite de tasa para prevenir abuso del sistema (código 429).

5. **Circuit Breaker**: Se implementa patrón Circuit Breaker para garantizar resiliencia ante fallos del PKI externo.

---

### 7.2 Validaciones - Endpoint generarCertificadoDigitalDniE

#### Validaciones de Entrada

1. **numeroCertificados**: 
   - Debe ser 2 o 3
   - Obligatorio

2. **dni** (datosAdicionales):
   - Longitud exacta: 8 caracteres
   - Formato numérico
   - Obligatorio

3. **email** (certificadoFirma, certificadoCifrado, certificadoAutenticacion):
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 100 caracteres
   - Formato de email válido
   - Obligatorio

4. **password** (certificadoFirma, certificadoCifrado, certificadoAutenticacion):
   - Longitud máxima: 20 caracteres
   - Obligatorio

5. **subjectDN** (certificadoFirma, certificadoCifrado, certificadoAutenticacion):
   - Longitud mínima: 50 caracteres
   - Longitud máxima: 500 caracteres
   - Obligatorio

6. **pkcs10Str** (certificadoFirma, certificadoCifrado, certificadoAutenticacion):
   - Longitud mínima: 100 caracteres
   - Longitud máxima: 10000 caracteres
   - Formato PKCS#10 válido
   - Obligatorio

7. **nuSolicitud** (certificadoFirma, certificadoCifrado, certificadoAutenticacion):
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 20 caracteres
   - Obligatorio

#### Reglas de Negocio

1. **Certificado Único**: No puede existir un certificado activo para el mismo ciudadano y tipo de certificado (código 409).

2. **Ciudadano Registrado**: El ciudadano debe existir en el APD (Archivo Personal Digital) de RENIEC (código 404 si no existe).

3. **Requisitos para Certificado**: El ciudadano debe cumplir con todos los requisitos establecidos por RENIEC para obtener un certificado digital (código 422 si no cumple).

4. **Permisos**: El usuario autenticado debe tener permisos para generar certificados digitales (código 403 si no tiene permisos).

---

### 7.3 Validaciones - Endpoint generarNumerosSolicitud2

#### Validaciones de Entrada

1. **dni**:
   - Longitud exacta: 8 caracteres
   - Formato numérico
   - Obligatorio

2. **nombres**:
   - Longitud mínima: 2 caracteres
   - Longitud máxima: 100 caracteres
   - Obligatorio

3. **apellidos**:
   - Longitud mínima: 2 caracteres
   - Longitud máxima: 100 caracteres
   - Obligatorio

4. **email**:
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 100 caracteres
   - Formato de email válido
   - Obligatorio

5. **direccion**:
   - Longitud mínima: 5 caracteres
   - Longitud máxima: 200 caracteres
   - Obligatorio

6. **departamento**:
   - Longitud mínima: 3 caracteres
   - Longitud máxima: 50 caracteres
   - Obligatorio

7. **provincia**:
   - Longitud mínima: 3 caracteres
   - Longitud máxima: 50 caracteres
   - Obligatorio

8. **distrito**:
   - Longitud mínima: 3 caracteres
   - Longitud máxima: 50 caracteres
   - Obligatorio

9. **comprobante**:
   - Longitud mínima: 10 caracteres
   - Longitud máxima: 200 caracteres
   - Obligatorio

10. **ficha**:
    - Longitud mínima: 5 caracteres
    - Longitud máxima: 20 caracteres
    - Obligatorio

11. **nombreOperador**:
    - Longitud mínima: 5 caracteres
    - Longitud máxima: 100 caracteres
    - Obligatorio

12. **agenciaErep**:
    - Longitud mínima: 1 carácter
    - Longitud máxima: 100 caracteres
    - Obligatorio

13. **tipo**:
    - Longitud exacta: 1 carácter
    - Obligatorio

14. **celular** (opcional):
    - Longitud mínima: 9 caracteres
    - Longitud máxima: 15 caracteres
    - Formato numérico

15. **telefono** (opcional):
    - Longitud mínima: 6 caracteres
    - Longitud máxima: 15 caracteres
    - Formato numérico

#### Reglas de Negocio

1. **Generación de Secuencias**: El sistema debe generar 3 números de solicitud únicos e irrepetibles, uno para cada tipo de certificado (AUT, FIR, CIF).

2. **Validación de Datos**: Aunque los datos sean válidos técnicamente, el servicio PKI puede rechazarlos por razones de negocio (código 422).

3. **Permisos**: El usuario autenticado debe tener permisos para generar números de solicitud (código 403 si no tiene permisos).

---

## 8. PATRONES DE ARQUITECTURA IMPLEMENTADOS

### 8.1 Circuit Breaker
- Protege el sistema ante fallos del servicio PKI externo
- Cuando el servicio está abierto, retorna código 503

### 8.2 Retry Pattern
- Reintentos automáticos ante fallos transitorios
- Garantiza continuidad operativa

### 8.3 API Gateway
- Punto único de entrada
- Gestión centralizada de seguridad
- Control de throttling y versionado

### 8.4 Adapter Pattern
- El microservicio actúa como fachada
- Abstrae detalles del servicio PKI externo
- Facilita cambios futuros sin impactar clientes

### 8.5 Distributed Tracing
- Logging centralizado
- Correlación de transacciones mediante X-Correlation-ID
- Métricas granulares de desempeño

---

## 9. CONSIDERACIONES DE SEGURIDAD

### 9.1 Autenticación
- Bearer Token JWT en header Authorization
- Validación de token en cada petición
- Token debe estar activo y no expirado

### 9.2 Autorización
- Validación de permisos específicos por endpoint
- Control de acceso basado en roles

### 9.3 Trazabilidad
- X-Correlation-ID obligatorio para seguimiento
- X-Request-ID para identificación única de solicitud
- X-PKI-Transaction-ID para seguimiento en PKI

### 9.4 Datos Sensibles
- Contraseñas y certificados transmitidos sobre HTTPS
- Información sensible no expuesta en logs externos
- Detalle de errores solo en logs internos

---

## 10. OBSERVABILIDAD Y MONITOREO

### 10.1 Métricas Incluidas
- **tiempoRespuesta**: Tiempo total de procesamiento
- **timestamp**: Marca temporal precisa
- **correlationId**: Para tracing distribuido
- **version**: Identificación de versión del servicio

### 10.2 Logging
- Errores internos registrados con detalle (código 500)
- Errores externos generalizados al cliente
- Trazabilidad completa mediante correlationId

---

## 11. RESUMEN DE TIPOS DE CERTIFICADOS

El sistema maneja tres tipos de certificados digitales:

| Tipo | Código | Descripción |
|------|--------|-------------|
| **Autenticación** | AUT | Certificado para autenticación del ciudadano |
| **Firma** | FIR | Certificado para firma digital |
| **Cifrado** | CIF | Certificado para cifrado de información |

---

## 12. CONTROL DE VERSIONES

| Versión | Fecha | Responsable | Descripción |
|---------|-------|-------------|-------------|
| 1.0 | 24/11/2025 | Arquitecto de Software | Versión inicial del documento |

---

## FIN DEL DOCUMENTO
