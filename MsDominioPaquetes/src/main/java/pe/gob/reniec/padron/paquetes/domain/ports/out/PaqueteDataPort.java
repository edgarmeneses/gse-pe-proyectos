package pe.gob.reniec.padron.paquetes.domain.ports.out;

import pe.gob.reniec.padron.paquetes.domain.model.AprobacionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConfirmacionRevisionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConsultaPaquetesResult;
import pe.gob.reniec.padron.paquetes.domain.model.InformacionPublicacion;

/**
 * Puerto de salida para integración con MsDatosPaquetesElectorales.
 * Este puerto define las operaciones necesarias para interactuar con el microservicio de datos.
 * No define protocolo de comunicación (HTTP/SOAP/Colas).
 */
public interface PaqueteDataPort {
    
    /**
     * Consulta paquetes electorales según los filtros especificados.
     */
    ConsultaPaquetesResult consultarPaquetes(String idPadron, String tipoPadron, 
                                             String codigoDepartamento, String codigoProvincia,
                                             String codigoDistrito, String estadoPaquete,
                                             int pagina, int registrosPorPagina);
    
    /**
     * Aprueba un paquete electoral específico.
     */
    AprobacionResult aprobarPaquete(String paqueteId, InformacionPublicacion informacionPublicacion,
                                    String comentarioAprobacion, Boolean confirmarIntegridad);
    
    /**
     * Confirma la revisión completa de todos los paquetes de un padrón.
     */
    ConfirmacionRevisionResult confirmarRevisionPaquetes(String idPadron, String tipoPadron,
                                                         String comentarioConfirmacion,
                                                         Boolean confirmarRevisionCompleta);
}
