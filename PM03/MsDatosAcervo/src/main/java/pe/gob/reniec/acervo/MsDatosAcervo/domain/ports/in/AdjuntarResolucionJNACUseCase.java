package pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public interface AdjuntarResolucionJNACUseCase {
    Acervo ejecutar(Acervo acervo);
}
