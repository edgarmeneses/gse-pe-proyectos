package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;

public record RegistroEntradaItemDto(
    Integer numeroSecuencia,
    String numeroDni,
    String apellidoPaterno,
    String apellidoMaterno,
    String nombres,
    LocalDate fechaNacimiento,
    String indicadorSexo,
    String identificadorInstitucion,
    Object datosAdicionales
) {}
