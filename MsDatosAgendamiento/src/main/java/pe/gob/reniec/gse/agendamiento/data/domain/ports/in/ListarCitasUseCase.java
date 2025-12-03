package pe.gob.reniec.gse.agendamiento.data.domain.ports.in;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import java.time.LocalDate;
import java.util.List;

public interface ListarCitasUseCase {
    
    List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite,
                      String idTecnico, LocalDate fechaDesde, LocalDate fechaHasta);
}
