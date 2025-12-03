package pe.gob.reniec.protecciondocumentos.domain.model;

public class Estadisticas {
    private Long totalDocumentos;
    private Long documentosProcesados;
    private Long documentosFallidos;
    private Long tiempoProcesamientoMs;
    private Long ahorroEspacioBytes;

    public Estadisticas() {
    }

    public Estadisticas(Long totalDocumentos, Long documentosProcesados, Long documentosFallidos,
                       Long tiempoProcesamientoMs, Long ahorroEspacioBytes) {
        this.totalDocumentos = totalDocumentos;
        this.documentosProcesados = documentosProcesados;
        this.documentosFallidos = documentosFallidos;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
        this.ahorroEspacioBytes = ahorroEspacioBytes;
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
}
