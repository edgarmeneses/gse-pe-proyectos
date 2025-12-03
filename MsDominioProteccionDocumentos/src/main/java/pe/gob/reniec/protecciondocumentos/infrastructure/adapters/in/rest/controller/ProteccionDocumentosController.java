package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.protecciondocumentos.domain.ports.in.ComprimirYProtegerDocumentosUseCase;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.SolicitudProteccionRequestDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.RespuestaProteccionResponseDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto.ErrorResponseDto;
import pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.mapper.ProteccionDocumentosDtoMapper;

public class ProteccionDocumentosController {
    
    private final ComprimirYProtegerDocumentosUseCase comprimirYProtegerDocumentosUseCase;
    private final ProteccionDocumentosDtoMapper mapper;

    public ProteccionDocumentosController(ComprimirYProtegerDocumentosUseCase comprimirYProtegerDocumentosUseCase,
                                         ProteccionDocumentosDtoMapper mapper) {
        this.comprimirYProtegerDocumentosUseCase = comprimirYProtegerDocumentosUseCase;
        this.mapper = mapper;
    }

    public RespuestaProteccionResponseDto comprimirYProteger(SolicitudProteccionRequestDto request,
                                                             String xRequestId,
                                                             String xCorrelationId,
                                                             String xClientId,
                                                             String xUserId,
                                                             String xTenantId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
