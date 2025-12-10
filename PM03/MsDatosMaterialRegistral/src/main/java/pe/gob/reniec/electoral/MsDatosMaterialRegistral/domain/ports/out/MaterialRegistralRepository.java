package pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.out;

import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.model.MaterialRegistral;

public interface MaterialRegistralRepository {
    void actualizar(MaterialRegistral entidad);
    void solicitudMaterial(MaterialRegistral entidad);
}
