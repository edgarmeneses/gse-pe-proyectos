package pe.gob.reniec.datosparentesco.domain.model;

import java.util.Objects;

/**
 * Objeto de valor inmutable que representa la información de paginación.
 * Encapsula la lógica de cálculo y validación de paginación.
 */
public class Paginacion {
    
    private static final int TAMANIO_MINIMO_PAGINA = 1;
    private static final int TAMANIO_MAXIMO_PAGINA = 100;
    private static final int PAGINA_MINIMA = 1;
    
    private final int totalRegistros;
    private final int totalPaginas;
    private final int paginaActual;
    private final int tamanioPagina;
    private final boolean tieneAnterior;
    private final boolean tieneSiguiente;
    
    private Paginacion(int totalRegistros, int totalPaginas, int paginaActual,
                      int tamanioPagina, boolean tieneAnterior, boolean tieneSiguiente) {
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.paginaActual = paginaActual;
        this.tamanioPagina = tamanioPagina;
        this.tieneAnterior = tieneAnterior;
        this.tieneSiguiente = tieneSiguiente;
    }
    
    /**
     * Factory method para crear paginación calculando automáticamente los valores derivados.
     */
    public static Paginacion crear(int totalRegistros, int paginaActual, int tamanioPagina) {
        validarTamanioPagina(tamanioPagina);
        validarPaginaActual(paginaActual);
        
        if (totalRegistros < 0) {
            throw new IllegalArgumentException("El total de registros no puede ser negativo");
        }
        
        int totalPaginas = calcularTotalPaginas(totalRegistros, tamanioPagina);
        boolean tieneAnterior = paginaActual > PAGINA_MINIMA;
        boolean tieneSiguiente = paginaActual < totalPaginas;
        
        return new Paginacion(totalRegistros, totalPaginas, paginaActual, 
                             tamanioPagina, tieneAnterior, tieneSiguiente);
    }
    
    /**
     * Factory method para crear paginación con valores específicos (útil para reconstrucción).
     */
    public static Paginacion reconstruir(int totalRegistros, int totalPaginas, int paginaActual,
                                        int tamanioPagina, boolean tieneAnterior, boolean tieneSiguiente) {
        validarTamanioPagina(tamanioPagina);
        validarPaginaActual(paginaActual);
        
        return new Paginacion(totalRegistros, totalPaginas, paginaActual,
                             tamanioPagina, tieneAnterior, tieneSiguiente);
    }
    
    /**
     * Calcula el número total de páginas basado en el total de registros y tamaño de página.
     */
    private static int calcularTotalPaginas(int totalRegistros, int tamanioPagina) {
        if (totalRegistros == 0) {
            return 0;
        }
        return (int) Math.ceil((double) totalRegistros / tamanioPagina);
    }
    
    /**
     * Calcula el índice inicial (offset) para la consulta paginada.
     */
    public int calcularOffset() {
        return (paginaActual - 1) * tamanioPagina;
    }
    
    /**
     * Obtiene el número de la primera entrada en la página actual.
     */
    public int obtenerPrimerRegistro() {
        return totalRegistros == 0 ? 0 : calcularOffset() + 1;
    }
    
    /**
     * Obtiene el número de la última entrada en la página actual.
     */
    public int obtenerUltimoRegistro() {
        int ultimo = calcularOffset() + tamanioPagina;
        return Math.min(ultimo, totalRegistros);
    }
    
    /**
     * Verifica si esta es la primera página.
     */
    public boolean esPrimeraPagina() {
        return paginaActual == PAGINA_MINIMA;
    }
    
    /**
     * Verifica si esta es la última página.
     */
    public boolean esUltimaPagina() {
        return paginaActual == totalPaginas || totalPaginas == 0;
    }
    
    /**
     * Verifica si la paginación está vacía (sin registros).
     */
    public boolean estaVacia() {
        return totalRegistros == 0;
    }
    
    /**
     * Crea una nueva paginación para la página siguiente.
     */
    public Paginacion paginaSiguiente() {
        if (!tieneSiguiente) {
            throw new IllegalStateException("No hay página siguiente disponible");
        }
        return crear(totalRegistros, paginaActual + 1, tamanioPagina);
    }
    
    /**
     * Crea una nueva paginación para la página anterior.
     */
    public Paginacion paginaAnterior() {
        if (!tieneAnterior) {
            throw new IllegalStateException("No hay página anterior disponible");
        }
        return crear(totalRegistros, paginaActual - 1, tamanioPagina);
    }
    
    private static void validarTamanioPagina(int tamanioPagina) {
        if (tamanioPagina < TAMANIO_MINIMO_PAGINA || tamanioPagina > TAMANIO_MAXIMO_PAGINA) {
            throw new IllegalArgumentException(
                String.format("El tamaño de página debe estar entre %d y %d",
                    TAMANIO_MINIMO_PAGINA, TAMANIO_MAXIMO_PAGINA)
            );
        }
    }
    
    private static void validarPaginaActual(int paginaActual) {
        if (paginaActual < PAGINA_MINIMA) {
            throw new IllegalArgumentException(
                String.format("La página actual debe ser mayor o igual a %d", PAGINA_MINIMA)
            );
        }
    }
    
    public int getTotalRegistros() {
        return totalRegistros;
    }
    
    public int getTotalPaginas() {
        return totalPaginas;
    }
    
    public int getPaginaActual() {
        return paginaActual;
    }
    
    public int getTamanioPagina() {
        return tamanioPagina;
    }
    
    public boolean getTieneAnterior() {
        return tieneAnterior;
    }
    
    public boolean getTieneSiguiente() {
        return tieneSiguiente;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paginacion that = (Paginacion) o;
        return totalRegistros == that.totalRegistros &&
               paginaActual == that.paginaActual &&
               tamanioPagina == that.tamanioPagina;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(totalRegistros, paginaActual, tamanioPagina);
    }
    
    @Override
    public String toString() {
        return "Paginacion{" +
                "página " + paginaActual + " de " + totalPaginas +
                ", mostrando " + obtenerPrimerRegistro() + "-" + obtenerUltimoRegistro() +
                " de " + totalRegistros + " registros" +
                '}';
    }
}
