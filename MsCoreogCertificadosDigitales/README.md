# MsCoreogCertificadosDigitales

## Resumen del Microservicio

**Nombre**: MsCoreogCertificadosDigitales  
**Versión API**: 1.0.0  
**Tipo**: MsDominio (Microservicio de Coreografía)  
**Contexto de Negocio**: Gestión de Seguridad Electrónica - RENIEC

El MsCoreogCertificadosDigitales es un microservicio de coreografía encargado de coordinar el flujo técnico de emisión del Certificado Digital DNIe. Este microservicio actúa como un intermediario de negocio, aislando al SIIRC de la complejidad de la infraestructura PKI y ejecutando una secuencia garantizada de dos pasos obligatorios mediante el consumo directo de endpoints del MsAdaptadorPKI.

### Pasos de la Coreografía:
1. **Paso 1 - Generar Identificadores PKI**: `POST /api/v1/adaptador/MsAdaptadorPKI/generarNumerosSolicitud2`
2. **Paso 2 - Emitir Certificado Digital DNIe**: `POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE`

El coreógrafo administra los estados intermedios (solicitudPkiId), registra los tiempos por paso, el manejo de fallas y entrega el certificado emitido.

---

## Endpoints Documentados

### Endpoint: Obtener Certificado Digital

**Path**: `/api/v1/coreog/MsCoreogCertificadosDigitales/obtener-certificado-digital`  
**Método HTTP**: POST  
**Protocolo**: REST/HTTP  
**API Gateway**: Interno

#### Headers Requeridos

| Header | Tipo | Descripción |
|--------|------|-------------|
| Authorization | String | Bearer token JWT para autenticación |
| Content-Type | String | application/json |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad distribuida |
| X-Request-ID | UUID | Identificador único de la solicitud |
| X-Office-Code | String | Código de oficina donde se realiza la solicitud |
| X-Device-ID | String | ID del dispositivo desde donde se origina la solicitud |
| X-Channel | String | Canal de origen |

#### Parámetros de Entrada

| Dato | Atributo | Tipo | Obligatorio | Long. Mín. | Long. Máx. |
|------|----------|------|-------------|------------|------------|
| solicitud | numeroDocumento | String | Sí | 8 | 12 |
| solicitud | tipoDocumento | String | Sí | 2 | 3 |
| solicitud | codigoSolicitudTramite | String | Sí | 1 | 30 |
| solicitud | numeroTramite | String | Sí | 1 | 30 |
| ciudadano | nombres | String | Sí | 1 | 100 |
| ciudadano | apellidoPaterno | String | Sí | 1 | 50 |
| ciudadano | apellidoMaterno | String | No | 1 | 50 |
| ciudadano | fechaNacimiento | LocalDate | Sí | 10 | 10 |
| ciudadano | sexo | String | Sí | 1 | 1 |
| ciudadano | correoElectronico | String | No | 5 | 100 |
| ciudadano | departamento | String | Sí | 1 | 50 |
| ciudadano | provincia | String | Sí | 1 | 50 |
| ciudadano | distrito | String | Sí | 1 | 50 |
| configuracionCertificados | tipoCertificados | List<String> | Sí | 1 | 3 |
| configuracionCertificados | vigenciaAnios | Long | Sí | 1 | 4 |
| configuracionCertificados | usoExtendido | Boolean | No | - | - |
| configuracionCertificados | nivelSeguridad | String | No | 4 | 10 |
| metadatos | oficinaOrigen | String | Sí | 1 | 50 |
| metadatos | usuarioRegistrador | String | Sí | 1 | 30 |
| metadatos | ipOrigen | String | No | 7 | 45 |
| metadatos | timestampSolicitud | LocalDateTime | Sí | 20 | 30 |

#### Respuesta

La respuesta incluye información completa sobre:
- **Transacción**: transaccionId, estado, tiempos de procesamiento
- **Ciudadano**: numeroDocumento, nombreCompleto
- **Certificados**: lista de certificados emitidos con todos sus detalles (tipo, número de serie, fechas, algoritmos, certificado en Base64)
- **Pasos del Proceso**: estado y tiempos de cada paso (generación de claves y emisión)
- **Auditoría**: registros de auditoría completos

#### Códigos de Respuesta HTTP

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Certificados obtenidos exitosamente (cuando ya existían) |
| 201 | Created | Certificados emitidos exitosamente |
| 400 | Bad Request | Parámetros de entrada inválidos o incompletos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Usuario sin permisos para solicitar certificados |
| 404 | Not Found | Ciudadano no encontrado en el sistema |
| 409 | Conflict | Ya existe una solicitud de certificados en proceso para este ciudadano |
| 422 | Unprocessable Entity | Datos válidos pero ciudadano no cumple requisitos para certificados |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del microservicio |
| 502 | Bad Gateway | Error de comunicación con MsAdaptadorPKI |
| 503 | Service Unavailable | Servicio PKI temporalmente no disponible |
| 504 | Gateway Timeout | Timeout en comunicación con servicio PKI |

---

## Entidades del Dominio

### Aggregate Root
- **CertificadoDigital**: Raíz de agregado que contiene toda la información del proceso de obtención de certificados

### Entidades y Value Objects
- **Solicitud**: Información de la solicitud de trámite
- **Ciudadano**: Datos del ciudadano titular del certificado
- **ConfiguracionCertificados**: Configuración de los certificados a emitir
- **Metadatos**: Metadatos de la solicitud (oficina, usuario, IP, timestamp)
- **Transaccion**: Información de la transacción de certificación
- **Certificado**: Información detallada de cada certificado emitido
- **PasosProceso**: Información de los pasos del proceso de coreografía
- **PasoProceso**: Detalle de un paso individual del proceso
- **Auditoria**: Información de auditoría

---

## Mapeo de Tipos de Datos

| Tipo en Especificación | Tipo Java |
|------------------------|-----------|
| string | String |
| integer / int / long | Long |
| number / decimal / double | Double |
| boolean | Boolean |
| date (YYYY-MM-DD) | LocalDate |
| datetime / timestamp (YYYY-MM-DDThh:mm:ssZ) | LocalDateTime |
| array / list | List<T> |
| UUID | String |
| email | String |
| IPv4/IPv6 | String |

---

## Arquitectura Hexagonal

Este proyecto sigue una **Arquitectura Hexagonal estricta** sin dependencias de frameworks ni tecnologías específicas.

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/certificadosdigitales/
│
├── domain/
│   ├── model/
│   │   ├── CertificadoDigital.java (Aggregate Root)
│   │   ├── Solicitud.java
│   │   ├── Ciudadano.java
│   │   ├── ConfiguracionCertificados.java
│   │   ├── Metadatos.java
│   │   ├── Transaccion.java
│   │   ├── Certificado.java
│   │   ├── PasosProceso.java
│   │   ├── PasoProceso.java
│   │   └── Auditoria.java
│   │
│   └── ports/
│       ├── in/
│       │   └── ObtenerCertificadoDigitalUseCase.java
│       │
│       └── out/
│           └── AdaptadorPkiPort.java (Puerto hacia MsAdaptadorPKI)
│
├── application/
│   └── service/
│       └── ObtenerCertificadoDigitalService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── CertificadoDigitalController.java
        │       ├── dto/
        │       │   ├── ObtenerCertificadoDigitalRequestDto.java
        │       │   └── ObtenerCertificadoDigitalResponseDto.java
        │       └── mapper/
        │           └── CertificadoDigitalDtoMapper.java
        │
        └── out/
            └── msdata/
                └── client/
                    └── AdaptadorPkiAdapter.java
```

### Características de la Arquitectura

#### MsDominio - Sin Repository
Como este es un **microservicio de dominio (MsDominio)**, NO contiene:
- RepositoryPort
- Entities de persistencia
- Adaptadores de persistencia

En su lugar, contiene:
- **AdaptadorPkiPort**: Puerto de salida que define las operaciones contra MsAdaptadorPKI
- **AdaptadorPkiAdapter**: Adaptador que implementa el puerto de salida (sin tecnología, sin protocolo)

#### Puertos (Ports)
- **Puertos de Entrada (in)**: Interfaces que definen los casos de uso del sistema
- **Puertos de Salida (out)**: Interfaces que definen las dependencias externas (MsAdaptadorPKI)

#### Adaptadores (Adapters)
- **Adaptadores de Entrada**: Controllers REST (sin anotaciones)
- **Adaptadores de Salida**: Cliente para MsAdaptadorPKI (sin implementación de protocolo)

---

## Limitaciones y Consideraciones

### Sin Frameworks
- **No se utilizan frameworks**: Sin Spring, JAX-RS, JPA, ni otros frameworks
- **Solo Java puro**: Interfaces, clases POJO, records (Java 14+)
- **Sin anotaciones**: No se usan anotaciones de ningún framework

### Sin Protocolo Definido
- Los adaptadores de salida (AdaptadorPkiAdapter) **NO definen el protocolo** de comunicación con MsAdaptadorPKI
- No se asume HTTP, SOAP, colas u otro mecanismo
- Solo se definen los puertos (interfaces) y adaptadores con cuerpos stub (`UnsupportedOperationException`)

### Código Compilable
- Todo el código es **Java puro compilable**
- Las implementaciones lanzan `UnsupportedOperationException` como placeholder
- Los mappers contienen métodos de conversión sin librerías externas

### Build y Despliegue
- **No se incluye pom.xml** ni configuraciones de build (neutralidad tecnológica)
- El proyecto define únicamente la estructura y código Java

---

## Operaciones Implementadas

Solo se implementa la operación documentada en el PDF:

1. **Obtener Certificado Digital** (POST): Coordina el proceso completo de obtención de certificados digitales para un ciudadano

No se han creado operaciones adicionales no especificadas en el PDF.

---

## Notas de Implementación

- Los DTOs están implementados como **records de Java** para inmutabilidad
- Los mapeos de tipos siguen las convenciones especificadas (String → String, integer → Long, date → LocalDate, datetime → LocalDateTime)
- El servicio de aplicación coordina la coreografía de dos pasos con MsAdaptadorPKI
- La trazabilidad y auditoría están incluidas en el modelo de dominio
- Todos los campos opcionales están correctamente identificados

---

## Contexto RENIEC

El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros.

---

**Fecha de Generación**: 01/12/2025  
**Versión del Documento**: 1.1
