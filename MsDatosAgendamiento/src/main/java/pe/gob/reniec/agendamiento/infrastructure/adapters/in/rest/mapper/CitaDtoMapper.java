package pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CitaDtoMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public Cita requestDtoToDomain(CrearCitaRequestDto dto) {
        SedeServicio sedeServicio = new SedeServicio(
            dto.sedeServicio().codigoSede(),
            dto.sedeServicio().nombreSede(),
            dto.sedeServicio().direccion(),
            dto.sedeServicio().telefono(),
            dto.sedeServicio().capacidadDiariaMaxima(),
            dto.sedeServicio().tiempoAtencionMinutos()
        );

        Solicitud solicitud = new Solicitud(
            dto.solicitud().idSolicitud(),
            dto.solicitud().numeroTramite()
        );

        Solicitante solicitante = new Solicitante(
            dto.solicitante().dni(),
            dto.solicitante().nombres(),
            dto.solicitante().apellidoPaterno(),
            dto.solicitante().apellidoMaterno(),
            dto.solicitante().nombreCompleto(),
            dto.solicitante().email(),
            dto.solicitante().telefono()
        );

        Programacion programacion = new Programacion(
            LocalDate.parse(dto.programacion().fechaCita(), DATE_FORMATTER),
            LocalTime.parse(dto.programacion().horaCita(), TIME_FORMATTER),
            LocalDateTime.parse(dto.programacion().fechaHoraCompleta(), DATETIME_FORMATTER),
            dto.programacion().idDisponibilidad()
        );

        TecnicoAsignado tecnicoAsignado = dto.tecnicoAsignado() != null
            ? new TecnicoAsignado(
                dto.tecnicoAsignado().idTecnico(),
                dto.tecnicoAsignado().nombreCompleto()
            )
            : null;

        return new Cita(
            null,
            null,
            "PENDIENTE",
            sedeServicio,
            solicitud,
            solicitante,
            programacion,
            tecnicoAsignado,
            null,
            null,
            0L,
            3L,
            dto.observaciones(),
            null,
            null,
            null,
            null
        );
    }

    public Cita updateRequestDtoToDomain(String citaId, ActualizarCitaRequestDto dto) {
        Programacion programacion = new Programacion(
            LocalDate.parse(dto.nuevaProgramacion().fechaCita(), DATE_FORMATTER),
            LocalTime.parse(dto.nuevaProgramacion().horaCita(), TIME_FORMATTER),
            LocalDateTime.parse(dto.nuevaProgramacion().fechaHoraCompleta(), DATETIME_FORMATTER),
            dto.nuevaProgramacion().idDisponibilidad()
        );

        TecnicoAsignado tecnicoAsignado = dto.tecnicoAsignado() != null
            ? new TecnicoAsignado(
                dto.tecnicoAsignado().idTecnico(),
                dto.tecnicoAsignado().nombreCompleto()
            )
            : null;

        return new Cita(
            citaId,
            null,
            null,
            null,
            null,
            null,
            programacion,
            tecnicoAsignado,
            dto.tokenReagendamiento(),
            null,
            null,
            null,
            dto.observaciones(),
            null,
            null,
            null,
            null
        );
    }

    public CitaResponseDto domainToResponseDto(Cita cita) {
        SedeServicioDto sedeServicioDto = new SedeServicioDto(
            cita.sedeServicio().codigoSede(),
            cita.sedeServicio().nombreSede(),
            cita.sedeServicio().direccion(),
            cita.sedeServicio().telefono(),
            cita.sedeServicio().capacidadDiariaMaxima(),
            cita.sedeServicio().tiempoAtencionMinutos()
        );

        SolicitanteDto solicitanteDto = new SolicitanteDto(
            cita.solicitante().dni(),
            cita.solicitante().nombres(),
            cita.solicitante().apellidoPaterno(),
            cita.solicitante().apellidoMaterno(),
            cita.solicitante().nombreCompleto(),
            cita.solicitante().email(),
            cita.solicitante().telefono()
        );

        ProgramacionDto programacionDto = new ProgramacionDto(
            cita.programacion().fechaCita().format(DATE_FORMATTER),
            cita.programacion().horaCita().format(TIME_FORMATTER),
            cita.programacion().fechaHoraCompleta().format(DATETIME_FORMATTER),
            cita.programacion().idDisponibilidad()
        );

        TecnicoAsignadoDto tecnicoAsignadoDto = cita.tecnicoAsignado() != null
            ? new TecnicoAsignadoDto(
                cita.tecnicoAsignado().idTecnico(),
                cita.tecnicoAsignado().nombreCompleto()
            )
            : null;

        Map<String, String> links = new HashMap<>();
        links.put("self", "/api/v1/citas/" + cita.citaId());
        links.put("cancelar", "/api/v1/citas/" + cita.citaId() + "/cancelar");
        links.put("actualizar", "/api/v1/citas/" + cita.citaId());

        CitaDataDto dataDto = new CitaDataDto(
            cita.citaId(),
            cita.codigoCita(),
            cita.estado(),
            sedeServicioDto,
            solicitanteDto,
            programacionDto,
            tecnicoAsignadoDto,
            cita.tokenReagendamiento(),
            cita.fechaLimiteReagendamiento() != null ? cita.fechaLimiteReagendamiento().format(DATETIME_FORMATTER) : null,
            cita.fechaRegistro() != null ? cita.fechaRegistro().format(DATETIME_FORMATTER) : null,
            cita.usuarioRegistro(),
            links
        );

        MetadataDto metadataDto = new MetadataDto(
            LocalDateTime.now().format(DATETIME_FORMATTER),
            "correlation-id-" + System.currentTimeMillis(),
            "v1"
        );

        return new CitaResponseDto(true, dataDto, metadataDto, null);
    }

    public ListarCitasResponseDto domainListToResponseDto(List<Cita> citas) {
        List<CitaDataDto> citaDataDtos = citas.stream()
            .map(cita -> {
                SedeServicioDto sedeServicioDto = new SedeServicioDto(
                    cita.sedeServicio().codigoSede(),
                    cita.sedeServicio().nombreSede(),
                    cita.sedeServicio().direccion(),
                    cita.sedeServicio().telefono(),
                    cita.sedeServicio().capacidadDiariaMaxima(),
                    cita.sedeServicio().tiempoAtencionMinutos()
                );

                SolicitanteDto solicitanteDto = new SolicitanteDto(
                    cita.solicitante().dni(),
                    cita.solicitante().nombres(),
                    cita.solicitante().apellidoPaterno(),
                    cita.solicitante().apellidoMaterno(),
                    cita.solicitante().nombreCompleto(),
                    cita.solicitante().email(),
                    cita.solicitante().telefono()
                );

                ProgramacionDto programacionDto = new ProgramacionDto(
                    cita.programacion().fechaCita().format(DATE_FORMATTER),
                    cita.programacion().horaCita().format(TIME_FORMATTER),
                    cita.programacion().fechaHoraCompleta().format(DATETIME_FORMATTER),
                    cita.programacion().idDisponibilidad()
                );

                TecnicoAsignadoDto tecnicoAsignadoDto = cita.tecnicoAsignado() != null
                    ? new TecnicoAsignadoDto(
                        cita.tecnicoAsignado().idTecnico(),
                        cita.tecnicoAsignado().nombreCompleto()
                    )
                    : null;

                Map<String, String> links = new HashMap<>();
                links.put("self", "/api/v1/citas/" + cita.citaId());

                return new CitaDataDto(
                    cita.citaId(),
                    cita.codigoCita(),
                    cita.estado(),
                    sedeServicioDto,
                    solicitanteDto,
                    programacionDto,
                    tecnicoAsignadoDto,
                    cita.tokenReagendamiento(),
                    cita.fechaLimiteReagendamiento() != null ? cita.fechaLimiteReagendamiento().format(DATETIME_FORMATTER) : null,
                    cita.fechaRegistro() != null ? cita.fechaRegistro().format(DATETIME_FORMATTER) : null,
                    cita.usuarioRegistro(),
                    links
                );
            })
            .toList();

        PaginacionDto paginacionDto = new PaginacionDto(
            (long) citas.size(),
            1L,
            1L,
            (long) citas.size(),
            false,
            false
        );

        MetadataDto metadataDto = new MetadataDto(
            LocalDateTime.now().format(DATETIME_FORMATTER),
            "correlation-id-" + System.currentTimeMillis(),
            "v1"
        );

        return new ListarCitasResponseDto(true, citaDataDtos, paginacionDto, metadataDto, null);
    }
}
