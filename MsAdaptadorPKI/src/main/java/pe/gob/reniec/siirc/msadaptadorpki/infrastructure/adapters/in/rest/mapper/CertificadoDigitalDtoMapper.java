package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.CertificadoDigital;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.ContactoCiudadano;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.NumerosSolicitud;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudCertificado;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudNumerosSecuencia;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarCertificadoDigitalDnieUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarNumerosSolicitudUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.MetadataRespuesta;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.RespuestaPKI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CertificadoDigitalDtoMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    
    public SolicitudCertificado toDomain(GenerarCertificadoDigitalRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudCertificado solicitud = new SolicitudCertificado();
        solicitud.setNumeroCertificados(dto.getNumeroCertificados());
        solicitud.setCertificadoAutenticacion(toCertificadoDomain(dto.getCertificadoAutenticacion(), "AUTENTICACION"));
        solicitud.setCertificadoFirma(toCertificadoDomain(dto.getCertificadoFirma(), "FIRMA"));
        solicitud.setCertificadoCifrado(toCertificadoDomain(dto.getCertificadoCifrado(), "CIFRADO"));
        solicitud.setDatosAdicionales(toDatosAdicionalesDomain(dto.getDatosAdicionales()));
        
        return solicitud;
    }
    
    public SolicitudNumerosSecuencia toNumerosSecuenciaDomain(GenerarNumerosSolicitudRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudNumerosSecuencia solicitud = new SolicitudNumerosSecuencia();
        solicitud.setDni(dto.getDni());
        solicitud.setNombres(dto.getNombres());
        solicitud.setApellidoPaterno(dto.getApellidoPaterno());
        solicitud.setApellidoMaterno(dto.getApellidoMaterno());
        solicitud.setEmail(dto.getEmail());
        solicitud.setTelefono(dto.getTelefono());
        solicitud.setDireccion(dto.getDireccion());
        solicitud.setCodigoOficina(dto.getCodigoOficina());
        solicitud.setTipoDocumento(dto.getTipoDocumento());
        solicitud.setFechaNacimiento(parseDate(dto.getFechaNacimiento()));
        solicitud.setLugarNacimiento(dto.getLugarNacimiento());
        solicitud.setNacionalidad(dto.getNacionalidad());
        solicitud.setSexo(dto.getSexo());
        solicitud.setEstadoCivil(dto.getEstadoCivil());
        solicitud.setObservaciones(dto.getObservaciones());
        
        return solicitud;
    }
    
    public GenerarCertificadoDigitalResponseDto toResponseDto(
            GenerarCertificadoDigitalDnieUseCase.GenerarCertificadoDigitalDnieResponse response) {
        if (response == null) {
            return null;
        }
        
        GenerarCertificadoDigitalResponseDto dto = new GenerarCertificadoDigitalResponseDto();
        dto.setResultado(response.getResultado());
        dto.setMensaje(response.getMensaje());
        dto.setCertificados(toCertificadosResponseDto(response.getCertificados()));
        dto.setPkiExterno(toRespuestaPKIDto(response.getPkiExterno()));
        dto.setMetadata(toMetadataDto(response.getMetadata()));
        
        return dto;
    }
    
    public GenerarNumerosSolicitudResponseDto toNumerosSolicitudResponseDto(
            GenerarNumerosSolicitudUseCase.GenerarNumerosSolicitudResponse response) {
        if (response == null) {
            return null;
        }
        
        GenerarNumerosSolicitudResponseDto dto = new GenerarNumerosSolicitudResponseDto();
        dto.setResultado(response.getResultado());
        dto.setMensaje(response.getMensaje());
        dto.setSolicitudes(toNumerosSolicitudDto(response.getSolicitudes()));
        dto.setMetadata(toMetadataDto(response.getMetadata()));
        
        return dto;
    }
    
    private CertificadoDigital toCertificadoDomain(CertificadoDigitalRequestDto dto, String tipo) {
        if (dto == null) {
            return null;
        }
        
        CertificadoDigital certificado = new CertificadoDigital();
        certificado.setTipo(tipo);
        certificado.setNumeroSolicitud(dto.getNumeroSolicitud());
        certificado.setNumeroDni(dto.getNumeroDni());
        certificado.setTipoDocumento(dto.getTipoDocumento());
        certificado.setApellidoPaterno(dto.getApellidoPaterno());
        certificado.setApellidoMaterno(dto.getApellidoMaterno());
        certificado.setNombres(dto.getNombres());
        certificado.setFechaNacimiento(parseDate(dto.getFechaNacimiento()));
        certificado.setCodigoOficina(dto.getCodigoOficina());
        certificado.setNumeroSerie(dto.getNumeroSerie());
        certificado.setFechaEmision(parseDateTime(dto.getFechaEmision()));
        certificado.setFechaExpiracion(parseDateTime(dto.getFechaExpiracion()));
        certificado.setEstadoCertificado(dto.getEstadoCertificado());
        certificado.setMotivoRevocacion(dto.getMotivoRevocacion());
        certificado.setPublicKey(dto.getPublicKey());
        certificado.setCertificadoPEM(dto.getCertificadoPEM());
        
        return certificado;
    }
    
    private ContactoCiudadano toDatosAdicionalesDomain(DatosAdicionalesDto dto) {
        if (dto == null) {
            return null;
        }
        
        ContactoCiudadano datos = new ContactoCiudadano();
        datos.setEmailCiudadano(dto.getEmailCiudadano());
        datos.setTelefonoCiudadano(dto.getTelefonoCiudadano());
        datos.setDireccionCiudadano(dto.getDireccionCiudadano());
        datos.setUsuarioRegistro(dto.getUsuarioRegistro());
        datos.setObservaciones(dto.getObservaciones());
        
        return datos;
    }
    
    private List<CertificadoDigitalResponseDto> toCertificadosResponseDto(List<CertificadoDigital> certificados) {
        if (certificados == null) {
            return null;
        }
        
        List<CertificadoDigitalResponseDto> dtos = new ArrayList<>();
        for (CertificadoDigital cert : certificados) {
            dtos.add(toCertificadoResponseDto(cert));
        }
        
        return dtos;
    }
    
    private CertificadoDigitalResponseDto toCertificadoResponseDto(CertificadoDigital certificado) {
        if (certificado == null) {
            return null;
        }
        
        CertificadoDigitalResponseDto dto = new CertificadoDigitalResponseDto();
        dto.setTipo(certificado.getTipo());
        dto.setNumeroSolicitud(certificado.getNumeroSolicitud());
        dto.setNumeroCertificado(certificado.getNumeroCertificado());
        dto.setEstadoCertificado(certificado.getEstadoCertificado());
        dto.setFechaEmision(formatDateTime(certificado.getFechaEmision()));
        dto.setFechaExpiracion(formatDateTime(certificado.getFechaExpiracion()));
        dto.setCertificadoPEM(certificado.getCertificadoPEM());
        
        return dto;
    }
    
    private RespuestaPKIDto toRespuestaPKIDto(RespuestaPKI respuesta) {
        if (respuesta == null) {
            return null;
        }
        
        RespuestaPKIDto dto = new RespuestaPKIDto();
        dto.setCodigoRespuesta(respuesta.getCodigoRespuesta());
        dto.setMensajeRespuesta(respuesta.getMensajeRespuesta());
        dto.setIdTransaccionPKI(respuesta.getIdTransaccionPKI());
        dto.setTimestampPKI(formatIsoDateTime(respuesta.getTimestampPKI()));
        
        return dto;
    }
    
    private NumerosSolicitudDto toNumerosSolicitudDto(NumerosSolicitud numeros) {
        if (numeros == null) {
            return null;
        }
        
        NumerosSolicitudDto dto = new NumerosSolicitudDto();
        dto.setNumeroSolicitudAutenticacion(numeros.getNumeroSolicitudAutenticacion());
        dto.setNumeroSolicitudFirma(numeros.getNumeroSolicitudFirma());
        dto.setNumeroSolicitudCifrado(numeros.getNumeroSolicitudCifrado());
        
        return dto;
    }
    
    private MetadataRespuestaDto toMetadataDto(MetadataRespuesta metadata) {
        if (metadata == null) {
            return null;
        }
        
        MetadataRespuestaDto dto = new MetadataRespuestaDto();
        dto.setCorrelationId(metadata.getCorrelationId());
        dto.setRequestId(metadata.getRequestId());
        dto.setTimestamp(formatIsoDateTime(metadata.getTimestamp()));
        dto.setVersion(metadata.getVersion());
        
        return dto;
    }
    
    private LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }
    
    private String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DATETIME_FORMATTER);
    }
    
    private String formatIsoDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ISO_FORMATTER);
    }
}
