package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class AuditoriaInfoDto {
    private String timestampInicio;
    private String timestampFin;
    private String ipOrigen;
    private String usuarioSolicitante;
    private String oficinaSolicitante;

    public AuditoriaInfoDto() {}

    public String getTimestampInicio() { return timestampInicio; }
    public void setTimestampInicio(String timestampInicio) { this.timestampInicio = timestampInicio; }

    public String getTimestampFin() { return timestampFin; }
    public void setTimestampFin(String timestampFin) { this.timestampFin = timestampFin; }

    public String getIpOrigen() { return ipOrigen; }
    public void setIpOrigen(String ipOrigen) { this.ipOrigen = ipOrigen; }

    public String getUsuarioSolicitante() { return usuarioSolicitante; }
    public void setUsuarioSolicitante(String usuarioSolicitante) { this.usuarioSolicitante = usuarioSolicitante; }

    public String getOficinaSolicitante() { return oficinaSolicitante; }
    public void setOficinaSolicitante(String oficinaSolicitante) { this.oficinaSolicitante = oficinaSolicitante; }
}
