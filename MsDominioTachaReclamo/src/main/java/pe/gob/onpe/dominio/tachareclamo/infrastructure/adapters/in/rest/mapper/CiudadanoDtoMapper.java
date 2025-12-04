package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Ciudadano;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.CiudadanoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.CiudadanoResponseDto;

public class CiudadanoDtoMapper {

    public static Ciudadano toDomain(CiudadanoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setDni(dto.getDni());
        ciudadano.setNombres(dto.getNombres());
        ciudadano.setApellidoPaterno(dto.getApellidoPaterno());
        ciudadano.setApellidoMaterno(dto.getApellidoMaterno());
        ciudadano.setFechaNacimiento(dto.getFechaNacimiento());
        ciudadano.setDireccion(dto.getDireccion());

        return ciudadano;
    }

    public static CiudadanoResponseDto toResponseDto(Ciudadano ciudadano, String statusCode, String message) {
        if (ciudadano == null) {
            return null;
        }

        CiudadanoResponseDto dto = new CiudadanoResponseDto();
        dto.setId(ciudadano.getId());
        dto.setDni(ciudadano.getDni());
        dto.setNombreCompleto(ciudadano.getNombreCompleto());
        dto.setFechaRegistro(ciudadano.getFechaRegistro());
        dto.setStatusCode(statusCode);
        dto.setMessage(message);

        return dto;
    }
}
