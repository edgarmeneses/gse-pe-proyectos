package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de Response: ReporteCargaResponseDto
 * Representa la respuesta con el reporte de carga generado.
 */
public class ReporteCargaResponseDto {

    private ReporteCargueDto reporteCargue;
    private String reporteBase64;
    private String urlReporteRepositorio;

    public ReporteCargaResponseDto() {
    }

    public ReporteCargaResponseDto(ReporteCargueDto reporteCargue, String reporteBase64, String urlReporteRepositorio) {
        this.reporteCargue = reporteCargue;
        this.reporteBase64 = reporteBase64;
        this.urlReporteRepositorio = urlReporteRepositorio;
    }

    public ReporteCargueDto getReporteCargue() {
        return reporteCargue;
    }

    public void setReporteCargue(ReporteCargueDto reporteCargue) {
        this.reporteCargue = reporteCargue;
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

    public static class ReporteCargueDto {
        private String idReporteCargue;
        private Integer cantidadtramitesTransferido;
        private List<String> logTramitre;
        private EstadoReporteDto estadoReporte;
        private MetadataDto metadata;

        public ReporteCargueDto() {
        }

        public ReporteCargueDto(String idReporteCargue, Integer cantidadtramitesTransferido,
                                List<String> logTramitre, EstadoReporteDto estadoReporte,
                                MetadataDto metadata) {
            this.idReporteCargue = idReporteCargue;
            this.cantidadtramitesTransferido = cantidadtramitesTransferido;
            this.logTramitre = logTramitre;
            this.estadoReporte = estadoReporte;
            this.metadata = metadata;
        }

        public String getIdReporteCargue() {
            return idReporteCargue;
        }

        public void setIdReporteCargue(String idReporteCargue) {
            this.idReporteCargue = idReporteCargue;
        }

        public Integer getCantidadtramitesTransferido() {
            return cantidadtramitesTransferido;
        }

        public void setCantidadtramitesTransferido(Integer cantidadtramitesTransferido) {
            this.cantidadtramitesTransferido = cantidadtramitesTransferido;
        }

        public List<String> getLogTramitre() {
            return logTramitre;
        }

        public void setLogTramitre(List<String> logTramitre) {
            this.logTramitre = logTramitre;
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
        private String tipo;
        private List<String> valor;

        public EstadoReporteDto() {
        }

        public EstadoReporteDto(String tipo, List<String> valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public List<String> getValor() {
            return valor;
        }

        public void setValor(List<String> valor) {
            this.valor = valor;
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
