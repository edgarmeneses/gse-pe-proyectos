package pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in;

import pe.gob.reniec.oficina.MsDatosOficinas.domain.model.Oficina;
import pe.gob.reniec.oficina.MsDatosOficinas.infrastructure.adapters.in.rest.dto.OficinaDto;

public interface ListarOficinasUseCase {
    Oficina ejecutar(OficinaDto dto);
}
