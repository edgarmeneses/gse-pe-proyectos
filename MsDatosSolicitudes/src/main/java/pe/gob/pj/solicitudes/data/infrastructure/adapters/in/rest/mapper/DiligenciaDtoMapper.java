package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Diligencia;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.DiligenciaRequestDto;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.DiligenciaResponseDto;

public class DiligenciaDtoMapper {
    
    public static Diligencia toDomain(DiligenciaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        Diligencia diligencia = new Diligencia();
        diligencia.setNumeroDiligencia(dto.numeroDiligencia());
        diligencia.setFechaDiligencia(dto.fechaDiligencia());
        diligencia.setTipoDiligencia(dto.tipoDiligencia());
        diligencia.setEstado(dto.estado());
        diligencia.setDescripcion(dto.descripcion());
        
        return diligencia;
    }
    
    public static DiligenciaResponseDto toDto(Diligencia diligencia) {
        if (diligencia == null) {
            return null;
        }
        
        return new DiligenciaResponseDto(
            diligencia.getId(),
            diligencia.getNumeroDiligencia(),
            diligencia.getFechaDiligencia(),
            diligencia.getTipoDiligencia(),
            diligencia.getEstado(),
            diligencia.getDescripcion(),
            diligencia.getSolicitudId()
        );
    }
}
