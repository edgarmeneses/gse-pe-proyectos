package pe.gob.reniec.localizacion.MsDatosUbigeo.application.service;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in.CrearUbigeoUseCase;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.out.UbigeoRepository;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public class CrearUbigeoService implements CrearUbigeoUseCase {
    private final UbigeoRepository repository;

    public CrearUbigeoService(UbigeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ubigeo ejecutar(Ubigeo entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
