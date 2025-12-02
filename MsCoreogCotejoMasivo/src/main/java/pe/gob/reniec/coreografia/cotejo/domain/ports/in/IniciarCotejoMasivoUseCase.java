package pe.gob.reniec.coreografia.cotejo.domain.ports.in;

import pe.gob.reniec.coreografia.cotejo.domain.model.RespuestaIniciarCotejo;
import pe.gob.reniec.coreografia.cotejo.domain.model.SolicitudCotejoMasivo;

public interface IniciarCotejoMasivoUseCase {
    RespuestaIniciarCotejo iniciarCotejoMasivo(SolicitudCotejoMasivo solicitud);
}
