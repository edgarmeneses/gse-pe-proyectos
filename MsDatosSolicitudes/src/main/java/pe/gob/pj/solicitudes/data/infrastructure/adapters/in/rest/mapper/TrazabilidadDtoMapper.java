package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.*;
import pe.gob.pj.solicitudes.data.application.query.TrazabilidadQueryResult;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.*;
import java.util.stream.Collectors;

public class TrazabilidadDtoMapper {

    public TrazabilidadResponseDto toResponseDto(TrazabilidadQueryResult queryResult) {
        if (queryResult == null || queryResult.getTrazabilidad() == null) {
            return null;
        }

        Trazabilidad trazabilidad = queryResult.getTrazabilidad();
        
        return new TrazabilidadResponseDto(
                trazabilidad.getSolicitudId(),
                trazabilidad.getNumeroSolicitud(),
                trazabilidad.getTipoTramite(),
                trazabilidad.getEstadoActual(),
                trazabilidad.getFechaCreacion(),
                trazabilidad.getFechaUltimaModificacion(),
                trazabilidad.getTotalEventos(),
                trazabilidad.getEventos() != null ?
                        trazabilidad.getEventos().stream()
                                .map(this::toEventoDto)
                                .collect(Collectors.toList()) : null,
                toResumenEventosDto(queryResult),
                toEstadisticasDto(queryResult),
                toPaginacionDto(queryResult)
        );
    }

    private EventoDto toEventoDto(Evento evento) {
        if (evento == null) {
            return null;
        }
        return new EventoDto(
                evento.getEventoId(),
                evento.getTipoEvento(),
                evento.getFechaHora(),
                evento.getDescripcion(),
                toUsuarioDto(evento.getUsuario()),
                toOficinaDto(evento.getOficina()),
                evento.getDetalles(),
                evento.getMetadatos(),
                evento.getEstadoAnterior(),
                evento.getEstadoNuevo()
        );
    }

    private UsuarioDto toUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(
                usuario.getUsuarioId(),
                usuario.getNombreCompleto(),
                usuario.getRol(),
                usuario.getEmail()
        );
    }

    private OficinaDto toOficinaDto(Oficina oficina) {
        if (oficina == null) {
            return null;
        }
        return new OficinaDto(
                oficina.getCodigo(),
                oficina.getNombre()
        );
    }

    private ResumenEventosDto toResumenEventosDto(TrazabilidadQueryResult queryResult) {
        if (queryResult == null) {
            return null;
        }
        return new ResumenEventosDto(
                queryResult.getTotalCambiosEstado(),
                queryResult.getTotalModificaciones(),
                queryResult.getTotalAsignaciones(),
                queryResult.getTotalDiligencias(),
                queryResult.getTotalValidaciones(),
                queryResult.getTotalComentarios(),
                queryResult.getTotalNotificaciones()
        );
    }

    private EstadisticasDto toEstadisticasDto(TrazabilidadQueryResult queryResult) {
        if (queryResult == null) {
            return null;
        }
        return new EstadisticasDto(
                queryResult.getTiempoTotalProceso(),
                queryResult.getTiempoPorEtapa(),
                queryResult.getUsuariosInvolucrados(),
                queryResult.getOficinasProceso()
        );
    }

    private PaginacionDto toPaginacionDto(TrazabilidadQueryResult queryResult) {
        if (queryResult == null) {
            return null;
        }
        return new PaginacionDto(
                queryResult.getPage(),
                queryResult.getSize(),
                queryResult.getTotalElements(),
                queryResult.getTotalPages(),
                queryResult.getFirst(),
                queryResult.getLast()
        );
    }
}
