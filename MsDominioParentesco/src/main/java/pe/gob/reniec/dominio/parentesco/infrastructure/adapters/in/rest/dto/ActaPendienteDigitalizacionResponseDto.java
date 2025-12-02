package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record ActaPendienteDigitalizacionResponseDto(
    String tipoActa,
    String referenciaActa,
    String oficinaRegistral,
    String observacion
) {}
