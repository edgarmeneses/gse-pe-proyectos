package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.AnalisisRepositoryPort;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.out.persistence.mapper.AnalisisPersistenceMapper;
import java.time.LocalDateTime;
import java.util.List;

public class AnalisisRepositoryAdapter implements AnalisisRepositoryPort {
    private final AnalisisPersistenceMapper analisisPersistenceMapper;

    public AnalisisRepositoryAdapter(AnalisisPersistenceMapper analisisPersistenceMapper) {
        this.analisisPersistenceMapper = analisisPersistenceMapper;
    }

    @Override
    public Analisis guardar(Analisis analisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public Analisis consultarPorId(String idAnalisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public List<Analisis> listar(String idCiudadano, String idSolicitud, String estado, String tipoVinculo,
                                  LocalDateTime fechaDesde, LocalDateTime fechaHasta, String usuarioTecnico,
                                  Integer pagina, Integer tamanioPagina) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public Analisis actualizar(String idAnalisis, Analisis analisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
