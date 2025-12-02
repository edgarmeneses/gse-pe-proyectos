package pe.gob.reniec.msdni.domain.ports.in;

import pe.gob.reniec.msdni.domain.model.DatosMenorEdad;

public interface ConsultarDatosMenorEdadUseCase {
    DatosMenorEdad consultar(String cui);
}
