package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Value Object - Representa la población de vínculos posibles encontrados.
 */
public class PoblacionVinculosPosibles {
    
    private final Integer totalEncontrados;
    private final List<VinculoConsanguineo> vinculosConsanguineos;
    private final List<VinculoAfinidad> vinculosAfinidad;
    
    public PoblacionVinculosPosibles(Integer totalEncontrados,
                                    List<VinculoConsanguineo> vinculosConsanguineos,
                                    List<VinculoAfinidad> vinculosAfinidad) {
        this.totalEncontrados = Objects.requireNonNull(totalEncontrados, "El total no puede ser nulo");
        this.vinculosConsanguineos = vinculosConsanguineos != null ? 
            List.copyOf(vinculosConsanguineos) : List.of();
        this.vinculosAfinidad = vinculosAfinidad != null ? 
            List.copyOf(vinculosAfinidad) : List.of();
    }
    
    public Integer getTotalEncontrados() {
        return totalEncontrados;
    }
    
    public List<VinculoConsanguineo> getVinculosConsanguineos() {
        return vinculosConsanguineos;
    }
    
    public List<VinculoAfinidad> getVinculosAfinidad() {
        return vinculosAfinidad;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoblacionVinculosPosibles that = (PoblacionVinculosPosibles) o;
        return Objects.equals(totalEncontrados, that.totalEncontrados) &&
               Objects.equals(vinculosConsanguineos, that.vinculosConsanguineos) &&
               Objects.equals(vinculosAfinidad, that.vinculosAfinidad);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(totalEncontrados, vinculosConsanguineos, vinculosAfinidad);
    }
    
    @Override
    public String toString() {
        return "PoblacionVinculosPosibles{" +
                "totalEncontrados=" + totalEncontrados +
                ", vinculosConsanguineos=" + vinculosConsanguineos.size() +
                ", vinculosAfinidad=" + vinculosAfinidad.size() +
                '}';
    }
}
