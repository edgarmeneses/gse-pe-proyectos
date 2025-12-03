package pe.gob.reniec.protecciondocumentos.domain.model;

public class Documento {
    private String documentoId;
    private String nombre;
    private TipoDocumento tipo;
    private Long tamanioBytes;
    private String formato;
    private Metadatos metadatos;

    public Documento() {
    }

    public Documento(String documentoId, String nombre, TipoDocumento tipo, Long tamanioBytes, 
                    String formato, Metadatos metadatos) {
        this.documentoId = documentoId;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamanioBytes = tamanioBytes;
        this.formato = formato;
        this.metadatos = metadatos;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public Long getTamanioBytes() {
        return tamanioBytes;
    }

    public void setTamanioBytes(Long tamanioBytes) {
        this.tamanioBytes = tamanioBytes;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Metadatos getMetadatos() {
        return metadatos;
    }

    public void setMetadatos(Metadatos metadatos) {
        this.metadatos = metadatos;
    }
}
