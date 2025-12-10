package pe.gob.reniec.notificaciones.MsAdaptadorNotificaciones.domain.model;

public class CanalUtilizado {
    private String dni;
    private String canal;
    private String estado;
    private String proveedorAsignado;

    public CanalUtilizado() {}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProveedorAsignado() {
        return proveedorAsignado;
    }

    public void setProveedorAsignado(String proveedorAsignado) {
        this.proveedorAsignado = proveedorAsignado;
    }
}
