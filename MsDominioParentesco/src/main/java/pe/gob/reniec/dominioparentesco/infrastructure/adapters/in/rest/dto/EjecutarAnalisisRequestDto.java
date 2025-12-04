package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO Request para ejecutar análisis de parentesco.
 */
public record EjecutarAnalisisRequestDto(
    String idSolicitud,
    String idCiudadanoConsultado,
    DatosCiudadanoDto datosCiudadano,
    String codTipoVinculo,
    Integer nivelComplejidad,
    CriteriosBusquedaDto criteriosBusqueda,
    OpcionesAnalisisDto opcionesAnalisis,
    String usuarioTecnico,
    String observaciones
) {}

record DatosCiudadanoDto(String nombre, LocalDateTime fechaNacimiento) {}

record CriteriosBusquedaDto(
    RangoAniosDto rangoAniosPadres,
    RangoAniosDto rangoAniosHijos,
    List<String> variacionesNombre,
    Boolean incluirFallecidos,
    Boolean incluirActasAnuladas
) {}

record RangoAniosDto(Integer anioInicio, Integer anioFin) {}

record OpcionesAnalisisDto(
    Boolean generarArbolGenealogico,
    Boolean validarContraAPD,
    Boolean incluirActasSustento,
    Boolean detectarInconsistencias
) {}
