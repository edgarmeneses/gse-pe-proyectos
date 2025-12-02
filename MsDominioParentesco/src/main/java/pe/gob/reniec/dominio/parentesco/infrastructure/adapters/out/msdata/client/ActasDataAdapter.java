package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.dominio.parentesco.domain.model.ActaSustento;
import pe.gob.reniec.dominio.parentesco.domain.ports.out.ActasDataPort;

import java.util.List;

public class ActasDataAdapter implements ActasDataPort {

    @Override
    public List<ActaSustento> consultarActasNacimiento(String idCiudadano) {
        throw new UnsupportedOperationException("Implementación pendiente: consultar actas de nacimiento desde MsDatosActas");
    }

    @Override
    public List<ActaSustento> consultarActasMatrimonio(String idCiudadano) {
        throw new UnsupportedOperationException("Implementación pendiente: consultar actas de matrimonio desde MsDatosActas");
    }

    @Override
    public List<ActaSustento> consultarActasDefuncion(String idCiudadano) {
        throw new UnsupportedOperationException("Implementación pendiente: consultar actas de defunción desde MsDatosActas");
    }
}
