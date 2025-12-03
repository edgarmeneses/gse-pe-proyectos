package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.out.msdata.client;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.out.CertificadoDigitalDataPort;
import java.util.List;

/**
 * Adaptador para comunicación con MsAdaptadorPKI
 * Implementa el puerto de salida sin especificar tecnología o protocolo
 * (HTTP, SOAP, colas, etc. se definirían en tiempo de implementación)
 * 
 * Consume dos endpoints del MsAdaptadorPKI v1.0:
 * 1. POST /api/v1/adaptador/MsAdaptadorPKI/generarNumerosSolicitud2
 * 2. POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE
 */
public class CertificadoDigitalDataAdapter implements CertificadoDigitalDataPort {
    
    
    @Override
    public List<CertificadoDigital> obtenerCertificadoDigital(String solicitudPkiId, Object solicitud, 
                                                                   Object ciudadano, Object configuracion, Object metadatos) {
        // Implementación pendiente: conexión con MsAdaptadorPKI - Paso 2
        // El protocolo de comunicación (HTTP/SOAP/etc.) se definirá con el framework elegido
        // Endpoint: POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE
        throw new UnsupportedOperationException("Implementación pendiente: generarCertificadoDigitalDniE en MsAdaptadorPKI");
    }
}
