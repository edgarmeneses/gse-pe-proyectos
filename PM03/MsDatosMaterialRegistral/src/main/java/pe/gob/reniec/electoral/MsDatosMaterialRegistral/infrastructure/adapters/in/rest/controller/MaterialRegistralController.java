package pe.gob.reniec.electoral.MsDatosMaterialRegistral.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.in.ActualizarUseCase;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.domain.ports.in.SolicitudMaterialUseCase;
import pe.gob.reniec.electoral.MsDatosMaterialRegistral.infrastructure.adapters.in.rest.dto.MaterialRegistralDto;

public class MaterialRegistralController {
    private final ActualizarUseCase actualizarUseCase;
    private final SolicitudMaterialUseCase solicitudMaterialUseCase;

    public MaterialRegistralController(ActualizarUseCase actualizarUseCase, SolicitudMaterialUseCase solicitudMaterialUseCase) {
        this.actualizarUseCase = actualizarUseCase;
        this.solicitudMaterialUseCase = solicitudMaterialUseCase;
    }

    public MaterialRegistralDto actualizar() {
        // Simulación de respuesta
        return new MaterialRegistralDto();
    }

    public MaterialRegistralDto solicitudMaterial() {
        // Simulación de respuesta
        return new MaterialRegistralDto();
    }
}
