package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.msdatos.domain.model.HorarioEspecial;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExcepcionHorariaDtoMapper {

    public ExcepcionHoraria toDomain(RegistrarExcepcionHorariaRequestDto dto) {
        HorarioEspecial horario = dto.horarioEspecial() != null 
            ? new HorarioEspecial(
                dto.horarioEspecial().horaInicio() != null ? LocalTime.parse(dto.horarioEspecial().horaInicio()) : null,
                dto.horarioEspecial().horaFin() != null ? LocalTime.parse(dto.horarioEspecial().horaFin()) : null,
                dto.horarioEspecial().duracionCita(),
                dto.horarioEspecial().capacidadMaxima()
              )
            : null;

        return new ExcepcionHoraria(
            null,
            dto.codigoSede(),
            dto.codigoServicio(),
            dto.fecha() != null ? LocalDate.parse(dto.fecha()) : null,
            dto.tipo(),
            dto.motivo(),
            horario,
            dto.observaciones(),
            null,
            null
        );
    }

    public RegistrarExcepcionHorariaResponseDto toRegistrarResponseDto(RegistrarExcepcionHorariaUseCase.ResultadoRegistro resultado) {
        if (resultado == null || resultado.excepcion() == null) {
            return new RegistrarExcepcionHorariaResponseDto(
                false,
                null,
                new RegistrarExcepcionHorariaResponseDto.MetadataDto(
                    "Error al registrar excepción horaria",
                    null
                )
            );
        }

        ExcepcionHoraria excepcion = resultado.excepcion();
        
        RegistrarExcepcionHorariaResponseDto.CitasAfectadasDto citasAfectadas = 
            new RegistrarExcepcionHorariaResponseDto.CitasAfectadasDto(
                resultado.citasAfectadas() != null ? resultado.citasAfectadas().size() : 0,
                resultado.citasAfectadas() != null ? resultado.citasAfectadas() : Collections.emptyList()
            );

        RegistrarExcepcionHorariaResponseDto.ExcepcionDataDto data = 
            new RegistrarExcepcionHorariaResponseDto.ExcepcionDataDto(
                excepcion.excepcionId(),
                excepcion.codigoSede(),
                excepcion.codigoServicio(),
                excepcion.fecha() != null ? excepcion.fecha().toString() : null,
                excepcion.tipo(),
                excepcion.motivo(),
                citasAfectadas,
                excepcion.fechaCreacion() != null ? excepcion.fechaCreacion().toString() : null
            );

        return new RegistrarExcepcionHorariaResponseDto(
            true,
            data,
            new RegistrarExcepcionHorariaResponseDto.MetadataDto(
                "Excepción horaria registrada exitosamente",
                null
            )
        );
    }
}
