package pe.gob.sunat.gse.coreog.certificadosdigitales.application.service;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.in.ObtenerCertificadoDigitalUseCase;
import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.out.CertificadoDigitalDataPort;
import java.util.List;

/**
 * Servicio de aplicación: Obtener Certificado Digital
 * Implementa el caso de uso coordinando el flujo de dos pasos obligatorios
 */
public class ObtenerCertificadoDigitalService implements ObtenerCertificadoDigitalUseCase {
    
    private final CertificadoDigitalDataPort certificadoDigitalDataPort;
    
    public ObtenerCertificadoDigitalService(CertificadoDigitalDataPort certificadoDigitalDataPort) {
        this.certificadoDigitalDataPort = certificadoDigitalDataPort;
    }
    
    @Override
    public List<CertificadoDigital> obtener(Object solicitud, Object ciudadano, Object configuracion, Object metadatos) {
        // Paso 1: Generar Números de Solicitud PKI
        String solicitudPkiId = certificadoDigitalDataPort.generarNumerosSolicitudPki(solicitud, configuracion, metadatos);
        
        // Paso 2: Emitir Certificado Digital DNIe usando el ID del paso 1
        List<CertificadoDigital> certificados = certificadoDigitalDataPort.generarCertificadoDigitalDniE(
            solicitudPkiId, solicitud, ciudadano, configuracion, metadatos
        );
        
        return certificados;
    }
}
