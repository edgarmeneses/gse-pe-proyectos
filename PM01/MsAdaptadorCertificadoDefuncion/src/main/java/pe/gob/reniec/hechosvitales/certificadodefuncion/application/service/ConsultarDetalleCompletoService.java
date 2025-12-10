package pe.gob.reniec.hechosvitales.certificadodefuncion.application.service;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in.ConsultarDetalleCompletoUseCase;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.out.CertificadoDefuncionDataPort;

import java.util.List;

/**
 * Servicio de aplicación: Implementa el caso de uso de consulta de detalle completo
 * Orquesta la lógica de negocio y delega a los puertos de salida
 */
public class ConsultarDetalleCompletoService implements ConsultarDetalleCompletoUseCase {

    private final CertificadoDefuncionDataPort certificadoDefuncionDataPort;

    public ConsultarDetalleCompletoService(CertificadoDefuncionDataPort certificadoDefuncionDataPort) {
        this.certificadoDefuncionDataPort = certificadoDefuncionDataPort;
    }

    @Override
    public List<CertificadoDefuncion> consultarDetalleCompleto(
            String coEntidadConsulta, 
            String coTipoDocIdentidad, 
            String deDocIdentidad) {
        
        // Implementación stub: delega al puerto de salida
        return certificadoDefuncionDataPort.obtenerDetalleCompleto(
            coEntidadConsulta, 
            coTipoDocIdentidad, 
            deDocIdentidad
        );
    }
}
