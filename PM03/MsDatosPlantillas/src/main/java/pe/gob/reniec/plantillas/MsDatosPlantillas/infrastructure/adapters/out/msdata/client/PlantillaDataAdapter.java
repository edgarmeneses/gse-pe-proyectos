package pe.gob.reniec.plantillas.MsDatosPlantillas.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.out.PlantillaRepository;

public class PlantillaDataAdapter implements PlantillaRepository {
    @Override
    public void consultarPlantilla(Plantilla plantilla) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void crearPlantilla(Plantilla plantilla) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
