package pe.gob.reniec.dominioparentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominioparentesco.domain.ports.out.ActasDataPort;

/**
 * Adaptador para comunicarse con MsDatosActas.
 * Implementa el puerto de salida sin depender de tecnología específica.
 * 
 * NOTA: Esta implementación stub debe ser reemplazada con el cliente real
 * que invoque los endpoints de MsDatosActas.
 */
public class ActasDataAdapter implements ActasDataPort {
    
    public ActasDataAdapter() {
        // Constructor sin dependencias de frameworks
    }
    
    @Override
    public boolean validarActaNacimiento(String dni) {
        // STUB: En producción invocaría:
        // GET /api/v1/actas/nacimiento/{dni}/validar
        // Esperaría respuesta con: {existeActa: true/false}
        
        throw new UnsupportedOperationException(
            "Debe implementarse cliente para invocar MsDatosActas.validarActaNacimiento");
    }
}
