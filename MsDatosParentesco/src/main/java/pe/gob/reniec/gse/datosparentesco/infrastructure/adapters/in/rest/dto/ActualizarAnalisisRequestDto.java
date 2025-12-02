package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record ActualizarAnalisisRequestDto(
        String estado,
        CriteriosBusquedaDto criteriosBusqueda,
        String observaciones,
        String resultadoAnalisis
) {
}
