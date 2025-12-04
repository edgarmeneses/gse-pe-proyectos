package pe.gob.onpe.datos.electoral.domain.model;

import java.time.LocalDateTime;

public class InformeFinal {
    private Long id;
    private String numeroInforme;
    private LocalDateTime fechaEmision;
    private String contenido;
    private String conclusiones;
    private String estado;

    public InformeFinal() {
    }

    public InformeFinal(Long id, String numeroInforme, LocalDateTime fechaEmision, 
                        String contenido, String conclusiones, String estado) {
        this.id = id;
        this.numeroInforme = numeroInforme;
        this.fechaEmision = fechaEmision;
        this.contenido = contenido;
        this.conclusiones = conclusiones;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroInforme() {
        return numeroInforme;
    }

    public void setNumeroInforme(String numeroInforme) {
        this.numeroInforme = numeroInforme;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
