package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DiligenciaDtoMapper {

    public Diligencia toDomain(DiligenciaRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Diligencia diligencia = new Diligencia();
        diligencia.setTipoDiligencia(dto.tipoDiligencia());
        diligencia.setEntidadDestino(dto.entidadDestino());
        diligencia.setTipoEntidad(dto.tipoEntidad());
        diligencia.setDatosContactoEntidad(toDatosContactoEntidad(dto.datosContactoEntidad()));
        diligencia.setMotivoDiligencia(dto.motivoDiligencia());
        diligencia.setFundamentoLegal(dto.fundamentoLegal());
        diligencia.setInformacionRequerida(dto.informacionRequerida());
        
        if (dto.documentosRequeridos() != null) {
            diligencia.setDocumentosRequeridos(dto.documentosRequeridos().stream()
                    .map(this::toDocumentoRequerido)
                    .collect(Collectors.toList()));
        }
        
        diligencia.setPlazoRespuesta(dto.plazoRespuesta());
        diligencia.setUnidadPlazo(dto.unidadPlazo());
        diligencia.setPrioridad(dto.prioridad());
        diligencia.setRequiereRespuestaOficial(dto.requiereRespuestaOficial());
        diligencia.setPermitoRespuestaDigital(dto.permitoRespuestaDigital());
        diligencia.setObservaciones(dto.observaciones());
        
        return diligencia;
    }

    public DiligenciaResponseDto toResponseDto(Diligencia diligencia) {
        if (diligencia == null) {
            return null;
        }

        return new DiligenciaResponseDto(
                diligencia.getDiligenciaId(),
                diligencia.getNumeroDiligencia(),
                diligencia.getSolicitudId(),
                diligencia.getNumeroSolicitud(),
                diligencia.getEstado(),
                diligencia.getTipoDiligencia(),
                diligencia.getEntidadDestino(),
                diligencia.getMotivoDiligencia(),
                diligencia.getFechaCreacion(),
                diligencia.getFechaVencimiento(),
                diligencia.getPlazoRespuesta(),
                calcularDiasTranscurridos(diligencia.getFechaCreacion()),
                calcularDiasRestantes(diligencia.getFechaVencimiento()),
                diligencia.getPrioridad(),
                toOficinaResponsableDto(diligencia.getOficinaResponsable()),
                diligencia.getUsuarioSolicitante(),
                diligencia.getEstadoOficio(),
                diligencia.getDocumentosGenerados() != null ? 
                        diligencia.getDocumentosGenerados().stream()
                                .map(this::toDocumentoGeneradoDto)
                                .collect(Collectors.toList()) : null
        );
    }

    private DatosContactoEntidad toDatosContactoEntidad(DatosContactoEntidadDto dto) {
        if (dto == null) {
            return null;
        }
        return new DatosContactoEntidad(
                dto.nombre(),
                dto.direccion(),
                dto.email(),
                dto.telefono()
        );
    }

    private DocumentoRequerido toDocumentoRequerido(DocumentoRequeridoDto dto) {
        if (dto == null) {
            return null;
        }
        return new DocumentoRequerido(
                dto.tipoDocumento(),
                dto.descripcion(),
                dto.obligatorio()
        );
    }

    private OficinaResponsableDto toOficinaResponsableDto(OficinaResponsable oficina) {
        if (oficina == null) {
            return null;
        }
        return new OficinaResponsableDto(
                oficina.getCodigo(),
                oficina.getNombre()
        );
    }

    private DocumentoGeneradoDto toDocumentoGeneradoDto(DocumentoGenerado doc) {
        if (doc == null) {
            return null;
        }
        return new DocumentoGeneradoDto(
                doc.getTipoDocumento(),
                doc.getNumeroOficio(),
                doc.getUrlDocumento(),
                doc.getFirmadoDigitalmente(),
                doc.getHash()
        );
    }

    // Métodos de cálculo
    private Integer calcularDiasTranscurridos(LocalDateTime fechaCreacion) {
        if (fechaCreacion == null) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(fechaCreacion, LocalDateTime.now());
    }

    private Integer calcularDiasRestantes(LocalDateTime fechaVencimiento) {
        if (fechaVencimiento == null) {
            return null;
        }
        long dias = ChronoUnit.DAYS.between(LocalDateTime.now(), fechaVencimiento);
        return dias < 0 ? 0 : (int) dias;
    }
}
