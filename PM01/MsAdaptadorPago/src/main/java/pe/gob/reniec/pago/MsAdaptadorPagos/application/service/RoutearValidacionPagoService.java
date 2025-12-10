package pe.gob.reniec.pago.MsAdaptadorPagos.application.service;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in.RoutearValidacionPagoUseCase;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.out.ValidacionPagoDataPort;

public class RoutearValidacionPagoService implements RoutearValidacionPagoUseCase {

    private final ValidacionPagoDataPort validacionPagoDataPort;

    public RoutearValidacionPagoService(ValidacionPagoDataPort validacionPagoDataPort) {
        this.validacionPagoDataPort = validacionPagoDataPort;
    }

    @Override
    public ValidacionPago routear(ValidacionPago validacion) {
        // Lógica de dominio: Identificar banco, aplicar políticas, etc.
        // Por ahora delegamos al puerto de salida
        return validacionPagoDataPort.validar(validacion);
    }
}
