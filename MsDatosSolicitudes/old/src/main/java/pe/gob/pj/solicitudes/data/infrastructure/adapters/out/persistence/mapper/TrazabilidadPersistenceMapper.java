package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.TrazabilidadEntity;
import java.util.List;
import java.util.stream.Collectors;

public class TrazabilidadPersistenceMapper {
    
    public static TrazabilidadEntity toEntity(Trazabilidad trazabilidad) {
        if (trazabilidad == null) {
            return null;
        }
        
        TrazabilidadEntity entity = new TrazabilidadEntity();
        entity.setId(trazabilidad.getId());
        entity.setSolicitudId(trazabilidad.getSolicitudId());
        entity.setFecha(trazabilidad.getFecha());
        entity.setAccion(trazabilidad.getAccion());
        entity.setUsuario(trazabilidad.getUsuario());
        entity.setDetalle(trazabilidad.getDetalle());
        
        return entity;
    }
    
    public static Trazabilidad toDomain(TrazabilidadEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Trazabilidad trazabilidad = new Trazabilidad();
        trazabilidad.setId(entity.getId());
        trazabilidad.setSolicitudId(entity.getSolicitudId());
        trazabilidad.setFecha(entity.getFecha());
        trazabilidad.setAccion(entity.getAccion());
        trazabilidad.setUsuario(entity.getUsuario());
        trazabilidad.setDetalle(entity.getDetalle());
        
        return trazabilidad;
    }
    
    public static List<Trazabilidad> toDomainList(List<TrazabilidadEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
            .map(TrazabilidadPersistenceMapper::toDomain)
            .collect(Collectors.toList());
    }
}
