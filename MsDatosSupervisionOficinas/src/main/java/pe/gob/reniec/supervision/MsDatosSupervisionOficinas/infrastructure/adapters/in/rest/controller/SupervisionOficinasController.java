package pe.gob.reniec.supervision.MsDatosSupervisionOficinas.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in.ActualizarObservacionesUseCase;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in.ListarObservacionesUseCase;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in.PrepararVisitaUseCase;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.domain.ports.in.RegistrarVisitaUseCase;
import pe.gob.reniec.supervision.MsDatosSupervisionOficinas.infrastructure.adapters.in.rest.dto.SupervisionOficinasDto;

public class SupervisionOficinasController {
    private final ActualizarObservacionesUseCase actualizarObservacionesUseCase;
    private final ListarObservacionesUseCase listarObservacionesUseCase;
    private final PrepararVisitaUseCase prepararVisitaUseCase;
    private final RegistrarVisitaUseCase registrarVisitaUseCase;

    public SupervisionOficinasController(
            ActualizarObservacionesUseCase actualizarObservacionesUseCase,
            ListarObservacionesUseCase listarObservacionesUseCase,
            PrepararVisitaUseCase prepararVisitaUseCase,
            RegistrarVisitaUseCase registrarVisitaUseCase) {
        this.actualizarObservacionesUseCase = actualizarObservacionesUseCase;
        this.listarObservacionesUseCase = listarObservacionesUseCase;
        this.prepararVisitaUseCase = prepararVisitaUseCase;
        this.registrarVisitaUseCase = registrarVisitaUseCase;
    }

    public void actualizarObservaciones(SupervisionOficinasDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }

    public void listarObservaciones(SupervisionOficinasDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }

    public void prepararVisita(SupervisionOficinasDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }

    public void registrarVisita(SupervisionOficinasDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }
}
