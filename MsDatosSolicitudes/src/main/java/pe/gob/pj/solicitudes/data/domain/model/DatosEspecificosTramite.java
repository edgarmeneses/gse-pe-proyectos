package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class DatosEspecificosTramite {
    
    private String motivoRenovacion;
    private String dniAnterior;
    private LocalDateTime fechaVencimientoDniAnterior;
    private Boolean requiereEntregaDomicilio;
    private String oficinaEntregaPreferida;
    private List<DocumentoAdjunto> documentosAdjuntos;

    public DatosEspecificosTramite() {
    }

    public DatosEspecificosTramite(String motivoRenovacion, String dniAnterior,
                                   LocalDateTime fechaVencimientoDniAnterior, Boolean requiereEntregaDomicilio,
                                   String oficinaEntregaPreferida, List<DocumentoAdjunto> documentosAdjuntos) {
        this.motivoRenovacion = motivoRenovacion;
        this.dniAnterior = dniAnterior;
        this.fechaVencimientoDniAnterior = fechaVencimientoDniAnterior;
        this.requiereEntregaDomicilio = requiereEntregaDomicilio;
        this.oficinaEntregaPreferida = oficinaEntregaPreferida;
        this.documentosAdjuntos = documentosAdjuntos;
    }

    public String getMotivoRenovacion() {
        return motivoRenovacion;
    }

    public void setMotivoRenovacion(String motivoRenovacion) {
        this.motivoRenovacion = motivoRenovacion;
    }

    public String getDniAnterior() {
        return dniAnterior;
    }

    public void setDniAnterior(String dniAnterior) {
        this.dniAnterior = dniAnterior;
    }

    public LocalDateTime getFechaVencimientoDniAnterior() {
        return fechaVencimientoDniAnterior;
    }

    public void setFechaVencimientoDniAnterior(LocalDateTime fechaVencimientoDniAnterior) {
        this.fechaVencimientoDniAnterior = fechaVencimientoDniAnterior;
    }

    public Boolean getRequiereEntregaDomicilio() {
        return requiereEntregaDomicilio;
    }

    public void setRequiereEntregaDomicilio(Boolean requiereEntregaDomicilio) {
        this.requiereEntregaDomicilio = requiereEntregaDomicilio;
    }

    public String getOficinaEntregaPreferida() {
        return oficinaEntregaPreferida;
    }

    public void setOficinaEntregaPreferida(String oficinaEntregaPreferida) {
        this.oficinaEntregaPreferida = oficinaEntregaPreferida;
    }

    public List<DocumentoAdjunto> getDocumentosAdjuntos() {
        return documentosAdjuntos;
    }

    public void setDocumentosAdjuntos(List<DocumentoAdjunto> documentosAdjuntos) {
        this.documentosAdjuntos = documentosAdjuntos;
    }
}
