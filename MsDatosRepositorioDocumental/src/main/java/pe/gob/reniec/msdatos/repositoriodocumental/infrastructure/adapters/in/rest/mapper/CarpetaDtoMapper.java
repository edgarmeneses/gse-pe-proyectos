package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatos.repositoriodocumental.domain.model.Carpeta;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.CarpetaResponseDto;
import pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto.ActualizarCarpetaResponseDto;
import java.util.List;

public class CarpetaDtoMapper {

    public static CarpetaResponseDto toResponseDto(Carpeta carpeta) {
        return new CarpetaResponseDto(
            carpeta.getId(),
            carpeta.getCreatedAt(),
            carpeta.getEstadoCarpeta(),
            carpeta.getRuta()
        );
    }

    public static ActualizarCarpetaResponseDto toActualizarResponseDto(Carpeta carpeta, List<String> camposActualizados) {
        return new ActualizarCarpetaResponseDto(
            carpeta.getId(),
            carpeta.getUpdatedAt(),
            camposActualizados
        );
    }
}
