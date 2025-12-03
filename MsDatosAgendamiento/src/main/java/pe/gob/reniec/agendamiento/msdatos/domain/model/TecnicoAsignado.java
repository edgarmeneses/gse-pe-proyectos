package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class TecnicoAsignado {
    private String idTecnico;
    private String nombreCompleto;

    public TecnicoAsignado() {
    }

    public TecnicoAsignado(String idTecnico, String nombreCompleto) {
        this.idTecnico = idTecnico;
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
