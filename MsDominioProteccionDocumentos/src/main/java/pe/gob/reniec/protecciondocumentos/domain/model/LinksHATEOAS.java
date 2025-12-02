package pe.gob.reniec.protecciondocumentos.domain.model;

public class LinksHATEOAS {
    private String self;
    private String descargar;
    private String verificar;

    public LinksHATEOAS() {
    }

    public LinksHATEOAS(String self, String descargar, String verificar) {
        this.self = self;
        this.descargar = descargar;
        this.verificar = verificar;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getDescargar() {
        return descargar;
    }

    public void setDescargar(String descargar) {
        this.descargar = descargar;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }
}
