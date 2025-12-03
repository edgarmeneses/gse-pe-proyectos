package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Documento;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import java.time.format.DateTimeFormatter;

/**
 * Mapper: Conversión entre DTOs y Documento del dominio
 */
public class DocumentoDtoMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static Documento toDomain(CrearDocumentoRequestDto dto) {
        Documento documento = new Documento();
        documento.setArchivoBase64(dto.archivoBase64());
        documento.setCarpetaId(dto.carpetaId());
        documento.setMetadata(dto.metadata());
        return documento;
    }

    public static Documento toDomain(ActualizarDocumentoRequestDto dto) {
        Documento documento = new Documento();
        documento.setArchivoBase64(dto.archivoBase64());
        documento.setCarpetaId(dto.carpetaId());
        documento.setMetadata(dto.metadata());
        documento.setEstadoDocumento(dto.estadoDocumento());
        return documento;
    }

    public static CrearDocumentoResponseDto toCrearResponseDto(Documento documento) {
        return new CrearDocumentoResponseDto(
            documento.getId(),
            documento.getMetadata(),
            documento.getCreatedAt() != null ? documento.getCreatedAt().format(FORMATTER) : null,
            documento.getEstadoDocumento()
        );
    }

    public static ConsultarDocumentoResponseDto toConsultarResponseDto(Documento documento) {
        return new ConsultarDocumentoResponseDto(
            documento.getArchivoBase64(),
            documento.getCarpetaId(),
            documento.getMetadata(),
            documento.getEstadoDocumento()
        );
    }

    public static ActualizarDocumentoResponseDto toActualizarResponseDto(Documento documento) {
        // La lista de campos actualizados debería construirse según la lógica de negocio
        return new ActualizarDocumentoResponseDto(
            documento.getId(),
            null, // camposActualizados
            documento.getUpdatedAt() != null ? documento.getUpdatedAt().format(FORMATTER) : null,
            documento.getEstadoDocumento()
        );
    }
}
