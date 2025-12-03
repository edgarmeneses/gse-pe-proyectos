package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.EjecutarCotejoUseCase;
import pe.gob.reniec.cotejo.masivo.domain.ports.in.ObtenerResultadosUseCase;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CotejoDtoMapper {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public EjecutarCotejoUseCase.SolicitudCotejo toSolicitudCotejo(EjecutarCotejoRequestDto request) {
        EjecutarCotejoUseCase.SolicitudCotejo solicitud = new EjecutarCotejoUseCase.SolicitudCotejo();
        solicitud.setSolicitudId(request.getSolicitudId());
        solicitud.setCodigoOrganizacion(request.getCodigoOrganizacion());
        solicitud.setNombreOrganizacion(request.getNombreOrganizacion());
        solicitud.setCodigoEnvio(request.getCodigoEnvio());
        solicitud.setNumeroLote(request.getNumeroLote());
        solicitud.setDocumentoSustento(request.getDocumentoSustento());
        solicitud.setObservaciones(request.getObservaciones());
        solicitud.setIndicadorDomicilio(request.getIndicadorDomicilio());
        solicitud.setCodigoPrograma(request.getCodigoPrograma());
        solicitud.setUsuarioCreacion("SYSTEM");
        
        if (request.getRegistros() != null) {
            List<RegistroEntrada> registros = request.getRegistros().stream()
                .map(this::toRegistroEntrada)
                .collect(Collectors.toList());
            solicitud.setRegistros(registros);
        }
        
        return solicitud;
    }

    public RegistroEntrada toRegistroEntrada(RegistroEntradaDto dto) {
        RegistroEntrada registro = new RegistroEntrada();
        registro.setNumeroSecuencia(dto.getNumeroSecuencia());
        registro.setNumeroDni(dto.getNumeroDni());
        registro.setApellidoPaterno(dto.getApellidoPaterno());
        registro.setApellidoMaterno(dto.getApellidoMaterno());
        registro.setNombres(dto.getNombres());
        if (dto.getFechaNacimiento() != null) {
            registro.setFechaNacimiento(LocalDateTime.parse(dto.getFechaNacimiento(), DATE_TIME_FORMATTER));
        }
        registro.setIndicadorSexo(dto.getIndicadorSexo());
        registro.setIdentificadorInstitucion(dto.getIdentificadorInstitucion());
        registro.setDatosAdicionales(dto.getDatosAdicionales());
        return registro;
    }

    public EjecutarCotejoResponseDto toEjecutarCotejoResponseDto(EjecutarCotejoUseCase.ResultadoEjecucionCotejo resultado) {
        EjecutarCotejoResponseDto response = new EjecutarCotejoResponseDto();
        response.setSuccess(true);
        
        EjecutarCotejoResponseDto.EjecucionDataDto dataDto = new EjecutarCotejoResponseDto.EjecucionDataDto();
        dataDto.setEjecucionId(resultado.getEjecucionId());
        dataDto.setEstadoProceso(resultado.getEstadoProceso());
        dataDto.setMensajeProceso(resultado.getMensajeProceso());
        
        if (resultado.getEjecucion() != null) {
            Ejecucion ejecucion = resultado.getEjecucion();
            dataDto.setCodigoEstado(ejecucion.getCodigoEstado());
            dataDto.setDescripcionEstado(ejecucion.getDescripcionEstado());
            dataDto.setTotalRegistrosEntrada(ejecucion.getTotalRegistrosEntrada());
            if (ejecucion.getFechaCreacion() != null) {
                dataDto.setFechaCreacion(ejecucion.getFechaCreacion().format(DATE_TIME_FORMATTER));
            }
        }
        
        response.setData(dataDto);
        response.setMetadata(createMetadata());
        
        return response;
    }

    public ConsultarEstadoResponseDto toConsultarEstadoResponseDto(Ejecucion ejecucion) {
        ConsultarEstadoResponseDto response = new ConsultarEstadoResponseDto();
        response.setSuccess(true);
        
        ConsultarEstadoResponseDto.EstadoEjecucionDto estadoDto = new ConsultarEstadoResponseDto.EstadoEjecucionDto();
        estadoDto.setEjecucionId(ejecucion.getEjecucionId());
        estadoDto.setCodigoEstado(ejecucion.getCodigoEstado());
        estadoDto.setDescripcionEstado(ejecucion.getDescripcionEstado());
        estadoDto.setTotalRegistrosEntrada(ejecucion.getTotalRegistrosEntrada());
        estadoDto.setTotalRegistrosProcesados(ejecucion.getTotalRegistrosProcesados());
        estadoDto.setTotalRegistrosCorrectos(ejecucion.getTotalRegistrosCorrectos());
        estadoDto.setTotalRegistrosIncorrectos(ejecucion.getTotalRegistrosIncorrectos());
        
        if (ejecucion.getFechaInicioProceso() != null) {
            estadoDto.setFechaInicioProceso(ejecucion.getFechaInicioProceso().format(DATE_TIME_FORMATTER));
        }
        if (ejecucion.getFechaFinProceso() != null) {
            estadoDto.setFechaFinProceso(ejecucion.getFechaFinProceso().format(DATE_TIME_FORMATTER));
        }
        
        if (ejecucion.getResumenResultados() != null) {
            ConsultarEstadoResponseDto.ResumenResultadosDto resumenDto = new ConsultarEstadoResponseDto.ResumenResultadosDto();
            resumenDto.setTotalCorrectos(ejecucion.getResumenResultados().getTotalCorrectos());
            resumenDto.setTotalDniNoExiste(ejecucion.getResumenResultados().getTotalDniNoExiste());
            resumenDto.setTotalDatosNoCoinciden(ejecucion.getResumenResultados().getTotalDatosNoCoinciden());
            resumenDto.setTotalErrores(ejecucion.getResumenResultados().getTotalErrores());
            resumenDto.setPorcentajeExito(ejecucion.getResumenResultados().getPorcentajeExito());
            estadoDto.setResumenResultados(resumenDto);
        }
        
        response.setData(estadoDto);
        response.setMetadata(createMetadata());
        
        return response;
    }

    public ObtenerResultadosResponseDto toObtenerResultadosResponseDto(ObtenerResultadosUseCase.ResultadoPaginado resultado) {
        ObtenerResultadosResponseDto response = new ObtenerResultadosResponseDto();
        response.setSuccess(true);
        
        ObtenerResultadosResponseDto.ResultadosDataDto dataDto = new ObtenerResultadosResponseDto.ResultadosDataDto();
        
        if (resultado.getResultados() != null) {
            List<ObtenerResultadosResponseDto.ResultadoCotejoDto> resultadosDto = resultado.getResultados().stream()
                .map(this::toResultadoCotejoDto)
                .collect(Collectors.toList());
            dataDto.setResultados(resultadosDto);
        }
        
        ObtenerResultadosResponseDto.PaginacionDto paginacionDto = new ObtenerResultadosResponseDto.PaginacionDto();
        paginacionDto.setPaginaActual(resultado.getPaginaActual());
        paginacionDto.setElementosPorPagina(resultado.getElementosPorPagina());
        paginacionDto.setTotalElementos(resultado.getTotalElementos());
        paginacionDto.setTotalPaginas(resultado.getTotalPaginas());
        dataDto.setPaginacion(paginacionDto);
        
        response.setData(dataDto);
        response.setMetadata(createMetadata());
        
        return response;
    }

    private ObtenerResultadosResponseDto.ResultadoCotejoDto toResultadoCotejoDto(ResultadoCotejo resultado) {
        ObtenerResultadosResponseDto.ResultadoCotejoDto dto = new ObtenerResultadosResponseDto.ResultadoCotejoDto();
        dto.setResultadoId(resultado.getResultadoId());
        dto.setRegistroEntradaId(resultado.getRegistroEntradaId());
        dto.setCodigoResultado(resultado.getCodigoResultado());
        dto.setNumeroDni(resultado.getNumeroDniEncontrado());
        dto.setApellidoPaterno(resultado.getApellidoPaternoEncontrado());
        dto.setApellidoMaterno(resultado.getApellidoMaternoEncontrado());
        dto.setNombres(resultado.getNombresEncontrado());
        dto.setCoincideDni(resultado.getCoincideDni());
        dto.setCoincideApellidoPaterno(resultado.getCoincideApellidoPaterno());
        dto.setCoincideApellidoMaterno(resultado.getCoincideApellidoMaterno());
        dto.setCoincideNombres(resultado.getCoincideNombres());
        dto.setMensajeObservacion(resultado.getMensajeObservacion());
        return dto;
    }

    private MetadataDto createMetadata() {
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        metadata.setCorrelationId(java.util.UUID.randomUUID().toString());
        metadata.setVersion("1.0");
        return metadata;
    }
}
