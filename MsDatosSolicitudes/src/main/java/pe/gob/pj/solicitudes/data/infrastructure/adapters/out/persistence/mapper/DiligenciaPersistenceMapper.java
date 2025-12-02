package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.DiligenciaEntity;
import java.util.List;
import java.util.stream.Collectors;

public class DiligenciaPersistenceMapper {
    
    public static DiligenciaEntity toEntity(Diligencia diligencia) {
        if (diligencia == null) {
            return null;
        }
        
        DiligenciaEntity entity = new DiligenciaEntity();
        entity.setId(diligencia.getId());
        entity.setNumeroDiligencia(diligencia.getNumeroDiligencia());
        entity.setFechaDiligencia(diligencia.getFechaDiligencia());
        entity.setTipoDiligencia(diligencia.getTipoDiligencia());
        entity.setEstado(diligencia.getEstado());
        entity.setDescripcion(diligencia.getDescripcion());
        entity.setSolicitudId(diligencia.getSolicitudId());
        
        return entity;
    }
    
    public static Diligencia toDomain(DiligenciaEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Diligencia diligencia = new Diligencia();
        diligencia.setId(entity.getId());
        diligencia.setNumeroDiligencia(entity.getNumeroDiligencia());
        diligencia.setFechaDiligencia(entity.getFechaDiligencia());
        diligencia.setTipoDiligencia(entity.getTipoDiligencia());
        diligencia.setEstado(entity.getEstado());
        diligencia.setDescripcion(entity.getDescripcion());
        diligencia.setSolicitudId(entity.getSolicitudId());
        
        return diligencia;
    }
    
    public static List<Diligencia> toDomainList(List<DiligenciaEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
            .map(DiligenciaPersistenceMapper::toDomain)
            .collect(Collectors.toList());
    }
}
