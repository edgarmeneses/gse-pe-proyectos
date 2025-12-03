package pe.gob.pj.solicitudes.data.domain.model;

import java.time.LocalDateTime;

public class Pago {
    
    private Double montoPagado;
    private String metodoPago;
    private String referenciaPago;
    private LocalDateTime fechaPago;

    public Pago() {
    }

    public Pago(Double montoPagado, String metodoPago, String referenciaPago, LocalDateTime fechaPago) {
        this.montoPagado = montoPagado;
        this.metodoPago = metodoPago;
        this.referenciaPago = referenciaPago;
        this.fechaPago = fechaPago;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
}
