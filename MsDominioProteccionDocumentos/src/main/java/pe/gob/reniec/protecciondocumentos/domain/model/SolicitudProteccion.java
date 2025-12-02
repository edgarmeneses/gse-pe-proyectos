package pe.gob.reniec.protecciondocumentos.domain.model;

public class SolicitudProteccion {
    private String solicitudId;
    private String tipoDocumento;
    private String nombreArchivo;
    private FuenteDocumento fuenteDocumento;
    private MetadatosSolicitud metadatos;
    private ConfiguracionProteccion configuracionProteccion;
    private Destinatario destinatario;

    public SolicitudProteccion() {
    }

    public SolicitudProteccion(String solicitudId, String tipoDocumento, String nombreArchivo, 
                               FuenteDocumento fuenteDocumento, MetadatosSolicitud metadatos, 
                               ConfiguracionProteccion configuracionProteccion, Destinatario destinatario) {
        this.solicitudId = solicitudId;
        this.tipoDocumento = tipoDocumento;
        this.nombreArchivo = nombreArchivo;
        this.fuenteDocumento = fuenteDocumento;
        this.metadatos = metadatos;
        this.configuracionProteccion = configuracionProteccion;
        this.destinatario = destinatario;
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public FuenteDocumento getFuenteDocumento() {
        return fuenteDocumento;
    }

    public void setFuenteDocumento(FuenteDocumento fuenteDocumento) {
        this.fuenteDocumento = fuenteDocumento;
    }

    public MetadatosSolicitud getMetadatos() {
        return metadatos;
    }

    public void setMetadatos(MetadatosSolicitud metadatos) {
        this.metadatos = metadatos;
    }

    public ConfiguracionProteccion getConfiguracionProteccion() {
        return configuracionProteccion;
    }

    public void setConfiguracionProteccion(ConfiguracionProteccion configuracionProteccion) {
        this.configuracionProteccion = configuracionProteccion;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }
}
