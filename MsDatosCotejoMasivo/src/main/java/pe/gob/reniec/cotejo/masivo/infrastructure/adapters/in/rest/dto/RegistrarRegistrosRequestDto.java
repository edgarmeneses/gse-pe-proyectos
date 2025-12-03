package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class RegistrarRegistrosRequestDto {
    private List<RegistroDto> registros;

    public RegistrarRegistrosRequestDto() {
    }

    public List<RegistroDto> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroDto> registros) {
        this.registros = registros;
    }

    public static class RegistroDto {
        private Long numeroSecuencia;
        private String numeroDni;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String nombres;
        private String fechaNacimiento;
        private String indicadorSexo;
        private String identificadorInstitucion;
        private Object datosAdicionales;

        public RegistroDto() {
        }

        public Long getNumeroSecuencia() {
            return numeroSecuencia;
        }

        public void setNumeroSecuencia(Long numeroSecuencia) {
            this.numeroSecuencia = numeroSecuencia;
        }

        public String getNumeroDni() {
            return numeroDni;
        }

        public void setNumeroDni(String numeroDni) {
            this.numeroDni = numeroDni;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getApellidoMaterno() {
            return apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getIndicadorSexo() {
            return indicadorSexo;
        }

        public void setIndicadorSexo(String indicadorSexo) {
            this.indicadorSexo = indicadorSexo;
        }

        public String getIdentificadorInstitucion() {
            return identificadorInstitucion;
        }

        public void setIdentificadorInstitucion(String identificadorInstitucion) {
            this.identificadorInstitucion = identificadorInstitucion;
        }

        public Object getDatosAdicionales() {
            return datosAdicionales;
        }

        public void setDatosAdicionales(Object datosAdicionales) {
            this.datosAdicionales = datosAdicionales;
        }
    }
}
