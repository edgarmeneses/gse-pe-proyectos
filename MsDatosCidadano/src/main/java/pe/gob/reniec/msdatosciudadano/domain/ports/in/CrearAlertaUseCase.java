package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;

public interface CrearAlertaUseCase {
    String crear(Alerta alerta);
}
