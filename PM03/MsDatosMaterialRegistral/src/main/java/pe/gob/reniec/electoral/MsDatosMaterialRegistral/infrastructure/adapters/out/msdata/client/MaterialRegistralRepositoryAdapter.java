package pe.gob.reniec.electoral.MsDatosMaterialRegistral.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.out.MaterialRegistralRepository;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.model.MaterialRegistral;

public class MaterialRegistralRepositoryAdapter implements MaterialRegistralRepository {
    @Override
    public void actualizar(MaterialRegistral entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void solicitudMaterial(MaterialRegistral entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
