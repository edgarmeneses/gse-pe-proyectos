package pe.com.gse.adaptadorbcp.domain.ports.out;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;

/**
 * Puerto de salida: BCPDataPort
 * Interfaz para comunicación con servicios externos del BCP
 * 
 * Tipo: MsDominio - DataPort para integración con sistema externo
 */
public interface BCPDataPort {
    
    /**
     * Envía una solicitud al BCP y obtiene la respuesta
     * @param solicitud La solicitud a enviar
     * @return La respuesta del BCP
     */
    RespuestaBCP enviarSolicitud(SolicitudBCP solicitud);
}
