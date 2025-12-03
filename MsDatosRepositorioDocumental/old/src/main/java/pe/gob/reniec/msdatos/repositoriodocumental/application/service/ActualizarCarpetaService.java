package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.ActualizarCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;

public class ActualizarCarpetaService implements ActualizarCarpetaUseCase {
    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public ActualizarCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public Carpeta actualizar(String id, String nombre, String estadoCarpeta, 
                            String parentId, String descripcion) {
        Carpeta carpeta = carpetaRepositoryPort.buscarPorId(id);
        if (nombre != null) {
            carpeta.setNombre(nombre);
        }
        if (estadoCarpeta != null) {
            carpeta.setEstadoCarpeta(estadoCarpeta);
        }
        if (parentId != null) {
            carpeta.setParentId(parentId);
        }
        if (descripcion != null) {
            carpeta.setDescripcion(descripcion);
        }
        return carpetaRepositoryPort.actualizar(carpeta);
    }
}
