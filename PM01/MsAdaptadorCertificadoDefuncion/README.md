# MsAdaptadorCertificadoDefuncion

Microservicio adaptador entre SIIRC y WS-CDEF de RENIEC para consulta de certificados de defunción.

## 📋 Información General

- **Versión del API**: v1
- **Organización**: RENIEC - Gestión de Seguridad Electrónica
- **Tipo de Microservicio**: MsDominio (Adaptador/Integración)
- **Arquitectura**: Hexagonal (Ports & Adapters)
- **Tecnología**: Java puro sin frameworks

## 🎯 Propósito

Actúa como **puente de comunicación especializado** entre la plataforma SIIRC y el Web Service de Certificados de Defunción (WS-CDEF) de RENIEC. Su propósito principal es:

- Abstraer la complejidad de la integración con WS-CDEF
- Proteger al SIIRC de cambios en la API externa
- Proporcionar consulta, validación y recuperación estandarizada de certificados de defunción
- Implementar patrones de resiliencia (Circuit Breaker, Retry)

## 🏗️ Arquitectura Hexagonal

```
┌─────────────────────────────────────────────────────────────────────┐
│                         INFRASTRUCTURE LAYER                        │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │              Adapters In (REST Controllers)                │    │
│  │  - CertificadoDefuncionController                          │    │
│  │  - DTOs (Request/Response)                                 │    │
│  │  - Mappers (Domain ↔ DTO)                                  │    │
│  └─────────────────────┬──────────────────────────────────────┘    │
│                        │                                            │
├────────────────────────┼────────────────────────────────────────────┤
│                        ▼                                            │
│                   APPLICATION LAYER                                 │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │              Services (Use Case Implementations)            │   │
│  │  - ConsultarDatosBasicosService                             │   │
│  │  - ConsultarDetalleCompletoService                          │   │
│  └─────────────────────┬───────────────────────────────────────┘   │
│                        │                                            │
├────────────────────────┼────────────────────────────────────────────┤
│                        ▼                                            │
│                     DOMAIN LAYER                                    │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │  Ports In (Use Cases - Interfaces)                          │   │
│  │  - ConsultarDatosBasicosUseCase                             │   │
│  │  - ConsultarDetalleCompletoUseCase                          │   │
│  ├─────────────────────────────────────────────────────────────┤   │
│  │  Model (Aggregates & Value Objects)                         │   │
│  │  - CertificadoDefuncion (Aggregate Root)                    │   │
│  │  - Fallecido, Defuncion, Certificante, etc. (VOs)          │   │
│  ├─────────────────────────────────────────────────────────────┤   │
│  │  Ports Out (External Integrations - Interfaces)             │   │
│  │  - CertificadoDefuncionDataPort                             │   │
│  └─────────────────────┬───────────────────────────────────────┘   │
│                        │                                            │
├────────────────────────┼────────────────────────────────────────────┤
│                        ▼                                            │
│                  INFRASTRUCTURE LAYER                               │
│  ┌─────────────────────────────────────────────────────────────┐   │
│  │              Adapters Out (External Systems)                │   │
│  │  - CertificadoDefuncionDataAdapter (WS-CDEF Client)         │   │
│  └─────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────┘
```

## 📁 Estructura del Proyecto

```
src/main/java/pe/gob/reniec/hechosvitales/certificadodefuncion/
│
├── domain/                                    # Capa de Dominio (núcleo del negocio)
│   ├── model/                                # Entidades y Value Objects
│   │   ├── CertificadoDefuncion.java        # Aggregate Root
│   │   ├── Fallecido.java
│   │   ├── Defuncion.java
│   │   ├── Profesional.java
│   │   ├── Certificante.java
│   │   ├── CausaMuerte.java
│   │   ├── Declarante.java
│   │   └── Auditoria.java
│   │
│   └── ports/                                # Puertos (interfaces)
│       ├── in/                               # Puertos de entrada (Use Cases)
│       │   ├── ConsultarDatosBasicosUseCase.java
│       │   └── ConsultarDetalleCompletoUseCase.java
│       │
│       └── out/                              # Puertos de salida
│           └── CertificadoDefuncionDataPort.java
│
├── application/                              # Capa de Aplicación
│   └── service/                             # Servicios de aplicación
│       ├── ConsultarDatosBasicosService.java
│       └── ConsultarDetalleCompletoService.java
│
└── infrastructure/                          # Capa de Infraestructura
    └── adapters/
        ├── in/                              # Adaptadores de entrada (REST)
        │   └── rest/
        │       ├── controller/
        │       │   └── CertificadoDefuncionController.java
        │       ├── dto/                     # DTOs REST
        │       │   ├── ConsultaCertificadoRequestDto.java
        │       │   ├── ConsultaCertificadoResponseDto.java
        │       │   ├── CertificadoDefuncionDto.java
        │       │   ├── FallecidoDto.java
        │       │   ├── DefuncionDto.java
        │       │   ├── ProfesionalDto.java
        │       │   ├── CertificanteDto.java
        │       │   ├── CausaMuerteDto.java
        │       │   ├── DeclaranteDto.java
        │       │   ├── AuditoriaDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── CertificadoDefuncionDtoMapper.java
        │
        └── out/                             # Adaptadores de salida (Integraciones)
            └── wscdef/
                └── CertificadoDefuncionDataAdapter.java
```

## 🔌 Endpoints

### Base Path
```
/api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion
```

### 1. Consultar Datos Básicos

Obtiene datos básicos de certificados de defunción en estado **VIGENTE**.

**Endpoint:**
```
POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/datos-basicos
```

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad

**Request:**
```json
{
  "coEntidadConsulta": "20131312955",
  "coTipoDocIdentidad": "01",
  "deDocIdentidad": "12345678"
}
```

**Response (200 OK):**
```json
{
  "success": true,
  "statusCode": "200",
  "message": "Operación realizada exitosamente",
  "data": {
    "certificados": [
      {
        "nuCdef": "1234567890",
        "coTipoCdef": "01",
        "feCrea": "01/12/2024 10:30:00",
        "fallecido": {
          "coTitularTipoDocIdentidad": "01",
          "deTitularDocIdentidad": "12345678",
          "deTitularPrimerApellido": "PEREZ",
          "deTitularSegundoApellido": "GOMEZ",
          "deTitularPrenombres": "JUAN CARLOS",
          "feTitularNacimiento": "15/05/1950",
          "deTitularSexo": "M"
        },
        "defuncion": {
          "feFallecimiento": "30/11/2024",
          "coFallecimientoCont": "SA",
          "coFallecimientoPais": "PE",
          "coFallecimientoDpto": "15",
          "coFallecimientoProv": "01",
          "coFallecimientoDist": "01",
          "deFallecimientoTipoLugar": "HOSPITAL",
          "coFallecimientoRenaes": "12345",
          "deFallecimientoNombreLugar": "Hospital Nacional Dos de Mayo"
        },
        "profesional": {
          "deProfDocIdentidad": "87654321"
        }
      }
    ]
  },
  "metadata": {
    "timestamp": "2024-12-04T15:30:00-05:00",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000",
    "version": "v1",
    "source": "WS-CDEF"
  }
}
```

### 2. Consultar Detalle Completo

Obtiene el detalle completo de certificados de defunción en estado **VIGENTE** o **EDITADO**.

**Endpoint:**
```
POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/detalle-completo
```

**Headers:**
- `Authorization`: Bearer token JWT
- `Content-Type`: application/json
- `X-Correlation-ID`: UUID para trazabilidad

**Request:**
```json
{
  "coEntidadConsulta": "20131312955",
  "coTipoDocIdentidad": "01",
  "deDocIdentidad": "12345678"
}
```

**Response (200 OK):**
```json
{
  "success": true,
  "statusCode": "200",
  "message": "Operación realizada exitosamente",
  "data": {
    "certificados": [
      {
        "nuCdef": "1234567890",
        "coTipoCdef": "01",
        "coEstadoCdef": "01",
        "deEstadoCdef": "VIGENTE",
        "feCrea": "01/12/2024 10:30:00",
        "feModifica": "01/12/2024 14:00:00",
        "fallecido": {
          "coTitularTipoDocIdentidad": "01",
          "deTitularDocIdentidad": "12345678",
          "deTitularPrimerApellido": "PEREZ",
          "deTitularSegundoApellido": "GOMEZ",
          "deTitularPrenombres": "JUAN CARLOS",
          "feTitularNacimiento": "15/05/1950",
          "deTitularSexo": "M",
          "coTitularEstadoCivil": "01",
          "deTitularEstadoCivil": "CASADO",
          "coTitularGradoInstruccion": "05",
          "deTitularGradoInstruccion": "SUPERIOR",
          "coTitularOcupacion": "999",
          "deTitularOcupacion": "JUBILADO"
        },
        "defuncion": {
          "feFallecimiento": "30/11/2024",
          "hoFallecimiento": "14:30:00",
          "coFallecimientoCont": "SA",
          "coFallecimientoPais": "PE",
          "deFallecimientoPais": "PERU",
          "coFallecimientoDpto": "15",
          "deFallecimientoDpto": "LIMA",
          "coFallecimientoProv": "01",
          "deFallecimientoProv": "LIMA",
          "coFallecimientoDist": "01",
          "deFallecimientoDist": "LIMA",
          "deFallecimientoTipoLugar": "HOSPITAL",
          "coFallecimientoRenaes": "12345",
          "deFallecimientoNombreLugar": "Hospital Nacional Dos de Mayo",
          "deFallecimientoDireccion": "Av. Grau 13",
          "coTipoMuerte": "01",
          "deTipoMuerte": "NATURAL"
        },
        "causasMuerte": [
          {
            "tipoCausa": "DIRECTA",
            "coEnfermedad": "I21.9",
            "deEnfermedad": "Infarto agudo de miocardio",
            "tiempoEvolucion": "2 horas"
          }
        ],
        "certificante": {
          "deProfDocIdentidad": "87654321",
          "deProfNombres": "MARIA",
          "deProfApellidoPaterno": "RODRIGUEZ",
          "deProfApellidoMaterno": "LOPEZ",
          "coColegioProf": "01",
          "deColegioProf": "COLEGIO MEDICO DEL PERU",
          "nuColegioProf": "54321"
        },
        "declarante": {
          "coDeclaranteTipoDocIdentidad": "01",
          "deDeclaranteDocIdentidad": "23456789",
          "deDeclaranteNombres": "CARMEN",
          "deDeclaranteApellidoPaterno": "PEREZ",
          "deDeclaranteApellidoMaterno": "SILVA",
          "coParentesco": "02",
          "deParentesco": "CONYUGE"
        },
        "observaciones": "Ninguna",
        "auditoria": {
          "usuarioCrea": "USUARIO01",
          "usuarioModifica": "USUARIO01",
          "oficinaCrea": "LIMA01"
        }
      }
    ]
  },
  "metadata": {
    "timestamp": "2024-12-04T15:30:00-05:00",
    "correlationId": "550e8400-e29b-41d4-a716-446655440000",
    "version": "v1",
    "source": "WS-CDEF"
  }
}
```

### Response de Error

**Response (400/401/404/500):**
```json
{
  "error": {
    "tipo": "ValidationError",
    "titulo": "Parámetros inválidos",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El campo coEntidadConsulta debe tener 11 caracteres"
      }
    ]
  }
}
```

## 📊 Códigos de Estado HTTP

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación realizada exitosamente |
| 400 | Bad Request - Parámetros inválidos o incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 404 | Not Found - No se encontraron certificados |
| 408 | Request Timeout - Tiempo de espera agotado al conectar con WS-CDEF |
| 422 | Unprocessable Entity - Datos válidos pero no procesables |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del microservicio |
| 502 | Bad Gateway - WS-CDEF no disponible o respuesta inválida |
| 503 | Service Unavailable - Circuit Breaker abierto |
| 504 | Gateway Timeout - WS-CDEF no respondió a tiempo |

## 🔧 Componentes Principales

### Dominio

**Aggregate Root:**
- `CertificadoDefuncion`: Entidad raíz que encapsula toda la información del certificado

**Value Objects:**
- `Fallecido`: Información del fallecido
- `Defuncion`: Datos del evento de defunción
- `Profesional`: Información básica del profesional
- `Certificante`: Información completa del profesional certificante
- `CausaMuerte`: Causas médicas de la muerte
- `Declarante`: Información del declarante
- `Auditoria`: Información de trazabilidad

### Puertos

**Puertos de Entrada (Use Cases):**
- `ConsultarDatosBasicosUseCase`: Define el contrato para consultar datos básicos
- `ConsultarDetalleCompletoUseCase`: Define el contrato para consultar detalle completo

**Puertos de Salida:**
- `CertificadoDefuncionDataPort`: Define el contrato de integración con WS-CDEF

### Servicios

**Servicios de Aplicación:**
- `ConsultarDatosBasicosService`: Implementa la lógica de consulta de datos básicos
- `ConsultarDetalleCompletoService`: Implementa la lógica de consulta de detalle completo

### Adaptadores

**Adaptadores de Entrada:**
- `CertificadoDefuncionController`: Maneja las peticiones HTTP REST
- `CertificadoDefuncionDtoMapper`: Transforma entre objetos del dominio y DTOs

**Adaptadores de Salida:**
- `CertificadoDefuncionDataAdapter`: Integración con WS-CDEF de RENIEC

## 🔒 Seguridad

- **Autenticación**: Bearer token JWT en header `Authorization`
- **Trazabilidad**: Header `X-Correlation-ID` para seguimiento distribuido
- **Rate Limiting**: Control de peticiones por tiempo

## 🛡️ Patrones de Resiliencia

### Circuit Breaker
Protege el sistema de fallos en cascada cuando WS-CDEF no está disponible.

### Retry
Reintentos automáticos en caso de fallos transitorios de comunicación.

### Timeout
Tiempos de espera configurados para evitar bloqueos indefinidos.

## 🚀 Integración Externa

### Web Service Consumido
**WS-CDEF (Web Service de Certificados de Defunción) - RENIEC**

**Métodos consumidos:**
1. `obtener_datos_cdef`: Consulta datos básicos
2. `obtener_cdef_detalle`: Consulta detalle completo

## 📝 Notas de Implementación

### Características del Código

✅ **Java puro sin frameworks**
- No se usan anotaciones de Spring, Jakarta EE o similares
- No se usan librerías externas como MapStruct o Lombok
- Código compilable con JDK 11+

✅ **Implementaciones stub**
- Los métodos lanzan `UnsupportedOperationException`
- Preparado para implementación real de la lógica de negocio
- Estructura completa lista para integración

✅ **Separación de responsabilidades**
- Dominio aislado de infraestructura
- Dependencias apuntan hacia el dominio (Dependency Inversion)
- Puertos e interfaces claramente definidos

### Siguientes Pasos para Implementación Real

1. **Integración con WS-CDEF:**
   - Implementar cliente SOAP en `CertificadoDefuncionDataAdapter`
   - Configurar timeouts y endpoints
   - Implementar mapeo SOAP/XML ↔ Domain Objects

2. **Patrones de Resiliencia:**
   - Configurar Circuit Breaker (ej: Resilience4j)
   - Configurar política de Retry
   - Implementar fallbacks

3. **Framework REST:**
   - Anotar `CertificadoDefuncionController` con framework elegido (Spring, Quarkus, etc.)
   - Implementar manejo de excepciones global
   - Configurar serialización JSON

4. **Seguridad:**
   - Implementar validación de JWT
   - Configurar HTTPS/TLS
   - Implementar rate limiting

5. **Observabilidad:**
   - Configurar logging centralizado
   - Implementar distributed tracing
   - Configurar métricas y health checks

## 📚 Referencias

- **Documento de Especificación**: p_Microservicio MsAdaptadorCertificadoDefuncion V1.2.pdf
- **Especificación Extraída**: EXTRACTED_SPEC.md
- **Arquitectura Hexagonal**: Ver estructura de carpetas y flujo de dependencias

---

**Generado automáticamente siguiendo el prompt de Arquitectura Hexagonal v3.0**  
**Fecha de generación**: 04/12/2024  
**Versión del microservicio**: v1
