package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record OpcionesAnalisisRequestDto(
    Boolean generarArbolGenealogico,
    Boolean validarContraAPD,
    Boolean incluirActasSustento,
    Boolean detectarInconsistencias
) {}
