package pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.ports.in;

import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.domain.model.LineamientosRegistrales;
import pe.gob.reniec.lineamientosRegistrales.MsDatosLineamientosRegistrales.infrastructure.adapters.in.rest.dto.LineamientosRegistralesDto;

public interface CrearLineamientoRegistralUseCase {
    LineamientosRegistrales ejecutar(LineamientosRegistralesDto dto);
}
