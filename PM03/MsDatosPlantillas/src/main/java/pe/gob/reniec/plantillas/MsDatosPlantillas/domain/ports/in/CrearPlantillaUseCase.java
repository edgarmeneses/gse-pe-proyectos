package pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;

public interface CrearPlantillaUseCase {
    Plantilla ejecutar(Plantilla plantilla);
}
