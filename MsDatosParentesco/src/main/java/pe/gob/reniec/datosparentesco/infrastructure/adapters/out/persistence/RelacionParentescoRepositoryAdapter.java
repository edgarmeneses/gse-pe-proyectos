package pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence;

import pe.gob.reniec.datosparentesco.domain.model.RelacionParentesco;
import pe.gob.reniec.datosparentesco.domain.model.Ciudadano;
import pe.gob.reniec.datosparentesco.domain.ports.out.RelacionParentescoRepositoryPort;
import pe.gob.reniec.datosparentesco.infrastructure.adapters.out.persistence.mapper.RelacionParentescoPersistenceMapper;
import java.util.List;

/**
 * Adaptador de repositorio para operaciones de persistencia de RelacionParentesco.
 * Implementa el puerto de salida sin usar tecnología específica (sin JPA, JDBC, etc.).
 */
public class RelacionParentescoRepositoryAdapter implements RelacionParentescoRepositoryPort {
    
    private final RelacionParentescoPersistenceMapper mapper;
    
    public RelacionParentescoRepositoryAdapter(RelacionParentescoPersistenceMapper mapper) {
        this.mapper = mapper;
    }
    
    @Override
    public RelacionParentesco guardar(RelacionParentesco relacionParentesco) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere driver de BD específico");
    }
    
    @Override
    public List<RelacionParentesco> buscarPorCiudadano(String idCiudadano, String tipoParentesco, 
                                                       Integer gradoMaximo, Boolean incluirInactivos) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere driver de BD específico");
    }
    
    @Override
    public Ciudadano buscarCiudadano(String idCiudadano) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere driver de BD específico");
    }
    
    @Override
    public boolean existeRelacion(String idCiudadanoOrigen, String idCiudadanoDestino, String tipoParentesco) {
        throw new UnsupportedOperationException("Implementación pendiente - requiere driver de BD específico");
    }
}
