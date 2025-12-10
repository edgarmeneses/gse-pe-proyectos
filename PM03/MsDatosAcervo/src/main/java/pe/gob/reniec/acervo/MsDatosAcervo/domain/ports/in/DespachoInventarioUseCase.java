package pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.in;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public interface DespachoInventarioUseCase {
    Acervo ejecutar(Acervo acervo);
}
