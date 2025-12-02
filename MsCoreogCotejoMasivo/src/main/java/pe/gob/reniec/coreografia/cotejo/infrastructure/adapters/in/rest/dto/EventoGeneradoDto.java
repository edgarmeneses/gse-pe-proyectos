package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record EventoGeneradoDto(
    String eventId,
    String eventType,
    String topic
) {}
