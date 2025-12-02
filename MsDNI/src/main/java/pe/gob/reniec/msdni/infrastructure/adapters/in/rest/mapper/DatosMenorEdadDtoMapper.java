package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdni.domain.model.DatosMenorEdad;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.DatosMenorEdadResponseDto;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.DatosTitularMenorDto;
import pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto.ProgenitorDto;

public class DatosMenorEdadDtoMapper {
    
    public DatosMenorEdadResponseDto toResponseDto(DatosMenorEdad datosMenorEdad) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    private DatosTitularMenorDto toDatosTitularMenorDto(DatosMenorEdad datosMenorEdad) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    private ProgenitorDto toProgenitorDto(DatosMenorEdad.Progenitor progenitor) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
