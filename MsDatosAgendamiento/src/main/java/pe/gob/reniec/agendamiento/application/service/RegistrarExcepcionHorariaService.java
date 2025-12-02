package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.ExcepcionHorariaRepositoryPort;

public class RegistrarExcepcionHorariaService implements RegistrarExcepcionHorariaUseCase {
    private final ExcepcionHorariaRepositoryPort excepcionHorariaRepositoryPort;

    public RegistrarExcepcionHorariaService(ExcepcionHorariaRepositoryPort excepcionHorariaRepositoryPort) {
        this.excepcionHorariaRepositoryPort = excepcionHorariaRepositoryPort;
    }

    @Override
    public ExcepcionHoraria registrar(ExcepcionHoraria excepcionHoraria) {
        return excepcionHorariaRepositoryPort.guardar(excepcionHoraria);
    }
}
