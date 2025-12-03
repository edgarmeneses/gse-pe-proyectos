package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.Map;

public record CitaDataDto(
    String citaId,
    String codigoCita,
    String estado,
    SedeServicioDto sedeServicio,
    SolicitanteDto solicitante,
    ProgramacionDto programacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String tokenReagendamiento,
    String fechaLimiteReagendamiento,
    String fechaRegistro,
    String usuarioRegistro,
    Map<String, String> links
) {}
