package pe.gob.onpe.dominio.paquetes.domain.ports.in;

public interface ConfirmarRevisionPaquetesUseCase {
    void confirmarRevision(String idPadron, String tipoPadron,
                           String comentarioConfirmacion, Boolean confirmarRevisionCompleta);
}
