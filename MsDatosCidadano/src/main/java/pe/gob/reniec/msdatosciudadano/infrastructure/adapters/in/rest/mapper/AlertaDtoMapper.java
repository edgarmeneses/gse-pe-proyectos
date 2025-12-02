package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.AlertaResponseDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.CrearAlertaRequestDto;

public class AlertaDtoMapper {

    public static Alerta toDomain(CrearAlertaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        Alerta alerta = new Alerta();
        alerta.setCiudadanoId(dto.ciudadanoId());
        alerta.setSituacion(dto.situacion());
        alerta.setMotivo(dto.motivo());
        alerta.setFechaDeteccion(dto.fechaDeteccion());
        alerta.setCircunscripcionId(dto.circunscripcionId());
        alerta.setMedioVerificacion(dto.medioVerificacion());
        alerta.setDocumentoSoporteId(dto.documentoSoporteId());
        alerta.setEquipoTrabajoId(dto.equipoTrabajoId());
        
        return alerta;
    }

    public static AlertaResponseDto toResponseDto(String id, Alerta alerta) {
        return new AlertaResponseDto(id, alerta.getFechaCreacion(), alerta.getEstado());
    }
}
