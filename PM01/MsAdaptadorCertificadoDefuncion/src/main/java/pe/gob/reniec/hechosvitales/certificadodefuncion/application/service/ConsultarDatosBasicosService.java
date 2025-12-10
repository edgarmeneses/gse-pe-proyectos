package pe.gob.reniec.hechosvitales.certificadodefuncion.application.service;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in.ConsultarDatosBasicosUseCase;
import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.out.CertificadoDefuncionDataPort;

import java.util.List;

/**
 * Servicio de aplicación: Implementa el caso de uso de consulta de datos básicos
 * Orquesta la lógica de negocio y delega a los puertos de salida
 */
public class ConsultarDatosBasicosService implements ConsultarDatosBasicosUseCase {

    private final CertificadoDefuncionDataPort certificadoDefuncionDataPort;

    public ConsultarDatosBasicosService(CertificadoDefuncionDataPort certificadoDefuncionDataPort) {
        this.certificadoDefuncionDataPort = certificadoDefuncionDataPort;
    }

    @Override
    public List<CertificadoDefuncion> consultarDatosBasicos(
            String coEntidadConsulta, 
            String coTipoDocIdentidad, 
            String deDocIdentidad) {
        
        // Implementación stub: delega al puerto de salida
        return certificadoDefuncionDataPort.obtenerDatosBasicos(
            coEntidadConsulta, 
            coTipoDocIdentidad, 
            deDocIdentidad
        );
    }
}
