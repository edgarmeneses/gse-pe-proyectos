package pe.gob.reniec.circunscripciones.application.service;

import pe.gob.reniec.circunscripciones.domain.model.InformeFinal;
import pe.gob.reniec.circunscripciones.domain.ports.in.GenerarInformeFinalUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.out.InformeDataPort;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.InformeFinalRequestDto;

public class GenerarInformeFinalService implements GenerarInformeFinalUseCase {

    private final InformeDataPort informeDataPort;

    public GenerarInformeFinalService(InformeDataPort informeDataPort) {
        this.informeDataPort = informeDataPort;
    }

    @Override
    public InformeFinal generarInforme(InformeFinalRequestDto requestDto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
