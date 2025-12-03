package pe.gob.reniec.msdatosciudadano.domain.ports.in;

import pe.gob.reniec.msdatosciudadano.domain.model.CotejoMasivo;

public interface ConsultaMasivaUseCase {
    CotejoMasivo procesar(CotejoMasivo cotejoMasivo);
}
