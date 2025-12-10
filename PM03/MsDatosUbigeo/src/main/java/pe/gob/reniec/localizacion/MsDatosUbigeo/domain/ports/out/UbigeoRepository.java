package pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.out;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public interface UbigeoRepository {
    Ubigeo actualizarSolicitud(Ubigeo entidad);
    Ubigeo actualizarUbigeos(Ubigeo entidad);
    Ubigeo crearSolicitud(Ubigeo entidad);
    Ubigeo crearTrabajoCampo(Ubigeo entidad);
    Ubigeo crearUbigeo(Ubigeo entidad);
    Ubigeo guardarCartografia(Ubigeo entidad);
    Ubigeo listarSolicitudes(Ubigeo entidad);
    Ubigeo listarUbigeos(Ubigeo entidad);
    Ubigeo registrarVisitaCampo(Ubigeo entidad);
}
