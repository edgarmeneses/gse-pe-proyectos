# MsAdaptadorPagos

## 📋 Información General
- **Nombre:** MsAdaptadorPagos
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.pago.MsAdaptadorPagos
- **Contexto:** Componente orquestador y router de la arquitectura de validación de pagos de RENIEC. Actúa como punto de entrada unificado para todas las solicitudes de validación de pago, implementando lógica de routing inteligente para determinar qué adaptador bancario específico debe procesar cada solicitud.

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

- ✓ Define puertos de salida hacia adaptadores externos (`ValidacionPagoDataPort`, `AdaptadorStatusDataPort`)
- ✓ Implementa adaptador cliente (`ValidacionPagoDataAdapter`, `AdaptadorStatusDataAdapter`)
- ✗ NO define `RepositoryPort` (delegado a adaptadores externos)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### RoutearValidacionPago
- **Método:** POST
- **Ruta:** /api/v1/pago/MsAdaptadorPagos/validar-pago
- **Request Body:**
  ```json
  {
    "codigoOperacion": "string",
    "numeroSolicitud": "string",
    "montoCobrar": "decimal",
    "moneda": "string",
    "fechaOperacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "tipoTramite": "string",
    "entidadBancaria": "string",
    "metadata": { ... },
    "configuracionRouting": { ... }
  }
  ```
- **Response:** 200 OK
  ```json
  {
    "routingId": "string",
    "codigoOperacion": "string",
    "numeroSolicitud": "string",
    "entidadBancariaIdentificada": "string",
    "adaptadorUtilizado": "string",
    "validacionExitosa": "boolean",
    "resultadoValidacion": { ... },
    "routing": { ... },
    "auditoria": { ... }
  }
  ```

### ConsultarEstadoAdaptadores
- **Método:** GET
- **Ruta:** /api/v1/pago/MsAdaptadorPagos/estado-adaptadores
- **Request Body:** No requiere
- **Response:** 200 OK
  ```json
  {
    "timestamp": "string",
    "estadoGeneral": "string",
    "adaptadores": [
        {
            "nombre": "string",
            "entidadBancaria": "string",
            "estado": "string",
            "disponible": "boolean",
            "circuitBreaker": { ... },
            "metricas": { ... },
            "ultimaVerificacion": "string"
        }
    ]
  }
  ```

## 🗂️ Entidades del Dominio

### SolicitudValidacion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| codigoOperacion | String | string | - |
| numeroSolicitud | String | string | - |
| montoCobrar | Double | decimal | - |
| moneda | String | string | - |
| fechaOperacion | LocalDateTime | string (ISO) | - |
| tipoTramite | String | string | - |
| entidadBancaria | String | string | - |
| metadata | MetadataSolicitud | object | - |
| configuracionRouting | ConfiguracionRouting | object | - |

### ResultadoValidacion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| routingId | String | string | - |
| codigoOperacion | String | string | - |
| numeroSolicitud | String | string | - |
| entidadBancariaIdentificada | String | string | - |
| adaptadorUtilizado | String | string | - |
| validacionExitosa | Boolean | boolean | - |
| resultadoValidacion | DetalleResultadoValidacion | object | - |
| routing | DetalleRouting | object | - |
| auditoria | AuditoriaInfo | object | - |

### EstadoAdaptadores
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| timestamp | LocalDateTime | string (DateTime) | - |
| estadoGeneral | String | string | - |
| adaptadores | List<AdaptadorInfo> | array | - |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.pago.MsAdaptadorPagos/
├── domain/
│   ├── model/
│   └── ports/ (in, out)
├── application/
│   └── service/
└── infrastructure/
    └── adapters/ (in/rest, out/msdata)
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException`
2. **Sin protocolo de integración:** El adaptador hacia los bancos no define HTTP/SOAP/colas
3. **Sin validaciones:** No se implementa lógica de validación
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones

## ⚠️ AMBIGÜEDADES DETECTADAS

- **Tipos de fecha:** El PDF especifica formatos de fecha como string en algunos casos y DateTime en otros. Se ha usado `LocalDateTime` en el dominio y `String` en los DTOs para facilitar la conversión posterior.
- **Decimal:** Se ha mapeado `decimal` a `Double` siguiendo las reglas del prompt.

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de routing en `RoutearValidacionPagoService`
3. Implementar clientes HTTP reales en `ValidacionPagoDataAdapter`
4. Agregar validaciones y manejo de errores
5. Implementar mappers con lógica real (MapStruct recomendado)
6. Agregar tests unitarios e integración

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsAdaptadorPagos V1.2.pdf
