package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

public record ProgramacionDto(
    String fechaCita,
    String horaCita,
    String fechaHoraCompleta,
    String idDisponibilidad
) {}
