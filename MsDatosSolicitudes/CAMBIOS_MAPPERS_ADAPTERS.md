# Cambios en Mappers y Adapters

## Resumen
Se completó la refactorización de los mappers y adapters para alinearlos con el modelo de dominio limpio y el uso de Query Results.

## Archivos Modificados

### 1. TrazabilidadDtoMapper
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/in/rest/mapper/TrazabilidadDtoMapper.java`

**Cambios**:
- ✅ Actualizado `toResponseDto()` para recibir `TrazabilidadQueryResult` en lugar de `Trazabilidad`
- ✅ Actualizado `toResumenEventosDto()` para extraer datos de `TrazabilidadQueryResult`
- ✅ Actualizado `toEstadisticasDto()` para extraer datos de `TrazabilidadQueryResult`
- ✅ Actualizado `toPaginacionDto()` para extraer datos de `TrazabilidadQueryResult`

**Justificación**: El mapper ahora procesa el Query Result completo con todas las estadísticas y metadata de paginación, en lugar de intentar extraerlas del dominio.

---

### 2. DiligenciaDtoMapper
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/in/rest/mapper/DiligenciaDtoMapper.java`

**Cambios**:
- ✅ Removido `oficinaResponsableSeguimiento` del método `toDomain()`
- ✅ Actualizado `toResponseDto()` para calcular `diasTranscurridos` y `diasRestantes` en lugar de obtenerlos del dominio
- ✅ Removidos parámetros `seguimiento` y `eventosPublicados` del DTO de respuesta
- ✅ Agregado método `calcularDiasTranscurridos()` usando `ChronoUnit.DAYS.between()`
- ✅ Agregado método `calcularDiasRestantes()` con lógica para retornar 0 si la fecha ya pasó
- ✅ Eliminado método `toSeguimientoDto()` ya que ese concepto no existe en dominio

**Justificación**: Los campos calculados no pertenecen al dominio. Se calculan en el mapper cuando se crea el DTO de respuesta.

---

### 3. DiligenciaResponseDto
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/in/rest/dto/DiligenciaResponseDto.java`

**Cambios**:
- ✅ Cambiado tipo de `diasTranscurridos` y `diasRestantes` de `Long` a `Integer`
- ✅ Removidos campos `seguimiento` y `eventosPublicados`

**Justificación**: Alineación con el resto de la aplicación (SolicitudResponseDto también usa Integer) y eliminación de conceptos que no pertenecen al dominio.

---

### 4. SolicitudDtoMapper
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/in/rest/mapper/SolicitudDtoMapper.java`

**Cambios**:
- ✅ Corregido `toOficinaRegistroDto()` - removida referencia a `getDireccion()` inexistente
- ✅ Corregido `toDireccionDto()` - uso de `getDireccionCompleta()` en lugar de `getDireccion()`
- ✅ Corregido `toRequisitoCumplidoDto()` - uso de `getNombreRequisito()` y `getCumple()` con parámetro `requisitoId`
- ✅ Corregido `toDatosEspecificosTramiteDto()` - mapeo de todos los campos correctos del dominio incluyendo lista de documentos adjuntos

**Justificación**: Alineación con los getters reales de las clases de dominio.

---

### 5. SolicitudPersistenceMapper
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/out/persistence/mapper/SolicitudPersistenceMapper.java`

**Cambios**:
- ✅ Removidas líneas que intentaban mapear `urlSeguimiento`, `codigoQR`, `diasTranscurridos`, `diasRestantes` en `toEntity()`
- ✅ Removidas líneas que intentaban setear esos mismos campos en `toDomain()`

**Justificación**: Estos campos ya no existen en la clase `Solicitud` del dominio porque son campos calculados de presentación.

---

### 6. SolicitudRepositoryAdapter
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/out/persistence/SolicitudRepositoryAdapter.java`

**Cambios**:
- ✅ Agregado import de `SolicitudQueryResult`
- ✅ Cambiado tipo de retorno del método `listar()` de `List<Solicitud>` a `SolicitudQueryResult`

**Justificación**: El repository port ahora retorna Query Results que incluyen la paginación y metadata.

---

### 7. TrazabilidadRepositoryAdapter
**Ubicación**: `src/main/java/pe/gob/pj/solicitudes/data/infrastructure/adapters/out/persistence/TrazabilidadRepositoryAdapter.java`

**Cambios**:
- ✅ Cambiado import de `Trazabilidad` por `TrazabilidadQueryResult`
- ✅ Cambiado tipo de retorno del método `buscarPorSolicitudId()` de `Trazabilidad` a `TrazabilidadQueryResult`

**Justificación**: El repository port ahora retorna Query Results que incluyen estadísticas y paginación.

---

## Estado de Compilación

✅ **Sin errores de compilación**

Todos los errores han sido resueltos:
- ✅ DiligenciaDtoMapper: Constructor fix + cálculo de días
- ✅ TrazabilidadDtoMapper: Uso de getters en lugar de records
- ✅ SolicitudDtoMapper: Corrección de nombres de métodos del dominio
- ✅ SolicitudPersistenceMapper: Eliminación de campos inexistentes
- ✅ Repository Adapters: Tipos de retorno actualizados

---

## Próximos Pasos (Implementación Futura)

Los repository adapters actualmente lanzan `UnsupportedOperationException` porque no tienen una tecnología de persistencia configurada. Cuando se implemente la persistencia real (por ejemplo, con Spring Data JPA):

1. **SolicitudRepositoryAdapter.listar()** deberá:
   - Ejecutar query con filtros
   - Construir `SolicitudQueryResult` con:
     - Lista de `Solicitud` del dominio
     - Metadata de paginación (page, size, totalElements, totalPages, first, last)

2. **TrazabilidadRepositoryAdapter.buscarPorSolicitudId()** deberá:
   - Buscar la trazabilidad
   - Calcular estadísticas (totales por tipo de evento, tiempos, etc.)
   - Construir `TrazabilidadQueryResult` con:
     - Objeto `Trazabilidad` del dominio
     - Estadísticas calculadas
     - Metadata de paginación de eventos

---

## Validación

Para validar que todo funciona correctamente:

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar tests (cuando estén implementados)
mvn test
```

---

## Impacto en Arquitectura

### Separación de Responsabilidades
- **Dominio**: Solo contiene lógica de negocio, sin campos calculados o de presentación
- **Application (Query Results)**: Contiene metadata y estadísticas de consultas
- **Infrastructure (Mappers)**: Realiza cálculos para presentación (días transcurridos, URLs, etc.)

### Flujo de Datos

```
Repository → Query Result → Service → Controller → Mapper → DTO → API Response
   (DB)      (+ metadata)   (orquesta) (orquesta)  (calcula)  (record)  (JSON)
```

---

## Notas Técnicas

- Los campos `diasTranscurridos` y `diasRestantes` se calculan usando `ChronoUnit.DAYS.between()`
- Los cálculos de días retornan 0 si el resultado es negativo (fecha ya pasada)
- Los mappers usan `LocalDateTime.now()` para calcular días actuales
- Los DTOs son records inmutables para garantizar thread-safety

---

**Fecha**: 3 de diciembre, 2024
**Estado**: ✅ Completado
