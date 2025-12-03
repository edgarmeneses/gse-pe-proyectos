package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto;

/**
 * DTO - Configuración del Proceso
 */
public class ConfiguracionProcesoDto {
    
    private Boolean notificarProgreso;
    private Boolean generarReporteDetallado;
    private String formatoReporte;
    
    public ConfiguracionProcesoDto() {
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
