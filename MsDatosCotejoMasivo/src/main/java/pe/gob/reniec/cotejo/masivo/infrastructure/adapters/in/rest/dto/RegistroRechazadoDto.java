package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public record RegistroRechazadoDto(
    Integer numeroSecuencia,
    String numeroDni,
    String motivoRechazo
) {}
