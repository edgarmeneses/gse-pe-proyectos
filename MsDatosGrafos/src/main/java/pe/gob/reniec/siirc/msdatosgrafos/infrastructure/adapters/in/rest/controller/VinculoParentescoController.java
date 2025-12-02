package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.ConsultaVinculosResult;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in.ConsultarVinculosParentescoUseCase;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto.ConsultaVinculosResponseDto;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.mapper.VinculoParentescoDtoMapper;

/**
 * Controller REST para gestionar vínculos de parentesco
 * Sin anotaciones de framework (neutralidad tecnológica)
 * 
 * Endpoint: GET /api/v1/APD/MsDatosGrafos/vinculos-parentesco
 */
public class VinculoParentescoController {
    
    private final ConsultarVinculosParentescoUseCase consultarUseCase;
    private final VinculoParentescoDtoMapper mapper;

    public VinculoParentescoController(ConsultarVinculosParentescoUseCase consultarUseCase, 
                                       VinculoParentescoDtoMapper mapper) {
        this.consultarUseCase = consultarUseCase;
        this.mapper = mapper;
    }

    /**
     * Consulta los vínculos de parentesco de un ciudadano
     * 
     * Método HTTP: GET
     * Path: /api/v1/APD/MsDatosGrafos/vinculos-parentesco
     * 
     * Headers:
     * - Authorization: Bearer token JWT
     * - Content-Type: application/json
     * - X-Correlation-ID: UUID de correlación
     * - X-User-Role: Rol del usuario
     * 
     * Query Parameters:
     * @param idCiudadano Identificador del ciudadano (obligatorio, 8-20 chars)
     * @param gradoMaximo Grado máximo de parentesco (opcional, 1-10)
     * @param categoriaParentesco Categoría de parentesco (opcional, 3-20 chars)
     * @param soloVigentes Indica si solo vínculos vigentes (opcional)
     * @param pagina Número de página (opcional, 1-9999)
     * @param registrosPorPagina Cantidad de registros por página (opcional, 1-100)
     * 
     * @return ConsultaVinculosResponseDto con la respuesta
     */
    public ConsultaVinculosResponseDto consultarVinculosParentesco(
            String idCiudadano,
            Long gradoMaximo,
            String categoriaParentesco,
            Boolean soloVigentes,
            Long pagina,
            Long registrosPorPagina,
            String correlationId,
            String userRole) {
        
        ConsultaVinculosResult result = consultarUseCase.consultar(
            idCiudadano, 
            gradoMaximo, 
            categoriaParentesco, 
            soloVigentes, 
            pagina, 
            registrosPorPagina
        );
        
        return mapper.toResponseDto(result, correlationId, "v1.0");
    }
}
