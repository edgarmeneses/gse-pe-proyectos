package pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.CertificadoDigital;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudCertificado;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.MetadataRespuesta;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.RespuestaPKI;

import java.util.List;

public interface GenerarCertificadoDigitalDnieUseCase {
    
    GenerarCertificadoDigitalDnieResponse ejecutar(SolicitudCertificado solicitud, String correlationId,
                                                   String requestId, String officeCode, String pkiTransactionId);
    
    class GenerarCertificadoDigitalDnieResponse {
        private String resultado;
        private String mensaje;
        private List<CertificadoDigital> certificados;
        private RespuestaPKI pkiExterno;
        private MetadataRespuesta metadata;
        
        public GenerarCertificadoDigitalDnieResponse() {
        }
        
        public GenerarCertificadoDigitalDnieResponse(String resultado, String mensaje, 
                                                    List<CertificadoDigital> certificados,
                                                    RespuestaPKI pkiExterno, MetadataRespuesta metadata) {
            this.resultado = resultado;
            this.mensaje = mensaje;
            this.certificados = certificados;
            this.pkiExterno = pkiExterno;
            this.metadata = metadata;
        }
        
        public String getResultado() {
            return resultado;
        }
        
        public void setResultado(String resultado) {
            this.resultado = resultado;
        }
        
        public String getMensaje() {
            return mensaje;
        }
        
        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
        
        public List<CertificadoDigital> getCertificados() {
            return certificados;
        }
        
        public void setCertificados(List<CertificadoDigital> certificados) {
            this.certificados = certificados;
        }
        
        public RespuestaPKI getPkiExterno() {
            return pkiExterno;
        }
        
        public void setPkiExterno(RespuestaPKI pkiExterno) {
            this.pkiExterno = pkiExterno;
        }
        
        public MetadataRespuesta getMetadata() {
            return metadata;
        }
        
        public void setMetadata(MetadataRespuesta metadata) {
            this.metadata = metadata;
        }
    }
}
