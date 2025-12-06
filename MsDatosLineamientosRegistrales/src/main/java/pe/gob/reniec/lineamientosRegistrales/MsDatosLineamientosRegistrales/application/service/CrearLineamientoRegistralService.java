package pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.application.service;

import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.model.LineamientosRegistrales;
import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.ports.in.CrearLineamientoRegistralUseCase;
import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.ports.out.LineamientosRegistralesRepository;
import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.infrastructure.adapters.in.rest.dto.LineamientosRegistralesDto;

public class CrearLineamientoRegistralService implements CrearLineamientoRegistralUseCase {
    private final LineamientosRegistralesRepository repository;

    public CrearLineamientoRegistralService(LineamientosRegistralesRepository repository) {
        this.repository = repository;
    }

    @Override
    public LineamientosRegistrales ejecutar(LineamientosRegistralesDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
