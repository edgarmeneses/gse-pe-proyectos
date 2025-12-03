package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record ProgramacionDto(
    String fechaCita,
    String horaCita,
    String idDisponibilidad
) {}
