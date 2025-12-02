package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity.ResultadoCotejoEntity;

public class ResultadoCotejoPersistenceMapper {

    public static ResultadoCotejoEntity toEntity(ResultadoCotejo resultadoCotejo) {
        ResultadoCotejoEntity entity = new ResultadoCotejoEntity();
        entity.setResultadoCotejoId(resultadoCotejo.getResultadoCotejoId());
        entity.setRegistroEntradaId(resultadoCotejo.getRegistroEntradaId());
        entity.setCodigoResultado(resultadoCotejo.getCodigoResultado());
        entity.setNumeroDniEncontrado(resultadoCotejo.getNumeroDniEncontrado());
        entity.setApellidoPaternoEncontrado(resultadoCotejo.getApellidoPaternoEncontrado());
        entity.setApellidoMaternoEncontrado(resultadoCotejo.getApellidoMaternoEncontrado());
        entity.setNombresEncontrado(resultadoCotejo.getNombresEncontrado());
        entity.setFechaNacimientoEncontrada(resultadoCotejo.getFechaNacimientoEncontrada());
        entity.setIndicadorSexoEncontrado(resultadoCotejo.getIndicadorSexoEncontrado());
        entity.setCodigoUbigeoDomicilio(resultadoCotejo.getCodigoUbigeoDomicilio());
        entity.setDescripcionDomicilio(resultadoCotejo.getDescripcionDomicilio());
        entity.setEstadoCivil(resultadoCotejo.getEstadoCivil());
        entity.setCondicionCiudadano(resultadoCotejo.getCondicionCiudadano());
        entity.setFechaCaducidadDni(resultadoCotejo.getFechaCaducidadDni());
        entity.setIndicadorRestriccion(resultadoCotejo.getIndicadorRestriccion());
        entity.setFechaRestriccion(resultadoCotejo.getFechaRestriccion());
        entity.setCoincideDni(resultadoCotejo.getCoincideDni());
        entity.setCoincideApellidoPaterno(resultadoCotejo.getCoincideApellidoPaterno());
        entity.setCoincideApellidoMaterno(resultadoCotejo.getCoincideApellidoMaterno());
        entity.setCoincideNombres(resultadoCotejo.getCoincideNombres());
        entity.setCoincideFechaNacimiento(resultadoCotejo.getCoincideFechaNacimiento());
        entity.setCoincideSexo(resultadoCotejo.getCoincideSexo());
        entity.setMensajeObservacion(resultadoCotejo.getMensajeObservacion());
        return entity;
    }

    public static ResultadoCotejo toDomain(ResultadoCotejoEntity entity) {
        ResultadoCotejo resultadoCotejo = new ResultadoCotejo();
        resultadoCotejo.setResultadoCotejoId(entity.getResultadoCotejoId());
        resultadoCotejo.setRegistroEntradaId(entity.getRegistroEntradaId());
        resultadoCotejo.setCodigoResultado(entity.getCodigoResultado());
        resultadoCotejo.setNumeroDniEncontrado(entity.getNumeroDniEncontrado());
        resultadoCotejo.setApellidoPaternoEncontrado(entity.getApellidoPaternoEncontrado());
        resultadoCotejo.setApellidoMaternoEncontrado(entity.getApellidoMaternoEncontrado());
        resultadoCotejo.setNombresEncontrado(entity.getNombresEncontrado());
        resultadoCotejo.setFechaNacimientoEncontrada(entity.getFechaNacimientoEncontrada());
        resultadoCotejo.setIndicadorSexoEncontrado(entity.getIndicadorSexoEncontrado());
        resultadoCotejo.setCodigoUbigeoDomicilio(entity.getCodigoUbigeoDomicilio());
        resultadoCotejo.setDescripcionDomicilio(entity.getDescripcionDomicilio());
        resultadoCotejo.setEstadoCivil(entity.getEstadoCivil());
        resultadoCotejo.setCondicionCiudadano(entity.getCondicionCiudadano());
        resultadoCotejo.setFechaCaducidadDni(entity.getFechaCaducidadDni());
        resultadoCotejo.setIndicadorRestriccion(entity.getIndicadorRestriccion());
        resultadoCotejo.setFechaRestriccion(entity.getFechaRestriccion());
        resultadoCotejo.setCoincideDni(entity.getCoincideDni());
        resultadoCotejo.setCoincideApellidoPaterno(entity.getCoincideApellidoPaterno());
        resultadoCotejo.setCoincideApellidoMaterno(entity.getCoincideApellidoMaterno());
        resultadoCotejo.setCoincideNombres(entity.getCoincideNombres());
        resultadoCotejo.setCoincideFechaNacimiento(entity.getCoincideFechaNacimiento());
        resultadoCotejo.setCoincideSexo(entity.getCoincideSexo());
        resultadoCotejo.setMensajeObservacion(entity.getMensajeObservacion());
        return resultadoCotejo;
    }
}
