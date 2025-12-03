package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

import java.util.List;

/**
 * Value Object del dominio - Resultado del registro de una solicitud de cotejo masivo
 * Representa el resultado de negocio al iniciar un cotejo, sin preocupaciones de transporte
 */
public class ResultadoRegistroSolicitud {
    
    private final SolicitudCotejoMasivo solicitud;
    private final List<EventoGenerado> eventosGenerados;
    private final String tiempoEstimadoProcesamiento;
    
    public ResultadoRegistroSolicitud(SolicitudCotejoMasivo solicitud, 
                                       List<EventoGenerado> eventosGenerados,
                                       String tiempoEstimadoProcesamiento) {
        if (solicitud == null) {
            throw new IllegalArgumentException("La solicitud no puede ser nula");
        }
        if (eventosGenerados == null || eventosGenerados.isEmpty()) {
            throw new IllegalArgumentException("Debe generar al menos un evento");
        }
        
        this.solicitud = solicitud;
        this.eventosGenerados = eventosGenerados;
        this.tiempoEstimadoProcesamiento = tiempoEstimadoProcesamiento;
    }
    
    // Getters (sin setters, es inmutable)
    
    public SolicitudCotejoMasivo getSolicitud() {
        return solicitud;
    }
    
    public List<EventoGenerado> getEventosGenerados() {
        return eventosGenerados;
    }
    
    public String getTiempoEstimadoProcesamiento() {
        return tiempoEstimadoProcesamiento;
    }
    
    // Métodos de conveniencia
    
    public String getSolicitudId() {
        return solicitud.getSolicitudId();
    }
    
    public String getNumeroSolicitud() {
        return solicitud.getNumeroSolicitud();
    }
    
    public EstadoSolicitud getEstado() {
        return solicitud.getEstado();
    }
    
    public int getTotalEventosGenerados() {
        return eventosGenerados.size();
    }
}
