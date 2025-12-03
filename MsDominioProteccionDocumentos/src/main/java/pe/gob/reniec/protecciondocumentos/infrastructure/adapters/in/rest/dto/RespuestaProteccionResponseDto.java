package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RespuestaProteccionResponseDto {
    private Boolean success;
    private LocalDateTime timestamp;
    private DataProteccionDto data;
    private List<LinksHATEOASDto> links;
    private MetadataRespuestaDto metadata;

    public RespuestaProteccionResponseDto() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public DataProteccionDto getData() {
        return data;
    }

    public void setData(DataProteccionDto data) {
        this.data = data;
    }

    public List<LinksHATEOASDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinksHATEOASDto> links) {
        this.links = links;
    }

    public MetadataRespuestaDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataRespuestaDto metadata) {
        this.metadata = metadata;
    }

    public static class DataProteccionDto {
        private String procesoId;
        private String solicitudId;
        private String estado;
        private LocalDateTime fechaProcesamiento;
        private List<ArchivoProtegidoDto> archivosProtegidos;
        private InformacionSeguridadDto seguridad;
        private EstadisticasCompresionDto estadisticas;

        public DataProteccionDto() {
        }

        public String getProcesoId() {
            return procesoId;
        }

        public void setProcesoId(String procesoId) {
            this.procesoId = procesoId;
        }

        public String getSolicitudId() {
            return solicitudId;
        }

        public void setSolicitudId(String solicitudId) {
            this.solicitudId = solicitudId;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public LocalDateTime getFechaProcesamiento() {
            return fechaProcesamiento;
        }

        public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
            this.fechaProcesamiento = fechaProcesamiento;
        }

        public List<ArchivoProtegidoDto> getArchivosProtegidos() {
            return archivosProtegidos;
        }

        public void setArchivosProtegidos(List<ArchivoProtegidoDto> archivosProtegidos) {
            this.archivosProtegidos = archivosProtegidos;
        }

        public InformacionSeguridadDto getSeguridad() {
            return seguridad;
        }

        public void setSeguridad(InformacionSeguridadDto seguridad) {
            this.seguridad = seguridad;
        }

        public EstadisticasCompresionDto getEstadisticas() {
            return estadisticas;
        }

        public void setEstadisticas(EstadisticasCompresionDto estadisticas) {
            this.estadisticas = estadisticas;
        }
    }

    public static class ArchivoProtegidoDto {
        private String archivoId;
        private String documentoOriginalId;
        private String nombreArchivo;
        private String formatoProtegido;
        private Long tamanioOriginalBytes;
        private Long tamanioComprimidoBytes;
        private Double ratioCompresion;
        private String hash;
        private String algoritmoHash;
        private String ubicacionAlmacenamiento;

        public ArchivoProtegidoDto() {
        }

        public String getArchivoId() {
            return archivoId;
        }

        public void setArchivoId(String archivoId) {
            this.archivoId = archivoId;
        }

        public String getDocumentoOriginalId() {
            return documentoOriginalId;
        }

        public void setDocumentoOriginalId(String documentoOriginalId) {
            this.documentoOriginalId = documentoOriginalId;
        }

        public String getNombreArchivo() {
            return nombreArchivo;
        }

        public void setNombreArchivo(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
        }

        public String getFormatoProtegido() {
            return formatoProtegido;
        }

        public void setFormatoProtegido(String formatoProtegido) {
            this.formatoProtegido = formatoProtegido;
        }

        public Long getTamanioOriginalBytes() {
            return tamanioOriginalBytes;
        }

        public void setTamanioOriginalBytes(Long tamanioOriginalBytes) {
            this.tamanioOriginalBytes = tamanioOriginalBytes;
        }

        public Long getTamanioComprimidoBytes() {
            return tamanioComprimidoBytes;
        }

        public void setTamanioComprimidoBytes(Long tamanioComprimidoBytes) {
            this.tamanioComprimidoBytes = tamanioComprimidoBytes;
        }

        public Double getRatioCompresion() {
            return ratioCompresion;
        }

        public void setRatioCompresion(Double ratioCompresion) {
            this.ratioCompresion = ratioCompresion;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getAlgoritmoHash() {
            return algoritmoHash;
        }

        public void setAlgoritmoHash(String algoritmoHash) {
            this.algoritmoHash = algoritmoHash;
        }

        public String getUbicacionAlmacenamiento() {
            return ubicacionAlmacenamiento;
        }

        public void setUbicacionAlmacenamiento(String ubicacionAlmacenamiento) {
            this.ubicacionAlmacenamiento = ubicacionAlmacenamiento;
        }
    }

    public static class InformacionSeguridadDto {
        private String algoritmoCifrado;
        private String nivelSeguridad;
        private LocalDateTime fechaCifrado;
        private String huellaCifrado;

        public InformacionSeguridadDto() {
        }

        public String getAlgoritmoCifrado() {
            return algoritmoCifrado;
        }

        public void setAlgoritmoCifrado(String algoritmoCifrado) {
            this.algoritmoCifrado = algoritmoCifrado;
        }

        public String getNivelSeguridad() {
            return nivelSeguridad;
        }

        public void setNivelSeguridad(String nivelSeguridad) {
            this.nivelSeguridad = nivelSeguridad;
        }

        public LocalDateTime getFechaCifrado() {
            return fechaCifrado;
        }

        public void setFechaCifrado(LocalDateTime fechaCifrado) {
            this.fechaCifrado = fechaCifrado;
        }

        public String getHuellaCifrado() {
            return huellaCifrado;
        }

        public void setHuellaCifrado(String huellaCifrado) {
            this.huellaCifrado = huellaCifrado;
        }
    }

    public static class EstadisticasCompresionDto {
        private Long totalDocumentos;
        private Long documentosProcesados;
        private Long documentosFallidos;
        private Long tiempoProcesamientoMs;
        private Long ahorroEspacioBytes;
        private Double porcentajeReduccion;

        public EstadisticasCompresionDto() {
        }

        public Long getTotalDocumentos() {
            return totalDocumentos;
        }

        public void setTotalDocumentos(Long totalDocumentos) {
            this.totalDocumentos = totalDocumentos;
        }

        public Long getDocumentosProcesados() {
            return documentosProcesados;
        }

        public void setDocumentosProcesados(Long documentosProcesados) {
            this.documentosProcesados = documentosProcesados;
        }

        public Long getDocumentosFallidos() {
            return documentosFallidos;
        }

        public void setDocumentosFallidos(Long documentosFallidos) {
            this.documentosFallidos = documentosFallidos;
        }

        public Long getTiempoProcesamientoMs() {
            return tiempoProcesamientoMs;
        }

        public void setTiempoProcesamientoMs(Long tiempoProcesamientoMs) {
            this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        }

        public Long getAhorroEspacioBytes() {
            return ahorroEspacioBytes;
        }

        public void setAhorroEspacioBytes(Long ahorroEspacioBytes) {
            this.ahorroEspacioBytes = ahorroEspacioBytes;
        }

        public Double getPorcentajeReduccion() {
            return porcentajeReduccion;
        }

        public void setPorcentajeReduccion(Double porcentajeReduccion) {
            this.porcentajeReduccion = porcentajeReduccion;
        }
    }

    public static class LinksHATEOASDto {
        private String rel;
        private String href;
        private String method;

        public LinksHATEOASDto() {
        }

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    public static class MetadataRespuestaDto {
        private String version;
        private String requestId;
        private String correlationId;

        public MetadataRespuestaDto() {
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getCorrelationId() {
            return correlationId;
        }

        public void setCorrelationId(String correlationId) {
            this.correlationId = correlationId;
        }
    }
}
