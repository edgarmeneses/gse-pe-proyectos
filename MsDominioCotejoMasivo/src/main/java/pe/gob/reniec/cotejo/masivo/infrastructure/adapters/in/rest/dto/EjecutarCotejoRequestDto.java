package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class EjecutarCotejoRequestDto {
    private String solicitudId;
    private String codigoOrganizacion;
    private String nombreOrganizacion;
    private String codigoEnvio;
    private String numeroLote;
    private String documentoSustento;
    private String observaciones;
    private String indicadorDomicilio;
    private String codigoPrograma;
    private List<RegistroEntradaDto> registros;

    public EjecutarCotejoRequestDto() {
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getCodigoOrganizacion() {
        return codigoOrganizacion;
    }

    public void setCodigoOrganizacion(String codigoOrganizacion) {
        this.codigoOrganizacion = codigoOrganizacion;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getCodigoEnvio() {
        return codigoEnvio;
    }

    public void setCodigoEnvio(String codigoEnvio) {
        this.codigoEnvio = codigoEnvio;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getDocumentoSustento() {
        return documentoSustento;
    }

    public void setDocumentoSustento(String documentoSustento) {
        this.documentoSustento = documentoSustento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIndicadorDomicilio() {
        return indicadorDomicilio;
    }

    public void setIndicadorDomicilio(String indicadorDomicilio) {
        this.indicadorDomicilio = indicadorDomicilio;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public List<RegistroEntradaDto> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroEntradaDto> registros) {
        this.registros = registros;
    }
}
