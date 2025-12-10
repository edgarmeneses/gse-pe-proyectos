package pe.gob.reniec.plantillas.MsDatosPlantillas.application.service;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in.ConsultarPlantillaUseCase;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.out.PlantillaRepository;

public class ConsultarPlantillaService implements ConsultarPlantillaUseCase {
    private final PlantillaRepository repository;

    public ConsultarPlantillaService(PlantillaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Plantilla ejecutar(Plantilla plantilla) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
