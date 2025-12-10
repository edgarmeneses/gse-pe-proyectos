package pe.gob.reniec.localizacion.MsDatosUbigeo.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.ports.in.*;
import pe.gob.reniec.localizacion.MsDatosUbigeo.domain.model.Ubigeo;
import pe.gob.reniec.localizacion.MsDatosUbigeo.infrastructure.adapters.in.rest.dto.UbigeoDto;

public class UbigeoController {
    private final ActualizarSolicitudUseCase actualizarSolicitudUseCase;
    private final ActualizarUbigeosUseCase actualizarUbigeosUseCase;
    private final CrearSolicitudUseCase crearSolicitudUseCase;
    private final CrearTrabajoCampoUseCase crearTrabajoCampoUseCase;
    private final CrearUbigeoUseCase crearUbigeoUseCase;
    private final GuardarCartografiaUseCase guardarCartografiaUseCase;
    private final ListarSolicitudesUseCase listarSolicitudesUseCase;
    private final ListarUbigeosUseCase listarUbigeosUseCase;
    private final RegistrarVisitaCampoUseCase registrarVisitaCampoUseCase;

    public UbigeoController(
        ActualizarSolicitudUseCase actualizarSolicitudUseCase,
        ActualizarUbigeosUseCase actualizarUbigeosUseCase,
        CrearSolicitudUseCase crearSolicitudUseCase,
        CrearTrabajoCampoUseCase crearTrabajoCampoUseCase,
        CrearUbigeoUseCase crearUbigeoUseCase,
        GuardarCartografiaUseCase guardarCartografiaUseCase,
        ListarSolicitudesUseCase listarSolicitudesUseCase,
        ListarUbigeosUseCase listarUbigeosUseCase,
        RegistrarVisitaCampoUseCase registrarVisitaCampoUseCase
    ) {
        this.actualizarSolicitudUseCase = actualizarSolicitudUseCase;
        this.actualizarUbigeosUseCase = actualizarUbigeosUseCase;
        this.crearSolicitudUseCase = crearSolicitudUseCase;
        this.crearTrabajoCampoUseCase = crearTrabajoCampoUseCase;
        this.crearUbigeoUseCase = crearUbigeoUseCase;
        this.guardarCartografiaUseCase = guardarCartografiaUseCase;
        this.listarSolicitudesUseCase = listarSolicitudesUseCase;
        this.listarUbigeosUseCase = listarUbigeosUseCase;
        this.registrarVisitaCampoUseCase = registrarVisitaCampoUseCase;
    }

    public Ubigeo actualizarSolicitud(UbigeoDto dto) {
        return actualizarSolicitudUseCase.ejecutar(new Ubigeo());
    }
    
    public Ubigeo actualizarUbigeos(UbigeoDto dto) {
        return actualizarUbigeosUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo crearSolicitud(UbigeoDto dto) {
        return crearSolicitudUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo crearTrabajoCampo(UbigeoDto dto) {
        return crearTrabajoCampoUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo crearUbigeo(UbigeoDto dto) {
        return crearUbigeoUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo guardarCartografia(UbigeoDto dto) {
        return guardarCartografiaUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo listarSolicitudes(UbigeoDto dto) {
        return listarSolicitudesUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo listarUbigeos(UbigeoDto dto) {
        return listarUbigeosUseCase.ejecutar(new Ubigeo());
    }

    public Ubigeo registrarVisitaCampo(UbigeoDto dto) {
        return registrarVisitaCampoUseCase.ejecutar(new Ubigeo());
    }
}
