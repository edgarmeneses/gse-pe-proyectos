package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record DiligenciaRequestDto(
        String tipoDiligencia,
        String entidadDestino,
        String tipoEntidad,
        DatosContactoEntidadDto datosContactoEntidad,
        String motivoDiligencia,
        String fundamentoLegal,
        String informacionRequerida,
        List<DocumentoRequeridoDto> documentosRequeridos,
        Long plazoRespuesta,
        String unidadPlazo,
        String prioridad,
        Boolean requiereRespuestaOficial,
        Boolean permitoRespuestaDigital,
        String observaciones,
        String oficinaResponsableSeguimiento
) {
}
