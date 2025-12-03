package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Enumeración que representa las categorías de parentesco.
 */
public enum CategoriaParentesco {
    CONSANGUINEO("Consanguíneo"),
    AFINIDAD("Afinidad");

    private final String descripcion;

    CategoriaParentesco(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static CategoriaParentesco fromString(String texto) {
        if (texto == null) {
            return null;
        }
        
        for (CategoriaParentesco categoria : CategoriaParentesco.values()) {
            if (categoria.name().equalsIgnoreCase(texto) || 
                categoria.descripcion.equalsIgnoreCase(texto)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoría de parentesco no válida: " + texto);
    }
}
