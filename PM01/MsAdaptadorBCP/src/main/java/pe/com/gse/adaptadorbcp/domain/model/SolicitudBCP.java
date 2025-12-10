package pe.com.gse.adaptadorbcp.domain.model;

/**
 * Aggregate Root: SolicitudBCP
 * Representa una solicitud hacia el BCP
 */
public class SolicitudBCP {
    
    private String tipoOperacion;
    private String datos;
    
    public SolicitudBCP() {
    }
    
    public SolicitudBCP(String tipoOperacion, String datos) {
        this.tipoOperacion = tipoOperacion;
        this.datos = datos;
    }
    
    public String getTipoOperacion() {
        return tipoOperacion;
    }
    
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    public String getDatos() {
        return datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }
}
