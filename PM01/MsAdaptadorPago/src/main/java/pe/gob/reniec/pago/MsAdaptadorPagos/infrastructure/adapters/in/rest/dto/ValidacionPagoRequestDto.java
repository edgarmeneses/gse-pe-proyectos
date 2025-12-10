package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

public class ValidacionPagoRequestDto {
    private String codigoOperacion;
    private String numeroSolicitud;
    private Double montoCobrar;
    private String moneda;
    private String fechaOperacion;
    private String tipoTramite;
    private String entidadBancaria;
    private MetadataDto metadata;
    private ConfiguracionRoutingDto configuracionRouting;

    public ValidacionPagoRequestDto() {}

    public String getCodigoOperacion() { return codigoOperacion; }
    public void setCodigoOperacion(String codigoOperacion) { this.codigoOperacion = codigoOperacion; }

    public String getNumeroSolicitud() { return numeroSolicitud; }
    public void setNumeroSolicitud(String numeroSolicitud) { this.numeroSolicitud = numeroSolicitud; }

    public Double getMontoCobrar() { return montoCobrar; }
    public void setMontoCobrar(Double montoCobrar) { this.montoCobrar = montoCobrar; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public String getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(String fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public String getTipoTramite() { return tipoTramite; }
    public void setTipoTramite(String tipoTramite) { this.tipoTramite = tipoTramite; }

    public String getEntidadBancaria() { return entidadBancaria; }
    public void setEntidadBancaria(String entidadBancaria) { this.entidadBancaria = entidadBancaria; }

    public MetadataDto getMetadata() { return metadata; }
    public void setMetadata(MetadataDto metadata) { this.metadata = metadata; }

    public ConfiguracionRoutingDto getConfiguracionRouting() { return configuracionRouting; }
    public void setConfiguracionRouting(ConfiguracionRoutingDto configuracionRouting) { this.configuracionRouting = configuracionRouting; }
}
