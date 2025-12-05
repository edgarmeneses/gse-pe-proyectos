package pe.gob.reniec.circunscripciones.domain.model;

public class CircunscripcionAfectada {

    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;
    private Integer cantidadCambios;
    private Integer poblacionVerificar;
    private Double porcentajeCambio;
    private Boolean esAnomalia;
    private String prioridad;
    private Boolean tieneRAE;

    public CircunscripcionAfectada() {
    }

    public CircunscripcionAfectada(String ubigeo, String departamento, String provincia, String distrito,
                                   Integer cantidadCambios, Integer poblacionVerificar, Double porcentajeCambio,
                                   Boolean esAnomalia, String prioridad, Boolean tieneRAE) {
        this.ubigeo = ubigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.cantidadCambios = cantidadCambios;
        this.poblacionVerificar = poblacionVerificar;
        this.porcentajeCambio = porcentajeCambio;
        this.esAnomalia = esAnomalia;
        this.prioridad = prioridad;
        this.tieneRAE = tieneRAE;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getCantidadCambios() {
        return cantidadCambios;
    }

    public void setCantidadCambios(Integer cantidadCambios) {
        this.cantidadCambios = cantidadCambios;
    }

    public Integer getPoblacionVerificar() {
        return poblacionVerificar;
    }

    public void setPoblacionVerificar(Integer poblacionVerificar) {
        this.poblacionVerificar = poblacionVerificar;
    }

    public Double getPorcentajeCambio() {
        return porcentajeCambio;
    }

    public void setPorcentajeCambio(Double porcentajeCambio) {
        this.porcentajeCambio = porcentajeCambio;
    }

    public Boolean getEsAnomalia() {
        return esAnomalia;
    }

    public void setEsAnomalia(Boolean esAnomalia) {
        this.esAnomalia = esAnomalia;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Boolean getTieneRAE() {
        return tieneRAE;
    }

    public void setTieneRAE(Boolean tieneRAE) {
        this.tieneRAE = tieneRAE;
    }
}
