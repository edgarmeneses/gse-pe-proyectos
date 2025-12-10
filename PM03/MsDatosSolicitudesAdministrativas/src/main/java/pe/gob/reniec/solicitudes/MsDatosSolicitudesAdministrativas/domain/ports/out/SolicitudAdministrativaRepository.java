package pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.ports.out;

import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.model.SolicitudAdministrativa;

public interface SolicitudAdministrativaRepository {

    // Se genera un método por cada operación
    void crearSolicitudAdministrativa(SolicitudAdministrativa entidad);

}
