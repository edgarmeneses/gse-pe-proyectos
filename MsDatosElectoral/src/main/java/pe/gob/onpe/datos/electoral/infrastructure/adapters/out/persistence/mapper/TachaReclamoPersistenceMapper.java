package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.TachaReclamoEntity;

public class TachaReclamoPersistenceMapper {

    public static TachaReclamo toDomain(TachaReclamoEntity entity) {
        if (entity == null) {
            return null;
        }
        TachaReclamo domain = new TachaReclamo();
        domain.setId(entity.getId());
        domain.setTipo(entity.getTipo());
        domain.setNumeroExpediente(entity.getNumeroExpediente());
        domain.setFechaRegistro(entity.getFechaRegistro());
        domain.setEstado(entity.getEstado());
        domain.setDescripcion(entity.getDescripcion());
        domain.setSolicitante(entity.getSolicitante());
        return domain;
    }

    public static TachaReclamoEntity toEntity(TachaReclamo domain) {
        if (domain == null) {
            return null;
        }
        TachaReclamoEntity entity = new TachaReclamoEntity();
        entity.setId(domain.getId());
        entity.setTipo(domain.getTipo());
        entity.setNumeroExpediente(domain.getNumeroExpediente());
        entity.setFechaRegistro(domain.getFechaRegistro());
        entity.setEstado(domain.getEstado());
        entity.setDescripcion(domain.getDescripcion());
        entity.setSolicitante(domain.getSolicitante());
        return entity;
    }
}
