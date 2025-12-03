package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.Alerta;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.AlertaDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.AlertaListResponseDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.AlertaResponseDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.CrearAlertaRequestDto;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.PageDto;

import java.util.List;
import java.util.stream.Collectors;

public class AlertaDtoMapper {

    public static Alerta toDomain(CrearAlertaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        Alerta alerta = new Alerta();
        alerta.setCiudadanoId(dto.ciudadanoId());
        alerta.setSituacion(dto.situacion() != null ? dto.situacion().name() : null);
        alerta.setMotivo(dto.motivo());
        alerta.setFechaDeteccion(dto.fechaDeteccion());
        alerta.setCircunscripcionId(dto.circunscripcionId());
        alerta.setMedioVerificacion(dto.medioVerificacion() != null ? dto.medioVerificacion().getValue() : null);
        alerta.setDocumentoSoporteId(dto.documentoSoporteId());
        alerta.setEquipoTrabajoId(dto.equipoTrabajoId());
        
        return alerta;
    }

    public static AlertaResponseDto toResponseDto(String id, Alerta alerta) {
        return new AlertaResponseDto(id, alerta.getFechaCreacion(), alerta.getEstado());
    }

    public static AlertaDto toDto(Alerta alerta) {
        if (alerta == null) return null;
        return new AlertaDto(
            alerta.getId(),
            alerta.getEstado(),
            alerta.getFechaCreacion(),
            alerta.getFechaActualizacion(),
            alerta.getSituacion(),
            alerta.getMotivo(),
            alerta.getFechaDeteccion(),
            null, // fechaMaximaDescargo no existe en domain Alerta
            alerta.getMedioVerificacion(),
            null // nivelAlerta no existe en domain Alerta
        );
    }

    public static List<AlertaDto> toDtoList(List<Alerta> alertas) {
        if (alertas == null) return List.of();
        return alertas.stream().map(AlertaDtoMapper::toDto).collect(Collectors.toList());
    }

    public static AlertaListResponseDto toListResponseDto(List<Alerta> alertas, Integer page, Integer size, Integer totalElements) {
        if (alertas == null) alertas = List.of();
        int total = totalElements != null ? totalElements : alertas.size();
        int sz = (size == null || size <= 0) ? Math.max(1, alertas.size()) : size;
        int pg = (page == null || page < 0) ? 0 : page;
        int totalPages = (int) Math.ceil((double) total / sz);
        boolean hasNext = (pg + 1) < totalPages;
        PageDto pageDto = new PageDto(pg, sz, total, totalPages, hasNext);
        return new AlertaListResponseDto(pageDto, toDtoList(alertas));
    }
}
