package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.EvaluacionDataPort;
import java.util.List;

/**
 * Adaptador: Cliente para MsDataValidadorDocumentos - Evaluaciones
 * Este es un microservicio de DOMINIO, por lo que implementa puertos hacia MsData
 * NO define el protocolo de conexión (sin HTTP, SOAP, colas, etc.)
 */
public class EvaluacionDataAdapter implements EvaluacionDataPort {
    
    @Override
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        // Sin tecnología (sin protocolo HTTP/SOAP/colas definido)
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
    
    @Override
    public Evaluacion consultarEvaluacionPorId(String evaluacionId) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
    
    @Override
    public List<Evaluacion> consultarEvaluacionesPorSolicitud(String solicitudId) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
}
