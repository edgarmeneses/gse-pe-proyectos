package pe.gob.reniec.validadordocumentos.domain.ports.in;

import pe.gob.reniec.validadordocumentos.domain.model.EvaluacionDocumento;

/**
 * Puerto de entrada (Use Case) para registrar una evaluación de documento en el sistema.
 * Define el contrato para la operación de persistencia de evaluaciones.
 */
public interface RegistrarEvaluacionDocumentoUseCase {

    /**
     * Registra una evaluación completa de documento en la base de datos.
     *
     * @param evaluacionDocumento Evaluación a registrar con todos sus datos
     * @return Evaluación registrada con información de persistencia
     */
    EvaluacionDocumento registrar(EvaluacionDocumento evaluacionDocumento);
}
