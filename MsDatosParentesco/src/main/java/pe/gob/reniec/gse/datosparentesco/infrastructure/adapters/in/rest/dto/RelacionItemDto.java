package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record RelacionItemDto(
        Long idRelacion,
        String tipoParentesco,
        String descripcionParentesco,
        Integer gradoParentesco,
        CiudadanoDto ciudadanoRelacionado,
        String actaSustento,
        Boolean vigente
) {
}
