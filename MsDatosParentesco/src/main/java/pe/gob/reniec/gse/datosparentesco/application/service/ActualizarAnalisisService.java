package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.ActualizarAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.AnalisisRepositoryPort;

public class ActualizarAnalisisService implements ActualizarAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public ActualizarAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public Analisis actualizar(String idAnalisis, Analisis analisis) {
        return analisisRepositoryPort.actualizar(idAnalisis, analisis);
    }
}
