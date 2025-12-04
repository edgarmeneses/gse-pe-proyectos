package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.Impugnacion;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.ImpugnacionResponseDto;

public class ImpugnacionDtoMapper {
    
    public static ImpugnacionResponseDto toResponseDto(Impugnacion impugnacion) {
        if (impugnacion == null) {
            return null;
        }
        
        ImpugnacionResponseDto dto = new ImpugnacionResponseDto();
        dto.setId(impugnacion.getId());
        dto.setNumeroImpugnacion(impugnacion.getNumeroImpugnacion());
        dto.setFechaRegistro(impugnacion.getFechaRegistro());
        dto.setEstado(impugnacion.getEstado());
        dto.setDescripcion(impugnacion.getDescripcion());
        dto.setTipo(impugnacion.getTipo());
        return dto;
    }
}
