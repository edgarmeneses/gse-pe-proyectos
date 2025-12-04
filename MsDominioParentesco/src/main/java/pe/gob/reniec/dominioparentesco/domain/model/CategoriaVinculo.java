package pe.gob.reniec.dominioparentesco.domain.model;

/**
 * Enum - Categoría de vínculo de parentesco según el derecho civil peruano.
 */
public enum CategoriaVinculo {
    
    CONSANGUINEO("Vínculo por consanguinidad - relación de sangre"),
    AFINIDAD("Vínculo por afinidad - relación por matrimonio");
    
    private final String descripcion;
    
    CategoriaVinculo(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
