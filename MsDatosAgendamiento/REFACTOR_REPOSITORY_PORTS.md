# Refactorización de Repository Ports (Puertos de Salida)

## Resumen de Cambios

Se han refactorizado los **Repository Ports** siguiendo el principio de **diseño minimalista** en Arquitectura Hexagonal: **solo incluir las operaciones que realmente se necesitan** según los endpoints documentados en el PDF.

---

## Problemas Identificados

### ❌ Métodos Innecesarios Eliminados

1. **`eliminar()` en todos los repositorios**
   - **Razón:** No existe ningún endpoint DELETE en el PDF
   - Las citas se **cancelan** (cambio de estado), no se eliminan
   - El historial y excepciones no se eliminan por razones de auditoría
   - Las disponibilidades se **desactivan**, no se eliminan

2. **`contarTotal()` en CitaRepositoryPort**
   - **Razón:** `Paginacion` fue eliminada del modelo de dominio
   - La paginación es responsabilidad de la capa de infraestructura (DTOs)
   - El dominio no debe conocer conceptos de paginación

3. **Parámetros de paginación en `listar()`**
   - **Razón:** `page`, `size`, `sort`, `direction` son concerns de infraestructura
   - El dominio retorna listas completas
   - La capa de presentación aplica paginación sobre los resultados

4. **`buscarPorId()` y `listarPorSede()` en ExcepcionHorariaRepositoryPort**
   - **Razón:** No existen endpoints GET para excepciones en el PDF
   - Solo se registran (POST), no se consultan individualmente

5. **`HistorialCitaRepositoryPort` completo**
   - **Razón:** Historial no es un Aggregate Root independiente
   - Es parte del Aggregate de Cita
   - Se consulta como parte de `Cita` con parámetro `incluirHistorial`

---

## Estructura Final de Repository Ports

### 1. **CitaRepositoryPort** (Operaciones esenciales de Cita)

```java
public interface CitaRepositoryPort {
    
    // Operaciones CRUD básicas
    Cita guardar(Cita cita);
    Cita actualizar(Cita cita);
    Cita buscarPorId(String citaId);
    
    // Búsquedas específicas de dominio
    List<Cita> buscarPorSolicitud(String idSolicitud);
    List<Cita> buscarPorDni(String dni);
    
    // Listar con filtros (sin paginación)
    List<Cita> listar(String codigoSede, String estado, String dniSolicitante, 
                      String numeroTramite, String idTecnico, 
                      LocalDate fechaDesde, LocalDate fechaHasta);
    
    // Historial (parte del aggregate Cita)
    void guardarHistorial(HistorialCita historialCita);
    List<HistorialCita> buscarHistorialPorCita(String citaId);
}
```

**Justificación de métodos:**
- ✅ `guardar()` → POST /citas (crear cita)
- ✅ `actualizar()` → PUT /citas/{id}, POST /citas/{id}/cancelar
- ✅ `buscarPorId()` → GET /citas?citaId=...
- ✅ `buscarPorSolicitud()` → Validar duplicados por solicitud
- ✅ `buscarPorDni()` → Buscar citas del solicitante
- ✅ `listar()` → GET /citas con filtros múltiples
- ✅ `guardarHistorial()` → Registrar cambios de estado
- ✅ `buscarHistorialPorCita()` → GET /citas?incluirHistorial=true

---

### 2. **DisponibilidadRepositoryPort** (Operaciones de Disponibilidad)

```java
public interface DisponibilidadRepositoryPort {
    
    Disponibilidad guardar(Disponibilidad disponibilidad);
    Disponibilidad actualizar(Disponibilidad disponibilidad);
    Disponibilidad buscarPorId(String idDisponibilidad);
    
    List<Disponibilidad> buscarPorSedeYFecha(String codigoSede, 
                                             LocalDate fechaDesde, 
                                             LocalDate fechaHasta, 
                                             Boolean soloDisponibles);
    
    List<Disponibilidad> guardarLote(List<Disponibilidad> disponibilidades);
}
```

**Justificación de métodos:**
- ✅ `guardar()` → POST /disponibilidad (individual)
- ✅ `actualizar()` → PUT /disponibilidad/{id}
- ✅ `buscarPorId()` → Necesario para actualizar
- ✅ `buscarPorSedeYFecha()` → GET /disponibilidad (consultar)
- ✅ `guardarLote()` → POST /disponibilidad (crear múltiples franjas)

---

### 3. **ExcepcionHorariaRepositoryPort** (Operaciones de Excepciones)

```java
public interface ExcepcionHorariaRepositoryPort {
    
    ExcepcionHoraria guardar(ExcepcionHoraria excepcionHoraria);
    
    List<ExcepcionHoraria> buscarPorSedeYFecha(String codigoSede, LocalDate fecha);
}
```

**Justificación de métodos:**
- ✅ `guardar()` → POST /excepciones (registrar excepción)
- ✅ `buscarPorSedeYFecha()` → Necesario para validar duplicados y afectar citas

**❌ Eliminados:**
- `buscarPorId()` → No hay GET individual en el PDF
- `listarPorSede()` → No hay GET para listar excepciones
- `eliminar()` → No hay DELETE, las excepciones son permanentes para auditoría

---

## Comparación: Antes vs Después

### CitaRepositoryPort

| Antes | Después | Justificación |
|-------|---------|---------------|
| `guardar()` | ✅ `guardar()` | Necesario (POST /citas) |
| `actualizar()` | ✅ `actualizar()` | Necesario (PUT, cancelar) |
| `buscarPorId()` | ✅ `buscarPorId()` | Necesario (GET por ID) |
| `listar(... page, size, sort, direction)` | ✅ `listar(... sin paginación)` | Paginación es de infraestructura |
| `contarTotal()` | ❌ **ELIMINADO** | No hay `Paginacion` en dominio |
| `eliminar()` | ❌ **ELIMINADO** | No hay DELETE, solo cancelar |
| - | ✅ `buscarPorSolicitud()` | **AÑADIDO** para validar duplicados |
| - | ✅ `buscarPorDni()` | **AÑADIDO** para búsquedas de solicitante |
| - | ✅ `guardarHistorial()` | **AÑADIDO** (antes en repo separado) |
| - | ✅ `buscarHistorialPorCita()` | **AÑADIDO** (antes en repo separado) |

### DisponibilidadRepositoryPort

| Antes | Después | Justificación |
|-------|---------|---------------|
| `guardar()` | ✅ `guardar()` | Necesario (POST) |
| `actualizar()` | ✅ `actualizar()` | Necesario (PUT) |
| `buscarPorId()` | ✅ `buscarPorId()` | Necesario para actualizar |
| `listar()` | ✅ `buscarPorSedeYFecha()` | Renombrado para claridad |
| `guardarLote()` | ✅ `guardarLote()` | Necesario (crear múltiples) |
| `eliminar()` | ❌ **ELIMINADO** | No hay DELETE en PDF |

### ExcepcionHorariaRepositoryPort

| Antes | Después | Justificación |
|-------|---------|---------------|
| `guardar()` | ✅ `guardar()` | Necesario (POST) |
| `buscarPorId()` | ❌ **ELIMINADO** | No hay GET individual |
| `listarPorSede()` | ❌ **ELIMINADO** | No hay GET para listar |
| `listarPorSedeYFecha()` | ✅ `buscarPorSedeYFecha()` | Necesario para validar duplicados |
| `eliminar()` | ❌ **ELIMINADO** | No hay DELETE |

### HistorialCitaRepositoryPort

| Antes | Después | Justificación |
|-------|---------|---------------|
| **Repositorio completo** | ❌ **ELIMINADO** | Historial es parte de Cita, no un aggregate root |
| `guardar()` | → `CitaRepositoryPort.guardarHistorial()` | Movido a Cita |
| `listarPorCita()` | → `CitaRepositoryPort.buscarHistorialPorCita()` | Movido a Cita |
| `eliminar()` | ❌ **ELIMINADO** | Historial no se elimina |

---

## Resumen Estadístico

### Antes de Refactorización
- **4 Repository Ports**
- **CitaRepositoryPort:** 6 métodos
- **DisponibilidadRepositoryPort:** 6 métodos
- **ExcepcionHorariaRepositoryPort:** 5 métodos
- **HistorialCitaRepositoryPort:** 3 métodos
- **Total:** 20 métodos

### Después de Refactorización
- **3 Repository Ports** (eliminado HistorialCitaRepositoryPort)
- **CitaRepositoryPort:** 8 métodos (+2 de historial)
- **DisponibilidadRepositoryPort:** 5 métodos
- **ExcepcionHorariaRepositoryPort:** 2 métodos
- **Total:** 15 métodos (-5 métodos)

**Reducción:** -25% de métodos innecesarios

---

## Principios Aplicados

### 1. **Interface Segregation Principle (ISP)**
Los Repository Ports solo exponen operaciones que realmente se usan:
```java
// ❌ Mal: exponer métodos que nunca se llaman
void eliminar(String id); // No hay DELETE en el sistema

// ✅ Bien: solo operaciones necesarias
Cita actualizar(Cita cita); // Para reagendar y cancelar
```

### 2. **Separación de Concerns**
El dominio no conoce detalles de infraestructura:
```java
// ❌ Mal: paginación en el dominio
List<Cita> listar(..., Integer page, Integer size, String sort);

// ✅ Bien: dominio retorna lista completa
List<Cita> listar(...); // La capa de presentación pagina
```

### 3. **Aggregate Design**
Historial es parte del Aggregate Cita:
```java
// ❌ Mal: repositorio separado
HistorialCitaRepositoryPort historialRepo;

// ✅ Bien: parte de CitaRepositoryPort
void guardarHistorial(HistorialCita historial);
List<HistorialCita> buscarHistorialPorCita(String citaId);
```

### 4. **YAGNI (You Aren't Gonna Need It)**
No implementar métodos "por si acaso":
```java
// ❌ Mal: métodos especulativos
Long contarTotal(...); // No hay paginación real
void eliminar(String id); // No hay DELETE endpoint

// ✅ Bien: solo lo necesario ahora
List<Cita> listar(...); // Para GET /citas
```

---

## Impacto en Otras Capas

### Application Services
Los services ahora llaman métodos más específicos:
```java
// Antes
Long total = citaRepository.contarTotal(...);
List<Cita> citas = citaRepository.listar(..., page, size, sort, direction);

// Después
List<Cita> citas = citaRepository.listar(...); // Infraestructura pagina
```

### Infrastructure Adapters
Los adapters implementan menos métodos:
```java
// CitaRepositoryAdapter ya no implementa:
// - eliminar()
// - contarTotal()

// Y añade operaciones de historial:
// - guardarHistorial()
// - buscarHistorialPorCita()
```

---

## Validación Final

### ✅ Checklist de Validación

- [x] Todos los endpoints del PDF están cubiertos
- [x] No hay métodos DELETE (no existen en el PDF)
- [x] No hay parámetros de paginación en el dominio
- [x] Historial es parte de Cita (no aggregate separado)
- [x] Solo operaciones necesarias según Use Cases
- [x] Nombres de métodos revelan intención de negocio
- [x] Interfaces mínimas y cohesivas

### 📊 Cobertura de Endpoints

| Endpoint | Repository Port | Método |
|----------|----------------|--------|
| POST /citas | CitaRepositoryPort | `guardar()` |
| PUT /citas/{id} | CitaRepositoryPort | `actualizar()` |
| GET /citas (por ID) | CitaRepositoryPort | `buscarPorId()` |
| GET /citas (listar) | CitaRepositoryPort | `listar()` |
| POST /citas/{id}/cancelar | CitaRepositoryPort | `actualizar()` |
| GET /disponibilidad | DisponibilidadRepositoryPort | `buscarPorSedeYFecha()` |
| POST /disponibilidad | DisponibilidadRepositoryPort | `guardar()` / `guardarLote()` |
| PUT /disponibilidad/{id} | DisponibilidadRepositoryPort | `actualizar()` |
| POST /excepciones | ExcepcionHorariaRepositoryPort | `guardar()` |

**Cobertura:** 100% de endpoints cubiertos

---

## Conclusiones

1. **Menos es más:** Reducción de 20 a 15 métodos (-25%)
2. **Dominio puro:** Sin conceptos de infraestructura (paginación)
3. **Aggregate correcto:** Historial es parte de Cita
4. **Solo lo necesario:** Métodos basados en endpoints reales del PDF
5. **Mantenibilidad:** Menos métodos = menos complejidad

La refactorización sigue los principios de **Arquitectura Hexagonal**: el dominio es independiente de detalles de infraestructura y solo expone las operaciones que realmente necesita el negocio.
