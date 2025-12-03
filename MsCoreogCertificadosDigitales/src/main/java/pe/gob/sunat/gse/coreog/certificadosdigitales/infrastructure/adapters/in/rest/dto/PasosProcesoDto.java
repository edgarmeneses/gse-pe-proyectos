package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para los pasos del proceso
 */
public class PasosProcesoDto {
    
    private Paso1GeneracionClavesDto paso1GeneracionClaves;
    private Paso2EmisionCertificadoDto paso2EmisionCertificado;
    
    public PasosProcesoDto() {
    }
    
    public Paso1GeneracionClavesDto getPaso1GeneracionClaves() {
        return paso1GeneracionClaves;
    }
    
    public void setPaso1GeneracionClaves(Paso1GeneracionClavesDto paso1GeneracionClaves) {
        this.paso1GeneracionClaves = paso1GeneracionClaves;
    }
    
    public Paso2EmisionCertificadoDto getPaso2EmisionCertificado() {
        return paso2EmisionCertificado;
    }
    
    public void setPaso2EmisionCertificado(Paso2EmisionCertificadoDto paso2EmisionCertificado) {
        this.paso2EmisionCertificado = paso2EmisionCertificado;
    }
}
