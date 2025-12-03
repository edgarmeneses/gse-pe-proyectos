package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.controller;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import pe.gob.pj.solicitudes.data.domain.ports.in.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper.*;
import java.util.List;

public class SolicitudController {
    
    private final CrearSolicitudUseCase crearSolicitudUseCase;
    private final ActualizarSolicitudUseCase actualizarSolicitudUseCase;
    private final ConsultarSolicitudUseCase consultarSolicitudUseCase;
    private final ListarSolicitudesUseCase listarSolicitudesUseCase;
    private final CrearDiligenciaUseCase crearDiligenciaUseCase;
    private final VerificarDuplicadosUseCase verificarDuplicadosUseCase;
    private final VerTrazabilidadUseCase verTrazabilidadUseCase;
    
    public SolicitudController(
            CrearSolicitudUseCase crearSolicitudUseCase,
            ActualizarSolicitudUseCase actualizarSolicitudUseCase,
            ConsultarSolicitudUseCase consultarSolicitudUseCase,
            ListarSolicitudesUseCase listarSolicitudesUseCase,
            CrearDiligenciaUseCase crearDiligenciaUseCase,
            VerificarDuplicadosUseCase verificarDuplicadosUseCase,
            VerTrazabilidadUseCase verTrazabilidadUseCase) {
        this.crearSolicitudUseCase = crearSolicitudUseCase;
        this.actualizarSolicitudUseCase = actualizarSolicitudUseCase;
        this.consultarSolicitudUseCase = consultarSolicitudUseCase;
        this.listarSolicitudesUseCase = listarSolicitudesUseCase;
        this.crearDiligenciaUseCase = crearDiligenciaUseCase;
        this.verificarDuplicadosUseCase = verificarDuplicadosUseCase;
        this.verTrazabilidadUseCase = verTrazabilidadUseCase;
    }
    
    public SolicitudResponseDto crear(SolicitudRequestDto request) {
        Solicitud solicitud = SolicitudDtoMapper.toDomain(request);
        Solicitud solicitudCreada = crearSolicitudUseCase.crear(solicitud);
        return SolicitudDtoMapper.toDto(solicitudCreada);
    }
    
    public List<SolicitudResponseDto> listar() {
        List<Solicitud> solicitudes = listarSolicitudesUseCase.listar();
        return SolicitudDtoMapper.toDtoList(solicitudes);
    }
    
    public SolicitudResponseDto obtenerPorId(Long id) {
        Solicitud solicitud = consultarSolicitudUseCase.consultar(id);
        return SolicitudDtoMapper.toDto(solicitud);
    }
    
    public SolicitudResponseDto actualizar(Long id, SolicitudRequestDto request) {
        Solicitud solicitud = SolicitudDtoMapper.toDomain(request);
        Solicitud solicitudActualizada = actualizarSolicitudUseCase.actualizar(id, solicitud);
        return SolicitudDtoMapper.toDto(solicitudActualizada);
    }
    
    public DiligenciaResponseDto crearDiligencia(Long solicitudId, DiligenciaRequestDto request) {
        Diligencia diligencia = DiligenciaDtoMapper.toDomain(request);
        Diligencia diligenciaCreada = crearDiligenciaUseCase.crear(solicitudId, diligencia);
        return DiligenciaDtoMapper.toDto(diligenciaCreada);
    }
    
    public VerificarDuplicadosResponseDto verificarDuplicados(VerificarDuplicadosRequestDto request) {
        Boolean existeDuplicado = verificarDuplicadosUseCase.verificar(request.criterio());
        return new VerificarDuplicadosResponseDto(existeDuplicado);
    }
    
    public List<TrazabilidadResponseDto> verTrazabilidad(Long solicitudId) {
        List<Trazabilidad> trazabilidades = verTrazabilidadUseCase.ver(solicitudId);
        return TrazabilidadDtoMapper.toDtoList(trazabilidades);
    }
}
