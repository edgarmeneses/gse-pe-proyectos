package pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.out;

import pe.gob.reniec.oficina.MsDatosOficinas.domain.model.Oficina;

public interface OficinaRepository {

    void inhabilitar(Oficina entidad);
    void crearSolicitud(Oficina entidad);
    void listarOficinas(Oficina entidad);
    void matricular(Oficina entidad);
    void actualizar(Oficina entidad);

}
