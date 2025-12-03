package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representa el grafo de vínculos de parentesco de un ciudadano.
 * Este es un concepto de dominio que encapsula la red de relaciones familiares.
 */
public class GrafoParentesco {
    private final Ciudadano ciudadano;
    private final List<VinculoParentesco> vinculos;

    public GrafoParentesco(Ciudadano ciudadano, List<VinculoParentesco> vinculos) {
        if (ciudadano == null) {
            throw new IllegalArgumentException("El ciudadano no puede ser nulo");
        }
        this.ciudadano = ciudadano;
        this.vinculos = vinculos != null ? new ArrayList<>(vinculos) : new ArrayList<>();
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public List<VinculoParentesco> getVinculos() {
        return Collections.unmodifiableList(vinculos);
    }

    /**
     * Obtiene solo los vínculos vigentes.
     */
    public List<VinculoParentesco> getVinculosVigentes() {
        return vinculos.stream()
            .filter(VinculoParentesco::esVigente)
            .collect(Collectors.toList());
    }

    /**
     * Filtra vínculos por categoría de parentesco.
     */
    public List<VinculoParentesco> getVinculosPorCategoria(CategoriaParentesco categoria) {
        return vinculos.stream()
            .filter(v -> v.esDeCategoria(categoria))
            .collect(Collectors.toList());
    }

    /**
     * Filtra vínculos por grado máximo.
     */
    public List<VinculoParentesco> getVinculosHastaGrado(int gradoMaximo) {
        return vinculos.stream()
            .filter(v -> v.getGradoParentesco() != null && v.getGradoParentesco() <= gradoMaximo)
            .collect(Collectors.toList());
    }

    /**
     * Cuenta el total de vínculos.
     */
    public int getTotalVinculos() {
        return vinculos.size();
    }

    /**
     * Cuenta vínculos vigentes.
     */
    public int contarVinculosVigentes() {
        return (int) vinculos.stream()
            .filter(VinculoParentesco::esVigente)
            .count();
    }

    /**
     * Cuenta vínculos por categoría.
     */
    public int contarVinculosPorCategoria(CategoriaParentesco categoria) {
        return (int) vinculos.stream()
            .filter(v -> v.esDeCategoria(categoria))
            .count();
    }
}
