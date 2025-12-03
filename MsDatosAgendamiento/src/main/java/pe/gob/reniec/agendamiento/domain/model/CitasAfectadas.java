package pe.gob.reniec.agendamiento.domain.model;

import java.util.List;

public class CitasAfectadas {
    private Long cantidad;
    private String accion;
    private List<String> citasIds;

    public CitasAfectadas() {
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<String> getCitasIds() {
        return citasIds;
    }

    public void setCitasIds(List<String> citasIds) {
        this.citasIds = citasIds;
    }
}
