package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ErrorResponseDto(
    ErrorDto error
) {
    public record ErrorDto(
        String tipo,
        String titulo,
        Integer estado,
        ErrorDetalleDto[] errores
    ) {}

    public record ErrorDetalleDto(
        String detalleError
    ) {}
}
