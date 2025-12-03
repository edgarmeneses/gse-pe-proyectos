package pe.gob.reniec.gse.registradores.application.query;

import pe.gob.reniec.gse.registradores.domain.model.Registrador;

import java.util.List;

/**
 * Query Result: Resultado de búsqueda paginada
 * Envuelve los resultados con información de paginación.
 * Este es un concepto de aplicación, no de dominio.
 */
public class RegistradoresPaginados {
    
    private final List<Registrador> registradores;
    private final InformacionPaginacion paginacion;
    
    public RegistradoresPaginados(List<Registrador> registradores, InformacionPaginacion paginacion) {
        this.registradores = registradores;
        this.paginacion = paginacion;
    }
    
    public List<Registrador> getRegistradores() {
        return registradores;
    }
    
    public InformacionPaginacion getPaginacion() {
        return paginacion;
    }
}
