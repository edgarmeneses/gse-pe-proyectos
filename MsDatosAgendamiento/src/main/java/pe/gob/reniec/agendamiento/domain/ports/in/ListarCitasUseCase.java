package pe.gob.reniec.agendamiento.domain.ports.in;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import java.util.List;

public interface ListarCitasUseCase {
    List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite, String idTecnico, String fechaDesde, String fechaHasta, Long page, Long size, String sort, String direction);
}
