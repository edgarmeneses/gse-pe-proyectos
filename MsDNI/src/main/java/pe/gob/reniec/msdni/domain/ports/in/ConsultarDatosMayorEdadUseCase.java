package pe.gob.reniec.msdni.domain.ports.in;

import pe.gob.reniec.msdni.domain.model.DatosMayorEdad;

public interface ConsultarDatosMayorEdadUseCase {
    DatosMayorEdad consultar(String cui);
}
