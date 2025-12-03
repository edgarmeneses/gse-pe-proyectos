package pe.gob.sunat.gse.coreog.certificadosdigitales.domain.ports.in;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import java.util.List;

/**
 * Puerto de entrada: Obtener Certificado Digital
 * Coordina el flujo de emisión de certificados digitales DNIe
 */
public interface ObtenerCertificadoDigitalUseCase {
    
    /**
     * Ejecuta el flujo completo de emisión de certificados digitales
     * Coordina los dos pasos obligatorios:
     * 1. Generar Números de Solicitud PKI
     * 2. Emitir Certificado Digital DNIe
     * 
     * @param solicitud Datos de la solicitud
     * @param ciudadano Datos del ciudadano
     * @param configuracion Configuración de los certificados
     * @param metadatos Metadatos de la solicitud
     * @return Lista de certificados digitales emitidos
     */
    List<CertificadoDigital> obtener(Object solicitud, Object ciudadano, Object configuracion, Object metadatos);
}
