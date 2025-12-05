package pe.gob.reniec.circunscripciones.domain.ports.in;

import pe.gob.reniec.circunscripciones.domain.model.ListadoVisitas;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.ListadoVisitasRequestDto;

public interface GenerarListadosVisitasUseCase {

    ListadoVisitas generarListados(ListadoVisitasRequestDto requestDto);
}
