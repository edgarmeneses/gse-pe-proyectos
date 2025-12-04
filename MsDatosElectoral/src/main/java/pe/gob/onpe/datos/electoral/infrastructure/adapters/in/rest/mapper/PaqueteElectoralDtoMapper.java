package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.PaqueteElectoral;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.PaqueteElectoralRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.PaqueteElectoralResponseDto;

public class PaqueteElectoralDtoMapper {
    
    public static PaqueteElectoral toDomain(PaqueteElectoralRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        
        PaqueteElectoral paqueteElectoral = new PaqueteElectoral();
        paqueteElectoral.setNumeroPaquete(requestDto.getNumeroPaquete());
        paqueteElectoral.setEstado(requestDto.getEstado());
        paqueteElectoral.setFechaRecepcion(requestDto.getFechaRecepcion());
        paqueteElectoral.setUbicacion(requestDto.getUbicacion());
        paqueteElectoral.setObservaciones(requestDto.getObservaciones());
        return paqueteElectoral;
    }
    
    public static PaqueteElectoralResponseDto toResponseDto(PaqueteElectoral paqueteElectoral) {
        if (paqueteElectoral == null) {
            return null;
        }
        
        PaqueteElectoralResponseDto dto = new PaqueteElectoralResponseDto();
        dto.setId(paqueteElectoral.getId());
        dto.setNumeroPaquete(paqueteElectoral.getNumeroPaquete());
        dto.setEstado(paqueteElectoral.getEstado());
        dto.setFechaRecepcion(paqueteElectoral.getFechaRecepcion());
        dto.setUbicacion(paqueteElectoral.getUbicacion());
        dto.setObservaciones(paqueteElectoral.getObservaciones());
        return dto;
    }
}
