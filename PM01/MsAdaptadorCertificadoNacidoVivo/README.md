# MsAdaptadorCertificadoNacidoVivo

Microservicio adaptador para consulta de certificados de nacido vivo desde el sistema de Hechos Vitales del Ministerio de Salud (MINSA).

**Versión**: 1.2  
**Organización**: RENIEC - Gestión de Seguridad Electrónica  
**Tipo**: MsDominio (Adaptador de Integración)  
**Arquitectura**: Hexagonal (Ports & Adapters)  
**Tecnología**: Java Puro (sin frameworks)

---

## 📋 Tabla de Contenidos

- [Descripción](#descripción)
- [Arquitectura](#arquitectura)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Endpoint Documentado](#endpoint-documentado)
- [Entidades del Dominio](#entidades-del-dominio)
- [Códigos de Respuesta HTTP](#códigos-de-respuesta-http)
- [Patrones Implementados](#patrones-implementados)
- [Compilación y Ejecución](#compilación-y-ejecución)
- [Notas de Implementación](#notas-de-implementación)

---

## 📖 Descripción

El **MsAdaptadorCertificadoNacidoVivo** es un microservicio que actúa como **puente de comunicación especializado** entre el sistema SIIRC de RENIEC y el servicio de Hechos Vitales del Ministerio de Salud.

### Propósito Principal

- Abstraer la complejidad técnica de la comunicación con el servicio externo del MINSA
- Proporcionar una interfaz estandarizada para consultar certificados de nacido vivo
- Implementar patrones de resiliencia (Circuit Breaker, Retry, Timeout)
- Garantizar trazabilidad end-to-end mediante correlation IDs
- Normalizar respuestas y manejar errores del sistema externo

---

## 🏗️ Arquitectura

Este microservicio implementa **Arquitectura Hexagonal** estricta, con las siguientes capas:

```
MsAdaptadorCertificadoNacidoVivo/
├── domain/                          # Capa de Dominio (núcleo)
│   ├── model/                       # Entidades y Value Objects
│   └── ports/                       # Interfaces de puertos
│       ├── in/                      # Puertos de entrada (Use Cases)
│       └── out/                     # Puertos de salida (Data Ports)
│
├── application/                     # Capa de Aplicación
│   └── service/                     # Servicios que orquestan lógica
│
└── infrastructure/                  # Capa de Infraestructura
    └── adapters/                    # Implementaciones de puertos
        ├── in/                      # Adaptadores de entrada
        │   └── rest/                # Controladores REST
        │       ├── controller/
        │       ├── dto/
        │       └── mapper/
        └── out/                     # Adaptadores de salida
            └── minsa/               # Cliente MINSA
                └── client/
```

### Principios Aplicados

✅ **Neutralidad Tecnológica**: Java puro, sin frameworks ni anotaciones  
✅ **Separación de Responsabilidades**: Dominio, Aplicación, Infraestructura  
✅ **Inversión de Dependencias**: Dominio no depende de infraestructura  
✅ **Fidelidad a la Especificación**: Solo operaciones documentadas  

---

## 📁 Estructura del Proyecto

```
src/main/java/pe/gob/reniec/hechosVitales/
│
├── domain/
│   ├── model/
│   │   ├── CertificadoNacidoVivo.java        # Aggregate Root
│   │   ├── Metadata.java                      # Value Object
│   │   ├── Error.java                         # Value Object
│   │   ├── ErrorDetalle.java                  # Value Object
│   │   └── RequestParams.java                 # Value Object
│   │
│   └── ports/
│       ├── in/
│       │   └── ConsultarCertificadoNacidoVivoUseCase.java
│       │
│       └── out/
│           └── CertificadoNacidoVivoDataPort.java
│
├── application/
│   └── service/
│       └── ConsultarCertificadoNacidoVivoService.java
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── CertificadoNacidoVivoController.java
        │       ├── dto/
        │       │   ├── CertificadoResponseDto.java
        │       │   ├── CertificadoDataDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── CertificadoDtoMapper.java
        │
        └── out/
            └── minsa/
                └── client/
                    └── CertificadoNacidoVivoDataAdapter.java
```

---

## 📡 Endpoint Documentado

### GET /api/v1/hechosVitales/MsAdaptadorCertificadoNacidoVivo/certificado-nacido-vivo

Consulta los datos de un certificado de nacido vivo desde el sistema del MINSA.

#### Headers Requeridos

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| `Authorization` | String | Sí | Bearer token JWT para autenticación |
| `Content-Type` | String | Sí | `application/json` |
| `X-Correlation-ID` | UUID | Sí | Identificador único de correlación para trazabilidad |
| `X-Office-Code` | String | Sí | Código de oficina o sede desde donde se realiza la operación |
| `X-User-Role` | String | Sí | Rol del usuario que realiza la operación |
| `X-Request-Source` | String | Sí | Origen: WEB, MOBILE, API_EXTERNA |

#### Query Parameters

| Parámetro | Tipo | Obligatorio | Longitud | Descripción |
|-----------|------|-------------|----------|-------------|
| `coEntidad` | String | Sí | 11 caracteres | Código único de la entidad |
| `nuCnv` | String | Sí | 8-10 caracteres | Número del Certificado de Nacido Vivo |
| `tipoDoc` | String | Sí | 1 carácter | Tipo de documento |

#### Ejemplo de Request

```http
GET /api/v1/hechosVitales/MsAdaptadorCertificadoNacidoVivo/certificado-nacido-vivo?coEntidad=12345678901&nuCnv=12345678&tipoDoc=1 HTTP/1.1
Host: api.reniec.gob.pe
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
Content-Type: application/json
X-Correlation-ID: 550e8400-e29b-41d4-a716-446655440000
X-Office-Code: LIM001
X-User-Role: ADMIN
X-Request-Source: WEB
```

#### Response 200 OK (Éxito)

```json
{
  "success": true,
  "data": {
    "coTipoDocMadre": "1",
    "nuDocMadre": "43567890",
    "feNaceMenor": "20250115",
    "hoNaceMenor": "143000",
    "sexoMenor": "M",
    "coRespuesta": "00",
    "deRespuesta": "Consulta exitosa"
  },
  "metadata": {
    "timestamp": "2025-12-05T10:30:45-05:00",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000",
    "version": "1.2",
    "proveedor": "MINSA"
  }
}
```

#### Response 400 Bad Request (Error de Validación)

```json
{
  "error": {
    "tipo": "ValidationError",
    "titulo": "Parámetros inválidos",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El parámetro 'coEntidad' debe tener exactamente 11 caracteres"
      },
      {
        "detalleError": "El parámetro 'nuCnv' es obligatorio"
      }
    ]
  }
}
```

---

## 🗂️ Entidades del Dominio

### 1. CertificadoNacidoVivo (Aggregate Root)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `coTipoDocMadre` | String | Código de tipo de documento de la madre |
| `nuDocMadre` | String | Número de documento de identidad de la madre |
| `feNaceMenor` | String | Fecha de nacimiento del menor (formato YYYYMMDD) |
| `hoNaceMenor` | String | Hora de nacimiento del menor (formato HHMMSS) |
| `sexoMenor` | String | Sexo de nacimiento del menor |
| `coRespuesta` | String | Código de resultado de la operación |
| `deRespuesta` | String | Descripción del resultado de la operación |

### 2. Metadata (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `timestamp` | String (ISO 8601) | Marca de tiempo del procesamiento |
| `correlationId` | String (UUID) | Identificador de correlación para trazabilidad |
| `version` | String | Versión del servicio |
| `proveedor` | String | Proveedor del servicio externo (MINSA) |

### 3. Error (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `tipo` | String | Tipo de error |
| `titulo` | String | Título del error |
| `estado` | Integer | Código HTTP del error |
| `errores` | List<ErrorDetalle> | Listado de errores detallados |

### 4. ErrorDetalle (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `detalleError` | String | Detalle del error generado |

### 5. RequestParams (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `coEntidad` | String | Código de entidad (11 caracteres) |
| `nuCnv` | String | Número de CNV (8-10 caracteres) |
| `tipoDoc` | String | Tipo de documento (1 carácter) |

---

## 🔢 Códigos de Respuesta HTTP

| Código | Descripción |
|--------|-------------|
| **200** | OK - Consulta realizada exitosamente |
| **400** | Bad Request - Parámetros inválidos o incompletos |
| **401** | Unauthorized - Token JWT inválido, expirado o ausente |
| **403** | Forbidden - Sin permisos suficientes |
| **404** | Not Found - El endpoint solicitado no existe |
| **408** | Request Timeout - Tiempo de espera agotado al conectar |
| **422** | Unprocessable Entity - Error de negocio del MINSA |
| **429** | Too Many Requests - Límite de rate limit excedido |
| **500** | Internal Server Error - Error interno del servicio |
| **502** | Bad Gateway - Servicio MINSA no disponible |
| **503** | Service Unavailable - Circuit Breaker abierto |
| **504** | Gateway Timeout - Servicio MINSA no respondió a tiempo |

---

## 🔧 Patrones Implementados

### 1. Arquitectura Hexagonal (Ports & Adapters)

- **Dominio**: Independiente de tecnología
- **Puertos de Entrada**: Use Cases (interfaces)
- **Puertos de Salida**: DataPort para integración MINSA
- **Adaptadores**: Implementaciones concretas

### 2. Patrones de Resiliencia

- **Circuit Breaker**: Protección contra fallos del servicio externo (código 503)
- **Retry Logic**: Reintentos automáticos en fallos transitorios
- **Timeout Management**: Control de tiempos de espera (códigos 408, 504)

### 3. Patrones de Observabilidad

- **Correlation ID**: Trazabilidad end-to-end mediante `X-Correlation-ID`
- **Metadata Enriquecida**: Timestamp, versión, proveedor en cada respuesta
- **Logging Centralizado**: Registro detallado de errores (implementación pendiente)

### 4. Patrones de Integración

- **Adapter Pattern**: CertificadoNacidoVivoDataAdapter abstrae integración MINSA
- **DTO Pattern**: Separación entre DTOs de infraestructura y entidades de dominio
- **Mapper Pattern**: Transformación bidireccional entre capas

---

## 🛠️ Compilación y Ejecución

### Requisitos

- **Java**: JDK 11 o superior
- **Maven/Gradle**: (opcional, no configurado en este proyecto)

### Compilación Manual

```bash
# Navegar al directorio del proyecto
cd src/main/java

# Compilar todos los archivos Java
javac -d ../../../target/classes pe/gob/reniec/hechosVitales/**/*.java

# El proyecto compilará sin errores
```

### Notas

- **Sin frameworks**: El código es Java puro y compilable
- **Sin dependencias externas**: No se requieren bibliotecas adicionales
- **Stubs implementados**: Los métodos lanzan `UnsupportedOperationException` para indicar implementación pendiente

---

## 📝 Notas de Implementación

### ✅ Completado

1. **Estructura de Dominio**
   - Entidades del dominio definidas según especificación
   - Value Objects para Metadata, Error, RequestParams
   - Aggregate Root: CertificadoNacidoVivo

2. **Puertos (Interfaces)**
   - Puerto de entrada: ConsultarCertificadoNacidoVivoUseCase
   - Puerto de salida: CertificadoNacidoVivoDataPort

3. **Servicios de Aplicación**
   - ConsultarCertificadoNacidoVivoService con validaciones básicas

4. **Adaptadores de Infraestructura**
   - Controller REST con método `obtenerCertificado()`
   - DTOs completos: Response, Data, Metadata, Error
   - Mapper para conversión Domain ↔ DTO
   - DataAdapter stub para integración MINSA

### ⚠️ Pendiente de Implementación

1. **Integración Real con MINSA**
   - Cliente HTTP para llamadas al servicio externo
   - Configuración de headers de autenticación
   - Manejo de respuestas JSON del MINSA
   - Transformación de errores específicos

2. **Patrones de Resiliencia**
   - Implementación concreta de Circuit Breaker
   - Lógica de Retry con backoff exponencial
   - Configuración de timeouts personalizables

3. **Validaciones Completas**
   - Validaciones de formato en RequestParams
   - Validación de tokens JWT
   - Validación de permisos y roles

4. **Logging y Observabilidad**
   - Sistema de logging centralizado
   - Métricas de rendimiento
   - Alertas y monitoreo

5. **Testing**
   - Tests unitarios para servicios
   - Tests de integración para adaptadores
   - Tests de contrato con MINSA

6. **Framework Integration** (si se requiere)
   - Integración con Spring Boot / Quarkus
   - Configuración de beans y dependencias
   - Anotaciones para REST endpoints

---

## 🎯 Decisiones de Diseño

### 1. Tipo de Microservicio: MsDominio

Este es un **MsDominio** (no MsData) porque:

- ✅ Actúa como **adaptador de integración** con sistema externo
- ✅ Contiene **lógica de negocio** (validaciones, normalización)
- ✅ Usa **DataPort** (no RepositoryPort) para integración
- ❌ NO gestiona persistencia propia
- ❌ NO define entidades de base de datos

### 2. Puerto de Salida: DataPort (no RepositoryPort)

Según las convenciones del prompt:

- **MsDominio** → Usa `{Entidad}DataPort` para integración externa
- **MsData** → Usa `{Entidad}RepositoryPort` para persistencia

Este servicio consulta datos externos (MINSA), no persiste datos localmente.

### 3. Operación Única: GET (Consulta)

El PDF documenta **solo un endpoint GET**, por lo tanto:

- ✅ Generado: `ConsultarCertificadoNacidoVivoUseCase`
- ✅ Generado: `ConsultarCertificadoNacidoVivoService`
- ❌ NO generado: CrearXxx, ActualizarXxx, EliminarXxx

**Principio**: Solo generar operaciones explícitamente documentadas.

### 4. Neutralidad Tecnológica

Todo el código es **Java puro**:

- ❌ Sin anotaciones: @RestController, @Service, @Component
- ❌ Sin frameworks: Spring, Jakarta EE, Quarkus
- ❌ Sin librerías: Lombok, MapStruct
- ✅ Interfaces y clases plain Java
- ✅ Compilable con JDK estándar

---

## 📚 Referencias

- **Documento Original**: `p_Microservicio MsAdaptadorCertificadoNacidoVivo V1.2.pdf`
- **Análisis Extraído**: `ANALISIS_PDF.md`
- **Prompt de Arquitectura**: `AGENT_PROMPT_MEJORADO.md`
- **Organización**: RENIEC - Registro Nacional de Identificación y Estado Civil
- **Sistema**: SIIRC (Sistema Integral de Identificación y Registro Civil)

---

## 📞 Soporte

Para consultas o soporte relacionado con este microservicio, contactar al equipo de Arquitectura de Software de RENIEC.

---

**Fecha de Generación**: 2025-12-05  
**Generado por**: Agente de Arquitectura Hexagonal v3.0  
**Basado en**: Especificación oficial v1.2 del 30/11/2025
