package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.model.Paginacion;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.*;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.mapper.CitaDtoMapper;
import java.time.LocalDate;
import java.util.List;

public class CitaController {
    
    private final CrearCitaUseCase crearCitaUseCase;
    private final ActualizarCitaUseCase actualizarCitaUseCase;
    private final ConsultarCitaUseCase consultarCitaUseCase;
    private final ListarCitasUseCase listarCitasUseCase;
    private final CancelarCitaUseCase cancelarCitaUseCase;
    
    public CitaController(CrearCitaUseCase crearCitaUseCase, ActualizarCitaUseCase actualizarCitaUseCase,
                         ConsultarCitaUseCase consultarCitaUseCase, ListarCitasUseCase listarCitasUseCase,
                         CancelarCitaUseCase cancelarCitaUseCase) {
        this.crearCitaUseCase = crearCitaUseCase;
        this.actualizarCitaUseCase = actualizarCitaUseCase;
        this.consultarCitaUseCase = consultarCitaUseCase;
        this.listarCitasUseCase = listarCitasUseCase;
        this.cancelarCitaUseCase = cancelarCitaUseCase;
    }
    
    public ApiResponseDto<CrearCitaResponseDto> crear(CrearCitaRequestDto request, String correlationId) {
        Cita cita = CitaDtoMapper.toDomain(request);
        Cita citaCreada = crearCitaUseCase.crear(cita);
        return CitaDtoMapper.toApiResponse(citaCreada, correlationId);
    }
    
    public ApiResponseDto<CrearCitaResponseDto> actualizar(String citaId, ActualizarCitaRequestDto request, String correlationId) {
        // Conversión y actualización
        throw new UnsupportedOperationException("Actualizar cita no implementado");
    }
    
    public ApiResponseDto<CrearCitaResponseDto> consultar(String citaId, Boolean incluirHistorial, String correlationId) {
        Cita cita = consultarCitaUseCase.consultar(citaId, incluirHistorial);
        return CitaDtoMapper.toApiResponse(cita, correlationId);
    }
    
    public ApiResponseDto<List<CrearCitaResponseDto>> listar(String codigoSede, String estado, String dniSolicitante,
                                                             String numeroTramite, String idTecnico, LocalDate fechaDesde,
                                                             LocalDate fechaHasta, Integer page, Integer size,
                                                             String sort, String direction, String correlationId) {
        List<Cita> citas = listarCitasUseCase.listar(codigoSede, estado, dniSolicitante, numeroTramite,
                                                     idTecnico, fechaDesde, fechaHasta, page, size, sort, direction);
        
        Paginacion paginacion = listarCitasUseCase.obtenerPaginacion(codigoSede, estado, dniSolicitante,
                                                                     numeroTramite, idTecnico, fechaDesde,
                                                                     fechaHasta, page, size);
        
        throw new UnsupportedOperationException("Listar citas no implementado");
    }
    
    public ApiResponseDto<Void> cancelar(String citaId, CancelarCitaRequestDto request, String correlationId) {
        cancelarCitaUseCase.cancelar(citaId, request.motivoCancelacion(), request.tokenReagendamiento(), request.observaciones());
        throw new UnsupportedOperationException("Cancelar cita no implementado");
    }
}
