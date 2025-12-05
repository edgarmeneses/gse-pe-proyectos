package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.controller;

import pe.gse.generadorreportecargaoffline.domain.ports.in.GenerarReporteUseCase;
import pe.gse.generadorreportecargaoffline.domain.ports.in.GenerarReporteSolicitudesPendientesUseCase;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaRequestDto;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaResponseDto;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaPendienteRequestDto;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaPendienteResponseDto;

/**
 * Controller: GeneradorReporteCargaOfflineController
 * Maneja las solicitudes HTTP para generación de reportes de carga offline.
 *
 * IMPORTANTE: Esta clase es un POJO sin anotaciones de frameworks.
 * La configuración de rutas y métodos HTTP debe realizarse externamente.
 */
public class GeneradorReporteCargaOfflineController {

    private final GenerarReporteUseCase generarReporteUseCase;
    private final GenerarReporteSolicitudesPendientesUseCase generarReporteSolicitudesPendientesUseCase;

    public GeneradorReporteCargaOfflineController(
            GenerarReporteUseCase generarReporteUseCase,
            GenerarReporteSolicitudesPendientesUseCase generarReporteSolicitudesPendientesUseCase) {
        this.generarReporteUseCase = generarReporteUseCase;
        this.generarReporteSolicitudesPendientesUseCase = generarReporteSolicitudesPendientesUseCase;
    }

    /**
     * Endpoint: POST /api/v1/tramite/MsDominioGeneradorReporteCargaOffline/regenerarreporte/
     * Genera el reporte del procesamiento de un lote de trámites.
     *
     * @param request DTO con el ID del cargue de trámite
     * @return ReporteCargaResponseDto con el reporte generado
     */
    public ReporteCargaResponseDto generarReporte(ReporteCargaRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Endpoint: POST /api/v1/tramite/MsDominioGeneradorReporteCargaOffline/generarreporte-pendiente
     * Genera el reporte de solicitudes pendientes para un itinerante.
     *
     * @param request DTO con el ID del itinerante
     * @return ReporteCargaPendienteResponseDto con el reporte generado
     */
    public ReporteCargaPendienteResponseDto generarReporteSolicitudesPendientes(
            ReporteCargaPendienteRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
