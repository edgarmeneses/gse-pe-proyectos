package pe.gob.reniec.msdni.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.msdni.domain.model.DatosTarjetaDNI;
import pe.gob.reniec.msdni.domain.ports.out.DatosTarjetaDNIDataPort;

public class DatosTarjetaDNIDataAdapter implements DatosTarjetaDNIDataPort {
    
    @Override
    public DatosTarjetaDNI obtenerDatosTarjetaDNI(String cui) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
