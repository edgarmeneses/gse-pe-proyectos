package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.out.persistence.entity.DocumentoEntity;

public class DocumentoPersistenceMapper {

    public static DocumentoEntity toEntity(Documento documento) {
        return new DocumentoEntity(
            documento.getId(),
            documento.getArchivoBase64(),
            documento.getCarpetaId(),
            documento.getMetadata(),
            documento.getEstadoDocumento(),
            documento.getCreatedAt(),
            documento.getUpdatedAt()
        );
    }

    public static Documento toDomain(DocumentoEntity entity) {
        return new Documento(
            entity.getId(),
            entity.getArchivoBase64(),
            entity.getCarpetaId(),
            entity.getMetadata(),
            entity.getEstadoDocumento(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
