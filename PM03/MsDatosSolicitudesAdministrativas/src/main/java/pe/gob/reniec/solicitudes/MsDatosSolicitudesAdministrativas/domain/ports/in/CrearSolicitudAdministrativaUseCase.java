package pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.ports.in;

import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.model.SolicitudAdministrativa;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.infrastructure.adapters.in.rest.dto.SolicitudAdministrativaDto;

public interface CrearSolicitudAdministrativaUseCase {
    SolicitudAdministrativa ejecutar(SolicitudAdministrativaDto dto);
}
