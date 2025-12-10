package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.ports.out;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.CertificadoDefuncion;
import java.util.List;

/**
 * Puerto de salida: Integración con WS-CDEF de RENIEC
 * Este puerto abstrae la comunicación con el Web Service externo de Certificados de Defunción
 */
public interface CertificadoDefuncionDataPort {

    /**
     * Consulta datos básicos desde WS-CDEF (método: obtener_datos_cdef)
     * 
     * @param coEntidadConsulta Código de institución que consulta (RUC)
     * @param coTipoDocIdentidad Código para el tipo de documento de identidad
     * @param deDocIdentidad Número de documento de identidad del fallecido
     * @return Lista de certificados con datos básicos
     */
    List<CertificadoDefuncion> obtenerDatosBasicos(
        String coEntidadConsulta, 
        String coTipoDocIdentidad, 
        String deDocIdentidad
    );

    /**
     * Consulta detalle completo desde WS-CDEF (método: obtener_cdef_detalle)
     * 
     * @param coEntidadConsulta Código de institución que consulta (RUC)
     * @param coTipoDocIdentidad Código para el tipo de documento de identidad
     * @param deDocIdentidad Número de documento de identidad del fallecido
     * @return Lista de certificados con información completa
     */
    List<CertificadoDefuncion> obtenerDetalleCompleto(
        String coEntidadConsulta, 
        String coTipoDocIdentidad, 
        String deDocIdentidad
    );
}
