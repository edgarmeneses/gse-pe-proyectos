package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import pe.gob.reniec.agendamiento.msdatos.domain.model.FiltroCita;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper.CitaDtoMapper;

public class CitaController {
    
    private final CrearCitaUseCase crearCitaUseCase;
    private final ActualizarCitaUseCase actualizarCitaUseCase;
    private final ConsultarCitaUseCase consultarCitaUseCase;
    private final ListarCitasUseCase listarCitasUseCase;
    private final CancelarCitaUseCase cancelarCitaUseCase;
    private final CitaDtoMapper mapper;

    public CitaController(CrearCitaUseCase crearCitaUseCase,
                          ActualizarCitaUseCase actualizarCitaUseCase,
                          ConsultarCitaUseCase consultarCitaUseCase,
                          ListarCitasUseCase listarCitasUseCase,
                          CancelarCitaUseCase cancelarCitaUseCase) {
        this.crearCitaUseCase = crearCitaUseCase;
        this.actualizarCitaUseCase = actualizarCitaUseCase;
        this.consultarCitaUseCase = consultarCitaUseCase;
        this.listarCitasUseCase = listarCitasUseCase;
        this.cancelarCitaUseCase = cancelarCitaUseCase;
        this.mapper = new CitaDtoMapper();
    }

    public CrearCitaResponseDto crear(CrearCitaRequestDto request) {
        Cita cita = mapper.toDomain(request);
        Cita citaCreada = crearCitaUseCase.crear(cita);
        return mapper.toCrearResponseDto(citaCreada);
    }

    public ActualizarCitaResponseDto actualizar(String citaId, ActualizarCitaRequestDto request) {
        Cita citaActualizada = mapper.toDomainActualizar(request);
        Cita cita = actualizarCitaUseCase.actualizar(citaId, citaActualizada);
        return mapper.toActualizarResponseDto(cita);
    }

    public ConsultarCitaResponseDto consultar(String citaId, Boolean incluirHistorial) {
        Cita cita = consultarCitaUseCase.consultar(citaId, incluirHistorial);
        return mapper.toConsultarResponseDto(cita);
    }

    public ListarCitasResponseDto listar(String codigoSede, String estado, String dniSolicitante, 
                                          String numeroTramite, String idTecnico, String fechaDesde,
                                          String fechaHasta, Integer page, Integer size, 
                                          String sort, String direction) {
        FiltroCita filtro = mapper.toFiltroCita(codigoSede, estado, dniSolicitante,
            numeroTramite, idTecnico, fechaDesde, fechaHasta, page, size, sort, direction);
        ListarCitasUseCase.ResultadoPaginado resultado = listarCitasUseCase.listar(filtro);
        return mapper.toListarResponseDto(resultado);
    }

    public CancelarCitaResponseDto cancelar(String citaId, CancelarCitaRequestDto request) {
        CancelarCitaUseCase.ResultadoCancelacion resultado = cancelarCitaUseCase.cancelar(
            citaId, 
            request.tokenReagendamiento(), 
            request.motivoCancelacion(), 
            request.observaciones()
        );
        return mapper.toCancelarResponseDto(resultado);
    }
}
