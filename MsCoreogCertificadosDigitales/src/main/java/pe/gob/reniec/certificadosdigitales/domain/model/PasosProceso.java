package pe.gob.reniec.certificadosdigitales.domain.model;

public class PasosProceso {
    private PasoProceso paso1GeneracionClaves;
    private PasoProceso paso2EmisionCertificado;

    public PasosProceso() {
    }

    public PasosProceso(PasoProceso paso1GeneracionClaves, PasoProceso paso2EmisionCertificado) {
        this.paso1GeneracionClaves = paso1GeneracionClaves;
        this.paso2EmisionCertificado = paso2EmisionCertificado;
    }

    public PasoProceso getPaso1GeneracionClaves() {
        return paso1GeneracionClaves;
    }

    public void setPaso1GeneracionClaves(PasoProceso paso1GeneracionClaves) {
        this.paso1GeneracionClaves = paso1GeneracionClaves;
    }

    public PasoProceso getPaso2EmisionCertificado() {
        return paso2EmisionCertificado;
    }

    public void setPaso2EmisionCertificado(PasoProceso paso2EmisionCertificado) {
        this.paso2EmisionCertificado = paso2EmisionCertificado;
    }
}
