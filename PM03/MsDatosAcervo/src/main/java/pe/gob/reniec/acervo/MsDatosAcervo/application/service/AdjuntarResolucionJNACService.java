package pe.gob.reniec.acervo.MsDatosAcervo.application.service;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in.AdjuntarResolucionJNACUseCase;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class AdjuntarResolucionJNACService implements AdjuntarResolucionJNACUseCase {
    private final AcervoRepository repository;

    public AdjuntarResolucionJNACService(AcervoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acervo ejecutar(Acervo acervo) {
        repository.adjuntarResolucionJNAC(acervo);
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
