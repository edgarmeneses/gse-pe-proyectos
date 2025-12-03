package pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreografia.cotejomasivo.domain.model.*;
import pe.gob.reniec.coreografia.cotejomasivo.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper - Convierte entre DTOs y objetos del dominio
 * Sin uso de librerías de mapeo (MapStruct, ModelMapper, etc.)
 */
public class CotejoMasivoDtoMapper {
    
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    /**
     * Convierte RequestDto a modelo de dominio
     */
    public SolicitudCotejoMasivo toDomain(CotejoMasivoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudCotejoMasivo solicitud = new SolicitudCotejoMasivo();
        
        // Mapear datos básicos desde SolicitudDto
        if (dto.getSolicitud() != null) {
            solicitud.setNumeroSolicitud(dto.getSolicitud().getNumeroSolicitud());
            solicitud.setTipoTramite(dto.getSolicitud().getTipoTramite());
            solicitud.setFechaSolicitud(parseDateTime(dto.getSolicitud().getFechaSolicitud()));
            solicitud.setPrioridad(Prioridad.fromString(dto.getSolicitud().getPrioridad()));
        }
        
        solicitud.setEntidadSolicitante(toEntidadSolicitanteDomain(dto.getEntidadSolicitante()));
        solicitud.setRegistrosCotejo(toRegistrosCotejoDomain(dto.getRegistrosCotejo()));
        solicitud.setConfiguracionProceso(toConfiguracionProcesoDomain(dto.getConfiguracionProceso()));
        solicitud.setDocumentoSolicitud(toDocumentoSolicitudDomain(dto.getDocumentoSolicitud()));
        solicitud.setObservaciones(dto.getObservaciones());
        
        return solicitud;
    }
    
    /**
     * Convierte ResultadoRegistroSolicitud de dominio a ResponseDto
     */
    public CotejoMasivoResponseDto toResponseDto(ResultadoRegistroSolicitud resultado) {
        if (resultado == null) {
            return null;
        }
        
        CotejoMasivoResponseDto dto = new CotejoMasivoResponseDto();
        
        DataResponseDto data = new DataResponseDto();
        SolicitudCotejoMasivo solicitud = resultado.getSolicitud();
        
        data.setSolicitudId(solicitud.getSolicitudId());
        data.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        data.setEstado(solicitud.getEstado().name());
        data.setTipoTramite(solicitud.getTipoTramite());
        data.setEntidadSolicitante(toEntidadSolicitanteResponseDto(solicitud.getEntidadSolicitante()));
        data.setFechaRegistro(formatDateTime(solicitud.getFechaRegistro()));
        data.setUsuarioRegistro(solicitud.getUsuarioRegistro());
        
        // Oficina de registro
        OficinaRegistroDto oficinaDto = new OficinaRegistroDto();
        oficinaDto.setCodigo(solicitud.getCodigoOficina());
        oficinaDto.setNombre("Oficina " + solicitud.getCodigoOficina()); // TODO: obtener nombre real
        data.setOficinaRegistro(oficinaDto);
        
        // Resumen de solicitud
        ResumenSolicitudDto resumenDto = new ResumenSolicitudDto();
        resumenDto.setTotalRegistros(solicitud.getRegistrosCotejo().size());
        resumenDto.setPrioridad(solicitud.getPrioridad().name());
        resumenDto.setTiempoEstimadoProcesamiento(resultado.getTiempoEstimadoProcesamiento());
        data.setResumenSolicitud(resumenDto);
        
        data.setUrlSeguimiento("/api/v1/ciudadano/MsCoreogCotejoMasivo/" + solicitud.getSolicitudId());
        data.setEventosGenerados(toEventosGeneradosDto(resultado.getEventosGenerados()));
        
        // Links HATEOAS
        LinksDto linksDto = new LinksDto();
        linksDto.setSelf("/api/v1/ciudadano/MsCoreogCotejoMasivo/" + solicitud.getSolicitudId());
        linksDto.setConsultarEstado("/api/v1/ciudadano/MsCoreogCotejoMasivo/" + solicitud.getSolicitudId() + "/estado");
        linksDto.setCancelar("/api/v1/ciudadano/MsCoreogCotejoMasivo/" + solicitud.getSolicitudId() + "/cancelar");
        data.setLinks(linksDto);
        
        dto.setData(data);
        
        return dto;
    }
    
    // Métodos auxiliares de conversión de dominio a DTO
    
    private EntidadSolicitante toEntidadSolicitanteDomain(EntidadSolicitanteDto dto) {
        if (dto == null) {
            return null;
        }
        
        EntidadSolicitante entidad = new EntidadSolicitante();
        entidad.setCodigo(dto.getCodigo());
        entidad.setNombre(dto.getNombre());
        entidad.setRuc(dto.getRuc());
        entidad.setRepresentanteLegal(toRepresentanteLegalDomain(dto.getRepresentanteLegal()));
        entidad.setContacto(toContactoDomain(dto.getContacto()));
        
        return entidad;
    }
    
    private RepresentanteLegal toRepresentanteLegalDomain(RepresentanteLegalDto dto) {
        if (dto == null) {
            return null;
        }
        
        RepresentanteLegal representante = new RepresentanteLegal();
        representante.setDni(dto.getDni());
        representante.setNombres(dto.getNombres());
        representante.setApellidoPaterno(dto.getApellidoPaterno());
        representante.setApellidoMaterno(dto.getApellidoMaterno());
        
        return representante;
    }
    
    private Contacto toContactoDomain(ContactoDto dto) {
        if (dto == null) {
            return null;
        }
        
        Contacto contacto = new Contacto();
        contacto.setEmail(dto.getEmail());
        contacto.setTelefono(dto.getTelefono());
        
        return contacto;
    }
    
    private List<RegistroCotejo> toRegistrosCotejoDomain(List<RegistroCotejoDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }
        
        return dtos.stream()
            .map(this::toRegistroCotejoDomain)
            .collect(Collectors.toList());
    }
    
    private RegistroCotejo toRegistroCotejoDomain(RegistroCotejoDto dto) {
        if (dto == null) {
            return null;
        }
        
        RegistroCotejo registro = new RegistroCotejo();
        registro.setSecuencia(dto.getSecuencia());
        registro.setNumeroDni(dto.getNumeroDni());
        registro.setApellidoPaterno(dto.getApellidoPaterno());
        registro.setApellidoMaterno(dto.getApellidoMaterno());
        registro.setNombres(dto.getNombres());
        registro.setFechaNacimiento(parseDateTime(dto.getFechaNacimiento()));
        
        // Convertir String a enum Genero
        if (dto.getGenero() != null) {
            try {
                registro.setGenero(Genero.valueOf(dto.getGenero().toUpperCase()));
            } catch (IllegalArgumentException e) {
                registro.setGenero(null); // O manejar el error apropiadamente
            }
        }
        
        return registro;
    }
    
    private ConfiguracionProceso toConfiguracionProcesoDomain(ConfiguracionProcesoDto dto) {
        if (dto == null) {
            return null;
        }
        
        ConfiguracionProceso config = new ConfiguracionProceso();
        config.setNotificarProgreso(dto.getNotificarProgreso());
        config.setGenerarReporteDetallado(dto.getGenerarReporteDetallado());
        
        // Convertir String a enum FormatoReporte
        if (dto.getFormatoReporte() != null) {
            try {
                config.setFormatoReporte(FormatoReporte.valueOf(dto.getFormatoReporte().toUpperCase()));
            } catch (IllegalArgumentException e) {
                config.setFormatoReporte(FormatoReporte.PDF); // Valor por defecto
            }
        }
        
        return config;
    }
    
    private DocumentoSolicitud toDocumentoSolicitudDomain(DocumentoSolicitudDto dto) {
        if (dto == null) {
            return null;
        }
        
        DocumentoSolicitud documento = new DocumentoSolicitud();
        documento.setTipo(dto.getTipo());
        documento.setNombre(dto.getNombre());
        documento.setUrlDocumento(dto.getUrlDocumento());
        documento.setHashDocumento(dto.getHashDocumento());
        
        return documento;
    }
    
    // Métodos auxiliares de conversión de dominio a DTO de respuesta
    
    private EntidadSolicitanteResponseDto toEntidadSolicitanteResponseDto(EntidadSolicitante entidad) {
        if (entidad == null) {
            return null;
        }
        
        EntidadSolicitanteResponseDto dto = new EntidadSolicitanteResponseDto();
        dto.setCodigo(entidad.getCodigo());
        dto.setNombre(entidad.getNombre());
        
        return dto;
    }
    
    private List<EventoGeneradoDto> toEventosGeneradosDto(List<EventoGenerado> eventos) {
        if (eventos == null) {
            return new ArrayList<>();
        }
        
        return eventos.stream()
            .map(this::toEventoGeneradoDto)
            .collect(Collectors.toList());
    }
    
    private EventoGeneradoDto toEventoGeneradoDto(EventoGenerado evento) {
        if (evento == null) {
            return null;
        }
        
        EventoGeneradoDto dto = new EventoGeneradoDto();
        dto.setEventId(evento.getEventId());
        dto.setEventType(evento.getEventType());
        dto.setTopic(evento.getTopic());
        
        return dto;
    }
    
    // Métodos auxiliares para formateo de fechas
    
    private LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        
        try {
            return LocalDateTime.parse(dateTimeStr, ISO_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.format(ISO_FORMATTER);
    }
}
