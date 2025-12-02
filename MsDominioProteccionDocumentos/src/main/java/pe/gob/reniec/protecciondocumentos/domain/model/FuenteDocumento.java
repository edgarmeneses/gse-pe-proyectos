package pe.gob.reniec.protecciondocumentos.domain.model;

public class FuenteDocumento {
    private String tipo;
    private String contenidoBase64;
    private ReferenciaRepositorio referenciaRepositorio;

    public FuenteDocumento() {
    }

    public FuenteDocumento(String tipo, String contenidoBase64, ReferenciaRepositorio referenciaRepositorio) {
        this.tipo = tipo;
        this.contenidoBase64 = contenidoBase64;
        this.referenciaRepositorio = referenciaRepositorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenidoBase64() {
        return contenidoBase64;
    }

    public void setContenidoBase64(String contenidoBase64) {
        this.contenidoBase64 = contenidoBase64;
    }

    public ReferenciaRepositorio getReferenciaRepositorio() {
        return referenciaRepositorio;
    }

    public void setReferenciaRepositorio(ReferenciaRepositorio referenciaRepositorio) {
        this.referenciaRepositorio = referenciaRepositorio;
    }
}
