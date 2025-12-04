package pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.mapper;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.out.persistence.entity.PaqueteElectoralEntity;

public class PaqueteElectoralPersistenceMapper {

    public static PaqueteElectoral toDomain(PaqueteElectoralEntity entity) {
        if (entity == null) {
            return null;
        }
        PaqueteElectoral domain = new PaqueteElectoral();
        domain.setId(entity.getId());
        domain.setNumeroPaquete(entity.getNumeroPaquete());
        domain.setEstado(entity.getEstado());
        domain.setFechaRecepcion(entity.getFechaRecepcion());
        domain.setUbicacion(entity.getUbicacion());
        domain.setObservaciones(entity.getObservaciones());
        return domain;
    }

    public static PaqueteElectoralEntity toEntity(PaqueteElectoral domain) {
        if (domain == null) {
            return null;
        }
        PaqueteElectoralEntity entity = new PaqueteElectoralEntity();
        entity.setId(domain.getId());
        entity.setNumeroPaquete(domain.getNumeroPaquete());
        entity.setEstado(domain.getEstado());
        entity.setFechaRecepcion(domain.getFechaRecepcion());
        entity.setUbicacion(domain.getUbicacion());
        entity.setObservaciones(domain.getObservaciones());
        return entity;
    }
}
