package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.InformeFinalEntity;

public class InformeFinalPersistenceMapper {

    public static InformeFinal toDomain(InformeFinalEntity entity) {
        if (entity == null) {
            return null;
        }
        InformeFinal domain = new InformeFinal();
        domain.setId(entity.getId());
        domain.setNumeroInforme(entity.getNumeroInforme());
        domain.setFechaEmision(entity.getFechaEmision());
        domain.setContenido(entity.getContenido());
        domain.setConclusiones(entity.getConclusiones());
        domain.setEstado(entity.getEstado());
        return domain;
    }

    public static InformeFinalEntity toEntity(InformeFinal domain) {
        if (domain == null) {
            return null;
        }
        InformeFinalEntity entity = new InformeFinalEntity();
        entity.setId(domain.getId());
        entity.setNumeroInforme(domain.getNumeroInforme());
        entity.setFechaEmision(domain.getFechaEmision());
        entity.setContenido(domain.getContenido());
        entity.setConclusiones(domain.getConclusiones());
        entity.setEstado(domain.getEstado());
        return entity;
    }
}
