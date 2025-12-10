package pe.gob.reniec.pago.MsAdaptadorPagos.domain.model;

import java.time.LocalDateTime;

public class ValidacionPago {
    // Identificadores
    private String routingId;
    private String codigoOperacion;
    private String numeroSolicitud;

    // Datos de Entrada
    private Monto monto;
    private LocalDateTime fechaOperacion;
    private String tipoTramite;
    private String entidadBancariaPreferida;
    private DatosSolicitante solicitante;
    private ReglasEnrutamiento reglasEnrutamiento;

    // Resultado del Routing (Decisión)
    private String entidadBancariaIdentificada;
    private String adaptadorUtilizado;
    private String estrategiaUtilizada;
    private Boolean fallbackAplicado;

    // Resultado de la Validación (Respuesta del Banco)
    private Boolean esValido;
    private String codigoTrazaBanco; // Antes validacionId
    private String estadoTransaccion;

    // Auditoría
    private AuditoriaInfo auditoria;

    public ValidacionPago() {}

    // Getters y Setters
    public String getRoutingId() { return routingId; }
    public void setRoutingId(String routingId) { this.routingId = routingId; }

    public String getCodigoOperacion() { return codigoOperacion; }
    public void setCodigoOperacion(String codigoOperacion) { this.codigoOperacion = codigoOperacion; }

    public String getNumeroSolicitud() { return numeroSolicitud; }
    public void setNumeroSolicitud(String numeroSolicitud) { this.numeroSolicitud = numeroSolicitud; }

    public Monto getMonto() { return monto; }
    public void setMonto(Monto monto) { this.monto = monto; }

    public LocalDateTime getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(LocalDateTime fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public String getTipoTramite() { return tipoTramite; }
    public void setTipoTramite(String tipoTramite) { this.tipoTramite = tipoTramite; }

    public String getEntidadBancariaPreferida() { return entidadBancariaPreferida; }
    public void setEntidadBancariaPreferida(String entidadBancariaPreferida) { this.entidadBancariaPreferida = entidadBancariaPreferida; }

    public DatosSolicitante getSolicitante() { return solicitante; }
    public void setSolicitante(DatosSolicitante solicitante) { this.solicitante = solicitante; }

    public ReglasEnrutamiento getReglasEnrutamiento() { return reglasEnrutamiento; }
    public void setReglasEnrutamiento(ReglasEnrutamiento reglasEnrutamiento) { this.reglasEnrutamiento = reglasEnrutamiento; }

    public String getEntidadBancariaIdentificada() { return entidadBancariaIdentificada; }
    public void setEntidadBancariaIdentificada(String entidadBancariaIdentificada) { this.entidadBancariaIdentificada = entidadBancariaIdentificada; }

    public String getAdaptadorUtilizado() { return adaptadorUtilizado; }
    public void setAdaptadorUtilizado(String adaptadorUtilizado) { this.adaptadorUtilizado = adaptadorUtilizado; }

    public String getEstrategiaUtilizada() { return estrategiaUtilizada; }
    public void setEstrategiaUtilizada(String estrategiaUtilizada) { this.estrategiaUtilizada = estrategiaUtilizada; }

    public Boolean getFallbackAplicado() { return fallbackAplicado; }
    public void setFallbackAplicado(Boolean fallbackAplicado) { this.fallbackAplicado = fallbackAplicado; }

    public Boolean getEsValido() { return esValido; }
    public void setEsValido(Boolean esValido) { this.esValido = esValido; }

    public String getCodigoTrazaBanco() { return codigoTrazaBanco; }
    public void setCodigoTrazaBanco(String codigoTrazaBanco) { this.codigoTrazaBanco = codigoTrazaBanco; }

    public String getEstadoTransaccion() { return estadoTransaccion; }
    public void setEstadoTransaccion(String estadoTransaccion) { this.estadoTransaccion = estadoTransaccion; }

    public AuditoriaInfo getAuditoria() { return auditoria; }
    public void setAuditoria(AuditoriaInfo auditoria) { this.auditoria = auditoria; }
}
