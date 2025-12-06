package pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.ports.in;

import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.infrastructure.adapters.in.rest.dto.CoreogDigitalizacionDto;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.model.CoreogDigitalizacion;

public interface DigitalizarDocumentoUseCase {
    CoreogDigitalizacion ejecutar(CoreogDigitalizacionDto dto);
}
