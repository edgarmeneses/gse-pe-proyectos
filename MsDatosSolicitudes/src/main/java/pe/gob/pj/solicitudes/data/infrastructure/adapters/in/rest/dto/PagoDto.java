package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public final class PagoDto {
    private final Double montoPagado;
    private final String metodoPago;
    private final String referenciaPago;
    private final LocalDateTime fechaPago;

    public PagoDto(Double montoPagado, String metodoPago, String referenciaPago, LocalDateTime fechaPago) {
        this.montoPagado = montoPagado;
        this.metodoPago = metodoPago;
        this.referenciaPago = referenciaPago;
        this.fechaPago = fechaPago;
    }

    public Double montoPagado() { return montoPagado; }
    public String metodoPago() { return metodoPago; }
    public String referenciaPago() { return referenciaPago; }
    public LocalDateTime fechaPago() { return fechaPago; }
}
