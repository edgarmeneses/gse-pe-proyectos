package pe.gse.generadorreportecargaoffline.domain.model;

import java.util.List;

/**
 * Aggregate Root: ReporteCarga
 * Representa el reporte generado del procesamiento de un lote de trámites offline.
 */
public class ReporteCarga {

    private String idReporteCargue;
    private Integer cantidadTramitesTransferido;
    private List<String> logTramitre;
    private EstadoReporte estadoReporte;
    private Metadata metadata;
    private String reporteBase64;
    private String urlReporteRepositorio;

    public ReporteCarga() {
    }

    public ReporteCarga(String idReporteCargue, Integer cantidadTramitesTransferido,
                        List<String> logTramitre, EstadoReporte estadoReporte,
                        Metadata metadata, String reporteBase64, String urlReporteRepositorio) {
        this.idReporteCargue = idReporteCargue;
        this.cantidadTramitesTransferido = cantidadTramitesTransferido;
        this.logTramitre = logTramitre;
        this.estadoReporte = estadoReporte;
        this.metadata = metadata;
        this.reporteBase64 = reporteBase64;
        this.urlReporteRepositorio = urlReporteRepositorio;
    }

    public String getIdReporteCargue() {
        return idReporteCargue;
    }

    public void setIdReporteCargue(String idReporteCargue) {
        this.idReporteCargue = idReporteCargue;
    }

    public Integer getCantidadTramitesTransferido() {
        return cantidadTramitesTransferido;
    }

    public void setCantidadTramitesTransferido(Integer cantidadTramitesTransferido) {
        this.cantidadTramitesTransferido = cantidadTramitesTransferido;
    }

    public List<String> getLogTramitre() {
        return logTramitre;
    }

    public void setLogTramitre(List<String> logTramitre) {
        this.logTramitre = logTramitre;
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
