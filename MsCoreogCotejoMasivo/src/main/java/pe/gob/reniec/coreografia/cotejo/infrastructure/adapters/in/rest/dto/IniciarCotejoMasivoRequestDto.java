package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record IniciarCotejoMasivoRequestDto(
    SolicitudDto solicitud,
    EntidadSolicitanteDto entidadSolicitante,
    List<RegistroCotejoDto> registrosCotejo,
    ConfiguracionProcesoDto configuracionProceso,
    DocumentoSolicitudDto documentoSolicitud,
    String observaciones
) {}
