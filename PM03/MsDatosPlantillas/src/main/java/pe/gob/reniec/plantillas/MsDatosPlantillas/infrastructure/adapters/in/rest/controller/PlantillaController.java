package pe.gob.reniec.plantillas.MsDatosPlantillas.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in.ConsultarPlantillaUseCase;
import pe.gob.reniec.plantillas.MsDatosPlantillas.domain.ports.in.CrearPlantillaUseCase;
import pe.gob.reniec.plantillas.MsDatosPlantillas.infrastructure.adapters.in.rest.dto.PlantillaDto;

public class PlantillaController {
   private final ConsultarPlantillaUseCase consultarPlantillaUseCase;
   private final CrearPlantillaUseCase crearPlantillaUseCase;

   public PlantillaController(ConsultarPlantillaUseCase consultarPlantillaUseCase, CrearPlantillaUseCase crearPlantillaUseCase) {
    this.consultarPlantillaUseCase = consultarPlantillaUseCase;
    this.crearPlantillaUseCase = crearPlantillaUseCase;
   }

   public void consultarPlantilla() {
     // Pendiente de implementación
     throw new UnsupportedOperationException("Pendiente de implementación");
   }

   public void crearPlantilla() {
     // Pendiente de implementación
     throw new UnsupportedOperationException("Pendiente de implementación");
   }
}
