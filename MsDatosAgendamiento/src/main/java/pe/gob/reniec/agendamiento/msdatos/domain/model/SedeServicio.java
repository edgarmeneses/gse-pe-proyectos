package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class SedeServicio {
    private String codigoSede;
    private String nombreSede;
    private String direccion;
    private String telefono;

    public SedeServicio() {
    }

    public SedeServicio(String codigoSede, String nombreSede, String direccion, String telefono) {
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
