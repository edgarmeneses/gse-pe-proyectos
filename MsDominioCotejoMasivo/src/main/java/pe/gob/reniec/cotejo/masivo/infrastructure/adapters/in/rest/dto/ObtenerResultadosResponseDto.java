package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ObtenerResultadosResponseDto {
    private Boolean success;
    private ResultadosDataDto data;
    private MetadataDto metadata;

    public ObtenerResultadosResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ResultadosDataDto getData() {
        return data;
    }

    public void setData(ResultadosDataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
    
    public static class ResultadosDataDto {
        private List<ResultadoCotejoDto> resultados;
        private PaginacionDto paginacion;

        public ResultadosDataDto() {
        }

        public List<ResultadoCotejoDto> getResultados() {
            return resultados;
        }

        public void setResultados(List<ResultadoCotejoDto> resultados) {
            this.resultados = resultados;
        }

        public PaginacionDto getPaginacion() {
            return paginacion;
        }

        public void setPaginacion(PaginacionDto paginacion) {
            this.paginacion = paginacion;
        }
    }
    
    public static class ResultadoCotejoDto {
        private String resultadoId;
        private String registroEntradaId;
        private String codigoResultado;
        private String numeroDni;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String nombres;
        private String coincideDni;
        private String coincideApellidoPaterno;
        private String coincideApellidoMaterno;
        private String coincideNombres;
        private String mensajeObservacion;

        public ResultadoCotejoDto() {
        }

        public String getResultadoId() {
            return resultadoId;
        }

        public void setResultadoId(String resultadoId) {
            this.resultadoId = resultadoId;
        }

        public String getRegistroEntradaId() {
            return registroEntradaId;
        }

        public void setRegistroEntradaId(String registroEntradaId) {
            this.registroEntradaId = registroEntradaId;
        }

        public String getCodigoResultado() {
            return codigoResultado;
        }

        public void setCodigoResultado(String codigoResultado) {
            this.codigoResultado = codigoResultado;
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

        public String getCoincideDni() {
            return coincideDni;
        }

        public void setCoincideDni(String coincideDni) {
            this.coincideDni = coincideDni;
        }

        public String getCoincideApellidoPaterno() {
            return coincideApellidoPaterno;
        }

        public void setCoincideApellidoPaterno(String coincideApellidoPaterno) {
            this.coincideApellidoPaterno = coincideApellidoPaterno;
        }

        public String getCoincideApellidoMaterno() {
            return coincideApellidoMaterno;
        }

        public void setCoincideApellidoMaterno(String coincideApellidoMaterno) {
            this.coincideApellidoMaterno = coincideApellidoMaterno;
        }

        public String getCoincideNombres() {
            return coincideNombres;
        }

        public void setCoincideNombres(String coincideNombres) {
            this.coincideNombres = coincideNombres;
        }

        public String getMensajeObservacion() {
            return mensajeObservacion;
        }

        public void setMensajeObservacion(String mensajeObservacion) {
            this.mensajeObservacion = mensajeObservacion;
        }
    }
    
    public static class PaginacionDto {
        private Integer paginaActual;
        private Integer elementosPorPagina;
        private Long totalElementos;
        private Integer totalPaginas;

        public PaginacionDto() {
        }

        public Integer getPaginaActual() {
            return paginaActual;
        }

        public void setPaginaActual(Integer paginaActual) {
            this.paginaActual = paginaActual;
        }

        public Integer getElementosPorPagina() {
            return elementosPorPagina;
        }

        public void setElementosPorPagina(Integer elementosPorPagina) {
            this.elementosPorPagina = elementosPorPagina;
        }

        public Long getTotalElementos() {
            return totalElementos;
        }

        public void setTotalElementos(Long totalElementos) {
            this.totalElementos = totalElementos;
        }

        public Integer getTotalPaginas() {
            return totalPaginas;
        }

        public void setTotalPaginas(Integer totalPaginas) {
            this.totalPaginas = totalPaginas;
        }
    }
}
