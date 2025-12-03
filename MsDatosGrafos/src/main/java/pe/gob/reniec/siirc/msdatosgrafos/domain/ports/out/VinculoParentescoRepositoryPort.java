package pe.gob.reniec.siirc.msdatosgrafos.domain.ports.out;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.CategoriaParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.model.GrafoParentesco;

/**
 * Puerto de salida para acceder al repositorio de vínculos de parentesco.
 */
public interface VinculoParentescoRepositoryPort {
    
    /**
     * Consulta el grafo completo de vínculos de parentesco de un ciudadano.
     * 
     * @param idCiudadano Identificador del ciudadano
     * @param gradoMaximo Grado máximo de parentesco (opcional)
     * @param categoria Categoría de parentesco (opcional)
     * @param soloVigentes Si true, solo incluye vínculos vigentes (opcional)
     * @return GrafoParentesco con todos los vínculos que cumplen los criterios
     */
    GrafoParentesco consultarGrafoParentesco(String idCiudadano, 
                                            Integer gradoMaximo, 
                                            CategoriaParentesco categoria, 
                                            Boolean soloVigentes);
}
