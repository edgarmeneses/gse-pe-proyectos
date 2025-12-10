package pe.gob.reniec.hechosVitales.domain.model;

public enum TipoDocumento {
    DNI("1"),
    CARNET_EXTRANJERIA("2"),
    PASAPORTE("3"),
    OTROS("4");

    private final String codigo;

    TipoDocumento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static TipoDocumento fromCodigo(String codigo) {
        for (TipoDocumento t : values()) {
            if (t.codigo.equals(codigo)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Código de tipo de documento inválido: " + codigo);
    }
}
