# MsDominioCircunscripciones

## 📋 Información General
- **Nombre:** MsDominioCircunscripciones
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.circunscripciones
- **Contexto:** Microservicio especializado de análisis y planificación geográfico-electoral dentro del SIIRC (Sistema Integrado de Información del Registro Civil). Su propósito principal es analizar los cambios de dirección de los ciudadanos, determinar las circunscripciones afectadas y generar planes óptimos de verificación domiciliaria para asegurar la integridad del padrón electoral.

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

- ✓ Define puertos de salida hacia MsData (`CircunscripcionDataPort`, `MigracionDataPort`, `InformeDataPort`, `ListadoDataPort`)
- ✓ Implementa adaptadores cliente (`CircunscripcionDataAdapter`, `MigracionDataAdapter`, `InformeDataAdapter`, `ListadoDataAdapter`)
- ✗ NO define `RepositoryPort` (delegado a MsData)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### 1. Análisis de Circunscripciones
- **Método:** POST
- **Ruta:** /api/v1/electoral/MsDominioCircunscripciones/analisis
- **Descripción:** Analiza cambios de domicilio en un rango temporal para identificar circunscripciones afectadas, detectar patrones anómalos y determinar población objetivo para verificación domiciliaria.
- **Request Body:**
  ```json
  {
    "cronogramaId": "string (UUID)",
    "tipoProceso": "string",
    "fechaInicio": "YYYY-MM-DD",
    "fechaFin": "YYYY-MM-DD",
    "departamentos": ["string"],
    "provincias": ["string"],
    "distritos": ["string"],
    "umbralAnomalia": "decimal",
    "incluirRAE": "boolean",
    "modoAnalisis": "string"
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "success": "boolean",
    "data": {
      "analisisId": "string (UUID)",
      "cronogramaId": "string (UUID)",
      "fechaAnalisis": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "periodoAnalizado": {
        "fechaInicio": "YYYY-MM-DD",
        "fechaFin": "YYYY-MM-DD"
      },
      "estadisticasGenerales": {
        "totalCambiosDomicilio": "integer",
        "totalCircunscripcionesAfectadas": "integer",
        "totalPoblacionVerificar": "integer",
        "promedioCambiosPorCircunscripcion": "decimal"
      },
      "circunscripcionesAfectadas": [...],
      "alertasDetectadas": [...],
      "recomendaciones": ["string"],
      "estadoAnalisis": "string",
      "tiempoProcesamientoMs": "integer"
    },
    "metadata": {...}
  }
  ```
- **Status Codes:**
  - 200: Análisis realizado exitosamente
  - 400: Parámetros de análisis inválidos o fechas incorrectas
  - 401: Token JWT inválido o expirado
  - 403: Usuario sin permisos para realizar análisis
  - 404: Cronograma no encontrado
  - 422: Período de análisis fuera de rango permitido
  - 429: Límite de rate limit excedido
  - 500: Error interno del servidor
  - 503: Servicio temporalmente no disponible

### 2. Consultar Migraciones Domiciliarias
- **Método:** GET
- **Ruta:** /api/v1/electoral/MsDominioCircunscripciones/migraciones
- **Descripción:** Consulta el historial de cambios de domicilio de un ciudadano específico o grupo de ciudadanos, proporcionando trazabilidad completa de migraciones y estado actual electoral.
- **Query Parameters:**
  - dni (string): Identificador utilizado como criterio de búsqueda
  - ubigeoOrigen (string): Código de ubicación de origen para el filtro
  - ubigeoDestino (string): Código de ubicación de destino para el filtro
  - fechaDesde (string): Fecha inicial del rango de consulta
  - fechaHasta (string): Fecha final del rango de consulta
  - tipoMovimiento (string): Tipo de movimiento empleado como parámetro de filtrado
  - incluirVerificados (boolean): Indica si deben considerarse registros verificados
  - page (integer): Número de página para la paginación
  - pageSize (integer): Cantidad de elementos por página
- **Response:** 200 OK
  ```json
  {
    "success": "boolean",
    "data": {
      "migraciones": [
        {
          "migracionId": "string",
          "dni": "string",
          "nombreCompleto": "string",
          "domicilioAnterior": {...},
          "domicilioNuevo": {...},
          "fechaCambio": "YYYY-MM-DDThh:mm:ss±hh:mm",
          "tipoMovimiento": "string",
          "estadoVerificacion": "string",
          "tieneAlertaRAE": "boolean",
          "circunscripcionElectoral": {...}
        }
      ],
      "paginacion": {
        "paginaActual": "integer",
        "tamanioPagina": "integer",
        "totalRegistros": "integer",
        "totalPaginas": "integer"
      }
    },
    "metadata": {...}
  }
  ```
- **Status Codes:**
  - 200: Consulta realizada exitosamente
  - 400: Parámetros de consulta inválidos
  - 401: Token JWT inválido o expirado
  - 403: Usuario sin permisos para consultar migraciones
  - 404: No se encontraron migraciones con los criterios especificados
  - 429: Límite de rate limit excedido
  - 500: Error interno del servidor
  - 503: Servicio temporalmente no disponible

### 3. Generar Informe Final
- **Método:** POST
- **Ruta:** /api/v1/electoral/MsDominioCircunscripciones/informe-final
- **Descripción:** Genera el informe final consolidado de verificación de domicilios para un cronograma específico, incluyendo estadísticas, resultados de trabajo de campo y recomendaciones para actualización del padrón electoral.
- **Request Body:**
  ```json
  {
    "cronogramaId": "string",
    "tipoInforme": "string",
    "circunscripcion": {
      "tipo": "string",
      "ubigeo": "string"
    },
    "incluirAnexos": "boolean",
    "incluirDescargos": "boolean"
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "success": "boolean",
    "data": {
      "informeId": "string",
      "cronogramaId": "string",
      "tipoInforme": "string",
      "fechaGeneracion": "YYYY-MM-DD",
      "circunscripcion": {...},
      "estadisticas": {...},
      "recomendaciones": [...],
      "documentoGenerado": {...},
      "estadoInforme": "string",
      "requiereAprobacion": "boolean",
      "proximoPaso": "string",
      "_links": {...}
    },
    "metadata": {...}
  }
  ```
- **Status Codes:**
  - 200: Informe generado exitosamente
  - 400: Parámetros de informe inválidos
  - 401: Token JWT inválido o expirado
  - 403: Usuario sin permisos para generar informes
  - 404: Cronograma no encontrado
  - 409: Ya existe un informe final para este cronograma
  - 422: Verificaciones incompletas, no se puede generar informe final
  - 429: Límite de rate limit excedido
  - 500: Error interno del servidor
  - 502: Error al comunicarse con gestor documental
  - 503: Servicio temporalmente no disponible

### 4. Generar Listados de Visitas
- **Método:** POST
- **Ruta:** /api/v1/electoral/MsDominioCircunscripciones/listados-visitas
- **Descripción:** Genera listados detallados de ciudadanos y direcciones para trabajo de campo de verificación domiciliaria, optimizados por rutas geográficas y equipos de verificación.
- **Request Body:**
  ```json
  {
    "cronogramaId": "string",
    "circunscripciones": ["string"],
    "tipoListado": "string",
    "optimizarRutas": "boolean",
    "equiposDisponibles": "integer",
    "ciudadanosPorEquipo": "integer",
    "incluirMapa": "boolean",
    "formatoSalida": "string",
    "prioridad": "string"
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "success": "boolean",
    "data": {
      "listadoId": "string",
      "cronogramaId": "string",
      "fechaGeneracion": "YYYY-MM-DDThh:mm:ss±hh:mm",
      "tipoListado": "string",
      "estadisticas": {...},
      "equiposGenerados": [...],
      "documentosGenerados": [...],
      "actasVirtualesGeneradas": [...],
      "_links": {...}
    },
    "metadata": {...}
  }
  ```
- **Status Codes:**
  - 200: Listados generados exitosamente
  - 400: Parámetros inválidos o circunscripciones no encontradas
  - 401: Token JWT inválido o expirado
  - 403: Usuario sin permisos para generar listados
  - 404: Cronograma no encontrado
  - 422: No hay población objetivo en las circunscripciones seleccionadas
  - 429: Límite de rate limit excedido
  - 500: Error interno del servidor
  - 503: Servicio temporalmente no disponible

## 🗂️ Entidades del Dominio

### AnalisisCircunscripcion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| analisisId | String | string (UUID) | Identificador único del análisis |
| cronogramaId | String | string (UUID) | Cronograma asociado |
| fechaAnalisis | LocalDateTime | YYYY-MM-DDThh:mm:ss±hh:mm | Fecha y hora del análisis |
| periodoAnalizado | PeriodoAnalizado | Object | Período analizado |
| estadisticasGenerales | EstadisticasGenerales | Object | Estadísticas generales |
| circunscripcionesAfectadas | List<CircunscripcionAfectada> | Array[Object] | Lista de circunscripciones |
| alertasDetectadas | List<Alerta> | Array[Object] | Alertas detectadas |
| recomendaciones | List<String> | Array[String] | Recomendaciones |
| estadoAnalisis | String | string (Enum) | Estado del análisis |
| tiempoProcesamientoMs | Integer | integer | Tiempo de procesamiento |

### MigracionDomiciliaria
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| migracionId | String | string (UUID) | Identificador único |
| dni | String | string | DNI del ciudadano |
| nombreCompleto | String | string | Nombre completo |
| domicilioAnterior | Domicilio | Object | Domicilio anterior |
| domicilioNuevo | Domicilio | Object | Domicilio nuevo |
| fechaCambio | LocalDateTime | YYYY-MM-DDThh:mm:ss±hh:mm | Fecha del cambio |
| tipoMovimiento | String | string (Enum) | Tipo de movimiento |
| estadoVerificacion | String | string (Enum) | Estado de verificación |
| tieneAlertaRAE | Boolean | boolean | Indica si tiene alerta |
| circunscripcionElectoral | CircunscripcionElectoral | Object | Circunscripción electoral |

### InformeFinal
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| informeId | String | string (UUID) | Identificador único |
| cronogramaId | String | string (UUID) | Cronograma asociado |
| tipoInforme | String | string (Enum) | PRELIMINAR o FINAL |
| fechaGeneracion | LocalDate | YYYY-MM-DD | Fecha de generación |
| circunscripcion | CircunscripcionInforme | Object | Circunscripción del informe |
| estadisticas | EstadisticasInforme | Object | Estadísticas del proceso |
| recomendaciones | List<Recomendacion> | Array[Object] | Recomendaciones |
| documentoGenerado | DocumentoGenerado | Object | Documento generado |
| estadoInforme | String | string (Enum) | Estado del informe |
| requiereAprobacion | Boolean | boolean | Indica si requiere aprobación |
| proximoPaso | String | string | Próximo paso en el flujo |

### ListadoVisitas
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| listadoId | String | string | Identificador único |
| cronogramaId | String | string | Cronograma asociado |
| fechaGeneracion | LocalDateTime | YYYY-MM-DDThh:mm:ss±hh:mm | Fecha de generación |
| tipoListado | String | string (Enum) | FISICO o VIRTUAL |
| estadisticas | EstadisticasListado | Object | Estadísticas del listado |
| equiposGenerados | List<EquipoGenerado> | Array[Object] | Equipos generados |
| documentosGenerados | List<DocumentoGenerado> | Array[Object] | Documentos generados |
| actasVirtualesGeneradas | List<ActaVirtual> | Array[Object] | Actas virtuales |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.circunscripciones/
├── domain/
│   ├── model/
│   │   ├── AnalisisCircunscripcion.java
│   │   ├── MigracionDomiciliaria.java
│   │   ├── InformeFinal.java
│   │   ├── ListadoVisitas.java
│   │   ├── PeriodoAnalizado.java
│   │   ├── EstadisticasGenerales.java
│   │   ├── CircunscripcionAfectada.java
│   │   ├── Alerta.java
│   │   ├── Domicilio.java
│   │   ├── CircunscripcionElectoral.java
│   │   ├── CircunscripcionInforme.java
│   │   ├── EstadisticasInforme.java
│   │   ├── Recomendacion.java
│   │   ├── DocumentoGenerado.java
│   │   ├── EstadisticasListado.java
│   │   ├── EquipoGenerado.java
│   │   └── ActaVirtual.java
│   │
│   └── ports/
│       ├── in/
│       │   ├── AnalisisCircunscripcionesUseCase.java
│       │   ├── ConsultarMigracionesDomiciliariasUseCase.java
│       │   ├── GenerarInformeFinalUseCase.java
│       │   └── GenerarListadosVisitasUseCase.java
│       │
│       └── out/
│           ├── CircunscripcionDataPort.java
│           ├── MigracionDataPort.java
│           ├── InformeDataPort.java
│           └── ListadoDataPort.java
│
├── application/
│   └── service/
│       ├── AnalisisCircunscripcionesService.java
│       ├── ConsultarMigracionesDomiciliariasService.java
│       ├── GenerarInformeFinalService.java
│       └── GenerarListadosVisitasService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── CircunscripcionesController.java
        │       │
        │       ├── dto/
        │       │   ├── AnalisisCircunscripcionRequestDto.java
        │       │   ├── AnalisisCircunscripcionResponseDto.java
        │       │   ├── InformeFinalRequestDto.java
        │       │   ├── InformeFinalResponseDto.java
        │       │   ├── ListadoVisitasRequestDto.java
        │       │   ├── ListadoVisitasResponseDto.java
        │       │   ├── MigracionesResponseDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorResponseDto.java
        │       │
        │       └── mapper/
        │           ├── AnalisisCircunscripcionDtoMapper.java
        │           ├── MigracionDtoMapper.java
        │           ├── InformeFinalDtoMapper.java
        │           └── ListadoVisitasDtoMapper.java
        │
        └── out/
            └── msdata/
                └── client/
                    ├── CircunscripcionDataAdapter.java
                    ├── MigracionDataAdapter.java
                    ├── InformeDataAdapter.java
                    └── ListadoDataAdapter.java
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException`
2. **Sin protocolo de integración:** Los adaptadores hacia MsData no definen HTTP/SOAP/colas
3. **Sin validaciones:** No se implementa lógica de validación
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones
5. **Neutralidad tecnológica:** El código está diseñado para ser independiente de frameworks específicos

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de negocio en servicios
3. Definir protocolo de integración con MsData (REST, gRPC, mensajería)
4. Agregar validaciones y manejo de errores
5. Implementar mappers con lógica real de transformación
6. Agregar tests unitarios e integración
7. Configurar seguridad (JWT, OAuth2)
8. Implementar logging y métricas
9. Configurar deployment y CI/CD

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsDominioCircunscripciones V1.2.pdf
- **Organización:** RENIEC (Registro Nacional de Identificación y Estado Civil)
- **Contexto:** Gestión de Seguridad Electrónica - Sistema de personalización del DNIe
