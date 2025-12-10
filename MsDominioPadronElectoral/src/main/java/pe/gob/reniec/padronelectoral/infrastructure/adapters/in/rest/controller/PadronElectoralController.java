package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.model.PaginatedResult;
import pe.gob.reniec.padronelectoral.domain.ports.in.ActualizarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.in.ConsultarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.in.GenerarPadronElectoralUseCase;
import pe.gob.reniec.padronelectoral.domain.ports.in.ListarPadronesElectoralesUseCase;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.ActualizarPadronElectoralRequestDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.ConsultarPadronResponseDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.GenerarPadronElectoralRequestDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.ListarPadronesResponseDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.PadronElectoralResponseDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.mapper.PadronElectoralDtoMapper;

/**
 * Controlador REST para el microservicio MsDominioPadronElectoral.
 * Expone los endpoints para la gestión del padrón electoral.
 * Sin anotaciones de framework (arquitectura neutral).
 */
public class PadronElectoralController {

    private final GenerarPadronElectoralUseCase generarPadronElectoralUseCase;
    private final ActualizarPadronElectoralUseCase actualizarPadronElectoralUseCase;
    private final ConsultarPadronElectoralUseCase consultarPadronElectoralUseCase;
    private final ListarPadronesElectoralesUseCase listarPadronesElectoralesUseCase;
    private final PadronElectoralDtoMapper mapper;

    public PadronElectoralController(
            GenerarPadronElectoralUseCase generarPadronElectoralUseCase,
            ActualizarPadronElectoralUseCase actualizarPadronElectoralUseCase,
            ConsultarPadronElectoralUseCase consultarPadronElectoralUseCase,
            ListarPadronesElectoralesUseCase listarPadronesElectoralesUseCase,
            PadronElectoralDtoMapper mapper) {
        this.generarPadronElectoralUseCase = generarPadronElectoralUseCase;
        this.actualizarPadronElectoralUseCase = actualizarPadronElectoralUseCase;
        this.consultarPadronElectoralUseCase = consultarPadronElectoralUseCase;
        this.listarPadronesElectoralesUseCase = listarPadronesElectoralesUseCase;
        this.mapper = mapper;
    }

    /**
     * POST /api/v1/electoral/MsDominioPadronElectoral
     * Genera un nuevo padrón electoral.
     * 
     * Headers: Authorization, X-Correlation-ID, X-Office-Code
     * Status: 201 Created, 400, 401, 403, 404, 409, 422, 429, 500, 502, 503
     */
    public PadronElectoralResponseDto generarPadronElectoral(GenerarPadronElectoralRequestDto request) {
        String departamento = request.getCircunscripcion().getEstructura().getDepartamento();
        String provincia = request.getCircunscripcion().getEstructura().getProvincia();
        String distrito = request.getCircunscripcion().getEstructura().getDistrito();

        PadronElectoral padron = generarPadronElectoralUseCase.generar(
                request.getTipoPadron(),
                departamento,
                provincia,
                distrito
        );

        return mapper.toResponseDto(padron);
    }

    /**
     * PUT /api/v1/electoral/MsDominioPadronElectoral/{id}
     * Actualiza un padrón electoral existente.
     * 
     * Headers: Authorization, X-Correlation-ID, X-Office-Code
     * Status: 200 OK, 400, 401, 403, 404, 422, 429, 500, 502, 503
     */
    public PadronElectoralResponseDto actualizarPadronElectoral(String id, ActualizarPadronElectoralRequestDto request) {
        PadronElectoral padron = actualizarPadronElectoralUseCase.actualizar(
                id,
                request.getUsuarioResponsableId(),
                request.getTipoPadron(),
                request.getInformeFinalVerificacionDomicilioId(),
                request.getTipoVerificacion()
        );

        return mapper.toResponseDto(padron);
    }

    /**
     * GET /api/v1/electoral/MsDominioPadronElectoral
     * Lista padrones electorales con filtros y paginación.
     * 
     * Query Params: texto, fecha, queryParam3, page, size
     * Headers: Authorization, X-Correlation-ID, X-Office-Code
     * Status: 200 OK, 400, 401, 403, 404, 429, 500, 502, 503
     */
    public ListarPadronesResponseDto listarPadronesElectorales(
            String texto, String fecha, String queryParam3, Integer page, Integer size) {
        PaginatedResult<PadronElectoral> resultado = listarPadronesElectoralesUseCase.listar(
                texto, fecha, queryParam3, page, size
        );

        return mapper.toListarResponseDto(resultado);
    }

    /**
     * GET /api/v1/electoral/MsDominioPadronElectoral/{id}
     * Consulta un padrón electoral específico por ID con paginación de ciudadanos.
     * 
     * Path Param: id
     * Query Params: page, size
     * Headers: Authorization, X-Correlation-ID, X-Office-Code
     * Status: 200 OK, 400, 401, 403, 404, 429, 500, 502, 503
     */
    public ConsultarPadronResponseDto consultarPadronElectoral(String id, Integer page, Integer size) {
        PadronElectoral padron = consultarPadronElectoralUseCase.consultarPorId(id, page, size);
        return mapper.toConsultarResponseDto(padron);
    }
}
