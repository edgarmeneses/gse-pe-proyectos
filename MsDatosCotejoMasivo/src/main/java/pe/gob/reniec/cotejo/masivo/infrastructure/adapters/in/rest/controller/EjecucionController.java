package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.*;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper.EjecucionDtoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class EjecucionController {
    private final CrearEjecucionUseCase crearEjecucionUseCase;
    private final RegistrarRegistrosEntradaUseCase registrarRegistrosEntradaUseCase;
    private final RegistrarResultadosCotejoUseCase registrarResultadosCotejoUseCase;
    private final ListarEjecucionesUseCase listarEjecucionesUseCase;
    private final ConsultarEjecucionUseCase consultarEjecucionUseCase;

    public EjecucionController(CrearEjecucionUseCase crearEjecucionUseCase,
                               RegistrarRegistrosEntradaUseCase registrarRegistrosEntradaUseCase,
                               RegistrarResultadosCotejoUseCase registrarResultadosCotejoUseCase,
                               ListarEjecucionesUseCase listarEjecucionesUseCase,
                               ConsultarEjecucionUseCase consultarEjecucionUseCase) {
        this.crearEjecucionUseCase = crearEjecucionUseCase;
        this.registrarRegistrosEntradaUseCase = registrarRegistrosEntradaUseCase;
        this.registrarResultadosCotejoUseCase = registrarResultadosCotejoUseCase;
        this.listarEjecucionesUseCase = listarEjecucionesUseCase;
        this.consultarEjecucionUseCase = consultarEjecucionUseCase;
    }

    public EjecucionResponseDto crear(CrearEjecucionRequestDto request) {
        Ejecucion ejecucion = EjecucionDtoMapper.toDomain(request);
        Ejecucion ejecucionCreada = crearEjecucionUseCase.crear(ejecucion);
        return EjecucionDtoMapper.toResponseDto(ejecucionCreada);
    }

    public RegistrarRegistrosEntradaResponseDto registrarRegistrosEntrada(UUID ejecucionId, 
                                                                          RegistrarRegistrosEntradaRequestDto request) {
        List<RegistroEntrada> registros = EjecucionDtoMapper.toRegistroEntradaDomain(request.registros());
        List<RegistroEntrada> registrosGuardados = registrarRegistrosEntradaUseCase.registrar(ejecucionId, registros);
        throw new UnsupportedOperationException("Mapeo de respuesta no implementado");
    }

    public RegistrarResultadosCotejoResponseDto registrarResultadosCotejo(UUID ejecucionId,
                                                                          RegistrarResultadosCotejoRequestDto request) {
        List<ResultadoCotejo> resultados = EjecucionDtoMapper.toResultadoCotejoDomain(request.resultados());
        List<ResultadoCotejo> resultadosGuardados = registrarResultadosCotejoUseCase.registrar(ejecucionId, resultados);
        throw new UnsupportedOperationException("Mapeo de respuesta no implementado");
    }

    public ListarEjecucionesResponseDto listar(UUID solicitudId, String codigoOrganizacion, String codigoEnvio,
                                               String codigoEstado, LocalDateTime fechaDesde, LocalDateTime fechaHasta,
                                               Integer page, Integer size, String sort, String direction) {
        List<Ejecucion> ejecuciones = listarEjecucionesUseCase.listar(solicitudId, codigoOrganizacion, codigoEnvio,
                                                                       codigoEstado, fechaDesde, fechaHasta,
                                                                       page, size, sort, direction);
        List<EjecucionListItemDto> items = EjecucionDtoMapper.toListItemDtos(ejecuciones);
        PaginationDto pagination = new PaginationDto(page, size, items.size(), 1, true, true);
        return new ListarEjecucionesResponseDto(items, pagination);
    }

    public EjecucionDetalleResponseDto obtenerPorId(UUID ejecucionId) {
        Ejecucion ejecucion = consultarEjecucionUseCase.consultar(ejecucionId);
        return EjecucionDtoMapper.toDetalleResponseDto(ejecucion);
    }
}
