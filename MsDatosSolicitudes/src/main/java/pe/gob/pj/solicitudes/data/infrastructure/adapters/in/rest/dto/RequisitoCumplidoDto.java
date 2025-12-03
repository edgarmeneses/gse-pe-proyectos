package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public record RequisitoCumplidoDto(
        String requisitoId,
        String nombreRequisito,
        Boolean cumple,
        String observacion
) {
}
