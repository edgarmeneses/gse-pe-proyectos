package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.protecciondocumentos.domain.model.*;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.SolicitudProteccionRequestDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.RespuestaProteccionResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProteccionDocumentosDtoMapper {

    public SolicitudProteccion toDomain(SolicitudProteccionRequestDto dto) {
        if (dto == null) {
            return null;
        }

        SolicitudProteccion solicitud = new SolicitudProteccion();
        solicitud.setSolicitudId(dto.getSolicitudId());
        solicitud.setTipoOperacion(dto.getTipoOperacion());
        solicitud.setFechaSolicitud(dto.getFechaSolicitud());
        solicitud.setFuente(toFuenteDocumento(dto.getFuente()));
        solicitud.setDocumentos(toMetadatosDocumentoList(dto.getDocumentos()));
        solicitud.setConfiguracion(toConfiguracionProteccion(dto.getConfiguracion()));
        solicitud.setDestinatarios(toDestinatarioList(dto.getDestinatarios()));

        return solicitud;
    }

    public RespuestaProteccionResponseDto toDto(RespuestaProteccion domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto dto = new RespuestaProteccionResponseDto();
        dto.setSuccess(domain.getSuccess());
        dto.setTimestamp(domain.getTimestamp());
        dto.setData(toDataProteccionDto(domain.getData()));
        dto.setLinks(toLinksHATEOASDtoList(domain.getLinks()));
        dto.setMetadata(toMetadataRespuestaDto(domain.getMetadata()));

        return dto;
    }

    private FuenteDocumento toFuenteDocumento(SolicitudProteccionRequestDto.FuenteDocumentoDto dto) {
        if (dto == null) {
            return null;
        }

        FuenteDocumento fuente = new FuenteDocumento();
        fuente.setTipo(dto.getTipo());
        fuente.setOrigen(dto.getOrigen());
        fuente.setReferencia(toReferenciaRepositorio(dto.getReferencia()));

        return fuente;
    }

    private ReferenciaRepositorio toReferenciaRepositorio(SolicitudProteccionRequestDto.ReferenciaRepositorioDto dto) {
        if (dto == null) {
            return null;
        }

        ReferenciaRepositorio referencia = new ReferenciaRepositorio();
        referencia.setSistema(dto.getSistema());
        referencia.setTransaccionId(dto.getTransaccionId());
        referencia.setCodigoSeguimiento(dto.getCodigoSeguimiento());

        return referencia;
    }

    private List<MetadatosDocumento> toMetadatosDocumentoList(List<SolicitudProteccionRequestDto.MetadatosDocumentoDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        return dtoList.stream()
                .map(this::toMetadatosDocumento)
                .collect(Collectors.toList());
    }

    private MetadatosDocumento toMetadatosDocumento(SolicitudProteccionRequestDto.MetadatosDocumentoDto dto) {
        if (dto == null) {
            return null;
        }

        MetadatosDocumento metadatos = new MetadatosDocumento();
        metadatos.setDocumentoId(dto.getDocumentoId());
        metadatos.setNombre(dto.getNombre());
        metadatos.setTipo(dto.getTipo());
        metadatos.setTamanioBytes(dto.getTamanioBytes());
        metadatos.setFormatoOriginal(dto.getFormatoOriginal());
        metadatos.setMetadatos(toDatosMetadatos(dto.getMetadatos()));

        return metadatos;
    }

    private DatosMetadatos toDatosMetadatos(SolicitudProteccionRequestDto.DatosMetadatosDto dto) {
        if (dto == null) {
            return null;
        }

        DatosMetadatos datos = new DatosMetadatos();
        datos.setTitulo(dto.getTitulo());
        datos.setDescripcion(dto.getDescripcion());
        datos.setAutor(dto.getAutor());
        datos.setFechaCreacion(dto.getFechaCreacion());
        datos.setClasificacion(dto.getClasificacion());
        datos.setPalabrasClave(dto.getPalabrasClave());

        return datos;
    }

    private ConfiguracionProteccion toConfiguracionProteccion(SolicitudProteccionRequestDto.ConfiguracionProteccionDto dto) {
        if (dto == null) {
            return null;
        }

        ConfiguracionProteccion configuracion = new ConfiguracionProteccion();
        configuracion.setNivelCompresion(dto.getNivelCompresion());
        configuracion.setAlgoritmoCifrado(dto.getAlgoritmoCifrado());
        configuracion.setClavePublica(dto.getClavePublica());
        configuracion.setIncluirMetadatos(dto.getIncluirMetadatos());
        configuracion.setProtegerConPassword(dto.getProtegerConPassword());
        configuracion.setPasswordHash(dto.getPasswordHash());

        return configuracion;
    }

    private List<Destinatario> toDestinatarioList(List<SolicitudProteccionRequestDto.DestinatarioDto> dtoList) {
        if (dtoList == null) {
            return null;
        }

        return dtoList.stream()
                .map(this::toDestinatario)
                .collect(Collectors.toList());
    }

    private Destinatario toDestinatario(SolicitudProteccionRequestDto.DestinatarioDto dto) {
        if (dto == null) {
            return null;
        }

        Destinatario destinatario = new Destinatario();
        destinatario.setDestinatarioId(dto.getDestinatarioId());
        destinatario.setTipo(dto.getTipo());
        destinatario.setNivelAcceso(dto.getNivelAcceso());
        destinatario.setPermisos(dto.getPermisos());

        return destinatario;
    }

    private RespuestaProteccionResponseDto.DataProteccionDto toDataProteccionDto(DataProteccion domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.DataProteccionDto dto = new RespuestaProteccionResponseDto.DataProteccionDto();
        dto.setProcesoId(domain.getProcesoId());
        dto.setSolicitudId(domain.getSolicitudId());
        dto.setEstado(domain.getEstado());
        dto.setFechaProcesamiento(domain.getFechaProcesamiento());
        dto.setArchivosProtegidos(toArchivoProtegidoDtoList(domain.getArchivosProtegidos()));
        dto.setSeguridad(toInformacionSeguridadDto(domain.getSeguridad()));
        dto.setEstadisticas(toEstadisticasCompresionDto(domain.getEstadisticas()));

        return dto;
    }

    private List<RespuestaProteccionResponseDto.ArchivoProtegidoDto> toArchivoProtegidoDtoList(List<ArchivoProtegido> domainList) {
        if (domainList == null) {
            return null;
        }

        return domainList.stream()
                .map(this::toArchivoProtegidoDto)
                .collect(Collectors.toList());
    }

    private RespuestaProteccionResponseDto.ArchivoProtegidoDto toArchivoProtegidoDto(ArchivoProtegido domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.ArchivoProtegidoDto dto = new RespuestaProteccionResponseDto.ArchivoProtegidoDto();
        dto.setArchivoId(domain.getArchivoId());
        dto.setDocumentoOriginalId(domain.getDocumentoOriginalId());
        dto.setNombreArchivo(domain.getNombreArchivo());
        dto.setFormatoProtegido(domain.getFormatoProtegido());
        dto.setTamanioOriginalBytes(domain.getTamanioOriginalBytes());
        dto.setTamanioComprimidoBytes(domain.getTamanioComprimidoBytes());
        dto.setRatioCompresion(domain.getRatioCompresion());
        dto.setHash(domain.getHash());
        dto.setAlgoritmoHash(domain.getAlgoritmoHash());
        dto.setUbicacionAlmacenamiento(domain.getUbicacionAlmacenamiento());

        return dto;
    }

    private RespuestaProteccionResponseDto.InformacionSeguridadDto toInformacionSeguridadDto(InformacionSeguridad domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.InformacionSeguridadDto dto = new RespuestaProteccionResponseDto.InformacionSeguridadDto();
        dto.setAlgoritmoCifrado(domain.getAlgoritmoCifrado());
        dto.setNivelSeguridad(domain.getNivelSeguridad());
        dto.setFechaCifrado(domain.getFechaCifrado());
        dto.setHuellaCifrado(domain.getHuellaCifrado());

        return dto;
    }

    private RespuestaProteccionResponseDto.EstadisticasCompresionDto toEstadisticasCompresionDto(EstadisticasCompresion domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.EstadisticasCompresionDto dto = new RespuestaProteccionResponseDto.EstadisticasCompresionDto();
        dto.setTotalDocumentos(domain.getTotalDocumentos());
        dto.setDocumentosProcesados(domain.getDocumentosProcesados());
        dto.setDocumentosFallidos(domain.getDocumentosFallidos());
        dto.setTiempoProcesamientoMs(domain.getTiempoProcesamientoMs());
        dto.setAhorroEspacioBytes(domain.getAhorroEspacioBytes());
        dto.setPorcentajeReduccion(domain.getPorcentajeReduccion());

        return dto;
    }

    private List<RespuestaProteccionResponseDto.LinksHATEOASDto> toLinksHATEOASDtoList(List<LinksHATEOAS> domainList) {
        if (domainList == null) {
            return null;
        }

        return domainList.stream()
                .map(this::toLinksHATEOASDto)
                .collect(Collectors.toList());
    }

    private RespuestaProteccionResponseDto.LinksHATEOASDto toLinksHATEOASDto(LinksHATEOAS domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.LinksHATEOASDto dto = new RespuestaProteccionResponseDto.LinksHATEOASDto();
        dto.setRel(domain.getRel());
        dto.setHref(domain.getHref());
        dto.setMethod(domain.getMethod());

        return dto;
    }

    private RespuestaProteccionResponseDto.MetadataRespuestaDto toMetadataRespuestaDto(MetadataRespuesta domain) {
        if (domain == null) {
            return null;
        }

        RespuestaProteccionResponseDto.MetadataRespuestaDto dto = new RespuestaProteccionResponseDto.MetadataRespuestaDto();
        dto.setVersion(domain.getVersion());
        dto.setRequestId(domain.getRequestId());
        dto.setCorrelationId(domain.getCorrelationId());

        return dto;
    }
}
