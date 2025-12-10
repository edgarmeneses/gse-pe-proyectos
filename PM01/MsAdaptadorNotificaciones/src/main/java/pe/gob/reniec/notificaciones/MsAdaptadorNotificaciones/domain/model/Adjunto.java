package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model;

public class Adjunto {
    private String nombre;
    private String contenidoBase64;
    private String mimeType;

    public Adjunto() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenidoBase64() {
        return contenidoBase64;
    }

    public void setContenidoBase64(String contenidoBase64) {
        this.contenidoBase64 = contenidoBase64;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
