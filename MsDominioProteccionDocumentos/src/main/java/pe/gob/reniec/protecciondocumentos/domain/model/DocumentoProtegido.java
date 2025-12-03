package pe.gob.reniec.protecciondocumentos.domain.model;

public class DocumentoProtegido {
    private String documentoId;
    private String documentoOriginalId;
    private String nombre;
    private Compresion compresion;
    private Cifrado cifrado;
    private String ubicacionAlmacenamiento;

    public DocumentoProtegido() {
    }

    public DocumentoProtegido(String documentoId, String documentoOriginalId, String nombre, 
                             Compresion compresion, Cifrado cifrado, String ubicacionAlmacenamiento) {
        this.documentoId = documentoId;
        this.documentoOriginalId = documentoOriginalId;
        this.nombre = nombre;
        this.compresion = compresion;
        this.cifrado = cifrado;
        this.ubicacionAlmacenamiento = ubicacionAlmacenamiento;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getDocumentoOriginalId() {
        return documentoOriginalId;
    }

    public void setDocumentoOriginalId(String documentoOriginalId) {
        this.documentoOriginalId = documentoOriginalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Compresion getCompresion() {
        return compresion;
    }

    public void setCompresion(Compresion compresion) {
        this.compresion = compresion;
    }

    public Cifrado getCifrado() {
        return cifrado;
    }

    public void setCifrado(Cifrado cifrado) {
        this.cifrado = cifrado;
    }

    public String getUbicacionAlmacenamiento() {
        return ubicacionAlmacenamiento;
    }

    public void setUbicacionAlmacenamiento(String ubicacionAlmacenamiento) {
        this.ubicacionAlmacenamiento = ubicacionAlmacenamiento;
    }
}
