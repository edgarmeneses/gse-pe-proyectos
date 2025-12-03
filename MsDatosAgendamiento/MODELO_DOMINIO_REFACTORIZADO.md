# Modelo de Dominio Refactorizado - MsDatosAgendamiento

## Resumen de Cambios

El modelo de dominio ha sido rediseñado siguiendo principios de **Domain-Driven Design (DDD)** para separar claramente las **entidades de negocio** de los **DTOs de presentación**.

### Cambios Principales

1. **Eliminados (eran DTOs de presentación, no del dominio):**
   - ❌ `Paginacion` - Metadata de respuesta API
   - ❌ `ResumenDisponibilidad` - Vista calculada para respuestas
   - ❌ `CitasAfectadas` - Resultado de operaciones

2. **Nuevos Value Objects con validaciones:**
   - ✅ `Dni` - DNI con validación de 8 dígitos
   - ✅ `Email` - Email con validación de formato
   - ✅ `Telefono` - Teléfono con validación de longitud
   - ✅ `NombreCompleto` - Composición de nombres y apellidos
   - ✅ `CodigoSede` - Código de sede normalizado

3. **Nuevas Enumeraciones con lógica de negocio:**
   - ✅ `EstadoCita` (enum) - Estados con métodos: `esActiva()`, `esFinalizada()`, `permiteReagendamiento()`, `permiteCancelacion()`
   - ✅ `DiaSemana` (enum) - Días con métodos: `esFinDeSemana()`, `esLaborable()`, `desde(LocalDate)`
   - ✅ `TipoExcepcion` (enum) - Tipos con métodos: `requiereCancelacionCitas()`, `esRecurrente()`

4. **Entidades refactorizadas con lógica de dominio:**
   - ✅ `Cita` - Ahora con métodos de negocio ricos
   - ✅ `Disponibilidad` - Con gestión de capacidad
   - ✅ `ExcepcionHoraria` - Con validaciones de negocio

---

## Modelo de Dominio Actual

### 📦 Value Objects (8)

#### 1. **Dni**
```java
// Inmutable, con validación
new Dni("12345678") // Valida 8 dígitos
```

#### 2. **Email**
```java
// Inmutable, con validación de formato
new Email("usuario@example.com")
```

#### 3. **Telefono**
```java
// Inmutable, valida 7-15 dígitos
new Telefono("987654321")
```

#### 4. **NombreCompleto**
```java
// Inmutable, composición de nombres y apellidos
new NombreCompleto("Juan", "Pérez", "García")
nombreCompleto.getNombreCompletoFormateado() // "Pérez García Juan"
```

#### 5. **CodigoSede**
```java
// Inmutable, normalizado a mayúsculas
new CodigoSede("SEDE001")
```

#### 6. **Solicitante**
```java
// Value object compuesto
new Solicitante(dni, nombreCompleto, email, telefono)
```

#### 7. **SedeServicio**
```java
// Value object con datos de sede
new SedeServicio(codigoSede, "Sede Lima", "Av. Principal 123")
```

#### 8. **Programacion**
```java
// Value object con fecha/hora de cita
programacion.esEnElPasado()
programacion.esEnElFuturo()
programacion.getFechaHoraCompleta()
```

**Otros Value Objects:**
- `Solicitud` - ID de solicitud y número de trámite
- `TecnicoAsignado` - Datos del técnico
- `HorarioEspecial` - Horario especial en excepciones
- `HorarioServicio` - Horario de servicio estándar

---

### 🎯 Enumeraciones (3)

#### 1. **EstadoCita**
```java
public enum EstadoCita {
    PENDIENTE, CONFIRMADA, REAGENDADA, COMPLETADA, CANCELADA, NO_ASISTIO;
    
    // Métodos de dominio
    boolean esActiva()
    boolean esFinalizada()
    boolean permiteReagendamiento()
    boolean permiteCancelacion()
}
```

**Uso:**
```java
EstadoCita.PENDIENTE.permiteReagendamiento() // true
EstadoCita.COMPLETADA.esFinalizada() // true
```

#### 2. **DiaSemana**
```java
public enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    
    // Métodos de dominio
    boolean esFinDeSemana()
    boolean esLaborable()
    static DiaSemana desde(LocalDate fecha)
}
```

**Uso:**
```java
DiaSemana.SABADO.esFinDeSemana() // true
DiaSemana dia = DiaSemana.desde(LocalDate.now())
```

#### 3. **TipoExcepcion**
```java
public enum TipoExcepcion {
    FERIADO, DIA_NO_LABORABLE, MANTENIMIENTO, EVENTO_ESPECIAL, 
    CAPACITACION, EMERGENCIA, CIERRE_TEMPORAL;
    
    // Métodos de dominio
    boolean requiereCancelacionCitas()
    boolean esRecurrente()
}
```

**Uso:**
```java
TipoExcepcion.MANTENIMIENTO.requiereCancelacionCitas() // true
TipoExcepcion.FERIADO.esRecurrente() // true
```

---

### 🏛️ Entidades (Aggregate Roots) (3)

#### 1. **Cita** (Aggregate Root)

**Atributos:**
- `citaId`, `codigoCita`, `estado`, `sedeServicio`
- `solicitud`, `solicitante`, `programacion`
- `tecnicoAsignado`, `tokenReagendamiento`
- `fechaLimiteReagendamiento`, `cantidadReagendamientos`
- `maximoReagendamientos`, `observaciones`
- `fechaRegistro`, `usuarioRegistro`

**Métodos de Dominio:**
```java
// Creación y gestión de ciclo de vida
void crear(SedeServicio, Solicitud, Solicitante, Programacion, String usuario)
void reagendar(Programacion nueva, String motivoCambio, String usuario)
void cancelar(String motivoCancelacion, String usuario)
void confirmar(String usuario)
void completar(String usuario)
void marcarNoAsistio(String usuario)
void asignarTecnico(TecnicoAsignado tecnico, String usuario)

// Consultas de negocio
boolean puedeReagendar()
boolean estaEnPlazoParaReagendar()
boolean esActiva()
boolean estaFinalizada()
int reagendamientosDisponibles()

// Métodos privados
private String generarCodigoCita()
private String generarToken()
private LocalDateTime calcularFechaLimiteReagendamiento()
private void validarDatosObligatorios(...)
```

**Reglas de Negocio Implementadas:**
- ✅ No se puede crear cita en el pasado
- ✅ Máximo 3 reagendamientos por defecto (configurable)
- ✅ Fecha límite para reagendar: 48 horas antes de la cita
- ✅ Solo se reagendan citas en estados permitidos
- ✅ Genera token único para cada reagendamiento
- ✅ Calcula automáticamente fecha límite de reagendamiento
- ✅ Registra observaciones con cada cambio

**Ejemplo de uso:**
```java
Cita cita = new Cita();
cita.crear(sedeServicio, solicitud, solicitante, programacion, "usuario123");

if (cita.puedeReagendar() && cita.estaEnPlazoParaReagendar()) {
    cita.reagendar(nuevaProgramacion, "Cambio por disponibilidad", "usuario123");
}

cita.confirmar("usuario123");
cita.completar("usuario123");
```

---

#### 2. **Disponibilidad** (Aggregate Root)

**Atributos:**
- `idDisponibilidad`, `codigoSede`, `fecha`, `diaSemana`
- `esHabil`, `motivoNoHabil`
- `horaInicio`, `horaFin`
- `capacidadTotal`, `capacidadOcupada`
- `estado`, `fechaRegistro`, `usuarioRegistro`

**Métodos de Dominio:**
```java
// Configuración y gestión
void configurar(CodigoSede, LocalDate, LocalTime inicio, LocalTime fin, Integer capacidad, String usuario)
void ocuparCupo()
void liberarCupo()
void marcarComoNoHabil(String motivo, String usuario)
void marcarComoHabil(String usuario)
void desactivar(String usuario)
void activar(String usuario)
void actualizarCapacidad(Integer nuevaCapacidad, String usuario)
void actualizarHorario(LocalTime inicio, LocalTime fin, String usuario)

// Consultas de negocio
boolean estaDisponible()
boolean estaCompleta()
boolean estaActiva()
Integer getCapacidadDisponible() // Calculada
boolean esDelDia(LocalDate fecha)
boolean esDeLaSede(CodigoSede codigoSede)
boolean estaEnRangoHorario(LocalTime hora)

// Métodos privados
private void validarDatosObligatorios(...)
```

**Reglas de Negocio Implementadas:**
- ✅ No se configura disponibilidad en el pasado
- ✅ Hora fin debe ser posterior a hora inicio
- ✅ Capacidad total debe ser mayor a 0
- ✅ No se puede reducir capacidad por debajo de cupos ocupados
- ✅ Solo se ocupan cupos si está disponible y es hábil
- ✅ Calcula automáticamente día de la semana
- ✅ Capacidad disponible es calculada (no almacenada)

**Ejemplo de uso:**
```java
Disponibilidad disp = new Disponibilidad();
disp.configurar(codigoSede, fecha, horaInicio, horaFin, 20, "usuario123");

if (disp.estaDisponible() && disp.estaActiva()) {
    disp.ocuparCupo(); // capacidadOcupada++
}

disp.marcarComoNoHabil("Feriado Nacional", "usuario123");
```

---

#### 3. **ExcepcionHoraria** (Aggregate Root)

**Atributos:**
- `idExcepcion`, `codigoSede`, `fechaExcepcion`
- `tipoExcepcion`, `descripcion`
- `horarioEspecial`
- `afectaCitasExistentes`, `notificarAfectados`
- `fechaRegistro`, `usuarioRegistro`

**Métodos de Dominio:**
```java
// Registro y gestión
void registrar(CodigoSede, LocalDate, TipoExcepcion, String descripcion, HorarioEspecial, String usuario)

// Consultas de negocio
boolean requiereCancelacionDeCitas()
boolean esParaLaSede(CodigoSede codigoSede)
boolean esParaLaFecha(LocalDate fecha)
boolean tieneHorarioEspecial()

// Métodos privados
private void validarDatosObligatorios(...)
```

**Reglas de Negocio Implementadas:**
- ✅ No se registran excepciones en el pasado
- ✅ Automáticamente determina si requiere cancelación según el tipo
- ✅ Por defecto, notifica a afectados
- ✅ Valida datos obligatorios

**Ejemplo de uso:**
```java
ExcepcionHoraria excepcion = new ExcepcionHoraria();
excepcion.registrar(codigoSede, fecha, TipoExcepcion.MANTENIMIENTO, 
                    "Mantenimiento de sistema", horarioEspecial, "usuario123");

if (excepcion.requiereCancelacionDeCitas()) {
    // Cancelar citas programadas para esa fecha
}
```

---

### 📊 Entidades Secundarias (1)

#### **HistorialCita**
- Registra cambios en el estado de citas
- No tiene lógica de dominio compleja
- Es un event log

---

## Beneficios del Nuevo Modelo

### 1. **Separación de Responsabilidades**
- ✅ Dominio puro sin dependencias de DTOs
- ✅ Value Objects inmutables con validaciones
- ✅ Enumeraciones con lógica de negocio

### 2. **Validaciones en el Dominio**
```java
new Dni("123") // IllegalArgumentException: debe tener 8 dígitos
new Email("invalid") // IllegalArgumentException: formato inválido
cita.reagendar(...) // IllegalStateException si no puede reagendar
```

### 3. **Lógica de Negocio Centralizada**
```java
// Antes (lógica dispersa en services)
if (cita.getEstado().equals("PENDIENTE") && 
    cita.getCantidadReagendamientos() < cita.getMaximoReagendamientos()) {
    // reagendar
}

// Ahora (lógica en el dominio)
if (cita.puedeReagendar() && cita.estaEnPlazoParaReagendar()) {
    cita.reagendar(nuevaProgramacion, motivo, usuario);
}
```

### 4. **Inmutabilidad en Value Objects**
```java
// Value Objects son inmutables
Dni dni = new Dni("12345678");
dni.setNumero("87654321"); // No existe, es inmutable

// Para cambiar, se crea nuevo objeto
Dni otroDni = new Dni("87654321");
```

### 5. **Métodos Reveladores de Intención**
```java
disponibilidad.ocuparCupo()
disponibilidad.liberarCupo()
disponibilidad.estaDisponible()

cita.reagendar(nuevaProgramacion, motivo, usuario)
cita.cancelar(motivo, usuario)
cita.confirmar(usuario)
```

---

## Estructura Final del Dominio

```
domain/model/
├── Aggregate Roots (Entidades mutables con identidad)
│   ├── Cita.java (con 13 métodos de negocio)
│   ├── Disponibilidad.java (con 15 métodos de negocio)
│   └── ExcepcionHoraria.java (con 6 métodos de negocio)
│
├── Value Objects (Inmutables, definidos por sus valores)
│   ├── Primitivos:
│   │   ├── Dni.java
│   │   ├── Email.java
│   │   ├── Telefono.java
│   │   ├── NombreCompleto.java
│   │   └── CodigoSede.java
│   │
│   ├── Compuestos:
│   │   ├── Solicitante.java
│   │   ├── SedeServicio.java
│   │   ├── Programacion.java
│   │   ├── Solicitud.java
│   │   ├── TecnicoAsignado.java
│   │   ├── HorarioEspecial.java
│   │   └── HorarioServicio.java
│
├── Enumeraciones (Con lógica de dominio)
│   ├── EstadoCita.java
│   ├── DiaSemana.java
│   └── TipoExcepcion.java
│
└── Entidades Secundarias
    └── HistorialCita.java
```

**Total: 19 clases de dominio**
- 3 Aggregate Roots (con lógica rica)
- 12 Value Objects (5 primitivos + 7 compuestos)
- 3 Enumeraciones (con métodos de negocio)
- 1 Entidad secundaria

---

## Comparación: Antes vs Después

### Antes ❌
```java
// Modelo anémico (sin comportamiento)
public class Cita {
    private String estado;
    // ... solo getters y setters
}

// Lógica dispersa en services
if (cita.getEstado().equals("PENDIENTE")) {
    cita.setEstado("CONFIRMADA");
    cita.setFechaActualizacion(LocalDateTime.now());
}
```

### Después ✅
```java
// Modelo rico (con comportamiento)
public class Cita {
    private EstadoCita estado; // Enum con lógica
    
    public void confirmar(String usuario) {
        if (estado != EstadoCita.PENDIENTE && estado != EstadoCita.REAGENDADA) {
            throw new IllegalStateException("Solo se confirman citas pendientes");
        }
        this.estado = EstadoCita.CONFIRMADA;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
}

// Uso limpio
cita.confirmar("usuario123"); // Lógica encapsulada
```

---

## Próximos Pasos

1. ✅ **Dominio refactorizado** (completado)
2. ⏳ **Actualizar Use Cases** para usar los nuevos métodos de dominio
3. ⏳ **Actualizar Mappers** (DTO ↔ Dominio y Dominio ↔ Persistencia)
4. ⏳ **Actualizar Services** para delegar lógica al dominio
5. ⏳ **Tests unitarios** del modelo de dominio

---

## Notas Importantes

- **No hay dependencias externas**: Todo es Java puro
- **Sin anotaciones**: No hay `@Entity`, `@Service`, `@Valid`, etc.
- **Validaciones tempranas**: Fallan en construcción si datos inválidos
- **Inmutabilidad**: Value Objects no pueden cambiar después de creación
- **Consistencia**: Las reglas están en el dominio, no dispersas en services

---

## Archivos Eliminados

Estos archivos fueron eliminados porque **NO son del dominio**, son de presentación/infraestructura:

- ❌ `Paginacion.java` → Metadata de respuestas API (mover a DTOs)
- ❌ `ResumenDisponibilidad.java` → Vista calculada para respuestas (mover a DTOs)
- ❌ `CitasAfectadas.java` → Resultado de operación (mover a DTOs)

**Total archivos Java:** 72 (antes 68, +7 nuevos, -3 eliminados)
