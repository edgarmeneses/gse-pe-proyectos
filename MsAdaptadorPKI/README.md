# MsAdaptadorPKI

## Resumen

**MsAdaptadorPKI** (Microservicio Adaptador PKI) es un componente adaptador dentro de la plataforma SIIRC de RENIEC que actúa como fachada/puente entre microservicios internos y el servicio PKI externo de RENIEC. Es parte de la iniciativa de transformación digital DNI Electrónico (DNIe) de Perú.

### Información General

- **Nombre**: MsAdaptadorPKI
- **Tipo**: Microservicio de Dominio (MsDominio)
- **Versión API**: v1
- **Paquete Base**: `pe.gob.reniec.siirc.msadaptadorpki`

### Contexto de Negocio

El microservicio abstrae los detalles del servicio PKI externo de los microservicios de dominio, proporcionando una interfaz simplificada para:
- Generar certificados digitales para DNI Electrónico (autenticación, firma y cifrado)
- Generar números de solicitud únicos para cada tipo de certificado

---

## Arquitectura

### Tipo de Microservicio: MsDominio

Como microservicio de dominio:
- **NO define** `RepositoryPort` (no accede directamente a bases de datos)
- **SÍ define** `PKIDataPort` como puerto de salida para integración con el servicio PKI externo
- **SÍ implementa** `PKIDataAdapter` que implementa `PKIDataPort`
- **NO asume** protocolo de conexión específico (HTTP/SOAP/colas quedan sin definir)

### Arquitectura Hexagonal

El proyecto sigue estrictamente los principios de Arquitectura Hexagonal:

```
src/main/java/pe/gob/reniec/siirc/msadaptadorpki/
├── domain/                          # Capa de Dominio
│   ├── model/                       # Entidades de dominio (POJOs puros)
│   │   ├── CertificadoDigital.java
│   │   ├── SolicitudCertificado.java
│   │   ├── DatosAdicionales.java
│   │   ├── SolicitudNumerosSecuencia.java
│   │   ├── NumerosSolicitud.java
│   │   ├── RespuestaPKI.java
│   │   ├── MetadataRespuesta.java
│   │   ├── ErrorResponse.java
│   │   └── DetalleError.java
│   └── ports/                       # Puertos (interfaces)
│       ├── in/                      # Puertos de entrada (casos de uso)
│       │   ├── GenerarCertificadoDigitalDnieUseCase.java
│       │   └── GenerarNumerosSolicitudUseCase.java
│       └── out/                     # Puertos de salida
│           └── PKIDataPort.java     # Integración con servicio PKI externo
├── application/                     # Capa de Aplicación
│   └── service/                     # Servicios que implementan casos de uso
│       ├── GenerarCertificadoDigitalDnieService.java
│       └── GenerarNumerosSolicitudService.java
└── infrastructure/                  # Capa de Infraestructura
    └── adapters/
        ├── in/                      # Adaptadores de entrada
        │   └── rest/
        │       ├── controller/
        │       │   └── CertificadoDigitalController.java
        │       ├── dto/             # DTOs de request/response
        │       │   ├── GenerarCertificadoDigitalRequestDto.java
        │       │   ├── GenerarCertificadoDigitalResponseDto.java
        │       │   ├── GenerarNumerosSolicitudRequestDto.java
        │       │   ├── GenerarNumerosSolicitudResponseDto.java
        │       │   ├── CertificadoDigitalRequestDto.java
        │       │   ├── CertificadoDigitalResponseDto.java
        │       │   ├── DatosAdicionalesDto.java
        │       │   ├── NumerosSolicitudDto.java
        │       │   ├── RespuestaPKIDto.java
        │       │   └── MetadataRespuestaDto.java
        │       └── mapper/
        │           └── CertificadoDigitalDtoMapper.java
        └── out/                     # Adaptadores de salida
            └── pki/
                └── client/
                    └── PKIDataAdapter.java  # Adaptador al servicio PKI externo
```

### Flujo de Datos

1. **Request** → Controller (REST Adapter) → DTO → Mapper → Domain Model
2. **Domain Model** → Use Case (Port In) → Service → PKI Port (Port Out)
3. **PKI Adapter** → Servicio PKI Externo (sin protocolo definido)
4. **Response** ← Domain Model ← Service ← Mapper ← DTO ← Controller

---

## Endpoints

### 1. Generar Certificado Digital DNIe

Genera certificados digitales para autenticación, firma y cifrado del DNI Electrónico.

**Endpoint**: `POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarCertificadoDigitalDniE`

**Headers**:
```
Authorization: Bearer {token}
Content-Type: application/json
X-Correlation-ID: {UUID}
X-Request-ID: {UUID}
X-Office-Code: {código de 5 caracteres}
X-PKI-Transaction-ID: {ID transacción PKI}
```

**Request Body**:
```json
{
  "numeroCertificados": "string (10 caracteres)",
  "certificadoAutenticacion": {
    "numeroSolicitud": "string (10 caracteres)",
    "numeroDni": "string (8 dígitos)",
    "tipoDocumento": "string (ej: DNI)",
    "apellidoPaterno": "string",
    "apellidoMaterno": "string",
    "nombres": "string",
    "fechaNacimiento": "string (dd/MM/yyyy)",
    "codigoOficina": "string (5 caracteres)",
    "numeroSerie": "string",
    "fechaEmision": "string (dd/MM/yyyy HH:mm:ss)",
    "fechaExpiracion": "string (dd/MM/yyyy HH:mm:ss)",
    "estadoCertificado": "string (VIGENTE, REVOCADO, EXPIRADO)",
    "motivoRevocacion": "string (opcional)",
    "publicKey": "string (Base64)",
    "certificadoPEM": "string (formato PEM)"
  },
  "certificadoFirma": { /* misma estructura */ },
  "certificadoCifrado": { /* misma estructura */ },
  "datosAdicionales": {
    "emailCiudadano": "string",
    "telefonoCiudadano": "string",
    "direccionCiudadano": "string",
    "usuarioRegistro": "string",
    "observaciones": "string"
  }
}
```

**Response (201 Created)**:
```json
{
  "resultado": "EXITOSO",
  "mensaje": "Certificados generados exitosamente",
  "certificados": [
    {
      "tipo": "AUTENTICACION | FIRMA | CIFRADO",
      "numeroSolicitud": "string",
      "numeroCertificado": "string",
      "estadoCertificado": "VIGENTE",
      "fechaEmision": "string (dd/MM/yyyy HH:mm:ss)",
      "fechaExpiracion": "string (dd/MM/yyyy HH:mm:ss)",
      "certificadoPEM": "string"
    }
  ],
  "pkiExterno": {
    "codigoRespuesta": "string",
    "mensajeRespuesta": "string",
    "idTransaccionPKI": "string",
    "timestampPKI": "string (ISO-8601)"
  },
  "metadata": {
    "correlationId": "string",
    "requestId": "string",
    "timestamp": "string (ISO-8601)",
    "version": "v1"
  }
}
```

**Status Codes**:
- `201`: Certificados generados exitosamente
- `400`: Datos de entrada inválidos
- `401`: No autorizado (token inválido)
- `403`: Prohibido (permisos insuficientes)
- `404`: Ciudadano no encontrado en APD
- `409`: Conflicto (certificado ya existe)
- `422`: Error de validación de negocio
- `429`: Too Many Requests (rate limiting)
- `500`: Error interno del servidor
- `502`: Error en servicio PKI externo
- `503`: Servicio no disponible
- `504`: Timeout (> 30 segundos)

---

### 2. Generar Números de Solicitud

Genera números de solicitud únicos para los tres tipos de certificados.

**Endpoint**: `POST /api/v1/certificadosDigitales/MsAdaptadorPKI/generarNumerosSolicitud2`

**Headers**:
```
Authorization: Bearer {token}
Content-Type: application/json
X-Correlation-ID: {UUID}
X-Office-Code: {código de 5 caracteres}
```

**Request Body**:
```json
{
  "dni": "string (8 dígitos, requerido)",
  "nombres": "string (max 100, requerido)",
  "apellidoPaterno": "string (max 50, requerido)",
  "apellidoMaterno": "string (max 50, requerido)",
  "email": "string (formato email, requerido)",
  "telefono": "string (max 15)",
  "direccion": "string (max 200)",
  "codigoOficina": "string (5 caracteres, requerido)",
  "tipoDocumento": "string (default: DNI)",
  "fechaNacimiento": "string (dd/MM/yyyy)",
  "lugarNacimiento": "string",
  "nacionalidad": "string (default: PERUANA)",
  "sexo": "string (M/F)",
  "estadoCivil": "string",
  "observaciones": "string"
}
```

**Response (201 Created)**:
```json
{
  "resultado": "EXITOSO",
  "mensaje": "Números de solicitud generados exitosamente",
  "solicitudes": {
    "numeroSolicitudAutenticacion": "string (10 caracteres)",
    "numeroSolicitudFirma": "string (10 caracteres)",
    "numeroSolicitudCifrado": "string (10 caracteres)"
  },
  "metadata": {
    "correlationId": "string",
    "requestId": "string",
    "timestamp": "string (ISO-8601)",
    "version": "v1"
  }
}
```

**Status Codes**:
- `201`: Números generados exitosamente
- `400`: Datos de entrada inválidos
- `401`: No autorizado
- `403`: Prohibido
- `422`: Error de validación de negocio
- `429`: Too Many Requests
- `500`: Error interno
- `502`: Error en servicio PKI externo
- `503`: Servicio no disponible
- `504`: Timeout

---

## Entidades del Dominio

### CertificadoDigital (Aggregate Root)
Representa un certificado digital del DNIe.

**Atributos**:
- `tipo`: String (AUTENTICACION, FIRMA, CIFRADO)
- `numeroSolicitud`: String (10 caracteres)
- `numeroCertificado`: String (10 caracteres)
- `numeroDni`: String (8 dígitos)
- `tipoDocumento`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `nombres`: String
- `fechaNacimiento`: LocalDate
- `codigoOficina`: String (5 caracteres)
- `numeroSerie`: String
- `fechaEmision`: LocalDateTime
- `fechaExpiracion`: LocalDateTime
- `estadoCertificado`: String (VIGENTE, REVOCADO, EXPIRADO)
- `motivoRevocacion`: String (opcional)
- `publicKey`: String (Base64)
- `certificadoPEM`: String

### SolicitudCertificado
Agrupa la solicitud de los tres certificados.

**Atributos**:
- `numeroCertificados`: String
- `certificadoAutenticacion`: CertificadoDigital
- `certificadoFirma`: CertificadoDigital
- `certificadoCifrado`: CertificadoDigital
- `datosAdicionales`: DatosAdicionales

### DatosAdicionales
Información adicional del ciudadano.

**Atributos**:
- `emailCiudadano`: String
- `telefonoCiudadano`: String
- `direccionCiudadano`: String
- `usuarioRegistro`: String
- `observaciones`: String

### SolicitudNumerosSecuencia
Datos para generar números de solicitud.

**Atributos**:
- `dni`: String (8 dígitos)
- `nombres`: String
- `apellidoPaterno`: String
- `apellidoMaterno`: String
- `email`: String
- `telefono`: String
- `direccion`: String
- `codigoOficina`: String
- `tipoDocumento`: String
- `fechaNacimiento`: LocalDate
- `lugarNacimiento`: String
- `nacionalidad`: String
- `sexo`: String
- `estadoCivil`: String
- `observaciones`: String

### NumerosSolicitud
Números de solicitud generados.

**Atributos**:
- `numeroSolicitudAutenticacion`: String
- `numeroSolicitudFirma`: String
- `numeroSolicitudCifrado`: String

### RespuestaPKI
Respuesta del servicio PKI externo.

**Atributos**:
- `codigoRespuesta`: String
- `mensajeRespuesta`: String
- `idTransaccionPKI`: String
- `timestampPKI`: LocalDateTime

### MetadataRespuesta
Metadatos de trazabilidad.

**Atributos**:
- `correlationId`: String
- `requestId`: String
- `timestamp`: LocalDateTime
- `version`: String

### ErrorResponse
Estructura estándar de error.

**Atributos**:
- `tipo`: String
- `titulo`: String
- `estado`: Integer
- `detalle`: String
- `instancia`: String
- `errores`: List<DetalleError>
- `timestamp`: LocalDateTime
- `correlationId`: String

### DetalleError
Detalle individual de error.

**Atributos**:
- `campo`: String
- `mensaje`: String
- `codigo`: String

---

## Reglas de Mapeo de Tipos

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer/int | Integer |
| long | Long |
| number/decimal/double | Double |
| boolean | Boolean |
| date (dd/MM/yyyy) | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List<T> |

---

## Reglas de Negocio

### Validaciones

1. **Autenticación obligatoria**: Todos los endpoints requieren JWT válido en header `Authorization`
2. **Unicidad de certificados**: No se pueden generar certificados duplicados para un ciudadano/tipo
3. **Validación de existencia**: El ciudadano debe existir en APD antes de generar certificados
4. **Formato DNI**: Debe ser exactamente 8 dígitos numéricos
5. **Formato email**: Debe cumplir formato estándar RFC 5322
6. **Longitud campos**: Respetar longitudes máximas definidas
7. **Fechas**: 
   - Formato `dd/MM/yyyy` para fechas
   - Formato `dd/MM/yyyy HH:mm:ss` para timestamps en request/response
   - Formato ISO-8601 para metadata y respuestas PKI
8. **Códigos de oficina**: Exactamente 5 caracteres

### Políticas Operacionales

#### Timeout
- **Timeout máximo**: 30 segundos
- Si se excede, retornar `504 Gateway Timeout`

#### Rate Limiting
- Implementar límites de peticiones por minuto
- Retornar `429 Too Many Requests` cuando se exceda

#### Circuit Breaker
- Aplicar patrón circuit breaker para llamadas al servicio PKI externo
- Prevenir cascada de fallos
- Retornar `503 Service Unavailable` cuando el circuit esté abierto

#### Trazabilidad
- Todos los endpoints requieren headers `X-Correlation-ID` y `X-Request-ID`
- Propagar estos IDs a través de toda la cadena de llamadas
- Incluir en logs y respuestas de error

---

## Casos de Uso (Puertos de Entrada)

### GenerarCertificadoDigitalDnieUseCase
Genera certificados digitales para el DNIe.

**Método**: `ejecutar(SolicitudCertificado, correlationId, requestId, officeCode, pkiTransactionId)`

**Retorna**: `GenerarCertificadoDigitalDnieResponse`

### GenerarNumerosSolicitudUseCase
Genera números de solicitud únicos.

**Método**: `ejecutar(SolicitudNumerosSecuencia, correlationId, requestId, officeCode)`

**Retorna**: `GenerarNumerosSolicitudResponse`

---

## Puerto de Salida

### PKIDataPort
Interface para integración con el servicio PKI externo de RENIEC.

**Métodos**:
- `generarCertificados(SolicitudCertificado, pkiTransactionId)`: GenerarCertificadosResult
- `generarNumerosSolicitud(SolicitudNumerosSecuencia)`: GenerarNumerosSolicitudResult

**Implementado por**: `PKIDataAdapter` (sin tecnología específica)

---

## Limitaciones y Aclaraciones

### Neutralidad Tecnológica

Este proyecto está diseñado siguiendo el principio de **neutralidad tecnológica**:

- **Sin frameworks**: No usa Spring, JAX-RS, JPA, ni ningún framework específico
- **Sin anotaciones**: Código Java puro (POJOs e interfaces)
- **Sin protocolo definido**: La conexión con el servicio PKI externo no especifica HTTP, SOAP, colas, etc.
- **Sin build tools**: No se genera `pom.xml` ni configuración de construcción

### Implementación de Adaptadores

Los adaptadores son **stubs** que lanzan `UnsupportedOperationException`:

```java
@Override
public GenerarCertificadosResult generarCertificados(SolicitudCertificado solicitud, String pkiTransactionId) {
    throw new UnsupportedOperationException(
        "Método generarCertificados no implementado. " +
        "Debe implementar la conexión con el servicio PKI externo de RENIEC."
    );
}
```

La implementación real debe:
1. Definir el protocolo de comunicación (HTTP REST, SOAP, etc.)
2. Manejar conexiones y timeouts
3. Implementar Circuit Breaker
4. Manejar serialización/deserialización
5. Gestionar errores del servicio externo

### No Repository

Como microservicio de dominio (MsDominio):
- **NO define** `RepositoryPort`
- **NO accede** directamente a bases de datos
- **SÍ integra** con servicios externos a través de puertos de salida

---

## Manejo de Errores

### Estructura de Error Estándar

```json
{
  "tipo": "string (URI que identifica el tipo de error)",
  "titulo": "string (resumen corto)",
  "estado": "integer (código HTTP)",
  "detalle": "string (explicación detallada)",
  "instancia": "string (URI de la petición)",
  "errores": [
    {
      "campo": "string",
      "mensaje": "string",
      "codigo": "string"
    }
  ],
  "timestamp": "string (ISO-8601)",
  "correlationId": "string"
}
```

### Códigos de Error Comunes

- `400`: Validación de formato/estructura
- `401`: Autenticación fallida
- `403`: Sin permisos
- `404`: Recurso no encontrado
- `409`: Conflicto de estado
- `422`: Validación de negocio
- `429`: Rate limit excedido
- `500`: Error interno
- `502`: Error en servicio externo
- `503`: Servicio no disponible
- `504`: Timeout

---

## Próximos Pasos

Para hacer este microservicio ejecutable:

1. **Elegir tecnología**:
   - Framework web (Spring Boot, Quarkus, Micronaut, etc.)
   - Cliente HTTP/SOAP para PKI
   - Serialización JSON

2. **Agregar dependencias**:
   - Crear `pom.xml` o `build.gradle`
   - Dependencias de frameworks elegidos

3. **Implementar PKIDataAdapter**:
   - Conexión real con servicio PKI externo
   - Manejo de timeouts y reintentos
   - Circuit Breaker (Resilience4j, Hystrix, etc.)

4. **Agregar anotaciones**:
   - Controllers: `@RestController`, `@PostMapping`, etc.
   - Dependency Injection: `@Service`, `@Component`, etc.
   - Validation: `@Valid`, `@NotNull`, etc.

5. **Configuración**:
   - `application.properties` / `application.yml`
   - URLs del servicio PKI
   - Timeouts, reintentos, circuit breaker

6. **Seguridad**:
   - Validación JWT
   - Autorización por roles
   - Rate limiting

7. **Observabilidad**:
   - Logs estructurados
   - Métricas (Prometheus)
   - Tracing distribuido (Zipkin, Jaeger)

---

## Documentos Relacionados

- `ESPECIFICACION_EXTRAIDA.md`: Especificación completa extraída del PDF
- PDF original: `Microservicio MsAdaptadorPKI V1.0.pdf`

---

## Licencia

Este proyecto es propiedad de RENIEC (Registro Nacional de Identificación y Estado Civil) - Perú.
