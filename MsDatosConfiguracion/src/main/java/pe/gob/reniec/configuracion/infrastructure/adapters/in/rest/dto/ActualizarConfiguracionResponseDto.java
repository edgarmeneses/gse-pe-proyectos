package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta - Actualizar configuración
 * Endpoint: PUT /api/v1/configuracion/MsDatosConfiguracion/{clave}
 */
public class ActualizarConfiguracionResponseDto {

    private BodyDto body;

    public ActualizarConfiguracionResponseDto() {
    }

    public BodyDto getBody() {
        return body;
    }

    public void setBody(BodyDto body) {
        this.body = body;
    }

    public static class BodyDto {
        private String categoria;
        private Integer totalConfiguraciones;
        private List<ConfiguracionDto> configuraciones;
        private MetadataDto metadata;

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public Integer getTotalConfiguraciones() {
            return totalConfiguraciones;
        }

        public void setTotalConfiguraciones(Integer totalConfiguraciones) {
            this.totalConfiguraciones = totalConfiguraciones;
        }

        public List<ConfiguracionDto> getConfiguraciones() {
            return configuraciones;
        }

        public void setConfiguraciones(List<ConfiguracionDto> configuraciones) {
            this.configuraciones = configuraciones;
        }

        public MetadataDto getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataDto metadata) {
            this.metadata = metadata;
        }
    }

    public static class ConfiguracionDto {
        private String clave;
        private Object valor;
        private String tipoDato;
        private String unidad;
        private String descripcion;
        private Integer version;
        private String estado;

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

        public String getTipoDato() {
            return tipoDato;
        }

        public void setTipoDato(String tipoDato) {
            this.tipoDato = tipoDato;
        }

        public String getUnidad() {
            return unidad;
        }

        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }

    public static class MetadataDto {
        private String timestamp;
        private String correlationId;
        private String version;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getCorrelationId() {
            return correlationId;
        }

        public void setCorrelationId(String correlationId) {
            this.correlationId = correlationId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
