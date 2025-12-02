package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity.RegistroEntradaEntity;

public class RegistroEntradaPersistenceMapper {

    public static RegistroEntradaEntity toEntity(RegistroEntrada registroEntrada) {
        RegistroEntradaEntity entity = new RegistroEntradaEntity();
        entity.setRegistroEntradaId(registroEntrada.getRegistroEntradaId());
        entity.setEjecucionId(registroEntrada.getEjecucionId());
        entity.setNumeroSecuencia(registroEntrada.getNumeroSecuencia());
        entity.setNumeroDni(registroEntrada.getNumeroDni());
        entity.setApellidoPaterno(registroEntrada.getApellidoPaterno());
        entity.setApellidoMaterno(registroEntrada.getApellidoMaterno());
        entity.setNombres(registroEntrada.getNombres());
        entity.setFechaNacimiento(registroEntrada.getFechaNacimiento());
        entity.setIndicadorSexo(registroEntrada.getIndicadorSexo());
        entity.setIdentificadorInstitucion(registroEntrada.getIdentificadorInstitucion());
        entity.setDatosAdicionales(registroEntrada.getDatosAdicionales());
        return entity;
    }

    public static RegistroEntrada toDomain(RegistroEntradaEntity entity) {
        RegistroEntrada registroEntrada = new RegistroEntrada();
        registroEntrada.setRegistroEntradaId(entity.getRegistroEntradaId());
        registroEntrada.setEjecucionId(entity.getEjecucionId());
        registroEntrada.setNumeroSecuencia(entity.getNumeroSecuencia());
        registroEntrada.setNumeroDni(entity.getNumeroDni());
        registroEntrada.setApellidoPaterno(entity.getApellidoPaterno());
        registroEntrada.setApellidoMaterno(entity.getApellidoMaterno());
        registroEntrada.setNombres(entity.getNombres());
        registroEntrada.setFechaNacimiento(entity.getFechaNacimiento());
        registroEntrada.setIndicadorSexo(entity.getIndicadorSexo());
        registroEntrada.setIdentificadorInstitucion(entity.getIdentificadorInstitucion());
        registroEntrada.setDatosAdicionales(entity.getDatosAdicionales());
        return registroEntrada;
    }
}
