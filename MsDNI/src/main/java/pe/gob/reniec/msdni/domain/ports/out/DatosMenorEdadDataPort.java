package pe.gob.reniec.msdni.domain.ports.out;

import pe.gob.reniec.msdni.domain.model.DatosMenorEdad;

public interface DatosMenorEdadDataPort {
    DatosMenorEdad obtenerDatosMenorEdad(String cui);
}
