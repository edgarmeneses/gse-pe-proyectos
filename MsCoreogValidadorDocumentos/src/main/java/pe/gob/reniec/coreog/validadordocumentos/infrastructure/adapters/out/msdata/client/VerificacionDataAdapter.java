package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Verificacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.VerificacionDataPort;
import java.util.List;

/**
 * Adaptador: Cliente para MsDataValidadorDocumentos - Verificaciones
 * Este es un microservicio de DOMINIO, por lo que implementa puertos hacia MsData
 * NO define el protocolo de conexión (sin HTTP, SOAP, colas, etc.)
 */
public class VerificacionDataAdapter implements VerificacionDataPort {
    
    @Override
    public Verificacion guardarVerificacion(Verificacion verificacion) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        // Sin tecnología (sin protocolo HTTP/SOAP/colas definido)
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
    
    @Override
    public Verificacion consultarVerificacionPorId(String verificacionId) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
    
    @Override
    public List<Verificacion> consultarVerificacionesPorSolicitud(String solicitudId) {
        // TODO: Implementar integración con MsDataValidadorDocumentos
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataValidadorDocumentos");
    }
}
