package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Visita;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.VisitaRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.VisitaResponseDto;

public class VisitaDtoMapper {
    
    public static Visita toDomain(VisitaRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        
        Visita visita = new Visita();
        visita.setFechaVisita(requestDto.getFechaVisita());
        visita.setLugar(requestDto.getLugar());
        visita.setObservaciones(requestDto.getObservaciones());
        visita.setResponsable(requestDto.getResponsable());
        return visita;
    }
    
    public static VisitaResponseDto toResponseDto(Visita visita) {
        if (visita == null) {
            return null;
        }
        
        VisitaResponseDto dto = new VisitaResponseDto();
        dto.setId(visita.getId());
        dto.setFechaVisita(visita.getFechaVisita());
        dto.setLugar(visita.getLugar());
        dto.setObservaciones(visita.getObservaciones());
        dto.setResponsable(visita.getResponsable());
        return dto;
    }
}
