package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Evaluacion;
import pe.gob.reniec.coreog.validadordocumentos.domain.ports.in.CalificarDocumentoUseCase;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.CalificarDocumentoRequestDto;
import pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto.CalificarDocumentoResponseDto;

/**
 * Mapper: Convierte entre DTOs de REST y objetos de dominio para Calificar Documento
 */
public class CalificarDocumentoDtoMapper {
    
    /**
     * Convierte el DTO de request a comando del caso de uso
     */
    public CalificarDocumentoUseCase.CalificarDocumentoCommand toCommand(CalificarDocumentoRequestDto requestDto) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Convierte la evaluación del dominio a DTO de response
     */
    public CalificarDocumentoResponseDto toResponseDto(Evaluacion evaluacion) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
    
    /**
     * Crea un DTO de error para respuestas de error
     */
    public CalificarDocumentoResponseDto toErrorResponseDto(String tipo, String titulo, Integer estado, String detalleError) {
        // TODO: Implementar conversión completa
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
