package pe.gob.reniec.hechosVitales.domain.ports.in;

import pe.gob.reniec.hechosVitales.domain.model.CertificadoNacidoVivo;
import pe.gob.reniec.hechosVitales.domain.model.CriterioBusqueda;

/**
 * Puerto de entrada: ConsultarCertificadoNacidoVivoUseCase
 * 
 * Define el caso de uso para consultar un certificado de nacido vivo
 * desde el sistema de Hechos Vitales del MINSA.
 */
public interface ConsultarCertificadoNacidoVivoUseCase {
    
    /**
     * Consulta un certificado de nacido vivo según los criterios proporcionados.
     * 
     * @param criterio Criterios de búsqueda (coEntidad, nuCnv, tipoDoc)
     * @param correlationId Identificador de correlación para trazabilidad
     * @return CertificadoNacidoVivo con los datos del certificado
     */
    CertificadoNacidoVivo consultar(CriterioBusqueda criterio, String correlationId);
}
