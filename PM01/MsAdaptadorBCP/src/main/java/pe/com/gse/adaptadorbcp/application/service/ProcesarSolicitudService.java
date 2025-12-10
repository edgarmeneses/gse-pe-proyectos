package pe.com.gse.adaptadorbcp.application.service;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;
import pe.com.gse.adaptadorbcp.domain.ports.in.ProcesarSolicitudUseCase;
import pe.com.gse.adaptadorbcp.domain.ports.out.BCPDataPort;

/**
 * Servicio de aplicación: ProcesarSolicitudService
 * Implementa el caso de uso de procesar solicitudes hacia BCP
 */
public class ProcesarSolicitudService implements ProcesarSolicitudUseCase {
    
    private final BCPDataPort bcpDataPort;
    
    public ProcesarSolicitudService(BCPDataPort bcpDataPort) {
        this.bcpDataPort = bcpDataPort;
    }
    
    @Override
    public RespuestaBCP procesar(SolicitudBCP solicitud) {
        // Implementación stub - Lógica de negocio pendiente
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
