package pe.gob.reniec.gse.datosparentesco.domain.ports.out;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import java.time.LocalDateTime;
import java.util.List;

public interface AnalisisRepositoryPort {
    Analisis guardar(Analisis analisis);
    Analisis consultarPorId(String idAnalisis);
    List<Analisis> listar(String idCiudadano, String idSolicitud, String estado, String tipoVinculo,
                          LocalDateTime fechaDesde, LocalDateTime fechaHasta, String usuarioTecnico,
                          Integer pagina, Integer tamanioPagina);
    Analisis actualizar(String idAnalisis, Analisis analisis);
}
