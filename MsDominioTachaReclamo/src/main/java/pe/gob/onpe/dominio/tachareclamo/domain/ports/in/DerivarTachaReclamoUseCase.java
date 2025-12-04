package pe.gob.onpe.dominio.tachareclamo.domain.ports.in;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Derivacion;

public interface DerivarTachaReclamoUseCase {
    Derivacion derivar(Long tachaReclamoId, String areaDestino, String responsable, String observaciones);
}
