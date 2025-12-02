package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.*;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.out.persistence.entity.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre entidades de persistencia y objetos de dominio
 */
public class VinculoParentescoPersistenceMapper {

    public VinculoParentesco toDomain(VinculoParentescoEntity entity) {
        return new VinculoParentesco(
            entity.getIdRelacion(),
            toTipoParentescoDomain(entity.getTipoParentesco()),
            entity.getGradoParentesco(),
            entity.getCategoriaParentesco(),
            toCiudadanoDomain(entity.getCiudadanoRelacionado()),
            toVigenciaDomain(entity.getVigencia()),
            toSustentoDomain(entity.getSustento()),
            entity.getObservacion()
        );
    }

    public VinculoParentescoEntity toEntity(VinculoParentesco domain) {
        return new VinculoParentescoEntity(
            domain.getIdRelacion(),
            toTipoParentescoEntity(domain.getTipoParentesco()),
            domain.getGradoParentesco(),
            domain.getCategoriaParentesco(),
            toCiudadanoEntity(domain.getCiudadanoRelacionado()),
            toVigenciaEntity(domain.getVigencia()),
            toSustentoEntity(domain.getSustento()),
            domain.getObservacion()
        );
    }

    public List<VinculoParentesco> toDomainList(List<VinculoParentescoEntity> entities) {
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    private TipoParentesco toTipoParentescoDomain(TipoParentescoEntity entity) {
        return new TipoParentesco(
            entity.getCodigo(),
            entity.getDescripcion(),
            entity.getEsSimetrico()
        );
    }

    private TipoParentescoEntity toTipoParentescoEntity(TipoParentesco domain) {
        return new TipoParentescoEntity(
            domain.getCodigo(),
            domain.getDescripcion(),
            domain.getEsSimetrico()
        );
    }

    private Ciudadano toCiudadanoDomain(CiudadanoEntity entity) {
        return new Ciudadano(
            entity.getIdCiudadano(),
            entity.getNombre(),
            entity.getFechaNacimiento()
        );
    }

    private CiudadanoEntity toCiudadanoEntity(Ciudadano domain) {
        return new CiudadanoEntity(
            domain.getIdCiudadano(),
            domain.getNombre(),
            domain.getFechaNacimiento()
        );
    }

    private Vigencia toVigenciaDomain(VigenciaEntity entity) {
        return new Vigencia(
            entity.getFechaInicio(),
            entity.getFechaFin(),
            entity.getEsVigente()
        );
    }

    private VigenciaEntity toVigenciaEntity(Vigencia domain) {
        return new VigenciaEntity(
            domain.getFechaInicio(),
            domain.getFechaFin(),
            domain.getEsVigente()
        );
    }

    private Sustento toSustentoDomain(SustentoEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Sustento(
            entity.getIdActaSustento(),
            entity.getIdDocumentoSustento()
        );
    }

    private SustentoEntity toSustentoEntity(Sustento domain) {
        if (domain == null) {
            return null;
        }
        return new SustentoEntity(
            domain.getIdActaSustento(),
            domain.getIdDocumentoSustento()
        );
    }

    public Resumen toResumenDomain(Long totalVinculos, Long vinculosConsanguineos, 
                                   Long vinculosPorAfinidad, Long vinculosVigentes, 
                                   Long vinculosNoVigentes) {
        return new Resumen(totalVinculos, vinculosConsanguineos, vinculosPorAfinidad, 
                          vinculosVigentes, vinculosNoVigentes);
    }

    public Paginacion toPaginacionDomain(Long paginaActual, Long registrosPorPagina, 
                                        Long totalRegistros, Long totalPaginas, 
                                        Boolean tieneAnterior, Boolean tieneSiguiente) {
        return new Paginacion(paginaActual, registrosPorPagina, totalRegistros, 
                             totalPaginas, tieneAnterior, tieneSiguiente);
    }
}
