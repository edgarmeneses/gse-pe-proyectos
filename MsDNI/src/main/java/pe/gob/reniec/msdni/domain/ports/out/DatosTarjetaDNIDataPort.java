package pe.gob.reniec.msdni.domain.ports.out;

import pe.gob.reniec.msdni.domain.model.DatosTarjetaDNI;

public interface DatosTarjetaDNIDataPort {
    DatosTarjetaDNI obtenerDatosTarjetaDNI(String cui);
}
