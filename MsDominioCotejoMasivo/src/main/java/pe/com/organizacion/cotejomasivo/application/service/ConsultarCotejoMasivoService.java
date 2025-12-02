package pe.com.organizacion.cotejomasivo.application.service;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.ports.in.ConsultarCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.domain.ports.out.CotejoMasivoDataPort;

/**
 * Servicio de aplicación: ConsultarCotejoMasivoService
 * Implementa el caso de uso para consultar el estado de un cotejo masivo
 */
public class ConsultarCotejoMasivoService implements ConsultarCotejoMasivoUseCase {
    
    private final CotejoMasivoDataPort cotejoMasivoDataPort;
    
    public ConsultarCotejoMasivoService(CotejoMasivoDataPort cotejoMasivoDataPort) {
        this.cotejoMasivoDataPort = cotejoMasivoDataPort;
    }
    
    @Override
    public CotejoMasivo consultar(String idEjecucion) {
        // Delegar la consulta al puerto de salida (MsDataCotejoMasivo)
        return cotejoMasivoDataPort.consultarPorId(idEjecucion);
    }
}
