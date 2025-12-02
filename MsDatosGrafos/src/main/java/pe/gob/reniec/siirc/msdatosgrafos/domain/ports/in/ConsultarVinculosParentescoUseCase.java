package pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.ConsultaVinculosResult;

/**
 * Puerto de entrada para el caso de uso de consultar vínculos de parentesco
 */
public interface ConsultarVinculosParentescoUseCase {
    
    /**
     * Consulta los vínculos de parentesco de un ciudadano
     * 
     * @param idCiudadano Identificador del ciudadano
     * @param gradoMaximo Grado máximo de parentesco (opcional)
     * @param categoriaParentesco Categoría de parentesco (CONSANGUINEO, AFINIDAD) (opcional)
     * @param soloVigentes Indica si solo se deben retornar vínculos vigentes (opcional)
     * @param pagina Número de página (opcional)
     * @param registrosPorPagina Cantidad de registros por página (opcional)
     * @return Resultado de la consulta con vínculos, resumen y paginación
     */
    ConsultaVinculosResult consultar(String idCiudadano, Long gradoMaximo, String categoriaParentesco,
                                     Boolean soloVigentes, Long pagina, Long registrosPorPagina);
}
