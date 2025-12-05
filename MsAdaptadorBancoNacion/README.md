# MsAdaptadorBancoNacion

## 📋 Información General
- **Nombre:** MsAdaptadorBancoNacion
- **Tipo:** Adaptador de Integración (basado en patrón MsDominio)
- **Versión API:** v1
- **Paquete base:** pe.gob.reniec.adaptadorbanconacion
- **Contexto:** Gestión de Seguridad Electrónica - RENIEC. Adaptador de integración especializado que actúa como traductor bidireccional y puente de comunicación exclusivo con el Banco de la Nación para la validación de pagos. Transforma el formato estándar de SIIRC en los protocolos propietarios del banco y normaliza las respuestas.

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: Adaptador de Integración

- ✓ Define puertos de salida hacia el Banco de la Nación (`BancoNacionPort`)
- ✓ Implementa adaptador cliente (`BancoNacionAdapter`)
- ✓ Traduce protocolos entre SIIRC y el Banco de la Nación
- ✗ NO define `RepositoryPort` (no gestiona persistencia)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Validar Pago con Banco de la Nación
- **Método:** POST
- **Ruta:** /api/v1/pago/MsAdaptadorBancoNacion/validar-banco-nacion
- **API Gateway:** Interno
- **Protocolo:** REST/HTTP
- **Headers:**
  - `Authorization`: String (Bearer token JWT para autenticación)
  - `X-Correlation-ID`: UUID (ID de correlación para trazabilidad distribuida)
  - `X-Office-Code`: String (Código de oficina RENIEC, formato: ORG-LIMA-CENTRO)
  - `X-Request-Source`: String (Origen de la solicitud: CoreService, EvaluacionService, etc.)
  - `X-User-ID`: String (Identificador del usuario que realiza la consulta)

- **Request Body:**
  ```json
  {
    "codigoOperacion": "string",
    "numeroSolicitud": "string",
    "montoCobrar": 0.0,
    "moneda": "PEN",
    "fechaOperacion": "2025-11-30",
    "tipoTramite": "string",
    "metadata": {
      "dni": "12345678",
      "nombreCompleto": "string",
      "codigoOficina": "string",
      "usuarioRegistrador": "string"
    }
  }
  ```

- **Response:** 200 OK
  ```json
  {
    "validacionId": "uuid",
    "codigoOperacion": "string",
    "numeroSolicitud": "string",
    "esValido": true,
    "estadoTransaccion": "APROBADO",
    "detalleTransaccion": {
      "montoPagado": 0.0,
      "moneda": "PEN",
      "fechaPago": "2025-11-30",
      "horaPago": "10:30:00",
      "codigoAgencia": "string",
      "nombreAgencia": "string",
      "numeroCuenta": "string",
      "codigoAutorizacion": "string"
    },
    "coincidencias": {
      "montoCoincide": true,
      "diferenciaMonto": 0.0,
      "fechaCoincide": true,
      "diasDiferencia": 0
    },
    "auditoria": {
      "timestampConsulta": "2025-11-30T10:30:00",
      "tiempoRespuestaMs": 150,
      "ipOrigen": "192.168.1.1",
      "usuarioConsulta": "string",
      "intentosRealizados": 1
    },
    "mensajes": []
  }
  ```

- **Error Response:**
  ```json
  {
    "error": {
      "tipo": "string",
      "titulo": "string",
      "estado": 400,
      "errores": [
        {
          "detalleError": "string"
        }
      ]
    }
  }
  ```

## 🗂️ Entidades del Dominio

### Validacion (Aggregate Root)
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| validacionId | String | string (UUID) | Identificador único de la validación |
| codigoOperacion | String | string | Código de operación consultado |
| numeroSolicitud | String | string | Número de solicitud asociada |
| esValido | Boolean | boolean | Indica si el pago es válido |
| estadoTransaccion | String | string | Estado de la transacción |
| detalleTransaccion | DetalleTransaccion | object | Detalle completo de la transacción |
| coincidencias | Coincidencias | object | Análisis de coincidencias |
| auditoria | Auditoria | object | Información de auditoría |
| mensajes | List<String> | array[string] | Mensajes informativos o advertencias |

### SolicitudValidacion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| codigoOperacion | String | string | Código de operación (6-20 caracteres) |
| numeroSolicitud | String | string | Número de solicitud (1-50 caracteres) |
| montoCobrar | Double | decimal | Monto a cobrar |
| moneda | String | string | Moneda (3 caracteres) |
| fechaOperacion | String | string | Fecha de operación (opcional) |
| tipoTramite | String | string | Tipo de trámite (1-100 caracteres) |
| metadata | Metadata | object | Metadata adicional (opcional) |

### DetalleTransaccion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| montoPagado | Double | decimal | Monto efectivamente pagado |
| moneda | String | string | Moneda de la transacción |
| fechaPago | String | string | Fecha del pago |
| horaPago | String | string | Hora del pago |
| codigoAgencia | String | string | Código de agencia bancaria |
| nombreAgencia | String | string | Nombre de agencia bancaria |
| numeroCuenta | String | string | Número de cuenta destino |
| codigoAutorizacion | String | string | Código de autorización bancaria |

### Coincidencias
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| montoCoincide | Boolean | boolean | Indica si el monto pagado coincide |
| diferenciaMonto | Double | decimal | Diferencia entre monto pagado y esperado |
| fechaCoincide | Boolean | boolean | Indica si la fecha coincide |
| diasDiferencia | Integer | integer | Días de diferencia con fecha esperada |

### Auditoria
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| timestampConsulta | LocalDateTime | string (DateTime) | Timestamp de la consulta (ISO 8601) |
| tiempoRespuestaMs | Integer | integer | Tiempo de respuesta en milisegundos |
| ipOrigen | String | string | IP desde donde se realizó la consulta |
| usuarioConsulta | String | string | Usuario que realizó la consulta |
| intentosRealizados | Integer | integer | Número de intentos realizados |

### Metadata
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | DNI (8 caracteres) |
| nombreCompleto | String | string | Nombre completo (1-200 caracteres) |
| codigoOficina | String | string | Código de oficina (1-50 caracteres) |
| usuarioRegistrador | String | string | Usuario registrador (1-100 caracteres) |

## 📦 Estructura de Paquetes

```
pe.gob.reniec.adaptadorbanconacion/
├── domain/
│   ├── model/
│   │   ├── Validacion.java
│   │   ├── SolicitudValidacion.java
│   │   ├── DetalleTransaccion.java
│   │   ├── Coincidencias.java
│   │   ├── Auditoria.java
│   │   └── Metadata.java
│   └── ports/
│       ├── in/
│       │   └── ValidarPagoBancoNacionUseCase.java
│       └── out/
│           └── BancoNacionPort.java
├── application/
│   └── service/
│       └── ValidarPagoBancoNacionService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── ValidacionPagoController.java
        │       ├── dto/
        │       │   ├── ValidacionPagoRequestDto.java
        │       │   ├── ValidacionPagoResponseDto.java
        │       │   ├── DetalleTransaccionDto.java
        │       │   ├── CoincidenciasDto.java
        │       │   ├── AuditoriaDto.java
        │       │   ├── MetadataDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   └── ErrorDetalleDto.java
        │       └── mapper/
        │           └── ValidacionPagoDtoMapper.java
        └── out/
            └── banconacion/
                └── BancoNacionAdapter.java
```

## 📋 Códigos de Respuesta HTTP

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Validación realizada exitosamente |
| 400 | Bad Request | Código de operación inválido o parámetros incorrectos |
| 401 | Unauthorized | Token JWT inválido, expirado o ausente |
| 403 | Forbidden | Sin permisos para validar pagos |
| 404 | Not Found | Código de operación no encontrado en el Banco de la Nación |
| 408 | Request Timeout | Tiempo de espera agotado al consultar el banco |
| 422 | Unprocessable Entity | Datos válidos, pero inconsistencias detectadas (monto no coincide) |
| 500 | Internal Server Error | Error interno del adaptador |
| 502 | Bad Gateway | API del Banco de la Nación no disponible o respuesta inválida |
| 503 | Service Unavailable | Servicio temporalmente no disponible (Circuit Breaker abierto) |
| 504 | Gateway Timeout | API del Banco de la Nación no respondió en tiempo esperado |

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException` - requieren implementación real
2. **Sin protocolo de integración:** El adaptador hacia el Banco de la Nación no define HTTP/SOAP/otros protocolos específicos
3. **Sin validaciones:** No se implementa lógica de validación de datos
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones
5. **Sin traducción de protocolos:** La lógica de traducción entre SIIRC y el formato del Banco de la Nación debe ser implementada
6. **Sin lógica de coincidencias:** El análisis de coincidencias de montos y fechas debe ser implementado
7. **Sin generación de UUID:** La generación del `validacionId` debe ser implementada

## 🚀 Próximos Pasos (Fuera del Alcance)

1. Elegir e integrar framework web (Spring Boot, Quarkus, etc.)
2. Implementar lógica de validación en el servicio
3. Definir protocolo de integración con el Banco de la Nación (REST, SOAP, etc.)
4. Implementar lógica de traducción de protocolos en `BancoNacionAdapter`
5. Implementar análisis de coincidencias (montos, fechas)
6. Agregar validaciones de entrada y manejo de errores
7. Implementar mappers con lógica de conversión real
8. Configurar Circuit Breaker para resiliencia
9. Implementar retry policies para llamadas al banco
10. Agregar logging y métricas
11. Agregar tests unitarios e integración
12. Configurar timeouts y conexiones HTTP
13. Implementar seguridad (JWT validation, HTTPS)

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-04
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsAdaptadorBancoNacion V1.2.pdf
- **Tipo de microservicio:** Adaptador de integración basado en patrón MsDominio (no gestiona persistencia, integra con servicios externos)
- **Flujo de datos:** Controller → UseCase → Service → BancoNacionPort → BancoNacionAdapter → API Banco de la Nación

## 🔍 Análisis de Arquitectura

### Separación de Responsabilidades

1. **Domain Layer (Capa de Dominio)**
   - Contiene las entidades del negocio y las interfaces de los puertos
   - Totalmente independiente de frameworks y tecnologías
   - Define el contrato de comunicación (puertos de entrada y salida)

2. **Application Layer (Capa de Aplicación)**
   - Implementa los casos de uso del negocio
   - Orquesta la lógica entre el dominio y los adaptadores
   - Contiene la lógica de aplicación (traducción, normalización, validación)

3. **Infrastructure Layer (Capa de Infraestructura)**
   - Adaptadores de entrada (REST controllers, DTOs)
   - Adaptadores de salida (integración con Banco de la Nación)
   - Mappers para convertir entre DTOs y entidades de dominio
   - Puede ser reemplazada sin afectar el dominio

### Principios Aplicados

- **Inversión de Dependencias:** El dominio no depende de la infraestructura
- **Separación de Concerns:** Cada capa tiene responsabilidades claras
- **Puertos y Adaptadores:** Interfaces definen contratos, adaptadores los implementan
- **Neutralidad Tecnológica:** El código es puro Java, sin dependencias de frameworks
