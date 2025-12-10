package pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public interface ActualizarSolicitudUseCase {
    Ubigeo ejecutar(Ubigeo entidad);
}
