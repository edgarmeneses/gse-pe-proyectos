package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

import java.time.LocalDateTime;

public class AuditoriaInfo {
    private LocalDateTime timestampInicio;
    private LocalDateTime timestampFin;
    private String ipOrigen;
    private String usuarioSolicitante;
    private String oficinaSolicitante;

    public AuditoriaInfo() {}

    public LocalDateTime getTimestampInicio() { return timestampInicio; }
    public void setTimestampInicio(LocalDateTime timestampInicio) { this.timestampInicio = timestampInicio; }

    public LocalDateTime getTimestampFin() { return timestampFin; }
    public void setTimestampFin(LocalDateTime timestampFin) { this.timestampFin = timestampFin; }

    public String getIpOrigen() { return ipOrigen; }
    public void setIpOrigen(String ipOrigen) { this.ipOrigen = ipOrigen; }

    public String getUsuarioSolicitante() { return usuarioSolicitante; }
    public void setUsuarioSolicitante(String usuarioSolicitante) { this.usuarioSolicitante = usuarioSolicitante; }

    public String getOficinaSolicitante() { return oficinaSolicitante; }
    public void setOficinaSolicitante(String oficinaSolicitante) { this.oficinaSolicitante = oficinaSolicitante; }
}
