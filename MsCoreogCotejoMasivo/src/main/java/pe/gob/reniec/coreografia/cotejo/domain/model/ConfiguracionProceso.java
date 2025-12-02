package pe.gob.reniec.coreografia.cotejo.domain.model;

public class ConfiguracionProceso {
    private Boolean notificarProgreso;
    private Boolean generarReporteDetallado;
    private String formatoReporte;

    public ConfiguracionProceso() {
    }

    public ConfiguracionProceso(Boolean notificarProgreso, Boolean generarReporteDetallado, String formatoReporte) {
        this.notificarProgreso = notificarProgreso;
        this.generarReporteDetallado = generarReporteDetallado;
        this.formatoReporte = formatoReporte;
    }

    public Boolean getNotificarProgreso() {
        return notificarProgreso;
    }

    public void setNotificarProgreso(Boolean notificarProgreso) {
        this.notificarProgreso = notificarProgreso;
    }

    public Boolean getGenerarReporteDetallado() {
        return generarReporteDetallado;
    }

    public void setGenerarReporteDetallado(Boolean generarReporteDetallado) {
        this.generarReporteDetallado = generarReporteDetallado;
    }

    public String getFormatoReporte() {
        return formatoReporte;
    }

    public void setFormatoReporte(String formatoReporte) {
        this.formatoReporte = formatoReporte;
    }
}
