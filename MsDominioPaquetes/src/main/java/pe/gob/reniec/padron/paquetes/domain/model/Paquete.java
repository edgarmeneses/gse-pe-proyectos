package pe.gob.reniec.padron.paquetes.domain.model;

import java.time.LocalDateTime;

public class Paquete {
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
    private Long totalCiudadanos;
    private Long totalImagenes;
    private Long tamanioArchivoPDF;
    private Long tamanioArchivoDatos;
    private String hashIntegridad;
    private String rutaArchivoPDF;
    private String rutaArchivoDatos;
    private String rutaArchivoImagenes;
    private InformacionPublicacion informacionPublicacion;
    private Aprobacion aprobacion;

    // Constructor vacío
    public Paquete() {
    }

    // Constructor completo
    public Paquete(String paqueteId, String codigoPaquete, String idPadron, String tipoPadron,
                   String codigoCronogramaElectoral, String tipoProcesoElectoral, Ubicacion ubicacion,
                   String estadoPaquete, LocalDateTime fechaGeneracion, LocalDateTime fechaUltimaActualizacion,
                   String usuarioUltimaActualizacion, Long totalCiudadanos, Long totalImagenes,
                   Long tamanioArchivoPDF, Long tamanioArchivoDatos, String hashIntegridad,
                   String rutaArchivoPDF, String rutaArchivoDatos, String rutaArchivoImagenes,
                   InformacionPublicacion informacionPublicacion, Aprobacion aprobacion) {
        this.paqueteId = paqueteId;
        this.codigoPaquete = codigoPaquete;
        this.idPadron = idPadron;
        this.tipoPadron = tipoPadron;
        this.codigoCronogramaElectoral = codigoCronogramaElectoral;
        this.tipoProcesoElectoral = tipoProcesoElectoral;
        this.ubicacion = ubicacion;
        this.estadoPaquete = estadoPaquete;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
        this.totalCiudadanos = totalCiudadanos;
        this.totalImagenes = totalImagenes;
        this.tamanioArchivoPDF = tamanioArchivoPDF;
        this.tamanioArchivoDatos = tamanioArchivoDatos;
        this.hashIntegridad = hashIntegridad;
        this.rutaArchivoPDF = rutaArchivoPDF;
        this.rutaArchivoDatos = rutaArchivoDatos;
        this.rutaArchivoImagenes = rutaArchivoImagenes;
        this.informacionPublicacion = informacionPublicacion;
        this.aprobacion = aprobacion;
    }

    // Getters y Setters
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

    public Long getTotalCiudadanos() {
        return totalCiudadanos;
    }

    public void setTotalCiudadanos(Long totalCiudadanos) {
        this.totalCiudadanos = totalCiudadanos;
    }

    public Long getTotalImagenes() {
        return totalImagenes;
    }

    public void setTotalImagenes(Long totalImagenes) {
        this.totalImagenes = totalImagenes;
    }

    public Long getTamanioArchivoPDF() {
        return tamanioArchivoPDF;
    }

    public void setTamanioArchivoPDF(Long tamanioArchivoPDF) {
        this.tamanioArchivoPDF = tamanioArchivoPDF;
    }

    public Long getTamanioArchivoDatos() {
        return tamanioArchivoDatos;
    }

    public void setTamanioArchivoDatos(Long tamanioArchivoDatos) {
        this.tamanioArchivoDatos = tamanioArchivoDatos;
    }

    public String getHashIntegridad() {
        return hashIntegridad;
    }

    public void setHashIntegridad(String hashIntegridad) {
        this.hashIntegridad = hashIntegridad;
    }

    public String getRutaArchivoPDF() {
        return rutaArchivoPDF;
    }

    public void setRutaArchivoPDF(String rutaArchivoPDF) {
        this.rutaArchivoPDF = rutaArchivoPDF;
    }

    public String getRutaArchivoDatos() {
        return rutaArchivoDatos;
    }

    public void setRutaArchivoDatos(String rutaArchivoDatos) {
        this.rutaArchivoDatos = rutaArchivoDatos;
    }

    public String getRutaArchivoImagenes() {
        return rutaArchivoImagenes;
    }

    public void setRutaArchivoImagenes(String rutaArchivoImagenes) {
        this.rutaArchivoImagenes = rutaArchivoImagenes;
    }

    public InformacionPublicacion getInformacionPublicacion() {
        return informacionPublicacion;
    }

    public void setInformacionPublicacion(InformacionPublicacion informacionPublicacion) {
        this.informacionPublicacion = informacionPublicacion;
    }

    public Aprobacion getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Aprobacion aprobacion) {
        this.aprobacion = aprobacion;
    }
}
