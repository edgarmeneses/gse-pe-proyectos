package pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.application.service;

import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.ports.in.CrearSolicitudAdministrativaUseCase;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.ports.out.SolicitudAdministrativaRepository;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.domain.model.SolicitudAdministrativa;
import pe.gob.reniec.solicitudes.MsDatosSolicitudesAdministrativas.infrastructure.adapters.in.rest.dto.SolicitudAdministrativaDto;

public class CrearSolicitudAdministrativaService implements CrearSolicitudAdministrativaUseCase {
    private final SolicitudAdministrativaRepository dataPort;

    public CrearSolicitudAdministrativaService(SolicitudAdministrativaRepository dataPort) {
        this.dataPort = dataPort;
    }

    @Override
    public SolicitudAdministrativa ejecutar(SolicitudAdministrativaDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
