package pe.gob.reniec.oficina.MsDatosOficinas.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.oficina.MsDatosOficinas.domain.model.Oficina;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.out.OficinaRepository;

public class OficinaRepositoryAdapter implements OficinaRepository {
    @Override
    public void inhabilitar(Oficina entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void crearSolicitud(Oficina entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void listarOficinas(Oficina entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void matricular(Oficina entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void actualizar(Oficina entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
