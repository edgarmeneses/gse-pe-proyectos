package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record EntidadSolicitanteDto(
    String codigo,
    String nombre,
    String ruc,
    RepresentanteLegalDto representanteLegal,
    ContactoDto contacto
) {}
