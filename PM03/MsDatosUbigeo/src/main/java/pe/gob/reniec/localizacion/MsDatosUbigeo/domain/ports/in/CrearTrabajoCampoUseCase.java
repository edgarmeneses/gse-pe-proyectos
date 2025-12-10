package pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public interface CrearTrabajoCampoUseCase {
    Ubigeo ejecutar(Ubigeo entidad);
}
