# 📝 Estructura de DTOs y Respuestas API

## 🎯 Arquitectura de Respuestas

### Wrapper Genérico: `ApiResponse<T>`

Todas las respuestas de la API siguen este formato estándar:

```json
{
  "success": boolean,
  "data": T,           // Puede ser un objeto o array
  "pagination": {...}, // Opcional: solo para listados
  "error": {...}       // Opcional: solo para errores
}
```

---

## 📋 Respuestas de Solicitudes

### 1. **Listar Solicitudes** - `GET /api/v1/solicitudes`

**Respuesta**: `ApiResponse<List<SolicitudResponseDto>>`

```json
{
  "success": true,
  "data": [
    {
      "solicitudId": "SOL-2025-001",
      "numeroSolicitud": "2025-001",
      "estado": "PENDIENTE",
      "tipoTramite": "CERTIFICADO",
      "subTipoTramite": "ANTECEDENTES",
      "dniSolicitante": "12345678",
      "nombresSolicitante": "Juan Pérez García",
      "fechaRegistro": "2025-12-02T10:30:00Z",
      "fechaVencimiento": "2025-12-10T17:00:00Z",
      "prioridad": "NORMAL",
      "usuarioAsignado": "USR001",
      "oficinaRegistro": "OF-LIMA-01",
      "diasTranscurridos": 1,
      "diasRestantes": 8
    }
  ],
  "pagination": {
    "page": 0,
    "size": 20,
    "totalElements": 150,
    "totalPages": 8,
    "first": true,
    "last": false
  },
  "error": null
}
```

**DTO Usado**: `SolicitudResponseDto` (simplificado para listados)
- Campos básicos y esenciales
- `diasTranscurridos` y `diasRestantes` se calculan en el mapper

---

### 2. **Consultar Solicitud Individual** - `GET /api/v1/solicitudes/{id}`

**Respuesta**: `ApiResponse<SolicitudDetalleDto>`

```json
{
  "success": true,
  "data": {
    "solicitudId": "SOL-2025-001",
    "numeroSolicitud": "2025-001",
    "estado": "PENDIENTE",
    "tipoTramite": "CERTIFICADO",
    "subTipoTramite": "ANTECEDENTES",
    "prioridad": "NORMAL",
    "tipoSolicitante": "PERSONA_NATURAL",
    "solicitante": {
      "dni": "12345678",
      "nombres": "Juan",
      "apellidoPaterno": "Pérez",
      "apellidoMaterno": "García",
      "email": "juan.perez@email.com",
      "telefono": "+51999888777",
      "direccion": {
        "departamento": "Lima",
        "provincia": "Lima",
        "distrito": "Miraflores",
        "direccion": "Av. Larco 1234"
      }
    },
    "requisitosCumplidos": [
      {
        "requisito": "DNI vigente",
        "cumplido": true,
        "observacion": null
      }
    ],
    "documentosAdjuntos": [
      {
        "tipo": "DNI",
        "nombre": "dni-escaneado.pdf",
        "tamanioBytes": 245678,
        "mimeType": "application/pdf",
        "checksum": "abc123..."
      }
    ],
    "pago": {
      "montoPagado": 35.50,
      "metodoPago": "TARJETA",
      "referenciaPago": "PAY-2025-001",
      "fechaPago": "2025-12-02T10:25:00Z"
    },
    "observaciones": "Solicitud regular sin observaciones",
    "fechaRegistro": "2025-12-02T10:30:00Z",
    "fechaVencimiento": "2025-12-10T17:00:00Z",
    "usuarioRegistro": "USR002",
    "usuarioAsignado": "USR001",
    "oficinaRegistro": {
      "codigo": "OF-LIMA-01",
      "nombre": "Oficina Lima Centro",
      "direccion": "Av. Abancay 123"
    },
    "tiempoEstimadoResolucion": 8,
    "requiereDiligencia": false,
    "diasTranscurridos": 1,
    "diasRestantes": 8,
    "urlSeguimiento": "/api/v1/solicitudes/SOL-2025-001/seguimiento",
    "siguientesPasos": [
      {
        "paso": "Esperar revisión de requisitos"
      },
      {
        "paso": "Aprobación por responsable"
      }
    ]
  },
  "pagination": null,
  "error": null
}
```

**DTO Usado**: `SolicitudDetalleDto` (completo con toda la información)
- Incluye información completa del solicitante
- Requisitos y documentos
- Campos calculados (días, URL, siguientes pasos)

---

### 3. **Crear Solicitud** - `POST /api/v1/solicitudes`

**Request**: `SolicitudRequestDto`

**Respuesta**: `ApiResponse<SolicitudDetalleDto>`

```json
{
  "success": true,
  "data": {
    "solicitudId": "SOL-2025-002",
    "numeroSolicitud": "2025-002",
    // ... resto de campos de SolicitudDetalleDto
  },
  "pagination": null,
  "error": null
}
```

---

### 4. **Error en la Respuesta**

**Ejemplo**: `GET /api/v1/solicitudes/INVALID-ID`

```json
{
  "success": false,
  "data": null,
  "pagination": null,
  "error": {
    "code": "NOT_FOUND",
    "message": "Solicitud con ID 'INVALID-ID' no encontrada"
  }
}
```

---

## 🔄 Flujo de Transformación

### Para Listados (con paginación)

```
[Controller]
    ↓
SolicitudQueryResult (application layer)
    |-- List<Solicitud> (domain)
    |-- Paginacion metadata
    ↓
[Mapper]
    |-- Solicitud → SolicitudResponseDto (calcular diasTranscurridos, diasRestantes)
    |-- QueryResult pagination → PaginacionDto
    ↓
ApiResponse<List<SolicitudResponseDto>>
    |-- success: true
    |-- data: List<SolicitudResponseDto>
    |-- pagination: PaginacionDto
    ↓
[JSON Response]
```

### Para Consulta Individual (sin paginación)

```
[Controller]
    ↓
Solicitud (domain)
    ↓
[Mapper]
    |-- Solicitud → SolicitudDetalleDto
    |-- Calcular campos de presentación:
    |   |-- diasTranscurridos
    |   |-- diasRestantes
    |   |-- urlSeguimiento
    |   |-- siguientesPasos (basado en estado)
    ↓
ApiResponse<SolicitudDetalleDto>
    |-- success: true
    |-- data: SolicitudDetalleDto
    |-- pagination: null
    ↓
[JSON Response]
```

---

## 📊 DTOs Disponibles

### Respuestas

1. **`ApiResponse<T>`** - Wrapper genérico (todas las respuestas)
2. **`SolicitudResponseDto`** - Solicitud simplificada (listados)
3. **`SolicitudDetalleDto`** - Solicitud completa (consulta individual)
4. **`PaginacionDto`** - Metadata de paginación (formato estándar API)

### Componentes

- `SolicitanteDto`
- `DireccionDto`
- `RequisitoCumplidoDto`
- `DocumentoAdjuntoDto`
- `PagoDto`
- `OficinaRegistroDto`
- `SiguientePasoDto`

---

## ✅ Ventajas de esta Estructura

1. **Consistencia**: Todas las respuestas siguen el mismo formato
2. **Claridad**: Fácil distinguir entre éxito y error
3. **Flexibilidad**: `ApiResponse<T>` funciona para cualquier tipo de dato
4. **Estándar**: Sigue convenciones REST modernas
5. **Paginación Uniforme**: Mismo formato para todas las respuestas paginadas
6. **Separación**: DTOs simples para listados, detallados para consultas individuales

---

## 🎯 Ejemplo de Uso en Controller

```java
@GetMapping
public ApiResponse<List<SolicitudResponseDto>> listarSolicitudes(
        @RequestParam(required = false) String estado,
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "20") Integer size) {
    
    // Obtener query result desde use case
    SolicitudQueryResult result = listarSolicitudesUseCase.ejecutar(
        estado, null, null, null, null, null, null, null, null, 
        page.longValue(), size.longValue(), "fechaRegistro", "desc"
    );
    
    // Mapear a DTOs
    List<SolicitudResponseDto> solicitudesDto = result.getSolicitudes().stream()
        .map(solicitudMapper::toResponseDto)  // Calcular campos aquí
        .toList();
    
    PaginacionDto paginacion = new PaginacionDto(
        result.getPage(),
        result.getSize(),
        result.getTotalElements(),
        result.getTotalPages(),
        result.getFirst(),
        result.getLast()
    );
    
    // Retornar wrapped response
    return ApiResponse.success(solicitudesDto, paginacion);
}

@GetMapping("/{id}")
public ApiResponse<SolicitudDetalleDto> consultarSolicitud(@PathVariable String id) {
    Solicitud solicitud = consultarSolicitudUseCase.ejecutar(id);
    
    if (solicitud == null) {
        return ApiResponse.error("NOT_FOUND", "Solicitud no encontrada");
    }
    
    SolicitudDetalleDto detalleDto = solicitudMapper.toDetalleDto(solicitud);
    return ApiResponse.success(detalleDto);
}
```
