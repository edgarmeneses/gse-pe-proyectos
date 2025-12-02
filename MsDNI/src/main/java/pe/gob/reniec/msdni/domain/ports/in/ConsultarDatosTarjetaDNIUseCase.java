package pe.gob.reniec.msdni.domain.ports.in;

import pe.gob.reniec.msdni.domain.model.DatosTarjetaDNI;

public interface ConsultarDatosTarjetaDNIUseCase {
    DatosTarjetaDNI consultar(String cui);
}
