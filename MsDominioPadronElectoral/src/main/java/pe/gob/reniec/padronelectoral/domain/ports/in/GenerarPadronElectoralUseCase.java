package pe.gob.reniec.padronelectoral.domain.ports.in;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;

public interface GenerarPadronElectoralUseCase {
    PadronElectoral generar(String tipoPadron, String departamento, String provincia, String distrito);
}
