package pe.gob.reniec.coreografia.cotejo.application.service;

import pe.gob.reniec.coreografia.cotejo.domain.model.RespuestaIniciarCotejo;
import pe.gob.reniec.coreografia.cotejo.domain.model.SolicitudCotejoMasivo;
import pe.gob.reniec.coreografia.cotejo.domain.ports.in.IniciarCotejoMasivoUseCase;
import pe.gob.reniec.coreografia.cotejo.domain.ports.out.CotejoMasivoDataPort;

public class IniciarCotejoMasivoService implements IniciarCotejoMasivoUseCase {
    
    private final CotejoMasivoDataPort cotejoMasivoDataPort;

    public IniciarCotejoMasivoService(CotejoMasivoDataPort cotejoMasivoDataPort) {
        this.cotejoMasivoDataPort = cotejoMasivoDataPort;
    }

    @Override
    public RespuestaIniciarCotejo iniciarCotejoMasivo(SolicitudCotejoMasivo solicitud) {
        return cotejoMasivoDataPort.registrarSolicitudCotejoMasivo(solicitud);
    }
}
