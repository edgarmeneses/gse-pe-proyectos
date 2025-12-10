package pe.gob.reniec.acervo.MsDatosAcervo.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out.AcervoRepository;
import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public class AcervoRepositoryAdapter implements AcervoRepository {
    @Override
    public void adjuntarResolucionJNAC(Acervo acervo) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void recepcionarLibroRegistra(Acervo acervo) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void listarInventario(Acervo acervo) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void despachoInventario(Acervo acervo) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }

    @Override
    public void registrarAcervo(Acervo acervo) {
        throw new UnsupportedOperationException("Pendiente de implementación");
    }
}
