package pe.gse.generadorreportecargaoffline.domain.model;

/**
 * Aggregate Root: ReporteCargaPendiente
 * Representa el reporte de solicitudes pendientes para un itinerante.
 */
public class ReporteCargaPendiente {

    private String idReportePendiente;
    private Integer cantidadTramitesGestionados;
    private EstadoReporte estadoReporte;
    private Metadata metadata;
    private String reporteBase64;
    private String urlReporteRepositorio;

    public ReporteCargaPendiente() {
    }

    public ReporteCargaPendiente(String idReportePendiente, Integer cantidadTramitesGestionados,
                                 EstadoReporte estadoReporte, Metadata metadata,
                                 String reporteBase64, String urlReporteRepositorio) {
        this.idReportePendiente = idReportePendiente;
        this.cantidadTramitesGestionados = cantidadTramitesGestionados;
        this.estadoReporte = estadoReporte;
        this.metadata = metadata;
        this.reporteBase64 = reporteBase64;
        this.urlReporteRepositorio = urlReporteRepositorio;
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

    public EstadoReporte getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(EstadoReporte estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
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
}
