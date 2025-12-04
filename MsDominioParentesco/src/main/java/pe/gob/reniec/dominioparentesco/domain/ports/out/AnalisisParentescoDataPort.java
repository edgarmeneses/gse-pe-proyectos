package pe.gob.reniec.dominioparentesco.domain.ports.out;

import java.util.List;
import java.util.Map;

/**
 * Puerto de salida - Operaciones contra MsDatosParentesco.
 * Usa tipos primitivos para mantener independencia tecnológica.
 * No define el protocolo de comunicación (HTTP/SOAP/otros).
 */
public interface AnalisisParentescoDataPort {
    
    /**
     * Busca relaciones consanguíneas para un ciudadano.
     * 
     * @param dni DNI del ciudadano
     * @param profundidad Grados de parentesco a buscar (1-4)
     * @return Lista de maps con datos de relaciones: dniRelacionado, tipoRelacion, confianza
     */
    List<Map<String, Object>> buscarRelacionesConsanguineas(String dni, int profundidad);
    
    /**
     * Busca relaciones de afinidad para un ciudadano.
     * 
     * @param dni DNI del ciudadano
     * @param profundidad Grados de parentesco a buscar (1-4)
     * @return Lista de maps con datos de relaciones: dniRelacionado, tipoRelacion, confianza
     */
    List<Map<String, Object>> buscarRelacionesAfinidad(String dni, int profundidad);
}
