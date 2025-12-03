package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class VerificarDuplicadosResponseDto {
    private final Boolean tieneDuplicados;

    public VerificarDuplicadosResponseDto(Boolean tieneDuplicados) {
        this.tieneDuplicados = tieneDuplicados;
    }

    public Boolean tieneDuplicados() { return tieneDuplicados; }
}
