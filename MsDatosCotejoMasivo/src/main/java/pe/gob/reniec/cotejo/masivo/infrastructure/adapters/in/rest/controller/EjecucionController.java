package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.*;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper.EjecucionDtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EjecucionController {
    private final CrearEjecucionUseCase crearEjecucionUseCase;
    private final RegistrarRegistrosEntradaUseCase registrarRegistrosEntradaUseCase;
    private final RegistrarResultadosCotejoUseCase registrarResultadosCotejoUseCase;
    private final ListarEjecucionesUseCase listarEjecucionesUseCase;
    private final ConsultarEjecucionUseCase consultarEjecucionUseCase;
    private final EjecucionDtoMapper mapper;

    public EjecucionController(CrearEjecucionUseCase crearEjecucionUseCase,
                               RegistrarRegistrosEntradaUseCase registrarRegistrosEntradaUseCase,
                               RegistrarResultadosCotejoUseCase registrarResultadosCotejoUseCase,
                               ListarEjecucionesUseCase listarEjecucionesUseCase,
                               ConsultarEjecucionUseCase consultarEjecucionUseCase,
                               EjecucionDtoMapper mapper) {
        this.crearEjecucionUseCase = crearEjecucionUseCase;
        this.registrarRegistrosEntradaUseCase = registrarRegistrosEntradaUseCase;
        this.registrarResultadosCotejoUseCase = registrarResultadosCotejoUseCase;
        this.listarEjecucionesUseCase = listarEjecucionesUseCase;
        this.consultarEjecucionUseCase = consultarEjecucionUseCase;
        this.mapper = mapper;
    }

    public EjecucionResponseDto crearEjecucion(CrearEjecucionRequestDto request) {
        Ejecucion ejecucion = mapper.toDomain(request);
        Ejecucion ejecucionCreada = crearEjecucionUseCase.crear(ejecucion);
        return mapper.toResponseDto(ejecucionCreada);
    }

    public RegistrarRegistrosResponseDto registrarRegistros(String ejecucionId, RegistrarRegistrosRequestDto request) {
        List<RegistroEntrada> registros = request.getRegistros().stream()
                .map(dto -> mapper.toDomain(dto, ejecucionId))
                .collect(Collectors.toList());
        
        RegistrarRegistrosEntradaUseCase.ResultadoRegistroBatch resultado = 
                registrarRegistrosEntradaUseCase.registrarBatch(ejecucionId, registros);
        
        throw new UnsupportedOperationException("Implementación de mapeo pendiente");
    }

    public RegistrarResultadosResponseDto registrarResultados(String ejecucionId, RegistrarResultadosRequestDto request) {
        List<ResultadoCotejo> resultados = request.getResultados().stream()
                .map(dto -> mapper.toDomain(dto, ejecucionId))
                .collect(Collectors.toList());
        
        RegistrarResultadosCotejoUseCase.ResultadoRegistroCotejoBatch resultado = 
                registrarResultadosCotejoUseCase.registrarBatch(ejecucionId, resultados);
        
        throw new UnsupportedOperationException("Implementación de mapeo pendiente");
    }

    public ListarEjecucionesResponseDto listarEjecuciones(String solicitudId, String codigoOrganizacion,
                                                          String codigoEnvio, String codigoEstado,
                                                          String fechaDesde, String fechaHasta,
                                                          Integer page, Integer size,
                                                          String sort, String direction) {
        ListarEjecucionesUseCase.FiltrosEjecucion filtros = new ListarEjecucionesUseCase.FiltrosEjecucion();
        filtros.setSolicitudId(solicitudId);
        filtros.setCodigoOrganizacion(codigoOrganizacion);
        filtros.setCodigoEnvio(codigoEnvio);
        filtros.setCodigoEstado(codigoEstado);
        
        ListarEjecucionesUseCase.Paginacion paginacion = 
                new ListarEjecucionesUseCase.Paginacion(page, size, sort, direction);
        
        ListarEjecucionesUseCase.ResultadoPaginado resultado = listarEjecucionesUseCase.listar(filtros, paginacion);
        
        return mapper.toListaResponseDto(resultado.getEjecuciones());
    }

    public ConsultarEjecucionResponseDto consultarEjecucion(String ejecucionId) {
        Ejecucion ejecucion = consultarEjecucionUseCase.consultarPorId(ejecucionId);
        return mapper.toDetalleResponseDto(ejecucion);
    }
}
