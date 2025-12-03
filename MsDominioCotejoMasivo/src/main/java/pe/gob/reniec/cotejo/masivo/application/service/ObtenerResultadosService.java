package pe.gob.reniec.cotejo.masivo.application.service;

import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ObtenerResultadosUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionDataPort;

import java.util.List;

public class ObtenerResultadosService implements ObtenerResultadosUseCase {
    private final EjecucionDataPort ejecucionDataPort;

    public ObtenerResultadosService(EjecucionDataPort ejecucionDataPort) {
        this.ejecucionDataPort = ejecucionDataPort;
    }

    public ResultadoPaginado obtenerResultados(FiltrosResultados filtros) {
        Integer page = filtros.getPage() != null ? filtros.getPage() : 0;
        Integer size = filtros.getSize() != null ? filtros.getSize() : 100;
        
        if (size > 1000) {
            size = 1000;
        }
        
        List<ResultadoCotejo> resultados = ejecucionDataPort.obtenerResultados(
            filtros.getEjecucionId(),
            filtros.getCodigoResultado(),
            page,
            size
        );
        
        ResultadoPaginado resultado = new ResultadoPaginado();
        resultado.setResultados(resultados);
        resultado.setPaginaActual(page);
        resultado.setElementosPorPagina(size);
        resultado.setTotalElementos((long) resultados.size());
        resultado.setTotalPaginas((int) Math.ceil((double) resultados.size() / size));
        
        return resultado;
    }
}
