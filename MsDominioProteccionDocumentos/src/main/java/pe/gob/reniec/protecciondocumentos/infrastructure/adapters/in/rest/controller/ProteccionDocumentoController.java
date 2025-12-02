package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.protecciondocumentos.domain.model.ProteccionDocumento;
import pe.gob.reniec.protecciondocumentos.domain.model.SolicitudProteccion;
import pe.gob.reniec.protecciondocumentos.domain.ports.in.CrearProteccionDocumentoUseCase;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.ProteccionDocumentoRequestDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.ProteccionDocumentoResponseDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.mapper.ProteccionDocumentoDtoMapper;

import java.util.Map;

public class ProteccionDocumentoController {

    private final CrearProteccionDocumentoUseCase crearProteccionDocumentoUseCase;
    private final ProteccionDocumentoDtoMapper mapper;

    public ProteccionDocumentoController(CrearProteccionDocumentoUseCase crearProteccionDocumentoUseCase) {
        this.crearProteccionDocumentoUseCase = crearProteccionDocumentoUseCase;
        this.mapper = new ProteccionDocumentoDtoMapper();
    }

    /**
     * Endpoint: POST /api/v1/documentos/MsProteccionDocumentos/comprimir-proteger
     * 
     * Este método representa el endpoint para comprimir y proteger un documento.
     * En una implementación real con framework web, este método estaría anotado apropiadamente.
     * 
     * @param requestDto El cuerpo de la solicitud con los datos del documento a proteger
     * @param headers Mapa con los headers de la solicitud (Authorization, X-Correlation-ID, etc.)
     * @return ProteccionDocumentoResponseDto con el resultado de la operación
     */
    public ProteccionDocumentoResponseDto comprimirYProtegerDocumento(
            ProteccionDocumentoRequestDto requestDto, 
            Map<String, String> headers) {
        
        // Extraer headers relevantes
        String correlationId = headers.getOrDefault("X-Correlation-ID", "");
        String version = "v1";

        // Convertir DTO a modelo de dominio
        SolicitudProteccion solicitudProteccion = mapper.toDomain(requestDto);

        // Ejecutar caso de uso
        ProteccionDocumento proteccionDocumento = crearProteccionDocumentoUseCase.crearProteccionDocumento(solicitudProteccion);

        // Convertir resultado a DTO de respuesta
        return mapper.toResponseDto(proteccionDocumento, correlationId, version);
    }
}
