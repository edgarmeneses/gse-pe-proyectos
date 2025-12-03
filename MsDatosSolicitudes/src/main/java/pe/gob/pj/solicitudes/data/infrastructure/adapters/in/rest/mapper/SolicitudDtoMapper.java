package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.*;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class SolicitudDtoMapper {

    public Solicitud toDomain(SolicitudRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setTipoTramite(dto.tipoTramite());
        solicitud.setSubTipoTramite(dto.subTipoTramite());
        solicitud.setSolicitante(toSolicitante(dto.solicitante()));
        solicitud.setTipoSolicitante(dto.tipoSolicitante());
        solicitud.setPrioridad(dto.prioridad());
        
        if (dto.requisitosCumplidos() != null) {
            solicitud.setRequisitosCumplidos(dto.requisitosCumplidos().stream()
                    .map(this::toRequisitoCumplido)
                    .collect(Collectors.toList()));
        }
        
        solicitud.setDatosEspecificosTramite(toDatosEspecificosTramite(dto.datosEspecificosTramite()));
        solicitud.setPago(toPago(dto.pago()));
        solicitud.setObservaciones(dto.observaciones());
        
        return solicitud;
    }

    public SolicitudResponseDto toResponseDto(Solicitud solicitud) {
        if (solicitud == null) {
            return null;
        }

        return new SolicitudResponseDto(
                solicitud.getSolicitudId(),
                solicitud.getNumeroSolicitud(),
                solicitud.getEstado(),
                solicitud.getTipoTramite(),
                solicitud.getSubTipoTramite(),
                solicitud.getSolicitante() != null ? solicitud.getSolicitante().getDni() : null,
                solicitud.getSolicitante() != null ? 
                        solicitud.getSolicitante().getNombres() + " " + 
                        solicitud.getSolicitante().getApellidoPaterno() + " " +
                        solicitud.getSolicitante().getApellidoMaterno() : null,
                solicitud.getFechaRegistro(),
                solicitud.getFechaVencimiento(),
                solicitud.getPrioridad(),
                solicitud.getUsuarioAsignado(),
                solicitud.getOficinaRegistro() != null ? solicitud.getOficinaRegistro().getCodigo() : null,
                calcularDiasTranscurridos(solicitud.getFechaRegistro()),
                calcularDiasRestantes(solicitud.getFechaVencimiento())
        );
    }
    
    /**
     * Mapea Solicitud de dominio a SolicitudDetalleDto (respuesta completa)
     * Incluye toda la información y campos calculados
     */
    public SolicitudDetalleDto toDetalleDto(Solicitud solicitud) {
        if (solicitud == null) {
            return null;
        }

        return new SolicitudDetalleDto(
                solicitud.getSolicitudId(),
                solicitud.getNumeroSolicitud(),
                solicitud.getEstado(),
                solicitud.getTipoTramite(),
                solicitud.getSubTipoTramite(),
                solicitud.getPrioridad(),
                solicitud.getTipoSolicitante(),
                toSolicitanteDto(solicitud.getSolicitante()),
                solicitud.getRequisitosCumplidos() != null ?
                        solicitud.getRequisitosCumplidos().stream()
                                .map(this::toRequisitoCumplidoDto)
                                .collect(Collectors.toList()) : null,
                toDatosEspecificosTramiteDto(solicitud.getDatosEspecificosTramite()),
                solicitud.getDocumentosAdjuntos() != null ?
                        solicitud.getDocumentosAdjuntos().stream()
                                .map(this::toDocumentoAdjuntoDto)
                                .collect(Collectors.toList()) : null,
                toPagoDto(solicitud.getPago()),
                solicitud.getObservaciones(),
                solicitud.getFechaRegistro(),
                solicitud.getFechaVencimiento(),
                solicitud.getUsuarioRegistro(),
                solicitud.getUsuarioAsignado(),
                toOficinaRegistroDto(solicitud.getOficinaRegistro()),
                solicitud.getTiempoEstimadoResolucion(),
                solicitud.getRequiereDiligencia(),
                calcularDiasTranscurridos(solicitud.getFechaRegistro()),
                calcularDiasRestantes(solicitud.getFechaVencimiento()),
                generarUrlSeguimiento(solicitud.getSolicitudId()),
                calcularSiguientesPasos(solicitud)
        );
    }

    private Solicitante toSolicitante(SolicitanteDto dto) {
        if (dto == null) {
            return null;
        }
        return new Solicitante(
                dto.dni(),
                dto.nombres(),
                dto.apellidoPaterno(),
                dto.apellidoMaterno(),
                dto.email(),
                dto.telefono(),
                toDireccion(dto.direccion())
        );
    }

    private Direccion toDireccion(DireccionDto dto) {
        if (dto == null) {
            return null;
        }
        return new Direccion(
                dto.departamento(),
                dto.provincia(),
                dto.distrito(),
                dto.direccionCompleta()
        );
    }

    private RequisitoCumplido toRequisitoCumplido(RequisitoCumplidoDto dto) {
        if (dto == null) {
            return null;
        }
        return new RequisitoCumplido(
                dto.requisitoId(),
                dto.nombreRequisito(),
                dto.cumple(),
                dto.observacion()
        );
    }

    private DatosEspecificosTramite toDatosEspecificosTramite(DatosEspecificosTramiteDto dto) {
        if (dto == null) {
            return null;
        }
        return new DatosEspecificosTramite(
                dto.motivoRenovacion(),
                dto.dniAnterior(),
                dto.fechaVencimientoDniAnterior(),
                dto.requiereEntregaDomicilio(),
                dto.oficinaEntregaPreferida(),
                dto.documentosAdjuntos() != null ? 
                        dto.documentosAdjuntos().stream()
                                .map(this::toDocumentoAdjunto)
                                .collect(Collectors.toList()) : null
        );
    }

    private DocumentoAdjunto toDocumentoAdjunto(DocumentoAdjuntoDto dto) {
        if (dto == null) {
            return null;
        }
        return new DocumentoAdjunto(
                dto.tipo(),
                dto.nombre(),
                dto.tamanioBytes(),
                dto.mimeType(),
                dto.checksum()
        );
    }

    private Pago toPago(PagoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Pago(
                dto.montoPagado(),
                dto.metodoPago(),
                dto.referenciaPago(),
                dto.fechaPago()
        );
    }

    private OficinaRegistroDto toOficinaRegistroDto(OficinaRegistro oficina) {
        if (oficina == null) {
            return null;
        }
        return new OficinaRegistroDto(
                oficina.getCodigo(),
                oficina.getNombre()
        );
    }
    
    // Métodos helper para DTOs desde domain
    
    private SolicitanteDto toSolicitanteDto(Solicitante solicitante) {
        if (solicitante == null) {
            return null;
        }
        return new SolicitanteDto(
                solicitante.getDni(),
                solicitante.getNombres(),
                solicitante.getApellidoPaterno(),
                solicitante.getApellidoMaterno(),
                solicitante.getEmail(),
                solicitante.getTelefono(),
                toDireccionDto(solicitante.getDireccion())
        );
    }
    
    private DireccionDto toDireccionDto(Direccion direccion) {
        if (direccion == null) {
            return null;
        }
        return new DireccionDto(
                direccion.getDepartamento(),
                direccion.getProvincia(),
                direccion.getDistrito(),
                direccion.getDireccionCompleta()
        );
    }
    
    private RequisitoCumplidoDto toRequisitoCumplidoDto(RequisitoCumplido requisito) {
        if (requisito == null) {
            return null;
        }
        return new RequisitoCumplidoDto(
                requisito.getRequisitoId(),
                requisito.getNombreRequisito(),
                requisito.getCumple(),
                requisito.getObservacion()
        );
    }
    
    private DocumentoAdjuntoDto toDocumentoAdjuntoDto(DocumentoAdjunto documento) {
        if (documento == null) {
            return null;
        }
        return new DocumentoAdjuntoDto(
                documento.getTipo(),
                documento.getNombre(),
                documento.getTamanioBytes(),
                documento.getMimeType(),
                documento.getChecksum()
        );
    }
    
    private DatosEspecificosTramiteDto toDatosEspecificosTramiteDto(DatosEspecificosTramite datos) {
        if (datos == null) {
            return null;
        }
        return new DatosEspecificosTramiteDto(
                datos.getMotivoRenovacion(),
                datos.getDniAnterior(),
                datos.getFechaVencimientoDniAnterior(),
                datos.getRequiereEntregaDomicilio(),
                datos.getOficinaEntregaPreferida(),
                datos.getDocumentosAdjuntos() != null ?
                        datos.getDocumentosAdjuntos().stream()
                                .map(this::toDocumentoAdjuntoDto)
                                .collect(java.util.stream.Collectors.toList()) : null
        );
    }
    
    private PagoDto toPagoDto(Pago pago) {
        if (pago == null) {
            return null;
        }
        return new PagoDto(
                pago.getMontoPagado(),
                pago.getMetodoPago(),
                pago.getReferenciaPago(),
                pago.getFechaPago()
        );
    }
    
    // Métodos de cálculo (campos de presentación)
    
    private Integer calcularDiasTranscurridos(LocalDateTime fechaRegistro) {
        if (fechaRegistro == null) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(fechaRegistro, LocalDateTime.now());
    }
    
    private Integer calcularDiasRestantes(LocalDateTime fechaVencimiento) {
        if (fechaVencimiento == null) {
            return null;
        }
        long dias = ChronoUnit.DAYS.between(LocalDateTime.now(), fechaVencimiento);
        return dias < 0 ? 0 : (int) dias;
    }
    
    private String generarUrlSeguimiento(String solicitudId) {
        if (solicitudId == null) {
            return null;
        }
        return "/api/v1/solicitudes/" + solicitudId + "/seguimiento";
    }
    
    private List<SiguientePasoDto> calcularSiguientesPasos(Solicitud solicitud) {
        if (solicitud == null || solicitud.getEstado() == null) {
            return null;
        }
        
        // Lógica de negocio: determinar siguientes pasos según el estado
        return switch (solicitud.getEstado().toUpperCase()) {
            case "PENDIENTE" -> List.of(
                    new SiguientePasoDto("Revisar requisitos"),
                    new SiguientePasoDto("Validar documentos adjuntos")
            );
            case "EN_PROCESO" -> List.of(
                    new SiguientePasoDto("Esperar aprobación"),
                    new SiguientePasoDto("Seguimiento por parte del responsable")
            );
            case "OBSERVADO" -> List.of(
                    new SiguientePasoDto("Subsanar observaciones"),
                    new SiguientePasoDto("Volver a presentar solicitud")
            );
            case "APROBADO" -> List.of(
                    new SiguientePasoDto("Recoger documentos"),
                    new SiguientePasoDto("Notificación enviada")
            );
            case "RECHAZADO" -> List.of(
                    new SiguientePasoDto("Revisar motivos de rechazo"),
                    new SiguientePasoDto("Presentar nueva solicitud si corresponde")
            );
            case "COMPLETADO" -> List.of(
                    new SiguientePasoDto("Trámite finalizado")
            );
            default -> List.of(
                    new SiguientePasoDto("Consultar estado de solicitud")
            );
        };
    }
}
