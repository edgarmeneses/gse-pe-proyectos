package pe.gob.reniec.gse.registradores.domain.ports.out;

import pe.gob.reniec.gse.registradores.application.query.BuscarRegistradoresCriteria;
import pe.gob.reniec.gse.registradores.application.query.RegistradoresPaginados;
import pe.gob.reniec.gse.registradores.domain.model.Registrador;

/**
 * Puerto de salida: RegistradorRepositoryPort
 * Define el contrato para operaciones de persistencia de registradores.
 * Este es un MsData, por lo tanto define RepositoryPort.
 */
public interface RegistradorRepositoryPort {
    
    /**
     * Guarda un nuevo registrador en la base de datos.
     * 
     * @param registrador El registrador a persistir
     * @return El registrador persistido con información adicional (ID generado, timestamps, etc.)
     */
    Registrador guardar(Registrador registrador);
    
    /**
     * Busca un registrador por su identificador único.
     * 
     * @param idRegistrador El identificador del registrador
     * @return El registrador encontrado o null si no existe
     */
    Registrador buscarPorId(String idRegistrador);
    
    /**
     * Lista registradores aplicando filtros opcionales y paginación.
     * 
     * @param criteria Los criterios de filtrado y paginación
     * @return Resultado paginado con los registradores encontrados
     */
    RegistradoresPaginados buscarConFiltros(BuscarRegistradoresCriteria criteria);
    
    /**
     * Verifica si existe un registrador con el DNI especificado.
     * 
     * @param numeroDni El número de DNI a verificar
     * @return true si existe, false en caso contrario
     */
    Boolean existePorDni(String numeroDni);
    
    /**
     * Verifica si existe un registrador con el ID especificado.
     * 
     * @param idRegistrador El identificador a verificar
     * @return true si existe, false en caso contrario
     */
    Boolean existePorId(String idRegistrador);
}
