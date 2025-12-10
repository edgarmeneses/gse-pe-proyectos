package pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public interface CrearSolicitudUseCase {
    Ubigeo ejecutar(Ubigeo entidad);
}
