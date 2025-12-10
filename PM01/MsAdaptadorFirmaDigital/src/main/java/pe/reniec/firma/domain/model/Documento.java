package pe.reniec.firma.domain.model;

public class Documento {
    private String nombre;
    private String tipoDocumento;
    private String contenidoBase64;
    private String hashSHA256;
    private Integer tamanoBytes;

    public Documento() {}

    public Documento(String nombre, String tipoDocumento, String contenidoBase64, String hashSHA256, Integer tamanoBytes) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.contenidoBase64 = contenidoBase64;
        this.hashSHA256 = hashSHA256;
        this.tamanoBytes = tamanoBytes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getContenidoBase64() {
        return contenidoBase64;
    }

    public void setContenidoBase64(String contenidoBase64) {
        this.contenidoBase64 = contenidoBase64;
    }

    public String getHashSHA256() {
        return hashSHA256;
    }

    public void setHashSHA256(String hashSHA256) {
        this.hashSHA256 = hashSHA256;
    }

    public Integer getTamanoBytes() {
        return tamanoBytes;
    }

    public void setTamanoBytes(Integer tamanoBytes) {
        this.tamanoBytes = tamanoBytes;
    }
}
