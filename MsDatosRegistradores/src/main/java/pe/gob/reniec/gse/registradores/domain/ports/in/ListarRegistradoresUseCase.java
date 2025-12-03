package pe.gob.reniec.gse.registradores.domain.ports.in;

import pe.gob.reniec.gse.registradores.application.query.BuscarRegistradoresCriteria;
import pe.gob.reniec.gse.registradores.application.query.RegistradoresPaginados;

/**
 * Puerto de entrada: Listar Registradores
 * Define el contrato para listar registradores con filtros opcionales.
 */
public interface ListarRegistradoresUseCase {
    
    /**
     * Lista registradores aplicando filtros opcionales y paginación.
     * 
     * @param criteria Los criterios de filtrado y paginación
     * @return Resultado paginado con la lista de registradores encontrados
     */
    RegistradoresPaginados listar(BuscarRegistradoresCriteria criteria);
}
