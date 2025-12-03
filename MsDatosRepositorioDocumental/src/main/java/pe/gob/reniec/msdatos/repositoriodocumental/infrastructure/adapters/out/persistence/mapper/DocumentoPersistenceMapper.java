package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.DocumentoEntity;

/**
 * Mapper de persistencia: Documento
 * Convierte entre Documento del dominio y DocumentoEntity de persistencia.
 */
public class DocumentoPersistenceMapper {

    public static DocumentoEntity toEntity(Documento documento) {
        if (documento == null) {
            return null;
        }
        
        DocumentoEntity entity = new DocumentoEntity();
        entity.setId(documento.getId());
        entity.setArchivoBase64(documento.getArchivoBase64());
        entity.setCarpetaId(documento.getCarpetaId());
        entity.setMetadata(documento.getMetadata());
        entity.setEstadoDocumento(documento.getEstadoDocumento());
        entity.setCreatedAt(documento.getCreatedAt());
        entity.setUpdatedAt(documento.getUpdatedAt());
        
        return entity;
    }

    public static Documento toDomain(DocumentoEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Documento documento = new Documento();
        documento.setId(entity.getId());
        documento.setArchivoBase64(entity.getArchivoBase64());
        documento.setCarpetaId(entity.getCarpetaId());
        documento.setMetadata(entity.getMetadata());
        documento.setEstadoDocumento(entity.getEstadoDocumento());
        documento.setCreatedAt(entity.getCreatedAt());
        documento.setUpdatedAt(entity.getUpdatedAt());
        
        return documento;
    }
}
