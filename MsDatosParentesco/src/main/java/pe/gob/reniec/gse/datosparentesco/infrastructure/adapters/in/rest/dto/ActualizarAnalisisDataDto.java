package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record ActualizarAnalisisDataDto(
        String idAnalisis,
        String estado,
        String fechaModificacion
) {
}
