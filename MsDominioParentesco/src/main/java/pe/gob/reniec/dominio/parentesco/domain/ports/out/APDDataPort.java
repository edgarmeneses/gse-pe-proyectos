package pe.gob.reniec.dominio.parentesco.domain.ports.out;

import pe.gob.reniec.dominio.parentesco.domain.model.DatosAPD;

public interface APDDataPort {
    DatosAPD consultarAPD(String idCiudadano);
}
