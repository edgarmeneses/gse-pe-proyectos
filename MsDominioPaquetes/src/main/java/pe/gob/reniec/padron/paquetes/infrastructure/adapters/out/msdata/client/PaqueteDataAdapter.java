package pe.gob.reniec.padron.paquetes.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.padron.paquetes.domain.model.AprobacionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConfirmacionRevisionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConsultaPaquetesResult;
import pe.gob.reniec.padron.paquetes.domain.model.InformacionPublicacion;
import pe.gob.reniec.padron.paquetes.domain.ports.out.PaqueteDataPort;

/**
 * Adaptador para integración con MsDatosPaquetesElectorales.
 * Implementa PaqueteDataPort sin definir el protocolo de comunicación.
 * La implementación concreta de la comunicación (HTTP, SOAP, colas, etc.)
 * debe ser proporcionada por configuración externa o inyección de dependencias.
 */
public class PaqueteDataAdapter implements PaqueteDataPort {

    @Override
    public ConsultaPaquetesResult consultarPaquetes(String idPadron, String tipoPadron,
                                                    String codigoDepartamento, String codigoProvincia,
                                                    String codigoDistrito, String estadoPaquete,
                                                    int pagina, int registrosPorPagina) {
        // Implementación stub - La comunicación real con MsDatosPaquetesElectorales 
        // debe ser configurada externamente
        throw new UnsupportedOperationException(
            "La implementación de comunicación con MsDatosPaquetesElectorales debe ser configurada"
        );
    }

    @Override
    public AprobacionResult aprobarPaquete(String paqueteId, InformacionPublicacion informacionPublicacion,
                                          String comentarioAprobacion, Boolean confirmarIntegridad) {
        // Implementación stub - La comunicación real con MsDatosPaquetesElectorales 
        // debe ser configurada externamente
        throw new UnsupportedOperationException(
            "La implementación de comunicación con MsDatosPaquetesElectorales debe ser configurada"
        );
    }

    @Override
    public ConfirmacionRevisionResult confirmarRevisionPaquetes(String idPadron, String tipoPadron,
                                                               String comentarioConfirmacion,
                                                               Boolean confirmarRevisionCompleta) {
        // Implementación stub - La comunicación real con MsDatosPaquetesElectorales 
        // debe ser configurada externamente
        throw new UnsupportedOperationException(
            "La implementación de comunicación con MsDatosPaquetesElectorales debe ser configurada"
        );
    }
}
