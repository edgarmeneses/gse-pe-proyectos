package pe.gob.reniec.circunscripciones.domain.ports.in;

import pe.gob.reniec.circunscripciones.domain.model.AnalisisCircunscripcion;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.AnalisisCircunscripcionRequestDto;

public interface AnalisisCircunscripcionesUseCase {

    AnalisisCircunscripcion ejecutarAnalisis(AnalisisCircunscripcionRequestDto requestDto);
}
