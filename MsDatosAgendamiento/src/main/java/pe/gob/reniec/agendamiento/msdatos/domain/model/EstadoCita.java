package pe.gob.reniec.agendamiento.msdatos.domain.model;

public class EstadoCita {
    private String codigo;
    private String descripcion;
    private Boolean permiteModificacion;
    private Boolean permiteCancelacion;

    public EstadoCita() {
    }

    public EstadoCita(String codigo, String descripcion, Boolean permiteModificacion, Boolean permiteCancelacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.permiteModificacion = permiteModificacion;
        this.permiteCancelacion = permiteCancelacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPermiteModificacion() {
        return permiteModificacion;
    }

    public void setPermiteModificacion(Boolean permiteModificacion) {
        this.permiteModificacion = permiteModificacion;
    }

    public Boolean getPermiteCancelacion() {
        return permiteCancelacion;
    }

    public void setPermiteCancelacion(Boolean permiteCancelacion) {
        this.permiteCancelacion = permiteCancelacion;
    }
}
