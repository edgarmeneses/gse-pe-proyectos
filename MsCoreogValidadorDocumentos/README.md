# Microservicio MsCoreogValidadorDocumentos

## Resumen

**Nombre del Microservicio**: MsCoreogValidadorDocumentos  
**Contexto de Negocio**: Validación de Documentos con Inteligencia Artificial para SIIRC (Sistema Integrado de Identificación y Registro Civil)  
**Tipo**: MsDominio (Microservicio de Dominio)  
**Versión del API**: v1  
**Paquete Base**: `pe.gob.reniec.coreog.validadordocumentos`  
**Fecha de Generación**: 03/12/2025

## Descripción

El Microservicio de Validación de Documentos con IA (MsCoreogValidadorDocumentos) es responsable de la evaluación automática de documentos digitales dentro de la plataforma SIIRC, utilizando modelos de inteligencia artificial para detectar posibles inconsistencias, errores o señales de fraude.

Este microservicio pertenece al RENIEC (Registro Nacional de Identificación y Estado Civil) y forma parte de la arquitectura de microservicios para la modernización y transformación digital del Estado peruano.

### Justificación de la Arquitectura Hexagonal

Este proyecto implementa **Arquitectura Hexagonal estricta** sin dependencias de frameworks, siguiendo los principios DDD (Domain-Driven Design):

- **Capa de Dominio**: Entidades, objetos de valor y puertos (interfaces) que definen el núcleo del negocio.
- **Capa de Aplicación**: Servicios que implementan los casos de uso del negocio.
- **Capa de Infraestructura**: Adaptadores que conectan el dominio con tecnologías externas (REST, bases de datos, servicios externos).

### Características del Tipo de Microservicio

**MsDominio (Microservicio de Dominio)**:
- ❌ **NO define `RepositoryPort`**: No tiene responsabilidad de persistencia directa
- ✅ **Define puertos de salida hacia MsData**: Integración con microservicios de datos (MsDataValidadorDocumentos, MsDataRegistradores)
- ✅ **Implementa lógica de negocio**: Contiene las reglas de validación y evaluación de documentos
- ✅ **No define protocolo de conexión**: Los adaptadores no especifican HTTP, SOAP, colas, etc. (neutralidad tecnológica)

## Arquitectura del Proyecto

```
src/main/java/pe/gob/reniec/coreog/validadordocumentos/
├── domain/                                    # Capa de Dominio
│   ├── model/                                 # Entidades y Objetos de Valor
│   │   ├── Documento.java                     # Entidad: Documento digital
│   │   ├── Evaluacion.java                    # Aggregate Root: Evaluación con IA
│   │   ├── Verificacion.java                  # Aggregate Root: Verificación de firma
│   │   └── Registrador.java                   # Entidad: Registrador civil
│   └── ports/                                 # Puertos (Interfaces)
│       ├── in/                                # Puertos de Entrada (Use Cases)
│       │   ├── CalificarDocumentoUseCase.java
│       │   └── VerificarFirmaRegistradorUseCase.java
│       └── out/                               # Puertos de Salida (hacia MsData y externos)
│           ├── EvaluacionDataPort.java        # Persistencia de Evaluaciones (MsData)
│           ├── VerificacionDataPort.java      # Persistencia de Verificaciones (MsData)
│           ├── RegistradorDataPort.java       # Consulta de Registradores (MsData)
│           ├── GestorDocumentalPort.java      # Gestor Documental
│           └── ServicioIAPort.java            # Servicio de Inteligencia Artificial
│
├── application/                               # Capa de Aplicación
│   └── service/                               # Servicios de Aplicación
│       ├── CalificarDocumentoService.java
│       └── VerificarFirmaRegistradorService.java
│
└── infrastructure/                            # Capa de Infraestructura
    └── adapters/
        ├── in/                                # Adaptadores de Entrada
        │   └── rest/                          # Adaptador REST
        │       ├── controller/
        │       │   └── ValidadorDocumentosController.java
        │       ├── dto/
        │       │   ├── CalificarDocumentoRequestDto.java
        │       │   ├── CalificarDocumentoResponseDto.java
        │       │   ├── VerificarFirmaRegistradorRequestDto.java
        │       │   └── VerificarFirmaRegistradorResponseDto.java
        │       └── mapper/
        │           ├── CalificarDocumentoDtoMapper.java
        │           └── VerificarFirmaRegistradorDtoMapper.java
        └── out/                               # Adaptadores de Salida
            ├── msdata/                        # Adaptadores hacia MsData
            │   └── client/
            │       ├── EvaluacionDataAdapter.java
            │       ├── VerificacionDataAdapter.java
            │       └── RegistradorDataAdapter.java
            └── externo/                       # Adaptadores hacia servicios externos
                └── client/
                    ├── GestorDocumentalAdapter.java
                    └── ServicioIAAdapter.java
```

## Endpoints

### 1. Calificar Documento

**Endpoint**: `POST /api/v1/documentos/MsCoreogValidadorDocumentos/calificar`  
**Descripción**: Evalúa uno o más documentos digitales asociados a un trámite específico, aplicando modelos de inteligencia artificial para determinar su nivel de confiabilidad y detectar posibles riesgos de fraude o inconsistencias.

#### Headers
```
Authorization: Bearer {JWT_TOKEN}
Content-Type: application/json
X-Correlation-Id: {UUID} (opcional, para trazabilidad)
X-Usuario-Id: {ID_USUARIO}
X-Oficina-Id: {ID_OFICINA}
```

#### Request Body (JSON)
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
      "hashSHA256": "string (64 caracteres)",
      "formatoDocumento": "string",
      "tamanioBytes": integer,
      "requiereValidacionIA": boolean
    }
  ],
  "parametrosValidacion": {
    "nivelPonderacionMinimo": number,
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
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ssZ",
  "observaciones": "string"
}
```

#### Response Body (JSON)
```json
{
  "success": boolean,
  "data": {
    "evaluacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "fechaEvaluacion": "YYYY-MM-DDThh:mm:ssZ",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": integer,
    "resultadoGeneral": {
      "estado": "string",
      "scorePromedio": number,
      "nivelRiesgo": "string",
      "alertaFraude": boolean,
      "requiereRevisionManual": boolean,
      "observacionesGenerales": "string"
    },
    "documentosEvaluados": [
      {
        "documentoId": "string (UUID)",
        "tipoDocumental": "string",
        "nombreArchivo": "string",
        "estadoEvaluacion": "string",
        "scoreConfiabilidad": number,
        "nivelRiesgo": "string",
        "alertaFraude": boolean,
        "observaciones": [
          {
            "codigo": "string",
            "descripcion": "string",
            "severidad": "string",
            "evidencias": ["string"]
          }
        ],
        "metricas": {
          "calidadImagen": number,
          "legibilidadTexto": number,
          "integridadEstructura": number,
          "confianzaOCR": number
        },
        "tiempoProcesamientoMs": integer
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
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string (UUID)",
    "version": "string",
    "servidorProcesamiento": "string"
  }
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 200    | Evaluación realizada exitosamente |
| 400    | Parámetros inválidos o documentos no encontrados en gestor documental |
| 401    | Token JWT inválido o expirado |
| 403    | Usuario sin permisos para solicitar validación de documentos |
| 404    | Solicitud no encontrada o documentos no localizados |
| 408    | Timeout al intentar obtener documentos del gestor documental |
| 422    | Documentos en formato no soportado o trámite en estado no válido |
| 429    | Límite de rate limit excedido |
| 500    | Error interno del servicio de validación |
| 502    | Error al comunicarse con el gestor documental o servicio de IA |
| 503    | Servicio de inferencia de IA temporalmente no disponible - Circuit Breaker activado |
| 504    | Timeout en servicio de inferencia de IA - tiempo de procesamiento excedido |

---

### 2. Verificar Firma del Registrador

**Endpoint**: `POST /api/v1/documentos/MsCoreogValidadorDocumentos/verificarFirmaRegistrador`  
**Descripción**: Verifica la autenticidad de la firma manuscrita y el sello del registrador civil presentes en un documento de acta registral (nacimiento, matrimonio o defunción). Utiliza modelos de IA para comparar las imágenes extraídas contra las firmas y sellos de referencia almacenados en la Base de Datos de Registradores Civiles.

#### Headers
```
Authorization: Bearer {JWT_TOKEN}
Content-Type: application/json
X-Correlation-Id: {UUID} (opcional, para trazabilidad)
X-Usuario-Id: {ID_USUARIO}
X-Oficina-Id: {ID_OFICINA}
```

#### Request Body (JSON)
```json
{
  "solicitudId": "string (UUID)",
  "tramiteId": "string",
  "documentoId": "string (UUID)",
  "tipoActa": "string",
  "rutaGestorDocumental": "string (URI)",
  "hashSHA256": "string (64 caracteres)",
  "datosRegistrador": {
    "numeroDniRegistrador": "string (8 caracteres)",
    "idUsuario": "string",
    "primerApellido": "string",
    "segundoApellido": "string",
    "prenombres": "string",
    "codigoLocal": "string (6 caracteres)"
  },
  "datosActa": {
    "numeroActa": "string",
    "anioActa": integer,
    "fechaInscripcion": "YYYY-MM-DDThh:mm:ssZ",
    "oficinaRegistroCivil": "string"
  },
  "parametrosVerificacion": {
    "umbralSimilitudFirma": number,
    "umbralSimilitudSello": number,
    "modeloIA": "string",
    "incluirImagenesReferencia": boolean
  },
  "usuarioSolicita": "string",
  "oficinaOrigen": "string",
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ssZ",
  "observaciones": "string"
}
```

#### Response Body (JSON)
```json
{
  "success": boolean,
  "data": {
    "verificacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "documentoId": "string (UUID)",
    "fechaVerificacion": "YYYY-MM-DDThh:mm:ssZ",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": integer,
    "resultadoGeneral": {
      "estadoVerificacion": "string",
      "firmaValida": boolean,
      "selloValido": boolean,
      "periodoValido": boolean,
      "requiereRevisionManual": boolean,
      "observacionesGenerales": "string"
    },
    "verificacionFirma": {
      "estadoFirma": "string",
      "scoreSimilitud": number,
      "nivelConfianza": "string",
      "firmaEncontradaEnBD": boolean,
      "imagenFirmaDocumento": "string (Base64)",
      "imagenFirmaReferencia": "string (Base64)",
      "observaciones": "string",
      "metricas": {
        "similitudEstructural": number,
        "similitudTrazos": number,
        "calidadImagenExtraida": number
      }
    },
    "verificacionSello": {
      "estadoSello": "string",
      "scoreSimilitud": number,
      "nivelConfianza": "string",
      "selloEncontradoEnBD": boolean,
      "imagenSelloDocumento": "string (Base64)",
      "imagenSelloReferencia": "string (Base64)",
      "observaciones": "string",
      "metricas": {
        "similitudForma": number,
        "legibilidadTexto": number,
        "calidadImagenExtraida": number
      }
    },
    "verificacionPeriodo": {
      "estadoPeriodo": "string",
      "registradorEncontrado": boolean,
      "registradorHabilitado": boolean,
      "fechaInscripcionActa": "YYYY-MM-DDThh:mm:ssZ",
      "periodoHabilitacion": {
        "fechaInicio": "YYYY-MM-DDThh:mm:ssZ",
        "fechaFin": "YYYY-MM-DDThh:mm:ssZ",
        "codigoLocal": "string",
        "nombreOficina": "string"
      },
      "estadoRegistrador": "string",
      "observaciones": "string"
    },
    "datosRegistradorVerificado": {
      "numeroDniRegistrador": "string",
      "idUsuario": "string",
      "nombreCompleto": "string",
      "codigoLocal": "string",
      "nombreOficina": "string",
      "estadoActual": "string"
    },
    "alertas": [
      {
        "codigo": "string",
        "tipo": "string",
        "descripcion": "string",
        "severidad": "string"
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
    "timestamp": "YYYY-MM-DDThh:mm:ssZ",
    "correlationId": "string (UUID)",
    "version": "string",
    "servidorProcesamiento": "string"
  }
}
```

#### Status Codes
| Código | Descripción |
|--------|-------------|
| 200    | Verificación realizada exitosamente |
| 400    | Parámetros inválidos o documento no encontrado en gestor documental |
| 401    | Token JWT inválido o expirado |
| 403    | Usuario sin permisos para solicitar verificación de firma |
| 404    | Documento no localizado en gestor documental o registrador no encontrado en BD |
| 408    | Timeout al intentar obtener documento del gestor documental |
| 422    | Documento en formato no soportado o no contiene firma/sello extraíble |
| 429    | Límite de rate limit excedido |
| 500    | Error interno del servicio de verificación |
| 502    | Error al comunicarse con el gestor documental, BD de Registradores o servicio de IA |
| 503    | Servicio de inferencia de IA temporalmente no disponible - Circuit Breaker activado |
| 504    | Timeout en servicio de inferencia de IA - tiempo de procesamiento excedido |

---

## Entidades del Dominio

### 1. Documento
**Descripción**: Representa un documento digital que será validado por el sistema.

**Atributos**:
- `documentoId`: String (UUID)
- `tipoDocumental`: String
- `nombreArchivo`: String
- `rutaGestorDocumental`: String (URI)
- `hashSHA256`: String (64 caracteres)
- `formatoDocumento`: String
- `tamanioBytes`: Long
- `requiereValidacionIA`: Boolean

### 2. Evaluacion (Aggregate Root)
**Descripción**: Representa el resultado de la evaluación de documentos con IA.

**Atributos principales**:
- `evaluacionId`: String (UUID)
- `solicitudId`: String (UUID)
- `tramiteId`: String
- `fechaEvaluacion`: LocalDateTime
- `modeloIAUtilizado`: String
- `tiempoProcesamientoMs`: Long
- `resultadoGeneral`: ResultadoGeneral
- `documentosEvaluados`: List<DocumentoEvaluado>
- `accionesRecomendadas`: List<AccionRecomendada>

**Objetos de valor anidados**:
- `ResultadoGeneral`: estado, scorePromedio, nivelRiesgo, alertaFraude, requiereRevisionManual, observacionesGenerales
- `DocumentoEvaluado`: documentoId, tipoDocumental, estadoEvaluacion, scoreConfiabilidad, nivelRiesgo, alertaFraude, observaciones, metricas
- `Observacion`: codigo, descripcion, severidad, evidencias
- `Metricas`: calidadImagen, legibilidadTexto, integridadEstructura, confianzaOCR
- `AccionRecomendada`: tipo, descripcion, prioridad

### 3. Verificacion (Aggregate Root)
**Descripción**: Representa el resultado de la verificación de firma y sello del registrador.

**Atributos principales**:
- `verificacionId`: String (UUID)
- `solicitudId`: String (UUID)
- `tramiteId`: String
- `documentoId`: String (UUID)
- `fechaVerificacion`: LocalDateTime
- `modeloIAUtilizado`: String
- `tiempoProcesamientoMs`: Long
- `resultadoGeneral`: ResultadoGeneral
- `verificacionFirma`: VerificacionFirma
- `verificacionSello`: VerificacionSello
- `verificacionPeriodo`: VerificacionPeriodo
- `datosRegistradorVerificado`: DatosRegistrador
- `alertas`: List<Alerta>
- `accionesRecomendadas`: List<AccionRecomendada>

**Objetos de valor anidados**:
- `ResultadoGeneral`: estadoVerificacion, firmaValida, selloValido, periodoValido, requiereRevisionManual, observacionesGenerales
- `VerificacionFirma`: estadoFirma, scoreSimilitud, nivelConfianza, firmaEncontradaEnBD, imagenFirmaDocumento, imagenFirmaReferencia, metricas
- `VerificacionSello`: estadoSello, scoreSimilitud, nivelConfianza, selloEncontradoEnBD, imagenSelloDocumento, imagenSelloReferencia, metricas
- `VerificacionPeriodo`: estadoPeriodo, registradorEncontrado, registradorHabilitado, fechaInscripcionActa, periodoHabilitacion, estadoRegistrador
- `Alerta`: codigo, tipo, descripcion, severidad

### 4. Registrador
**Descripción**: Representa los datos de un registrador civil.

**Atributos**:
- `numeroDniRegistrador`: String (8 caracteres)
- `idUsuario`: String
- `primerApellido`: String
- `segundoApellido`: String
- `prenombres`: String
- `codigoLocal`: String (6 caracteres)

---

## Mapeo de Tipos de Datos

### Reglas de Conversión (Especificación PDF → Java)

| Tipo en PDF | Tipo Java | Descripción |
|-------------|-----------|-------------|
| `string` | `String` | Cadenas de texto |
| `integer` / `int` | `Long` | Números enteros (se usa Long por seguridad) |
| `number` / `decimal` / `double` | `Double` | Números decimales |
| `boolean` | `Boolean` | Valores booleanos |
| `date` | `LocalDate` | Fechas sin hora |
| `datetime` / `timestamp` / `YYYY-MM-DDThh:mm:ssZ` | `LocalDateTime` | Fechas con hora (ISO 8601) |
| `array` / `list` | `List<T>` | Listas de elementos |
| `UUID` | `String` | Identificadores únicos (representados como String) |
| `Base64` | `String` | Imágenes codificadas en Base64 |
| `URI` | `String` | URLs y rutas |

### Notas sobre el Mapeo
- **Fechas**: Se utiliza `LocalDateTime` de Java 8+ para representar fechas en formato ISO 8601.
- **UUIDs**: Representados como `String` por simplicidad, sin dependencia de librerías UUID.
- **Números**: Se prefiere `Long` sobre `Integer` y `Double` sobre `Float` para mayor precisión.
- **Imágenes**: Representadas como `String` en Base64 según especificación del PDF.

---

## Puertos de Salida (Integraciones)

### Hacia Microservicios de Datos (MsData)

#### 1. EvaluacionDataPort
**Propósito**: Comunicación con MsDataValidadorDocumentos para persistir evaluaciones.

**Operaciones**:
- `guardarEvaluacion(Evaluacion)`: Guarda una evaluación
- `consultarEvaluacionPorId(String)`: Consulta evaluación por ID
- `consultarEvaluacionesPorSolicitud(String)`: Consulta evaluaciones de una solicitud

#### 2. VerificacionDataPort
**Propósito**: Comunicación con MsDataValidadorDocumentos para persistir verificaciones.

**Operaciones**:
- `guardarVerificacion(Verificacion)`: Guarda una verificación
- `consultarVerificacionPorId(String)`: Consulta verificación por ID
- `consultarVerificacionesPorSolicitud(String)`: Consulta verificaciones de una solicitud

#### 3. RegistradorDataPort
**Propósito**: Comunicación con MsDataRegistradores para consultar información de registradores.

**Operaciones**:
- `consultarRegistradorPorDni(String)`: Consulta registrador por DNI
- `consultarFirmaReferencia(String)`: Obtiene firma de referencia
- `consultarSelloReferencia(String)`: Obtiene sello de referencia
- `verificarHabilitacionEnFecha(String, LocalDateTime, String)`: Verifica habilitación del registrador

### Hacia Servicios Externos

#### 4. GestorDocumentalPort
**Propósito**: Comunicación con el sistema de gestión documental.

**Operaciones**:
- `obtenerDocumento(String)`: Obtiene contenido del documento
- `verificarIntegridadDocumento(String, String)`: Verifica hash SHA256
- `existeDocumento(String)`: Verifica existencia del documento

#### 5. ServicioIAPort
**Propósito**: Comunicación con el servicio de inteligencia artificial.

**Operaciones**:
- `evaluarDocumentos(SolicitudEvaluacionIA)`: Evalúa documentos con IA
- `compararFirma(String, String, Double)`: Compara firmas
- `compararSello(String, String, Double)`: Compara sellos
- `extraerFirma(byte[])`: Extrae firma de un documento
- `extraerSello(byte[])`: Extrae sello de un documento

---

## Limitaciones y Aclaraciones

### Neutralidad Tecnológica
Este proyecto está diseñado siguiendo estricta **neutralidad tecnológica**:

1. **Sin Frameworks**: No se utilizan Spring, JAX-RS, JPA, MapStruct, ni ningún framework.
2. **Sin Anotaciones**: Todo el código es POJO puro de Java.
3. **Sin Protocolo Definido**: Los adaptadores hacia servicios externos no especifican HTTP, SOAP, colas u otros protocolos.
4. **Compilable como Java Puro**: El código compila sin dependencias externas.

### Tipo de Microservicio: MsDominio

**Características clave**:
- ✅ Define **puertos de salida** hacia MsData (EvaluacionDataPort, VerificacionDataPort, RegistradorDataPort)
- ❌ **NO define RepositoryPort** (no tiene responsabilidad de persistencia directa)
- ✅ Implementa **lógica de negocio** de validación y evaluación de documentos
- ✅ Los **adaptadores no definen tecnología** (implementación a completar según stack técnico)

### Estado de Implementación

Este proyecto contiene la **estructura completa** de Arquitectura Hexagonal con:

- ✅ **Dominio**: Entidades, objetos de valor, puertos de entrada y salida
- ✅ **Aplicación**: Servicios de aplicación (casos de uso)
- ✅ **Infraestructura**: Controladores REST, DTOs, mappers y adaptadores

**Pendientes de implementación**:
- Lógica de negocio completa en los servicios de aplicación
- Conversión completa en los mappers (DTO ↔ Dominio)
- Implementación de adaptadores de salida (conexión real con MsData y servicios externos)
- Manejo de excepciones y validaciones
- Configuración de infraestructura (sin pom.xml ni build por neutralidad tecnológica)

### Endpoints Implementados

Según el PDF de especificación, este microservicio implementa **únicamente 2 endpoints**:
1. Calificar Documento
2. Verificar Firma del Registrador

**No se han agregado operaciones adicionales** que no estén documentadas en el PDF (sin inferencias).

### Códigos HTTP Estándar

Todos los endpoints implementan el conjunto estandarizado de códigos de respuesta HTTP:

| Código | Descripción |
|--------|-------------|
| 200    | OK - Operación completada exitosamente |
| 201    | Created - Recurso creado exitosamente |
| 400    | Bad Request - Parámetros inválidos o datos incompletos |
| 401    | Unauthorized - Token JWT inválido, expirado o ausente |
| 403    | Forbidden - Sin permisos suficientes |
| 404    | Not Found - Recurso no encontrado |
| 408    | Request Timeout - Tiempo de espera agotado |
| 409    | Conflict - Conflicto con el estado actual del recurso |
| 422    | Unprocessable Entity - Datos válidos pero no procesables |
| 429    | Too Many Requests - Límite de rate limit excedido |
| 500    | Internal Server Error - Error interno del servicio |
| 502    | Bad Gateway - Servicio externo no disponible |
| 503    | Service Unavailable - Servicio temporalmente no disponible |
| 504    | Gateway Timeout - Servicio externo no respondió a tiempo |

---

## Patrones y Prácticas Implementadas

### Patrones de Arquitectura
- **Arquitectura Hexagonal (Ports & Adapters)**: Separación estricta entre dominio, aplicación e infraestructura
- **Domain-Driven Design (DDD)**: Aggregate Roots (Evaluacion, Verificacion), Entidades, Objetos de Valor
- **Dependency Inversion**: El dominio no depende de la infraestructura; todo mediante interfaces (puertos)

### Patrones de Diseño Mencionados (para implementación futura)
- **Circuit Breaker**: Para resiliencia en llamadas a servicios de IA (status 503)
- **Retry**: Para tolerancia a fallos en integraciones externas
- **Rate Limiting**: Control de límites de peticiones (status 429)
- **Distributed Tracing**: Trazabilidad mediante X-Correlation-Id

---

## Próximos Pasos

Para completar la implementación del microservicio, se recomienda:

1. **Implementar lógica de negocio** en los servicios de aplicación (`CalificarDocumentoService`, `VerificarFirmaRegistradorService`)
2. **Completar mappers** para conversión entre DTOs y objetos de dominio
3. **Implementar adaptadores de salida** con la tecnología elegida (HTTP REST, gRPC, etc.)
4. **Agregar validaciones** de entrada en los casos de uso
5. **Implementar manejo de excepciones** y conversión a códigos HTTP apropiados
6. **Agregar configuración de build** (Maven/Gradle) según la tecnología elegida
7. **Implementar pruebas unitarias e integración** para cada capa
8. **Configurar observabilidad** (logging, métricas, tracing)
9. **Implementar seguridad** (validación JWT, autorización por roles)

---

## Información de Contacto

**Organización**: RENIEC - Registro Nacional de Identificación y Estado Civil  
**Sistema**: SIIRC - Sistema Integrado de Identificación y Registro Civil  
**Versión del Documento**: 1.0  
**Fecha**: 02/12/2025

---

## Licencia

Este proyecto es propiedad de RENIEC y está destinado para uso interno de la institución en el contexto de la modernización y transformación digital del Estado peruano.
