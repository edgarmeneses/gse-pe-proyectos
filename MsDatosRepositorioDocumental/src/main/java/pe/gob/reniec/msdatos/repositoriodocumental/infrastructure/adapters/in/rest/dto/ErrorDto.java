package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

public record ErrorDto(
    String tipo,
    String titulo,
    Integer estado,
    java.util.List<ErrorDetalleDto> errores
) {}
