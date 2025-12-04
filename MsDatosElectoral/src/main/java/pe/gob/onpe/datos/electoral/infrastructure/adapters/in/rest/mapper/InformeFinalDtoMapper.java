package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.InformeFinal;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.InformeFinalRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.InformeFinalResponseDto;

public class InformeFinalDtoMapper {
    
    public static InformeFinal toDomain(InformeFinalRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        
        InformeFinal informeFinal = new InformeFinal();
        informeFinal.setNumeroInforme(requestDto.getNumeroInforme());
        informeFinal.setFechaEmision(requestDto.getFechaEmision());
        informeFinal.setContenido(requestDto.getContenido());
        informeFinal.setConclusiones(requestDto.getConclusiones());
        informeFinal.setEstado(requestDto.getEstado());
        return informeFinal;
    }
    
    public static InformeFinalResponseDto toResponseDto(InformeFinal informeFinal) {
        if (informeFinal == null) {
            return null;
        }
        
        InformeFinalResponseDto dto = new InformeFinalResponseDto();
        dto.setId(informeFinal.getId());
        dto.setNumeroInforme(informeFinal.getNumeroInforme());
        dto.setFechaEmision(informeFinal.getFechaEmision());
        dto.setContenido(informeFinal.getContenido());
        dto.setConclusiones(informeFinal.getConclusiones());
        dto.setEstado(informeFinal.getEstado());
        return dto;
    }
}
