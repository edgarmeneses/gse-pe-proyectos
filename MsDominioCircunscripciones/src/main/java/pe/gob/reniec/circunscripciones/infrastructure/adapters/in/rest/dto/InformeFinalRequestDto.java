package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto;

public class InformeFinalRequestDto {

    private String cronogramaId;
    private String tipoInforme;
    private CircunscripcionRequestDto circunscripcion;
    private Boolean incluirAnexos;
    private Boolean incluirDescargos;

    public InformeFinalRequestDto() {
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public CircunscripcionRequestDto getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(CircunscripcionRequestDto circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public Boolean getIncluirAnexos() {
        return incluirAnexos;
    }

    public void setIncluirAnexos(Boolean incluirAnexos) {
        this.incluirAnexos = incluirAnexos;
    }

    public Boolean getIncluirDescargos() {
        return incluirDescargos;
    }

    public void setIncluirDescargos(Boolean incluirDescargos) {
        this.incluirDescargos = incluirDescargos;
    }

    public static class CircunscripcionRequestDto {
        private String tipo;
        private String ubigeo;

        public CircunscripcionRequestDto() {
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getUbigeo() {
            return ubigeo;
        }

        public void setUbigeo(String ubigeo) {
            this.ubigeo = ubigeo;
        }
    }
}
