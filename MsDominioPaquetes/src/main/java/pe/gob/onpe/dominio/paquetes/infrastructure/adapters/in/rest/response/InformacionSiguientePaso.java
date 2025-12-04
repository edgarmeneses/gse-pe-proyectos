package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.response;

/**
 * Información del siguiente paso en el flujo del proceso.
 * Esta clase pertenece a la capa de aplicación.
 * Contiene información de guía para el usuario sobre las siguientes acciones.
 */
public class InformacionSiguientePaso {
    private String accion;
    private String descripcion;
    private String plantillaSugerida;

    public InformacionSiguientePaso() {
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlantillaSugerida() {
        return plantillaSugerida;
    }

    public void setPlantillaSugerida(String plantillaSugerida) {
        this.plantillaSugerida = plantillaSugerida;
    }
}
