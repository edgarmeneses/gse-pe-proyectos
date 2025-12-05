package pe.gob.reniec.adaptadorbanconacion.application.service;

import pe.gob.reniec.adaptadorbanconacion.domain.model.SolicitudValidacion;
import pe.gob.reniec.adaptadorbanconacion.domain.model.Validacion;
import pe.gob.reniec.adaptadorbanconacion.domain.ports.in.ValidarPagoBancoNacionUseCase;
import pe.gob.reniec.adaptadorbanconacion.domain.ports.out.BancoNacionPort;

public class ValidarPagoBancoNacionService implements ValidarPagoBancoNacionUseCase {

    private final BancoNacionPort bancoNacionPort;

    public ValidarPagoBancoNacionService(BancoNacionPort bancoNacionPort) {
        this.bancoNacionPort = bancoNacionPort;
    }

    @Override
    public Validacion validar(SolicitudValidacion solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
