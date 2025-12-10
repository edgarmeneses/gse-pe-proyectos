package pe.gob.reniec.pago.MsAdaptadorPagos.application.service;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in.ConsultarEstadoAdaptadoresUseCase;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out.AdaptadorStatusDataPort;
import java.util.List;

public class ConsultarEstadoAdaptadoresService implements ConsultarEstadoAdaptadoresUseCase {

    private final AdaptadorStatusDataPort adaptadorStatusDataPort;

    public ConsultarEstadoAdaptadoresService(AdaptadorStatusDataPort adaptadorStatusDataPort) {
        this.adaptadorStatusDataPort = adaptadorStatusDataPort;
    }

    @Override
    public List<AdaptadorBancario> consultar() {
        return adaptadorStatusDataPort.obtenerEstado();
    }
}
