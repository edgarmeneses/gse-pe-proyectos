package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseDto {
    private Boolean success;
    private LocalDateTime timestamp;
    private ErrorDetalleDto error;
    private MetadataRespuestaDto metadata;

    public ErrorResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorDetalleDto getError() {
        return error;
    }

    public void setError(ErrorDetalleDto error) {
        this.error = error;
    }

    public MetadataRespuestaDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataRespuestaDto metadata) {
        this.metadata = metadata;
    }

    public static class ErrorDetalleDto {
        private String codigo;
        private String mensaje;
        private List<ErrorItemDto> detalles;

        public ErrorDetalleDto() {
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public List<ErrorItemDto> getDetalles() {
            return detalles;
        }

        public void setDetalles(List<ErrorItemDto> detalles) {
            this.detalles = detalles;
        }
    }

    public static class ErrorItemDto {
        private String campo;
        private String descripcion;
        private String valorRecibido;

        public ErrorItemDto() {
        }

        public String getCampo() {
            return campo;
        }

        public void setCampo(String campo) {
            this.campo = campo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getValorRecibido() {
            return valorRecibido;
        }

        public void setValorRecibido(String valorRecibido) {
            this.valorRecibido = valorRecibido;
        }
    }

    public static class MetadataRespuestaDto {
        private String version;
        private String requestId;
        private String correlationId;

        public MetadataRespuestaDto() {
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getCorrelationId() {
            return correlationId;
        }

        public void setCorrelationId(String correlationId) {
            this.correlationId = correlationId;
        }
    }
}
