package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto;

public class PaqueteElectoralDto {
    private String paqueteId;
    private String codigoPaquete;
    private String idPadron;
    private String tipoPadron;
    private String codigoCronogramaElectoral;
    private String tipoProcesoElectoral;
    private UbicacionDto ubicacion;
    private String estadoPaquete;
    private String fechaGeneracion;
    private String fechaUltimaActualizacion;
    private String usuarioUltimaActualizacion;
    private Integer totalCiudadanos;
    private Integer totalImagenes;
    private Long tamanioArchivoPDF;
    private Long tamanioArchivoDatos;
    private String hashIntegridad;
    private String rutaArchivoPDF;
    private String rutaArchivoDatos;
    private String rutaArchivoImagenes;
    private InformacionPublicacionDto informacionPublicacion;
    private AprobacionDto aprobacion;

    public PaqueteElectoralDto() {
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

    public UbicacionDto getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDto ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
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

    public InformacionPublicacionDto getInformacionPublicacion() {
        return informacionPublicacion;
    }

    public void setInformacionPublicacion(InformacionPublicacionDto informacionPublicacion) {
        this.informacionPublicacion = informacionPublicacion;
    }

    public AprobacionDto getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(AprobacionDto aprobacion) {
        this.aprobacion = aprobacion;
    }
}
