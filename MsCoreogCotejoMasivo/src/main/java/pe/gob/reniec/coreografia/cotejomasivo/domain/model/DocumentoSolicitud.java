package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Documento adjunto a la solicitud de cotejo masivo
 */
public class DocumentoSolicitud {
    
    private String tipo;
    private String nombre;
    private String urlDocumento;
    private String hashDocumento;
    
    public DocumentoSolicitud() {
    }
    
    public DocumentoSolicitud(String tipo, String nombre, String urlDocumento, String hashDocumento) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.urlDocumento = urlDocumento;
        this.hashDocumento = hashDocumento;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getUrlDocumento() {
        return urlDocumento;
    }
    
    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }
    
    public String getHashDocumento() {
        return hashDocumento;
    }
    
    public void setHashDocumento(String hashDocumento) {
        this.hashDocumento = hashDocumento;
    }
}
