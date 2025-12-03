package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.*;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper entre entidades de persistencia y objetos de dominio.
 * Nota: Las entidades de persistencia pueden ser mutables (getters/setters)
 * ya que es una preocupación técnica de la capa de infraestructura.
 * Los objetos de dominio son inmutables.
 */
public class VinculoParentescoPersistenceMapper {

    public GrafoParentesco toDomain(GrafoParentescoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new GrafoParentesco(
            toDomain(entity.getCiudadanoConsultado()),
            toVinculosDomain(entity.getVinculos())
        );
    }

    public Ciudadano toDomain(CiudadanoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Ciudadano(
            entity.getIdCiudadano(),
            entity.getNombre(),
            entity.getFechaNacimiento()
        );
    }

    public List<VinculoParentesco> toVinculosDomain(List<VinculoParentescoEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        
        return entities.stream()
            .map(this::toVinculoDomain)
            .collect(Collectors.toList());
    }

    public VinculoParentesco toVinculoDomain(VinculoParentescoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        // Convertir String a enum CategoriaParentesco
        CategoriaParentesco categoria = CategoriaParentesco.fromString(entity.getCategoriaParentesco());
        
        return new VinculoParentesco(
            entity.getIdRelacion(),
            toDomain(entity.getTipoParentesco()),
            entity.getGradoParentesco(),
            categoria,
            toDomain(entity.getCiudadanoRelacionado()),
            toDomain(entity.getVigencia()),
            toDomain(entity.getSustento()),
            entity.getObservacion()
        );
    }

    public TipoParentesco toDomain(TipoParentescoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new TipoParentesco(
            entity.getCodigo(),
            entity.getDescripcion(),
            entity.getEsSimetrico()
        );
    }

    public Vigencia toDomain(VigenciaEntity entity) {
        if (entity == null) {
            return null;
        }
        
        // Las entidades de persistencia almacenan las fechas,
        // pero la lógica de vigencia se calcula en el dominio
        return new Vigencia(
            entity.getFechaInicio(),
            entity.getFechaFin()
        );
    }

    public Sustento toDomain(SustentoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Sustento(
            entity.getIdActaSustento(),
            entity.getIdDocumentoSustento()
        );
    }

    // Métodos toEntity - para cuando necesitemos persistir objetos de dominio

    public GrafoParentescoEntity toEntity(GrafoParentesco domain) {
        if (domain == null) {
            return null;
        }
        
        GrafoParentescoEntity entity = new GrafoParentescoEntity();
        entity.setCiudadanoConsultado(toEntity(domain.getCiudadano()));
        entity.setVinculos(toVinculosEntity(domain.getVinculos()));
        
        return entity;
    }

    public CiudadanoEntity toEntity(Ciudadano domain) {
        if (domain == null) {
            return null;
        }
        
        CiudadanoEntity entity = new CiudadanoEntity();
        entity.setIdCiudadano(domain.getIdCiudadano());
        entity.setNombre(domain.getNombre());
        entity.setFechaNacimiento(domain.getFechaNacimiento());
        
        return entity;
    }

    public List<VinculoParentescoEntity> toVinculosEntity(List<VinculoParentesco> domains) {
        if (domains == null) {
            return List.of();
        }
        
        return domains.stream()
            .map(this::toVinculoEntity)
            .collect(Collectors.toList());
    }

    public VinculoParentescoEntity toVinculoEntity(VinculoParentesco domain) {
        if (domain == null) {
            return null;
        }
        
        VinculoParentescoEntity entity = new VinculoParentescoEntity();
        entity.setIdRelacion(domain.getIdRelacion());
        entity.setTipoParentesco(toEntity(domain.getTipoParentesco()));
        entity.setGradoParentesco(domain.getGradoParentesco());
        entity.setCategoriaParentesco(domain.getCategoriaParentesco().name());
        entity.setCiudadanoRelacionado(toEntity(domain.getCiudadanoRelacionado()));
        entity.setVigencia(toEntity(domain.getVigencia()));
        entity.setSustento(toEntity(domain.getSustento()));
        entity.setObservacion(domain.getObservacion());
        
        return entity;
    }

    public TipoParentescoEntity toEntity(TipoParentesco domain) {
        if (domain == null) {
            return null;
        }
        
        TipoParentescoEntity entity = new TipoParentescoEntity();
        entity.setCodigo(domain.getCodigo());
        entity.setDescripcion(domain.getDescripcion());
        entity.setEsSimetrico(domain.esSimetrico());
        
        return entity;
    }

    public VigenciaEntity toEntity(Vigencia domain) {
        if (domain == null) {
            return null;
        }
        
        VigenciaEntity entity = new VigenciaEntity();
        entity.setFechaInicio(domain.getFechaInicio());
        entity.setFechaFin(domain.getFechaFin());
        
        return entity;
    }

    public SustentoEntity toEntity(Sustento domain) {
        if (domain == null) {
            return null;
        }
        
        SustentoEntity entity = new SustentoEntity();
        entity.setIdActaSustento(domain.getIdActaSustento());
        entity.setIdDocumentoSustento(domain.getIdDocumentoSustento());
        
        return entity;
    }
}
