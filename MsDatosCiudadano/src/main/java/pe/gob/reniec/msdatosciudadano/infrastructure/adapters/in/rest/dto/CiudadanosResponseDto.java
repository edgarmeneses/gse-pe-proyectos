package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record CiudadanosResponseDto(
    List<Object> contenido,
    PageDto page
) {
}
