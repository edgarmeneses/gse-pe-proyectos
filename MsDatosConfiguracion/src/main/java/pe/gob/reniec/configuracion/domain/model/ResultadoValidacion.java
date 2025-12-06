package pe.gob.reniec.configuracion.domain.model;

import java.util.List;

/**
 * Value Object - Resultado de validación de configuración
 */
public class ResultadoValidacion {

    private Boolean esValido;
    private Validaciones validaciones;
    private List<String> advertencias;

    public ResultadoValidacion() {
    }

    public Boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(Boolean esValido) {
        this.esValido = esValido;
    }

    public Validaciones getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(Validaciones validaciones) {
        this.validaciones = validaciones;
    }

    public List<String> getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(List<String> advertencias) {
        this.advertencias = advertencias;
    }

    /**
     * Value Object - Detalle de validaciones realizadas
     */
    public static class Validaciones {
        private String tipoDato;
        private String rangoValor;
        private String formatoEstructura;
        private String dependenciasIntegridad;

        public Validaciones() {
        }

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
