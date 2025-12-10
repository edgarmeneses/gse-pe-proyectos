package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Response exitoso para consultas de certificados de defunción
 */
public class ConsultaCertificadoResponseDto {

    private Boolean success;
    private String statusCode;
    private String message;
    private DataDto data;
    private MetadataDto metadata;

    public ConsultaCertificadoResponseDto() {
    }

    public ConsultaCertificadoResponseDto(Boolean success, String statusCode, String message, 
                                         DataDto data, MetadataDto metadata) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDto getData() {
        return data;
    }

    public void setData(DataDto data) {
        this.data = data;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

    /**
     * Clase interna: Contenedor de certificados
     */
    public static class DataDto {
        private List<CertificadoDefuncionDto> certificados;

        public DataDto() {
        }

        public DataDto(List<CertificadoDefuncionDto> certificados) {
            this.certificados = certificados;
        }

        public List<CertificadoDefuncionDto> getCertificados() {
            return certificados;
        }

        public void setCertificados(List<CertificadoDefuncionDto> certificados) {
            this.certificados = certificados;
        }
    }
}
