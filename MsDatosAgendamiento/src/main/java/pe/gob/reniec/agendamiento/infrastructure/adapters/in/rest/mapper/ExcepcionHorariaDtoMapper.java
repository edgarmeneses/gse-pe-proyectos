package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcepcionHorariaDtoMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public ExcepcionHoraria requestDtoToDomain(RegistrarExcepcionHorariaRequestDto dto) {
        HorarioEspecial horarioEspecial = dto.horarioEspecial() != null
            ? new HorarioEspecial(
                LocalTime.parse(dto.horarioEspecial().horaInicio(), TIME_FORMATTER),
                LocalTime.parse(dto.horarioEspecial().horaFin(), TIME_FORMATTER),
                dto.horarioEspecial().capacidadPorFranja()
            )
            : null;

        CitasAfectadas citasAfectadas = new CitasAfectadas(
            0L,
            dto.afectaCitasExistentes() ? "REAGENDAR" : "NINGUNA",
            null
        );

        return new ExcepcionHoraria(
            null,
            dto.codigoSede(),
            null,
            LocalDate.parse(dto.fechaExcepcion(), DATE_FORMATTER),
            dto.tipoExcepcion(),
            dto.descripcion(),
            horarioEspecial,
            citasAfectadas,
            null,
            null,
            null
        );
    }

    public ExcepcionHorariaResponseDto domainToResponseDto(ExcepcionHoraria excepcion) {
        HorarioEspecialDto horarioEspecialDto = excepcion.horarioEspecial() != null
            ? new HorarioEspecialDto(
                excepcion.horarioEspecial().horaInicio().format(TIME_FORMATTER),
                excepcion.horarioEspecial().horaFin().format(TIME_FORMATTER),
                excepcion.horarioEspecial().capacidadPorFranja()
            )
            : null;

        CitasAfectadasDto citasAfectadasDto = excepcion.citasAfectadas() != null
            ? new CitasAfectadasDto(
                excepcion.citasAfectadas().cantidad(),
                excepcion.citasAfectadas().accion(),
                excepcion.citasAfectadas().citasIds()
            )
            : null;

        ExcepcionHorariaDataDto dataDto = new ExcepcionHorariaDataDto(
            excepcion.idExcepcion(),
            excepcion.codigoSede(),
            excepcion.nombreSede(),
            excepcion.fechaExcepcion().format(DATE_FORMATTER),
            excepcion.tipoExcepcion(),
            excepcion.descripcion(),
            horarioEspecialDto,
            citasAfectadasDto,
            excepcion.fechaRegistro() != null ? excepcion.fechaRegistro().format(DATETIME_FORMATTER) : null,
            excepcion.usuarioRegistro()
        );

        MetadataDto metadataDto = new MetadataDto(
            LocalDateTime.now().format(DATETIME_FORMATTER),
            "correlation-id-" + System.currentTimeMillis(),
            "v1"
        );

        return new ExcepcionHorariaResponseDto(true, dataDto, metadataDto, null);
    }
}
