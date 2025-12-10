package pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.mapper;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;
import pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.RespuestaBCPResponseDto;
import pe.com.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.SolicitudBCPRequestDto;

/**
 * Mapper: Conversión entre DTOs y entidades del dominio
 * Sin anotaciones de frameworks - Java puro
 */
public class BCPDtoMapper {
    
    /**
     * Convierte SolicitudBCPRequestDto a SolicitudBCP (dominio)
     * @param dto DTO de entrada
     * @return Entidad de dominio
     */
    public SolicitudBCP toDomain(SolicitudBCPRequestDto dto) {
        // Implementación stub
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte RespuestaBCP (dominio) a RespuestaBCPResponseDto
     * @param respuesta Entidad de dominio
     * @return DTO de salida
     */
    public RespuestaBCPResponseDto toDto(RespuestaBCP respuesta) {
        // Implementación stub
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
