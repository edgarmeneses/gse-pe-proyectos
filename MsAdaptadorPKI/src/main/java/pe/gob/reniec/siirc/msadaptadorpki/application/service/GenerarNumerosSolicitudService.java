package pe.gob.reniec.siirc.msadaptadorpki.application.service;

import pe.gob.reniec.siirc.msadaptadorpki.domain.model.SolicitudNumerosSecuencia;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.in.GenerarNumerosSolicitudUseCase;
import pe.gob.reniec.siirc.msadaptadorpki.domain.ports.out.PKIDataPort;
import pe.gob.reniec.siirc.msadaptadorpki.infrastructure.shared.response.MetadataRespuesta;

import java.time.LocalDateTime;

public class GenerarNumerosSolicitudService implements GenerarNumerosSolicitudUseCase {
    
    private final PKIDataPort pkiDataPort;
    
    public GenerarNumerosSolicitudService(PKIDataPort pkiDataPort) {
        this.pkiDataPort = pkiDataPort;
    }
    
    @Override
    public GenerarNumerosSolicitudResponse ejecutar(SolicitudNumerosSecuencia solicitud, String correlationId,
                                                    String requestId, String officeCode) {
        PKIDataPort.GenerarNumerosSolicitudResult resultado = pkiDataPort.generarNumerosSolicitud(solicitud);
        
        MetadataRespuesta metadata = new MetadataRespuesta();
        metadata.setCorrelationId(correlationId);
        metadata.setRequestId(requestId);
        metadata.setTimestamp(LocalDateTime.now());
        metadata.setVersion("v1");
        
        GenerarNumerosSolicitudResponse response = new GenerarNumerosSolicitudResponse();
        response.setResultado("EXITOSO");
        response.setMensaje("Números de solicitud generados exitosamente");
        response.setSolicitudes(resultado.getNumerosSolicitud());
        response.setMetadata(metadata);
        
        return response;
    }
}
