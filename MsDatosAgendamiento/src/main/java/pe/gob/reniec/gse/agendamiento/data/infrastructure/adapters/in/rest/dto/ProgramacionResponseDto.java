package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto;

public record ProgramacionResponseDto(
    String fechaCita,
    String horaCita,
    String fechaHoraCompleta
) {}
