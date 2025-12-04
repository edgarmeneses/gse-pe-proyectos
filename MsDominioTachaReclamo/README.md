# Microservicio MsDominioTachaReclamo

## Información General

- **Nombre**: MsDominioTachaReclamo
- **Versión API**: V1.0
- **Tipo**: Microservicio de Dominio
- **Paquete Base**: `pe.gob.onpe.dominio.tachareclamo`
- **Contexto**: Gestión de la lógica de negocio para Tachas y Reclamos Electorales

## Arquitectura

Este microservicio sigue una **Arquitectura Hexagonal** estricta sin frameworks ni dependencias tecnológicas concretas. Solo utiliza Java puro con POJOs e interfaces.

### Estructura del Proyecto

```
src/main/java/pe/gob/onpe/dominio/tachareclamo/
├── domain/
│   ├── model/                          # Entidades del dominio
│   │   ├── TachaReclamo.java
│   │   ├── Ciudadano.java
│   │   ├── ValidacionSustento.java
│   │   └── Derivacion.java
│   └── ports/
│       ├── in/                         # Puertos de entrada (Use Cases)
│       │   ├── RegistrarCiudadanoUseCase.java
│       │   ├── RegistrarTachaReclamoUseCase.java
│       │   ├── ValidarSustentoUseCase.java
│       │   └── DerivarTachaReclamoUseCase.java
│       └── out/                        # Puertos de salida (Data Ports)
│           └── TachaReclamoDataPort.java
├── application/
│   └── service/                        # Servicios de aplicación (Implementan Use Cases)
│       ├── RegistrarCiudadanoService.java
│       ├── RegistrarTachaReclamoService.java
│       ├── ValidarSustentoService.java
│       └── DerivarTachaReclamoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/         # Controladores REST (sin anotaciones)
        │       │   ├── CiudadanoController.java
        │       │   └── TachaReclamoController.java
        │       ├── dto/                # DTOs de entrada/salida
        │       │   ├── CiudadanoRequestDto.java
        │       │   ├── CiudadanoResponseDto.java
        │       │   ├── TachaReclamoRequestDto.java
        │       │   ├── TachaReclamoResponseDto.java
        │       │   ├── ValidarSustentoRequestDto.java
        │       │   ├── ValidarSustentoResponseDto.java
        │       │   ├── DerivarTachaReclamoRequestDto.java
        │       │   └── DerivarTachaReclamoResponseDto.java
        │       └── mapper/              # Mappers DTO ↔ Domain
        │           ├── CiudadanoDtoMapper.java
        │           ├── TachaReclamoDtoMapper.java
        │           ├── ValidacionSustentoDtoMapper.java
        │           └── DerivacionDtoMapper.java
        └── out/
            └── msdata/
                └── client/              # Adapter para MsDatosElectoral
                    └── TachaReclamoDataAdapter.java
```

## Características Clave

### Microservicio de Dominio (MsDominio)

Como microservicio de dominio:

- ✅ **Contiene lógica de negocio**
- ✅ **Define puertos de salida (DataPorts)** para integración con MsDatosElectoral
- ✅ **Implementa adaptadores cliente** para comunicación externa
- ❌ **NO define RepositoryPort** (esto es responsabilidad de MsData)
- ❌ **NO persiste datos directamente** (delega a MsDatosElectoral)

### Sin Dependencias Tecnológicas

- Sin frameworks (Spring, JAX-RS, etc.)
- Sin anotaciones JPA, Spring, etc.
- Sin dependencias HTTP/SOAP/colas
- Código compilable como Java puro

## Endpoints Expuestos

### 1. Registrar Ciudadanos

**POST** `/ciudadanos`

**Request:**
```json
{
  "dni": "12345678",
  "nombres": "Juan",
  "apellidoPaterno": "Pérez",
  "apellidoMaterno": "García",
  "fechaNacimiento": "1990-05-15",
  "direccion": "Av. Principal 123"
}
```

**Response (201):**
```json
{
  "id": 1,
  "dni": "12345678",
  "nombreCompleto": "Juan Pérez García",
  "fechaRegistro": "2025-12-03T10:30:00",
  "statusCode": "201",
  "message": "Ciudadano registrado exitosamente"
}
```

**Status Codes:**
- `201`: Created (éxito)
- `400`: Bad Request (validación fallida)
- `500`: Internal Server Error

---

### 2. Registrar Tachas/Reclamos

**POST** `/tacha-reclamo`

**Request:**
```json
{
  "tipo": "TACHA",
  "solicitante": "Juan Pérez",
  "descripcion": "Descripción de la tacha",
  "sustento": "Sustento legal de la tacha...",
  "documentos": ["doc1.pdf", "doc2.pdf"]
}
```

**Response (201):**
```json
{
  "id": 1,
  "numeroExpediente": "EXP-A1B2C3D4",
  "tipo": "TACHA",
  "estado": "REGISTRADO",
  "fechaRegistro": "2025-12-03T10:30:00",
  "statusCode": "201",
  "message": "Tacha/Reclamo registrado exitosamente"
}
```

**Status Codes:**
- `201`: Created
- `400`: Bad Request
- `500`: Internal Server Error

---

### 3. Validar Sustento

**POST** `/tacha-reclamo/validar-sustento`

**Request:**
```json
{
  "tachaReclamoId": 1,
  "sustento": "Sustento detallado con evidencias...",
  "documentos": ["evidencia1.pdf", "evidencia2.pdf"]
}
```

**Response (200):**
```json
{
  "tachaReclamoId": 1,
  "esValido": true,
  "observaciones": "Observaciones de la validación",
  "fechaValidacion": "2025-12-03T11:00:00",
  "statusCode": "200",
  "message": "Sustento validado exitosamente"
}
```

**Status Codes:**
- `200`: OK
- `400`: Bad Request
- `404`: Not Found
- `500`: Internal Server Error

---

### 4. Derivar Tacha/Reclamo

**PUT** `/tacha-reclamo/{id}/derivar`

**Path Parameters:**
- `id`: Long (ID de la tacha/reclamo)

**Request:**
```json
{
  "areaDestino": "AREA_LEGAL",
  "responsable": "María López",
  "observaciones": "Deriva para análisis legal"
}
```

**Response (200):**
```json
{
  "id": 1,
  "numeroExpediente": "EXP-A1B2C3D4",
  "estadoAnterior": "VALIDADO",
  "estadoActual": "DERIVADO",
  "areaDestino": "AREA_LEGAL",
  "fechaDerivacion": "2025-12-03T12:00:00",
  "statusCode": "200",
  "message": "Tacha/Reclamo derivado exitosamente"
}
```

**Status Codes:**
- `200`: OK
- `400`: Bad Request
- `404`: Not Found
- `500`: Internal Server Error

## Entidades del Dominio

### TachaReclamo

Aggregate Root principal del microservicio.

**Atributos:**
- `id`: Long
- `tipo`: String (TACHA | RECLAMO)
- `numeroExpediente`: String (generado automáticamente)
- `fechaRegistro`: LocalDateTime
- `estado`: String (REGISTRADO | VALIDADO | RECHAZADO | DERIVADO)
- `descripcion`: String
- `solicitante`: String
- `sustento`: String
- `documentos`: List\<String\>
- `areaActual`: String
- `responsableActual`: String

### Ciudadano

**Atributos:**
- `id`: Long
- `dni`: String (8 dígitos)
- `nombres`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `fechaNacimiento`: LocalDate
- `direccion`: String
- `fechaRegistro`: LocalDateTime

### ValidacionSustento

**Atributos:**
- `id`: Long
- `tachaReclamoId`: Long
- `esValido`: Boolean
- `observaciones`: String
- `fechaValidacion`: LocalDateTime
- `validadoPor`: String

### Derivacion

**Atributos:**
- `id`: Long
- `tachaReclamoId`: Long
- `areaOrigen`: String
- `areaDestino`: String
- `responsable`: String
- `observaciones`: String
- `fechaDerivacion`: LocalDateTime

## Reglas de Negocio

### Registrar Ciudadanos

1. DNI debe tener exactamente 8 dígitos
2. Nombres, apellido paterno y apellido materno son obligatorios
3. Fecha de nacimiento debe ser anterior a la fecha actual
4. No se permiten duplicados de DNI (pendiente implementación en persistencia)

### Registrar Tachas/Reclamos

1. Tipo debe ser "TACHA" o "RECLAMO"
2. Sustento y descripción son obligatorios
3. Número de expediente se genera automáticamente con formato: `EXP-[UUID-8]`
4. Estado inicial siempre es "REGISTRADO"
5. Fecha de registro se establece automáticamente

### Validar Sustento

1. Solo se pueden validar tachas/reclamos en estado "REGISTRADO"
2. Las observaciones son obligatorias
3. La validación determina si el sustento es válido
4. Si es válido, el estado cambia a "VALIDADO"
5. Si no es válido, el estado cambia a "RECHAZADO"

### Derivar Tacha/Reclamo

1. Solo se pueden derivar tachas/reclamos en estado "VALIDADO"
2. Área destino es obligatoria
3. Responsable es obligatorio
4. Se registra el área de origen actual
5. Estado cambia a "DERIVADO"
6. Se actualiza área actual y responsable actual

## Integración con MsDatosElectoral

Este microservicio se integra con **MsDatosElectoral** a través del puerto de salida `TachaReclamoDataPort` y su implementación `TachaReclamoDataAdapter`.

### Operaciones Requeridas de MsDatosElectoral

1. **Crear Tacha/Reclamo**: `POST /tacha-reclamo`
2. **Actualizar Tacha/Reclamo**: `PUT /tacha-reclamo/{id}`
3. **Obtener Tacha/Reclamo por ID**: `GET /tacha-reclamo/{id}` (no expuesto en el PDF de MsDatosElectoral, pero necesario para la lógica)

### Protocolo de Comunicación

El protocolo de comunicación (HTTP, SOAP, colas, etc.) **NO está definido** en este microservicio. La implementación del `TachaReclamoDataAdapter` debe completarse con la tecnología elegida:

- HTTP REST Client (RestTemplate, WebClient, OkHttp, etc.)
- SOAP Client
- Message Queue (RabbitMQ, Kafka, etc.)
- gRPC
- Otros

## Mapeo de Tipos

| Tipo Especificación | Tipo Java |
|---------------------|-----------|
| string | String |
| integer/long | Long |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List\<T\> |

## Limitaciones y Notas de Implementación

### Tecnología Neutral

Este microservicio está diseñado para ser **tecnológicamente neutral**:

- No incluye configuraciones de frameworks
- No tiene `pom.xml` ni `build.gradle`
- El código es Java puro sin dependencias externas
- Los adaptadores deben implementarse según las tecnologías elegidas

### Pendientes de Implementación

1. **Protocolo de comunicación** con MsDatosElectoral
2. **Manejo de errores HTTP** en controladores (sin frameworks)
3. **Gestión de Ciudadanos en MsDatosElectoral** (si se requiere persistencia)
4. **Validación de duplicados** de DNI
5. **Endpoint GET** para consultar tachas/reclamos (si se requiere)
6. **Autenticación y autorización**
7. **Logs y trazabilidad**
8. **Validaciones de negocio adicionales** según especificación PDF completa

### Criterios de Aceptación

✅ **Cumplidos:**
- Estructura de Arquitectura Hexagonal estricta
- Separación clara de capas (domain, application, infrastructure)
- Puertos de entrada (Use Cases) definidos
- Puertos de salida (DataPorts) para MsDatosElectoral
- Adaptador cliente sin protocolo definido
- Servicios de aplicación con lógica de negocio
- Controllers, DTOs y Mappers generados
- Solo operaciones del PDF (sin invenciones)
- Código compilable como Java puro
- Sin frameworks ni anotaciones

❌ **NO implementados (por diseño):**
- RepositoryPort (responsabilidad de MsData)
- Persistencia directa de datos
- Protocolo de comunicación específico
- Frameworks o librerías externas

## Cómo Usar Este Proyecto

### Compilación

El proyecto compila como Java estándar (Java 8+):

```bash
javac -d bin src/main/java/pe/gob/onpe/dominio/tachareclamo/**/*.java
```

### Integración con Frameworks

Para usar este proyecto con frameworks (Spring Boot, Quarkus, Micronaut, etc.):

1. Agregar dependencias del framework elegido
2. Anotar controladores con `@RestController`, `@Path`, etc.
3. Implementar `TachaReclamoDataAdapter` con cliente HTTP/SOAP
4. Configurar inyección de dependencias
5. Agregar manejo de excepciones HTTP

### Testing

Los servicios pueden probarse con mocks de los puertos:

```java
TachaReclamoDataPort mockDataPort = mock(TachaReclamoDataPort.class);
RegistrarTachaReclamoService service = new RegistrarTachaReclamoService(mockDataPort);
```

## Contacto y Soporte

Para dudas sobre la especificación, consultar:
- **PDF de Especificación**: `Microservicio MsDominioTachaReclamo V1.0.pdf`
- **Prompt de Construcción**: `AGENT_PROMPT.md`
- **Análisis Extraído**: `PDF_EXTRACTION.md`

---

**Versión**: 1.0  
**Fecha**: Diciembre 2025  
**Arquitectura**: Hexagonal (Ports & Adapters)  
**Lenguaje**: Java (sin frameworks)
