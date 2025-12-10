package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones;

public class SolicitudMigraciones {
    private CiudadanoMigraciones ciudadano;
    private OpcionesMigraciones opciones;

    public SolicitudMigraciones() {}

    public CiudadanoMigraciones getCiudadano() { return ciudadano; }
    public void setCiudadano(CiudadanoMigraciones ciudadano) { this.ciudadano = ciudadano; }

    public OpcionesMigraciones getOpciones() { return opciones; }
    public void setOpciones(OpcionesMigraciones opciones) { this.opciones = opciones; }
}
