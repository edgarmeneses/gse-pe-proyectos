package pe.com.organizacion.cotejomasivo.domain.model;

import java.time.LocalDateTime;

/**
 * Value Object: ResultadoCotejo
 * Representa el resultado del cotejo de un registro individual
 */
public class ResultadoCotejo {
    
    private String idRegistro;
    private String estadoCotejo;
    private String detalles;
    private LocalDateTime fechaProcesamiento;
    
    public ResultadoCotejo() {
    }
    
    public ResultadoCotejo(String idRegistro, String estadoCotejo, String detalles, LocalDateTime fechaProcesamiento) {
        this.idRegistro = idRegistro;
        this.estadoCotejo = estadoCotejo;
        this.detalles = detalles;
        this.fechaProcesamiento = fechaProcesamiento;
    }
    
    public String getIdRegistro() {
        return idRegistro;
    }
    
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public String getEstadoCotejo() {
        return estadoCotejo;
    }
    
    public void setEstadoCotejo(String estadoCotejo) {
        this.estadoCotejo = estadoCotejo;
    }
    
    public String getDetalles() {
        return detalles;
    }
    
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }
    
    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }
}
