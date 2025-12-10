package pe.gob.reniec.localizacion.MsDatosUbigeo.application.service;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in.ListarUbigeosUseCase;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.out.UbigeoRepository;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public class ListarUbigeosService implements ListarUbigeosUseCase {
    private final UbigeoRepository repository;

    public ListarUbigeosService(UbigeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ubigeo ejecutar(Ubigeo entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
