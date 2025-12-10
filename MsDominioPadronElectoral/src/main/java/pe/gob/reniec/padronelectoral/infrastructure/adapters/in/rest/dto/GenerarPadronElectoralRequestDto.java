package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto;

public class GenerarPadronElectoralRequestDto {
    private String tipoPadron;
    private CircunscripcionDto circunscripcion;

    public GenerarPadronElectoralRequestDto() {
    }

    public String getTipoPadron() {
        return tipoPadron;
    }

    public void setTipoPadron(String tipoPadron) {
        this.tipoPadron = tipoPadron;
    }

    public CircunscripcionDto getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(CircunscripcionDto circunscripcion) {
        this.circunscripcion = circunscripcion;
    }
}
