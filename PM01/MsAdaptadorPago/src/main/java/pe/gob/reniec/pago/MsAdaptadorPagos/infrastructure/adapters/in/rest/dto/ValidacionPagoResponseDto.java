package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class ValidacionPagoResponseDto {
    private String routingId;
    private String codigoOperacion;
    private String numeroSolicitud;
    private String entidadBancariaIdentificada;
    private String adaptadorUtilizado;
    private Boolean validacionExitosa;
    private DetalleResultadoValidacionDto resultadoValidacion;
    private DetalleRoutingDto routing;
    private AuditoriaInfoDto auditoria;

    public ValidacionPagoResponseDto() {}

    public String getRoutingId() { return routingId; }
    public void setRoutingId(String routingId) { this.routingId = routingId; }

    public String getCodigoOperacion() { return codigoOperacion; }
    public void setCodigoOperacion(String codigoOperacion) { this.codigoOperacion = codigoOperacion; }

    public String getNumeroSolicitud() { return numeroSolicitud; }
    public void setNumeroSolicitud(String numeroSolicitud) { this.numeroSolicitud = numeroSolicitud; }

    public String getEntidadBancariaIdentificada() { return entidadBancariaIdentificada; }
    public void setEntidadBancariaIdentificada(String entidadBancariaIdentificada) { this.entidadBancariaIdentificada = entidadBancariaIdentificada; }

    public String getAdaptadorUtilizado() { return adaptadorUtilizado; }
    public void setAdaptadorUtilizado(String adaptadorUtilizado) { this.adaptadorUtilizado = adaptadorUtilizado; }

    public Boolean getValidacionExitosa() { return validacionExitosa; }
    public void setValidacionExitosa(Boolean validacionExitosa) { this.validacionExitosa = validacionExitosa; }

    public DetalleResultadoValidacionDto getResultadoValidacion() { return resultadoValidacion; }
    public void setResultadoValidacion(DetalleResultadoValidacionDto resultadoValidacion) { this.resultadoValidacion = resultadoValidacion; }

    public DetalleRoutingDto getRouting() { return routing; }
    public void setRouting(DetalleRoutingDto routing) { this.routing = routing; }

    public AuditoriaInfoDto getAuditoria() { return auditoria; }
    public void setAuditoria(AuditoriaInfoDto auditoria) { this.auditoria = auditoria; }
}
