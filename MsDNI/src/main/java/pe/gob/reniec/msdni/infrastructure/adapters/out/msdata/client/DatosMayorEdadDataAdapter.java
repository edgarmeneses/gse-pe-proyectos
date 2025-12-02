package pe.gob.reniec.msdni.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.msdni.domain.model.DatosMayorEdad;
import pe.gob.reniec.msdni.domain.ports.out.DatosMayorEdadDataPort;

public class DatosMayorEdadDataAdapter implements DatosMayorEdadDataPort {
    
    @Override
    public DatosMayorEdad obtenerDatosMayorEdad(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
