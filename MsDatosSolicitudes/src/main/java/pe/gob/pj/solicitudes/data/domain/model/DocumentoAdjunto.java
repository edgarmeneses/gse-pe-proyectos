package pe.gob.pj.solicitudes.data.domain.model;

public class DocumentoAdjunto {
    
    private String tipo;
    private String nombre;
    private Long tamanioBytes;
    private String mimeType;
    private String checksum;

    public DocumentoAdjunto() {
    }

    public DocumentoAdjunto(String tipo, String nombre, Long tamanioBytes, String mimeType, String checksum) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.tamanioBytes = tamanioBytes;
        this.mimeType = mimeType;
        this.checksum = checksum;
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

    public Long getTamanioBytes() {
        return tamanioBytes;
    }

    public void setTamanioBytes(Long tamanioBytes) {
        this.tamanioBytes = tamanioBytes;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
