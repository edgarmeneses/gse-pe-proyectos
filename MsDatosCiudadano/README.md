# MsDatosCiudadano

## Resumen del Microservicio

**Nombre:** MsDatosCiudadano  
**Tipo:** Microservicio de Datos (MsData)  
**Versión API:** v1  
**Paquete Base:** `pe.gob.reniec.msdatosciudadano`  
**Contexto de Negocio:** Gestión centralizada de la información de identificación (DNI) de los ciudadanos peruanos para el sistema de personalización del DNI Electrónico de RENIEC.

### Características del Proyecto

Este proyecto implementa una **Arquitectura Hexagonal estricta** siguiendo los principios de **Domain-Driven Design (DDD)** sin dependencias a frameworks específicos:

- ✅ **Sin Frameworks:** Código Java puro sin anotaciones de Spring, JPA, JAX-RS, MapStruct, etc.
- ✅ **POJOs puros:** Todas las clases son Plain Old Java Objects sin anotaciones tecnológicas
- ✅ **Puertos e Interfaces:** Separación clara entre dominio, aplicación e infraestructura
- ✅ **DTOs como Records:** Uso de Java Records para objetos de transferencia de datos
- ✅ **RepositoryPort:** Como MsData, define interfaces de repositorio y sus adaptadores
- ✅ **Neutralidad tecnológica:** No se define protocolo de conexión ni persistencia específica

## Tipo de Microservicio: MsData

Según la clasificación del proyecto, **MsDatosCiudadano es un microservicio de DATOS (MsData)**, lo que significa:

### Características Estructurales de MsData:

1. **SÍ define RepositoryPort**: Interfaces para acceso a datos en `domain/ports/out`
2. **SÍ tiene RepositoryAdapter**: Implementaciones de repositorios en `infrastructure/adapters/out/persistence`
3. **SÍ define Entities**: POJOs en `infrastructure/adapters/out/persistence/entity` (sin anotaciones JPA)
4. **NO es MsDominio**: No requiere puertos hacia otros microservicios de datos externos
5. **Puertos IN/OUT completos**: Define casos de uso (in) y repositorios (out) según endpoints del PDF

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/msdatosciudadano/
├── domain/
│   ├── model/                                    # Aggregate Roots y Value Objects
│   │   ├── Ciudadano.java                       # Aggregate Root principal
│   │   ├── Alerta.java
│   │   ├── CambioDomicilio.java
│   │   ├── ConfiguracionCotejo.java
│   │   ├── Contacto.java
│   │   ├── CotejoMasivo.java
│   │   ├── DatosBiometricos.java
│   │   ├── DireccionResidencia.java
│   │   ├── EntidadSolicitante.java
│   │   ├── FirmaDigital.java
│   │   ├── Fotografia.java
│   │   ├── HuellaDactilar.java
│   │   ├── InformacionElectoral.java
│   │   ├── InformacionParental.java
│   │   ├── InformePericial.java
│   │   └── RegistroCotejo.java
│   └── ports/
│       ├── in/                                   # Casos de uso (interfaces)
│       │   ├── ActualizarCiudadanoUseCase.java
│       │   ├── ConsultaMasivaUseCase.java
│       │   ├── ConsultarAlertaUseCase.java
│       │   ├── ConsultarCambiosDomicilioUseCase.java
│       │   ├── ConsultarCiudadanoUseCase.java
│       │   ├── ConsultarInformePericialUseCase.java
│       │   ├── CrearAlertaUseCase.java
│       │   ├── CrearCiudadanoUseCase.java
│       │   ├── ListarAlertaUseCase.java
│       │   └── ListarCiudadanosUseCase.java
│       └── out/                                  # Puertos de repositorio (MsData)
│           ├── AlertaRepositoryPort.java
│           ├── CambioDomicilioRepositoryPort.java
│           ├── CiudadanoRepositoryPort.java
│           ├── CotejoMasivoRepositoryPort.java
│           └── InformePericialRepositoryPort.java
├── application/
│   └── service/                                  # Implementación de casos de uso
│       ├── ActualizarCiudadanoService.java
│       ├── ConsultaMasivaService.java
│       ├── ConsultarAlertaService.java
│       ├── ConsultarCambiosDomicilioService.java
│       ├── ConsultarCiudadanoService.java
│       ├── ConsultarInformePericialService.java
│       ├── CrearAlertaService.java
│       ├── CrearCiudadanoService.java
│       ├── ListarAlertaService.java
│       └── ListarCiudadanosService.java
└── infrastructure/
    └── adapters/
        ├── in/                                   # Adaptadores de entrada
        │   └── rest/
        │       ├── controller/
        │       │   ├── AlertaController.java    # Sin anotaciones
        │       │   ├── CiudadanoController.java
        │       │   └── ConsultasController.java
        │       ├── dto/                          # Java Records
        │       │   ├── AlertaResponseDto.java
        │       │   ├── CiudadanoResponseDto.java
        │       │   ├── ConfiguracionCotejoDto.java
        │       │   ├── ConsultaMasivaRequestDto.java
        │       │   ├── ContactoDto.java
        │       │   ├── CrearAlertaRequestDto.java
        │       │   ├── CrearCiudadanoRequestDto.java
        │       │   ├── DatosBiometricosDto.java
        │       │   ├── DireccionResidenciaDto.java
        │       │   ├── EntidadSolicitanteDto.java
        │       │   ├── ErrorDetalleDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   ├── FirmaDigitalDto.java
        │       │   ├── FotografiaDto.java
        │       │   ├── HuellaDactilarDto.java
        │       │   ├── InformacionElectoralDto.java
        │       │   ├── InformacionParentalDto.java
        │       │   └── RegistroCotejoDto.java
        │       └── mapper/                       # Conversión DTO ↔ Domain
        │           ├── AlertaDtoMapper.java
        │           ├── CiudadanoDtoMapper.java
        │           └── CotejoMasivoDtoMapper.java
        └── out/
            └── persistence/                       # MsData: Adaptadores de repositorio
                ├── entity/                        # Entidades de persistencia (POJOs)
                │   ├── AlertaEntity.java
                │   └── CiudadanoEntity.java
                ├── mapper/                        # Conversión Entity ↔ Domain
                │   ├── AlertaPersistenceMapper.java
                │   └── CiudadanoPersistenceMapper.java
                └── [repositorios]                 # Implementan RepositoryPort
                    ├── AlertaRepositoryAdapter.java
                    ├── CambioDomicilioRepositoryAdapter.java
                    ├── CiudadanoRepositoryAdapter.java
                    ├── CotejoMasivoRepositoryAdapter.java
                    └── InformePericialRepositoryAdapter.java
```

## Endpoints Documentados

Todos los endpoints están extraídos del documento de especificación PDF y solo se implementan aquellos que aparecen explícitamente documentados.

### 1. Crear Ciudadano

**Path:** `/api/v1/ciudadano/MsDatosCiudadano`  
**Método:** `POST`  
**Headers:**
- `Content-Type: multipart/form-data`
- `Authorization: Bearer <token>` (JWT para autenticación)
- `X-Correlation-ID: <UUID>` (ID de correlación para trazabilidad)
- `X-Request-Source: <string>` (origen: CoreService, IdentityValidation, SolicitudesService)
- `X-Retry-Attempt: <integer>` (0 para primera llamada, máx 3)
- `X-Office-Code: <string>` (Código de oficina RENIEC, formato: ORG-LIMA-CENTRO)

**Request Body:** JSON con datos completos del ciudadano
```json
{
  "estado": "string",
  "tipoDocumento": "string",
  "numeroDocumento": "string",
  "primerNombre": "string",
  "segundoNombre": "string",
  "primerApellido": "string",
  "segundoApellido": "string",
  "fechaNacimiento": "YYYY-MM-DD",
  "sexo": "string",
  "estadoCivil": "string",
  "nacionalidad": "string",
  "paisNacimiento": "string",
  "departamentoNacimiento": "string",
  "provinciaNacimiento": "string",
  "distritoNacimiento": "string",
  "grupoSanguineo": "string",
  "estatura": "string",
  "informacionParental": { /* ... */ },
  "direccionResidencia": { /* ... */ },
  "contacto": { /* ... */ },
  "informacionElectoral": { /* ... */ },
  "datosBiometricos": { /* ... */ }
}
```

**Response (201 Created):**
```json
{
  "id": "string",
  "fechaCreacion": "YYYY-MM-DDThh:mm:ss±hh:mm"
}
```

**Códigos de Estado:**
- `201` Created - Ciudadano creado exitosamente
- `400` Bad Request - Parámetros incorrectos
- `401` Unauthorized - Token inválido o ausente
- `403` Forbidden - Sin permisos
- `408` Request Timeout - Tiempo de espera agotado
- `413` Payload Too Large - Más de 500 registros o >50MB
- `422` Unprocessable Entity - Datos válidos pero no procesables
- `429` Too Many Requests - Límite excedido (100 req/hora)

---

### 2. Actualizar Ciudadano

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/{id}`  
**Método:** `PUT`  
**Path Parameters:**
- `id` (string, requerido) - Identificador del ciudadano

**Headers:** Igual que Crear Ciudadano

**Request Body:** JSON con datos del ciudadano a actualizar (misma estructura que Crear)

**Response (200 OK):**
```json
{
  "id": "string",
  "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
  "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
  "datosActualizados": ["campo1", "campo2"]
}
```

**Códigos de Estado:**
- `200` OK - Ciudadano actualizado exitosamente
- `400` Bad Request - Parámetros inválidos o estructura incorrecta
- `401` Unauthorized - Token JWT inválido, expirado o ausente
- `403` Forbidden - Sin permisos para actualizar el ciudadano
- `408` Request Timeout - Tiempo de espera agotado

---

### 3. Obtener Ciudadano

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/documento`  
**Método:** `GET`  
**Query Parameters:**
- `tipoDocumento` (string, requerido, long: 1-50)
- `numeroDocumento` (string, requerido, long: 1-50)

**Headers:** Igual que endpoints anteriores

**Response (200 OK):**
```json
{
  "tipoDocumento": "string",
  "numeroDocumento": "string",
  "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
  "fechaActualizacion": "YYYY-MM-DDThh:mm:ssZ",
  "ciudadano": { /* objeto completo */ },
  "estado": "string"
}
```

**Códigos de Estado:**
- `200` OK - Ciudadano encontrado exitosamente
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos para obtener el ciudadano
- `404` Not Found - No se encontró el ciudadano solicitado
- `408` Request Timeout - Tiempo de espera agotado
- `429` Too Many Requests - Límite de rate limit excedido

---

### 4. Listar Ciudadanos

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/ciudadano`  
**Método:** `GET`  
**Query Parameters:**
- `page` (integer, requerido, mín: 1)
- `size` (integer, requerido, mín: 1)
- `queryParam1` (string, opcional, long: 1-20)
- `queryParam2` (string, opcional, long: 1-20)
- `queryParam3` (string, opcional, long: 1-20)
- `fields` (array of string, opcional) - Campos específicos a retornar

**Response (200 OK):**
```json
{
  "page": {
    "number": 1,
    "size": 10,
    "totalElements": 100,
    "totalPages": 10,
    "hasNext": true
  },
  "contenido": [
    { /* ciudadano 1 */ },
    { /* ciudadano 2 */ }
  ]
}
```

**Códigos de Estado:**
- `200` OK - Consulta exitosa
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `404` Not Found - Sin resultados
- `408` Request Timeout - Tiempo de espera agotado
- `429` Too Many Requests - Límite excedido

---

### 5. Consultar Informe Pericial

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/informes-periciales`  
**Método:** `GET`  
**Query Parameters:**
- `tipoDocumento` (string, requerido)
- `numeroDocumento` (string, requerido)

**Response (200 OK):**
```json
{
  "informes": [
    {
      "informeId": "string",
      "tipoInforme": "string",
      "fechaInforme": "YYYY-MM-DDThh:mm:ssZ",
      "urlPdf": "string"
    }
  ]
}
```

**Códigos de Estado:**
- `200` OK - Informe pericial encontrado exitosamente
- `204` No Content - No se encontró información pericial
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `404` Not Found - Ciudadano no encontrado

---

### 6. Crear Alerta

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`  
**Método:** `POST`  
**Request Body:**
```json
{
  "situacion": "A|B|C",
  "ciudadanoId": "string",
  "motivo": "string",
  "fechaDeteccion": "YYYY-MM-DDThh:mm:ssZ",
  "circunscripcionId": "string",
  "medioVerificacion": "fisico|virtual",
  "documentoSoporteId": "string",
  "equipoTrabajoId": "string"
}
```

**Response (201 Created):**
```json
{
  "id": "string",
  "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ",
  "estado": "string"
}
```

**Códigos de Estado:**
- `201` Created - Alerta creada exitosamente
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos para crear la alerta
- `404` Not Found - El ciudadano no existe
- `409` Conflict - Alerta duplicada

---

### 7. Listar Alertas

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`  
**Método:** `GET`  
**Query Parameters:** Similar a Listar Ciudadanos (page, size, queryParam1-3, fields)

**Response (200 OK):** Paginación con lista de alertas (misma estructura que Listar Ciudadanos)

**Códigos de Estado:**
- `200` OK - Alertas encontradas exitosamente
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `404` Not Found - No se encontró la alerta
- `408` Request Timeout - Tiempo de espera agotado
- `429` Too Many Requests - Límite de rate limit excedido

---

### 8. Consultar Alerta

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/alerta`  
**Método:** `GET`  
**Query Parameters:**
- `alertaId` (string, requerido)

**Response (200 OK):** Detalle completo de la alerta específica

**Códigos de Estado:**
- `200` OK - Alerta encontrada
- `400` Bad Request - Parámetros incorrectos
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `404` Not Found - Alerta no encontrada
- `408` Request Timeout - Tiempo de espera agotado
- `429` Too Many Requests - Límite excedido
- `500` Internal Server Error - Error interno
- `502` Bad Gateway - Servicio externo no disponible
- `503` Service Unavailable - Servicio temporalmente no disponible

---

### 9. Consultar Cambios Domicilio

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/cambio-domicilio`  
**Método:** `GET`  
**Query Parameters:**
- `fechaDesde` (string YYYY-MM-DD, requerido)
- `fechaHasta` (string YYYY-MM-DD, requerido)
- `circunscripcionId` (string, opcional)
- `queryParam1`, `queryParam2`, `queryParam3` (string, opcional)

**Response (200 OK):**
```json
{
  "circunscripciones": [
    {
      "circunscripcionId": "string",
      "totalCambios": 0,
      "promedio": 0.0,
      "migraciones": [
        {
          "tipoDocumento": "string",
          "numeroDocumento": "string",
          "domicilio": {
            "departamento": "string",
            "provincia": "string",
            "distrito": "string"
          }
        }
      ]
    }
  ]
}
```

**Códigos de Estado:**
- `200` OK - Consulta realizada exitosamente
- `204` No Content - No se encontró resultado para los filtros
- `400` Bad Request - Información incorrecta en los filtros
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `404` Not Found - Circunscripción no encontrada
- `408` Request Timeout - Tiempo de espera agotado
- `429` Too Many Requests - Límite excedido
- `500` Internal Server Error - El sistema no responde

---

### 10. Consulta Masiva

**Path:** `/api/v1/ciudadano/MsDatosCiudadano/consulta-masiva`  
**Método:** `POST`  
**Request Body:**
```json
{
  "solicitudId": "string",
  "registros": [
    {
      "numeroSecuencia": "string",
      "tipoDocumento": "string",
      "numeroDocumento": "string"
    }
  ]
}
```

**Response (200 OK / 202 Accepted):**
```json
{
  "solicitudId": "string",
  "fechaProcesamiento": "YYYY-MM-DDThh:mm:ssZ",
  "estadoProceso": "string",
  "resultados": [
    {
      "numeroSecuencia": "string",
      "tipoDocumento": "string",
      "numeroDocumento": "string",
      "estadoConsulta": "ENCONTRADO|NO_ENCONTRADO|ERROR",
      "datosCiudadano": {
        "primerApellido": "string",
        "segundoApellido": "string",
        "prenombres": "string",
        "fechaNacimiento": "YYYY-MM-DD",
        "sexo": "string",
        "estadoCivil": "string",
        "ubigeo": "string",
        "direccion": "string"
      }
    }
  ]
}
```

**Códigos de Estado:**
- `200` OK - Cotejo completado síncronamente (lote pequeño)
- `202` Accepted - Cotejo masivo aceptado, procesamiento en curso
- `400` Bad Request - Parámetros incorrectos
- `401` Unauthorized - Token JWT inválido
- `403` Forbidden - Sin permisos
- `408` Request Timeout - Tiempo de espera agotado
- `413` Payload Too Large - Más de 500 registros
- `422` Unprocessable Entity - Datos válidos pero no procesables
- `429` Too Many Requests - Límite excedido
- `500` Internal Server Error - Error interno
- `502` Bad Gateway - Servicio externo no disponible
- `503` Service Unavailable - Servicio temporalmente no disponible

---

## Entidades del Dominio

### Ciudadano (Aggregate Root)

Representa la información completa de un ciudadano peruano.

**Atributos principales:**
- `id: String` - Identificador único
- `tipoDocumento: String` - Tipo de documento (DNI, CE, etc.)
- `numeroDocumento: String` - Número de documento
- `primerNombre: String`
- `segundoNombre: String`
- `primerApellido: String`
- `segundoApellido: String`
- `fechaNacimiento: LocalDate`
- `sexo: String` - M/F
- `estadoCivil: String`
- `nacionalidad: String`
- `paisNacimiento: String`
- `departamentoNacimiento: String`
- `provinciaNacimiento: String`
- `distritoNacimiento: String`
- `grupoSanguineo: String`
- `estatura: String`
- `estado: String` - Estado del registro (activo, inactivo, etc.)
- `fechaCreacion: LocalDateTime`
- `fechaActualizacion: LocalDateTime`

**Objetos de valor asociados:**
- `informacionParental: InformacionParental` - Datos de padre y madre
- `direccionResidencia: DireccionResidencia` - Dirección completa
- `contacto: Contacto` - Teléfonos y correos
- `informacionElectoral: InformacionElectoral` - Datos electorales
- `datosBiometricos: DatosBiometricos` - Huellas, fotos, firma

---

### Alerta

Representa una alerta de domicilio asociada a un ciudadano.

**Atributos:**
- `id: String`
- `ciudadanoId: String`
- `situacion: String` - A, B o C (según normativa)
- `motivo: String`
- `fechaDeteccion: LocalDateTime`
- `circunscripcionId: String`
- `medioVerificacion: String` - físico o virtual
- `documentoSoporteId: String`
- `equipoTrabajoId: String`
- `fechaCreacion: LocalDateTime`
- `fechaActualizacion: LocalDateTime`
- `estado: String`

---

### InformePericial

Representa un informe pericial registrado para un ciudadano.

**Atributos:**
- `informeId: String`
- `tipoInforme: String`
- `fechaInforme: LocalDateTime`
- `urlPdf: String`

---

### CotejoMasivo

Representa una solicitud de cotejo masivo de ciudadanos.

**Atributos:**
- `solicitudId: String`
- `fechaProcesamiento: LocalDateTime`
- `estadoProceso: String`
- `registros: List<RegistroCotejo>`

---

### CambioDomicilio

Representa un cambio de domicilio registrado en una circunscripción.

**Atributos:**
- `circunscripcionId: String`
- `totalCambios: Integer`
- `promedio: Double`
- `migraciones: List<Migracion>` - Lista de cambios de domicilio

---

### Objetos de Valor (Value Objects)

#### InformacionParental
- `primerNombrePaterno: String`
- `segundoNombrePaterno: String`
- `primerApellidoPaterno: String`
- `segundoApellidoPaterno: String`
- `primerNombreMaterno: String`
- `segundoNombreMaterno: String`
- `primerApellidoMaterno: String`
- `segundoApellidoMaterno: String`
- `tipoDocumentoPaterno: String`
- `numeroDocumentoPaterno: String`
- `tipoDocumentoMaterno: String`
- `numeroDocumentoMaterno: String`

#### DireccionResidencia
- `departamento: String`
- `provincia: String`
- `distrito: String`
- `centroPoblado: String`
- `direccionCompleta: String`
- `referencia: String`
- `ubigeo: String`

#### Contacto
- `telefonoFijo: String`
- `telefonoMovil: String`
- `correoElectronico: String`
- `correoAlternativo: String`

#### InformacionElectoral
- `numeroInscripcion: String`
- `fechaInscripcion: LocalDate`
- `localVotacion: String`
- `mesa: String`

#### DatosBiometricos
- `huellasDactilares: List<HuellaDactilar>`
- `fotografia: List<Fotografia>`
- `firmaDigital: List<FirmaDigital>`
- `fechaRegistro: LocalDateTime`

#### HuellaDactilar
- `nombreDedo: String`
- `formato: String`
- `valor: String` - Base64 o referencia

#### Fotografia
- `formato: String`
- `valorBase64: String`
- `resolucion: String`
- `modoCaptura: String`

#### FirmaDigital
- `formato: String`
- `valorBase64: String`
- `dispositivoCaptura: String`

#### RegistroCotejo
- `numeroSecuencia: String`
- `tipoDocumento: String`
- `numeroDocumento: String`
- `primerApellido: String`
- `segundoApellido: String`
- `prenombres: String`
- `fechaNacimiento: LocalDate`
- `sexo: String`
- `estadoCivil: String`
- `ubigeo: String`
- `direccion: String`

---

## Reglas de Mapeo de Tipos

Según las especificaciones del proyecto, los tipos de datos del PDF se mapean a tipos Java de la siguiente manera:

| Tipo en PDF          | Tipo Java          | Observaciones                                    |
|----------------------|--------------------|--------------------------------------------------|
| string               | String             | Texto genérico                                   |
| integer / int        | Integer / Long     | Dependiendo del rango esperado                   |
| long                 | Long               | Números grandes                                  |
| number / decimal     | Double             | Números con decimales                            |
| boolean              | Boolean            | Valores verdadero/falso                          |
| date                 | LocalDate          | Solo fecha (YYYY-MM-DD)                          |
| datetime / timestamp | LocalDateTime      | Fecha y hora (YYYY-MM-DDThh:mm:ssZ)              |
| array / list         | List\<T\>          | Colecciones genéricas                            |
| object               | POJO / Record      | Objetos anidados                                 |
| enum                 | String             | Enumeraciones como String (sin enum Java)        |

---

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 202 | Accepted - Cotejo masivo aceptado, procesamiento en curso |
| 204 | No Content - Sin contenido para los criterios especificados |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes para ejecutar la operación |
| 404 | Not Found - Recurso no encontrado en el sistema |
| 408 | Request Timeout - Tiempo de espera agotado al conectar |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 413 | Payload Too Large - Tamaño del lote excede el límite (>500 registros o >50MB) |
| 422 | Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio |
| 429 | Too Many Requests - Límite de rate limit excedido (100 req/hora) |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible o respuesta inválida |
| 503 | Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Gateway Timeout - Servicio externo no respondió en tiempo esperado |

---

## Estructura de Respuesta de Error

Todas las respuestas de error siguen la siguiente estructura estándar:

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

**Campos:**
- `tipo` (string) - Path de la ruta con error o categoría del error
- `titulo` (string) - Título o descripción corta del error
- `estado` (integer) - Código de estado HTTP asociado
- `errores` (array) - Lista de detalles específicos de los errores detectados
- `errores[].detalleError` (string) - Mensaje específico del error

---

## Limitaciones y Consideraciones

### Neutralidad Tecnológica

1. **Sin Frameworks:** El código no depende de Spring, Jakarta EE, Hibernate, etc.
2. **Sin Anotaciones:** Clases POJOs puros sin @Entity, @Component, @RestController, etc.
3. **Sin Protocolo Definido:** Los adaptadores no implementan HTTP, SOAP o colas específicas
4. **Sin ORM:** Las entidades de persistencia son POJOs sin mapeo JPA
5. **Sin Serialización Automática:** Los mappers convierten manualmente entre DTOs y dominio

### Arquitectura Hexagonal

- **Puertos de Entrada (In):** Interfaces de casos de uso en `domain/ports/in`
- **Puertos de Salida (Out):** Interfaces de repositorio en `domain/ports/out`
- **Adaptadores de Entrada:** Controllers y DTOs en `infrastructure/adapters/in/rest`
- **Adaptadores de Salida:** Repository Adapters en `infrastructure/adapters/out/persistence`

### Tipo MsData

- **SÍ define RepositoryPort:** Acceso a datos mediante interfaces en puertos out
- **SÍ tiene Entities:** POJOs de persistencia sin anotaciones
- **SÍ tiene RepositoryAdapter:** Implementaciones de los puertos de repositorio
- **NO define DataPort hacia otros MS:** Este microservicio ES la fuente de datos

### Compilación

El código debe compilar como **Java puro** sin dependencias externas. Para ejecutar en producción, se requiere integrar:
- Un framework web (ej. Spring Boot) que mapee los controllers
- Un ORM o driver de BD (ej. JPA, JDBC) que implemente los repository adapters
- Serialización JSON (ej. Jackson, Gson) para los DTOs records

---

## Casos de Uso Implementados

Solo se implementan los casos de uso documentados en el PDF de especificación:

### Ciudadano
1. ✅ **CrearCiudadanoUseCase** - POST `/api/v1/ciudadano/MsDatosCiudadano`
2. ✅ **ActualizarCiudadanoUseCase** - PUT `/api/v1/ciudadano/MsDatosCiudadano/{id}`
3. ✅ **ConsultarCiudadanoUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/documento`
4. ✅ **ListarCiudadanosUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/ciudadano`

### Informes
5. ✅ **ConsultarInformePericialUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/informes-periciales`

### Alertas
6. ✅ **CrearAlertaUseCase** - POST `/api/v1/ciudadano/MsDatosCiudadano/alerta`
7. ✅ **ListarAlertaUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/alerta` (paginado)
8. ✅ **ConsultarAlertaUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/alerta?alertaId=...`

### Cambios de Domicilio
9. ✅ **ConsultarCambiosDomicilioUseCase** - GET `/api/v1/ciudadano/MsDatosCiudadano/cambio-domicilio`

### Consultas Masivas
10. ✅ **ConsultaMasivaUseCase** - POST `/api/v1/ciudadano/MsDatosCiudadano/consulta-masiva`

**Nota:** No se implementan operaciones DELETE ya que no están documentadas en el PDF de especificación.

---

## Convenciones de Código

### Nombres de Clases y Métodos

- **Use Cases (Puertos In):** `{Operación}{Entidad}UseCase` (interfaz)
- **Services:** `{Operación}{Entidad}Service` (implementa Use Case)
- **Repository Ports:** `{Entidad}RepositoryPort` (interfaz)
- **Repository Adapters:** `{Entidad}RepositoryAdapter` (implementa Repository Port)
- **Controllers:** `{Entidad}Controller` (sin anotaciones)
- **DTOs:** `{Nombre}Dto` o `{Operación}{Entidad}RequestDto/ResponseDto` (records)
- **Entities:** `{Entidad}Entity` (POJOs de persistencia)
- **Mappers:** `{Entidad}DtoMapper` y `{Entidad}PersistenceMapper`

### Métodos en Controllers

- `crear(request)` → crea un nuevo recurso
- `actualizar(id, request)` → actualiza un recurso existente
- `obtenerPorDocumento(tipo, numero)` → obtiene por documento
- `obtenerPorId(id)` → obtiene por ID
- `listar(page, size, filters)` → lista recursos paginados

### Métodos en Mappers

- `toDomain(dto)` → convierte DTO a modelo de dominio
- `toDto(domain)` → convierte dominio a DTO
- `toResponseDto(domain)` → convierte dominio a DTO de respuesta
- `toEntity(domain)` → convierte dominio a entidad de persistencia
- `toDomainFromEntity(entity)` → convierte entidad a dominio

---

## Cómo Extender el Proyecto

### Para agregar un nuevo endpoint:

1. **Verificar que existe en el PDF de especificación** (no inventar operaciones)
2. **Crear el Use Case (puerto in):** interfaz en `domain/ports/in`
3. **Implementar el Service:** clase en `application/service`
4. **Crear/Actualizar el Controller:** método en el controller correspondiente
5. **Definir DTOs:** records en `infrastructure/adapters/in/rest/dto`
6. **Actualizar Mappers:** agregar conversiones necesarias
7. **Si requiere persistencia:** actualizar/crear Repository Port y Adapter

### Para agregar una nueva entidad:

1. **Crear el modelo de dominio:** POJO en `domain/model`
2. **Definir Repository Port:** interfaz en `domain/ports/out`
3. **Crear Entity:** POJO en `infrastructure/adapters/out/persistence/entity`
4. **Implementar Repository Adapter:** clase que implementa el port
5. **Crear Persistence Mapper:** conversiones entre entity y domain
6. **Definir DTOs necesarios:** records para request/response

---

## Documentación de Referencia

- **Especificación completa:** Ver archivo `Microservicio MsDatosCiudadano V1.3 old.pdf` en la raíz del proyecto
- **Especificación extraída:** Ver archivo `ciudadano_spec.txt` para búsquedas rápidas
- **Arquitectura Hexagonal:** Ports & Adapters pattern (Alistair Cockburn)
- **Domain-Driven Design:** Aggregate Roots, Value Objects, Repositories (Eric Evans)

---

## Notas de Implementación

### ¿Por qué sin frameworks?

Este proyecto sigue el principio de **neutralidad tecnológica** para:
- Facilitar la migración entre tecnologías
- Evitar acoplamiento con frameworks específicos
- Permitir testing unitario sin dependencias externas
- Mantener el dominio puro y sin contaminación tecnológica

### ¿Cómo se ejecuta en producción?

En producción, se debe:
1. Integrar un framework web (Spring Boot, Quarkus, Micronaut) que enlace los controllers
2. Configurar un ORM o driver de BD que implemente los repository adapters
3. Agregar serialización JSON para convertir automáticamente los records
4. Configurar seguridad JWT para validar los tokens de autorización
5. Implementar circuit breakers, retry policies y demás patrones de resiliencia

### Estado actual del código

El proyecto contiene:
- ✅ **Estructura completa** de carpetas según arquitectura hexagonal
- ✅ **Interfaces de puertos** (Use Cases y Repository Ports)
- ✅ **Servicios de aplicación** con lógica básica
- ✅ **Controllers sin anotaciones** con métodos stub
- ✅ **DTOs como Java Records** con todos los campos
- ✅ **Modelos de dominio** como POJOs puros
- ✅ **Entities de persistencia** como POJOs sin anotaciones
- ✅ **Mappers de conversión** con lógica básica
- ⚠️ **Adaptadores con UnsupportedOperationException** - requiere implementación de persistencia real

---

## Autor

Proyecto generado siguiendo las especificaciones del documento **Microservicio MsDatosCiudadano V1.3** para RENIEC (Registro Nacional de Identificación y Estado Civil del Perú).

**Arquitectura:** Hexagonal (Ports & Adapters)  
**Paradigma:** Domain-Driven Design (DDD)  
**Tecnología:** Java puro sin frameworks  
**Tipo:** Microservicio de Datos (MsData)
