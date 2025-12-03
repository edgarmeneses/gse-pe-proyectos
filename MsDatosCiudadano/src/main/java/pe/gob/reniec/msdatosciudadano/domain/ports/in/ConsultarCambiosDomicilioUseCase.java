package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.CambioDomicilio;
import java.util.List;

public interface ConsultarCambiosDomicilioUseCase {
    List<CambioDomicilio> consultar(String fechaDesde, String fechaHasta, String circunscripcionId, 
                                     String queryParam1, String queryParam2, String queryParam3);
}
