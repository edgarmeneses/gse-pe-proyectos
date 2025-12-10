package pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto;

/**
 * DTO de entrada: SolicitudBCPRequestDto
 * Request para POST /api/v1/adaptador/procesar
 */
public class SolicitudBCPRequestDto {
    
    private String tipoOperacion;
    private String datos;
    
    public SolicitudBCPRequestDto() {
    }
    
    public SolicitudBCPRequestDto(String tipoOperacion, String datos) {
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
