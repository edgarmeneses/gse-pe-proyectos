package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.datosparentesco.domain.ports.in.*;
import pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.mapper.RelacionParentescoDtoMapper;

/**
 * Controller REST para operaciones de relaciones de parentesco.
 * Representa los endpoints definidos en la especificación sin anotaciones de framework.
 */
public class RelacionParentescoController {
    
    private final RegistrarRelacionUseCase registrarRelacionUseCase;
    private final ConsultarRelacionesUseCase consultarRelacionesUseCase;
    private final RelacionParentescoDtoMapper mapper;
    
    public RelacionParentescoController(RegistrarRelacionUseCase registrarRelacionUseCase,
                                       ConsultarRelacionesUseCase consultarRelacionesUseCase,
                                       RelacionParentescoDtoMapper mapper) {
        this.registrarRelacionUseCase = registrarRelacionUseCase;
        this.consultarRelacionesUseCase = consultarRelacionesUseCase;
        this.mapper = mapper;
    }
    
    /**
     * POST /api/v1/parentesco/MsDatosParentesco/relaciones
     * Endpoint para registrar una nueva relación de parentesco entre dos ciudadanos.
     * 
     * @param request Datos de la relación a registrar
     * @param authorization Bearer token JWT
     * @param correlationId Identificador de correlación
     * @return Response con la relación registrada y su relación inversa
     */
    public RegistrarRelacionResponseDto registrarRelacion(RegistrarRelacionRequestDto request,
                                                         String authorization,
                                                         String correlationId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * GET /api/v1/parentesco/MsDatosParentesco/relaciones
     * Endpoint para consultar todas las relaciones de parentesco de un ciudadano.
     * 
     * @param idCiudadano DNI del ciudadano (obligatorio)
     * @param tipoParentesco Filtro opcional por tipo de parentesco
     * @param gradoMaximo Filtro opcional por grado máximo de parentesco
     * @param incluirInactivos Indica si se deben incluir relaciones inactivas
     * @param authorization Bearer token JWT
     * @param correlationId Identificador de correlación
     * @return Response con el ciudadano y sus relaciones
     */
    public ConsultarRelacionesResponseDto consultarRelaciones(String idCiudadano,
                                                             String tipoParentesco,
                                                             Integer gradoMaximo,
                                                             Boolean incluirInactivos,
                                                             String authorization,
                                                             String correlationId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
