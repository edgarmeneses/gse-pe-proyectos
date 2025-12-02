package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DisponibilidadDtoMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public Disponibilidad requestDtoToDomain(ConfigurarDisponibilidadRequestDto dto) {
        SedeServicio sedeServicio = new SedeServicio(
            dto.sedeServicio().codigoSede(),
            dto.sedeServicio().nombreSede(),
            dto.sedeServicio().direccion(),
            dto.sedeServicio().telefono(),
            dto.sedeServicio().capacidadDiariaMaxima(),
            dto.sedeServicio().tiempoAtencionMinutos()
        );

        List<HorarioServicio> horarios = dto.horarioServicio().stream()
            .map(h -> new HorarioServicio(
                h.diaSemana(),
                h.nombreDia(),
                LocalTime.parse(h.horaInicio(), TIME_FORMATTER),
                LocalTime.parse(h.horaFin(), TIME_FORMATTER),
                h.capacidadPorFranja(),
                h.duracionFranjaMinutos(),
                h.activo()
            ))
            .toList();

        return new Disponibilidad(
            null,
            sedeServicio,
            null,
            null,
            true,
            null,
            null,
            null,
            null,
            null,
            null,
            "DISPONIBLE",
            horarios,
            null,
            null,
            null,
            null
        );
    }

    public Disponibilidad updateRequestDtoToDomain(String disponibilidadId, ActualizarDisponibilidadRequestDto dto) {
        return new Disponibilidad(
            disponibilidadId,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            dto.capacidadTotal(),
            null,
            null,
            dto.estado(),
            null,
            null,
            null,
            null,
            null
        );
    }

    public DisponibilidadResponseDto domainToResponseDto(Disponibilidad disponibilidad) {
        SedeServicioDto sedeServicioDto = new SedeServicioDto(
            disponibilidad.sedeServicio().codigoSede(),
            disponibilidad.sedeServicio().nombreSede(),
            disponibilidad.sedeServicio().direccion(),
            disponibilidad.sedeServicio().telefono(),
            disponibilidad.sedeServicio().capacidadDiariaMaxima(),
            disponibilidad.sedeServicio().tiempoAtencionMinutos()
        );

        List<FranjaDisponibilidadDto> franjas = disponibilidad.horarioServicio() != null
            ? disponibilidad.horarioServicio().stream()
                .map(h -> new FranjaDisponibilidadDto(
                    disponibilidad.idDisponibilidad(),
                    h.horaInicio().format(TIME_FORMATTER),
                    h.horaFin().format(TIME_FORMATTER),
                    h.capacidadPorFranja(),
                    0L,
                    h.capacidadPorFranja(),
                    "DISPONIBLE"
                ))
                .toList()
            : List.of();

        DisponibilidadDataDto dataDto = new DisponibilidadDataDto(
            disponibilidad.idDisponibilidad(),
            sedeServicioDto,
            disponibilidad.fecha() != null ? disponibilidad.fecha().format(DATE_FORMATTER) : null,
            disponibilidad.diaSemana(),
            disponibilidad.esHabil(),
            disponibilidad.motivoNoHabil(),
            disponibilidad.horaInicio() != null ? disponibilidad.horaInicio().format(TIME_FORMATTER) : null,
            disponibilidad.horaFin() != null ? disponibilidad.horaFin().format(TIME_FORMATTER) : null,
            disponibilidad.capacidadTotal(),
            disponibilidad.capacidadOcupada(),
            disponibilidad.capacidadDisponible(),
            disponibilidad.estado(),
            franjas
        );

        MetadataDto metadataDto = new MetadataDto(
            LocalDateTime.now().format(DATETIME_FORMATTER),
            "correlation-id-" + System.currentTimeMillis(),
            "v1"
        );

        return new DisponibilidadResponseDto(true, dataDto, metadataDto, null);
    }
}
