package pe.gob.reniec.dominioparentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominioparentesco.domain.ports.out.APDDataPort;

import java.util.Map;

/**
 * Adaptador para comunicarse con MsSagaAPD.
 * Implementa el puerto de salida sin depender de tecnología específica.
 * 
 * NOTA: Esta implementación stub debe ser reemplazada con el cliente real
 * que invoque los endpoints de MsSagaAPD.
 */
public class APDDataAdapter implements APDDataPort {
    
    public APDDataAdapter() {
        // Constructor sin dependencias de frameworks
    }
    
    @Override
    public Map<String, Object> validarCiudadano(String dni) {
        // STUB: En producción invocaría:
        // GET /api/v1/apd/ciudadano/{dni}
        // Esperaría respuesta con: {valido: true, nombreCompleto: "...", fechaNacimiento: "..."}
        
        throw new UnsupportedOperationException(
            "Debe implementarse cliente para invocar MsSagaAPD.validarCiudadano");
    }
}
