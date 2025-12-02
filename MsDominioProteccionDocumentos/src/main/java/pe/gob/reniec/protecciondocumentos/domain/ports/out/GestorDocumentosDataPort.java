package pe.gob.reniec.protecciondocumentos.domain.ports.out;

import pe.gob.reniec.protecciondocumentos.domain.model.ArchivoProtegido;

public interface GestorDocumentosDataPort {
    byte[] obtenerDocumento(String repositorioId, String documentoId, String versionId);
    ArchivoProtegido almacenarDocumentoProtegido(String nombreArchivo, byte[] contenido, String checksumSHA256);
}
