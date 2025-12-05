package pe.gse.generadorreportecargaoffline.domain.ports.in;

import pe.gse.generadorreportecargaoffline.domain.model.ReporteCarga;

/**
 * Puerto de entrada: GenerarReporteUseCase
 * Define el contrato para generar el reporte del procesamiento de un lote de trámites.
 */
public interface GenerarReporteUseCase {

    /**
     * Genera el reporte de carga de trámites offline.
     *
     * @param idCargueTramite ID del lote de carga de trámites
     * @return ReporteCarga con la información del reporte generado
     */
    ReporteCarga generar(String idCargueTramite);
}
