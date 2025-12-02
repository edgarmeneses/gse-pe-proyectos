package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record LinksDto(
    String self,
    String descargar,
    String aprobar,
    String regenerar
) {}
