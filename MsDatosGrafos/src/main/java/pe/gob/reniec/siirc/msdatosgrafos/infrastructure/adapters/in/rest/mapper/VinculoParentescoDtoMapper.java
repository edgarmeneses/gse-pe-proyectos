package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.*;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre objetos de dominio y DTOs REST
 */
public class VinculoParentescoDtoMapper {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    public ConsultaVinculosResponseDto toResponseDto(ConsultaVinculosResult result, 
                                                     String correlationId, String version) {
        DataResponseDto data = new DataResponseDto(
            toCiudadanoDto(result.getCiudadanoConsultado()),
            toVinculosDto(result.getVinculos()),
            toResumenDto(result.getResumen()),
            toPaginacionDto(result.getPaginacion())
        );
        
        MetadataResponseDto metadata = new MetadataResponseDto(
            java.time.LocalDateTime.now().toString(),
            correlationId,
            version,
            "0ms"
        );
        
        return new ConsultaVinculosResponseDto(true, data, metadata);
    }
    
    private CiudadanoResponseDto toCiudadanoDto(Ciudadano ciudadano) {
        String fechaNacimiento = ciudadano.getFechaNacimiento() != null 
            ? ciudadano.getFechaNacimiento().format(DATE_FORMATTER) 
            : null;
        return new CiudadanoResponseDto(
            ciudadano.getIdCiudadano(),
            ciudadano.getNombre(),
            fechaNacimiento
        );
    }
    
    private List<VinculoParentescoResponseDto> toVinculosDto(List<VinculoParentesco> vinculos) {
        return vinculos.stream()
            .map(this::toVinculoDto)
            .collect(Collectors.toList());
    }
    
    private VinculoParentescoResponseDto toVinculoDto(VinculoParentesco vinculo) {
        return new VinculoParentescoResponseDto(
            vinculo.getIdRelacion(),
            toTipoParentescoDto(vinculo.getTipoParentesco()),
            vinculo.getGradoParentesco(),
            vinculo.getCategoriaParentesco(),
            toCiudadanoDto(vinculo.getCiudadanoRelacionado()),
            toVigenciaDto(vinculo.getVigencia()),
            toSustentoDto(vinculo.getSustento()),
            vinculo.getObservacion()
        );
    }
    
    private TipoParentescoResponseDto toTipoParentescoDto(TipoParentesco tipo) {
        return new TipoParentescoResponseDto(
            tipo.getCodigo(),
            tipo.getDescripcion(),
            tipo.getEsSimetrico()
        );
    }
    
    private VigenciaResponseDto toVigenciaDto(Vigencia vigencia) {
        String fechaInicio = vigencia.getFechaInicio() != null 
            ? vigencia.getFechaInicio().format(DATE_FORMATTER) 
            : null;
        String fechaFin = vigencia.getFechaFin() != null 
            ? vigencia.getFechaFin().format(DATE_FORMATTER) 
            : null;
        return new VigenciaResponseDto(
            fechaInicio,
            fechaFin,
            vigencia.getEsVigente()
        );
    }
    
    private SustentoResponseDto toSustentoDto(Sustento sustento) {
        if (sustento == null) {
            return null;
        }
        return new SustentoResponseDto(
            sustento.getIdActaSustento(),
            sustento.getIdDocumentoSustento()
        );
    }
    
    private ResumenResponseDto toResumenDto(Resumen resumen) {
        return new ResumenResponseDto(
            resumen.getTotalVinculos(),
            resumen.getVinculosConsanguineos(),
            resumen.getVinculosPorAfinidad(),
            resumen.getVinculosVigentes(),
            resumen.getVinculosNoVigentes()
        );
    }
    
    private PaginacionResponseDto toPaginacionDto(Paginacion paginacion) {
        return new PaginacionResponseDto(
            paginacion.getPaginaActual(),
            paginacion.getRegistrosPorPagina(),
            paginacion.getTotalRegistros(),
            paginacion.getTotalPaginas(),
            paginacion.getTieneAnterior(),
            paginacion.getTieneSiguiente()
        );
    }
    
    public ErrorResponseDto toErrorDto(String tipo, String titulo, Integer estado, List<String> errores) {
        List<DetalleErrorDto> detalles = errores.stream()
            .map(DetalleErrorDto::new)
            .collect(Collectors.toList());
        return new ErrorResponseDto(tipo, titulo, estado, detalles);
    }
}
