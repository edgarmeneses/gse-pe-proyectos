package pe.gob.reniec.agendamiento.domain.model;

public class SedeServicio {
    private String codigoSede;
    private String nombreSede;
    private String direccion;
    private String telefono;
    private Long capacidadDiariaMaxima;
    private Long tiempoAtencionMinutos;

    public SedeServicio() {
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

    public Long getCapacidadDiariaMaxima() {
        return capacidadDiariaMaxima;
    }

    public void setCapacidadDiariaMaxima(Long capacidadDiariaMaxima) {
        this.capacidadDiariaMaxima = capacidadDiariaMaxima;
    }

    public Long getTiempoAtencionMinutos() {
        return tiempoAtencionMinutos;
    }

    public void setTiempoAtencionMinutos(Long tiempoAtencionMinutos) {
        this.tiempoAtencionMinutos = tiempoAtencionMinutos;
    }
}
