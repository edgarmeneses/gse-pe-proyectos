package pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.in;

import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.model.MaterialRegistral;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.infrastructure.adapters.in.rest.dto.MaterialRegistralDto;

public interface ActualizarUseCase {
    MaterialRegistral ejecutar(MaterialRegistralDto dto);
}
