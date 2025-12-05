package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto;

/**
 * DTO de Request: ReporteCargaRequestDto
 * Representa la solicitud para generar un reporte de carga.
 */
public class ReporteCargaRequestDto {

    private String idCargueTramite;

    public ReporteCargaRequestDto() {
    }

    public ReporteCargaRequestDto(String idCargueTramite) {
        this.idCargueTramite = idCargueTramite;
    }

    public String getIdCargueTramite() {
        return idCargueTramite;
    }

    public void setIdCargueTramite(String idCargueTramite) {
        this.idCargueTramite = idCargueTramite;
    }
}
