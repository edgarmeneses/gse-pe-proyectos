package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.UUID;

public record RegistroInsertadoDto(
    UUID registroEntradaId,
    Integer numeroSecuencia,
    String numeroDni
) {}
