package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.util.List;

/**
 * Value Object que encapsula el resultado completo de una consulta de vínculos de parentesco
 */
public class ConsultaVinculosResult {
    private final Ciudadano ciudadanoConsultado;
    private final List<VinculoParentesco> vinculos;
    private final Resumen resumen;
    private final Paginacion paginacion;

    public ConsultaVinculosResult(Ciudadano ciudadanoConsultado, List<VinculoParentesco> vinculos,
                                  Resumen resumen, Paginacion paginacion) {
        this.ciudadanoConsultado = ciudadanoConsultado;
        this.vinculos = vinculos;
        this.resumen = resumen;
        this.paginacion = paginacion;
    }

    public Ciudadano getCiudadanoConsultado() {
        return ciudadanoConsultado;
    }

    public List<VinculoParentesco> getVinculos() {
        return vinculos;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public Paginacion getPaginacion() {
        return paginacion;
    }
}
