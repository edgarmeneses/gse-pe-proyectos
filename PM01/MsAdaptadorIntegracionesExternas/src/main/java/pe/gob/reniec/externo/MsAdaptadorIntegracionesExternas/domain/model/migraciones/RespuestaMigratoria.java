package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones;

import java.util.List;

public class RespuestaMigratoria {
    private Boolean esValido;
    private String estadoMigratorio;
    private String tipoCalidad;
    private String fechaIngreso;
    private String fechaVencimiento;
    private List<AlertaMigraciones> alertas;
    private DataCompletaMigraciones dataCompleta;

    public RespuestaMigratoria() {}

    public Boolean getEsValido() { return esValido; }
    public void setEsValido(Boolean esValido) { this.esValido = esValido; }

    public String getEstadoMigratorio() { return estadoMigratorio; }
    public void setEstadoMigratorio(String estadoMigratorio) { this.estadoMigratorio = estadoMigratorio; }

    public String getTipoCalidad() { return tipoCalidad; }
    public void setTipoCalidad(String tipoCalidad) { this.tipoCalidad = tipoCalidad; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public List<AlertaMigraciones> getAlertas() { return alertas; }
    public void setAlertas(List<AlertaMigraciones> alertas) { this.alertas = alertas; }

    public DataCompletaMigraciones getDataCompleta() { return dataCompleta; }
    public void setDataCompleta(DataCompletaMigraciones dataCompleta) { this.dataCompleta = dataCompleta; }
}
