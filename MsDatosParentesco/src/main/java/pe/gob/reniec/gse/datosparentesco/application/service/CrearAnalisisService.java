package pe.gob.reniec.gse.datosparentesco.application.service;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.domain.ports.in.CrearAnalisisUseCase;
import pe.gob.reniec.gse.datosparentesco.domain.ports.out.AnalisisRepositoryPort;

public class CrearAnalisisService implements CrearAnalisisUseCase {
    private final AnalisisRepositoryPort analisisRepositoryPort;

    public CrearAnalisisService(AnalisisRepositoryPort analisisRepositoryPort) {
        this.analisisRepositoryPort = analisisRepositoryPort;
    }

    @Override
    public Analisis crear(Analisis analisis) {
        return analisisRepositoryPort.guardar(analisis);
    }
}
