package pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.mapper;

import pe.gse.generadorreportecargaoffline.domain.model.EstadoReporte;
import pe.gse.generadorreportecargaoffline.domain.model.Metadata;
import pe.gse.generadorreportecargaoffline.domain.model.ReporteCarga;
import pe.gse.generadorreportecargaoffline.infrastructure.adapters.in.rest.dto.ReporteCargaResponseDto;

import java.time.format.DateTimeFormatter;

/**
 * Mapper: ReporteCargaDtoMapper
 * Convierte entre entidades del dominio y DTOs para ReporteCarga.
 */
public class ReporteCargaDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    /**
     * Convierte ReporteCarga del dominio a ReporteCargaResponseDto.
     *
     * @param reporteCarga Entidad del dominio
     * @return DTO de respuesta
     */
    public ReporteCargaResponseDto toDto(ReporteCarga reporteCarga) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte ReporteCargaResponseDto a ReporteCarga del dominio.
     *
     * @param dto DTO de respuesta
     * @return Entidad del dominio
     */
    public ReporteCarga toDomain(ReporteCargaResponseDto dto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte EstadoReporte del dominio a EstadoReporteDto.
     *
     * @param estadoReporte Entidad del dominio
     * @return DTO
     */
    private ReporteCargaResponseDto.EstadoReporteDto toEstadoReporteDto(EstadoReporte estadoReporte) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    /**
     * Convierte Metadata del dominio a MetadataDto.
     *
     * @param metadata Entidad del dominio
     * @return DTO
     */
    private ReporteCargaResponseDto.MetadataDto toMetadataDto(Metadata metadata) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
