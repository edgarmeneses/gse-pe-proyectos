package pe.gob.reniec.hechosVitales.domain.ports.out;

import pe.gob.reniec.hechosVitales.domain.model.CertificadoNacidoVivo;
import pe.gob.reniec.hechosVitales.domain.model.CriterioBusqueda;

/**
 * Puerto de salida: CertificadoNacidoVivoDataPort
 * 
 * Define la interfaz para integración con el servicio externo de
 * Hechos Vitales del Ministerio de Salud (MINSA).
 * 
 * Este es un MsDominio (adaptador), por lo tanto usa DataPort
 * para comunicación con sistemas externos.
 */
public interface CertificadoNacidoVivoDataPort {
    
    /**
     * Consulta un certificado de nacido vivo del sistema externo MINSA.
     * 
     * @param criterio Criterios de búsqueda
     * @param correlationId Identificador de correlación
     * @return CertificadoNacidoVivo con los datos obtenidos del MINSA
     */
    CertificadoNacidoVivo consultarDesdeMinsa(CriterioBusqueda criterio, String correlationId);
}
