package pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.out.RegistradorRepository;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.model.Registrador;

public class RegistradorRepositoryAdapter implements RegistradorRepository {
    @Override
    public void consultarRegistrador(Registrador entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void actualizarRegistrador(Registrador entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void crearRegistrador(Registrador entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
