package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.CarpetaEntity;

public class CarpetaPersistenceMapper {

    public static CarpetaEntity toEntity(Carpeta carpeta) {
        return new CarpetaEntity(
            carpeta.getId(),
            carpeta.getNombre(),
            carpeta.getParentId(),
            carpeta.getDescripcion(),
            carpeta.getEstadoCarpeta(),
            carpeta.getRuta(),
            carpeta.getMetadata(),
            carpeta.getCreatedAt(),
            carpeta.getUpdatedAt()
        );
    }

    public static Carpeta toDomain(CarpetaEntity entity) {
        return new Carpeta(
            entity.getId(),
            entity.getNombre(),
            entity.getParentId(),
            entity.getDescripcion(),
            entity.getEstadoCarpeta(),
            entity.getRuta(),
            entity.getMetadata(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
