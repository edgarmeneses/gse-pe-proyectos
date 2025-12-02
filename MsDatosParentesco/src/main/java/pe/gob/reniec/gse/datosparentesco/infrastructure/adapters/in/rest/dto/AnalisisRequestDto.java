package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisRequestDto(
        String idSolicitud,
        String idCiudadanoConsultado,
        String tipoVinculo,
        Integer nivelComplejidad,
        CriteriosBusquedaDto criteriosBusqueda,
        String estado,
        String usuarioTecnico,
        String observaciones
) {
}
