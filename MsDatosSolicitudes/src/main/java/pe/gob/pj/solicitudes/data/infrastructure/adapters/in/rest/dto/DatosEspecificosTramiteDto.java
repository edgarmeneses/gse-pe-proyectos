package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public final class DatosEspecificosTramiteDto {
    private final String motivoRenovacion;
    private final String dniAnterior;
    private final LocalDateTime fechaVencimientoDniAnterior;
    private final Boolean requiereEntregaDomicilio;
    private final String oficinaEntregaPreferida;
    private final List<DocumentoAdjuntoDto> documentosAdjuntos;

    public DatosEspecificosTramiteDto(String motivoRenovacion, String dniAnterior, LocalDateTime fechaVencimientoDniAnterior, Boolean requiereEntregaDomicilio, String oficinaEntregaPreferida, List<DocumentoAdjuntoDto> documentosAdjuntos) {
        this.motivoRenovacion = motivoRenovacion;
        this.dniAnterior = dniAnterior;
        this.fechaVencimientoDniAnterior = fechaVencimientoDniAnterior;
        this.requiereEntregaDomicilio = requiereEntregaDomicilio;
        this.oficinaEntregaPreferida = oficinaEntregaPreferida;
        this.documentosAdjuntos = documentosAdjuntos;
    }

    public String motivoRenovacion() { return motivoRenovacion; }
    public String dniAnterior() { return dniAnterior; }
    public LocalDateTime fechaVencimientoDniAnterior() { return fechaVencimientoDniAnterior; }
    public Boolean requiereEntregaDomicilio() { return requiereEntregaDomicilio; }
    public String oficinaEntregaPreferida() { return oficinaEntregaPreferida; }
    public java.util.List<DocumentoAdjuntoDto> documentosAdjuntos() { return documentosAdjuntos; }
}
