package pe.gob.reniec.adaptadorbanconacion.domain.model;

import java.time.LocalDateTime;

public class Auditoria {

    private LocalDateTime timestampConsulta;
    private Integer tiempoRespuestaMs;
    private String ipOrigen;
    private String usuarioConsulta;
    private Integer intentosRealizados;

    public Auditoria() {
    }

    public Auditoria(LocalDateTime timestampConsulta, Integer tiempoRespuestaMs, String ipOrigen,
                    String usuarioConsulta, Integer intentosRealizados) {
        this.timestampConsulta = timestampConsulta;
        this.tiempoRespuestaMs = tiempoRespuestaMs;
        this.ipOrigen = ipOrigen;
        this.usuarioConsulta = usuarioConsulta;
        this.intentosRealizados = intentosRealizados;
    }

    public LocalDateTime getTimestampConsulta() {
        return timestampConsulta;
    }

    public void setTimestampConsulta(LocalDateTime timestampConsulta) {
        this.timestampConsulta = timestampConsulta;
    }

    public Integer getTiempoRespuestaMs() {
        return tiempoRespuestaMs;
    }

    public void setTiempoRespuestaMs(Integer tiempoRespuestaMs) {
        this.tiempoRespuestaMs = tiempoRespuestaMs;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    public String getUsuarioConsulta() {
        return usuarioConsulta;
    }

    public void setUsuarioConsulta(String usuarioConsulta) {
        this.usuarioConsulta = usuarioConsulta;
    }

    public Integer getIntentosRealizados() {
        return intentosRealizados;
    }

    public void setIntentosRealizados(Integer intentosRealizados) {
        this.intentosRealizados = intentosRealizados;
    }
}
