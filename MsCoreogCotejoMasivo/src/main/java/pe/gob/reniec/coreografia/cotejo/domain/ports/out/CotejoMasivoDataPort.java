package pe.gob.reniec.coreografia.cotejo.domain.ports.out;

import pe.gob.reniec.coreografia.cotejo.domain.model.RespuestaIniciarCotejo;
import pe.gob.reniec.coreografia.cotejo.domain.model.SolicitudCotejoMasivo;

public interface CotejoMasivoDataPort {
    RespuestaIniciarCotejo registrarSolicitudCotejoMasivo(SolicitudCotejoMasivo solicitud);
}
