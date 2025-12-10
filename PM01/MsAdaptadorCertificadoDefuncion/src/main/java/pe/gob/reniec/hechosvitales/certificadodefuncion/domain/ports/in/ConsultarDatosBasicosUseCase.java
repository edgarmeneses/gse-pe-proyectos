package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import java.util.List;

/**
 * Puerto de entrada: Caso de uso para consultar datos básicos de certificados de defunción
 * Endpoint: POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/datos-basicos
 */
public interface ConsultarDatosBasicosUseCase {

    /**
     * Consulta datos básicos de certificados de defunción en estado VIGENTE
     * 
     * @param coEntidadConsulta Código de institución que consulta (RUC)
     * @param coTipoDocIdentidad Código para el tipo de documento de identidad
     * @param deDocIdentidad Número de documento de identidad del fallecido
     * @return Lista de certificados encontrados
     */
    List<CertificadoDefuncion> consultarDatosBasicos(
        String coEntidadConsulta, 
        String coTipoDocIdentidad, 
        String deDocIdentidad
    );
}
