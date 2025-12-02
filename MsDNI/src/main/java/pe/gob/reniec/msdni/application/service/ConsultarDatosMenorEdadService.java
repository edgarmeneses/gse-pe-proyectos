package pe.gob.reniec.msdni.application.service;

import pe.gob.reniec.msdni.domain.model.DatosMenorEdad;
import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosMenorEdadUseCase;
import pe.gob.reniec.msdni.domain.ports.out.DatosMenorEdadDataPort;

public class ConsultarDatosMenorEdadService implements ConsultarDatosMenorEdadUseCase {
    private final DatosMenorEdadDataPort datosMenorEdadDataPort;

    public ConsultarDatosMenorEdadService(DatosMenorEdadDataPort datosMenorEdadDataPort) {
        this.datosMenorEdadDataPort = datosMenorEdadDataPort;
    }

    @Override
    public DatosMenorEdad consultar(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
