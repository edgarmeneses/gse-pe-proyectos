package pe.gob.reniec.hechosVitales.domain.model;

import java.util.Objects;

public class Madre {
    private final TipoDocumento tipoDocumento;
    private final String numeroDocumento;

    public Madre(TipoDocumento tipoDocumento, String numeroDocumento) {
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento, "El tipo de documento es obligatorio");
        this.numeroDocumento = Objects.requireNonNull(numeroDocumento, "El número de documento es obligatorio");
        
        if (numeroDocumento.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de documento no puede estar vacío");
        }
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
}
