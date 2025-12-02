package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record ResumenAnalisisResponseDto(
    Integer vinculosGrado1,
    Integer vinculosGrado2,
    Integer vinculosGrado3,
    Integer vinculosGrado4,
    Integer vinculosAfinidad,
    Integer actasConsultadas,
    Integer actasNoDigitalizadas,
    Integer inconsistenciasDetectadas
) {}
