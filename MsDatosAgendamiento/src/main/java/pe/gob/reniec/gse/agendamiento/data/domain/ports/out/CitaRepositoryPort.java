package pe.gob.reniec.gse.agendamiento.data.domain.ports.out;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.model.HistorialCita;
import java.time.LocalDate;
import java.util.List;

public interface CitaRepositoryPort {
    
    Cita guardar(Cita cita);
    
    Cita actualizar(Cita cita);
    
    Cita buscarPorId(String citaId);
    
    List<Cita> buscarPorSolicitud(String idSolicitud);
    
    List<Cita> buscarPorDni(String dni);
    
    List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite,
                      String idTecnico, LocalDate fechaDesde, LocalDate fechaHasta);
    
    void guardarHistorial(HistorialCita historialCita);
    
    List<HistorialCita> buscarHistorialPorCita(String citaId);
}
