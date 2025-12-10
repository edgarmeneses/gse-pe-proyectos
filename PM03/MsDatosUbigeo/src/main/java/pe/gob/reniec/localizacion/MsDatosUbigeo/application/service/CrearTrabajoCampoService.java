package pe.gob.reniec.localizacion.MsDatosUbigeo.application.service;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in.CrearTrabajoCampoUseCase;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.out.UbigeoRepository;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public class CrearTrabajoCampoService implements CrearTrabajoCampoUseCase {
    private final UbigeoRepository repository;

    public CrearTrabajoCampoService(UbigeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ubigeo ejecutar(Ubigeo entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
