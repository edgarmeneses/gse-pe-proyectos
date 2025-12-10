package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.in;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import java.util.List;

/**
 * Puerto de entrada: Caso de uso para consultar detalle completo de certificados de defunción
 * Endpoint: POST /api/v1/hechosVitales/MsAdaptadorCertificadoDefuncion/detalle-completo
 */
public interface ConsultarDetalleCompletoUseCase {

    /**
     * Consulta el detalle completo de certificados de defunción en estado VIGENTE o EDITADO
     * 
     * @param coEntidadConsulta Código de institución que consulta (RUC)
     * @param coTipoDocIdentidad Código para el tipo de documento de identidad
     * @param deDocIdentidad Número de documento de identidad del fallecido
     * @return Lista de certificados con información completa
     */
    List<CertificadoDefuncion> consultarDetalleCompleto(
        String coEntidadConsulta, 
        String coTipoDocIdentidad, 
        String deDocIdentidad
    );
}
