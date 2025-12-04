package pe.gob.reniec.datosparentesco.domain.model;

import java.util.Objects;

/**
 * Objeto de valor inmutable que representa un ciudadano con su identificación y nombre completo.
 */
public class Ciudadano {
    
    private static final int LONGITUD_MINIMA_NOMBRE = 2;
    private static final int LONGITUD_MAXIMA_NOMBRE = 200;
    
    private final IdentificadorCiudadano identificador;
    private final String nombreCompleto;
    
    private Ciudadano(IdentificadorCiudadano identificador, String nombreCompleto) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
    }
    
    /**
     * Factory method para crear un ciudadano.
     * Valida que el nombre tenga formato correcto.
     */
    public static Ciudadano crear(IdentificadorCiudadano identificador, String nombreCompleto) {
        Objects.requireNonNull(identificador, "El identificador del ciudadano no puede ser nulo");
        validarNombre(nombreCompleto);
        
        String nombreNormalizado = normalizarNombre(nombreCompleto);
        return new Ciudadano(identificador, nombreNormalizado);
    }
    
    /**
     * Factory method alternativo usando String para el DNI.
     */
    public static Ciudadano crear(String dni, String nombreCompleto) {
        IdentificadorCiudadano identificador = IdentificadorCiudadano.of(dni);
        return crear(identificador, nombreCompleto);
    }
    
    /**
     * Normaliza el nombre: convierte a mayúsculas y elimina espacios extras.
     */
    private static String normalizarNombre(String nombre) {
        return nombre.trim().toUpperCase().replaceAll("\\s+", " ");
    }
    
    /**
     * Obtiene los apellidos del ciudadano (asumiendo formato: APELLIDO1 APELLIDO2 NOMBRES).
     */
    public String obtenerApellidos() {
        String[] partes = nombreCompleto.split(" ");
        if (partes.length >= 2) {
            return partes[0] + " " + partes[1];
        }
        return partes.length > 0 ? partes[0] : "";
    }
    
    /**
     * Obtiene los nombres del ciudadano (asumiendo formato: APELLIDO1 APELLIDO2 NOMBRES).
     */
    public String obtenerNombres() {
        String[] partes = nombreCompleto.split(" ");
        if (partes.length > 2) {
            StringBuilder nombres = new StringBuilder();
            for (int i = 2; i < partes.length; i++) {
                if (i > 2) nombres.append(" ");
                nombres.append(partes[i]);
            }
            return nombres.toString();
        }
        return "";
    }
    
    /**
     * Verifica si el nombre contiene un texto específico (búsqueda insensible a mayúsculas).
     */
    public boolean contieneEnNombre(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        return nombreCompleto.toUpperCase().contains(texto.toUpperCase());
    }
    
    private static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede ser nulo o vacío");
        }
        
        String nombreLimpio = nombre.trim();
        if (nombreLimpio.length() < LONGITUD_MINIMA_NOMBRE || 
            nombreLimpio.length() > LONGITUD_MAXIMA_NOMBRE) {
            throw new IllegalArgumentException(
                String.format("El nombre debe tener entre %d y %d caracteres",
                    LONGITUD_MINIMA_NOMBRE, LONGITUD_MAXIMA_NOMBRE)
            );
        }
        
        // Validar que solo contenga letras, espacios y tildes
        if (!nombreLimpio.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }
    }
    
    public IdentificadorCiudadano getIdentificador() {
        return identificador;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    // Método legacy para compatibilidad con código existente
    @Deprecated
    public String getIdCiudadano() {
        return identificador.getValor();
    }
    
    // Método legacy para compatibilidad con código existente
    @Deprecated
    public String getNombre() {
        return nombreCompleto;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return Objects.equals(identificador, ciudadano.identificador);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    
    @Override
    public String toString() {
        return "Ciudadano{" +
                "identificador=" + identificador +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
