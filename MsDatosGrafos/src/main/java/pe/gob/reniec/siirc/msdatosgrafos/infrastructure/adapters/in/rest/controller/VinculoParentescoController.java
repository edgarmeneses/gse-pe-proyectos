package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.CategoriaParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.model.GrafoParentesco;
import pe.gob.reniec.siirc.msdatosgrafos.domain.ports.in.ConsultarVinculosParentescoUseCase;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto.VinculosParentescoResponseDto;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.mapper.VinculoParentescoDtoMapper;

/**
 * Controller REST que expone el endpoint de consulta de vínculos de parentesco.
 * La paginación se maneja a nivel de infraestructura, no de dominio.
 */
public class VinculoParentescoController {
    
    private final ConsultarVinculosParentescoUseCase consultarVinculosUseCase;
    private final VinculoParentescoDtoMapper mapper;

    public VinculoParentescoController(ConsultarVinculosParentescoUseCase consultarVinculosUseCase,
                                       VinculoParentescoDtoMapper mapper) {
        this.consultarVinculosUseCase = consultarVinculosUseCase;
        this.mapper = mapper;
    }

    /**
     * GET /api/v1/APD/MsDatosGrafos/vinculos-parentesco
     * 
     * @param idCiudadano Identificador del ciudadano (requerido)
     * @param gradoMaximo Grado máximo de parentesco (opcional)
     * @param categoriaParentesco Categoría de parentesco (opcional: CONSANGUINEO, AFINIDAD)
     * @param soloVigentes Indica si solo se consultan vínculos vigentes (opcional)
     * @param pagina Número de página (opcional, para infraestructura)
     * @param registrosPorPagina Cantidad de registros por página (opcional, para infraestructura)
     * @return VinculosParentescoResponseDto con la información de los vínculos
     */
    public VinculosParentescoResponseDto consultarVinculosParentesco(
            String idCiudadano,
            Integer gradoMaximo,
            String categoriaParentesco,
            Boolean soloVigentes,
            Integer pagina,
            Integer registrosPorPagina) {
        
        // Convertir categoría string a enum de dominio
        CategoriaParentesco categoria = categoriaParentesco != null 
            ? CategoriaParentesco.fromString(categoriaParentesco) 
            : null;
        
        // Llamar al caso de uso de dominio (sin aspectos técnicos como paginación)
        GrafoParentesco grafo = consultarVinculosUseCase.consultar(
            idCiudadano,
            gradoMaximo,
            categoria,
            soloVigentes
        );
        
        // El mapper aplica paginación y construye el DTO de respuesta
        return mapper.toResponseDto(grafo, pagina, registrosPorPagina);
    }
}
