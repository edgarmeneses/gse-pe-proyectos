package pe.gob.reniec.protecciondocumentos.domain.model;

public class ProteccionPassword {
    private Boolean protegido;
    private String passwordHash;

    public ProteccionPassword() {
    }

    public ProteccionPassword(Boolean protegido, String passwordHash) {
        this.protegido = protegido;
        this.passwordHash = passwordHash;
    }

    public Boolean getProtegido() {
        return protegido;
    }

    public void setProtegido(Boolean protegido) {
        this.protegido = protegido;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
