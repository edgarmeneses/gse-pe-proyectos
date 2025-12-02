package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.datosparentesco.domain.ports.in.CrearAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ConsultarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ListarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ActualizarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.mapper.AnalisisDtoMapper;

public class AnalisisController {
    private final CrearAnalisisUseCase crearAnalisisUseCase;
    private final ConsultarAnalisisUseCase consultarAnalisisUseCase;
    private final ListarAnalisisUseCase listarAnalisisUseCase;
    private final ActualizarAnalisisUseCase actualizarAnalisisUseCase;
    private final AnalisisDtoMapper analisisDtoMapper;

    public AnalisisController(CrearAnalisisUseCase crearAnalisisUseCase,
                              ConsultarAnalisisUseCase consultarAnalisisUseCase,
                              ListarAnalisisUseCase listarAnalisisUseCase,
                              ActualizarAnalisisUseCase actualizarAnalisisUseCase,
                              AnalisisDtoMapper analisisDtoMapper) {
        this.crearAnalisisUseCase = crearAnalisisUseCase;
        this.consultarAnalisisUseCase = consultarAnalisisUseCase;
        this.listarAnalisisUseCase = listarAnalisisUseCase;
        this.actualizarAnalisisUseCase = actualizarAnalisisUseCase;
        this.analisisDtoMapper = analisisDtoMapper;
    }

    public AnalisisResponseDto guardarAnalisis(AnalisisRequestDto request, String authorization,
                                               String contentType, String correlationId, String userRole) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public AnalisisDetalleResponseDto consultarAnalisisPorId(String idAnalisis, String authorization,
                                                              String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public AnalisisListaResponseDto listarAnalisis(String idCiudadano, String idSolicitud, String estado,
                                                    String tipoVinculo, String fechaDesde, String fechaHasta,
                                                    String usuarioTecnico, Integer pagina, Integer tamanioPagina,
                                                    String authorization, String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public ActualizarAnalisisResponseDto actualizarAnalisis(String idAnalisis, ActualizarAnalisisRequestDto request,
                                                            String authorization, String contentType,
                                                            String correlationId) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
