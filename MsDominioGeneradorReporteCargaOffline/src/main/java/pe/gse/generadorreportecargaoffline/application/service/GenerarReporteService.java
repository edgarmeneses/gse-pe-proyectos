package pe.gse.generadorreportecargaoffline.application.service;

import pe.gse.generadorreportecargaoffline.domain.model.ReporteCarga;
import pe.gse.generadorreportecargaoffline.domain.ports.in.GenerarReporteUseCase;
import pe.gse.generadorreportecargaoffline.domain.ports.out.ReporteCargaDataPort;

/**
 * Servicio de aplicación: GenerarReporteService
 * Implementa la lógica de negocio para generar reportes de carga de trámites.
 */
public class GenerarReporteService implements GenerarReporteUseCase {

    private final ReporteCargaDataPort reporteCargaDataPort;

    public GenerarReporteService(ReporteCargaDataPort reporteCargaDataPort) {
        this.reporteCargaDataPort = reporteCargaDataPort;
    }

    @Override
    public ReporteCarga generar(String idCargueTramite) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
