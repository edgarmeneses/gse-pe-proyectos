package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record CitasAfectadasDto(
    Long cantidad,
    String accion,
    List<String> citasIds
) {}
