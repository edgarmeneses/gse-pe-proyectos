package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.*;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre DTOs y modelos de dominio para verificación de firmas
 */
public class VerificarFirmaDtoMapper {
    
    private static final DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;
    private static final DateTimeFormatter ISO_DATETIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    /**
     * Convierte el DTO de request a modelo de dominio
     */
    public SolicitudVerificacionFirma toDomain(VerificarFirmaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudVerificacionFirma solicitud = new SolicitudVerificacionFirma();
        solicitud.setSolicitudId(dto.solicitudId());
        solicitud.setTramiteId(dto.tramiteId());
        solicitud.setTipoTramite(dto.tipoTramite());
        solicitud.setDocumento(toDocumentoDomain(dto.documento()));
        solicitud.setRegistrador(toRegistradorDomain(dto.registrador()));
        solicitud.setFirmaDigital(toFirmaDigitalDomain(dto.firmaDigital()));
        solicitud.setParametrosValidacionFirma(toParametrosValidacionFirmaDomain(dto.parametrosValidacionFirma()));
        solicitud.setUsuarioSolicita(dto.usuarioSolicita());
        solicitud.setOficinaOrigen(dto.oficinaOrigen());
        solicitud.setFechaSolicitud(parseDateTime(dto.fechaSolicitud()));
        solicitud.setObservaciones(dto.observaciones());
        
        return solicitud;
    }
    
    /**
     * Convierte el modelo de dominio de verificación a DTO de respuesta
     */
    public VerificarFirmaResponseDto toResponseDto(VerificacionFirma verificacion) {
        if (verificacion == null) {
            return null;
        }
        
        VerificacionDataDto dataDto = new VerificacionDataDto(
            verificacion.getVerificacionId(),
            verificacion.getSolicitudId(),
            verificacion.getTramiteId(),
            verificacion.getDocumentoId(),
            formatDateTime(verificacion.getFechaVerificacion()),
            toResultadoVerificacionDto(verificacion.getResultadoVerificacion()),
            toDatosRegistradorDto(verificacion.getDatosRegistrador()),
            toDatosFirmaDigitalDto(verificacion.getDatosFirmaDigital()),
            toAlertasDto(verificacion.getAlertas())
        );
        
        MetadataDto metadata = new MetadataDto(
            formatDateTime(LocalDateTime.now()),
            verificacion.getVerificacionId(),
            "v1",
            "server-01"
        );
        
        return new VerificarFirmaResponseDto(true, dataDto, metadata);
    }
    
    private Documento toDocumentoDomain(DocumentoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Documento(
            dto.documentoId(),
            dto.tipoDocumental(),
            dto.nombreArchivo(),
            dto.rutaGestorDocumental(),
            dto.hashSHA256(),
            dto.formatoDocumento(),
            dto.tamanioBytes(),
            dto.requiereValidacionIA()
        );
    }
    
    private Registrador toRegistradorDomain(RegistradorDto dto) {
        if (dto == null) {
            return null;
        }
        return new Registrador(
            dto.codigoRegistrador(),
            dto.nombreRegistrador(),
            dto.documentoIdentidad(),
            dto.oficinaRegistral(),
            parseDate(dto.periodoInicio()),
            parseDate(dto.periodoFin())
        );
    }
    
    private FirmaDigital toFirmaDigitalDomain(FirmaDigitalDto dto) {
        if (dto == null) {
            return null;
        }
        return new FirmaDigital(
            dto.idFirma(),
            dto.numeroSerieCertificado(),
            dto.subjectDN(),
            dto.algoritmoFirma(),
            parseDateTime(dto.fechaFirma()),
            dto.huellaCertificado(),
            dto.entidadCertificadora()
        );
    }
    
    private ParametrosValidacionFirma toParametrosValidacionFirmaDomain(ParametrosValidacionFirmaDto dto) {
        if (dto == null) {
            return null;
        }
        return new ParametrosValidacionFirma(
            dto.validarContraBDRegistradores(),
            dto.validarPeriodoVigencia(),
            dto.validarCertificadoDigital()
        );
    }
    
    private ResultadoVerificacionDto toResultadoVerificacionDto(ResultadoVerificacion domain) {
        if (domain == null) {
            return null;
        }
        return new ResultadoVerificacionDto(
            domain.getEstadoFirma(),
            domain.getEsFirmaValida(),
            domain.getDetalleEstado(),
            domain.getFuenteValidacion(),
            domain.getRequiereRevisionManual()
        );
    }
    
    private DatosRegistradorDto toDatosRegistradorDto(DatosRegistrador domain) {
        if (domain == null) {
            return null;
        }
        return new DatosRegistradorDto(
            domain.getCodigoRegistrador(),
            domain.getNombreRegistrador(),
            domain.getDocumentoIdentidad(),
            domain.getOficinaRegistral(),
            formatDate(domain.getPeriodoInicio()),
            formatDate(domain.getPeriodoFin()),
            domain.getEnPeriodoVigencia()
        );
    }
    
    private DatosFirmaDigitalDto toDatosFirmaDigitalDto(DatosFirmaDigital domain) {
        if (domain == null) {
            return null;
        }
        return new DatosFirmaDigitalDto(
            domain.getIdFirma(),
            domain.getNumeroSerieCertificado(),
            domain.getSubjectDN(),
            domain.getAlgoritmoFirma(),
            formatDateTime(domain.getFechaFirma()),
            domain.getHuellaCertificado(),
            domain.getEntidadCertificadora()
        );
    }
    
    private List<AlertaDto> toAlertasDto(List<Alerta> domain) {
        if (domain == null) {
            return null;
        }
        return domain.stream()
                .map(alerta -> new AlertaDto(
                    alerta.getCodigo(),
                    alerta.getDescripcion(),
                    alerta.getSeveridad()
                ))
                .collect(Collectors.toList());
    }
    
    private LocalDate parseDate(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(fecha, ISO_DATE_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private LocalDateTime parseDateTime(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(fecha, ISO_DATETIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private String formatDate(LocalDate fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.format(ISO_DATE_FORMATTER);
    }
    
    private String formatDateTime(LocalDateTime fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.format(ISO_DATETIME_FORMATTER);
    }
}
