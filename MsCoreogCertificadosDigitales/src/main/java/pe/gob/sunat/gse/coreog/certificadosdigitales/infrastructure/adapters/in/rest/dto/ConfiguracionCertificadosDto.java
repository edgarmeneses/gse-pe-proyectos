package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para configuración de certificados
 */
public class ConfiguracionCertificadosDto {
    
    private List<String> tipoCertificados;
    private Integer vigenciaAnios;
    private Boolean usoExtendido;
    private String nivelSeguridad;
    
    public ConfiguracionCertificadosDto() {
    }
    
    public List<String> getTipoCertificados() {
        return tipoCertificados;
    }
    
    public void setTipoCertificados(List<String> tipoCertificados) {
        this.tipoCertificados = tipoCertificados;
    }
    
    public Integer getVigenciaAnios() {
        return vigenciaAnios;
    }
    
    public void setVigenciaAnios(Integer vigenciaAnios) {
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
