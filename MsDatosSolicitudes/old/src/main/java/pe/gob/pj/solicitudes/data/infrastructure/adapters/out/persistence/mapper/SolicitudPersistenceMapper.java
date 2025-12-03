package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.SolicitudEntity;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.DiligenciaEntity;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudPersistenceMapper {
    
    public static SolicitudEntity toEntity(Solicitud solicitud) {
        if (solicitud == null) {
            return null;
        }
        
        SolicitudEntity entity = new SolicitudEntity();
        entity.setId(solicitud.getId());
        entity.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        entity.setFechaSolicitud(solicitud.getFechaSolicitud());
        entity.setTipoSolicitud(solicitud.getTipoSolicitud());
        entity.setEstado(solicitud.getEstado());
        entity.setSolicitante(solicitud.getSolicitante());
        entity.setDescripcion(solicitud.getDescripcion());
        
        if (solicitud.getDiligencias() != null) {
            List<DiligenciaEntity> diligencias = solicitud.getDiligencias().stream()
                .map(DiligenciaPersistenceMapper::toEntity)
                .collect(Collectors.toList());
            entity.setDiligencias(diligencias);
        }
        
        return entity;
    }
    
    public static Solicitud toDomain(SolicitudEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Solicitud solicitud = new Solicitud();
        solicitud.setId(entity.getId());
        solicitud.setNumeroSolicitud(entity.getNumeroSolicitud());
        solicitud.setFechaSolicitud(entity.getFechaSolicitud());
        solicitud.setTipoSolicitud(entity.getTipoSolicitud());
        solicitud.setEstado(entity.getEstado());
        solicitud.setSolicitante(entity.getSolicitante());
        solicitud.setDescripcion(entity.getDescripcion());
        
        if (entity.getDiligencias() != null) {
            List<Diligencia> diligencias = entity.getDiligencias().stream()
                .map(DiligenciaPersistenceMapper::toDomain)
                .collect(Collectors.toList());
            solicitud.setDiligencias(diligencias);
        }
        
        return solicitud;
    }
    
    public static List<Solicitud> toDomainList(List<SolicitudEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
            .map(SolicitudPersistenceMapper::toDomain)
            .collect(Collectors.toList());
    }
}
