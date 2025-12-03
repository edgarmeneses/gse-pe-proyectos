package pe.gob.reniec.coreografia.cotejomasivo.domain.model;

/**
 * Value Object - Formato de reporte en el dominio
 */
public enum FormatoReporte {
    
    PDF("PDF", "application/pdf"),
    EXCEL("Excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    CSV("CSV", "text/csv"),
    JSON("JSON", "application/json");
    
    private final String descripcion;
    private final String mimeType;
    
    FormatoReporte(String descripcion, String mimeType) {
        this.descripcion = descripcion;
        this.mimeType = mimeType;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getMimeType() {
        return mimeType;
    }
    
    public static FormatoReporte fromString(String formato) {
        if (formato == null) {
            return PDF;
        }
        
        try {
            return FormatoReporte.valueOf(formato.toUpperCase());
        } catch (IllegalArgumentException e) {
            return PDF;
        }
    }
}
