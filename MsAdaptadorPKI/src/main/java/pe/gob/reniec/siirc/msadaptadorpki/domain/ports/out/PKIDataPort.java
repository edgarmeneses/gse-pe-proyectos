package pe.gob.reniec.siirc.msadaptadorpki.domain.ports.out;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.CertificadoDigital;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.NumerosSolicitud;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudCertificado;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudNumerosSecuencia;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.RespuestaPKI;

import java.util.List;

public interface PKIDataPort {
    
    GenerarCertificadosResult generarCertificados(SolicitudCertificado solicitud, String pkiTransactionId);
    
    GenerarNumerosSolicitudResult generarNumerosSolicitud(SolicitudNumerosSecuencia solicitud);
    
    class GenerarCertificadosResult {
        private List<CertificadoDigital> certificados;
        private RespuestaPKI respuestaPKI;
        
        public GenerarCertificadosResult() {
        }
        
        public GenerarCertificadosResult(List<CertificadoDigital> certificados, RespuestaPKI respuestaPKI) {
            this.certificados = certificados;
            this.respuestaPKI = respuestaPKI;
        }
        
        public List<CertificadoDigital> getCertificados() {
            return certificados;
        }
        
        public void setCertificados(List<CertificadoDigital> certificados) {
            this.certificados = certificados;
        }
        
        public RespuestaPKI getRespuestaPKI() {
            return respuestaPKI;
        }
        
        public void setRespuestaPKI(RespuestaPKI respuestaPKI) {
            this.respuestaPKI = respuestaPKI;
        }
    }
    
    class GenerarNumerosSolicitudResult {
        private NumerosSolicitud numerosSolicitud;
        
        public GenerarNumerosSolicitudResult() {
        }
        
        public GenerarNumerosSolicitudResult(NumerosSolicitud numerosSolicitud) {
            this.numerosSolicitud = numerosSolicitud;
        }
        
        public NumerosSolicitud getNumerosSolicitud() {
            return numerosSolicitud;
        }
        
        public void setNumerosSolicitud(NumerosSolicitud numerosSolicitud) {
            this.numerosSolicitud = numerosSolicitud;
        }
    }
}
