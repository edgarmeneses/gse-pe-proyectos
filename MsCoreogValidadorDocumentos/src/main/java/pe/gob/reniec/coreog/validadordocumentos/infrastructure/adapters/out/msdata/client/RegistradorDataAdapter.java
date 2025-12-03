package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Registrador;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.out.RegistradorDataPort;
import java.time.LocalDateTime;

/**
 * Adaptador: Cliente para MsDataRegistradores
 * Este es un microservicio de DOMINIO, por lo que implementa puertos hacia MsData
 * NO define el protocolo de conexión (sin HTTP, SOAP, colas, etc.)
 */
public class RegistradorDataAdapter implements RegistradorDataPort {
    
    @Override
    public Registrador consultarRegistradorPorDni(String numeroDni) {
        // TODO: Implementar integración con MsDataRegistradores
        // Sin tecnología (sin protocolo HTTP/SOAP/colas definido)
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataRegistradores");
    }
    
    @Override
    public String consultarFirmaReferencia(String numeroDni) {
        // TODO: Implementar integración con MsDataRegistradores
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataRegistradores");
    }
    
    @Override
    public String consultarSelloReferencia(String numeroDni) {
        // TODO: Implementar integración con MsDataRegistradores
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataRegistradores");
    }
    
    @Override
    public Boolean verificarHabilitacionEnFecha(String numeroDni, LocalDateTime fechaInscripcion, String codigoLocal) {
        // TODO: Implementar integración con MsDataRegistradores
        throw new UnsupportedOperationException("Implementación pendiente - Integrar con MsDataRegistradores");
    }
}
