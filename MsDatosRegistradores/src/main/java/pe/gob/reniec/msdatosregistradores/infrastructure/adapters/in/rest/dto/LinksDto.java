package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

public record LinksDto(
    String self,
    String firmas,
    String sellos,
    String periodos,
    String asignaciones,
    String historialFirmas,
    String historialSellos
) {}
