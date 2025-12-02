package pe.com.organizacion.cotejomasivo.application.service;

import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;
import pe.com.organizacion.cotejomasivo.domain.ports.in.ObtenerResultadosCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.domain.ports.out.CotejoMasivoDataPort;

/**
 * Servicio de aplicación: ObtenerResultadosCotejoMasivoService
 * Implementa el caso de uso para obtener resultados de un cotejo masivo
 */
public class ObtenerResultadosCotejoMasivoService implements ObtenerResultadosCotejoMasivoUseCase {
    
    private final CotejoMasivoDataPort cotejoMasivoDataPort;
    
    public ObtenerResultadosCotejoMasivoService(CotejoMasivoDataPort cotejoMasivoDataPort) {
        this.cotejoMasivoDataPort = cotejoMasivoDataPort;
    }
    
    @Override
    public ResultadosPaginados obtenerResultados(String idEjecucion, Long pagina, Long tamanio, String estadoCotejo) {
        // Aplicar valores por defecto si no se proporcionan
        Long paginaFinal = (pagina != null) ? pagina : 0L;
        Long tamanioFinal = (tamanio != null) ? tamanio : 100L;
        
        // Delegar la obtención de resultados al puerto de salida (MsDataCotejoMasivo)
        return cotejoMasivoDataPort.obtenerResultados(idEjecucion, paginaFinal, tamanioFinal, estadoCotejo);
    }
}
