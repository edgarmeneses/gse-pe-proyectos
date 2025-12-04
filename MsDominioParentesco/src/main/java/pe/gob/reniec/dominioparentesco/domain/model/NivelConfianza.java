package pe.gob.reniec.dominioparentesco.domain.model;

/**
 * Enum - Nivel de confianza en un vínculo detectado.
 * Determina si requiere validación manual.
 */
public enum NivelConfianza {
    
    ALTO(0.80, 1.00, "Vínculo confirmado con acta y datos consistentes"),
    MEDIO(0.50, 0.79, "Vínculo probable, requiere verificación adicional"),
    BAJO(0.00, 0.49, "Vínculo posible, requiere validación manual obligatoria");
    
    private final double rangoMinimo;
    private final double rangoMaximo;
    private final String descripcion;
    
    NivelConfianza(double rangoMinimo, double rangoMaximo, String descripcion) {
        this.rangoMinimo = rangoMinimo;
        this.rangoMaximo = rangoMaximo;
        this.descripcion = descripcion;
    }
    
    public static NivelConfianza fromPorcentaje(double porcentaje) {
        if (porcentaje < 0.0 || porcentaje > 1.0) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0.0 y 1.0");
        }
        
        if (porcentaje >= ALTO.rangoMinimo) {
            return ALTO;
        } else if (porcentaje >= MEDIO.rangoMinimo) {
            return MEDIO;
        } else {
            return BAJO;
        }
    }
    
    public boolean esConfiable() {
        return this == ALTO;
    }
    
    public boolean esConfianzaBaja() {
        return this == BAJO;
    }
    
    public boolean requiereValidacion() {
        return this == MEDIO || this == BAJO;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getRangoMinimo() {
        return rangoMinimo;
    }
    
    public double getRangoMaximo() {
        return rangoMaximo;
    }
}
