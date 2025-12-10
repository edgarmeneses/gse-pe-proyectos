package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones;

public class DataCompletaMigraciones {
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombreCompleto;
    private String nacionalidad;
    private String tipoCalidad;
    private String estadoMigratorio;
    private String fechaIngreso;
    private String fechaVencimiento;
    private String puestoControl;
    private String numeroCarnet;

    public DataCompletaMigraciones() {}

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getTipoCalidad() { return tipoCalidad; }
    public void setTipoCalidad(String tipoCalidad) { this.tipoCalidad = tipoCalidad; }

    public String getEstadoMigratorio() { return estadoMigratorio; }
    public void setEstadoMigratorio(String estadoMigratorio) { this.estadoMigratorio = estadoMigratorio; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getPuestoControl() { return puestoControl; }
    public void setPuestoControl(String puestoControl) { this.puestoControl = puestoControl; }

    public String getNumeroCarnet() { return numeroCarnet; }
    public void setNumeroCarnet(String numeroCarnet) { this.numeroCarnet = numeroCarnet; }
}
