package pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;

public interface ValidacionPagoDataPort {
    ValidacionPago validar(ValidacionPago validacion);
}
