package pe.gob.reniec.padronelectoral.application.service;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.model.PaginatedResult;
import pe.gob.reniec.padronelectoral.domain.ports.in.ListarPadronesElectoralesUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.out.PadronElectoralDataPort;

public class ListarPadronesElectoralesService implements ListarPadronesElectoralesUseCase {
    
    private final PadronElectoralDataPort padronElectoralDataPort;

    public ListarPadronesElectoralesService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public PaginatedResult<PadronElectoral> listar(String texto, String fecha, String queryParam3, 
                                                   Integer page, Integer size) {
        return padronElectoralDataPort.listarPadrones(texto, fecha, queryParam3, page, size);
    }
}
