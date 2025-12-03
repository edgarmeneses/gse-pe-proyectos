package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.SolicitudRequestDto;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.SolicitudResponseDto;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.DiligenciaResponseDto;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudDtoMapper {
    
    public static Solicitud toDomain(SolicitudRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        Solicitud solicitud = new Solicitud();
        solicitud.setNumeroSolicitud(dto.numeroSolicitud());
        solicitud.setFechaSolicitud(dto.fechaSolicitud());
        solicitud.setTipoSolicitud(dto.tipoSolicitud());
        solicitud.setEstado(dto.estado());
        solicitud.setSolicitante(dto.solicitante());
        solicitud.setDescripcion(dto.descripcion());
        
        if (dto.diligencias() != null) {
            List<Diligencia> diligencias = dto.diligencias().stream()
                .map(DiligenciaDtoMapper::toDomain)
                .collect(Collectors.toList());
            solicitud.setDiligencias(diligencias);
        }
        
        return solicitud;
    }
    
    public static SolicitudResponseDto toDto(Solicitud solicitud) {
        if (solicitud == null) {
            return null;
        }
        
        List<DiligenciaResponseDto> diligenciasDto = null;
        if (solicitud.getDiligencias() != null) {
            diligenciasDto = solicitud.getDiligencias().stream()
                .map(DiligenciaDtoMapper::toDto)
                .collect(Collectors.toList());
        }
        
        return new SolicitudResponseDto(
            solicitud.getId(),
            solicitud.getNumeroSolicitud(),
            solicitud.getFechaSolicitud(),
            solicitud.getTipoSolicitud(),
            solicitud.getEstado(),
            solicitud.getSolicitante(),
            solicitud.getDescripcion(),
            diligenciasDto
        );
    }
    
    public static List<SolicitudResponseDto> toDtoList(List<Solicitud> solicitudes) {
        if (solicitudes == null) {
            return null;
        }
        return solicitudes.stream()
            .map(SolicitudDtoMapper::toDto)
            .collect(Collectors.toList());
    }
}
