package pe.gob.reniec.msdatosregistradores.domain.ports.out;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import java.util.List;

public interface RegistradorRepositoryPort {
    Registrador guardar(Registrador registrador);
    Registrador buscarPorId(String idRegistrador);
    List<Registrador> buscarTodos(String codigoLocal, String estado, String numeroDni, 
                                  String nombreRegistrador, Long pagina, Long registrosPorPagina);
}
