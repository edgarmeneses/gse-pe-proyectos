package pe.gob.reniec.gse.datosparentesco.domain.ports.in;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import java.time.LocalDateTime;
import java.util.List;

public interface ListarAnalisisUseCase {
    List<Analisis> listar(String idCiudadano, String idSolicitud, String estado, String tipoVinculo,
                          LocalDateTime fechaDesde, LocalDateTime fechaHasta, String usuarioTecnico,
                          Integer pagina, Integer tamanioPagina);
}
