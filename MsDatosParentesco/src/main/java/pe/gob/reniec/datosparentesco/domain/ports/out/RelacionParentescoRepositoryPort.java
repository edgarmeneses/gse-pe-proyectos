package pe.gob.reniec.datosparentesco.domain.ports.out;

import pe.gob.reniec.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.datosparentesco.domain.model.Ciudadano;
import java.util.List;

/**
 * Puerto de salida - Interfaz del repositorio para operaciones de persistencia de relaciones de parentesco.
 */
public interface RelacionParentescoRepositoryPort {
    
    /**
     * Guarda una relación de parentesco en la base de datos.
     * 
     * @param relacionParentesco Relación a guardar
     * @return Relación guardada con ID generado e información de relación inversa
     */
    RelacionParentesco guardar(RelacionParentesco relacionParentesco);
    
    /**
     * Busca todas las relaciones de parentesco de un ciudadano específico.
     * 
     * @param idCiudadano DNI del ciudadano
     * @param tipoParentesco Filtro opcional por tipo de parentesco
     * @param gradoMaximo Filtro opcional por grado máximo de parentesco
     * @param incluirInactivos Indica si se deben incluir relaciones inactivas
     * @return Lista de relaciones encontradas
     */
    List<RelacionParentesco> buscarPorCiudadano(String idCiudadano, String tipoParentesco, 
                                                Integer gradoMaximo, Boolean incluirInactivos);
    
    /**
     * Busca un ciudadano por su identificador.
     * 
     * @param idCiudadano DNI del ciudadano
     * @return Ciudadano encontrado o null si no existe
     */
    Ciudadano buscarCiudadano(String idCiudadano);
    
    /**
     * Verifica si existe una relación de parentesco entre dos ciudadanos.
     * 
     * @param idCiudadanoOrigen DNI del ciudadano origen
     * @param idCiudadanoDestino DNI del ciudadano destino
     * @param tipoParentesco Tipo de parentesco
     * @return true si existe la relación, false en caso contrario
     */
    boolean existeRelacion(String idCiudadanoOrigen, String idCiudadanoDestino, String tipoParentesco);
}
