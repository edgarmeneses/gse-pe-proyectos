package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record DatosEspecificosTramiteDto(
        String motivoRenovacion,
        String dniAnterior,
        LocalDateTime fechaVencimientoDniAnterior,
        Boolean requiereEntregaDomicilio,
        String oficinaEntregaPreferida,
        List<DocumentoAdjuntoDto> documentosAdjuntos
) {
}
