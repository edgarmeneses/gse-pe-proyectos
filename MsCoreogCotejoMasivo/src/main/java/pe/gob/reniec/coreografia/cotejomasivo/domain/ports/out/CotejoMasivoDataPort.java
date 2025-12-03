package pe.gob.reniec.coreografia.cotejomasivo.domain.ports.out;

import pe.gob.reniec.coreografia.cotejomasivo.domain.model.EventoGenerado;
import pe.gob.reniec.coreografia.cotejomasivo.domain.model.Prioridad;
import pe.gob.reniec.coreografia.cotejomasivo.domain.model.SolicitudCotejoMasivo;
import java.util.List;

/**
 * Puerto de salida - Interface para integración con MsDominioCotejoMasivo y MsDatosCotejoMasivo
 * Este puerto define las operaciones necesarias para coordinar el flujo asíncrono
 * sin especificar el protocolo de comunicación (puede ser Kafka, HTTP, etc.)
 */
public interface CotejoMasivoDataPort {
    
    /**
     * Publica evento de inicio de cotejo masivo
     * 
     * @param solicitud Solicitud de cotejo masivo
     * @param correlationId ID de correlación para trazabilidad
     * @return Lista de eventos generados
     */
    List<EventoGenerado> publicarEventoInicioCotejo(SolicitudCotejoMasivo solicitud, String correlationId);
    
    /**
     * Valida la existencia de la entidad solicitante
     * 
     * @param codigoEntidad Código de la entidad solicitante
     * @return true si la entidad existe, false en caso contrario
     */
    Boolean validarEntidadSolicitante(String codigoEntidad);
    
    /**
     * Verifica si existe una solicitud con el mismo número
     * 
     * @param numeroSolicitud Número de solicitud a verificar
     * @return true si existe, false en caso contrario
     */
    Boolean existeSolicitud(String numeroSolicitud);
    
    /**
     * Verifica si existe una solicitud con la misma clave de idempotencia
     * 
     * @param idempotencyKey Clave de idempotencia
     * @return true si existe, false en caso contrario
     */
    Boolean existeSolicitudPorIdempotencyKey(String idempotencyKey);
    
    /**
     * Registra la solicitud de cotejo masivo
     * 
     * @param solicitud Solicitud a registrar
     * @param officeCode Código de oficina
     * @param userRole Rol del usuario
     * @param idempotencyKey Clave de idempotencia
     * @return ID de la solicitud registrada
     */
    String registrarSolicitud(SolicitudCotejoMasivo solicitud, String officeCode, String userRole, String idempotencyKey);
    
    /**
     * Calcula el tiempo estimado de procesamiento
     * 
     * @param totalRegistros Total de registros a procesar
     * @param prioridad Prioridad de la solicitud (enum del dominio)
     * @return Tiempo estimado en formato ISO 8601 Duration
     */
    String calcularTiempoEstimado(Integer totalRegistros, Prioridad prioridad);
    
    /**
     * Obtiene información de la oficina
     * 
     * @param officeCode Código de oficina
     * @return Nombre de la oficina
     */
    String obtenerNombreOficina(String officeCode);
}
