package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.TachaReclamoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.TachaReclamoResponseDto;

public class TachaReclamoDtoMapper {

    public static TachaReclamo toDomain(TachaReclamoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        TachaReclamo tachaReclamo = new TachaReclamo();
        tachaReclamo.setTipo(dto.getTipo());
        tachaReclamo.setNumeroExpediente(dto.getNumeroExpediente());
        tachaReclamo.setSolicitante(dto.getSolicitante());
        tachaReclamo.setDescripcion(dto.getDescripcion());
        tachaReclamo.setSustento(dto.getSustento());
        tachaReclamo.setDocumentos(dto.getDocumentos());

        return tachaReclamo;
    }

    public static TachaReclamoResponseDto toResponseDto(TachaReclamo tachaReclamo, String statusCode, String message) {
        if (tachaReclamo == null) {
            return null;
        }

        TachaReclamoResponseDto dto = new TachaReclamoResponseDto();
        dto.setId(tachaReclamo.getId());
        dto.setNumeroExpediente(tachaReclamo.getNumeroExpediente());
        dto.setTipo(tachaReclamo.getTipo());
        dto.setEstado(tachaReclamo.getEstado());
        dto.setFechaRegistro(tachaReclamo.getFechaRegistro());
        dto.setStatusCode(statusCode);
        dto.setMessage(message);

        return dto;
    }
}
