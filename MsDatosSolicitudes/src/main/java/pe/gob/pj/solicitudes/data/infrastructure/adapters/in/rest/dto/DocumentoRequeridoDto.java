package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record DocumentoRequeridoDto(
        String tipoDocumento,
        String descripcion,
        Boolean obligatorio
) {
}
