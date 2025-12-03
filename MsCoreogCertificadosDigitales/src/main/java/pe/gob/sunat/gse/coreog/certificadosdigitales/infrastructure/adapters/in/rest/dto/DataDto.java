package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para el objeto data que contiene toda la información de la transacción
 */
public class DataDto {
    
    private TransaccionDto transaccion;
    private CiudadanoResponseDto ciudadano;
    private List<CertificadoDigitalDto> certificados;
    private PasosProcesoDto pasosProceso;
    private AuditoriaDto auditoria;
    
    public DataDto() {
    }
    
    public TransaccionDto getTransaccion() {
        return transaccion;
    }
    
    public void setTransaccion(TransaccionDto transaccion) {
        this.transaccion = transaccion;
    }
    
    public CiudadanoResponseDto getCiudadano() {
        return ciudadano;
    }
    
    public void setCiudadano(CiudadanoResponseDto ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public List<CertificadoDigitalDto> getCertificados() {
        return certificados;
    }
    
    public void setCertificados(List<CertificadoDigitalDto> certificados) {
        this.certificados = certificados;
    }
    
    public PasosProcesoDto getPasosProceso() {
        return pasosProceso;
    }
    
    public void setPasosProceso(PasosProcesoDto pasosProceso) {
        this.pasosProceso = pasosProceso;
    }
    
    public AuditoriaDto getAuditoria() {
        return auditoria;
    }
    
    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }
}
