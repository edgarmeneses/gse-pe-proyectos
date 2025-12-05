package pe.gob.reniec.circunscripciones.domain.model;

public class DocumentoGenerado {

    private String nombreArchivo;
    private String formato;
    private Integer tamañoBytes;
    private String urlDescarga;
    private String checksum;
    private Boolean firmado;

    public DocumentoGenerado() {
    }

    public DocumentoGenerado(String nombreArchivo, String formato, Integer tamañoBytes,
                            String urlDescarga, String checksum, Boolean firmado) {
        this.nombreArchivo = nombreArchivo;
        this.formato = formato;
        this.tamañoBytes = tamañoBytes;
        this.urlDescarga = urlDescarga;
        this.checksum = checksum;
        this.firmado = firmado;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getTamañoBytes() {
        return tamañoBytes;
    }

    public void setTamañoBytes(Integer tamañoBytes) {
        this.tamañoBytes = tamañoBytes;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public Boolean getFirmado() {
        return firmado;
    }

    public void setFirmado(Boolean firmado) {
        this.firmado = firmado;
    }
}
