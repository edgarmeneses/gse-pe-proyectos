package pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.application.service;

import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.model.CoreogDigitalizacion;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.ports.in.DigitalizarDocumentoUseCase;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.domain.ports.out.CoreogDigitalizacionDataPort;
import pe.gob.reniec.digitalizacion.MsCoreogDigitalizacion.infrastructure.adapters.in.rest.dto.CoreogDigitalizacionDto;

public class DigitalizarDocumentoService implements DigitalizarDocumentoUseCase {
    private final CoreogDigitalizacionDataPort dataPort;

    public DigitalizarDocumentoService(CoreogDigitalizacionDataPort dataPort) {
        this.dataPort = dataPort;
    }

    @Override
    public CoreogDigitalizacion ejecutar(CoreogDigitalizacionDto dto) {
        throw new UnsupportedOperationException("Pendiente");
    }
}
