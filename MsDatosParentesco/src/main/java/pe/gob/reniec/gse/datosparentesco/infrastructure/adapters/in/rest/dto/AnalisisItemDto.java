package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record AnalisisItemDto(
        String idAnalisis,
        String idSolicitud,
        String idCiudadanoConsultado,
        String tipoVinculo,
        Integer nivelComplejidad,
        String estado,
        String usuarioTecnico,
        String fechaCreacion
) {
}
