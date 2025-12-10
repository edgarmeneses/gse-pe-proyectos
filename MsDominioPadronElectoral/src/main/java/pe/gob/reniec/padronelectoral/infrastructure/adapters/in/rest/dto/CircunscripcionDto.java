package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

public class CircunscripcionDto {
    private EstructuraDto estructura;

    public CircunscripcionDto() {
    }

    public EstructuraDto getEstructura() {
        return estructura;
    }

    public void setEstructura(EstructuraDto estructura) {
        this.estructura = estructura;
    }

    public static class EstructuraDto {
        private String departamento;
        private String provincia;
        private String distrito;

        public EstructuraDto() {
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
    }
}
