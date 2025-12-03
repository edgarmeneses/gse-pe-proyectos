package pe.gob.reniec.agendamiento.msdatos.domain.ports.out;

import pe.gob.reniec.agendamiento.msdatos.application.query.FiltroBusquedaCita;
import pe.gob.reniec.agendamiento.msdatos.domain.model.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaRepositoryPort {
    Cita guardar(Cita cita);
    Cita actualizar(Cita cita);
    Optional<Cita> buscarPorId(String citaId);
    List<Cita> buscarConFiltros(FiltroBusquedaCita filtro);
    Integer contarConFiltros(FiltroBusquedaCita filtro);
    Boolean existe(String citaId);
    void eliminar(String citaId);
}
