package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa un tipo de vínculo de parentesco.
 * Encapsula las reglas de negocio sobre tipos de vínculos válidos.
 */
public class TipoVinculo {
    
    // Vínculos de primer grado
    public static final TipoVinculo PADRE = new TipoVinculo("PADRE", "Padre", 1, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo MADRE = new TipoVinculo("MADRE", "Madre", 1, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo HIJO = new TipoVinculo("HIJO", "Hijo", 1, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo HIJA = new TipoVinculo("HIJA", "Hija", 1, CategoriaVinculo.CONSANGUINEO);
    
    // Vínculos de segundo grado
    public static final TipoVinculo ABUELO = new TipoVinculo("ABUELO", "Abuelo", 2, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo ABUELA = new TipoVinculo("ABUELA", "Abuela", 2, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo HERMANO = new TipoVinculo("HERMANO", "Hermano", 2, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo HERMANA = new TipoVinculo("HERMANA", "Hermana", 2, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo NIETO = new TipoVinculo("NIETO", "Nieto", 2, CategoriaVinculo.CONSANGUINEO);
    public static final TipoVinculo NIETA = new TipoVinculo("NIETA", "Nieta", 2, CategoriaVinculo.CONSANGUINEO);
    
    // Vínculos de afinidad
    public static final TipoVinculo CONYUGE = new TipoVinculo("CONYUGE", "Cónyuge", 1, CategoriaVinculo.AFINIDAD);
    public static final TipoVinculo SUEGRO = new TipoVinculo("SUEGRO", "Suegro", 1, CategoriaVinculo.AFINIDAD);
    public static final TipoVinculo SUEGRA = new TipoVinculo("SUEGRA", "Suegra", 1, CategoriaVinculo.AFINIDAD);
    public static final TipoVinculo YERNO = new TipoVinculo("YERNO", "Yerno", 1, CategoriaVinculo.AFINIDAD);
    public static final TipoVinculo NUERA = new TipoVinculo("NUERA", "Nuera", 1, CategoriaVinculo.AFINIDAD);
    
    private final String codigo;
    private final String descripcion;
    private final int grado;
    private final CategoriaVinculo categoria;
    
    private TipoVinculo(String codigo, String descripcion, int grado, CategoriaVinculo categoria) {
        this.codigo = Objects.requireNonNull(codigo, "El código no puede ser nulo");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser nula");
        this.grado = grado;
        this.categoria = Objects.requireNonNull(categoria, "La categoría no puede ser nula");
        
        validarGrado(grado);
    }
    
    public static TipoVinculo fromCodigo(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("El código no puede ser nulo");
        }
        
        // En una implementación real, esto vendría de un repositorio
        return switch (codigo.toUpperCase()) {
            case "PADRE" -> PADRE;
            case "MADRE" -> MADRE;
            case "HIJO" -> HIJO;
            case "HIJA" -> HIJA;
            case "ABUELO" -> ABUELO;
            case "ABUELA" -> ABUELA;
            case "HERMANO" -> HERMANO;
            case "HERMANA" -> HERMANA;
            case "NIETO" -> NIETO;
            case "NIETA" -> NIETA;
            case "CONYUGE" -> CONYUGE;
            case "SUEGRO" -> SUEGRO;
            case "SUEGRA" -> SUEGRA;
            case "YERNO" -> YERNO;
            case "NUERA" -> NUERA;
            default -> new TipoVinculo(codigo, codigo, 1, CategoriaVinculo.CONSANGUINEO);
        };
    }
    
    private void validarGrado(int grado) {
        if (grado < 1 || grado > 4) {
            throw new IllegalArgumentException(
                "El grado de parentesco debe estar entre 1 y 4 para consanguinidad, o 1 y 2 para afinidad");
        }
    }
    
    public boolean esConsanguineo() {
        return categoria == CategoriaVinculo.CONSANGUINEO;
    }
    
    public boolean esAfinidad() {
        return categoria == CategoriaVinculo.AFINIDAD;
    }
    
    public boolean esPrimerGrado() {
        return grado == 1;
    }
    
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getGrado() { return grado; }
    public CategoriaVinculo getCategoria() { return categoria; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoVinculo that = (TipoVinculo) o;
        return Objects.equals(codigo, that.codigo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    
    @Override
    public String toString() {
        return descripcion + " (" + codigo + ")";
    }
}
