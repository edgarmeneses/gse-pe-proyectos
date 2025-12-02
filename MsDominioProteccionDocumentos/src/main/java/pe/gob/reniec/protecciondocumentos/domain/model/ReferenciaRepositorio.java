package pe.gob.reniec.protecciondocumentos.domain.model;

public class ReferenciaRepositorio {
    private String repositorioId;
    private String documentoId;
    private String versionId;

    public ReferenciaRepositorio() {
    }

    public ReferenciaRepositorio(String repositorioId, String documentoId, String versionId) {
        this.repositorioId = repositorioId;
        this.documentoId = documentoId;
        this.versionId = versionId;
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

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
}
