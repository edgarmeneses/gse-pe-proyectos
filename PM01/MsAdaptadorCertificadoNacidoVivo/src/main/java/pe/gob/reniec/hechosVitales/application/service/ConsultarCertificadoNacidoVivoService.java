package pe.gob.reniec.hechosVitales.application.service;

import pe.gob.reniec.hechosVitales.domain.model.CertificadoNacidoVivo;
import pe.gob.reniec.hechosVitales.domain.model.CriterioBusqueda;
import pe.gob.reniec.hechosVitales.domain.ports.in.ConsultarCertificadoNacidoVivoUseCase;
import pe.gob.reniec.hechosVitales.domain.ports.out.CertificadoNacidoVivoDataPort;

/**
 * Servicio de Aplicación: ConsultarCertificadoNacidoVivoService
 * 
 * Implementa el caso de uso de consulta de certificado de nacido vivo.
 * Orquesta la lógica de negocio y delega la integración al puerto de salida.
 */
public class ConsultarCertificadoNacidoVivoService implements ConsultarCertificadoNacidoVivoUseCase {
    
    private final CertificadoNacidoVivoDataPort certificadoDataPort;
    
    public ConsultarCertificadoNacidoVivoService(CertificadoNacidoVivoDataPort certificadoDataPort) {
        this.certificadoDataPort = certificadoDataPort;
    }
    
    @Override
    public CertificadoNacidoVivo consultar(CriterioBusqueda criterio, String correlationId) {
        // La validación de parámetros ya se realiza en el constructor de CriterioBusqueda (Value Object)
        // Aquí podríamos agregar validaciones de negocio adicionales si fuera necesario.
        
        // Delegación al puerto de salida para consulta externa
        return certificadoDataPort.consultarDesdeMinsa(criterio, correlationId);
    }
}
