package pe.gob.onpe.dominio.paquetes.application.service;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import pe.gob.onpe.dominio.paquetes.domain.ports.in.ConsultarPaquetesUseCase;
import pe.gob.onpe.dominio.paquetes.domain.ports.out.PadronElectoralDataPort;
import java.util.List;

public class ConsultarPaquetesService implements ConsultarPaquetesUseCase {
    private final PadronElectoralDataPort padronElectoralDataPort;

    public ConsultarPaquetesService(PadronElectoralDataPort padronElectoralDataPort) {
        this.padronElectoralDataPort = padronElectoralDataPort;
    }

    @Override
    public List<PaqueteElectoral> consultar(String idPadron, String tipoPadron, String codigoDepartamento,
                                            String codigoProvincia, String codigoDistrito, String estadoPaquete,
                                            Integer pagina, Integer registrosPorPagina) {
        return padronElectoralDataPort.consultarPaquetes(idPadron, tipoPadron, codigoDepartamento,
                codigoProvincia, codigoDistrito, estadoPaquete, pagina, registrosPorPagina);
    }
}
