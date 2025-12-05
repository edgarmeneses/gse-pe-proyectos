# MsDominioAnalizadorActas

## 📋 Información General
- **Nombre:** MsDominioAnalizadorActas
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.analizadoractas
- **Contexto:** Microservicio de orquestación y coordinación para el análisis automatizado de actas registrales mediante inteligencia artificial dentro del SIIRC (Sistema Integrado de Identificación y Registro Civil) de RENIEC

## 🎯 Propósito del Microservicio

Este microservicio es esencial para la **detección automatizada de inconsistencias, errores o patrones anómalos** en las actas de nacimiento, matrimonio, defunción y adopción, permitiendo a RENIEC mejorar la calidad de los datos registrales y detectar posibles fraudes o duplicidades.

Actúa como intermediario entre:
- **MsDataActas** (Microservicio de Datos de Actas)
- **Componente de IA Analizador de Actas**

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

Como es un microservicio de tipo **MsDominio**:
- ✓ Define puertos de salida hacia MsDataActas (`AnalizadorActasDataPort`)
- ✓ Implementa adaptador cliente (`AnalizadorActasDataAdapter`)
- ✓ Contiene lógica de orquestación y coordinación del análisis
- ✗ **NO define** `RepositoryPort` (delegado a MsData)
- ✗ **NO define** `Entities` de persistencia

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, @Service, @Autowired)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Analizar Actas

Ejecuta análisis automatizado de actas registrales mediante inteligencia artificial basado en criterios de búsqueda definidos por el Calificador Depuración.

- **Método:** POST
- **Ruta:** `/api/v1/actas/MsDominioAnalizadorActas/analizar`
- **API Gateway:** Interno
- **Protocolo:** REST/HTTP

#### Headers

| Header | Tipo | Descripción | Obligatorio |
|--------|------|-------------|-------------|
| Authorization | String | Bearer token JWT para autenticación del usuario | Sí |
| Content-Type | String | "application/json" | Sí |
| X-Correlation-ID | UUID | Identificador único de correlación para trazabilidad end-to-end | Sí |
| X-Office-Code | String | Código de oficina o sede (ej.: ORG-LIMA-CENTRO) | Sí |
| X-User-Role | String | Rol del usuario (CALIFICADOR_DEPURACION) | Sí |
| X-Request-Source | String | Origen de la solicitud (WEB, MOBILE, API_EXTERNA) | Sí |
| X-Idempotency-Key | UUID | Clave única para evitar ejecuciones duplicadas | Sí |

#### Request Body

```json
{
  "solicitudAnalisis": {
    "fechaInicio": "2024-01-01T00:00:00-05:00",
    "fechaFin": "2024-12-31T23:59:59-05:00",
    "tipoEvento": "NACIMIENTO",
    "tipoActa": [
      {
        "codigo": "NAC",
        "descripcion": "Acta de Nacimiento"
      }
    ],
    "oficinaRegistral": {
      "codigo": "OR-LIMA-01",
      "nombre": "Oficina Registral Lima Centro"
    },
    "inconsistenciasPrevias": true
  },
  "usuarioSolicitante": {
    "dni": "12345678",
    "nombres": "Juan Carlos",
    "apellidos": "Pérez García",
    "rol": "CALIFICADOR_DEPURACION"
  },
  "prioridadAnalisis": "ALTA"
}
```

#### Response (200 OK)

```json
{
  "success": true,
  "data": {
    "analisisId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "numeroAnalisis": "AN-2024-001234",
    "fechaEjecucion": "2024-12-05T10:30:00-05:00",
    "estadoAnalisis": "COMPLETADO",
    "criteriosBusqueda": {
      "fechaInicio": "2024-01-01T00:00:00-05:00",
      "fechaFin": "2024-12-31T23:59:59-05:00",
      "tiposActa": ["NAC"],
      "oficinaRegistral": "OR-LIMA-01"
    },
    "resumenResultados": {
      "totalActasAnalizadas": 1500,
      "actasConAlertasAltas": 25,
      "actasConAlertasMedias": 150,
      "actasConAlertasBajas": 300,
      "actasSinInconsistencias": 1025,
      "tiempoProcesamientoSegundos": 45.7
    },
    "resultadosDetallados": [
      {
        "actaId": "acta-001",
        "numeroActa": "NAC-2024-000123",
        "tipoActa": "NACIMIENTO",
        "fechaRegistro": "2024-03-15T14:20:00-05:00",
        "oficinaRegistral": "OR-LIMA-01",
        "scoreRiesgo": 0.85,
        "nivelRiesgo": "ALTO",
        "alertasDetectadas": [
          {
            "codigoAlerta": "ALR-001",
            "tipoAlerta": "INCONSISTENCIA_FECHA",
            "descripcion": "Fecha de nacimiento posterior a fecha de registro",
            "severidad": "ALTA",
            "campoAfectado": "fechaNacimiento"
          }
        ],
        "clasificacionIA": "SOSPECHOSO",
        "recomendaciones": [
          "Verificar manualmente la fecha de nacimiento",
          "Solicitar documentación adicional"
        ],
        "urlActaOriginal": "/api/v1/actas/acta-001"
      }
    ],
    "usuarioSolicitante": {
      "dni": "12345678",
      "nombreCompleto": "Juan Carlos Pérez García",
      "rol": "CALIFICADOR_DEPURACION"
    },
    "_links": {
      "self": "/api/v1/actas/MsDominioAnalizadorActas/analisis/a1b2c3d4-e5f6-7890-abcd-ef1234567890",
      "exportar": "/api/v1/actas/MsDominioAnalizadorActas/analisis/a1b2c3d4-e5f6-7890-abcd-ef1234567890/exportar",
      "actas": "/api/v1/actas/MsDominioAnalizadorActas/analisis/a1b2c3d4-e5f6-7890-abcd-ef1234567890/actas"
    }
  },
  "metadata": {
    "timestamp": "2024-12-05T10:30:15-05:00",
    "correlationId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
    "version": "v1"
  }
}
```

#### Error Response

```json
{
  "error": {
    "tipo": "/api/v1/actas/MsDominioAnalizadorActas/analizar",
    "titulo": "Error de validación",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El campo fechaInicio es obligatorio"
      }
    ]
  }
}
```

#### Status Codes

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Análisis realizado exitosamente |
| 400 | Bad Request | Parámetros de búsqueda inválidos o fuera de rango |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Usuario sin permisos para ejecutar análisis (rol no autorizado) |
| 408 | Request Timeout | Tiempo de espera agotado en consulta a MsDatosActas o componente IA |
| 422 | Unprocessable Entity | No se encontraron actas con los criterios especificados |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servidor |
| 502 | Bad Gateway | Componente de IA no disponible o respuesta inválida |
| 503 | Service Unavailable | Servicio temporalmente no disponible |
| 504 | Gateway Timeout | Componente de IA no respondió en tiempo esperado |

## 🗂️ Entidades del Dominio

### AnalisisActas (Aggregate Root)

Representa el análisis completo de actas registrales mediante inteligencia artificial.

| Campo | Tipo Java | Tipo PDF | Notas |
|-------|-----------|----------|-------|
| analisisId | String | string (UUID) | Identificador único del análisis |
| numeroAnalisis | String | string | Número legible del análisis |
| fechaEjecucion | LocalDateTime | datetime (ISO 8601) | Fecha/hora de ejecución (UTC) |
| estadoAnalisis | String | string | Estado del análisis |
| criteriosBusqueda | CriteriosBusqueda | object | Criterios utilizados |
| resumenResultados | ResumenResultados | object | Resumen consolidado |
| resultadosDetallados | List<ResultadoDetallado> | array | Resultados por acta |
| usuarioSolicitante | UsuarioSolicitante | object | Usuario que solicitó |

### SolicitudAnalisis (Value Object)

Criterios de búsqueda para el análisis de actas.

| Campo | Tipo Java | Tipo PDF | Obligatorio |
|-------|-----------|----------|-------------|
| fechaInicio | LocalDateTime | string (ISO 8601) | Sí |
| fechaFin | LocalDateTime | string (ISO 8601) | Sí |
| tipoEvento | String | string | No |
| tipoActa | List<TipoActa> | array | Sí |
| oficinaRegistral | OficinaRegistral | object | No |
| inconsistenciasPrevias | Boolean | boolean | No |

### TipoActa (Value Object)

| Campo | Tipo Java | Tipo PDF | Obligatorio |
|-------|-----------|----------|-------------|
| codigo | String | string | Sí |
| descripcion | String | string | Sí |

### OficinaRegistral (Value Object)

| Campo | Tipo Java | Tipo PDF | Obligatorio |
|-------|-----------|----------|-------------|
| codigo | String | string | Sí |
| nombre | String | string | Sí |

### UsuarioSolicitante (Value Object)

| Campo | Tipo Java | Tipo PDF | Obligatorio |
|-------|-----------|----------|-------------|
| dni | String | string | Sí |
| nombres | String | string | Sí |
| apellidos | String | string | Sí |
| rol | String | string | Sí |
| nombreCompleto | String | string | Derivado |

### CriteriosBusqueda (Value Object)

| Campo | Tipo Java | Tipo PDF |
|-------|-----------|----------|
| fechaInicio | LocalDateTime | string (ISO 8601) |
| fechaFin | LocalDateTime | string (ISO 8601) |
| tiposActa | List<String> | array |
| oficinaRegistral | String | string |

### ResumenResultados (Value Object)

| Campo | Tipo Java | Tipo PDF |
|-------|-----------|----------|
| totalActasAnalizadas | Integer | integer |
| actasConAlertasAltas | Integer | integer |
| actasConAlertasMedias | Integer | integer |
| actasConAlertasBajas | Integer | integer |
| actasSinInconsistencias | Integer | integer |
| tiempoProcesamientoSegundos | Double | decimal |

### ResultadoDetallado (Value Object)

| Campo | Tipo Java | Tipo PDF |
|-------|-----------|----------|
| actaId | String | string (UUID) |
| numeroActa | String | string |
| tipoActa | String | string |
| fechaRegistro | LocalDateTime | string (ISO 8601) |
| oficinaRegistral | String | string |
| scoreRiesgo | Double | decimal |
| nivelRiesgo | String | string |
| alertasDetectadas | List<AlertaDetectada> | array |
| clasificacionIA | String | string |
| recomendaciones | List<String> | array |
| urlActaOriginal | String | string (URI) |

### AlertaDetectada (Value Object)

| Campo | Tipo Java | Tipo PDF |
|-------|-----------|----------|
| codigoAlerta | String | string |
| tipoAlerta | String | string |
| descripcion | String | string |
| severidad | String | string |
| campoAfectado | String | string |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.analizadoractas/
├── domain/
│   ├── model/
│   │   ├── AnalisisActas.java              (Aggregate Root)
│   │   ├── SolicitudAnalisis.java          (Value Object)
│   │   ├── TipoActa.java                   (Value Object)
│   │   ├── OficinaRegistral.java           (Value Object)
│   │   ├── UsuarioSolicitante.java         (Value Object)
│   │   ├── CriteriosBusqueda.java          (Value Object)
│   │   ├── ResumenResultados.java          (Value Object)
│   │   ├── ResultadoDetallado.java         (Value Object)
│   │   └── AlertaDetectada.java            (Value Object)
│   │
│   └── ports/
│       ├── in/
│       │   └── AnalizarActasUseCase.java   (Puerto de entrada)
│       │
│       └── out/
│           └── AnalizadorActasDataPort.java (Puerto de salida hacia MsData)
│
├── application/
│   └── service/
│       └── AnalizarActasService.java       (Implementación del caso de uso)
│
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── AnalizadorActasController.java
        │       │
        │       ├── dto/
        │       │   ├── AnalisisRequestDto.java
        │       │   ├── SolicitudAnalisisDto.java
        │       │   ├── TipoActaDto.java
        │       │   ├── OficinaRegistralDto.java
        │       │   ├── UsuarioSolicitanteDto.java
        │       │   ├── AnalisisResponseDto.java
        │       │   ├── AnalisisDataDto.java
        │       │   ├── CriteriosBusquedaDto.java
        │       │   ├── ResumenResultadosDto.java
        │       │   ├── ResultadoDetalladoDto.java
        │       │   ├── AlertaDetectadaDto.java
        │       │   ├── LinksDto.java
        │       │   ├── MetadataDto.java
        │       │   └── ErrorResponseDto.java
        │       │
        │       └── mapper/
        │           └── AnalizadorActasDtoMapper.java
        │
        └── out/
            └── msdata/
                └── client/
                    └── AnalizadorActasDataAdapter.java
```

## 🔄 Flujo de Datos

```
1. HTTP Request → AnalizadorActasController
2. Controller → AnalizadorActasDtoMapper (DTO → Domain)
3. Controller → AnalizarActasUseCase
4. UseCase → AnalizarActasService
5. Service → AnalizadorActasDataPort (interface)
6. DataPort → AnalizadorActasDataAdapter (implementación)
7. Adapter → MsDataActas (obtener actas)
8. Adapter → Componente IA (ejecutar análisis)
9. Adapter → MsDataActas (guardar resultados)
10. Service → Controller (resultado)
11. Controller → AnalizadorActasDtoMapper (Domain → DTO)
12. Controller → HTTP Response
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos en el DataAdapter lanzan `UnsupportedOperationException` porque requieren integración real con:
   - **MsDataActas**: Para obtener y guardar actas
   - **Componente de IA**: Para ejecutar el análisis

2. **Sin protocolo de integración definido:** El adaptador hacia MsDataActas y el componente de IA no define si usará:
   - HTTP/REST
   - SOAP/XML
   - gRPC
   - Message Queue (Kafka, RabbitMQ)

3. **Sin validaciones:** No se implementa lógica de validación de negocio (fechas, rangos, permisos)

4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones específicas

5. **Sin autenticación/autorización:** No se valida el token JWT ni los permisos del usuario

6. **Sin circuit breaker:** No hay implementación de patrones de resiliencia

## 🚀 Próximos Pasos (Fuera del Alcance)

1. **Elegir e integrar framework web** (Spring Boot, Quarkus, Jakarta EE)
   - Agregar anotaciones @RestController, @Service, @Component
   - Configurar servidor embebido (Tomcat, Undertow)

2. **Implementar lógica de integración en DataAdapter**
   - Definir cliente HTTP para MsDataActas (RestTemplate, WebClient, Feign)
   - Implementar protocolo de comunicación con componente IA
   - Agregar circuit breaker (Resilience4j, Hystrix)
   - Implementar retry y timeout policies

3. **Agregar validaciones y manejo de errores**
   - Validación de parámetros de entrada (Bean Validation)
   - Manejo centralizado de excepciones (@ControllerAdvice)
   - Validaciones de negocio en servicios

4. **Implementar seguridad**
   - Validación de JWT tokens
   - Autorización basada en roles
   - Rate limiting

5. **Agregar observabilidad**
   - Logging estructurado (SLF4J + Logback)
   - Métricas (Micrometer + Prometheus)
   - Distributed tracing (Sleuth + Zipkin)

6. **Implementar mappers con lógica real**
   - Completar todas las conversiones DTO ↔ Domain
   - Agregar validaciones en mappers

7. **Agregar tests**
   - Tests unitarios (JUnit 5 + Mockito)
   - Tests de integración
   - Tests de contrato (Spring Cloud Contract)

8. **Configuración de despliegue**
   - Dockerfile
   - Kubernetes manifests
   - CI/CD pipelines

## 📝 Notas de Generación

- **Fecha de generación:** 2024-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsDominioAnalizadorActas V1.2.pdf
- **Tipo de microservicio:** MsDominio (orquestación y coordinación)
- **Arquitectura:** Hexagonal estricta, sin dependencias de frameworks
- **Java Version:** Compatible con JDK 11+

## 📚 Referencias

- **Especificación completa:** Ver archivo `p_Microservicio MsDominioAnalizadorActas V1.2.pdf`
- **Arquitectura de referencia:** Documento de Arquitectura RENIEC
- **Estándares de código:** Guía de Arquitectura Hexagonal v3.0

---

**Generado automáticamente por el Agente de Arquitectura Hexagonal**
