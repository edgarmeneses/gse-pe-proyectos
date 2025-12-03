package pe.gob.reniec.msdatosciudadano.domain.ports.out;

import pe.gob.reniec.msdatosciudadano.domain.model.ConsultaMasiva;

public interface ConsultaMasivaRepositoryPort {
    ConsultaMasiva procesar(ConsultaMasiva consultaMasiva);
}
