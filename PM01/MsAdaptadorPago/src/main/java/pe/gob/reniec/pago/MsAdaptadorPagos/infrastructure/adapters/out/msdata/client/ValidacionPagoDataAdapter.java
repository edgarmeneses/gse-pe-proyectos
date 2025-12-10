package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out.ValidacionPagoDataPort;

public class ValidacionPagoDataAdapter implements ValidacionPagoDataPort {

    @Override
    public ValidacionPago validar(ValidacionPago validacion) {
        throw new UnsupportedOperationException("Integración con adaptadores bancarios pendiente");
    }
}
