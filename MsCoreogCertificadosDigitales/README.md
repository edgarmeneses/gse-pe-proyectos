# MsCoreogCertificadosDigitales

## Descripción General

**Nombre del Microservicio:** MsCoreogCertificadosDigitales  
**Tipo:** Microservicio de Coreografía (MsDominio)  
**Versión API:** V1.0  
**Contexto de Negocio:** Emisión de Certificados Digitales DNIe  
**Paquete Base:** `pe.gob.sunat.gse.coreog.certificadosdigitales`

Microservicio que coordina la emisión de certificados digitales ejecutando un flujo obligatorio de 2 pasos contra **MsAdaptadorPKI**. Implementado con Arquitectura Hexagonal sin dependencias de frameworks.

### Flujo de Coreografía

Este microservicio orquesta dos operaciones secuenciales contra MsAdaptadorPKI:

1. **Paso 1 - Generar Números de Solicitud PKI**
   - Endpoint: `POST /api/v1/adaptador/MsAdaptadorPKI/generarNumerosSolicitud2`
   - Genera IDs de solicitud PKI requeridos para emisión
   - Retorna: `solicitudPkiId`

2. **Paso 2 - Emitir Certificado Digital DNIe**
   - Endpoint: `POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE`
   - Usa `solicitudPkiId` del Paso 1
   - Genera el certificado digital final

---

## Operación

### Obtener Certificado Digital

**Endpoint:** `POST /api/v1/coreog/MsCoreogCertificadosDigitales/obtener-certificado-digital`

**Descripción:** Emite certificados digitales DNIe coordinando flujo de 2 pasos con MsAdaptadorPKI.

#### Headers Requeridos

| Header             | Tipo   | Descripción                                      |
|--------------------|--------|--------------------------------------------------|
| Authorization      | String | Token Bearer de autenticación                     |
| Content-Type       | String | `application/json`                                |
| X-Correlation-ID   | UUID   | ID de trazabilidad entre microservicios           |
| X-Request-ID       | UUID   | ID único de la solicitud                          |
| X-Office-Code      | String | Código de oficina SUNAT                           |
| X-Device-ID        | String | Identificador del dispositivo                     |
| X-Channel          | String | Canal de origen (web/mobile/kiosk)                |

#### Request Body

Estructura con 4 secciones principales:

```json
{
  "solicitud": {
    "numeroDocumento": "12345678",
    "tipoDocumento": "DNI",
    "codigoSolicitudTramite": "CERT-2024-001",
    "numeroTramite": "TRM-2024-12345"
  },
  "ciudadano": {
    "numeroDocumento": "12345678",
    "tipoDocumento": "DNI",
    "nombres": "Juan Carlos",
    "apellidoPaterno": "Perez",
    "apellidoMaterno": "Garcia",
    "fechaNacimiento": "1990-05-15",
    "email": "juan.perez@example.com",
    "telefono": "+51987654321",
    "direccion": "Av. Principal 123, Lima"
  },
  "configuracionCertificados": {
    "tipoCertificados": ["FIRMA_DIGITAL", "AUTENTICACION"],
    "vigenciaAnios": 3,
    "usoExtendido": true,
    "nivelSeguridad": "ALTO"
  },
  "metadatos": {
    "oficinaOrigen": "LIMA_CENTRO",
    "usuarioRegistrador": "OPERADOR_001",
    "ipOrigen": "192.168.1.100",
    "timestampSolicitud": "2024-01-15T10:30:00Z"
  }
}
```

##### Sección: `solicitud`

| Campo                    | Tipo   | Descripción                                      |
|--------------------------|--------|--------------------------------------------------|
| numeroDocumento          | String | Número de documento del ciudadano                 |
| tipoDocumento            | String | Tipo de documento (DNI, CE, etc.)                 |
| codigoSolicitudTramite   | String | Código identificador de la solicitud              |
| numeroTramite            | String | Número de trámite asociado                        |

##### Sección: `ciudadano`

| Campo              | Tipo   | Descripción                                      |
|--------------------|--------|--------------------------------------------------|
| numeroDocumento    | String | Número de documento                               |
| tipoDocumento      | String | Tipo de documento                                 |
| nombres            | String | Nombres completos                                 |
| apellidoPaterno    | String | Apellido paterno                                  |
| apellidoMaterno    | String | Apellido materno                                  |
| fechaNacimiento    | String | Fecha de nacimiento (ISO 8601)                    |
| email              | String | Correo electrónico                                |
| telefono           | String | Teléfono con código país                          |
| direccion          | String | Dirección completa                                |

##### Sección: `configuracionCertificados`

| Campo              | Tipo     | Descripción                                      |
|--------------------|----------|--------------------------------------------------|
| tipoCertificados   | String[] | Tipos de certificados a emitir                    |
| vigenciaAnios      | Integer  | Años de vigencia del certificado                  |
| usoExtendido       | Boolean  | Habilitar uso extendido de clave                  |
| nivelSeguridad     | String   | Nivel de seguridad (BAJO, MEDIO, ALTO)           |

##### Sección: `metadatos`

| Campo                | Tipo   | Descripción                                      |
|----------------------|--------|--------------------------------------------------|
| oficinaOrigen        | String | Código de oficina que origina solicitud           |
| usuarioRegistrador   | String | Usuario que registra la solicitud                 |
| ipOrigen             | String | IP del cliente                                    |
| timestampSolicitud   | String | Timestamp de solicitud (ISO 8601)                 |

#### Response Body (201 Created)

Estructura con `success`, `data` (5 secciones) y `metadata`:

```json
{
  "success": true,
  "data": {
    "transaccion": {
      "transaccionId": "TRX-2024-001",
      "estado": "COMPLETADO",
      "fechaInicio": "2024-01-15T10:30:00Z",
      "fechaFin": "2024-01-15T10:31:30Z",
      "tiempoProcesamientoMs": 90000
    },
    "ciudadano": {
      "numeroDocumento": "12345678",
      "nombreCompleto": "Juan Carlos Perez Garcia"
    },
    "certificados": [
      {
        "tipoCertificado": "FIRMA_DIGITAL",
        "certificadoId": "CERT-FD-2024-001",
        "numeroSerie": "5B:3A:9F:2E:1C:4D",
        "fechaEmision": "2024-01-15",
        "fechaVencimiento": "2027-01-15",
        "vigenciaAnios": 3,
        "estadoCertificado": "ACTIVO",
        "algoritmoFirma": "SHA256withRSA",
        "longitudClave": 2048,
        "subjectDN": "CN=Juan Carlos Perez Garcia, OU=SUNAT, O=PERU, C=PE",
        "huellaCertificado": "A1:B2:C3:D4:E5:F6:07:08:09:0A",
        "certificadoBase64": "MIIDXTCCAkWgAwIBAgI..."
      },
      {
        "tipoCertificado": "AUTENTICACION",
        "certificadoId": "CERT-AU-2024-002",
        "numeroSerie": "6C:4B:8E:3F:2D:5E",
        "fechaEmision": "2024-01-15",
        "fechaVencimiento": "2027-01-15",
        "vigenciaAnios": 3,
        "estadoCertificado": "ACTIVO",
        "algoritmoFirma": "SHA256withRSA",
        "longitudClave": 2048,
        "subjectDN": "CN=Juan Carlos Perez Garcia, OU=SUNAT, O=PERU, C=PE",
        "huellaCertificado": "B2:C3:D4:E5:F6:07:08:09:0A:1B",
        "certificadoBase64": "MIIDXTCCAkWgAwIBAgJ..."
      }
    ],
    "pasosProceso": {
      "paso1GeneracionClaves": {
        "solicitudPkiId": "PKI-SOL-2024-001",
        "estado": "COMPLETADO",
        "fechaInicio": "2024-01-15T10:30:00Z",
        "fechaFin": "2024-01-15T10:30:45Z",
        "intentos": 1
      },
      "paso2EmisionCertificado": {
        "estado": "COMPLETADO",
        "fechaInicio": "2024-01-15T10:30:46Z",
        "fechaFin": "2024-01-15T10:31:30Z",
        "intentos": 1
      }
    },
    "auditoria": {
      "registroAuditoriaId": "AUD-2024-001",
      "usuarioEjecutor": "OPERADOR_001",
      "oficinaEjecucion": "LIMA_CENTRO",
      "ipCliente": "192.168.1.100",
      "timestampEjecucion": "2024-01-15T10:31:30Z"
    }
  },
  "metadata": {
    "version": "1.0",
    "timestamp": "2024-01-15T10:31:30Z",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000"
  }
}
```

##### Sección Response: `transaccion`

| Campo                  | Tipo    | Descripción                                      |
|------------------------|---------|--------------------------------------------------|
| transaccionId          | String  | ID único de la transacción                        |
| estado                 | String  | Estado final (COMPLETADO, FALLIDO, etc.)          |
| fechaInicio            | String  | Timestamp inicio (ISO 8601)                       |
| fechaFin               | String  | Timestamp fin (ISO 8601)                          |
| tiempoProcesamientoMs  | Long    | Tiempo total en milisegundos                      |

##### Sección Response: `ciudadano`

| Campo            | Tipo   | Descripción                                      |
|------------------|--------|--------------------------------------------------|
| numeroDocumento  | String | Número de documento                               |
| nombreCompleto   | String | Nombre completo concatenado                       |

##### Sección Response: `certificados[]`

Array de certificados emitidos (uno por cada tipo solicitado):

| Campo               | Tipo    | Descripción                                      |
|---------------------|---------|--------------------------------------------------|
| tipoCertificado     | String  | Tipo (FIRMA_DIGITAL, AUTENTICACION, etc.)         |
| certificadoId       | String  | ID único del certificado                          |
| numeroSerie         | String  | Número de serie hexadecimal                       |
| fechaEmision        | String  | Fecha de emisión (YYYY-MM-DD)                     |
| fechaVencimiento    | String  | Fecha de vencimiento (YYYY-MM-DD)                 |
| vigenciaAnios       | Integer | Años de vigencia                                  |
| estadoCertificado   | String  | Estado (ACTIVO, REVOCADO, SUSPENDIDO, EXPIRADO)   |
| algoritmoFirma      | String  | Algoritmo de firma digital                        |
| longitudClave       | Integer | Longitud de clave en bits                         |
| subjectDN           | String  | Distinguished Name del sujeto                     |
| huellaCertificado   | String  | Hash SHA-256 del certificado (hexadecimal)        |
| certificadoBase64   | String  | Certificado X.509 codificado en Base64            |

##### Sección Response: `pasosProceso`

Detalle de los 2 pasos ejecutados:

**paso1GeneracionClaves:**

| Campo           | Tipo    | Descripción                                      |
|-----------------|---------|--------------------------------------------------|
| solicitudPkiId  | String  | ID de solicitud PKI generado                      |
| estado          | String  | Estado del paso (COMPLETADO, FALLIDO)             |
| fechaInicio     | String  | Timestamp inicio paso (ISO 8601)                  |
| fechaFin        | String  | Timestamp fin paso (ISO 8601)                     |
| intentos        | Integer | Número de intentos realizados                     |

**paso2EmisionCertificado:**

| Campo       | Tipo    | Descripción                                      |
|-------------|---------|--------------------------------------------------|
| estado      | String  | Estado del paso (COMPLETADO, FALLIDO)             |
| fechaInicio | String  | Timestamp inicio paso (ISO 8601)                  |
| fechaFin    | String  | Timestamp fin paso (ISO 8601)                     |
| intentos    | Integer | Número de intentos realizados                     |

##### Sección Response: `auditoria`

| Campo                | Tipo   | Descripción                                      |
|----------------------|--------|--------------------------------------------------|
| registroAuditoriaId  | String | ID único de registro de auditoría                 |
| usuarioEjecutor      | String | Usuario que ejecutó la operación                  |
| oficinaEjecucion     | String | Oficina donde se ejecutó                          |
| ipCliente            | String | IP del cliente                                    |
| timestampEjecucion   | String | Timestamp de ejecución (ISO 8601)                 |

##### Sección Response: `metadata`

| Campo         | Tipo   | Descripción                                      |
|---------------|--------|--------------------------------------------------|
| version       | String | Versión de la API                                 |
| timestamp     | String | Timestamp de respuesta (ISO 8601)                 |
| correlationId | String | UUID de trazabilidad (desde header)              |

#### Error Response

Estructura para errores de validación o negocio:

```json
{
  "error": {
    "tipo": "VALIDATION_ERROR",
    "titulo": "Datos de solicitud inválidos",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El campo 'numeroDocumento' es requerido"
      },
      {
        "detalleError": "El formato de 'email' es inválido"
      }
    ]
  }
}
```

##### Estructura Error:

| Campo   | Tipo                | Descripción                                      |
|---------|---------------------|--------------------------------------------------|
| tipo    | String              | Tipo de error (VALIDATION_ERROR, BUSINESS_ERROR, etc.) |
| titulo  | String              | Título descriptivo del error                      |
| estado  | Integer             | Código HTTP correspondiente                       |
| errores | DetalleErrorDto[]   | Array de detalles de errores                      |

**DetalleErrorDto:**

| Campo         | Tipo   | Descripción                                      |
|---------------|--------|--------------------------------------------------|
| detalleError  | String | Descripción específica del error                  |

#### Códigos de Respuesta

| Código | Descripción                                      | Escenario                                        |
|--------|--------------------------------------------------|--------------------------------------------------|
| 201    | Created                                          | Certificado emitido exitosamente                  |
| 400    | Bad Request                                      | Validación de datos fallida                       |
| 401    | Unauthorized                                     | Token inválido o expirado                         |
| 403    | Forbidden                                        | Usuario sin permisos                              |
| 404    | Not Found                                        | Ciudadano no encontrado en RENIEC                 |
| 409    | Conflict                                         | Certificado ya existe para ese ciudadano          |
| 422    | Unprocessable Entity                             | Regla de negocio fallida                          |
| 429    | Too Many Requests                                | Límite de tasa excedido                           |
| 500    | Internal Server Error                            | Error interno del microservicio                   |
| 502    | Bad Gateway                                      | Error en comunicación con MsAdaptadorPKI          |
| 503    | Service Unavailable                              | Servicio no disponible temporalmente              |
| 504    | Gateway Timeout                                  | Timeout en comunicación con MsAdaptadorPKI        |

---

## Arquitectura

### Tipo de Microservicio: MsDominio (Coreografía)

Como microservicio de coreografía:
- **NO define RepositoryPort** (no persiste datos directamente)
- Define **CertificadoDigitalDataPort** como puerto de salida hacia MsAdaptadorPKI
- Implementa **CertificadoDigitalDataAdapter** para integración con MsAdaptadorPKI
- **NO especifica protocolo** de comunicación (HTTP/SOAP/Colas se define en implementación)

### Arquitectura Hexagonal (Ports & Adapters)

```
┌─────────────────────────────────────────────────────────────────┐
│                    CAPA DE INFRAESTRUCTURA                      │
│  ┌────────────────────┐              ┌────────────────────────┐ │
│  │  REST Controller   │              │  Data Adapter (PKI)    │ │
│  │  (Puerto Entrada)  │              │  (Puerto Salida)       │ │
│  └────────┬───────────┘              └───────────┬────────────┘ │
│           │                                      │              │
│           │  DTOs                                │  POJOs       │
│           │                                      │              │
├───────────┼──────────────────────────────────────┼──────────────┤
│           │         CAPA DE APLICACIÓN           │              │
│  ┌────────▼────────────────────────────┐         │              │
│  │  ObtenerCertificadoDigitalService   │◄────────┤              │
│  │  (Coordinador 2 pasos)              │         │              │
│  └────────┬────────────────────────────┘         │              │
│           │                                      │              │
├───────────┼──────────────────────────────────────┼──────────────┤
│           │          CAPA DE DOMINIO             │              │
│  ┌────────▼─────────────┐    ┌──────────────────▼────────────┐ │
│  │  UseCase (Puerto In) │    │  DataPort (Puerto Out)        │ │
│  │  - obtener()         │    │  - generarNumerosSolicitud()  │ │
│  └──────────────────────┘    │  - generarCertificadoDniE()   │ │
│                               └───────────────────────────────┘ │
│  ┌──────────────────────────────────────────────┐              │
│  │  CertificadoDigital (Aggregate Root)         │              │
│  │  - 12 campos (sin frameworks)                │              │
│  └──────────────────────────────────────────────┘              │
└─────────────────────────────────────────────────────────────────┘
```

### Estructura del Proyecto

```
src/main/java/pe/gob/sunat/gse/coreog/certificadosdigitales/
├── domain/                                        # CAPA DE DOMINIO
│   ├── model/
│   │   └── CertificadoDigital.java                # Aggregate Root (12 campos)
│   └── ports/
│       ├── in/
│       │   └── ObtenerCertificadoDigitalUseCase.java  # Puerto entrada
│       └── out/
│           └── CertificadoDigitalDataPort.java    # Puerto salida (MsAdaptadorPKI)
│
├── application/                                   # CAPA DE APLICACIÓN
│   └── service/
│       └── ObtenerCertificadoDigitalService.java  # Coordina 2 pasos
│
└── infrastructure/                                # CAPA DE INFRAESTRUCTURA
    └── adapters/
        ├── in/                                    # ADAPTADORES ENTRADA
        │   └── rest/
        │       ├── controller/
        │       │   └── CertificadoDigitalController.java  # Controlador POST
        │       ├── dto/                           # 16 DTOs totales
        │       │   ├── ObtenerCertificadoDigitalRequestDto.java
        │       │   ├── ObtenerCertificadoDigitalResponseDto.java
        │       │   ├── SolicitudDto.java
        │       │   ├── CiudadanoDto.java
        │       │   ├── CiudadanoResponseDto.java
        │       │   ├── ConfiguracionCertificadosDto.java
        │       │   ├── MetadatosDto.java
        │       │   ├── DataDto.java
        │       │   ├── TransaccionDto.java
        │       │   ├── CertificadoDigitalDto.java
        │       │   ├── PasosProcesoDto.java
        │       │   ├── Paso1GeneracionClavesDto.java
        │       │   ├── Paso2EmisionCertificadoDto.java
        │       │   ├── AuditoriaDto.java
        │       │   ├── MetadataResponseDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── CertificadoDigitalDtoMapper.java  # Mapper manual
        │
        └── out/                                   # ADAPTADORES SALIDA
            └── msdata/
                └── client/
                    └── CertificadoDigitalDataAdapter.java  # Cliente MsAdaptadorPKI
```

---

## Principios de Diseño

### 1. Arquitectura Hexagonal Estricta

- **Dominio puro:** Sin frameworks, anotaciones ni infraestructura
- **Puertos definidos:** Interfaces claras entre capas
- **Inversión de dependencias:** Dominio no depende de infraestructura
- **Adaptadores intercambiables:** Infraestructura implementa puertos

### 2. Domain-Driven Design (DDD)

- **Aggregate Root:** `CertificadoDigital` con 12 campos de negocio
- **Bounded Context:** Gestión de certificados digitales DNIe
- **Ubiquitous Language:** Términos del dominio SUNAT/PKI

### 3. Sin Frameworks en el Core

- POJOs puros en dominio
- Sin anotaciones (Spring, JPA, Lombok, MapStruct, etc.)
- Tecnología definida solo en infraestructura
- Framework-agnostic: compatible con Spring Boot, Micronaut, Quarkus, Jakarta EE, etc.

### 4. Principios SOLID

- **SRP:** Cada clase tiene una responsabilidad única
- **OCP:** Abierto a extensión, cerrado a modificación
- **LSP:** Interfaces sustituibles
- **ISP:** Interfaces específicas por cliente
- **DIP:** Dependencias hacia abstracciones

---

## Modelo de Dominio

### CertificadoDigital (Aggregate Root)

Representa un certificado digital emitido para un ciudadano.

**Campos (12 totales):**

| Campo               | Tipo    | Descripción                                      |
|---------------------|---------|--------------------------------------------------|
| tipoCertificado     | String  | Tipo de certificado (FIRMA_DIGITAL, etc.)         |
| certificadoId       | String  | Identificador único del certificado               |
| numeroSerie         | String  | Número de serie hexadecimal                       |
| fechaEmision        | String  | Fecha de emisión (YYYY-MM-DD)                     |
| fechaVencimiento    | String  | Fecha de vencimiento (YYYY-MM-DD)                 |
| vigenciaAnios       | Integer | Años de vigencia                                  |
| estadoCertificado   | String  | Estado actual del certificado                     |
| algoritmoFirma      | String  | Algoritmo de firma digital usado                  |
| longitudClave       | Integer | Longitud de clave en bits                         |
| subjectDN           | String  | Distinguished Name del sujeto                     |
| huellaCertificado   | String  | Hash SHA-256 en hexadecimal                       |
| certificadoBase64   | String  | Certificado X.509 codificado en Base64            |

---

## Integración con MsAdaptadorPKI

Este microservicio consume dos endpoints del **MsAdaptadorPKI v1.0**:

### Paso 1: Generar Números de Solicitud PKI

**Endpoint:** `POST /api/v1/adaptador/MsAdaptadorPKI/generarNumerosSolicitud2`

**Propósito:** Genera identificadores de solicitud PKI requeridos para emitir certificados.

**Request:**
```json
{
  "solicitud": {...},
  "configuracion": {...},
  "metadatos": {...}
}
```

**Response:**
```json
{
  "solicitudPkiId": "PKI-SOL-2024-001",
  "estado": "GENERADO"
}
```

### Paso 2: Generar Certificado Digital DNIe

**Endpoint:** `POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE`

**Propósito:** Emite el certificado digital usando el ID del Paso 1.

**Request:**
```json
{
  "solicitudPkiId": "PKI-SOL-2024-001",
  "solicitud": {...},
  "ciudadano": {...},
  "configuracion": {...},
  "metadatos": {...}
}
```

**Response:**
```json
{
  "certificados": [
    {
      "tipoCertificado": "FIRMA_DIGITAL",
      "certificadoId": "CERT-FD-2024-001",
      ...
    }
  ]
}
```

---

## Casos de Uso

### ObtenerCertificadoDigital

**Flujo:**
1. Recibir solicitud con 4 secciones (solicitud, ciudadano, configuración, metadatos)
2. Validar datos de entrada
3. **Ejecutar Paso 1:** Generar números de solicitud PKI
4. **Ejecutar Paso 2:** Emitir certificado digital DNIe usando ID del Paso 1
5. Construir respuesta con estructura success/data/metadata
6. Registrar auditoría completa

**Reglas de Negocio:**
- Ciudadano debe existir en RENIEC
- Documento debe ser válido y no expirado
- No puede existir certificado vigente del mismo tipo
- Edad mínima: 18 años
- Email y teléfono válidos
- Configuración compatible con tipo de certificado
- Ambos pasos del flujo PKI deben completarse exitosamente

---

## Tecnologías y Frameworks

### Estado Actual (Sin Frameworks)

El proyecto implementa **Java puro** sin dependencias:
- Sin anotaciones (@Entity, @Service, @RestController, etc.)
- Sin Spring Boot, JPA, Lombok, MapStruct
- POJOs con getters/setters manuales
- Mappers manuales (sin MapStruct)

### Implementación Futura (Framework-Agnostic)

La infraestructura está preparada para integrar frameworks en tiempo de implementación:

**Opciones de Framework:**
- Spring Boot + Spring WebFlux/MVC
- Micronaut
- Quarkus
- Jakarta EE / Wildfly

**Persistencia (No aplica - MsDominio):**
- Este microservicio NO persiste datos
- Solo coordina con MsAdaptadorPKI

**Comunicación HTTP:**
- WebClient (Spring WebFlux)
- RestTemplate (Spring MVC)
- HttpClient (Java 11+)
- Feign Client

---

## Testing

### Estrategia de Testing

```
Unit Tests (JUnit 5)
├── Domain Layer
│   └── CertificadoDigital business logic
├── Application Layer
│   └── ObtenerCertificadoDigitalService coordination
└── Infrastructure Layer
    ├── Controller request/response handling
    ├── Mapper DTO conversions
    └── DataAdapter integration (mocked)

Integration Tests
└── End-to-end flow with test doubles para MsAdaptadorPKI
```

### Pruebas Recomendadas

**Casos Felices:**
- Emisión exitosa de certificado FIRMA_DIGITAL
- Emisión exitosa de múltiples certificados (FIRMA_DIGITAL + AUTENTICACION)
- Flujo completo con ambos pasos PKI exitosos

**Casos de Error:**
- Validación fallida de campos obligatorios
- Ciudadano no encontrado (404)
- Certificado ya existente (409)
- Timeout en Paso 1 de PKI (504)
- Error en Paso 2 de PKI (502)
- Reglas de negocio (menor de edad, documento expirado)

---

## Deployment

### Empaquetado

El proyecto puede empaquetarse como:
- **JAR ejecutable** (con Spring Boot)
- **WAR** (para servidores de aplicaciones)
- **Imagen Docker** (multistage build)
- **Native Image** (GraalVM con Quarkus/Micronaut)

### Variables de Entorno

```properties
# MsAdaptadorPKI
MS_ADAPTADOR_PKI_URL=https://adaptador-pki.sunat.gob.pe
MS_ADAPTADOR_PKI_TIMEOUT=30000

# Seguridad
JWT_SECRET=<secret>
JWT_EXPIRATION=3600

# Observabilidad
OTEL_EXPORTER_OTLP_ENDPOINT=http://collector:4317
LOGGING_LEVEL=INFO
```

### Health Check

```
GET /actuator/health
```

**Response:**
```json
{
  "status": "UP",
  "components": {
    "msAdaptadorPki": {
      "status": "UP",
      "details": {
        "endpoint": "https://adaptador-pki.sunat.gob.pe",
        "responseTime": "120ms"
      }
    }
  }
}
```

---

## Observabilidad

### Logs Estructurados

```
2024-01-15T10:30:00.000Z [INFO] ObtenerCertificadoDigitalService - Iniciando emisión certificado
  correlationId=550e8400-e29b-41d4-a716-446655440000
  requestId=660e8400-e29b-41d4-a716-446655440001
  numeroDocumento=12345678

2024-01-15T10:30:45.000Z [INFO] CertificadoDigitalDataAdapter - Paso 1 PKI completado
  correlationId=550e8400-e29b-41d4-a716-446655440000
  solicitudPkiId=PKI-SOL-2024-001
  tiempoMs=450

2024-01-15T10:31:30.000Z [INFO] CertificadoDigitalDataAdapter - Paso 2 PKI completado
  correlationId=550e8400-e29b-41d4-a716-446655440000
  certificadosEmitidos=2
  tiempoMs=450
```

### Métricas (Micrometer / Prometheus)

- `certificados_emitidos_total{tipo="FIRMA_DIGITAL"}` (Counter)
- `certificados_emitidos_total{tipo="AUTENTICACION"}` (Counter)
- `pki_paso1_duracion_segundos` (Histogram)
- `pki_paso2_duracion_segundos` (Histogram)
- `errores_pki_total{paso="1|2", codigo="400|500|502|504"}` (Counter)

### Traces (OpenTelemetry)

```
POST /obtener-certificado-digital
  ├── ObtenerCertificadoDigitalService.obtener() [90s]
  │   ├── CertificadoDigitalDataPort.generarNumerosSolicitud() [45s]
  │   │   └── HTTP POST /generarNumerosSolicitud2 [42s]
  │   └── CertificadoDigitalDataPort.generarCertificadoDniE() [44s]
  │       └── HTTP POST /generarCertificadoDigitalDniE [41s]
  └── CertificadoDigitalDtoMapper.toResponseDto() [1s]
```

---

## Seguridad

### Autenticación

- Token JWT en header `Authorization: Bearer <token>`
- Validación de firma y expiración
- Roles requeridos: `CERT_OPERATOR`, `CERT_ADMIN`

### Autorización

- RBAC basado en roles JWT
- Control de oficinas (X-Office-Code)
- Límite de tasa por usuario: 10 req/min

### Validación de Entrada

- Sanitización de campos String
- Validación de formatos (email, teléfono, DNI)
- Longitud máxima de campos
- Prevención de inyección (SQL, XSS, etc.)

### Auditoría

Todos los eventos se registran con:
- Usuario ejecutor
- Oficina de origen
- IP del cliente
- Timestamp
- Resultado de operación
- Correlation ID

---

## Roadmap

### Fase 1 - Implementación Base ✅
- [x] Arquitectura hexagonal pura Java
- [x] Modelo de dominio (CertificadoDigital)
- [x] Puertos y adaptadores
- [x] DTOs completos (16 archivos)
- [x] Mapper manual
- [x] Documentación completa

### Fase 2 - Framework Integration (Pendiente)
- [ ] Integrar Spring Boot
- [ ] Configurar WebFlux para comunicación con MsAdaptadorPKI
- [ ] Implementar seguridad JWT
- [ ] Configurar validaciones (@Valid, Bean Validation)

### Fase 3 - Testing (Pendiente)
- [ ] Unit tests (JUnit 5 + Mockito)
- [ ] Integration tests (WireMock para MsAdaptadorPKI)
- [ ] Contract tests (Pact)

### Fase 4 - Observabilidad (Pendiente)
- [ ] Logs estructurados (SLF4J + Logback)
- [ ] Métricas (Micrometer + Prometheus)
- [ ] Traces (OpenTelemetry)
- [ ] Dashboards (Grafana)

### Fase 5 - Deployment (Pendiente)
- [ ] Dockerfile multistage
- [ ] Kubernetes manifests
- [ ] CI/CD pipeline (GitHub Actions / Jenkins)
- [ ] Helm charts

---

## Contacto y Soporte

**Equipo de Desarrollo:** GSE Perú - Arquitectura de Microservicios  
**Contexto de Negocio:** Certificados Digitales DNIe  
**Versión:** 1.0  
**Última Actualización:** 2024-01-15
