package pe.gob.reniec.registradores.MsDatosRegistradores.application.service;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in.ActualizarRegistradorUseCase;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.out.RegistradorRepository;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.model.Registrador;
import pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.in.rest.dto.RegistradorDto;

public class ActualizarRegistradorService implements ActualizarRegistradorUseCase {
    private final RegistradorRepository dataPort;

    public ActualizarRegistradorService(RegistradorRepository dataPort) {
        this.dataPort = dataPort;
    }

    @Override
    public Registrador ejecutar(RegistradorDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
