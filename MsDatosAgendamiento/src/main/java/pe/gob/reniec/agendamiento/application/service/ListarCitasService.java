package pe.gob.reniec.agendamiento.application.service;

import pe.gob.reniec.agendamiento.domain.model.Cita;
import pe.gob.reniec.agendamiento.domain.ports.in.ListarCitasUseCase;
import pe.gob.reniec.agendamiento.domain.ports.out.CitaRepositoryPort;
import java.util.List;

public class ListarCitasService implements ListarCitasUseCase {
    private final CitaRepositoryPort citaRepositoryPort;

    public ListarCitasService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }

    @Override
    public List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite, String idTecnico, String fechaDesde, String fechaHasta, Long page, Long size, String sort, String direction) {
        return citaRepositoryPort.listar(codigoSede, estado, dniSolicitante, numeroTramite, idTecnico, fechaDesde, fechaHasta, page, size, sort, direction);
    }
}
