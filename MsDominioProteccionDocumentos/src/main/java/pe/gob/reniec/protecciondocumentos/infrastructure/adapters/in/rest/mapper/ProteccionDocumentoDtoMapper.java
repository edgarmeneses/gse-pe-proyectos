package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.protecciondocumentos.domain.model.*;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProteccionDocumentoDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public SolicitudProteccion toDomain(ProteccionDocumentoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        SolicitudProteccion solicitud = new SolicitudProteccion();
        solicitud.setSolicitudId(dto.solicitudId());
        solicitud.setTipoDocumento(dto.tipoDocumento());
        solicitud.setNombreArchivo(dto.nombreArchivo());
        solicitud.setFuenteDocumento(toFuenteDocumentoDomain(dto.fuenteDocumento()));
        solicitud.setMetadatos(toMetadatosDomain(dto.metadatos()));
        solicitud.setConfiguracionProteccion(toConfiguracionDomain(dto.configuracionProteccion()));
        solicitud.setDestinatario(toDestinatarioDomain(dto.destinatario()));

        return solicitud;
    }

    private FuenteDocumento toFuenteDocumentoDomain(FuenteDocumentoDto dto) {
        if (dto == null) {
            return null;
        }

        FuenteDocumento fuente = new FuenteDocumento();
        fuente.setTipo(dto.tipo());
        fuente.setContenidoBase64(dto.contenidoBase64());
        fuente.setReferenciaRepositorio(toReferenciaDomain(dto.referenciaRepositorio()));

        return fuente;
    }

    private ReferenciaRepositorio toReferenciaDomain(ReferenciaRepositorioDto dto) {
        if (dto == null) {
            return null;
        }

        ReferenciaRepositorio referencia = new ReferenciaRepositorio();
        referencia.setRepositorioId(dto.repositorioId());
        referencia.setDocumentoId(dto.documentoId());
        referencia.setVersionId(dto.versionId());

        return referencia;
    }

    private MetadatosSolicitud toMetadatosDomain(MetadatosSolicitudDto dto) {
        if (dto == null) {
            return null;
        }

        MetadatosSolicitud metadatos = new MetadatosSolicitud();
        metadatos.setTipoTramite(dto.tipoTramite());
        metadatos.setNumeroSolicitud(dto.numeroSolicitud());
        metadatos.setDniSolicitante(dto.dniSolicitante());
        metadatos.setFechaGeneracion(dto.fechaGeneracion());

        return metadatos;
    }

    private ConfiguracionProteccion toConfiguracionDomain(ConfiguracionProteccionDto dto) {
        if (dto == null) {
            return null;
        }

        ConfiguracionProteccion configuracion = new ConfiguracionProteccion();
        configuracion.setUsarConfiguracionPorDefecto(dto.usarConfiguracionPorDefecto());
        configuracion.setAlgoritmoCompresion(dto.algoritmoCompresion());
        configuracion.setNivelCompresion(dto.nivelCompresion());

        return configuracion;
    }

    private Destinatario toDestinatarioDomain(DestinatarioDto dto) {
        if (dto == null) {
            return null;
        }

        Destinatario destinatario = new Destinatario();
        destinatario.setEmail(dto.email());
        destinatario.setTelefono(dto.telefono());
        destinatario.setNombreCompleto(dto.nombreCompleto());

        return destinatario;
    }

    public ProteccionDocumentoResponseDto toResponseDto(ProteccionDocumento domain, String correlationId, String version) {
        if (domain == null) {
            return null;
        }

        ProteccionDocumentoDataDto data = new ProteccionDocumentoDataDto(
            domain.getProteccionId(),
            domain.getSolicitudId(),
            toArchivoProtegidoDto(domain.getArchivoProtegido()),
            toInformacionSeguridadDto(domain.getSeguridad()),
            toEstadisticasCompresionDto(domain.getCompresion()),
            domain.getEstado(),
            domain.getFechaProcesamiento(),
            toLinksDto(domain.getLinks())
        );

        MetadataDto metadata = new MetadataDto(
            formatDateTime(LocalDateTime.now()),
            correlationId,
            version,
            "0ms"
        );

        return new ProteccionDocumentoResponseDto(true, data, metadata);
    }

    private ArchivoProtegidoDto toArchivoProtegidoDto(ArchivoProtegido domain) {
        if (domain == null) {
            return null;
        }

        return new ArchivoProtegidoDto(
            domain.getRepositorioId(),
            domain.getDocumentoId(),
            domain.getNombreArchivo(),
            domain.getTamanioBytes(),
            domain.getFormatoSalida(),
            domain.getChecksumSHA256()
        );
    }

    private InformacionSeguridadDto toInformacionSeguridadDto(InformacionSeguridad domain) {
        if (domain == null) {
            return null;
        }

        return new InformacionSeguridadDto(
            domain.getPasswordHashSHA512(),
            domain.getAlgoritmoUtilizado(),
            domain.getLongitudPassword(),
            domain.getFechaGeneracion(),
            domain.getFechaExpiracion()
        );
    }

    private EstadisticasCompresionDto toEstadisticasCompresionDto(EstadisticasCompresion domain) {
        if (domain == null) {
            return null;
        }

        return new EstadisticasCompresionDto(
            domain.getAlgoritmo(),
            domain.getNivelCompresion(),
            domain.getTamanioOriginal(),
            domain.getTamanioComprimido(),
            domain.getRatioCompresion()
        );
    }

    private LinksDto toLinksDto(LinksHATEOAS domain) {
        if (domain == null) {
            return null;
        }

        return new LinksDto(
            domain.getSelf(),
            domain.getDescargar(),
            domain.getVerificar()
        );
    }

    private LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, ISO_FORMATTER);
    }

    private String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ISO_FORMATTER);
    }
}
