package pe.gob.pj.solicitudes.data.domain.ports.in;

public interface VerificarDuplicadosUseCase {
    
    Boolean ejecutar(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento,
                     String usuarioId, Long limit, Long offset, String ordenamiento,
                     Boolean incluirDatosDetallados);
}
