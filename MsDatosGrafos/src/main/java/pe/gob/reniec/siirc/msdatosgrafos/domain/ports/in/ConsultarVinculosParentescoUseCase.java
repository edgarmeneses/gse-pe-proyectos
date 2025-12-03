package pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.CategoriaParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.model.GrafoParentesco;

/**
 * Puerto de entrada para consultar el grafo de vínculos de parentesco de un ciudadano.
 */
public interface ConsultarVinculosParentescoUseCase {
    
    /**
     * Consulta los vínculos de parentesco de un ciudadano con filtros opcionales.
     * 
     * @param idCiudadano Identificador del ciudadano (obligatorio)
     * @param gradoMaximo Grado máximo de parentesco a incluir (opcional)
     * @param categoria Categoría de parentesco a filtrar (opcional)
     * @param soloVigentes Si true, solo incluye vínculos vigentes (opcional)
     * @return GrafoParentesco con los vínculos del ciudadano
     */
    GrafoParentesco consultar(String idCiudadano, 
                             Integer gradoMaximo, 
                             CategoriaParentesco categoria, 
                             Boolean soloVigentes);
}
