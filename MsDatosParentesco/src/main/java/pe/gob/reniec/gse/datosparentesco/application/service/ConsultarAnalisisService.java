package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ConsultarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.AnalisisRepositoryPort;

public class ConsultarAnalisisService implements ConsultarAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public ConsultarAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public Analisis consultarPorId(String idAnalisis) {
        return analisisRepositoryPort.consultarPorId(idAnalisis);
    }
}
