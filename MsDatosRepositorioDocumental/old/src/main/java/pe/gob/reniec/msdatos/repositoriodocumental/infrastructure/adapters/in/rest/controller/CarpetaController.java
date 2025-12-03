package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ConsultarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper.CarpetaDtoMapper;
import java.util.List;
import java.util.Map;

public class CarpetaController {
    private final CrearCarpetaUseCase crearCarpetaUseCase;
    private final ActualizarCarpetaUseCase actualizarCarpetaUseCase;
    private final ConsultarCarpetaUseCase consultarCarpetaUseCase;

    public CarpetaController(CrearCarpetaUseCase crearCarpetaUseCase,
                            ActualizarCarpetaUseCase actualizarCarpetaUseCase,
                            ConsultarCarpetaUseCase consultarCarpetaUseCase) {
        this.crearCarpetaUseCase = crearCarpetaUseCase;
        this.actualizarCarpetaUseCase = actualizarCarpetaUseCase;
        this.consultarCarpetaUseCase = consultarCarpetaUseCase;
    }

    public CarpetaResponseDto crear(CarpetaRequestDto request, Map<String, String> headers) {
        Carpeta carpeta = crearCarpetaUseCase.crear(
            request.nombre(),
            request.parentId(),
            request.descripcion()
        );
        return CarpetaDtoMapper.toResponseDto(carpeta);
    }

    public ActualizarCarpetaResponseDto actualizar(String id, ActualizarCarpetaRequestDto request, 
                                                   Map<String, String> headers) {
        Carpeta carpeta = actualizarCarpetaUseCase.actualizar(
            id,
            request.nombre(),
            request.estadoCarpeta(),
            request.parentId(),
            request.descripcion()
        );
        List<String> camposActualizados = List.of();
        return CarpetaDtoMapper.toActualizarResponseDto(carpeta, camposActualizados);
    }

    public ConsultarCarpetaResponseDto consultarContenido(String id, String queryParam1, String queryParam2, 
                                                  String queryParam3, Integer page, Integer size, 
                                                  Map<String, String> headers) {
        Map<String, Object> resultado = consultarCarpetaUseCase.consultarContenido(
            id, queryParam1, queryParam2, queryParam3, page, size
        );
        return CarpetaDtoMapper.toConsultarCarpetaResponseDto(resultado);
    }
}
