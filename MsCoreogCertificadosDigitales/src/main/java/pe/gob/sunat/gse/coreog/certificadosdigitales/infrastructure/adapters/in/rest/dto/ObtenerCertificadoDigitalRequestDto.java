package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO de entrada principal para el endpoint Obtener Certificado Digital
 */
public class ObtenerCertificadoDigitalRequestDto {
    
    private SolicitudDto solicitud;
    private CiudadanoDto ciudadano;
    private ConfiguracionCertificadosDto configuracionCertificados;
    private MetadatosDto metadatos;
    
    public ObtenerCertificadoDigitalRequestDto() {
    }
    
    public SolicitudDto getSolicitud() {
        return solicitud;
    }
    
    public void setSolicitud(SolicitudDto solicitud) {
        this.solicitud = solicitud;
    }
    
    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }
    
    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public ConfiguracionCertificadosDto getConfiguracionCertificados() {
        return configuracionCertificados;
    }
    
    public void setConfiguracionCertificados(ConfiguracionCertificadosDto configuracionCertificados) {
        this.configuracionCertificados = configuracionCertificados;
    }
    
    public MetadatosDto getMetadatos() {
        return metadatos;
    }
    
    public void setMetadatos(MetadatosDto metadatos) {
        this.metadatos = metadatos;
    }
}
