package pe.gob.reniec.msdatosregistradores.application.service;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import pe.gob.reniec.msdatosregistradores.domain.ports.in.ListarRegistradoresUseCase;
import pe.gob.reniec.msdatosregistradores.domain.ports.out.RegistradorRepositoryPort;
import java.util.List;

public class ListarRegistradoresService implements ListarRegistradoresUseCase {
    private final RegistradorRepositoryPort repositoryPort;

    public ListarRegistradoresService(RegistradorRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Registrador> listar(String codigoLocal, String estado, String numeroDni, 
                                   String nombreRegistrador, Long pagina, Long registrosPorPagina) {
        return repositoryPort.buscarTodos(codigoLocal, estado, numeroDni, 
                                         nombreRegistrador, pagina, registrosPorPagina);
    }
}
