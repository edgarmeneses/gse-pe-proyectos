package pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.datos.electoral.domain.model.TachaReclamo;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.TachaReclamoRequestDto;
import pe.gob.onpe.datos.electoral.infrastructure.adapters.in.rest.dto.TachaReclamoResponseDto;

public class TachaReclamoDtoMapper {
    
    public static TachaReclamo toDomain(TachaReclamoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        
        TachaReclamo tachaReclamo = new TachaReclamo();
        tachaReclamo.setTipo(requestDto.getTipo());
        tachaReclamo.setNumeroExpediente(requestDto.getNumeroExpediente());
        tachaReclamo.setFechaRegistro(requestDto.getFechaRegistro());
        tachaReclamo.setEstado(requestDto.getEstado());
        tachaReclamo.setDescripcion(requestDto.getDescripcion());
        tachaReclamo.setSolicitante(requestDto.getSolicitante());
        return tachaReclamo;
    }
    
    public static TachaReclamoResponseDto toResponseDto(TachaReclamo tachaReclamo) {
        if (tachaReclamo == null) {
            return null;
        }
        
        TachaReclamoResponseDto dto = new TachaReclamoResponseDto();
        dto.setId(tachaReclamo.getId());
        dto.setTipo(tachaReclamo.getTipo());
        dto.setNumeroExpediente(tachaReclamo.getNumeroExpediente());
        dto.setFechaRegistro(tachaReclamo.getFechaRegistro());
        dto.setEstado(tachaReclamo.getEstado());
        dto.setDescripcion(tachaReclamo.getDescripcion());
        dto.setSolicitante(tachaReclamo.getSolicitante());
        return dto;
    }
}
