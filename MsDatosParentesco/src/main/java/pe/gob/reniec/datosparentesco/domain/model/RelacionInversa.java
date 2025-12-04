package pe.gob.reniec.datosparentesco.domain.model;

import java.util.Objects;

/**
 * Objeto de valor inmutable que representa la relación inversa de parentesco.
 * Por ejemplo: Si A es padre de B, entonces B es hijo de A.
 */
public class RelacionInversa {
    
    private final IdentificadorCiudadano ciudadanoOrigen;
    private final IdentificadorCiudadano ciudadanoDestino;
    private final TipoVinculo tipoVinculoInverso;
    
    private RelacionInversa(IdentificadorCiudadano ciudadanoOrigen, 
                           IdentificadorCiudadano ciudadanoDestino,
                           TipoVinculo tipoVinculoInverso) {
        this.ciudadanoOrigen = ciudadanoOrigen;
        this.ciudadanoDestino = ciudadanoDestino;
        this.tipoVinculoInverso = tipoVinculoInverso;
    }
    
    /**
     * Factory method para crear una relación inversa.
     * Valida que los ciudadanos no sean el mismo.
     */
    public static RelacionInversa crear(IdentificadorCiudadano ciudadanoOrigen,
                                       IdentificadorCiudadano ciudadanoDestino,
                                       TipoVinculo tipoVinculoInverso) {
        Objects.requireNonNull(ciudadanoOrigen, "El ciudadano origen no puede ser nulo");
        Objects.requireNonNull(ciudadanoDestino, "El ciudadano destino no puede ser nulo");
        Objects.requireNonNull(tipoVinculoInverso, "El tipo de vínculo inverso no puede ser nulo");
        
        if (ciudadanoOrigen.equals(ciudadanoDestino)) {
            throw new IllegalArgumentException(
                "La relación inversa no puede tener el mismo ciudadano como origen y destino"
            );
        }
        
        return new RelacionInversa(ciudadanoOrigen, ciudadanoDestino, tipoVinculoInverso);
    }
    
    /**
     * Obtiene una representación descriptiva de la relación inversa.
     * Ejemplo: "Juan (DNI: 12345678) es HIJO de María (DNI: 87654321)"
     */
    public String obtenerDescripcion() {
        return String.format("%s es %s de %s",
            ciudadanoOrigen.getValor(),
            tipoVinculoInverso.name(),
            ciudadanoDestino.getValor()
        );
    }
    
    /**
     * Verifica si esta relación inversa corresponde a otra relación dada.
     */
    public boolean correspondeA(IdentificadorCiudadano origen, 
                               IdentificadorCiudadano destino, 
                               TipoVinculo tipoVinculo) {
        return this.ciudadanoOrigen.equals(destino) &&
               this.ciudadanoDestino.equals(origen) &&
               this.tipoVinculoInverso.equals(tipoVinculo.obtenerVinculoInverso());
    }
    
    public IdentificadorCiudadano getCiudadanoOrigen() {
        return ciudadanoOrigen;
    }
    
    public IdentificadorCiudadano getCiudadanoDestino() {
        return ciudadanoDestino;
    }
    
    public TipoVinculo getTipoVinculoInverso() {
        return tipoVinculoInverso;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelacionInversa that = (RelacionInversa) o;
        return Objects.equals(ciudadanoOrigen, that.ciudadanoOrigen) &&
               Objects.equals(ciudadanoDestino, that.ciudadanoDestino) &&
               tipoVinculoInverso == that.tipoVinculoInverso;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(ciudadanoOrigen, ciudadanoDestino, tipoVinculoInverso);
    }
    
    @Override
    public String toString() {
        return "RelacionInversa{" +
                "origen=" + ciudadanoOrigen +
                ", destino=" + ciudadanoDestino +
                ", tipo=" + tipoVinculoInverso +
                '}';
    }
}
