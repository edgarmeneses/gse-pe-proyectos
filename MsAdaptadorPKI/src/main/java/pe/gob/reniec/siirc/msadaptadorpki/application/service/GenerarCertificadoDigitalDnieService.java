package pe.gob.reniec.siirc.msadaptadorpki.application.service;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudCertificado;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarCertificadoDigitalDnieUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.out.PKIDataPort;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.MetadataRespuesta;

import java.time.LocalDateTime;

public class GenerarCertificadoDigitalDnieService implements GenerarCertificadoDigitalDnieUseCase {
    
    private final PKIDataPort pkiDataPort;
    
    public GenerarCertificadoDigitalDnieService(PKIDataPort pkiDataPort) {
        this.pkiDataPort = pkiDataPort;
    }
    
    @Override
    public GenerarCertificadoDigitalDnieResponse ejecutar(SolicitudCertificado solicitud, String correlationId,
                                                          String requestId, String officeCode, 
                                                          String pkiTransactionId) {
        PKIDataPort.GenerarCertificadosResult resultado = pkiDataPort.generarCertificados(solicitud, pkiTransactionId);
        
        MetadataRespuesta metadata = new MetadataRespuesta();
        metadata.setCorrelationId(correlationId);
        metadata.setRequestId(requestId);
        metadata.setTimestamp(LocalDateTime.now());
        metadata.setVersion("v1");
        
        GenerarCertificadoDigitalDnieResponse response = new GenerarCertificadoDigitalDnieResponse();
        response.setResultado("EXITOSO");
        response.setMensaje("Certificados generados exitosamente");
        response.setCertificados(resultado.getCertificados());
        response.setPkiExterno(resultado.getRespuestaPKI());
        response.setMetadata(metadata);
        
        return response;
    }
}
