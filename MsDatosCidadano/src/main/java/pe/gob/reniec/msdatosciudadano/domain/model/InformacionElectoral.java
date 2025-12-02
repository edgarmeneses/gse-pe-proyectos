package pe.gob.reniec.msdatosciudadano.domain.model;

public class InformacionElectoral {
    private Boolean inscritoVotacion;
    private String departamentoVotacion;
    private String provinciaVotacion;
    private String distritoVotacion;
    private String lugarVotacion;

    public InformacionElectoral() {
    }

    public InformacionElectoral(Boolean inscritoVotacion, String departamentoVotacion, String provinciaVotacion,
                               String distritoVotacion, String lugarVotacion) {
        this.inscritoVotacion = inscritoVotacion;
        this.departamentoVotacion = departamentoVotacion;
        this.provinciaVotacion = provinciaVotacion;
        this.distritoVotacion = distritoVotacion;
        this.lugarVotacion = lugarVotacion;
    }

    public Boolean getInscritoVotacion() {
        return inscritoVotacion;
    }

    public void setInscritoVotacion(Boolean inscritoVotacion) {
        this.inscritoVotacion = inscritoVotacion;
    }

    public String getDepartamentoVotacion() {
        return departamentoVotacion;
    }

    public void setDepartamentoVotacion(String departamentoVotacion) {
        this.departamentoVotacion = departamentoVotacion;
    }

    public String getProvinciaVotacion() {
        return provinciaVotacion;
    }

    public void setProvinciaVotacion(String provinciaVotacion) {
        this.provinciaVotacion = provinciaVotacion;
    }

    public String getDistritoVotacion() {
        return distritoVotacion;
    }

    public void setDistritoVotacion(String distritoVotacion) {
        this.distritoVotacion = distritoVotacion;
    }

    public String getLugarVotacion() {
        return lugarVotacion;
    }

    public void setLugarVotacion(String lugarVotacion) {
        this.lugarVotacion = lugarVotacion;
    }
}
