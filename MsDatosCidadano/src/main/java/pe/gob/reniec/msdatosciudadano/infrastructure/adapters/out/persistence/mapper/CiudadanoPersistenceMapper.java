package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.out.persistence.entity.CiudadanoEntity;

public class CiudadanoPersistenceMapper {

    public static CiudadanoEntity toEntity(Ciudadano ciudadano) {
        if (ciudadano == null) {
            return null;
        }
        
        CiudadanoEntity entity = new CiudadanoEntity();
        entity.setId(ciudadano.getId());
        entity.setTipoDocumento(ciudadano.getTipoDocumento());
        entity.setNumeroDocumento(ciudadano.getNumeroDocumento());
        entity.setPrimerNombre(ciudadano.getPrimerNombre());
        entity.setSegundoNombre(ciudadano.getSegundoNombre());
        entity.setPrimerApellido(ciudadano.getPrimerApellido());
        entity.setSegundoApellido(ciudadano.getSegundoApellido());
        entity.setFechaNacimiento(ciudadano.getFechaNacimiento());
        entity.setSexo(ciudadano.getSexo());
        entity.setEstadoCivil(ciudadano.getEstadoCivil());
        entity.setNacionalidad(ciudadano.getNacionalidad());
        entity.setPaisNacimiento(ciudadano.getPaisNacimiento());
        entity.setDepartamentoNacimiento(ciudadano.getDepartamentoNacimiento());
        entity.setProvinciaNacimiento(ciudadano.getProvinciaNacimiento());
        entity.setDistritoNacimiento(ciudadano.getDistritoNacimiento());
        entity.setGrupoSanguineo(ciudadano.getGrupoSanguineo());
        entity.setEstatura(ciudadano.getEstatura());
        entity.setEstado(ciudadano.getEstado());
        entity.setFechaCreacion(ciudadano.getFechaCreacion());
        entity.setFechaActualizacion(ciudadano.getFechaActualizacion());
        
        return entity;
    }

    public static Ciudadano toDomain(CiudadanoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setId(entity.getId());
        ciudadano.setTipoDocumento(entity.getTipoDocumento());
        ciudadano.setNumeroDocumento(entity.getNumeroDocumento());
        ciudadano.setPrimerNombre(entity.getPrimerNombre());
        ciudadano.setSegundoNombre(entity.getSegundoNombre());
        ciudadano.setPrimerApellido(entity.getPrimerApellido());
        ciudadano.setSegundoApellido(entity.getSegundoApellido());
        ciudadano.setFechaNacimiento(entity.getFechaNacimiento());
        ciudadano.setSexo(entity.getSexo());
        ciudadano.setEstadoCivil(entity.getEstadoCivil());
        ciudadano.setNacionalidad(entity.getNacionalidad());
        ciudadano.setPaisNacimiento(entity.getPaisNacimiento());
        ciudadano.setDepartamentoNacimiento(entity.getDepartamentoNacimiento());
        ciudadano.setProvinciaNacimiento(entity.getProvinciaNacimiento());
        ciudadano.setDistritoNacimiento(entity.getDistritoNacimiento());
        ciudadano.setGrupoSanguineo(entity.getGrupoSanguineo());
        ciudadano.setEstatura(entity.getEstatura());
        ciudadano.setEstado(entity.getEstado());
        ciudadano.setFechaCreacion(entity.getFechaCreacion());
        ciudadano.setFechaActualizacion(entity.getFechaActualizacion());
        
        return ciudadano;
    }
}
