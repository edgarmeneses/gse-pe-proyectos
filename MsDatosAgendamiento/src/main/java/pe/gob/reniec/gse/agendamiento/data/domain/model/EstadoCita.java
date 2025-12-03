package pe.gob.reniec.gse.agendamiento.data.domain.model;

public enum EstadoCita {
    
    PENDIENTE("Pendiente", "Cita agendada pendiente de confirmación"),
    CONFIRMADA("Confirmada", "Cita confirmada por el solicitante"),
    REAGENDADA("Reagendada", "Cita reagendada a nueva fecha"),
    COMPLETADA("Completada", "Cita completada exitosamente"),
    CANCELADA("Cancelada", "Cita cancelada por el solicitante o el sistema"),
    NO_ASISTIO("No Asistió", "El solicitante no asistió a la cita");
    
    private final String nombre;
    private final String descripcion;
    
    EstadoCita(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean esActiva() {
        return this == PENDIENTE || this == CONFIRMADA;
    }
    
    public boolean esFinalizada() {
        return this == COMPLETADA || this == CANCELADA || this == NO_ASISTIO;
    }
    
    public boolean permiteReagendamiento() {
        return this == PENDIENTE || this == CONFIRMADA || this == REAGENDADA;
    }
    
    public boolean permiteCancelacion() {
        return this == PENDIENTE || this == CONFIRMADA || this == REAGENDADA;
    }
}
