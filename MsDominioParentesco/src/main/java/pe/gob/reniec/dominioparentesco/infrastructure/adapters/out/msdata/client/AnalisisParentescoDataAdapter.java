package pe.gob.reniec.dominioparentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominioparentesco.domain.ports.out.AnalisisParentescoDataPort;

import java.util.List;
import java.util.Map;

/**
 * Adaptador para comunicarse con MsDatosParentesco.
 * Implementa el puerto de salida sin depender de tecnología específica.
 * 
 * NOTA: Esta implementación stub debe ser reemplazada con el cliente real
 * que invoque los endpoints de MsDatosParentesco.
 */
public class AnalisisParentescoDataAdapter implements AnalisisParentescoDataPort {
    
    public AnalisisParentescoDataAdapter() {
        // Constructor sin dependencias de frameworks
    }
    
    @Override
    public List<Map<String, Object>> buscarRelacionesConsanguineas(String dni, int profundidad) {
        // STUB: En producción invocaría:
        // GET /api/v1/parentesco/MsDatosParentesco/relaciones/consanguineas?dni={dni}&profundidad={profundidad}
        
        throw new UnsupportedOperationException(
            "Debe implementarse cliente para invocar MsDatosParentesco.buscarRelacionesConsanguineas");
    }
    
    @Override
    public List<Map<String, Object>> buscarRelacionesAfinidad(String dni, int profundidad) {
        // STUB: En producción invocaría:
        // GET /api/v1/parentesco/MsDatosParentesco/relaciones/afinidad?dni={dni}&profundidad={profundidad}
        
        throw new UnsupportedOperationException(
            "Debe implementarse cliente para invocar MsDatosParentesco.buscarRelacionesAfinidad");
    }
}
