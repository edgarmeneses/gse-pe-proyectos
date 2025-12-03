package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Verificacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.VerificarFirmaRegistradorUseCase;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.VerificarFirmaRegistradorRequestDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.VerificarFirmaRegistradorResponseDto;

/**
 * Mapper: Convierte entre DTOs de REST y objetos de dominio para Verificar Firma
 */
public class VerificarFirmaRegistradorDtoMapper {
    
    /**
     * Convierte el DTO de request a comando del caso de uso
     */
    public VerificarFirmaRegistradorUseCase.VerificarFirmaRegistradorCommand toCommand(VerificarFirmaRegistradorRequestDto requestDto) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte la verificación del dominio a DTO de response
     */
    public VerificarFirmaRegistradorResponseDto toResponseDto(Verificacion verificacion) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Crea un DTO de error para respuestas de error
     */
    public VerificarFirmaRegistradorResponseDto toErrorResponseDto(String tipo, String titulo, Integer estado, String detalleError) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
