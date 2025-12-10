# MsAdaptadorNotificaciones

## 📋 Información General
- **Nombre:** MsAdaptadorNotificaciones
- **Tipo:** MsDominio
- **Versión API:** v1
- **Paquete base:** pe/gob/reniec/notificaciones/MsAdaptadorNotificaciones
- **Contexto:** Microservicio de integración especializado que actúa como orquestador de notificaciones multicanal hacia ciudadanos. Gestiona el envío de notificaciones a través de proveedores externos (correo electrónico, SMS, WhatsApp, casilla electrónica).

## 🏗️ Arquitectura

Este proyecto sigue **Arquitectura Hexagonal** estricta con las siguientes características:

### Tipo de Microservicio: MsDominio

- ✓ Define puertos de salida hacia MsData (`NotificacionDataPort`)
- ✓ Implementa adaptador cliente (`NotificacionDataAdapter`)
- ✗ NO define `RepositoryPort` (delegado a MsData)

### Restricciones Tecnológicas
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, etc.)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Java puro (POJOs, interfaces, clases)
- ✅ Compilable con JDK 11+

## 📡 Endpoints

### Enviar Notificación
- **Método:** POST
- **Ruta:** /api/v1/notificaciones/MsAdaptadorNotificaciones/enviar
- **Request Body:**
  ```json
  {
    "plantillaId": "string",
    "destinatarios": [...],
    "canalesPrioritarios": ["string"],
    "parametros": {...},
    "asunto": "string",
    "adjuntos": [...],
    "webhookUrl": "string",
    "webhookHeaders": {...},
    "metadata": {...}
  }
  ```
- **Response:** 202 Accepted
  ```json
  {
    "success": true,
    "data": {
      "notificacionId": "string",
      "estado": "string",
      ...
    },
    "metadata": {...}
  }
  ```

### Consultar Estado de Notificación
- **Método:** GET
- **Ruta:** /api/v1/notificaciones/MsAdaptadorNotificaciones/{notificacionId}/estado
- **Path Params:** notificacionId (UUID)
- **Query Params:** incluirDetalles (boolean), incluirContenido (boolean)
- **Response:** 200 OK
  ```json
  {
    "success": true,
    "data": {
      "notificacionId": "string",
      "estado": "string",
      "estadoDetallado": {...},
      ...
    },
    "metadata": {...}
  }
  ```

### Consultar Historial de Notificaciones
- **Método:** GET
- **Ruta:** /api/v1/notificaciones/MsAdaptadorNotificaciones/historial
- **Query Params:** dni, fechaInicio, fechaFin, canal, estado, plantillaId, sistemaOrigen, oficinaOrigen, page, pageSize, orderBy, orderDir
- **Response:** 200 OK
  ```json
  {
    "success": true,
    "data": {
      "resultados": [...],
      "paginacion": {...}
    },
    "metadata": {...}
  }
  ```

## 🗂️ Entidades del Dominio

### Notificacion
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| notificacionId | UUID | string (UUID) | Identificador único |
| plantillaId | String | string | - |
| destinatarios | List<Destinatario> | Array(Object) | - |
| estado | String | string | - |
| fechaCreacion | LocalDateTime | string (Date ISO 8601) | - |

### Destinatario
| Campo | Tipo Java | Tipo Original PDF | Notas |
|-------|-----------|-------------------|-------|
| dni | String | string | - |
| nombres | String | string | - |
| email | String | string | - |
| telefono | String | string | - |
| whatsapp | String | string | - |

## 📦 Estructura de Paquetes

```
pe/gob/reniec/notificaciones/MsAdaptadorNotificaciones/
├── domain/
│   ├── model/
│   └── ports/ (in, out)
├── application/
│   └── service/
└── infrastructure/
    └── adapters/ (in/rest, out/msdata)
```

## ⚠️ Limitaciones y Consideraciones

1. **Implementaciones stub:** Todos los métodos lanzan `UnsupportedOperationException` o retornan datos dummy.
2. **Sin protocolo de integración:** El adaptador hacia MsData no define HTTP/SOAP/colas real.
3. **Sin validaciones:** No se implementa lógica de validación.
4. **Sin manejo de errores:** No hay try-catch ni gestión de excepciones compleja.

## ⚠️ AMBIGÜEDADES DETECTADAS

- **MsData:** El PDF no especifica explícitamente un microservicio "MsData" para persistencia, pero como "MsDominio" se asume que delega la persistencia. Se creó `NotificacionDataPort`.
- **Tipos de datos:** Algunos tipos como `Map<String, String>` para `parametros` se asumieron dado que el PDF muestra un objeto JSON genérico.

## 📝 Notas de Generación

- **Fecha de generación:** 2025-12-05
- **Versión del prompt:** 3.0
- **Fuente:** p_Microservicio MsAdaptadorNotificaciones V1.2.pdf
