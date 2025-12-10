package pe.gob.reniec.plantillas.MsDatosPlantillas.application.service;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in.CrearPlantillaUseCase;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.out.PlantillaRepository;

public class CrearPlantillaService implements CrearPlantillaUseCase {
    private final PlantillaRepository repository;

    public CrearPlantillaService(PlantillaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Plantilla ejecutar(Plantilla plantilla) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
