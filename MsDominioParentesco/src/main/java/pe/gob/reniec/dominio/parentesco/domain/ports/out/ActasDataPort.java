package pe.gob.reniec.dominio.parentesco.domain.ports.out;

import pe.gob.reniec.dominio.parentesco.domain.model.ActaSustento;
import java.util.List;

public interface ActasDataPort {
    List<ActaSustento> consultarActasNacimiento(String idCiudadano);
    List<ActaSustento> consultarActasMatrimonio(String idCiudadano);
    List<ActaSustento> consultarActasDefuncion(String idCiudadano);
}
