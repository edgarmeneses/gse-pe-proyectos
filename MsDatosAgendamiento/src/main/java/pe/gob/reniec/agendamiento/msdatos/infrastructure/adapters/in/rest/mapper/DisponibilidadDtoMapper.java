package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.msdatos.domain.model.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DisponibilidadDtoMapper {

    public Disponibilidad toDomain(ConfigurarDisponibilidadRequestDto dto) {
        List<HorarioServicio> horarios = dto.horarios() != null 
            ? dto.horarios().stream()
                .map(h -> new HorarioServicio(
                    h.codigoServicio(),
                    h.nombreServicio(),
                    h.horaInicio() != null ? LocalTime.parse(h.horaInicio()) : null,
                    h.horaFin() != null ? LocalTime.parse(h.horaFin()) : null,
                    h.duracionCita(),
                    h.capacidadMaxima(),
                    h.diasHabiles(),
                    h.estadoHorario()
                ))
                .collect(Collectors.toList())
            : Collections.emptyList();

        ConfiguracionDisponibilidad configuracion = new ConfiguracionDisponibilidad(
            dto.codigoSede(),
            dto.nombreSede(),
            dto.fechaVigenciaDesde() != null ? LocalDate.parse(dto.fechaVigenciaDesde()) : null,
            dto.fechaVigenciaHasta() != null ? LocalDate.parse(dto.fechaVigenciaHasta()) : null,
            horarios
        );

        return new Disponibilidad(
            null,
            dto.codigoSede(),
            null,
            configuracion,
            "ACTIVO",
            null,
            null
        );
    }

    public Disponibilidad toDomainActualizar(ActualizarDisponibilidadRequestDto dto) {
        List<HorarioServicio> horarios = dto.horarios() != null 
            ? dto.horarios().stream()
                .map(h -> new HorarioServicio(
                    h.codigoServicio(),
                    h.nombreServicio(),
                    h.horaInicio() != null ? LocalTime.parse(h.horaInicio()) : null,
                    h.horaFin() != null ? LocalTime.parse(h.horaFin()) : null,
                    h.duracionCita(),
                    h.capacidadMaxima(),
                    h.diasHabiles(),
                    h.estadoHorario()
                ))
                .collect(Collectors.toList())
            : Collections.emptyList();

        ConfiguracionDisponibilidad configuracion = new ConfiguracionDisponibilidad(
            null,
            null,
            dto.fechaVigenciaDesde() != null ? LocalDate.parse(dto.fechaVigenciaDesde()) : null,
            dto.fechaVigenciaHasta() != null ? LocalDate.parse(dto.fechaVigenciaHasta()) : null,
            horarios
        );

        return new Disponibilidad(
            null,
            null,
            null,
            configuracion,
            dto.estado(),
            null,
            null
        );
    }

    public ConsultarDisponibilidadResponseDto toConsultarResponseDto(Disponibilidad disponibilidad) {
        if (disponibilidad == null) {
            return new ConsultarDisponibilidadResponseDto(
                false,
                null,
                new ConsultarDisponibilidadResponseDto.MetadataDto(
                    "No se encontró disponibilidad",
                    null
                )
            );
        }

        List<ConsultarDisponibilidadResponseDto.FranjaHorariaDto> franjas = Collections.emptyList();
        
        if (disponibilidad.configuracion() != null && disponibilidad.configuracion().horarios() != null) {
            franjas = disponibilidad.configuracion().horarios().stream()
                .map(h -> new ConsultarDisponibilidadResponseDto.FranjaHorariaDto(
                    h.horaInicio() != null ? h.horaInicio().toString() : null,
                    h.horaFin() != null ? h.horaFin().toString() : null,
                    h.capacidadMaxima(),
                    h.capacidadMaxima(),
                    true
                ))
                .collect(Collectors.toList());
        }

        ConsultarDisponibilidadResponseDto.DisponibilidadDataDto data = 
            new ConsultarDisponibilidadResponseDto.DisponibilidadDataDto(
                disponibilidad.codigoSede(),
                disponibilidad.configuracion() != null ? disponibilidad.configuracion().nombreSede() : null,
                disponibilidad.configuracion() != null && disponibilidad.configuracion().horarios() != null
                    ? disponibilidad.configuracion().horarios().get(0).codigoServicio() : null,
                disponibilidad.configuracion() != null && disponibilidad.configuracion().horarios() != null
                    ? disponibilidad.configuracion().horarios().get(0).nombreServicio() : null,
                disponibilidad.fechaConsulta() != null ? disponibilidad.fechaConsulta().toString() : null,
                franjas
            );

        return new ConsultarDisponibilidadResponseDto(
            true,
            data,
            new ConsultarDisponibilidadResponseDto.MetadataDto(
                "Consulta de disponibilidad exitosa",
                null
            )
        );
    }

    public ConfigurarDisponibilidadResponseDto toConfigurarResponseDto(Disponibilidad disponibilidad) {
        if (disponibilidad == null) {
            return new ConfigurarDisponibilidadResponseDto(
                false,
                null,
                new ConfigurarDisponibilidadResponseDto.MetadataDto(
                    "Error al configurar disponibilidad",
                    null
                )
            );
        }

        ConfigurarDisponibilidadResponseDto.DisponibilidadDataDto data = 
            new ConfigurarDisponibilidadResponseDto.DisponibilidadDataDto(
                disponibilidad.disponibilidadId(),
                disponibilidad.codigoSede(),
                disponibilidad.configuracion() != null && disponibilidad.configuracion().fechaVigenciaDesde() != null
                    ? disponibilidad.configuracion().fechaVigenciaDesde().toString() : null,
                disponibilidad.configuracion() != null && disponibilidad.configuracion().fechaVigenciaHasta() != null
                    ? disponibilidad.configuracion().fechaVigenciaHasta().toString() : null,
                disponibilidad.estado(),
                disponibilidad.fechaCreacion() != null ? disponibilidad.fechaCreacion().toString() : null
            );

        return new ConfigurarDisponibilidadResponseDto(
            true,
            data,
            new ConfigurarDisponibilidadResponseDto.MetadataDto(
                "Disponibilidad configurada exitosamente",
                null
            )
        );
    }

    public ActualizarDisponibilidadResponseDto toActualizarResponseDto(Disponibilidad disponibilidad) {
        if (disponibilidad == null) {
            return new ActualizarDisponibilidadResponseDto(
                false,
                null,
                new ActualizarDisponibilidadResponseDto.MetadataDto(
                    "Error al actualizar disponibilidad",
                    null
                )
            );
        }

        ActualizarDisponibilidadResponseDto.DisponibilidadDataDto data = 
            new ActualizarDisponibilidadResponseDto.DisponibilidadDataDto(
                disponibilidad.disponibilidadId(),
                disponibilidad.codigoSede(),
                disponibilidad.estado(),
                disponibilidad.fechaActualizacion() != null ? disponibilidad.fechaActualizacion().toString() : null
            );

        return new ActualizarDisponibilidadResponseDto(
            true,
            data,
            new ActualizarDisponibilidadResponseDto.MetadataDto(
                "Disponibilidad actualizada exitosamente",
                null
            )
        );
    }
}
