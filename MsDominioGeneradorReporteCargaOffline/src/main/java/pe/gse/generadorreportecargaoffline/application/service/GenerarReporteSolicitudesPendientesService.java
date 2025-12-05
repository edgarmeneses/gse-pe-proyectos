package pe.gse.generadorreportecargaoffline.application.service;

import pe.gse.generadorreportecargaoffline.domain.model.ReporteCargaPendiente;
import pe.gse.generadorreportecargaoffline.domain.ports.in.GenerarReporteSolicitudesPendientesUseCase;
import pe.gse.generadorreportecargaoffline.domain.ports.out.ReporteCargaPendienteDataPort;

/**
 * Servicio de aplicación: GenerarReporteSolicitudesPendientesService
 * Implementa la lógica de negocio para generar reportes de solicitudes pendientes.
 */
public class GenerarReporteSolicitudesPendientesService implements GenerarReporteSolicitudesPendientesUseCase {

    private final ReporteCargaPendienteDataPort reporteCargaPendienteDataPort;

    public GenerarReporteSolicitudesPendientesService(ReporteCargaPendienteDataPort reporteCargaPendienteDataPort) {
        this.reporteCargaPendienteDataPort = reporteCargaPendienteDataPort;
    }

    @Override
    public ReporteCargaPendiente generar(String itineranteId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
