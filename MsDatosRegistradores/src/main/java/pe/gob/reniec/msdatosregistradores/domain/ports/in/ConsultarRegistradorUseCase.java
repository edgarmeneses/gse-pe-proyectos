package pe.gob.reniec.msdatosregistradores.domain.ports.in;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;

public interface ConsultarRegistradorUseCase {
    Registrador consultarPorId(String idRegistrador);
}
