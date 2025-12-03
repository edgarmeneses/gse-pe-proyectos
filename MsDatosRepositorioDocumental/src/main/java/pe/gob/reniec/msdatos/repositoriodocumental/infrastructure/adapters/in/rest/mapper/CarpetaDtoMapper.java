package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.*;
import java.time.format.DateTimeFormatter;

/**
 * Mapper: Conversión entre DTOs y Carpeta del dominio
 */
public class CarpetaDtoMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static Carpeta toDomain(CrearCarpetaRequestDto dto) {
        Carpeta carpeta = new Carpeta();
        carpeta.setNombre(dto.nombre());
        carpeta.setParentId(dto.parentId());
        carpeta.setDescripcion(dto.descripcion());
        return carpeta;
    }

    public static Carpeta toDomain(ActualizarCarpetaRequestDto dto) {
        Carpeta carpeta = new Carpeta();
        carpeta.setNombre(dto.nombre());
        carpeta.setEstadoCarpeta(dto.estadoCarpeta());
        carpeta.setParentId(dto.parentId());
        carpeta.setDescripcion(dto.descripcion());
        return carpeta;
    }

    public static CrearCarpetaResponseDto toCrearResponseDto(Carpeta carpeta) {
        return new CrearCarpetaResponseDto(
            carpeta.getId(),
            carpeta.getCreatedAt() != null ? carpeta.getCreatedAt().format(FORMATTER) : null,
            carpeta.getEstadoCarpeta(),
            carpeta.getRuta()
        );
    }

    public static ActualizarCarpetaResponseDto toActualizarResponseDto(Carpeta carpeta) {
        return new ActualizarCarpetaResponseDto(
            carpeta.getId(),
            carpeta.getUpdatedAt() != null ? carpeta.getUpdatedAt().format(FORMATTER) : null,
            null // camposActualizados - debería construirse según la lógica de negocio
        );
    }
}
