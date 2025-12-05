package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto;

public class ValidacionPagoRequestDto {

    private String codigoOperacion;
    private String numeroSolicitud;
    private Double montoCobrar;
    private String moneda;
    private String fechaOperacion;
    private String tipoTramite;
    private MetadataDto metadata;

    public ValidacionPagoRequestDto() {
    }

    public ValidacionPagoRequestDto(String codigoOperacion, String numeroSolicitud, Double montoCobrar,
                                   String moneda, String fechaOperacion, String tipoTramite,
                                   MetadataDto metadata) {
        this.codigoOperacion = codigoOperacion;
        this.numeroSolicitud = numeroSolicitud;
        this.montoCobrar = montoCobrar;
        this.moneda = moneda;
        this.fechaOperacion = fechaOperacion;
        this.tipoTramite = tipoTramite;
        this.metadata = metadata;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public Double getMontoCobrar() {
        return montoCobrar;
    }

    public void setMontoCobrar(Double montoCobrar) {
        this.montoCobrar = montoCobrar;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
}
