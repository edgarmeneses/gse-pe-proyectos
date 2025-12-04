package pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.NumerosSolicitud;
import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudNumerosSecuencia;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.MetadataRespuesta;

public interface GenerarNumerosSolicitudUseCase {
    
    GenerarNumerosSolicitudResponse ejecutar(SolicitudNumerosSecuencia solicitud, String correlationId,
                                            String requestId, String officeCode);
    
    class GenerarNumerosSolicitudResponse {
        private String resultado;
        private String mensaje;
        private NumerosSolicitud solicitudes;
        private MetadataRespuesta metadata;
        
        public GenerarNumerosSolicitudResponse() {
        }
        
        public GenerarNumerosSolicitudResponse(String resultado, String mensaje, NumerosSolicitud solicitudes,
                                              MetadataRespuesta metadata) {
            this.resultado = resultado;
            this.mensaje = mensaje;
            this.solicitudes = solicitudes;
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
        
        public NumerosSolicitud getSolicitudes() {
            return solicitudes;
        }
        
        public void setSolicitudes(NumerosSolicitud solicitudes) {
            this.solicitudes = solicitudes;
        }
        
        public MetadataRespuesta getMetadata() {
            return metadata;
        }
        
        public void setMetadata(MetadataRespuesta metadata) {
            this.metadata = metadata;
        }
    }
}
