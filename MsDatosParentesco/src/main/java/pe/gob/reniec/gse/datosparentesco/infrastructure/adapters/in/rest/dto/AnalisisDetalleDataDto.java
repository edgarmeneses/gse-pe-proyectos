package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisDetalleDataDto(
        String idAnalisis,
        String idSolicitud,
        String idCiudadanoConsultado,
        String tipoVinculo,
        Integer nivelComplejidad,
        CriteriosBusquedaDto criteriosBusqueda,
        String estado,
        String resultadoAnalisis,
        String usuarioTecnico,
        String fechaCreacion,
        String fechaModificacion,
        String observaciones
) {
}
