package pe.gob.reniec.acervo.MsDatosAcervo.application.service;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in.DespachoInventarioUseCase;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class DespachoInventarioService implements DespachoInventarioUseCase {
    private final AcervoRepository repository;

    public DespachoInventarioService(AcervoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acervo ejecutar(Acervo acervo) {
        repository.despachoInventario(acervo);
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
