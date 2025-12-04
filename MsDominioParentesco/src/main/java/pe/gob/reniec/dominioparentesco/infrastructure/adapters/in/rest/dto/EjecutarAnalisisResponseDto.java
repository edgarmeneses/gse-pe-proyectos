package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO Response para ejecutar análisis de parentesco.
 */
public record EjecutarAnalisisResponseDto(
    Boolean success,
    EjecutarAnalisisDataDto data,
    MetadataDto metadata
) {}

record EjecutarAnalisisDataDto(
    String idSolicitud,
    String idCiudadanoConsultado,
    String codTipoVinculo,
    Integer nivelComplejidad,
    String estadoSolicitud,
    CiudadanoAnalizadoDto ciudadanoAnalizado,
    PoblacionVinculosPosiblesDto poblacionVinculosPosibles,
    ResumenAnalisisDto resumenAnalisis,
    List<InconsistenciaDto> inconsistencias,
    List<ActaPendienteDigitalizacionDto> actasPendientesDigitalizacion,
    LocalDateTime fechaSolicitud,
    Long tiempoProcesamientoMs,
    String usuarioTecnico
) {}

record CiudadanoAnalizadoDto(
    String idCiudadano,
    String nombre,
    LocalDateTime fechaNacimiento,
    DatosAPDDto datosAPD
) {}

record DatosAPDDto(
    String version,
    LocalDateTime ultimaActualizacion,
    String estadoAPD
) {}

record PoblacionVinculosPosiblesDto(
    Integer totalEncontrados,
    List<VinculoConsanguineoDto> vinculosConsanguineos,
    List<VinculoAfinidadDto> vinculosAfinidad
) {}

record VinculoConsanguineoDto(
    Long idRelacion,
    String idCiudadanoOrigen,
    String idCiudadanoDestino,
    String nombreCiudadanoDestino,
    String codTipo,
    String descripcionTipo,
    String categoria,
    Integer gradoMinimo,
    String esSimetrico,
    String codInverso,
    LocalDateTime fechaInicio,
    LocalDateTime fechaFin,
    String idActaSustento,
    ActaSustentoDto actaSustento,
    String idDocumentoSustento,
    Double nivelConfianza,
    String estadoConfirmacion,
    Boolean requiereValidacionManual,
    String observacion
) {}

record VinculoAfinidadDto(
    Long idRelacion,
    String idCiudadanoOrigen,
    String idCiudadanoDestino,
    String nombreCiudadanoDestino,
    String codTipo,
    String descripcionTipo,
    String categoria,
    Integer gradoMinimo,
    String esSimetrico,
    String codInverso,
    ConyugeIntermedioDto conyugeIntermedio,
    LocalDateTime fechaInicio,
    LocalDateTime fechaFin,
    String idActaSustento,
    ActaSustentoDto actaSustento,
    String idDocumentoSustento,
    Double nivelConfianza,
    String estadoConfirmacion,
    Boolean requiereValidacionManual,
    String observacion
) {}

record ActaSustentoDto(
    String idActa,
    String tipoActa,
    LocalDateTime fechaActa,
    String lugarActa
) {}

record ConyugeIntermedioDto(
    String idCiudadano,
    String nombre
) {}

record ResumenAnalisisDto(
    Integer vinculosGrado1,
    Integer vinculosGrado2,
    Integer vinculosGrado3,
    Integer vinculosGrado4,
    Integer vinculosAfinidad,
    Integer actasConsultadas,
    Integer actasNoDigitalizadas,
    Integer inconsistenciasDetectadas
) {}

record InconsistenciaDto(
    String tipo,
    String descripcion,
    List<String> ciudadanosInvolucrados,
    String severidad,
    String accionRecomendada
) {}

record ActaPendienteDigitalizacionDto(
    String tipoActa,
    String referenciaActa,
    String lugarActa,
    String observacion
) {}

record MetadataDto(
    LocalDateTime timestamp,
    String correlationId,
    String version,
    ServiciosConsultadosDto serviciosConsultados
) {}

record ServiciosConsultadosDto(
    Boolean msSagaAPD,
    Boolean msDatosActas,
    Boolean msDatosParentesco
) {}
