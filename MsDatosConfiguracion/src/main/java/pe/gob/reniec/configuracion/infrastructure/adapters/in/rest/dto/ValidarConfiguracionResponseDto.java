package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta - Validar configuración
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/validar
 */
public class ValidarConfiguracionResponseDto {

    private Boolean esValido;
    private ValidacionesDto validaciones;
    private List<String> advertencias;

    public ValidarConfiguracionResponseDto() {
    }

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }

    public ValidacionesDto getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ValidacionesDto validaciones) {
        this.validaciones = validaciones;
    }

    public List<String> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(List<String> advertencias) {
        this.advertencias = advertencias;
    }

    public static class ValidacionesDto {
        private String tipoDato;
        private String rangoValor;
        private String formatoEstructura;
        private String dependenciasIntegridad;

        public String getTipoDato() {
            return tipoDato;
        }

        public void setTipoDato(String tipoDato) {
            this.tipoDato = tipoDato;
        }

        public String getRangoValor() {
            return rangoValor;
        }

        public void setRangoValor(String rangoValor) {
            this.rangoValor = rangoValor;
        }

        public String getFormatoEstructura() {
            return formatoEstructura;
        }

        public void setFormatoEstructura(String formatoEstructura) {
            this.formatoEstructura = formatoEstructura;
        }

        public String getDependenciasIntegridad() {
            return dependenciasIntegridad;
        }

        public void setDependenciasIntegridad(String dependenciasIntegridad) {
            this.dependenciasIntegridad = dependenciasIntegridad;
        }
    }
}
