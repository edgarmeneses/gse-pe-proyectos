package pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;

public interface RoutearValidacionPagoUseCase {
    ValidacionPago routear(ValidacionPago validacion);
}
