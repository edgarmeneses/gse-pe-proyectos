package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Documento de Solicitud
 */
public class DocumentoSolicitudDto {
    
    private String tipo;
    private String nombre;
    private String urlDocumento;
    private String hashDocumento;
    
    public DocumentoSolicitudDto() {
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
