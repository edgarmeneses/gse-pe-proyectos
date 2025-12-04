package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;

public interface ConsultarImpugnacionUseCase {
    Impugnacion consultarPorId(Long id);
}
