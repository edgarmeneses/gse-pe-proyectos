package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto;

public record RelacionParentescoRequestDto(
        String idAnalisis,
        String idCiudadanoOrigen,
        String idCiudadanoDestino,
        String codigoTipoParentesco,
        Integer gradoParentesco,
        String idActaSustento,
        String idDocumentoSustento,
        String fechaInicioVigencia,
        String observacion
) {
}
