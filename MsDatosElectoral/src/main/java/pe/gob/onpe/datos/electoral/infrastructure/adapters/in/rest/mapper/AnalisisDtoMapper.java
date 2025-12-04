package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.AnalisisRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.AnalisisResponseDto;

public class AnalisisDtoMapper {
    
    public static Analisis toDomain(AnalisisRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        
        Analisis analisis = new Analisis();
        analisis.setTipoAnalisis(requestDto.getTipoAnalisis());
        analisis.setFechaAnalisis(requestDto.getFechaAnalisis());
        analisis.setResultado(requestDto.getResultado());
        analisis.setObservaciones(requestDto.getObservaciones());
        analisis.setEstado(requestDto.getEstado());
        return analisis;
    }
    
    public static AnalisisResponseDto toResponseDto(Analisis analisis) {
        if (analisis == null) {
            return null;
        }
        
        AnalisisResponseDto dto = new AnalisisResponseDto();
        dto.setId(analisis.getId());
        dto.setTipoAnalisis(analisis.getTipoAnalisis());
        dto.setFechaAnalisis(analisis.getFechaAnalisis());
        dto.setResultado(analisis.getResultado());
        dto.setObservaciones(analisis.getObservaciones());
        dto.setEstado(analisis.getEstado());
        return dto;
    }
}
