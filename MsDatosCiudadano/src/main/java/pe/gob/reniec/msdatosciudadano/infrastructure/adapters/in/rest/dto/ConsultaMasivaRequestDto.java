package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultaMasivaRequestDto(
    String solicitudId,
    List<RegistroDto> registros
) {}
