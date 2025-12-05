# MsDominioAnalisisBiometrico

## 📋 Información General
- **Nombre:** MsDominioAnalisisBiometrico
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.analisisbiometrico
- **Contexto:** Gestión de Seguridad Electrónica - RENIEC. Sistema de validación de identidad de ciudadanos mediante análisis de datos biométricos (huellas dactilares y fotografías faciales).

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

- ✓ Define puertos de salida hacia MsData (`AnalisisBiometricoDataPort`)
- ✓ Implementa adaptador cliente (`AnalisisBiometricoDataAdapter`)
- ✗ NO define `RepositoryPort` (delegado a MsData)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Validar Datos Biométricos
- **Método:** POST
- **Ruta:** /api/v1/tramite/MsDominioAnalisisBiometrico
- **API Gateway:** Interno
- **Protocolo:** REST/HTTP
- **Headers:**
  - Content-Type: multipart/form-data
  - Authorization: String (Bearer token JWT)
  - X-Correlation-ID: UUID (ID de correlación para trazabilidad)
  - X-Office-Code: String (Código de oficina, formato: ORG-LIMACENTRO)

- **Request Body:**
  ```json
  {
    "ciudadanos": [
      {
        "dni": "string",
        "nombres": "string",
        "apellidos": "string",
        "huellasDactilares": ["ArrayString"],
        "fotografiasFaciales": ["ArrayString"]
      }
    ]
  }
  ```

- **Response:** 200 OK
  ```json
  {
    "resultadoAnalisis": [
      {
        "dni": "string",
        "identidadConfirmadaHuellas": "string",
        "identidadConfirmadaFotos": "string",
        "observaciones": ["ArrayString"],
        "identidadesEncontradasConHuellas": [
          {
            "dni": "string",
            "nombres": "string",
            "apellidos": "string",
            "huellasDactilares": ["ArrayString"]
          }
        ],
        "identidadesEncontradasConFotos": [
          {
            "dni": "string",
            "nombres": "string",
            "apellidos": "string",
            "fotografiasFaciales": ["ArrayString"]
          }
        ]
      }
    ]
  }
  ```

- **Error Response:**
  ```json
  {
    "error": {
      "tipo": "string",
      "titulo": "string",
      "estado": "integer",
      "errores": [
        {
          "detalleError": "string"
        }
      ]
    }
  }
  ```

- **Status Codes:**
  - 200 - OK: Validación realizada exitosamente
  - 400 - Bad Request: Parámetros inválidos
  - 401 - Unauthorized: Token JWT inválido, expirado o ausente
  - 403 - Forbidden: Sin permisos para realizar el análisis
  - 429 - Too Many Requests: Límite de rate limit excedido
  - 500 - Internal Server Error: Error interno del servidor
  - 502 - Bad Gateway: Todos los proveedores externos no disponibles
  - 503 - Service Unavailable: Servicio temporalmente no disponible

## 🗂️ Entidades del Dominio

### Ciudadano
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | Número de documento de identidad |
| nombres | String | string | Nombres del ciudadano (1-50 caracteres) |
| apellidos | String | string | Apellidos del ciudadano (1-60 caracteres) |
| huellasDactilares | List\<String\> | Array(string) | Lista de huellas dactilares |
| fotografiasFaciales | List\<String\> | Array(string) | Lista de fotografías faciales |

### ResultadoAnalisis
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | DNI del ciudadano analizado |
| identidadConfirmadaHuellas | String | string | Indica si se encontró coincidencia por huellas |
| identidadConfirmadaFotos | String | string | Indica si se encontró coincidencia por fotos |
| observaciones | List\<String\> | Array(string) | Lista de observaciones detectadas |
| identidadesEncontradasConHuellas | List\<IdentidadEncontradaConHuellas\> | Array(object) | Identidades que coinciden con huellas |
| identidadesEncontradasConFotos | List\<IdentidadEncontradaConFotos\> | Array(object) | Identidades que coinciden con fotos |

### IdentidadEncontradaConHuellas
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | DNI de la persona identificada |
| nombres | String | string | Nombres de la persona identificada |
| apellidos | String | string | Apellidos de la persona identificada |
| huellasDactilares | List\<String\> | Array(string) | Huellas que coincidieron |

### IdentidadEncontradaConFotos
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | DNI de la persona identificada |
| nombres | String | string | Nombres de la persona identificada |
| apellidos | String | string | Apellidos de la persona identificada |
| fotografiasFaciales | List\<String\> | Array(string) | Fotos que coincidieron |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.analisisbiometrico/
├── domain/
│   ├── model/
│   │   ├── Ciudadano.java
│   │   ├── ResultadoAnalisis.java
│   │   ├── IdentidadEncontradaConHuellas.java
│   │   └── IdentidadEncontradaConFotos.java
│   └── ports/
│       ├── in/
│       │   └── ValidarDatosBiometricosUseCase.java
│       └── out/
│           └── AnalisisBiometricoDataPort.java
├── application/
│   └── service/
│       └── ValidarDatosBiometricosService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── AnalisisBiometricoController.java
        │       ├── dto/
        │       │   ├── ValidarDatosBiometricosRequestDto.java
        │       │   ├── ValidarDatosBiometricosResponseDto.java
        │       │   ├── CiudadanoRequestDto.java
        │       │   ├── ResultadoAnalisisDto.java
        │       │   ├── IdentidadEncontradaConHuellasDto.java
        │       │   ├── IdentidadEncontradaConFotosDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           └── AnalisisBiometricoDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    └── AnalisisBiometricoDataAdapter.java
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException`
2. **Sin protocolo de integración:** El adaptador hacia MsData no define HTTP/SOAP/colas
3. **Sin validaciones:** No se implementa lógica de validación
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones
5. **Content-Type multipart/form-data:** El endpoint especifica multipart/form-data en el PDF, pero la implementación asume JSON para simplificación

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de negocio en servicios
3. Definir protocolo de integración con MsData de análisis biométrico
4. Agregar validaciones y manejo de errores
5. Implementar mappers con lógica real de conversión
6. Agregar tests unitarios e integración
7. Implementar manejo de multipart/form-data si es requerido
8. Configurar logging, tracing y métricas
9. Implementar patrones Circuit Breaker y Retry para resiliencia

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsDominioAnalisisBiometrico V1.2.pdf
- **Documento versión:** 1.2 (30/11/2025)
- **Organización:** RENIEC - Registro Nacional de Identificación y Estado Civil

## 🔍 Casos de Uso Implementados

De acuerdo con el PDF, se implementó únicamente el siguiente caso de uso:

1. **ValidarDatosBiometricosUseCase** - Correspondiente al endpoint POST /api/v1/tramite/MsDominioAnalisisBiometrico

No se generaron casos de uso adicionales (GET, PUT, DELETE) ya que no están documentados en la especificación.
