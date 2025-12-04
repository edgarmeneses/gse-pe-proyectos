package pe.gob.onpe.datos.electoral.domain.model;

import java.time.LocalDateTime;

public class Analisis {
    private Long id;
    private String tipoAnalisis;
    private LocalDateTime fechaAnalisis;
    private String resultado;
    private String observaciones;
    private String estado;

    public Analisis() {
    }

    public Analisis(Long id, String tipoAnalisis, LocalDateTime fechaAnalisis, 
                    String resultado, String observaciones, String estado) {
        this.id = id;
        this.tipoAnalisis = tipoAnalisis;
        this.fechaAnalisis = fechaAnalisis;
        this.resultado = resultado;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }

    public LocalDateTime getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(LocalDateTime fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
