package pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.out;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;

public interface PlantillaRepository {

    void consultarPlantilla(Plantilla plantilla);

    void crearPlantilla(Plantilla plantilla);

}
