package pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto;

/**
 * DTO de salida: RespuestaBCPResponseDto
 * Response para POST /api/v1/adaptador/procesar
 */
public class RespuestaBCPResponseDto {
    
    private String codigo;
    private String mensaje;
    private String datos;
    
    public RespuestaBCPResponseDto() {
    }
    
    public RespuestaBCPResponseDto(String codigo, String mensaje, String datos) {
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
