package pe.gob.reniec.padron.paquetes.application.service;

import pe.gob.reniec.padron.paquetes.domain.model.ConsultaPaquetesResult;
import pe.gob.reniec.padron.paquetes.domain.ports.in.ConsultarPaquetesUseCase;
import pe.gob.reniec.padron.paquetes.domain.ports.out.PaqueteDataPort;

public class ConsultarPaquetesService implements ConsultarPaquetesUseCase {

    private final PaqueteDataPort paqueteDataPort;

    public ConsultarPaquetesService(PaqueteDataPort paqueteDataPort) {
        this.paqueteDataPort = paqueteDataPort;
    }

    @Override
    public ConsultaPaquetesResult consultar(String idPadron, String tipoPadron, String codigoDepartamento,
                                           String codigoProvincia, String codigoDistrito,
                                           String estadoPaquete, int pagina, int registrosPorPagina) {
        // Validaciones de negocio podrían ir aquí
        
        // Delega al puerto de salida para obtener los datos
        return paqueteDataPort.consultarPaquetes(idPadron, tipoPadron, codigoDepartamento,
                codigoProvincia, codigoDistrito, estadoPaquete, pagina, registrosPorPagina);
    }
}
