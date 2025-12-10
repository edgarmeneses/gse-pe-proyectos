package pe.gob.reniec.electoral.MsDatosMaterialRegistral.application.service;

import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.in.ActualizarUseCase;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.out.MaterialRegistralRepository;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.model.MaterialRegistral;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.infrastructure.adapters.in.rest.dto.MaterialRegistralDto;

public class ActualizarService implements ActualizarUseCase {
    private final MaterialRegistralRepository repository;

    public ActualizarService(MaterialRegistralRepository repository) {
        this.repository = repository;
    }

    @Override
    public MaterialRegistral ejecutar(MaterialRegistralDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
