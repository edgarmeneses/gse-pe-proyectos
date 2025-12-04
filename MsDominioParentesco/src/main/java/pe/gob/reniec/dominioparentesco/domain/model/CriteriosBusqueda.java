package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Value Object - Representa los criterios de búsqueda para el análisis de parentesco.
 */
public class CriteriosBusqueda {
    
    private final RangoAnios rangoAniosPadres;
    private final RangoAnios rangoAniosHijos;
    private final List<String> variacionesNombre;
    private final Boolean incluirFallecidos;
    private final Boolean incluirActasAnuladas;
    
    public CriteriosBusqueda(RangoAnios rangoAniosPadres, 
                            RangoAnios rangoAniosHijos,
                            List<String> variacionesNombre,
                            Boolean incluirFallecidos,
                            Boolean incluirActasAnuladas) {
        this.rangoAniosPadres = rangoAniosPadres;
        this.rangoAniosHijos = rangoAniosHijos;
        this.variacionesNombre = variacionesNombre != null ? List.copyOf(variacionesNombre) : List.of();
        this.incluirFallecidos = incluirFallecidos != null ? incluirFallecidos : false;
        this.incluirActasAnuladas = incluirActasAnuladas != null ? incluirActasAnuladas : false;
    }
    
    public RangoAnios getRangoAniosPadres() {
        return rangoAniosPadres;
    }
    
    public RangoAnios getRangoAniosHijos() {
        return rangoAniosHijos;
    }
    
    public List<String> getVariacionesNombre() {
        return variacionesNombre;
    }
    
    public Boolean getIncluirFallecidos() {
        return incluirFallecidos;
    }
    
    public Boolean getIncluirActasAnuladas() {
        return incluirActasAnuladas;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriosBusqueda that = (CriteriosBusqueda) o;
        return Objects.equals(rangoAniosPadres, that.rangoAniosPadres) &&
               Objects.equals(rangoAniosHijos, that.rangoAniosHijos) &&
               Objects.equals(variacionesNombre, that.variacionesNombre) &&
               Objects.equals(incluirFallecidos, that.incluirFallecidos) &&
               Objects.equals(incluirActasAnuladas, that.incluirActasAnuladas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(rangoAniosPadres, rangoAniosHijos, variacionesNombre, 
                          incluirFallecidos, incluirActasAnuladas);
    }
    
    @Override
    public String toString() {
        return "CriteriosBusqueda{" +
                "rangoAniosPadres=" + rangoAniosPadres +
                ", rangoAniosHijos=" + rangoAniosHijos +
                ", variacionesNombre=" + variacionesNombre +
                ", incluirFallecidos=" + incluirFallecidos +
                ", incluirActasAnuladas=" + incluirActasAnuladas +
                '}';
    }
}
