package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.CarpetaEntity;

/**
 * Mapper de persistencia: Carpeta
 * Convierte entre Carpeta del dominio y CarpetaEntity de persistencia.
 */
public class CarpetaPersistenceMapper {

    public static CarpetaEntity toEntity(Carpeta carpeta) {
        if (carpeta == null) {
            return null;
        }
        
        CarpetaEntity entity = new CarpetaEntity();
        entity.setId(carpeta.getId());
        entity.setNombre(carpeta.getNombre());
        entity.setParentId(carpeta.getParentId());
        entity.setDescripcion(carpeta.getDescripcion());
        entity.setEstadoCarpeta(carpeta.getEstadoCarpeta());
        entity.setRuta(carpeta.getRuta());
        entity.setMetadata(carpeta.getMetadata());
        entity.setCreatedAt(carpeta.getCreatedAt());
        entity.setUpdatedAt(carpeta.getUpdatedAt());
        
        return entity;
    }

    public static Carpeta toDomain(CarpetaEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Carpeta carpeta = new Carpeta();
        carpeta.setId(entity.getId());
        carpeta.setNombre(entity.getNombre());
        carpeta.setParentId(entity.getParentId());
        carpeta.setDescripcion(entity.getDescripcion());
        carpeta.setEstadoCarpeta(entity.getEstadoCarpeta());
        carpeta.setRuta(entity.getRuta());
        carpeta.setMetadata(entity.getMetadata());
        carpeta.setCreatedAt(entity.getCreatedAt());
        carpeta.setUpdatedAt(entity.getUpdatedAt());
        
        return carpeta;
    }
}
