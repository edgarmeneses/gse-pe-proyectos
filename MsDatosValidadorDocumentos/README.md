# MsDatosValidadorDocumentos

## 📋 Información General
- **Nombre:** MsDatosValidadorDocumentos
- **Tipo:** MsData
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.validadordocumentos
- **Contexto:** Gestión de Seguridad Electrónica - RENIEC - Personalización del DNI Electrónico (DNIe)

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsData

El Microservicio MsDatosValidadorDocumentos es el componente de persistencia y acceso a datos dedicado exclusivamente al dominio de la validación documental. Su propósito principal es actuar como el único intermediario entre el Microservicio MsDominioValidadorDocumentos (orquestador) y la BD Validador Documentos.

- ✓ Define `RepositoryPort` para persistencia
- ✓ Define `Entities` sin anotaciones JPA
- ✓ Implementa `RepositoryAdapter`
- ✗ NO define `DataPort` (esto es para MsDominio)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Registrar Evaluación de Documento
- **Método:** POST
- **Ruta:** /api/v1/documentos/MsDatosValidadorDocumentos/evaluacion
- **API Gateway:** Interno
- **Protocolo:** REST/HTTP
- **Headers:**
  - Authorization: String (Bearer token JWT para autenticación del usuario)
  - Content-Type: application/json
  - X-Correlation-Id: UUID (Identificador único de correlación para trazabilidad end-to-end)
  - X-Usuario-Id: String (ID del usuario que realizó la evaluación)
  - X-Oficina-Id: String (ID de la oficina donde se realizó la evaluación)

- **Request Body:**
  ```json
  {
    "evaluacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "fechaEvaluacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": "integer",
    "resultadoGeneral": {
      "estado": "string",
      "scorePromedio": "decimal",
      "nivelRiesgo": "string",
      "alertaFraude": "boolean",
      "requiereRevisionManual": "boolean",
      "observacionesGenerales": "string"
    },
    "documentosEvaluados": [
      {
        "documentoId": "string (UUID)",
        "tipoDocumental": "string",
        "nombreArchivo": "string",
        "estadoEvaluacion": "string",
        "scoreConfiabilidad": "decimal",
        "nivelRiesgo": "string",
        "alertaFraude": "boolean",
        "observaciones": [
          {
            "codigo": "string",
            "descripcion": "string",
            "severidad": "string",
            "evidencias": ["string"]
          }
        ],
        "metricas": {
          "calidadImagen": "decimal",
          "legibilidadTexto": "decimal",
          "integridadEstructura": "decimal",
          "confianzaOCR": "decimal"
        },
        "tiempoProcesamientoMs": "integer"
      }
    ],
    "accionesRecomendadas": [
      {
        "tipo": "string",
        "descripcion": "string",
        "prioridad": "string"
      }
    ],
    "usuarioSolicita": "string",
    "oficinaOrigen": "string"
  }
  ```

- **Response:** 201 Created
  ```json
  {
    "success": "boolean",
    "data": {
      "evaluacionId": "string (UUID)",
      "solicitudId": "string (UUID)",
      "tramiteId": "string",
      "fechaRegistro": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "estadoPersistencia": "string",
      "registrosCreados": {
        "evaluacionGeneral": "integer",
        "documentosEvaluados": "integer",
        "observaciones": "integer",
        "metricas": "integer",
        "accionesRecomendadas": "integer"
      }
    },
    "metadata": {
      "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "correlationId": "string (UUID)",
      "version": "string"
    }
  }
  ```

- **Error Response:**
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

- **Códigos de Estado:**
  - 200 OK - Operación completada exitosamente
  - 201 Created - Evaluación registrada exitosamente
  - 400 Bad Request - Datos de evaluación inválidos, incompletos o formato JSON inválido
  - 401 Unauthorized - Token JWT inválido o expirado
  - 403 Forbidden - Usuario sin permisos para registrar evaluaciones
  - 409 Conflict - Conflicto de integridad referencial
  - 422 Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio
  - 429 Too Many Requests - Límite de rate limit excedido
  - 500 Internal Server Error - Error interno al persistir en base de datos
  - 503 Service Unavailable - Base de datos temporalmente no disponible
  - 504 Gateway Timeout - Timeout al intentar persistir en base de datos

## 🗂️ Entidades del Dominio

### EvaluacionDocumento (Aggregate Root)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| evaluacionId | String | string (UUID) | Identificador único |
| solicitudId | String | string (UUID) | Identificador de la solicitud |
| tramiteId | String | string | Identificador del trámite |
| fechaEvaluacion | LocalDateTime | string (Date ISO 8601) | Fecha y hora de evaluación |
| modeloIAUtilizado | String | string | Modelo de IA utilizado |
| tiempoProcesamientoMs | Integer | integer | Tiempo de procesamiento en ms |
| resultadoGeneral | ResultadoGeneral | object | Resultado general de la evaluación |
| documentosEvaluados | List<DocumentoEvaluado> | array | Lista de documentos evaluados (1-20) |
| accionesRecomendadas | List<AccionRecomendada> | array | Acciones recomendadas (0-10) |
| usuarioSolicita | String | string | Usuario que solicita |
| oficinaOrigen | String | string | Oficina de origen |

### ResultadoGeneral (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| estado | String | string | Estado del resultado |
| scorePromedio | Double | decimal | Score promedio |
| nivelRiesgo | String | string | Nivel de riesgo |
| alertaFraude | Boolean | boolean | Indica alerta de fraude |
| requiereRevisionManual | Boolean | boolean | Requiere revisión manual |
| observacionesGenerales | String | string | Observaciones generales (opcional) |

### DocumentoEvaluado (Entity)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| documentoId | String | string (UUID) | Identificador único |
| tipoDocumental | String | string | Tipo de documento |
| nombreArchivo | String | string | Nombre del archivo |
| estadoEvaluacion | String | string | Estado de evaluación |
| scoreConfiabilidad | Double | decimal | Score de confiabilidad |
| nivelRiesgo | String | string | Nivel de riesgo |
| alertaFraude | Boolean | boolean | Indica alerta de fraude |
| observaciones | List<Observacion> | array | Lista de observaciones (0-50) |
| metricas | Metricas | object | Métricas técnicas (opcional) |
| tiempoProcesamientoMs | Integer | integer | Tiempo de procesamiento |

### Observacion (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| codigo | String | string | Código de observación |
| descripcion | String | string | Descripción |
| severidad | String | string | Severidad |
| evidencias | List<String> | array | Lista de evidencias (0-20) |

### Metricas (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| calidadImagen | Double | decimal | Calidad de imagen |
| legibilidadTexto | Double | decimal | Legibilidad del texto |
| integridadEstructura | Double | decimal | Integridad de estructura |
| confianzaOCR | Double | decimal | Confianza OCR |

### AccionRecomendada (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| tipo | String | string | Tipo de acción |
| descripcion | String | string | Descripción |
| prioridad | String | string | Prioridad |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.validadordocumentos/
├── domain/
│   ├── model/
│   │   ├── EvaluacionDocumento.java
│   │   ├── ResultadoGeneral.java
│   │   ├── DocumentoEvaluado.java
│   │   ├── Observacion.java
│   │   ├── Metricas.java
│   │   └── AccionRecomendada.java
│   └── ports/
│       ├── in/
│       │   └── RegistrarEvaluacionDocumentoUseCase.java
│       └── out/
│           └── EvaluacionDocumentoRepositoryPort.java
├── application/
│   └── service/
│       └── RegistrarEvaluacionDocumentoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── EvaluacionDocumentoController.java
        │       ├── dto/
        │       │   ├── EvaluacionDocumentoRequestDto.java
        │       │   ├── EvaluacionDocumentoResponseDto.java
        │       │   ├── EvaluacionDataDto.java
        │       │   ├── ResultadoGeneralDto.java
        │       │   ├── DocumentoEvaluadoDto.java
        │       │   ├── ObservacionDto.java
        │       │   ├── MetricasDto.java
        │       │   ├── AccionRecomendadaDto.java
        │       │   ├── RegistrosCreadosDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── ErrorDetailDto.java
        │       └── mapper/
        │           └── EvaluacionDocumentoDtoMapper.java
        └── out/
            └── persistence/
                ├── entity/
                │   └── EvaluacionDocumentoEntity.java
                ├── mapper/
                │   └── EvaluacionDocumentoPersistenceMapper.java
                └── EvaluacionDocumentoRepositoryAdapter.java
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException`
2. **Sin tecnología de persistencia:** El adaptador no implementa acceso real a base de datos (requiere JDBC, JPA, MyBatis, etc.)
3. **Sin validaciones:** No se implementa lógica de validación de datos
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones
5. **Sin framework web:** El controller es un POJO y requiere integración con un framework web (Spring Boot, Quarkus, etc.)
6. **Modelo simplificado:** Las entidades de persistencia tienen una estructura simplificada (desnormalización del resultado general)

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de negocio en servicios
3. Configurar persistencia (JPA, JDBC, MyBatis, etc.)
4. Diseñar y crear esquema de base de datos con tablas relacionadas:
   - evaluaciones_generales
   - documentos_evaluados
   - observaciones_documentos
   - metricas_tecnicas
   - acciones_recomendadas
5. Implementar RepositoryAdapter con acceso real a base de datos
6. Agregar validaciones de datos de entrada (Bean Validation, validaciones custom)
7. Implementar manejo de errores y excepciones
8. Implementar mappers con lógica completa de transformación
9. Agregar logging y trazabilidad distribuida
10. Configurar seguridad (JWT, OAuth2, etc.)
11. Agregar tests unitarios e integración
12. Configurar API Gateway y routing
13. Implementar métricas y observabilidad

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsDatosValidadorDocumentos V1.2.pdf
- **Generado por:** Claude Code - Arquitectura Hexagonal Generator
- **Documentación de referencia:** AGENT_PROMPT_MEJORADO.md

## 📚 Documentación Adicional

### Mapeo de Tipos de Datos

| Tipo en PDF | Tipo Java | Notas |
|-------------|-----------|-------|
| string | String | Tipo por defecto |
| string (UUID) | String | Sin validación UUID implementada |
| string (Date ISO 8601) | LocalDateTime | Formato: YYYY-MM-DDThh:mm:ss±hh:mm |
| integer | Integer | Números enteros |
| decimal | Double | Números decimales |
| boolean | Boolean | Valores true/false |
| array | List<T> | Listas genéricas de Java |
| object | Class | Clases Java específicas |

### Convenciones de Nomenclatura

- **Puertos de entrada:** {Verbo}{Entidad}UseCase
- **Puertos de salida (MsData):** {Entidad}RepositoryPort
- **Servicios:** {Verbo}{Entidad}Service
- **Controllers:** {Entidad}Controller
- **DTOs Request:** {Entidad}RequestDto
- **DTOs Response:** {Entidad}ResponseDto
- **Entities (Persistencia):** {Entidad}Entity
- **Mappers (REST):** {Entidad}DtoMapper
- **Mappers (Persistence):** {Entidad}PersistenceMapper
- **Adapters (MsData):** {Entidad}RepositoryAdapter
