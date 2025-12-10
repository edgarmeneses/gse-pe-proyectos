package pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.out;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.model.Registrador;

public interface RegistradorRepository {

    void consultarRegistrador(Registrador entidad);

    void actualizarRegistrador(Registrador entidad);

    void crearRegistrador(Registrador entidad);

}
