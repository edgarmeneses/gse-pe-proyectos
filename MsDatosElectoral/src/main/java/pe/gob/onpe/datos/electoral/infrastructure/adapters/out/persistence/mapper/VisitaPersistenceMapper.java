package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Visita;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.VisitaEntity;

public class VisitaPersistenceMapper {

    public static Visita toDomain(VisitaEntity entity) {
        if (entity == null) {
            return null;
        }
        Visita domain = new Visita();
        domain.setId(entity.getId());
        domain.setFechaVisita(entity.getFechaVisita());
        domain.setLugar(entity.getLugar());
        domain.setObservaciones(entity.getObservaciones());
        domain.setResponsable(entity.getResponsable());
        return domain;
    }

    public static VisitaEntity toEntity(Visita domain) {
        if (domain == null) {
            return null;
        }
        VisitaEntity entity = new VisitaEntity();
        entity.setId(domain.getId());
        entity.setFechaVisita(domain.getFechaVisita());
        entity.setLugar(domain.getLugar());
        entity.setObservaciones(domain.getObservaciones());
        entity.setResponsable(domain.getResponsable());
        return entity;
    }
}
