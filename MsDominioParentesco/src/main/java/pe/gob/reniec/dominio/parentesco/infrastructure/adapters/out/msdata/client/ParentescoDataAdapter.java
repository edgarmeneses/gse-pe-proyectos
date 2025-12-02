package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominio.parentesco.domain.model.AnalisisParentesco;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.ParentescoDataPort;

public class ParentescoDataAdapter implements ParentescoDataPort {

    @Override
    public AnalisisParentesco crearAnalisis(AnalisisParentesco analisis) {
        throw new UnsupportedOperationException("Implementación pendiente: crear análisis en MsDatosParentesco");
    }

    @Override
    public AnalisisParentesco actualizarAnalisis(AnalisisParentesco analisis) {
        throw new UnsupportedOperationException("Implementación pendiente: actualizar análisis en MsDatosParentesco");
    }

    @Override
    public AnalisisParentesco consultarAnalisis(String idAnalisis) {
        throw new UnsupportedOperationException("Implementación pendiente: consultar análisis desde MsDatosParentesco");
    }
}
