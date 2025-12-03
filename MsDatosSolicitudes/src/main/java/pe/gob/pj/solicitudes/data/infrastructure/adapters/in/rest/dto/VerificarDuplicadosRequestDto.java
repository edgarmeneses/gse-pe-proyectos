package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record VerificarDuplicadosRequestDto(
        String solicitudId,
        String fechaDesde,
        String fechaHasta,
        String tipoEvento,
        String usuarioId,
        Long limit,
        Long offset,
        String ordenamiento,
        Boolean incluirDatosDetallados
) {
}
