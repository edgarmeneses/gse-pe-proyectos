package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;

import java.util.List;

/**
 * Objeto de resultado para la consulta de paquetes electorales.
 * Esta clase pertenece a la capa de aplicación, no al dominio.
 * Contiene información técnica como paginación que no es parte del modelo de negocio.
 */
public class ResultadoConsultaPaquetes {
    private List<PaqueteElectoral> paquetes;
    private ResumenPaquetes resumen;
    private InformacionPaginacion paginacion;

    public ResultadoConsultaPaquetes() {
    }

    public ResultadoConsultaPaquetes(List<PaqueteElectoral> paquetes, ResumenPaquetes resumen, 
                                     InformacionPaginacion paginacion) {
        this.paquetes = paquetes;
        this.resumen = resumen;
        this.paginacion = paginacion;
    }

    public List<PaqueteElectoral> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<PaqueteElectoral> paquetes) {
        this.paquetes = paquetes;
    }

    public ResumenPaquetes getResumen() {
        return resumen;
    }

    public void setResumen(ResumenPaquetes resumen) {
        this.resumen = resumen;
    }

    public InformacionPaginacion getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(InformacionPaginacion paginacion) {
        this.paginacion = paginacion;
    }
}
