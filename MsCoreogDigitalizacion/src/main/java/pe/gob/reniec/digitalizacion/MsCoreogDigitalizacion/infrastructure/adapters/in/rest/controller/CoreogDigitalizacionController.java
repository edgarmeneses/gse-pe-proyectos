package pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.model.CoreogDigitalizacion;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.ports.in.DigitalizarDocumentoUseCase;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.infrastructure.adapters.in.rest.dto.CoreogDigitalizacionDto;

public class CoreogDigitalizacionController {
    private final DigitalizarDocumentoUseCase useCase;

    public CoreogDigitalizacionController(DigitalizarDocumentoUseCase useCase) {
        this.useCase = useCase;
    }

    public CoreogDigitalizacion digitalizar(CoreogDigitalizacionDto dto) {
        return useCase.ejecutar(dto);
    }
}
