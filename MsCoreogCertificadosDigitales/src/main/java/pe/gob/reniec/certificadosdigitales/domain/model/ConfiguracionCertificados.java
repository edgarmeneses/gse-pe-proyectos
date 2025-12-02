package pe.gob.reniec.certificadosdigitales.domain.model;

import java.util.List;

public class ConfiguracionCertificados {
    private List<String> tipoCertificados;
    private Long vigenciaAnios;
    private Boolean usoExtendido;
    private String nivelSeguridad;

    public ConfiguracionCertificados() {
    }

    public ConfiguracionCertificados(List<String> tipoCertificados, Long vigenciaAnios, Boolean usoExtendido, String nivelSeguridad) {
        this.tipoCertificados = tipoCertificados;
        this.vigenciaAnios = vigenciaAnios;
        this.usoExtendido = usoExtendido;
        this.nivelSeguridad = nivelSeguridad;
    }

    public List<String> getTipoCertificados() {
        return tipoCertificados;
    }

    public void setTipoCertificados(List<String> tipoCertificados) {
        this.tipoCertificados = tipoCertificados;
    }

    public Long getVigenciaAnios() {
        return vigenciaAnios;
    }

    public void setVigenciaAnios(Long vigenciaAnios) {
        this.vigenciaAnios = vigenciaAnios;
    }

    public Boolean getUsoExtendido() {
        return usoExtendido;
    }

    public void setUsoExtendido(Boolean usoExtendido) {
        this.usoExtendido = usoExtendido;
    }

    public String getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(String nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }
}
