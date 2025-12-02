package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.padron.paquetes.domain.model.AprobacionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConfirmacionRevisionResult;
import pe.gob.reniec.padron.paquetes.domain.model.ConsultaPaquetesResult;
import pe.gob.reniec.padron.paquetes.domain.ports.in.AprobarPaqueteUseCase;
import pe.gob.reniec.padron.paquetes.domain.ports.in.ConfirmarRevisionPaquetesUseCase;
import pe.gob.reniec.padron.paquetes.domain.ports.in.ConsultarPaquetesUseCase;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.AprobarPaqueteRequestDto;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.AprobarPaqueteResponseDto;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.ConfirmarRevisionRequestDto;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.ConfirmarRevisionResponseDto;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.ConsultaPaquetesResponseDto;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.mapper.PaqueteDtoMapper;

/**
 * Controlador REST para operaciones de paquetes electorales.
 * POJO sin anotaciones de framework - representa los endpoints definidos en la especificación.
 * 
 * Endpoints:
 * - GET /api/v1/electoral/paquetes/MsDominioPaquetes
 * - PUT /api/v1/electoral/paquetes/MsDominioPaquetes/{paqueteId}/aprobar
 * - PUT /api/v1/electoral/paquetes/MsDominioPaquetes/padron/{idPadron}/confirmar-revision
 */
public class PaqueteController {

    private final ConsultarPaquetesUseCase consultarPaquetesUseCase;
    private final AprobarPaqueteUseCase aprobarPaqueteUseCase;
    private final ConfirmarRevisionPaquetesUseCase confirmarRevisionPaquetesUseCase;
    private final PaqueteDtoMapper mapper;

    public PaqueteController(ConsultarPaquetesUseCase consultarPaquetesUseCase,
                            AprobarPaqueteUseCase aprobarPaqueteUseCase,
                            ConfirmarRevisionPaquetesUseCase confirmarRevisionPaquetesUseCase,
                            PaqueteDtoMapper mapper) {
        this.consultarPaquetesUseCase = consultarPaquetesUseCase;
        this.aprobarPaqueteUseCase = aprobarPaqueteUseCase;
        this.confirmarRevisionPaquetesUseCase = confirmarRevisionPaquetesUseCase;
        this.mapper = mapper;
    }

    /**
     * GET /api/v1/electoral/paquetes/MsDominioPaquetes
     * Consulta paquetes electorales con filtros opcionales.
     */
    public ConsultaPaquetesResponseDto consultarPaquetes(String idPadron, String tipoPadron,
                                                         String codigoDepartamento, String codigoProvincia,
                                                         String codigoDistrito, String estadoPaquete,
                                                         int pagina, int registrosPorPagina) {
        ConsultaPaquetesResult result = consultarPaquetesUseCase.consultar(
            idPadron, tipoPadron, codigoDepartamento, codigoProvincia,
            codigoDistrito, estadoPaquete, pagina, registrosPorPagina
        );
        
        return mapper.toConsultaPaquetesResponseDto(result);
    }

    /**
     * PUT /api/v1/electoral/paquetes/MsDominioPaquetes/{paqueteId}/aprobar
     * Aprueba un paquete electoral específico.
     */
    public AprobarPaqueteResponseDto aprobarPaquete(String paqueteId, AprobarPaqueteRequestDto request) {
        AprobacionResult result = aprobarPaqueteUseCase.aprobar(
            paqueteId,
            mapper.toInformacionPublicacion(request.informacionPublicacion()),
            request.comentarioAprobacion(),
            request.confirmarIntegridad()
        );
        
        return mapper.toAprobarPaqueteResponseDto(result);
    }

    /**
     * PUT /api/v1/electoral/paquetes/MsDominioPaquetes/padron/{idPadron}/confirmar-revision
     * Confirma la revisión completa de todos los paquetes de un padrón.
     */
    public ConfirmarRevisionResponseDto confirmarRevision(String idPadron, ConfirmarRevisionRequestDto request) {
        ConfirmacionRevisionResult result = confirmarRevisionPaquetesUseCase.confirmarRevision(
            idPadron,
            request.tipoPadron(),
            request.comentarioConfirmacion(),
            request.confirmarRevisionCompleta()
        );
        
        return mapper.toConfirmarRevisionResponseDto(result);
    }
}
