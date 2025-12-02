package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto;

/**
 * DTO Record para respuesta de vínculo de parentesco
 */
public record VinculoParentescoResponseDto(
    Long idRelacion,
    TipoParentescoResponseDto tipoParentesco,
    Long gradoParentesco,
    String categoriaParentesco,
    CiudadanoResponseDto ciudadanoRelacionado,
    VigenciaResponseDto vigencia,
    SustentoResponseDto sustento,
    String observacion
) {}
