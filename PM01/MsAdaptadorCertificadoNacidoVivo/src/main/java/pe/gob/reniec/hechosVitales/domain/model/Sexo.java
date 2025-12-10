package pe.gob.reniec.hechosVitales.domain.model;

public enum Sexo {
    MASCULINO("1"),
    FEMENINO("2"),
    INDETERMINADO("3");

    private final String codigo;

    Sexo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Sexo fromCodigo(String codigo) {
        for (Sexo s : values()) {
            if (s.codigo.equals(codigo)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Código de sexo inválido: " + codigo);
    }
}
