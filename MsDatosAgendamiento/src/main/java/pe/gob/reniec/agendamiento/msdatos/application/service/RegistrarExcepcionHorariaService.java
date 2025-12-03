package pe.gob.reniec.agendamiento.msdatos.application.service;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.ExcepcionHorariaRepositoryPort;

public class RegistrarExcepcionHorariaService implements RegistrarExcepcionHorariaUseCase {
    
    private final ExcepcionHorariaRepositoryPort excepcionRepositoryPort;

    public RegistrarExcepcionHorariaService(ExcepcionHorariaRepositoryPort excepcionRepositoryPort) {
        this.excepcionRepositoryPort = excepcionRepositoryPort;
    }

    @Override
    public ExcepcionHoraria registrar(ExcepcionHoraria excepcion) {
        Boolean existe = excepcionRepositoryPort.existeExcepcionEnFecha(
            excepcion.getCodigoSede(), 
            excepcion.getFechaExcepcion()
        );
        
        if (Boolean.TRUE.equals(existe)) {
            throw new RuntimeException("Ya existe una excepción para esta fecha y sede");
        }
        
        return excepcionRepositoryPort.guardar(excepcion);
    }
}
