package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record PagoDto(
        Double montoPagado,
        String metodoPago,
        String referenciaPago,
        LocalDateTime fechaPago
) {
}
