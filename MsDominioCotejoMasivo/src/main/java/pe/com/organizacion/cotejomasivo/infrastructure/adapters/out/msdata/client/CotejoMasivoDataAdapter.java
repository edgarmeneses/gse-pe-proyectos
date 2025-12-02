package pe.com.organizacion.cotejomasivo.infrastructure.adapters.out.msdata.client;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;
import pe.com.organizacion.cotejomasivo.domain.ports.out.CotejoMasivoDataPort;

/**
 * Adaptador: CotejoMasivoDataAdapter
 * Implementa la integración con MsDataCotejoMasivo (microservicio de datos)
 * NOTA: La tecnología de comunicación (HTTP/SOAP/colas) no está definida
 */
public class CotejoMasivoDataAdapter implements CotejoMasivoDataPort {
    
    /**
     * Constructor sin dependencias tecnológicas específicas
     * En una implementación real, aquí se inyectaría el cliente de comunicación
     */
    public CotejoMasivoDataAdapter() {
        // Constructor para futuras dependencias de comunicación con MsDataCotejoMasivo
    }
    
    @Override
    public CotejoMasivo crear(CotejoMasivo cotejoMasivo) {
        // TODO: Implementar llamada a MsDataCotejoMasivo para crear registro
        // El protocolo de comunicación debe ser definido en la implementación
        throw new UnsupportedOperationException(
            "Implementación pendiente: crear registro en MsDataCotejoMasivo. " +
            "Debe definirse el protocolo de comunicación (HTTP/SOAP/colas)."
        );
    }
    
    @Override
    public CotejoMasivo actualizar(CotejoMasivo cotejoMasivo) {
        // TODO: Implementar llamada a MsDataCotejoMasivo para actualizar registro
        // El protocolo de comunicación debe ser definido en la implementación
        throw new UnsupportedOperationException(
            "Implementación pendiente: actualizar registro en MsDataCotejoMasivo. " +
            "Debe definirse el protocolo de comunicación (HTTP/SOAP/colas)."
        );
    }
    
    @Override
    public CotejoMasivo consultarPorId(String idEjecucion) {
        // TODO: Implementar llamada a MsDataCotejoMasivo para consultar registro
        // El protocolo de comunicación debe ser definido en la implementación
        throw new UnsupportedOperationException(
            "Implementación pendiente: consultar registro en MsDataCotejoMasivo. " +
            "Debe definirse el protocolo de comunicación (HTTP/SOAP/colas)."
        );
    }
    
    @Override
    public ResultadosPaginados obtenerResultados(String idEjecucion, Long pagina, Long tamanio, String estadoCotejo) {
        // TODO: Implementar llamada a MsDataCotejoMasivo para obtener resultados
        // El protocolo de comunicación debe ser definido en la implementación
        throw new UnsupportedOperationException(
            "Implementación pendiente: obtener resultados de MsDataCotejoMasivo. " +
            "Debe definirse el protocolo de comunicación (HTTP/SOAP/colas)."
        );
    }
}
