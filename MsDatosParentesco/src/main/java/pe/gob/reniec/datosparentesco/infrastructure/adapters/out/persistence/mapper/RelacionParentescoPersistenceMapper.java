package pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.datosparentesco.domain.model.*;
import pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.entity.*;

/**
 * Mapper para conversión entre entidades de persistencia y modelo de dominio de RelacionParentesco.
 */
public class RelacionParentescoPersistenceMapper {
    
    /**
     * Convierte una entidad de persistencia a modelo de dominio.
     * 
     * @param entity Entidad de persistencia
     * @return Modelo de dominio
     */
    public RelacionParentesco toDomain(RelacionParentescoEntity entity) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte un modelo de dominio a entidad de persistencia.
     * 
     * @param relacion Modelo de dominio
     * @return Entidad de persistencia
     */
    public RelacionParentescoEntity toEntity(RelacionParentesco relacion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte una entidad de persistencia de ciudadano a modelo de dominio.
     * 
     * @param entity Entidad de persistencia
     * @return Modelo de dominio
     */
    public Ciudadano toDomainCiudadano(CiudadanoEntity entity) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte un modelo de dominio de ciudadano a entidad de persistencia.
     * 
     * @param ciudadano Modelo de dominio
     * @return Entidad de persistencia
     */
    public CiudadanoEntity toEntityCiudadano(Ciudadano ciudadano) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
