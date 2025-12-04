package pe.gob.onpe.dominio.paquetes.domain.ports.in;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import java.util.List;

public interface ConsultarPaquetesUseCase {
    List<PaqueteElectoral> consultar(String idPadron, String tipoPadron, String codigoDepartamento,
                                     String codigoProvincia, String codigoDistrito, String estadoPaquete,
                                     Integer pagina, Integer registrosPorPagina);
}
