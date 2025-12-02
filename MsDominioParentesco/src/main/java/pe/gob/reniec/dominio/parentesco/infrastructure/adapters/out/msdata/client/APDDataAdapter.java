package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominio.parentesco.domain.model.DatosAPD;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.APDDataPort;

public class APDDataAdapter implements APDDataPort {

    @Override
    public DatosAPD consultarAPD(String idCiudadano) {
        throw new UnsupportedOperationException("Implementación pendiente: consultar APD desde MsSagaAPD");
    }
}
