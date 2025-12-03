package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class SiguientePasoDto {
    private final String paso;

    public SiguientePasoDto(String paso) {
        this.paso = paso;
    }

    public String paso() { return paso; }
}
