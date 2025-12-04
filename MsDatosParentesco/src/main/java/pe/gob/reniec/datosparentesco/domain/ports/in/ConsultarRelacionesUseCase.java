package pe.gob.reniec.datosparentesco.domain.ports.in;

import pe.gob.reniec.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.datosparentesco.domain.model.Ciudadano;
import java.util.List;

/**
 * Puerto de entrada - Caso de uso para consultar relaciones de parentesco de un ciudadano.
 */
public interface ConsultarRelacionesUseCase {
    
    /**
     * Clase que encapsula el resultado de la consulta de relaciones.
     */
    class ResultadoConsulta {
        private final Ciudadano ciudadano;
        private final List<RelacionParentesco> relaciones;
        private final Integer totalRelaciones;
        
        public ResultadoConsulta(Ciudadano ciudadano, List<RelacionParentesco> relaciones, Integer totalRelaciones) {
            this.ciudadano = ciudadano;
            this.relaciones = relaciones;
            this.totalRelaciones = totalRelaciones;
        }
        
        public Ciudadano getCiudadano() {
            return ciudadano;
        }
        
        public List<RelacionParentesco> getRelaciones() {
            return relaciones;
        }
        
        public Integer getTotalRelaciones() {
            return totalRelaciones;
        }
    }
    
    /**
     * Consulta todas las relaciones de parentesco de un ciudadano específico.
     * 
     * @param idCiudadano DNI del ciudadano
     * @param tipoParentesco Filtro opcional por tipo de parentesco
     * @param gradoMaximo Filtro opcional por grado máximo de parentesco
     * @param incluirInactivos Indica si se deben incluir relaciones inactivas
     * @return Resultado con información del ciudadano y sus relaciones
     */
    ResultadoConsulta consultar(String idCiudadano, String tipoParentesco, 
                               Integer gradoMaximo, Boolean incluirInactivos);
}
