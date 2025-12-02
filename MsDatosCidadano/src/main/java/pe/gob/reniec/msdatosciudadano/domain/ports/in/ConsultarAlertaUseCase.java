package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;

public interface ConsultarAlertaUseCase {
    Alerta consultar(String alertaId);
}
