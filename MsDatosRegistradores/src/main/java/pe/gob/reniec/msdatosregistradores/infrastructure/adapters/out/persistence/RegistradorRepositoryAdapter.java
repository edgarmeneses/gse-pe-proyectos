package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.out.persistence;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import pe.gob.reniec.msdatosregistradores.domain.ports.out.RegistradorRepositoryPort;
import pe.gob.reniec.msdatosregistradores.infrastructure.adapters.out.persistence.mapper.RegistradorPersistenceMapper;
import java.util.List;

public class RegistradorRepositoryAdapter implements RegistradorRepositoryPort {
    private final RegistradorPersistenceMapper mapper;

    public RegistradorRepositoryAdapter(RegistradorPersistenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Registrador guardar(Registrador registrador) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public Registrador buscarPorId(String idRegistrador) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    @Override
    public List<Registrador> buscarTodos(String codigoLocal, String estado, String numeroDni, 
                                        String nombreRegistrador, Long pagina, Long registrosPorPagina) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
