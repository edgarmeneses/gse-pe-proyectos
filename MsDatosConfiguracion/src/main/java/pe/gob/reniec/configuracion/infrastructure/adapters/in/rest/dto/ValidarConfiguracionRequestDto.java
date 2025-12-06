package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

/**
 * DTO de petición - Validar configuración
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/validar
 */
public class ValidarConfiguracionRequestDto {

    private String clave;
    private Object valor;
    private ContextoDto contexto;
    private Boolean validarDependencias;

    public ValidarConfiguracionRequestDto() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public ContextoDto getContexto() {
        return contexto;
    }

    public void setContexto(ContextoDto contexto) {
        this.contexto = contexto;
    }

    public Boolean getValidarDependencias() {
        return validarDependencias;
    }

    public void setValidarDependencias(Boolean validarDependencias) {
        this.validarDependencias = validarDependencias;
    }

    public static class ContextoDto {
        private String ambiente;
        private String oficina;
        private String tipoTramite;

        public String getAmbiente() {
            return ambiente;
        }

        public void setAmbiente(String ambiente) {
            this.ambiente = ambiente;
        }

        public String getOficina() {
            return oficina;
        }

        public void setOficina(String oficina) {
            this.oficina = oficina;
        }

        public String getTipoTramite() {
            return tipoTramite;
        }

        public void setTipoTramite(String tipoTramite) {
            this.tipoTramite = tipoTramite;
        }
    }
}
