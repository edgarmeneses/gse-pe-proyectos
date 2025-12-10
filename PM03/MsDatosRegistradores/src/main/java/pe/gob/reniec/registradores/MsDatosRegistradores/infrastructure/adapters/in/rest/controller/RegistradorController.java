package pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in.ConsultarRegistradorUseCase;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in.ActualizarRegistradorUseCase;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.in.rest.dto.RegistradorDto;

public class RegistradorController {
   private final ConsultarRegistradorUseCase consultarRegistradorUseCase;
   private final ActualizarRegistradorUseCase actualizarRegistradorUseCase;
   private final CrearRegistradorUseCase crearRegistradorUseCase;

   public RegistradorController(ConsultarRegistradorUseCase consultarRegistradorUseCase, ActualizarRegistradorUseCase actualizarRegistradorUseCase, CrearRegistradorUseCase crearRegistradorUseCase) {
    this.consultarRegistradorUseCase = consultarRegistradorUseCase;
    this.actualizarRegistradorUseCase = actualizarRegistradorUseCase;
    this.crearRegistradorUseCase = crearRegistradorUseCase;
   }

   public void consultarRegistrador() {
     throw new UnsupportedOperationException("Pendiente de implementación");
   }

   public void actualizarRegistrador() {
     throw new UnsupportedOperationException("Pendiente de implementación");
   }

   public void crearRegistrador() {
     throw new UnsupportedOperationException("Pendiente de implementación");
   }
}
