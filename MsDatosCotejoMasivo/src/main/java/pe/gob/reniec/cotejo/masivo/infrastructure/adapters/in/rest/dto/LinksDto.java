package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

public record LinksDto(
    String self,
    String registros,
    String resultados,
    String actualizarEstado,
    String solicitud
) {}
