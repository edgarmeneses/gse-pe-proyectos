package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones;

public class AlertaMigraciones {
    private String codigo;
    private String descripcion;
    private String severidad;

    public AlertaMigraciones() {}

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getSeveridad() { return severidad; }
    public void setSeveridad(String severidad) { this.severidad = severidad; }
}
