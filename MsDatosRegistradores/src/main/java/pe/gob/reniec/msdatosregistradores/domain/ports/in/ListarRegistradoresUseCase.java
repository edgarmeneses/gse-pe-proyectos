package pe.gob.reniec.msdatosregistradores.domain.ports.in;

import pe.gob.reniec.msdatosregistradores.domain.model.Registrador;
import java.util.List;

public interface ListarRegistradoresUseCase {
    List<Registrador> listar(String codigoLocal, String estado, String numeroDni, 
                            String nombreRegistrador, Long pagina, Long registrosPorPagina);
}
