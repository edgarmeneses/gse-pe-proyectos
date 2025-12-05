package pe.gob.reniec.circunscripciones.application.service;

import pe.gob.reniec.circunscripciones.domain.model.AnalisisCircunscripcion;
import pe.gob.reniec.circunscripciones.domain.ports.in.AnalisisCircunscripcionesUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.out.CircunscripcionDataPort;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.AnalisisCircunscripcionRequestDto;

public class AnalisisCircunscripcionesService implements AnalisisCircunscripcionesUseCase {

    private final CircunscripcionDataPort circunscripcionDataPort;

    public AnalisisCircunscripcionesService(CircunscripcionDataPort circunscripcionDataPort) {
        this.circunscripcionDataPort = circunscripcionDataPort;
    }

    @Override
    public AnalisisCircunscripcion ejecutarAnalisis(AnalisisCircunscripcionRequestDto requestDto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
