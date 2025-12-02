package pe.gob.reniec.msdatos.repositoriodocumental.application.service;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.in.CrearCarpetaUseCase;
import pe.gob.reniec.msdatos.repositoriodocumental.domain.ports.out.CarpetaRepositoryPort;

public class CrearCarpetaService implements CrearCarpetaUseCase {
    private final CarpetaRepositoryPort carpetaRepositoryPort;

    public CrearCarpetaService(CarpetaRepositoryPort carpetaRepositoryPort) {
        this.carpetaRepositoryPort = carpetaRepositoryPort;
    }

    @Override
    public Carpeta crear(String nombre, String parentId, String descripcion) {
        Carpeta carpeta = new Carpeta();
        carpeta.setNombre(nombre);
        carpeta.setParentId(parentId);
        carpeta.setDescripcion(descripcion);
        return carpetaRepositoryPort.guardar(carpeta);
    }
}
