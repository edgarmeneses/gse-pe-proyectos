package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.controller;

import pe.gob.pj.solicitudes.data.application.query.SolicitudQueryResult;
import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;
import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.domain.ports.in.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper.SolicitudDtoMapper;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper.DiligenciaDtoMapper;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper.TrazabilidadDtoMapper;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudController {
    
    private final CrearSolicitudUseCase crearSolicitudUseCase;
    private final ListarSolicitudesUseCase listarSolicitudesUseCase;
    private final ConsultarSolicitudUseCase consultarSolicitudUseCase;
    private final ActualizarSolicitudUseCase actualizarSolicitudUseCase;
    private final ConsultarSolicitudesPendientesOfflineUseCase consultarSolicitudesPendientesOfflineUseCase;
    private final CrearDiligenciaUseCase crearDiligenciaUseCase;
    private final VerificarDuplicadosUseCase verificarDuplicadosUseCase;
    private final VerTrazabilidadUseCase verTrazabilidadUseCase;
    private final SolicitudDtoMapper solicitudDtoMapper;
    private final DiligenciaDtoMapper diligenciaDtoMapper;
    private final TrazabilidadDtoMapper trazabilidadDtoMapper;

    public SolicitudController(CrearSolicitudUseCase crearSolicitudUseCase,
                               ListarSolicitudesUseCase listarSolicitudesUseCase,
                               ConsultarSolicitudUseCase consultarSolicitudUseCase,
                               ActualizarSolicitudUseCase actualizarSolicitudUseCase,
                               ConsultarSolicitudesPendientesOfflineUseCase consultarSolicitudesPendientesOfflineUseCase,
                               CrearDiligenciaUseCase crearDiligenciaUseCase,
                               VerificarDuplicadosUseCase verificarDuplicadosUseCase,
                               VerTrazabilidadUseCase verTrazabilidadUseCase,
                               SolicitudDtoMapper solicitudDtoMapper,
                               DiligenciaDtoMapper diligenciaDtoMapper,
                               TrazabilidadDtoMapper trazabilidadDtoMapper) {
        this.crearSolicitudUseCase = crearSolicitudUseCase;
        this.listarSolicitudesUseCase = listarSolicitudesUseCase;
        this.consultarSolicitudUseCase = consultarSolicitudUseCase;
        this.actualizarSolicitudUseCase = actualizarSolicitudUseCase;
        this.consultarSolicitudesPendientesOfflineUseCase = consultarSolicitudesPendientesOfflineUseCase;
        this.crearDiligenciaUseCase = crearDiligenciaUseCase;
        this.verificarDuplicadosUseCase = verificarDuplicadosUseCase;
        this.verTrazabilidadUseCase = verTrazabilidadUseCase;
        this.solicitudDtoMapper = solicitudDtoMapper;
        this.diligenciaDtoMapper = diligenciaDtoMapper;
        this.trazabilidadDtoMapper = trazabilidadDtoMapper;
    }

    public ApiResponse<SolicitudDetalleDto> crearSolicitud(SolicitudRequestDto solicitudRequestDto) {
        Solicitud solicitud = solicitudDtoMapper.toDomain(solicitudRequestDto);
        Solicitud solicitudCreada = crearSolicitudUseCase.ejecutar(solicitud);
        SolicitudDetalleDto detalleDto = solicitudDtoMapper.toDetalleDto(solicitudCreada);
        return ApiResponse.success(detalleDto);
    }

    public ApiResponse<List<SolicitudResponseDto>> listarSolicitudes(String estado, String tipoTramite, String codigoOficina,
                                                        String dniSolicitante, String usuarioAsignado,
                                                        String fechaDesde, String fechaHasta, String prioridad,
                                                        Boolean soloVencidas, Long page, Long size,
                                                        String sort, String direction) {
        // Obtener query result desde use case
        SolicitudQueryResult result = listarSolicitudesUseCase.ejecutar(estado, tipoTramite, codigoOficina,
                dniSolicitante, usuarioAsignado, fechaDesde, fechaHasta, prioridad, soloVencidas, page, size,
                sort, direction);
        
        // Mapear solicitudes a DTOs
        List<SolicitudResponseDto> solicitudesDto = result.getSolicitudes().stream()
                .map(solicitudDtoMapper::toResponseDto)
                .collect(Collectors.toList());
        
        // Crear paginación
        PaginacionDto paginacion = new PaginacionDto(
                result.getPage(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                result.getFirst(),
                result.getLast()
        );
        
        return ApiResponse.success(solicitudesDto, paginacion);
    }

    public ApiResponse<SolicitudDetalleDto> consultarSolicitud(String solicitudId) {
        Solicitud solicitud = consultarSolicitudUseCase.ejecutar(solicitudId);
        
        if (solicitud == null) {
            return ApiResponse.error("NOT_FOUND", "Solicitud con ID '" + solicitudId + "' no encontrada");
        }
        
        SolicitudDetalleDto detalleDto = solicitudDtoMapper.toDetalleDto(solicitud);
        return ApiResponse.success(detalleDto);
    }

    public ApiResponse<SolicitudDetalleDto> actualizarSolicitud(String solicitudId, SolicitudRequestDto solicitudRequestDto) {
        Solicitud solicitud = solicitudDtoMapper.toDomain(solicitudRequestDto);
        Solicitud solicitudActualizada = actualizarSolicitudUseCase.ejecutar(solicitudId, solicitud);
        
        if (solicitudActualizada == null) {
            return ApiResponse.error("NOT_FOUND", "Solicitud con ID '" + solicitudId + "' no encontrada");
        }
        
        SolicitudDetalleDto detalleDto = solicitudDtoMapper.toDetalleDto(solicitudActualizada);
        return ApiResponse.success(detalleDto);
    }

    public ApiResponse<List<SolicitudResponseDto>> consultarSolicitudesPendientesOffline(String oficinaCode, String dispositivoId,
                                                                            String fechaDesde, String fechaHasta,
                                                                            String estadoSincronizacion, Long page,
                                                                            Long size, Boolean incluirDetalles) {
        List<Solicitud> solicitudes = consultarSolicitudesPendientesOfflineUseCase.ejecutar(oficinaCode, dispositivoId,
                fechaDesde, fechaHasta, estadoSincronizacion, page, size, incluirDetalles);
        
        List<SolicitudResponseDto> solicitudesDto = solicitudes.stream()
                .map(solicitudDtoMapper::toResponseDto)
                .collect(Collectors.toList());
        
        return ApiResponse.success(solicitudesDto);
    }

    public ApiResponse<DiligenciaResponseDto> crearDiligencia(String solicitudId, DiligenciaRequestDto diligenciaRequestDto) {
        Diligencia diligencia = diligenciaDtoMapper.toDomain(diligenciaRequestDto);
        diligencia.setSolicitudId(solicitudId);
        Diligencia diligenciaCreada = crearDiligenciaUseCase.ejecutar(diligencia);
        DiligenciaResponseDto diligenciaDto = diligenciaDtoMapper.toResponseDto(diligenciaCreada);
        return ApiResponse.success(diligenciaDto);
    }

    public ApiResponse<VerificarDuplicadosResponseDto> verificarDuplicados(VerificarDuplicadosRequestDto requestDto) {
        Boolean resultado = verificarDuplicadosUseCase.ejecutar(requestDto.solicitudId(), requestDto.fechaDesde(),
                requestDto.fechaHasta(), requestDto.tipoEvento(), requestDto.usuarioId(), requestDto.limit(),
                requestDto.offset(), requestDto.ordenamiento(), requestDto.incluirDatosDetallados());
        VerificarDuplicadosResponseDto responseDto = new VerificarDuplicadosResponseDto(resultado);
        return ApiResponse.success(responseDto);
    }

    public ApiResponse<TrazabilidadResponseDto> verTrazabilidad(String solicitudId, String fechaDesde, String fechaHasta,
                                                   String tipoEvento, String usuarioId, Long limit, Long offset,
                                                   String ordenamiento, Boolean incluirDatosDetallados) {
        // Obtener query result desde use case
        TrazabilidadQueryResult result = verTrazabilidadUseCase.ejecutar(solicitudId, fechaDesde, fechaHasta, tipoEvento,
                usuarioId, limit, offset, ordenamiento, incluirDatosDetallados);
        
        // Mapear a DTO
        TrazabilidadResponseDto trazabilidadDto = trazabilidadDtoMapper.toResponseDto(result);
        return ApiResponse.success(trazabilidadDto);
    }
}
