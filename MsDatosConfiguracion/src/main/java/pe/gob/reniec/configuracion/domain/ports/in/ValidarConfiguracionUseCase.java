package pe.gob.reniec.configuracion.domain.ports.in;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.model.ResultadoValidacion;

/**
 * Puerto de entrada - Validar configuración
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/validar
 */
public interface ValidarConfiguracionUseCase {

    /**
     * Valida una configuración propuesta
     *
     * @param clave Clave de la configuración a validar
     * @param valor Valor propuesto para validar
     * @param contexto Contexto de aplicación de la configuración
     * @param validarDependencias Validar configuraciones relacionadas
     * @return Resultado de la validación
     */
    ResultadoValidacion validar(
            String clave,
            Object valor,
            Configuracion.Contexto contexto,
            Boolean validarDependencias
    );
}
