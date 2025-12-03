package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.gse.registradores.application.query.InformacionPaginacion;
import pe.gob.reniec.gse.registradores.application.query.RegistradoresPaginados;
import pe.gob.reniec.gse.registradores.domain.model.*;
import pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper: RegistradorDtoMapper
 * Convierte entre objetos del dominio y DTOs.
 * 
 * NOTA: Este mapper hace lo mejor posible para adaptarse al modelo de dominio refactorizado.
 * Algunos campos pueden estar null porque el dominio ya no tiene las mismas estructuras.
 */
public class RegistradorDtoMapper {
    
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    private static final String BASE_URL = "/api/v1/registradores/MsDatosRegistradores";
    
    /**
     * Convierte un DTO de solicitud a una entidad de dominio Registrador.
     * Usa el factory method del dominio.
     */
    public static Registrador toRegistradorDomain(CrearRegistradorRequestDto dto) {
        // TODO: El dominio refactorizado usa factory methods. 
        // Necesitaría ajustarse según la lógica de negocio real
        EstadoRegistrador estado = EstadoRegistrador.ACTIVO;
        
        /*return Registrador.crear(
            dto.getNumeroDni(),
            dto.getPrimerApellido(),
            dto.getSegundoApellido(),
            dto.getPrenombres(),
            dto.getCodigoLocal(),
            estado
        );*/
        return null;
    }
    
    /**
     * Convierte un Registrador del dominio a un DTO de respuesta.
     */
    public static RegistradorResponseDto toRegistradorResponseDto(Registrador registrador) {
        String nombreCompleto = construirNombreCompleto(
            registrador.getPrimerApellido(), 
            registrador.getSegundoApellido(), 
            registrador.getPrenombres()
        );
        
        return new RegistradorResponseDto(
            registrador.getIdRegistrador(),
            registrador.getNumeroDni(),
            nombreCompleto,
            registrador.getCodigoLocal(),
            null, // descripcionLocal - ya no disponible en dominio
            registrador.getEstado() != null ? registrador.getEstado().getCodigo() : null,
            registrador.getEstado() != null ? registrador.getEstado().getDescripcion() : null,
            formatDateTime(registrador.getFechaCreacion()),
            registrador.getUsuarioCreacion(),
            createLinks(registrador.getIdRegistrador())
        );
    }
    
    /**
     * Convierte un Registrador del dominio a un DTO de listado.
     */
    public static RegistradorListadoDto toRegistradorListadoDto(Registrador registrador) {
        String nombreCompleto = construirNombreCompleto(
            registrador.getPrimerApellido(), 
            registrador.getSegundoApellido(), 
            registrador.getPrenombres()
        );
        
        return new RegistradorListadoDto(
            registrador.getIdRegistrador(),
            registrador.getNumeroDni(),
            nombreCompleto,
            registrador.getPrimerApellido(),
            registrador.getSegundoApellido(),
            registrador.getPrenombres(),
            registrador.getCodigoLocal(),
            null, // descripcionLocal - ya no disponible
            registrador.getEstado() != null ? registrador.getEstado().getCodigo() : null,
            registrador.getEstado() != null ? registrador.getEstado().getDescripcion() : null,
            registrador.getFirma() != null && registrador.getFirma().estaRegistrada(),
            registrador.getSello() != null && registrador.getSello().estaRegistrado(),
            formatDateTime(registrador.getFechaCreacion()),
            createLinks(registrador.getIdRegistrador())
        );
    }
    
    /**
     * Convierte un Registrador del dominio a un DTO de detalle completo.
     */
    public static RegistradorDetalleResponseDto toRegistradorDetalleDto(Registrador registrador) {
        String nombreCompleto = construirNombreCompleto(
            registrador.getPrimerApellido(), 
            registrador.getSegundoApellido(), 
            registrador.getPrenombres()
        );
        
        return new RegistradorDetalleResponseDto(
            registrador.getIdRegistrador(),
            registrador.getNumeroDni(),
            registrador.getPrimerApellido(),
            registrador.getSegundoApellido(),
            registrador.getPrenombres(),
            nombreCompleto,
            registrador.getNumeroImagen(),
            toAsignacionActualDto(registrador),
            toFirmaDto(registrador.getFirma()),
            toSelloDto(registrador.getSello()),
            toPeriodosDto(null), // periodos - necesita ajuste según modelo
            toAuditoriaDto(registrador),
            createLinksDetalle(registrador.getIdRegistrador())
        );
    }
    
    /**
     * Convierte RegistradoresPaginados del dominio a DTO de lista.
     */
    public static ListaRegistradoresResponseDto toListaRegistradoresDto(RegistradoresPaginados resultado) {
        List<RegistradorListadoDto> registradoresDto = resultado.getRegistradores()
            .stream()
            .map(RegistradorDtoMapper::toRegistradorListadoDto)
            .collect(Collectors.toList());
        
        return new ListaRegistradoresResponseDto(
            registradoresDto,
            toPaginacionDto(resultado.getPaginacion())
        );
    }
    
    // Métodos auxiliares privados
    
    private static AsignacionActualDto toAsignacionActualDto(Registrador registrador) {
        // Construir desde el Registrador ya que AsignacionActual fue eliminada
        if (registrador == null) return null;
        
        // TODO: El modelo de dominio refactorizado no expone getPeriodos() públicamente
        // Buscar el periodo activo - requiere ajuste en el modelo de dominio
        // Periodo periodoActivo = null;
        // if (registrador.getPeriodos() != null) {
        //     periodoActivo = registrador.getPeriodos().stream()
        //         .filter(p -> p.estaActivo())
        //         .findFirst()
        //         .orElse(null);
        // }
        
        return new AsignacionActualDto(
            registrador.getCodigoLocal(),
            null, // descripcionLocal - no disponible
            registrador.getEstado() != null ? registrador.getEstado().getCodigo() : null,
            registrador.getEstado() != null ? registrador.getEstado().getDescripcion() : null,
            formatDateTime(registrador.getFechaCreacion()) // usar fechaCreacion como alternativa
        );
    }
    
    private static FirmaDto toFirmaDto(Firma firma) {
        if (firma == null) return null;
        return new FirmaDto(
            firma.estaRegistrada(),
            firma.getHashFirma(),
            formatDateTime(firma.getFechaRegistro())
        );
    }
    
    private static SelloDto toSelloDto(Sello sello) {
        if (sello == null) return null;
        return new SelloDto(
            sello.estaRegistrado(),
            sello.getHashSello(),
            formatDateTime(sello.getFechaRegistro())
        );
    }
    
    private static List<PeriodoDto> toPeriodosDto(List<Periodo> periodos) {
        if (periodos == null) return new ArrayList<>();
        return periodos.stream()
            .map(periodo -> new PeriodoDto(
                periodo.getIdPeriodo(),
                null, // codigoLocal - ya no está en Periodo
                null, // descripcionLocal - ya no está en Periodo
                formatDateTime(periodo.getFechaInicio()),
                formatDateTime(periodo.getFechaFin()),
                periodo.getEstado() != null ? periodo.getEstado().getCodigo() : null
            ))
            .collect(Collectors.toList());
    }
    
    private static AuditoriaDto toAuditoriaDto(Registrador registrador) {
        if (registrador == null) return null;
        // Construir desde los campos de auditoría del Registrador
        return new AuditoriaDto(
            registrador.getUsuarioCreacion(),
            formatDateTime(registrador.getFechaCreacion()),
            registrador.getUsuarioModificacion(),
            formatDateTime(registrador.getFechaModificacion())
        );
    }
    
    private static PaginacionDto toPaginacionDto(InformacionPaginacion paginacion) {
        if (paginacion == null) return null;
        return new PaginacionDto(
            paginacion.getTotalRegistros(),
            paginacion.getTotalPaginas(),
            paginacion.getPaginaActual(),
            paginacion.getRegistrosPorPagina(),
            paginacion.getTieneAnterior(),
            paginacion.getTieneSiguiente()
        );
    }
    
    private static LinksDto createLinks(String idRegistrador) {
        return new LinksDto(
            BASE_URL + "/" + idRegistrador,
            BASE_URL + "/" + idRegistrador + "/firmas",
            BASE_URL + "/" + idRegistrador + "/sellos",
            BASE_URL + "/" + idRegistrador + "/periodos",
            BASE_URL + "/" + idRegistrador + "/asignaciones"
        );
    }
    
    private static LinksDetalleDto createLinksDetalle(String idRegistrador) {
        return new LinksDetalleDto(
            BASE_URL + "/" + idRegistrador,
            BASE_URL + "/" + idRegistrador + "/firmas",
            BASE_URL + "/" + idRegistrador + "/sellos",
            BASE_URL + "/" + idRegistrador + "/periodos",
            BASE_URL + "/" + idRegistrador + "/asignaciones",
            BASE_URL + "/" + idRegistrador + "/historial-firmas",
            BASE_URL + "/" + idRegistrador + "/historial-sellos"
        );
    }
    
    private static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(ISO_FORMATTER);
    }
    
    /**
     * Construye el nombre completo del registrador.
     */
    private static String construirNombreCompleto(String primerApellido, String segundoApellido, String prenombres) {
        StringBuilder sb = new StringBuilder();
        if (primerApellido != null) {
            sb.append(primerApellido);
        }
        if (segundoApellido != null && !segundoApellido.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(segundoApellido);
        }
        if (prenombres != null && !prenombres.isEmpty()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(prenombres);
        }
        return sb.toString();
    }
}
