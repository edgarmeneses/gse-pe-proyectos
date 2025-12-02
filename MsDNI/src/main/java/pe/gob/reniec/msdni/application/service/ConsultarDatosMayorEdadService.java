package pe.gob.reniec.msdni.application.service;

import pe.gob.reniec.msdni.domain.model.DatosMayorEdad;
import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosMayorEdadUseCase;
import pe.gob.reniec.msdni.domain.ports.out.DatosMayorEdadDataPort;

public class ConsultarDatosMayorEdadService implements ConsultarDatosMayorEdadUseCase {
    private final DatosMayorEdadDataPort datosMayorEdadDataPort;

    public ConsultarDatosMayorEdadService(DatosMayorEdadDataPort datosMayorEdadDataPort) {
        this.datosMayorEdadDataPort = datosMayorEdadDataPort;
    }

    @Override
    public DatosMayorEdad consultar(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
