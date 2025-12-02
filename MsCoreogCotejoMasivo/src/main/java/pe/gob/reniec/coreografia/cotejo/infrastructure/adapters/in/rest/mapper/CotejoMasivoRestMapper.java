package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreografia.cotejo.domain.model.*;
import pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CotejoMasivoRestMapper {

    private static final DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    private static final DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    public SolicitudCotejoMasivo toDomain(IniciarCotejoMasivoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Solicitud solicitud = toSolicitudDomain(dto.solicitud());
        EntidadSolicitante entidadSolicitante = toEntidadSolicitanteDomain(dto.entidadSolicitante());
        List<RegistroCotejo> registrosCotejo = toRegistrosCotejoDomain(dto.registrosCotejo());
        ConfiguracionProceso configuracionProceso = toConfiguracionProcesoDomain(dto.configuracionProceso());
        DocumentoSolicitud documentoSolicitud = toDocumentoSolicitudDomain(dto.documentoSolicitud());

        return new SolicitudCotejoMasivo(
            solicitud,
            entidadSolicitante,
            registrosCotejo,
            configuracionProceso,
            documentoSolicitud,
            dto.observaciones()
        );
    }

    private Solicitud toSolicitudDomain(SolicitudDto dto) {
        if (dto == null) {
            return null;
        }
        LocalDateTime fechaSolicitud = dto.fechaSolicitud() != null ? 
            LocalDateTime.parse(dto.fechaSolicitud(), ISO_DATE_TIME_FORMATTER) : null;
        
        return new Solicitud(
            dto.numeroSolicitud(),
            dto.tipoTramite(),
            fechaSolicitud,
            dto.prioridad()
        );
    }

    private EntidadSolicitante toEntidadSolicitanteDomain(EntidadSolicitanteDto dto) {
        if (dto == null) {
            return null;
        }
        RepresentanteLegal representanteLegal = toRepresentanteLegalDomain(dto.representanteLegal());
        Contacto contacto = toContactoDomain(dto.contacto());

        return new EntidadSolicitante(
            dto.codigo(),
            dto.nombre(),
            dto.ruc(),
            representanteLegal,
            contacto
        );
    }

    private RepresentanteLegal toRepresentanteLegalDomain(RepresentanteLegalDto dto) {
        if (dto == null) {
            return null;
        }
        return new RepresentanteLegal(
            dto.dni(),
            dto.nombres(),
            dto.apellidoPaterno(),
            dto.apellidoMaterno()
        );
    }

    private Contacto toContactoDomain(ContactoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Contacto(dto.email(), dto.telefono());
    }

    private List<RegistroCotejo> toRegistrosCotejoDomain(List<RegistroCotejoDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }
        return dtos.stream()
            .map(this::toRegistrotejoDomain)
            .collect(Collectors.toList());
    }

    private RegistroCotejo toRegistrotejoDomain(RegistroCotejoDto dto) {
        if (dto == null) {
            return null;
        }
        LocalDate fechaNacimiento = dto.fechaNacimiento() != null ? 
            LocalDate.parse(dto.fechaNacimiento(), ISO_DATE_FORMATTER) : null;

        return new RegistroCotejo(
            dto.secuencia(),
            dto.numeroDni(),
            dto.apellidoPaterno(),
            dto.apellidoMaterno(),
            dto.nombres(),
            fechaNacimiento,
            dto.genero()
        );
    }

    private ConfiguracionProceso toConfiguracionProcesoDomain(ConfiguracionProcesoDto dto) {
        if (dto == null) {
            return null;
        }
        return new ConfiguracionProceso(
            dto.notificarProgreso(),
            dto.generarReporteDetallado(),
            dto.formatoReporte()
        );
    }

    private DocumentoSolicitud toDocumentoSolicitudDomain(DocumentoSolicitudDto dto) {
        if (dto == null) {
            return null;
        }
        return new DocumentoSolicitud(
            dto.tipo(),
            dto.nombre(),
            dto.urlDocumento(),
            dto.hashDocumento()
        );
    }

    public IniciarCotejoMasivoResponseDto toResponseDto(RespuestaIniciarCotejo respuesta, 
                                                        String correlationId, 
                                                        String version) {
        if (respuesta == null) {
            return null;
        }

        EntidadSolicitanteResponseDto entidadDto = new EntidadSolicitanteResponseDto(
            respuesta.getEntidadSolicitante().getCodigo(),
            respuesta.getEntidadSolicitante().getNombre()
        );

        OficinaRegistroDto oficinaDto = toOficinaRegistroDto(respuesta.getOficinaRegistro());
        ResumenSolicitudDto resumenDto = toResumenSolicitudDto(respuesta.getResumenSolicitud());
        List<SiguientePasoDto> siguientesPasos = toSiguientesPasosDto(respuesta.getSiguientesPasos());
        List<EventoGeneradoDto> eventosDto = toEventosGeneradosDto(respuesta.getEventosGenerados());
        LinksDto linksDto = new LinksDto(null, null, null);

        DatosCotejoDto dataDto = new DatosCotejoDto(
            respuesta.getSolicitudId(),
            respuesta.getNumeroSolicitud(),
            respuesta.getEstado(),
            respuesta.getTipoTramite(),
            entidadDto,
            respuesta.getFechaRegistro() != null ? respuesta.getFechaRegistro().format(ISO_DATE_TIME_FORMATTER) : null,
            respuesta.getUsuarioRegistro(),
            oficinaDto,
            resumenDto,
            siguientesPasos,
            respuesta.getUrlSeguimiento(),
            eventosDto,
            linksDto
        );

        MetadataDto metadataDto = new MetadataDto(
            LocalDateTime.now().format(ISO_DATE_TIME_FORMATTER),
            correlationId,
            version,
            "0ms"
        );

        return new IniciarCotejoMasivoResponseDto(true, dataDto, metadataDto);
    }

    private OficinaRegistroDto toOficinaRegistroDto(OficinaRegistro oficinaRegistro) {
        if (oficinaRegistro == null) {
            return null;
        }
        return new OficinaRegistroDto(oficinaRegistro.getCodigo(), oficinaRegistro.getNombre());
    }

    private ResumenSolicitudDto toResumenSolicitudDto(ResumenSolicitud resumen) {
        if (resumen == null) {
            return null;
        }
        return new ResumenSolicitudDto(
            resumen.getTotalRegistros(),
            resumen.getPrioridad(),
            resumen.getTiempoEstimadoProcesamiento()
        );
    }

    private List<SiguientePasoDto> toSiguientesPasosDto(List<SiguientePaso> siguientesPasos) {
        if (siguientesPasos == null) {
            return new ArrayList<>();
        }
        return siguientesPasos.stream()
            .map(paso -> new SiguientePasoDto(paso.getPaso(), paso.getDescripcion()))
            .collect(Collectors.toList());
    }

    private List<EventoGeneradoDto> toEventosGeneradosDto(List<EventoGenerado> eventos) {
        if (eventos == null) {
            return new ArrayList<>();
        }
        return eventos.stream()
            .map(evento -> new EventoGeneradoDto(
                evento.getEventId(),
                evento.getEventType(),
                evento.getTopic()
            ))
            .collect(Collectors.toList());
    }
}
