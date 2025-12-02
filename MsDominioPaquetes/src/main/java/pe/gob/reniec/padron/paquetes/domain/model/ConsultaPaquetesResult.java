package pe.gob.reniec.padron.paquetes.domain.model;

import java.util.List;

public class ConsultaPaquetesResult {
    private List<Paquete> paquetes;
    private Resumen resumen;
    private Paginacion paginacion;

    public ConsultaPaquetesResult() {
    }

    public ConsultaPaquetesResult(List<Paquete> paquetes, Resumen resumen, Paginacion paginacion) {
        this.paquetes = paquetes;
        this.resumen = resumen;
        this.paginacion = paginacion;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public void setResumen(Resumen resumen) {
        this.resumen = resumen;
    }

    public Paginacion getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(Paginacion paginacion) {
        this.paginacion = paginacion;
    }
}
