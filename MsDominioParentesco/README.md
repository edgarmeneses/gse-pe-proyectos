# Microservicio MsDominioParentesco

## Información General

- **Nombre**: MsDominioParentesco
- **Versión API**: 1.0
- **Contexto de Negocio**: Componente de lógica de negocio de la plataforma SIIRC especializado en el análisis, validación y certificación de vínculos familiares entre ciudadanos.
- **Paquete Base**: `pe.gob.reniec.dominioparentesco`
- **Tipo de Microservicio**: **Dominio** (NO gestiona persistencia directa)

## Descripción

El Microservicio Dominio Parentesco es el motor de inteligencia de negocio que orquesta el proceso completo de análisis de vínculos familiares. Su propósito principal es:

- Gestionar y centralizar la lógica de análisis de parentesco
- Verificar la coherencia de las relaciones familiares contra las reglas del registro civil peruano
- Generar automáticamente la población de posibles vínculos
- Coordinar la consulta de datos del APD para establecer cadenas de parentesco hasta el cuarto grado de consanguinidad y segundo de afinidad

## Arquitectura

Este microservicio implementa **Arquitectura Hexagonal** estricta con las siguientes características:

### Características Arquitectónicas

- ✅ **Sin frameworks**: Código Java puro sin dependencias de Spring, JAX-RS, JPA, etc.
- ✅ **Sin anotaciones**: POJOs e interfaces limpias
- ✅ **Puertos y Adaptadores**: Separación clara entre lógica de negocio e infraestructura
- ✅ **Independencia tecnológica**: El dominio no conoce detalles de implementación
- ✅ **Testeable**: Lógica de negocio aislada y fácilmente testeable

### Tipo: Microservicio de Dominio

Como **MsDominioParentesco**:
- ❌ NO define `RepositoryPort` (no gestiona persistencia)
- ✅ Define puertos de salida (`DataPort`) hacia otros microservicios:
  - `MsDatosParentesco`: Para guardar/consultar análisis
  - `MsSagaAPD`: Para validar datos del APD
  - `MsDatosActas`: Para consultar actas de registro civil
- ✅ Los adaptadores implementan estos puertos SIN definir el protocolo de conexión
- ✅ Orquesta la lógica de negocio y coordina con servicios externos

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/dominioparentesco/
├── domain/
│   ├── model/
│   │   ├── ResultadoAnalisisParentesco.java (Aggregate Root)
│   │   ├── SolicitudAnalisisParentesco.java (Value Object de entrada)
│   │   ├── CiudadanoAnalizado.java
│   │   ├── PoblacionVinculosPosibles.java
│   │   ├── VinculoConsanguineo.java
│   │   ├── VinculoAfinidad.java
│   │   ├── ResumenAnalisis.java
│   │   ├── Inconsistencia.java
│   │   ├── ActaPendienteDigitalizacion.java
│   │   ├── DatosCiudadano.java
│   │   ├── DatosAPD.java
│   │   ├── ActaSustento.java
│   │   ├── ConyugeIntermedio.java
│   │   ├── CriteriosBusqueda.java
│   │   ├── OpcionesAnalisis.java
│   │   └── RangoAnios.java
│   └── ports/
│       ├── in/
│       │   └── EjecutarAnalisisParentescoUseCase.java
│       └── out/
│           ├── AnalisisParentescoDataPort.java (hacia MsDatosParentesco)
│           ├── APDDataPort.java (hacia MsSagaAPD)
│           └── ActasDataPort.java (hacia MsDatosActas)
├── application/
│   └── service/
│       └── EjecutarAnalisisParentescoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── AnalisisParentescoController.java
        │       ├── dto/
        │       │   ├── EjecutarAnalisisRequestDto.java (record)
        │       │   ├── EjecutarAnalisisResponseDto.java (record)
        │       │   └── ErrorResponseDto.java (record)
        │       └── mapper/
        │           └── AnalisisParentescoDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    ├── AnalisisParentescoDataAdapter.java
                    ├── APDDataAdapter.java
                    └── ActasDataAdapter.java
```

## Endpoints

### POST /api/v1/parentesco/MsDominioParentesco/analisis/ejecutar

Ejecuta el proceso completo de análisis de vínculos de parentesco para un ciudadano.

#### Headers

| Header | Tipo | Requerido | Descripción |
|--------|------|-----------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación |
| `Content-Type` | String | Sí | application/json |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad |
| `X-Office-Code` | String | Sí | Código de oficina RENIEC (ej: ORG-LIMA-CENTRO) |
| `X-User-Role` | String | Sí | Rol: TECNICO_VINCULO, COORDINADOR_VINCULO |
| `X-Idempotency-Key` | UUID | Sí | Clave de idempotencia para evitar duplicados |

#### Request Body

```json
{
  "idSolicitud": "string",
  "idCiudadanoConsultado": "string",
  "datosCiudadano": {
    "nombre": "string",
    "fechaNacimiento": "YYYY-MM-DDTHH:MM:SSZ"
  },
  "codTipoVinculo": "string",
  "nivelComplejidad": "integer",
  "criteriosBusqueda": {
    "rangoAniosPadres": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "rangoAniosHijos": {
      "anioInicio": "integer",
      "anioFin": "integer"
    },
    "variacionesNombre": ["string"],
    "incluirFallecidos": "boolean",
    "incluirActasAnuladas": "boolean"
  },
  "opcionesAnalisis": {
    "generarArbolGenealogico": "boolean",
    "validarContraAPD": "boolean",
    "incluirActasSustento": "boolean",
    "detectarInconsistencias": "boolean"
  },
  "usuarioTecnico": "string",
  "observaciones": "string"
}
```

#### Response Body (200 OK)

```json
{
  "success": "boolean",
  "data": {
    "idSolicitud": "string",
    "idCiudadanoConsultado": "string",
    "codTipoVinculo": "string",
    "nivelComplejidad": "integer",
    "estadoSolicitud": "string",
    "ciudadanoAnalizado": {
      "idCiudadano": "string",
      "nombre": "string",
      "fechaNacimiento": "YYYY-MM-DDTHH:MM:SSZ",
      "datosAPD": {
        "version": "string",
        "ultimaActualizacion": "YYYY-MM-DDTHH:MM:SSZ",
        "estadoAPD": "string"
      }
    },
    "poblacionVinculosPosibles": {
      "totalEncontrados": "integer",
      "vinculosConsanguineos": [
        {
          "idRelacion": "integer",
          "idCiudadanoOrigen": "string",
          "idCiudadanoDestino": "string",
          "nombreCiudadanoDestino": "string",
          "codTipo": "string",
          "descripcionTipo": "string",
          "categoria": "string",
          "gradoMinimo": "integer",
          "esSimetrico": "string",
          "codInverso": "string",
          "fechaInicio": "YYYY-MM-DDTHH:MM:SSZ",
          "fechaFin": "YYYY-MM-DDTHH:MM:SSZ",
          "idActaSustento": "string",
          "actaSustento": {
            "idActa": "string",
            "tipoActa": "string",
            "fechaActa": "YYYY-MM-DDTHH:MM:SSZ",
            "lugarActa": "string"
          },
          "idDocumentoSustento": "string",
          "nivelConfianza": "number",
          "estadoConfirmacion": "string",
          "requiereValidacionManual": "boolean",
          "observacion": "string"
        }
      ],
      "vinculosAfinidad": [
        {
          "idRelacion": "integer",
          "conyugeIntermedio": {
            "idCiudadano": "string",
            "nombre": "string"
          }
        }
      ]
    },
    "resumenAnalisis": {
      "vinculosGrado1": "integer",
      "vinculosGrado2": "integer",
      "vinculosGrado3": "integer",
      "vinculosGrado4": "integer",
      "vinculosAfinidad": "integer",
      "actasConsultadas": "integer",
      "actasNoDigitalizadas": "integer",
      "inconsistenciasDetectadas": "integer"
    },
    "inconsistencias": [
      {
        "tipo": "string",
        "descripcion": "string",
        "ciudadanosInvolucrados": ["string"],
        "severidad": "string",
        "accionRecomendada": "string"
      }
    ],
    "actasPendientesDigitalizacion": [
      {
        "tipoActa": "string",
        "referenciaActa": "string",
        "lugarActa": "string",
        "observacion": "string"
      }
    ],
    "fechaSolicitud": "YYYY-MM-DDTHH:MM:SSZ",
    "tiempoProcesamientoMs": "integer",
    "usuarioTecnico": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDTHH:MM:SSZ",
    "correlationId": "string",
    "version": "string",
    "serviciosConsultados": {
      "msSagaAPD": "boolean",
      "msDatosActas": "boolean",
      "msDatosParentesco": "boolean"
    }
  }
}
```

#### Códigos de Respuesta HTTP

| Código | Descripción |
|--------|-------------|
| 200 | OK - Análisis ejecutado exitosamente |
| 202 | Accepted - Análisis iniciado, procesamiento asíncrono en curso |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos para ejecutar análisis de parentesco |
| 404 | Not Found - Ciudadano no encontrado en el sistema APD |
| 408 | Request Timeout - Tiempo de espera agotado al consultar servicios externos |
| 409 | Conflict - Ya existe un análisis activo para esta solicitud y ciudadano |
| 422 | Unprocessable Entity - Nivel de complejidad no válido para el tipo de vínculo |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - MsSagaAPD o MsDatosActas no disponible |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Timeout en consulta a servicios externos |

## Entidades del Dominio

### Aggregate Root

- **ResultadoAnalisisParentesco**: Resultado completo del análisis con vínculos encontrados, resumen e inconsistencias

### Value Objects

- **SolicitudAnalisisParentesco**: Entrada del caso de uso principal
- **CiudadanoAnalizado**: Datos del ciudadano analizado con información del APD
- **PoblacionVinculosPosibles**: Contenedor de vínculos encontrados
- **VinculoConsanguineo**: Vínculo por consanguinidad
- **VinculoAfinidad**: Vínculo por afinidad con cónyuge intermedio
- **ResumenAnalisis**: Estadísticas del análisis
- **Inconsistencia**: Inconsistencia detectada
- **ActaPendienteDigitalizacion**: Acta que requiere digitalización
- **DatosCiudadano**: Información básica del ciudadano
- **DatosAPD**: Datos del Archivo Personal Digitalizado
- **ActaSustento**: Acta de registro civil que sustenta un vínculo
- **ConyugeIntermedio**: Cónyuge que establece vínculo de afinidad
- **CriteriosBusqueda**: Parámetros de búsqueda
- **OpcionesAnalisis**: Opciones de configuración del análisis
- **RangoAnios**: Rango de años para criterios

### Mapeo de Tipos

| Tipo Especificación | Tipo Java |
|---------------------|-----------|
| string | String |
| integer | Integer |
| number/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp (YYYY-MM-DDTHH:MM:SSZ) | LocalDateTime |
| array | List<T> |

## Puertos de Salida (Integración con Otros Microservicios)

### AnalisisParentescoDataPort

Comunica con **MsDatosParentesco** para:
- `guardarAnalisis()`: Persiste el resultado del análisis
- `consultarAnalisis()`: Consulta un análisis específico
- `actualizarEstadoAnalisis()`: Actualiza el estado de un análisis

### APDDataPort

Comunica con **MsSagaAPD** para:
- `consultarAPD()`: Obtiene datos del Archivo Personal Digitalizado
- `validarVigenciaAPD()`: Valida que el APD esté vigente

### ActasDataPort

Comunica con **MsDatosActas** para:
- `consultarActasCiudadano()`: Obtiene actas de registro civil
- `consultarActaPorId()`: Consulta un acta específica
- `verificarActaDigitalizada()`: Verifica disponibilidad de acta

## Lógica de Negocio

El servicio `EjecutarAnalisisParentescoService` orquesta:

1. **Validación de APD**: Verifica vigencia del APD del ciudadano
2. **Construcción del ciudadano analizado**: Enriquece con datos del APD
3. **Consulta de actas**: Obtiene actas de nacimiento y matrimonio
4. **Análisis de vínculos**: Aplica algoritmos de detección de parentesco
   - Análisis de cadenas de parentesco
   - Generación de población de vínculos posibles
   - Validación contra criterios de búsqueda
5. **Generación de resumen**: Calcula estadísticas por grado
6. **Detección de inconsistencias**: Identifica conflictos y datos faltantes
7. **Identificación de actas pendientes**: Lista actas no digitalizadas
8. **Persistencia**: Guarda resultado en MsDatosParentesco

## Limitaciones y Consideraciones

### Neutralidad Tecnológica

- ✅ **Sin frameworks**: El código no depende de Spring, Quarkus, Micronaut, etc.
- ✅ **Sin anotaciones**: No hay @Entity, @Service, @RestController, etc.
- ✅ **Sin JPA/Hibernate**: No hay dependencias de persistencia
- ✅ **Sin librerías de mapeo**: No hay MapStruct, ModelMapper, etc.
- ✅ **Java puro**: Solo clases, interfaces, enums y tipos estándar de Java

### Protocolo de Conexión NO Definido

Los adaptadores de salida (`*DataAdapter`) NO especifican:
- ❌ HTTP (RestTemplate, WebClient, HttpClient)
- ❌ SOAP (JAX-WS, CXF)
- ❌ Mensajería (Kafka, RabbitMQ)
- ❌ gRPC
- ❌ GraphQL

**Decisión de implementación**: El protocolo se definirá al momento de integrar con la arquitectura real.

### Implementaciones Stub

Los siguientes componentes tienen implementaciones básicas que lanzan `UnsupportedOperationException`:
- Algoritmo de análisis de vínculos
- Adaptadores de datos (AnalisisParentescoDataAdapter, APDDataAdapter, ActasDataAdapter)
- Lógica de detección de inconsistencias

**Razón**: Se mantiene la estructura arquitectónica sin comprometerse con tecnologías específicas.

### Compilación

El código es **compilable como Java puro** (sin dependencias externas) usando:
```bash
javac -d target/classes src/main/java/pe/gob/reniec/dominioparentesco/**/*.java
```

## Integración con MsDatosParentesco

Este microservicio de dominio orquesta y coordina con MsDatosParentesco, que es responsable de:
- Persistencia de análisis
- Gestión de relaciones de parentesco
- Consultas y listados de análisis históricos

### Operaciones utilizadas de MsDatosParentesco

- `POST /api/v1/parentesco/MsDatosParentesco/analisis`: Guardar análisis
- `GET /api/v1/parentesco/MsDatosParentesco/analisis/{id}`: Consultar análisis
- `PUT /api/v1/parentesco/MsDatosParentesco/analisis/{id}`: Actualizar análisis

## Próximos Pasos para Implementación Real

1. **Seleccionar stack tecnológico**: Spring Boot, Quarkus, Micronaut, etc.
2. **Definir protocolo de comunicación**: REST (HTTP), SOAP, Mensajería, gRPC
3. **Implementar clientes de integración**: En los adaptadores de salida
4. **Completar algoritmo de análisis**: Lógica real de detección de vínculos
5. **Agregar validaciones**: Validación de entrada con Bean Validation o similar
6. **Implementar manejo de errores**: Try-catch, circuit breaker, retry, etc.
7. **Configurar observabilidad**: Logging, métricas, tracing distribuido
8. **Agregar tests**: Unitarios y de integración

## Contacto y Documentación

- **Especificación**: `Microservicio MsDominioParentesco V1.0.pdf`
- **Versión del documento**: 1.0
- **Fecha de generación**: 01/12/2025
