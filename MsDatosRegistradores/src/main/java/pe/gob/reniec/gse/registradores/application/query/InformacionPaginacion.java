package pe.gob.reniec.gse.registradores.application.query;

/**
 * DTO: Información de paginación
 * Representa metadatos de una consulta paginada.
 * Este es un concepto de aplicación/infraestructura.
 */
public class InformacionPaginacion {
    
    private final Long totalRegistros;
    private final Long totalPaginas;
    private final Long paginaActual;
    private final Long registrosPorPagina;
    private final Boolean tieneAnterior;
    private final Boolean tieneSiguiente;
    
    public InformacionPaginacion(Long totalRegistros, Long totalPaginas, Long paginaActual,
                                Long registrosPorPagina, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.registrosPorPagina = registrosPorPagina;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
    }
    
    public static InformacionPaginacion calcular(Long totalRegistros, Long paginaActual, Long registrosPorPagina) {
        Long totalPaginas = (long) Math.ceil((double) totalRegistros / registrosPorPagina);
        Boolean tieneAnterior = paginaActual > 1;
        Boolean tieneSiguiente = paginaActual < totalPaginas;
        
        return new InformacionPaginacion(
            totalRegistros,
            totalPaginas,
            paginaActual,
            registrosPorPagina,
            tieneAnterior,
            tieneSiguiente
        );
    }
    
    // Getters
    
    public Long getTotalRegistros() {
        return totalRegistros;
    }
    
    public Long getTotalPaginas() {
        return totalPaginas;
    }
    
    public Long getPaginaActual() {
        return paginaActual;
    }
    
    public Long getRegistrosPorPagina() {
        return registrosPorPagina;
    }
    
    public Boolean getTieneAnterior() {
        return tieneAnterior;
    }
    
    public Boolean getTieneSiguiente() {
        return tieneSiguiente;
    }
}
