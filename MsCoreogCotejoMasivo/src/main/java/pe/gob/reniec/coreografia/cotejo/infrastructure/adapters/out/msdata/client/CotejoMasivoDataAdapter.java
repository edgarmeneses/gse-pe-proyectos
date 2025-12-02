package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.coreografia.cotejo.domain.model.RespuestaIniciarCotejo;
import pe.gob.reniec.coreografia.cotejo.domain.model.SolicitudCotejoMasivo;
import pe.gob.reniec.coreografia.cotejo.domain.ports.out.CotejoMasivoDataPort;

public class CotejoMasivoDataAdapter implements CotejoMasivoDataPort {

    @Override
    public RespuestaIniciarCotejo registrarSolicitudCotejoMasivo(SolicitudCotejoMasivo solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente: conexión con MsDatosCotejoMasivo");
    }
}
