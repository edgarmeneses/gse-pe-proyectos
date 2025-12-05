package pe.gob.reniec.circunscripciones.application.service;

import pe.gob.reniec.circunscripciones.domain.model.ListadoVisitas;
import pe.gob.reniec.circunscripciones.domain.ports.in.GenerarListadosVisitasUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.out.ListadoDataPort;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.ListadoVisitasRequestDto;

public class GenerarListadosVisitasService implements GenerarListadosVisitasUseCase {

    private final ListadoDataPort listadoDataPort;

    public GenerarListadosVisitasService(ListadoDataPort listadoDataPort) {
        this.listadoDataPort = listadoDataPort;
    }

    @Override
    public ListadoVisitas generarListados(ListadoVisitasRequestDto requestDto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
