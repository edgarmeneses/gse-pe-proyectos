package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa la información de paginación
 */
public class Paginacion {
    private final Long paginaActual;
    private final Long registrosPorPagina;
    private final Long totalRegistros;
    private final Long totalPaginas;
    private final Boolean tieneAnterior;
    private final Boolean tieneSiguiente;

    public Paginacion(Long paginaActual, Long registrosPorPagina, Long totalRegistros, 
                      Long totalPaginas, Boolean tieneAnterior, Boolean tieneSiguiente) {
        this.paginaActual = paginaActual;
        this.registrosPorPagina = registrosPorPagina;
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
    }

    public Long getPaginaActual() {
        return paginaActual;
    }

    public Long getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public Long getTotalPaginas() {
        return totalPaginas;
    }

    public Boolean getTieneAnterior() {
        return tieneAnterior;
    }

    public Boolean getTieneSiguiente() {
        return tieneSiguiente;
    }
}
