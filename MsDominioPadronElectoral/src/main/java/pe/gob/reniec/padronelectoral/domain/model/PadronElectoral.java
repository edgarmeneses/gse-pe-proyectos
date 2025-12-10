package pe.gob.reniec.padronelectoral.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate Root: Padrón Electoral
 * Representa un padrón electoral con su circunscripción, ciudadanos y actualizaciones.
 * Modelo de dominio rico con comportamiento, validaciones e inmutabilidad.
 */
public class PadronElectoral {
    private final PadronElectoralId id;
    private final TipoPadron tipoPadron;
    private final TipoProceso tipoProceso;
    private final Circunscripcion circunscripcion;
    private final LocalDateTime fechaCreacion;
    private final List<Ciudadano> ciudadanos;
    private final List<ActualizacionPadron> historialActualizaciones;

    private PadronElectoral(Builder builder) {
        this.id = Objects.requireNonNull(builder.id, "El ID del padrón es obligatorio");
        this.tipoPadron = Objects.requireNonNull(builder.tipoPadron, "El tipo de padrón es obligatorio");
        this.tipoProceso = Objects.requireNonNull(builder.tipoProceso, "El tipo de proceso es obligatorio");
        this.circunscripcion = Objects.requireNonNull(builder.circunscripcion, "La circunscripción es obligatoria");
        this.fechaCreacion = Objects.requireNonNull(builder.fechaCreacion, "La fecha de creación es obligatoria");
        this.ciudadanos = new ArrayList<>(builder.ciudadanos);
        this.historialActualizaciones = new ArrayList<>(builder.historialActualizaciones);
    }

    // Factory method para crear un nuevo padrón
    public static PadronElectoral crear(String id, TipoPadron tipoPadron, TipoProceso tipoProceso,
                                        Circunscripcion circunscripcion, List<Ciudadano> ciudadanos) {
        return new Builder()
                .conId(new PadronElectoralId(id))
                .conTipoPadron(tipoPadron)
                .conTipoProceso(tipoProceso)
                .conCircunscripcion(circunscripcion)
                .conFechaCreacion(LocalDateTime.now())
                .conCiudadanos(ciudadanos)
                .construir();
    }

    // Factory method para reconstruir desde persistencia
    public static PadronElectoral reconstruir(String id, TipoPadron tipoPadron, TipoProceso tipoProceso,
                                             Circunscripcion circunscripcion, LocalDateTime fechaCreacion,
                                             List<Ciudadano> ciudadanos, List<ActualizacionPadron> historial) {
        return new Builder()
                .conId(new PadronElectoralId(id))
                .conTipoPadron(tipoPadron)
                .conTipoProceso(tipoProceso)
                .conCircunscripcion(circunscripcion)
                .conFechaCreacion(fechaCreacion)
                .conCiudadanos(ciudadanos)
                .conHistorialActualizaciones(historial)
                .construir();
    }

    // Método de dominio: Actualizar padrón
    public PadronElectoral actualizar(ActualizacionPadron actualizacion) {
        Objects.requireNonNull(actualizacion, "La actualización no puede ser nula");
        
        return new Builder()
                .conId(this.id)
                .conTipoPadron(actualizacion.getNuevoTipoPadron() != null ? actualizacion.getNuevoTipoPadron() : this.tipoPadron)
                .conTipoProceso(this.tipoProceso)
                .conCircunscripcion(this.circunscripcion)
                .conFechaCreacion(this.fechaCreacion)
                .conCiudadanos(this.ciudadanos)
                .conHistorialActualizaciones(this.historialActualizaciones)
                .agregarActualizacion(actualizacion)
                .construir();
    }

    // Método de dominio: Verificar si está actualizado
    public boolean estaActualizado() {
        return !historialActualizaciones.isEmpty();
    }

    // Método de dominio: Obtener última actualización
    public ActualizacionPadron obtenerUltimaActualizacion() {
        if (historialActualizaciones.isEmpty()) {
            return null;
        }
        return historialActualizaciones.get(historialActualizaciones.size() - 1);
    }

    // Método de dominio: Contar ciudadanos
    public int contarCiudadanos() {
        return ciudadanos.size();
    }

    // Método de dominio: Verificar si pertenece a una circunscripción
    public boolean perteneceACircunscripcion(String departamento, String provincia, String distrito) {
        return circunscripcion.coincideCon(departamento, provincia, distrito);
    }

    // Método de dominio: Verificar si está en estado final
    public boolean esFinal() {
        return tipoPadron == TipoPadron.FINAL;
    }

    // Método de dominio: Buscar ciudadano por documento
    public Ciudadano buscarCiudadano(String numeroDocumento) {
        return ciudadanos.stream()
                .filter(c -> c.getDocumento().equals(numeroDocumento))
                .findFirst()
                .orElse(null);
    }

    // Getters (sin setters para inmutabilidad)
    public PadronElectoralId getId() {
        return id;
    }

    public TipoPadron getTipoPadron() {
        return tipoPadron;
    }

    public TipoProceso getTipoProceso() {
        return tipoProceso;
    }

    public Circunscripcion getCircunscripcion() {
        return circunscripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        ActualizacionPadron ultima = obtenerUltimaActualizacion();
        return ultima != null ? ultima.getFechaActualizacion() : null;
    }

    public List<Ciudadano> getCiudadanos() {
        return Collections.unmodifiableList(ciudadanos);
    }

    public List<ActualizacionPadron> getHistorialActualizaciones() {
        return Collections.unmodifiableList(historialActualizaciones);
    }

    // Builder pattern
    public static class Builder {
        private PadronElectoralId id;
        private TipoPadron tipoPadron;
        private TipoProceso tipoProceso;
        private Circunscripcion circunscripcion;
        private LocalDateTime fechaCreacion;
        private List<Ciudadano> ciudadanos = new ArrayList<>();
        private List<ActualizacionPadron> historialActualizaciones = new ArrayList<>();

        public Builder conId(PadronElectoralId id) {
            this.id = id;
            return this;
        }

        public Builder conTipoPadron(TipoPadron tipoPadron) {
            this.tipoPadron = tipoPadron;
            return this;
        }

        public Builder conTipoProceso(TipoProceso tipoProceso) {
            this.tipoProceso = tipoProceso;
            return this;
        }

        public Builder conCircunscripcion(Circunscripcion circunscripcion) {
            this.circunscripcion = circunscripcion;
            return this;
        }

        public Builder conFechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder conCiudadanos(List<Ciudadano> ciudadanos) {
            this.ciudadanos = new ArrayList<>(ciudadanos != null ? ciudadanos : new ArrayList<>());
            return this;
        }

        public Builder conHistorialActualizaciones(List<ActualizacionPadron> historial) {
            this.historialActualizaciones = new ArrayList<>(historial != null ? historial : new ArrayList<>());
            return this;
        }

        public Builder agregarActualizacion(ActualizacionPadron actualizacion) {
            this.historialActualizaciones.add(actualizacion);
            return this;
        }

        public PadronElectoral construir() {
            return new PadronElectoral(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PadronElectoral that = (PadronElectoral) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PadronElectoral{" +
                "id=" + id +
                ", tipoPadron=" + tipoPadron +
                ", tipoProceso=" + tipoProceso +
                ", circunscripcion=" + circunscripcion +
                ", ciudadanos=" + contarCiudadanos() +
                ", actualizaciones=" + historialActualizaciones.size() +
                '}';
    }
}
