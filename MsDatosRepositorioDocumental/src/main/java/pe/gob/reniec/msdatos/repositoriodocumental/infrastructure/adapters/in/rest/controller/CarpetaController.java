package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper.CarpetaDtoMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller REST: Carpetas
 * Expone los endpoints para la gestión de carpetas sin usar anotaciones.
 */
public class CarpetaController {

    private final CrearCarpetaUseCase crearCarpetaUseCase;
    private final ActualizarCarpetaUseCase actualizarCarpetaUseCase;
    private final ConsultarCarpetaUseCase consultarCarpetaUseCase;

    public CarpetaController(
            CrearCarpetaUseCase crearCarpetaUseCase,
            ActualizarCarpetaUseCase actualizarCarpetaUseCase,
            ConsultarCarpetaUseCase consultarCarpetaUseCase) {
        this.crearCarpetaUseCase = crearCarpetaUseCase;
        this.actualizarCarpetaUseCase = actualizarCarpetaUseCase;
        this.consultarCarpetaUseCase = consultarCarpetaUseCase;
    }

    /**
     * POST /api/v1/documentos/MsDatosRepositorioDocumental/carpeta
     * Crea una nueva carpeta
     */
    public CrearCarpetaResponseDto crear(CrearCarpetaRequestDto request) {
        Carpeta carpeta = CarpetaDtoMapper.toDomain(request);
        Carpeta creada = crearCarpetaUseCase.crear(carpeta);
        return CarpetaDtoMapper.toCrearResponseDto(creada);
    }

    /**
     * PUT /api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}
     * Actualiza una carpeta existente
     */
    public ActualizarCarpetaResponseDto actualizar(String id, ActualizarCarpetaRequestDto request) {
        Carpeta carpeta = CarpetaDtoMapper.toDomain(request);
        Carpeta actualizada = actualizarCarpetaUseCase.actualizar(id, carpeta);
        return CarpetaDtoMapper.toActualizarResponseDto(actualizada);
    }

    /**
     * GET /api/v1/documentos/MsDatosRepositorioDocumental/carpeta/{id}
     * Consulta el contenido de una carpeta
     */
    public ConsultarCarpetaResponseDto consultarContenido(String id, String queryParam1, String queryParam2, 
                                                           String queryParam3, Integer page, Integer size) {
        Map<String, String> filtros = new HashMap<>();
        if (queryParam1 != null) filtros.put("queryParam1", queryParam1);
        if (queryParam2 != null) filtros.put("queryParam2", queryParam2);
        if (queryParam3 != null) filtros.put("queryParam3", queryParam3);
        
        return consultarCarpetaUseCase.consultarContenido(id, filtros, page, size);
    }
}
