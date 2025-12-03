package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ExcepcionHorariaDataDto(
    String idExcepcion,
    String codigoSede,
    String nombreSede,
    String fechaExcepcion,
    String tipoExcepcion,
    String descripcion,
    HorarioEspecialDto horarioEspecial,
    CitasAfectadasDto citasAfectadas,
    String fechaRegistro,
    String usuarioRegistro
) {}
