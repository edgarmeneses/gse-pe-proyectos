package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.agendamiento.domain.ports.in.CrearCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.ActualizarCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.ConsultarCitaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.ListarCitasUseCase;
import pe.gob.reniec.agendamiento.domain.ports.in.CancelarCitaUseCase;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper.CitaDtoMapper;
import pe.gob.reniec.agendamiento.domain.model.Cita;
import java.util.List;
import java.util.Map;

public class CitaController {
    private final CrearCitaUseCase crearCitaUseCase;
    private final ActualizarCitaUseCase actualizarCitaUseCase;
    private final ConsultarCitaUseCase consultarCitaUseCase;
    private final ListarCitasUseCase listarCitasUseCase;
    private final CancelarCitaUseCase cancelarCitaUseCase;
    private final CitaDtoMapper mapper;

    public CitaController(
            CrearCitaUseCase crearCitaUseCase,
            ActualizarCitaUseCase actualizarCitaUseCase,
            ConsultarCitaUseCase consultarCitaUseCase,
            ListarCitasUseCase listarCitasUseCase,
            CancelarCitaUseCase cancelarCitaUseCase,
            CitaDtoMapper mapper) {
        this.crearCitaUseCase = crearCitaUseCase;
        this.actualizarCitaUseCase = actualizarCitaUseCase;
        this.consultarCitaUseCase = consultarCitaUseCase;
        this.listarCitasUseCase = listarCitasUseCase;
        this.cancelarCitaUseCase = cancelarCitaUseCase;
        this.mapper = mapper;
    }

    public CitaResponseDto crearCita(CrearCitaRequestDto request) {
        Cita cita = mapper.requestDtoToDomain(request);
        Cita citaCreada = crearCitaUseCase.crear(cita);
        return mapper.domainToResponseDto(citaCreada);
    }

    public CitaResponseDto actualizarCita(String citaId, ActualizarCitaRequestDto request) {
        Cita cita = mapper.updateRequestDtoToDomain(citaId, request);
        Cita citaActualizada = actualizarCitaUseCase.actualizar(cita);
        return mapper.domainToResponseDto(citaActualizada);
    }

    public CitaResponseDto consultarCita(String citaId) {
        Cita cita = consultarCitaUseCase.consultar(citaId);
        return mapper.domainToResponseDto(cita);
    }

    public ListarCitasResponseDto listarCitas(Map<String, String> filtros) {
        List<Cita> citas = listarCitasUseCase.listar(filtros);
        return mapper.domainListToResponseDto(citas);
    }

    public CitaResponseDto cancelarCita(String citaId, CancelarCitaRequestDto request) {
        Cita cita = cancelarCitaUseCase.cancelar(citaId, request.motivoCancelacion());
        return mapper.domainToResponseDto(cita);
    }
}
