package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record SolicitudRequestDto(
        String tipoTramite,
        String subTipoTramite,
        SolicitanteDto solicitante,
        String tipoSolicitante,
        String prioridad,
        List<RequisitoCumplidoDto> requisitosCumplidos,
        DatosEspecificosTramiteDto datosEspecificosTramite,
        PagoDto pago,
        String observaciones
) {
}
