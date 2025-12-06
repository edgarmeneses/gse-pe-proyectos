package pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in;

import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.infrastructure.adapters.in.rest.dto.SupervisionOficinasDto;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.model.SupervisionOficinas;

public interface ActualizarObservacionesUseCase {
    SupervisionOficinas ejecutar(SupervisionOficinasDto dto);
}
