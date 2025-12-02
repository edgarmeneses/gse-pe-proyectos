package pe.gob.reniec.msdni.application.service;

import pe.gob.reniec.msdni.domain.model.DatosTarjetaDNI;
import pe.gob.reniec.msdni.domain.ports.in.ConsultarDatosTarjetaDNIUseCase;
import pe.gob.reniec.msdni.domain.ports.out.DatosTarjetaDNIDataPort;

public class ConsultarDatosTarjetaDNIService implements ConsultarDatosTarjetaDNIUseCase {
    private final DatosTarjetaDNIDataPort datosTarjetaDNIDataPort;

    public ConsultarDatosTarjetaDNIService(DatosTarjetaDNIDataPort datosTarjetaDNIDataPort) {
        this.datosTarjetaDNIDataPort = datosTarjetaDNIDataPort;
    }

    @Override
    public DatosTarjetaDNI consultar(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
