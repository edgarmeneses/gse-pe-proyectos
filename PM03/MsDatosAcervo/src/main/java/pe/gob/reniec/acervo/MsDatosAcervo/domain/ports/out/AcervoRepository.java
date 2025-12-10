package pe.gob.reniec.acervo.MsDatosAcervo.domain.ports.out;

import pe.gob.reniec.acervo.MsDatosAcervo.domain.model.Acervo;

public interface AcervoRepository {
    void adjuntarResolucionJNAC(Acervo acervo);
    void recepcionarLibroRegistra(Acervo acervo);
    void listarInventario(Acervo acervo);
    void despachoInventario(Acervo acervo);
    void registrarAcervo(Acervo acervo);
}
