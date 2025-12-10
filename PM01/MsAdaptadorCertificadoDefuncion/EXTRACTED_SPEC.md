# ESPECIFICACIÓN EXTRAÍDA DEL PDF
## Microservicio MsAdaptadorCertificadoDefuncion

---

## 📋 INFORMACIÓN GENERAL

### Nombre del Microservicio
**MsAdaptadorCertificadoDefuncion**

### Versión del Documento
- **Versión**: 1.2
- **Fecha de Generación**: 30/11/2025
- **Organización**: Gestión de Seguridad Electrónica - RENIEC

### Historial de Versiones
| Versión | Fecha | Cargo | Descripción |
|---------|-------|-------|-------------|
| 1.0 | 03/11/2025 | Arquitecto de Software | Versión inicial del documento |
| 1.1 | 29/11/2025 | Control de Arquitectura | Corrección del documento basado en observaciones |
| 1.2 | 30/11/2025 | Control de Arquitectura | Revisión estructura de objetos JSON |

---

## 🏢 CONTEXTO DE NEGOCIO

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

### Propósito del Microservicio

Actúa como **puente de comunicación especializado** entre la plataforma SIIRC y el Web Service de Certificados de Defunción (WS-CDEF) de RENIEC. Su propósito principal es:

- Abstraer la complejidad de la integración
- Proteger al SIIRC de cualquier modificación o cambio en la API o la estructura de datos del servicio externo
- Proporcionar consulta, validación y recuperación estandarizada de certificados de defunción
- Implementar patrones de resiliencia (Circuit Breaker, Retry)

---

## 🏗️ ARQUITECTURA DE REFERENCIA

La solución se estructura en tres capas principales:

1. **Capa de Exposición (API Management Layer)**: API Manager como punto único de entrada con gestión centralizada de seguridad, throttling y versionado.

2. **Capa de Representación (Microservices Layer)**: Microservicios de negocio con lógica específica de dominio y responsabilidad única.

3. **Capa de Integración (Integration Layer)**: Event Streaming para comunicación asíncrona y conectores a sistemas legados.

### Justificación de la Arquitectura de Microservicios

- **Escalabilidad Independiente**: Componentes con cargas diferenciadas pueden escalar de forma independiente según demanda real, optimizando recursos de infraestructura.
- **Resiliencia y Tolerancia a Fallos**: El fallo de un microservicio no compromete servicios críticos. Los patrones Circuit Breaker y Retry garantizan continuidad operativa.
- **Agilidad en el Desarrollo**: Equipos autónomos pueden desarrollar, probar y desplegar servicios de manera independiente, reduciendo tiempos de entrega.
- **Mantenibilidad y Evolución Tecnológica**: Cada servicio puede evolucionar tecnológicamente sin afectar al ecosistema completo.
- **Trazabilidad y Observabilidad**: Arquitectura distribuida permite implementar logging centralizado, distributed tracing y métricas granulares.

---

## 📡 VERSIÓN DEL API

**Versión**: v1

**Base Path**: `/api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion`

---

## 🔌 ENDPOINTS

### 1️⃣ ENDPOINT: Obtener Datos de Certificado de Defunción

Permite consultar los datos básicos de certificados de defunción en línea que se encuentran en estado **VIGENTE**. Proporciona información resumida del certificado para validaciones rápidas y verificaciones iniciales.

**Servicio Externo Consumido**: `obtener_datos_cdef` del WS-CDEF de RENIEC

#### Configuración del Endpoint

| Atributo | Valor |
|----------|-------|
| **Path** | `/api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/datos-basicos` |
| **API Gateway** | Interno |
| **Método HTTP** | POST |
| **Protocolo** | REST/HTTP |

#### Headers

| Header | Tipo | Descripción |
|--------|------|-------------|
| `Authorization` | String | Bearer token JWT para autenticación |
| `Content-Type` | String | `application/json` |
| `X-Correlation-ID` | UUID | ID de correlación para trazabilidad distribuida |

#### Request Body (JSON)

```json
{
    "coEntidadConsulta": "string",
    "coTipoDocIdentidad": "string",
    "deDocIdentidad": "string"
}
```

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Longitud Mínima | Longitud Máxima |
|------|----------|------|-------------|-----------------|-----------------|
| Código de institución que consulta (RUC) | `coEntidadConsulta` | String | Sí | 11 | 11 |
| Código para el tipo de documento de identidad | `coTipoDocIdentidad` | String | Sí | 2 | 2 |
| Número de documento de identidad del fallecido | `deDocIdentidad` | String | Sí | 1 | 20 |

#### Response Body - Éxito (JSON)

```json
{
    "success": true,
    "statusCode": "string",
    "message": "string",
    "data": {
        "certificados": [
            {
                "nuCdef": "string",
                "coTipoCdef": "string",
                "feCrea": "string",
                "fallecido": {
                    "coTitularTipoDocIdentidad": "string",
                    "deTitularDocIdentidad": "string",
                    "deTitularPrimerApellido": "string",
                    "deTitularSegundoApellido": "string",
                    "deTitularPrenombres": "string",
                    "feTitularNacimiento": "string",
                    "deTitularSexo": "string"
                },
                "defuncion": {
                    "feFallecimiento": "string",
                    "coFallecimientoCont": "string",
                    "coFallecimientoPais": "string",
                    "coFallecimientoDpto": "string",
                    "coFallecimientoProv": "string",
                    "coFallecimientoDist": "string",
                    "deFallecimientoTipoLugar": "string",
                    "coFallecimientoRenaes": "string",
                    "deFallecimientoNombreLugar": "string"
                },
                "profesional": {
                    "deProfDocIdentidad": "string"
                }
            }
        ]
    },
    "metadata": {
        "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "correlationId": "string",
        "version": "string"
    }
}
```

#### Response Body - Error (JSON)

```json
{
    "error": {
        "tipo": "string",
        "titulo": "string",
        "estado": "integer",
        "errores": [
            {
                "detalleError": "string"
            }
        ]
    }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `success` | Boolean | Sí | Indica si la operación fue exitosa |
| `statusCode` | String | Sí | Código de respuesta del WS-CDEF |
| `message` | String | Sí | Mensaje descriptivo de la respuesta |
| `data` | Object | Sí (si success=true) | Cuerpo principal de la respuesta |
| `data.certificados` | Array | Sí | Lista de certificados encontrados (puede estar vacío) |
| `data.certificados[].nuCdef` | String | Sí | Número de certificado de defunción (10 dígitos) |
| `data.certificados[].coTipoCdef` | String | Sí | Código de tipo de CDEF |
| `data.certificados[].feCrea` | String | Sí | Fecha de creación del registro (formato: dd/MM/yyyy HH:mm:ss) |
| `data.certificados[].fallecido` | Object | Sí | Información del fallecido |
| `data.certificados[].fallecido.coTitularTipoDocIdentidad` | String | Sí | Código para el tipo de documento de identidad |
| `data.certificados[].fallecido.deTitularDocIdentidad` | String | Sí | Número de documento de identidad del fallecido |
| `data.certificados[].fallecido.deTitularPrimerApellido` | String | Sí | Primer apellido del fallecido |
| `data.certificados[].fallecido.deTitularSegundoApellido` | String | Sí | Segundo apellido del fallecido |
| `data.certificados[].fallecido.deTitularPrenombres` | String | Sí | Prenombres del fallecido |
| `data.certificados[].fallecido.feTitularNacimiento` | String | Sí | Fecha de nacimiento del fallecido |
| `data.certificados[].fallecido.deTitularSexo` | String | Sí | Sexo del fallecido (M/F) |
| `data.certificados[].defuncion` | Object | Sí | Información de la defunción |
| `data.certificados[].defuncion.feFallecimiento` | String | Sí | Fecha de fallecimiento (formato: dd/MM/yyyy) |
| `data.certificados[].defuncion.coFallecimientoCont` | String | Sí | Código de continente de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoPais` | String | Sí | Código de país de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoDpto` | String | Sí | Código de departamento de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoProv` | String | Sí | Código de provincia de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoDist` | String | Sí | Código de distrito de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoTipoLugar` | String | Sí | Detalle de tipo de lugar de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoRenaes` | String | Sí | Código RENAES (Registro Nacional de Establecimientos de Salud) |
| `data.certificados[].defuncion.deFallecimientoNombreLugar` | String | Sí | Nombre del lugar de fallecimiento |
| `data.certificados[].profesional` | Object | Sí | Información del profesional que certifica |
| `data.certificados[].profesional.deProfDocIdentidad` | String | Sí | Número de documento de identidad del profesional |
| `metadata` | Object | Sí | Metadatos de la respuesta |
| `metadata.timestamp` | String (ISO 8601) | Sí | Timestamp de la consulta |
| `metadata.correlationId` | String (UUID) | Sí | ID de correlación para trazabilidad |
| `metadata.version` | String | Sí | Versión del API |
| `error` | Object | No | Objeto qué especifica algún error existente en la operación |
| `error.tipo` | String | No | Tipo de error |
| `error.titulo` | String | No | Título del error |
| `error.status` | Integer | No | Número del estado de error |
| `error.errores` | Array | No | Listado de errores |
| `error.errores[].detalleError` | String | No | Detalle del error generado |

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Operación realizada exitosamente |
| 400 | Bad Request | Parámetros inválidos o incompletos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 404 | Not Found | No se encontraron certificados para el documento consultado |
| 408 | Request Timeout | Tiempo de espera agotado al conectar con WS-CDEF |
| 422 | Unprocessable Entity | Datos válidos, pero no procesables por reglas de negocio del WS-CDEF |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del microservicio |
| 502 | Bad Gateway | WS-CDEF no disponible o respuesta inválida |
| 503 | Service Unavailable | Circuit Breaker abierto por fallos consecutivos del WS-CDEF |
| 504 | Gateway Timeout | WS-CDEF no respondió en el tiempo esperado |

---

### 2️⃣ ENDPOINT: Obtener Detalle Completo CDEF

Permite consultar el detalle completo de certificados de defunción en línea que se encuentran en estado **VIGENTE** o **EDITADO**. Proporciona información exhaustiva incluyendo causas de muerte, datos médicos y detalles adicionales del certificado.

**Servicio Externo Consumido**: `obtener_cdef_detalle` del WS-CDEF de RENIEC

#### Configuración del Endpoint

| Atributo | Valor |
|----------|-------|
| **Path** | `/api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/detalle-completo` |
| **API Gateway** | Interno |
| **Método HTTP** | POST |
| **Protocolo** | REST/HTTP |

#### Headers

| Header | Tipo | Descripción |
|--------|------|-------------|
| `Authorization` | String | Bearer token JWT para autenticación |
| `Content-Type` | String | `application/json` |
| `X-Correlation-ID` | UUID | ID de correlación para trazabilidad distribuida |

#### Request Body (JSON)

```json
{
    "coEntidadConsulta": "string",
    "coTipoDocIdentidad": "string",
    "deDocIdentidad": "string"
}
```

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Longitud Mínima | Longitud Máxima |
|------|----------|------|-------------|-----------------|-----------------|
| Código de institución que consulta (RUC) | `coEntidadConsulta` | String | Sí | 11 | 11 |
| Código para el tipo de documento de identidad | `coTipoDocIdentidad` | String | Sí | 2 | 2 |
| Número de documento de identidad del fallecido | `deDocIdentidad` | String | Sí | 1 | 20 |

#### Response Body - Éxito (JSON)

```json
{
    "success": true,
    "statusCode": "string",
    "message": "string",
    "data": {
        "certificados": [
            {
                "nuCdef": "string",
                "coTipoCdef": "string",
                "coEstadoCdef": "string",
                "deEstadoCdef": "string",
                "feCrea": "string",
                "feModifica": "string",
                "fallecido": {
                    "coTitularTipoDocIdentidad": "string",
                    "deTitularDocIdentidad": "string",
                    "deTitularPrimerApellido": "string",
                    "deTitularSegundoApellido": "string",
                    "deTitularPrenombres": "string",
                    "feTitularNacimiento": "string",
                    "deTitularSexo": "string",
                    "coTitularEstadoCivil": "string",
                    "deTitularEstadoCivil": "string",
                    "coTitularGradoInstruccion": "string",
                    "deTitularGradoInstruccion": "string",
                    "coTitularOcupacion": "string",
                    "deTitularOcupacion": "string"
                },
                "defuncion": {
                    "feFallecimiento": "string",
                    "hoFallecimiento": "string",
                    "coFallecimientoCont": "string",
                    "coFallecimientoPais": "string",
                    "deFallecimientoPais": "string",
                    "coFallecimientoDpto": "string",
                    "deFallecimientoDpto": "string",
                    "coFallecimientoProv": "string",
                    "deFallecimientoProv": "string",
                    "coFallecimientoDist": "string",
                    "deFallecimientoDist": "string",
                    "deFallecimientoTipoLugar": "string",
                    "coFallecimientoRenaes": "string",
                    "deFallecimientoNombreLugar": "string",
                    "deFallecimientoDireccion": "string",
                    "coTipoMuerte": "string",
                    "deTipoMuerte": "string"
                },
                "causasMuerte": [
                    {
                        "tipoCausa": "string",
                        "coEnfermedad": "string",
                        "deEnfermedad": "string",
                        "tiempoEvolucion": "string"
                    }
                ],
                "certificante": {
                    "deProfDocIdentidad": "string",
                    "deProfNombres": "string",
                    "deProfApellidoPaterno": "string",
                    "deProfApellidoMaterno": "string",
                    "coColegioProf": "string",
                    "deColegioProf": "string",
                    "nuColegioProf": "string"
                },
                "declarante": {
                    "coDeclaranteTipoDocIdentidad": "string",
                    "deDeclaranteDocIdentidad": "string",
                    "deDeclaranteNombres": "string",
                    "deDeclaranteApellidoPaterno": "string",
                    "deDeclaranteApellidoMaterno": "string",
                    "coParentesco": "string",
                    "deParentesco": "string"
                },
                "observaciones": "string",
                "auditoria": {
                    "usuarioCrea": "string",
                    "usuarioModifica": "string",
                    "oficinaCrea": "string"
                }
            }
        ]
    },
    "metadata": {
        "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "correlationId": "string",
        "version": "string"
    }
}
```

#### Response Body - Error (JSON)

```json
{
    "error": {
        "tipo": "string",
        "titulo": "string",
        "estado": "integer",
        "errores": [
            {
                "detalleError": "string"
            }
        ]
    }
}
```

#### Parámetros de Respuesta

| Nombre | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `success` | Boolean | Sí | Indica si la operación fue exitosa |
| `statusCode` | String | Sí | Código de respuesta del WS-CDEF (ver tabla de códigos) |
| `message` | String | Sí | Mensaje descriptivo de la respuesta |
| `data` | Object | Sí (si success=true) | Cuerpo principal de la respuesta |
| `data.certificados` | Array | Sí | Lista de certificados encontrados con detalle completo |
| `data.certificados[].nuCdef` | String | Sí | Número de certificado de defunción (10 dígitos) |
| `data.certificados[].coTipoCdef` | String | Sí | Código de tipo de CDEF |
| `data.certificados[].coEstadoCdef` | String | Sí | Código de estado del certificado (01=Vigente, 02=Editado, etc.) |
| `data.certificados[].deEstadoCdef` | String | Sí | Descripción del estado del certificado |
| `data.certificados[].feCrea` | String | Sí | Fecha de creación del registro (formato: dd/MM/yyyy HH:mm:ss) |
| `data.certificados[].feModifica` | String | No | Fecha de última modificación (formato: dd/MM/yyyy HH:mm:ss) |
| `data.certificados[].fallecido` | Object | Sí | Información completa del fallecido |
| `data.certificados[].fallecido.coTitularTipoDocIdentidad` | String | Sí | Código para el tipo de documento de identidad |
| `data.certificados[].fallecido.deTitularDocIdentidad` | String | Sí | Número de documento de identidad del fallecido |
| `data.certificados[].fallecido.deTitularPrimerApellido` | String | Sí | Primer apellido del fallecido |
| `data.certificados[].fallecido.deTitularSegundoApellido` | String | Sí | Segundo apellido del fallecido |
| `data.certificados[].fallecido.deTitularPrenombres` | String | Sí | Prenombres del fallecido |
| `data.certificados[].fallecido.feTitularNacimiento` | String | Sí | Fecha de nacimiento del fallecido (formato: dd/MM/yyyy) |
| `data.certificados[].fallecido.deTitularSexo` | String | Sí | Sexo del fallecido (M/F) |
| `data.certificados[].fallecido.coTitularEstadoCivil` | String | No | Código de estado civil |
| `data.certificados[].fallecido.deTitularEstadoCivil` | String | No | Descripción del estado civil |
| `data.certificados[].fallecido.coTitularGradoInstruccion` | String | No | Código de grado de instrucción |
| `data.certificados[].fallecido.deTitularGradoInstruccion` | String | No | Descripción del grado de instrucción |
| `data.certificados[].fallecido.coTitularOcupacion` | String | No | Código de ocupación |
| `data.certificados[].fallecido.deTitularOcupacion` | String | No | Descripción de la ocupación |
| `data.certificados[].defuncion` | Object | Sí | Información detallada de la defunción |
| `data.certificados[].defuncion.feFallecimiento` | String | Sí | Fecha de fallecimiento (formato: dd/MM/yyyy) |
| `data.certificados[].defuncion.hoFallecimiento` | String | No | Hora de fallecimiento (formato: HH:mm:ss) |
| `data.certificados[].defuncion.coFallecimientoCont` | String | Sí | Código de continente de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoPais` | String | Sí | Código de país de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoPais` | String | Sí | Descripción del país de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoDpto` | String | Sí | Código de departamento de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoDpto` | String | Sí | Descripción del departamento de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoProv` | String | Sí | Código de provincia de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoProv` | String | Sí | Descripción de la provincia de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoDist` | String | Sí | Código de distrito de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoDist` | String | Sí | Descripción del distrito de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoTipoLugar` | String | Sí | Detalle de tipo de lugar de fallecimiento |
| `data.certificados[].defuncion.coFallecimientoRenaes` | String | No | Código RENAES (Registro Nacional de Establecimientos de Salud) |
| `data.certificados[].defuncion.deFallecimientoNombreLugar` | String | Sí | Nombre del lugar de fallecimiento |
| `data.certificados[].defuncion.deFallecimientoDireccion` | String | No | Dirección del lugar de fallecimiento |
| `data.certificados[].defuncion.coTipoMuerte` | String | No | Código de tipo de muerte |
| `data.certificados[].defuncion.deTipoMuerte` | String | No | Descripción del tipo de muerte |
| `data.certificados[].causasMuerte` | Array | No | Lista de causas de muerte (puede incluir causa directa, antecedente, básica) |
| `data.certificados[].causasMuerte[].tipoCausa` | String | Sí | Tipo de causa |
| `data.certificados[].causasMuerte[].coEnfermedad` | String | No | Código CIE-10 de la enfermedad |
| `data.certificados[].causasMuerte[].deEnfermedad` | String | Sí | Descripción de la enfermedad o causa |
| `data.certificados[].causasMuerte[].tiempoEvolucion` | String | No | Tiempo aproximado de evolución de la causa |
| `data.certificados[].certificante` | Object | Sí | Información del profesional que certifica la defunción |
| `data.certificados[].certificante.deProfDocIdentidad` | String | Sí | Número de documento de identidad del profesional |
| `data.certificados[].certificante.deProfNombres` | String | No | Nombres del profesional |
| `data.certificados[].certificante.deProfApellidoPaterno` | String | No | Apellido paterno del profesional |
| `data.certificados[].certificante.deProfApellidoMaterno` | String | No | Apellido materno del profesional |
| `data.certificados[].certificante.coColegioProf` | String | No | Código del colegio profesional |
| `data.certificados[].certificante.deColegioProf` | String | No | Nombre del colegio profesional |
| `data.certificados[].certificante.nuColegioProf` | String | No | Número de colegiatura |
| `data.certificados[].declarante` | Object | No | Información del declarante del certificado |
| `data.certificados[].declarante.coDeclaranteTipoDocIdentidad` | String | No | Código de tipo de documento del declarante |
| `data.certificados[].declarante.deDeclaranteDocIdentidad` | String | No | Número de documento del declarante |
| `data.certificados[].declarante.deDeclaranteNombres` | String | No | Nombres del declarante |
| `data.certificados[].declarante.deDeclaranteApellidoPaterno` | String | No | Apellido paterno del declarante |
| `data.certificados[].declarante.deDeclaranteApellidoMaterno` | String | No | Apellido materno del declarante |
| `data.certificados[].declarante.coParentesco` | String | No | Código de parentesco con el fallecido |
| `data.certificados[].declarante.deParentesco` | String | No | Descripción del parentesco |
| `data.certificados[].observaciones` | String | No | Observaciones adicionales del certificado |
| `data.certificados[].auditoria` | Object | No | Información de auditoría del registro |
| `data.certificados[].auditoria.usuarioCrea` | String | No | Usuario que creó el registro |
| `data.certificados[].auditoria.usuarioModifica` | String | No | Usuario que modificó el registro |
| `data.certificados[].auditoria.oficinaCrea` | String | No | Oficina donde se creó el registro |
| `metadata` | Object | Sí | Metadatos de la respuesta |
| `metadata.timestamp` | String (ISO 8601) | Sí | Timestamp de la consulta |
| `metadata.correlationId` | String (UUID) | Sí | ID de correlación para trazabilidad |
| `metadata.version` | String | Sí | Versión del API |
| `metadata.source` | String | Sí | Fuente de los datos (WS-CDEF) |
| `error` | Object | No | Objeto qué especifica algún error existente en la operación |
| `error.tipo` | String | No | Tipo de error |
| `error.titulo` | String | No | Título del error |
| `error.status` | Integer | No | Número del estado de error |
| `error.errores` | Array | No | Listado de errores |
| `error.errores[].detalleError` | String | No | Detalle del error generado |

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Consulta realizada exitosamente |
| 400 | Bad Request | Parámetros inválidos o incompletos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 404 | Not Found | No se encontraron certificados para el documento consultado |
| 408 | Request Timeout | Tiempo de espera agotado al conectar con WS-CDEF |
| 422 | Unprocessable Entity | Datos válidos, pero no procesables por reglas de negocio del WS-CDEF |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del microservicio |
| 502 | Bad Gateway | WS-CDEF no disponible o respuesta inválida |
| 503 | Service Unavailable | Circuit Breaker abierto por fallos consecutivos del WS-CDEF |
| 504 | Gateway Timeout | WS-CDEF no respondió en el tiempo esperado |

---

## 📊 ENTIDADES DEL DOMINIO

### 1. Certificado de Defunción (Datos Básicos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `nuCdef` | String | Número de certificado de defunción (10 dígitos) |
| `coTipoCdef` | String | Código de tipo de CDEF |
| `feCrea` | String | Fecha de creación del registro (formato: dd/MM/yyyy HH:mm:ss) |

### 2. Certificado de Defunción (Detalle Completo)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `nuCdef` | String | Número de certificado de defunción (10 dígitos) |
| `coTipoCdef` | String | Código de tipo de CDEF |
| `coEstadoCdef` | String | Código de estado del certificado (01=Vigente, 02=Editado, etc.) |
| `deEstadoCdef` | String | Descripción del estado del certificado |
| `feCrea` | String | Fecha de creación del registro (formato: dd/MM/yyyy HH:mm:ss) |
| `feModifica` | String | Fecha de última modificación (formato: dd/MM/yyyy HH:mm:ss) |
| `observaciones` | String | Observaciones adicionales del certificado |

### 3. Fallecido (Datos Básicos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `coTitularTipoDocIdentidad` | String | Código para el tipo de documento de identidad |
| `deTitularDocIdentidad` | String | Número de documento de identidad del fallecido |
| `deTitularPrimerApellido` | String | Primer apellido del fallecido |
| `deTitularSegundoApellido` | String | Segundo apellido del fallecido |
| `deTitularPrenombres` | String | Prenombres del fallecido |
| `feTitularNacimiento` | String | Fecha de nacimiento del fallecido |
| `deTitularSexo` | String | Sexo del fallecido (M/F) |

### 4. Fallecido (Datos Completos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `coTitularTipoDocIdentidad` | String | Código para el tipo de documento de identidad |
| `deTitularDocIdentidad` | String | Número de documento de identidad del fallecido |
| `deTitularPrimerApellido` | String | Primer apellido del fallecido |
| `deTitularSegundoApellido` | String | Segundo apellido del fallecido |
| `deTitularPrenombres` | String | Prenombres del fallecido |
| `feTitularNacimiento` | String | Fecha de nacimiento del fallecido (formato: dd/MM/yyyy) |
| `deTitularSexo` | String | Sexo del fallecido (M/F) |
| `coTitularEstadoCivil` | String | Código de estado civil |
| `deTitularEstadoCivil` | String | Descripción del estado civil |
| `coTitularGradoInstruccion` | String | Código de grado de instrucción |
| `deTitularGradoInstruccion` | String | Descripción del grado de instrucción |
| `coTitularOcupacion` | String | Código de ocupación |
| `deTitularOcupacion` | String | Descripción de la ocupación |

### 5. Defunción (Datos Básicos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `feFallecimiento` | String | Fecha de fallecimiento (formato: dd/MM/yyyy) |
| `coFallecimientoCont` | String | Código de continente de fallecimiento |
| `coFallecimientoPais` | String | Código de país de fallecimiento |
| `coFallecimientoDpto` | String | Código de departamento de fallecimiento |
| `coFallecimientoProv` | String | Código de provincia de fallecimiento |
| `coFallecimientoDist` | String | Código de distrito de fallecimiento |
| `deFallecimientoTipoLugar` | String | Detalle de tipo de lugar de fallecimiento |
| `coFallecimientoRenaes` | String | Código RENAES (Registro Nacional de Establecimientos de Salud) |
| `deFallecimientoNombreLugar` | String | Nombre del lugar de fallecimiento |

### 6. Defunción (Datos Completos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `feFallecimiento` | String | Fecha de fallecimiento (formato: dd/MM/yyyy) |
| `hoFallecimiento` | String | Hora de fallecimiento (formato: HH:mm:ss) |
| `coFallecimientoCont` | String | Código de continente de fallecimiento |
| `coFallecimientoPais` | String | Código de país de fallecimiento |
| `deFallecimientoPais` | String | Descripción del país de fallecimiento |
| `coFallecimientoDpto` | String | Código de departamento de fallecimiento |
| `deFallecimientoDpto` | String | Descripción del departamento de fallecimiento |
| `coFallecimientoProv` | String | Código de provincia de fallecimiento |
| `deFallecimientoProv` | String | Descripción de la provincia de fallecimiento |
| `coFallecimientoDist` | String | Código de distrito de fallecimiento |
| `deFallecimientoDist` | String | Descripción del distrito de fallecimiento |
| `deFallecimientoTipoLugar` | String | Detalle de tipo de lugar de fallecimiento |
| `coFallecimientoRenaes` | String | Código RENAES (Registro Nacional de Establecimientos de Salud) |
| `deFallecimientoNombreLugar` | String | Nombre del lugar de fallecimiento |
| `deFallecimientoDireccion` | String | Dirección del lugar de fallecimiento |
| `coTipoMuerte` | String | Código de tipo de muerte |
| `deTipoMuerte` | String | Descripción del tipo de muerte |

### 7. Profesional (Datos Básicos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `deProfDocIdentidad` | String | Número de documento de identidad del profesional |

### 8. Certificante (Profesional - Datos Completos)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `deProfDocIdentidad` | String | Número de documento de identidad del profesional |
| `deProfNombres` | String | Nombres del profesional |
| `deProfApellidoPaterno` | String | Apellido paterno del profesional |
| `deProfApellidoMaterno` | String | Apellido materno del profesional |
| `coColegioProf` | String | Código del colegio profesional |
| `deColegioProf` | String | Nombre del colegio profesional |
| `nuColegioProf` | String | Número de colegiatura |

### 9. Causa de Muerte

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipoCausa` | String | Tipo de causa |
| `coEnfermedad` | String | Código CIE-10 de la enfermedad |
| `deEnfermedad` | String | Descripción de la enfermedad o causa |
| `tiempoEvolucion` | String | Tiempo aproximado de evolución de la causa |

### 10. Declarante

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `coDeclaranteTipoDocIdentidad` | String | Código de tipo de documento del declarante |
| `deDeclaranteDocIdentidad` | String | Número de documento del declarante |
| `deDeclaranteNombres` | String | Nombres del declarante |
| `deDeclaranteApellidoPaterno` | String | Apellido paterno del declarante |
| `deDeclaranteApellidoMaterno` | String | Apellido materno del declarante |
| `coParentesco` | String | Código de parentesco con el fallecido |
| `deParentesco` | String | Descripción del parentesco |

### 11. Auditoría

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `usuarioCrea` | String | Usuario que creó el registro |
| `usuarioModifica` | String | Usuario que modificó el registro |
| `oficinaCrea` | String | Oficina donde se creó el registro |

### 12. Metadata (Metadatos de Respuesta)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `timestamp` | String (ISO 8601) | Timestamp de la consulta (formato: YYYY-MM-DDThh:mm:ss±hh:mm) |
| `correlationId` | String (UUID) | ID de correlación para trazabilidad |
| `version` | String | Versión del API |
| `source` | String | Fuente de los datos (WS-CDEF) |

### 13. Error

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipo` | String | Tipo de error |
| `titulo` | String | Título del error |
| `estado` | Integer | Número del estado de error |
| `errores` | Array | Listado de errores |

### 14. Detalle de Error

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `detalleError` | String | Detalle del error generado |

---

## 📋 CÓDIGOS DE RESPUESTA HTTP ESTÁNDAR

Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP para garantizar consistencia:

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos, pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio (información generalizada al exterior, detalle en logs) |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

---

## 📝 NOTAS ADICIONALES

### Patrones de Resiliencia Implementados
- **Circuit Breaker**: Protección ante fallos consecutivos del servicio externo WS-CDEF
- **Retry**: Reintentos automáticos en caso de fallos transitorios
- **Timeout**: Tiempos de espera configurados para evitar bloqueos indefinidos

### Seguridad
- Autenticación mediante **Bearer token JWT**
- Validación de tokens en todos los endpoints
- Correlación de peticiones mediante **X-Correlation-ID**

### Trazabilidad
- ID de correlación (UUID) para seguimiento distribuido
- Timestamp ISO 8601 en todas las respuestas
- Logging centralizado para auditoría

### Integración Externa
- **Servicio Consumido**: Web Service de Certificados de Defunción (WS-CDEF) de RENIEC
- **Métodos WS-CDEF Consumidos**:
  - `obtener_datos_cdef` (para datos básicos)
  - `obtener_cdef_detalle` (para detalle completo)

---

**Documento generado automáticamente desde el PDF**
**Versión del PDF**: 1.2
**Fecha de extracción**: 04/12/2025
