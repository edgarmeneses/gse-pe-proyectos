package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto;

public class AuditoriaDto {

    private String timestampConsulta;
    private Integer tiempoRespuestaMs;
    private String ipOrigen;
    private String usuarioConsulta;
    private Integer intentosRealizados;

    public AuditoriaDto() {
    }

    public AuditoriaDto(String timestampConsulta, Integer tiempoRespuestaMs, String ipOrigen,
                       String usuarioConsulta, Integer intentosRealizados) {
        this.timestampConsulta = timestampConsulta;
        this.tiempoRespuestaMs = tiempoRespuestaMs;
        this.ipOrigen = ipOrigen;
        this.usuarioConsulta = usuarioConsulta;
        this.intentosRealizados = intentosRealizados;
    }

    public String getTimestampConsulta() {
        return timestampConsulta;
    }

    public void setTimestampConsulta(String timestampConsulta) {
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
