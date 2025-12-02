package pe.gob.reniec.protecciondocumentos.domain.ports.out;

import pe.gob.reniec.protecciondocumentos.domain.model.ProteccionDocumento;

public interface ProteccionDocumentoDataPort {
    ProteccionDocumento guardarProteccionDocumento(ProteccionDocumento proteccionDocumento);
    ProteccionDocumento obtenerProteccionDocumentoPorId(String proteccionId);
    boolean existeProteccionPorSolicitudId(String solicitudId);
}
