package pe.gob.reniec.protecciondocumentos.domain.model;

public class ArchivoProtegido {
    private String repositorioId;
    private String documentoId;
    private String nombreArchivo;
    private int tamanioBytes;
    private String formatoSalida;
    private String checksumSHA256;

    public ArchivoProtegido() {
    }

    public ArchivoProtegido(String repositorioId, String documentoId, String nombreArchivo, 
                           int tamanioBytes, String formatoSalida, String checksumSHA256) {
        this.repositorioId = repositorioId;
        this.documentoId = documentoId;
        this.nombreArchivo = nombreArchivo;
        this.tamanioBytes = tamanioBytes;
        this.formatoSalida = formatoSalida;
        this.checksumSHA256 = checksumSHA256;
    }

    public String getRepositorioId() {
        return repositorioId;
    }

    public void setRepositorioId(String repositorioId) {
        this.repositorioId = repositorioId;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public int getTamanioBytes() {
        return tamanioBytes;
    }

    public void setTamanioBytes(int tamanioBytes) {
        this.tamanioBytes = tamanioBytes;
    }

    public String getFormatoSalida() {
        return formatoSalida;
    }

    public void setFormatoSalida(String formatoSalida) {
        this.formatoSalida = formatoSalida;
    }

    public String getChecksumSHA256() {
        return checksumSHA256;
    }

    public void setChecksumSHA256(String checksumSHA256) {
        this.checksumSHA256 = checksumSHA256;
    }
}
