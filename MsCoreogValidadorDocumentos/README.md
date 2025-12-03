# MsCoreogValidadorDocumentos

## Resumen del Microservicio

**Nombre:** MsCoreogValidadorDocumentos  
**Contexto:** Validación de Documentos con IA para el Sistema SIIRC de RENIEC  
**Versión API:** v1  
**Tipo:** Microservicio de Dominio (MsDominio)  
**Paquete Base:** `pe.gob.reniec.coreog.validadordocumentos`

## Descripción

El Microservicio de Validación de Documentos con IA (MsCoreogValidadorDocumentos) es responsable de la evaluación automática de documentos digitales dentro de la plataforma SIIRC, utilizando modelos de inteligencia artificial para detectar posibles inconsistencias, errores o señales de fraude.

Este microservicio forma parte del ecosistema de Gestión de Seguridad Electrónica del RENIEC y se integra con el DNI Electrónico (DNIe) para facilitar servicios digitales seguros.

## Características Arquitectónicas

### Tipo de Microservicio: MsDominio

Como microservicio de dominio, **MsCoreogValidadorDocumentos**:

- **NO define `RepositoryPort`** - No maneja directamente persistencia de datos
- **Define puertos de salida hacia MsData** - Se integra con `MsDataValidadorDocumentos` para operaciones de datos
- **No especifica protocolo de conexión** - Los adaptadores implementan interfaces sin asumir HTTP/SOAP/colas
- **Implementa lógica de negocio** - Contiene las reglas de validación y calificación de documentos

### Arquitectura Hexagonal

El proyecto sigue estrictamente los principios de Arquitectura Hexagonal (Ports & Adapters):

```
├── domain/
│   ├── model/              # Entidades y objetos de valor (POJOs puros)
│   └── ports/
│       ├── in/             # Casos de uso (interfaces)
│       └── out/            # Puertos hacia MsData (interfaces)
├── application/
│   └── service/            # Servicios que implementan casos de uso
└── infrastructure/
    └── adapters/
        ├── in/rest/        # Adaptador REST (controllers, DTOs, mappers)
        └── out/msdata/     # Adaptador hacia MsDataValidadorDocumentos
```

## Endpoints

### 1. Calificar Documento

Evalúa uno o más documentos digitales aplicando modelos de IA.

- **Path:** `/api/v1/documentos/MsCoreogValidadorDocumentos/calificar`
- **Método:** `POST`
- **Protocolo:** REST/HTTP
- **Headers requeridos:**
  - `Authorization: Bearer {JWT_TOKEN}`
  - `Content-Type: application/json`
  - `X-Usuario-Id: {ID_USUARIO}`
  - `X-Oficina-Id: {ID_OFICINA}`
- **Headers opcionales:**
  - `X-Correlation-Id: {UUID}`

#### Request

```json
{
  "solicitudId": "string (UUID)",
  "tramiteId": "string",
  "tipoTramite": "string",
  "documentos": [
    {
      "documentoId": "string (UUID)",
      "tipoDocumental": "string",
      "nombreArchivo": "string",
      "rutaGestorDocumental": "string (URI)",
      "hashSHA256": "string (64 chars)",
      "formatoDocumento": "string",
      "tamanioBytes": 0,
      "requiereValidacionIA": true
    }
  ],
  "parametrosValidacion": {
    "nivelPonderacionMinimo": 0.0,
    "modeloIA": "string",
    "tiposObservacion": [
      {
        "codigo": "string",
        "descripcion": "string"
      }
    ]
  },
  "usuarioSolicita": "string",
  "oficinaOrigen": "string",
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ss±hh:mm",
  "observaciones": "string"
}
```

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "evaluacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "fechaEvaluacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": 0,
    "resultadoGeneral": {
      "estado": "string (APROBADO|ALERTA|RECHAZADO)",
      "scorePromedio": 0.0,
      "nivelRiesgo": "string (BAJO|MEDIO|ALTO|CRITICO)",
      "alertaFraude": false,
      "requiereRevisionManual": false,
      "observacionesGenerales": "string"
    },
    "documentosEvaluados": [
      {
        "documentoId": "string (UUID)",
        "tipoDocumental": "string",
        "nombreArchivo": "string",
        "estadoEvaluacion": "string (APROBADO|OBSERVADO|RECHAZADO)",
        "scoreConfiabilidad": 0.0,
        "nivelRiesgo": "string",
        "alertaFraude": false,
        "observaciones": [
          {
            "codigo": "string",
            "descripcion": "string",
            "severidad": "string",
            "evidencias": ["string"]
          }
        ],
        "metricas": {
          "calidadImagen": 0.0,
          "legibilidadTexto": 0.0,
          "integridadEstructura": 0.0,
          "confianzaOCR": 0.0
        },
        "tiempoProcesamientoMs": 0
      }
    ],
    "accionesRecomendadas": [
      {
        "tipo": "string",
        "descripcion": "string",
        "prioridad": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string (UUID)",
    "version": "string",
    "servidorProcesamiento": "string"
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 200 | OK - Evaluación realizada exitosamente |
| 400 | Bad Request - Parámetros inválidos |
| 401 | Unauthorized - Token JWT inválido o expirado |
| 403 | Forbidden - Sin permisos suficientes |
| 404 | Not Found - Solicitud o documentos no encontrados |
| 408 | Request Timeout - Timeout al obtener documentos |
| 422 | Unprocessable Entity - Datos no procesables |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Error con gestor documental o IA |
| 503 | Service Unavailable - Servicio de IA no disponible |
| 504 | Gateway Timeout - Timeout en servicio de IA |

### 2. Verificar Firma del Registrador

Valida la firma digital de un registrador en documentos registrales.

- **Path:** `/api/v1/documentos/MsCoreogValidadorDocumentos/verificar-firma-registrador`
- **Método:** `POST`
- **Protocolo:** REST/HTTP
- **Headers:** Iguales al endpoint anterior

#### Request

```json
{
  "solicitudId": "string (UUID)",
  "tramiteId": "string",
  "tipoTramite": "string",
  "documento": {
    "documentoId": "string (UUID)",
    "tipoDocumental": "string",
    "nombreArchivo": "string",
    "rutaGestorDocumental": "string (URI)",
    "hashSHA256": "string (64 chars)",
    "formatoDocumento": "string",
    "tamanioBytes": 0
  },
  "registrador": {
    "codigoRegistrador": "string",
    "nombreRegistrador": "string",
    "documentoIdentidad": "string",
    "oficinaRegistral": "string",
    "periodoInicio": "YYYY-MM-DD",
    "periodoFin": "YYYY-MM-DD"
  },
  "firmaDigital": {
    "idFirma": "string",
    "numeroSerieCertificado": "string",
    "subjectDN": "string",
    "algoritmoFirma": "string",
    "fechaFirma": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "huellaCertificado": "string",
    "entidadCertificadora": "string"
  },
  "parametrosValidacionFirma": {
    "validarContraBDRegistradores": true,
    "validarPeriodoVigencia": true,
    "validarCertificadoDigital": true
  },
  "usuarioSolicita": "string",
  "oficinaOrigen": "string",
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ss±hh:mm",
  "observaciones": "string"
}
```

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "verificacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "documentoId": "string (UUID)",
    "fechaVerificacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "resultadoVerificacion": {
      "estadoFirma": "string",
      "esFirmaValida": true,
      "detalleEstado": "string",
      "fuenteValidacion": "string",
      "requiereRevisionManual": false
    },
    "datosRegistrador": {
      "codigoRegistrador": "string",
      "nombreRegistrador": "string",
      "documentoIdentidad": "string",
      "oficinaRegistral": "string",
      "periodoInicio": "YYYY-MM-DD",
      "periodoFin": "YYYY-MM-DD",
      "enPeriodoVigencia": true
    },
    "datosFirmaDigital": {
      "idFirma": "string",
      "numeroSerieCertificado": "string",
      "subjectDN": "string",
      "algoritmoFirma": "string",
      "fechaFirma": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "huellaCertificado": "string",
      "entidadCertificadora": "string"
    },
    "alertas": [
      {
        "codigo": "string",
        "descripcion": "string",
        "severidad": "string"
      }
    ]
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string (UUID)",
    "version": "string",
    "servidorProcesamiento": "string"
  }
}
```

#### Status Codes

Similares al endpoint de calificación, con énfasis en errores relacionados con:
- Sistema de firma digital
- Base de datos de registradores
- Validación de certificados

## Entidades del Dominio

### Entidades Principales

| Entidad | Descripción | Tipo Java |
|---------|-------------|-----------|
| `SolicitudCalificacion` | Solicitud de evaluación de documentos | Aggregate Root |
| `SolicitudVerificacionFirma` | Solicitud de verificación de firma | Aggregate Root |
| `Documento` | Documento digital a validar | Entity |
| `Registrador` | Datos del registrador civil | Entity |
| `FirmaDigital` | Información de firma digital | Entity |
| `EvaluacionDocumento` | Resultado de evaluación | Entity |
| `VerificacionFirma` | Resultado de verificación | Entity |

### Objetos de Valor

- `ParametrosValidacion`
- `ParametrosValidacionFirma`
- `TipoObservacion`
- `ResultadoGeneral`
- `DocumentoEvaluado`
- `Observacion`
- `Metricas`
- `AccionRecomendada`
- `ResultadoVerificacion`
- `DatosRegistrador`
- `DatosFirmaDigital`
- `Alerta`

## Reglas de Mapeo de Tipos

Mapeo desde tipos JSON del PDF a tipos Java:

| Tipo JSON | Tipo Java |
|-----------|-----------|
| `string` | `String` |
| `integer` / `int` / `long` | `Long` |
| `number` / `decimal` / `double` | `Double` |
| `boolean` | `Boolean` |
| `date` | `LocalDate` |
| `datetime` / `timestamp` / `Date-Time` | `LocalDateTime` |
| `array` / `list` | `List<T>` |

Formato de fechas:
- **Fecha:** `YYYY-MM-DD` (ISO 8601)
- **Fecha-Hora:** `YYYY-MM-DDThh:mm:ss±hh:mm` (ISO 8601 con zona horaria)

## Integración con MsDataValidadorDocumentos

### Puertos de Salida Definidos

Este microservicio define dos puertos de salida hacia el componente de datos:

1. **`CalificacionDocumentoDataPort`**
   - `procesarCalificacion(SolicitudCalificacion)`: Envía solicitud de calificación
   - `consultarEvaluacion(String)`: Consulta estado de evaluación

2. **`VerificacionFirmaDataPort`**
   - `procesarVerificacion(SolicitudVerificacionFirma)`: Envía solicitud de verificación
   - `consultarVerificacion(String)`: Consulta estado de verificación

### Adaptadores Implementados

- **`CalificacionDocumentoDataAdapter`**: Implementa `CalificacionDocumentoDataPort`
- **`VerificacionFirmaDataAdapter`**: Implementa `VerificacionFirmaDataPort`

**IMPORTANTE:** Los adaptadores están implementados como stubs que lanzan `UnsupportedOperationException`. El protocolo de comunicación (HTTP, SOAP, colas, etc.) debe configurarse en tiempo de implementación según los requerimientos de infraestructura.

## Limitaciones y Consideraciones

### Neutralidad Tecnológica

Este proyecto se genera bajo estricta **neutralidad tecnológica**:

1. **Sin Frameworks:** No utiliza Spring, JAX-RS, JPA, ni ningún framework
2. **Sin Anotaciones:** Código Java puro (POJOs)
3. **Sin Dependencias Externas:** Compila con JDK estándar
4. **Sin Protocolo Definido:** Los adaptadores hacia MsData no especifican tecnología de conexión

### Implementación de Producción

Para llevar este código a producción, se requiere:

1. **Configurar Framework Web** (ej. Spring Boot) para exponer los controllers como endpoints REST
2. **Implementar Adaptadores de Salida** con tecnología específica (RestTemplate, WebClient, JMS, etc.)
3. **Configurar Inyección de Dependencias** para conectar puertos y adaptadores
4. **Añadir Manejo de Errores** y mapeo a códigos HTTP
5. **Implementar Seguridad** (validación de JWT, autorización)
6. **Configurar Logging y Trazabilidad**
7. **Definir Build Tool** (Maven o Gradle) y dependencias

### Compilación

El código generado es compilable como Java puro sin dependencias externas:

```bash
# Compilación con javac (ejemplo)
javac -d bin -sourcepath src/main/java src/main/java/pe/gob/reniec/coreog/validadordocumentos/**/*.java
```

## Casos de Uso Implementados

Según el PDF, solo se implementan los siguientes casos de uso:

1. **Calificar Documento** (`CalificarDocumentoUseCase`)
2. **Verificar Firma del Registrador** (`VerificarFirmaRegistradorUseCase`)

No se han creado casos de uso adicionales no documentados en el PDF.

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/coreog/validadordocumentos/
├── domain/
│   ├── model/
│   │   ├── AccionRecomendada.java
│   │   ├── Alerta.java
│   │   ├── DatosFirmaDigital.java
│   │   ├── DatosRegistrador.java
│   │   ├── Documento.java
│   │   ├── DocumentoEvaluado.java
│   │   ├── EvaluacionDocumento.java
│   │   ├── FirmaDigital.java
│   │   ├── Metricas.java
│   │   ├── Observacion.java
│   │   ├── ParametrosValidacion.java
│   │   ├── ParametrosValidacionFirma.java
│   │   ├── Registrador.java
│   │   ├── ResultadoGeneral.java
│   │   ├── ResultadoVerificacion.java
│   │   ├── SolicitudCalificacion.java
│   │   ├── SolicitudVerificacionFirma.java
│   │   ├── TipoObservacion.java
│   │   └── VerificacionFirma.java
│   └── ports/
│       ├── in/
│       │   ├── CalificarDocumentoUseCase.java
│       │   └── VerificarFirmaRegistradorUseCase.java
│       └── out/
│           ├── CalificacionDocumentoDataPort.java
│           └── VerificacionFirmaDataPort.java
├── application/
│   └── service/
│       ├── CalificarDocumentoService.java
│       └── VerificarFirmaRegistradorService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── ValidadorDocumentosController.java
        │       ├── dto/
        │       │   ├── AccionRecomendadaDto.java
        │       │   ├── AlertaDto.java
        │       │   ├── CalificarDocumentoRequestDto.java
        │       │   ├── CalificarDocumentoResponseDto.java
        │       │   ├── DatosFirmaDigitalDto.java
        │       │   ├── DatosRegistradorDto.java
        │       │   ├── DetalleErrorDto.java
        │       │   ├── DocumentoDto.java
        │       │   ├── DocumentoEvaluadoDto.java
        │       │   ├── ErrorDto.java
        │       │   ├── EvaluacionDataDto.java
        │       │   ├── FirmaDigitalDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── MetricasDto.java
        │       │   ├── ObservacionDto.java
        │       │   ├── ParametrosValidacionDto.java
        │       │   ├── ParametrosValidacionFirmaDto.java
        │       │   ├── RegistradorDto.java
        │       │   ├── ResultadoGeneralDto.java
        │       │   ├── ResultadoVerificacionDto.java
        │       │   ├── TipoObservacionDto.java
        │       │   ├── VerificarFirmaRequestDto.java
        │       │   ├── VerificarFirmaResponseDto.java
        │       │   └── VerificacionDataDto.java
        │       └── mapper/
        │           ├── CalificarDocumentoDtoMapper.java
        │           └── VerificarFirmaDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    ├── CalificacionDocumentoDataAdapter.java
                    └── VerificacionFirmaDataAdapter.java
```

## Contacto y Soporte

**Organismo:** Registro Nacional de Identificación y Estado Civil (RENIEC)  
**Sistema:** SIIRC - Sistema Integral de Identificación y Registro Civil  
**Módulo:** Gestión de Seguridad Electrónica - DNIe

---

**Nota:** Este proyecto fue generado automáticamente siguiendo las especificaciones del documento "Microservicio MsCoreogValidadorDocumentos v1.1.pdf" bajo estrictos principios de Domain-Driven Design y Arquitectura Hexagonal sin dependencias tecnológicas.
