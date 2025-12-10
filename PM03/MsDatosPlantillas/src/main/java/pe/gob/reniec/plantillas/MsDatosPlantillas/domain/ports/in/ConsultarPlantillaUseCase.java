package pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.model.Plantilla;

public interface ConsultarPlantillaUseCase {
    Plantilla ejecutar(Plantilla plantilla);
}
