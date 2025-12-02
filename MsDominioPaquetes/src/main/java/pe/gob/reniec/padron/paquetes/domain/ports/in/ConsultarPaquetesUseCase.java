package pe.gob.reniec.padron.paquetes.domain.ports.in;

import pe.gob.reniec.padron.paquetes.domain.model.ConsultaPaquetesResult;

public interface ConsultarPaquetesUseCase {
    
    ConsultaPaquetesResult consultar(String idPadron, String tipoPadron, String codigoDepartamento,
                                     String codigoProvincia, String codigoDistrito, 
                                     String estadoPaquete, int pagina, int registrosPorPagina);
}
