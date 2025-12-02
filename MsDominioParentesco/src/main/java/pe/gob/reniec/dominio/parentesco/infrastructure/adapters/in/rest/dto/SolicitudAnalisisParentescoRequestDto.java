package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

public record SolicitudAnalisisParentescoRequestDto(
    String idSolicitud,
    String idCiudadanoConsultado,
    DatosCiudadanoRequestDto datosCiudadano,
    String tipoVinculo,
    Integer nivelComplejidad,
    CriteriosBusquedaRequestDto criteriosBusqueda,
    OpcionesAnalisisRequestDto opcionesAnalisis,
    String usuarioTecnico,
    String observaciones
) {}
