package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class AnalisisCircunscripcionRequestDto {

    private String cronogramaId;
    private String tipoProceso;
    private String fechaInicio;
    private String fechaFin;
    private List<String> departamentos;
    private List<String> provincias;
    private List<String> distritos;
    private Double umbralAnomalia;
    private Boolean incluirRAE;
    private String modoAnalisis;

    public AnalisisCircunscripcionRequestDto() {
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<String> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<String> departamentos) {
        this.departamentos = departamentos;
    }

    public List<String> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<String> provincias) {
        this.provincias = provincias;
    }

    public List<String> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<String> distritos) {
        this.distritos = distritos;
    }

    public Double getUmbralAnomalia() {
        return umbralAnomalia;
    }

    public void setUmbralAnomalia(Double umbralAnomalia) {
        this.umbralAnomalia = umbralAnomalia;
    }

    public Boolean getIncluirRAE() {
        return incluirRAE;
    }

    public void setIncluirRAE(Boolean incluirRAE) {
        this.incluirRAE = incluirRAE;
    }

    public String getModoAnalisis() {
        return modoAnalisis;
    }

    public void setModoAnalisis(String modoAnalisis) {
        this.modoAnalisis = modoAnalisis;
    }
}
