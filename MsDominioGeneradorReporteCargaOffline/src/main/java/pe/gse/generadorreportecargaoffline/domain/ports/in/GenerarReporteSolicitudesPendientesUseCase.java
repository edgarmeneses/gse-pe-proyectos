package pe.gse.generadorreportecargaoffline.domain.ports.in;

import pe.gse.generadorreportecargaoffline.domain.model.ReporteCargaPendiente;

/**
 * Puerto de entrada: GenerarReporteSolicitudesPendientesUseCase
 * Define el contrato para generar el reporte de solicitudes pendientes de un itinerante.
 */
public interface GenerarReporteSolicitudesPendientesUseCase {

    /**
     * Genera el reporte de solicitudes pendientes para un itinerante.
     *
     * @param itineranteId ID del itinerante
     * @return ReporteCargaPendiente con la información del reporte generado
     */
    ReporteCargaPendiente generar(String itineranteId);
}
