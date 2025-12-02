# MsAdaptadorPKI - Microservicio Adaptador PKI

## Información General

- **Nombre del Microservicio**: MsAdaptadorPKI
- **Versión del API**: v1.0
- **Contexto de Negocio**: Microservicio adaptador para integración con infraestructura de clave pública (PKI - Public Key Infrastructure). Proporciona servicios de firma digital de documentos, validación de certificados digitales y consulta de información de certificados.
- **Paquete Base**: `pe.gob.sunat.sol.adaptadorpki`
- **Tipo de Arquitectura**: Hexagonal (Ports & Adapters)

## Tipo de Microservicio

Este es un **microservicio adaptador** que:
- NO es un MsDominioXXXX tradicional
- NO es un MsDataXXXX (no maneja persistencia directa)
- Actúa como **adaptador/integrador** con sistema PKI externo
- Define puerto de salida `PKIPort` hacia sistema PKI externo
- NO define `RepositoryPort` (no maneja datos persistentes)
- Implementa `PKIAdapter` sin protocolo de comunicación específico (sin asumir HTTP/SOAP/colas)

## Endpoints Documentados

### 1. Firmar Documento
**Endpoint**: `POST /api/v1/firma/firmar`  
**Descripción**: Firma digitalmente un documento utilizando un certificado digital.

**Request**:
```json
{
  "documento": "string (base64 encoded)",
  "certificado": "string",
  "password": "string",
  "tipoFirma": "string"
}
```

**Response**:
```json
{
  "documentoFirmado": "string (base64 encoded)",
  "fechaFirma": "datetime (ISO 8601)",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```

**Status Codes**:
- `200 OK`: Documento firmado exitosamente
- `400 Bad Request`: Solicitud inválida (datos incorrectos o incompletos)
- `500 Internal Server Error`: Error interno del servidor

---

### 2. Validar Certificado
**Endpoint**: `POST /api/v1/certificado/validar`  
**Descripción**: Valida un certificado digital verificando su vigencia y autenticidad.

**Request**:
```json
{
  "certificado": "string",
  "fechaValidacion": "datetime (ISO 8601)"
}
```

**Response**:
```json
{
  "esValido": "boolean",
  "fechaExpiracion": "datetime (ISO 8601)",
  "emisor": "string",
  "titular": "string",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```

**Status Codes**:
- `200 OK`: Validación ejecutada exitosamente
- `400 Bad Request`: Solicitud inválida
- `500 Internal Server Error`: Error interno del servidor

---

### 3. Consultar Certificado
**Endpoint**: `GET /api/v1/certificado/{numCertificado}`  
**Descripción**: Consulta la información detallada de un certificado digital por su número.

**Path Parameters**:
- `numCertificado`: String - Número identificador del certificado

**Response**:
```json
{
  "numeroCertificado": "string",
  "titular": "string",
  "emisor": "string",
  "fechaEmision": "datetime (ISO 8601)",
  "fechaExpiracion": "datetime (ISO 8601)",
  "estado": "string",
  "codigoRespuesta": "string",
  "mensaje": "string"
}
```

**Status Codes**:
- `200 OK`: Consulta exitosa
- `404 Not Found`: Certificado no encontrado
- `500 Internal Server Error`: Error interno del servidor

---

## Entidades del Dominio

### Firma
Representa una operación de firma digital sobre un documento.

**Atributos**:
- `documento`: String - Documento original en formato base64
- `certificado`: String - Certificado digital utilizado
- `password`: String - Contraseña del certificado
- `tipoFirma`: String - Tipo de firma a aplicar
- `documentoFirmado`: String - Documento firmado en formato base64
- `fechaFirma`: LocalDateTime - Fecha y hora de la firma
- `codigoRespuesta`: String - Código de respuesta de la operación
- `mensaje`: String - Mensaje descriptivo del resultado

### Certificado
Representa un certificado digital y su información asociada.

**Atributos**:
- `numeroCertificado`: String - Número identificador único del certificado
- `certificado`: String - Contenido del certificado
- `titular`: String - Titular del certificado
- `emisor`: String - Entidad emisora del certificado
- `fechaEmision`: LocalDateTime - Fecha de emisión del certificado
- `fechaExpiracion`: LocalDateTime - Fecha de expiración del certificado
- `fechaValidacion`: LocalDateTime - Fecha en que se realizó la validación
- `estado`: String - Estado actual del certificado
- `esValido`: Boolean - Indicador de validez del certificado
- `codigoRespuesta`: String - Código de respuesta de la operación
- `mensaje`: String - Mensaje descriptivo del resultado

---

## Mapeo de Tipos de Datos

La arquitectura utiliza los siguientes tipos de datos Java según las especificaciones:

| Tipo en Especificación | Tipo en Java |
|------------------------|--------------|
| string | String |
| integer/int/long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List<T> |

---

## Estructura del Proyecto

El proyecto sigue estrictamente la **Arquitectura Hexagonal** con la siguiente estructura:

```
src/main/java/pe/gob/sunat/sol/adaptadorpki/
├── domain/
│   ├── model/
│   │   ├── Firma.java
│   │   └── Certificado.java
│   └── ports/
│       ├── in/
│       │   ├── FirmarDocumentoUseCase.java
│       │   ├── ValidarCertificadoUseCase.java
│       │   └── ConsultarCertificadoUseCase.java
│       └── out/
│           └── PKIPort.java
├── application/
│   └── service/
│       ├── FirmarDocumentoService.java
│       ├── ValidarCertificadoService.java
│       └── ConsultarCertificadoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   ├── FirmaController.java
        │       │   └── CertificadoController.java
        │       ├── dto/
        │       │   ├── FirmarDocumentoRequestDto.java
        │       │   ├── FirmarDocumentoResponseDto.java
        │       │   ├── ValidarCertificadoRequestDto.java
        │       │   ├── ValidarCertificadoResponseDto.java
        │       │   └── ConsultarCertificadoResponseDto.java
        │       └── mapper/
        │           ├── FirmaDtoMapper.java
        │           └── CertificadoDtoMapper.java
        └── out/
            └── pki/
                └── client/
                    └── PKIAdapter.java
```

---

## Componentes Principales

### Capa de Dominio (`domain/`)
Contiene la lógica de negocio pura, independiente de tecnología:
- **Modelos**: `Firma`, `Certificado` (POJOs sin anotaciones)
- **Puertos de Entrada (in)**: Interfaces que definen los casos de uso
- **Puertos de Salida (out)**: Interface `PKIPort` para comunicación con sistema PKI externo

### Capa de Aplicación (`application/`)
Contiene los servicios que implementan los casos de uso:
- `FirmarDocumentoService`: Implementa `FirmarDocumentoUseCase`
- `ValidarCertificadoService`: Implementa `ValidarCertificadoUseCase`
- `ConsultarCertificadoService`: Implementa `ConsultarCertificadoUseCase`

Estos servicios orquestan las llamadas al puerto de salida `PKIPort`.

### Capa de Infraestructura (`infrastructure/`)

#### Adaptadores de Entrada (in)
- **Controllers**: Clases POJO que representan endpoints REST (sin anotaciones de frameworks)
- **DTOs**: Records de Java para Request/Response
- **Mappers**: Conversión entre DTOs y modelos de dominio

#### Adaptadores de Salida (out)
- **PKIAdapter**: Implementa `PKIPort` para comunicación con sistema PKI externo
  - Métodos lanzan `UnsupportedOperationException` (implementación stub)
  - NO define protocolo de comunicación específico (ni HTTP, ni SOAP, ni colas)

---

## Casos de Uso Implementados

1. **FirmarDocumentoUseCase**: Firma un documento digital
   - Input: Objeto `Firma` con documento, certificado, password y tipo de firma
   - Output: Objeto `Firma` con documento firmado y fecha de firma

2. **ValidarCertificadoUseCase**: Valida un certificado digital
   - Input: Objeto `Certificado` con certificado y fecha de validación
   - Output: Objeto `Certificado` con resultado de validación

3. **ConsultarCertificadoUseCase**: Consulta información de un certificado
   - Input: String con número de certificado
   - Output: Objeto `Certificado` con información completa

---

## Limitaciones y Consideraciones

### Neutralidad Tecnológica
- **Sin Frameworks**: No se utilizan Spring, JAX-RS, JPA ni ningún framework
- **Sin Anotaciones**: Todo el código es Java puro (POJOs e interfaces)
- **Sin Protocolo Definido**: El adaptador PKI no especifica cómo se conecta (HTTP, SOAP, colas, etc.)
- **Implementación Stub**: Los adaptadores lanzan `UnsupportedOperationException` por defecto

### Sin Gestión de Persistencia
- Este microservicio NO define `RepositoryPort` ni maneja persistencia de datos
- NO existen Entities de persistencia ni mappers de persistencia
- Es un adaptador puro hacia sistema PKI externo

### Sin Build Configuration
- NO se genera `pom.xml` ni configuraciones de build
- Mantiene neutralidad respecto a herramientas de construcción (Maven, Gradle, etc.)

### Errores y Códigos HTTP
- Los status codes están documentados pero NO implementados en el código
- Los controllers no tienen lógica HTTP real (solo métodos simples)
- La gestión de errores debe implementarse al integrar con un framework web

---

## Integraciones Externas

### Sistema PKI
El microservicio se integra con un sistema PKI externo a través de:
- **Puerto de Salida**: `PKIPort` (interface)
- **Adaptador**: `PKIAdapter` (implementación stub)
- **Operaciones**:
  - Firmar documento
  - Validar certificado
  - Consultar certificado por número

**Nota**: La implementación real del `PKIAdapter` debe definirse según el protocolo y tecnología del sistema PKI específico.

---

## Próximos Pasos para Implementación Completa

1. **Elegir Framework Web**: Spring Boot, Quarkus, Micronaut, etc.
2. **Añadir Anotaciones REST**: @RestController, @RequestMapping, @PathVariable, etc.
3. **Implementar PKIAdapter**: Definir protocolo (HTTP, SOAP, etc.) y conectar con sistema PKI real
4. **Gestión de Errores**: Implementar exception handlers y mapeo a códigos HTTP
5. **Validaciones**: Añadir validación de datos de entrada
6. **Configuración**: Añadir archivos de configuración (application.properties, etc.)
7. **Build Tool**: Crear pom.xml (Maven) o build.gradle (Gradle)
8. **Testing**: Añadir pruebas unitarias e integrales
9. **Seguridad**: Implementar autenticación y autorización
10. **Logging y Monitoreo**: Añadir trazabilidad y observabilidad

---

## Principios de Diseño Aplicados

- **Separación de Responsabilidades**: Cada capa tiene responsabilidades claramente definidas
- **Inversión de Dependencias**: El dominio no depende de infraestructura
- **Puertos y Adaptadores**: Comunicación a través de interfaces (puertos)
- **Independencia de Frameworks**: Código Java puro sin dependencias externas
- **Trazabilidad**: Mapeo directo entre especificación PDF y artefactos generados
- **Domain-Driven Design**: Modelos de dominio ricos que representan conceptos de negocio

---

## Autor y Versión

- **Generado por**: Arquitecto de Software Senior
- **Fecha**: Diciembre 2025
- **Versión del Microservicio**: 1.0
- **Basado en**: Especificación PDF "Microservicio MsAdaptadorPKI v1.0.pdf"
