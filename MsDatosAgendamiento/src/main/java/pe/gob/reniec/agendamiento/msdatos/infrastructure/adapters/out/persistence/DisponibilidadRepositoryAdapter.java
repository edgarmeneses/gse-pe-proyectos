package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ConfiguracionDisponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.out.DisponibilidadRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class DisponibilidadRepositoryAdapter implements DisponibilidadRepositoryPort {

    @Override
    public Disponibilidad guardar(Disponibilidad disponibilidad) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Disponibilidad actualizar(Disponibilidad disponibilidad) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public Disponibilidad buscarPorId(String disponibilidadId) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public List<Disponibilidad> buscarPorSedeYRangoFechas(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public List<Disponibilidad> buscarDisponibles(String codigoSede, LocalDate fechaDesde, LocalDate fechaHasta) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public void guardarConfiguracion(ConfiguracionDisponibilidad configuracion) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public ConfiguracionDisponibilidad buscarConfiguracionPorSede(String codigoSede) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }

    @Override
    public void eliminar(String disponibilidadId) {
        throw new UnsupportedOperationException("Método de persistencia no implementado. Requiere tecnología específica.");
    }
}
