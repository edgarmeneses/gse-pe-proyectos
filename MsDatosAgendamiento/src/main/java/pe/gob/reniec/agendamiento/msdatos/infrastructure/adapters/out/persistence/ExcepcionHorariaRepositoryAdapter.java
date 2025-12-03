package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ExcepcionHoraria;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.ExcepcionHorariaRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class ExcepcionHorariaRepositoryAdapter implements ExcepcionHorariaRepositoryPort {

    @Override
    public ExcepcionHoraria guardar(ExcepcionHoraria excepcion) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public ExcepcionHoraria buscarPorId(String idExcepcion) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public List<ExcepcionHoraria> buscarPorSedeYFecha(String codigoSede, LocalDate fecha) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public List<ExcepcionHoraria> buscarPorSede(String codigoSede) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Boolean existeExcepcionEnFecha(String codigoSede, LocalDate fecha) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public void eliminar(String idExcepcion) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }
}
