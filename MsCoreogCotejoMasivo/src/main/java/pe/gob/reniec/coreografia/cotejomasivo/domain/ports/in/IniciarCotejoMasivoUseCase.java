package pe.gob.reniec.coreografia.cotejomasivo.domain.ports.in;

import pe.gob.reniec.coreografia.cotejomasivo.domain.model.ResultadoRegistroSolicitud;
import pe.gob.reniec.coreografia.cotejomasivo.domain.model.SolicitudCotejoMasivo;

/**
 * Puerto de entrada - Caso de uso para iniciar el proceso de cotejo masivo
 */
public interface IniciarCotejoMasivoUseCase {
    
    /**
     * Inicia el proceso de cotejo masivo de forma síncrona
     * 
     * @param solicitud Solicitud completa de cotejo masivo
     * @param correlationId ID de correlación para trazabilidad
     * @param officeCode Código de oficina desde donde se realiza la operación
     * @param userRole Rol del usuario que realiza la operación
     * @param requestSource Origen de la solicitud (WEB, API_EXTERNA, BATCH)
     * @param idempotencyKey Clave para evitar procesamientos duplicados
     * @return ResultadoRegistroSolicitud con información de la solicitud creada
     */
    ResultadoRegistroSolicitud iniciarCotejo(
        SolicitudCotejoMasivo solicitud,
        String correlationId,
        String officeCode,
        String userRole,
        String requestSource,
        String idempotencyKey
    );
}
