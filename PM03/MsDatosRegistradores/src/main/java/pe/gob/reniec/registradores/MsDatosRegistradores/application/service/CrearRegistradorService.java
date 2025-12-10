package pe.gob.reniec.registradores.MsDatosRegistradores.application.service;

import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.ports.out.RegistradorRepository;
import pe.gob.reniec.registradores.MsDatosRegistradores.domain.model.Registrador;
import pe.gob.reniec.registradores.MsDatosRegistradores.infrastructure.adapters.in.rest.dto.RegistradorDto;

public class CrearRegistradorService implements CrearRegistradorUseCase {
    private final RegistradorRepository dataPort;

    public CrearRegistradorService(RegistradorRepository dataPort) {
        this.dataPort = dataPort;
    }

    @Override
    public Registrador ejecutar(RegistradorDto dto) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
