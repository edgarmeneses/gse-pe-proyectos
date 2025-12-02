package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ListarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.AnalisisRepositoryPort;
import java.time.LocalDateTime;
import java.util.List;

public class ListarAnalisisService implements ListarAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public ListarAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public List<Analisis> listar(String idCiudadano, String idSolicitud, String estado, String tipoVinculo,
                                  LocalDateTime fechaDesde, LocalDateTime fechaHasta, String usuarioTecnico,
                                  Integer pagina, Integer tamanioPagina) {
        return analisisRepositoryPort.listar(idCiudadano, idSolicitud, estado, tipoVinculo,
                fechaDesde, fechaHasta, usuarioTecnico, pagina, tamanioPagina);
    }
}
