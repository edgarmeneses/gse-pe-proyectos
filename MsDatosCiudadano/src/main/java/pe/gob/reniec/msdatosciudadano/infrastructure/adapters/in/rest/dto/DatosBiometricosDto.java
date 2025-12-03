package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record DatosBiometricosDto(
    List<HuellaDactilarDto> huellasDactilares,
    List<FotografiaDto> fotografia,
    List<FirmaDigitalDto> firmaDigital,
    LocalDateTime fechaRegistro
) {}
