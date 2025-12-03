package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class EjecucionDtoMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public Ejecucion toDomain(CrearEjecucionRequestDto dto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public EjecucionResponseDto toResponseDto(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public RegistroEntrada toDomain(RegistrarRegistrosRequestDto.RegistroDto dto, String ejecucionId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public RegistrarRegistrosResponseDto toResponseDto(String ejecucionId, List<RegistroEntrada> insertados, 
                                                       List<RegistroEntrada> rechazados) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public ResultadoCotejo toDomain(RegistrarResultadosRequestDto.ResultadoDto dto, String ejecucionId) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public RegistrarResultadosResponseDto toResultadosResponseDto(String ejecucionId, 
                                                                  List<ResultadoCotejo> insertados,
                                                                  List<ResultadoCotejo> rechazados) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public ListarEjecucionesResponseDto toListaResponseDto(List<Ejecucion> ejecuciones) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public ConsultarEjecucionResponseDto toDetalleResponseDto(Ejecucion ejecucion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    private String formatDateTime(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(FORMATTER) : null;
    }

    private LocalDateTime parseDateTime(String dateTimeStr) {
        return dateTimeStr != null ? LocalDateTime.parse(dateTimeStr, FORMATTER) : null;
    }
}
