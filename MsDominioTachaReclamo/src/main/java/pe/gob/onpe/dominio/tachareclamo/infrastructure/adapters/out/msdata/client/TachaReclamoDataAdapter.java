package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.out.msdata.client;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.out.TachaReclamoDataPort;

/**
 * Adaptador que implementa la integración con MsDatosElectoral.
 * Este adaptador NO define el protocolo de comunicación (HTTP, SOAP, colas, etc.).
 * Solo define las operaciones necesarias que serán implementadas según la tecnología elegida.
 */
public class TachaReclamoDataAdapter implements TachaReclamoDataPort {

    @Override
    public TachaReclamo crear(TachaReclamo tachaReclamo) {
        // Este método será implementado con la tecnología específica (HTTP client, etc.)
        // Por ahora lanza UnsupportedOperationException
        throw new UnsupportedOperationException("Crear TachaReclamo en MsDatosElectoral - Pendiente implementación");
    }

    @Override
    public TachaReclamo actualizar(Long id, TachaReclamo tachaReclamo) {
        // Este método será implementado con la tecnología específica (HTTP client, etc.)
        // Por ahora lanza UnsupportedOperationException
        throw new UnsupportedOperationException("Actualizar TachaReclamo en MsDatosElectoral - Pendiente implementación");
    }

    @Override
    public TachaReclamo obtenerPorId(Long id) {
        // Este método será implementado con la tecnología específica (HTTP client, etc.)
        // Por ahora lanza UnsupportedOperationException
        throw new UnsupportedOperationException("Obtener TachaReclamo por ID en MsDatosElectoral - Pendiente implementación");
    }
}
