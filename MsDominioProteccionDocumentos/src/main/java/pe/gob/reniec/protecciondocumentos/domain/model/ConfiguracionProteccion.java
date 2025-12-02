package pe.gob.reniec.protecciondocumentos.domain.model;

public class ConfiguracionProteccion {
    private Boolean usarConfiguracionPorDefecto;
    private String algoritmoCompresion;
    private String nivelCompresion;

    public ConfiguracionProteccion() {
    }

    public ConfiguracionProteccion(Boolean usarConfiguracionPorDefecto, String algoritmoCompresion, String nivelCompresion) {
        this.usarConfiguracionPorDefecto = usarConfiguracionPorDefecto;
        this.algoritmoCompresion = algoritmoCompresion;
        this.nivelCompresion = nivelCompresion;
    }

    public Boolean getUsarConfiguracionPorDefecto() {
        return usarConfiguracionPorDefecto;
    }

    public void setUsarConfiguracionPorDefecto(Boolean usarConfiguracionPorDefecto) {
        this.usarConfiguracionPorDefecto = usarConfiguracionPorDefecto;
    }

    public String getAlgoritmoCompresion() {
        return algoritmoCompresion;
    }

    public void setAlgoritmoCompresion(String algoritmoCompresion) {
        this.algoritmoCompresion = algoritmoCompresion;
    }

    public String getNivelCompresion() {
        return nivelCompresion;
    }

    public void setNivelCompresion(String nivelCompresion) {
        this.nivelCompresion = nivelCompresion;
    }
}
