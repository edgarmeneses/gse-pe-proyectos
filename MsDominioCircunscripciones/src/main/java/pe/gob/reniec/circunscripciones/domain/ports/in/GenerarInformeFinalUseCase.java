package pe.gob.reniec.circunscripciones.domain.ports.in;

import pe.gob.reniec.circunscripciones.domain.model.InformeFinal;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.InformeFinalRequestDto;

public interface GenerarInformeFinalUseCase {

    InformeFinal generarInforme(InformeFinalRequestDto requestDto);
}
