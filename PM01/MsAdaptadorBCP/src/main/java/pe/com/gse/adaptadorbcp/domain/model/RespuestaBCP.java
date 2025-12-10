package pe.com.gse.adaptadorbcp.domain.model;

/**
 * Aggregate Root: RespuestaBCP
 * Representa la respuesta del BCP
 */
public class RespuestaBCP {
    
    private String codigo;
    private String mensaje;
    private String datos;
    
    public RespuestaBCP() {
    }
    
    public RespuestaBCP(String codigo, String mensaje, String datos) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.datos = datos;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getDatos() {
        return datos;
    }
    
    public void setDatos(String datos) {
        this.datos = datos;
    }
}
