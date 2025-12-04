package pe.gob.onpe.dominio.paquetes.domain.model;

import java.time.LocalDateTime;

/**
 * Entidad de dominio que representa un paquete electoral.
 * Contiene solo información del negocio electoral, sin atributos técnicos de infraestructura.
 */
public class PaqueteElectoral {
    private String paqueteId;
    private String codigoPaquete;
    private String idPadron;
    private String tipoPadron;
    private String codigoCronogramaElectoral;
    private String tipoProcesoElectoral;
    private Ubicacion ubicacion;
    private String estadoPaquete;
    private LocalDateTime fechaGeneracion;
    private LocalDateTime fechaUltimaActualizacion;
    private String usuarioUltimaActualizacion;
    private Integer totalCiudadanos;
    private Integer totalImagenes;
    private String hashIntegridad;
    private Aprobacion aprobacion;

    public PaqueteElectoral() {
    }

    public String getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(String paqueteId) {
        this.paqueteId = paqueteId;
    }

    public String getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(String codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(String idPadron) {
        this.idPadron = idPadron;
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public String getCodigoCronogramaElectoral() {
        return codigoCronogramaElectoral;
    }

    public void setCodigoCronogramaElectoral(String codigoCronogramaElectoral) {
        this.codigoCronogramaElectoral = codigoCronogramaElectoral;
    }

    public String getTipoProcesoElectoral() {
        return tipoProcesoElectoral;
    }

    public void setTipoProcesoElectoral(String tipoProcesoElectoral) {
        this.tipoProcesoElectoral = tipoProcesoElectoral;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getUsuarioUltimaActualizacion() {
        return usuarioUltimaActualizacion;
    }

    public void setUsuarioUltimaActualizacion(String usuarioUltimaActualizacion) {
        this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
    }

    public Integer getTotalCiudadanos() {
        return totalCiudadanos;
    }

    public void setTotalCiudadanos(Integer totalCiudadanos) {
        this.totalCiudadanos = totalCiudadanos;
    }

    public Integer getTotalImagenes() {
        return totalImagenes;
    }

    public void setTotalImagenes(Integer totalImagenes) {
        this.totalImagenes = totalImagenes;
    }

    public String getHashIntegridad() {
        return hashIntegridad;
    }

    public void setHashIntegridad(String hashIntegridad) {
        this.hashIntegridad = hashIntegridad;
    }

    public Aprobacion getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Aprobacion aprobacion) {
        this.aprobacion = aprobacion;
    }
}
