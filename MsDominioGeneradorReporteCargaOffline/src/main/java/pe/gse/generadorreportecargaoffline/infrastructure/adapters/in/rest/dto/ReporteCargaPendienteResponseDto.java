package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Response: ReporteCargaPendienteResponseDto
 * Representa la respuesta con el reporte de solicitudes pendientes generado.
 */
public class ReporteCargaPendienteResponseDto {

    private ReporteCarguePendienteDto reporteCarguePendiente;
    private String reporteBase64;
    private String urlReporteRepositorio;

    public ReporteCargaPendienteResponseDto() {
    }

    public ReporteCargaPendienteResponseDto(ReporteCarguePendienteDto reporteCarguePendiente,
                                            String reporteBase64, String urlReporteRepositorio) {
        this.reporteCarguePendiente = reporteCarguePendiente;
        this.reporteBase64 = reporteBase64;
        this.urlReporteRepositorio = urlReporteRepositorio;
    }

    public ReporteCarguePendienteDto getReporteCarguePendiente() {
        return reporteCarguePendiente;
    }

    public void setReporteCarguePendiente(ReporteCarguePendienteDto reporteCarguePendiente) {
        this.reporteCarguePendiente = reporteCarguePendiente;
    }

    public String getReporteBase64() {
        return reporteBase64;
    }

    public void setReporteBase64(String reporteBase64) {
        this.reporteBase64 = reporteBase64;
    }

    public String getUrlReporteRepositorio() {
        return urlReporteRepositorio;
    }

    public void setUrlReporteRepositorio(String urlReporteRepositorio) {
        this.urlReporteRepositorio = urlReporteRepositorio;
    }

    public static class ReporteCarguePendienteDto {
        private String idReportePendiente;
        private Integer cantidadTramitesGestionados;
        private EstadoReporteDto estadoReporte;
        private MetadataDto metadata;

        public ReporteCarguePendienteDto() {
        }

        public ReporteCarguePendienteDto(String idReportePendiente, Integer cantidadTramitesGestionados,
                                         EstadoReporteDto estadoReporte, MetadataDto metadata) {
            this.idReportePendiente = idReportePendiente;
            this.cantidadTramitesGestionados = cantidadTramitesGestionados;
            this.estadoReporte = estadoReporte;
            this.metadata = metadata;
        }

        public String getIdReportePendiente() {
            return idReportePendiente;
        }

        public void setIdReportePendiente(String idReportePendiente) {
            this.idReportePendiente = idReportePendiente;
        }

        public Integer getCantidadTramitesGestionados() {
            return cantidadTramitesGestionados;
        }

        public void setCantidadTramitesGestionados(Integer cantidadTramitesGestionados) {
            this.cantidadTramitesGestionados = cantidadTramitesGestionados;
        }

        public EstadoReporteDto getEstadoReporte() {
            return estadoReporte;
        }

        public void setEstadoReporte(EstadoReporteDto estadoReporte) {
            this.estadoReporte = estadoReporte;
        }

        public MetadataDto getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataDto metadata) {
            this.metadata = metadata;
        }
    }

    public static class EstadoReporteDto {
        private List<String> value;

        public EstadoReporteDto() {
        }

        public EstadoReporteDto(List<String> value) {
            this.value = value;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }

    public static class MetadataDto {
        private String timestamp;
        private String correlationId;
        private String version;

        public MetadataDto() {
        }

        public MetadataDto(String timestamp, String correlationId, String version) {
            this.timestamp = timestamp;
            this.correlationId = correlationId;
            this.version = version;
        }

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
