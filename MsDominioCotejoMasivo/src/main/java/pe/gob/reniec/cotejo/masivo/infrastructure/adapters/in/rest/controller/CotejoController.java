package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ConsultarEstadoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.EjecutarCotejoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ObtenerResultadosUseCase;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.EjecutarCotejoRequestDto;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.EjecutarCotejoResponseDto;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.ConsultarEstadoResponseDto;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.ObtenerResultadosResponseDto;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper.CotejoDtoMapper;

public class CotejoController {
    private final EjecutarCotejoUseCase ejecutarCotejoUseCase;
    private final ConsultarEstadoUseCase consultarEstadoUseCase;
    private final ObtenerResultadosUseCase obtenerResultadosUseCase;
    private final CotejoDtoMapper mapper;

    public CotejoController(EjecutarCotejoUseCase ejecutarCotejoUseCase,
                           ConsultarEstadoUseCase consultarEstadoUseCase,
                           ObtenerResultadosUseCase obtenerResultadosUseCase,
                           CotejoDtoMapper mapper) {
        this.ejecutarCotejoUseCase = ejecutarCotejoUseCase;
        this.consultarEstadoUseCase = consultarEstadoUseCase;
        this.obtenerResultadosUseCase = obtenerResultadosUseCase;
        this.mapper = mapper;
    }

    public EjecutarCotejoResponseDto ejecutarCotejo(EjecutarCotejoRequestDto request) {
        EjecutarCotejoUseCase.SolicitudCotejo solicitud = mapper.toSolicitudCotejo(request);
        
        EjecutarCotejoUseCase.ResultadoEjecucionCotejo resultado = ejecutarCotejoUseCase.ejecutar(solicitud);
        
        return mapper.toEjecutarCotejoResponseDto(resultado);
    }

    public ConsultarEstadoResponseDto consultarEstado(String ejecucionId) {
        Ejecucion ejecucion = consultarEstadoUseCase.consultarEstado(ejecucionId);
        
        return mapper.toConsultarEstadoResponseDto(ejecucion);
    }

    public ObtenerResultadosResponseDto obtenerResultados(String ejecucionId, String codigoResultado,
                                                          Integer page, Integer size) {
        ObtenerResultadosUseCase.FiltrosResultados filtros = new ObtenerResultadosUseCase.FiltrosResultados(ejecucionId);
        filtros.setCodigoResultado(codigoResultado);
        filtros.setPage(page);
        filtros.setSize(size);
        
        ObtenerResultadosUseCase.ResultadoPaginado resultado = obtenerResultadosUseCase.obtenerResultados(filtros);
        
        return mapper.toObtenerResultadosResponseDto(resultado);
    }
}
