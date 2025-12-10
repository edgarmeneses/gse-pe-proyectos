package pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.model.Registrador;
import pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.in.rest.dto.RegistradorDto;

public interface ConsultarRegistradorUseCase {
    Registrador ejecutar(RegistradorDto dto);
}
