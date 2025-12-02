package pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.gse.datosparentesco.domain.model.Analisis;
import pe.gob.reniec.gse.datosparentesco.infrastructure.adapters.in.rest.dto.*;
import java.util.List;

public class AnalisisDtoMapper {

    public Analisis toDomain(AnalisisRequestDto dto) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public AnalisisResponseDto toResponseDto(Analisis analisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public AnalisisDetalleResponseDto toDetalleResponseDto(Analisis analisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public AnalisisListaResponseDto toListaResponseDto(List<Analisis> analisisList) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public Analisis toActualizacionDomain(ActualizarAnalisisRequestDto dto) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public ActualizarAnalisisResponseDto toActualizarResponseDto(Analisis analisis) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
