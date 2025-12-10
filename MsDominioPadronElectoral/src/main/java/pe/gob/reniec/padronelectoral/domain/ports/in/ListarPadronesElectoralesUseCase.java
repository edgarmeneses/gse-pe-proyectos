package pe.gob.reniec.padronelectoral.domain.ports.in;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.model.PaginatedResult;

public interface ListarPadronesElectoralesUseCase {
    PaginatedResult<PadronElectoral> listar(String texto, String fecha, String queryParam3, 
                                            Integer page, Integer size);
}
