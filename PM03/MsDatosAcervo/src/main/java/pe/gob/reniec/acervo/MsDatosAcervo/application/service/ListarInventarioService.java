package pe.gob.reniec.acervo.MsDatosAcervo.application.service;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in.ListarInventarioUseCase;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class ListarInventarioService implements ListarInventarioUseCase {
    private final AcervoRepository repository;

    public ListarInventarioService(AcervoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acervo ejecutar(Acervo acervo) {
        repository.listarInventario(acervo);
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
