package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record RelacionParentescoDataDto(
        Long idRelacion,
        RelacionInversaDto relacionInversa,
        String fechaRegistro
) {
}
