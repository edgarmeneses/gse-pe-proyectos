package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HistorialCita {
    
    private String idHistorial;
    private String citaId;
    private LocalDateTime fechaCambio;
    private String estadoAnterior;
    private String estadoNuevo;
    private LocalDateTime fechaAnterior;
    private LocalTime horaAnterior;
    private LocalDateTime fechaNueva;
    private LocalTime horaNueva;
    private String motivoCambio;
    private String usuarioCambio;
    
    public HistorialCita() {
    }
    
    public HistorialCita(String idHistorial, String citaId, LocalDateTime fechaCambio,
                        String estadoAnterior, String estadoNuevo, LocalDateTime fechaAnterior,
                        LocalTime horaAnterior, LocalDateTime fechaNueva, LocalTime horaNueva,
                        String motivoCambio, String usuarioCambio) {
        this.idHistorial = idHistorial;
        this.citaId = citaId;
        this.fechaCambio = fechaCambio;
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.fechaAnterior = fechaAnterior;
        this.horaAnterior = horaAnterior;
        this.fechaNueva = fechaNueva;
        this.horaNueva = horaNueva;
        this.motivoCambio = motivoCambio;
        this.usuarioCambio = usuarioCambio;
    }
    
    public String getIdHistorial() {
        return idHistorial;
    }
    
    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }
    
    public String getCitaId() {
        return citaId;
    }
    
    public void setCitaId(String citaId) {
        this.citaId = citaId;
    }
    
    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }
    
    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }
    
    public String getEstadoAnterior() {
        return estadoAnterior;
    }
    
    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
    
    public String getEstadoNuevo() {
        return estadoNuevo;
    }
    
    public void setEstadoNuevo(String estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }
    
    public LocalDateTime getFechaAnterior() {
        return fechaAnterior;
    }
    
    public void setFechaAnterior(LocalDateTime fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }
    
    public LocalTime getHoraAnterior() {
        return horaAnterior;
    }
    
    public void setHoraAnterior(LocalTime horaAnterior) {
        this.horaAnterior = horaAnterior;
    }
    
    public LocalDateTime getFechaNueva() {
        return fechaNueva;
    }
    
    public void setFechaNueva(LocalDateTime fechaNueva) {
        this.fechaNueva = fechaNueva;
    }
    
    public LocalTime getHoraNueva() {
        return horaNueva;
    }
    
    public void setHoraNueva(LocalTime horaNueva) {
        this.horaNueva = horaNueva;
    }
    
    public String getMotivoCambio() {
        return motivoCambio;
    }
    
    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }
    
    public String getUsuarioCambio() {
        return usuarioCambio;
    }
    
    public void setUsuarioCambio(String usuarioCambio) {
        this.usuarioCambio = usuarioCambio;
    }
}
