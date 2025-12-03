package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Verificacion;

/**
 * Puerto de salida: Comunicación con MsDataValidadorDocumentos para persistir verificaciones
 * Este es un microservicio de DOMINIO, por lo que NO define RepositoryPort.
 * Define puertos de salida hacia MsData para operaciones de persistencia.
 */
public interface VerificacionDataPort {
    
    /**
     * Guarda una verificación de firma en el sistema de datos
     * 
     * @param verificacion Verificación a guardar
     * @return Verificación guardada con el ID generado
     */
    Verificacion guardarVerificacion(Verificacion verificacion);
    
    /**
     * Consulta una verificación por su ID
     * 
     * @param verificacionId ID de la verificación
     * @return Verificación encontrada o null si no existe
     */
    Verificacion consultarVerificacionPorId(String verificacionId);
    
    /**
     * Consulta verificaciones por solicitud
     * 
     * @param solicitudId ID de la solicitud
     * @return Lista de verificaciones de la solicitud
     */
    java.util.List<Verificacion> consultarVerificacionesPorSolicitud(String solicitudId);
}
