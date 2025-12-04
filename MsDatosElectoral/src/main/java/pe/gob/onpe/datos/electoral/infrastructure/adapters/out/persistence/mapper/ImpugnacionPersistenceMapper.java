package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.ImpugnacionEntity;

public class ImpugnacionPersistenceMapper {

    public static Impugnacion toDomain(ImpugnacionEntity entity) {
        if (entity == null) {
            return null;
        }
        Impugnacion domain = new Impugnacion();
        domain.setId(entity.getId());
        domain.setNumeroImpugnacion(entity.getNumeroImpugnacion());
        domain.setFechaRegistro(entity.getFechaRegistro());
        domain.setEstado(entity.getEstado());
        domain.setDescripcion(entity.getDescripcion());
        domain.setTipo(entity.getTipo());
        return domain;
    }

    public static ImpugnacionEntity toEntity(Impugnacion domain) {
        if (domain == null) {
            return null;
        }
        ImpugnacionEntity entity = new ImpugnacionEntity();
        entity.setId(domain.getId());
        entity.setNumeroImpugnacion(domain.getNumeroImpugnacion());
        entity.setFechaRegistro(domain.getFechaRegistro());
        entity.setEstado(domain.getEstado());
        entity.setDescripcion(domain.getDescripcion());
        entity.setTipo(domain.getTipo());
        return entity;
    }
}
