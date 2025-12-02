package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ResultadoCotejoItemDto(
    UUID registroEntradaId,
    String codigoResultado,
    String numeroDniEncontrado,
    String apellidoPaternoEncontrado,
    String apellidoMaternoEncontrado,
    String nombresEncontrado,
    LocalDate fechaNacimientoEncontrada,
    String indicadorSexoEncontrado,
    String codigoUbigeoDomicilio,
    String descripcionDomicilio,
    String estadoCivil,
    String condicionCiudadano,
    LocalDate fechaCaducidadDni,
    String indicadorRestriccion,
    LocalDate fechaRestriccion,
    String coincideDni,
    String coincideApellidoPaterno,
    String coincideApellidoMaterno,
    String coincideNombres,
    String coincideFechaNacimiento,
    String coincideSexo,
    String mensajeObservacion
) {}
