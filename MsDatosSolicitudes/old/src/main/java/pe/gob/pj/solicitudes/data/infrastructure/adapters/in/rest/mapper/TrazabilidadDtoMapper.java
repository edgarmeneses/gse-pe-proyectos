package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Trazabilidad;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto.TrazabilidadResponseDto;
import java.util.List;
import java.util.stream.Collectors;

public class TrazabilidadDtoMapper {
    
    public static TrazabilidadResponseDto toDto(Trazabilidad trazabilidad) {
        if (trazabilidad == null) {
            return null;
        }
        
        return new TrazabilidadResponseDto(
            trazabilidad.getId(),
            trazabilidad.getSolicitudId(),
            trazabilidad.getFecha(),
            trazabilidad.getAccion(),
            trazabilidad.getUsuario(),
            trazabilidad.getDetalle()
        );
    }
    
    public static List<TrazabilidadResponseDto> toDtoList(List<Trazabilidad> trazabilidades) {
        if (trazabilidades == null) {
            return null;
        }
        return trazabilidades.stream()
            .map(TrazabilidadDtoMapper::toDto)
            .collect(Collectors.toList());
    }
}
