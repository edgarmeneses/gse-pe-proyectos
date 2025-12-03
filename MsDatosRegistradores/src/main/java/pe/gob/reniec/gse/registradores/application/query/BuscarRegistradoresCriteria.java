package pe.gob.reniec.gse.registradores.application.query;

/**
 * Query: Criterios de búsqueda de registradores
 * Representa los parámetros de filtrado para consultas.
 * Este es un concepto de aplicación, no de dominio.
 */
public class BuscarRegistradoresCriteria {
    
    private String codigoLocal;
    private String estado;
    private String numeroDni;
    private String nombreRegistrador;
    private Long pagina;
    private Long registrosPorPagina;
    
    public BuscarRegistradoresCriteria() {
    }
    
    public BuscarRegistradoresCriteria(String codigoLocal, String estado, String numeroDni,
                                       String nombreRegistrador, Long pagina, Long registrosPorPagina) {
        this.codigoLocal = codigoLocal;
        this.estado = estado;
        this.numeroDni = numeroDni;
        this.nombreRegistrador = nombreRegistrador;
        this.pagina = pagina != null ? pagina : 1L;
        this.registrosPorPagina = registrosPorPagina != null ? registrosPorPagina : 10L;
    }
    
    // Getters y Setters
    
    public String getCodigoLocal() {
        return codigoLocal;
    }
    
    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getNumeroDni() {
        return numeroDni;
    }
    
    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }
    
    public String getNombreRegistrador() {
        return nombreRegistrador;
    }
    
    public void setNombreRegistrador(String nombreRegistrador) {
        this.nombreRegistrador = nombreRegistrador;
    }
    
    public Long getPagina() {
        return pagina;
    }
    
    public void setPagina(Long pagina) {
        this.pagina = pagina;
    }
    
    public Long getRegistrosPorPagina() {
        return registrosPorPagina;
    }
    
    public void setRegistrosPorPagina(Long registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }
}
