package pe.gob.reniec.protecciondocumentos.application.service;

import pe.gob.reniec.protecciondocumentos.domain.model.ProcesoProteccion;
import pe.gob.reniec.protecciondocumentos.domain.model.SolicitudProteccion;
import pe.gob.reniec.protecciondocumentos.domain.ports.in.ComprimirYProtegerDocumentosUseCase;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ConfiguracionPort;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.AlmacenamientoPort;

public class ComprimirYProtegerDocumentosService implements ComprimirYProtegerDocumentosUseCase {
    
    private final ConfiguracionPort configuracionPort;
    private final AlmacenamientoPort almacenamientoPort;

    public ComprimirYProtegerDocumentosService(ConfiguracionPort configuracionPort, 
                                               AlmacenamientoPort almacenamientoPort) {
        this.configuracionPort = configuracionPort;
        this.almacenamientoPort = almacenamientoPort;
    }

    @Override
    public ProcesoProteccion ejecutar(SolicitudProteccion solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
