package pe.gob.reniec.oficina.MsDatosOficinas.application.service;

import pe.gob.reniec.oficina.MsDatosOficinas.domain.model.Oficina;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.ActualizarUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.out.OficinaRepository;
import pe.gob.reniec.oficina.MsDatosOficinas.infrastructure.adapters.in.rest.dto.OficinaDto;

public class ActualizarService implements ActualizarUseCase {
    private final OficinaRepository repository;

    public ActualizarService(OficinaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Oficina ejecutar(OficinaDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
