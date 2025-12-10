package pe.gob.reniec.hechosVitales.domain.model;

import java.util.Objects;

public class CertificadoId {
    private final String valor;

    public CertificadoId(String valor) {
        this.valor = Objects.requireNonNull(valor, "El número de CNV es obligatorio");
        if (valor.length() < 8 || valor.length() > 10) {
            throw new IllegalArgumentException("El número de CNV debe tener entre 8 y 10 caracteres");
        }
    }

    public String getValor() {
        return valor;
    }
}
