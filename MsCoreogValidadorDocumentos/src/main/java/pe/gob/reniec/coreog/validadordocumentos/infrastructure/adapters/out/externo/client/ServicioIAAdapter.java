package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.externo.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.ServicioIAPort;

/**
 * Adaptador: Cliente para el Servicio de Inteligencia Artificial
 * Implementa la comunicación con los modelos de IA para evaluación de documentos
 * NO define el protocolo de conexión (sin HTTP, SOAP, colas, etc.)
 */
public class ServicioIAAdapter implements ServicioIAPort {
    
    @Override
    public Evaluacion evaluarDocumentos(SolicitudEvaluacionIA solicitudEvaluacion) {
        // TODO: Implementar integración con Servicio de IA
        // Sin tecnología (sin protocolo HTTP/SOAP/colas definido)
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Servicio de IA");
    }
    
    @Override
    public ResultadoComparacion compararFirma(String imagenFirmaDocumento, String imagenFirmaReferencia, Double umbralSimilitud) {
        // TODO: Implementar comparación de firma con IA
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Servicio de IA");
    }
    
    @Override
    public ResultadoComparacion compararSello(String imagenSelloDocumento, String imagenSelloReferencia, Double umbralSimilitud) {
        // TODO: Implementar comparación de sello con IA
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Servicio de IA");
    }
    
    @Override
    public String extraerFirma(byte[] contenidoDocumento) {
        // TODO: Implementar extracción de firma con IA
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Servicio de IA");
    }
    
    @Override
    public String extraerSello(byte[] contenidoDocumento) {
        // TODO: Implementar extracción de sello con IA
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con Servicio de IA");
    }
}
