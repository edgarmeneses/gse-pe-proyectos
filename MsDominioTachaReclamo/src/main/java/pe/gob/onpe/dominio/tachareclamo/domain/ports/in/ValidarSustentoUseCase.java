package pe.gob.onpe.dominio.tachareclamo.domain.ports.in;

import pe.gob.onpe.dominio.tachareclamo.domain.model.ValidacionSustento;

public interface ValidarSustentoUseCase {
    ValidacionSustento validar(Long tachaReclamoId, String sustento, String observaciones);
}
