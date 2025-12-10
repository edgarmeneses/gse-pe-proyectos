package pe.gob.reniec.localizacion.MsDatosUbigeo.application.service;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in.RegistrarVisitaCampoUseCase;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.out.UbigeoRepository;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;

public class RegistrarVisitaCampoService implements RegistrarVisitaCampoUseCase {
    private final UbigeoRepository repository;

    public RegistrarVisitaCampoService(UbigeoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ubigeo ejecutar(Ubigeo entidad) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
