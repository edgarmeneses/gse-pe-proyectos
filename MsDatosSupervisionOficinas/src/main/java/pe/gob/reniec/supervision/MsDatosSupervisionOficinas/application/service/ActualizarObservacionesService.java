package pe.gob.reniec.supervision.MsDatosSupervisionOficinas.application.service;

import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.model.SupervisionOficinas;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in.ActualizarObservacionesUseCase;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.out.SupervisionOficinasRepository;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.infrastructure.adapters.in.rest.dto.SupervisionOficinasDto;

public class ActualizarObservacionesService implements ActualizarObservacionesUseCase {
    private final SupervisionOficinasRepository dataPort;

    public ActualizarObservacionesService(SupervisionOficinasRepository dataPort) {
        this.dataPort = dataPort;
    }

    @Override
    public SupervisionOficinas ejecutar(SupervisionOficinasDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }
}
