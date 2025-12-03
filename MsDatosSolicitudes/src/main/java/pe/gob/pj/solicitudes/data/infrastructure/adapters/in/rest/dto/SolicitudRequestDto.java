package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;

public final class SolicitudRequestDto {
    private final String tipoTramite;
    private final String subTipoTramite;
    private final SolicitanteDto solicitante;
    private final String tipoSolicitante;
    private final String prioridad;
    private final List<RequisitoCumplidoDto> requisitosCumplidos;
    private final DatosEspecificosTramiteDto datosEspecificosTramite;
    private final PagoDto pago;
    private final String observaciones;

    public SolicitudRequestDto(String tipoTramite, String subTipoTramite, SolicitanteDto solicitante, String tipoSolicitante, String prioridad, List<RequisitoCumplidoDto> requisitosCumplidos, DatosEspecificosTramiteDto datosEspecificosTramite, PagoDto pago, String observaciones) {
        this.tipoTramite = tipoTramite;
        this.subTipoTramite = subTipoTramite;
        this.solicitante = solicitante;
        this.tipoSolicitante = tipoSolicitante;
        this.prioridad = prioridad;
        this.requisitosCumplidos = requisitosCumplidos;
        this.datosEspecificosTramite = datosEspecificosTramite;
        this.pago = pago;
        this.observaciones = observaciones;
    }

    public String tipoTramite() { return tipoTramite; }
    public String subTipoTramite() { return subTipoTramite; }
    public SolicitanteDto solicitante() { return solicitante; }
    public String tipoSolicitante() { return tipoSolicitante; }
    public String prioridad() { return prioridad; }
    public java.util.List<RequisitoCumplidoDto> requisitosCumplidos() { return requisitosCumplidos; }
    public DatosEspecificosTramiteDto datosEspecificosTramite() { return datosEspecificosTramite; }
    public PagoDto pago() { return pago; }
    public String observaciones() { return observaciones; }
}
