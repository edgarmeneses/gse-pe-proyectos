package pe.gob.reniec.agendamiento.domain.ports.out;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import java.util.List;

public interface CitaRepositoryPort {
    Cita guardar(Cita cita);
    Cita actualizar(Cita cita);
    Cita consultarPorId(String citaId);
    List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite, String idTecnico, String fechaDesde, String fechaHasta, Long page, Long size, String sort, String direction);
    Cita cancelar(String citaId);
}
