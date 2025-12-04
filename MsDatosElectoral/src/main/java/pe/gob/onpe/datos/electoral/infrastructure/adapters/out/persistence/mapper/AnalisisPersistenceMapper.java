package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.AnalisisEntity;

public class AnalisisPersistenceMapper {

    public static Analisis toDomain(AnalisisEntity entity) {
        if (entity == null) {
            return null;
        }
        Analisis domain = new Analisis();
        domain.setId(entity.getId());
        domain.setTipoAnalisis(entity.getTipoAnalisis());
        domain.setFechaAnalisis(entity.getFechaAnalisis());
        domain.setResultado(entity.getResultado());
        domain.setObservaciones(entity.getObservaciones());
        domain.setEstado(entity.getEstado());
        return domain;
    }

    public static AnalisisEntity toEntity(Analisis domain) {
        if (domain == null) {
            return null;
        }
        AnalisisEntity entity = new AnalisisEntity();
        entity.setId(domain.getId());
        entity.setTipoAnalisis(domain.getTipoAnalisis());
        entity.setFechaAnalisis(domain.getFechaAnalisis());
        entity.setResultado(domain.getResultado());
        entity.setObservaciones(domain.getObservaciones());
        entity.setEstado(domain.getEstado());
        return entity;
    }
}
