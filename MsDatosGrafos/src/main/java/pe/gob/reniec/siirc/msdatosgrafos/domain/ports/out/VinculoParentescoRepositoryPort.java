package pe.gob.reniec.siirc.msdatosgrafos.domain.ports.out;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.ConsultaVinculosResult;

/**
 * Puerto de salida para acceso a datos de vínculos de parentesco (Repository)
 */
public interface VinculoParentescoRepositoryPort {
    
    /**
     * Consulta vínculos de parentesco en la base de datos de grafos
     * 
     * @param idCiudadano Identificador del ciudadano
     * @param gradoMaximo Grado máximo de parentesco
     * @param categoriaParentesco Categoría de parentesco
     * @param soloVigentes Indica si solo se deben retornar vínculos vigentes
     * @param pagina Número de página
     * @param registrosPorPagina Cantidad de registros por página
     * @return Resultado de la consulta con vínculos, resumen y paginación
     */
    ConsultaVinculosResult consultarVinculosParentesco(String idCiudadano, Long gradoMaximo, 
                                                       String categoriaParentesco, Boolean soloVigentes, 
                                                       Long pagina, Long registrosPorPagina);
}
