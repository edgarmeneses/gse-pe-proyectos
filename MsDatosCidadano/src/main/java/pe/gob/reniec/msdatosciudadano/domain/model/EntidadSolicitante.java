package pe.gob.reniec.msdatosciudadano.domain.model;

public class EntidadSolicitante {
    private String ruc;
    private String razonSocial;
    private String tipoEntidad;

    public EntidadSolicitante() {
    }

    public EntidadSolicitante(String ruc, String razonSocial, String tipoEntidad) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.tipoEntidad = tipoEntidad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}
