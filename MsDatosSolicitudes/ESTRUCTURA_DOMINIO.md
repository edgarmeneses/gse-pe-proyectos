# Estructura del Modelo de Dominio - MsDatosSolicitudes

```
src/main/java/pe/gob/pj/solicitudes/data/
│
├── domain/                                    ← CAPA DE DOMINIO (Core Business)
│   ├── model/                                 ← Entidades y Value Objects
│   │   ├── [AGGREGATE ROOTS]
│   │   │   ├── Solicitud.java                ✅ Aggregate Root principal
│   │   │   ├── Diligencia.java               ✅ Aggregate Root
│   │   │   └── Trazabilidad.java             ✅ Aggregate Root (refactorizado)
│   │   │
│   │   ├── [ENTITIES]
│   │   │   └── Evento.java                   ✅ Entity dentro de Trazabilidad
│   │   │
│   │   └── [VALUE OBJECTS]
│   │       ├── Solicitante.java              ✅ Información del solicitante
│   │       ├── Direccion.java                ✅ Dirección postal
│   │       ├── Pago.java                     ✅ Información de pago
│   │       ├── DocumentoAdjunto.java         ✅ Documento adjunto
│   │       ├── RequisitoCumplido.java        ✅ Requisito completado
│   │       ├── DatosEspecificosTramite.java  ✅ Datos específicos
│   │       ├── DocumentoRequerido.java       ✅ Documento requerido
│   │       ├── DocumentoGenerado.java        ✅ Documento generado
│   │       ├── DatosContactoEntidad.java     ✅ Contacto de entidad
│   │       ├── OficinaRegistro.java          ✅ Oficina de registro
│   │       ├── OficinaResponsable.java       ✅ Oficina responsable
│   │       ├── Usuario.java                  ✅ Usuario del sistema
│   │       └── Oficina.java                  ✅ Información de oficina
│   │
│   └── ports/                                 ← Interfaces (contratos)
│       ├── in/                                ← Puertos de entrada (Use Cases)
│       │   ├── CrearSolicitudUseCase.java    ✅ Retorna Solicitud
│       │   ├── ListarSolicitudesUseCase.java ✅ Retorna SolicitudQueryResult
│       │   ├── ConsultarSolicitudUseCase.java ✅ Retorna Solicitud
│       │   ├── ActualizarSolicitudUseCase.java ✅ Retorna Solicitud
│       │   ├── ConsultarSolicitudesPendientesOfflineUseCase.java
│       │   ├── CrearDiligenciaUseCase.java   ✅ Retorna Diligencia
│       │   ├── VerificarDuplicadosUseCase.java ✅ Retorna Boolean
│       │   └── VerTrazabilidadUseCase.java   ✅ Retorna TrazabilidadQueryResult
│       │
│       └── out/                               ← Puertos de salida (Repository Ports)
│           ├── SolicitudRepositoryPort.java  ✅ Actualizado
│           ├── DiligenciaRepositoryPort.java
│           └── TrazabilidadRepositoryPort.java ✅ Actualizado
│
├── application/                               ← CAPA DE APLICACIÓN
│   ├── service/                               ← Servicios de aplicación
│   │   ├── CrearSolicitudService.java
│   │   ├── ListarSolicitudesService.java     ✅ Actualizado
│   │   ├── ConsultarSolicitudService.java
│   │   ├── ActualizarSolicitudService.java
│   │   ├── ConsultarSolicitudesPendientesOfflineService.java
│   │   ├── CrearDiligenciaService.java
│   │   ├── VerificarDuplicadosService.java
│   │   └── VerTrazabilidadService.java       ✅ Actualizado
│   │
│   └── query/                                 ← Query Results (NUEVO)
│       ├── SolicitudQueryResult.java         ✅ Nuevo - Wrapper con paginación
│       └── TrazabilidadQueryResult.java      ✅ Nuevo - Wrapper con estadísticas
│
└── infrastructure/                            ← CAPA DE INFRAESTRUCTURA
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       ├── dto/                       ← DTOs para API REST
        │       │   ├── SolicitudRequestDto.java
        │       │   ├── SolicitudResponseDto.java
        │       │   ├── PaginacionDto.java    ✅ Ya existe (no en dominio)
        │       │   ├── EstadisticasDto.java  ✅ Ya existe (no en dominio)
        │       │   └── ResumenEventosDto.java ✅ Ya existe (no en dominio)
        │       └── mapper/                    ← Mappers DTO ↔ Domain
        │
        └── out/
            └── persistence/                   ← Adaptador de persistencia
                ├── entity/                    ← Entidades JPA/MongoDB
                ├── mapper/                    ← Mappers Domain ↔ Entity
                └── *RepositoryAdapter.java    ← Implementación de Repository Ports
```

---

## 🔄 Flujo de Datos (Ejemplo: Listar Solicitudes)

```
[REST Controller]
       ↓
[SolicitudRequestDto] ──────────────────────────────────────┐
       ↓                                                      │
[Mapper: DTO → Domain]                                       │
       ↓                                                      │
[ListarSolicitudesUseCase] (Puerto de entrada)               │
       ↓                                                      │
[ListarSolicitudesService] (Servicio de aplicación)          │
       ↓                                                      │
[SolicitudRepositoryPort] (Puerto de salida)                 │ HEXAGONAL
       ↓                                                      │ ARCHITECTURE
[SolicitudRepositoryAdapter] (Adaptador de persistencia)     │
       ↓                                                      │
[Base de Datos / MongoDB]                                    │
       ↓                                                      │
[List<SolicitudEntity>] ─→ [Mapper: Entity → Domain]         │
       ↓                                                      │
[SolicitudQueryResult] ← contiene List<Solicitud> + metadata │
       ↓                                                      │
[Mapper: QueryResult → ResponseDto] ←────────────────────────┘
       ↓
[SolicitudResponseDto + PaginacionDto]
       ↓
[JSON Response]
```

---

## ✅ Ventajas de la Nueva Estructura

### 1. **Separación de Responsabilidades**
- **Dominio**: Solo conceptos de negocio
- **Aplicación**: Coordinación y transformación
- **Infraestructura**: Detalles técnicos (DB, REST, etc.)

### 2. **Testabilidad**
- Dominio testeable sin dependencias
- Puertos permiten usar mocks/stubs
- Lógica de negocio aislada

### 3. **Mantenibilidad**
- Cambios en API no afectan el dominio
- Cambios en BD no afectan la lógica de negocio
- Fácil identificar dónde hacer cambios

### 4. **Reutilización**
- Dominio puede usarse en múltiples adaptadores
- Use cases reutilizables
- Lógica de negocio centralizada

### 5. **Cumplimiento con DDD**
- Aggregates con invariantes claras
- Value Objects inmutables
- Lenguaje ubicuo (Ubiquitous Language)

---

## 🎯 Comparación: Antes vs Después

| Aspecto | ❌ Antes | ✅ Después |
|---------|---------|-----------|
| **Paginacion** | En `domain/model` | En DTOs (infraestructura) |
| **Estadisticas** | En `domain/model` | En `TrazabilidadQueryResult` (aplicación) |
| **ResumenEventos** | En `domain/model` | En `TrazabilidadQueryResult` (aplicación) |
| **SiguientePaso** | En `domain/model` | En DTOs (infraestructura) |
| **Solicitud** | Con campos de UI | Solo datos de negocio + métodos de dominio |
| **Diligencia** | Con campos calculados | Solo datos de negocio + métodos de dominio |
| **Trazabilidad** | Con metadata mixta | Solo eventos + métodos de negocio |
| **Use Cases** | Retornan listas simples | Retornan Query Results con metadata |

---

## 📚 Patrones Aplicados

1. ✅ **Hexagonal Architecture** (Ports & Adapters)
2. ✅ **Domain-Driven Design** (Aggregates, Entities, Value Objects)
3. ✅ **CQRS** (separación implícita con Query Results)
4. ✅ **Repository Pattern** (abstracción de persistencia)
5. ✅ **Dependency Inversion** (puertos en lugar de implementaciones)
6. ✅ **Single Responsibility** (cada clase tiene una razón para cambiar)
