package pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.ports.in.CrearSolicitudAdministrativaUseCase;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.infrastructure.adapters.in.rest.dto.SolicitudAdministrativaDto;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.model.SolicitudAdministrativa;

public class SolicitudAdministrativaController {
   private final CrearSolicitudAdministrativaUseCase useCase;

   public SolicitudAdministrativaController(CrearSolicitudAdministrativaUseCase useCase) {
    this.useCase = useCase;
   }

   public SolicitudAdministrativa crearSolicitudAdministrativa(SolicitudAdministrativaDto dto) {
     return useCase.ejecutar(dto);
   }
}
