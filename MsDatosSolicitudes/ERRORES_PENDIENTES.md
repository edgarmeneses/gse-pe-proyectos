# 🔧 Errores Pendientes de Corrección - Adaptadores de Infraestructura

## ⚠️ Estado Actual

El **modelo de dominio está completamente refactorizado y sin errores**. Los errores restantes están en la **capa de infraestructura (adaptadores)** que necesitan actualizarse para trabajar con el nuevo modelo.

---

## 📋 Errores por Archivo

### 1. **SolicitudController.java** ✏️

**Ubicación**: `infrastructure/adapters/in/rest/controller/`

#### Error 1 - Línea 63
```java
// ❌ ANTES
List<Solicitud> solicitudes = listarSolicitudesUseCase.ejecutar(...);

// ✅ CORREGIR A
SolicitudQueryResult result = listarSolicitudesUseCase.ejecutar(...);
List<Solicitud> solicitudes = result.getSolicitudes();
```

#### Error 2 - Línea 110
```java
// ❌ ANTES
Trazabilidad trazabilidad = verTrazabilidadUseCase.ejecutar(...);

// ✅ CORREGIR A
TrazabilidadQueryResult result = verTrazabilidadUseCase.ejecutar(...);
Trazabilidad trazabilidad = result.getTrazabilidad();
```

---

### 2. **SolicitudDtoMapper.java** ✏️

**Ubicación**: `infrastructure/adapters/in/rest/mapper/`

#### Errores - Campos eliminados del dominio

Los siguientes campos ya no existen en `Solicitud` y deben **calcularse en el mapper**:

```java
// ❌ Campos eliminados del dominio:
- solicitud.getSiguientesPasos()  → Calcular en mapper basado en estado
- solicitud.getUrlSeguimiento()    → Generar URL: "/api/v1/solicitudes/{id}/seguimiento"
- solicitud.getCodigoQR()          → Generar QR code basado en URL
- solicitud.getDiasTranscurridos() → Calcular: now - fechaRegistro
- solicitud.getDiasRestantes()     → Calcular: fechaVencimiento - now

// ✅ CORREGIR A:
private SolicitudResponseDto toResponseDto(Solicitud solicitud) {
    return new SolicitudResponseDto(
        // ... campos existentes ...
        calcularSiguientesPasos(solicitud),  // Método helper
        generarUrlSeguimiento(solicitud.getSolicitudId()),
        generarCodigoQR(solicitud.getSolicitudId()),
        calcularDiasTranscurridos(solicitud.getFechaRegistro()),
        calcularDiasRestantes(solicitud.getFechaVencimiento()),
        // ... resto de campos ...
    );
}

// Métodos helpers
private List<SiguientePasoDto> calcularSiguientesPasos(Solicitud solicitud) {
    // Lógica según el estado de la solicitud
    return switch(solicitud.getEstado()) {
        case "PENDIENTE" -> List.of(new SiguientePasoDto("Revisar requisitos"));
        case "EN_PROCESO" -> List.of(new SiguientePasoDto("Esperar aprobación"));
        // etc...
    };
}

private String generarUrlSeguimiento(String solicitudId) {
    return "/api/v1/solicitudes/" + solicitudId + "/seguimiento";
}

private String generarCodigoQR(String solicitudId) {
    // Generar QR code basado en URL de seguimiento
    return QRCodeGenerator.generate(generarUrlSeguimiento(solicitudId));
}

private Long calcularDiasTranscurridos(LocalDateTime fechaRegistro) {
    if (fechaRegistro == null) return 0L;
    return ChronoUnit.DAYS.between(fechaRegistro, LocalDateTime.now());
}

private Long calcularDiasRestantes(LocalDateTime fechaVencimiento) {
    if (fechaVencimiento == null) return null;
    long dias = ChronoUnit.DAYS.between(LocalDateTime.now(), fechaVencimiento);
    return dias < 0 ? 0 : dias;
}
```

---

### 3. **DiligenciaDtoMapper.java** ✏️

**Ubicación**: `infrastructure/adapters/in/rest/mapper/`

#### Errores - Campos eliminados del dominio

```java
// ❌ Campos eliminados:
- diligencia.setOficinaResponsableSeguimiento()  → Ya no existe (usar oficinaResponsable)
- diligencia.getDiasTranscurridos()              → Calcular en mapper
- diligencia.getDiasRestantes()                  → Calcular en mapper
- diligencia.getSeguimiento()                    → Ya no existe (eliminar del DTO)
- diligencia.getEventosPublicados()              → Ya no existe (eliminar del DTO)

// ✅ CORREGIR A:
private DiligenciaResponseDto toResponseDto(Diligencia diligencia) {
    return new DiligenciaResponseDto(
        // ... campos existentes ...
        calcularDiasTranscurridos(diligencia.getFechaCreacion()),
        calcularDiasRestantes(diligencia.getFechaVencimiento()),
        // Remover seguimiento y eventosPublicados del DTO
        // ... resto de campos ...
    );
}

// Del método toDomain, remover:
diligencia.setOficinaResponsableSeguimiento(...)  // ← Eliminar esta línea
```

---

### 4. **TrazabilidadDtoMapper.java** ✏️

**Ubicación**: `infrastructure/adapters/in/rest/mapper/`

#### Errores - Usar TrazabilidadQueryResult

```java
// ❌ ANTES - Obteniendo datos del dominio:
toResumenEventosDto(trazabilidad.getResumenEventos())  // Ya no existe
toEstadisticasDto(trazabilidad.getEstadisticas())      // Ya no existe
toPaginacionDto(trazabilidad.getPaginacion())          // Ya no existe

// ✅ CORREGIR A - Obtener de TrazabilidadQueryResult:
public TrazabilidadResponseDto toResponseDto(TrazabilidadQueryResult result) {
    Trazabilidad trazabilidad = result.getTrazabilidad();
    
    return new TrazabilidadResponseDto(
        // Datos del dominio
        trazabilidad.getSolicitudId(),
        trazabilidad.getNumeroSolicitud(),
        trazabilidad.getTipoTramite(),
        trazabilidad.getEstadoActual(),
        trazabilidad.getFechaCreacion(),
        trazabilidad.getFechaUltimaModificacion(),
        trazabilidad.getTotalEventos(),  // Método calculado en dominio
        trazabilidad.getEventos().stream()
            .map(this::toEventoDto)
            .toList(),
        
        // Metadata del QueryResult
        toResumenEventosDto(result),     // ← Cambiar: ahora del result
        toEstadisticasDto(result),       // ← Cambiar: ahora del result
        toPaginacionDto(result)          // ← Cambiar: ahora del result
    );
}

// Actualizar métodos:
private ResumenEventosDto toResumenEventosDto(TrazabilidadQueryResult result) {
    return new ResumenEventosDto(
        result.getTotalCambiosEstado(),
        result.getTotalModificaciones(),
        result.getTotalAsignaciones(),
        result.getTotalDiligencias(),
        result.getTotalValidaciones(),
        result.getTotalComentarios(),
        result.getTotalNotificaciones()
    );
}

private EstadisticasDto toEstadisticasDto(TrazabilidadQueryResult result) {
    return new EstadisticasDto(
        result.getTiempoTotalProceso(),
        result.getTiempoPorEtapa(),
        result.getUsuariosInvolucrados(),
        result.getOficinasProceso()
    );
}

private PaginacionDto toPaginacionDto(TrazabilidadQueryResult result) {
    return new PaginacionDto(
        result.getTotalRegistros(),
        result.getTotalPaginas(),
        result.getPaginaActual(),
        result.getRegistrosPorPagina(),
        result.getTieneAnterior(),
        result.getTieneSiguiente()
    );
}
```

---

### 5. **SolicitudRepositoryAdapter.java** ✏️

**Ubicación**: `infrastructure/adapters/out/persistence/`

#### Error - Tipo de retorno incorrecto

```java
// ❌ ANTES
@Override
public List<Solicitud> listar(String estado, String tipoTramite, ...) {
    // ... lógica ...
    return solicitudes;
}

// ✅ CORREGIR A
@Override
public SolicitudQueryResult listar(String estado, String tipoTramite, 
                                     String codigoOficina, String dniSolicitante,
                                     String usuarioAsignado, String fechaDesde, 
                                     String fechaHasta, String prioridad,
                                     Boolean soloVencidas, Long page, Long size, 
                                     String sort, String direction) {
    
    // Consultar entidades con paginación
    Page<SolicitudEntity> pageResult = repository.findAll(
        buildSpecification(...), 
        PageRequest.of(page.intValue(), size.intValue(), Sort.by(...))
    );
    
    // Mapear entidades a dominio
    List<Solicitud> solicitudes = pageResult.getContent().stream()
        .map(mapper::toDomain)
        .toList();
    
    // Construir SolicitudQueryResult con metadata
    return new SolicitudQueryResult(
        solicitudes,
        pageResult.getTotalElements(),
        pageResult.getTotalPages(),
        page,
        size,
        pageResult.hasPrevious(),
        pageResult.hasNext()
    );
}
```

---

### 6. **SolicitudPersistenceMapper.java** ✏️

**Ubicación**: `infrastructure/adapters/out/persistence/mapper/`

#### Errores - Campos eliminados del dominio

```java
// ❌ Campos que ya no existen en dominio:
entity.setUrlSeguimiento(solicitud.getUrlSeguimiento());  // Ya no existe
entity.setCodigoQR(solicitud.getCodigoQR());              // Ya no existe

// ✅ OPCIONES:

// Opción 1: Eliminar del entity (recomendado - no se persisten)
// Estos campos se calculan en tiempo real en el mapper de DTOs

// Opción 2: Mantener en entity pero no mapear desde dominio
// Dejar como null o calcular al persistir
entity.setUrlSeguimiento(null);  // Se genera en presentación
entity.setCodigoQR(null);        // Se genera en presentación

// Al mapear de entity a domain, ignorar estos campos
```

---

## 📊 Resumen de Correcciones Necesarias

| Archivo | Tipo de Error | Complejidad | Prioridad |
|---------|---------------|-------------|-----------|
| SolicitudController | Tipo de retorno | ⭐ Fácil | 🔴 Alta |
| SolicitudDtoMapper | Cálculo de campos | ⭐⭐⭐ Media | 🔴 Alta |
| DiligenciaDtoMapper | Campos eliminados | ⭐⭐ Fácil-Media | 🟡 Media |
| TrazabilidadDtoMapper | Usar QueryResult | ⭐⭐ Fácil-Media | 🔴 Alta |
| SolicitudRepositoryAdapter | QueryResult | ⭐⭐⭐ Media | 🔴 Alta |
| SolicitudPersistenceMapper | Campos eliminados | ⭐ Fácil | 🟡 Media |

---

## ✅ Checklist de Corrección

- [ ] Actualizar **SolicitudController** para usar `SolicitudQueryResult` y `TrazabilidadQueryResult`
- [ ] Actualizar **SolicitudDtoMapper** con métodos de cálculo de campos de presentación
- [ ] Actualizar **DiligenciaDtoMapper** para campos eliminados
- [ ] Actualizar **TrazabilidadDtoMapper** para usar `TrazabilidadQueryResult`
- [ ] Actualizar **SolicitudRepositoryAdapter** para retornar `SolicitudQueryResult`
- [ ] Actualizar **SolicitudPersistenceMapper** eliminando campos inexistentes
- [ ] Compilar y verificar que no haya errores
- [ ] Ejecutar tests (si existen)

---

## 🎯 Próximo Paso

Empezar por los controladores y mappers de DTOs, ya que son los más críticos y tienen impacto directo en la API REST.

**Orden recomendado**:
1. Controllers (cambios simples de tipos)
2. Repository Adapters (retornar QueryResults)
3. DTO Mappers (agregar lógica de cálculo)
4. Persistence Mappers (eliminar campos)
