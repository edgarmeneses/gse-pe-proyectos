package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.entity.AlertaEntity;

public class AlertaPersistenceMapper {

    public static AlertaEntity toEntity(Alerta alerta) {
        if (alerta == null) {
            return null;
        }
        
        AlertaEntity entity = new AlertaEntity();
        entity.setId(alerta.getId());
        entity.setCiudadanoId(alerta.getCiudadanoId());
        entity.setSituacion(alerta.getSituacion());
        entity.setMotivo(alerta.getMotivo());
        entity.setFechaDeteccion(alerta.getFechaDeteccion());
        entity.setCircunscripcionId(alerta.getCircunscripcionId());
        entity.setMedioVerificacion(alerta.getMedioVerificacion());
        entity.setDocumentoSoporteId(alerta.getDocumentoSoporteId());
        entity.setEquipoTrabajoId(alerta.getEquipoTrabajoId());
        entity.setFechaCreacion(alerta.getFechaCreacion());
        entity.setFechaActualizacion(alerta.getFechaActualizacion());
        entity.setEstado(alerta.getEstado());
        
        return entity;
    }

    public static Alerta toDomain(AlertaEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Alerta alerta = new Alerta();
        alerta.setId(entity.getId());
        alerta.setCiudadanoId(entity.getCiudadanoId());
        alerta.setSituacion(entity.getSituacion());
        alerta.setMotivo(entity.getMotivo());
        alerta.setFechaDeteccion(entity.getFechaDeteccion());
        alerta.setCircunscripcionId(entity.getCircunscripcionId());
        alerta.setMedioVerificacion(entity.getMedioVerificacion());
        alerta.setDocumentoSoporteId(entity.getDocumentoSoporteId());
        alerta.setEquipoTrabajoId(entity.getEquipoTrabajoId());
        alerta.setFechaCreacion(entity.getFechaCreacion());
        alerta.setFechaActualizacion(entity.getFechaActualizacion());
        alerta.setEstado(entity.getEstado());
        
        return alerta;
    }
}
