package pe.gob.reniec.acervo.MsDatosAcervo.application.service;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in.RecepcionarLibroRegistraUseCase;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class RecepcionarLibroRegistraService implements RecepcionarLibroRegistraUseCase {
    private final AcervoRepository repository;

    public RecepcionarLibroRegistraService(AcervoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acervo ejecutar(Acervo acervo) {
        repository.recepcionarLibroRegistra(acervo);
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
