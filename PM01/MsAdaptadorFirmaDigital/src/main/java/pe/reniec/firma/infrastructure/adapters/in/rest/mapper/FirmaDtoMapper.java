package pe.reniec.firma.infrastructure.adapters.in.rest.mapper;

import pe.reniec.firma.domain.model.*;
import pe.reniec.firma.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirmaDtoMapper {

    public SolicitudFirma toDomain(FirmarDocumentoRequestDto dto) {
        if (dto == null) return null;
        SolicitudFirma domain = new SolicitudFirma();
        domain.setTramiteId(dto.getTramiteId());
        domain.setDocumento(toDomain(dto.getDocumento()));
        domain.setFirmante(toDomain(dto.getFirmante()));
        domain.setConfiguracionFirma(toDomain(dto.getConfiguracionFirma()));
        domain.setMetadata(toDomain(dto.getMetadata()));
        return domain;
    }

    public FirmarDocumentoResponseDto toDto(ProcesoFirma domain) {
        if (domain == null) return null;
        FirmarDocumentoResponseDto dto = new FirmarDocumentoResponseDto();
        dto.setStatus(domain.getEstadoFirma()); // Assuming status maps to estadoFirma or similar
        
        ProcesoFirmaDto data = new ProcesoFirmaDto();
        data.setProcesoFirmaId(domain.getProcesoFirmaId());
        data.setTramiteId(domain.getTramiteId());
        data.setEstadoFirma(domain.getEstadoFirma());
        data.setDocumentoFirmado(toDto(domain.getDocumentoFirmado()));
        data.setFirmaAplicada(toDto(domain.getFirmaAplicada()));
        data.setValidaciones(toDto(domain.getValidaciones()));
        data.setAuditoria(toDto(domain.getAuditoria()));
        
        dto.setData(data);
        // Metadata needs to be populated from somewhere, maybe passed in or from domain if it exists there
        return dto;
    }

    public SolicitudLote toDomain(FirmarLoteRequestDto dto) {
        if (dto == null) return null;
        SolicitudLote domain = new SolicitudLote();
        domain.setLoteId(dto.getLoteId());
        domain.setDescripcionLote(dto.getDescripcionLote());
        if (dto.getDocumentos() != null) {
            domain.setDocumentos(dto.getDocumentos().stream().map(this::toDomain).collect(Collectors.toList()));
        }
        domain.setFirmante(toDomain(dto.getFirmante()));
        domain.setConfiguracionFirma(toDomain(dto.getConfiguracionFirma()));
        domain.setMetadata(toDomain(dto.getMetadata()));
        return domain;
    }

    public FirmarLoteResponseDto toDto(ProcesoLote domain) {
        if (domain == null) return null;
        FirmarLoteResponseDto dto = new FirmarLoteResponseDto();
        dto.setLoteId(domain.getLoteId());
        dto.setProcesoLoteId(domain.getProcesoLoteId());
        dto.setEstadoLote(domain.getEstadoLote());
        dto.setTotalDocumentos(domain.getTotalDocumentos());
        dto.setDocumentosFirmados(domain.getDocumentosFirmados());
        dto.setDocumentosFallidos(domain.getDocumentosFallidos());
        if (domain.getResultadosDocumentos() != null) {
            dto.setResultadosDocumentos(domain.getResultadosDocumentos().stream().map(this::toDto).collect(Collectors.toList()));
        }
        dto.setFirmante(toDto(domain.getFirmante()));
        dto.setAuditoria(toDto(domain.getAuditoria()));
        dto.setMetadata(toDto(domain.getMetadata()));
        return dto;
    }

    public SolicitudValidacion toDomain(ValidarFirmaRequestDto dto) {
        if (dto == null) return null;
        SolicitudValidacion domain = new SolicitudValidacion();
        domain.setDocumento(toDomain(dto.getDocumento()));
        domain.setValidaciones(toDomain(dto.getValidaciones()));
        domain.setMetadata(toDomain(dto.getMetadata()));
        return domain;
    }

    public ValidarFirmaResponseDto toDto(ProcesoValidacion domain) {
        if (domain == null) return null;
        ValidarFirmaResponseDto dto = new ValidarFirmaResponseDto();
        dto.setValidacionId(domain.getValidacionId());
        dto.setDocumento(toDto(domain.getDocumento()));
        dto.setResultadoValidacion(toDto(domain.getResultadoValidacion()));
        if (domain.getDetallesFirmas() != null) {
            dto.setDetallesFirmas(domain.getDetallesFirmas().stream().map(this::toDto).collect(Collectors.toList()));
        }
        dto.setAdvertencias(domain.getAdvertencias());
        dto.setErrores(domain.getErrores());
        dto.setMetadata(toDto(domain.getMetadata()));
        return dto;
    }

    // Helper methods

    private Documento toDomain(DocumentoDto dto) {
        if (dto == null) return null;
        Documento domain = new Documento();
        domain.setNombre(dto.getNombre());
        domain.setTipoDocumento(dto.getTipoDocumento());
        domain.setContenidoBase64(dto.getContenidoBase64());
        domain.setHashSHA256(dto.getHashSHA256());
        domain.setTamanoBytes(dto.getTamanoBytes());
        return domain;
    }

    private DocumentoDto toDto(Documento domain) {
        if (domain == null) return null;
        DocumentoDto dto = new DocumentoDto();
        dto.setNombre(domain.getNombre());
        dto.setTipoDocumento(domain.getTipoDocumento());
        dto.setContenidoBase64(domain.getContenidoBase64());
        dto.setHashSHA256(domain.getHashSHA256());
        dto.setTamanoBytes(domain.getTamanoBytes());
        return dto;
    }

    private Firmante toDomain(FirmanteDto dto) {
        if (dto == null) return null;
        Firmante domain = new Firmante();
        domain.setUsuarioId(dto.getUsuarioId());
        domain.setDni(dto.getDni());
        domain.setNombreCompleto(dto.getNombreCompleto());
        domain.setCargo(dto.getCargo());
        domain.setCertificadoId(dto.getCertificadoId());
        domain.setEmail(dto.getEmail());
        return domain;
    }

    private FirmanteDto toDto(Firmante domain) {
        if (domain == null) return null;
        FirmanteDto dto = new FirmanteDto();
        dto.setUsuarioId(domain.getUsuarioId());
        dto.setDni(domain.getDni());
        dto.setNombreCompleto(domain.getNombreCompleto());
        dto.setCargo(domain.getCargo());
        dto.setCertificadoId(domain.getCertificadoId());
        dto.setEmail(domain.getEmail());
        return dto;
    }

    private ConfiguracionFirma toDomain(ConfiguracionFirmaDto dto) {
        if (dto == null) return null;
        ConfiguracionFirma domain = new ConfiguracionFirma();
        domain.setTipoCertificado(dto.getTipoCertificado());
        domain.setProveedorFirma(dto.getProveedorFirma());
        domain.setIncluyeGrafo(dto.getIncluyeGrafo());
        if (dto.getPosicionGrafo() != null) {
            ConfiguracionFirma.PosicionGrafo pg = new ConfiguracionFirma.PosicionGrafo();
            pg.setPagina(dto.getPosicionGrafo().getPagina());
            pg.setCoordenadaX(dto.getPosicionGrafo().getCoordenadaX());
            pg.setCoordenadaY(dto.getPosicionGrafo().getCoordenadaY());
            pg.setAncho(dto.getPosicionGrafo().getAncho());
            pg.setAlto(dto.getPosicionGrafo().getAlto());
            domain.setPosicionGrafo(pg);
        }
        domain.setRazonFirma(dto.getRazonFirma());
        domain.setUbicacionFirma(dto.getUbicacionFirma());
        domain.setValidarVigenciaCertificado(dto.getValidarVigenciaCertificado());
        domain.setProcesarEnParalelo(dto.getProcesarEnParalelo());
        domain.setMaximoParalelo(dto.getMaximoParalelo());
        return domain;
    }

    private Metadata toDomain(MetadataDto dto) {
        if (dto == null) return null;
        Metadata domain = new Metadata();
        domain.setModuloOrigen(dto.getModuloOrigen());
        domain.setIpCliente(dto.getIpCliente());
        domain.setNavegador(dto.getNavegador());
        domain.setCorrelationId(dto.getCorrelationId());
        if (dto.getTimestamp() != null) {
            try {
                domain.setTimestamp(LocalDateTime.parse(dto.getTimestamp(), DateTimeFormatter.ISO_DATE_TIME));
            } catch (Exception e) {
                // Handle or ignore
            }
        }
        domain.setVersion(dto.getVersion());
        domain.setTiempoRespuestaMs(dto.getTiempoRespuestaMs());
        domain.setMotivoValidacion(dto.getMotivoValidacion());
        domain.setTiempoValidacionMs(dto.getTiempoValidacionMs());
        return domain;
    }

    private MetadataDto toDto(Metadata domain) {
        if (domain == null) return null;
        MetadataDto dto = new MetadataDto();
        dto.setModuloOrigen(domain.getModuloOrigen());
        dto.setIpCliente(domain.getIpCliente());
        dto.setNavegador(domain.getNavegador());
        dto.setCorrelationId(domain.getCorrelationId());
        if (domain.getTimestamp() != null) {
            dto.setTimestamp(domain.getTimestamp().format(DateTimeFormatter.ISO_DATE_TIME));
        }
        dto.setVersion(domain.getVersion());
        dto.setTiempoRespuestaMs(domain.getTiempoRespuestaMs());
        dto.setMotivoValidacion(domain.getMotivoValidacion());
        dto.setTiempoValidacionMs(domain.getTiempoValidacionMs());
        return dto;
    }

    private FirmaAplicadaDto toDto(FirmaAplicada domain) {
        if (domain == null) return null;
        FirmaAplicadaDto dto = new FirmaAplicadaDto();
        dto.setCertificadoId(domain.getCertificadoId());
        if (domain.getTimestampFirma() != null) {
            dto.setTimestampFirma(domain.getTimestampFirma().format(DateTimeFormatter.ISO_DATE_TIME));
        }
        return dto;
    }

    private ValidacionEstadoDto toDto(ValidacionEstado domain) {
        if (domain == null) return null;
        ValidacionEstadoDto dto = new ValidacionEstadoDto();
        dto.setCertificadoValido(domain.getCertificadoValido());
        dto.setCertificadoNoRevocado(domain.getCertificadoNoRevocado());
        dto.setFirmaValida(domain.getFirmaValida());
        dto.setCertificadoVigente(domain.getCertificadoVigente());
        dto.setCadenaConfianzaVerificada(domain.getCadenaConfianzaVerificada());
        dto.setTimestampValido(domain.getTimestampValido());
        dto.setIntegridadDocumento(domain.getIntegridadDocumento());
        return dto;
    }

    private AuditoriaDto toDto(Auditoria domain) {
        if (domain == null) return null;
        AuditoriaDto dto = new AuditoriaDto();
        dto.setIdTransaccionProveedor(domain.getIdTransaccionProveedor());
        dto.setLoteIniciado(domain.getLoteIniciado());
        dto.setLoteCompletado(domain.getLoteCompletado());
        dto.setTiempoProcesamientoMs(domain.getTiempoProcesamientoMs());
        dto.setProveedorUtilizado(domain.getProveedorUtilizado());
        return dto;
    }

    private DocumentoLote toDomain(DocumentoLoteDto dto) {
        if (dto == null) return null;
        DocumentoLote domain = new DocumentoLote();
        // Map parent fields
        domain.setNombre(dto.getNombre());
        domain.setTipoDocumento(dto.getTipoDocumento());
        domain.setContenidoBase64(dto.getContenidoBase64());
        domain.setHashSHA256(dto.getHashSHA256());
        domain.setTamanoBytes(dto.getTamanoBytes());
        // Map specific fields
        domain.setDocumentoId(dto.getDocumentoId());
        domain.setTramiteId(dto.getTramiteId());
        domain.setEstado(dto.getEstado());
        domain.setProcesoFirmaId(dto.getProcesoFirmaId());
        domain.setTimestampFirma(dto.getTimestampFirma());
        return domain;
    }

    private DocumentoLoteDto toDto(DocumentoLote domain) {
        if (domain == null) return null;
        DocumentoLoteDto dto = new DocumentoLoteDto();
        // Map parent fields
        dto.setNombre(domain.getNombre());
        dto.setTipoDocumento(domain.getTipoDocumento());
        dto.setContenidoBase64(domain.getContenidoBase64());
        dto.setHashSHA256(domain.getHashSHA256());
        dto.setTamanoBytes(domain.getTamanoBytes());
        // Map specific fields
        dto.setDocumentoId(domain.getDocumentoId());
        dto.setTramiteId(domain.getTramiteId());
        dto.setEstado(domain.getEstado());
        dto.setProcesoFirmaId(domain.getProcesoFirmaId());
        dto.setTimestampFirma(domain.getTimestampFirma());
        return dto;
    }

    private ValidacionConfig toDomain(ValidacionConfigDto dto) {
        if (dto == null) return null;
        ValidacionConfig domain = new ValidacionConfig();
        domain.setVerificarCertificado(dto.getVerificarCertificado());
        domain.setVerificarRevocacion(dto.getVerificarRevocacion());
        domain.setVerificarCadenaConfianza(dto.getVerificarCadenaConfianza());
        domain.setVerificarTimestamp(dto.getVerificarTimestamp());
        domain.setVerificarIntegridad(dto.getVerificarIntegridad());
        return domain;
    }

    private ResultadoValidacionDto toDto(ResultadoValidacion domain) {
        if (domain == null) return null;
        ResultadoValidacionDto dto = new ResultadoValidacionDto();
        dto.setEsValido(domain.getEsValido());
        dto.setResumenValidacion(domain.getResumenValidacion());
        dto.setFirmasEncontradas(domain.getFirmasEncontradas());
        dto.setFirmasValidas(domain.getFirmasValidas());
        dto.setFirmasInvalidas(domain.getFirmasInvalidas());
        return dto;
    }

    private DetalleFirmaDto toDto(DetalleFirma domain) {
        if (domain == null) return null;
        DetalleFirmaDto dto = new DetalleFirmaDto();
        dto.setNumeroFirma(domain.getNumeroFirma());
        dto.setFirmante(toDto(domain.getFirmante()));
        dto.setCertificado(toDto(domain.getCertificado()));
        dto.setValidaciones(toDto(domain.getValidaciones()));
        dto.setTimestamp(toDto(domain.getTimestamp()));
        dto.setDetallesValidacion(toDto(domain.getDetallesValidacion()));
        return dto;
    }

    private CertificadoDto toDto(Certificado domain) {
        if (domain == null) return null;
        CertificadoDto dto = new CertificadoDto();
        dto.setNumeroSerie(domain.getNumeroSerie());
        dto.setEmisor(domain.getEmisor());
        dto.setVigenciaDesde(domain.getVigenciaDesde());
        dto.setVigenciaHasta(domain.getVigenciaHasta());
        dto.setAlgoritmo(domain.getAlgoritmo());
        dto.setLongitudClave(domain.getLongitudClave());
        return dto;
    }

    private TimestampDto toDto(Timestamp domain) {
        if (domain == null) return null;
        TimestampDto dto = new TimestampDto();
        dto.setFechaHoraFirma(domain.getFechaHoraFirma());
        dto.setAutoridadTimestamp(domain.getAutoridadTimestamp());
        dto.setAlgoritmoTimestamp(domain.getAlgoritmoTimestamp());
        return dto;
    }

    private DetallesValidacionDto toDto(DetallesValidacion domain) {
        if (domain == null) return null;
        DetallesValidacionDto dto = new DetallesValidacionDto();
        if (domain.getRevocacion() != null) {
            DetallesValidacionDto.RevocacionDto r = new DetallesValidacionDto.RevocacionDto();
            r.setMetodoVerificacion(domain.getRevocacion().getMetodoVerificacion());
            r.setUrlOCSP(domain.getRevocacion().getUrlOCSP());
            r.setEstadoCertificado(domain.getRevocacion().getEstadoCertificado());
            r.setFechaVerificacion(domain.getRevocacion().getFechaVerificacion());
            dto.setRevocacion(r);
        }
        if (domain.getCadenaConfianza() != null) {
            DetallesValidacionDto.CadenaConfianzaDto c = new DetallesValidacionDto.CadenaConfianzaDto();
            c.setCertificadosEnCadena(domain.getCadenaConfianza().getCertificadosEnCadena());
            c.setRaizConfiable(domain.getCadenaConfianza().getRaizConfiable());
            c.setTodosVerificados(domain.getCadenaConfianza().getTodosVerificados());
            dto.setCadenaConfianza(c);
        }
        return dto;
    }
}
