package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ConsultaMasivaRequestDto(
    String solicitudId,
    EntidadSolicitanteDto entidadSolicitante,
    ConfiguracionCotejoDto configuracionCotejo,
    List<RegistroCotejoDto> registros
) {}
