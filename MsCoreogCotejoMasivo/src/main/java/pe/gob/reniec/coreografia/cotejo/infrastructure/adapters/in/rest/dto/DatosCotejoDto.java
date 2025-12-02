package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record DatosCotejoDto(
    String solicitudId,
    String numeroSolicitud,
    String estado,
    String tipoTramite,
    EntidadSolicitanteResponseDto entidadSolicitante,
    String fechaRegistro,
    String usuarioRegistro,
    OficinaRegistroDto oficinaRegistro,
    ResumenSolicitudDto resumenSolicitud,
    List<SiguientePasoDto> siguientesPasos,
    String urlSeguimiento,
    List<EventoGeneradoDto> eventosGenerados,
    LinksDto _links
) {}
