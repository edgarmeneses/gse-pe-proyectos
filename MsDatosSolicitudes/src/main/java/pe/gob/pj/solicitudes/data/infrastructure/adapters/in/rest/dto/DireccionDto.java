package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class DireccionDto {
    private final String departamento;
    private final String provincia;
    private final String distrito;
    private final String direccionCompleta;

    public DireccionDto(String departamento, String provincia, String distrito, String direccionCompleta) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccionCompleta = direccionCompleta;
    }

    public String departamento() { return departamento; }
    public String provincia() { return provincia; }
    public String distrito() { return distrito; }
    public String direccionCompleta() { return direccionCompleta; }
}
