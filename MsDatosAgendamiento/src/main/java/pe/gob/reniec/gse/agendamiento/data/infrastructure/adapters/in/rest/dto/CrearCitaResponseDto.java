package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

import java.util.Map;

public record CrearCitaResponseDto(
    String citaId,
    String codigoCita,
    String estado,
    SedeServicioResponseDto sedeServicio,
    SolicitanteResponseDto solicitante,
    ProgramacionResponseDto programacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String tokenReagendamiento,
    String fechaLimiteReagendamiento,
    String fechaRegistro,
    String usuarioRegistro,
    Map<String, String> _links
) {}
