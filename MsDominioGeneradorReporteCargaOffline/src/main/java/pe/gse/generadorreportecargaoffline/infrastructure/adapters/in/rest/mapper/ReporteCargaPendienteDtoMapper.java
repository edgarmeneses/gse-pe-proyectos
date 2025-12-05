package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.mapper;

import pe.gse.generadorreportecargaoffline.domain.model.EstadoReporte;
import pe.gse.generadorreportecargaoffline.domain.model.Metadata;
import pe.gse.generadorreportecargaoffline.domain.model.ReporteCargaPendiente;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaPendienteResponseDto;

import java.time.format.DateTimeFormatter;

/**
 * Mapper: ReporteCargaPendienteDtoMapper
 * Convierte entre entidades del dominio y DTOs para ReporteCargaPendiente.
 */
public class ReporteCargaPendienteDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    /**
     * Convierte ReporteCargaPendiente del dominio a ReporteCargaPendienteResponseDto.
     *
     * @param reporteCargaPendiente Entidad del dominio
     * @return DTO de respuesta
     */
    public ReporteCargaPendienteResponseDto toDto(ReporteCargaPendiente reporteCargaPendiente) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte ReporteCargaPendienteResponseDto a ReporteCargaPendiente del dominio.
     *
     * @param dto DTO de respuesta
     * @return Entidad del dominio
     */
    public ReporteCargaPendiente toDomain(ReporteCargaPendienteResponseDto dto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte EstadoReporte del dominio a EstadoReporteDto.
     *
     * @param estadoReporte Entidad del dominio
     * @return DTO
     */
    private ReporteCargaPendienteResponseDto.EstadoReporteDto toEstadoReporteDto(EstadoReporte estadoReporte) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte Metadata del dominio a MetadataDto.
     *
     * @param metadata Entidad del dominio
     * @return DTO
     */
    private ReporteCargaPendienteResponseDto.MetadataDto toMetadataDto(Metadata metadata) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
