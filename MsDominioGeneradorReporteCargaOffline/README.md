# MsDominioGeneradorReporteCargaOffline

## 📋 Información General
- **Nombre:** MsDominioGeneradorReporteCargaOffline
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe.gse.generadorreportecargaoffline
- **Contexto:** Orquestar un flujo de trabajo para procesar solicitudes recibidas de la aplicación de escritorio en modo offline y generar un reporte consolidado. Su propósito es asegurar que las solicitudes capturadas fuera de línea se integren correctamente en la plataforma central del SIIRC y completen los pasos críticos de su ciclo de vida.

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

- ✓ Define puertos de salida hacia MsData (`ReporteCargaDataPort`, `ReporteCargaPendienteDataPort`)
- ✓ Implementa adaptadores cliente (`ReporteCargaDataAdapter`, `ReporteCargaPendienteDataAdapter`)
- ✗ NO define `RepositoryPort` (delegado a MsData)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Endpoint 1: GenerarReporte
- **Método:** POST
- **Ruta:** `/api/v1/tramite/MsDominioGeneradorReporteCargaOffline/regenerarreporte/`
- **Headers:**
  - `Content-Type: multipart/form-data`
  - `Authorization: String` (Bearer token JWT para autenticación)
  - `X-Correlation-ID: UUID` (ID de correlación para trazabilidad)
  - `X-Office-Code: String` (Código de oficina de origen, formato: ORG-LIMACENTRO)
- **Request Body:**
  ```json
  {
    "idCargueTramite": "string"
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "reporteCargue": {
      "idReporteCargue": "string",
      "cantidadtramitesTransferido": "Integer",
      "logTramitre": ["ArrayString"],
      "estadoReporte": {
        "tipo": "string",
        "valor": ["firmado", "noFirmado"]
      },
      "metadata": {
        "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "correlationId": "string",
        "version": "string"
      }
    },
    "reporteBase64": "String",
    "urlReporteRepositorio": "String"
  }
  ```
- **Status Codes:**
  - `200 OK` - Reporte generado exitosamente
  - `204 No content` - Se aceptó la solicitud, pero aún no se ha generado el reporte
  - `400 Bad Request` - Parámetros inválidos o estructura incorrecta
  - `401 Unauthorized` - Token JWT inválido, expirado o ausente
  - `403 Forbidden` - Sin permisos para ejecutar esta consulta
  - `408 Request Timeout` - Tiempo de espera agotado
  - `429 Too Many Requests` - Límite de rate limit excedido
  - `500 Internal Server Error` - Error interno del servicio
  - `502 Bad Gateway` - Servicio no responde
  - `503 Service Unavailable` - Servicio temporalmente no disponible

### Endpoint 2: GenerarReporteSolicitudesPendientes
- **Método:** POST
- **Ruta:** `/api/v1/tramite/MsDominioGeneradorReporteCargaOffline/generarreporte-pendiente`
- **Headers:**
  - `Content-Type: multipart/form-data`
  - `Authorization: String` (Bearer token JWT para autenticación)
  - `X-Correlation-ID: UUID` (ID de correlación para trazabilidad)
  - `X-Office-Code: String` (Código de oficina de origen, formato: ORG-LIMACENTRO)
- **Request Body:**
  ```json
  {
    "itineranteId": "string"
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "reporteCarguePendiente": {
      "idReportePendiente": "string",
      "cantidadTramitesGestionados": "Integer",
      "estadoReporte": {
        "value": ["firmado", "noFirmado"]
      },
      "metadata": {
        "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "correlationId": "string",
        "version": "string"
      }
    },
    "reporteBase64": "String",
    "urlReporteRepositorio": "String"
  }
  ```
- **Status Codes:**
  - `200 OK` - Reporte generado exitosamente
  - `204 No content` - Se aceptó la solicitud, pero aún no se ha generado el reporte
  - `400 Bad Request` - Parámetros inválidos o estructura incorrecta
  - `401 Unauthorized` - Token JWT inválido, expirado o ausente
  - `403 Forbidden` - Sin permisos para ejecutar esta consulta
  - `408 Request Timeout` - Tiempo de espera agotado
  - `429 Too Many Requests` - Límite de rate limit excedido
  - `500 Internal Server Error` - Error interno del servicio
  - `502 Bad Gateway` - Servicio no responde
  - `503 Service Unavailable` - Servicio temporalmente no disponible

## 🗂️ Entidades del Dominio

### ReporteCarga
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| idReporteCargue | String | string | Identificador único del reporte |
| cantidadTramitesTransferido | Integer | Integer | Cantidad de trámites procesados |
| logTramitre | List&lt;String&gt; | ArrayString | Logs de trámites transferidos |
| estadoReporte | EstadoReporte | Object | Estado del reporte (firmado/no firmado) |
| metadata | Metadata | Object | Metadatos de la operación |
| reporteBase64 | String | String | Reporte en formato Base64 |
| urlReporteRepositorio | String | String | URL del reporte en repositorio |

### ReporteCargaPendiente
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| idReportePendiente | String | string | Identificador único del reporte pendiente |
| cantidadTramitesGestionados | Integer | Integer | Cantidad de trámites gestionados |
| estadoReporte | EstadoReporte | Object | Estado del reporte (firmado/no firmado) |
| metadata | Metadata | Object | Metadatos de la operación |
| reporteBase64 | String | String | Reporte en formato Base64 |
| urlReporteRepositorio | String | String | URL del reporte en repositorio |

### EstadoReporte (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| tipo | String | string | Tipo de estado |
| valor | List&lt;String&gt; | Array | Valores posibles: ["firmado", "noFirmado"] |

### Metadata (Value Object)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| timestamp | LocalDateTime | String (ISO 8601) | Marca de tiempo del procesamiento |
| correlationId | String | string | ID de correlación para trazabilidad |
| version | String | string | Versión del servicio |

## 📦 Estructura de Paquetes

```
pe.gse.generadorreportecargaoffline/
├── domain/
│   ├── model/
│   │   ├── ReporteCarga.java
│   │   ├── ReporteCargaPendiente.java
│   │   ├── EstadoReporte.java
│   │   └── Metadata.java
│   └── ports/
│       ├── in/
│       │   ├── GenerarReporteUseCase.java
│       │   └── GenerarReporteSolicitudesPendientesUseCase.java
│       └── out/
│           ├── ReporteCargaDataPort.java
│           └── ReporteCargaPendienteDataPort.java
├── application/
│   └── service/
│       ├── GenerarReporteService.java
│       └── GenerarReporteSolicitudesPendientesService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── GeneradorReporteCargaOfflineController.java
        │       ├── dto/
        │       │   ├── ReporteCargaRequestDto.java
        │       │   ├── ReporteCargaResponseDto.java
        │       │   ├── ReporteCargaPendienteRequestDto.java
        │       │   ├── ReporteCargaPendienteResponseDto.java
        │       │   └── ErrorResponseDto.java
        │       └── mapper/
        │           ├── ReporteCargaDtoMapper.java
        │           └── ReporteCargaPendienteDtoMapper.java
        └── out/
            └── msdata/
                └── client/
                    ├── ReporteCargaDataAdapter.java
                    └── ReporteCargaPendienteDataAdapter.java
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException`
2. **Sin protocolo de integración:** Los adaptadores hacia MsData no definen HTTP/SOAP/colas
3. **Sin validaciones:** No se implementa lógica de validación
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones
5. **Sin anotaciones de frameworks:** El código es Java puro sin dependencias externas

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de negocio en servicios
3. Definir protocolo de integración con MsData (HTTP REST, SOAP, colas de mensajería)
4. Agregar validaciones y manejo de errores
5. Implementar mappers con lógica real de conversión
6. Agregar tests unitarios e integración
7. Configurar autenticación y autorización (JWT)
8. Implementar logging y trazabilidad distribuida
9. Configurar métricas y observabilidad

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-04
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio GeneradorReporteCargaOffLine V1.2.pdf

## 📚 Casos de Uso Implementados

| Caso de Uso | Archivo | Operación HTTP | Endpoint |
|-------------|---------|----------------|----------|
| Generar Reporte | GenerarReporteUseCase.java | POST | /regenerarreporte/ |
| Generar Reporte Solicitudes Pendientes | GenerarReporteSolicitudesPendientesUseCase.java | POST | /generarreporte-pendiente |

## 🔍 Flujo de Datos (Arquitectura Hexagonal)

```
Request → Controller → UseCase → Service → DataPort → DataAdapter → MsData
                                    ↓
                                 Domain
                                 Models
```

### Flujo Detallado:
1. **Controller** recibe request HTTP (sin anotaciones, POJO puro)
2. **Mapper** convierte DTO a entidad del dominio
3. **UseCase** define el contrato de entrada
4. **Service** implementa la lógica de negocio
5. **DataPort** define el contrato de salida hacia MsData
6. **DataAdapter** implementa la integración con MsData (protocolo pendiente)

## 📋 Checklist de Validación

- ✅ Fidelidad a la especificación del PDF
- ✅ Sin anotaciones de frameworks
- ✅ Arquitectura hexagonal correcta (MsDominio)
- ✅ Convenciones de nomenclatura respetadas
- ✅ Estructura de carpetas según especificación
- ✅ README.md completo
- ✅ Código compilable (Java puro)
