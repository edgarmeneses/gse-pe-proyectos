package pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.mapper;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.CriterioCotejo;
import pe.com.organizacion.cotejomasivo.domain.model.ResultadoCotejo;
import pe.com.organizacion.cotejomasivo.domain.model.ResultadosPaginados;
import pe.com.organizacion.cotejomasivo.infrastructure.adapters.in.rest.dto.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper: CotejoMasivoDtoMapper
 * Convierte entre objetos de dominio y DTOs
 */
public class CotejoMasivoDtoMapper {
    
    /**
     * Convierte una lista de CriterioCotejoDto a lista de CriterioCotejo del dominio
     */
    public List<CriterioCotejo> toDomainCriterioList(List<CriterioCotejoDto> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
            .map(this::toDomainCriterio)
            .collect(Collectors.toList());
    }
    
    /**
     * Convierte un CriterioCotejoDto a CriterioCotejo del dominio
     */
    public CriterioCotejo toDomainCriterio(CriterioCotejoDto dto) {
        if (dto == null) {
            return null;
        }
        return new CriterioCotejo(dto.campo(), dto.operador(), dto.valor());
    }
    
    /**
     * Convierte CotejoMasivo del dominio a EjecutarCotejoMasivoResponseDto
     */
    public EjecutarCotejoMasivoResponseDto toEjecutarResponseDto(CotejoMasivo cotejoMasivo, Long statusCode, String mensaje) {
        if (cotejoMasivo == null) {
            return null;
        }
        return new EjecutarCotejoMasivoResponseDto(
            cotejoMasivo.getIdEjecucion(),
            cotejoMasivo.getFechaSolicitud(),
            cotejoMasivo.getEstado(),
            statusCode,
            mensaje
        );
    }
    
    /**
     * Convierte CotejoMasivo del dominio a ConsultarCotejoMasivoResponseDto
     */
    public ConsultarCotejoMasivoResponseDto toConsultarResponseDto(CotejoMasivo cotejoMasivo, Long statusCode, String mensaje) {
        if (cotejoMasivo == null) {
            return null;
        }
        return new ConsultarCotejoMasivoResponseDto(
            cotejoMasivo.getIdEjecucion(),
            cotejoMasivo.getFechaSolicitud(),
            cotejoMasivo.getEstado(),
            cotejoMasivo.getTotalRegistros(),
            cotejoMasivo.getRegistrosProcesados(),
            cotejoMasivo.getRegistrosExitosos(),
            cotejoMasivo.getRegistrosConError(),
            cotejoMasivo.getFechaInicio(),
            cotejoMasivo.getFechaFin(),
            cotejoMasivo.getUsuarioSolicitante(),
            statusCode,
            mensaje
        );
    }
    
    /**
     * Convierte ResultadosPaginados del dominio a ObtenerResultadosCotejoMasivoResponseDto
     */
    public ObtenerResultadosCotejoMasivoResponseDto toObtenerResultadosResponseDto(
            ResultadosPaginados resultadosPaginados, Long statusCode, String mensaje) {
        if (resultadosPaginados == null) {
            return null;
        }
        List<ResultadoCotejoDto> resultadoDtos = resultadosPaginados.getResultados() != null
            ? resultadosPaginados.getResultados().stream()
                .map(this::toResultadoCotejoDto)
                .collect(Collectors.toList())
            : null;
            
        return new ObtenerResultadosCotejoMasivoResponseDto(
            resultadosPaginados.getIdEjecucion(),
            resultadosPaginados.getEstado(),
            resultadoDtos,
            resultadosPaginados.getPaginaActual(),
            resultadosPaginados.getTamanio(),
            resultadosPaginados.getTotalResultados(),
            resultadosPaginados.getTotalPaginas(),
            statusCode,
            mensaje
        );
    }
    
    /**
     * Convierte ResultadoCotejo del dominio a ResultadoCotejoDto
     */
    public ResultadoCotejoDto toResultadoCotejoDto(ResultadoCotejo resultado) {
        if (resultado == null) {
            return null;
        }
        return new ResultadoCotejoDto(
            resultado.getIdRegistro(),
            resultado.getEstadoCotejo(),
            resultado.getDetalles(),
            resultado.getFechaProcesamiento()
        );
    }
}
