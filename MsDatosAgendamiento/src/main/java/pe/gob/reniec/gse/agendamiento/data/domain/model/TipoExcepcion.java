package pe.gob.reniec.gse.agendamiento.data.domain.model;

public enum TipoExcepcion {
    
    FERIADO("Feriado", "Día feriado nacional o regional"),
    DIA_NO_LABORABLE("Día No Laborable", "Día declarado no laborable"),
    MANTENIMIENTO("Mantenimiento", "Mantenimiento programado de la sede"),
    EVENTO_ESPECIAL("Evento Especial", "Evento especial que afecta la disponibilidad"),
    CAPACITACION("Capacitación", "Capacitación del personal"),
    EMERGENCIA("Emergencia", "Situación de emergencia"),
    CIERRE_TEMPORAL("Cierre Temporal", "Cierre temporal de la sede");
    
    private final String nombre;
    private final String descripcion;
    
    TipoExcepcion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean requiereCancelacionCitas() {
        return this == MANTENIMIENTO || this == EMERGENCIA || this == CIERRE_TEMPORAL;
    }
    
    public boolean esRecurrente() {
        return this == FERIADO || this == DIA_NO_LABORABLE;
    }
}
