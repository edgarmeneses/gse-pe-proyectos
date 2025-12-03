package pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.siirc.msdatosgrafos.domain.model.*;
import pe.gob.reniec.siirc.msdatosgrafos.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper que convierte entre el modelo de dominio y los DTOs de la capa REST.
 * La paginación y el resumen se calculan aquí en la capa de infraestructura.
 */
public class VinculoParentescoDtoMapper {
    
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    /**
     * Convierte un GrafoParentesco del dominio a un ResponseDto con paginación aplicada.
     */
    public VinculosParentescoResponseDto toResponseDto(GrafoParentesco grafo, 
                                                       Integer pagina, 
                                                       Integer registrosPorPagina) {
        // Aplicar paginación a nivel de infraestructura
        List<VinculoParentesco> vinculosPaginados = aplicarPaginacion(
            grafo.getVinculos(), 
            pagina, 
            registrosPorPagina
        );
        
        // Calcular datos de paginación
        PaginacionDto paginacionDto = calcularPaginacion(
            grafo.getVinculos().size(), 
            pagina, 
            registrosPorPagina
        );
        
        // Calcular resumen estadístico
        ResumenVinculosDto resumenDto = calcularResumen(grafo);
        
        VinculosParentescoDataDto data = new VinculosParentescoDataDto(
            toCiudadanoDto(grafo.getCiudadano()),
            toVinculoDtoList(vinculosPaginados),
            resumenDto,
            paginacionDto
        );
        
        MetadataDto metadata = new MetadataDto(
            LocalDateTime.now().format(ISO_FORMATTER),
            generateCorrelationId(),
            "v1",
            "0ms"
        );
        
        return new VinculosParentescoResponseDto(true, data, metadata);
    }

    private List<VinculoParentesco> aplicarPaginacion(List<VinculoParentesco> vinculos, 
                                                       Integer pagina, 
                                                       Integer registrosPorPagina) {
        if (pagina == null || registrosPorPagina == null || vinculos.isEmpty()) {
            return vinculos;
        }
        
        int inicio = (pagina - 1) * registrosPorPagina;
        int fin = Math.min(inicio + registrosPorPagina, vinculos.size());
        
        if (inicio >= vinculos.size()) {
            return List.of();
        }
        
        return vinculos.subList(inicio, fin);
    }

    private PaginacionDto calcularPaginacion(int totalRegistros, 
                                            Integer pagina, 
                                            Integer registrosPorPagina) {
        if (pagina == null) pagina = 1;
        if (registrosPorPagina == null) registrosPorPagina = totalRegistros > 0 ? totalRegistros : 10;
        
        int totalPaginas = (int) Math.ceil((double) totalRegistros / registrosPorPagina);
        
        return new PaginacionDto(
            pagina,
            registrosPorPagina,
            totalRegistros,
            totalPaginas,
            pagina > 1,
            pagina < totalPaginas
        );
    }

    private ResumenVinculosDto calcularResumen(GrafoParentesco grafo) {
        return new ResumenVinculosDto(
            grafo.getTotalVinculos(),
            grafo.contarVinculosPorCategoria(CategoriaParentesco.CONSANGUINEO),
            grafo.contarVinculosPorCategoria(CategoriaParentesco.AFINIDAD),
            grafo.contarVinculosVigentes(),
            grafo.getTotalVinculos() - grafo.contarVinculosVigentes()
        );
    }

    public CiudadanoDto toCiudadanoDto(Ciudadano ciudadano) {
        if (ciudadano == null) {
            return null;
        }
        
        String fechaNacimiento = ciudadano.getFechaNacimiento() != null 
            ? ciudadano.getFechaNacimiento().format(ISO_FORMATTER) 
            : null;
            
        return new CiudadanoDto(
            ciudadano.getIdCiudadano(),
            ciudadano.getNombre(),
            fechaNacimiento
        );
    }

    public List<VinculoDto> toVinculoDtoList(List<VinculoParentesco> vinculos) {
        if (vinculos == null) {
            return List.of();
        }
        
        return vinculos.stream()
            .map(this::toVinculoDto)
            .collect(Collectors.toList());
    }

    public VinculoDto toVinculoDto(VinculoParentesco vinculo) {
        if (vinculo == null) {
            return null;
        }
        
        return new VinculoDto(
            vinculo.getIdRelacion(),
            toTipoParentescoDto(vinculo.getTipoParentesco()),
            vinculo.getGradoParentesco(),
            vinculo.getCategoriaParentesco() != null ? vinculo.getCategoriaParentesco().name() : null,
            toCiudadanoDto(vinculo.getCiudadanoRelacionado()),
            toVigenciaDto(vinculo.getVigencia()),
            toSustentoDto(vinculo.getSustento()),
            vinculo.getObservacion()
        );
    }

    public TipoParentescoDto toTipoParentescoDto(TipoParentesco tipoParentesco) {
        if (tipoParentesco == null) {
            return null;
        }
        
        return new TipoParentescoDto(
            tipoParentesco.getCodigo(),
            tipoParentesco.getDescripcion(),
            tipoParentesco.getEsSimetrico()
        );
    }

    public VigenciaDto toVigenciaDto(Vigencia vigencia) {
        if (vigencia == null) {
            return null;
        }
        
        String fechaInicio = vigencia.getFechaInicio() != null 
            ? vigencia.getFechaInicio().format(ISO_FORMATTER) 
            : null;
            
        String fechaFin = vigencia.getFechaFin() != null 
            ? vigencia.getFechaFin().format(ISO_FORMATTER) 
            : null;
        
        return new VigenciaDto(
            fechaInicio,
            fechaFin,
            vigencia.estaVigente()
        );
    }

    public SustentoDto toSustentoDto(Sustento sustento) {
        if (sustento == null) {
            return null;
        }
        
        return new SustentoDto(
            sustento.getIdActaSustento(),
            sustento.getIdDocumentoSustento()
        );
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
