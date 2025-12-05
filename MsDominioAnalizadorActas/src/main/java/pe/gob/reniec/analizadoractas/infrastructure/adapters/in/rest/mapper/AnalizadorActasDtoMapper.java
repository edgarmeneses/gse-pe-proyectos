package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.analizadoractas.domain.model.*;
import pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre DTOs y objetos de dominio
 * IMPORTANTE: Sin anotaciones de MapStruct o Lombok (Java puro)
 */
public class AnalizadorActasDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public AnalizadorActasDtoMapper() {
    }

    // ==================== De DTO a Dominio ====================

    /**
     * Convierte SolicitudAnalisisDto a SolicitudAnalisis (dominio)
     */
    public SolicitudAnalisis toSolicitudAnalisisDomain(SolicitudAnalisisDto dto) {
        if (dto == null) {
            return null;
        }

        LocalDateTime fechaInicio = dto.getFechaInicio() != null
                ? LocalDateTime.parse(dto.getFechaInicio(), ISO_FORMATTER)
                : null;

        LocalDateTime fechaFin = dto.getFechaFin() != null
                ? LocalDateTime.parse(dto.getFechaFin(), ISO_FORMATTER)
                : null;

        List<TipoActa> tiposActa = dto.getTipoActa() != null
                ? dto.getTipoActa().stream()
                .map(this::toTipoActaDomain)
                .collect(Collectors.toList())
                : null;

        OficinaRegistral oficinaRegistral = toOficinaRegistralDomain(dto.getOficinaRegistral());

        return new SolicitudAnalisis(
                fechaInicio,
                fechaFin,
                dto.getTipoEvento(),
                tiposActa,
                oficinaRegistral,
                dto.getInconsistenciasPrevias()
        );
    }

    /**
     * Convierte TipoActaDto a TipoActa (dominio)
     */
    public TipoActa toTipoActaDomain(TipoActaDto dto) {
        if (dto == null) {
            return null;
        }
        return new TipoActa(dto.getCodigo(), dto.getDescripcion());
    }

    /**
     * Convierte OficinaRegistralDto a OficinaRegistral (dominio)
     */
    public OficinaRegistral toOficinaRegistralDomain(OficinaRegistralDto dto) {
        if (dto == null) {
            return null;
        }
        return new OficinaRegistral(dto.getCodigo(), dto.getNombre());
    }

    /**
     * Convierte UsuarioSolicitanteDto a UsuarioSolicitante (dominio)
     */
    public UsuarioSolicitante toUsuarioSolicitanteDomain(UsuarioSolicitanteDto dto) {
        if (dto == null) {
            return null;
        }
        return new UsuarioSolicitante(
                dto.getDni(),
                dto.getNombres(),
                dto.getApellidos(),
                dto.getRol()
        );
    }

    // ==================== De Dominio a DTO ====================

    /**
     * Convierte AnalisisActas (dominio) a AnalisisResponseDto
     */
    public AnalisisResponseDto toAnalisisResponseDto(AnalisisActas analisis) {
        if (analisis == null) {
            return null;
        }

        AnalisisDataDto dataDto = new AnalisisDataDto();
        dataDto.setAnalisisId(analisis.getAnalisisId());
        dataDto.setNumeroAnalisis(analisis.getNumeroAnalisis());
        dataDto.setFechaEjecucion(analisis.getFechaEjecucion() != null
                ? analisis.getFechaEjecucion().format(ISO_FORMATTER)
                : null);
        dataDto.setEstadoAnalisis(analisis.getEstadoAnalisis());
        dataDto.setCriteriosBusqueda(toCriteriosBusquedaDto(analisis.getCriteriosBusqueda()));
        dataDto.setResumenResultados(toResumenResultadosDto(analisis.getResumenResultados()));
        dataDto.setResultadosDetallados(
                analisis.getResultadosDetallados() != null
                        ? analisis.getResultadosDetallados().stream()
                        .map(this::toResultadoDetalladoDto)
                        .collect(Collectors.toList())
                        : null
        );
        dataDto.setUsuarioSolicitante(toUsuarioSolicitanteDto(analisis.getUsuarioSolicitante()));
        dataDto.setLinks(createLinksDto(analisis.getAnalisisId()));

        MetadataDto metadataDto = new MetadataDto();
        metadataDto.setTimestamp(LocalDateTime.now().format(ISO_FORMATTER));
        metadataDto.setCorrelationId(analisis.getAnalisisId());
        metadataDto.setVersion("v1");

        AnalisisResponseDto response = new AnalisisResponseDto();
        response.setSuccess(true);
        response.setData(dataDto);
        response.setMetadata(metadataDto);

        return response;
    }

    /**
     * Convierte CriteriosBusqueda (dominio) a CriteriosBusquedaDto
     */
    private CriteriosBusquedaDto toCriteriosBusquedaDto(CriteriosBusqueda criterios) {
        if (criterios == null) {
            return null;
        }

        return new CriteriosBusquedaDto(
                criterios.getFechaInicio() != null
                        ? criterios.getFechaInicio().format(ISO_FORMATTER)
                        : null,
                criterios.getFechaFin() != null
                        ? criterios.getFechaFin().format(ISO_FORMATTER)
                        : null,
                criterios.getTiposActa(),
                criterios.getOficinaRegistral()
        );
    }

    /**
     * Convierte ResumenResultados (dominio) a ResumenResultadosDto
     */
    private ResumenResultadosDto toResumenResultadosDto(ResumenResultados resumen) {
        if (resumen == null) {
            return null;
        }

        return new ResumenResultadosDto(
                resumen.getTotalActasAnalizadas(),
                resumen.getActasConAlertasAltas(),
                resumen.getActasConAlertasMedias(),
                resumen.getActasConAlertasBajas(),
                resumen.getActasSinInconsistencias(),
                resumen.getTiempoProcesamientoSegundos()
        );
    }

    /**
     * Convierte ResultadoDetallado (dominio) a ResultadoDetalladoDto
     */
    private ResultadoDetalladoDto toResultadoDetalladoDto(ResultadoDetallado resultado) {
        if (resultado == null) {
            return null;
        }

        ResultadoDetalladoDto dto = new ResultadoDetalladoDto();
        dto.setActaId(resultado.getActaId());
        dto.setNumeroActa(resultado.getNumeroActa());
        dto.setTipoActa(resultado.getTipoActa());
        dto.setFechaRegistro(resultado.getFechaRegistro() != null
                ? resultado.getFechaRegistro().format(ISO_FORMATTER)
                : null);
        dto.setOficinaRegistral(resultado.getOficinaRegistral());
        dto.setScoreRiesgo(resultado.getScoreRiesgo());
        dto.setNivelRiesgo(resultado.getNivelRiesgo());
        dto.setAlertasDetectadas(
                resultado.getAlertasDetectadas() != null
                        ? resultado.getAlertasDetectadas().stream()
                        .map(this::toAlertaDetectadaDto)
                        .collect(Collectors.toList())
                        : null
        );
        dto.setClasificacionIA(resultado.getClasificacionIA());
        dto.setRecomendaciones(resultado.getRecomendaciones());
        dto.setUrlActaOriginal(resultado.getUrlActaOriginal());

        return dto;
    }

    /**
     * Convierte AlertaDetectada (dominio) a AlertaDetectadaDto
     */
    private AlertaDetectadaDto toAlertaDetectadaDto(AlertaDetectada alerta) {
        if (alerta == null) {
            return null;
        }

        return new AlertaDetectadaDto(
                alerta.getCodigoAlerta(),
                alerta.getTipoAlerta(),
                alerta.getDescripcion(),
                alerta.getSeveridad(),
                alerta.getCampoAfectado()
        );
    }

    /**
     * Convierte UsuarioSolicitante (dominio) a UsuarioSolicitanteDto
     */
    private UsuarioSolicitanteDto toUsuarioSolicitanteDto(UsuarioSolicitante usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioSolicitanteDto dto = new UsuarioSolicitanteDto();
        dto.setDni(usuario.getDni());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setRol(usuario.getRol());
        dto.setNombreCompleto(usuario.getNombreCompleto());

        return dto;
    }

    /**
     * Crea LinksDto para HATEOAS
     */
    private LinksDto createLinksDto(String analisisId) {
        String baseUrl = "/api/v1/actas/MsDominioAnalizadorActas";
        return new LinksDto(
                baseUrl + "/analisis/" + analisisId,
                baseUrl + "/analisis/" + analisisId + "/exportar",
                baseUrl + "/analisis/" + analisisId + "/actas"
        );
    }
}
