package pe.gob.reniec.msdatosciudadano.domain.ports.out;

import pe.gob.reniec.msdatosciudadano.domain.model.CotejoMasivo;

public interface CotejoMasivoRepositoryPort {
    CotejoMasivo procesar(CotejoMasivo cotejoMasivo);
}
