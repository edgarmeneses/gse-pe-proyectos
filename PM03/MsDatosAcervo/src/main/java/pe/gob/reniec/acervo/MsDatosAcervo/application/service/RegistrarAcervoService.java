package pe.gob.reniec.acervo.MsDatosAcervo.application.service;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in.RegistrarAcervoUseCase;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class RegistrarAcervoService implements RegistrarAcervoUseCase {
    private final AcervoRepository repository;

    public RegistrarAcervoService(AcervoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acervo ejecutar(Acervo acervo) {
        repository.registrarAcervo(acervo);
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
