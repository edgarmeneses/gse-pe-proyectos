package pe.gob.reniec.padronelectoral.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object: Actualización de Padrón
 * Representa un evento de actualización en el ciclo de vida del padrón electoral.
 * Inmutable y con validaciones de dominio.
 */
public class ActualizacionPadron {
    private final LocalDateTime fechaActualizacion;
    private final String usuarioResponsableId;
    private final String informeFinalVerificacionDomicilioId;
    private final TipoPadron nuevoTipoPadron;
    private final TipoVerificacion tipoVerificacion;

    // Constructor para nueva actualización
    public ActualizacionPadron(String usuarioResponsableId, 
                              String informeFinalVerificacionDomicilioId,
                              TipoPadron nuevoTipoPadron,
                              TipoVerificacion tipoVerificacion) {
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioResponsableId = validarUsuarioResponsable(usuarioResponsableId);
        this.informeFinalVerificacionDomicilioId = validarInforme(informeFinalVerificacionDomicilioId);
        this.nuevoTipoPadron = nuevoTipoPadron;
        this.tipoVerificacion = Objects.requireNonNull(tipoVerificacion, "El tipo de verificación es obligatorio");
    }

    // Constructor para reconstrucción desde persistencia
    public ActualizacionPadron(LocalDateTime fechaActualizacion,
                              String usuarioResponsableId, 
                              String informeFinalVerificacionDomicilioId,
                              TipoPadron nuevoTipoPadron,
                              TipoVerificacion tipoVerificacion) {
        this.fechaActualizacion = Objects.requireNonNull(fechaActualizacion, "La fecha es obligatoria");
        this.usuarioResponsableId = validarUsuarioResponsable(usuarioResponsableId);
        this.informeFinalVerificacionDomicilioId = validarInforme(informeFinalVerificacionDomicilioId);
        this.nuevoTipoPadron = nuevoTipoPadron;
        this.tipoVerificacion = Objects.requireNonNull(tipoVerificacion, "El tipo de verificación es obligatorio");
    }

    // Constructor simplificado sin tipo de padrón nuevo
    public ActualizacionPadron(String usuarioResponsableId, 
                              String informeFinalVerificacionDomicilioId,
                              TipoVerificacion tipoVerificacion) {
        this(usuarioResponsableId, informeFinalVerificacionDomicilioId, null, tipoVerificacion);
    }

    private String validarUsuarioResponsable(String usuarioId) {
        if (usuarioId == null || usuarioId.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario responsable es obligatorio");
        }
        return usuarioId.trim();
    }

    private String validarInforme(String informeId) {
        if (informeId == null || informeId.trim().isEmpty()) {
            throw new IllegalArgumentException("El informe de verificación es obligatorio");
        }
        return informeId.trim();
    }

    // Método de dominio: Verificar si cambió el tipo de padrón
    public boolean cambiaTipoPadron() {
        return nuevoTipoPadron != null;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public String getUsuarioResponsableId() {
        return usuarioResponsableId;
    }

    public String getInformeFinalVerificacionDomicilioId() {
        return informeFinalVerificacionDomicilioId;
    }

    public TipoPadron getNuevoTipoPadron() {
        return nuevoTipoPadron;
    }

    public TipoVerificacion getTipoVerificacion() {
        return tipoVerificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActualizacionPadron that = (ActualizacionPadron) o;
        return Objects.equals(fechaActualizacion, that.fechaActualizacion) &&
               Objects.equals(usuarioResponsableId, that.usuarioResponsableId) &&
               Objects.equals(informeFinalVerificacionDomicilioId, that.informeFinalVerificacionDomicilioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaActualizacion, usuarioResponsableId, informeFinalVerificacionDomicilioId);
    }

    @Override
    public String toString() {
        return "ActualizacionPadron{" +
                "fecha=" + fechaActualizacion +
                ", usuario='" + usuarioResponsableId + '\'' +
                ", informe='" + informeFinalVerificacionDomicilioId + '\'' +
                ", nuevoTipo=" + nuevoTipoPadron +
                ", tipoVerificacion=" + tipoVerificacion +
                '}';
    }
}
