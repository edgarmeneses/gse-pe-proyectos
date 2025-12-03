package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.ConsultaMasiva;

public interface ConsultaMasivaUseCase {
    ConsultaMasiva procesar(ConsultaMasiva consultaMasiva);
}
