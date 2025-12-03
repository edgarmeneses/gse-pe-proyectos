package pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.out;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import java.util.List;

/**
 * Puerto de salida hacia MsAdaptadorPKI
 * Define las operaciones de emisión de certificados sin especificar el protocolo de comunicación
 * 
 * El microservicio ejecuta dos pasos obligatorios:
 * 1. Generar Números de Solicitud PKI (generarNumerosSolicitud2)
 * 2. Emitir Certificado Digital DNIe (generarCertificadoDigitalDniE)
 */
public interface CertificadoDigitalDataPort {
    
    /**
     * Paso 2: Emite el certificado digital DNIe
     * Invoca POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE
     * 
     * @param solicitudPkiId ID de solicitud PKI del paso 1
     * @param solicitud Datos de la solicitud
     * @param ciudadano Datos del ciudadano
     * @param configuracion Configuración de certificados
     * @param metadatos Metadatos de la solicitud
     * @return Lista de certificados digitales emitidos
     */
    List<CertificadoDigital> obtenerCertificadoDigital(String solicitudPkiId, Object solicitud, 
                                                           Object ciudadano, Object configuracion, Object metadatos);
}
