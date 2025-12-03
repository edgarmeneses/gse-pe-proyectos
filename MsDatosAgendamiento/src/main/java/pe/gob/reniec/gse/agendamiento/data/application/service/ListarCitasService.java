package pe.gob.reniec.gse.agendamiento.data.application.service;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Cita;
import pe.gob.reniec.gse.agendamiento.data.domain.model.Paginacion;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ListarCitasUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.out.CitaRepositoryPort;
import java.time.LocalDate;
import java.util.List;

public class ListarCitasService implements ListarCitasUseCase {
    
    private final CitaRepositoryPort citaRepositoryPort;
    
    public ListarCitasService(CitaRepositoryPort citaRepositoryPort) {
        this.citaRepositoryPort = citaRepositoryPort;
    }
    
    @Override
    public List<Cita> listar(String codigoSede, String estado, String dniSolicitante, String numeroTramite,
                            String idTecnico, LocalDate fechaDesde, LocalDate fechaHasta,
                            Integer page, Integer size, String sort, String direction) {
        return citaRepositoryPort.listar(codigoSede, estado, dniSolicitante, numeroTramite,
                                        idTecnico, fechaDesde, fechaHasta, page, size, sort, direction);
    }
    
    @Override
    public Paginacion obtenerPaginacion(String codigoSede, String estado, String dniSolicitante,
                                       String numeroTramite, String idTecnico, LocalDate fechaDesde,
                                       LocalDate fechaHasta, Integer page, Integer size) {
        Long totalRegistros = citaRepositoryPort.contarTotal(codigoSede, estado, dniSolicitante,
                                                             numeroTramite, idTecnico, fechaDesde, fechaHasta);
        Integer totalPaginas = (int) Math.ceil((double) totalRegistros / size);
        Boolean tieneAnterior = page > 0;
        Boolean tieneSiguiente = page < (totalPaginas - 1);
        
        return new Paginacion(totalRegistros.intValue(), totalPaginas, page, size, tieneAnterior, tieneSiguiente);
    }
}
