package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto;

/**
 * DTO de Request: ReporteCargaPendienteRequestDto
 * Representa la solicitud para generar un reporte de solicitudes pendientes.
 */
public class ReporteCargaPendienteRequestDto {

    private String itineranteId;

    public ReporteCargaPendienteRequestDto() {
    }

    public ReporteCargaPendienteRequestDto(String itineranteId) {
        this.itineranteId = itineranteId;
    }

    public String getItineranteId() {
        return itineranteId;
    }

    public void setItineranteId(String itineranteId) {
        this.itineranteId = itineranteId;
    }
}
