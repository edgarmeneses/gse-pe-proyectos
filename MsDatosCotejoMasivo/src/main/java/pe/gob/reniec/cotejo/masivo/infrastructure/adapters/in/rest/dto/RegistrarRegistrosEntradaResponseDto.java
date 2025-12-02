package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.UUID;

public record RegistrarRegistrosEntradaResponseDto(
    UUID ejecucionId,
    Integer totalRegistrosRecibidos,
    Integer totalRegistrosInsertados,
    Integer totalRegistrosRechazados,
    List<RegistroInsertadoDto> registrosInsertados,
    List<RegistroRechazadoDto> registrosRechazados
) {}
