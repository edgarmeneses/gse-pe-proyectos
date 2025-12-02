package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record AnalisisParentescoDataResponseDto(
    String idAnalisis,
    String idSolicitud,
    String idCiudadanoConsultado,
    String tipoVinculo,
    Integer nivelComplejidad,
    String estado,
    CiudadanoAnalizadoResponseDto ciudadanoAnalizado,
    PoblacionVinculosPosiblesResponseDto poblacionVinculosPosibles,
    ResumenAnalisisResponseDto resumenAnalisis,
    List<InconsistenciaResponseDto> inconsistencias,
    List<ActaPendienteDigitalizacionResponseDto> actasPendientesDigitalizacion,
    LocalDateTime fechaAnalisis,
    Integer tiempoProcesamientoMs,
    String usuarioTecnico
) {}
