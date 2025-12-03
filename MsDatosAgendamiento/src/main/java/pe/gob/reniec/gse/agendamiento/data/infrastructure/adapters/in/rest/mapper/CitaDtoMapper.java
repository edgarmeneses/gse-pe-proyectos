package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.gse.agendamiento.data.domain.model.*;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CitaDtoMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    public static Cita toDomain(CrearCitaRequestDto dto) {
        Cita cita = new Cita();
        
        SedeServicio sedeServicio = new SedeServicio(
            dto.sedeServicio().codigoSede(),
            dto.sedeServicio().nombreSede(),
            null, null, null, null
        );
        cita.setSedeServicio(sedeServicio);
        
        Solicitud solicitud = new Solicitud(
            dto.solicitud().idSolicitud(),
            dto.solicitud().numeroTramite()
        );
        cita.setSolicitud(solicitud);
        
        Solicitante solicitante = new Solicitante(
            dto.solicitante().dni(),
            dto.solicitante().nombres(),
            dto.solicitante().apellidoPaterno(),
            dto.solicitante().apellidoMaterno(),
            dto.solicitante().email(),
            dto.solicitante().telefono()
        );
        cita.setSolicitante(solicitante);
        
        Programacion programacion = new Programacion(
            LocalDate.parse(dto.programacion().fechaCita(), DATE_FORMATTER),
            LocalTime.parse(dto.programacion().horaCita(), TIME_FORMATTER),
            dto.programacion().idDisponibilidad()
        );
        cita.setProgramacion(programacion);
        
        if (dto.tecnicoAsignado() != null) {
            TecnicoAsignado tecnico = new TecnicoAsignado(
                dto.tecnicoAsignado().idTecnico(),
                dto.tecnicoAsignado().nombreCompleto()
            );
            cita.setTecnicoAsignado(tecnico);
        }
        
        cita.setObservaciones(dto.observaciones());
        
        return cita;
    }
    
    public static CrearCitaResponseDto toCrearResponse(Cita cita) {
        SedeServicioResponseDto sedeDto = new SedeServicioResponseDto(
            cita.getSedeServicio().getCodigoSede(),
            cita.getSedeServicio().getNombreSede(),
            cita.getSedeServicio().getDireccion()
        );
        
        SolicitanteResponseDto solicitanteDto = new SolicitanteResponseDto(
            cita.getSolicitante().getDni(),
            cita.getSolicitante().getNombreCompleto()
        );
        
        ProgramacionResponseDto programacionDto = new ProgramacionResponseDto(
            cita.getProgramacion().getFechaCita().format(DATE_FORMATTER),
            cita.getProgramacion().getHoraCita().format(TIME_FORMATTER),
            LocalDateTime.of(cita.getProgramacion().getFechaCita(), cita.getProgramacion().getHoraCita()).format(DATETIME_FORMATTER)
        );
        
        TecnicoAsignadoDto tecnicoDto = null;
        if (cita.getTecnicoAsignado() != null) {
            tecnicoDto = new TecnicoAsignadoDto(
                cita.getTecnicoAsignado().getIdTecnico(),
                cita.getTecnicoAsignado().getNombreCompleto()
            );
        }
        
        Map<String, String> links = new HashMap<>();
        links.put("self", "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId());
        links.put("actualizar", "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId());
        links.put("cancelar", "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId() + "/cancelar");
        links.put("historial", "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId() + "/historial");
        
        return new CrearCitaResponseDto(
            cita.getCitaId(),
            cita.getCodigoCita(),
            cita.getEstado().getCodigo(),
            sedeDto,
            solicitanteDto,
            programacionDto,
            tecnicoDto,
            cita.getTokenReagendamiento(),
            cita.getFechaLimiteReagendamiento().format(DATETIME_FORMATTER),
            cita.getFechaRegistro().format(DATETIME_FORMATTER),
            cita.getUsuarioRegistro(),
            links
        );
    }
    
    public static ApiResponseDto<CrearCitaResponseDto> toApiResponse(Cita cita, String correlationId) {
        CrearCitaResponseDto data = toCrearResponse(cita);
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now().format(DATETIME_FORMATTER),
            correlationId,
            "1.0"
        );
        
        return new ApiResponseDto<>(true, data, metadata, null);
    }
    
    public static PaginacionDto toPaginacionDto(Paginacion paginacion) {
        return new PaginacionDto(
            paginacion.getTotalRegistros(),
            paginacion.getTotalPaginas(),
            paginacion.getPaginaActual(),
            paginacion.getRegistrosPorPagina(),
            paginacion.getTieneAnterior(),
            paginacion.getTieneSiguiente()
        );
    }
}
