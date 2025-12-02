package pe.gob.reniec.msdni.domain.ports.out;

import pe.gob.reniec.msdni.domain.model.DatosMayorEdad;

public interface DatosMayorEdadDataPort {
    DatosMayorEdad obtenerDatosMayorEdad(String cui);
}
