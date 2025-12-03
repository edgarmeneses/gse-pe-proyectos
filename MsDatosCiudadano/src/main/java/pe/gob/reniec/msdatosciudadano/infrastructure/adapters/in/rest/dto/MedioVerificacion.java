package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

/**
 * Enum para el campo `medioVerificacion` con las opciones "fisico" y "virtual".
 * Se expone una representación en minúsculas vía toString() y getValue().
 */
public enum MedioVerificacion {
    FISICO("fisico"),
    VIRTUAL("virtual");

    private final String value;

    MedioVerificacion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

