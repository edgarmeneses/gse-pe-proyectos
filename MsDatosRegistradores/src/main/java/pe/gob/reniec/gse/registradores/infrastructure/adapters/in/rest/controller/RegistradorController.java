package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.registradores.application.query.BuscarRegistradoresCriteria;
import pe.gob.reniec.gse.registradores.application.query.RegistradoresPaginados;
import pe.gob.reniec.gse.registradores.domain.model.Registrador;
import pe.gob.reniec.gse.registradores.domain.ports.in.ConsultarRegistradorUseCase;
import pe.gob.reniec.gse.registradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.gse.registradores.domain.ports.in.ListarRegistradoresUseCase;
import pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.mapper.RegistradorDtoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller REST: RegistradorController
 * Expone los endpoints REST para la gestión de registradores.
 * 
 * NOTA: Esta clase no utiliza anotaciones de frameworks.
 * Los métodos representan las operaciones REST definidas en la especificación.
 */
public class RegistradorController {
    
    private final CrearRegistradorUseCase crearRegistradorUseCase;
    private final ListarRegistradoresUseCase listarRegistradoresUseCase;
    private final ConsultarRegistradorUseCase consultarRegistradorUseCase;
    
    private static final String API_VERSION = "v1.0";
    
    public RegistradorController(
            CrearRegistradorUseCase crearRegistradorUseCase,
            ListarRegistradoresUseCase listarRegistradoresUseCase,
            ConsultarRegistradorUseCase consultarRegistradorUseCase) {
        this.crearRegistradorUseCase = crearRegistradorUseCase;
        this.listarRegistradoresUseCase = listarRegistradoresUseCase;
        this.consultarRegistradorUseCase = consultarRegistradorUseCase;
    }
    
    /**
     * POST /api/v1/registradores/MsDatosRegistradores
     * Crea un nuevo registrador civil en el sistema.
     * 
     * Headers esperados:
     * - Authorization: Bearer token JWT
     * - Content-Type: application/json
     * - X-Correlation-ID: UUID
     * - X-Office-Code: String
     * - X-User-Role: String
     * - X-Idempotency-Key: UUID
     * 
     * @param request El DTO con los datos del registrador a crear
     * @param correlationId El ID de correlación para trazabilidad
     * @return ApiResponseDto con el registrador creado (HTTP 201)
     */
    public ApiResponseDto<RegistradorResponseDto> crearRegistrador(CrearRegistradorRequestDto request) {
        String correlationId = "";
        // Convertir DTO a entidad de dominio
        Registrador registrador = RegistradorDtoMapper.toRegistradorDomain(request);
        
        // Ejecutar caso de uso
        Registrador registradorCreado = crearRegistradorUseCase.crear(registrador);
        
        // Convertir resultado a DTO
        RegistradorResponseDto responseData = RegistradorDtoMapper.toRegistradorResponseDto(registradorCreado);
        
        // Construir metadata
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
            correlationId,
            API_VERSION
        );
        
        // Retornar respuesta
        return new ApiResponseDto<>(true, responseData, metadata);
    }
    
    /**
     * GET /api/v1/registradores/MsDatosRegistradores
     * Lista registradores con filtros opcionales y paginación.
     * 
     * Headers esperados:
     * - Authorization: Bearer token JWT
     * - X-Correlation-ID: UUID
     * - X-Office-Code: String
     * - X-User-Role: String
     * 
     * Query Parameters opcionales:
     * - codigoLocal: String
     * - estado: String
     * - numeroDni: String
     * - nombreRegistrador: String
     * - pagina: Integer
     * - registrosPorPagina: Integer
     * 
     * @return ApiResponseDto con la lista paginada de registradores (HTTP 200)
     */
    public ApiResponseDto<ListaRegistradoresResponseDto> listarRegistradores(
            String codigoLocal,
            String estado,
            String numeroDni,
            String nombreRegistrador,
            Long pagina,
            Long registrosPorPagina) {
        
        String correlationId   = "";
        
        // Construir criterios de búsqueda
        BuscarRegistradoresCriteria criteria = new BuscarRegistradoresCriteria(
            codigoLocal,
            estado,
            numeroDni,
            nombreRegistrador,
            pagina,
            registrosPorPagina
        );
        
        // Ejecutar caso de uso
        RegistradoresPaginados resultado = listarRegistradoresUseCase.listar(criteria);
        
        // Convertir resultado a DTO
        ListaRegistradoresResponseDto responseData = RegistradorDtoMapper.toListaRegistradoresDto(resultado);
        
        // Construir metadata
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
            correlationId,
            API_VERSION
        );
        
        // Retornar respuesta
        return new ApiResponseDto<>(true, responseData, metadata);
    }
    
    /**
     * GET /api/v1/registradores/MsDatosRegistradores/{idRegistrador}
     * Consulta la información detallada de un registrador específico.
     * 
     * Headers esperados:
     * - Authorization: Bearer token JWT
     * - X-Correlation-ID: UUID
     * - X-Office-Code: String
     * 
     * @param idRegistrador El identificador único del registrador
     * @param correlationId El ID de correlación para trazabilidad
     * @return ApiResponseDto con el detalle completo del registrador (HTTP 200)
     */
    public ApiResponseDto<RegistradorDetalleResponseDto> consultarRegistrador(
            String idRegistrador) {
        
        String correlationId = "";
        // Ejecutar caso de uso
        Registrador registrador = consultarRegistradorUseCase.consultarPorId(idRegistrador);
        
        // Convertir resultado a DTO
        RegistradorDetalleResponseDto responseData = RegistradorDtoMapper.toRegistradorDetalleDto(registrador);
        
        // Construir metadata
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
            correlationId,
            API_VERSION
        );
        
        // Retornar respuesta
        return new ApiResponseDto<>(true, responseData, metadata);
    }
}
