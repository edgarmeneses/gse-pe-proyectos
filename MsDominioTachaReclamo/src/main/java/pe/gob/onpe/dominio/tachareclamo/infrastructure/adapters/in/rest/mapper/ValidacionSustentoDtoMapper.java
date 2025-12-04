package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.dominio.tachareclamo.domain.model.ValidacionSustento;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.ValidarSustentoResponseDto;

public class ValidacionSustentoDtoMapper {

    public static ValidarSustentoResponseDto toResponseDto(ValidacionSustento validacion, String statusCode, String message) {
        if (validacion == null) {
            return null;
        }

        ValidarSustentoResponseDto dto = new ValidarSustentoResponseDto();
        dto.setTachaReclamoId(validacion.getTachaReclamoId());
        dto.setEsValido(validacion.getEsValido());
        dto.setObservaciones(validacion.getObservaciones());
        dto.setFechaValidacion(validacion.getFechaValidacion());
        dto.setStatusCode(statusCode);
        dto.setMessage(message);

        return dto;
    }
}
