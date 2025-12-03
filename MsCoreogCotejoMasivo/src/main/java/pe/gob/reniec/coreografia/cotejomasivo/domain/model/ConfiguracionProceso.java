package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Configuración del procesamiento del cotejo masivo
 */
public class ConfiguracionProceso {
    
    private Boolean notificarProgreso;
    private Boolean generarReporteDetallado;
    private FormatoReporte formatoReporte;
    
    public ConfiguracionProceso() {
    }
    
    public ConfiguracionProceso(Boolean notificarProgreso, Boolean generarReporteDetallado, FormatoReporte formatoReporte) {
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
    
    public FormatoReporte getFormatoReporte() {
        return formatoReporte;
    }
    
    public void setFormatoReporte(FormatoReporte formatoReporte) {
        this.formatoReporte = formatoReporte;
    }
}
