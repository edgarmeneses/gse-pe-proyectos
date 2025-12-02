package pe.gob.reniec.dominio.parentesco.application.service;

import pe.gob.reniec.dominio.parentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.model.SolicitudAnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.ports.in.EjecutarAnalisisParentescoUseCase;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.APDDataPort;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.ActasDataPort;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.ParentescoDataPort;

public class EjecutarAnalisisParentescoService implements EjecutarAnalisisParentescoUseCase {
    private final APDDataPort apdDataPort;
    private final ActasDataPort actasDataPort;
    private final ParentescoDataPort parentescoDataPort;

    public EjecutarAnalisisParentescoService(APDDataPort apdDataPort, ActasDataPort actasDataPort,
                                            ParentescoDataPort parentescoDataPort) {
        this.apdDataPort = apdDataPort;
        this.actasDataPort = actasDataPort;
        this.parentescoDataPort = parentescoDataPort;
    }

    @Override
    public AnalisisParentesco ejecutar(SolicitudAnalisisParentesco solicitud) {
        throw new UnsupportedOperationException("Implementación pendiente: ejecutar análisis de parentesco");
    }
}
