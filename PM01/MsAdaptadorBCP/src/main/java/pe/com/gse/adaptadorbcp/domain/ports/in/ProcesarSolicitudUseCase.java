package pe.com.gse.adaptadorbcp.domain.ports.in;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;

/**
 * Puerto de entrada: Caso de uso para procesar solicitudes hacia BCP
 * Mapeo: POST /api/v1/adaptador/procesar
 */
public interface ProcesarSolicitudUseCase {
    
    /**
     * Procesa una solicitud hacia BCP
     * @param solicitud La solicitud a procesar
     * @return La respuesta del BCP
     */
    RespuestaBCP procesar(SolicitudBCP solicitud);
}
