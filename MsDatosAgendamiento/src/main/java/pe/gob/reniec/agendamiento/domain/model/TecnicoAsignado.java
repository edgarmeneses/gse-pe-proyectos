package pe.gob.reniec.agendamiento.domain.model;

public class TecnicoAsignado {
    private String idTecnico;
    private String nombreCompleto;

    public TecnicoAsignado() {
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
