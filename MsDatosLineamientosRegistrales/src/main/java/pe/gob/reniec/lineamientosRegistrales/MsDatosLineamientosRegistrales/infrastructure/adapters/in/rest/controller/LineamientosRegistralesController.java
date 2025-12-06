package pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.ports.in.CrearLineamientoRegistralUseCase;
import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.infrastructure.adapters.in.rest.dto.LineamientosRegistralesDto;

public class LineamientosRegistralesController {
    private final CrearLineamientoRegistralUseCase useCase;

    public LineamientosRegistralesController(CrearLineamientoRegistralUseCase useCase) {
        this.useCase = useCase;
    }

    public LineamientosRegistralesDto crearLineamientoRegistral(LineamientosRegistralesDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
