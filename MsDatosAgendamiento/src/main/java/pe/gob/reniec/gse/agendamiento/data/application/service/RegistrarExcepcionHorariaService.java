package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.CitasAfectadas;
import pe.gob.reniec.gse.agendamiento.data.domain.model.ExcepcionHoraria;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.RegistrarExcepcionHorariaUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.ExcepcionHorariaRepositoryPort;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;
import java.util.ArrayList;

public class RegistrarExcepcionHorariaService implements RegistrarExcepcionHorariaUseCase {
    
    private final ExcepcionHorariaRepositoryPort excepcionHorariaRepositoryPort;
    private final CitaRepositoryPort citaRepositoryPort;
    
    public RegistrarExcepcionHorariaService(ExcepcionHorariaRepositoryPort excepcionHorariaRepositoryPort,
                                           CitaRepositoryPort citaRepositoryPort) {
        this.excepcionHorariaRepositoryPort = excepcionHorariaRepositoryPort;
        this.citaRepositoryPort = citaRepositoryPort;
    }
    
    @Override
    public ExcepcionHoraria registrar(ExcepcionHoraria excepcionHoraria) {
        return excepcionHorariaRepositoryPort.guardar(excepcionHoraria);
    }
    
    @Override
    public CitasAfectadas obtenerCitasAfectadas(ExcepcionHoraria excepcionHoraria) {
        // Lógica para obtener citas afectadas por la excepción
        return new CitasAfectadas(0, "NINGUNA", new ArrayList<>());
    }
}
