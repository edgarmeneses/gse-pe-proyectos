package pe.gob.reniec.oficina.MsDatosOficinas.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.InhabilitarUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.CrearSolicitudUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.ListarOficinasUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.MatricularUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.domain.ports.in.ActualizarUseCase;
import pe.gob.reniec.oficina.MsDatosOficinas.infrastructure.adapters.in.rest.dto.OficinaDto;

public class OficinaController {
    private final InhabilitarUseCase inhabilitarUseCase;
    private final CrearSolicitudUseCase crearSolicitudUseCase;
    private final ListarOficinasUseCase listarOficinasUseCase;
    private final MatricularUseCase matricularUseCase;
    private final ActualizarUseCase actualizarUseCase;

    public OficinaController(
        InhabilitarUseCase inhabilitarUseCase,
        CrearSolicitudUseCase crearSolicitudUseCase,
        ListarOficinasUseCase listarOficinasUseCase,
        MatricularUseCase matricularUseCase,
        ActualizarUseCase actualizarUseCase
    ) {
        this.inhabilitarUseCase = inhabilitarUseCase;
        this.crearSolicitudUseCase = crearSolicitudUseCase;
        this.listarOficinasUseCase = listarOficinasUseCase;
        this.matricularUseCase = matricularUseCase;
        this.actualizarUseCase = actualizarUseCase;
    }

    public void inhabilitar(OficinaDto dto) {
        inhabilitarUseCase.ejecutar(dto);
    }

    public void crearSolicitud(OficinaDto dto) {
        crearSolicitudUseCase.ejecutar(dto);
    }

    public void listarOficinas(OficinaDto dto) {
        listarOficinasUseCase.ejecutar(dto);
    }

    public void matricular(OficinaDto dto) {
        matricularUseCase.ejecutar(dto);
    }

    public void actualizar(OficinaDto dto) {
        actualizarUseCase.ejecutar(dto);
    }
}
